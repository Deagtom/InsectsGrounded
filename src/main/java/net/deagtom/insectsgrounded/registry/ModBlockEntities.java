package net.deagtom.insectsgrounded.registry;

import net.deagtom.insectsgrounded.InsectsGrounded;
import net.deagtom.insectsgrounded.block.blockentity.EvercharcoalOreBlockEntity;
import net.deagtom.insectsgrounded.block.blockentity.WorkbenchBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, InsectsGrounded.MODID);

    public static void register(net.neoforged.bus.api.IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WorkbenchBlockEntity>> WORKBENCH_BLOCK =
            BLOCK_ENTITIES.register("workbench",
                    () -> BlockEntityType.Builder.of(
                            WorkbenchBlockEntity::new,
                            ModBlocks.WORKBENCH_BLOCK.get()
                    ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EvercharcoalOreBlockEntity>> EVERCHARCOAL_ORE_ENTITY =
            BLOCK_ENTITIES.register("evercharcoal_ore",
                    () -> BlockEntityType.Builder.of(
                            EvercharcoalOreBlockEntity::new,
                            ModBlocks.EVERCHARCOAL_ORE.get()
                    ).build(null));
}
