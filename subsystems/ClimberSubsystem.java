package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
// TalonFX for our motor and ControlMode to use a percent for our motors
import com.ctre.phoenix.motorcontrol.can.TalonFX;

//import com.ctre.phoenix.motorcontrol.can.TalonFX;
//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class ClimberSubsystem extends SubsystemBase {
  
  private TalonFX leftWinch = new TalonFX(11);
  private TalonFX rightWinch = new TalonFX(12);
  public void climb(){
      leftWinch.set(ControlMode.PercentOutput, Constants.climberSpeed);
      rightWinch.follow(leftWinch);
  }
  public void retract(){
    leftWinch.set(ControlMode.PercentOutput, -Constants.climberSpeed);
    rightWinch.follow(leftWinch);
  }
  public void stop(){
    leftWinch.set(ControlMode.PercentOutput,0);
    rightWinch.follow(leftWinch);
  }
  public void leftGo(String direction){
    if (direction == "up") {
      leftWinch.set(ControlMode.PercentOutput, Constants.climberSpeed);
    }
    else if (direction == "down") {
      leftWinch.set(ControlMode.PercentOutput, -Constants.climberSpeed);
    }
  }
  public void rightGo(String direction){
    if (direction == "up"){
      rightWinch.set(ControlMode.PercentOutput, -Constants.climberSpeed);
    }
    else if (direction == "down") {
      rightWinch.set(ControlMode.PercentOutput, Constants.climberSpeed);
    }
  }
}
