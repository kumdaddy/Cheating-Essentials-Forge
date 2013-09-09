package com.kodehawa.ce.module.classes;

import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingFallEvent;

import org.lwjgl.input.Keyboard;

import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;

public class NoFall extends CheatingEssentialsModule {

	public NoFall( ) {
		super("No Fall", "No fall damage", "1.6.2", Keyboard.KEY_V, 
				EnumGuiCategory.PLAYER, true);
	}

	@ForgeSubscribe
	public void removeFalling(LivingFallEvent e){
		if(isActive()){ 
			for(Object o : getMinecraft().theWorld.loadedEntityList) {
				if(o instanceof EntityClientPlayerMP && !(o instanceof EntityMob) && !(o instanceof EntityAnimal)){
					e.setCanceled(true);
				}
			}
		}
	}
}
