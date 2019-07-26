package com.jvsrivas.vamparasol;

import com.jvsrivas.vamparasol.items.VamCharm;
import com.jvsrivas.vamparasol.items.Vamparasol;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SuppressWarnings("unused")
public class ModItems {
    @GameRegistry.ObjectHolder("vamparasol:vamparasol")
    public static Vamparasol vamparasol;

    @GameRegistry.ObjectHolder("vamparasol:vamcharm")
    public static VamCharm vamCharm;

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        vamparasol.initModel();
        vamCharm.initModel();
    }
}