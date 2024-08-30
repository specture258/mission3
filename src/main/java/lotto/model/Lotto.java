package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Collections.sort;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        Set<Integer> numberSet = new HashSet<>(numbers);
        if(numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> lottoList() {
        return numbers;
    }
}
