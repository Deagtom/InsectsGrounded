package net.deagtom.insectsgrounded.block.custom;

import net.deagtom.insectsgrounded.block.blockentity.EvercharcoalOreBlockEntity;
import net.deagtom.insectsgrounded.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.phys.AABB;

import javax.annotation.Nullable;

public class EvercharcoalOreBlock extends DropExperienceBlock implements EntityBlock {
    public EvercharcoalOreBlock(Properties properties) {
        super(UniformInt.of(2, 4), properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new EvercharcoalOreBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        if (level.isClientSide) return null;
        return type == ModBlockEntities.EVERCHARCOAL_ORE_ENTITY.get()
                ? (lvl, p, st, be) -> ((EvercharcoalOreBlockEntity) be).tick(lvl, p, st)
                : null;
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        super.animateTick(state, level, pos, random);

        if (level.isClientSide) {
            double radius = 20.0;

            if (!level.getEntitiesOfClass(Player.class, new AABB(pos).inflate(radius)).isEmpty()) {

                if (random.nextFloat() < 0.6f) {
                    int count = 2 + random.nextInt(2);
                    for (int i = 0; i < count; i++) {
                        double x = pos.getX() + 0.5 + (random.nextDouble() - 0.5) * 0.4;
                        double y = pos.getY() + 1.0 + random.nextDouble() * 0.2;
                        double z = pos.getZ() + 0.5 + (random.nextDouble() - 0.5) * 0.4;

                        level.addParticle(ParticleTypes.LARGE_SMOKE, x, y, z, 0.0, 0.07, 0.0);
                    }
                }

                if (random.nextFloat() < 0.1f) {
                    double sx = pos.getX() + 0.5;
                    double sy = pos.getY() + 0.5;
                    double sz = pos.getZ() + 0.5;

                    level.playLocalSound(sx, sy, sz, SoundEvents.CAMPFIRE_CRACKLE,
                            SoundSource.BLOCKS, 1.0f, 1.0f, false);
                }
            }
        }
    }
}
