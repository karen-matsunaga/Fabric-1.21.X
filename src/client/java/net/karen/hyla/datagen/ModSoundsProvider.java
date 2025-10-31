package net.karen.hyla.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.builder.SoundTypeBuilder;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricSoundsProvider;
import net.karen.hyla.Hyla;
import net.karen.hyla.sound.ModSounds;
import net.minecraft.data.DataOutput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import java.util.concurrent.CompletableFuture;

public class ModSoundsProvider extends FabricSoundsProvider {
    public ModSoundsProvider(DataOutput output,
                             CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registryLookup, SoundExporter exporter) {
        exporter.add(ModSounds.CHISEL_USE, SoundTypeBuilder.of(ModSounds.CHISEL_USE)
                                                           .category(SoundCategory.BLOCKS)
                                                           .sound(SoundTypeBuilder.EntryBuilder.ofFile(Identifier.of(Hyla.MOD_ID,
                                                                                                       "chisel_use")))
                                                           .subtitle("sounds.hyla.chisel_use"));
    }

    @Override public String getName() { return "Hyla Mod Sounds Provider"; }
}