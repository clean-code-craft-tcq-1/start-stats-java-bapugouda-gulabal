package statisticker;

import java.util.List;

public class StatsChecker {
	
	private float maxThreshold;
	  private IAlerter[] alerters;
	  
	  public StatsChecker(float maxThreshold, IAlerter[] alerters) {
	     this.maxThreshold = maxThreshold;
	     this.alerters = alerters;
	  }

	  public void checkAndAlert(List<Float> floatValueslist) {
	    Statistics.Stats stats = Statistics.getStatistics(floatValueslist);
	    
	    if(stats.getMax() > maxThreshold) {
	      for (int i = 0; i < alerters.length; i++) {
	        IAlerter iAlerter = alerters[i];
	        
	        if(iAlerter instanceof LEDAlert) {
	          LEDAlert ledAlert = (LEDAlert) iAlerter;
	          ledAlert.setLedGlows(Boolean.TRUE);
	        } else if(iAlerter instanceof EmailAlert) {
	          EmailAlert emailAlert = (EmailAlert) iAlerter;
	          emailAlert.setEmailSent(Boolean.TRUE);
	        }
	      }
	    }
	  }
}
