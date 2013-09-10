package com.kodehawa.ce.module.classes;

import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import org.lwjgl.input.Keyboard;

import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;

public class AutoTool extends CheatingEssentialsModule {

	public AutoTool() {
		super("Auto Tool", "", "1.6.2", Keyboard.KEY_NONE, EnumGuiCategory.PLAYER, true);
		setTick(true);
	}

	public void tick(){
		int x = getMinecraft().objectMouseOver.blockX;
		int y = getMinecraft().objectMouseOver.blockY;
		int z = getMinecraft().objectMouseOver.blockZ;
		//if()
		getMinecraft().playerController.onPlayerDamageBlock(x, y, z, 0);
		
	}
}
