package Artie.Projects;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

/*"
This will initialize the HTTP transport fot making API requests
"*/
public class YouTubeAuthenticator {
    private static final String APPLICATION_NAME = "YouTubeDownloader"; // Replace with your app name

    public static HttpTransport initializeHttpTransport() {
        try {
            return GoogleNetHttpTransport.newTrustedTransport();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}