package com.kodehawa.ce.module.classes;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.entity.RenderManager;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;
import com.reeszrbteam.ce.util.CEUtils;

public class Xray extends CheatingEssentialsModule{
		
	public static ArrayList<Integer> xrayBlocks = new ArrayList<Integer>();
	public static int listID = 0;
	public static BlockCoord[] espBlocks = new BlockCoord[10000000];
	private int radius = 32;
	private int timer = 0;
	private int size = 0;
	
    public Xray() {
		super("X-Ray", "", "1.6.2", Keyboard.KEY_X,
				EnumGuiCategory.WORLD, true);
		this.setTick(true);
	}

	@Override
	public void onEnableModule() {
		getMinecraft().renderGlobal.loadRenderers();
		float[] brightness = getMinecraft().theWorld.provider.lightBrightnessTable;
        for(int i = 0; i < brightness.length; i++) {
            brightness[i] = 1.0F;
        }
	}

	@Override
	public void onDisableModule()  {
		getMinecraft().renderGlobal.loadRenderers();
		getMinecraft().theWorld.provider.registerWorld(Minecraft.getMinecraft().theWorld);
		}
	
	public void tick(){
		if(isActive()) {
            timer++;

			if(timer >= 50) {
				refresh();
				timer = 0;
			}
		}
	}
		
    void refresh(){
    	for(int y = 0; y < 128; y++) {
			for(int x = 0; x < radius; x++) {
				for(int z = 0; z < radius; z++) {

					int cX = (int)getMinecraft().thePlayer.posX - (int)radius/2+x;
					int cY = y;
					int cZ = (int)getMinecraft().thePlayer.posZ - (int)radius/2+z;
					int ids = getMinecraft().theWorld.getBlockId(cX, cY, cZ);
				
    		    GL11.glDeleteLists(listID, 1);
    		    GL11.glNewList(listID, 4864);

    		    GL11.glDisable(3553);
    		    GL11.glDisable(2929);

    		    GL11.glColor3ub((byte)-1, (byte)0, (byte)0);
    		    GL11.glBegin(1);
    		    WorldClient world = getMinecraft().theWorld;
    		    EntityClientPlayerMP player = getMinecraft().thePlayer;
    		    for (int i = 0; i < radius * 2; i++) {
    		      for (int j = 0; j < radius * 2; j++) {
    		        for (int k = 0; k < 100; k++) {

    		          if (ids != 0)
    		          {
    		            for (int o = 0; o < xrayBlocks.size(); o++) {
    		              if (xrayBlocks.get(o) == ids)
    		      			for(int cur = 0; cur < size; cur++) {
    		  				BlockCoord curBlock = espBlocks[cur];
    						espBlocks[size++] = new BlockCoord(cX, cY, cZ);
    						CEUtils.drawESP(curBlock.getDeltaX(), curBlock.getDeltaY(), curBlock.getDeltaZ(), 0.0F, 0.0F, 1.0F);
    		            }
    		            }
    		          }
    		        }
    		      }
    		    }
				}
			}
    	}
    		    GL11.glEnd();
    		    GL11.glEnable(2929);
    		    GL11.glEnable(3553);
    		    GL11.glEndList();
    }
    
    public static void setStandardList() {
        ArrayList block = new ArrayList();
        block.add(15);
        block.add(16);
        block.add(17);
        block.add(56);
        block.add(73);
        block.add(21);

        xrayBlocks = block;
	}
    
    public class BlockCoord {
		private int x, y, z;

		public BlockCoord(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public int getZ() {
			return z;
		}

		public double getDeltaX() {
			return getX() - RenderManager.renderPosX;
		}

		public double getDeltaY() {
			return getY() - RenderManager.renderPosY;
		}

		public double getDeltaZ() {
			return getZ() - RenderManager.renderPosZ;
		}
	}
}