package com.kodehawa.ce.module.classes;

import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

import com.kodehawa.ce.api.reflection.ReflectorHelper;
import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;

public class FastPlace extends CheatingEssentialsModule {

	public FastPlace( ) {
		super("Fast Place", "", "1.6.2", Keyboard.KEY_K, EnumGuiCategory.WORLD, true);
		super.setTick(true);
	}
	public String[] greeting = { "you", "are", "not", "a", "f*ck", "nut" };

	@Override
	public void onEnableModule(){}
	
	@Override
	public void onDisableModule(){
		System.out.println(greeting[5] + " " + greeting[1]);
		Object o = Minecraft.getMinecraft();
		        ReflectorHelper.setField(Minecraft.class, o, 47, 0);
	}
	
	@Override
	public void tick() {
		Object o = Minecraft.getMinecraft();
		     ReflectorHelper.setField(Minecraft.class, o, 47, 0);
		}
	}
