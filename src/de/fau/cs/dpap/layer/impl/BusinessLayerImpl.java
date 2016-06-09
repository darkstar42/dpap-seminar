package de.fau.cs.dpap.layer.impl;

import de.fau.cs.dpap.layer.BusinessLayer;
import de.fau.cs.dpap.layer.DataLayer;
import de.fau.cs.dpap.layer.Temperature;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * General business layer implementation
 */
public class BusinessLayerImpl implements BusinessLayer {
    private final DataLayer dataLayer;

    public BusinessLayerImpl(DataLayer dataLayer) {
        this.dataLayer = dataLayer;
    }

    @Override
    public Temperature measureTemperature() {
        double currentTemperature = readTemperature();
        Date currentDate = new Date();

        Temperature temperature = new Temperature(currentDate, currentTemperature);
        saveTemperature(temperature);

        return temperature;
    }

    @Override
    public Temperature loadTemperature(Date timestamp) {
        String key = "" + timestamp.getTime() / 1000;
        String data = dataLayer.load(key);
        Double temperature = new Double(data);

        return new Temperature(timestamp, temperature);
    }

    @Override
    public List<Temperature> getTemperatureHistory() {
        List<String> keys = dataLayer.list();
        List<Temperature> temperatures = new ArrayList<>();

        java.util.Collections.sort(keys);

        for (String key : keys) {
            Date timestamp = new Date(new Long(key) * 1000);
            Temperature temperature = loadTemperature(timestamp);

            temperatures.add(temperature);
        }

        return temperatures;
    }

    /**
     * Read the current temperature value
     *
     * @return Current temperature
     */
    private double readTemperature() {
        return ThreadLocalRandom.current().nextDouble(0.0, 30.0);
    }

    /**
     * Persist the given temperature
     *
     * @param temperature Temperature to save
     */
    private void saveTemperature(Temperature temperature) {
        String key = "" + temperature.getTimestamp().getTime() / 1000;
        String data = "" + temperature.getValue();

        dataLayer.store(key, data);
    }
}
