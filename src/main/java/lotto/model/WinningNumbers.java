package lotto.model;

import lotto.view.WinningNumberInputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    List<Integer> winningNumber = new ArrayList<>();

    private final WinningNumberInputView winningNumberInputView;

    public WinningNumbers(WinningNumberInputView winningNumberInputView) {
        this.winningNumberInputView = winningNumberInputView;

    }

    public List<Integer> createWinningNumber(){
        String input = winningNumberInputView.inputWinningNumber();
        stringToIntegerList(input);
        return winningNumber;
    }

    public void stringToIntegerList(String input) {
        int[] array = Arrays.stream(input.split(","))
                .mapToInt(Integer::parseInt).toArray();

        winningNumber = Arrays.stream(array)
                .boxed()
                .collect(Collectors.toList());
    }
}
