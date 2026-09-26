package com.github.FallingUser.achievements;

import com.mojang.serialization.Codec;
import net.minecraft.advancements.triggers.SimpleCriterionTrigger;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import org.jspecify.annotations.NonNull;

import java.util.Optional;

public class OpenInventoryCriterion extends SimpleCriterionTrigger<OpenInventoryCriterion.Conditions> {

    @Override
    public @NonNull Codec<Conditions> codec() {
        return Conditions.CODEC;
    }

    public record Conditions(Optional<Holder<LootItemCondition>> playerPredicate) implements SimpleCriterionTrigger.SimpleInstance {
        public static final Codec<OpenInventoryCriterion.Conditions> CODEC = LootItemCondition.CODEC.optionalFieldOf("player")
                .xmap(Conditions::new, Conditions::player).codec();

        @Override
        public @NonNull Optional<Holder<LootItemCondition>> player() {
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
