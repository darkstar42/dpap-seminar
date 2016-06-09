package de.fau.cs.dpap.layer;

import java.util.Date;

public class Temperature {
    private Date timestamp;
    private double value;

    public Temperature(Date timestamp, double value) {
        this.timestamp = timestamp;
        this.value = value;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public double getValue() {
        return value;
    }
}
