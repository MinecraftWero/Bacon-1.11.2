package com.minecraftwero.baconmod;

import com.minecraftwero.baconmod.creativetab.BaconTab;
import com.minecraftwero.baconmod.handlers.BaconEventHandler;
import com.minecraftwero.baconmod.handlers.BaconSoundHandler;
import com.minecraftwero.baconmod.handlers.RecipeHandler;
import com.minecraftwero.baconmod.init.ModArmors;
import com.minecraftwero.baconmod.init.ModBlocks;
import com.minecraftwero.baconmod.init.ModItems;
import com.minecraftwero.baconmod.init.ModTools;
import com.minecraftwero.baconmod.proxy.CommonProxy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION, dependencies = "after:subcommonlib@[1.2,)")

public class Bacon {

	public static final CreativeTabs items = new BaconTab();

	
	@Mod.Instance(Reference.MODID)
	public static Bacon instance;
	
	@SidedProxy(serverSide = Reference.SERVER_PROXY_CLASS, clientSide = Reference.CLIENT_PROXY_CLASS)
	public static CommonProxy proxy;

		@EventHandler
		public void preInit(FMLPreInitializationEvent event){

			ModItems.init();
			ModTools.init();
			ModArmors.init();
			ModBlocks.init();
			ModItems.register();
			ModTools.register();
			ModArmors.register();
			ModBlocks.register();
			proxy.registerRenders();
		}
		
		
		@EventHandler
		public void init(FMLInitializationEvent event){
		BaconEventHandler.registerEvents();
		RecipeHandler.registerCraftingRecipes();
		RecipeHandler.registerSmeltingRecipes();
		BaconSoundHandler.init();
		}
		
		@EventHandler
		public void postInit(FMLPostInitializationEvent event){

		}


}

