import java.util.Optional;
import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book title:");
        String title = scanner.nextLine();

        Optional<String> optAuthor = Book.getAuthor(title);

        //Call ifPresentOrElse() method to test for value

    }
}

