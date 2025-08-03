package net.deagtom.insectsgrounded;

import net.deagtom.insectsgrounded.block.ModBlocks;
import net.deagtom.insectsgrounded.item.ModCreativeModTabs;
import net.deagtom.insectsgrounded.item.ModItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

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

        modEventBus.addListener(this::addCreative);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        /*if (event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(ModItems.PEBBLET);
            event.accept(ModItems.SPRIG);
            event.accept(ModItems.PLANT_FIBER);
        }

        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){
            event.accept((ModBlocks.PLANT_FIBER_BLOCK));
        }*/
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}
