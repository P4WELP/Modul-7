package JSONPlaceholderFetcher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class JSONMapper {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Post mapToJava(String json) throws IOException {
        return objectMapper.readValue(json, Post.class);
    }
    public static List<Post> mapToJavaList(String json) throws IOException {
        return objectMapper.readValue(json, new TypeReference<List<Post>>() {});
    }
    public static String mapToJSON(Post post) throws JsonProcessingException {
        return objectMapper.writeValueAsString(post);
    }
}
