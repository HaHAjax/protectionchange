package com.hahajax.protectionchange.config;

import com.hahajax.protectionchange.formula.FormulaManager;
import eu.midnightdust.lib.config.MidnightConfig;

public class MidnightTestConfigClass extends MidnightConfig {

	@Entry(category = "default") public static FormulaType formulaType = FormulaType.VANILLA;
	public enum FormulaType {
		VANILLA,
		TYPE_1,
		TYPE_2,
		TYPE_3,
		CUSTOM
	}

	@Override
	public void writeChanges() {
		super.writeChanges();

		FormulaManager.updateStrategy();
	}
}