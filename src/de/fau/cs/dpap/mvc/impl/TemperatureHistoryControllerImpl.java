package de.fau.cs.dpap.mvc.impl;

import de.fau.cs.dpap.mvc.Controller;
import de.fau.cs.dpap.mvc.Model;
import de.fau.cs.dpap.mvc.View;

import javax.swing.*;

public class TemperatureHistoryControllerImpl implements Controller {
    private Model model;
    private View view;

    @Override
    public void initialize(Model model, View view) {
        this.model = model;
        this.view = view;

        view.onButtonClick(e -> handleClickEvent());
        model.attach(this);
    }

    @Override
    public void handleClickEvent() {
        JOptionPane.showMessageDialog(null, "Button clicked");
    }

    @Override
    public void update() {
        // Nothing to do
    }
}
