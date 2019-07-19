package com.jvsrivas.vampirella;

import com.jvsrivas.vampirella.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Vampirella.MODID, name = Vampirella.MODNAME, version = Vampirella.MODVERSION, dependencies = "required-after:forge@[14.23.5.2768,)", useMetadata = true)
@SuppressWarnings("unused")
public class Vampirella {

    public static final String MODID = "vampirella";
    public static final String MODNAME = "Vampiric Baubles";
    public static final String MODVERSION = "0.0.1";

    public static boolean isVampirismLoaded;

    @SidedProxy(clientSide = "com.jvsrivas.vampirella.proxy.ClientProxy", serverSide = "com.jvsrivas.vampirella.proxy.ServerProxy")
    public static CommonProxy proxy;

    public static CreativeTabs creativeTab = new CreativeTabs("Vampirella") {
        @Override
        public ItemStack getTabIconItem() { return new ItemStack(ModItems.vampUmbrella);}
    };

    @Mod.Instance
    public static Vampirella instance;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        isVampirismLoaded = Loader.isModLoaded("vampirism");

        if(!isVampirismLoaded) {
            throw new Error("Vampirism is a core dependency for the mod Vampirella.  Please fix the dependency and restart!");
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