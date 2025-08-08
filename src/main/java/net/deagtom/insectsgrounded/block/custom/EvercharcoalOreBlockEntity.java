package net.deagtom.insectsgrounded.block.custom;

import net.deagtom.insectsgrounded.block.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class EvercharcoalOreBlockEntity extends BlockEntity {

    private static final double FIRE_RADIUS = 5.0;

    public EvercharcoalOreBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.EVERCHARCOAL_ORE_ENTITY.get(), pos, state);
    }

    public void tick(Level level, BlockPos pos, BlockState state) {
        List<ServerPlayer> players = level.getEntitiesOfClass(
                ServerPlayer.class,
                new AABB(pos).inflate(FIRE_RADIUS)
        );
        for (ServerPlayer player : players) {
            player.igniteForSeconds(4);
        }
    }
}
