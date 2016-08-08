package org.usfirst.frc.team1708.robot.subsystems;

import java.util.Queue;
import java.util.Stack;

import org.usfirst.frc.team1708.robot.OI;
import org.usfirst.frc.team1708.robot.Robot;
import org.usfirst.frc.team1708.robot.commands.TheDrive;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
@SuppressWarnings("unused")
public class DriveTrain extends Subsystem {
	private static boolean state = false;
	public static Stack<String> stack;
	public static double Kp = 0.03;
	CameraServer cam;
	public DriveTrain(){
		
	}
	   
    public void initDefaultCommand() {
        setDefaultCommand(new TheDrive());
    	    
    }
    
//////////////////////COMMANDS/////////////////////////////    
    public static void SetArcadeDrive(){
    	OI.showPressure();
    	//OI.Pancakes();
   	  	OI.returnRobotDrive().arcadeDrive(OI.returnJoystick().getRawAxis(1), -OI.returnJoystick().getRawAxis(2));
   	  	
   		// gyor.pidGet();
   		 /*
   		 if(gyor.getAngle() > .360){
   			 K -= .360;
   		 }
   		 else if(0 > K && K < -.360){
   			 gyor.reset();
   		 }
   		 SmartDashboard.putNumber("Gyro", K);
   		 */
   	 }
    /**
     * Straighten the Robot. If the Robot is a negative degree away from 0. Otherwise, if it is greater than 0, turn a negative angle until
     * it reaches 0.
     **/
    public static void StraightenBot(){
    	
    	try {
    		 if(OI.returnGyro().getAngle() < 0.00){
    		  SmartDashboard.putNumber("Auto Gyroscope", OI.returnGyro().getAngle()*1.5);
    		  OI.returnRobotDrive().tankDrive(0.5,-0.5);
    		  state = true;
    	  }
    	    if(OI.returnGyro().getAngle() > 0.00){
    		   SmartDashboard.putNumber("Auto Gyroscope", OI.returnGyro().getAngle()*1.5);
    		  OI.returnRobotDrive().tankDrive(-0.5,0.5);
    		  state = true;
    	   }
    	   while(state == false){
    		   OI.returnRobotDrive().tankDrive(0.0, 0.0);
    	   }
    	}catch(Exception e){
    		stack.push("System is not working");
    		e.printStackTrace();
    		System.out.println(stack);
    		stack.pop();
    	}
    }
    public static void ClawsDown(){
    	OI.returnArm().set(true);
    }
   public static void DelayedDrive(){
	  
	   OI.returnRobotDrive().drive(.75,(OI.returnGyro().getAngle())*Kp);
   }
    /**
     * Turn the robot in the left position until it actually reaches 90 degrees
     * */
    public static void TankTurnRight(){
    	double angle =OI.returnGyro().getAngle();
    	 state = true;
    	 SmartDashboard.putNumber("Auto Gyroscope", angle);
    	 if(angle < -0.032){
     		  //SmartDashboard.putNumber("Auto Gyroscope", OI.returnGyro().getAngle());
     		  OI.returnRobotDrive().drive(0.9,1);
     		
     	  }
     
     	   while(state == false){
     		  
     		  OI.returnRobotDrive().drive(0.0, 0.0);
     	   }
    }
    /**
     * Turn the Robot until it reaches 180 degrees in the direction specified by the tank drive
     * */
    public static void turnaround(){
    	if(OI.returnGyro().getAngle() < 0.365){
   		  SmartDashboard.putNumber("Auto Gyroscope", (OI.returnGyro().getAngle())/2);
   		  OI.returnRobotDrive().tankDrive(1,1);
   		  state = true;
   	  }
   
   	   while(state == false){
   		  
   		  OI.returnRobotDrive().drive(0.0, 0.0);
   	   }
    }
    /**
     * Turn the robot until it is equal to -90. The robot turns right, So you know
     **/
    public static void TankTurnLeft(){
    	/*
    	if(true)
    		OI.returnRobotDrive().tankDrive(0.6, 0.6);
    	
    	else if(true){
    		OI.returnRobotDrive().tankDrive(0.6, 0.7);
    	}
    	*/
    	
  	  if(OI.returnGyro().getAngle() < -0.090){
  		  SmartDashboard.putNumber("Auto Gyroscope", OI.returnGyro().getAngle()*1.5);
  		  OI.returnRobotDrive().tankDrive(-0.5, 0.5);
  		  state = true;
  	  }
  	   while(state == false){
  		  
  		  OI.returnRobotDrive().drive(0.0, 0.0);
  	   };
  	  
    }
  public static void TankMoveForward(){
	  OI.returnArm().set(true);
	  OI.returnRobotDrive().tankDrive(-0.65,-0.65);
	 }
  public static void TankAutoForward(){
	  OI.returnArm().set(true);
	  OI.returnRobotDrive().tankDrive(-0.75,-0.75);
	 }
  /**
   * This method is used to Run the RoughTerrain Autonomous 
  */
  public static void TankRoughForward(){
	  OI.returnArm().set(false);
	  OI.returnRobotDrive().tankDrive(1,1);
	 double angle = OI.returnGyro().getAngle();
	 SmartDashboard.putNumber("AutoGyro",(angle)/2);
	 
  }
  
  public static void HalfDrive(){
	  OI.returnArm().set(true);
	  OI.returnRobotDrive().tankDrive(-0.7,-0.7);
  }
  
 
  
  public static void stopFunctions(){
	  OI.returnRobotDrive().tankDrive(0, 0);
	
  	 
  }
  
  public static void GyroTank(double speed,boolean isArmUp){
	  OI.returnArm().set(isArmUp);
	 double angle = OI.returnGyro().getAngle();
	  OI.returnRobotDrive().drive(speed, angle*Kp);
	  /*
	  OI.returnEncoder().setDistancePerPulse(5);
	  OI.returnEncoder().setMinRate(10);
		 while(OI.returnEncoder().getDistance() < 30){
			 OI.returnRobotDrive().tankDrive(0.5, 0.5);
		 };
		*/ 
  }
  public static void turnThisBot(){
	  OI.returnRobotDrive().drive(0.9, 1);
	  SmartDashboard.putNumber( "This is Gyor",OI.returnGyro().getAngle());
	 
  }
	  
  
  
  }
  
 
//////////////////////COMMANDS/////////////////////////////
 
  // public double getSpeed()
  //{
   //   return Math.max(Math.abs(leftEncoder.getVelocity()),  Math.abs(rightEncoder.getVelocity()));



