package com.minecraftwero.baconmod.proxy;

import com.minecraftwero.baconmod.entities.EntityBacon;
import com.minecraftwero.baconmod.init.ModArmors;
import com.minecraftwero.baconmod.init.ModBlocks;
import com.minecraftwero.baconmod.init.ModItems;
import com.minecraftwero.baconmod.init.ModTools;
import com.minecraftwero.baconmod.renders.RenderBacon;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import scala.tools.nsc.Global.Run;

public class ClientProxy  extends CommonProxy{
	
    public TextureManager renderEngine;

	@Override
	public void registerRenders(){
		ModItems.registerRenders();
		ModTools.registerRenders();
		ModArmors.registerRenders();
		ModBlocks.registerRenders();
		RenderingRegistry.registerEntityRenderingHandler(EntityBacon.class, RenderBacon::new);

	}
}
