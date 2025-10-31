package net.karen.hyla.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.karen.hyla.block.ModBlocks;
import net.karen.hyla.item.ModItems;
import net.minecraft.registry.RegistryWrapper;
import java.util.concurrent.CompletableFuture;

public class ModLanguageProvider extends FabricLanguageProvider {
    public ModLanguageProvider(FabricDataOutput dataOutput,
                               CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup,
                                     TranslationBuilder translationBuilder) {
        // ITEM GROUPS
        translationBuilder.add("itemgroup.hyla.pink_items", "Pink Item Group");
        translationBuilder.add("itemgroup.hyla.pink_blocks", "Pink Block Group");

        // BLOCKS
        translationBuilder.add(ModBlocks.PINK_BLOCK, "Pink Block");

        // ITEMS
        translationBuilder.add(ModItems.PINK, "Pink");
    }

    @Override public String getName() { return "Hyla Mod Language Provider"; }
}