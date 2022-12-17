package telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : urls) {
            if (hasDigits(url)) {
                sb.append("Invalid URL!");
            } else {
                sb.append(String.format("Browsing: %s!", url));
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            if (!hasOnlyDigits(number)) {
                sb.append("Invalid number!");
            } else {
                sb.append(String.format("Calling... %s", number));
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    private boolean hasDigits(String url) {
        for (char singleChar : url.toCharArray()) {
            if (Character.isDigit(singleChar)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasOnlyDigits(String number) {
        for (char singleChar : number.toCharArray()) {
            if (!Character.isDigit(singleChar)) {
                return false;
            }
        }
        return true;
    }


}
