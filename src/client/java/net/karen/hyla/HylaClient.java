package net.karen.hyla;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.karen.hyla.particle.BismuthParticle;
import net.karen.hyla.particle.ModParticles;

public class HylaClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// PARTICLES
        ParticleFactoryRegistry.getInstance().register(ModParticles.BISMUTH_PARTICLES, BismuthParticle.Factory::new);
	}
}