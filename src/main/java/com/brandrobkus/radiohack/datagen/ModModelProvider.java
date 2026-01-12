package com.brandrobkus.radiohack.datagen;

import com.brandrobkus.radiohack.block.modBlocks;
import com.brandrobkus.radiohack.item.modItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TextureMap;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        //Sculk-Blue Dyed Blocks
        blockStateModelGenerator.registerSimpleCubeAll(modBlocks.SCULK_BLUE_WOOL);
        blockStateModelGenerator.registerSimpleCubeAll(modBlocks.SCULK_BLUE_CONCRETE_POWDER);
        blockStateModelGenerator.registerSimpleCubeAll(modBlocks.SCULK_BLUE_CONCRETE);
        blockStateModelGenerator.registerSimpleCubeAll(modBlocks.SCULK_BLUE_TERRACOTTA);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(
                modBlocks.SCULK_BLUE_GLAZED_TERRACOTTA,
                TextureMap.all(new Identifier("radiohack", "block/sculk_blue_glazed_terracotta")));
        blockStateModelGenerator.registerGlassPane(modBlocks.SCULK_BLUE_GLASS, modBlocks.SCULK_BLUE_GLASS_PANE);
        blockStateModelGenerator.registerCandle(modBlocks.SCULK_BLUE_CANDLE, modBlocks.SCULK_BLUE_CANDLE_CAKE);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        //wires
        itemModelGenerator.register(modItems.BLACK_WIRE, Models.GENERATED);
        itemModelGenerator.register(modItems.BLUE_WIRE, Models.GENERATED);
        itemModelGenerator.register(modItems.BROWN_WIRE, Models.GENERATED);
        itemModelGenerator.register(modItems.CYAN_WIRE, Models.GENERATED);
        itemModelGenerator.register(modItems.GRAY_WIRE, Models.GENERATED);
        itemModelGenerator.register(modItems.GREEN_WIRE, Models.GENERATED);
        itemModelGenerator.register(modItems.SKY_WIRE, Models.GENERATED);
        itemModelGenerator.register(modItems.LIGHT_GRAY_WIRE, Models.GENERATED);
        itemModelGenerator.register(modItems.LIME_WIRE, Models.GENERATED);
        itemModelGenerator.register(modItems.MAGENTA_WIRE, Models.GENERATED);
        itemModelGenerator.register(modItems.ORANGE_WIRE, Models.GENERATED);
        itemModelGenerator.register(modItems.PINK_WIRE, Models.GENERATED);
        itemModelGenerator.register(modItems.PURPLE_WIRE, Models.GENERATED);
        itemModelGenerator.register(modItems.RED_WIRE, Models.GENERATED);
        itemModelGenerator.register(modItems.WHITE_WIRE, Models.GENERATED);
        itemModelGenerator.register(modItems.YELLOW_WIRE, Models.GENERATED);
        itemModelGenerator.register(modItems.SCULK_BLUE_WIRE, Models.GENERATED);

        //crafting materials
        itemModelGenerator.register(modItems.SCULK_MEMBRANE, Models.GENERATED);
        itemModelGenerator.register(modItems.WIRELESS_MICROPHONE, Models.HANDHELD);
        itemModelGenerator.register(modItems.BOOM_MIC, Models.HANDHELD);
        itemModelGenerator.register(modItems.SCULK_BLUE_DYE, Models.GENERATED);
    }
}
