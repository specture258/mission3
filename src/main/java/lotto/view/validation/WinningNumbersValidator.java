package lotto.view.validation;

import java.util.Arrays;
import java.util.List;

public class WinningNumbersValidator implements Validator {
    @Override
    public boolean validate(String input) {
        List<String> inputList = StringtoList(input);
        validateInteger(inputList);
        validateSize(inputList);
        return true;
    }

    List<String> StringtoList(String value){
        String[] numbers = value.split(",");
        return Arrays.asList(numbers);
    }

    void validateInteger(List<String> numbersList){
        boolean isDigit = numbersList.stream()
                .anyMatch(n -> n.matches("\\d+"));
        if(!isDigit){
            Validator.throwError("당첨 번호가 숫자가 아닙니다");
        }
    }

    void validateSize(List<String> numbersList){
        if(numbersList.size() !=6){
            Validator.throwError("당첨 번호의 개수가 잘못되었습니다");
        }
    }
}
