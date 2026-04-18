package com.github.FallingUser.achievements;

import com.mojang.serialization.Codec;
import net.minecraft.advancements.criterion.ContextAwarePredicate;
import net.minecraft.advancements.criterion.SimpleCriterionTrigger;
import net.minecraft.server.level.ServerPlayer;
import org.jspecify.annotations.NonNull;

import java.util.Optional;

public class OpenInventoryCriterion extends SimpleCriterionTrigger<OpenInventoryCriterion.Conditions> {

    @Override
    public @NonNull Codec<Conditions> codec() {
        return Conditions.CODEC;
    }

    public record Conditions(Optional<ContextAwarePredicate> playerPredicate) implements SimpleCriterionTrigger.SimpleInstance {
        public static final Codec<OpenInventoryCriterion.Conditions> CODEC = ContextAwarePredicate.CODEC.optionalFieldOf("player")
                .xmap(Conditions::new, Conditions::player).codec();

        @Override
        public @NonNull Optional<ContextAwarePredicate> player() {
            return playerPredicate;
        }
        public boolean requirementsMet() {
            return true;
        }
    }

    public void trigger(ServerPlayer player) {
        trigger(player, Conditions::requirementsMet);
    }
}