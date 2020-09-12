package entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "course_v5")
public class CourseV5 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_v5_id")
    private List<Review> review;

    public static class CourseV5Builder {

        private String title;
        private List<Review> review;

        public CourseV5Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public CourseV5Builder setReview(List<Review> review) {
            this.review = review;
            return this;
        }

        public CourseV5 build() {
            return new CourseV5(title, review);
        }


    }


    public CourseV5(String title, List<Review> review) {
        this.title = title;
        this.review = review;
    }

    public CourseV5() {
    }

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
