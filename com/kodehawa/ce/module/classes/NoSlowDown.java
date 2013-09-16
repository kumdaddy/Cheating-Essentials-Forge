package com.kodehawa.ce.module.classes;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;

import org.lwjgl.input.Keyboard;

import com.kodehawa.ce.module.annotations.ModuleExperimental;
import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;
import com.kodehawa.ce.reflect.ReflectionHelper;

@ModuleExperimental
public class NoSlowDown extends CheatingEssentialsModule {

	//TODO: Make it works?
	
	public NoSlowDown( ) {
		super("No SlowDown", "", "1.6.2", Keyboard.KEY_NONE, EnumGuiCategory.PLAYER, true);
		this.setTick(true);
	}

	public void tick(){
		Object o = getPlayer();
		//Reflection: isInWeb field.
		ReflectionHelper.setField(Entity.class, o, 27, false);
		if(getPlayer().isInWater()){
		}
		if(getMinecraft().theWorld.getBlockId((int)getPlayer().posX, 
				(int)getPlayer().posY, (int)getPlayer().posZ) == Block.slowSand.blockID){
		}
	}
}
