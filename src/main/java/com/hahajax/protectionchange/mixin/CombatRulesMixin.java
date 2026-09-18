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
	private static void modifyDamageAfterMagicAbsorb(float damage, float enchantModifiers, CallbackInfoReturnable<Float> cir) {
		// enchantModifiers is the sum of protection levels across all armor pieces
		// damage is the amount of damage after effects like resistance. unsure if it's before or after normal armor/toughness DR

		// vanilla's formula. gonna change it once DT's available
		float f = Mth.clamp(enchantModifiers, 0.0F, 20.0F);
		float final_damage = damage * (1.0F - f / 25.0F);

		cir.setReturnValue(final_damage);
	}
}