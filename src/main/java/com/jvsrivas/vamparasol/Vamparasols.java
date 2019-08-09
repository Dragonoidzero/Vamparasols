package com.jvsrivas.vamparasol;

import com.jvsrivas.vamparasol.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Vamparasols.MODID, name = Vamparasols.MODNAME, version = Vamparasols.MODVERSION, dependencies = "required-after:forge@[14.23.5.2768,)", useMetadata = true)
@SuppressWarnings("unused")
public class Vamparasols {

    public static final String MODID = "vamparasol";
    public static final String MODNAME = "Vampiric Baubles";
    public static final String MODVERSION = "0.0.4";

    public static boolean isVampirismLoaded;

    @SidedProxy(clientSide = "com.jvsrivas.vamparasol.proxy.ClientProxy", serverSide = "com.jvsrivas.vamparasol.proxy.ServerProxy")
    public static CommonProxy proxy;

    public static CreativeTabs creativeTab = new CreativeTabs("Vamparasol") {
        @Override
        public ItemStack getTabIconItem() { return new ItemStack(ModItems.vamparasol);}
    };

    @Mod.Instance
    public static Vamparasols instance;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        isVampirismLoaded = Loader.isModLoaded("vampirism");

        if(!isVampirismLoaded) {
            throw new Error("Vampirism is a core dependency for the mod Vamparasols.  Please fix the dependency and restart!");
        }

        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}