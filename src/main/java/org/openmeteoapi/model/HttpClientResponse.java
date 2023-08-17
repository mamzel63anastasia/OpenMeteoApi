package org.openmeteoapi.model;

public class HttpClientResponse {
    private int status;

    private String response;

    public HttpClientResponse() {
    }

    public HttpClientResponse(int status, String response) {
        this.status = status;
        this.response = response;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
