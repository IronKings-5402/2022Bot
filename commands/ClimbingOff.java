package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimbingSubsystem;
import edu.wpi.first.wpilibj.Joystick;



public class ClimbingOff extends CommandBase {
    Joystick logitech = new Joystick(1);
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final ClimbingSubsystem m_ClimbingSubsystem;
    public ClimbingOff(ClimbingSubsystem subsystem) {
        m_ClimbingSubsystem = subsystem;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
      }
    @Override
    public void initialize() {}
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
      System.out.println("Climbing is Off");
      m_ClimbingSubsystem.ClimberUp(false);
    }
    public boolean isFinished() {
      return true;
    }

    
}
