package space.bbkr.impatience;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import org.dimdev.rift.listener.BlockAdder;
import org.dimdev.rift.listener.ItemAdder;

public class Impatience implements BlockAdder, ItemAdder {

    public static final BlockScaffold SCAFFOLDING = new BlockScaffold(Block.Builder.create(Material.WOOD, MapColor.WOOD).hardnessAndResistance(2f, 2f).sound(SoundType.WOOD));
    public static final BlockImpatientStairs ANDESITE_STAIRS = new BlockImpatientStairs(Blocks.ANDESITE.getDefaultState(), Block.Builder.from(Blocks.ANDESITE));
    public static final BlockImpatientStairs DIORITE_STAIRS = new BlockImpatientStairs(Blocks.DIORITE.getDefaultState(), Block.Builder.from(Blocks.DIORITE));
    public static final BlockImpatientStairs GRANITE_STAIRS = new BlockImpatientStairs(Blocks.GRANITE.getDefaultState(), Block.Builder.from(Blocks.GRANITE));
    public static final BlockImpatientStairs END_STONE_BRICK_STAIRS = new BlockImpatientStairs(Blocks.END_STONE_BRICKS.getDefaultState(), Block.Builder.from(Blocks.END_STONE_BRICKS));
    public static final BlockImpatientStairs MOSSY_COBBLESTONE_STAIRS = new BlockImpatientStairs(Blocks.MOSSY_COBBLESTONE.getDefaultState(), Block.Builder.from(Blocks.MOSSY_COBBLESTONE));
    public static final BlockImpatientStairs MOSSY_STONE_BRICK_STAIRS = new BlockImpatientStairs(Blocks.MOSSY_STONE_BRICKS.getDefaultState(), Block.Builder.from(Blocks.MOSSY_STONE_BRICKS));
    public static final BlockImpatientStairs POLISHED_ANDESITE_STAIRS = new BlockImpatientStairs(Blocks.POLISHED_ANDESITE.getDefaultState(), Block.Builder.from(Blocks.POLISHED_ANDESITE));
    public static final BlockImpatientStairs POLISHED_DIORITE_STAIRS = new BlockImpatientStairs(Blocks.POLISHED_DIORITE.getDefaultState(), Block.Builder.from(Blocks.POLISHED_DIORITE));
    public static final BlockImpatientStairs POLISHED_GRANITE_STAIRS = new BlockImpatientStairs(Blocks.POLISHED_GRANITE.getDefaultState(), Block.Builder.from(Blocks.POLISHED_GRANITE));
    public static final BlockImpatientStairs RED_NETHER_BRICK_STAIRS = new BlockImpatientStairs(Blocks.RED_NETHER_BRICKS.getDefaultState(), Block.Builder.from(Blocks.RED_NETHER_BRICKS));
    public static final BlockImpatientStairs SMOOTH_SANDSTONE_STAIRS = new BlockImpatientStairs(Blocks.SMOOTH_SANDSTONE.getDefaultState(), Block.Builder.from(Blocks.SMOOTH_SANDSTONE));
    public static final BlockImpatientStairs SMOOTH_RED_SANDSTONE_STAIRS = new BlockImpatientStairs(Blocks.SMOOTH_RED_SANDSTONE.getDefaultState(), Block.Builder.from(Blocks.SMOOTH_RED_SANDSTONE));
    public static final BlockImpatientStairs SMOOTH_STONE_STAIRS = new BlockImpatientStairs(Blocks.SMOOTH_STONE.getDefaultState(), Block.Builder.from(Blocks.SMOOTH_STONE));
    public static final BlockImpatientStairs SMOOTH_QUARTZ_STAIRS = new BlockImpatientStairs(Blocks.SMOOTH_QUARTZ.getDefaultState(), Block.Builder.from(Blocks.SMOOTH_QUARTZ));
    public static final BlockImpatientStairs STONE_STAIRS = new BlockImpatientStairs(Blocks.STONE.getDefaultState(), Block.Builder.from(Blocks.STONE));
    public static final BlockSlab ANDESITE_SLAB = new BlockSlab(Block.Builder.create(Material.ROCK, MapColor.STONE).hardnessAndResistance(1.5F, 6.0F));
    public static final BlockSlab DIORITE_SLAB = new BlockSlab(Block.Builder.create(Material.ROCK, MapColor.QUARTZ).hardnessAndResistance(1.5F, 6.0F));
    public static final BlockSlab GRANITE_SLAB = new BlockSlab(Block.Builder.create(Material.ROCK, MapColor.DIRT).hardnessAndResistance(1.5F, 6.0F));
    public static final BlockSlab END_STONE_BRICK_SLAB = new BlockSlab(Block.Builder.create(Material.ROCK, MapColor.SAND).hardnessAndResistance(0.8F, 0.8F));
    public static final BlockSlab MOSSY_COBBLESTONE_SLAB = new BlockSlab(Block.Builder.create(Material.ROCK).hardnessAndResistance(2.0F, 6.0F));
    public static final BlockSlab MOSSY_STONE_BRICK_SLAB = new BlockSlab(Block.Builder.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F));
    public static final BlockSlab POLISHED_ANDESITE_SLAB = new BlockSlab(Block.Builder.create(Material.ROCK, MapColor.STONE).hardnessAndResistance(1.5F, 6.0F));
    public static final BlockSlab POLISHED_DIORITE_SLAB = new BlockSlab(Block.Builder.create(Material.ROCK, MapColor.QUARTZ).hardnessAndResistance(1.5F, 6.0F));
    public static final BlockSlab POLISHED_GRANITE_SLAB = new BlockSlab(Block.Builder.create(Material.ROCK, MapColor.DIRT).hardnessAndResistance(1.5F, 6.0F));
    public static final BlockSlab RED_NETHER_BRICK_SLAB = new BlockSlab(Block.Builder.create(Material.ROCK, MapColor.NETHERRACK).hardnessAndResistance(2.0F, 6.0F));
    public static final BlockSlab SMOOTH_SANDSTONE_SLAB = new BlockSlab(Block.Builder.create(Material.ROCK, MapColor.SAND).hardnessAndResistance(2.0F, 6.0F));
    public static final BlockSlab SMOOTH_RED_SANDSTONE_SLAB = new BlockSlab(Block.Builder.create(Material.ROCK, MapColor.ADOBE).hardnessAndResistance(2.0F, 6.0F));
    public static final BlockSlab SMOOTH_STONE_SLAB = new BlockSlab(Block.Builder.create(Material.ROCK, MapColor.ADOBE).hardnessAndResistance(2.0F, 6.0F));
    public static final BlockSlab SMOOTH_QUARTZ_SLAB = new BlockSlab(Block.Builder.create(Material.ROCK, MapColor.ADOBE).hardnessAndResistance(2.0F, 6.0F));

    @Override
    public void registerBlocks() {
        Block.register(new ResourceLocation("impatience:scaffolding"), SCAFFOLDING);
        Block.register(new ResourceLocation("impatience:andesite_stairs"), ANDESITE_STAIRS);
        Block.register(new ResourceLocation("impatience:diorite_stairs"), DIORITE_STAIRS);
        Block.register(new ResourceLocation("impatience:granite_stairs"), GRANITE_STAIRS);
        Block.register(new ResourceLocation("impatience:end_stone_brick_stairs"), END_STONE_BRICK_STAIRS);
        Block.register(new ResourceLocation("impatience:mossy_cobblestone_stairs"), MOSSY_COBBLESTONE_STAIRS);
        Block.register(new ResourceLocation("impatience:mossy_stone_brick_stairs"), MOSSY_STONE_BRICK_STAIRS);
        Block.register(new ResourceLocation("impatience:polished_andesite_stairs"), POLISHED_ANDESITE_STAIRS);
        Block.register(new ResourceLocation("impatience:polished_diorite_stairs"), POLISHED_DIORITE_STAIRS);
        Block.register(new ResourceLocation("impatience:polished_granite_stairs"), POLISHED_GRANITE_STAIRS);
        Block.register(new ResourceLocation("impatience:red_nether_brick_stairs"), RED_NETHER_BRICK_STAIRS);
        Block.register(new ResourceLocation("impatience:smooth_sandstone_stairs"), SMOOTH_SANDSTONE_STAIRS);
        Block.register(new ResourceLocation("impatience:smooth_red_sandstone_stairs"), SMOOTH_RED_SANDSTONE_STAIRS);
        Block.register(new ResourceLocation("impatience:smooth_stone_stairs"), SMOOTH_STONE_STAIRS);
        Block.register(new ResourceLocation("impatience:smooth_quartz_stairs"), SMOOTH_QUARTZ_STAIRS);
        Block.register(new ResourceLocation("impatience:stone_stairs"), STONE_STAIRS);
        Block.register(new ResourceLocation("impatience:andesite_slab"), ANDESITE_SLAB);
        Block.register(new ResourceLocation("impatience:diorite_slab"), DIORITE_SLAB);
        Block.register(new ResourceLocation("impatience:granite_slab"), GRANITE_SLAB);
        Block.register(new ResourceLocation("impatience:end_stone_brick_slab"), END_STONE_BRICK_SLAB);
        Block.register(new ResourceLocation("impatience:mossy_cobblestone_slab"), MOSSY_COBBLESTONE_SLAB);
        Block.register(new ResourceLocation("impatience:mossy_stone_brick_slab"), MOSSY_STONE_BRICK_SLAB);
        Block.register(new ResourceLocation("impatience:polished_andesite_slab"), POLISHED_ANDESITE_SLAB);
        Block.register(new ResourceLocation("impatience:polished_diorite_slab"), POLISHED_DIORITE_SLAB);
        Block.register(new ResourceLocation("impatience:polished_granite_slab"), POLISHED_GRANITE_SLAB);
        Block.register(new ResourceLocation("impatience:red_nether_brick_slab"), RED_NETHER_BRICK_SLAB);
        Block.register(new ResourceLocation("impatience:smooth_sandstone_slab"), SMOOTH_SANDSTONE_SLAB);
        Block.register(new ResourceLocation("impatience:smooth_red_sandstone_slab"), SMOOTH_RED_SANDSTONE_SLAB);
        Block.register(new ResourceLocation("impatience:smooth_stone_slab"), SMOOTH_STONE_SLAB);
        Block.register(new ResourceLocation("impatience:smooth_quartz_slab"), SMOOTH_QUARTZ_SLAB);
        // register granite walls
        // register andesite walls
        // register diorite walls
        // register mossy stone brick walls
        // register end stone brick walls
        // register smooth stone walls
        // register stone walls
        // register smooth quartz walls
        // register red nether brick walls
        // register brick walls
        // register prismarine walls
        // register sandstone walls
        // register red sandstone walls
        // register nether brick walls
        // register stone brick walls

    }

    @Override
    public void registerItems() {
        Item.register(SCAFFOLDING, ItemGroup.BUILDING_BLOCKS);
        Item.register(ANDESITE_STAIRS, ItemGroup.BUILDING_BLOCKS);
        Item.register(DIORITE_STAIRS, ItemGroup.BUILDING_BLOCKS);
        Item.register(GRANITE_STAIRS, ItemGroup.BUILDING_BLOCKS);
        Item.register(END_STONE_BRICK_STAIRS, ItemGroup.BUILDING_BLOCKS);
        Item.register(MOSSY_COBBLESTONE_STAIRS, ItemGroup.BUILDING_BLOCKS);
        Item.register(MOSSY_STONE_BRICK_STAIRS, ItemGroup.BUILDING_BLOCKS);
        Item.register(POLISHED_ANDESITE_STAIRS, ItemGroup.BUILDING_BLOCKS);
        Item.register(POLISHED_DIORITE_STAIRS, ItemGroup.BUILDING_BLOCKS);
        Item.register(POLISHED_GRANITE_STAIRS, ItemGroup.BUILDING_BLOCKS);
        Item.register(RED_NETHER_BRICK_STAIRS, ItemGroup.BUILDING_BLOCKS);
        Item.register(SMOOTH_SANDSTONE_STAIRS, ItemGroup.BUILDING_BLOCKS);
        Item.register(SMOOTH_RED_SANDSTONE_STAIRS, ItemGroup.BUILDING_BLOCKS);
        Item.register(SMOOTH_STONE_STAIRS, ItemGroup.BUILDING_BLOCKS);
        Item.register(SMOOTH_QUARTZ_STAIRS, ItemGroup.BUILDING_BLOCKS);
        Item.register(STONE_STAIRS, ItemGroup.BUILDING_BLOCKS);
        Item.register(ANDESITE_SLAB, ItemGroup.BUILDING_BLOCKS);
        Item.register(DIORITE_SLAB, ItemGroup.BUILDING_BLOCKS);
        Item.register(GRANITE_SLAB, ItemGroup.BUILDING_BLOCKS);
        Item.register(END_STONE_BRICK_SLAB, ItemGroup.BUILDING_BLOCKS);
        Item.register(MOSSY_COBBLESTONE_SLAB, ItemGroup.BUILDING_BLOCKS);
        Item.register(MOSSY_STONE_BRICK_SLAB, ItemGroup.BUILDING_BLOCKS);
        Item.register(POLISHED_ANDESITE_SLAB, ItemGroup.BUILDING_BLOCKS);
        Item.register(POLISHED_DIORITE_SLAB, ItemGroup.BUILDING_BLOCKS);
        Item.register(POLISHED_GRANITE_SLAB, ItemGroup.BUILDING_BLOCKS);
        Item.register(RED_NETHER_BRICK_SLAB, ItemGroup.BUILDING_BLOCKS);
        Item.register(SMOOTH_SANDSTONE_SLAB, ItemGroup.BUILDING_BLOCKS);
        Item.register(SMOOTH_RED_SANDSTONE_SLAB, ItemGroup.BUILDING_BLOCKS);
        Item.register(SMOOTH_STONE_SLAB, ItemGroup.BUILDING_BLOCKS);
        Item.register(SMOOTH_QUARTZ_SLAB, ItemGroup.BUILDING_BLOCKS);
    }
}
