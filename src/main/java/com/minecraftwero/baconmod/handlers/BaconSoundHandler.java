package com.minecraftwero.baconmod.handlers;

import com.minecraftwero.baconmod.Reference;
import com.minecraftwero.baconmod.util.Utils;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class BaconSoundHandler {

	private static int size = 0;
	
	public static SoundEvent BACON_SHOOT;
	
	public static void init(){
		size = SoundEvent.REGISTRY.getKeys().size();
	
		BACON_SHOOT = register("item.bacon_shoot.shoot");
	}

	
	public static SoundEvent register(String name){
		ResourceLocation location = new ResourceLocation(Reference.MODID, name);
		SoundEvent e = new SoundEvent(location);
	
		SoundEvent.REGISTRY.register(size, location, e);
		size++;
		Utils.getLogger().info("Registered sound: " + name);
		return e;
	}
}


	