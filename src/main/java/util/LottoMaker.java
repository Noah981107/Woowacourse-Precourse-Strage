package util;

import lotto.Lotto;
import ui.ExceptionMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoMaker {

    private static final Integer MIN = 1;
    private static final Integer MAX = 45;
    private static final Integer NUMBER = 6;

    public static Lotto makeLottoFromInput(String input) throws IllegalArgumentException{
        String[] splitInput = input.split("[,]");
        isValidNumber(splitInput);
        isValidParser(splitInput);
        isUniqueNumber(splitInput);
        return makeLotto(splitInput);
    }

    private static void isValidNumber(String[] input) {
        for (String value : input) {
            if (Integer.parseInt(value) < MIN || Integer.parseInt(value) > MAX) {
                throw new IllegalArgumentException(ExceptionMessage.IS_NOT_VALID_WINNING_LOTTO.getTxt());
            }
        }
    }

    private static void isUniqueNumber(String[] input) {
        Set<Integer> set = new HashSet<>();
        for (String value : input) {
            set.add(Integer.parseInt(value));
        }
        if (set.size() != input.length)
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_UNIQUE_WINNING_LOTTO.getTxt());
    }

    private static void isValidParser(String[] input) {
        if (input.length != NUMBER)
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_VALID_WINNING_LOTTO_PARSER.getTxt());
    }

    private static Lotto makeLotto(String[] input) {
        List<Integer> result = new ArrayList<>();
        for (String value : input) {
            result.add(Integer.parseInt(value));
        }
        return new Lotto(result);
    }
}
