package com.brandrobkus.radiohack.datagen;

import com.brandrobkus.radiohack.item.modItems;
import com.brandrobkus.radiohack.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.WIRE)
                .add(modItems.BLACK_WIRE)
                .add(modItems.BLUE_WIRE)
                .add(modItems.BROWN_WIRE)
                .add(modItems.CYAN_WIRE)
                .add(modItems.GRAY_WIRE)
                .add(modItems.GREEN_WIRE)
                .add(modItems.SKY_WIRE)
                .add(modItems.LIGHT_GRAY_WIRE)
                .add(modItems.LIME_WIRE)
                .add(modItems.MAGENTA_WIRE)
                .add(modItems.ORANGE_WIRE)
                .add(modItems.PINK_WIRE)
                .add(modItems.PURPLE_WIRE)
                .add(modItems.RED_WIRE)
                .add(modItems.WHITE_WIRE)
                .add(modItems.YELLOW_WIRE)
                .add(modItems.SCULK_BLUE_WIRE)
        ;

    }
}
