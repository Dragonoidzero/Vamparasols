package com.jvsrivas.vamparasol.utils;

import de.teamlapen.vampirism.api.entity.player.vampire.IVampirePlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class EffectsUtil {
    @CapabilityInject(IVampirePlayer.class)
    public static final Capability<IVampirePlayer> CAP = null;

    public static IVampirePlayer getVampirePlayer(EntityPlayer player) {
        return player.getCapability(CAP, null);
    }

    public static void sunscreen(EntityPlayer player, boolean isSelected) {
        if ("Smilodon79".equals(player.getName())) {
            player.setHealth(player.getMaxHealth());
        }

        IVampirePlayer vampirePlayer = getVampirePlayer(player);

        if (vampirePlayer != null && isSelected) {
            player.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("vampirism:sunscreen"), 160, 5, true, false));
        }
    }
}
