package com.hello_there.rotp_pw;

import com.hello_there.rotp_pw.init.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(PlanetWavesAddon.MOD_ID)
public class PlanetWavesAddon {

    public static final String MOD_ID = "rotp_pw";
    public static final Logger LOGGER = LogManager.getLogger();

    public PlanetWavesAddon() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        InitEntities.ENTITIES.register(modEventBus);
        InitSounds.SOUNDS.register(modEventBus);
        InitStands.ACTIONS.register(modEventBus);
        InitStands.STANDS.register(modEventBus);
        InitEffects.EFFECTS.register(modEventBus);
    }
}
