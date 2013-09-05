package com.kodehawa.ce.forge.common.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.kodehawa.ce.module.classes.Gui;
import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.handlers.ModuleManager;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CEItemHardcoreGui extends Item {

	public CEItemHardcoreGui(int par1) {
		super(par1);
        maxStackSize = 1;
        setUnlocalizedName("ceHardcoreItem");
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer){
		try {
			ModuleManager.getInstance().getModuleByClass(Gui.class).onEnableModule();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return par1ItemStack;
	}

	public EnumRarity getRarity(ItemStack par1ItemStack)
	{
	    return EnumRarity.rare;
	}
}
