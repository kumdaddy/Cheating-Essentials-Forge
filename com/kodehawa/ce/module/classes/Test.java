package com.kodehawa.ce.module.classes;

import net.minecraftforge.client.ForgeHooksClient;

import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;

/**
 * Test class, mostly used when I need to test something for add it or create a new module
 * The content of onEnableModule, onDisableModule or tick gets deleted before push a new
 * commit on GitHub. As obvious it extends {@link CheatingEssentialsModule}, due to it means
 * to be taked for the GUI's as a module.
 */
public class Test extends CheatingEssentialsModule {
		
	public Test() {
		super("Test Class", "", EnumGuiCategory.UTILS, true);
		super.setTick(true);
		super.setRender(true);
	}
 	
	@Override
	public void onEnableModule(){}
	
	@Override
    public void onDisableModule(){
		ForgeHooksClient.getOffsetFOV(getPlayer(), 0);
	}
    
	@Override
    public void tick(){
		ForgeHooksClient.getOffsetFOV(getPlayer(), 1.0F);
	}


	@Override
    public void onRenderInModule(){}
}
