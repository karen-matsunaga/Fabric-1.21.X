package net.karen.hyla.particle;

import net.minecraft.client.particle.BillboardParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.math.random.Random;
import org.jetbrains.annotations.NotNull;

public class BismuthParticle extends BillboardParticle {
    protected BismuthParticle(ClientWorld world, double x, double y, double z,
                              double velocityX, double velocityY, double velocityZ, SpriteProvider sprite) {
        super(world, x, y, z, velocityX, velocityY, velocityZ, sprite.getFirst());
        this.velocityMultiplier = 0.8F;
        this.maxAge = 80;
        this.red = 1F;
        this.green = 1F;
        this.blue = 1F;
    }

    @Override
    protected RenderType getRenderType() { return RenderType.PARTICLE_ATLAS_TRANSLUCENT; }

    public record Factory(SpriteProvider spriteProvider) implements ParticleFactory<SimpleParticleType> {
        @Override
        public @NotNull Particle createParticle(SimpleParticleType parameters, ClientWorld world,
                                                double x, double y, double z, double velocityX, double velocityY, double velocityZ,
                                                Random random) {
            return new BismuthParticle(world, x, y, z, velocityX, velocityY, velocityZ, this.spriteProvider);
        }
    }
}