package com.kodehawa.module.test;

import com.kodehawa.module.ModuleBase;

/**
 * Created with IntelliJ IDEA.
 * User: Kodehawa
 * Date: 22-08-13
 * Time: 08:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class World_Apeteporico extends ModuleBase {
    public World_Apeteporico( ) {
        super("Apeteporico", "", -1);
    }

    @Override
    public void onEnableModule() {
        System.out.println("test");
    }

    @Override
    public void onDisableModule() {
    }
}
