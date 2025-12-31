package com.brandrobkus.radiohack.item;

import com.brandrobkus.radiohack.RadioHack;
import com.brandrobkus.radiohack.block.modBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;

import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class modItemGroups {
    public static final ItemGroup RADIOHACK_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(RadioHack.MOD_ID, "radiohack"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.radiohack"))
                    .icon(() -> new ItemStack(modBlocks.RADIO)).entries((displayContext, entries) -> {
                        //sound equipment
                        entries.add(modBlocks.RADIO);
                        entries.add(modBlocks.SPEAKER);
                        entries.add(modBlocks.MEDIA_BLOCK);
                        entries.add(modBlocks.RECEIVER);
                        entries.add(modBlocks.CONDENSER);
                        entries.add(modBlocks.ANTENNA);
                        entries.add(modBlocks.MICROPHONE);
                        entries.add(modBlocks.MICROPHONE_ARM);
                        entries.add(modItems.WIRELESS_MICROPHONE);

                        //acoustic panels
                        entries.add(modBlocks.BLACK_ACOUSTIC_PANEL);
                        entries.add(modBlocks.BLUE_ACOUSTIC_PANEL);
                        entries.add(modBlocks.BROWN_ACOUSTIC_PANEL);
                        entries.add(modBlocks.CYAN_ACOUSTIC_PANEL);
                        entries.add(modBlocks.GRAY_ACOUSTIC_PANEL);
                        entries.add(modBlocks.GREEN_ACOUSTIC_PANEL);
                        entries.add(modBlocks.LIGHT_BLUE_ACOUSTIC_PANEL);
                        entries.add(modBlocks.LIGHT_GRAY_ACOUSTIC_PANEL);
                        entries.add(modBlocks.LIME_ACOUSTIC_PANEL);
                        entries.add(modBlocks.MAGENTA_ACOUSTIC_PANEL);
                        entries.add(modBlocks.ORANGE_ACOUSTIC_PANEL);
                        entries.add(modBlocks.PINK_ACOUSTIC_PANEL);
                        entries.add(modBlocks.PURPLE_ACOUSTIC_PANEL);
                        entries.add(modBlocks.RED_ACOUSTIC_PANEL);
                        entries.add(modBlocks.WHITE_ACOUSTIC_PANEL);
                        entries.add(modBlocks.YELLOW_ACOUSTIC_PANEL);
                        entries.add(modBlocks.SCULK_BLUE_ACOUSTIC_PANEL);

                        //wires
                        entries.add(modItems.WHITE_WIRE);
                        entries.add(modItems.RED_WIRE);
                        entries.add(modItems.ORANGE_WIRE);
                        entries.add(modItems.YELLOW_WIRE);
                        entries.add(modItems.LIME_WIRE);
                        entries.add(modItems.GREEN_WIRE);
                        entries.add(modItems.CYAN_WIRE);
                        entries.add(modItems.SKY_WIRE);
                        entries.add(modItems.BLUE_WIRE);
                        entries.add(modItems.PURPLE_WIRE);
                        entries.add(modItems.MAGENTA_WIRE);
                        entries.add(modItems.PINK_WIRE);
                        entries.add(modItems.LIGHT_GRAY_WIRE);
                        entries.add(modItems.GRAY_WIRE);
                        entries.add(modItems.BLACK_WIRE);
                        entries.add(modItems.BROWN_WIRE);
                        entries.add(modItems.SCULK_BLUE_WIRE);
                        entries.add(modBlocks.WIREHOOK);
                        entries.add(modBlocks.MUSIC_DISC_PRESSER);

                        //crafting materials
                        entries.add(modItems.SCULK_MEMBRANE);
                        entries.add(modItems.SCULK_BLUE_DYE);

                        //weapon
                        entries.add(modItems.BOOM_MIC);

                        //blocks
                        entries.add(modBlocks.SCULK_BLUE_WOOL);
                        entries.add(modBlocks.SCULK_BLUE_CARPET);
                        entries.add(modBlocks.SCULK_BLUE_CONCRETE_POWDER);
                        entries.add(modBlocks.SCULK_BLUE_CONCRETE);
                        entries.add(modBlocks.SCULK_BLUE_TERRACOTTA);
                        entries.add(modBlocks.SCULK_BLUE_GLAZED_TERRACOTTA);
                        entries.add(modBlocks.SCULK_BLUE_GLASS);
                        entries.add(modBlocks.SCULK_BLUE_GLASS_PANE);
                        entries.add(modBlocks.SCULK_BLUE_CANDLE);

                        //music disc stuff
                        entries.add(modItems.MUSIC_DISC_WAX);

                    }).build());

    public static void registerItemGroups(){
        RadioHack.LOGGER.info("Registering Item Groups for " + RadioHack.MOD_ID);
    }
}
