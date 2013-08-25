package com.kodehawa.module;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.kodehawa.CheatingEssentials;
import com.kodehawa.core.Strings;
import com.kodehawa.module.annotations.ModuleExperimental;
import com.kodehawa.util.Tickable;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public final class ModuleManager {

    public volatile CopyOnWriteArrayList<ModuleBase> modules;
    public CopyOnWriteArrayList<String> enabledModules = new CopyOnWriteArrayList<String>();
    public CopyOnWriteArrayList<Tickable> modInternalTicksArray = new CopyOnWriteArrayList<Tickable>();

    private volatile static ModuleManager instance;
	
	public ModuleManager( ){
        modules = new CopyOnWriteArrayList<ModuleBase>();

        CheatingEssentials.CELogAgent(
                "Module System: Starting in Cheating Essentials " + Strings.MOD_VERSION + " for Minecraft 1.6.2...");
    }
	
	public void addModule(final ModuleBase e) {
        synchronized (modules) {
            modules.add( e );
            if (e.getClass().isAnnotationPresent(ModuleExperimental.class)) {
           	 CheatingEssentials.CELogAgent("Module \"" + e.getName() + "\" is WIP! Use at own risk!");
           }
        }
	}

	public void removeModule(final ModuleBase e) {
        synchronized (modules) {
                modules.remove( e );
        }
	}
	
    public final ModuleBase getModuleByClass(final Class module) {
                synchronized (modules) {
                        for (final ModuleBase e : modules) {
                                if (e.getClass().equals(module)) {
                                        return e;
                                }
                        }
                }
                return null;
        }

     public final List<ModuleBase> getModules() {
                synchronized (modules) {
                        return Collections.unmodifiableList(modules);
                }
        }

    public void addToTick(Tickable tickable) {
        if (!modInternalTicksArray.contains(tickable))
        {
            modInternalTicksArray.add(tickable);
        }

    }

    public void removeFromCurrentTick(Tickable tickable) {
        if (modInternalTicksArray.contains(tickable))
        {
            modInternalTicksArray.remove(tickable);
        }
    }

 	public static ModuleManager getInstance(){
 		if(instance == null){
 			instance = new ModuleManager();
 		}
 		return instance;
 	}
 	
}
