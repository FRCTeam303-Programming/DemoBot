package org.usfirst.frc.team303.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
	Joystick lStick;
	Joystick rStick;
	boolean lStickBtn1;
	boolean lStickBtn2;
	boolean lStickBtn3;
	boolean lStickBtn4;
	boolean lStickBtn5;
	double lStickY;
	double lStickX;
	double rStickY;
	
	public OI() {
		lStick = new Joystick(RobotMap.LSTICK_PORT);
		rStick = new Joystick(RobotMap.RSTICK_PORT);
	}
	
	public void update() {
		lStickBtn1 = lStick.getRawButton(1);
		lStickBtn2 = lStick.getRawButton(2);
		lStickBtn3 = lStick.getRawButton(3);
		lStickBtn4 = lStick.getRawButton(4);
		lStickBtn5 = lStick.getRawButton(5);
		lStickY = lStick.getRawAxis(1);
		lStickX = lStick.getRawAxis(0);
		
		rStickY = rStick.getRawAxis(1);
	}
}
