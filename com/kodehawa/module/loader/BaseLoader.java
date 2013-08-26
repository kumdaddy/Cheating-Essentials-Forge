package com.kodehawa.module.loader;

import com.kodehawa.CheatingEssentials;
import com.kodehawa.module.annotations.ModuleLoader;
import com.kodehawa.module.classes.AutoRespawn;
import com.kodehawa.module.classes.BlockESP;
import com.kodehawa.module.classes.Breadcrumb;
import com.kodehawa.module.classes.ChestESP;
import com.kodehawa.module.classes.CreativeFly;
import com.kodehawa.module.classes.FastBreak;
import com.kodehawa.module.classes.Fly;
import com.kodehawa.module.classes.Fullbright;
import com.kodehawa.module.classes.Gui;
import com.kodehawa.module.classes.MobESP;
import com.kodehawa.module.classes.Mobaura;
import com.kodehawa.module.classes.NoFall;
import com.kodehawa.module.classes.PlayerESP;
import com.kodehawa.module.classes.Sprint;
import com.kodehawa.module.classes.Tracers;
import com.kodehawa.module.classes.Unpushable;
import com.kodehawa.module.classes.UtilAdvancedTooltips;
import com.kodehawa.module.classes.UtilMobHitbox;
import com.kodehawa.module.classes.UtilReloadChunks;
import com.kodehawa.module.classes.Waterwalk;
import com.kodehawa.module.classes.Xray;
import com.kodehawa.module.core.CheatingEssentialsModule;
import com.kodehawa.module.handlers.ModuleManager;

public final class BaseLoader {

	private volatile static BaseLoader instance;
	
	@ModuleLoader(type = "Charger")
    public BaseLoader( ){
		ModuleManager.getInstance().addModule(new CreativeFly( ) );
		ModuleManager.getInstance().addModule(new Fly( ) );
		ModuleManager.getInstance().addModule(new NoFall( ));
		ModuleManager.getInstance().addModule(new Sprint( ));
        ModuleManager.getInstance().addModule(new Unpushable( ));
        ModuleManager.getInstance().addModule(new Waterwalk( ));
        ModuleManager.getInstance().addModule(new Mobaura());
        ModuleManager.getInstance().addModule(new AutoRespawn( ));
        ModuleManager.getInstance().addModule(new Xray( ));
        ModuleManager.getInstance().addModule(new Fullbright( ));
		ModuleManager.getInstance().addModule(new FastBreak( ));
		ModuleManager.getInstance().addModule(new ChestESP( ));
		ModuleManager.getInstance().addModule(new BlockESP( ));
		ModuleManager.getInstance().addModule(new PlayerESP( ));
		ModuleManager.getInstance().addModule(new MobESP( ));
		ModuleManager.getInstance().addModule(new Tracers( ));
        ModuleManager.getInstance().addModule(new Breadcrumb( ));
        ModuleManager.getInstance().addModule(new UtilMobHitbox( ));
        ModuleManager.getInstance().addModule(new UtilReloadChunks( ));
        ModuleManager.getInstance().addModule(new UtilAdvancedTooltips(  ));
        ModuleManager.getInstance().addModule(new Gui());
        disableModules();
        CheatingEssentials.CELogAgent("Loaded " + ModuleManager.getInstance().modules.size() + " modules in Cheating Essentials" );
    }

    public void disableModules(){
        for(CheatingEssentialsModule m : ModuleManager.getInstance().modules){
            if(!m.enabled){
                CheatingEssentials.CELogAgent("Disabled Module: " +m+ " for internal petition");
                ModuleManager.getInstance().removeModule(m);
            }
        }
    }

    public static void keyInit(){
        for(CheatingEssentialsModule m : ModuleManager.getInstance().modules){
            m.getKeybinding();
        }
    }

	public static BaseLoader getInstance(){
		if(instance == null){
			instance = new BaseLoader();
		}
	    return instance;
	}
}
