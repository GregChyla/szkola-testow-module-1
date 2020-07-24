package modul1;

import java.util.Objects;
import java.util.regex.Pattern;

public class StringCalculator {
    int add(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            return 0;
        } else {
            String[] numbers = input.split(",");
            int result = 0;

            for (String number : numbers) {
                if (Pattern.matches("^[-+]?\\d*$", number)) {
                    result += Integer.parseInt(number);
                }
            }
            return result;
        }
    }
}
