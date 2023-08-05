
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jjoonsscience.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.jjoonsscience.block.DecomposerBlock;
import net.mcreator.jjoonsscience.block.AirCollectorBlock;
import net.mcreator.jjoonsscience.JjoonsScienceMod;

public class JjoonsScienceModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, JjoonsScienceMod.MODID);
	public static final RegistryObject<Block> AIR_COLLECTOR = REGISTRY.register("air_collector", () -> new AirCollectorBlock());
	public static final RegistryObject<Block> DECOMPOSER = REGISTRY.register("decomposer", () -> new DecomposerBlock());
}
