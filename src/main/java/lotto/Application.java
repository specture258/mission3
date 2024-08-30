package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.controller.Controller;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Service;
import lotto.model.WinningNumbers;
import lotto.view.BonusNumberInputView;
import lotto.view.OutputView;
import lotto.view.WinningNumberInputView;
import lotto.view.validation.BonusNumberValidator;
import lotto.view.validation.WinningNumbersValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        Controller controller = new Controller(new OutputView(), new Service());
        controller.run();
        // TODO: 프로그램 구현
    }
}
