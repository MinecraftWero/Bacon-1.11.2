package com.minecraftwero.baconmod.init;

import com.minecraftwero.baconmod.Bacon;
import com.minecraftwero.baconmod.Reference;
import com.minecraftwero.baconmod.blocks.BlockCookedBacon;
import com.minecraftwero.baconmod.blocks.BlockRawBacon;
import com.minecraftwero.baconmod.util.Utils;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {

	public static Block blockraw;
	public static Block blockcooked;
	
	public static void init(){
		
		blockraw = new BlockRawBacon("blockraw");
		blockcooked = new BlockCookedBacon("blockcooked");
	}
	
	public static void register(){
		registerBlock(blockraw);
		registerBlock(blockcooked);
	}
	
	
	public static void registerRenders(){
		registerRender(blockraw);
		registerRender(blockcooked);
	}
	
	
	public static void registerBlock(Block block) {
		block.setCreativeTab(Bacon.items);
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		Utils.getLogger().info("Registered Block: " + block.getRegistryName());
	}
	
	
	public static void registerRender(Block block) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, block.getUnlocalizedName().substring(5)), "inventory"));
		Utils.getLogger().info("Registered render for " + block.getRegistryName());
	}
	
	
}
