package com.softserve.edu.task1.numbersWithMaxSumDivisors;

/**
 * enum with printed strings.
 */
public enum Messages {

    /**
     * List of constants:
     * ANSWER_BETWEEN_NUMBERS - a part of the answer
     * ANSWER_WINNER - a part of the answer
     * IS - a part of the answer
     * ARE - a part of the answer
     * WITH - a part of the answer
     * DIVISORS - a part of the answer
     */
    ANSWER_BETWEEN_NUMBERS("Between numbers from 0 to "),
    ANSWER_WINNER (" the winner"),
    IS  (" is "),
    ARE ("s are "),
    WITH ("with "),
    DIVISORS (" divisors' sum.");

    private String chosenMessage;

    Messages(String choice) {
        chosenMessage = choice;
    }

    public String getMessage() {
        return chosenMessage;
    }
    }
