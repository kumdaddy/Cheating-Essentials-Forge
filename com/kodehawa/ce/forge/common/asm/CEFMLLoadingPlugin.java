package com.kodehawa.ce.forge.common.asm;

import java.util.Map;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.MCVersion;

@MCVersion(value = "1.6.2")
public class CEFMLLoadingPlugin implements IFMLLoadingPlugin {

    public static final String BlockTransformer = "com.kodehawa.ce.forge.common.asm.BlockTransformer";
	
	@Override
	public String[] getASMTransformerClass() {
		// TODO Auto-generated method stub
		return new String[]{
			//	BlockTransformer
		};
	}

	@Override
	public String getModContainerClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSetupClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void injectData(Map<String, Object> data) {
		// TODO Auto-generated method stub
		
	}
	@Override
	@Deprecated
	public
	String[] getLibraryRequestClass() {
		// TODO Auto-generated method stub
		return null;
	}

}
