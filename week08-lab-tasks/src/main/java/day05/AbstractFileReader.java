package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractFileReader {
    public String findSmallestDifferenceName(){
        List<String> lines = readLines(getFileName());
        lines = filterLines(lines, getFilteredIndexes());
        List<DataWithDifference> data = extractData(lines,
                getNamePosition(), getValue1Position(), getValue2Position());
        return findMin(data).getName();
    }

    public abstract String getFileName();

    public abstract List<Integer> getFilteredIndexes();

    public abstract Position getNamePosition();

    public abstract Position getValue1Position();

    public abstract Position getValue2Position();

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
}
