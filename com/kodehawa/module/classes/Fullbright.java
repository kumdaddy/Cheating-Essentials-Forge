package com.kodehawa.module.classes;

import net.minecraft.client.Minecraft;

import org.lwjgl.input.Keyboard;

import com.kodehawa.CheatingEssentials;
import com.kodehawa.module.core.CheatingEssentialsModule;
import com.kodehawa.module.enums.EnumGuiCategory;

public class Fullbright extends CheatingEssentialsModule {

	public Fullbright( ) {
		super("Full Bright", "No more darkness!", "1.6.2",
				Keyboard.KEY_F, EnumGuiCategory.WORLD, true);
	}

	@Override
	public void onEnableModule() {
        float[] brightness = CheatingEssentials.getMinecraftInstance().theWorld.provider.lightBrightnessTable;
        for(int i = 0; i < brightness.length; i++) {
            brightness[i] = 1.0F;
        }
	}

	@Override
	public void onDisableModule() {
        CheatingEssentials.getMinecraftInstance().theWorld.provider.registerWorld(Minecraft.getMinecraft().theWorld);
    }
}
