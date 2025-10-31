package net.karen.hyla;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.karen.hyla.datagen.ModDynamicRegistryProvider;
import net.karen.hyla.datagen.ModLanguageProvider;
import net.karen.hyla.datagen.ModModelsProvider;

public class HylaDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(ModLanguageProvider::new);
        pack.addProvider(ModModelsProvider::new);
        pack.addProvider(ModDynamicRegistryProvider::new);
	}
}