package lotto.view.validation;

public class PriceValidator implements Validator {

    @Override
    public boolean validate(String input) {
        validateInteger(input);
        validateBlank(input);
        return true;
    }

    void validateInteger(String value){
        boolean isDigit = value.chars()
                .allMatch(Character::isDigit);
        if(!isDigit){
            Validator.throwError("구입 금액이 숫자가 아닙니다");
        }
    }

    void validateBlank(String value){
        final String BLANK = "";
        if(BLANK.equals(value.trim())){
            Validator.throwError("구입 금액이 없습니다");
        }
    }

}
