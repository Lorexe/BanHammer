package be.lorexe.banhammer.items;

import be.lorexe.banhammer.BanHammer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
	
	public static ItemBasicModifiers banModifier = new ItemBasicModifiers("ban_modifier");
	public static ItemBasicModifiers kickModifier = new ItemBasicModifiers("kick_modifier");
	
	public static void register(IForgeRegistry<Item> registry) {
		registry.registerAll(
			banModifier,
			kickModifier
		);
	}
	
	public static void registerModels() {
		banModifier.registerItemModel();
		kickModifier.registerItemModel();
	}
}
