package net.williamcooke.SkyOrigns2Tech.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.williamcooke.SkyOrigns2Tech.block.ModBlocks;

public class obblivumalloy extends Item {
    public obblivumalloy(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide && level instanceof ServerLevel serverLevel) {
            BlockPos playerPos = player.blockPosition();
            Block voidBlock = ModBlocks.voidblock.get(); // Your custom void block

            int radius = 3; // half-size of cube

            for (int x = -radius; x <= radius; x++) {
                for (int y = -radius; y <= radius; y++) {
                    for (int z = -radius; z <= radius; z++) {
                        // Hollow cube logic: only place at edges
                        if (Math.abs(x) == radius || Math.abs(y) == radius || Math.abs(z) == radius) {
                            BlockPos placePos = playerPos.offset(x, y, z);
                            if (serverLevel.isEmptyBlock(placePos)) {
                                serverLevel.setBlockAndUpdate(placePos, voidBlock.defaultBlockState());
                            }
                        }
                    }
                }
            }

            // Optional: Damage the item
            player.getItemInHand(hand).hurtAndBreak(1, player,
                    (p) -> p.broadcastBreakEvent(hand));
        }

        return InteractionResultHolder.sidedSuccess(player.getItemInHand(hand), level.isClientSide());
    }
}