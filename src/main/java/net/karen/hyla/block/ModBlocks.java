package net.karen.hyla.block;

import net.karen.hyla.Hyla;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import java.util.function.Function;

public class ModBlocks {
    public static final Block PINK_BLOCK =
           registerBlock("pink_block", set -> new Block(set.strength(4F)
                                                                         .requiresTool()
                                                                         .sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    // CUSTOM METHOD - Register Hyla blocks + block items
    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> function) {
        Block toRegister = function.apply(AbstractBlock.Settings.create()
                                                       .registryKey(RegistryKey.of(RegistryKeys.BLOCK,
                                                                                   Identifier.of(Hyla.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(Registries.BLOCK, Identifier.of(Hyla.MOD_ID, name), toRegister);
    }

    // CUSTOM METHOD - Register Hyla blocks
    private static Block registerBlockWithoutBlockItem(String name, Function<AbstractBlock.Settings,
                                                       Block> function) {
        return Registry.register(Registries.BLOCK, Identifier.of(Hyla.MOD_ID, name),
                                 function.apply(AbstractBlock.Settings.create()
                                                             .registryKey(RegistryKey.of(RegistryKeys.BLOCK,
                                                                                         Identifier.of(Hyla.MOD_ID, name)))));
    }

    // CUSTOM METHOD - Register Hyla block items
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Hyla.MOD_ID, name),
                          new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey()
                                                                  .registryKey(RegistryKey.of(RegistryKeys.ITEM,
                                                                                              Identifier.of(Hyla.MOD_ID, name)))));
    }

    // CUSTOM METHOD - Register all Hyla blocks
    public static void registerModBlocks() {
        Hyla.LOGGER.info("Registering Mod Blocks for " + Hyla.MOD_ID);
    }
}