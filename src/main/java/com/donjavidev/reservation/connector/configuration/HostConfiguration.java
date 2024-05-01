package com.donjavidev.reservation.connector.configuration;

import java.util.HashMap;

public class HostConfiguration {
    private String host;
    private int port;
    private HashMap<String, EndPointConfiguration> endpoints;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public HashMap<String, EndPointConfiguration> getEndpoints() {
        return endpoints;
    }

    public void setEndpoints(HashMap<String, EndPointConfiguration> endpoints) {
        this.endpoints = endpoints;
    }
}
