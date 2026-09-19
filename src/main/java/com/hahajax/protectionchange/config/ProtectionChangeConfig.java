package com.hahajax.protectionchange.config;

import com.hahajax.protectionchange.formula.FormulaType;
import net.neoforged.neoforge.common.ModConfigSpec;


public class ProtectionChangeConfig {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();


    public static final ModConfigSpec.ConfigValue<FormulaType> FORMULA_TYPE = BUILDER
            .comment("The preset formula to use, or a custom one. Certain variables in the non-vanilla presets can be modified. WARNING: Custom does nothing at the moment, sorry for the inconvenience!")
            .defineEnum("formulaType", FormulaType.TYPE_1);


    public static final ModConfigSpec SPEC = BUILDER.build();
}
