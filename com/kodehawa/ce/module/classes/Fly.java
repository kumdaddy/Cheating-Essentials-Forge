package com.kodehawa.ce.module.classes;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingFallEvent;

import org.lwjgl.input.Keyboard;

import com.kodehawa.ce.CheatingEssentials;
import com.kodehawa.ce.module.annotations.ModuleLoader;
import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;

public class Fly extends CheatingEssentialsModule {

	@ModuleLoader(type = "Module")
	public Fly( ) {
		super("Fly", "Fly like a bird!", "1.6.2", Keyboard.KEY_R,
				EnumGuiCategory.PLAYER, true);
        super.setTick(true);
	}
    
	
	@ForgeSubscribe
	public void removeFalling(LivingFallEvent e){
			for(Object o : CheatingEssentials.getMinecraftInstance().theWorld.loadedEntityList) {
				if(o instanceof EntityPlayer){
					e.setCanceled(true);
				}
		}
	}

	@Override
    public void onEnableModule(){
		CheatingEssentials.getMinecraftInstance().thePlayer.capabilities.isFlying = true;
	}
	
	@Override
	public void onDisableModule(){
		CheatingEssentials.getMinecraftInstance().thePlayer.capabilities.isFlying = false;
	}
	
	@Override
	public void tick() {
		if(!CheatingEssentials.getMinecraftInstance().thePlayer.capabilities.isFlying){
			CheatingEssentials.getMinecraftInstance().thePlayer.capabilities.isFlying = true;
		}
	}
}
