package statisticker;

import static org.junit.Assert.*;
import jdk.nashorn.internal.AssertsEnabled;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import org.junit.Test;

//import com.sun.org.glassfish.external.statistics.Stats;

public class StatisticsTest 
{
    @Test
    public void reportsAverageMinMaxx()
    {
        Float[] numbers = {1.5f, 8.9f, 3.2f, 4.5f};
        List<Float> numberList = Arrays.asList(numbers);

        Statistics.Stats stats = Statistics.getStatistics(numberList);
        

        float epsilon = 0.001f;
        assertEquals(stats.getAverage(), 4.525f, epsilon);
        assertEquals(stats.getMin(), 1.5f, epsilon);
        assertEquals(stats.getMax(), 8.9f, epsilon);
    }
    @Test
    public void reportsNaNForEmptyInput()
    {
        List<Float> emptyList = new ArrayList<Float>();

        Statistics.Stats stats = Statistics.getStatistics(emptyList);

        assertTrue(((Double)stats.getAverage()).isNaN());
        
        //All fields of computedStats (average, max, min) must be
        //Float.NaN (not-a-number), as described in
        //https://www.geeksforgeeks.org/nan-not-number-java/
        //Design the asserts here and implement accordingly.
    }
    
    @Test
    public void reportsAlertsIfMaxIsMoreThanThreshold()
    {
        EmailAlert emailAlerter = new EmailAlert();
        LEDAlert ledAlerter = new LEDAlert();
        IAlerter alerters[] = {emailAlerter, ledAlerter};
        float maxThreshold = 10.2f;
        StatsChecker checker = new StatsChecker(maxThreshold, alerters);

        Float[] numbers = {11.5f, 6.9f, 7.5f, 6.6f};
        List<Float> numberList = Arrays.asList(numbers);
        checker.checkAndAlert(numberList);
        
        assertTrue(emailAlerter.isEmailSent());
        assertTrue(ledAlerter.isLedGlows());
        
    }
}
