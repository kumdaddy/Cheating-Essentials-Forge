package com.kodehawa.ce.module.classes;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import org.lwjgl.input.Keyboard;

import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;
import com.kodehawa.ce.util.Utils;

public class NoDamage extends CheatingEssentialsModule {

	public NoDamage() {
		super("No Damage", "", "1.6.2", Keyboard.KEY_NONE, EnumGuiCategory.PLAYER, false);
	}
 
	public void onEnableModule(){
		Utils.getInstance().addChatMessage("[Cheating Essentials] [Module Warning] " +
				"THIS MODULE DISABLE DAMAGE IN ALL ENTITIES!");
	}
	
	public void onDisableModule(){}
	
	@ForgeSubscribe
	public void removeAllDamage(LivingDeathEvent e){
		for(Object o : getMinecraft().theWorld.loadedEntityList){
			if(o instanceof EntityPlayer){
				e.setCanceled(true);
			}
		}
	}
	
	@ForgeSubscribe
	public void removeAllDamage(LivingHurtEvent e){
		for(Object o : getMinecraft().theWorld.loadedEntityList){
			if(o instanceof EntityPlayer){
				e.setCanceled(true);
			}
		}
	}
}
