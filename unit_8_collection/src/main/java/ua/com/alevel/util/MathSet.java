package ua.com.alevel.util;

import java.util.Arrays;

public class MathSet<T extends Number> {
    private final static int DEFAULT_CAPACITY = 10;
    private int size;
    private Number[] mathSet;
    private static final int MULTIPLIER = 2;

    public MathSet() {
        this.mathSet = new Number[DEFAULT_CAPACITY];
    }

    public MathSet(int capacity) {
        this.mathSet = new Number[capacity];
    }

    public MathSet(MathSet numbersSet) {
        this.add(numbersSet.toArray());
    }

    public MathSet(Number[] numbers) {
        this.mathSet = new Number[numbers.length];
        this.addArrayToMathSet(numbers);
    }

    public MathSet(Number[]... numbers) {
        for (Number[] num : numbers) {
            this.addArrayToMathSet(num);
        }
    }

    public int findNumber(Number num) {
        if (mathSet != null) {
            for (int i = 0; i < mathSet.length; i++) {
                if (num.equals(mathSet[i])) {
                    return i;
                }
            }
        }
        return 0;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void add(T num) {
        if (this.findNumber(num) == 0) {
            if (this.mathSet.length == size) {
                setSize((int) mathSet.length * MULTIPLIER);
            }
            this.mathSet[size] = num;
            this.size++;
        }
    }

    public void add(T... number) {
        if (this.mathSet.length < (this.size + number.length)) {
            Number[] newMathSet = Arrays.copyOf(mathSet, (this.size + number.length));
        }
        addArrayToMathSet(number);
    }

    private void addArrayToMathSet(Number[] numbers) {
        for (Number num : numbers) {
            this.add(num);
        }
    }

    public void join(MathSet addingMathSet) {
        this.add((T[])addingMathSet.toArray());
    }

    public void join(MathSet... mathSet) {
        for (MathSet set : mathSet) {
            this.join(set);
        }
    }

    public void sortAsc() {
        for (int i = 0; i < this.mathSet.length - 1; i--) {
            for (int j = 0; j < i; j++) {
                if ((Integer)(mathSet[j]) >(Integer)(mathSet[j + 1])) {
                    Number temp = mathSet[j];
                    mathSet[j] = mathSet[j + 1];
                    mathSet[j + 1] = temp;
                }
            }
        }
    }

    public void sortDesc() {
        Number[] result = new Number[mathSet.length];
        sortAsc();
        Number[] sortedSet = new Number[result.length];
        for (int i = result.length - 1; i > 0; i--) {
            for (int j = 0; j < sortedSet.length; j++) {
                sortedSet[j] = result[i];
            }
        }
    }

    public Number get(int index) {
        return mathSet[index];
    }

    public Number getMax() {
        Number max = mathSet[0];
        for (int i = 0; i < mathSet.length; i++) {
            if ((Integer)(mathSet[i]) > (Integer)max) {
                max = mathSet[i];
            }
        }
        return max;
    }

    public Number getMin() {
        Number min = mathSet[0];
        for (int i = 0; i < mathSet.length; i++) {
            if ((Integer)mathSet[i] < (Integer)min) {
                min = mathSet[i];
            }
        }
        return min;
    }

    public Number getAverage() {
        Integer sum = 0;
        for (Number value : mathSet) {
            sum += (Integer)value;
        }
        Number average = sum / mathSet.length;
        return average;
    }

    public Number getMedian() {
        Number median = 0;
        if (size > 0) {
            sortAsc();
            if (mathSet.length % 2 == 0) {
                median = mathSet[size / 2 - 1];
            }
            if (mathSet.length % 2 == 1) {
                median = mathSet[size / 2];
            }
        }

        return median;
    }

    public Number[] toArray() {
        return  Arrays.copyOfRange(this.mathSet, 0, size);
    }

    public void clear() {
        this.mathSet = new Number[mathSet.length];
        this.size = 0;
    }

    public void clear(int firstIndex, int lastIndex) {
        if (isCorrectIndex(firstIndex, lastIndex)) {
            Number[] numbers = new Number[size];
            int index = 0;
            for (int i = 0; i < size; i++) {
                if (!(firstIndex <= i && lastIndex > i)) {
                    numbers[index] = mathSet[i];
                    index++;
                }
            }
            mathSet = numbers;
        }
    }

    public void clear(Number[] numbs) {
        Number[] numbers = new Number[size];
        int index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < numbs.length; j++) {
                if (findNumber(numbs[j]) == findNumber(mathSet[i])) {
                    numbers[index] = mathSet[i];
                    index++;
                }
            }
        }
        this.mathSet = numbers;
    }

    private boolean isCorrectIndex(int firstIndex, int lastIndex) {
        if (firstIndex < 0 || firstIndex > this.size) {
            return false;
        }
        if (lastIndex < 0 || lastIndex > this.size) {
            return false;
        }
        if (firstIndex > lastIndex) {
            return false;
        }
        return true;
    }
}
