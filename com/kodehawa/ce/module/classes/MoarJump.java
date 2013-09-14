package com.kodehawa.ce.module.classes;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

import org.lwjgl.input.Keyboard;

import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;

public class MoarJump extends CheatingEssentialsModule {

	public MoarJump( ) {
		super("High Jump", "", "1.6.2", Keyboard.KEY_NONE, EnumGuiCategory.PLAYER, true);
	}
	
	//Simple, no?
	public void onEnableModule(){
		getPlayer().addPotionEffect(new PotionEffect(Potion.jump.getId(), 999999, 2));
	}
	
	public void onDisableModule(){
		getPlayer().removePotionEffect(8);
    }
}

