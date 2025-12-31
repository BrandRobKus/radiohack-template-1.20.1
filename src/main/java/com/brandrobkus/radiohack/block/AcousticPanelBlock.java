package com.brandrobkus.radiohack.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class AcousticPanelBlock extends Block {
    public static final DirectionProperty FACING;
    private static final VoxelShape SHAPE_NORTH;
    private static final VoxelShape SHAPE_EAST;
    private static final VoxelShape SHAPE_SOUTH;
    private static final VoxelShape SHAPE_WEST;
    private static final VoxelShape SHAPE_DOWN;
    private static final VoxelShape SHAPE_UP;
    static {
        FACING = Properties.FACING;

        SHAPE_NORTH = Block.createCuboidShape(0.0, 0.0, 12, 16, 16.0, 16);
        SHAPE_EAST = Block.createCuboidShape(0.0, 0, 0.0, 4.0, 16.0, 16.0);
        SHAPE_SOUTH = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 4);
        SHAPE_WEST = Block.createCuboidShape(12.0, 0.0, 0.0, 16.0, 16.0, 16.0);
        SHAPE_DOWN = Block.createCuboidShape(0.0, 12, 0.0, 16.0, 16.0, 16.0);
        SHAPE_UP = Block.createCuboidShape(0, 0, 0.0, 16.0, 4, 16.0);
    }

    public AcousticPanelBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction clickedFace = ctx.getSide();

        if (clickedFace == Direction.UP) {
            Direction playerFacing = ctx.getHorizontalPlayerFacing();
            return this.getDefaultState().with(FACING, Direction.UP);
        } else if (clickedFace == Direction.DOWN) {
            return this.getDefaultState().with(FACING, Direction.DOWN);
        }
        return this.getDefaultState().with(FACING, clickedFace);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
    private Direction getRotatedDirection(Direction playerFacing) {
        switch (playerFacing) {
            case NORTH:
                return Direction.SOUTH;
            case EAST:
                return Direction.WEST;
            case SOUTH:
                return Direction.NORTH;
            case WEST:
                return Direction.EAST;
            default:
                return Direction.NORTH;
        }
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
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
            case DOWN:
                return SHAPE_DOWN;
            case UP:
                return SHAPE_UP;
            default:
                return SHAPE_UP;
        }
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return getCollisionShape(state, world, pos, context);
    }
}

