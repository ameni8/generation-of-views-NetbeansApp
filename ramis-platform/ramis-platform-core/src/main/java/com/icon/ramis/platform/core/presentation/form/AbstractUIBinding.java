/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icon.ramis.platform.core.presentation.form;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import net.vpc.upa.AccessLevel;
import net.vpc.upa.AccessMode;
import net.vpc.upa.Field;

/**
 *
 * @author ameni
 */
public abstract class AbstractUIBinding implements UIBinding {

    protected Node node;
    protected Label label;
    protected Field field;

    public AbstractUIBinding(Node node, Field field) {
        this.node = node;
        this.field = field;
        label = new Label(field.getName());
        
        label.setTextFill(Color.web("#0076a3"));
        label.setStyle("-fx-background-color: ;-fx-padding: 8;");
        final AccessLevel effectiveAccessLevel = field.getEffectiveAccessLevel(AccessMode.PERSIST);
//        boolean visible = effectiveAccessLevel == AccessLevel.READ_ONLY || effectiveAccessLevel == AccessLevel.READ_WRITE || effectiveAccessLevel == AccessLevel.DEFAULT;
        boolean disabled = effectiveAccessLevel == AccessLevel.READ_ONLY;
        node.setDisable(disabled);
    }

    @Override
    public Node getComponent() {
        return node;
    }
    @Override
    public Label getLabel() {
        return label;
    }

}
