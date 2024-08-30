package lotto.view.input;

import lotto.view.validation.Validator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class WinningNumberInputView {
    public Validator winningNumberValidator;

    public WinningNumberInputView(Validator winningNumberValidator) {
        this.winningNumberValidator = winningNumberValidator;
    }

    public String inputWinningNumber(){
        String winningNumber = "";
        boolean validInput = false;
        while(!validInput){
            winningNumber = readLine();
            validInput = handleInputWinningNumberValidation(winningNumber);
        }
        return winningNumber;
    }

    public boolean handleInputWinningNumberValidation(String winningNumber){
        try{
            winningNumberValidator.validate(winningNumber);
            return true;
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
