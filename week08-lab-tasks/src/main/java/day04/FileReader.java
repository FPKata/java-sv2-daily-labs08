package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReader {
    public String findSmallestTeamDifference(String filename){
        List<String> lines = readLines(filename);
        lines = filterLines(lines, Arrays.asList(0, 18));
        List<DataWithDifference> data = extractData(lines,
                new Position(7, 22), new Position(43, 45), new Position(50, 52));
        return findMin(data).getName();
    }

    public int findSmallestTemperatureSpread(String filename){
        List<String> lines = readLines(filename);
        lines = filterLines(lines, Arrays.asList(0, 1, 32));
        List<DataWithDifference> data = extractData(lines,
                new Position(2, 4), new Position(6, 8), new Position(12, 14));
        return Integer.parseInt(findMin(data).getName());
    }

     private List<String> readLines(String filename){
         try {
             return Files.readAllLines(Path.of("src/test/resources/datamunging/" + filename));
         } catch (IOException ioe) {
             throw new IllegalStateException("Cannot read file", ioe);
         }
     }

     private List<String> filterLines(List<String> lines, List<Integer> filtered){
        List<String> result = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++){
            if (!filtered.contains(i)){
                result.add(lines.get(i));
            }
        }
        return result;
     }

     private List<DataWithDifference> extractData(List<String> lines, Position namePosition,
                                                  Position value1Position, Position value2Position){
        List<DataWithDifference> result = new ArrayList<>();
        for (String actual : lines){
            String name = namePosition.getAsString(actual);
            int value1 = value1Position.getAsInt(actual);
            int value2 = value2Position.getAsInt(actual);

            result.add(new DataWithDifference(name, value1, value2));
        }
        return result;
     }

     private DataWithDifference findMin(List<DataWithDifference> data){
        DataWithDifference min = data.get(0);
        for (DataWithDifference item : data){
            if (min.getDifference() > item.getDifference()){
                min = item;
            }
        }
        return min;
     }

    public static void main(String[] args) {
        int minTemperature = new FileReader().findSmallestTemperatureSpread("weather.dat");
        System.out.println(minTemperature);
        String result = new FileReader().findSmallestTeamDifference("football.dat");
        System.out.println(result);
    }
}

