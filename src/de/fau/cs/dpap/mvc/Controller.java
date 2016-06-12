package de.fau.cs.dpap.mvc;

import java.awt.event.ActionEvent;

public interface Controller extends ModelObserver {
    void initialize(Model model, View view);

    void handleEvent(ActionEvent event);
}
