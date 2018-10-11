package space.bbkr.impatience;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import org.dimdev.rift.listener.BlockAdder;
import org.dimdev.rift.listener.ItemAdder;

public class Impatience implements BlockAdder, ItemAdder {

    public static final BlockScaffold SCAFFOLD = new BlockScaffold(Block.Builder.create(Material.WOOD, MapColor.WOOD).hardnessAndResistance(2f, 2f).sound(SoundType.WOOD));

    @Override
    public void registerBlocks() {
        Block.register(new ResourceLocation("impatience:scaffold"), SCAFFOLD);
    }

    @Override
    public void registerItems() {
        Item.register(SCAFFOLD, ItemGroup.BUILDING_BLOCKS);
    }
}
