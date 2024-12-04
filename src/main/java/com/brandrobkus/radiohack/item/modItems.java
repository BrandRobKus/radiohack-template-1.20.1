package com.brandrobkus.radiohack.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import com.brandrobkus.radiohack.RadioHack;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class modItems{
    public static final Item SCULK_MEMBRANE = registerItem("sculk_membrane", new Item(new FabricItemSettings()));
    private static void addItemstoIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(SCULK_MEMBRANE);
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(RadioHack.MOD_ID, name), item);
    }
    public static void registerModItems(){
        RadioHack.LOGGER.info("Registering Mod Items For " + RadioHack.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(modItems::addItemstoIngredientTabItemGroup);
    }
}