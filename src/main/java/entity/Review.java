package entity;


import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "review_text")
    private String reviewText;


    public static class ReviewBuilder {

        private String reviewText;

        public ReviewBuilder setReviewText(String reviewText) {
            this.reviewText = reviewText;
            return this;
        }

        public Review build() {
            return new Review(reviewText);
        }
    }


    public Review(String reviewText) {
        this.reviewText = reviewText;
    }

    public Review() {
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", reviewText='" + reviewText + '\'' +
                '}';
    }
}
