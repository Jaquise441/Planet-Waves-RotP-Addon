package com.hello_there.rotp_pw.effects;

import com.github.standobyte.jojo.potion.UncurableEffect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectType;

public class TrueBlindnessEffect extends UncurableEffect {
    public TrueBlindnessEffect(int color) {
        super(EffectType.HARMFUL, color);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level.isClientSide()) {
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
