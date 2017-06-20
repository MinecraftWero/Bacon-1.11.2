package com.minecraftwero.baconmod.init;

import com.minecraftwero.baconmod.Bacon;
import com.minecraftwero.baconmod.Reference;
import com.minecraftwero.baconmod.entities.EntityBacon;
import com.minecraftwero.baconmod.handlers.EntityHandler;
import com.minecraftwero.baconmod.items.BaconCar;
import com.minecraftwero.baconmod.items.BaconGun;
import com.minecraftwero.baconmod.items.BeefSoup;
import com.minecraftwero.baconmod.util.Utils;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {

	public static Item rawbacon;
	public static Item cookedbacon;
	public static Item gaybacon;
	public static Item rawbeef;
	public static Item roastbeef;
	public static Item eggfried;
	public static Item bacongun;
	public static Item beefsoup;
	public static Item baconsandwich;
	public static Item baconcar;
	public static Item baconeggsandwich;
	public static void init(){
		
		//Food//
		rawbacon = new ModFood("rawbacon", 1, 0.3F, true, new PotionEffect(MobEffects.POISON, 40, 1));
		cookedbacon = new ModFood("cookedbacon", 2, 0.6F, true);
		gaybacon = new ModFood("gaybacon", 2, 0.2F, false, new PotionEffect(MobEffects.SPEED, 600, 1)).setAlwaysEdible();
		rawbeef = new ModFood("rawbeef", 2, 0.6F, true, new PotionEffect(MobEffects.POISON, 40, 1));
		roastbeef = new ModFood("roastbeef", 5, 1.6F, true); 
		eggfried = new ModFood("eggfried", 3, 1.2F, false);
		beefsoup = new 	BeefSoup("beefsoup", 6, 1.6F, false);
		baconsandwich = new ModFood("baconsandwich", 7, 1.7F, false);
		baconeggsandwich = new ModFood("baconeggsandwich", 9, 2.5F, false);


		//Items//
		bacongun = new BaconGun("bacongun");
		baconcar = new BaconCar("baconcar");
		
		
		//Entity Registration
		ResourceLocation baconbullet = new ResourceLocation(Reference.MODID, "baconbullet");
		EntityHandler.registerModEntity(baconbullet, EntityBacon.class, "baconbullet", Bacon.instance, 16, 20, true);
	}
	
	public static void register(){
		registerItem(rawbacon);
		registerItem(cookedbacon);
		registerItem(gaybacon);
		registerItem(rawbeef);
		registerItem(roastbeef);
		registerItem(eggfried);
		registerItem(bacongun);
		registerItem(beefsoup);
		registerItem(baconsandwich);
		registerItem(baconcar);
		registerItem(baconeggsandwich);
	}
	
	public static void registerRenders(){
		registerRender(rawbacon);
		registerRender(cookedbacon);
		registerRender(gaybacon);
		registerRender(rawbeef);
		registerRender(roastbeef);
		registerRender(eggfried);
		registerRender(bacongun);
		registerRender(beefsoup);
		registerRender(baconsandwich);
		registerRender(baconcar);
		registerRender(baconeggsandwich);
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
