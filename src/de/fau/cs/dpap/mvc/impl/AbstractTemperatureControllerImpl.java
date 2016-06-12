package de.fau.cs.dpap.mvc.impl;

import de.fau.cs.dpap.mvc.Controller;
import de.fau.cs.dpap.mvc.Model;
import de.fau.cs.dpap.mvc.View;

public abstract class AbstractTemperatureControllerImpl implements Controller {
    private Model model;
    private View view;

    @Override
    public void initialize(Model model, View view) {
        this.model = model;
        this.view = view;

        model.attach(this);
    }

    @Override
    public void update() {
        // Nothing to do
    }

    /**
     * Return the associated model
     *
     * @return Associated model
     */
    protected Model getModel() {
        return model;
    }

    /**
     * Return the associated view
     *
     * @return Associated view
     */
    protected View getView() {
        return view;
    }
}
