package frc.robot.commands;

import frc.robot.subsystems.ShootingSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
/** An example command that uses an example subsystem. */
public class ShooterOff extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ShootingSubsystem m_shootingSubsystem;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ShooterOff(ShootingSubsystem subsystem) {
    m_shootingSubsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println("shooter off");
     m_shootingSubsystem.setShooter(false);
  }
  @Override
  public boolean isFinished(){
    return true;
  }
  
  // Called once the command ends or is interrupted.
}
