package lotto.model.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.domain.*;
import lotto.view.input.BonusNumberInputView;
import lotto.view.input.PriceNumberInputView;
import lotto.view.input.WinningNumberInputView;
import lotto.view.validation.BonusNumberValidator;
import lotto.view.validation.PriceValidator;
import lotto.view.validation.WinningNumbersValidator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Collections.sort;

public class Service {

    List<Lotto> lotteries = new ArrayList<>();
    List<Integer> lottoNumbers = new ArrayList<>();
    List<Integer> winningNumbersList = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    int[] correspondCount = new int[5];
    Long profit = 0L;

    public final WinningNumbers winningNumbers = new WinningNumbers(new WinningNumberInputView(new WinningNumbersValidator()));
    public final BonusNumber bonusNumber = new BonusNumber(new BonusNumberInputView(new BonusNumberValidator()));
    public final Price price = new Price(new PriceNumberInputView(new PriceValidator()));


    public int getCount(){
        return price.getPrice() / 1000;
    }

    public void getLotto(){
        price.createPrice();
    }

    public List<Lotto> createLotteries(){
        for(int i = 0; i < getCount(); i++){
            lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> sorted = lottoNumbers.stream()
                    .sorted()
                    .toList();
            Lotto lotto = new Lotto(sorted);
            lotteries.add(lotto);
        }
        return lotteries;
    }

    public void getWinningNumbers(){
         winningNumbersList = winningNumbers.createWinningNumber();
    }

    public void getBonusNumber(){
        boolean isValid = false;
        while(!isValid){
            int number = bonusNumber.createBonusNumber();
            isValid = handleDuplicateBonusNumberValidation(number, winningNumbersList);
        }
    }

    public boolean handleDuplicateBonusNumberValidation(int bonusNumber, List<Integer> list){
        try{
            duplicateBonusNumberValidator(bonusNumber, list);
            return true;
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void duplicateBonusNumberValidator(int bonusNumber, List<Integer> list){
        boolean same = list.stream()
                .anyMatch(i -> i == bonusNumber);
        if(same){
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 일치합니다.");
        }
    }

    public void correspondWithLotto(){
        List<Integer> wN = winningNumbersList;
        int bN = bonusNumber.getNumber();
        for(int i = 0; i < getCount(); i++){
            Lotto lotto = lotteries.get(i);
            temp = lotto.lottoList();
            Set<Integer> integerList = temp.stream()
                    .filter(wN::contains)
                    .collect(Collectors.toSet());
            int size = integerList.size();
            if(size==5){
                if(temp.contains(bN)){
                    //2등
                    correspondCount[3]++;
                }
                else{
                    //3등
                    correspondCount[2]++;
                }
            }
            else{
                if(size == 3){
                    //5동
                    correspondCount[0]++;
                }
                else if(size == 4){
                    //4동
                    correspondCount[1]++;
                }
                else if(size == 6){
                    //1등
                    correspondCount[4]++;
                }
            }
        }

    }

    public int[] getCorrespondCount() {
        return correspondCount;
    }

    public long createProfit(){
        int cnt =0 ;
        Rank[] values = Rank.values();

        for(Rank rank : values){
            profit += (long) rank.getMoney() * correspondCount[cnt++];
        }
        return profit;
    }

    public String getProfit(){
        BigDecimal bigDecimal = BigDecimal.valueOf((double) createProfit() / 8000 * 100);
        return bigDecimal.toPlainString();

    }
}
