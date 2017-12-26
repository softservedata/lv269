package com.softserve.edu.opencart.data.reviews;

/**
 * Created by Serhiienko.
 */
interface ICriterion {
    IName setCriterion(String criterion);
}

interface IName {
    IText setName(String name);
}

interface IText {
    IRating setText(String text);
}

interface IRating {
    IReviewBuild setRating(Integer rating);
}

interface IReviewBuild {
    IReview build();
}

public class Review implements IReview, IRating, IName, IText, IReviewBuild, ICriterion {

    private Review() {}

    private String criterion;
    private String name;
    private String text;
    private Integer rating;

    public static ICriterion get() {
        return new Review();
    }
    //public static IName get() { return new Review();}

    public String getCriterion() {
        return criterion;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public Integer getRating() {
        return rating;
    }

    public IReview build() {
        return this;
    }

    public IName setCriterion (String criterion) {
        this.criterion = criterion;
        return this;
    }

    public IText setName(String name) {
        this.name = name;
        return this;
    }

    public IRating setText(String text) {
        this.text = text;
        return this;
    }

    public IReviewBuild setRating(Integer rating) {
        this.rating = rating;
        return this;
    }

}
