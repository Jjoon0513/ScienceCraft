
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jjoonsscience.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.jjoonsscience.client.gui.DecomposerGuiScreen;
import net.mcreator.jjoonsscience.client.gui.AirCollectorGuiScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class JjoonsScienceModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(JjoonsScienceModMenus.AIR_COLLECTOR_GUI.get(), AirCollectorGuiScreen::new);
			MenuScreens.register(JjoonsScienceModMenus.DECOMPOSER_GUI.get(), DecomposerGuiScreen::new);
		});
	}
}
