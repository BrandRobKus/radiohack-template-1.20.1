package com.brandrobkus.radiohack.datagen;

import com.brandrobkus.radiohack.block.modBlocks;
import com.brandrobkus.radiohack.item.modItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {


    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {

        addDrop(modBlocks.RADIO);
        addDrop(modBlocks.SPEAKER);
        addDrop(modBlocks.MEDIA_BLOCK);
        addDrop(modBlocks.RECEIVER);
        addDrop(modBlocks.CONDENSER);
        addDrop(modBlocks.ANTENNA);
        addDrop(modBlocks.MICROPHONE);
        addDrop(modBlocks.MICROPHONE_ARM);
        addDrop(modBlocks.WIREHOOK);
        addDrop(modBlocks.MUSIC_DISC_PRESSER);

        //acoustic panels
        addDrop(modBlocks.BLACK_ACOUSTIC_PANEL);
        addDrop(modBlocks.BLUE_ACOUSTIC_PANEL);
        addDrop(modBlocks.BROWN_ACOUSTIC_PANEL);
        addDrop(modBlocks.CYAN_ACOUSTIC_PANEL);
        addDrop(modBlocks.GRAY_ACOUSTIC_PANEL);
        addDrop(modBlocks.GREEN_ACOUSTIC_PANEL);
        addDrop(modBlocks.LIGHT_BLUE_ACOUSTIC_PANEL);
        addDrop(modBlocks.LIGHT_GRAY_ACOUSTIC_PANEL);
        addDrop(modBlocks.LIME_ACOUSTIC_PANEL);
        addDrop(modBlocks.MAGENTA_ACOUSTIC_PANEL);
        addDrop(modBlocks.ORANGE_ACOUSTIC_PANEL);
        addDrop(modBlocks.PINK_ACOUSTIC_PANEL);
        addDrop(modBlocks.PURPLE_ACOUSTIC_PANEL);
        addDrop(modBlocks.RED_ACOUSTIC_PANEL);
        addDrop(modBlocks.WHITE_ACOUSTIC_PANEL);
        addDrop(modBlocks.YELLOW_ACOUSTIC_PANEL);
        addDrop(modBlocks.SCULK_BLUE_ACOUSTIC_PANEL);

        addDrop(Blocks.SCULK_SENSOR, sculkMembraneDrops(Blocks.SCULK_SENSOR, modItems.SCULK_MEMBRANE));

        //colored blocks
        addDrop(modBlocks.SCULK_BLUE_WOOL);
        addDrop(modBlocks.SCULK_BLUE_CARPET);
        addDrop(modBlocks.SCULK_BLUE_CONCRETE_POWDER);
        addDrop(modBlocks.SCULK_BLUE_CONCRETE);
        addDrop(modBlocks.SCULK_BLUE_TERRACOTTA);
        addDrop(modBlocks.SCULK_BLUE_GLAZED_TERRACOTTA);

        addDropWithSilkTouch(modBlocks.SCULK_BLUE_GLASS);
        addDropWithSilkTouch(modBlocks.SCULK_BLUE_GLASS_PANE);


    }
    public LootTable.Builder sculkMembraneDrops(Block drop, Item item) {
        return dropsWithSilkTouch(
                drop,
                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 4.0F)))
                )
        );
    }
}
