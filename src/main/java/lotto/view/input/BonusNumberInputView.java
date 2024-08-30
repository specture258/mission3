package lotto.view.input;

import lotto.view.validation.Validator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BonusNumberInputView {

    public Validator bonusNumberValidator;

    public BonusNumberInputView(Validator bonusNumberValidator) {
        this.bonusNumberValidator = bonusNumberValidator;
    }

    public String inputBonusNumber(){
        String bonusNumber = "";
        boolean validInput = false;
        while(!validInput){
            bonusNumber = readLine();
            validInput = handleInputBonusValidation(bonusNumber);
        }
        return bonusNumber;
    }

    public boolean handleInputBonusValidation(String bonusNumber){
        try{
            bonusNumberValidator.validate(bonusNumber);
            return true;
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
