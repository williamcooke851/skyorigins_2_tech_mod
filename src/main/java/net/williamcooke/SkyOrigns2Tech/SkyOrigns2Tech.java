package net.williamcooke.SkyOrigns2Tech;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.williamcooke.SkyOrigns2Tech.block.ModBlocks;
import net.williamcooke.SkyOrigns2Tech.item.ModItems;
import org.slf4j.Logger;


@Mod(SkyOrigns2Tech.Mod_Id)
public class SkyOrigns2Tech
{

    public static final String Mod_Id = "sky_origins_tech_2";

    private static final Logger LOGGER = LogUtils.getLogger();


    public SkyOrigns2Tech(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();


        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }


    private void addCreative(BuildCreativeModeTabContentsEvent event) {
         if (event.getTabKey() == CreativeModeTabs.INGREDIENTS){
             event.accept(ModItems.voidEssence);
         }
         if (event.getTabKey() == CreativeModeTabs.INGREDIENTS){
             event.accept(ModItems.voidCrystal);
         }
         if (event.getTabKey()== CreativeModeTabs.BUILDING_BLOCKS){
             event.accept(ModBlocks.Block_of_voidcrystals);
         }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = Mod_Id, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
