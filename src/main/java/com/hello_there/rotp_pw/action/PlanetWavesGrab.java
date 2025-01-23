package com.hello_there.rotp_pw.action;

import com.github.standobyte.jojo.action.ActionConditionResult;
import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.github.standobyte.jojo.entity.stand.StandRelativeOffset;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.hello_there.rotp_pw.init.InitSounds;
import net.minecraft.command.arguments.EntityAnchorArgument;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class PlanetWavesGrab extends StandEntityAction {
    public static final StandPose GRAB = new StandPose("grab");

    private float initialHealth;

    public PlanetWavesGrab(Builder builder) {
        super(builder);
    }

    @Override
    public ActionConditionResult checkTarget(ActionTarget target, LivingEntity user, IStandPower power) {
        Entity targetEntity = target.getEntity();
        if (targetEntity instanceof LivingEntity && targetEntity.isAlive() && targetEntity.distanceTo(user) <= 7) {
            return ActionConditionResult.POSITIVE;
        }
        return conditionMessage("no_target");
    }

    @Override
    public TargetRequirement getTargetRequirement() {
        return TargetRequirement.ENTITY;
    }

    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        LivingEntity user = userPower.getUser();
        initialHealth = user.getHealth();
        Entity targetEntity = task.getTarget().getEntity();
        if (!(targetEntity instanceof LivingEntity) || !targetEntity.isAlive() || targetEntity.distanceTo(user) > 7) {
            pwLetGo(userPower, (LivingEntity) targetEntity);
        }
    }

    @Override
    public void standTickPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        LivingEntity user = userPower.getUser();

        if (user.getHealth() <= initialHealth - 4.0F) {
            pwLetGo(userPower, (LivingEntity) task.getTarget().getEntity());
            return;
        }

        Entity targetEntity = task.getTarget().getEntity();
        if (!(targetEntity instanceof LivingEntity) || !targetEntity.isAlive() || targetEntity.distanceTo(user) > 7) {
            pwLetGo(userPower, (LivingEntity) targetEntity);
            return;
        }

        LivingEntity livingTarget = (LivingEntity) targetEntity;
        livingTarget.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 20, 11, false, false));
        Vector3d targetPos = livingTarget.position();
        Vector3d targetDirection = livingTarget.getLookAngle();
        double offsetDistance = 0.85;
        Vector3d standPos = targetPos.add(targetDirection.scale(offsetDistance));
        standEntity.setPos(standPos.x, standPos.y, standPos.z);
        standEntity.lookAt(EntityAnchorArgument.Type.FEET, targetPos);
        IStandPower.getStandPowerOptional(livingTarget).ifPresent(power -> power.setLeapCooldown(20));
    }

    private void pwLetGo(IStandPower userPower, @Nullable LivingEntity target) {
        if (target != null) {
            target.removeEffect(Effects.MOVEMENT_SLOWDOWN);
        }
        userPower.stopHeldAction(true);
    }

    @Override
    public void phaseTransition(World world, StandEntity standEntity, IStandPower userPower,
                                @Nullable Phase from, @Nullable Phase to, StandEntityTask task, int nextPhaseTicks) {
        if (to == Phase.PERFORM && world.isClientSide()) {
            standEntity.playSound(InitSounds.PLANET_WAVES_GRAB.get(), 1.0F, 1.0F);
        }
        if (from == Phase.PERFORM && !world.isClientSide()) {
            Entity targetEntity = task.getTarget().getEntity();
            if (targetEntity instanceof LivingEntity) {
                ((LivingEntity) targetEntity).removeEffect(Effects.MOVEMENT_SLOWDOWN);
            }
        }
    }

    @Override
    public StandRelativeOffset getOffsetFromUser(IStandPower standPower, StandEntity standEntity, StandEntityTask task) {
        return offsetToTarget(standPower, standEntity, task.getTarget(), 0, standEntity.getMaxEffectiveRange(), null)
                .orElse(super.getOffsetFromUser(standPower, standEntity, task));
    }
}
