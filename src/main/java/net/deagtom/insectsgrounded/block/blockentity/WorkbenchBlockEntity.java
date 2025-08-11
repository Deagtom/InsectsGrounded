package net.deagtom.insectsgrounded.block.blockentity;

import net.deagtom.insectsgrounded.registry.ModBlockEntities;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;

public class WorkbenchBlockEntity extends BlockEntity {
    public WorkbenchBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.WORKBENCH_BLOCK.get(), pos, state);
    }
}