package com.softserve.edu.opencart.data.reviews;

/**
 * Created by Serhiienko.
 */

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

public class Review implements IReview, IRating, IName, IText, IReviewBuild {

    private Review() {}

    private String name;
    private String text;
    private Integer rating;


    public static IName get() {
        return new Review();
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
