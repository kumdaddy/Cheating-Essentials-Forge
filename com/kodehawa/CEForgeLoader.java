package com.kodehawa;

import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;

import com.kodehawa.ce.forge.common.CommonProxy;
import com.kodehawa.ce.forge.packet.PacketHandler;
import com.kodehawa.ce.forge.tick.TickHandler;
import com.kodehawa.module.ModuleBase;
import com.kodehawa.module.ModuleManager;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * The 63 lines of this are enough to init all the mod <3
 * Forge CE version main class, with all of my love for Optifine users. Me included :)
 * @author Kodehawa
 */

@Mod(modid="Cheating-Essentials", name="Cheating Essentials", version="3.2.0 - Forge")
@NetworkMod(clientSideRequired=true, serverSideRequired=false, packetHandler=PacketHandler.class)
@SideOnly(Side.CLIENT)
public class CEForgeLoader {
	
    @Instance("Cheating Essentials")
    public static CEForgeLoader instance;
   
    @SidedProxy(clientSide="com.kodehawa.ce.forge.common.ClientProxy", serverSide="com.kodehawa.ce.forge.common.CommonProxy")
    public static CommonProxy proxyHandler;
    public static TickHandler tickHandler = new TickHandler();
   
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	TickRegistry.registerTickHandler(tickHandler, Side.CLIENT);
    }
   
    @EventHandler
    public void load(FMLInitializationEvent event) {
        proxyHandler.registerRenderers();
        MinecraftForge.EVENT_BUS.register(this);
    }
   
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {}

	@ForgeSubscribe
	public void onRenderWorldLastEvent(RenderWorldLastEvent e){
		for(ModuleBase m : ModuleManager.getInstance().modules){
			m.onRenderInModule();
		}
	}
}