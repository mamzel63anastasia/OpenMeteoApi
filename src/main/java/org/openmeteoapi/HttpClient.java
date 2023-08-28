package org.openmeteoapi;

import org.openmeteoapi.model.HttpClientResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public class HttpClient {


    public HttpClientResponse get(String urlStr, Map<String, String> headers) {
        HttpClientResponse response = new HttpClientResponse();
        try {
            URI uri = new URI(urlStr);

            HttpURLConnection con = (HttpURLConnection) uri.toURL().openConnection();
            con.setRequestMethod("GET");

            for (Map.Entry<String, String> header : headers.entrySet()){
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            con.setRequestProperty("Accept-Encoding", "gzip, deflate, br");

            response.setStatus(con.getResponseCode());

            if (con.getResponseCode() == 200) {
                response.setResponse(buildResponse(con));
            }
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }

        return response;
    }

    public HttpClientResponse get(String urlStr){
        return get(urlStr, new HashMap<>());
    }

    private String buildResponse(HttpURLConnection con) {
        try (final BufferedReader in = new BufferedReader(new InputStreamReader(new GZIPInputStream(con.getInputStream())))) {
            String inputLine;
            final StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            return content.toString();
        } catch (final Exception ex) {
            ex.printStackTrace();
        }

        return "";
    }
}
