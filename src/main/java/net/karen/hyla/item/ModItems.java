package net.karen.hyla.item;

import net.karen.hyla.Hyla;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import java.util.function.Function;

public class ModItems {
    public static Item PINK = registerItem("pink", set -> new Item(set.fireproof()));

    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(Hyla.MOD_ID, name),
                                 function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM,
                                                                                               Identifier.of(Hyla.MOD_ID, name)))));
    }

    // CUSTOM METHOD - Register all Hyla items
    public static void registerModItems() {
        Hyla.LOGGER.info("Registering Mod Items for " + Hyla.MOD_ID);
    }
}