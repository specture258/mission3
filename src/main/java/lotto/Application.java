package lotto;

import lotto.controller.Controller;
import lotto.model.service.Service;
import lotto.view.output.OutputView;

public class Application {
    public static void main(String[] args) {

        Controller controller = new Controller(new OutputView(), new Service());
        controller.run();
        // TODO: 프로그램 구현
    }
}
