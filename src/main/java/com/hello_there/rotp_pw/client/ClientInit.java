package com.hello_there.rotp_pw.client;

import com.hello_there.rotp_pw.PlanetWavesAddon;
import com.hello_there.rotp_pw.client.render.entity.stand.PlanetWavesRenderer;
import com.hello_there.rotp_pw.init.InitEntities;
import com.hello_there.rotp_pw.init.InitStands;
import com.hello_there.rotp_pw.client.render.entity.MeteoriteRenderer;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = PlanetWavesAddon.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientInit {

    @SubscribeEvent
    public static void onFMLClientSetup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(
                InitStands.PLANET_WAVES.getEntityType(), PlanetWavesRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(InitEntities.METEORITE.get(), MeteoriteRenderer::new);

    }
}