package com.hello_there.rotp_pw.action;

import com.github.standobyte.jojo.action.ActionConditionResult;
import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.hello_there.rotp_pw.entity.MeteoriteEntity;
import com.hello_there.rotp_pw.init.InitEntities;
import com.hello_there.rotp_pw.init.InitSounds;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.play.server.SPlaySoundEffectPacket;
import net.minecraft.network.play.server.SStopSoundPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class PlanetWavesHorizontalMeteoriteAttraction extends StandEntityAction {

    public static final StandPose GENERAL = new StandPose("general");


    public PlanetWavesHorizontalMeteoriteAttraction(Builder builder) {
        super(builder);
    }


    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        if (!world.isClientSide) {
            if (standEntity.getUser() instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) standEntity.getUser();

                Vector3d lookVector = player.getLookAngle().normalize();
                double spawnX = player.getX() + lookVector.x * 60;
                double spawnY = player.getY() + 60;
                double spawnZ = player.getZ() + lookVector.z * 60;

                MeteoriteEntity meteorite = new MeteoriteEntity(InitEntities.METEORITE.get(), world);
                meteorite.setPos(spawnX, spawnY, spawnZ);
                meteorite.setTarget(player);
                meteorite.setVerticalAttraction(true);
                meteorite.addException(standEntity);
                meteorite.addException(meteorite);
                meteorite.setSize(6.0);

                world.addFreshEntity(meteorite);
            }
        }
    }
}


