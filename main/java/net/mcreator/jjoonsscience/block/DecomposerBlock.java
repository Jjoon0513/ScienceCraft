
package net.mcreator.jjoonsscience.block;

import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.Containers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.jjoonsscience.world.inventory.DecomposerGuiMenu;
import net.mcreator.jjoonsscience.block.entity.DecomposerBlockEntity;

import java.util.List;
import java.util.Collections;

import io.netty.buffer.Unpooled;

public class DecomposerBlock extends Block implements SimpleWaterloggedBlock, EntityBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public DecomposerBlock() {
		super(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(1f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return state.getFluidState().isEmpty();
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return switch (state.getValue(FACING)) {
			default -> Shapes.or(box(14, 0, 14, 16, 10, 16), box(14, 0, 0, 16, 10, 2), box(0, 0, 0, 2, 10, 2), box(0, 0, 14, 2, 10, 16), box(0, 10, 0, 16, 12, 16), box(0, 12, 15, 16, 16, 16), box(0, 12, 0, 16, 16, 1), box(15, 12, 1, 16, 16, 15),
					box(0, 12, 1, 1, 16, 15), box(3, 11, 3, 13, 13, 13), box(14, 12, 14, 15, 14, 15), box(13, 12, 14, 14, 13, 15), box(11, 12, 14, 13, 15, 15), box(9, 12, 14, 11, 14, 15), box(7, 12, 14, 9, 13, 15), box(5, 12, 14, 7, 15, 15));
			case NORTH -> Shapes.or(box(0, 0, 0, 2, 10, 2), box(0, 0, 14, 2, 10, 16), box(14, 0, 14, 16, 10, 16), box(14, 0, 0, 16, 10, 2), box(0, 10, 0, 16, 12, 16), box(0, 12, 0, 16, 16, 1), box(0, 12, 15, 16, 16, 16), box(0, 12, 1, 1, 16, 15),
					box(15, 12, 1, 16, 16, 15), box(3, 11, 3, 13, 13, 13), box(1, 12, 1, 2, 14, 2), box(2, 12, 1, 3, 13, 2), box(3, 12, 1, 5, 15, 2), box(5, 12, 1, 7, 14, 2), box(7, 12, 1, 9, 13, 2), box(9, 12, 1, 11, 15, 2));
			case EAST -> Shapes.or(box(14, 0, 0, 16, 10, 2), box(0, 0, 0, 2, 10, 2), box(0, 0, 14, 2, 10, 16), box(14, 0, 14, 16, 10, 16), box(0, 10, 0, 16, 12, 16), box(15, 12, 0, 16, 16, 16), box(0, 12, 0, 1, 16, 16), box(1, 12, 0, 15, 16, 1),
					box(1, 12, 15, 15, 16, 16), box(3, 11, 3, 13, 13, 13), box(14, 12, 1, 15, 14, 2), box(14, 12, 2, 15, 13, 3), box(14, 12, 3, 15, 15, 5), box(14, 12, 5, 15, 14, 7), box(14, 12, 7, 15, 13, 9), box(14, 12, 9, 15, 15, 11));
			case WEST -> Shapes.or(box(0, 0, 14, 2, 10, 16), box(14, 0, 14, 16, 10, 16), box(14, 0, 0, 16, 10, 2), box(0, 0, 0, 2, 10, 2), box(0, 10, 0, 16, 12, 16), box(0, 12, 0, 1, 16, 16), box(15, 12, 0, 16, 16, 16), box(1, 12, 15, 15, 16, 16),
					box(1, 12, 0, 15, 16, 1), box(3, 11, 3, 13, 13, 13), box(1, 12, 14, 2, 14, 15), box(1, 12, 13, 2, 13, 14), box(1, 12, 11, 2, 15, 13), box(1, 12, 9, 2, 14, 11), box(1, 12, 7, 2, 13, 9), box(1, 12, 5, 2, 15, 7));
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, WATERLOGGED);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(WATERLOGGED, flag);
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
		}
		return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}

	@Override
	public InteractionResult use(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
		super.use(blockstate, world, pos, entity, hand, hit);
		if (entity instanceof ServerPlayer player) {
			NetworkHooks.openScreen(player, new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("Decomposer");
				}

				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					return new DecomposerGuiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(pos));
				}
			}, pos);
		}
		return InteractionResult.SUCCESS;
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new DecomposerBlockEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
	}

	@Override
	public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity blockEntity = world.getBlockEntity(pos);
			if (blockEntity instanceof DecomposerBlockEntity be) {
				Containers.dropContents(world, pos, be);
				world.updateNeighbourForOutputSignal(pos, this);
			}
			super.onRemove(state, world, pos, newState, isMoving);
		}
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
		BlockEntity tileentity = world.getBlockEntity(pos);
		if (tileentity instanceof DecomposerBlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}
}
