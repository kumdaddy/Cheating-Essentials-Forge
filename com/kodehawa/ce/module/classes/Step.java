package com.kodehawa.ce.module.classes;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

import org.lwjgl.input.Keyboard;

import com.kodehawa.ce.api.reflection.ReflectorHelper;
import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;

public class Step extends CheatingEssentialsModule {

	public static float STEP_HEIGHT = 1.0F;

	/**
	 * Change {@link EntityClientPlayerMP} or {@link EntityPlayer} step or block auto jump value to a configurable value. 
	 *  Accessed through reflection because getMinecraft().thePlayer.stepHeight doesn't seem to work correctly.
	 * Implementation of {@link Entity} for {@link CheatingEssentials}
	 * @author Kodehawa
	 */
	public Step( ) {
		super("Step", "More than a slab!", "1.6.2", Keyboard.KEY_NUMPAD1,
				EnumGuiCategory.PLAYER, true);
        super.setTick(true);
	}

    public static void setStepHeight( float f ){
        STEP_HEIGHT = f;
    }

	@Override
	public void onEnableModule(){}
	
	@Override
	public void onDisableModule(){
		for(Object o : getMinecraft().theWorld.loadedEntityList){
			if(o instanceof EntityPlayer){
		        ReflectorHelper.setField(Entity.class, o, 42, 0.5F);
			}
		}
	}

	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		for(Object o : getMinecraft().theWorld.loadedEntityList){
			if(o instanceof EntityPlayer){
		        ReflectorHelper.setField(Entity.class, o, 42, STEP_HEIGHT);
			}
		}
	}	
}
