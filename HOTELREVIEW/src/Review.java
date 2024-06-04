import java.util.Date;

public class Review {
    private String username;
    private int rating;
    private String comment;
    private Date date;

    public Review(String username, int rating, String comment, Date date) {
        this.username = username;
        this.rating = rating;
        this.comment = comment;
        this.date = date != null ? date : new Date();
    }

    public String getUsername() {
        return username;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Review{" +
                "username='" + username + '\'' +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                '}';
    }
}
