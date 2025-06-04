package com.ads.helpers;

import com.google.auth.oauth2.GoogleCredentials;
import java.io.FileInputStream;
import java.io.IOException;

public class GoogleAuthHelper {

    public static String getAccessToken() throws IOException {
        FileInputStream serviceAccountStream = new FileInputStream("functions/serviceAccountKey.json");

        GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccountStream)
                .createScoped("https://www.googleapis.com/auth/firebase.messaging");

        credentials.refreshIfExpired();

        return credentials.getAccessToken().getTokenValue();
    }
}
