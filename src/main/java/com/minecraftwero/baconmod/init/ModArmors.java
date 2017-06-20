package com.minecraftwero.baconmod.init;

import com.minecraftwero.baconmod.Bacon;
import com.minecraftwero.baconmod.Reference;
import com.minecraftwero.baconmod.items.BaconArmor;
import com.minecraftwero.baconmod.util.Utils;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModArmors {

	public static ArmorMaterial baconmaterial = EnumHelper.addArmorMaterial("bacon", Reference.MODID + ":bacon", 10, new int[] {2,6,5,2}, 4, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0F);
	
	public static ItemArmor	baconhelmet;
	public static ItemArmor baconchest;
	public static ItemArmor baconlegs;
	public static ItemArmor baconboots;

	public static void init(){
		baconhelmet = new BaconArmor(baconmaterial, 1, EntityEquipmentSlot.HEAD, "baconhelmet");
		baconchest = new BaconArmor(baconmaterial, 1, EntityEquipmentSlot.CHEST, "baconchest");
		baconlegs = new BaconArmor(baconmaterial, 2, EntityEquipmentSlot.LEGS, "baconlegs");
		baconboots = new BaconArmor(baconmaterial, 1, EntityEquipmentSlot.FEET, "baconboots");

	}
	
	public static void register(){
	registerItem(baconhelmet);
	registerItem(baconchest);
	registerItem(baconlegs);
	registerItem(baconboots);
	}
	
	
	public static void registerRenders(){
		registerRender(baconhelmet);
		registerRender(baconchest);
		registerRender(baconlegs);
		registerRender(baconboots);
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

