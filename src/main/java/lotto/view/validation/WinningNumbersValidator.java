package lotto.view.validation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbersValidator implements Validator {
    @Override
    public boolean validate(String input) {
        List<String> inputList = StringtoList(input);
        validateSize(inputList);
        validateInteger(inputList);
        validateRange(inputList);
        return true;
    }

    List<String> StringtoList(String value) {
        String[] numbers = value.split(",");
        return List.of(numbers);
    }

    void validateSize(List<String> numbersList) throws IllegalArgumentException{
        if(numbersList.size() != 6){
            Validator.throwError("당첨 번호의 개수가 잘못되었습니다");
        }
    }

    void validateInteger(List<String> numbersList) throws IllegalArgumentException{
        for(String number : numbersList){
            if(!Character.isDigit(number.charAt(0))){
                Validator.throwError("당첨 번호가 숫자가 아닙니다");
            }
        }
    }

    void validateRange(List<String> numbersList) throws IllegalArgumentException{
        List<Integer> integerList = numbersList.stream()
                .map(Integer::parseInt)
                .toList();
        for (Integer integer : integerList) {
            if (integer < 1 || integer > 45) {
                Validator.throwError("당첨 번호는 1부터 45사이의 숫자여야 합니다");
            }
        }
    }
}
