package com.hahajax.protectionchange.mixin;

import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.CombatRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CombatRules.class)
public class CombatRulesMixin {

	@Inject(
			method = "getDamageAfterMagicAbsorb",
			at = @At("RETURN"),
			cancellable = true
	)
	private static void modifyDamageAfterMagicAbsorb(float initialDamage, float protLevels, CallbackInfoReturnable<Float> cir) {
		// protLevels is the sum of protection levels across all armor pieces
		// initialDamage is the amount of damage after effects like resistance. unsure if it's before or after normal armor/toughness DR

		// vanilla's formula. gonna change it eventually
		float f = Mth.clamp(protLevels, 0.0F, 20.0F);
		float damage = initialDamage * (1.0F - f / 25.0F);

		cir.setReturnValue(damage);
	}
}