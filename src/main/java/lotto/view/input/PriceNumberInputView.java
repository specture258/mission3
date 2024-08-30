package lotto.view.input;

import lotto.view.validation.Validator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class PriceNumberInputView {

    public Validator priceValidator;

    public PriceNumberInputView(Validator priceValidator) {
        this.priceValidator = priceValidator;
    }

    public String inputPrice(){
        String price = "";
        boolean validInput = false;
        while(!validInput){
            price = readLine();
            validInput = handleInputPriceValidation(price);
        }
        return price;
    }

    public boolean handleInputPriceValidation(String price){
        try{
            priceValidator.validate(price);
            return true;
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
