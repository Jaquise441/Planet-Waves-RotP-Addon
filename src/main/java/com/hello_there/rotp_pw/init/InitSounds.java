package com.hello_there.rotp_pw.init;

import java.util.function.Supplier;

import com.github.standobyte.jojo.init.ModSounds;
import com.github.standobyte.jojo.util.mc.OstSoundList;

import com.hello_there.rotp_pw.PlanetWavesAddon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(
            ForgeRegistries.SOUND_EVENTS, PlanetWavesAddon.MOD_ID); // TODO sounds.json
    
    public static final RegistryObject<SoundEvent> PLANET_WAVES_SUMMON_VOICELINE = SOUNDS.register("viviano_westwood_planet_waves",
            () -> new SoundEvent(new ResourceLocation(PlanetWavesAddon.MOD_ID, "viviano_westwood_planet_waves")));

    public static final Supplier<SoundEvent> PLANET_WAVES_SUMMON_SOUND = ModSounds.STAND_SUMMON_DEFAULT;
    
    public static final Supplier<SoundEvent> PLANET_WAVES_UNSUMMON_SOUND =  ModSounds.STAND_UNSUMMON_DEFAULT;
    
    public static final Supplier<SoundEvent> PLANET_WAVES_PUNCH_LIGHT = ModSounds.STAND_PUNCH_LIGHT;
    
    public static final Supplier<SoundEvent> PLANET_WAVES_PUNCH_HEAVY = ModSounds.STAND_PUNCH_HEAVY;

    public static final RegistryObject<SoundEvent> PLANET_WAVES_METEORITE_SUMMON = SOUNDS.register("planet_waves_meteorite_summon",
            () -> new SoundEvent(new ResourceLocation(PlanetWavesAddon.MOD_ID, "planet_waves_meteorite_summon")));

    public static final RegistryObject<SoundEvent> PLANET_WAVES_GRAB = SOUNDS.register("planet_waves_grab",
            () -> new SoundEvent(new ResourceLocation(PlanetWavesAddon.MOD_ID, "planet_waves_grab")));


    public static final OstSoundList PLANET_WAVES_OST = new OstSoundList(
            new ResourceLocation(PlanetWavesAddon.MOD_ID, "planet_waves_ost"), SOUNDS);
}
