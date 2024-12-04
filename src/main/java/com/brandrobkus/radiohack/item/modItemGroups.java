package com.brandrobkus.radiohack.item;

import com.brandrobkus.radiohack.RadioHack;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;

import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class modItemGroups {
    public static final ItemGroup WIRE_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(RadioHack.MOD_ID, "radiohack"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.radiohack"))
                    .icon(() -> new ItemStack(modItems.YELLOW_WIRE)).entries((displayContext, entries) -> {
                        entries.add(modItems.WHITE_WIRE);
                        entries.add(modItems.YELLOW_WIRE);
                        entries.add(modItems.SCULK_MEMBRANE);
                    }).build());

    public static void registerItemGroups(){
        RadioHack.LOGGER.info("Registering Item Groups for " + RadioHack.MOD_ID);
    }
}
