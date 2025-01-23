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

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PlanetWavesHorizontalMeteoriteShower extends StandEntityAction {

    public static final StandPose GENERAL = new StandPose("general");


    public PlanetWavesHorizontalMeteoriteShower(Builder builder) {
        super(builder);
    }


    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        if (!world.isClientSide && world.getServer() != null) {
            if (standEntity.getUser() instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) standEntity.getUser();

                ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

                for (int i = 0; i < 3; i++) {
                    int delay = i * 240;

                    executor.schedule(() -> {
                        Vector3d lookVector = player.getLookAngle().normalize();
                        double baseX = player.getX() + lookVector.x * 60;
                        double baseY = player.getY() + 60;
                        double baseZ = player.getZ() + lookVector.z * 60;

                        double offsetX = (Math.random() * 5) - 2.5;
                        double offsetZ = (Math.random() * 5) - 2.5;

                        MeteoriteEntity meteorite = new MeteoriteEntity(InitEntities.METEORITE.get(), world);
                        meteorite.setPos(baseX + offsetX, baseY, baseZ + offsetZ);
                        meteorite.setTarget(player);

                        meteorite.addException(standEntity);
                        meteorite.addException(meteorite);
                        meteorite.setVerticalAttraction(true);
                        meteorite.setSize(6.0);
                        world.addFreshEntity(meteorite);

                    }, delay, TimeUnit.MILLISECONDS);
                }

                executor.shutdown();
            }
        }
    }
}


