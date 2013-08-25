package com.kodehawa.module.classes;

import net.minecraft.potion.PotionEffect;

import org.lwjgl.input.Keyboard;

import com.kodehawa.CheatingEssentials;
import com.kodehawa.module.ModuleBase;
import com.kodehawa.module.annotations.ModuleLoader;
import com.kodehawa.module.enums.EnumGuiCategory;

public class FastBreak extends ModuleBase {

	@ModuleLoader(type = "Module")
	public FastBreak( ) {
		super("Fast Break", "Break ALL blocks <3", "1.6.2", Keyboard.KEY_B,
				EnumGuiCategory.WORLD, true);
	}

	
	@Override
	public void onEnableModule(){
		CheatingEssentials.getMinecraftInstance().thePlayer.addPotionEffect( new PotionEffect( 3, 99999999, 2 ) );
	}
	
	@Override
	public void onDisableModule(){
		CheatingEssentials.getMinecraftInstance().thePlayer.removePotionEffect( 3 );
	}

}
