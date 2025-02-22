package com.github.atomicblom.luckofthestraw;

import com.google.gson.JsonObject;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Random;

public class GrassLootModifier extends LootModifier {
    private final boolean enableLootModifier;
    private final float dropProbability;
    final NonNullList<ItemStack> allItems = NonNullList.create();

    public GrassLootModifier(ILootCondition[] conditionsIn, boolean enableLootModifier, float dropProbability) {
        super(conditionsIn);
        this.enableLootModifier = enableLootModifier;
        this.dropProbability = dropProbability;
        for (final Item item : ForgeRegistries.ITEMS) {
            System.out.println(item.getRegistryName());
            for (final ItemGroup creativeTabs : ItemGroup.TABS) {
                System.out.println("group:"+creativeTabs.getId());
                item.fillItemCategory(creativeTabs, allItems);
            }
        }
    }

    @Nonnull
    @Override
    public List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        Random random = new Random();
        if (enableLootModifier && context.getRandom().nextFloat() <= dropProbability) {
            generatedLoot.add(new ItemStack(Items.STRING));
        }
        generatedLoot.add(allItems.get(random.nextInt(allItems.size())));
        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<GrassLootModifier> {

        @Override
        public GrassLootModifier read(ResourceLocation name, JsonObject object, ILootCondition[] conditionsIn) {
            // Reading custom variables
            boolean enableLootModifier = JSONUtils.getAsBoolean(object, "enableLootModifier");
            float dropProbability = JSONUtils.getAsFloat(object, "dropProbability");
            return new GrassLootModifier(conditionsIn, enableLootModifier, dropProbability);
        }

        // In forge documentation this method was not mentioned whatsoever,
        // this is how I implemented it based on it's javadoc.
        // Sources:
        // https://mcforge.readthedocs.io/en/latest/items/globallootmodifiers/
        // https://github.com/MinecraftForge/MinecraftForge/blob/1.15.x/src/test/java/net/minecraftforge/debug/gameplay/loot/GlobalLootModifiersTest.java
        @Override
        public JsonObject write(GrassLootModifier instance) {
            return makeConditions(instance.conditions);
        }
    }
}
