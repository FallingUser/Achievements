package com.github.FallingUser.achievements.network;

import com.github.FallingUser.achievements.ModCriteria;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;

public class AchievementsDatagenAdvancement implements ModInitializer {
    @Override
    public void onInitialize() {
        ModCriteria.register();
        PayloadTypeRegistry.serverboundPlay().register(OpenInventoryC2SPayload.TYPE, OpenInventoryC2SPayload.CODEC);
        OpenInventoryC2SPayload.registerServerReceiver();
    }
}