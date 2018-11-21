package bots.mark_1;

import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;

public class Controller {
	
	private DifferentialPilot pilot;
	
	public Controller() {
		pilot = new DifferentialPilot(4, 9, Motor.B, Motor.C);
	}
	
	public void run() {
		/*pilot.travel(20, true);
	    while (pilot.isMoving()) {

	    }
	    System.out.println(" "+pilot.getMovement().getDistanceTraveled());
	    Button.waitForAnyPress();*/
		for(int i = 0; i<4 ; i++)
        {
            pilot.travel(20);
            pilot.rotate(90);                 
        }
	}
}
