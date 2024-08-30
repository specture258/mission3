package lotto.view;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.Service;

import java.util.Arrays;

public class OutputView {
    public void viewPrice(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void viewLottoCount(Service service){
        System.out.println();
        System.out.println(service.getCount()+ "개를 구매했습니다.");
    }

    public void viewLotteries(Lotto lotto){
        System.out.println(lotto.lottoList());
    }

    public void viewWinningNumbers(){
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void viewBonusNumber(){
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void viewWinningStatistic(){
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void viewFifth(Service service) {
        System.out.println("3개 일치 (5,000원) - "+ service.getCorrespondCount()[0]+"개");
    }

    public void viewFourth(Service service) {
        System.out.println("4개 일치 (50,000원) - "+ service.getCorrespondCount()[1]+"개");
    }

    public void viewThird(Service service) {
        System.out.println("5개 일치 (1,500,000원) - "+ service.getCorrespondCount()[2]+"개");
    }

    public void viewSecond(Service service) {
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+ service.getCorrespondCount()[3]+"개");
    }

    public void viewFirst(Service service) {
        System.out.println("6개 일치 (2,000,000,000원) - "+ service.getCorrespondCount()[4]+"개");
    }

    public void viewProfit(Service service) {
        System.out.println("총 수익률은 "+service.getProfit()+"%입니다.");
    }
}
