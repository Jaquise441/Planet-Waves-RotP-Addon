package com.hello_there.rotp_pw.action;

import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.hello_there.rotp_pw.entity.MeteoriteEntity;
import com.hello_there.rotp_pw.init.InitEntities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class PlanetWavesDiagonalMeteoriteAttraction extends StandEntityAction {
    public static final StandPose GENERAL = new StandPose("general");

    public PlanetWavesDiagonalMeteoriteAttraction(Builder builder) {
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
                meteorite.addException(standEntity);
                meteorite.addException(meteorite);
                meteorite.setSize(6.0);

                world.addFreshEntity(meteorite);
            }
        }
    }
}
