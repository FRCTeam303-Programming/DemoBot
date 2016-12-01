package org.usfirst.frc.team303.robot;
import edu.wpi.first.wpilibj.vision.AxisCamera;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.Rect;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
public class IPCam {
	
	Image frame;
	Rect overlay;
	CameraServer server;
	AxisCamera cam;
	NetworkTable table;
	double[] defaultValue = new double[0];
	NIVision.Rect rect;
	
	public IPCam() {
		cam = new AxisCamera("10.3.3.11");
		table = NetworkTable.getTable("GRIP/goal");
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
		//overlay = new NIVision.Rect()
		rect = new NIVision.Rect(10, 10, 100, 100);
		//server.startAutomaticCapture("cam0");
	}
	
	public void runCameraServer() {
		cam.getImage(frame);
		NIVision.imaqDrawShapeOnImage(frame, frame, rect, DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, 0.0f);
		CameraServer.getInstance().setImage(frame);
	}
	
	public double getGoalArea(int arrayNumber) {
		double[] areas = table.getNumberArray("area", defaultValue);
		return areas[arrayNumber];
	}
	
}
