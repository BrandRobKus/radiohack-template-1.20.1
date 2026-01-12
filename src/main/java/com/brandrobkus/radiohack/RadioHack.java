package com.brandrobkus.radiohack;

import com.brandrobkus.radiohack.block.modBlocks;
import com.brandrobkus.radiohack.effect.ModEffects;
import com.brandrobkus.radiohack.item.modItemGroups;
import com.brandrobkus.radiohack.item.modItems;
import com.brandrobkus.radiohack.potion.ModPotions;
import com.brandrobkus.radiohack.sound.ModSounds;
import com.brandrobkus.radiohack.util.ModTags;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RadioHack implements ModInitializer {
	public static final String MOD_ID = "radiohack";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// Define the sound identifier and sound event
	public static final Identifier MICROPHONE_HIT_ID = new Identifier(MOD_ID, "microphone_hit");
	public static final SoundEvent MICROPHONE_HIT = SoundEvent.of(MICROPHONE_HIT_ID);

	@Override
	public void onInitialize() {


		registerSounds();
		modItemGroups.registerItemGroups();
		modItems.registerModItems();
		modBlocks.registerModBlocks();
		ModSounds.registerSounds();
		ModEffects.registerEffects();
		ModPotions.registerPotions();

		FlammableBlockRegistry.getDefaultInstance().add(modBlocks.SCULK_BLUE_WOOL,60,30);
		FlammableBlockRegistry.getDefaultInstance().add(modBlocks.SCULK_BLUE_CARPET,60,30);
		FlammableBlockRegistry.getDefaultInstance().add(ModTags.Blocks.ACOUSTIC_PANEL,60,30);

		LOGGER.info("RadioHack initialized!");

	}

	public static void registerSounds() {
		Registry.register(Registries.SOUND_EVENT, MICROPHONE_HIT_ID, MICROPHONE_HIT);
	}
}
