package Artie.Projects;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.YouTubeRequestInitializer;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

public class YouTubeAPITest {
    public static void main(String[] args) throws IOException {
        String apiKey = "API KEY"; // Replace with your actual API key

        // Initialize YouTube service using YouTubeRequestInitializer
        YouTube youtube = new YouTube.Builder(
                new NetHttpTransport(),
                new JacksonFactory(),
                httpRequest -> {})
                .setYouTubeRequestInitializer(new YouTubeRequestInitializer(apiKey))
                .build();

        YouTube.Videos.List request = youtube.videos().list(Collections.singletonList("snippet")).setId(Collections.singletonList("Hec59WAbXQk"));
        Video video = request.execute().getItems().get(0);

        System.out.println("Title: "+ video.getSnippet().getTitle());
        System.out.println("Description: "+ video.getSnippet().getDescription());

        // Use the 'youtube' object to make API requests
        // For example, search for videos, fetch video details, etc.
    }
}
