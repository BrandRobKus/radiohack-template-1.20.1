package com.brandrobkus.radiohack.datagen;

import com.brandrobkus.radiohack.block.modBlocks;
import com.brandrobkus.radiohack.item.modItems;
import com.brandrobkus.radiohack.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {


    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        //Boom Mic
        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.ofItems(modBlocks.MICROPHONE_ARM), Ingredient.ofItems(Items.NETHERITE_INGOT), RecipeCategory.MISC, modItems.BOOM_MIC
                )
                .criterion("has_netherite_ingot", conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter, getItemPath(modItems.BOOM_MIC) + "_smithing");



        //Wireless Microphone
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, modItems.WIRELESS_MICROPHONE, 1)
                .pattern("  s")
                .pattern(" i ")
                .pattern("L  ")
                .input('s', modItems.SCULK_MEMBRANE)
                .input('i', Items.IRON_INGOT)
                .input('L', Items.LIGHTNING_ROD)
                .criterion(hasItem(modItems.SCULK_MEMBRANE), conditionsFromItem(modItems.SCULK_MEMBRANE))
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.LIGHTNING_ROD), conditionsFromItem(Items.LIGHTNING_ROD))
                .offerTo(exporter, Identifier.of(getRecipeName(modItems.WIRELESS_MICROPHONE)));



        //Sculk-Blue Dyed Items
        offerShapelessRecipe(exporter, modItems.SCULK_BLUE_DYE, modItems.SCULK_MEMBRANE, "sculk", 1);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, modBlocks.SCULK_BLUE_WOOL, 1)
                .input(Ingredient.fromTag(ItemTags.WOOL))
                .input(modItems.SCULK_BLUE_DYE)
                .group("sculk")
                .criterion(hasItem(modItems.SCULK_BLUE_DYE), conditionsFromItem(modItems.SCULK_BLUE_DYE))
                .offerTo(exporter, Identifier.of(getRecipeName(modBlocks.SCULK_BLUE_WOOL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, modBlocks.SCULK_BLUE_CARPET, 3)
                .input('#', modBlocks.SCULK_BLUE_WOOL)
                .pattern("##")
                .group("carpet")
                .criterion(hasItem(modBlocks.SCULK_BLUE_WOOL), conditionsFromItem(modBlocks.SCULK_BLUE_WOOL))
                .offerTo(exporter, getItemPath(modBlocks.SCULK_BLUE_CARPET) + "_dyeing");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, modBlocks.SCULK_BLUE_CARPET, 1)
                .input(Ingredient.fromTag(ItemTags.WOOL_CARPETS))
                .input(modItems.SCULK_BLUE_DYE)
                .group("sculk")
                .criterion(hasItem(modItems.SCULK_BLUE_DYE), conditionsFromItem(modItems.SCULK_BLUE_DYE))
                .offerTo(exporter, Identifier.of(getRecipeName(modBlocks.SCULK_BLUE_CARPET)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, modBlocks.SCULK_BLUE_CONCRETE_POWDER, 8)
                .input(modItems.SCULK_BLUE_DYE)
                .input(Blocks.SAND, 4)
                .input(Blocks.GRAVEL, 4)
                .group("concrete_powder")
                .criterion("has_sand", conditionsFromItem(Blocks.SAND))
                .criterion("has_gravel", conditionsFromItem(Blocks.GRAVEL))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, modBlocks.SCULK_BLUE_TERRACOTTA, 8)
                .input('#', Blocks.TERRACOTTA)
                .input('X', modItems.SCULK_BLUE_DYE)
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .group("stained_terracotta")
                .criterion("has_terracotta", conditionsFromItem(Blocks.TERRACOTTA))
                .offerTo(exporter);

        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(modBlocks.SCULK_BLUE_TERRACOTTA), RecipeCategory.BUILDING_BLOCKS, modBlocks.SCULK_BLUE_GLAZED_TERRACOTTA, 0.1F, 200)
                .criterion(hasItem(modBlocks.SCULK_BLUE_TERRACOTTA), conditionsFromItem(modBlocks.SCULK_BLUE_TERRACOTTA))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, modBlocks.SCULK_BLUE_GLASS, 8)
                .input('#', Blocks.GLASS)
                .input('X', modItems.SCULK_BLUE_DYE)
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .group("stained_glass")
                .criterion("has_glass", conditionsFromItem(Blocks.GLASS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, modBlocks.SCULK_BLUE_GLASS_PANE, 16)
                .input('#', modBlocks.SCULK_BLUE_GLASS)
                .pattern("###")
                .pattern("###")
                .group("stained_glass_pane")
                .criterion("has_glass", conditionsFromItem(modBlocks.SCULK_BLUE_GLASS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, modBlocks.SCULK_BLUE_GLASS_PANE, 8)
                .input('#', Blocks.GLASS_PANE)
                .input('$', modBlocks.SCULK_BLUE_GLASS)
                .pattern("###")
                .pattern("#$#")
                .pattern("###")
                .group("stained_glass_pane")
                .criterion("has_glass_pane", conditionsFromItem(Blocks.GLASS_PANE))
                .criterion(hasItem(modBlocks.SCULK_BLUE_GLASS), conditionsFromItem(modBlocks.SCULK_BLUE_GLASS))
                .offerTo(exporter, convertBetween(modBlocks.SCULK_BLUE_GLASS_PANE, Blocks.GLASS_PANE));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, modBlocks.SCULK_BLUE_CANDLE, 1)
                .input(Ingredient.fromTag(ItemTags.CANDLES))
                .input(modItems.SCULK_BLUE_DYE)
                .group("sculk")
                .criterion(hasItem(modItems.SCULK_BLUE_DYE), conditionsFromItem(modItems.SCULK_BLUE_DYE))
                .offerTo(exporter, Identifier.of(getRecipeName(modBlocks.SCULK_BLUE_CANDLE)));



        //Radio Components
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, modBlocks.ANTENNA, 1)
                .pattern(" L ")
                .pattern("/c/")
                .pattern("ici")
                .input('L', Items.LIGHTNING_ROD)
                .input('/', Items.STICK)
                .input('c', Items.COPPER_INGOT)
                .input('i', Items.IRON_INGOT)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.LIGHTNING_ROD), conditionsFromItem(Items.LIGHTNING_ROD))
                .offerTo(exporter, Identifier.of(getRecipeName(modBlocks.ANTENNA)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, modBlocks.CONDENSER, 1)
                .pattern("CCC")
                .pattern("CsC")
                .pattern("iRi")
                .input('C', Items.COBBLESTONE)
                .input('s', modItems.SCULK_MEMBRANE)
                .input('R', Items.COMPARATOR)
                .input('i', Items.IRON_INGOT)
                .criterion(hasItem(Items.COBBLESTONE), conditionsFromItem(Items.COBBLESTONE))
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(Items.COMPARATOR), conditionsFromItem(Items.COMPARATOR))
                .criterion(hasItem(modItems.SCULK_MEMBRANE), conditionsFromItem(modItems.SCULK_MEMBRANE))
                .offerTo(exporter, Identifier.of(getRecipeName(modBlocks.CONDENSER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, modBlocks.MEDIA_BLOCK, 1)
                .pattern("  n")
                .pattern("PJP")
                .pattern("PsP")
                .input('s', modItems.SCULK_MEMBRANE)
                .input('P', Ingredient.fromTag(ItemTags.PLANKS))
                .input('n', Items.IRON_NUGGET)
                .input('J', Items.JUKEBOX)
                .criterion(hasItem(Items.IRON_NUGGET), conditionsFromItem(Items.IRON_NUGGET))
                .criterion(hasItem(modItems.SCULK_MEMBRANE), conditionsFromItem(modItems.SCULK_MEMBRANE))
                .criterion(hasItem(Items.JUKEBOX), conditionsFromItem(Items.JUKEBOX))
                .offerTo(exporter, Identifier.of(getRecipeName(modBlocks.MEDIA_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, modBlocks.MICROPHONE, 1)
                .pattern(" # ")
                .pattern("gWg")
                .pattern("sss")
                .input('#', modItems.WIRELESS_MICROPHONE)
                .input('g', Items.GOLD_INGOT)
                .input('W', Ingredient.fromTag(ItemTags.WOOL))
                .input('s', Ingredient.fromTag(ItemTags.WOODEN_SLABS))
                .criterion(hasItem(modItems.WIRELESS_MICROPHONE), conditionsFromItem(modItems.WIRELESS_MICROPHONE))
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter, Identifier.of(getRecipeName(modBlocks.MICROPHONE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, modBlocks.MICROPHONE_ARM, 1)
                .pattern(" # ")
                .pattern(" i ")
                .pattern("iii")
                .input('i', Items.IRON_INGOT)
                .input('#', modItems.WIRELESS_MICROPHONE)
                .criterion(hasItem(modItems.WIRELESS_MICROPHONE), conditionsFromItem(modItems.WIRELESS_MICROPHONE))
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, Identifier.of(getRecipeName(modBlocks.MICROPHONE_ARM)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, modBlocks.RADIO, 1)
                .pattern("L  ")
                .pattern("isi")
                .pattern("iii")
                .input('L', Items.LIGHTNING_ROD)
                .input('i', Items.IRON_INGOT)
                .input('s', modItems.SCULK_MEMBRANE)
                .criterion(hasItem(Items.LIGHTNING_ROD), conditionsFromItem(Items.LIGHTNING_ROD))
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(modItems.SCULK_MEMBRANE), conditionsFromItem(modItems.SCULK_MEMBRANE))
                .offerTo(exporter, Identifier.of(getRecipeName(modBlocks.RADIO)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, modBlocks.RECEIVER, 1)
                .pattern("CCC")
                .pattern("sbb")
                .pattern("CCC")
                .input('C', Items.COBBLESTONE)
                .input('b', Items.STONE_BUTTON)
                .input('s', modItems.SCULK_MEMBRANE)
                .criterion(hasItem(Items.COBBLESTONE), conditionsFromItem(Items.COBBLESTONE))
                .criterion(hasItem(Items.STONE_BUTTON), conditionsFromItem(Items.STONE_BUTTON))
                .criterion(hasItem(modItems.SCULK_MEMBRANE), conditionsFromItem(modItems.SCULK_MEMBRANE))
                .offerTo(exporter, Identifier.of(getRecipeName(modBlocks.RECEIVER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, modBlocks.SPEAKER, 1)
                .pattern("iiP")
                .pattern("iss")
                .pattern("iiP")
                .input('P', Ingredient.fromTag(ItemTags.PLANKS))
                .input('i', Items.IRON_INGOT)
                .input('s', modItems.SCULK_MEMBRANE)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(modItems.SCULK_MEMBRANE), conditionsFromItem(modItems.SCULK_MEMBRANE))
                .offerTo(exporter, Identifier.of(getRecipeName(modBlocks.SPEAKER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, modBlocks.WIREHOOK, 3)
                .pattern(" c ")
                .pattern("n n")
                .pattern(" n ")
                .input('n', Items.IRON_NUGGET)
                .input('c', Items.CHAIN)
                .criterion(hasItem(Items.IRON_NUGGET), conditionsFromItem(Items.IRON_NUGGET))
                .criterion(hasItem(Items.CHAIN), conditionsFromItem(Items.CHAIN))
                .offerTo(exporter, Identifier.of(getRecipeName(modBlocks.WIREHOOK)));



        //discs
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, modItems.MUSIC_DISC_WAX, 2)
                .input(modItems.SCULK_MEMBRANE)
                .input(Items.HONEYCOMB)
                .input(Items.BLACK_DYE)
                .group("sculk")
                .criterion(hasItem(modItems.SCULK_MEMBRANE), conditionsFromItem(modItems.SCULK_MEMBRANE))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .criterion(hasItem(Items.BLACK_DYE), conditionsFromItem(Items.BLACK_DYE))
                .offerTo(exporter, Identifier.of(getRecipeName(modBlocks.SCULK_BLUE_CANDLE)));



        //Acoustic Panels Creation
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, modBlocks.BLACK_ACOUSTIC_PANEL, 6)
                .pattern("w  ")
                .pattern("ww ")
                .pattern("w  ")
                .input('w', Items.BLACK_WOOL)
                .criterion(hasItem(Items.BLACK_WOOL), conditionsFromItem(Items.BLACK_WOOL))
                .offerTo(exporter, Identifier.of(getRecipeName(modBlocks.BLACK_ACOUSTIC_PANEL) + "_creation"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, modBlocks.BLUE_ACOUSTIC_PANEL, 6)
                .pattern("w  ")
                .pattern("ww ")
                .pattern("w  ")
                .input('w', Items.BLUE_WOOL)
                .criterion(hasItem(Items.BLUE_WOOL), conditionsFromItem(Items.BLUE_WOOL))
                .offerTo(exporter, Identifier.of(getRecipeName(modBlocks.BLUE_ACOUSTIC_PANEL) + "_creation"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, modBlocks.BROWN_ACOUSTIC_PANEL, 6)
                .pattern("w  ")
                .pattern("ww ")
                .pattern("w  ")
                .input('w', Items.BROWN_WOOL)
                .criterion(hasItem(Items.BROWN_WOOL), conditionsFromItem(Items.BROWN_WOOL))
                .offerTo(exporter, Identifier.of(getRecipeName(modBlocks.BROWN_ACOUSTIC_PANEL) + "_creation"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, modBlocks.CYAN_ACOUSTIC_PANEL, 6)
                .pattern("w  ")
                .pattern("ww ")
                .pattern("w  ")
                .input('w', Items.CYAN_WOOL)
                .criterion(hasItem(Items.CYAN_WOOL), conditionsFromItem(Items.CYAN_WOOL))
                .offerTo(exporter, Identifier.of(getRecipeName(modBlocks.CYAN_ACOUSTIC_PANEL) + "_creation"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, modBlocks.GRAY_ACOUSTIC_PANEL, 6)
                .pattern("w  ")
                .pattern("ww ")
                .pattern("w  ")
                .input('w', Items.GRAY_WOOL)
                .criterion(hasItem(Items.GRAY_WOOL), conditionsFromItem(Items.GRAY_WOOL))
                .offerTo(exporter, Identifier.of(getRecipeName(modBlocks.GRAY_ACOUSTIC_PANEL) + "_creation"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, modBlocks.GREEN_ACOUSTIC_PANEL, 6)
                .pattern("w  ")
                .pattern("ww ")
                .pattern("w  ")
                .input('w', Items.GREEN_WOOL)
                .criterion(hasItem(Items.GREEN_WOOL), conditionsFromItem(Items.GREEN_WOOL))
                .offerTo(exporter, Identifier.of(getRecipeName(modBlocks.GREEN_ACOUSTIC_PANEL) + "_creation"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, modBlocks.LIGHT_BLUE_ACOUSTIC_PANEL, 6)
                .pattern("w  ")
                .pattern("ww ")
                .pattern("w  ")
                .input('w', Items.LIGHT_BLUE_WOOL)
                .criterion(hasItem(Items.LIGHT_BLUE_WOOL), conditionsFromItem(Items.LIGHT_BLUE_WOOL))
                .offerTo(exporter, Identifier.of(getRecipeName(modBlocks.LIGHT_BLUE_ACOUSTIC_PANEL) + "_creation"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, modBlocks.LIGHT_GRAY_ACOUSTIC_PANEL, 6)
                .pattern("w  ")
                .pattern("ww ")
                .pattern("w  ")
                .input('w', Items.LIGHT_GRAY_WOOL)
                .criterion(hasItem(Items.LIGHT_GRAY_WOOL), conditionsFromItem(Items.LIGHT_GRAY_WOOL))
                .offerTo(exporter, Identifier.of(getRecipeName(modBlocks.LIGHT_GRAY_ACOUSTIC_PANEL) + "_creation"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, modBlocks.LIME_ACOUSTIC_PANEL, 6)
                .pattern("w  ")
                .pattern("ww ")
                .pattern("w  ")
                .input('w', Items.LIME_WOOL)
                .criterion(hasItem(Items.LIME_WOOL), conditionsFromItem(Items.LIME_WOOL))
                .offerTo(exporter, Identifier.of(getRecipeName(modBlocks.LIME_ACOUSTIC_PANEL) + "_creation"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, modBlocks.MAGENTA_ACOUSTIC_PANEL, 6)
                .pattern("w  ")
                .pattern("ww ")
                .pattern("w  ")
                .input('w', Items.MAGENTA_WOOL)
                .criterion(hasItem(Items.MAGENTA_WOOL), conditionsFromItem(Items.MAGENTA_WOOL))
                .offerTo(exporter, Identifier.of(getRecipeName(modBlocks.MAGENTA_ACOUSTIC_PANEL) + "_creation"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, modBlocks.ORANGE_ACOUSTIC_PANEL, 6)
                .pattern("w  ")
                .pattern("ww ")
                .pattern("w  ")
                .input('w', Items.ORANGE_WOOL)
                .criterion(hasItem(Items.ORANGE_WOOL), conditionsFromItem(Items.ORANGE_WOOL))
                .offerTo(exporter, Identifier.of(getRecipeName(modBlocks.ORANGE_ACOUSTIC_PANEL) + "_creation"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, modBlocks.PINK_ACOUSTIC_PANEL, 6)
                .pattern("w  ")
                .pattern("ww ")
                .pattern("w  ")
                .input('w', Items.PINK_WOOL)
                .criterion(hasItem(Items.PINK_WOOL), conditionsFromItem(Items.PINK_WOOL))
                .offerTo(exporter, Identifier.of(getRecipeName(modBlocks.PINK_ACOUSTIC_PANEL) + "_creation"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, modBlocks.PURPLE_ACOUSTIC_PANEL, 6)
                .pattern("w  ")
                .pattern("ww ")
                .pattern("w  ")
                .input('w', Items.PURPLE_WOOL)
                .criterion(hasItem(Items.PURPLE_WOOL), conditionsFromItem(Items.PURPLE_WOOL))
                .offerTo(exporter, Identifier.of(getRecipeName(modBlocks.PURPLE_ACOUSTIC_PANEL) + "_creation"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, modBlocks.RED_ACOUSTIC_PANEL, 6)
                .pattern("w  ")
                .pattern("ww ")
                .pattern("w  ")
                .input('w', Items.RED_WOOL)
                .criterion(hasItem(Items.RED_WOOL), conditionsFromItem(Items.RED_WOOL))
                .offerTo(exporter, Identifier.of(getRecipeName(modBlocks.RED_ACOUSTIC_PANEL) + "_creation"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, modBlocks.WHITE_ACOUSTIC_PANEL, 6)
                .pattern("w  ")
                .pattern("ww ")
                .pattern("w  ")
                .input('w', Items.WHITE_WOOL)
                .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                .offerTo(exporter, Identifier.of(getRecipeName(modBlocks.WHITE_ACOUSTIC_PANEL) + "_creation"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, modBlocks.YELLOW_ACOUSTIC_PANEL, 6)
                .pattern("w  ")
                .pattern("ww ")
                .pattern("w  ")
                .input('w', Items.YELLOW_WOOL)
                .criterion(hasItem(Items.YELLOW_WOOL), conditionsFromItem(Items.YELLOW_WOOL))
                .offerTo(exporter, Identifier.of(getRecipeName(modBlocks.YELLOW_ACOUSTIC_PANEL) + "_creation"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, modBlocks.SCULK_BLUE_ACOUSTIC_PANEL, 6)
                .pattern("w  ")
                .pattern("ww ")
                .pattern("w  ")
                .input('w', modBlocks.SCULK_BLUE_WOOL)
                .criterion(hasItem(modBlocks.SCULK_BLUE_WOOL), conditionsFromItem(modBlocks.SCULK_BLUE_WOOL))
                .offerTo(exporter, Identifier.of(getRecipeName(modBlocks.SCULK_BLUE_ACOUSTIC_PANEL) + "_creation"));



        //Wires
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, modItems.YELLOW_WIRE, 8)
                .pattern("www")
                .pattern("wDw")
                .pattern("www")
                .input('w', Items.HONEYCOMB)
                .input('D', Items.COPPER_INGOT)
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, Identifier.of(getRecipeName(modItems.YELLOW_WIRE) + "_creation"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, modItems.BLACK_WIRE, 8)
                .pattern("www")
                .pattern("wDw")
                .pattern("www")
                .input('w', Ingredient.fromTag(ModTags.Items.WIRE))
                .input('D', Items.BLACK_DYE)
                .criterion(hasItem(modItems.YELLOW_WIRE), conditionsFromItem(modItems.YELLOW_WIRE))
                .criterion(hasItem(Items.BLACK_DYE), conditionsFromItem(Items.BLACK_DYE))
                .offerTo(exporter, Identifier.of(getRecipeName(modItems.BLACK_WIRE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, modItems.BLUE_WIRE, 8)
                .pattern("www")
                .pattern("wDw")
                .pattern("www")
                .input('w', Ingredient.fromTag(ModTags.Items.WIRE))
                .input('D', Items.BLUE_DYE)
                .criterion(hasItem(modItems.YELLOW_WIRE), conditionsFromItem(modItems.YELLOW_WIRE))
                .criterion(hasItem(Items.BLUE_DYE), conditionsFromItem(Items.BLUE_DYE))
                .offerTo(exporter, Identifier.of(getRecipeName(modItems.BLUE_WIRE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, modItems.BROWN_WIRE, 8)
                .pattern("www")
                .pattern("wDw")
                .pattern("www")
                .input('w', Ingredient.fromTag(ModTags.Items.WIRE))
                .input('D', Items.BROWN_DYE)
                .criterion(hasItem(modItems.YELLOW_WIRE), conditionsFromItem(modItems.YELLOW_WIRE))
                .criterion(hasItem(Items.BROWN_DYE), conditionsFromItem(Items.BROWN_DYE))
                .offerTo(exporter, Identifier.of(getRecipeName(modItems.BROWN_WIRE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, modItems.CYAN_WIRE, 8)
                .pattern("www")
                .pattern("wDw")
                .pattern("www")
                .input('w', Ingredient.fromTag(ModTags.Items.WIRE))
                .input('D', Items.CYAN_DYE)
                .criterion(hasItem(modItems.YELLOW_WIRE), conditionsFromItem(modItems.YELLOW_WIRE))
                .criterion(hasItem(Items.CYAN_DYE), conditionsFromItem(Items.CYAN_DYE))
                .offerTo(exporter, Identifier.of(getRecipeName(modItems.CYAN_WIRE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, modItems.GRAY_WIRE, 8)
                .pattern("www")
                .pattern("wDw")
                .pattern("www")
                .input('w', Ingredient.fromTag(ModTags.Items.WIRE))
                .input('D', Items.GRAY_DYE)
                .criterion(hasItem(modItems.YELLOW_WIRE), conditionsFromItem(modItems.YELLOW_WIRE))
                .criterion(hasItem(Items.GRAY_DYE), conditionsFromItem(Items.GRAY_DYE))
                .offerTo(exporter, Identifier.of(getRecipeName(modItems.GRAY_WIRE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, modItems.GRAY_WIRE, 8)
                .pattern("www")
                .pattern("wDw")
                .pattern("www")
                .input('w', Ingredient.fromTag(ModTags.Items.WIRE))
                .input('D', Items.GREEN_DYE)
                .criterion(hasItem(modItems.YELLOW_WIRE), conditionsFromItem(modItems.YELLOW_WIRE))
                .criterion(hasItem(Items.GREEN_DYE), conditionsFromItem(Items.GREEN_DYE))
                .offerTo(exporter, Identifier.of(getRecipeName(modItems.GREEN_WIRE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, modItems.SKY_WIRE, 8)
                .pattern("www")
                .pattern("wDw")
                .pattern("www")
                .input('w', Ingredient.fromTag(ModTags.Items.WIRE))
                .input('D', Items.LIGHT_BLUE_DYE)
                .criterion(hasItem(modItems.YELLOW_WIRE), conditionsFromItem(modItems.YELLOW_WIRE))
                .criterion(hasItem(Items.LIGHT_BLUE_DYE), conditionsFromItem(Items.LIGHT_BLUE_DYE))
                .offerTo(exporter, Identifier.of(getRecipeName(modItems.SKY_WIRE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, modItems.LIGHT_GRAY_WIRE, 8)
                .pattern("www")
                .pattern("wDw")
                .pattern("www")
                .input('w', Ingredient.fromTag(ModTags.Items.WIRE))
                .input('D', Items.LIGHT_GRAY_DYE)
                .criterion(hasItem(modItems.YELLOW_WIRE), conditionsFromItem(modItems.YELLOW_WIRE))
                .criterion(hasItem(Items.LIGHT_GRAY_DYE), conditionsFromItem(Items.LIGHT_GRAY_DYE))
                .offerTo(exporter, Identifier.of(getRecipeName(modItems.LIGHT_GRAY_WIRE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, modItems.LIME_WIRE, 8)
                .pattern("www")
                .pattern("wDw")
                .pattern("www")
                .input('w', Ingredient.fromTag(ModTags.Items.WIRE))
                .input('D', Items.LIME_DYE)
                .criterion(hasItem(modItems.YELLOW_WIRE), conditionsFromItem(modItems.YELLOW_WIRE))
                .criterion(hasItem(Items.LIME_DYE), conditionsFromItem(Items.LIME_DYE))
                .offerTo(exporter, Identifier.of(getRecipeName(modItems.LIME_WIRE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, modItems.MAGENTA_WIRE, 8)
                .pattern("www")
                .pattern("wDw")
                .pattern("www")
                .input('w', Ingredient.fromTag(ModTags.Items.WIRE))
                .input('D', Items.MAGENTA_DYE)
                .criterion(hasItem(modItems.YELLOW_WIRE), conditionsFromItem(modItems.YELLOW_WIRE))
                .criterion(hasItem(Items.MAGENTA_DYE), conditionsFromItem(Items.MAGENTA_DYE))
                .offerTo(exporter, Identifier.of(getRecipeName(modItems.MAGENTA_WIRE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, modItems.ORANGE_WIRE, 8)
                .pattern("www")
                .pattern("wDw")
                .pattern("www")
                .input('w', Ingredient.fromTag(ModTags.Items.WIRE))
                .input('D', Items.ORANGE_DYE)
                .criterion(hasItem(modItems.YELLOW_WIRE), conditionsFromItem(modItems.YELLOW_WIRE))
                .criterion(hasItem(Items.ORANGE_DYE), conditionsFromItem(Items.ORANGE_DYE))
                .offerTo(exporter, Identifier.of(getRecipeName(modItems.ORANGE_WIRE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, modItems.PINK_WIRE, 8)
                .pattern("www")
                .pattern("wDw")
                .pattern("www")
                .input('w', Ingredient.fromTag(ModTags.Items.WIRE))
                .input('D', Items.PINK_DYE)
                .criterion(hasItem(modItems.YELLOW_WIRE), conditionsFromItem(modItems.YELLOW_WIRE))
                .criterion(hasItem(Items.PINK_DYE), conditionsFromItem(Items.PINK_DYE))
                .offerTo(exporter, Identifier.of(getRecipeName(modItems.PINK_WIRE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, modItems.PURPLE_WIRE, 8)
                .pattern("www")
                .pattern("wDw")
                .pattern("www")
                .input('w', Ingredient.fromTag(ModTags.Items.WIRE))
                .input('D', Items.PURPLE_DYE)
                .criterion(hasItem(modItems.YELLOW_WIRE), conditionsFromItem(modItems.YELLOW_WIRE))
                .criterion(hasItem(Items.PURPLE_DYE), conditionsFromItem(Items.PURPLE_DYE))
                .offerTo(exporter, Identifier.of(getRecipeName(modItems.PURPLE_WIRE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, modItems.RED_WIRE, 8)
                .pattern("www")
                .pattern("wDw")
                .pattern("www")
                .input('w', Ingredient.fromTag(ModTags.Items.WIRE))
                .input('D', Items.RED_DYE)
                .criterion(hasItem(modItems.YELLOW_WIRE), conditionsFromItem(modItems.YELLOW_WIRE))
                .criterion(hasItem(Items.RED_DYE), conditionsFromItem(Items.RED_DYE))
                .offerTo(exporter, Identifier.of(getRecipeName(modItems.RED_WIRE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, modItems.WHITE_WIRE, 8)
                .pattern("www")
                .pattern("wDw")
                .pattern("www")
                .input('w', Ingredient.fromTag(ModTags.Items.WIRE))
                .input('D', Items.WHITE_DYE)
                .criterion(hasItem(modItems.YELLOW_WIRE), conditionsFromItem(modItems.YELLOW_WIRE))
                .criterion(hasItem(Items.WHITE_DYE), conditionsFromItem(Items.WHITE_DYE))
                .offerTo(exporter, Identifier.of(getRecipeName(modItems.WHITE_WIRE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, modItems.YELLOW_WIRE, 8)
                .pattern("www")
                .pattern("wDw")
                .pattern("www")
                .input('w', Ingredient.fromTag(ModTags.Items.WIRE))
                .input('D', Items.YELLOW_DYE)
                .criterion(hasItem(modItems.YELLOW_WIRE), conditionsFromItem(modItems.YELLOW_WIRE))
                .criterion(hasItem(Items.YELLOW_DYE), conditionsFromItem(Items.YELLOW_DYE))
                .offerTo(exporter, Identifier.of(getRecipeName(modItems.YELLOW_WIRE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, modItems.SCULK_BLUE_WIRE, 8)
                .pattern("www")
                .pattern("wDw")
                .pattern("www")
                .input('w', Ingredient.fromTag(ModTags.Items.WIRE))
                .input('D', modItems.SCULK_BLUE_DYE)
                .criterion(hasItem(modItems.YELLOW_WIRE), conditionsFromItem(modItems.YELLOW_WIRE))
                .criterion(hasItem(modItems.SCULK_BLUE_DYE), conditionsFromItem(modItems.SCULK_BLUE_DYE))
                .offerTo(exporter, Identifier.of(getRecipeName(modItems.SCULK_BLUE_WIRE)));
    }
}
