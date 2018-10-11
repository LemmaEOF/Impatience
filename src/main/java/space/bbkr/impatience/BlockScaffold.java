package space.bbkr.impatience;


import net.minecraft.block.Block;
import net.minecraft.block.IBucketPickupHandler;
import net.minecraft.block.ILiquidContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.IFluidState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReaderBase;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.Random;

public class BlockScaffold extends Block implements IBucketPickupHandler, ILiquidContainer {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public BlockScaffold(Builder builder) {
        super(builder);
        this.setDefaultState(this.stateContainer.getBaseState().withProperty(WATERLOGGED, false));

    }

    @Override
    public VoxelShape getShape(IBlockState p_getShape_1_, IBlockReader p_getShape_2_, BlockPos p_getShape_3_) {
        return Block.makeCuboidShape(0.0,0.0,0.0,16.0,16.0,16.0);
    }

    @Override
    public VoxelShape getCollisionShape(IBlockState p_getCollisionShape_1_, IBlockReader p_getCollisionShape_2_, BlockPos p_getCollisionShape_3_) {
        return Block.makeCuboidShape(0.05, 0.0, 0.05, 15.95, 16.0, 15.95);
    }

    @Override
    public boolean isNormalCube(IBlockState p_isNormalCube_1_) {
        return false;
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public IBlockState updatePostPlacement(IBlockState state, EnumFacing facing, IBlockState newState, IWorld world, BlockPos pos, BlockPos posFrom) {
        if (!state.isValidPosition(world, pos) || isIsolated(world, pos)) {
            world.getPendingBlockTicks().scheduleUpdate(pos, this, 1);
            return super.updatePostPlacement(state, facing, newState, world, pos, posFrom);
        } else {
            if (state.getValue(WATERLOGGED)) {
                world.getPendingFluidTicks().scheduleUpdate(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
            }
        }

        return super.updatePostPlacement(state, facing, newState, world, pos, posFrom);
    }

    @Nullable
    public IBlockState getStateForPlacement(BlockItemUseContext ctx) {
        IBlockState state = this.getDefaultState();
        IFluidState fluid = ctx.getWorld().getFluidState(ctx.getPos());

        for(EnumFacing facing: EnumFacing.values()) {
            if (facing.getAxis().isHorizontal()) {
                return state.withProperty(WATERLOGGED, fluid.getFluid() == Fluids.WATER);
            }
        }

        return null;
    }

    public void tick(IBlockState state, World world, BlockPos pos, Random rand) {
        if (!state.isValidPosition(world, pos) || isIsolated(world, pos)) {
            world.destroyBlock(pos, true);
        }

    }

    public boolean isIsolated(IWorldReaderBase world, BlockPos pos) {
        for (EnumFacing facing: EnumFacing.values()) {
            if (facing != EnumFacing.UP) {
                if (!world.getBlockState(pos.offset(facing)).isAir()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidPosition(IBlockState state, IWorldReaderBase world, BlockPos pos) {
        BlockPos checkPos = pos.offset(EnumFacing.DOWN);
        BlockPos doubleCheckPos;
        IBlockState checkBlock = world.getBlockState(checkPos);
        IBlockState doubleCheckBlock;
        if (checkBlock.isSolid() || checkBlock.getBlock() == Impatience.SCAFFOLD) return true;
        for (EnumFacing facing: EnumFacing.values()) {
            if (facing.getAxis().isHorizontal()) {
                checkPos = pos.offset(EnumFacing.DOWN);
                doubleCheckPos = pos.offset(facing.getOpposite());
                for (int i = 0; i <= 2; i++) {
                    checkPos = checkPos.offset(facing);
                    doubleCheckPos = doubleCheckPos.offset(facing);
                    checkBlock = world.getBlockState(checkPos);
                    doubleCheckBlock = world.getBlockState(doubleCheckPos);
                    if (doubleCheckPos == pos) {
                        //contingency to prevent a false positive during checking
                        BlockPos tempPos = doubleCheckPos.offset(EnumFacing.UP);
                        doubleCheckBlock = world.getBlockState(tempPos);
                    }
                    if (checkBlock.getBlock() == Impatience.SCAFFOLD && (i == 0 || doubleCheckBlock.getBlock() == Impatience.SCAFFOLD)) return true;
                }
            }
        }
        return false;
    }

    protected void fillStateContainer(net.minecraft.state.StateContainer.Builder<Block, IBlockState> builder) {
        builder.add(WATERLOGGED);
    }

    public Fluid pickupFluid(IWorld world, BlockPos pos, IBlockState state) {
        if (state.getValue(WATERLOGGED)) {
            world.setBlockState(pos, state.withProperty(WATERLOGGED, false), 3);
            return Fluids.WATER;
        } else {
            return Fluids.EMPTY;
        }
    }

    public IFluidState getFluidState(IBlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }

    public boolean canContainFluid(IBlockReader reader, BlockPos pos, IBlockState state, Fluid fluid) {
        return !state.getValue(WATERLOGGED) && fluid == Fluids.WATER;
    }

    public boolean receiveFluid(IWorld world, BlockPos pos, IBlockState state, IFluidState fluid) {
        if (!state.getValue(WATERLOGGED) && fluid.getFluid() == Fluids.WATER) {
            if (!world.isRemote()) {
                world.setBlockState(pos, state.withProperty(WATERLOGGED, true), 3);
                world.getPendingFluidTicks().scheduleUpdate(pos, fluid.getFluid(), fluid.getFluid().getTickRate(world));
            }

            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onEntityCollision(IBlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof EntityItem) return;
        if (entity.collidedHorizontally) {
            entity.motionY = 0.35;
        } else if (entity.isSneaking()) {
            entity.motionY = 0.08; //Stop, but also counteract EntityLivingBase-applied microgravity
        } else if (entity.motionY<-0.20) {
            entity.motionY = -0.20;
        }
        entity.fallDistance = 0.0f;
    }

    @Override
    public void onBlockClicked(IBlockState state, World world, BlockPos pos, EntityPlayer player) {
        if (player.getHeldItemMainhand().getItem().equals(Impatience.SCAFFOLD.asItem())) {
            BlockPos placePos = pos;
            for (int i = 0; i < 32; i++) {
                placePos = placePos.offset(EnumFacing.UP);
                if (world.getBlockState(placePos).isAir()) {
                    world.setBlockState(placePos, this.getDefaultState());
                    if (!player.isCreative()) player.getHeldItemMainhand().shrink(1);
                    break;
                } else if (world.getBlockState(placePos).getBlock() != Impatience.SCAFFOLD) break;
            }
        }
    }
}
