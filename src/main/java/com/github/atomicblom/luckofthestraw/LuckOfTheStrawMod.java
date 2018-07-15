package com.github.atomicblom.luckofthestraw;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

@Mod(modid = LuckOfTheStrawMod.MODID, name = LuckOfTheStrawMod.NAME, version = LuckOfTheStrawMod.VERSION, dependencies = "before:crafttweaker", acceptedMinecraftVersions = "[1.12, 1.13)")
public class LuckOfTheStrawMod
{
    static final String MODID = "luckofthestraw";
    static final String NAME = "Luck of the Straw";
    public static final String VERSION = "@MOD_VERSION@";

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        final NonNullList<ItemStack> allItems = NonNullList.create();

        for (final Item item : ForgeRegistries.ITEMS)
        {
            for (final CreativeTabs creativeTabs : CreativeTabs.CREATIVE_TAB_ARRAY)
            {
                item.getSubItems(creativeTabs, allItems);
            }
        }

        for (final ItemStack itemStack : allItems)
        {
            MinecraftForge.addGrassSeed(itemStack, 1);
        }
    }
}
