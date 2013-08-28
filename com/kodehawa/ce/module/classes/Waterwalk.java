package com.kodehawa.ce.module.classes;

import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLivingBase;

import org.lwjgl.input.Keyboard;

import com.kodehawa.ce.CheatingEssentials;
import com.kodehawa.ce.api.reflection.ReflectorHelper;
import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;

public class Waterwalk extends CheatingEssentialsModule {

	public Waterwalk( ) {
		super("Water Walk", "", "1.6.2", Keyboard.KEY_J, EnumGuiCategory.WORLD, true);
        super.setTick(true);
	}

	@Override
	public void tick() {
		if (getPlayer().isInWater())
        {
            getPlayer().setSprinting(false);
            try{
                for(Object o : getMinecraft().theWorld.loadedEntityList)  {
                    if(o instanceof EntityPlayerSP || o instanceof EntityClientPlayerMP){
                       ReflectorHelper.getPrivateMethod(EntityLivingBase.class, o, "jump" );
                    }
                }
            }
            catch (Exception e){
                CheatingEssentials.CELogAgent("First failures in reflection code.");
            }
            getPlayer().motionY /= 2;
        } 
	}

	@Override
	public void onEnableModule() {
	}

	@Override
	public void onDisableModule() {
	}

}
