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

    public void append(double number) {
        numberList.add(number);
    }

    public void pop() {
        if (!numberList.isEmpty()) {
            numberList.remove(numberList.size() - 1);
        }
    }
    
    public double calculateSum() {
        double sum = 0;
        for (double value : numberList) {
            sum += value;
        }
        return sum;
    }

    public double calculateDifference() {
        if (numberList.isEmpty()) {
            return 0; 
        }
        double difference = numberList.get(0);
        for (int i = 1; i < numberList.size(); i++) {
            difference -= numberList.get(i);
        }
        return difference;
    }

    public double calculateProduct() {
        double product = 1;
        for (double value : numberList) {
            if (product > Double.MAX_VALUE / value) {
                throw new ArithmeticException("Error: Result exceeds maximum value");
            }
            product *= value;
        }
        return product;
    }

    public double calculateQuotient() {
        if (numberList.isEmpty()) {
            return 0; 
        }
        double quotient = numberList.get(0);
        for (int i = 1; i < numberList.size(); i++) {
            if (numberList.get(i) != 0) {
                quotient /= numberList.get(i);
            } else {
                throw new ArithmeticException("Error: Dividing by 0");
            }
        }
        return quotient;
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
    
    public void removeAll() {
        numberList.clear(); 
    }
    
    public void sort() {
        Collections.sort(numberList);
    }
    
    public void shuffle() {
        Collections.shuffle(numberList);
    }
    
    public double getMin() {
        if (numberList.isEmpty()) {
            return 0; 
        }
        return Collections.min(numberList);
    }

    public double getMax() {
        if (numberList.isEmpty()) {
            return 0; 
        }
        return Collections.max(numberList);
    }

    public double getRange() {
        if (numberList.isEmpty()) {
            return 0; 
        }
        return getMax() - getMin();
    }
    
    public int getLength() {
        return numberList.size();
    }
    
    public double calculateStandardDeviation() {
        if (numberList.isEmpty()) {
            return 0;
        }

        double mean = calculateMean();

        double sumOfSquaredDifferences = 0;
        for (double value : numberList) {
            sumOfSquaredDifferences += Math.pow(value - mean, 2);
        }

        double variance = sumOfSquaredDifferences / numberList.size();

        return Math.sqrt(variance);
    }
    
    public String calculateDelta() {
        if (numberList.isEmpty() || numberList.size() == 1) {
            return "No delta";
        }

        double firstDifference = numberList.get(1) - numberList.get(0);

        for (int i = 1; i < numberList.size() - 1; i++) {
            double currentDifference = numberList.get(i + 1) - numberList.get(i);
            if (currentDifference != firstDifference) {
                return "No delta";
            }
        }

        return String.valueOf(firstDifference);
    }

    public String getListAsString() {
        return numberList.stream().map(Object::toString).collect(Collectors.joining(", "));
    }
}
