package com.brandrobkus.radiohack.block;

import com.brandrobkus.radiohack.RadioHack;
import com.brandrobkus.radiohack.item.ModDyeColor;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class modBlocks {

    public static final Block SPEAKER = registerBlock("speaker",
            new SpeakerBlock(AbstractBlock.Settings.create().nonOpaque().hardness(3).resistance(5).requiresTool()));
    public static final Block RECEIVER = registerBlock("receiver",
            new ReceiverBlock(AbstractBlock.Settings.create().nonOpaque().hardness(4).resistance(5).requiresTool()));
    public static final Block RADIO = registerBlock("radio",
            new RadioBlock(AbstractBlock.Settings.create().nonOpaque().hardness(1).resistance(3)));
    public static final Block ANTENNA = registerBlock("antenna",
            new AntennaBlock(AbstractBlock.Settings.create().nonOpaque().hardness(3).resistance(5).requiresTool()));
    public static final Block WIREHOOK = registerBlock("wirehook",
            new WireHookBlock(AbstractBlock.Settings.create().nonOpaque().hardness(2).resistance(5).requiresTool()));
    public static final Block MICROPHONE = registerBlock("microphone",
            new MicrophoneBlock(AbstractBlock.Settings.create().nonOpaque().hardness(3).resistance(5).requiresTool()));
    public static final Block CONDENSER = registerBlock("condenser",
            new CondenserBlock(AbstractBlock.Settings.create().nonOpaque().hardness(4).resistance(5).requiresTool()));
    public static final Block MEDIA_BLOCK = registerBlock("media_block",
            new MediaBlock(AbstractBlock.Settings.create().nonOpaque().hardness(2).resistance(5).requiresTool()));
    public static final Block MICROPHONE_ARM = registerBlock("microphone_arm",
            new MicrophoneArmBlock(AbstractBlock.Settings.create().nonOpaque().hardness(3).resistance(5).requiresTool()));
    public static final Block MUSIC_DISC_PRESSER = registerBlock("music_disc_presser",
            new MusicDiscPresserBlock(AbstractBlock.Settings.create().nonOpaque().hardness(3).resistance(5).requiresTool()));


    //sculk-blue colored blocks
    public static final Block SCULK_BLUE_WOOL = registerBlock("sculk_blue_wool",
            new Block(FabricBlockSettings.copyOf(Blocks.BLUE_WOOL)));
    public static final Block SCULK_BLUE_CARPET = registerBlock("sculk_blue_carpet",
            new ModDyedCarpetBlock(ModDyeColor.SCULK_BLUE, FabricBlockSettings.copyOf(Blocks.BLUE_CARPET)));
    public static final Block SCULK_BLUE_CONCRETE = registerBlock("sculk_blue_concrete",
            new Block(FabricBlockSettings.copyOf(Blocks.BLUE_CONCRETE)));
    public static final Block SCULK_BLUE_CONCRETE_POWDER = registerBlock("sculk_blue_concrete_powder",
            new ConcretePowderBlock(SCULK_BLUE_CONCRETE, AbstractBlock.Settings.copy(Blocks.BLUE_CONCRETE_POWDER)));
    public static final Block SCULK_BLUE_TERRACOTTA = registerBlock("sculk_blue_terracotta",
            new Block(FabricBlockSettings.copyOf(Blocks.BLUE_TERRACOTTA)));
    public static final Block SCULK_BLUE_GLAZED_TERRACOTTA = registerBlock("sculk_blue_glazed_terracotta",
            new GlazedTerracottaBlock(FabricBlockSettings.copyOf(Blocks.BLUE_GLAZED_TERRACOTTA)));
    public static final Block SCULK_BLUE_GLASS = registerBlock("sculk_blue_glass",
            new GlassBlock(FabricBlockSettings.copyOf(Blocks.GLASS)));
    public static final Block SCULK_BLUE_GLASS_PANE = registerBlock("sculk_blue_glass_pane",
            new ModStainedGlassPane(SCULK_BLUE_GLASS, FabricBlockSettings.copyOf(Blocks.GLASS_PANE)));
    public static final Block SCULK_BLUE_CANDLE = registerBlock("sculk_blue_candle",
            new CandleBlock(FabricBlockSettings.copyOf(Blocks.CANDLE)));
    public static final Block SCULK_BLUE_CANDLE_CAKE = registerBlock("sculk_blue_candle_cake",
            new CandleCakeBlock(SCULK_BLUE_CANDLE, FabricBlockSettings.copyOf(Blocks.CANDLE_CAKE)));

    //acoustic panels
    public static final Block BLACK_ACOUSTIC_PANEL = registerBlock("black_acoustic_panel",
            new AcousticPanelBlock(FabricBlockSettings.copyOf(Blocks.BLACK_CARPET)));
    public static final Block BLUE_ACOUSTIC_PANEL = registerBlock("blue_acoustic_panel",
            new AcousticPanelBlock(FabricBlockSettings.copyOf(Blocks.BLUE_CARPET)));
    public static final Block BROWN_ACOUSTIC_PANEL = registerBlock("brown_acoustic_panel",
            new AcousticPanelBlock(FabricBlockSettings.copyOf(Blocks.BROWN_CARPET)));
    public static final Block CYAN_ACOUSTIC_PANEL = registerBlock("cyan_acoustic_panel",
            new AcousticPanelBlock(FabricBlockSettings.copyOf(Blocks.CYAN_CARPET)));
    public static final Block GRAY_ACOUSTIC_PANEL = registerBlock("gray_acoustic_panel",
            new AcousticPanelBlock(FabricBlockSettings.copyOf(Blocks.GRAY_CARPET)));
    public static final Block GREEN_ACOUSTIC_PANEL = registerBlock("green_acoustic_panel",
            new AcousticPanelBlock(FabricBlockSettings.copyOf(Blocks.GREEN_CARPET)));
    public static final Block LIGHT_BLUE_ACOUSTIC_PANEL = registerBlock("light_blue_acoustic_panel",
            new AcousticPanelBlock(FabricBlockSettings.copyOf(Blocks.LIGHT_BLUE_CARPET)));
    public static final Block LIGHT_GRAY_ACOUSTIC_PANEL = registerBlock("light_gray_acoustic_panel",
            new AcousticPanelBlock(FabricBlockSettings.copyOf(Blocks.LIGHT_GRAY_CARPET)));
    public static final Block LIME_ACOUSTIC_PANEL = registerBlock("lime_acoustic_panel",
            new AcousticPanelBlock(FabricBlockSettings.copyOf(Blocks.LIME_CARPET)));
    public static final Block MAGENTA_ACOUSTIC_PANEL = registerBlock("magenta_acoustic_panel",
            new AcousticPanelBlock(FabricBlockSettings.copyOf(Blocks.MAGENTA_CARPET)));
    public static final Block ORANGE_ACOUSTIC_PANEL = registerBlock("orange_acoustic_panel",
            new AcousticPanelBlock(FabricBlockSettings.copyOf(Blocks.ORANGE_CARPET)));
    public static final Block PINK_ACOUSTIC_PANEL = registerBlock("pink_acoustic_panel",
            new AcousticPanelBlock(FabricBlockSettings.copyOf(Blocks.PINK_CARPET)));
    public static final Block PURPLE_ACOUSTIC_PANEL = registerBlock("purple_acoustic_panel",
            new AcousticPanelBlock(FabricBlockSettings.copyOf(Blocks.PURPLE_CARPET)));
    public static final Block RED_ACOUSTIC_PANEL = registerBlock("red_acoustic_panel",
            new AcousticPanelBlock(FabricBlockSettings.copyOf(Blocks.RED_CARPET)));
    public static final Block WHITE_ACOUSTIC_PANEL = registerBlock("white_acoustic_panel",
            new AcousticPanelBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CARPET)));
    public static final Block YELLOW_ACOUSTIC_PANEL = registerBlock("yellow_acoustic_panel",
            new AcousticPanelBlock(FabricBlockSettings.copyOf(Blocks.YELLOW_CARPET)));
    public static final Block SCULK_BLUE_ACOUSTIC_PANEL = registerBlock("sculk_blue_acoustic_panel",
            new AcousticPanelBlock(FabricBlockSettings.copyOf(Blocks.BLUE_CARPET)));

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
