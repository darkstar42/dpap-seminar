package de.fau.cs.dpap.mvc.impl;

import de.fau.cs.dpap.mvc.Controller;
import de.fau.cs.dpap.mvc.Model;
import de.fau.cs.dpap.mvc.View;

import javax.swing.*;

public class CurrentTemperatureViewImpl extends AbstractTemperatureViewImpl {
    private JTextField field;
    private JButton button;

    public CurrentTemperatureViewImpl() {
        initializeWindow();
    }

    @Override
    public void initialize(Model model, Controller controller) {
        super.initialize(model, controller);

        registerEventHandler(button, controller);
    }

    @Override
    public void update() {
        String output = String.format("%.2f °C", getModel().getCurrentTemperature().getValue());
        field.setText(output);
    }

    private void initializeWindow() {
        this.getContentPane().setLayout(null);

        field = new JTextField();
        button = new JButton("Fetch");

        field.setBounds(5, 10, 400, 25);
        button.setBounds(300, 110, 100, 30);

        getContentPane().add(field);
        getContentPane().add(button);

        pack();

        setBounds(10, 10, 420, 180);
        setVisible(true);
    }
}
