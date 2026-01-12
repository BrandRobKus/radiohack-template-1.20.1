package com.brandrobkus.radiohack.item;

import com.brandrobkus.radiohack.block.ModBlocks;
import com.brandrobkus.radiohack.block.modBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.UUID;

public class WireItem extends Item {
    // Map to store the first selected wirehook per player
    private static final HashMap<UUID, BlockPos> firstWireHookSelection = new HashMap<>();

    public WireItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        if (player == null) return ActionResult.PASS;

        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);

        // Check if the block clicked is a wirehook
        if (blockState.isOf(modBlocks.WIREHOOK)) {
            UUID playerId = player.getUuid();

            if (!world.isClient) {
                if (firstWireHookSelection.containsKey(playerId)) {
                    // Second click - Create connection
                    BlockPos firstPos = firstWireHookSelection.get(playerId);
                    connectWireHooks(world, firstPos, blockPos);
                    firstWireHookSelection.remove(playerId); // Reset selection
                    player.sendMessage(Text.literal("Wirehooks connected!"), true);
                } else {
                    // First click - Store selection
                    firstWireHookSelection.put(playerId, blockPos);
                    player.sendMessage(Text.literal("First wirehook selected. Click another to connect."), true);
                }
            }

            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    private void connectWireHooks(World world, BlockPos pos1, BlockPos pos2) {
        // Implement visual connection logic (e.g., particle effect, block state update)
        // Example: Store the connection in a block entity or create a renderable entity
        System.out.println("Connecting Wirehooks at " + pos1 + " and " + pos2);
    }
}
