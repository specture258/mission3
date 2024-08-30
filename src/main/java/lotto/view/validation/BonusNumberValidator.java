package lotto.view.validation;

public class BonusNumberValidator implements Validator {
    @Override
    public void validate(String input) {
        validateBlank(input);
        validateInteger(input);
        validateRange(input);
    }

    private void validateInteger(String value) throws IllegalArgumentException{
        boolean isDigit = value.chars()
                .allMatch(Character::isDigit);
        if(!isDigit){
            Validator.throwError("보너스 번호가 숫자가 아닙니다");
        }
    }

    private void validateBlank(String value) throws IllegalArgumentException{
        final String BLANK = "";
        if(BLANK.equals(value.trim())){
            Validator.throwError("보너스 번호가 없습니다");
        }
    }

    private void validateRange(String value) throws IllegalArgumentException{
        if(!value.matches("[1-45]+")){
            Validator.throwError("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
