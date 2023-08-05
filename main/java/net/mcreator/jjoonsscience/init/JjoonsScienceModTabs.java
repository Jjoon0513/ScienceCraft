
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jjoonsscience.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.CreativeModeTabEvent;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class JjoonsScienceModTabs {
	@SubscribeEvent
	public static void buildTabContentsModded(CreativeModeTabEvent.Register event) {
		event.registerCreativeModeTab(new ResourceLocation("jjoons_science", "jjoons_science"),
				builder -> builder.title(Component.translatable("item_group.jjoons_science.jjoons_science")).icon(() -> new ItemStack(Items.WATER_BUCKET)).displayItems((parameters, tabData) -> {
					tabData.accept(JjoonsScienceModBlocks.AIR_COLLECTOR.get().asItem());
					tabData.accept(JjoonsScienceModItems.BOTTLE_OF_AIR.get());
					tabData.accept(JjoonsScienceModBlocks.DECOMPOSER.get().asItem());
					tabData.accept(JjoonsScienceModItems.MY_TURN.get());
					tabData.accept(JjoonsScienceModItems.BOTTLE_OF_OXYGEN.get());
					tabData.accept(JjoonsScienceModItems.CRAFTING_PLATE.get());
				}).withSearchBar());
	}
}
