package de.fau.cs.dpap;

import de.fau.cs.dpap.layer.BusinessLayer;
import de.fau.cs.dpap.layer.DataLayer;
import de.fau.cs.dpap.layer.PresentationLayer;
import de.fau.cs.dpap.layer.impl.BusinessLayerImpl;
import de.fau.cs.dpap.layer.impl.TempDataLayerImpl;
import de.fau.cs.dpap.mvc.Controller;
import de.fau.cs.dpap.mvc.Model;
import de.fau.cs.dpap.mvc.View;
import de.fau.cs.dpap.mvc.impl.*;

public class MVCApplication {
    public static void main(String[] args) {
        DataLayer dataLayer = new TempDataLayerImpl();
        BusinessLayer businessLayer = new BusinessLayerImpl(dataLayer);
        PresentationLayer presentationLayer = new SwingPresentationLayerImpl(businessLayer);

        presentationLayer.display();
    }
}
