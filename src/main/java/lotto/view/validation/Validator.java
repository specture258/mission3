package lotto.view.validation;

public abstract class Validator {

    public abstract boolean validate(String input);

    static void throwError(String message){
        throw new IllegalArgumentException("[ERROR]" + message);
    }
}
