package com.kodehawa.ce.module.classes;

import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;

public class Fullbright extends CheatingEssentialsModule {

	public Fullbright( ) {
		super("Full Bright", "No more darkness!", "1.6.2",
				Keyboard.KEY_F, EnumGuiCategory.WORLD, true);
	}

	@Override
	public void onEnableModule() {
        float[] brightness = getMinecraft().theWorld.provider.lightBrightnessTable;
        for(int i = 0; i < brightness.length; i++) {
            brightness[i] = 1.0F;
        }
	}

	@Override
	public void onDisableModule() {
		getMinecraft().theWorld.provider.registerWorld(Minecraft.getMinecraft().theWorld);
    }
}
