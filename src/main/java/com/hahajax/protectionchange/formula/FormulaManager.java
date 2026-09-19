package com.hahajax.protectionchange.formula;


public class FormulaManager {
	// Defaults to linear until config is loaded
	private static Formulas activeStrategy = Formulas::test1;

	public static float compute(float damage, float protLevels) {
		return activeStrategy.calculate(damage, protLevels);
	}

	public static void updateStrategy(FormulaType formulaType) {
		activeStrategy = switch (formulaType) {
			case VANILLA -> Formulas::vanilla;
			case TYPE_1 -> Formulas::test1;
			case TYPE_2 -> Formulas::test2;
			case TYPE_3 -> Formulas::test3;
			case CUSTOM -> Formulas::testCustom;
			default -> Formulas::invalid;
		};
	}
}