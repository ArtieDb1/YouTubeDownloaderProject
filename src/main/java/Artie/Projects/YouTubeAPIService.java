package Artie.Projects;
import Artie.Projects.YouTubeAuthenticator;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.VideoListResponse;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.client.json.jackson2.JacksonFactory;

import java.io.IOException;
import java.util.Collections;

public class YouTubeAPIService {
    private static final String API_KEY = "API KEY!"; // Replace with your actual API key
    private static final String APPLICATION_NAME = "ArtieYoutubeDownloader"; // Replace with your app name
    private static final HttpTransport HTTP_TRANSPORT = YouTubeAuthenticator.initializeHttpTransport();

    public static YouTube initializeYouTube() {
        assert HTTP_TRANSPORT != null;
        return new YouTube.Builder(HTTP_TRANSPORT, JacksonFactory.getDefaultInstance(), null)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public static void searchVideos(String query) {
        try {
            YouTube youtube = initializeYouTube();
            YouTube.Search.List request = youtube.search().list(Collections.singletonList("snippet"));
            request.setKey(API_KEY); // Set the API key for authentication
            request.setQ(query); // Set the search query
            SearchListResponse response = request.execute();
            // Process the search response
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Other methods for interacting with the YouTube API
}
