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
        return Review.get().setName("Name")
                .setText("Input valid review there.")
                .setRating(2)
                .build();
    }

    public IReview notValidShortNameValidTextWithRating() {
        return Review.get().setName("Na")
                .setText("Input valid review there.")
                .setRating(3)
                .build();

    }

    public IReview validShortNameValidTextWithRating() {
        return Review.get().setName("Nam")
                .setText("Input valid review there.")
                .setRating(2)
                .build();
    }

    public IReview notValidLongNameValidTextWithRating() {
        return Review.get().setName("26 symbols for nameField 2")
                .setText("Input valid review there.")
                .setRating(1)
                .build();
    }

    public IReview validLongNameValidTextWithRating() {
        return Review.get().setName("25 symbols for name field")
                .setText("Input valid review there.")
                .setRating(3)
                .build();
    }

    public IReview validNameNotValidShortTextWithRating() {
        return Review.get().setName("Name")
                .setText("Input is notValid review")
                .setRating(5)
                .build();
    }

    public IReview validNameValidShortTextWithRating() {
        return Review.get().setName("Name")
                .setText("Input there valid review.")
                .setRating(4)
                .build();
    }

    public IReview validNameNotValidLongTextWithRating() {
        return Review.get().setName("Name")
                .setText(type1000()+"1")
                .setRating(2)
                .build();
    }

    public IReview validNameValidLongTextWithRating() {
        return Review.get().setName("Name")
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
        return Review.get().setName("%&@-")
                .setText("Input valid review there.")
                .setRating(2)
                .build();
    }

    public IReview validNameOnlySpecialCharactersForTextWithRating() {
        return Review.get().setName("Name")
                .setText("+-*/+-*/[]{}()??//.,:^%$#")
                .setRating(2)
                .build();
    }

    public IReview onlySpaceForNameValidTextWithRating() {
        return Review.get().setName("    ")
                .setText("Input valid review there.")
                .setRating(2)
                .build();
    }

    public IReview validNameOnlySpaceForTextWithRating() {
        return Review.get().setName("Name")
                .setText("                         ")
                .setRating(2)
                .build();
    }

}
