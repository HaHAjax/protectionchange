package com.hahajax.protectionchange.formula;


import com.hahajax.protectionchange.config.ProtectionChangeMidnightConfig;

public class FormulaManager {
	private static Formulas activeStrategy = Formulas::linear;

	public static float compute(float damage, float protLevels) {
		return activeStrategy.calculate(damage, protLevels);
	}

	public static void updateStrategy() {
		activeStrategy = switch (ProtectionChangeMidnightConfig.formulaType) {
			case LINEAR -> Formulas::linear;
			case SQUARE_ROOT -> Formulas::squareRootCurve;
			case TYPE_2 -> Formulas::test2;
			case TYPE_3 -> Formulas::test3;
			case CUSTOM -> Formulas::custom;
			default -> Formulas::invalid;
		};
	}
}