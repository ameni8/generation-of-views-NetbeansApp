/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icon.ramis.platform.core;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Window;
import javax.swing.JButton;
import net.vpc.upa.UPA;
import net.vpc.upa.UPAI18n;
import net.vpc.upa.UPAObject;
import net.vpc.upa.types.I18NString;
import org.openide.*;
import org.openide.modules.ModuleInstall;
import org.openide.util.Exceptions;
import com.icon.ramis.platform.core.FXMLDocumentController;

public class Installer extends ModuleInstall implements ActionListener {

    private DialogDescriptor d = null;
    @FXML
    public JFXTextField username;
    @FXML
    public JFXPasswordField password;
    @FXML
    private JFXButton connectbt;

    @FXML
    @Override
    public void restored() {
        Platform.setImplicitExit(false);
        final UPAI18n ii = new UPAI18n() {
            @Override
            public String get(UPAObject s, Map<String, Object> params) {
                return s.getName();
            }

            @Override
            public String get(I18NString s, Map<String, Object> params) {
                return s.toString();
            }

            @Override
            public String getEnum(Object obj) {
                return obj.toString();
            }

        };
        UPA.getPersistenceGroup().setI18n(ii);
        UPA.getPersistenceUnit();

        //final List<Ambulance> all = RamisCoreService.getInstance().findAmbulancesByCity("tunis");
        try {
            //JFXPanel fp = new JFXAppForm(com.icon.ramis.platform.core.model.Ambulance.class);
            JFXPanel fp = new JFXPanel();
            Parent root = FXMLLoader.load(Installer.class.getResource("FXMLDocument.fxml"));
            fp.setScene(new Scene(root, 400, 400));
            JButton ok = new JButton("Connect as Admin");
            ok.setOpaque(false);
            ok.setContentAreaFilled(false);
            ok.setBorderPainted(false);
            d = new DialogDescriptor(fp, "Login", true, this);
            d.setClosingOptions(new Object[]{ok});
            d.setModal(true);
            d.setOptions(new Object[]{ok});
            DialogDisplayer.getDefault().notifyLater(d);
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
        }

    }

    @FXML
    @Override
    public void actionPerformed(ActionEvent arg0) {

        if (arg0.getSource() == DialogDescriptor.OK_OPTION) {
            System.out.println("5raa");

            d.setClosingOptions(null);
        }

//        Window owner = username.getScene().getWindow();
//        System.out.println("bbbbz");
//
//        if (!nameField.getText().isEmpty()) {
//            System.out.println("ba333");
//
//        }
//        if (arg0.getSource() == DialogDescriptor.OK_OPTION) {
////if((controller.nameField.equals("admin"))&&(controller.passwordField.equals("admin"))){
//            
//            d.setClosingOptions(null);
//        }
//
//    }//else if (arg0.getSource() == DialogDescriptor.CANCEL_OPTION) {
//    //        LifecycleManager.getDefault().exit();
//    //}
    }

}
