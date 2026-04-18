package com.github.FallingUser.achievements.network;

import com.github.FallingUser.achievements.ModCriteria;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;

public record OpenInventoryC2SPayload() implements CustomPacketPayload {
    public static final Identifier ID = Identifier.fromNamespaceAndPath("achievements", "open_inventory");
    public static final CustomPacketPayload.Type<OpenInventoryC2SPayload> TYPE = new CustomPacketPayload.Type<>(ID);
    public static final StreamCodec<RegistryFriendlyByteBuf, OpenInventoryC2SPayload> CODEC = StreamCodec.unit(new OpenInventoryC2SPayload());

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void registerServerReceiver() {
        ServerPlayNetworking.registerGlobalReceiver(TYPE, (payload, context) -> {
            context.server().execute(() -> {
                ServerPlayer player = context.player();
                ModCriteria.OPEN_INVENTORY.trigger(player);
            });
        });
    }
}