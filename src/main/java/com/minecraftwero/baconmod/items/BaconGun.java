package com.minecraftwero.baconmod.items;

import com.minecraftwero.baconmod.Reference;
import com.minecraftwero.baconmod.entities.EntityBacon;
import com.minecraftwero.baconmod.handlers.BaconSoundHandler;
import com.minecraftwero.baconmod.init.ModItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class BaconGun extends Item
{
	public BaconGun(String unlocalizedName) {
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MODID, unlocalizedName));
		this.setMaxStackSize(1);
	}
	/**
	 * Called when the equipped item is right clicked.
	 */

	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
	{
		ItemStack itemStack = playerIn.getHeldItem(handIn);

		for (int i = 0; i < playerIn.inventory.getSizeInventory(); ++i){

			ItemStack itemstack = playerIn.inventory.getStackInSlot(i);

			if(itemstack.getItem()==ModItems.rawbacon){

				if(!playerIn.capabilities.isCreativeMode)

					itemstack.shrink(1);

				if (!worldIn.isRemote)
				{
					EntityBacon entitybacon = new EntityBacon(worldIn, playerIn);
					entitybacon.setHeadingFromThrower(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
					worldIn.spawnEntity(entitybacon);
					worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, BaconSoundHandler.BACON_SHOOT, SoundCategory.NEUTRAL, 1.0F, 2.0F);
				}
				break;
			}
		}

		playerIn.addStat(StatList.getObjectUseStats(this));
		return new ActionResult(EnumActionResult.SUCCESS, itemStack);
	}

}