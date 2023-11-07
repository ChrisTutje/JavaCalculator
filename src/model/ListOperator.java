package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ListOperator {
    private List<Double> numberList;

    public ListOperator() {
        numberList = new ArrayList<>();
    }

    public void appendToList(double number) {
        numberList.add(number);
    }

    public void popFromList() {
        if (!numberList.isEmpty()) {
            numberList.remove(numberList.size() - 1);
        }
    }

    public double calculateMean() {
        if (numberList.isEmpty()) {
            return 0;
        }
        double sum = numberList.stream().mapToDouble(Double::doubleValue).sum();
        return sum / numberList.size();
    }

    public double calculateMedian() {
        if (numberList.isEmpty()) {
            return 0;
        }
        Collections.sort(numberList);
        int size = numberList.size();
        if (size % 2 == 0) {
            int mid = size / 2;
            return (numberList.get(mid - 1) + numberList.get(mid)) / 2.0;
        } else {
            return numberList.get(size / 2);
        }
    }

    public List<Double> calculateMode() {
        if (numberList.isEmpty()) {
            return new ArrayList<>();
        }
        List<Double> modeList = new ArrayList<>();
        int maxCount = 0;
        for (double number : numberList) {
            int count = Collections.frequency(numberList, number);
            if (count > maxCount) {
                maxCount = count;
                modeList.clear();
                modeList.add(number);
            } else if (count == maxCount && !modeList.contains(number)) {
                modeList.add(number);
            }
        }
        return modeList;
    }

    public String getListAsString() {
        return numberList.stream().map(Object::toString).collect(Collectors.joining(", "));
    }
}
