package com.minecraftwero.baconmod.creativetab;

import com.minecraftwero.baconmod.Reference;
import com.minecraftwero.baconmod.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class BaconTab extends CreativeTabs {

	public BaconTab() {
		super(Reference.MODID);
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.rawbacon);
	}

}
