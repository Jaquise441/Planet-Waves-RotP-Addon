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

public class PlanetWavesVerticalMeteoriteAttraction extends StandEntityAction {

    public static final StandPose VERTICAL = new StandPose("vertical");

    public PlanetWavesVerticalMeteoriteAttraction(Builder builder) {
        super(builder);
    }

    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        if (!world.isClientSide) {
            if (standEntity.getUser() instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) standEntity.getUser();

                MeteoriteEntity meteorite = new MeteoriteEntity(InitEntities.METEORITE.get(), world);
                meteorite.setPos(standEntity.getX(), standEntity.getY() + 60, standEntity.getZ());
                meteorite.setTarget(player);

                meteorite.addException(standEntity);
                meteorite.addException(meteorite);
                meteorite.setSize(6.0);

                world.addFreshEntity(meteorite);
            }
        }
    }
}
