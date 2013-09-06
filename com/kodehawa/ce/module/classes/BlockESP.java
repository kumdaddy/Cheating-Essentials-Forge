package com.kodehawa.ce.module.classes;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.renderer.entity.RenderManager;

import org.lwjgl.input.Keyboard;

import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;
import com.reeszrbteam.ce.util.CEUtils;

public class BlockESP extends CheatingEssentialsModule{

	private int size = 0;

	public static List<Integer> espList = new ArrayList<Integer>();
	public static BlockCoord[] espBlocks = new BlockCoord[10000000];
	
	public BlockESP() {
		super("Block ESP", "Draws ESP on Blocks", "1.6.2", Keyboard.KEY_NUMPAD8,
				EnumGuiCategory.RENDER, true);
		super.setRender(true);
	}

	@Override
	public void onEnableModule() {}

	@Override
	public void onDisableModule() {}
	
	private int timer = 0;

	public void refresh() {
		size = 0;
		int radius = 72;
		for(int y = 0; y < 128; y++) {
			for(int x = 0; x < radius; x++) {
				for(int z = 0; z < radius; z++) {

					int cX = (int)getMinecraft().thePlayer.posX - (int)radius/2+x;
					int cY = y;
					int cZ = (int)getMinecraft().thePlayer.posZ - (int)radius/2+z;
					int ids = getMinecraft().theWorld.getBlockId(cX, cY, cZ);

					if (espList.contains(ids)) {
						espBlocks[size++] = new BlockCoord(cX, cY, cZ);
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
				BlockCoord curBlock = espBlocks[cur];
				CEUtils.drawESP(curBlock.getDeltaX(), curBlock.getDeltaY(), curBlock.getDeltaZ(), 0.0F, 0.0F, 1.0F);
			}
		}
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
