package com.hello_there.rotp_pw.init;

import com.hello_there.rotp_pw.PlanetWavesAddon;
import com.hello_there.rotp_pw.entity.MeteoriteEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(
            ForgeRegistries.ENTITIES, PlanetWavesAddon.MOD_ID);

    public static final RegistryObject<EntityType<MeteoriteEntity>> METEORITE = ENTITIES.register(
            "meteorite",
            () -> EntityType.Builder.<MeteoriteEntity>of(MeteoriteEntity::new, EntityClassification.MISC)
                    .sized(1.0F, 1.0F)
                    .build(new ResourceLocation(PlanetWavesAddon.MOD_ID, "meteorite").toString())
    );
}
