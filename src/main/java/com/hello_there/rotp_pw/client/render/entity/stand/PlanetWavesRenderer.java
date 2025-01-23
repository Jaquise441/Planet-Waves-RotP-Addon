package com.hello_there.rotp_pw.client.render.entity.stand;

import com.github.standobyte.jojo.client.render.entity.model.stand.StandEntityModel;
import com.github.standobyte.jojo.client.render.entity.model.stand.StandModelRegistry;
import com.github.standobyte.jojo.client.render.entity.renderer.stand.StandEntityRenderer;

import com.hello_there.rotp_pw.PlanetWavesAddon;
import com.hello_there.rotp_pw.entity.PlanetWavesEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class PlanetWavesRenderer extends StandEntityRenderer<PlanetWavesEntity, StandEntityModel<PlanetWavesEntity>> {
    
    public PlanetWavesRenderer(EntityRendererManager renderManager) {
        super(renderManager, 
                StandModelRegistry.registerModel(new ResourceLocation(PlanetWavesAddon.MOD_ID, "pw"), PlanetWavesModel::new),
                new ResourceLocation(PlanetWavesAddon.MOD_ID, "textures/entity/stand/pw.png"), 0);
    }
}
