package net.deagtom.insectsgrounded.block.custom;

import net.deagtom.insectsgrounded.block.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class EvercharcoalOreBlockEntity extends BlockEntity {

    private static final int FIRE_RADIUS_ENTITIES = 5;

    public EvercharcoalOreBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.EVERCHARCOAL_ORE_ENTITY.get(), pos, state);
    }

    public void tick(Level level, BlockPos pos, BlockState state) {
        List<LivingEntity> entities = level.getEntitiesOfClass(
                LivingEntity.class,
                new AABB(pos).inflate(FIRE_RADIUS_ENTITIES)
        );

        for (LivingEntity entity : entities) {
            if (!entity.fireImmune()) {
                entity.igniteForSeconds(4);
            }
        }

        if (!level.isClientSide && level.random.nextInt(200) == 0) {
            BlockPos target = pos.offset(
                    level.random.nextInt(7) - 3,
                    level.random.nextInt(3),
                    level.random.nextInt(7) - 3
            );

            if (level.isEmptyBlock(target)) {
                for (Direction dir : Direction.values()) {
                    BlockPos neighbor = target.relative(dir);
                    if (level.getBlockState(neighbor).isFlammable(level, neighbor, dir.getOpposite())) {
                        level.setBlock(target, Blocks.FIRE.defaultBlockState(), 3);
                        break;
                    }
                }
            }
        }
    }
}