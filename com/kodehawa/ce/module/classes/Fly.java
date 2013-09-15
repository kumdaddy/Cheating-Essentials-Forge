package com.kodehawa.ce.module.classes;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingFallEvent;

import org.lwjgl.input.Keyboard;

import com.kodehawa.ce.module.annotations.ModuleLoader;
import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;

public class Fly extends CheatingEssentialsModule {

	public Fly( ) {
		super("Fly", "Fly like a bird!", "1.6.2", Keyboard.KEY_R,
				EnumGuiCategory.PLAYER, true);
        super.setTick(true);
        incompat(DynamicFly.class);
	}

	@Override
    public void onEnableModule(){
		getMinecraft().thePlayer.capabilities.isFlying = true;
	}
	
	@Override
	public void onDisableModule(){
		getMinecraft().thePlayer.capabilities.isFlying = false;
	}
	
	@Override
	public void tick() {
		if(!getMinecraft().thePlayer.capabilities.isFlying){
			getMinecraft().thePlayer.capabilities.isFlying = true;
		}
	}
}
