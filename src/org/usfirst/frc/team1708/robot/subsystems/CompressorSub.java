package org.usfirst.frc.team1708.robot.subsystems;

import org.usfirst.frc.team1708.robot.OI;
import org.usfirst.frc.team1708.robot.commands.CompressAir;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CompressorSub extends Subsystem {
    public static Compressor com;
    
    
    CameraServer cam;
	
/*	public  void Camera(){
		cam = CameraServer.getInstance();
		cam.setQuality(30);
		cam.startAutomaticCapture("cam0");
	}
 */
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public CompressorSub(){
    	
    	com = new Compressor(0);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new CompressAir());
    }
    /**
     * Starts the Compressor and Output the Air Pressure
     * */
    public static void CompressorMethod(){
    	com.setClosedLoopControl(true);
    	OI.showPressure();
    	
    }
}


