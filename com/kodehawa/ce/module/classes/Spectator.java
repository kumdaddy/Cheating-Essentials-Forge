package com.kodehawa.ce.module.classes;

import net.minecraft.block.Block;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;

import org.lwjgl.input.Keyboard;

import com.kodehawa.ce.module.annotations.ModuleExperimental;
import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;
import com.kodehawa.ce.module.handlers.ModuleManager;
import com.reeszrbteam.ce.util.EntitySpectator;

import cpw.mods.fml.common.FMLCommonHandler;

public class Spectator extends CheatingEssentialsModule {

	public Spectator() {
		super("Spectate", "Spectate and Spy on People", "1.6.2", 0, EnumGuiCategory.RENDER, true);
		super.setTick(true);
	}
	
    public Location locationHelper;

    @Override
    public void onEnableModule() 
    {
	    ModuleManager.getInstance().getModuleByClass(Fly.class).toggleModule();
        createSpectator();
    }
    
    
    public void onDisableModule(){
        ModuleManager.getInstance().getModuleByClass(Fly.class).toggleModule();
        removeSpectator();
    }

    public void removeSpectator(){
        EntityPlayerSP player = getPlayer();
    	WorldClient world = getMinecraft().theWorld;
        world.removeEntityFromWorld(-1);
        player.setPositionAndRotation(locationHelper.posX, locationHelper.posY, locationHelper.posZ, locationHelper.rotationYaw, locationHelper.rotationPitch);
    }
    
    @Override
    public void tick(){
    }
    
    public void createSpectator() 
    {
      EntityPlayerSP player = getPlayer();
       if (getMinecraft().theWorld instanceof WorldClient) 
       {
        locationHelper = new Location(player);
        EntityOtherPlayerMP o = new EntityOtherPlayerMP(getMinecraft().theWorld, getPlayer().username);
        o.setPositionAndRotation(locationHelper.posX, locationHelper.posY - player.yOffset, locationHelper.posZ, locationHelper.rotationYaw, locationHelper.rotationPitch);
        o.inventory.copyInventory(getPlayer().inventory);
        WorldClient world = getMinecraft().theWorld;
        world.addEntityToWorld(-1, o);
       }
    }
       
    class Location 
    {

     public double posX;
     public double posY;
     public double posZ;
     public float rotationYaw;
     public float rotationPitch;

     public String name;

     @Override
     public Location clone() 
     {
      return new Location(posX, posY, posZ, rotationYaw, rotationPitch, name);
     }

     public Location(Entity entity) 
     {
      this(entity, "");
     }

     public Location(Entity entity, String s) 
     {
      this(entity.posX, entity.posY, entity.posZ, entity.rotationYaw, entity.rotationPitch, s);
     }

     public Location() 
     {
      this(0.0D, 0.0D, 0.0D, 0.0F, 0.0F, "");
     }

     public Location(double d, double d1, double d2, String s) 
     {
      this(d, d1, d2, 0.0F, 0.0F, s);
     }

     public Location(double d, double d1, double d2) 
     {
      this(d, d1, d2, 0.0F, 0.0F, "");
     }

     public Location(double d, double d1, double d2, float f, float f1) 
     {
      this(d, d1, d2, f, f1, "");
     }

     public Location(double d, double d1, double d2, float f, float f1, String s) 
     {
      posX = d;
      posY = d1;
      posZ = d2;
      rotationYaw = f;
      rotationPitch = f1;
      name = s;
     }

     public double distance(Location Location) 
     {
      return Math.sqrt(distanceSquare(Location));
     }

     public double distanceSquare(Location Location) 
     {
      double d = Location.posX - posX;
      double d1 = Location.posY - posY;
      double d2 = Location.posZ - posZ;
      return d * d + d1 * d1 + d2 * d2;
     }

     public double distance2D(Location Location) 
     {
      return Math.sqrt(distance2DSquare(Location));
     }

     public double distance2DSquare(Location Location) 
     {
      double d = Location.posX - posX;
      double d1 = Location.posZ - posZ;
      return d * d + d1 * d1;
     }

     public double distanceY(Location Location) 
     {
      return Location.posY - posY;
     }

     public Location(String s) throws Exception 
     {
      String as[] = s.split(";", 6);

      if (as.length != 6) 
      {
       throw new Exception("Invalid line!");
      } 
      else 
      {
       name = as[5];
       posX = Double.parseDouble(as[0]);
       posY = Double.parseDouble(as[1]);
       posZ = Double.parseDouble(as[2]);
       rotationYaw = Float.parseFloat(as[3]);
       rotationPitch = Float.parseFloat(as[4]);
       return;
      }
     }
     
     public String export() 
     {
      return (new StringBuilder()).append(posX).append(";").append(posY).append(";").append(posZ).append(";").append(rotationYaw).append(";").append(rotationPitch).append(";").append(name).toString();
     }
    }
   }