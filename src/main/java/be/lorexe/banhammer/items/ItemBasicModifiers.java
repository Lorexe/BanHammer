package be.lorexe.banhammer.items;

import be.lorexe.banhammer.BanHammer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBasicModifiers extends Item {
	
	protected String name;
	
	public ItemBasicModifiers(String name) {
		this.name = name;
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		
		this.setCreativeTab(BanHammer.creativeTab);
	}
	
	public void registerItemModel() {
		BanHammer.proxy.registerItemRenderer(this, 0, name);
	}
}
