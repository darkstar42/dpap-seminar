package de.fau.cs.dpap.layer;

import java.util.Date;
import java.util.List;

/**
 * General business layer interface
 */
public interface BusinessLayer {
    /**
     * Measure the current temperature
     *
     * @return Current temperature
     */
    Temperature measureTemperature();

    /**
     * Load the temperature for the given date
     *
     * @param timestamp Date to return the temperature for
     * @return Temperature for the given date
     */
    Temperature loadTemperature(Date timestamp);

    /**
     * Return the collected temperature history
     *
     * @return Temperature history
     */
    List<Temperature> getTemperatureHistory();
}
