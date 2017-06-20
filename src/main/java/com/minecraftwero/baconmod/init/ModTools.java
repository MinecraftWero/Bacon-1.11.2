package com.minecraftwero.baconmod.init;

import com.minecraftwero.baconmod.Bacon;
import com.minecraftwero.baconmod.Reference;
import com.minecraftwero.baconmod.items.BaconAxe;
import com.minecraftwero.baconmod.items.BaconHoe;
import com.minecraftwero.baconmod.items.BaconPickaxe;
import com.minecraftwero.baconmod.items.BaconSpade;
import com.minecraftwero.baconmod.items.BaconSword;
import com.minecraftwero.baconmod.util.Utils;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTools {

	
	public static final ToolMaterial baconium = EnumHelper.addToolMaterial(Reference.MODID+ ":bac", 0, 59, 2.0F, 0.0F, 15);
	
	public static BaconPickaxe baconpick;
	public static BaconAxe baconaxe;
	public static BaconHoe baconhoe;
	public static BaconSword baconsword;
	public static BaconSpade baconspade;
	
	public static void init(){
		
		baconpick = new BaconPickaxe(baconium, "baconpick");
		baconaxe = new BaconAxe(baconium, "baconaxe");
		baconhoe = new BaconHoe(baconium, "baconhoe");
		baconsword = new BaconSword(baconium, "baconsword");
		baconspade = new BaconSpade(baconium, "baconspade");
	}
	
	public static void register(){

		registerItem(baconpick);
		registerItem(baconaxe);
		registerItem(baconhoe);
		registerItem(baconsword);
		registerItem(baconspade);
	}
	
	public static void registerRenders(){
		
		registerRender(baconpick);
		registerRender(baconaxe);
		registerRender(baconhoe);
		registerRender(baconsword);
		registerRender(baconspade);
	}


	public static void registerItem(Item item){
		
		item.setCreativeTab(Bacon.items);
		GameRegistry.register(item);
		Utils.getLogger().info("Registered Item: " + item.getRegistryName());
	}
	
	public static void registerRender(Item item){
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		Utils.getLogger().info("Registered render for " + item.getRegistryName());
	}
	
}




