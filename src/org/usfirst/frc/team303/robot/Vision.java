package org.usfirst.frc.team303.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Vision {
	
	double KpX=.05;
	double KiX=.001;
	double KdX=0;
	double KpY=0;  
	double KiY=0;
	double KdY=0;
	double PowerX=.5;
	double PowerY=.15;
	final static double IDEAL_center_X=100;
    final static double IDEAL_center_Y=100;
    final static double PIXELS_TO_DEGREES=.14875;
    final static double PIXELS_TO_ENCODERS=1;
    double errorSumX=0;
    double errorSumY=0;
    double previousErrorX;
    double previousErrorY;
    boolean firstRun=true;
    double angleSetpoint;
    double encoderSetpoint;
    boolean firstPIDX;
    boolean firstPIDY;
    public boolean run(double centerX,double centerY){
    	if(firstRun){
    		angleSetpoint=((centerX-IDEAL_center_X)*PIXELS_TO_DEGREES)+Robot.drivebase.navX.getYaw();
    		encoderSetpoint=((centerY-IDEAL_center_Y)*PIXELS_TO_ENCODERS)+(Robot.drivebase.lDriveEnc.getDistance()+Robot.drivebase.rDriveEnc.getDistance())/2;
    		firstRun=false;
    	}else{}
    	SmartDashboard.putString("Encoder setpoint",""+centerY);	
    	SmartDashboard.putString("Encoder setpoint",""+encoderSetpoint);
		SmartDashboard.putString("angle setpoint",""+angleSetpoint);
		SmartDashboard.putString("Encoder error",""+""+(encoderSetpoint-(Robot.drivebase.lDriveEnc.getDistance()+Robot.drivebase.rDriveEnc.getDistance())/2));
    	if(Math.abs((Robot.drivebase.lDriveEnc.getDistance()+Robot.drivebase.rDriveEnc.getDistance())/2-encoderSetpoint)>40){
    		if(encoderSetpoint-((Robot.drivebase.lDriveEnc.getDistance()+Robot.drivebase.rDriveEnc.getDistance())/2)>0){
    			Robot.drivebase.drive(-PowerY,PowerY);
    		}
    		else{
    			Robot.drivebase.drive(PowerY,-PowerY);
    		}
    	
    		return false;
    	
    	}
    	else if (Math.abs((Robot.drivebase.lDriveEnc.getDistance()+Robot.drivebase.lDriveEnc.getDistance())/2-encoderSetpoint)>10){
    		double encoderError=encoderSetpoint-((Robot.drivebase.lDriveEnc.getDistance()+Robot.drivebase.lDriveEnc.getDistance())/2);
    		double p=encoderError*KpY;
    		double i=errorSumY*KiY;
    		double d;
    		if(!firstPIDY){
    			d=(encoderError-previousErrorY);
    		}
    		else{
    			d=0;
    		}
    		double power =p+i+d;
    		previousErrorY=encoderError;
    		errorSumY=encoderError;
    		Robot.drivebase.drive(-power, power);
    		return false;
    	}
    	else if(Math.abs(angleSetpoint-Robot.drivebase.navX.getYaw())>=8){
    		if(angleSetpoint-Robot.drivebase.navX.getYaw()>0)
    			Robot.drivebase.drive(PowerX,PowerX);
    		else
    			Robot.drivebase.drive(-PowerX,-PowerX);
    		return false;
    	}
    	else if(angleSetpoint-Robot.drivebase.navX.getYaw()>2){
    		double angleError=angleSetpoint-Robot.drivebase.navX.getYaw();
    		double p=angleError*KpX;
    		double i=errorSumX*KiX;
    		double d;
    		if(firstPIDX){
    			d=(angleError-previousErrorX);
    		}
    		else{
    			d=0;
    		}
    		double power =p+i+d;
    		previousErrorX=angleError;
    		errorSumX+=angleError;
    		Robot.drivebase.drive(power, power);
    		return false;
    	}
    	else if(Math.abs(centerX-IDEAL_center_X)>2&&Math.abs(centerY-IDEAL_center_Y)>2){
    		return true;
    	}
    	else{
    		reset();
    		return false;
    	}
    	
    
    }
    
   public void reset(){
	   firstRun=true;
	   firstPIDX=firstPIDY=false;
	   errorSumX=errorSumY=0;
   }
}
