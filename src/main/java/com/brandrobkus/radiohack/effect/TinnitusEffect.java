package com.brandrobkus.radiohack.effect;

import com.brandrobkus.radiohack.sound.ModSounds;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class TinnitusEffect extends StatusEffect {
    public TinnitusEffect() {
        super(
                StatusEffectCategory.NEUTRAL,
                0xcdd1ab
        );
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int interval = 30 >> amplifier;
        return duration == 1 || duration % interval == 0;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity player) {
            if (player.getWorld().isClient) {
                player.playSound(ModSounds.TINNITUS, 1f, 1f);
            }
        }
    }
}
