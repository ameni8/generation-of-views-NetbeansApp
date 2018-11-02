/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icon.ramis.platform.core.presentation.form;

import com.jfoenix.controls.JFXTextField;
import net.vpc.upa.Document;
import net.vpc.upa.Field;

/**
 *
 * @author ameni
 */
public class LongUIBinding extends AbstractUIBinding {

    public LongUIBinding(Field field) {
        super(new JFXTextField(), field);
    }

    @Override
    public void viewtoModel(Document model) {
        final String s = ((JFXTextField) node).getText();

        if (s == null || s.trim().isEmpty()) {
            model.setObject(field.getName(), null);
        } else {
            model.setLong(field.getName(), Long.parseLong(s));
        }
    }

    @Override
    public void modelToView(Document model) {
        Number s = model.getNumber(field.getName());
        ((JFXTextField) node).setText(s == null ? "" : String.valueOf(s.longValue()));
    }

}
