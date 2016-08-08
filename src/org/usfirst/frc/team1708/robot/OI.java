package org.usfirst.frc.team1708.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1708.robot.subsystems.CompressorSub;
import org.usfirst.frc.team1708.robot.subsystems.DriveTrain;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 * Z Was Here
 */
@SuppressWarnings("unused")
public class OI {
	static RobotDrive robodrive;
	static Joystick joystick,joystick2;
	static Solenoid arm;
	static int lol = 0;
	static Compressor comp;
	static AnalogInput press;
	//static Talon intake1, intake2, shoot, shoot2;
	public static DigitalInput switcher;
	public static Solenoid solerflare;
	public static AnalogGyro gyor;
	public static AnalogInput acu;
	public static boolean state= false;
	static Spark shoot, shoot2;
	static Victor Intake;//,intake2;
	static Encoder encoder;
	
	public OI(){
		comp = new Compressor();
		joystick = new Joystick(0);
		
		
		joystick2 = new Joystick(1);
		gyor = new AnalogGyro(1);
		gyor.setSensitivity(1.65);
		robodrive = new RobotDrive(0,1,2,3);
		//Joybut = new JoystickButton(joystick,3);
		//Joybut.whileHeld(new ExampleCommand());
		encoder = new Encoder(0,7,false,EncodingType.k2X);
		press = new AnalogInput(0);
		Intake = new Victor(5);
		
		//acu = new AnalogInput(0);
		//acu.resetAccumulator();
		//acu.setAccumulatorDeadband(9);
		//acu.setAccumulatorInitialValue(0);
		//acu.setOversampleBits(1);
		//acu.setAverageBits(4);
		//acu.setAccumulatorCenter(10);
		// = new Solenoid(7);
		/*
		shoot = new Talon(4); ///I PUT SPARKS BACK IN TO TEST SHOT
		shoot2 = new Talon(9);
		intake1 = new Talon(8);
		intake2 = new Talon(3);
		*/
		switcher = new DigitalInput(1);
		
		//intake1 = new Victor(8);
		//intake2 = new Victor(3);
		//shoot = new Spark(4);
		//shoot2 = new Spark(9);
		
		//shift = new DoubleSolenoid(6, 7);
		arm = new Solenoid(0);
		
	}
	
	//FREE BUTTONS: 4 , 8
	public static void ArcadeDrive(){/////I PUT DRIVE AT TOP BECAUSE THIS IS WHERE OUR MAIN PROBLEM IS
		//robodrive.arcadeDrive(-joystick.getRawAxis(1), -joystick.getRawAxis(2));  ///INVERTED BOTH MOTORS TO DRIVE CORRECT WAY
		//robodrive.arcadeDrive(-joystick.getRawAxis(1)*2, -joystick.getRawAxis(2)*2);
		robodrive.arcadeDrive(-joystick.getRawAxis(1),-joystick.getRawAxis(2));
		//robodrive.tankDrive(-joystick.getRawAxis(1),-joystick.getRawAxis(2));
	}
	
	//public static void HalfDrive(){/////SAME WITH THIS SINCE ITS DRIVE
	//robodrive.arcadeDrive(-joystick.getRawAxis(1)/2, -joystick.getRawAxis(2)/2);
	//}
	
	
	public static void RamUsed(){
		if (joystick2.getRawButton(6)){
			arm.set(true);
		}
		else if(joystick2.getRawButton(5)){
			arm.set(false);
		}
	}
	
	public static void intake(){
		if(joystick.getRawButton(8)){
		//	intake1.set(-1.0);
			//intake2.set(-1.0);
			Intake.set(.75);
		}
		else if(joystick.getRawButton(7)){
			//intake1.set(1.0);
			//intake2.set(1.0);
			Intake.set(-1.0);
		}else{
			//intake1.set(0);
			//intake2.set(0);
			Intake.set(0);
		}
	}
	/*
	public static void Pancakes(){
		if(joystick2.getRawButton(3)){
			solerflare.set(true);
		}
		 if(joystick2.getRawButton(4)){
		
			solerflare.set(false);
		}
	}
	*/
	/*
	public static void Launch(){
		if(joystick2.getRawButton(8)){
    		shoot.set(-1.0);
    		shoot2.set(-1.0);
    	}else if(joystick2.getRawButton(7)){
    		shoot.set(1.0);
    		shoot2.set(1.0);
    	}
    	else{
    		shoot.set(0);
    		shoot2.set(0);
    	}
		
	}
	*/
	

		
	public  static RobotDrive returnRobotDrive(){
		return robodrive;
	}
	public static Joystick returnJoystick(){
		return joystick;
	}
	
	

	public static void pubGyro(){
		 double angleGyro = gyor.getAngle();	/////IMPLEMENTED FOR ANGLE VALUE STUFF
		 SmartDashboard.putNumber("GyroAngle", (angleGyro));
}
	public static Encoder returnEncoder(){
		return encoder;
	}
	public static void showPressure(){
		press.getLSBWeight();
		SmartDashboard.putNumber("Air Pressure", press.getValue()/18);
	}
	 public static void resetGyro(){
	    	gyor.reset();
	    }
	 /*
	 public static Solenoid returnPancakes(){
		 return solerflare;
	 }
	 */
	 public static AnalogGyro returnGyro(){
		 return gyor;
	 }
	 public static void CustomCompressor(){
		 press.getLSBWeight();
		 double com = press.getValue()/18;
		 if(com < 110.000){
			comp.setClosedLoopControl(true);
		 }
		
	 }
	 public static Solenoid returnArm(){
		 return arm;
	 }
//////////////////////COMMANDS/////////////////////////////	
}