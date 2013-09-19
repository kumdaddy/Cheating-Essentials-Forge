package com.kodehawa.ce.module.loader;

import com.kodehawa.ce.forge.loader.CE_ForgeLoader;
import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.handlers.ModuleManager;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class DynamicModuleLoader {

    ClassLoader cLoader = CheatingEssentialsModule.class.getClassLoader();
    
    public DynamicModuleLoader( ){
    	
    }
    
    public void startClassLoading(){
    	try{
    		Class clazz = (Class<CheatingEssentialsModule>) cLoader.loadClass("com.kodehawa.ce.module.core.CheatingEssentialsModule");
    		CheatingEssentialsModule clazz1 = (CheatingEssentialsModule) clazz.newInstance();
    		ModuleManager.getInstance().modules.add(clazz1);
    	}
    	catch(Exception e){
    		CE_ForgeLoader.instance().log("Failed to load class: " + e.toString());
    	}
    }
	
}
