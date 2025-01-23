package com.hello_there.rotp_pw.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkHooks;

import java.util.ArrayList;
import java.util.List;

public class MeteoriteEntity extends ThrowableEntity {

    private double size = 6.0;
    private Entity target;
    private boolean verticalAttraction = false;

    private final List<Entity> exceptionEntities = new ArrayList<>();
    private final double speed = 1;

    public MeteoriteEntity(EntityType<? extends MeteoriteEntity> type, World world) {
        super(type, world);
        updateBoundingBox();
        this.setSecondsOnFire(Integer.MAX_VALUE);
        exceptionEntities.add(this);
    }

    @Override
    public boolean isOnFire() {
        return true;
    }

    public void setVerticalAttraction(boolean enabled) {
        this.verticalAttraction = enabled;
    }

    public void setSize(double size) {
        this.size = size;
        updateBoundingBox();
    }

    public double getSize() {
        return this.size;
    }

    public void setTarget(Entity target) {
        this.target = target;
    }

    public void addException(Entity entity) {
        exceptionEntities.add(entity);
    }

    @Override
    public boolean isNoGravity() {
        return true;
    }

    private void updateBoundingBox() {
        float halfSize = (float) this.size / 10;
        this.setBoundingBox(new AxisAlignedBB(
                this.getX() - halfSize, this.getY() - halfSize, this.getZ() - halfSize,
                this.getX() + halfSize, this.getY() + halfSize, this.getZ() + halfSize
        ));
    }

    private void explode() {
        if (this.level instanceof ServerWorld) {
            ServerWorld serverWorld = (ServerWorld) this.level;

            serverWorld.explode(null, this.getX(), this.getY(), this.getZ(), 4.0F, Explosion.Mode.DESTROY);

            if (target != null && this.distanceToSqr(target) < 40 * 40) {
                target.hurt(DamageSource.explosion((Explosion) null), 0F);
            }
        }
        this.remove();
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level.isClientSide()) {
            if (!this.level.getBlockState(this.blockPosition()).isAir()) {
                this.explode();
                return;
            }

            if (target != null && target.isAlive()) {
                Vector3d currentPos = this.position();
                Vector3d direction;

                if (verticalAttraction) {
                    double targetY = target.getY() + 1;
                    double thresholdY = targetY + 6;

                    if (currentPos.y > thresholdY) {
                        direction = new Vector3d(0, -1, 0).normalize().scale(speed);
                    } else {
                        direction = new Vector3d(
                                target.getX() - this.getX(),
                                targetY - this.getY(),
                                target.getZ() - this.getZ()
                        ).normalize().scale(speed);
                    }
                } else {
                    direction = new Vector3d(
                            target.getX() - this.getX(),
                            target.getY() - this.getY(),
                            target.getZ() - this.getZ()
                    ).normalize().scale(speed);
                }

                Vector3d newPosition = currentPos.add(direction);
                if (!this.level.getBlockState(new BlockPos(newPosition)).isAir()) {
                    this.explode();
                    return;
                }

                this.setDeltaMovement(direction);
                this.move(MoverType.SELF, this.getDeltaMovement());
            }

            if (target != null && this.distanceToSqr(target) < 3.5 * 3.5) {
                this.despawn();
                return;
            }

            List<Entity> collidedEntities = this.level.getEntities(this, this.getBoundingBox().inflate(1));
            for (Entity entity : collidedEntities) {
                if (!exceptionEntities.contains(entity)) {
                    this.explode();
                    return;
                }
            }

            if (this.level instanceof ServerWorld) {
                ServerWorld serverWorld = (ServerWorld) this.level;

                serverWorld.sendParticles(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, this.getX(), this.getY(), this.getZ(), 5, 0.5, 0.5, 0.5, 0.01);
                serverWorld.sendParticles(ParticleTypes.FLAME, this.getX(), this.getY(), this.getZ(), 10, 0.4, 0.4, 0.4, 0.02);
                serverWorld.sendParticles(ParticleTypes.LAVA, this.getX(), this.getY(), this.getZ(), 5, 0.3, 0.3, 0.3, 0.05);
                serverWorld.sendParticles(ParticleTypes.SMOKE, this.getX(), this.getY(), this.getZ(), 5, 0.4, 0.4, 0.4, 0.01);
            }
        }
    }


    private void despawn() {
        if (this.level instanceof ServerWorld) {
            ServerWorld serverWorld = (ServerWorld) this.level;

            serverWorld.sendParticles(ParticleTypes.FALLING_LAVA, this.getX(), this.getY(), this.getZ(), 15, 0.3, 0.3, 0.3, 0.05);

            serverWorld.sendParticles(ParticleTypes.SMOKE, this.getX(), this.getY(), this.getZ(), 10, 0.2, 0.2, 0.2, 0.01);

            serverWorld.sendParticles(ParticleTypes.CRIMSON_SPORE, this.getX(), this.getY(), this.getZ(), 10, 0.2, 0.2, 0.2, 0.01);


            this.level.playSound(null, this.getX(), this.getY(), this.getZ(), net.minecraft.util.SoundEvents.FIRE_EXTINGUISH,
                    net.minecraft.util.SoundCategory.NEUTRAL, 1.0F, 1.0F);
            this.level.playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.NETHERRACK_BREAK,
                    net.minecraft.util.SoundCategory.NEUTRAL, 1.0F, 1.0F);

        }
        this.remove();
    }



    @Override
    protected void defineSynchedData() {}

    @Override
    protected void readAdditionalSaveData(CompoundNBT compound) {
        this.size = compound.getDouble("Size");
        updateBoundingBox();
    }

    @Override
    protected void addAdditionalSaveData(CompoundNBT compound) {
        compound.putDouble("Size", this.size);
    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
