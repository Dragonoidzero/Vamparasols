package com.jvsrivas.vamparasol;

import de.teamlapen.vampirism.api.entity.player.vampire.IVampirePlayer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Vamparasol extends Item {
    @CapabilityInject(IVampirePlayer.class)
    public static final Capability<IVampirePlayer> CAP = null;

    public static IVampirePlayer getVampirePlayer(EntityPlayer player) {
        return player.getCapability(CAP, null);
    }

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
        if (entityIn instanceof EntityPlayer) {
            EntityPlayer player = ((EntityPlayer) entityIn);

            IVampirePlayer vampirePlayer = getVampirePlayer(player);

            if(vampirePlayer != null) {
                player.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("vampirism:sunscreen"), 160, 5, true, false));
            }
        }
    }
}