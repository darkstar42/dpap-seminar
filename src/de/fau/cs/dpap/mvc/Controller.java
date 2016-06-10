package de.fau.cs.dpap.mvc;

public interface Controller extends ModelObserver {
    void initialize(Model model, View view);

    void handleClickEvent();
}
