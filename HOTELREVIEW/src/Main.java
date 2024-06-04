import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Grand Hotel");
        Scanner scanner = new Scanner(System.in);
        String username, comment;
        int rating;

        while (true) {
            System.out.println("Enter username (or 'exit' to finish): ");
            username = scanner.nextLine();
            if (username.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.println("Enter rating (1-5): ");
            rating = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter comment: ");
            comment = scanner.nextLine();

            Review review = new Review(username, rating, comment, new Date());
            hotel.addReview(review);
        }

        // Display reviews sorted by rating
        System.out.println("Sorted by rating:");
        hotel.displayReviews("rating", true, null, null);

        // Display reviews with a minimum rating of 4
        System.out.println("\nFiltered by min rating of 4:");
        hotel.displayReviews(null, false, 4, null);

        scanner.close();
    }
}
