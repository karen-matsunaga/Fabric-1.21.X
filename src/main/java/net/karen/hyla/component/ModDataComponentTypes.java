package net.karen.hyla.component;

import net.karen.hyla.Hyla;
import net.karen.hyla.component.custom.Coordinates;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import java.util.function.UnaryOperator;

public class ModDataComponentTypes {
    public static final ComponentType<Coordinates> COORDINATES =
           register("coordinates",
                    builder -> builder.codec(Coordinates.CODEC).packetCodec(Coordinates.PACKET_CODEC));

    // CUSTOM METHOD - Register all Hyla data components
    private static <T>ComponentType<T> register(String name,
                                                UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(Hyla.MOD_ID, name),
                                 builderOperator.apply(ComponentType.builder()).build());
    }

    // CUSTOM METHOD - Register all Hyla data components
    public static void registerDataComponentTypes() {
        Hyla.LOGGER.info("Registering Data Component Types for " + Hyla.MOD_ID);
    }
}