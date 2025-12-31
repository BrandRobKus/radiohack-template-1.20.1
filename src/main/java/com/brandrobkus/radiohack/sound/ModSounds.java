package com.brandrobkus.radiohack.sound;

import com.brandrobkus.radiohack.RadioHack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static final SoundEvent RADIO_PLAYS_MUSIC = registerSoundEvent("radio_plays_music");
    public static final SoundEvent TINNITUS = registerSoundEvent("tinnitus_effect");


    private static SoundEvent registerSoundEvent(String name){
        Identifier id = new Identifier(RadioHack.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds(){
        RadioHack.LOGGER.info("Registering Sounds for " + RadioHack.MOD_ID);
    }
}
