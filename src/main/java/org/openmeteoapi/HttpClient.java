package org.openmeteoapi;

import org.openmeteoapi.model.HttpClientResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpClient {
    private final String apiKey;

    public HttpClient(String apiKey) {
        this.apiKey = apiKey;
    }


    public HttpClientResponse get(String urlStr) {
        HttpClientResponse response = new HttpClientResponse();
        try {
            URI uri = new URI(urlStr);

            HttpURLConnection con = (HttpURLConnection) uri.toURL().openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Yandex-API-Key", apiKey);
            con.setRequestProperty("Connection", "Keep-Alive");
            con.setRequestProperty("User-Agent", "Apache-HttpClient/4.5.14 (Java/17.0.7)");
            con.setRequestProperty("Accept-Encoding", "br,deflate,gzip,x-gzip");
            con.setRequestProperty("Content-Type", "text/html; charset=UTF-8");
            response.setStatus(con.getResponseCode());

            if (con.getResponseCode() == 200) {
                response.setResponse(buildResponse(con));
            }
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }

        return response;
    }

    private String buildResponse(HttpURLConnection con) {
        try (final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {
            String inputLine;
            final StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();
        } catch (final Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }
}
