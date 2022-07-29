public class CeilingFan {

	private int fanSpeed;
	private int spinDirection; // 1 = clockwise, -1 = counterclockwise
	
	// Constructor
	public CeilingFan() {
		this.fanSpeed = 0;
		this.spinDirection = 1;
	}
	
	// Returns the current fan setting
	public int checkFanSetting() {
		return fanSpeed * spinDirection; // Positive = clockwise, negative = counterclockwise
	}
	
	public void changeSpeed() {
		if (fanSpeed < 3) { 
			// Fan speed increases up to max of 3
			fanSpeed += 1;
		}
		else {
			// Fan turns off
			fanSpeed = 0;
		}
	}
	
	public void reverseDirection() {
		// Reverses spin direction
		spinDirection *= -1;
	}
}