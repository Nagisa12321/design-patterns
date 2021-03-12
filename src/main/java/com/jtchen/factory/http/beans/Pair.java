package com.jtchen.factory.http.beans;

import org.apache.http.NameValuePair;

public class Pair implements NameValuePair {

    private final String name;
    private final String val;

    public Pair(String name, String val) {
        this.name = name;
        this.val = val;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getValue() {
        return val;
    }
}
