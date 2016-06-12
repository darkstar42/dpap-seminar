package de.fau.cs.dpap.mvc.impl;

import de.fau.cs.dpap.mvc.Controller;
import de.fau.cs.dpap.mvc.Model;
import de.fau.cs.dpap.mvc.View;

import javax.swing.*;
import java.awt.event.ActionListener;

public class CurrentTemperatureViewImpl extends JFrame implements View {
    private Model model;
    private Controller controller;

    private JTextField field;
    private JButton button;

    public CurrentTemperatureViewImpl() {
        initializeWindow();
    }

    @Override
    public void initialize(Model model, Controller controller) {
        this.model = model;
        this.controller = controller;

        model.attach(this);
    }

    @Override
    public void onButtonClick(ActionListener listener) {
        button.addActionListener(listener);
    }

    @Override
    public void update() {
        String output = String.format("%.2f °C", model.getCurrentTemperature().getValue());
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
