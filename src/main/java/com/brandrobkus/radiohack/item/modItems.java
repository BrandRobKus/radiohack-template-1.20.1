package com.brandrobkus.radiohack.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import com.brandrobkus.radiohack.RadioHack;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class modItems {
    //crafting
    public static final Item SCULK_MEMBRANE = registerItem("sculk_membrane", new Item(new Item.Settings()));
    public static final Item SCULK_BLUE_DYE = registerItem("sculk_blue_dye", new SculkBlueDyeItem(new Item.Settings()));
    public static final Item MUSIC_DISC_WAX = registerItem("music_disc_item", new Item(new Item.Settings()));

    //wires
    public static final Item YELLOW_WIRE = registerItem("yellow_wire", new WireItem(new Item.Settings()));
    public static final Item WHITE_WIRE = registerItem("white_wire", new Item(new Item.Settings()));
    public static final Item RED_WIRE = registerItem("red_wire", new Item(new Item.Settings()));
    public static final Item ORANGE_WIRE = registerItem("orange_wire", new Item(new Item.Settings()));
    public static final Item LIME_WIRE = registerItem("lime_wire", new Item(new Item.Settings()));
    public static final Item GREEN_WIRE = registerItem("green_wire", new Item(new Item.Settings()));
    public static final Item CYAN_WIRE = registerItem("cyan_wire", new Item(new Item.Settings()));
    public static final Item SKY_WIRE = registerItem("sky_wire", new Item(new Item.Settings()));
    public static final Item BLUE_WIRE = registerItem("blue_wire", new Item(new Item.Settings()));
    public static final Item PURPLE_WIRE = registerItem("purple_wire", new Item(new Item.Settings()));
    public static final Item MAGENTA_WIRE = registerItem("magenta_wire", new Item(new Item.Settings()));
    public static final Item PINK_WIRE = registerItem("pink_wire", new Item(new Item.Settings()));
    public static final Item LIGHT_GRAY_WIRE = registerItem("light_gray_wire", new Item(new Item.Settings()));
    public static final Item GRAY_WIRE = registerItem("gray_wire", new Item(new Item.Settings()));
    public static final Item BLACK_WIRE = registerItem("black_wire", new Item(new Item.Settings()));
    public static final Item BROWN_WIRE = registerItem("brown_wire", new Item(new Item.Settings()));
    public static final Item SCULK_BLUE_WIRE = registerItem("sculk_blue_wire", new Item(new Item.Settings()));

    public static final Item WIRELESS_MICROPHONE = registerItem("wireless_microphone", new Item(new Item.Settings().maxCount(1)));

    public static final Item BOOM_MIC = registerItem("boom_mic",
            new BoomMicItem(ToolMaterials.NETHERITE, new Item.Settings().maxCount(1)));



    private static void addItemstoIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(SCULK_MEMBRANE);
        entries.add(YELLOW_WIRE);
        entries.add(WHITE_WIRE);
        entries.add(RED_WIRE);
        entries.add(ORANGE_WIRE);
        entries.add(LIME_WIRE);
        entries.add(GREEN_WIRE);
        entries.add(CYAN_WIRE);
        entries.add(SKY_WIRE);
        entries.add(BLUE_WIRE);
        entries.add(PURPLE_WIRE);
        entries.add(MAGENTA_WIRE);
        entries.add(PINK_WIRE);
        entries.add(LIGHT_GRAY_WIRE);
        entries.add(GRAY_WIRE);
        entries.add(BLACK_WIRE);
        entries.add(BROWN_WIRE);
        entries.add(SCULK_BLUE_WIRE);
        entries.add(SCULK_BLUE_DYE);
        entries.add(WIRELESS_MICROPHONE);
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(RadioHack.MOD_ID, name), item);
    }
    public static void registerModItems(){
        RadioHack.LOGGER.info("Registering Mod Items For " + RadioHack.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(modItems::addItemstoIngredientTabItemGroup);
    }
}