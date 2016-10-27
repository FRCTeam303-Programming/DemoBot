package org.usfirst.frc.team303.robot;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.RobotDrive;

public class VictorSixDrivebase {
	VictorSP FL;
	VictorSP FR;
	VictorSP BL;
	VictorSP BR;
	VictorSP F1;
	VictorSP F2;

	public VictorSixDrivebase() {
		FL = new VictorSP(RobotMap.FLM);
		FR = new VictorSP(RobotMap.FRM);
		BL = new VictorSP(RobotMap.BLM);
		BR = new VictorSP(RobotMap.BRM);
		F1 = new VictorSP(RobotMap.F1);
		F2 = new VictorSP(RobotMap.F2);
		
		FL.setSafetyEnabled(true);
		FR.setSafetyEnabled(true);
		BL.setSafetyEnabled(true);
		BR.setSafetyEnabled(true);
		F1.setSafetyEnabled(true);
		F2.setSafetyEnabled(true);
		
		FL.setInverted(RobotMap.FLM_INV);
		FR.setInverted(RobotMap.FRM_INV);
		BL.setInverted(RobotMap.BLM_INV);
		BR.setInverted(RobotMap.BRM_INV);
		F1.setInverted(RobotMap.F1_INV);
		F2.setInverted(RobotMap.F2_INV);
		
		FL.enableDeadbandElimination(true);
		FR.enableDeadbandElimination(true);
		BR.enableDeadbandElimination(true);
		BL.enableDeadbandElimination(true);
		F1.enableDeadbandElimination(true);
		F2.enableDeadbandElimination(true);
	}

	public void drive(double left, double right) {
		FL.set(left);
		BL.set(left);
		F1.set(left);
		
		FR.set(right);
		BR.set(right);
		F2.set(right);
	}
}
