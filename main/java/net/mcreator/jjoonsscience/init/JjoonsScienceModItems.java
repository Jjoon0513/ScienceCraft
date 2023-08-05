
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jjoonsscience.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.jjoonsscience.item.MyTurnItem;
import net.mcreator.jjoonsscience.item.BottleOfOxygenItem;
import net.mcreator.jjoonsscience.item.AirBottleItem;
import net.mcreator.jjoonsscience.JjoonsScienceMod;

public class JjoonsScienceModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, JjoonsScienceMod.MODID);
	public static final RegistryObject<Item> AIR_COLLECTOR = block(JjoonsScienceModBlocks.AIR_COLLECTOR);
	public static final RegistryObject<Item> BOTTLE_OF_AIR = REGISTRY.register("bottle_of_air", () -> new AirBottleItem());
	public static final RegistryObject<Item> DECOMPOSER = block(JjoonsScienceModBlocks.DECOMPOSER);
	public static final RegistryObject<Item> MY_TURN = REGISTRY.register("my_turn", () -> new MyTurnItem());
	public static final RegistryObject<Item> BOTTLE_OF_OXYGEN = REGISTRY.register("bottle_of_oxygen", () -> new BottleOfOxygenItem());
	public static final RegistryObject<Item> CRAFTING_PLATE = REGISTRY.register("crafting_plate", () -> new CraftingPlateItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
