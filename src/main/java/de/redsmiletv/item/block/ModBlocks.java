package de.redsmiletv.item.block;

import de.redsmiletv.buildersfriend;
import de.redsmiletv.item.ModCreativeModeTab;
import de.redsmiletv.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, buildersfriend.MOD_ID);

    public static final RegistryObject<Block> CALCITE_BRICKS = registerBlock("calcite_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CALCITE)), ModCreativeModeTab.BUILDERSFRIEND);

    public static final RegistryObject<SlabBlock> CALCITE_SLAB = registerBlock("calcite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE)), ModCreativeModeTab.BUILDERSFRIEND);

    public static final RegistryObject<StairBlock> CALCITE_STAIRS = registerBlock("calcite_stairs",
            () -> new StairBlock(() -> Blocks.CALCITE.defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.CALCITE)), ModCreativeModeTab.BUILDERSFRIEND);

    public static final RegistryObject<WallBlock> CALCITE_WALL = registerBlock("calcite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE)), ModCreativeModeTab.BUILDERSFRIEND);



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }
    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                           CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
