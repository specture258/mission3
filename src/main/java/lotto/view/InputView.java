package lotto.view;

import lotto.view.validation.Validator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public Validator priceValidator;
    public Validator winningNumberValidator;
    public Validator bonusNumberValidator;

    public InputView(Validator priceValidator, Validator winningNumberValidator, Validator bonusNumberValidator) {
        this.priceValidator = priceValidator;
        this.winningNumberValidator = winningNumberValidator;
        this.bonusNumberValidator = bonusNumberValidator;
    }

    public String inputPrice(){
        String price = "";
        do{
            price = readLine();
        }while (priceValidator.validate(price));
        return price;
    }

    public String inputWinningNumbers(){
        String winningNumbers = "";
        do{
            winningNumbers = readLine();
        }while (winningNumberValidator.validate(winningNumbers));
        return winningNumbers;
    }

    public String inputBonusNumber(){

    }
}
