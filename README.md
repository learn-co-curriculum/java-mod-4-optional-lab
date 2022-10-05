# Optional Lab

## Instruction

The `Book` class uses a `HashMap` to map a book's title to an author name. The title is the key and the author name is the value.

Recall that `HashMap.get()` returns `null` if the key is not found.

The `getAuthor()` method takes a book title as parameter,
and gets the corresponding author name from the map:

- The return type is `Optional<String>` since `HashMap.get()` might return `null`.
- The method returns a value using `Optional.ofNullable` since `HashMap.get()` might return `null`.

```java
public class Book {
    private static final Map<String, String> books = new HashMap<>();

    static {
        books.put("Effective Java", "Joshua Bloch");
        books.put("Designing Data-Intensive Applications", "Martin Kleppmann");
        books.put("Modern Java in Action", "Raoul-Gabriel Urma");
    }

    public static Optional<String> getAuthor( String title ) {
        return Optional.ofNullable( books.get(title) );
    }
}
```

### TASK #1:

`Task1.java` prompts for and reads in a book title, then calls `Book.getAuthor()` to retrieve the
author name based on the title.  

```java
import java.util.Optional;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book title:");
        String title = scanner.nextLine();

        Optional<String> optAuthor = Book.getAuthor(title);

        //print the book title and author name

    }
}
```

Edit the `main` method to print the book title and author name after reading in the title.

- If the user enters the title "Effective Java", the output should be `Effective Java written by Joshua Bloch`.
- Keep in mind the string representing the author name is contained in the `Optional` object returned from the `Book.getAuthor()` method.
  - HINT: Use the `get()` method to retrieve the value from the optional object.
- Test your program with at least two different titles found in the hashmap:

```text
Enter book title:Effective Java
Effective Java written by Joshua Bloch
```

```text
Enter book title:Modern Java in Action
Modern Java in Action written by Raoul-Gabriel Urma
```

Run the program again and type in a title that does not match
a key in the hashmap such as "Head First Java".
The program throws an exception because the optional object has no value to get.
You will fix this issue in the next task.

```text
Exception in thread "main" java.util.NoSuchElementException: No value present
```

### TASK #2

Update `Task2.java` to use a conditional statement (i.e. if else) to test whether
a value representing the author name exists.

- Use the `isPresent()` method from the `Optional` class to test for a value.
- Print the book title and author name if the value exists, otherwise print the book title and "unknown".

Test your code with a title found in the hashmap:

```text
Book title:Effective Java
"Effective Java written by Joshua Bloch"
```

Test your code with a title not in the hashmap:

```text
Enter book title:Head First Java
Head First Java unknown
```

### TASK #3

Edit `Task3.java` to implement the same functionality as `Task2.java`, but replace
the conditional statement with a call to `ifPresentOrElse()`.

- Do not use a conditional statement.
- Call the `ifPresentOrElse` method to decide what to print.
- The parameter passed into the first lambda is the actual value, not the optional object.
- The second lambda does not take a parameter when there is no value.

Test your code with a title found in the hashmap:

```text
Book title:Effective Java
"Effective Java written by Joshua Bloch"
```

Test your code with a title not in the hashmap:

```text
Enter book title:Head First Java
Head First Java unknown
```
