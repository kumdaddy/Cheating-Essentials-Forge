package com.kodehawa.ce.module.classes;

import org.lwjgl.input.Keyboard;

import com.kodehawa.ce.module.annotations.ModuleLoader;
import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;

public class Step extends CheatingEssentialsModule {

	public static float STEP_HEIGHT = 1.0F;

	@ModuleLoader(type = "Module")
	public Step( ) {
		super("Step", "More than a slab!", "1.6.2", Keyboard.KEY_NUMPAD1,
				EnumGuiCategory.PLAYER, true);
		// TODO Auto-generated constructor stub
        super.setTick(true);
	}

    public static void setStepHeight( float f ){
        STEP_HEIGHT = f;
    }

	@Override
	public void onEnableModule(){
	}
	
	@Override
	public void onDisableModule(){
		//setStep(0.5F);
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		//setStep(STEP_HEIGHT);
	}
	

}
