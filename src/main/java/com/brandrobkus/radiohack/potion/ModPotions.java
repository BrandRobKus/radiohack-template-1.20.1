package com.brandrobkus.radiohack.potion;

import com.brandrobkus.radiohack.RadioHack;
import com.brandrobkus.radiohack.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static final Potion TINNITUS_POTION = registerPotion("tinnitus_potion",
            new Potion(new StatusEffectInstance(ModEffects.TINNITUS, 1200, 0)));

    private static Potion registerPotion(String name, Potion potion) {
        return Registry.register(Registries.POTION, Identifier.of(RadioHack.MOD_ID, name), potion);
    }



    public static void registerPotions() {
        RadioHack.LOGGER.info("Registering Mod Potions for " + RadioHack.MOD_ID);
    }
}
