package de.fau.cs.dpap.mvc.impl;

import de.fau.cs.dpap.layer.BusinessLayer;
import de.fau.cs.dpap.layer.PresentationLayer;
import de.fau.cs.dpap.mvc.Controller;
import de.fau.cs.dpap.mvc.Model;
import de.fau.cs.dpap.mvc.View;

/**
 * Swing based presentation layer implementation
 */
public class SwingPresentationLayerImpl implements PresentationLayer {
    private final BusinessLayer businessLayer;

    public SwingPresentationLayerImpl(BusinessLayer businessLayer) {
        this.businessLayer = businessLayer;
    }

    @Override
    public void display() {
        Model model = new ModelImpl(businessLayer);

        View currentView = new CurrentTemperatureViewImpl();
        Controller currentController = new CurrentTemperatureControllerImpl();

        currentView.initialize(model);
        currentController.initialize(model, currentView);

        View historyView = new TemperatureHistoryViewImpl();
        Controller historyController = new TemperatureHistoryControllerImpl();

        historyView.initialize(model);
        historyController.initialize(model, historyView);
    }
}
