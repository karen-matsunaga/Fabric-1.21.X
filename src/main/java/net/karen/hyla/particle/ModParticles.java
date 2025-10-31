package net.karen.hyla.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.karen.hyla.Hyla;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {
    public static final SimpleParticleType BISMUTH_PARTICLES =
           registerParticle("bismuth_particles", FabricParticleTypes.simple());

    public static final SimpleParticleType ALEXANDRITE_PARTICLES =
           registerParticle("alexandrite_particles", FabricParticleTypes.simple());

    public static final SimpleParticleType BOUNCY_BALLS_PARTICLES =
           registerParticle("bouncy_balls_particles", FabricParticleTypes.simple());

    // CUSTOM METHOD - Register all Hyla custom particles
    private static SimpleParticleType registerParticle(String name, SimpleParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(Hyla.MOD_ID, name), particleType);
    }

    // CUSTOM METHOD - Register all Hyla particles
    public static void registerParticles() {
        Hyla.LOGGER.info("Registering Particles for " + Hyla.MOD_ID);
    }
}