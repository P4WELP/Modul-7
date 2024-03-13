package JSONPlaceholderFetcher;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        JSONPlaceholderFetcher fetcher = new JSONPlaceholderFetcher();

        try {
            System.out.println("Getting single post:");
            String singlePostJson = fetcher.getSinglePost(1);
            Post singlePost = JSONMapper.mapToJava(singlePostJson);
            System.out.println(singlePost);

            System.out.println("\nGetting all posts:");
            List<Post> allPosts = fetcher.getAllPosts();
            for (Post post : allPosts) {
                System.out.println(post);
            }

            System.out.println("\nAdding a new post:");
            String newPost = "{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }";
            boolean success = fetcher.addPost(newPost);
            System.out.println("Post added successfully: " + success);


            System.out.println("\nMapping post to JSON:");
            String postAsJson = JSONMapper.mapToJSON(singlePost);
            System.out.println(postAsJson);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
