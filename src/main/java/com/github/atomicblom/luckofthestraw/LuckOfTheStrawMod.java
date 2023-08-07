package com.github.atomicblom.luckofthestraw;

import net.minecraft.block.GrassBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.*;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifierManager;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

import static net.minecraftforge.versions.forge.ForgeVersion.MOD_ID;

@Mod("luckofthestraw")
public class LuckOfTheStrawMod
{
    //guide https://forums.minecraftforge.net/topic/96325-1164-loot-table-minecraftblocksgrass-not-loaded/
    static final String MODID = "luckofthestraw";
    static final String NAME = "Luck of the Straw";
    public static final String VERSION = "@MOD_VERSION@";

}
