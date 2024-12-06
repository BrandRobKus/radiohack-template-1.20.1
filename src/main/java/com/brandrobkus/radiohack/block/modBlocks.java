package com.brandrobkus.radiohack.block;

import com.brandrobkus.radiohack.RadioHack;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class modBlocks {

    public static final Block SPEAKER = registerBlock("speaker",
            new SpeakerBlock(AbstractBlock.Settings.create().nonOpaque().));
    public static final Block RECEIVER = registerBlock("receiver",
            new ReceiverBlock(AbstractBlock.Settings.create().nonOpaque()));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(RadioHack.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(RadioHack.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks(){
        RadioHack.LOGGER.info("Registering ModBlocks for " + RadioHack.MOD_ID);
    }
}
