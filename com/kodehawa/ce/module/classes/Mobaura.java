package com.kodehawa.ce.module.classes;

import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

import org.lwjgl.input.Keyboard;

import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;
import com.kodehawa.ce.util.EntityUtils;
import com.kodehawa.ce.util.Watcher;

public class Mobaura extends CheatingEssentialsModule {

	public Mobaura( ) {
		super("Mob Aura", "", "1.6.2", Keyboard.KEY_L,
				EnumGuiCategory.PLAYER, true);
        super.setTick(true);
	}

	public static double AURA_DISTANCE = 90D;
	
	public static void setAuraDistance( double thing ){
		AURA_DISTANCE = thing;
	}
	
	@Override
	public void tick() {
		for (int i = 0; i < getMinecraft().theWorld.loadedEntityList.size(); i++)
        {
            Entity ent = (Entity) getMinecraft().theWorld.loadedEntityList.get(i);
            int id = ent.entityId;
            long now = System.currentTimeMillis();
            Watcher tracked = EntityUtils.getLastAffected(id);

            if (tracked != null)
            {
                if (tracked.matches(ent, now))
                {
                    continue;
                }
            }

            EntityUtils.setLastAffected(id, ent);

            if ((ent == getMinecraft().thePlayer) || !(ent instanceof EntityLiving) || ent.isDead/* || ent instanceof EntityOtherPlayerMP <- Lol I released a version with that in MCF?*/ )
            {
                continue;
            }

            if ((getDistanceSqToEntity(ent) <= AURA_DISTANCE) && !ent.isDead && getMinecraft().thePlayer.canEntityBeSeen(ent))
            {
            	getMinecraft().playerController.attackEntity(getMinecraft().thePlayer, ent);
            	
            }
        } 
	}

	@Override
	public void onEnableModule() {}

	@Override
	public void onDisableModule() {}

}
