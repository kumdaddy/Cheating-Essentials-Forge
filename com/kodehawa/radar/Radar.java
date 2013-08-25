package com.kodehawa.radar;

import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;

import org.lwjgl.opengl.GL11;

import com.kodehawa.CheatingEssentials;
import com.kodehawa.gui.api.render.ModGuiUtils;
import com.kodehawa.playerrelations.Enemy;
import com.kodehawa.playerrelations.Friend;

public class Radar extends Thread {

	private static int tick = 0;
	
	 public static void drawRadar( ) {
			tick++ ;
			if ( tick >= 50 ) {
				tick = 0;
			}
			
			GL11.glLineWidth( 1.0F );
			ModGuiUtils.drawFilledCircle( ModGuiUtils.getWidth( ) - 60, 60, 50, 0x77007700 );
			ModGuiUtils.drawCircle( ModGuiUtils.getWidth( ) - 60, 60, 50, 0xff000000 );
			ModGuiUtils.drawCircle( ModGuiUtils.getWidth( ) - 60, 60, 38, 0xff000000 );
			ModGuiUtils.drawCircle( ModGuiUtils.getWidth( ) - 60, 60, 25, 0xff000000 );
			ModGuiUtils.drawCircle( ModGuiUtils.getWidth( ) - 60, 60, 13, 0xff000000 );
			
			ModGuiUtils.dr( ModGuiUtils.getWidth( ) - 110, 59.5, ModGuiUtils.getWidth( ) - 10, 60.5, 0xff00ffff );
			ModGuiUtils.dr( ModGuiUtils.getWidth( ) - 59.5, 10, ModGuiUtils.getWidth( ) - 60.5, 110, 0xff00ffff );
			
			ModGuiUtils.drawCircle( ModGuiUtils.getWidth( ) - 60, 60, 1, 0xffffffff );

			java.util.List list1 = CheatingEssentials.getCheatingEssentials().getMinecraftInstance().theWorld.loadedEntityList;
			
			GL11.glLineWidth( 1.0F );
			for ( int i = 0; i < list1.size( ); i++ ) {
				Entity entity = (Entity) list1.get( i );
				double xdis = CheatingEssentials.getCheatingEssentials().getMinecraftInstance().thePlayer.posX - entity.posX;
				double zdis = CheatingEssentials.getCheatingEssentials().getMinecraftInstance().thePlayer.posZ - entity.posZ;
				double tdis = Math.sqrt( ( xdis * xdis ) + ( zdis * zdis ) );
				
				double difInAng = MathHelper.wrapAngleTo180_double( CheatingEssentials.getCheatingEssentials().getMinecraftInstance().thePlayer.rotationYaw - ( ( Math.atan2( zdis, xdis ) * 180.0D ) / Math.PI ) );
				double finalX = Math.cos( Math.toRadians( difInAng ) ) * tdis;
				double finalY = -Math.sin( Math.toRadians( difInAng ) ) * tdis;
				
				GL11.glPushMatrix( );
				GL11.glTranslatef( ModGuiUtils.getWidth( ) - 60, 60, 0 );
				if ( tdis <= 100 ) {
					if ( !( entity instanceof EntityClientPlayerMP ) ) {
						if ( entity instanceof EntityPlayer ) {
							ModGuiUtils.drawCircle( (int) finalX / 2, (int) finalY / 2, 1, 0xff0000ff );
							GL11.glScalef( 0.5F, 0.5F, 0.5F );
							EntityPlayer p = (EntityPlayer) entity;
							String u = p.username;
	                        int color = 0xffffff;

	                        if (Friend.friendList.contains(u))
	                        {
	                            color = 0x00ff00;
	                        }
	                        else if (Enemy.enemyList.contains(u))
	                        {
	                            color = 0xff0000;
	                        }
	                        else
	                        {
	                            color = 0xffffff;
	                        }
							CheatingEssentials.getCheatingEssentials().getMinecraftInstance().fontRenderer.drawString( u, (int) ( finalX ) - ( CheatingEssentials.getCheatingEssentials().getMinecraftInstance().fontRenderer.getStringWidth( u ) / 2 ), (int) finalY - 10, color );
							
							GL11.glScalef( 1F, 0.5F, 1F );
						}
						if ( entity instanceof EntityAnimal ) {
							ModGuiUtils.drawCircle( (int) finalX / 2, (int) finalY / 2, 1, 0xff00ff00 );
						}
						if ( entity instanceof EntityMob ) {
							ModGuiUtils.drawCircle( (int) finalX / 2, (int) finalY / 2, 1, 0xffff0000 );
						}
						if ( entity instanceof EntitySlime ) {
							ModGuiUtils.drawCircle( (int) finalX / 2, (int) finalY / 2, 1, 0xffff88cc );
						}
						if ( entity instanceof EntityVillager ) {
							ModGuiUtils.drawCircle( (int) finalX / 2, (int) finalY / 2, 1, 0xff8b4513 );
						}
						if ( entity instanceof EntityBat ) {
							ModGuiUtils.drawCircle( (int) finalX / 2, (int) finalY / 2, 1, 0xfff4a460 );
						}
						if ( entity instanceof EntitySquid ) {
							ModGuiUtils.drawCircle( (int) finalX / 2, (int) finalY / 2, 1, 0xff003399 );
						}
					}
				}
				GL11.glPopMatrix( );
			}
		}

	 private static volatile boolean stopRequested;

	 @Override
	 public void run(){
	    drawRadar();
	 }
	 
	 private static void requestStop(){
		 stopRequested = true;
	 }
}
