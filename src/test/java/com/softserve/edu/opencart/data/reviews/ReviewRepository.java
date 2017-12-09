package com.softserve.edu.opencart.data.reviews;

/**
 * Created by Serhiienko.
 */
public class ReviewRepository {

    private static volatile ReviewRepository instance = null;

    private ReviewRepository() {
    }

    public static ReviewRepository get() {
        if (instance == null) {
            synchronized (ReviewRepository.class) {
                if (instance == null) {
                    instance = new ReviewRepository();
                }
            }
        }
        return instance;
    }

    public IReview validNameValidTextWithRating() {
        return Review.get()
                .setCriterion("validNameValidTextWithRating")
                .setName("Name")
                .setText("Input valid review there.")
                .setRating(0)
                .build();
    }

    public IReview notValidShortNameValidTextWithRating() {
        return Review.get()
                .setCriterion("notValidShortNameValidTextWithRating")
                .setName("Na")
                .setText("Input valid review there.")
                .setRating(3)
                .build();

    }

    public IReview validShortNameValidTextWithRating() {
        return Review.get()
                .setCriterion("validShortNameValidTextWithRating")
                .setName("Nam")
                .setText("Input valid review there.")
                .setRating(2)
                .build();
    }

    public IReview notValidLongNameValidTextWithRating() {
        return Review.get()
                .setCriterion("notValidLongNameValidTextWithRating")
                .setName("26 symbols for nameField 2")
                .setText("Input valid review there.")
                .setRating(1)
                .build();
    }

    public IReview validLongNameValidTextWithRating() {
        return Review.get()
                .setCriterion("validLongNameValidTextWithRating")
                .setName("25 symbols for name field")
                .setText("Input valid review there.")
                .setRating(3)
                .build();
    }

    public IReview validNameNotValidShortTextWithRating() {
        return Review.get()
                .setCriterion("validNameNotValidShortTextWithRating")
                .setName("Name")
                .setText("Input is notValid review")
                .setRating(4)
                .build();
    }

    public IReview validNameValidShortTextWithRating() {
        return Review.get()
                .setCriterion("validNameValidShortTextWithRating")
                .setName("Name")
                .setText("Input there valid review.")
                .setRating(4)
                .build();
    }

    public IReview validNameNotValidLongTextWithRating() {
        return Review.get()
                .setCriterion("validNameNotValidLongTextWithRating")
                .setName("Name")
                .setText(type1000()+"1")
                .setRating(0)
                .build();
    }

    public IReview validNameValidLongTextWithRating() {
        return Review.get()
                .setCriterion("validNameValidLongTextWithRating")
                .setName("Name")
                .setText(type1000())
                .setRating(3)
                .build();
    }

    private String type1000() {
        String string = "";
        for (int i = 0; i < 10; i++) {
            string += "Input there valid Review in length 1000 symbols gddhgd fgdfgkdjfgdfj dfkghdfjghdfj dfgdfjghd dfjgdfs";
        }
        return string;
    }

    public IReview onlySpecialCharactersForNameValidTextWithRating() {
        return Review.get()
                .setCriterion("onlySpecialCharactersForNameValidTextWithRating")
                .setName("%&@-")
                .setText("Input valid review there.")
                .setRating(2)
                .build();
    }

    public IReview validNameOnlySpecialCharactersForTextWithRating() {
        return Review.get()
                .setCriterion("validNameOnlySpecialCharactersForTextWithRating")
                .setName("Name")
                .setText("+-*/+-*/[]{}()??//.,:^%$#")
                .setRating(2)
                .build();
    }

    public IReview onlySpaceForNameValidTextWithRating() {
        return Review.get()
                .setCriterion("onlySpaceForNameValidTextWithRating")
                .setName("    ")
                .setText("Input valid review there.")
                .setRating(2)
                .build();
    }

    public IReview validNameOnlySpaceForTextWithRating() {
        return Review.get()
                .setCriterion("validNameOnlySpaceForTextWithRating")
                .setName("Name")
                .setText("                         ")
                .setRating(1)
                .build();
    }

}
