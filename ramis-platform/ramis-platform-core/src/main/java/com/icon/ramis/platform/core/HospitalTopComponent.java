/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icon.ramis.platform.core;

import com.icon.ramis.platform.core.presentation.form.JFXAppForm;
import java.awt.BorderLayout;
import javafx.application.Platform;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.Exceptions;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//com.icon.ramis.platform.core//Hospital//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "HospitalTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "explorer", openAtStartup = false)
@ActionID(category = "Window", id = "com.icon.ramis.platform.core.HospitalTopComponent")
@ActionReference(path = "Menu/New" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_HospitalAction",
        preferredID = "HospitalTopComponent"
)
@Messages({
    "CTL_HospitalAction=Hospital",
    "CTL_HospitalTopComponent=Hospital Window",
    "HINT_HospitalTopComponent=This is a Hospital window"
})
public final class HospitalTopComponent extends TopComponent {
    private JFXAppForm fp;
    public HospitalTopComponent() {
        initComponents();
        setName(Bundle.CTL_HospitalTopComponent());
        setToolTipText(Bundle.HINT_HospitalTopComponent());
        setLayout(new BorderLayout());
        
    }

    private void createScene() {
        try {
            fp.configureFX();

        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
       if (fp == null) {
            fp = new JFXAppForm(com.icon.ramis.platform.core.model.Hospital.class);
            add(fp, BorderLayout.CENTER);
         Platform.runLater(() -> createScene());
    }
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }
}
