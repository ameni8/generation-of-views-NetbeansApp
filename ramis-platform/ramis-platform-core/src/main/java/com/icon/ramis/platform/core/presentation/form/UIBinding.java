/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icon.ramis.platform.core.presentation.form;

import javafx.scene.Node;
import javafx.scene.control.Label;
import net.vpc.upa.Document;

/**
 *
 * @author ameni
 */
interface UIBinding {

    public void viewtoModel(Document value);

    public void modelToView(Document document);

    public Node getComponent();

    public Label getLabel();

}
