package com.minecraftwero.baconmod.handlers;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityHandler {

	static int entityID = 50;

	public static void registerModEntity(ResourceLocation registryName, Class<? extends Entity> eClass, String name, Object mod, int trackRange, int updateFreq, boolean sVU)
	{
	        EntityRegistry.registerModEntity(registryName, eClass, name, ++entityID, mod, trackRange, updateFreq, sVU);
	}
	
	
}

