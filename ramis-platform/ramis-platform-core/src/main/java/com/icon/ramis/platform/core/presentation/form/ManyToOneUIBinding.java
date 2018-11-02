/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icon.ramis.platform.core.presentation.form;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import net.vpc.upa.Document;
import net.vpc.upa.Entity;
import net.vpc.upa.Field;
import net.vpc.upa.UPA;
import net.vpc.upa.types.ManyToOneType;

/**
 *
 * @author ameni
 */
public class ManyToOneUIBinding extends AbstractUIBinding {

    public ManyToOneUIBinding(Field field) {
        super(createComponent(field), field);

    }

    private static ChoiceBox createComponent(Field f) {
        ObservableList list = FXCollections.observableArrayList();
        ManyToOneType m = (ManyToOneType) f.getDataType();
        Entity en = UPA.getPersistenceUnit().getEntity(m.getTargetEntityName());
        list.addAll(en.findAll());
        return new ChoiceBox<>(list);
    }

    @Override
    public void viewtoModel(Document model) {
        ChoiceBox uiComponent = (ChoiceBox) getComponent();
        Object s = uiComponent.getSelectionModel().getSelectedItem();
        if (s == null) {
            model.setObject(field.getName(), null);
        } else {
            model.setObject(field.getName(), s);
        }
    }

    @Override
    public void modelToView(Document model) {
        ChoiceBox uiComponent = (ChoiceBox) getComponent();
        Object s = model.getObject(field.getName());
        uiComponent.getSelectionModel().select(s);
    }

}
