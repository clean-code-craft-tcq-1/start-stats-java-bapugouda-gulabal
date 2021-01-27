package statisticker;

import java.util.List;

import com.sun.org.glassfish.external.statistics.Stats;

public class Statistics
{
	
	public static Stats getStatistics(List<Float> numbers) {
		
		float min = getMin(numbers);
		float max = getMax(numbers);
		float avg = getAvg(numbers);
		
		Statistics statistics = new Statistics();
		Stats s = statistics.new Stats();
		
		s.setMin(min);
		s.setMax(max);
		s.setAverage(avg);
				
		return s;
       
    }
	
	
	private static float getAvg(List<Float> numbers) {
		
		float sum = 0.0f;
		
		for (float avg : numbers)
	
		sum = sum + avg;
		return sum / numbers.size();
	}


	private static float getMax(List<Float> numbers) {
		float max = Float.MIN_VALUE;
		for (float value : numbers){
			max = Math.max(value, max);
		}
		return max;
	}


	private static float getMin(List<Float> numbers) {
		float min = Float.MAX_VALUE;
		for (final float value : numbers){
			min = Math.min(value, min);
		}
		return min;
	}


	public class Stats {
		
		private double min;
		private double max;
		private double average;
		
		
		public double getMin() {
			return min;
		}
		public void setMin(double min) {
			this.min = min;
		}
		public double getMax() {
			return max;
		}
		public void setMax(double max) {
			this.max = max;
		}
		public double getAverage() {
			return average;
		}
		public void setAverage(double average) {
			this.average = average;
		}
		
		
	}
}
