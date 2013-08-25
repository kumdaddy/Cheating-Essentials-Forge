package com.kodehawa.module.classes;

import com.kodehawa.module.ModuleBase;
import com.kodehawa.module.enums.EnumGuiCategory;
import com.kodehawa.util.Tickable;

public class Test extends ModuleBase implements Tickable {

	public Test(String name, String desc, String version, int key,
			EnumGuiCategory type, boolean enabled) {
		super(name, desc, version, key, type, enabled);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
	}

	@Override
	public void onEnableModule() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDisableModule() {
		// TODO Auto-generated method stub
		
	}

}
