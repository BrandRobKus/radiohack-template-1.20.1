package com.brandrobkus.radiohack.datagen;

import com.brandrobkus.radiohack.block.modBlocks;
import com.brandrobkus.radiohack.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture){
        super(output, registriesFuture);
    }
    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Blocks.ACOUSTIC_PANEL)
                .add(modBlocks.BLACK_ACOUSTIC_PANEL)
                .add(modBlocks.BLUE_ACOUSTIC_PANEL)
                .add(modBlocks.BROWN_ACOUSTIC_PANEL)
                .add(modBlocks.CYAN_ACOUSTIC_PANEL)
                .add(modBlocks.GRAY_ACOUSTIC_PANEL)
                .add(modBlocks.GREEN_ACOUSTIC_PANEL)
                .add(modBlocks.LIGHT_BLUE_ACOUSTIC_PANEL)
                .add(modBlocks.LIGHT_GRAY_ACOUSTIC_PANEL)
                .add(modBlocks.LIME_ACOUSTIC_PANEL)
                .add(modBlocks.MAGENTA_ACOUSTIC_PANEL)
                .add(modBlocks.ORANGE_ACOUSTIC_PANEL)
                .add(modBlocks.PINK_ACOUSTIC_PANEL)
                .add(modBlocks.PURPLE_ACOUSTIC_PANEL)
                .add(modBlocks.RED_ACOUSTIC_PANEL)
                .add(modBlocks.WHITE_ACOUSTIC_PANEL)
                .add(modBlocks.YELLOW_ACOUSTIC_PANEL)
                .add(modBlocks.SCULK_BLUE_ACOUSTIC_PANEL)
        ;

        getOrCreateTagBuilder(BlockTags.DAMPENS_VIBRATIONS)
                .add(modBlocks.BLACK_ACOUSTIC_PANEL)
                .add(modBlocks.BLUE_ACOUSTIC_PANEL)
                .add(modBlocks.BROWN_ACOUSTIC_PANEL)
                .add(modBlocks.CYAN_ACOUSTIC_PANEL)
                .add(modBlocks.GRAY_ACOUSTIC_PANEL)
                .add(modBlocks.GREEN_ACOUSTIC_PANEL)
                .add(modBlocks.LIGHT_BLUE_ACOUSTIC_PANEL)
                .add(modBlocks.LIGHT_GRAY_ACOUSTIC_PANEL)
                .add(modBlocks.LIME_ACOUSTIC_PANEL)
                .add(modBlocks.MAGENTA_ACOUSTIC_PANEL)
                .add(modBlocks.ORANGE_ACOUSTIC_PANEL)
                .add(modBlocks.PINK_ACOUSTIC_PANEL)
                .add(modBlocks.PURPLE_ACOUSTIC_PANEL)
                .add(modBlocks.RED_ACOUSTIC_PANEL)
                .add(modBlocks.WHITE_ACOUSTIC_PANEL)
                .add(modBlocks.YELLOW_ACOUSTIC_PANEL)
                .add(modBlocks.SCULK_BLUE_ACOUSTIC_PANEL)
                .add(modBlocks.SCULK_BLUE_WOOL)
                .add(modBlocks.SCULK_BLUE_CARPET)
        ;

        getOrCreateTagBuilder(BlockTags.OCCLUDES_VIBRATION_SIGNALS)
                .add(modBlocks.BLACK_ACOUSTIC_PANEL)
                .add(modBlocks.BLUE_ACOUSTIC_PANEL)
                .add(modBlocks.BROWN_ACOUSTIC_PANEL)
                .add(modBlocks.CYAN_ACOUSTIC_PANEL)
                .add(modBlocks.GRAY_ACOUSTIC_PANEL)
                .add(modBlocks.GREEN_ACOUSTIC_PANEL)
                .add(modBlocks.LIGHT_BLUE_ACOUSTIC_PANEL)
                .add(modBlocks.LIGHT_GRAY_ACOUSTIC_PANEL)
                .add(modBlocks.LIME_ACOUSTIC_PANEL)
                .add(modBlocks.MAGENTA_ACOUSTIC_PANEL)
                .add(modBlocks.ORANGE_ACOUSTIC_PANEL)
                .add(modBlocks.PINK_ACOUSTIC_PANEL)
                .add(modBlocks.PURPLE_ACOUSTIC_PANEL)
                .add(modBlocks.RED_ACOUSTIC_PANEL)
                .add(modBlocks.WHITE_ACOUSTIC_PANEL)
                .add(modBlocks.YELLOW_ACOUSTIC_PANEL)
                .add(modBlocks.SCULK_BLUE_ACOUSTIC_PANEL)
                .add(modBlocks.SCULK_BLUE_WOOL)
                .add(modBlocks.SCULK_BLUE_CARPET)
                ;

        getOrCreateTagBuilder(BlockTags.WOOL)
                .add(modBlocks.SCULK_BLUE_WOOL)
                ;

        getOrCreateTagBuilder(BlockTags.WOOL_CARPETS)
                .add(modBlocks.SCULK_BLUE_CARPET)
                ;

        getOrCreateTagBuilder(BlockTags.TERRACOTTA)
                .add(modBlocks.SCULK_BLUE_TERRACOTTA)
                .add(modBlocks.SCULK_BLUE_GLAZED_TERRACOTTA)
                ;

        getOrCreateTagBuilder(BlockTags.CANDLES)
                .add(modBlocks.SCULK_BLUE_CANDLE)
                ;

        getOrCreateTagBuilder(BlockTags.CANDLE_CAKES)
                .add(modBlocks.SCULK_BLUE_CANDLE_CAKE)
                ;


        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(modBlocks.CONDENSER)
                .add(modBlocks.MICROPHONE_ARM)
                .add(modBlocks.RECEIVER)
                .add(modBlocks.WIREHOOK)
                .add(modBlocks.SCULK_BLUE_TERRACOTTA)
                .add(modBlocks.SCULK_BLUE_GLAZED_TERRACOTTA)
                .add(modBlocks.SCULK_BLUE_CONCRETE)
                ;

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(modBlocks.ANTENNA)
                .add(modBlocks.MEDIA_BLOCK)
                .add(modBlocks.MICROPHONE)
                .add(modBlocks.SPEAKER)
                .add(modBlocks.MUSIC_DISC_PRESSER)
        ;

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(modBlocks.SCULK_BLUE_CONCRETE_POWDER)
        ;

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(Blocks.SCULK_SENSOR)
        ;

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(modBlocks.CONDENSER)
                .add(modBlocks.RECEIVER)
                .add(modBlocks.WIREHOOK)
        ;

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)

        ;

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)

        ;
    }
}
