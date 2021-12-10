package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReader {
    private int findSmallestTemperatureSpread(String filename){
       try{
           List<String> lines = Files.readAllLines(Path.of("src/main/resources/datamunging/" + filename));

           int minSpread = 100;
           int minDay = 0;

           for (int i = 2; i < lines.size() - 1; i++){
               int day = Integer.parseInt(lines.get(i).substring(2, 4).trim());
               int max = Integer.parseInt(lines.get(i).substring(6, 8).trim());
               int min = Integer.parseInt(lines.get(i).substring(12, 14).trim());

               int spread = max - min;
               if (minSpread > spread){
                   minSpread = spread;
                   minDay = day;
               }
           }
           return minDay;
       }catch(IOException ioe){
           throw  new IllegalStateException("Cannot read file", ioe);
       }
    }

    public static void main(String[] args) {
        int min = new FileReader().findSmallestTemperatureSpread("weather.dat");
        System.out.println(min);
    }
}

