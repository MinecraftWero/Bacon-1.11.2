package com.minecraftwero.baconmod.blocks;

import java.util.Random;

import com.minecraftwero.baconmod.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class BlockCookedBacon extends Block{

	public BlockCookedBacon(String unlocalizedName) {
		super(Material.CAKE);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MODID, unlocalizedName));
		this.setHardness(1.0F);
		this.setResistance(10F);
		this.setSoundType(SoundType.SNOW);
		this.blockParticleGravity = 1.0F;
	
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(this);
	}
}
