package com.hahajax.protectionchange.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ProtChangeConfig {
	private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

	public static final ModConfigSpec.IntValue TEST_INT = BUILDER
			.comment("A magic number")
			.defineInRange("magicNumber", 42, 0, Integer.MAX_VALUE);

}