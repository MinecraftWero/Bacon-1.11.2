package com.minecraftwero.baconmod.renders;

import com.minecraftwero.baconmod.entities.EntityBacon;
import com.minecraftwero.baconmod.init.ModBlocks;
import com.minecraftwero.baconmod.init.ModItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderBacon extends Render<EntityBacon> {

    private final RenderItem itemRenderer;

	
	public RenderBacon(RenderManager renderManagerIn) {
	        super(renderManagerIn);
	        this.itemRenderer = Minecraft.getMinecraft().getRenderItem();
	    }
	
		@Override
	    public void doRender(EntityBacon entity, double x, double y, double z, float entityYaw, float partialTicks)
	    {
	        GlStateManager.pushMatrix();
	        GlStateManager.translate((float)x, (float)y, (float)z);
	        GlStateManager.enableRescaleNormal();
	        GlStateManager.rotate(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
	        GlStateManager.rotate((this.renderManager.options.thirdPersonView == 2 ? -1 : 1) * this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
	        GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
	        this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);

	        
	        this.itemRenderer.renderItem(this.getStackToRender(entity), ItemCameraTransforms.TransformType.GROUND);


	        GlStateManager.disableRescaleNormal();
	        GlStateManager.popMatrix();
	        super.doRender(entity, x, y, z, entityYaw, partialTicks);
	    }

	    public ItemStack getStackToRender(EntityBacon entityIn)
	    {
	        return new ItemStack(ModItems.rawbacon);
	    }

		@Override
		protected ResourceLocation getEntityTexture(EntityBacon entity) {
			return TextureMap.LOCATION_BLOCKS_TEXTURE;
		}
	
	
}