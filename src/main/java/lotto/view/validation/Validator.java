package lotto.view.validation;

public interface Validator {

    void validate(String input);

    static void throwError(String message){
        throw new IllegalArgumentException("[ERROR] " + message);
    }
}
