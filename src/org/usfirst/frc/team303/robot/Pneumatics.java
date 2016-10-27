package org.usfirst.frc.team303.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;

public class Pneumatics {
	
//this class assumes two pneumatic pistons. More can easily be added. If extensive logic is being preformed,
//it may be desirable to split the class into two component parts. 
	
	Compressor compressor = new Compressor();
	Solenoid piston = new Solenoid(RobotMap.PCM_SOLENOID);
//	Solenoid piston2 = new Solenoid(SampleRobotMap.PCM_SOLENOID2);
	
	public Pneumatics() {
		pneumaticsInit();
	}
	
	public void pneumaticsInit() {
		compressor.start();
	}
	
	public void setPiston(boolean piston1) {
		piston.set(piston1);
//		piston.set(piston2);
	}
}