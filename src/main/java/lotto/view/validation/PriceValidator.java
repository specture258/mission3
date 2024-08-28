package lotto.view.validation;

public class PriceValidator extends Validator {
    @Override
    public boolean validate(String value) {
        validateInteger(value);
        validateBlank(value);
        return true;
    }

    void validateInteger(String value){
        boolean isDigit = value.chars()
                .allMatch(Character::isDigit);
        if(!isDigit){
            throwError("구입 금액이 숫자가 아닙니다");
        }
    }

    void validateBlank(String value){
        final String BLANK = "";
        if(BLANK.equals(value.trim())){
            throwError("구입 금액이 없습니다");
        }
    }
}
