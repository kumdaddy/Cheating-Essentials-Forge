package com.kodehawa.ce.module.classes;

import java.util.Scanner;

import net.minecraft.network.packet.Packet13PlayerLookMove;

import org.lwjgl.input.Keyboard;

import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;

public class PacketNoFall extends CheatingEssentialsModule {

	public PacketNoFall() {
		super("P. No Fall", "", "1.6.2", Keyboard.KEY_NONE, EnumGuiCategory.PLAYER, true);
		super.setTick(true);
	}
	
	public void tick(){
		sendPacket(new Packet13PlayerLookMove(getPlayer().motionX, -999.0D, -999.0D, getPlayer().motionZ, getPlayer().rotationYaw, getPlayer().rotationPitch, !getPlayer().onGround));
	}
}
