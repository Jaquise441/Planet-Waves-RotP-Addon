package com.hello_there.rotp_pw.action;

import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.hello_there.rotp_pw.entity.MeteoriteEntity;
import com.hello_there.rotp_pw.init.InitEntities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PlanetWavesVerticalMeteoriteShower extends StandEntityAction {

    public static final StandPose VERTICAL = new StandPose("vertical");

    public PlanetWavesVerticalMeteoriteShower(Builder builder) {
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
                        double baseX = standEntity.getX();
                        double baseY = standEntity.getY() + 60;
                        double baseZ = standEntity.getZ();

                        double offsetX = (Math.random() * 5) - 2.5;
                        double offsetZ = (Math.random() * 5) - 2.5;

                        MeteoriteEntity meteorite = new MeteoriteEntity(InitEntities.METEORITE.get(), world);
                        meteorite.setPos(baseX + offsetX, baseY, baseZ + offsetZ);
                        meteorite.setTarget(player);

                        meteorite.setSize(6.0);
                        meteorite.addException(standEntity);
                        meteorite.addException(meteorite);
                        world.addFreshEntity(meteorite);

                    }, delay, TimeUnit.MILLISECONDS);
                }

                executor.shutdown();
            }
        }
    }
}
