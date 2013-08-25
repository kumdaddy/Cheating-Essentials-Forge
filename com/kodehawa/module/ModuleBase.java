package com.kodehawa.module;

import java.util.LinkedList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.NetClientHandler;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet3Chat;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import com.kodehawa.CheatingEssentials;
import com.kodehawa.event.Event;
import com.kodehawa.event.EventHandler;
import com.kodehawa.event.Listener;
import com.kodehawa.event.events.EventKey;
import com.kodehawa.event.events.EventRender3D;
import com.kodehawa.event.events.EventTick;
import com.kodehawa.module.annotations.ModuleRetention;
import com.kodehawa.module.enums.EnumGuiCategory;
import com.kodehawa.util.Tickable;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Main module class. All modules should extends it.
 * @author Kodehawa
 */
@SideOnly(Side.CLIENT)
public abstract class ModuleBase implements Listener, Tickable {

    public EnumGuiCategory type;
    public boolean enabled;
	public String name;
	public String desc;
	public String credits;
	public String version;
	public int keybind;
	private boolean active;
    private Tickable Tickable;
    private boolean tick;
    public int color;
    private boolean ortho;
    private final LinkedList<Class<? extends ModuleBase>> incompat = new LinkedList<Class<? extends ModuleBase>>();


    @ModuleRetention( type = "Base" )
    public ModuleBase(final String name, final String desc, final int key) {
       this(name, desc, "1.6.2", key, EnumGuiCategory.UTILS, true);
        EventHandler.getInstance().registerListener( EventKey.class, this );
        EventHandler.getInstance().registerListener( EventRender3D.class, this );
      }

    public ModuleBase(final String name, final String desc, final EnumGuiCategory type) {
       this(name, desc, "1.6.2", -1, type, true);
        EventHandler.getInstance().registerListener( EventKey.class, this );
        EventHandler.getInstance().registerListener( EventRender3D.class, this );
       }

    public ModuleBase(final String name, final String desc, final String version, final int key, final EnumGuiCategory type, final boolean enabled) {
       this.name = name;
       this.desc = desc;
       this.keybind = key;
       this.type = type;
       this.enabled = enabled;
       this.version = version;
       EventHandler.getInstance().registerListener( EventKey.class, this );
       EventHandler.getInstance().registerListener( EventRender3D.class, this );
    }

    public void setOn( ){
    	active = true;
        onEnableModule();
        ModuleManager.getInstance().enabledModules.add(name);
        this.disableIncompat();
    }

    public void setOff( ){
    	active = false;
        onDisableModule();
        ModuleManager.getInstance().enabledModules.remove(name);
    }

    public void toggleModule( ){
    	try{
    	active = !active;
    	if (active) {
    		onEnableModule();
    		ModuleManager.getInstance().enabledModules.add(name);
            if(this.getTick()){
            ModuleManager.getInstance().addToTick(this); }
            if(getType() == EnumGuiCategory.NONE){
                ModuleManager.getInstance().enabledModules.remove(name);
            }
        }
    	else{
    		onDisableModule();
    		ModuleManager.getInstance().enabledModules.remove(name);
            if(this.getTick())   {
                ModuleManager.getInstance().removeFromCurrentTick(this);  }
        }
    	  if( this.isActive( ) ) {
              if( this.getRender( ) ) {
              	EventHandler.getInstance().registerListener( EventRender3D.class, this );
              }
          } else {
              if( this.getRender( ) ) {
              	EventHandler.getInstance().unRegisterListener( EventRender3D.class, this );
              }
          }
    	}
    	catch( Exception e ){
    		for(ModuleBase m : ModuleManager.getInstance().modules){
    		CheatingEssentials.CELogAgent("Can't load module " + m.getName() + " - Because of " + e.toString());
    		}
    		e.printStackTrace();
    	}
    }

    public boolean isActive( ){
    	return active;
    }

    public String getName( ){
    	return this.name;
    }

    public void setName( String s ){
    	this.name = s;
    }

    public int getKeybinding( ){
    	return this.keybind;
    }

    public void setKeybinding( Integer key ){
    	this.keybind = key;
    }
    
    public void setAuthor( String s ){
    	this.credits = s;
    }

    public void setActive( boolean state ){
    	this.enabled = state;
    }

    public void setColor( int color ){
    	this.color = color;
    }

    public boolean getEnabled( ){
    	return this.enabled;
    }

    public int getColor( ){
    	return this.color;
    }

    public void setDesc( String s ){
    	this.desc = s;
    }

    public String getMCVersion(){
    	return this.version;
    }

    public EnumGuiCategory getType() {
        return type;
}
    
    public boolean getRender( ) {
        return ortho;
    }

    public boolean getTick(){
        return tick;
    }

    public void setTick(boolean shit){
       tick = shit;
    }
    
    public void setRender( boolean state ) {
        ortho = state;
    }

    public void setVersion( String s ){
    	this.version = s;
    }

    @Override
    public void onEvent( Event e ) {
        if( e instanceof EventTick ) {
            Tickable.tick( );
        }
        if( e instanceof EventKey ) {
            if( ( ( EventKey ) e ).getKey( ) == this.getKeybinding( ) ) {
                toggleModule( );
            }
        }
        if( this.getRender( ) ) {
            if( e instanceof EventRender3D ) {
                this.onRenderInModule( );
            }
        }
    }

     protected static EntityClientPlayerMP getPlayer() {
        return getMinecraft().thePlayer;
     }

     protected static Minecraft getMinecraft() {
        return Minecraft.getMinecraft();
     }

     protected static World getWorld() {
        return getMinecraft().theWorld;
     }

     protected static List<TileEntity> getTileEntitiesInWorld() {
        return getWorld().loadedTileEntityList;
     }

     protected static List<EntityPlayer> getPlayersInWorld() {
        return getWorld().playerEntities;
    }

     protected static void displayGuiScreen(final GuiScreen e) {
        getMinecraft().displayGuiScreen(e);
     }

     protected static void sendPacket(final Packet packet) {
        getSendQueue().addToSendQueue(packet);
     }

     protected static void sendChatMessage(final String message) {
        sendPacket(new Packet3Chat(message));
     }

     protected static NetClientHandler getSendQueue() {
        return getPlayer().sendQueue;
     }


     protected static double getDistanceToEntity(final Entity e) {
        return getPlayer().getDistanceToEntity(e);
     }


     protected static double getDistanceSqToEntity(final Entity e) {
        return getPlayer().getDistanceSqToEntity(e);
     }

     protected static List<Entity> getLoadedEntities() {
        return getWorld().loadedEntityList;
         }

     protected static EntityRenderer getEntityRenderer() {
        return getMinecraft().entityRenderer;
         }

     protected static PlayerControllerMP getPlayerController() {
        return getMinecraft().playerController;
         }

     protected static boolean getCanEntityBeSeen(final Entity e) {
        return getPlayer().canEntityBeSeen(e);
         }
    
     protected void setFly(boolean state){
        getMinecraft().thePlayer.capabilities.allowFlying = state;
		getMinecraft().thePlayer.sendPlayerAbilities();
	}

     protected static List<Entity> getEntitiesInRange(final double range) {
        final List<Entity> list = new LinkedList<Entity>();
        for (final Entity e : getLoadedEntities()) {
                if (getDistanceToEntity(e) <= range) {
                        if (e instanceof EntityLiving) {
                                list.add(e);
                        } else {
                                continue;
                        }
                } else {
                        continue;
                }
        }

        return list;
           }

     protected void incompat(final Class<? extends ModuleBase> module) {
        incompat.add(module);
        }


     private void disableIncompat() {
        for (final Class<? extends ModuleBase> e : incompat) {
                this.disableIncompat(e);
        }
         }


     private void disableIncompat(final Class<? extends ModuleBase> module) {
      final ModuleBase incompat = ModuleManager.getInstance().getModuleByClass(module);

        if (!incompat.isActive()) {
                return;
        }

        if ((getWorld() != null) && (getMinecraft() != null) && (getPlayer() != null)) {
               CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage(EnumChatFormatting.YELLOW + "[CE v3] Disabling " + incompat.getName() + " because it is incompatible with " + getName());
        }

        incompat.setActive(false);
         }

      public abstract void onEnableModule( );
	  public abstract void onDisableModule( );
	  public void onRenderInModule( ){}
      public void tick(){}
      public void utilGui(){}

}