package com.hello_there.rotp_pw.client.render.entity;

import com.hello_there.rotp_pw.entity.MeteoriteEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;

public class MeteoriteRenderer extends EntityRenderer<MeteoriteEntity> {
    private static final ItemStack FIRE_CHARGE = new ItemStack(Items.FIRE_CHARGE);

    public MeteoriteRenderer(EntityRendererManager renderManager) {
        super(renderManager);
    }

    @Override
    public void render(MeteoriteEntity entity, float entityYaw, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int packedLight) {
        matrixStack.pushPose();

        matrixStack.mulPose(this.entityRenderDispatcher.cameraOrientation());

        float size = (float) entity.getSize();
        matrixStack.scale(size, size, size);

        Minecraft.getInstance().getItemRenderer().renderStatic(
                FIRE_CHARGE,
                ItemCameraTransforms.TransformType.GROUND,
                packedLight,
                0,
                matrixStack,
                buffer
        );

        matrixStack.popPose();
        super.render(entity, entityYaw, partialTicks, matrixStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(MeteoriteEntity entity) {
        return null;
    }
}
