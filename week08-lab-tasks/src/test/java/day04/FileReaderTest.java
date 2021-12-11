package day04;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {
    FileReader fileReader = new FileReader();

    @Test
    void testFindSmallestTeamDifference(){
        String name = fileReader.findSmallestTeamDifference("football.dat");
        assertEquals("Aston_Villa", name);
    }

    @Test
    void testFindSmallestTemperatureSpread(){
        int result = fileReader.findSmallestTemperatureSpread("weather.dat");
        assertEquals(14, result);
    }
}