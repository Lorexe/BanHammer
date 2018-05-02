package be.lorexe.banhammer.modifiers;

import be.lorexe.banhammer.items.ModItems;
import net.minecraft.command.CommandServerKick;
import slimeknights.tconstruct.library.modifiers.Modifier;

public class ModModifiers {
	public static Modifier banModifier;
	public static Modifier kickModifier;
	
	public static void createModifiers() {
		banModifier = new ModBan();
		banModifier.addItem(ModItems.banModifier);
		
		kickModifier = new ModKick();
		kickModifier.addItem(ModItems.kickModifier);
	}
}
