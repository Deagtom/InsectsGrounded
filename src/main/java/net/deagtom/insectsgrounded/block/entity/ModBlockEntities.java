package net.deagtom.insectsgrounded.block.entity;

import net.deagtom.insectsgrounded.InsectsGrounded;
import net.deagtom.insectsgrounded.block.ModBlocks;
import net.deagtom.insectsgrounded.block.custom.EvercharcoalOreBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, InsectsGrounded.MODID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EvercharcoalOreBlockEntity>> EVERCHARCOAL_ORE_ENTITY =
            BLOCK_ENTITIES.register("evercharcoal_ore",
                    () -> BlockEntityType.Builder.of(
                            EvercharcoalOreBlockEntity::new,
                            ModBlocks.EVERCHARCOAL_ORE.get()
                    ).build(null));

    public static void register(net.neoforged.bus.api.IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
