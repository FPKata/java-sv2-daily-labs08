package day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberSequence {
    private List<Integer> numbers = new ArrayList<>();

    public NumberSequence(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public NumberSequence(int howMany, int min, int max) {
        Random random = new Random();
        for (int i = 0; i < howMany; i++){
            numbers.add(random.nextInt(min, max + 1));
        }
    }

    public double getAverage(){
        double sum = 0;
        for (int actual : numbers){
            sum += actual;
        }
        return sum / numbers.size();  //vagy itt keerkítek 2 tizedejegyre
    }

    public List<Integer> closeToAverage(int value){
        List<Integer> withinValue = new ArrayList<>();
        double avg = getAverage();
        for (Integer actual : numbers){
            if (Math.abs(actual - avg) <= value){  //vagy value + 0.000001d a számábrázolás miatt
                withinValue.add(actual);
            }
        }
        return  withinValue;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
