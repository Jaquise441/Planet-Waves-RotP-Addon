package com.hello_there.rotp_pw.init;

import com.hello_there.rotp_pw.PlanetWavesAddon;
import com.hello_there.rotp_pw.effects.TrueBlindnessEffect;
import net.minecraft.potion.Effect;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitEffects {
    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(
            ForgeRegistries.POTIONS,
            PlanetWavesAddon.MOD_ID
    );

    public static final RegistryObject<Effect> TRUE_BLINDNESS = EFFECTS.register("true_blindness",
            () -> new TrueBlindnessEffect(0xc7615a)
    );
}