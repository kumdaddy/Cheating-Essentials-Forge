package com.kodehawa.module.classes;

import java.util.ArrayList;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;

import org.lwjgl.opengl.GL11;

import com.kodehawa.CheatingEssentials;
import com.kodehawa.module.core.CheatingEssentialsModule;
import com.kodehawa.module.enums.EnumGuiCategory;

public class Breadcrumb extends CheatingEssentialsModule {

    public static ArrayList<double[]> positionsList = new ArrayList<double[]>();

        public Breadcrumb() {
            super("Breadcrumb", "Draws a trail behind the player.", "", 0, EnumGuiCategory.WORLD, true);
            super.setTick(true);
    		super.setRender(true);
        }

        static int count = 0;

        @Override
        public void tick() {
            if(this.isActive()) {
                count++;
                if(count >= 50) {
                    count = 0;
                    if(positionsList.size() > 5) {
                        positionsList.remove(0);
                    }
                }
                for(Object o : CheatingEssentials.getMinecraftInstance().theWorld.playerEntities){
                    if(o instanceof EntityPlayer) {
                        EntityPlayer player1 = (EntityPlayer)o;

                        boolean shouldBreadCrumb = (player1 == getMinecraft().thePlayer) && ((getMinecraft().thePlayer.movementInput.moveForward != 0) || (getMinecraft().thePlayer.movementInput.moveStrafe != 0));

                        if(shouldBreadCrumb) {
                            double x =  (RenderManager.renderPosX);
                            double y =  (RenderManager.renderPosY);
                            double z =  (RenderManager.renderPosZ);

                            positionsList.add(new double[] {x, y - player1.height, z});
                        }
                    }
                }
            }
        }

        public static double posit(double val) {
            return (val == 0) ? (val) : (val < 0 ? val * -1 : val);
        }

        @Override
        public void onRenderInModule() {
            if(this.isActive()) {
                GL11.glPushMatrix();
                GL11.glLineWidth(2F);
                GL11.glDisable(GL11.GL_TEXTURE_2D);
                GL11.glDisable(GL11.GL_LIGHTING);
                GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
                GL11.glEnable(GL11.GL_LINE_SMOOTH);
                GL11.glEnable(GL11.GL_BLEND);
                GL11.glDisable(GL11.GL_DEPTH_TEST);

                GL11.glBegin(GL11.GL_LINE_STRIP);
                for(double[] pos : positionsList) {
                    double distance = posit(Math.hypot(pos[0] - RenderManager.renderPosX, pos[1] - RenderManager.renderPosY));
                    if(distance > 100) continue;
                    GL11.glColor4f(0.0F, 1.0F, 0.0F, 1.0F - (float)(distance / 100D));
                    GL11.glVertex3d(pos[0] - RenderManager.renderPosX, pos[1]  - RenderManager.renderPosY, pos[2] - RenderManager.renderPosZ);
                }
                GL11.glEnd();

                GL11.glEnable(GL11.GL_DEPTH_TEST);
                GL11.glDisable(GL11.GL_LINE_SMOOTH);
                GL11.glDisable(GL11.GL_BLEND);
                GL11.glEnable(GL11.GL_TEXTURE_2D);
                GL11.glEnable(GL11.GL_LIGHTING);
                GL11.glPopMatrix();
            }
        }

        @Override
        public void onEnableModule() {

        }

        @Override
        public void onDisableModule() {

        }
    }


