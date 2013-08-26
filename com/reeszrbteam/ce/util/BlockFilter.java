package com.reeszrbteam.ce.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class BlockFilter {

	public static String IDtoBlockName(final int id){
		 for (final Block e : Block.blocksList) {
			   if (e == null) {
			    continue;
			   }

			   if (e.blockID == id) {
			    return e.getLocalizedName();
			   }
		 }
		 
		 return "";
	}
	
	public static int BlockNametoID(String name){
		for (final Block e : Block.blocksList) {
			   if (e == null) {
			    continue;
			   }
			   
			   String s = e.getLocalizedName().replaceAll(" ", "").toLowerCase();
			   if(name.equalsIgnoreCase(s)){
				   return e.blockID;
			   }
		 }
		 
		 return 90000;
	}
	
	public static int testItem(String name){
		for (final Item e : Item.itemsList) {
			   if (e == null) {
			    continue;
			   }
			   
			   String s = e.getUnlocalizedName().replace("item.", "");
			   if(name.equalsIgnoreCase(s)){
				   System.out.println("Apetecan");
				   return e.itemID;
			   }
		 }
		 
		 return 90000;
	}
}
