package com.hahajax.protectionchange.config;

import com.hahajax.protectionchange.formula.FormulaManager;
import eu.midnightdust.lib.config.MidnightConfig;

public class ProtectionChangeMidnightConfig extends MidnightConfig {

	@Entry(category = "default") public static FormulaType formulaType = FormulaType.VANILLA;
	public enum FormulaType {
		VANILLA,
		SQUARE_ROOT,
		TYPE_2,
		TYPE_3,
		CUSTOM
	}

	@Entry(category = "default") public static float maxProtLevels = 36;
//	@Entry(category = "default") public static float formulaConstant = 0.116666666667F;
	@Entry(category = "default", min = 0f, max = 1f, precision = 1000) public static float formulaConstant = 0.116666666667F;

	@Override
	public void writeChanges() {
		super.writeChanges();

		FormulaManager.updateStrategy();
	}
}