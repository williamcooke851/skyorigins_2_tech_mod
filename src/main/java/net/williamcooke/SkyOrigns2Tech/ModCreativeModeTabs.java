package net.williamcooke.SkyOrigns2Tech;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.williamcooke.SkyOrigns2Tech.block.ModBlocks;
import net.williamcooke.SkyOrigns2Tech.item.ModItems;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SkyOrigns2Tech.Mod_Id);

    public static final RegistryObject<CreativeModeTab> SkyOrigins2Techvoid = CREATIVE_MODE_TABS.register("skyorigns2_tech_void",() -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.voidEssence.get())).title(Component.translatable("skyorigns2_tech_tab")).displayItems((itemDisplayParameters, output) -> {
        output.accept(ModItems.voidEssence.get());
        output.accept(ModItems.voidCrystal.get());
        output.accept(ModBlocks.voidcrystals_BLOCK.get());
        output.accept(ModBlocks.voidblock.get());

    }).build());
    public static final RegistryObject<CreativeModeTab> SkyOrigins2Techores = CREATIVE_MODE_TABS.register("skyorigns2_tech_ores",() -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.obblivum_alloy.get())).title(Component.translatable("skyorigns2_tech_tab")).displayItems((itemDisplayParameters, output) -> {
     output.accept(ModItems.obblivum_alloy.get());
     output.accept(ModItems.raw_unobtainum.get());
     output.accept(ModItems.unobtainum_ingot.get());
     output.accept(ModBlocks.unobtainum_ore.get());
     output.accept(ModBlocks.nannoforge.get());
    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
