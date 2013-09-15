package com.kodehawa.ce.module.classes;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.kodehawa.ce.api.reflection.ReflectorHelper;
import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;

public class NoSlowDown extends CheatingEssentialsModule {

	//TODO: Make it works?
	
	public NoSlowDown( ) {
		super("No SlowDown", "", "1.6.2", Keyboard.KEY_NONE, EnumGuiCategory.PLAYER, true);
		this.setTick(true);
	}

	public void tick(){
		Object o = getPlayer();
		ReflectorHelper.setField(Entity.class, o, 27, false);
		if(getPlayer().isInWater()){
		}
		if(getMinecraft().theWorld.getBlockId((int)getPlayer().posX, 
				(int)getPlayer().posY, (int)getPlayer().posZ) == Block.slowSand.blockID){
		}
	}
}
