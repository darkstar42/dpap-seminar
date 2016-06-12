package de.fau.cs.dpap.mvc.impl;

import de.fau.cs.dpap.Temperature;
import de.fau.cs.dpap.mvc.Controller;
import de.fau.cs.dpap.mvc.Model;

import javax.swing.*;
import java.util.List;

public class TemperatureHistoryViewImpl extends AbstractTemperatureViewImpl {
    private JTextField field;
    private JButton button;

    public TemperatureHistoryViewImpl() {
        initializeWindow();
    }

    @Override
    public void initialize(Model model, Controller controller) {
        super.initialize(model, controller);

        registerEventHandler(button, controller);
    }

    @Override
    public void update() {
        List<Temperature> temperatures = getModel().getTemperatureHistory();
        String output = "";

        for (Temperature temperature : temperatures) {
            output += String.format(" | %.2f °C", temperature.getValue());
        }

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
