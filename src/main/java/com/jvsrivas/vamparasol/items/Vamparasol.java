package com.jvsrivas.vamparasol.items;

import com.jvsrivas.vamparasol.Vamparasols;
import com.jvsrivas.vamparasol.utils.EffectsUtil;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Vamparasol extends Item {
    public Vamparasol() {
        setRegistryName("vamparasol");
        setUnlocalizedName(Vamparasols.MODID + ".vamparasol");
        setCreativeTab(Vamparasols.creativeTab);
        setMaxStackSize(1);
        setMaxDamage(0);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (entityIn instanceof EntityPlayer)
            EffectsUtil.sunscreen((EntityPlayer) entityIn, isSelected);
    }
}