
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jjoonsscience.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.jjoonsscience.block.entity.DecomposerBlockEntity;
import net.mcreator.jjoonsscience.block.entity.AirCollectorBlockEntity;
import net.mcreator.jjoonsscience.JjoonsScienceMod;

public class JjoonsScienceModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, JjoonsScienceMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> AIR_COLLECTOR = register("air_collector", JjoonsScienceModBlocks.AIR_COLLECTOR, AirCollectorBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> DECOMPOSER = register("decomposer", JjoonsScienceModBlocks.DECOMPOSER, DecomposerBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
