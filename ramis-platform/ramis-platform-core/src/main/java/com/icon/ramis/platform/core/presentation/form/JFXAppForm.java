/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icon.ramis.platform.core.presentation.form;

import com.icon.ramis.platform.core.model.City;
import com.jfoenix.controls.JFXTextField;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javax.swing.JButton;
import net.vpc.upa.AccessLevel;
import net.vpc.upa.AccessMode;
import net.vpc.upa.Document;
import net.vpc.upa.Entity;
import net.vpc.upa.EntityItem;
import net.vpc.upa.Section;
import net.vpc.upa.Field;
import net.vpc.upa.FieldDescriptor;
import net.vpc.upa.UPA;
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
public class JFXAppForm extends JFXPanel {

    private Entity entity;
    private NodeInfo nodeInfo;
    private List<UIBinding> bindings = new ArrayList<UIBinding>();
    private Model model;

    public JFXAppForm(Class clazz) {
        this(UPA.getPersistenceUnit().getEntity(clazz));
    }

    public JFXAppForm(Entity entity) {
        this.entity = entity;
        
    
        //System.out.println("scene added for " + entity);
    }

    public void configureFX() {
        nodeInfo = createNodeInfo(entity);

        setScene(new Scene((Parent) nodeInfo.node, 400, 400));
//        setScene(new Scene(new Button("Test"), 400, 400));
    }

    public void save() {
        entity.save(getValue());
    }
public void add(){
entity.addField((FieldDescriptor) getValue());
}
    public void delete() {
        final Object o = getValue();
        entity.remove(o);
    }

    public void reload() {
        final Object o = getValue();
        Object id = entity.getBuilder().objectToId(o);
        final Object n = entity.findById(id);
        setValue(n);
    }
    
    

    public void setValue(Object value) {
        Document doc = entity.getBuilder().objectToDocument(value);
        for (UIBinding binding : bindings) {
            binding.modelToView(doc);
        }
    }

    public Object getValue() {
        Document doc = entity.getBuilder().createDocument();
        for (UIBinding binding : bindings) {
            binding.viewtoModel(doc);
        }
        //return entity.getBuilder().documentToObject(doc);

        return doc;

    }

    private NodeInfo createNodeInfo(Entity entity) {

        GridPane p = new GridPane();
        //p.setHgap(10);
        p.setVgap(10);
        p.setPadding(new Insets(50, 50, 50, 50));
        p.setStyle("-fx-background-color: ;  -fx-background-radius: 15.0;  -fx-background-insets: 5.0 5.0 5.0 5.0;-fx-padding: 10; -fx-hgap: 10;-fx-vgap: 10;");
        Button DeleteBtn = new Button("Delete");
        Button SaveBtn = new Button("save");
        
        int currentRowIndex = 0;
        for (EntityItem part : entity.getItems()) {
            if (part instanceof Section) {
                NodeInfo n = createNodeInfo((Section) part);
                if (n.rows > 0) {
                    p.add(n.node, 0, currentRowIndex, Math.max(2, n.cols), n.rows);
                }
            } else if (part instanceof Field) {
                Field f = (Field) part;
                final UIBinding b = UIBindingFactory.getInstance().createFieldBinding(f);
                if (b != null) {
                    p.add(b.getLabel(), 0, currentRowIndex);
                    p.add(b.getComponent(), 1, currentRowIndex);
                    currentRowIndex++;
                    bindings.add(b);
                }
            } else {
                throw new IllegalArgumentException("Never");
            }
        }
        p.add(SaveBtn, 3, currentRowIndex+1);
        p.add(DeleteBtn, 2, currentRowIndex+1);
        SaveBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Field f = (Field) entity.getField("name");
                
                Object o=new Object();
                System.out.println(f.getValue(o).toString());
                //add();

            }
        });
        return new NodeInfo(p, currentRowIndex, 2);
    }

    public NodeInfo createNodeInfo(Section entity) {

        GridPane p = new GridPane();

        int currentRowIndex = 0;
        for (EntityItem part : entity.getItems()) {

            if (part instanceof Section) {

            } else if (part instanceof Field) {

                Label label = new Label(part.getTitle());
                System.out.println("fff :"+label);

                Field f = (Field) part;
                if (f.isSystem()) {
                    continue;
                }
                if (f.getDataType() instanceof StringType) {
                    JFXTextField cf = new JFXTextField();
                    p.add(label, 0, currentRowIndex);
                    p.add(cf, 1, currentRowIndex);
                    currentRowIndex++;
                } else if (f.getDataType() instanceof NumberType) {
                    JFXTextField cf = new JFXTextField();
                    p.add(label, 0, currentRowIndex);
                    p.add(cf, 1, currentRowIndex);
                    currentRowIndex++;
                } else {
                    throw new IllegalArgumentException("Next time i will do this...");
                }
            } else {
                throw new IllegalArgumentException("Never");
            }
        }

        return new NodeInfo(p, currentRowIndex, 2);

    }
    
    
    
    private class Model{
        City city;

        public City getCity() {
            return city;
        }

        public void setCity(City city) {
            this.city = city;
        }
        
    }

}
