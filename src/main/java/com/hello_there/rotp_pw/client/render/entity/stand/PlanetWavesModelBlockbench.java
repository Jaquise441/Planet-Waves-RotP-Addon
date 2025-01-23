package com.hello_there.rotp_pw.client.render.entity.stand;


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class PlanetWavesModelBlockbench extends EntityModel<Entity> {
    private final ModelRenderer head;
    private final ModelRenderer eyes;
    private final ModelRenderer head_pieces;
    private final ModelRenderer forehead_tube_piece_r1;
    private final ModelRenderer head_pipe_r1;
    private final ModelRenderer head_piece4_r1;
    private final ModelRenderer head_piece2_r1;
    private final ModelRenderer head_piece_r1;
    private final ModelRenderer head_pipe2_r1;
    private final ModelRenderer body;
    private final ModelRenderer upperPart;
    private final ModelRenderer torso;
    private final ModelRenderer pelvisl_r1;
    private final ModelRenderer pelvis_r1;
    private final ModelRenderer leftArm;
    private final ModelRenderer leftArmJoint;
    private final ModelRenderer leftForeArm;
    private final ModelRenderer rightArm;
    private final ModelRenderer rightArmJoint;
    private final ModelRenderer rightForeArm;
    private final ModelRenderer leftLeg;
    private final ModelRenderer leftLegJoint;
    private final ModelRenderer leftLowerLeg;
    private final ModelRenderer rightLeg;
    private final ModelRenderer rightLegJoint;
    private final ModelRenderer rightLowerLeg;

    public PlanetWavesModelBlockbench() {
        texWidth = 128;
        texHeight = 128;

        head = new ModelRenderer(this);
        head.setPos(0.0F, 0.0F, 0.0F);
        head.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
        head.texOffs(64, 50).addBox(-4.75F, -5.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        head.texOffs(64, 54).addBox(2.75F, -5.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        head.texOffs(46, 28).addBox(-1.0F, -0.75F, -4.25F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        eyes = new ModelRenderer(this);
        eyes.setPos(2.0F, -4.0F, -3.25F);
        head.addChild(eyes);
        eyes.texOffs(46, 30).addBox(-5.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        eyes.texOffs(66, 24).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

        head_pieces = new ModelRenderer(this);
        head_pieces.setPos(-0.25F, -3.0F, 4.5F);
        head.addChild(head_pieces);
        head_pieces.texOffs(48, 14).addBox(-2.25F, -5.25F, -7.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        head_pieces.texOffs(46, 25).addBox(-2.25F, -4.0F, -8.75F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        head_pieces.texOffs(8, 64).addBox(-1.2F, -1.55F, -1.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

        forehead_tube_piece_r1 = new ModelRenderer(this);
        forehead_tube_piece_r1.setPos(0.25F, -2.5F, -7.75F);
        head_pieces.addChild(forehead_tube_piece_r1);
        setRotationAngle(forehead_tube_piece_r1, 0.0F, 0.0F, -0.7854F);
        forehead_tube_piece_r1.texOffs(66, 20).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

        head_pipe_r1 = new ModelRenderer(this);
        head_pipe_r1.setPos(0.75F, -5.75F, -7.75F);
        head_pieces.addChild(head_pipe_r1);
        setRotationAngle(head_pipe_r1, 0.0F, 0.0F, -0.2182F);
        head_pipe_r1.texOffs(48, 10).addBox(-1.0F, -2.0F, -1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        head_piece4_r1 = new ModelRenderer(this);
        head_piece4_r1.setPos(0.75F, -4.1F, -1.0F);
        head_pieces.addChild(head_piece4_r1);
        setRotationAngle(head_piece4_r1, -0.0436F, 0.0015F, 0.3403F);
        head_piece4_r1.texOffs(22, 62).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

        head_piece2_r1 = new ModelRenderer(this);
        head_piece2_r1.setPos(1.25F, -5.6F, -4.25F);
        head_pieces.addChild(head_piece2_r1);
        setRotationAngle(head_piece2_r1, -1.7016F, 0.0057F, 0.3487F);
        head_piece2_r1.texOffs(56, 57).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);

        head_piece_r1 = new ModelRenderer(this);
        head_piece_r1.setPos(1.0F, -5.0F, -8.0F);
        head_pieces.addChild(head_piece_r1);
        setRotationAngle(head_piece_r1, 0.0F, 0.0F, 0.3403F);
        head_piece_r1.texOffs(14, 62).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

        head_pipe2_r1 = new ModelRenderer(this);
        head_pipe2_r1.setPos(2.5F, -5.0F, -2.75F);
        head_pieces.addChild(head_pipe2_r1);
        setRotationAngle(head_pipe2_r1, 0.0F, 0.0F, 0.6981F);
        head_pipe2_r1.texOffs(54, 66).addBox(-1.0F, -2.0F, -1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setPos(0.0F, 0.0F, 0.0F);


        upperPart = new ModelRenderer(this);
        upperPart.setPos(0.0F, 12.0F, 0.0F);
        body.addChild(upperPart);


        torso = new ModelRenderer(this);
        torso.setPos(0.0F, -12.0F, 0.0F);
        upperPart.addChild(torso);
        torso.texOffs(0, 26).addBox(-3.0F, 0.0F, -2.0F, 6.0F, 11.0F, 4.0F, 0.0F, false);
        torso.texOffs(0, 118).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 4.0F, 6.0F, 0.0F, false);
        torso.texOffs(28, 16).addBox(-3.5F, 1.75F, -2.5F, 7.0F, 4.0F, 5.0F, 0.0F, false);
        torso.texOffs(32, 0).addBox(-2.5F, 4.0F, -2.25F, 5.0F, 6.0F, 4.0F, 0.0F, false);
        torso.texOffs(52, 20).addBox(-1.5F, 4.0F, -1.75F, 3.0F, 6.0F, 4.0F, 0.0F, false);
        torso.texOffs(20, 26).addBox(-4.0F, 10.0F, -2.5F, 8.0F, 2.0F, 5.0F, 0.0F, false);

        pelvisl_r1 = new ModelRenderer(this);
        pelvisl_r1.setPos(0.0F, 11.0F, 0.0F);
        torso.addChild(pelvisl_r1);
        setRotationAngle(pelvisl_r1, 0.0F, 0.0F, 2.6616F);
        pelvisl_r1.texOffs(32, 52).addBox(-4.0F, -1.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);

        pelvis_r1 = new ModelRenderer(this);
        pelvis_r1.setPos(-4.0F, 10.05F, 0.0F);
        torso.addChild(pelvis_r1);
        setRotationAngle(pelvis_r1, 0.0F, 0.0F, 0.48F);
        pelvis_r1.texOffs(48, 52).addBox(-0.0472F, -1.021F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);

        leftArm = new ModelRenderer(this);
        leftArm.setPos(6.0F, -10.0F, 0.0F);
        upperPart.addChild(leftArm);
        leftArm.texOffs(20, 33).addBox(-1.5F, -2.5F, -2.5F, 4.0F, 4.0F, 5.0F, 0.0F, false);
        leftArm.texOffs(0, 41).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

        leftArmJoint = new ModelRenderer(this);
        leftArmJoint.setPos(0.0F, 4.0F, 0.0F);
        leftArm.addChild(leftArmJoint);
        leftArmJoint.texOffs(56, 30).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, -0.1F, false);
        leftArmJoint.texOffs(38, 63).addBox(-1.0F, -1.0F, 0.25F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        leftArmJoint.texOffs(46, 63).addBox(-1.0F, -1.0F, -2.25F, 2.0F, 2.0F, 2.0F, 0.0F, false);

        leftForeArm = new ModelRenderer(this);
        leftForeArm.setPos(0.0F, 4.0F, 0.0F);
        leftArm.addChild(leftForeArm);
        leftForeArm.texOffs(0, 90).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
        leftForeArm.texOffs(30, 63).addBox(1.25F, 4.5F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);

        rightArm = new ModelRenderer(this);
        rightArm.setPos(-6.0F, -10.0F, 0.0F);
        upperPart.addChild(rightArm);
        rightArm.texOffs(38, 33).addBox(-2.5F, -2.5F, -2.5F, 4.0F, 4.0F, 5.0F, 0.0F, false);
        rightArm.texOffs(32, 42).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

        rightArmJoint = new ModelRenderer(this);
        rightArmJoint.setPos(0.0F, 4.0F, 0.0F);
        rightArm.addChild(rightArmJoint);
        rightArmJoint.texOffs(56, 36).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, -0.1F, false);
        rightArmJoint.texOffs(0, 64).addBox(-1.0F, -1.0F, 0.25F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        rightArmJoint.texOffs(64, 42).addBox(-1.0F, -1.0F, -2.25F, 2.0F, 2.0F, 2.0F, 0.0F, false);

        rightForeArm = new ModelRenderer(this);
        rightForeArm.setPos(0.0F, 4.0F, 0.0F);
        rightArm.addChild(rightForeArm);
        rightForeArm.texOffs(0, 74).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
        rightForeArm.texOffs(64, 46).addBox(-2.25F, 4.5F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);

        leftLeg = new ModelRenderer(this);
        leftLeg.setPos(1.9F, 12.0F, 0.0F);
        body.addChild(leftLeg);
        leftLeg.texOffs(50, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

        leftLegJoint = new ModelRenderer(this);
        leftLegJoint.setPos(0.0F, 6.0F, 0.0F);
        leftLeg.addChild(leftLegJoint);
        leftLegJoint.texOffs(32, 57).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, -0.1F, false);
        leftLegJoint.texOffs(64, 58).addBox(-1.0F, -1.0F, -2.25F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        leftLegJoint.texOffs(64, 62).addBox(-1.0F, -1.0F, 0.25F, 2.0F, 2.0F, 2.0F, 0.0F, false);

        leftLowerLeg = new ModelRenderer(this);
        leftLowerLeg.setPos(0.0F, 6.0F, 0.0F);
        leftLeg.addChild(leftLowerLeg);
        leftLowerLeg.texOffs(0, 51).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, -0.001F, false);
        leftLowerLeg.texOffs(66, 8).addBox(0.5F, 3.5F, -0.25F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        leftLowerLeg.texOffs(66, 8).addBox(-2.5F, 3.5F, -0.25F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        rightLeg = new ModelRenderer(this);
        rightLeg.setPos(-1.9F, 12.0F, 0.0F);
        body.addChild(rightLeg);
        rightLeg.texOffs(52, 10).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

        rightLegJoint = new ModelRenderer(this);
        rightLegJoint.setPos(0.0F, 6.0F, 0.0F);
        rightLeg.addChild(rightLegJoint);
        rightLegJoint.texOffs(44, 57).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, -0.1F, false);
        rightLegJoint.texOffs(66, 0).addBox(-0.95F, -1.0F, -2.25F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        rightLegJoint.texOffs(66, 4).addBox(-0.95F, -1.0F, 0.25F, 2.0F, 2.0F, 2.0F, 0.0F, false);

        rightLowerLeg = new ModelRenderer(this);
        rightLowerLeg.setPos(0.0F, 6.0F, 0.0F);
        rightLeg.addChild(rightLowerLeg);
        rightLowerLeg.texOffs(16, 52).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, -0.001F, false);
        rightLowerLeg.texOffs(66, 27).addBox(-2.45F, 3.5F, -0.25F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        rightLowerLeg.texOffs(66, 27).addBox(0.45F, 3.5F, -0.25F, 2.0F, 1.0F, 1.0F, 0.0F, false);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        //previously the render function, render code was moved to a method below
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
