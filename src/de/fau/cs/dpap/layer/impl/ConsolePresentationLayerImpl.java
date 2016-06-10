package de.fau.cs.dpap.layer.impl;

import de.fau.cs.dpap.layer.BusinessLayer;
import de.fau.cs.dpap.layer.PresentationLayer;
import de.fau.cs.dpap.Temperature;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Console presentation layer implementation
 */
public class ConsolePresentationLayerImpl implements PresentationLayer {

    private final SimpleDateFormat dateFormat;
    private final BusinessLayer businessLayer;

    public ConsolePresentationLayerImpl(BusinessLayer businessLayer) {
        this.businessLayer = businessLayer;

        dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    }

    @Override
    public void display() {
        List<Temperature> temperatures = businessLayer.getTemperatureHistory();

        System.out.println("Temperature History");
        System.out.println("----------------------------------");

        for (Temperature temperature : temperatures) {
            String output = String.format("%-25s %.2f °C", dateFormat.format(temperature.getTimestamp()), temperature.getValue());
            System.out.println(output);
        }

        System.out.println("----------------------------------");
    }
}
