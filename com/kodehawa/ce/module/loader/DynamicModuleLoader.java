package com.kodehawa.ce.module.loader;

import com.kodehawa.ce.forge.common.Loader;
import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.handlers.ModuleManager;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid="cebaseloader", name="Cheating Essentials BL2", version="3.2.33a", useMetadata=true) //Gets mod data
public class DynamicModuleLoader {

    ClassLoader cLoader = CheatingEssentialsModule.class.getClassLoader();
    
    public DynamicModuleLoader( ){
    	
    }
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent e){
    	startClassLoading();
    }
    
    public void startClassLoading(){
    	try{
    		Class clazz = (Class<CheatingEssentialsModule>) cLoader.loadClass("com.kodehawa.ce.module.core.CheatingEssentialsModule");
    		CheatingEssentialsModule clazz1 = (CheatingEssentialsModule) clazz.newInstance();
    		ModuleManager.getInstance().modules.add(clazz1);
    	}
    	catch(Exception e){
    		Loader.instance().log("Failed to load class: " + e.toString());
    	}
    }
	
}
