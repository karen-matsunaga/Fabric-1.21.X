package net.karen.hyla.component.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.util.math.BlockPos;

public record Coordinates(BlockPos blockPos) {
    // CODEC
    public static Codec<Coordinates> CODEC =
           RecordCodecBuilder.create(instance ->
                                     instance.group(BlockPos.CODEC.fieldOf("blockPos").forGetter(Coordinates::blockPos))
                                             .apply(instance, Coordinates::new));

    // PACKET CODEC
    public static PacketCodec<RegistryByteBuf, Coordinates> PACKET_CODEC =
           PacketCodec.tuple(BlockPos.PACKET_CODEC, Coordinates::blockPos, Coordinates::new);

    public String description() {
        return "Last Block changed at [X: " + this.blockPos.getX() +
               ", Y: " +  this.blockPos.getY() + ", Z: " + this.blockPos.getZ() + "]";
    }
}