package com.hahajax.protectionchange.formula;

import com.hahajax.protectionchange.ProtectionChange;
import com.hahajax.protectionchange.config.ProtectionChangeMidnightConfig;
import net.minecraft.util.Mth;

public interface Formulas {
	float calculate(float damage, float protLevels);

	static float vanilla(float damage, float protLevels) {
		float f = Mth.clamp(protLevels, 0.0F, 20.0F);
		return damage * (1.0F - f / 25.0F);
	}

	static float invalid(float damage, float protLevels) {
		ProtectionChange.LOGGER.error("Invalid formula type in ProtectionChange config");

		return 0;
	}

	static float squareRoot(float damage, float protLevels) {
//		return (damage / 2);
		float p = Mth.clamp(protLevels, 0.0F, ProtectionChangeMidnightConfig.maxProtLevels);
		float c = ProtectionChangeMidnightConfig.formulaConstant;
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