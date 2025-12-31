package com.brandrobkus.radiohack;

import com.brandrobkus.radiohack.block.modBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class RadioHackClient implements ClientModInitializer{
    @Override
    public void onInitializeClient(){

        BlockRenderLayerMap.INSTANCE.putBlock(modBlocks.SCULK_BLUE_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(modBlocks.SCULK_BLUE_GLASS_PANE, RenderLayer.getTranslucent());

    }
}