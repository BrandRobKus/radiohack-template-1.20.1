package com.brandrobkus.radiohack.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.PaneBlock;


public class ModStainedGlassPane extends PaneBlock implements ModStainable {
    private final Block color;

    public ModStainedGlassPane(Block color, AbstractBlock.Settings settings) {
        super(settings);
        this.color = color;
        this.setDefaultState(
                this.stateManager
                        .getDefaultState()
                        .with(NORTH, Boolean.valueOf(false))
                        .with(EAST, Boolean.valueOf(false))
                        .with(SOUTH, Boolean.valueOf(false))
                        .with(WEST, Boolean.valueOf(false))
                        .with(WATERLOGGED, Boolean.valueOf(false))
        );
    }

    @Override
    public Block getColor() {
        return this.color;
    }
}