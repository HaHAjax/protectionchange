package com.hahajax.protectionchange.formula;

import com.hahajax.protectionchange.ProtectionChange;
import com.hahajax.protectionchange.config.ProtectionChangeMidnightConfig;
import net.minecraft.util.Mth;

public interface Formulas {
	float calculate(float damage, float protLevels);

	float protMax = ProtectionChangeMidnightConfig.maxProtLevels;


	static float invalid(float damage, float protLevels) {
		ProtectionChange.LOGGER.error("Invalid formula type in ProtectionChange config");

		return 0;
	}

	static float linear(float damage, float protLevels) {
		float p = Mth.clamp(protLevels, 0.0F, protMax);
		return damage * (1.0F - p * ProtectionChangeMidnightConfig.linearRate);
	}

	static float squareRootCurve(float damage, float protLevels) {
		float p = Mth.clamp(protLevels, 0.0F, protMax);
		float c = ProtectionChangeMidnightConfig.sqrtConstant;
		return damage * (1.0F - c * Mth.sqrt(p));
	}

	static float test2(float damage, float protLevels) {
		return (damage / 4);
	}

	static float test3(float damage, float protLevels) {
		return (damage / 8);
	}

	// TODO: add custom formula input to config and make it work here
	static float custom(float damage, float protLevels) {
		return (damage);
	}
}