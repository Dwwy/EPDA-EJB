package com.example.demo1.Util;

import com.example.demo1.parameter.UploadParameters;
import com.example.demo1.response.OptionalResponse;
import org.apache.commons.io.IOUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

public class ImgUp_Down {

    private static final String API_KEY = "ed11f5336082ae2f2e92f900f7e6af49";

    public static OptionalResponse uploadImage(InputStream file ) throws IOException{
        String url = "https://api.imgbb.com/1/upload";
        UploadParameters.Builder builder = new UploadParameters.Builder();
        builder.apiKey(API_KEY);
        builder.imageBase64(Base64.getEncoder().encodeToString((IOUtils.toByteArray(file))));
        UploadParameters parameters = builder.build();
        try {
            HostnameVerifier allHostsValid = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
            Connection.Response response = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .ignoreHttpErrors(true)
                    .method(Connection.Method.POST)
                    .data(parameters.toMap())
                    .execute();
            return OptionalResponse.of(response);
        } catch (IOException ex) {
            throw new RuntimeException("I/O exception was catched while try to upload image!", ex);
        }
    }
}
