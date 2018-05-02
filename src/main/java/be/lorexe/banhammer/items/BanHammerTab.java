package be.lorexe.banhammer.items;

import be.lorexe.banhammer.BanHammer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class BanHammerTab extends CreativeTabs {

	public BanHammerTab() {
		super(BanHammer.modId);
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.banModifier);
	}
}
