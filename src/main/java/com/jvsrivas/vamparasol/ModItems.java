package com.jvsrivas.vamparasol;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SuppressWarnings("unused")
public class ModItems {
    @GameRegistry.ObjectHolder("vamparasol:vamparasol")
    public static Vamparasol vamparasol;

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        vamparasol.initModel();
    }
}