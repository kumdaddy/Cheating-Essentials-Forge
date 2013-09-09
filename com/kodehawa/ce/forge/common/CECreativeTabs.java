package com.kodehawa.ce.forge.common;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CECreativeTabs extends CreativeTabs {

         public CECreativeTabs(int par1, String par2Str) {
        	 super(par1, par2Str);
        }
         
        public static CreativeTabs tabHardcore = new CreativeTabs("tabHardcore") {
            public ItemStack getIconItemStack() {
                     return new ItemStack(Item.enderPearl, 1, 0);
            }
        };
        
        
}
