package net.karen.hyla.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.karen.hyla.Hyla;
import net.karen.hyla.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemsGroup {
    public static final ItemGroup PINK_ITEMS_GROUP =
           Registry.register(Registries.ITEM_GROUP, Identifier.of(Hyla.MOD_ID, "pink_items"),
                             FabricItemGroup.builder()
                                            .icon(() -> new ItemStack(ModItems.PINK))
                                            .displayName(Text.translatable("itemgroup.hyla.pink_items"))
                                            .entries((displayContext, entries) -> {
                                                entries.add(ModItems.PINK);
                                                entries.add(ModItems.CHISEL);
                                            }).build());

    public static final ItemGroup PINK_BLOCKS_GROUP =
           Registry.register(Registries.ITEM_GROUP, Identifier.of(Hyla.MOD_ID, "pink_blocks"),
                             FabricItemGroup.builder()
                                            .icon(() -> new ItemStack(ModBlocks.PINK_BLOCK))
                                            .displayName(Text.translatable("itemgroup.hyla.pink_blocks"))
                                            .entries((displayContext, entries) -> {
                                                entries.add(ModBlocks.PINK_BLOCK);
                                            }).build());

    public static void registerItemGroups() {
        Hyla.LOGGER.info("Registering Item Groups for " + Hyla.MOD_ID);
    }
}