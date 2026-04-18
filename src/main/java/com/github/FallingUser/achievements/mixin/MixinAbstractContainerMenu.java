package com.github.FallingUser.achievements.mixin;

import com.github.FallingUser.achievements.network.OpenInventoryC2SPayload;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InventoryScreen.class)
public class MixinAbstractContainerMenu {
    @Inject(method = "init", at = @At("HEAD"))
    private void IsPlayerOpenInventory(CallbackInfo ci) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player != null) {
            ClientPlayNetworking.send(new OpenInventoryC2SPayload());
        }
    }
}
