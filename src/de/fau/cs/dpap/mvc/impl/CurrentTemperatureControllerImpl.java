package de.fau.cs.dpap.mvc.impl;

import java.awt.event.ActionEvent;

public class CurrentTemperatureControllerImpl extends AbstractTemperatureControllerImpl {
    @Override
    public void handleEvent(ActionEvent event) {
        getModel().measureTemperature();
    }
}
