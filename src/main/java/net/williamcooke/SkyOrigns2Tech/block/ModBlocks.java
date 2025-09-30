package net.williamcooke.SkyOrigns2Tech.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.williamcooke.SkyOrigns2Tech.SkyOrigns2Tech;
import net.williamcooke.SkyOrigns2Tech.item.ModItems;

import java.util.function.Supplier;
public class ModBlocks {

        public static final DeferredRegister<Block> BLOCKS =
                DeferredRegister.create(ForgeRegistries.BLOCKS, SkyOrigns2Tech.Mod_Id);

        public static final RegistryObject<Block> voidcrystals_BLOCK = registerBlock("voidcrystal_block",
                () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                        .requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));

        public static final RegistryObject<Block> voidblock = registerBlock("voidblock",() -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .requiresCorrectToolForDrops().strength(15.0F, 6.0F).sound(SoundType.METAL)));

    public static final RegistryObject<Block>  unobtainum_ore= registerBlock("unobtainum_ore",() -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
            .requiresCorrectToolForDrops().strength(19.0F, 6.0F).sound(SoundType.METAL)));

    public static final RegistryObject<Block> nannoforge = registerBlock("nannoforge",() -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
            .requiresCorrectToolForDrops().strength(19.0F, 6.0F).sound(SoundType.METAL)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
            RegistryObject<T> toReturn = BLOCKS.register(name, block);
            registerBlockItem(name, toReturn);
            return toReturn;
        }



        private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
            return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        }

        public static void register(IEventBus eventBus) {
            BLOCKS.register(eventBus);
        }
    }

