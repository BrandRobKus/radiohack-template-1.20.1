package com.brandrobkus.radiohack.util;

import com.brandrobkus.radiohack.RadioHack;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> ACOUSTIC_PANEL =
                createTag("acoustic_panel");

        private static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(RadioHack.MOD_ID, name));
        }

    }
    public static class Items{
        public static final TagKey<Item> WIRE =
                createTag("wire");

        private static TagKey<Item> createTag(String name){
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(RadioHack.MOD_ID, name));
        }

    }
}
