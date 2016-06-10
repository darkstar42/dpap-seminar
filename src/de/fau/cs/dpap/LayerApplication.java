package de.fau.cs.dpap;

import de.fau.cs.dpap.layer.BusinessLayer;
import de.fau.cs.dpap.layer.DataLayer;
import de.fau.cs.dpap.layer.PresentationLayer;
import de.fau.cs.dpap.layer.impl.BusinessLayerImpl;
import de.fau.cs.dpap.layer.impl.ConsolePresentationLayerImpl;
import de.fau.cs.dpap.layer.impl.TempDataLayerImpl;

public class LayerApplication {
    public static void main(String[] args) {
        DataLayer dataLayer = new TempDataLayerImpl();
        BusinessLayer businessLayer = new BusinessLayerImpl(dataLayer);
        PresentationLayer presentationLayer = new ConsolePresentationLayerImpl(businessLayer);

        measureTemperatures(businessLayer);
        presentationLayer.display();
    }

    private static void measureTemperatures(BusinessLayer businessLayer) {
        for (int i = 0; i < 10; i++) {
            businessLayer.measureTemperature();

            try {
                Thread.sleep(1000);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
