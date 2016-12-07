package org.usfirst.frc.team303.robot;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.I2C;

public class VictorSixDrivebase {
	VictorSP FL;
	VictorSP FR;
	VictorSP BL;
	VictorSP BR;
	VictorSP F1;
	VictorSP F2;
	Encoder lDriveEnc;
	Encoder rDriveEnc;
	AHRS navX;
	double navXYaw;
	double lDriveEncDist;
	double rDriveEncDist;

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
		lDriveEnc = new Encoder(0, 1);
		rDriveEnc = new Encoder(2, 3);
		navX = new AHRS(I2C.Port.kMXP);
	}

	public void drive(double left, double right) {
		FL.set(left);
		BL.set(left);
		F1.set(left);
		
		FR.set(right);
		BR.set(right);
		F2.set(right);
	}
	public void updateSensors() {
		navXYaw = navX.getYaw();
		lDriveEncDist = lDriveEnc.getDistance();
		rDriveEncDist = rDriveEnc.getDistance();
		
		SmartDashboard.putNumber("NavXYaw", navXYaw);
		SmartDashboard.putNumber("lDriveEncDist", lDriveEncDist);
		SmartDashboard.putNumber("rDriveEncDist", rDriveEncDist);
		
	}
}
