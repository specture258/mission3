package lotto.view;

import lotto.view.validation.BonusNumberValidator;
import lotto.view.validation.PriceValidator;
import lotto.view.validation.Validator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public Validator validator;

    public InputView(Validator validator) {
        this.validator =  new PriceValidator();
    }

    public String inputPrice(){
        String price = "";
        do{
            price = readLine();
        }while (validator.validate(price));
       return price;
    }

    public String inputWinningNumbers(){

    }

    public String inputBonusNumber(){

    }
}
