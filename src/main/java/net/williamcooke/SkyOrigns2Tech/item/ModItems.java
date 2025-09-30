package net.williamcooke.SkyOrigns2Tech.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.williamcooke.SkyOrigns2Tech.SkyOrigns2Tech;
import net.williamcooke.SkyOrigns2Tech.item.custom.obblivumalloy;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SkyOrigns2Tech.Mod_Id);


    public static final RegistryObject<Item> voidEssence = ITEMS.register("voidessence",
            ()-> new Item(new Item.Properties()));
public static final RegistryObject<Item> voidCrystal = ITEMS.register("voidcrystal",
        ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> raw_unobtainum = ITEMS.register("raw_unobtainum",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> unobtainum_ingot = ITEMS.register("unobtainum_ingot",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> obblivum_alloy =
            ITEMS.register("obblivum_alloy",
                    () -> new obblivumalloy(new Item.Properties()
                            .stacksTo(1)
                            .durability(100)
                            .rarity(Rarity.EPIC)));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
