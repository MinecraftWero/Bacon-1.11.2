package com.minecraftwero.baconmod.items;

import com.minecraftwero.baconmod.Reference;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class BeefSoup extends ItemFood{
	
	public BeefSoup(String unlocalizedName, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MODID, unlocalizedName));
		this.setMaxStackSize(1);
	}

	    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
	    {
	        super.onItemUseFinish(stack, worldIn, entityLiving);
	        return new ItemStack(Items.BOWL);
	
	    }
	}


