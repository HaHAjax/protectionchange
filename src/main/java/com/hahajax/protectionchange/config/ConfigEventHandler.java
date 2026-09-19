package com.hahajax.protectionchange.config;

import com.hahajax.protectionchange.formula.FormulaManager;
import com.hahajax.protectionchange.ProtectionChange;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;

@EventBusSubscriber(modid = ProtectionChange.MODID)
public class ConfigEventHandler {

	@SubscribeEvent
	public static void onConfigLoad(ModConfigEvent.Loading event) {
		if (event.getConfig().getSpec() == ProtectionChangeConfig.SPEC) {
			FormulaManager.updateStrategy(ProtectionChangeConfig.FORMULA_TYPE.get());
		}
	}

	@SubscribeEvent
	public static void onConfigReload(ModConfigEvent.Reloading event) {
		if (event.getConfig().getSpec() == ProtectionChangeConfig.SPEC) {
			FormulaManager.updateStrategy(ProtectionChangeConfig.FORMULA_TYPE.get());
		}
	}
}