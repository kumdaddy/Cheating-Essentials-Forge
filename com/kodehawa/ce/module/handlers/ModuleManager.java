package com.kodehawa.ce.module.handlers;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.commons.lang3.StringUtils;

import com.kodehawa.ce.forge.loader.CE_ForgeLoader;
import com.kodehawa.ce.module.annotations.ModuleExperimental;
import com.kodehawa.ce.module.annotations.ModuleTechnical;
import com.kodehawa.ce.module.classes.AutoRespawn;
import com.kodehawa.ce.module.classes.BlockESP;
import com.kodehawa.ce.module.classes.Breadcrumb;
import com.kodehawa.ce.module.classes.ChestESP;
import com.kodehawa.ce.module.classes.Console;
import com.kodehawa.ce.module.classes.CreativeFly;
import com.kodehawa.ce.module.classes.Day;
import com.kodehawa.ce.module.classes.DynamicFly;
import com.kodehawa.ce.module.classes.FastBreak;
import com.kodehawa.ce.module.classes.FastPlace;
import com.kodehawa.ce.module.classes.Fly;
import com.kodehawa.ce.module.classes.Fullbright;
import com.kodehawa.ce.module.classes.Gui;
import com.kodehawa.ce.module.classes.Invisible;
import com.kodehawa.ce.module.classes.MoarJump;
import com.kodehawa.ce.module.classes.MobESP;
import com.kodehawa.ce.module.classes.Mobaura;
import com.kodehawa.ce.module.classes.NoFall;
import com.kodehawa.ce.module.classes.NoSlowDown;
import com.kodehawa.ce.module.classes.PacketNoFall;
import com.kodehawa.ce.module.classes.PlayerESP;
import com.kodehawa.ce.module.classes.Spectator;
import com.kodehawa.ce.module.classes.Sprint;
import com.kodehawa.ce.module.classes.Step;
import com.kodehawa.ce.module.classes.Tracers;
import com.kodehawa.ce.module.classes.Unpushable;
import com.kodehawa.ce.module.classes.UtilAdvancedTooltips;
import com.kodehawa.ce.module.classes.UtilMobHitbox;
import com.kodehawa.ce.module.classes.UtilReloadChunks;
import com.kodehawa.ce.module.classes.Waterwalk;
import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.util.Tickable;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
@Mod(modid = "CE-ModuleManager", name = "Cheating Essentials MM",
dependencies = "after:Cheating-Essentials", version = "3.3.3a1")
public final class ModuleManager {

	public HashMap<Class<? extends CheatingEssentialsModule>, String> modulesHash = new HashMap<Class<? extends CheatingEssentialsModule>, String>();
    public volatile List<CheatingEssentialsModule> modules = new CopyOnWriteArrayList<CheatingEssentialsModule>();
    public List<String> enabledModules = new CopyOnWriteArrayList<String>();
    public List<Tickable> modInternalTicksArray = new CopyOnWriteArrayList<Tickable>();

    private volatile static ModuleManager instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent evt){
		ModMetadata modMeta = evt.getModMetadata();
		modMeta.parent = "Cheating-Essentials";    	
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

