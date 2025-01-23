package com.hello_there.rotp_pw.client.render;

import com.hello_there.rotp_pw.init.InitEffects;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = "rotp_cream")
public class TrueBlindnessRenderer {

    @SubscribeEvent
    public static void onRenderGameOverlay(RenderGameOverlayEvent.Pre event) {
        Minecraft mc = Minecraft.getInstance();

        if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
            if (mc.player != null && mc.player.hasEffect(InitEffects.TRUE_BLINDNESS.get())) {
                RenderSystem.disableDepthTest();
                RenderSystem.color4f(0.0F, 0.0F, 0.0F, 1.0F);
                AbstractGui.fill(event.getMatrixStack(), 0, 0, mc.getWindow().getGuiScaledWidth(), mc.getWindow().getGuiScaledHeight(), 0xFF000000);
                RenderSystem.enableDepthTest();
            }
        }
    }
}
