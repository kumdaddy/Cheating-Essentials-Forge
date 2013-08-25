package com.kodehawa.gui.api.components;

import java.util.List;

import net.minecraft.client.Minecraft;
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

public class Radar
{
    Minecraft mc = CheatingEssentials.getMinecraftInstance();

    public void drawRadar(int x, int y)
    {
    	CheatingEssentials.getCheatingEssentials().tick++ ;

        if (CheatingEssentials.getCheatingEssentials().tick >= 50)
        {
        	CheatingEssentials.getCheatingEssentials().tick = 0;
        }

        GL11.glLineWidth(1.0F);
        ModGuiUtils.drawFilledCircle(x, y, 50, 0x77007700);
        ModGuiUtils.drawCircle(x, y, 50, 0xff000000);
        ModGuiUtils.drawCircle(x, y, 38, 0xff000000);
        ModGuiUtils.drawCircle(x, y, 25, 0xff000000);
        ModGuiUtils.drawCircle(x, y, 13, 0xff000000);
        ModGuiUtils.drawCircle(x, y, CheatingEssentials.getCheatingEssentials().tick, 0xff00ffff);
        ModGuiUtils.drawCircle(x, y, 1, 0xffffffff);   // Player
        List list1 = this.mc.theWorld.loadedEntityList;
        GL11.glLineWidth(1.0F);

        for (int i = 0; i < list1.size(); i++)
        {
            Entity entity = (Entity) list1.get(i);
            double xdis = this.mc.thePlayer.posX - entity.posX;
            double zdis = this.mc.thePlayer.posZ - entity.posZ;
            double tdis = Math.sqrt((xdis * xdis) + (zdis * zdis));
            double difInAng = MathHelper.wrapAngleTo180_double(this.mc.thePlayer.rotationYaw - ((Math.atan2(zdis, xdis) * 180.0D) / Math.PI));
            double finalX = Math.cos(Math.toRadians(difInAng)) * tdis;
            double finalY = -Math.sin(Math.toRadians(difInAng)) * tdis;
            GL11.glPushMatrix();
            GL11.glTranslatef(x, y, 0);

            if (tdis <= 100)
            {
                if (!(entity instanceof EntityClientPlayerMP))
                {
                    if (entity instanceof EntityPlayer)
                    {
                        
                        ModGuiUtils.drawTriangle(entity, finalX, finalY, 0xff0000ff);
                        GL11.glScalef(0.5F, 0.5F, 0.5F);
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

                        this.mc.fontRenderer.drawString(u, (int)(finalX) - (this.mc.fontRenderer.getStringWidth(u) / 2), (int) finalY - 10, color);
                        
                        GL11.glScalef(1F, 1F, 1F);
                    }

                    if (entity instanceof EntityAnimal)
                    {
                        
                        ModGuiUtils.drawTriangle(entity, finalX, finalY, 0xff00ff00);
                    }

                    if (entity instanceof EntityMob)
                    {
                        
                        ModGuiUtils.drawTriangle(entity, finalX, finalY, 0xffff0000);
                    }

                    if (entity instanceof EntitySlime)
                    {
                        
                        ModGuiUtils.drawTriangle(entity, finalX, finalY, 0xffff88cc);
                    }

                    if (entity instanceof EntityVillager)
                    {
                        
                        ModGuiUtils.drawTriangle(entity, finalX, finalY, 0xff8b4513);
                    }

                    if (entity instanceof EntityBat)
                    {
                        
                        ModGuiUtils.drawTriangle(entity, finalX, finalY, 0xfff4a460);
                    }

                    if (entity instanceof EntitySquid)
                    {
                        
                        ModGuiUtils.drawTriangle(entity, finalX, finalY, 0xff003399);
                    }
                }
            }

            GL11.glPopMatrix();
        }
    }
}
