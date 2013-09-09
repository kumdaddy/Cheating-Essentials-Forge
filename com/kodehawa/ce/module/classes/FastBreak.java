package com.kodehawa.ce.module.classes;

import net.minecraft.potion.PotionEffect;

import org.lwjgl.input.Keyboard;

import com.kodehawa.ce.module.annotations.ModuleLoader;
import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;

public class FastBreak extends CheatingEssentialsModule {

	@ModuleLoader(type = "Module")
	public FastBreak( ) {
		super("Fast Break", "Break ALL blocks <3", "1.6.2", Keyboard.KEY_B,
				EnumGuiCategory.WORLD, true);
	}

	
	@Override
	public void onEnableModule(){
		getMinecraft().thePlayer.addPotionEffect( new PotionEffect( 3, 99999999, 2 ) );
	}
	
	@Override
	public void onDisableModule(){
		getMinecraft().thePlayer.removePotionEffect( 3 );
	}

}
