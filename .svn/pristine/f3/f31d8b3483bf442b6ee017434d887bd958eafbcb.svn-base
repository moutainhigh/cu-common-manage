package com.aotain.cu.auth;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Demo class
 *
 * @author bang
 * @date 2018/11/20
 */
public class DefaultRibbonFilterContext implements RibbonFilterContext{
    private final Map<String, String> attributes = new HashMap<String, String>();

    @Override
    public RibbonFilterContext add(String key, String value) {
        attributes.put(key, value);
        return this;
    }

    @Override
    public String get(String key) {
        return attributes.get(key);
    }

    @Override
    public RibbonFilterContext remove(String key) {
        attributes.remove(key);
        return this;
    }

    @Override
    public Map<String, String> getAttributes() {
        return Collections.unmodifiableMap(attributes);
    }
}
