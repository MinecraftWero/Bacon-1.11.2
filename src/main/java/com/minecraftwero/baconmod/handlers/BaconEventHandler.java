package com.minecraftwero.baconmod.handlers;

import com.minecraftwero.baconmod.events.CowDrops;
import com.minecraftwero.baconmod.events.PigDrops;

import net.minecraftforge.common.MinecraftForge;

public class BaconEventHandler {
	
	public static void registerEvents() {
	
		MinecraftForge.EVENT_BUS.register(new PigDrops());
		
		MinecraftForge.EVENT_BUS.register(new CowDrops());
	}
}
