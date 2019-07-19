package com.jvsrivas.vampirella;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SuppressWarnings("unused")
public class ModItems {
    @GameRegistry.ObjectHolder("vampirella:vampirella")
    public static VampUmbrella vampUmbrella;

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        vampUmbrella.initModel();
    }
}