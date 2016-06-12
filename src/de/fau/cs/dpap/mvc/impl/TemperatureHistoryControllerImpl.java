package de.fau.cs.dpap.mvc.impl;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class TemperatureHistoryControllerImpl extends AbstractTemperatureControllerImpl {
    @Override
    public void handleEvent(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "Button clicked");
    }
}
