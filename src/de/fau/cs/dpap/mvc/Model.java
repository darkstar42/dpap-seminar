package de.fau.cs.dpap.mvc;

import de.fau.cs.dpap.Temperature;

import java.util.List;

public interface Model {

    /**
     * Measure the current temperature
     */
    void measureTemperature();

    /**
     * Return the current temperature
     *
     * @return Current temperature
     */
    Temperature getCurrentTemperature();

    /**
     * Return the collected temperature history
     *
     * @return Temperature history
     */
    List<Temperature> getTemperatureHistory();

    void attach(ModelObserver observer);

    void detach(ModelObserver observer);

    void notifyObservers();
}
