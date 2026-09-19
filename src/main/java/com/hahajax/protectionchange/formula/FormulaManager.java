package com.hahajax.protectionchange.formula;


import com.hahajax.protectionchange.config.MidnightTestConfigClass;

public class FormulaManager {
	private static Formulas activeStrategy = Formulas::vanilla;

	public static float compute(float damage, float protLevels) {
		return activeStrategy.calculate(damage, protLevels);
	}

	public static void updateStrategy() {
		activeStrategy = switch (MidnightTestConfigClass.formulaType) {
			case VANILLA -> Formulas::vanilla;
			case TYPE_1 -> Formulas::test1;
			case TYPE_2 -> Formulas::test2;
			case TYPE_3 -> Formulas::test3;
			case CUSTOM -> Formulas::testCustom;
			default -> Formulas::invalid;
		};
	}
}