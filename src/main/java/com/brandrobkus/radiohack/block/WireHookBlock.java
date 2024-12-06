package com.brandrobkus.radiohack.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class WireHookBlock extends Block {
    public static final DirectionProperty FACING;
    private static final VoxelShape SHAPE_NORTH;
    private static final VoxelShape SHAPE_EAST;
    private static final VoxelShape SHAPE_SOUTH;
    private static final VoxelShape SHAPE_WEST;
    private static final VoxelShape SHAPE_UP;
    private static final VoxelShape SHAPE_DOWN;
    static {
        FACING = Properties.FACING;

        SHAPE_NORTH = Block.createCuboidShape(7.0, 7.0, 11, 10.0, 10.0, 16);
        SHAPE_EAST = Block.createCuboidShape(0.0, 7, 7.0, 5.0, 10.0, 10.0);
        SHAPE_SOUTH = Block.createCuboidShape(6.0, 6.0, 0.0, 9.0, 9.0, 5.0);
        SHAPE_WEST = Block.createCuboidShape(11.0, 6.0, 6.0, 16.0, 9.0, 9.0);
        SHAPE_UP = Block.createCuboidShape(7.0, 0, 7, 10.0, 5.0, 10); //
        SHAPE_DOWN = Block.createCuboidShape(7.0, 11, 7.0, 10.0, 16.0, 10.0);
    }

    public WireHookBlock(Settings settings) {
        super(settings);
        this.setDefaultState(getDefaultState().with(FACING, Direction.NORTH));
    }
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(FACING, ctx.getPlayerLookDirection().getOpposite());
    }
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        // Return the appropriate shape based on the facing direction
        Direction facing = state.get(FACING);
        switch (facing) {
            case NORTH:
                return SHAPE_NORTH;
            case EAST:
                return SHAPE_EAST;
            case SOUTH:
                return SHAPE_SOUTH;
            case WEST:
                return SHAPE_WEST;
            case UP:
                return SHAPE_UP;
            case DOWN:
                return SHAPE_DOWN;
            default:
                return SHAPE_NORTH;
        }
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return getCollisionShape(state, world, pos, context);
    }
}
