package com.hahajax.protectionchange.formula;


import com.hahajax.protectionchange.config.ProtectionChangeMidnightConfig;

public class FormulaManager {
	private static Formulas activeStrategy = Formulas::linear;
	private static float protMax, linearRate, rootConstant, rootExponent = 0.0F;

	public static float compute(float damage, float protLevels) {
		return activeStrategy.calculate(damage, protLevels, protMax, linearRate, rootConstant, rootExponent);
	}

	public static void updateStrategy() {
		activeStrategy = switch (ProtectionChangeMidnightConfig.formulaType) {
			case LINEAR -> Formulas::linear;
			case SQUARE_ROOT -> Formulas::squareRootCurve;
//			case CUSTOM -> Formulas::custom;
			default -> Formulas::invalid;
		};
		linearRate = ProtectionChangeMidnightConfig.linearRate;
		protMax = ProtectionChangeMidnightConfig.maxProtLevels;
		rootConstant = ProtectionChangeMidnightConfig.rootConstant;
		rootExponent = ProtectionChangeMidnightConfig.rootExponent;
	}
}