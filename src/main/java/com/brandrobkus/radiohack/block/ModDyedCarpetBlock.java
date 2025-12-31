package com.brandrobkus.radiohack.block;

import com.brandrobkus.radiohack.item.ModDyeColor;
import net.minecraft.block.Block;
import net.minecraft.block.CarpetBlock;

public class ModDyedCarpetBlock extends CarpetBlock {

    private final ModDyeColor modDyeColor;

    public ModDyedCarpetBlock(ModDyeColor modDyeColor, Settings settings) {
        super(settings);
        this.modDyeColor = modDyeColor;
    }

    public ModDyeColor getModDyeColor() {
        return this.modDyeColor;
    }
}
