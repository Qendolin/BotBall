package bots.mark_1;

import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.MotorPort;
import lejos.nxt.NXTRegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;

public class Controller {

	private DifferentialPilot pilot;

	public Controller() {
		pilot = new DifferentialPilot(4, 14.5, Motor.B, Motor.C);
	}

	public void run() {
		/*
		 * pilot.travel(20, true); while (pilot.isMoving()) {
		 * 
		 * } System.out.println(" "+pilot.getMovement().getDistanceTraveled());
		 * Button.waitForAnyPress();
		 */
		/*
		 * for(int i = 0; i<4 ; i++) { pilot.travel(20); pilot.rotate(90); }
		 */
		LightSensor right = new LightSensor(SensorPort.S1);
		LightSensor left = new LightSensor(SensorPort.S2);
		//UseClaw(MotorPort.A,false);
		//UseClaw(MotorPort.A,true);
		//System.exit(0);
		pilot.setTravelSpeed(17);
		rideOn();
		while (true) {
			LCD.drawString("left:" + left.getNormalizedLightValue(), 0, 0);
			LCD.drawString("right:" + right.getNormalizedLightValue(), 0, 1);
			while (right.getNormalizedLightValue() < 400) {
				pilot.rotate(-1, true);}
			rideOn();
			while (left.getNormalizedLightValue() < 400) {
				pilot.rotate(1, true);}
			rideOn();
			if (Button.readButtons() != 0) {
				System.exit(0);
			}
		}
	}
	public void rideOn() {
		
		pilot.travel(10000,true);
	}
	
	public void UseClaw(MotorPort motor,boolean close) {
		motor.controlMotor(10, 1);
		NXTRegulatedMotor m =new NXTRegulatedMotor(motor);
		m.setSpeed(60);
		if(close)m.rotate(-90);
		else m.rotate(90);
		m.waitComplete();
	}
}
