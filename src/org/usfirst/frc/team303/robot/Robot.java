
package org.usfirst.frc.team303.robot;

import com.ni.vision.VisionException;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    final String defaultAuto = "Default";
    final String customAuto = "My Auto";
    static String autoSelected;
    SendableChooser chooser;
    static VictorSixDrivebase drivebase;
    static Pneumatics piston;
    static IPCam camera;
    static Timer timer  = new Timer();
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", defaultAuto);
        chooser.addObject("My Auto", customAuto);
        SmartDashboard.putData("Auto chOIces", chooser);
        
       // drivebase = new VictorSixDrivebase();
       // piston = new Pneumatics();
        timer.reset();
        timer.start();
        
        camera = new IPCam();
    }
    
	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString line to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the switch structure below with additional strings.
	 * If using the SendableChooser make sure to add them to the chooser code above as well.
	 */
    public void autonomousInit() {
    	autoSelected = (String) chooser.getSelected();
//		autoSelected = SmartDashboard.getString("Auto Selector", defaultAuto);
		System.out.println("Auto selected: " + autoSelected);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	switch(autoSelected) {
    	case customAuto:
        //Put custom auto code here   
            break;
    	case defaultAuto:
    	default:
    	//Put default auto code here
            break;
    	}
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	OI.update();
    	runCamera();
    	//drivebase.drive(OI.lStickY, OI.rStickY);
    	//piston.setPiston(OI.lStickBtn1);
    	
    	//SmartDashboard.putNumber("lStick", OI.lStickY);
    	//SmartDashboard.putNumber("rStick", OI.rStickY);
    	
    	//SmartDashboard.putNumber("pwm value 1", drivebase.F1.get());
    	//SmartDashboard.putNumber("pwm value 2", drivebase.F2.get());
    	
   
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
    public void disabledPeriodic() {
    	SmartDashboard.putNumber("time", timer.get());
    	runCamera();
    }
    
    public void runCamera() {
    	try {
			camera.runCameraServer();
		} catch (VisionException e) {}
    	
    }
    
}
