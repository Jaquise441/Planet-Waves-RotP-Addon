package com.hello_there.rotp_pw.client.render.entity.stand;

import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.client.render.entity.model.stand.HumanoidStandModel;
import com.github.standobyte.jojo.client.render.entity.model.stand.bb.BlockbenchStandModelHelper;
import com.github.standobyte.jojo.client.render.entity.pose.IModelPose;
import com.github.standobyte.jojo.client.render.entity.pose.ModelPose;
import com.github.standobyte.jojo.client.render.entity.pose.ModelPoseTransitionMultiple;
import com.github.standobyte.jojo.client.render.entity.pose.RotationAngle;
import com.github.standobyte.jojo.client.render.entity.pose.anim.PosedActionAnimation;
import com.github.standobyte.jojo.entity.stand.StandPose;

import com.hello_there.rotp_pw.action.*;
import com.hello_there.rotp_pw.entity.PlanetWavesEntity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.HandSide;

public class PlanetWavesModel extends HumanoidStandModel<PlanetWavesEntity> {



    public PlanetWavesModel() {
        super();

        BlockbenchStandModelHelper.fillFromBlockbenchExport(new PlanetWavesModelBlockbench(), this);
    }


	@Override
    protected RotationAngle[][] initSummonPoseRotations() {
        return new RotationAngle[][] {
            new RotationAngle[] {
                    RotationAngle.fromDegrees(head, -11.5145, 22.9851, -21.6131),
                    RotationAngle.fromDegrees(body, 0, 37.5, 0),
                    RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                    RotationAngle.fromDegrees(torso, 0, 0, 0),
                    RotationAngle.fromDegrees(leftArm, 32.5, 0, -45),
                    RotationAngle.fromDegrees(rightArm, -37.5, 0, 0),
                    RotationAngle.fromDegrees(leftForeArm, -45, 52.5, 0),
                    RotationAngle.fromDegrees(rightForeArm, 63.2598, -78.831, -63.6975),
                    RotationAngle.fromDegrees(leftLeg, 30, 0, 0),
                    RotationAngle.fromDegrees(rightLeg, -57.5, 0F, 0),
                    RotationAngle.fromDegrees(leftLowerLeg, 0F, 0F, 0F),
                    RotationAngle.fromDegrees(rightLowerLeg, 57.5F, 0F, 0F)
            },
            new RotationAngle[] {
                    RotationAngle.fromDegrees(head, 22.5, 0, 0),
                    RotationAngle.fromDegrees(body, -15, 0, 0),
                    RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                    RotationAngle.fromDegrees(torso, 0, 0, 0),
                    RotationAngle.fromDegrees(leftArm, 32.1038, -5.3535, 8.4586),
                    RotationAngle.fromDegrees(rightArm, -12.5, 0, 0),
                    RotationAngle.fromDegrees(leftForeArm, 0, 0, 20),
                    RotationAngle.fromDegrees(rightForeArm, 167.5, -87.5, -180),
                    RotationAngle.fromDegrees(leftLeg, -39.3227, -23.9275, -26.341),
                    RotationAngle.fromDegrees(rightLeg, -35.067, 25.7383F, 31.743),
                    RotationAngle.fromDegrees(leftLowerLeg, 57.5F, 0F, 0F),
                    RotationAngle.fromDegrees(rightLowerLeg, 62.5F, 0F, 0F)
            }
		};
    }
    
    @Override
    protected void initActionPoses() {
        ModelPose<PlanetWavesEntity> grab_pose = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(body, 0, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(torso, 0, 0, 0),
                RotationAngle.fromDegrees(leftArm, -49.747, -19.5899, 2.681),
                RotationAngle.fromDegrees(rightArm, -51.5365, 11.8491, 9.2643),
                RotationAngle.fromDegrees(leftForeArm, -25.7693, 13.5663, 13.5393),
                RotationAngle.fromDegrees(rightForeArm, -25, 0, -20),
                RotationAngle.fromDegrees(leftLeg, 7.5, 0, -2.5),
                RotationAngle.fromDegrees(rightLeg, 5, 0F, 5),
                RotationAngle.fromDegrees(leftLowerLeg, 42.5, 0F, 0F),
                RotationAngle.fromDegrees(rightLowerLeg, 32.5, 0F, 0F)
        });

        actionAnim.put(PlanetWavesGrab.GRAB, new PosedActionAnimation.Builder<PlanetWavesEntity>()
                .addPose(StandEntityAction.Phase.PERFORM, new ModelPoseTransitionMultiple.Builder<>(idlePose)
                        .addPose(0.0F, grab_pose)
                        .build(idlePose))
                .build(idlePose));

        ModelPose<PlanetWavesEntity> general_attraction_pose = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, -32.5, 0, 0),
                RotationAngle.fromDegrees(body, 0, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(torso, 0, 0, 0),
                RotationAngle.fromDegrees(leftArm, 0, 0, 0),
                RotationAngle.fromDegrees(rightArm, -150.3988, 12.0303, -15.3605),
                RotationAngle.fromDegrees(leftForeArm, 0, 90, 0),
                RotationAngle.fromDegrees(rightForeArm, -137.5, -85, -237.5),
                RotationAngle.fromDegrees(leftLeg, 0, 0, -12.5),
                RotationAngle.fromDegrees(rightLeg, 0, 0F, 12.5),
                RotationAngle.fromDegrees(leftLowerLeg, 0F, 0F, 0F),
                RotationAngle.fromDegrees(rightLowerLeg, 0F, 0F, 0F)
        });

        actionAnim.put(PlanetWavesDiagonalMeteoriteShower.GENERAL, new PosedActionAnimation.Builder<PlanetWavesEntity>()
                .addPose(StandEntityAction.Phase.BUTTON_HOLD, new ModelPoseTransitionMultiple.Builder<>(idlePose)
                        .addPose(0.0F, general_attraction_pose)
                        .build(idlePose))
                .build(idlePose));

        actionAnim.put(PlanetWavesDiagonalMeteoriteAttraction.GENERAL, new PosedActionAnimation.Builder<PlanetWavesEntity>()
                .addPose(StandEntityAction.Phase.BUTTON_HOLD, new ModelPoseTransitionMultiple.Builder<>(idlePose)
                        .addPose(0.0F, general_attraction_pose)
                        .build(idlePose))
                .build(idlePose));

        actionAnim.put(PlanetWavesHorizontalMeteoriteShower.GENERAL, new PosedActionAnimation.Builder<PlanetWavesEntity>()
                .addPose(StandEntityAction.Phase.BUTTON_HOLD, new ModelPoseTransitionMultiple.Builder<>(idlePose)
                        .addPose(0.0F, general_attraction_pose)
                        .build(idlePose))
                .build(idlePose));

        actionAnim.put(PlanetWavesHorizontalMeteoriteAttraction.GENERAL, new PosedActionAnimation.Builder<PlanetWavesEntity>()
                .addPose(StandEntityAction.Phase.BUTTON_HOLD, new ModelPoseTransitionMultiple.Builder<>(idlePose)
                        .addPose(0.0F, general_attraction_pose)
                        .build(idlePose))
                .build(idlePose));

        ModelPose<PlanetWavesEntity> vertical_attraction_pose = new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, -62.5, 0, 0),
                RotationAngle.fromDegrees(body, 0, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(torso, 0, 0, 0),
                RotationAngle.fromDegrees(leftArm, 0, 0, 0),
                RotationAngle.fromDegrees(rightArm, -175.3988, 12.0303, -15.3605),
                RotationAngle.fromDegrees(leftForeArm, 0, 90, 0),
                RotationAngle.fromDegrees(rightForeArm, -137.5, -85, -237.5),
                RotationAngle.fromDegrees(leftLeg, 0, 0, -12.5),
                RotationAngle.fromDegrees(rightLeg, 0, 0F, 12.5),
                RotationAngle.fromDegrees(leftLowerLeg, 0F, 0F, 0F),
                RotationAngle.fromDegrees(rightLowerLeg, 0F, 0F, 0F)
        });

        actionAnim.put(PlanetWavesVerticalMeteoriteShower.VERTICAL, new PosedActionAnimation.Builder<PlanetWavesEntity>()
                .addPose(StandEntityAction.Phase.BUTTON_HOLD, new ModelPoseTransitionMultiple.Builder<>(idlePose)
                        .addPose(0.0F, vertical_attraction_pose)
                        .build(idlePose))
                .build(idlePose));

        actionAnim.put(PlanetWavesVerticalMeteoriteAttraction.VERTICAL, new PosedActionAnimation.Builder<PlanetWavesEntity>()
                .addPose(StandEntityAction.Phase.BUTTON_HOLD, new ModelPoseTransitionMultiple.Builder<>(idlePose)
                        .addPose(0.0F, vertical_attraction_pose)
                        .build(idlePose))
                .build(idlePose));

        super.initActionPoses();
    }


    @Override
    protected ModelPose<PlanetWavesEntity> initIdlePose() {
        return new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(body, 0, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(torso, 0, 0,    0),
                RotationAngle.fromDegrees(leftArm, 0, 0, -25),
                RotationAngle.fromDegrees(rightArm, 0, 0, 15),
                RotationAngle.fromDegrees(leftForeArm, -22.5, 0, 0),
                RotationAngle.fromDegrees(rightForeArm, 2.0675, -22.4097, -5.4096),
                RotationAngle.fromDegrees(leftLeg, -16.5254, -9.131, -10.2734),
                RotationAngle.fromDegrees(rightLeg, -7.7806, 11.8026, 10.8174),
                RotationAngle.fromDegrees(leftLowerLeg, 45, 0, 0),
                RotationAngle.fromDegrees(rightLowerLeg, 50, 0, 0),
        });
    }

    @Override
    protected IModelPose<PlanetWavesEntity> initIdlePose2Loop() {
        return new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(body, 0, 0, 0),
                RotationAngle.fromDegrees(upperPart, 0, 0, 0),
                RotationAngle.fromDegrees(torso, 0, 0, 0),
                RotationAngle.fromDegrees(leftArm, 0, 0, -17.5),
                RotationAngle.fromDegrees(rightArm, 0, 0, 12.5),
                RotationAngle.fromDegrees(leftForeArm, -15, 0, 0),
                RotationAngle.fromDegrees(rightForeArm, 3.0947, -22.2971, -8.11),
                RotationAngle.fromDegrees(leftLeg, -14.0254, -9.131, -10.2734),
                RotationAngle.fromDegrees(rightLeg, -5.2806, 11.8026, 10.8174),
                RotationAngle.fromDegrees(leftLowerLeg, 47.5, 0, 0),
                RotationAngle.fromDegrees(rightLowerLeg, 55, 0, 0),
        });
    }

    @Override
    public void poseIdleLoop(PlanetWavesEntity entity, float ticks, float yRotOffsetRad, float xRotRad, HandSide swingingHand) {
        super.poseIdleLoop(entity, ticks, yRotOffsetRad, xRotRad, swingingHand);
    }
}