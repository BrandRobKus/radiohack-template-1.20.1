package com.brandrobkus.radiohack.effect;

import com.brandrobkus.radiohack.RadioHack;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {

    public static final RegistryEntry<StatusEffect> TINNITUS = registerStatusEffect("tinnitus",
            new TinnitusEffect());


    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(RadioHack.MOD_ID, name), statusEffect);
    }

    public static void registerEffects(){
        RadioHack.LOGGER.info("Registering Mod Effects for " + RadioHack.MOD_ID);
    }
}
