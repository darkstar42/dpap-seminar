package de.fau.cs.dpap.mvc;

public interface View extends ModelObserver {
    void initialize(Model model, Controller controller);
}
