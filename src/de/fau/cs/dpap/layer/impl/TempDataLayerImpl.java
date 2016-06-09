package de.fau.cs.dpap.layer.impl;

import de.fau.cs.dpap.layer.DataLayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * In-memory data layer implementation
 */
public class TempDataLayerImpl implements DataLayer {
    private final HashMap<String, String> dataStore;

    public TempDataLayerImpl() {
        dataStore = new HashMap<>();
    }

    @Override
    public boolean store(String key, String data) {
        dataStore.put(key, data);

        return true;
    }

    @Override
    public String load(String key) {
        return dataStore.get(key);
    }

    @Override
    public List<String> list() {
        List<String> keyList = new ArrayList<>();
        keyList.addAll(dataStore.keySet());

        return keyList;
    }
}
