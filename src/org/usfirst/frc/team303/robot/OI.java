package org.usfirst.frc.team303.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
	static Joystick lStick = new Joystick(RobotMap.LSTICK_PORT);
	static Joystick rStick = new Joystick(RobotMap.RSTICK_PORT);
	static boolean lStickBtn1;
	static boolean lStickBtn2;
	static boolean lStickBtn3;
	static boolean lStickBtn4;
	static boolean lStickBtn5;
	static double lStickY;
	static double lStickX;
	static double rStickY;
	
	public OI() {
		//DON'T PUT THINGS HERE IT WILL CRASH OH MY GOD PLEASE DON'T DO IT
	}
	
	public static void update() {
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
