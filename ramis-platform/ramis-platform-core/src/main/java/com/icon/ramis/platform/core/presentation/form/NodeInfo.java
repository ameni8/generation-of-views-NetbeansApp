/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icon.ramis.platform.core.presentation.form;

import javafx.scene.Node;

/**
 *
 * @author ameni
 */
class NodeInfo {
    
    Node node;
    int rows;
    int cols;

    public NodeInfo(Node node, int rows, int cols) {
        this.node = node;
        this.rows = rows;
        this.cols = cols;
    }
    
}
