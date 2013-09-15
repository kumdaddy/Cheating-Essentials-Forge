package com.kodehawa.ce.module.classes;

import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.EntityLivingBase;

import org.lwjgl.input.Keyboard;

import com.kodehawa.ce.api.reflection.ReflectorHelper;
import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;

public class DynamicFly extends CheatingEssentialsModule {

	public DynamicFly() {
		super("Dynamic Fly", "Just without killing jarva!", "1.6.2", Keyboard.KEY_NONE, EnumGuiCategory.PLAYER, true);
		this.setTick(true);
		incompat(Fly.class);
	}
	
	public void tick(){
		
		EntityClientPlayerMP thePlayer = getPlayer();
		Object o = getPlayer();
		
		thePlayer.jumpMovementFactor = 0.5F;
		ReflectorHelper.setField(EntityLivingBase.class, o, 56, 0.5F);
		thePlayer.capabilities.isFlying = false;
		thePlayer.setSneaking(false);
		thePlayer.motionX = 0;
		thePlayer.motionY = 0;
		thePlayer.motionZ = 0;
		
		if(getMinecraft().currentScreen == null){
			if(getMinecraft().gameSettings.keyBindJump.pressed) {
                thePlayer.motionY += 1;
            }
            if(getMinecraft().gameSettings.keyBindSneak.pressed) {
                thePlayer.motionY -= 1;
            }
		}
		
		thePlayer.jumpMovementFactor *= 2.1D;
	}
}
