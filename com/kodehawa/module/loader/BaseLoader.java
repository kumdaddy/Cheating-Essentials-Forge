package com.kodehawa.module.loader;

import com.kodehawa.CheatingEssentials;
import com.kodehawa.module.ModuleBase;
import com.kodehawa.module.ModuleManager;
import com.kodehawa.module.annotations.ModuleLoader;
import com.kodehawa.module.classes.*;

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
        ModuleManager.getInstance().addModule(new Spectator());
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
        CheatingEssentials.CELogAgent("Loaded " + ModuleManager.getInstance().modules.size() + " modules in Cheating Essentials succefully" );
    }

    public void disableModules(){
        for(ModuleBase m : ModuleManager.getInstance().modules){
            if(!m.enabled){
                CheatingEssentials.CELogAgent("Disabled Module: " +m+ " for internal petition");
                ModuleManager.getInstance().removeModule(m);
            }
        }
    }

    public static void keyInit(){
        for(ModuleBase m : ModuleManager.getInstance().modules){
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
