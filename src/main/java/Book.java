import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Book {
    private static final Map<String, String> books = new HashMap<>();

    static {
        books.put("Effective Java", "Joshua Bloch");
        books.put("Designing Data-Intensive Applications", "Martin Kleppmann");
        books.put("Modern Java in Action", "Raoul-Gabriel Urma");
    }
    
    public static Optional<String> getAuthor(String title) {
        return Optional.ofNullable(books.get(title));
    }
}