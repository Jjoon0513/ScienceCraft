
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jjoonsscience.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.jjoonsscience.world.inventory.DecomposerGuiMenu;
import net.mcreator.jjoonsscience.world.inventory.AirCollectorGuiMenu;
import net.mcreator.jjoonsscience.JjoonsScienceMod;

public class JjoonsScienceModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, JjoonsScienceMod.MODID);
	public static final RegistryObject<MenuType<AirCollectorGuiMenu>> AIR_COLLECTOR_GUI = REGISTRY.register("air_collector_gui", () -> IForgeMenuType.create(AirCollectorGuiMenu::new));
	public static final RegistryObject<MenuType<DecomposerGuiMenu>> DECOMPOSER_GUI = REGISTRY.register("decomposer_gui", () -> IForgeMenuType.create(DecomposerGuiMenu::new));
}
