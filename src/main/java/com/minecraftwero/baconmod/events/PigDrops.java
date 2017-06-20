package com.minecraftwero.baconmod.events;

import java.util.Random;
import com.minecraftwero.baconmod.init.ModItems;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PigDrops {

	@SubscribeEvent
	public void onEntityDrop(LivingDropsEvent event) {
		if (event.getEntityLiving() instanceof EntityPig) {
			Random rand = new Random();
			boolean extraDrop = rand.nextBoolean();
			ItemStack drop = new ItemStack(ModItems.rawbacon, extraDrop ? 3 : 2);
			event.getDrops().add(new EntityItem(event.getEntity().getEntityWorld(), event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, drop));
		}
	}
	
}
