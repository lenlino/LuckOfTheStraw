package com.github.atomicblom.luckofthestraw;

import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = "luckofthestraw", bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerModifierSerializers(final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
        IForgeRegistry<GlobalLootModifierSerializer<?>> registry = event.getRegistry();
        register(registry, new GrassLootModifier.Serializer(), "grass");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, OptionsHolder.COMMON_SPEC);
    }

    private static void register(IForgeRegistry<GlobalLootModifierSerializer<?>> registry, GlobalLootModifierSerializer<?> serializer, String name) {
        registry.register(serializer.setRegistryName("luckofthestraw", "grass"));
    }
}