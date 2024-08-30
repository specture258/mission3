package lotto.view.validation;

public class PriceValidator implements Validator {

    @Override
    public void validate(String input) {
       validateInteger(input);
       validateBlank(input);
       validateCorrectPrice(input);
    }

    private void validateInteger(String value) throws IllegalArgumentException {
        boolean isDigit = value.chars()
                .allMatch(Character::isDigit);
        if(!isDigit){
            Validator.throwError("구입 금액이 숫자가 아닙니다");
        }
    }

    private void validateBlank(String value) throws IllegalArgumentException {
        final String BLANK = "";
        if(BLANK.equals(value.trim())){
            Validator.throwError("구입 금액이 없습니다");
        }
    }

    private void validateCorrectPrice(String value) throws IllegalArgumentException {
        if(Integer.parseInt(value) % 1000 != 0){
            Validator.throwError("로또의 개수가 정수가 아닙니다");
        }
    }

}
