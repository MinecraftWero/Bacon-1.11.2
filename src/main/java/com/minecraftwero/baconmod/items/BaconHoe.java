package com.minecraftwero.baconmod.items;

import com.minecraftwero.baconmod.Reference;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class BaconHoe extends ItemHoe{
	
	public BaconHoe(ToolMaterial material, String unlocalizedName) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MODID, unlocalizedName));
	}

	 @Override
	    public int getMaxItemUseDuration(ItemStack stack) {
	        return 32;
	    }
	    @Override
	    public EnumAction getItemUseAction(ItemStack stack) {
	        return EnumAction.EAT;
	    }
	  
	    @Override
	    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
	    {
	        ItemStack itemstack = playerIn.getHeldItem(handIn);

	        if (playerIn.canEat(false))
	        {
	            playerIn.setActiveHand(handIn);
	            return new ActionResult<>(EnumActionResult.SUCCESS, itemstack);
	        }
	        else
	        {
	            return new ActionResult<>(EnumActionResult.FAIL, itemstack);
	        }
	    }

	    @Override
	    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
	    {
	        if (entityLiving instanceof EntityPlayer)
	        {
	            EntityPlayer entityplayer = (EntityPlayer)entityLiving;
	            entityplayer.getFoodStats().addStats(this.getHealAmount(stack), this.getSaturationModifier(stack));
	            entityplayer.heal(entityplayer.getMaxHealth() / 3);
	            worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
	            entityplayer.addStat(StatList.getObjectUseStats(this));
	        }

	        stack.damageItem(10, entityLiving);
	        return stack;
	    }

	    public int getHealAmount(ItemStack stack)
	    {
	        return 1;
	    }

	    public float getSaturationModifier(ItemStack stack)
	    {
	        return 0.10F;
	    }
	
}
