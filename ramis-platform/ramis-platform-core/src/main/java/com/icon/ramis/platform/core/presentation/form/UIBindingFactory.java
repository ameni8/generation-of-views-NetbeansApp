/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icon.ramis.platform.core.presentation.form;

import net.vpc.upa.AccessLevel;
import net.vpc.upa.AccessMode;
import net.vpc.upa.Field;
import net.vpc.upa.types.DoubleType;
import net.vpc.upa.types.IntType;
import net.vpc.upa.types.LongType;
import net.vpc.upa.types.ManyToOneType;
import net.vpc.upa.types.NumberType;
import net.vpc.upa.types.StringType;

/**
 *
 * @author ameni
 */
public class UIBindingFactory {

    public static UIBindingFactory INSTANCE = new UIBindingFactory();

    private UIBindingFactory() {
    }

    public static UIBindingFactory getInstance() {
        return INSTANCE;
    }

    public UIBinding createFieldBinding(Field f) {
        if (f.isSystem()) {
            return null;
        }
        final AccessLevel effectiveAccessLevel = f.getEffectiveAccessLevel(AccessMode.PERSIST);
        boolean visible = effectiveAccessLevel == AccessLevel.READ_ONLY || effectiveAccessLevel == AccessLevel.READ_WRITE || effectiveAccessLevel == AccessLevel.DEFAULT;
        if (visible) {
            UIBinding b = null;
            if (f.getDataType() instanceof StringType) {
                b = new StringUIBinding(f);
            } else if (f.getDataType() instanceof NumberType) {
                if (f.getDataType() instanceof IntType) {
                    b = new IntUIBinding(f);
                } else if (f.getDataType() instanceof LongType) {
                    b = new LongUIBinding(f);
                } else if (f.getDataType() instanceof DoubleType) {
                    b = new DoubleUIBinding(f);
                }
            } else if (f.getDataType() instanceof ManyToOneType) {
                b = new ManyToOneUIBinding(f);
            }
            if (b == null) {
                b = new UnknownUIBinding(f);
            }
            return b;
        }
        return null;
    }

}
