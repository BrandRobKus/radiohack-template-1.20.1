package com.brandrobkus.radiohack;

import com.brandrobkus.radiohack.block.modBlocks;
import com.brandrobkus.radiohack.item.modItemGroups;
import com.brandrobkus.radiohack.item.modItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RadioHack implements ModInitializer {
	public static final String MOD_ID = "radiohack";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		modItemGroups.registerItemGroups();
		modItems.registerModItems();
		modBlocks.registerModBlocks();
	}
}