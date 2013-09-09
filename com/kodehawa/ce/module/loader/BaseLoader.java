package com.kodehawa.ce.module.loader;

import com.kodehawa.ce.forge.common.Loader;
import com.kodehawa.ce.module.classes.*;
import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.handlers.ModuleManager;

import cpw.mods.fml.common.Mod;

@Mod(modid="cebaseloader", name="Cheating Essentials BL2", version="3.2.33a", useMetadata=true) //Gets mod data
public final class BaseLoader {

	private volatile static BaseLoader instance;
	
    public BaseLoader( ){
		ModuleManager.getInstance().modules.clear();
		ModuleManager.getInstance().addModule(new CreativeFly( ) );
		ModuleManager.getInstance().addModule(new Fly( ) );
		ModuleManager.getInstance().addModule(new Test( ) );
		ModuleManager.getInstance().addModule(new FastPlace( ) );
		ModuleManager.getInstance().addModule(new Day( ) );
		ModuleManager.getInstance().addModule(new Spectator( ) );
		ModuleManager.getInstance().addModule(new NoFall( ));
		//ModuleManager.getInstance().addModule(new NoDamage( ) );
		ModuleManager.getInstance().addModule(new Sprint( ));
        ModuleManager.getInstance().addModule(new Unpushable( ));
        ModuleManager.getInstance().addModule(new Mobaura( ));
        ModuleManager.getInstance().addModule(new Waterwalk( ));
        ModuleManager.getInstance().addModule(new AutoRespawn( ));
        ModuleManager.getInstance().addModule(new Fullbright( ));
		ModuleManager.getInstance().addModule(new FastBreak( ));
		ModuleManager.getInstance().addModule(new ChestESP( ));
		ModuleManager.getInstance().addModule(new BlockESP( ));
		ModuleManager.getInstance().addModule(new MoarJump( ) );
		ModuleManager.getInstance().addModule(new PlayerESP( ));
		ModuleManager.getInstance().addModule(new MobESP( ));
		ModuleManager.getInstance().addModule(new Tracers( ));
        ModuleManager.getInstance().addModule(new Breadcrumb( ));
		ModuleManager.getInstance().addModule(new Step( ) );
        ModuleManager.getInstance().addModule(new UtilMobHitbox( ));
        ModuleManager.getInstance().addModule(new UtilReloadChunks( ));
        ModuleManager.getInstance().addModule(new UtilAdvancedTooltips(  ));
        ModuleManager.getInstance().addModule(new Gui());
        ModuleManager.getInstance().addModule(new Console());
        Loader.instance().log("Loaded " + ModuleManager.getInstance().modules.size() + " modules in Cheating Essentials" );
        disableModules();
    }

    public void disableModules(){
        for(CheatingEssentialsModule m : ModuleManager.getInstance().modules){
            if(!m.enabled){
                ModuleManager.getInstance().modules.remove(m);
            	Loader.instance().log("Disabled Module: " +m+ " for internal petition");
            }
            if(m.version != "1.6.2"){
            	ModuleManager.getInstance().modules.remove(m);
            	Loader.instance().log("Disabled Module: " +m+ ". Reached bad Minecraft version.");
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
