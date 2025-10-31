package net.karen.hyla.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.karen.hyla.block.ModBlocks;
import net.karen.hyla.component.ModDataComponentTypes;
import net.karen.hyla.item.ModItems;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.ItemModels;
import net.minecraft.client.data.Models;
import net.minecraft.client.item.ItemAsset;
import net.minecraft.client.render.item.model.ConditionItemModel;
import net.minecraft.client.render.item.model.ItemModel;
import net.minecraft.client.render.item.property.bool.HasComponentProperty;

public class ModModelsProvider extends FabricModelProvider {
    public ModModelsProvider(FabricDataOutput output) { super(output); }

    // DEFAULT METHOD - Hyla blocks models
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_BLOCK);
    }

    // DEFAULT METHOD - Hyla items models
    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PINK, Models.GENERATED);
        ItemModel.Unbaked unbakedChisel = ItemModels.basic(itemModelGenerator.upload(ModItems.CHISEL, Models.GENERATED));
        ItemModel.Unbaked unbakedUsedChisel =
                  ItemModels.basic(itemModelGenerator.registerSubModel(ModItems.CHISEL, "_used", Models.GENERATED));
        itemModelGenerator.output
                          .accept(ModItems.CHISEL,
                                  new ItemAsset(new ConditionItemModel.Unbaked(new HasComponentProperty(ModDataComponentTypes.COORDINATES,
                                                                                                        false),
                                                                               unbakedUsedChisel, unbakedChisel),
                                  new ItemAsset.Properties(false, false)).model());
    }

    @Override public String getName() { return "Hyla Mod Models Provider"; }
}