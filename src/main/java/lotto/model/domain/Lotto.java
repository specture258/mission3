package lotto.model.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateDuplicateLotto(numbers);
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicateLotto(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if(numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> lottoList() {
        return numbers;
    }
}
