package com.brandrobkus.radiohack.block;

import com.brandrobkus.radiohack.RadioHack;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class modBlocks {

    public static final Block SPEAKER = registerBlock("speaker",
            new SpeakerBlock(AbstractBlock.Settings.create().nonOpaque().hardness(3)));
    public static final Block RECEIVER = registerBlock("receiver",
            new ReceiverBlock(AbstractBlock.Settings.create().nonOpaque().hardness(4)));
    public static final Block RADIO = registerBlock("radio",
            new RadioBlock(AbstractBlock.Settings.create().nonOpaque().hardness(1)));
    public static final Block ANTENNA = registerBlock("antenna",
            new AntennaBlock(AbstractBlock.Settings.create().nonOpaque().hardness(3)));
    public static final Block WIREHOOK = registerBlock("wirehook",
            new WireHookBlock(AbstractBlock.Settings.create().nonOpaque().hardness(2)));
    public static final Block MICROPHONE = registerBlock("microphone",
            new MicrophoneBlock(AbstractBlock.Settings.create().nonOpaque().hardness(3)));
    public static final Block CONDENSER = registerBlock("condenser",
            new CondenserBlock(AbstractBlock.Settings.create().nonOpaque().hardness(4)));
    public static final Block MEDIA_BLOCK = registerBlock("media_block",
            new MediaBlock(AbstractBlock.Settings.create().nonOpaque().hardness(2)));

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
