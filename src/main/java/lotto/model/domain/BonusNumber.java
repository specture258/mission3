package lotto.model.domain;

import lotto.view.input.BonusNumberInputView;

public class BonusNumber {

    int number;

    private final BonusNumberInputView bonusNumberInputView;

    public BonusNumber(BonusNumberInputView bonusNumberInputView) {
        this.bonusNumberInputView = bonusNumberInputView;
    }

    public int createBonusNumber(){
        String input = bonusNumberInputView.inputBonusNumber();
        this.number = Integer.parseInt(input);
        return number;
    }

    public int getNumber() {
        return number;
    }
}
