package com.hahajax.protectionchange.config;

import com.hahajax.protectionchange.formula.FormulaManager;
import eu.midnightdust.lib.config.MidnightConfig;

public class ProtectionChangeMidnightConfig extends MidnightConfig {

	@Entry(category = "default") public static FormulaType formulaType = FormulaType.LINEAR;
	public enum FormulaType {
		LINEAR,
		SQUARE_ROOT,
		TYPE_2,
		TYPE_3,
		CUSTOM
	}

	@Entry(category = "variables", min = 4F) public static float maxProtLevels = 36;
	@Entry(category = "variables", min = 0F, max = 1F) public static float rootConstant = 0.116666666667F;
	@Entry(category = "variables", min = 0F, max = 1F) public static float rootExponent = 0.5F;
	@Entry(category = "variables", min = 0F, max = 1F) public static float linearRate = 0.04F;

	@Override
	public void writeChanges() {
		super.writeChanges();

		FormulaManager.updateStrategy();
	}
}