package be.lorexe.banhammer.modifiers;

import be.lorexe.banhammer.BanHammer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.client.texture.TextureColoredTexture;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class ModBan extends AbstractTrait {
	
	public ModBan() {
		super("banhammer.ban", 10289152);
		
		TinkerRegistry.addTrait(this);
		
		this.aspects.clear();
		addAspects(new ModifierAspect[] {new ModifierAspect.MultiAspect(this, 10289152, 1, 1, 1)});
	}
	
	@Override
	public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
		
		if(!player.getEntityWorld().isRemote && target instanceof EntityPlayerMP) {
			EntityPlayerMP p = (EntityPlayerMP) target;
			p.getServer().getCommandManager().executeCommand(player, "ban " + p.getName() + " " + BanHammer.instance.config.onBan);
			
			return 0.0F;
		}
		
		return super.damage(tool, player, target, damage, newDamage, isCritical);
	}
	
	@Override
	public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {
		super.applyEffect(rootCompound, modifierTag);
	}
}
