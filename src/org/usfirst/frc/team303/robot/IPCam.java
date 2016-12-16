package org.usfirst.frc.team303.robot;

import edu.wpi.first.wpilibj.vision.AxisCamera;
import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.Rect;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import org.opencv.imgproc.Imgproc;

import java.io.IOException;

public class IPCam {
	
	double globalCenterY;
	double globalCenterX;
	Image frame;
	Rect overlay;
	CameraServer server;
	AxisCamera cam;
	NetworkTable table;
	double[] defaultValue = new double[0];
	NIVision.Rect rect;
	Grip grip= new Grip();
	Mat m= new Mat();
	VideoCapture vcap = new VideoCapture();
	
	public IPCam() {
		
		vcap.open("http://10.3.3.5/mjpg/video.mjpg");
		cam = new AxisCamera("10.3.3.5");
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
		//overlay = new NIVision.Rect()
		rect = new NIVision.Rect(10, 10, 100, 100);
		//server.startAutomaticCapture("cam0");
		
		
		
	}
	
	public void runCameraServer() {
		cam.getImage(frame);
		NIVision.imaqDrawShapeOnImage(frame, frame, rect, DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, 0.0f);
		CameraServer.getInstance().setImage(frame);
		vcap.read(m);
		grip.setsource0(m);
	}
	
	public double[] getGoal() {
		return grip.process();
	}
	
	
}
