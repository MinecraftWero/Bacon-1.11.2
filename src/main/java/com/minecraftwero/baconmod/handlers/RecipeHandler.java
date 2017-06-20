package com.minecraftwero.baconmod.handlers;

import com.minecraftwero.baconmod.init.ModArmors;
import com.minecraftwero.baconmod.init.ModBlocks;
import com.minecraftwero.baconmod.init.ModItems;
import com.minecraftwero.baconmod.init.ModTools;
import com.minecraftwero.baconmod.util.Utils;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeHandler {

	public static void registerCraftingRecipes(){
		registerToolRecipe(ModItems.rawbacon, ModTools.baconpick, ModTools.baconaxe, ModTools.baconspade, ModTools.baconhoe, ModTools.baconsword);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockraw), new Object[] { "RRR", "RRR", "RRR", 'R', ModItems.rawbacon });
		GameRegistry.addRecipe(new ItemStack(ModItems.gaybacon), new Object [] { " S ", "SBS", " S ", 'S', Items.SUGAR, 'B', ModItems.rawbacon});

		
		registerArmourRecipe(ModArmors.baconhelmet, ModArmors.baconchest, ModArmors.baconlegs, ModArmors.baconboots, ModItems.rawbacon);
		Utils.getLogger().info("Registered Crafting Recipes");
	}
	
	public static void registerSmeltingRecipes(){
		GameRegistry.addSmelting(ModItems.rawbacon, new ItemStack(ModItems.cookedbacon), 0.35f);
		GameRegistry.addSmelting(ModBlocks.blockraw, new ItemStack(ModBlocks.blockcooked), 0.50f);
		GameRegistry.addSmelting(ModItems.rawbeef, new ItemStack(ModItems.roastbeef), 0.35f);
		GameRegistry.addSmelting(Items.EGG, new ItemStack(ModItems.eggfried), 0.35F);
		Utils.getLogger().info("Registered Smelting Recipes");
	}
	
		private static void registerToolRecipe(Item ingot, Item pickaxe, Item axe, Item shovel, Item hoe, Item sword) {
			GameRegistry.addRecipe(new ItemStack(pickaxe), new Object[] { "III", " S ", " S ", 'I', ingot, 'S', Items.STICK });
			GameRegistry.addRecipe(new ItemStack(axe), new Object[] { "II", "IS", " S", 'I', ingot, 'S', Items.STICK });
			GameRegistry.addRecipe(new ItemStack(shovel), new Object[] { "I", "S", "S", 'I', ingot, 'S', Items.STICK });
			GameRegistry.addRecipe(new ItemStack(hoe), new Object[] { "II", " S", " S", 'I', ingot, 'S', Items.STICK });
			GameRegistry.addRecipe(new ItemStack(sword), new Object[] { "I", "I", "S", 'I', ingot, 'S', Items.STICK });
	
	}
	
		public static void registerArmourRecipe(Item helmet, Item chestplate, Item leggings, Item boots, Item ingot) {
			GameRegistry.addRecipe(new ItemStack(helmet), new Object[] { "III","I I","   ",'I',ingot});
			GameRegistry.addRecipe(new ItemStack(helmet), new Object[] { "   ","III","I I",'I',ingot});
			GameRegistry.addRecipe(new ItemStack(chestplate), new Object[] { "I I","III","III",'I',ingot});
			GameRegistry.addRecipe(new ItemStack(leggings), new Object[] { "III","I I","I I",'I',ingot});
			GameRegistry.addRecipe(new ItemStack(boots), new Object[] { "I I","I I","   ",'I',ingot});
			GameRegistry.addRecipe(new ItemStack(boots), new Object[] { "   ","I I","I I",'I',ingot});
		}
}
