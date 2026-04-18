package com.github.FallingUser.achievements;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;

public class ModCriteria {
    public static OpenInventoryCriterion OPEN_INVENTORY;

    public static void register() {
        OPEN_INVENTORY = Registry.register(BuiltInRegistries.TRIGGER_TYPES, "achievements:open_inventory", new OpenInventoryCriterion());
    }
}