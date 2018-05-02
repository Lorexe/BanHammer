package be.lorexe.banhammer;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import org.apache.logging.log4j.Logger;

import be.lorexe.banhammer.items.BanHammerTab;
import be.lorexe.banhammer.items.ModItems;
import be.lorexe.banhammer.modifiers.ModModifiers;
import be.lorexe.banhammer.proxy.CommonProxy;
import be.lorexe.banhammer.utils.Config;

@Mod(modid = BanHammer.modId, name = BanHammer.name, version = BanHammer.version, acceptedMinecraftVersions="[1.12.2]")
public class BanHammer {
    public static final String modId = "banhammer";
    public static final String name = "BanHammer";
    public static final String version = "1.1";

    @SidedProxy(serverSide = "be.lorexe.banhammer.proxy.CommonProxy", clientSide = "be.lorexe.banhammer.proxy.ClientProxy")
    public static CommonProxy proxy;
    
    private static Logger logger;
    
    public static final BanHammerTab creativeTab = new BanHammerTab();
    
    public Config config;
    
    @Instance(modId)
    public static BanHammer instance;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        
        ModModifiers.createModifiers();
        
        this.config = new Config(event.getSuggestedConfigurationFile());
    }
    
    @Mod.EventBusSubscriber
	public static class RegistrationHandler {
    	@SubscribeEvent
    	public static void registerItems(RegistryEvent.Register<Item> event) {
    		ModItems.register(event.getRegistry());
    	}
    	
    	@SubscribeEvent
    	public static void registerItems(ModelRegistryEvent event) {
    		ModItems.registerModels();
    	}
	}
}
