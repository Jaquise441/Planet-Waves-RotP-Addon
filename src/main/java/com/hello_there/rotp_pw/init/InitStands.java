package com.hello_there.rotp_pw.init;

import com.github.standobyte.jojo.action.Action;
import com.github.standobyte.jojo.action.stand.*;
import com.github.standobyte.jojo.entity.stand.StandEntityType;
import com.github.standobyte.jojo.init.power.stand.EntityStandRegistryObject;
import com.github.standobyte.jojo.init.power.stand.ModStandsInit;
import com.github.standobyte.jojo.power.impl.stand.StandInstance.StandPart;
import com.github.standobyte.jojo.power.impl.stand.stats.StandStats;
import com.github.standobyte.jojo.power.impl.stand.type.EntityStandType;
import com.github.standobyte.jojo.power.impl.stand.type.StandType;

import com.hello_there.rotp_pw.PlanetWavesAddon;
import com.hello_there.rotp_pw.action.*;
import com.hello_there.rotp_pw.entity.PlanetWavesEntity;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public class InitStands {
    @SuppressWarnings("unchecked")
    public static final DeferredRegister<Action<?>> ACTIONS = DeferredRegister.create(
            (Class<Action<?>>) ((Class<?>) Action.class), PlanetWavesAddon.MOD_ID);
    @SuppressWarnings("unchecked")
    public static final DeferredRegister<StandType<?>> STANDS = DeferredRegister.create(
            (Class<StandType<?>>) ((Class<?>) StandType.class), PlanetWavesAddon.MOD_ID);
    
 // ======================================== Planet Waves ========================================

    public static final RegistryObject<StandEntityAction> PLANET_WAVES_PUNCH = ACTIONS.register("planet_waves_punch",
            () -> new StandEntityLightAttack(new StandEntityLightAttack.Builder()
                    .punchSound(InitSounds.PLANET_WAVES_PUNCH_LIGHT)));
    
    public static final RegistryObject<StandEntityAction> PLANET_WAVES_BARRAGE = ACTIONS.register("planet_waves_barrage",
            () -> new StandEntityMeleeBarrage(new StandEntityMeleeBarrage.Builder()
                    .barrageHitSound(InitSounds.PLANET_WAVES_PUNCH_LIGHT)));

    public static final RegistryObject<StandEntityAction> PLANET_WAVES_GRAB = ACTIONS.register("planet_waves_grab",
            () -> new PlanetWavesGrab(new StandEntityAction.Builder()
                    .holdType(140)
                    .resolveLevelToUnlock(1)
                    .standPose(PlanetWavesGrab.GRAB)
                    .staminaCost(75)
                    .cooldown(200)
                    .partsRequired(StandPart.MAIN_BODY)));


    public static final RegistryObject<StandEntityAction> PLANET_WAVES_BLOCK = ACTIONS.register("planet_waves_block",
            () -> new StandEntityBlock());
    
    public static final RegistryObject<StandEntityAction> PLANET_WAVES_VERTICAL = ACTIONS.register("planet_waves_vertical",
            () -> new PlanetWavesVerticalMeteoriteAttraction(new StandEntityAction.Builder()
                    .holdToFire(15, true)
                    .standSound(InitSounds.PLANET_WAVES_METEORITE_SUMMON)
                    .standPose(PlanetWavesVerticalMeteoriteAttraction.VERTICAL)
                    .resolveLevelToUnlock(1)
                    .staminaCost(100)
                    .cooldown(120)
                    .partsRequired(StandPart.ARMS)));


    public static final RegistryObject<StandEntityAction> PLANET_WAVES_HORIZONTAL = ACTIONS.register("planet_waves_horizontal",
            () -> new PlanetWavesHorizontalMeteoriteAttraction(new StandEntityAction.Builder()
                    .holdToFire(15, true)
                    .standSound(InitSounds.PLANET_WAVES_METEORITE_SUMMON)
                    .standPose(PlanetWavesHorizontalMeteoriteAttraction.GENERAL)
                    .resolveLevelToUnlock(2)
                    .staminaCost(100)
                    .cooldown(120)
                    .partsRequired(StandPart.ARMS)));


    public static final RegistryObject<StandEntityAction> PLANET_WAVES_DIAGONAL = ACTIONS.register("planet_waves_diagonal",
            () -> new PlanetWavesDiagonalMeteoriteAttraction(new StandEntityAction.Builder()
                    .holdToFire(15, true)
                    .standSound(InitSounds.PLANET_WAVES_METEORITE_SUMMON)
                    .standPose(PlanetWavesDiagonalMeteoriteAttraction.GENERAL)
                    .resolveLevelToUnlock(3)
                    .staminaCost(100)
                    .cooldown(120)
                    .partsRequired(StandPart.ARMS)));

    public static final RegistryObject<StandEntityAction> PLANET_WAVES_VERTICAL_SHOWER = ACTIONS.register("planet_waves_vertical_shower",
            () -> new PlanetWavesVerticalMeteoriteShower(new StandEntityAction.Builder()
                    .holdToFire(15, true)
                    .standSound(InitSounds.PLANET_WAVES_METEORITE_SUMMON)
                    .shiftVariationOf(PLANET_WAVES_VERTICAL)
                    .standPose(PlanetWavesVerticalMeteoriteShower.VERTICAL)
                    .resolveLevelToUnlock(3)
                    .staminaCost(175)
                    .cooldown(200)
                    .partsRequired(StandPart.ARMS)));

    public static final RegistryObject<StandEntityAction> PLANET_WAVES_HORIZONTAL_SHOWER = ACTIONS.register("planet_waves_horizontal_shower",
            () -> new PlanetWavesHorizontalMeteoriteShower(new StandEntityAction.Builder()
                    .holdToFire(15, true)
                    .standSound(InitSounds.PLANET_WAVES_METEORITE_SUMMON)
                    .shiftVariationOf(PLANET_WAVES_HORIZONTAL)
                    .standPose(PlanetWavesHorizontalMeteoriteShower.GENERAL)
                    .resolveLevelToUnlock(3)
                    .staminaCost(175)
                    .cooldown(200)
                    .partsRequired(StandPart.ARMS)));

    public static final RegistryObject<StandEntityAction> PLANET_WAVES_DIAGONAL_SHOWER = ACTIONS.register("planet_waves_diagonal_shower",
            () -> new PlanetWavesDiagonalMeteoriteShower(new StandEntityAction.Builder()
                    .holdToFire(15, true)
                    .standSound(InitSounds.PLANET_WAVES_METEORITE_SUMMON)
                    .shiftVariationOf(PLANET_WAVES_DIAGONAL)
                    .standPose(PlanetWavesDiagonalMeteoriteShower.GENERAL)
                    .resolveLevelToUnlock(3)
                    .staminaCost(175)
                    .cooldown(200)
                    .partsRequired(StandPart.ARMS)));

    public static final EntityStandRegistryObject<EntityStandType<StandStats>, StandEntityType<PlanetWavesEntity>> PLANET_WAVES =
            new EntityStandRegistryObject<>("pw",
                    STANDS, 
                    () -> new EntityStandType.Builder<StandStats>()
                    .color(0xFF3333)
                    .storyPartName(ModStandsInit.PART_6_NAME)
                    .leftClickHotbar(
                            PLANET_WAVES_PUNCH.get(),
                            PLANET_WAVES_GRAB.get()
                    )
                    .rightClickHotbar(
                            PLANET_WAVES_BLOCK.get(),
                            PLANET_WAVES_VERTICAL.get(),
                            PLANET_WAVES_DIAGONAL.get(),
                            PLANET_WAVES_HORIZONTAL.get()
                            )
                    .defaultStats(StandStats.class, new StandStats.Builder()
                            .tier(5)
                            .power(17)
                            .speed(14)
                            .range(17, 18)
                            .durability(18)
                            .precision(7)
                            .build())
                    .addSummonShout(InitSounds.PLANET_WAVES_SUMMON_VOICELINE)
                    .addOst(InitSounds.PLANET_WAVES_OST)
                    .build(),
                    
                    InitEntities.ENTITIES,
                    () -> new StandEntityType<PlanetWavesEntity>(PlanetWavesEntity::new, 0.7F, 2.1F)
                    .summonSound(InitSounds.PLANET_WAVES_SUMMON_SOUND)
                    .unsummonSound(InitSounds.PLANET_WAVES_UNSUMMON_SOUND))
            .withDefaultStandAttributes();
    

    
    // ======================================== ??? ========================================
    
    
    
}
