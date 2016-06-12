package de.fau.cs.dpap.mvc;

import java.awt.event.ActionListener;

public interface View extends ModelObserver {
    void initialize(Model model, Controller controller);

    void onButtonClick(ActionListener listener);
}
