package net.karen.hyla;

import net.fabricmc.api.ModInitializer;
import net.karen.hyla.block.ModBlocks;
import net.karen.hyla.component.ModDataComponentTypes;
import net.karen.hyla.item.ModItems;
import net.karen.hyla.item.ModItemsGroup;
import net.karen.hyla.particle.ModParticles;
import net.karen.hyla.sound.ModSounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hyla implements ModInitializer {
	public static final String MOD_ID = "hyla";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        LOGGER.info("Hello Fabric world!");
        ModItems.registerModItems(); // Items
        ModBlocks.registerModBlocks(); // Blocks
        ModSounds.registerSounds(); // Sounds
        ModParticles.registerParticles(); // Particles
        ModDataComponentTypes.registerDataComponentTypes(); // Data Components
        ModItemsGroup.registerItemGroups(); // Items Group
	}
}