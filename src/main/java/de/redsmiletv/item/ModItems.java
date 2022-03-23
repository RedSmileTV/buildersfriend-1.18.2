package de.redsmiletv.item;

import de.redsmiletv.buildersfriend;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, buildersfriend.MOD_ID);

    public static final RegistryObject<Item> IRON_HAMMER = ITEMS.register("iron_hammer",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BUILDERSFRIEND)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


}