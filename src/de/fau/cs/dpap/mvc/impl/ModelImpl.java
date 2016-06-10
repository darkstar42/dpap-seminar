package de.fau.cs.dpap.mvc.impl;

import de.fau.cs.dpap.Temperature;
import de.fau.cs.dpap.layer.BusinessLayer;
import de.fau.cs.dpap.mvc.Model;
import de.fau.cs.dpap.mvc.ModelObserver;

import java.util.LinkedList;
import java.util.List;

public class ModelImpl implements Model {
    private List<ModelObserver> observers = new LinkedList<>();
    private Temperature currentTemperature;

    private BusinessLayer businessLayer;

    public ModelImpl(BusinessLayer businessLayer) {
        this.businessLayer = businessLayer;
    }

    @Override
    public void measureTemperature() {
        currentTemperature = businessLayer.measureTemperature();
        notifyObservers();
    }

    @Override
    public Temperature getCurrentTemperature() {
        return currentTemperature;
    }

    @Override
    public List<Temperature> getTemperatureHistory() {
        return businessLayer.getTemperatureHistory();
    }

    @Override
    public void attach(ModelObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(ModelObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(ModelObserver::update);
    }
}
