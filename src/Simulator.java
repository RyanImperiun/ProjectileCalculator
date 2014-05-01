import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Simulator {

	double	angleTheta, projectileVelocity, gravityForce;	// Known factors
	double	horizontalVelocity, verticalVelocity;			// Velocities of the projectile
	double	projectileDistance, projectileHeight;			// Extra information to be determined
	double	cosineOfTheta, sineOfTheta;						// Sine and Cosine of the angle for determining velocities
	double	maximumHeight, maximumDistance;					// Highest point and farthest point
	double	halfHangTime, totalHangTime;					// Hangtime of the projectile

	public Simulator() { // Do stuff right away!
		gatherInitialInformation();

		determineSineAndCosineOfTheta(getAngleTheta());

		determineDirectionalVelocities();

		determineMaximumHeightOfProjectile(getVerticalVelocity(), getGravityForce());

		determineHangTimes(getVerticalVelocity(), getGravityForce());

		determineTotalHorizontalDistance();

		outputResults();
	}

	private void gatherInitialInformation() { // Gathers initial conditions from user
		setGravityForce(Double.parseDouble(JOptionPane.showInputDialog(null, "What is the force of Gravity (m/s^2)")));
		setAngleTheta(Double.parseDouble(JOptionPane.showInputDialog(null, "What is the angle of the projectile relative to the ground?")));
		setProjectileVelocity(Double.parseDouble(JOptionPane.showInputDialog(null, "What is the speed of the projectile(m/s)?")));
	}

	private void determineSineAndCosineOfTheta(double degrees) { // By name...
		setCosineOfTheta(Math.cos(Math.toRadians(degrees)));
		setSineOfTheta(Math.sin(Math.toRadians(degrees)));
	}

	private void determineDirectionalVelocities() { // By name...
		setHorizontalVelocity(getProjectileVelocity() * getCosineOfTheta());
		setVerticalVelocity(getProjectileVelocity() * getSineOfTheta());
	}

	private void determineMaximumHeightOfProjectile(double initialVelocity, double gravity) { // Determine height via (v^2 = u^2 - 2*a*s): Solving for "s"
		setMaximumHeight((initialVelocity * initialVelocity) / (2 * gravity));
	}

	private void determineHangTimes(double initialVelocity, double gravity) { // By name...
		setHalfHangTime(initialVelocity / gravity);
		setTotalHangTime(getHalfHangTime() * 2);
	}

	private void determineTotalHorizontalDistance() { // By name...
		setMaximumDistance(getHorizontalVelocity() * getTotalHangTime());
	}

	private void outputResults() { // By name...
		String outputMessage = "Force of Gravity (m/s^2): " + getGravityForce() 
			+ "\nAngle of the Projectile (Degrees): " + getAngleTheta()
			+ "\nInitial Velocity of the Projectile (m/s): " + getProjectileVelocity()
			+ "\nHorizontal Velocity of the Projectile (m/s): " + getHorizontalVelocity()
			+ "\nVertical Velocity of the Projectile (m/s): " + getVerticalVelocity()
			+ "\nHighest point of the Projectile (m): " + getMaximumHeight()
			+ "\nTotal Hang-Time of the Projectile (s): " + getTotalHangTime()
			+ "\nTotal distance of the Projectile (m): " + getMaximumDistance();

		JTextArea msg = new JTextArea(outputMessage);
		msg.setLineWrap(true);
		msg.setWrapStyleWord(true);
		msg.setColumns(35);

		JScrollPane scrollPane = new JScrollPane(msg);

		JOptionPane.showMessageDialog(null, scrollPane);
	}

	public static void main(String args[]) { // Start everything
		new Simulator();
	}

	/* -----------------------------
	 * Getters and Setters and Stuff
	 * Do not go past this point!
	 * I warned you!
	 */

	public double getAngleTheta() {
		return angleTheta;
	}

	public void setAngleTheta(double angleTheta) {
		this.angleTheta = angleTheta;
	}

	public double getProjectileVelocity() {
		return projectileVelocity;
	}

	public void setProjectileVelocity(double projectileVelocity) {
		this.projectileVelocity = projectileVelocity;
	}

	public double getGravityForce() {
		return gravityForce;
	}

	public void setGravityForce(double gravityForce) {
		this.gravityForce = gravityForce;
	}

	public double getProjectileDistance() {
		return projectileDistance;
	}

	public void setProjectileDistance(double projectileDistance) {
		this.projectileDistance = projectileDistance;
	}

	public double getProjectileHeight() {
		return projectileHeight;
	}

	public void setProjectileHeight(double projectileHeight) {
		this.projectileHeight = projectileHeight;
	}

	public double getHorizontalVelocity() {
		return horizontalVelocity;
	}

	public void setHorizontalVelocity(double horizontalVelocity) {
		this.horizontalVelocity = horizontalVelocity;
	}

	public double getVerticalVelocity() {
		return verticalVelocity;
	}

	public void setVerticalVelocity(double verticalVelocity) {
		this.verticalVelocity = verticalVelocity;
	}

	public double getCosineOfTheta() {
		return cosineOfTheta;
	}

	public void setCosineOfTheta(double cosineOfTheta) {
		this.cosineOfTheta = cosineOfTheta;
	}

	public double getSineOfTheta() {
		return sineOfTheta;
	}

	public void setSineOfTheta(double sineOfTheta) {
		this.sineOfTheta = sineOfTheta;
	}

	public double getMaximumHeight() {
		return maximumHeight;
	}

	public void setMaximumHeight(double maximumHeight) {
		this.maximumHeight = maximumHeight;
	}

	public double getMaximumDistance() {
		return maximumDistance;
	}

	public void setMaximumDistance(double maximumDistance) {
		this.maximumDistance = maximumDistance;
	}

	public double getTotalHangTime() {
		return totalHangTime;
	}

	public void setTotalHangTime(double totalHangTime) {
		this.totalHangTime = totalHangTime;
	}

	public double getHalfHangTime() {
		return halfHangTime;
	}

	public void setHalfHangTime(double halfHangTime) {
		this.halfHangTime = halfHangTime;
	}
}