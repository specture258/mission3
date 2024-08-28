package lotto.view.validation;

public class WinningNumbers implements Validator {
    @Override
    public boolean validate(String input) {
        return false;
    }

    void validateInteger(String value){
        boolean isDigit = value.chars()
                .allMatch(Character::isDigit);
        if(!isDigit){
            Validator.throwError("구입 금액이 숫자가 아닙니다");
        }
    }
}
