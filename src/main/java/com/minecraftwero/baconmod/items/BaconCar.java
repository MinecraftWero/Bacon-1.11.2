package com.minecraftwero.baconmod.items;

import com.minecraftwero.baconmod.Reference;

import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class BaconCar extends Item
{
	public BaconCar(String unlocalizedName) {
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MODID, unlocalizedName));
		this.setMaxStackSize(1);
		}

	@Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if(!worldIn.isRemote) {
            Vec3d eyes = playerIn.getPositionEyes(1.0f);
            Vec3d look = playerIn.getLookVec();
            Vec3d vec = eyes.addVector(look.xCoord * 300, look.yCoord * 300, look.zCoord * 300);
            RayTraceResult result = worldIn.rayTraceBlocks(eyes, vec, true, true, true);
            if(result.typeOfHit != RayTraceResult.Type.MISS) {
                Vec3d target = result.hitVec;
                for(int i = 0; i < itemRand.nextInt(1) + 1; i++) {
                    EntityBoat lightning = new EntityBoat(worldIn, target.xCoord + itemRand.nextInt(2) - 1, target.yCoord, target.zCoord + itemRand.nextInt(2) - 1);
                    worldIn.spawnEntity(lightning);
                    worldIn.addWeatherEffect(lightning);
                }
            }
            ItemStack stack = playerIn.getHeldItem(handIn);
            stack.shrink(1);
            playerIn.setHeldItem(handIn, stack);
        }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
	}
}