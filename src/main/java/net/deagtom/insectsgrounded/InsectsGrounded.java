package net.deagtom.insectsgrounded;

import net.deagtom.insectsgrounded.registry.ModBlocks;
import net.deagtom.insectsgrounded.registry.ModBlockEntities;
import net.deagtom.insectsgrounded.item.ModCreativeModTabs;
import net.deagtom.insectsgrounded.item.ModItems;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;

@Mod(InsectsGrounded.MODID)
public class InsectsGrounded {
    public static final String MODID = "insectsgrounded";
    public static final Logger LOGGER = LogUtils.getLogger();

    public InsectsGrounded(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);

        ModCreativeModTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
}
