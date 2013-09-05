package com.kodehawa.ce.forge.common;

import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.common.MinecraftForge;

import org.apache.commons.lang3.StringUtils;

import com.kodehawa.ce.CheatingEssentials;
import com.kodehawa.ce.api.reflection.ReflectorHelper;
import com.kodehawa.ce.forge.common.events.EventRegisterer;
import com.kodehawa.ce.forge.common.item.CEItemHardcoreConsole;
import com.kodehawa.ce.forge.common.item.CEItemHardcoreGui;
import com.kodehawa.ce.forge.tick.TickHandler;
import com.kodehawa.ce.playerrelations.Enemy;
import com.kodehawa.ce.playerrelations.Friend;
import com.kodehawa.ce.util.FileManager;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Forge Class Loader for {@link CheatingEssentials} in {@link MinecraftForge}, mostly created for
 * Optifine users and users that like to use other mods with it. It should not be loaded in
 * a server envirioment, but some cheats / hacks are compatible with it.
 * The {@link ReflectorHelper} class is for some cheats that need a private or unaccesible value.
 * This loader initialize the singleton instance of all classes that need it for load it in the
 * class patch. I'm planning to add a API for most easy mod development.
 * The hardcore feature are mostly items, see also: {@link CEItemHardcoreConsole} and {@link CEItemHardcoreGui}
 * and now is mostly testing for future projects.
 * @version 3.2.35a
 * @author Kodehawa
 * @since 25/08/2013
 */

@Mod(modid="Cheating-Essentials", name="Cheating Essentials", version="3.2.35a", useMetadata=true) //Gets mod data
@NetworkMod(clientSideRequired=true, serverSideRequired=false) 
@SideOnly(Side.CLIENT)

public class Loader {
	
	public CheatingEssentials ce;
    public static TickHandler tickHandler = new TickHandler();
    static final int MAJOR_VERSION = 3;
    static final int MINOR_VERSION = 2;
    static final int REVISION_VERSION = 35;
    static final String REVISION_LETTER = "a";
	
    @Instance("Cheating-Essentials")
    public static Loader instance;
    private final static Item hardcoreItem = new CEItemHardcoreGui(8235).setCreativeTab(CECreativeTabs.tabHardcore).
    		setFull3D().setNoRepair().setMaxDamage(2510).func_111206_d("cheating-essentials:hardcoreWand");
    private final static Item hardcoreItemC = new CEItemHardcoreConsole(8236).setCreativeTab(CECreativeTabs.tabHardcore).
    		setFull3D().setNoRepair().setMaxDamage(2510).func_111206_d("cheating-essentials:hardcoreWandConsole");
    
    @SidedProxy(clientSide="com.kodehawa.ce.forge.common.ClientProxy", serverSide="com.kodehawa.ce.forge.common.CommonProxy")
    public static CommonProxy proxyHandler;
   
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	FMLLog.log("Cheating Essentials", Level.INFO, "Cheating Essentials main: " + StringUtils.defaultString(CheatingEssentials.class.getName()));
    	FMLLog.log("Cheating Essentials", Level.INFO, "Attempting a early Cheating Essentials initialization");
    	ce = new CheatingEssentials( );
    	FMLLog.log("Cheating Essentials", Level.INFO,
    			"Cheating Essentials Forge Loader: " + StringUtils.defaultString(Loader.class.getName()) +
    			" in Minecraft Forge " + ForgeVersion.getVersion());
    	FMLLog.log("Cheating Essentials", Level.INFO, "Loading mod instances...");
        try {
			initializeSingletons();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
    	TickRegistry.registerScheduledTickHandler(tickHandler, Side.CLIENT);
    	FMLLog.log("Cheating Essentials", Level.INFO,
    			"Started Cheating Essentials "+getForgeCEVersion()+" in Minecraft 1.6.2 with Minecraft Forge " + ForgeVersion.getVersion());
    	/* Little joke <3 */
    	CheatingEssentials.CELogAgent("[Pinky] Cerebro, what are we going to do tomorrow night?");
    	CheatingEssentials.CELogAgent("[Cerebro] Pinky, we're going to take over the world!");
    }
    
    ItemStack emeraldBlock = new ItemStack(Block.blockEmerald);
    ItemStack diamondBlock = new ItemStack(Block.blockDiamond);
   
    @EventHandler
    public void load(FMLInitializationEvent event) {
        proxyHandler.registerRenderers();
        LanguageRegistry.instance().addStringLocalization("itemGroup.tabHardcore", "en_US", "Cheating Essentials");
        LanguageRegistry.addName(hardcoreItem, "Cheating GUI Wand");
        LanguageRegistry.addName(hardcoreItemC, "Cheating Console Wand");
        GameRegistry.addRecipe(new ItemStack(hardcoreItem), "xyx", "xyx", "xxx",
                'x', emeraldBlock , 'y', diamondBlock);
        GameRegistry.addRecipe(new ItemStack(hardcoreItemC), "xyx", "xyx", "xxx",
                'x', diamondBlock , 'y', emeraldBlock);
        MinecraftForge.EVENT_BUS.register(new EventRegisterer());
    }
   
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {}

	private void initializeSingletons() throws NoSuchFieldException, SecurityException{
        Enemy.getInstance();
        Friend.getInstance();
        FileManager.getInstance();
    }
	
	public static String getForgeCEVersion(){
		return MAJOR_VERSION+"."+MINOR_VERSION+"."+REVISION_VERSION+REVISION_LETTER; //Return current version
	}
}