package net.deagtom.insectsgrounded.item;

import net.deagtom.insectsgrounded.InsectsGrounded;
import net.deagtom.insectsgrounded.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, InsectsGrounded.MODID);

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

    public static final Supplier<CreativeModeTab> INSECTS_GROUNDED_TAB = CREATIVE_MODE_TAB.register("insects_grounded_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.PEBBLET.get()))
                    .title(Component.translatable("creativetab.insectsgrounded.insects_grounded"))
                    .displayItems((itemDisplayParameters, output) -> {
                        //Items
                        output.accept(ModItems.PEBBLET);
                        output.accept(ModItems.SPRIG);
                        output.accept(ModItems.PLANT_FIBER);
                        output.accept(ModItems.CRUDE_ROPE);

                        //Blocks
                        output.accept(ModBlocks.PLANT_FIBER_BLOCK);
                    })
                    .build());
}