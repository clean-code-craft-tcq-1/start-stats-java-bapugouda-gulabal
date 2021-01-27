package statisticker;

public class EmailAlert implements IAlerter {

	private boolean emailSent;

	public boolean isEmailSent() {
		return emailSent;
	}

	public void setEmailSent(boolean emailSent) {
		this.emailSent = emailSent;
	}
	
	
}
