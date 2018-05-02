package be.lorexe.banhammer.modifiers;

import be.lorexe.banhammer.BanHammer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class ModKick extends AbstractTrait {
	
	public ModKick() {
		super("banhammer.kick", 10289152);
		
		TinkerRegistry.addTrait(this);
		
		this.aspects.clear();
		addAspects(new ModifierAspect[] {new ModifierAspect.MultiAspect(this, 10289152, 1, 1, 1)});
	}
	
	@Override
	public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
		
		if(!player.getEntityWorld().isRemote &&
			target instanceof EntityPlayerMP && 
			(BanHammer.instance.config.canPlayerKick || player.canUseCommand(2, "kick"))) {
			
			EntityPlayerMP p = (EntityPlayerMP) target;
			
			ITextComponent reason = new TextComponentString(BanHammer.instance.config.onKick);
			p.connection.disconnect(reason);
			
			return 0.0F;
		}
		
		return super.damage(tool, player, target, damage, newDamage, isCritical);
	}
	
	@Override
	public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {
		super.applyEffect(rootCompound, modifierTag);
	}
}
