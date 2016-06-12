package de.fau.cs.dpap.mvc.impl;

import de.fau.cs.dpap.mvc.Controller;
import de.fau.cs.dpap.mvc.Model;
import de.fau.cs.dpap.mvc.View;

import javax.swing.*;

public abstract class AbstractTemperatureViewImpl extends JFrame implements View {
    private Model model;
    private Controller controller;

    @Override
    public void initialize(Model model, Controller controller) {
        this.model = model;
        this.controller = controller;

        model.attach(this);
    }

    protected static void registerEventHandler(JButton button, Controller controller) {
        button.addActionListener(controller::handleEvent);
    }

    protected Controller getController() {
        return controller;
    }

    protected Model getModel() {
        return model;
    }
}
