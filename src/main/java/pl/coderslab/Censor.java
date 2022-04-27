package pl.coderslab;

public class Censor {
    private static final String[] FORBIDDEN_WORDS = {"motyla noga",
            "kurde", "cholera"};

    public static String doCensor(String toBeCensored) {
        for (String word : FORBIDDEN_WORDS) {
            toBeCensored = toBeCensored.replaceAll(word, "*".repeat(word.length()));
        }

        return toBeCensored;
    }
}
