package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Service;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    public OutputView outputView;
    public Service service;
    public Lotto lotto;

    public Controller(OutputView outputView, Service service) {
        this.outputView = outputView;
        this.service = service;
    }

    public void run(){
        buyLotto();
        chooseNumber();
        showResult();
    }

    private void buyLotto() {
        outputView.viewPrice();
        service.getLotto();

        outputView.viewLottoCount(service);
        List<Lotto> lotteries = service.createLotteries();
        for(Lotto lottery : lotteries){
            outputView.viewLotteries(lottery);
        }
    }

    private void chooseNumber() {
        outputView.viewWinningNumbers();
        service.getWinningNumbers();

        outputView.viewBonusNumber();
        service.getBonusNumber();
    }

    private void showResult() {
        outputView.viewWinningStatistic();
        service.correspondWithLotto();
        outputView.viewFifth(service);
        outputView.viewFourth(service);
        outputView.viewThird(service);
        outputView.viewSecond(service);
        outputView.viewFirst(service);
        outputView.viewProfit(service);

    }


}
