package com.hahajax.protectionchange.formula;

import com.hahajax.protectionchange.ProtectionChange;
import com.hahajax.protectionchange.config.ProtectionChangeMidnightConfig;
import net.minecraft.util.Mth;

public interface Formulas {
	float calculate(float damage, float protLevels, float protMax, float linearRate, float rootConstant, float rootExponent);

	static float invalid(float damage, float protLevels, float protMax, float linearRate, float rootConstant, float rootExponent) {
		ProtectionChange.LOGGER.error("Invalid formula type in ProtectionChange config");

		return 0;
	}

	static float linear(float damage, float protLevels, float protMax, float linearRate, float rootConstant, float rootExponent) {
		float p = Mth.clamp(protLevels, 0.0F, protMax);
		return damage * (1.0F - p * linearRate);
	}

	static float squareRootCurve(float damage, float protLevels, float protMax, float linearRate, float rootConstant, float rootExponent) {
		float p = Mth.clamp(protLevels, 0.0F, protMax);
		return damage * (1.0F - rootConstant * (p * rootExponent));
	}

	// TODO: add custom formula input to config and make it work here
//	static float custom(float damage, float protLevels) {
//		return (damage);
//	}
}