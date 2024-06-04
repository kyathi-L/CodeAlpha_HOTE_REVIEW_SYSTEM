import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Hotel {
    private String name;
    private List<Review> reviews;

    public Hotel(String name) {
        this.name = name;
        this.reviews = new ArrayList<>();
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void sortReviewsByDate(boolean descending) {
        reviews.sort(Comparator.comparing(Review::getDate));
        if (descending) {
            Collections.reverse(reviews);
        }
    }

    public void sortReviewsByRating(boolean descending) {
        reviews.sort(Comparator.comparingInt(Review::getRating));
        if (descending) {
            Collections.reverse(reviews);
        }
    }

    public List<Review> filterReviewsByRating(int minRating, int maxRating) {
        return reviews.stream()
                .filter(review -> review.getRating() >= minRating && review.getRating() <= maxRating)
                .collect(Collectors.toList());
    }

    public void displayReviews(String sortedBy, boolean descending, Integer minRating, Integer maxRating) {
        if (sortedBy != null) {
            if (sortedBy.equals("date")) {
                sortReviewsByDate(descending);
            } else if (sortedBy.equals("rating")) {
                sortReviewsByRating(descending);
            }
        }

        List<Review> reviewsToDisplay = reviews;

        if (minRating != null || maxRating != null) {
            int min = minRating != null ? minRating : Integer.MIN_VALUE;
            int max = maxRating != null ? maxRating : Integer.MAX_VALUE;
            reviewsToDisplay = filterReviewsByRating(min, max);
        }

        for (Review review : reviewsToDisplay) {
            System.out.println(review);
        }
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", reviews=" + reviews +
                '}';
    }
}
