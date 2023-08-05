
package net.mcreator.jjoonsscience.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class CraftingPlateItem extends Item {
	public CraftingPlateItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
