package JSONPlaceholderFetcher;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JSONPlaceholderFetcherTest {

    @Test
    public void testGetSinglePost() throws IOException, InterruptedException {

        JSONPlaceholderFetcher fetcherMock = mock(JSONPlaceholderFetcher.class);

        String expectedJson = "{\"userId\":1,\"id\":1,\"title\":\"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\"body\":\"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"}";

        when(fetcherMock.getSinglePost(1)).thenReturn(expectedJson);

        Post fetchedPost = JSONMapper.mapToJava(fetcherMock.getSinglePost(1));

        Post expectedPost = new Post();
        expectedPost.setUserId(1);
        expectedPost.setId(1);
        expectedPost.setTitle("sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
        expectedPost.setBody("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto");

        assertEquals(expectedPost.getUserId(), fetchedPost.getUserId());
        assertEquals(expectedPost.getId(), fetchedPost.getId());
        assertEquals(expectedPost.getTitle(), fetchedPost.getTitle());
        assertEquals(expectedPost.getBody(), fetchedPost.getBody());
    }

    @Test
    public void testGetAllPosts() throws IOException, InterruptedException {
        JSONPlaceholderFetcher fetcherMock = mock(JSONPlaceholderFetcher.class);

        when(fetcherMock.getAllPosts()).thenReturn(new ArrayList<Post>());

        assertEquals(0, fetcherMock.getAllPosts().size());
    }

    @Test
    public void testMapToJSON() throws IOException {
        Post post = new Post();
        post.setUserId(1);
        post.setId(1);
        post.setTitle("sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
        post.setBody("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto");

        String json = JSONMapper.mapToJSON(post);

        String expectedJson = "{\"userId\":1,\"id\":1,\"title\":\"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\"body\":\"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"}";

        assertEquals(expectedJson, json);
    }
}
