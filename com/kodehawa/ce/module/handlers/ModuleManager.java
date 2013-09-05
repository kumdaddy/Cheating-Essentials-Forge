package com.kodehawa.ce.module.handlers;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.kodehawa.ce.CheatingEssentials;
import com.kodehawa.ce.core.Strings;
import com.kodehawa.ce.module.annotations.ModuleExperimental;
import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.util.Tickable;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
@Mod(modid = "cemodulemanager", name = "Cheating Essentials MM",
dependencies = "before:cebaseloader", version = "1.0.0")
public final class ModuleManager {

    public volatile CopyOnWriteArrayList<CheatingEssentialsModule> modules;
    public CopyOnWriteArrayList<String> enabledModules = new CopyOnWriteArrayList<String>();
    public CopyOnWriteArrayList<Tickable> modInternalTicksArray = new CopyOnWriteArrayList<Tickable>();

    private volatile static ModuleManager instance;
	
	public ModuleManager( ){
        modules = new CopyOnWriteArrayList<CheatingEssentialsModule>();
    }
	
	public void addModule(final CheatingEssentialsModule e) {
        synchronized (modules) {
            modules.add( e );
              if (e.getClass().isAnnotationPresent(ModuleExperimental.class)) {
           	 CheatingEssentials.CELogAgent("Module \"" + e.getName() + "\" is WIP! Use at own risk!");
           }
        }
	}

	public void removeModule(final CheatingEssentialsModule e) {
        synchronized (modules) {
                modules.remove( e );
        }
	}
	
    public final CheatingEssentialsModule getModuleByClass(final Class module) {
                synchronized (modules) {
                        for (final CheatingEssentialsModule e : modules) {
                                if (e.getClass().equals(module)) {
                                        return e;
                                }
                        }
                }
                return null;
        }

     public final List<CheatingEssentialsModule> getModules() {
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

