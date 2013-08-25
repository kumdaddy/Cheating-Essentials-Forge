package com.reeszrbteam.ce.util;

import net.minecraft.block.Block;

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
}
