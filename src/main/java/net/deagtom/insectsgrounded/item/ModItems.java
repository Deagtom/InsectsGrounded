package net.deagtom.insectsgrounded.item;

import net.deagtom.insectsgrounded.InsectsGrounded;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(InsectsGrounded.MODID);

    public static final DeferredItem<Item> PEBBLET = ITEMS.register("pebblet", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SPRIG = ITEMS.register("sprig", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
