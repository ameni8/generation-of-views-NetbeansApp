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
public class StringUIBinding extends AbstractUIBinding {

    public StringUIBinding(Field field) {
        super(new JFXTextField(),field);
        //System.out.println(field);
    }

    @Override
    public void viewtoModel(Document model) {
        model.setString(field.getName(), ((JFXTextField)node).getText());
        System.out.println(((JFXTextField)node).getText());
    }

    @Override
    public void modelToView(Document model) {
        final String s = model.getString(field.getName());
        System.out.println("ssss: "+s);
        ((JFXTextField)node).setText(s);
    }

}
