package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> randomNumbers;

    public Computer() {
        this.randomNumbers = generateRandomNumber();
    }

    public List<Integer> getRandomNumbers() {
        return this.randomNumbers;
    }

    private List<Integer> generateRandomNumber() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber))
                numbers.add(randomNumber);
        }
        return numbers;
    }
}
