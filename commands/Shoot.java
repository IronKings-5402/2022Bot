package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.ShootingSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
/** An example command that uses an example subsystem. */
public class Shoot extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ShootingSubsystem m_ShootingSubsystem;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public Shoot(ShootingSubsystem subsystem) {
    m_ShootingSubsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
     m_ShootingSubsystem.setShooter(true);
  }
  @Override
  public boolean isFinished() {
    if (m_ShootingSubsystem.getVelocity() < Constants.velocityThreshold){
      return true;
    }
    else {return false;}
  }
  // Called once the command ends or is interrupted.
}