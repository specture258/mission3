package lotto.model.domain;

import lotto.view.input.WinningNumberInputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    List<Integer> winningNumberList = new ArrayList<>();

    private final WinningNumberInputView winningNumberInputView;

    public WinningNumbers(WinningNumberInputView winningNumberInputView) {
        this.winningNumberInputView = winningNumberInputView;

    }

    public void createWinningNumber(){
        String input = winningNumberInputView.inputWinningNumber();
        stringToIntegerList(input);
    }

    private void stringToIntegerList(String input) {
        int[] array = Arrays.stream(input.split(","))
                .mapToInt(Integer::parseInt).toArray();

        winningNumberList = Arrays.stream(array)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> getWinningNumberList() {
        return winningNumberList;
    }
}
