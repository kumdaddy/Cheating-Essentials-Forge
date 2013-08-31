package com.kodehawa.ce.module.classes;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.entity.RenderManager;

import org.lwjgl.input.Keyboard;

import com.kodehawa.ce.CheatingEssentials;
import com.kodehawa.ce.module.classes.BlockESP.BlockCoord;
import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;
import com.reeszrbteam.ce.util.BlockFilter;
import com.reeszrbteam.ce.util.CEUtils;

	public class Xray extends CheatingEssentialsModule{

		private int size = 0;

		public static List<Integer> xrayList = new ArrayList<Integer>();
		public static BlockCoord[] xrayBlocks = new BlockCoord[10000000];
		
		public Xray() {
			super("X-Ray", "", "1.6.2", Keyboard.KEY_X,
					EnumGuiCategory.WORLD, true);
			xrayList.add(14);
			xrayList.add(56);
			xrayList.add(73);
			super.setRender(true);
		}

		@Override
		public void onEnableModule() {}

		@Override
		public void onDisableModule() {}
		
		/*private int timer = 0;

		public void refresh() {
			size = 0;
			int radius = 72;
			for(int y = 0; y < 128; y++) {
				for(int x = 0; x < radius; x++) {
					for(int z = 0; z < radius; z++) {

						int cX = (int)CheatingEssentials.getMinecraftInstance().thePlayer.posX - (int)radius/2+x;
						int cY = y;
						int cZ = (int)CheatingEssentials.getMinecraftInstance().thePlayer.posZ - (int)radius/2+z;
						int ids = CheatingEssentials.getMinecraftInstance().theWorld.getBlockId(cX, cY, cZ);

						if (xrayList.contains(ids)) {
							xrayBlocks[size++] = new BlockCoord(cX, cY, cZ);
						}
					}
				}
			}
		}

		@Override
		public void onRenderInModule() {
			if(isActive()) {
	            timer++;

				if(timer >= 50) {
					refresh();
					timer = 0;
				}
				
				for(int cur = 0; cur < size; cur++) {
					BlockCoord curBlock = xrayBlocks[cur];
						if(xrayList.contains(14)){ //Gold
	        				CEUtils.drawESP(curBlock.getDeltaX(), curBlock.getDeltaY(), curBlock.getDeltaZ(), 1.0F, 1.0F, 0.0F);
						}
	                   /* if(xrayList.contains("15")){ //Iron
	        				CEUtils.drawESP(curBlock.getDeltaX(), curBlock.getDeltaY(), curBlock.getDeltaZ(), 0.01F, 0.05F, 1.0F);
						}
	                    if(xrayList.contains("16")){ //Coal
	        				CEUtils.drawESP(curBlock.getDeltaX(), curBlock.getDeltaY(), curBlock.getDeltaZ(), 0.0F, 0.5F, 0.0F);
						}
	                    if(xrayList.contains(56)){ // Diamond
	        				CEUtils.drawESP(curBlock.getDeltaX(), curBlock.getDeltaY(), curBlock.getDeltaZ(), 0.0F, 0.0F, 1.0F);
						}
	                    if((xrayList.contains(73))){ // Redstone
	        				CEUtils.drawESP(curBlock.getDeltaX(), curBlock.getDeltaY(), curBlock.getDeltaZ(), 1.0F, 0.0F, 0.0F);
						}
	                    else{}
					}
				}
			}*/
		
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