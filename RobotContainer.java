package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ClimberDown;
import frc.robot.commands.ClimberUp;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.DriveForward;
import frc.robot.commands.FrontIntakeDown;
import frc.robot.commands.FrontIntakeUp;
import frc.robot.commands.IntakeOff;
import frc.robot.commands.IntakeOn;
import frc.robot.commands.LiftForward;
import frc.robot.commands.LiftReverse;
import frc.robot.commands.Reverse;
import frc.robot.commands.Shoot;
import frc.robot.commands.ShooterOff;
import frc.robot.commands.StopIntake;
import frc.robot.commands.DistanceToggle;
import frc.robot.commands.IntakeBallsCommand;
import frc.robot.commands.LeftGo;
import frc.robot.commands.LeftGoDown;
import frc.robot.commands.RightGo;
import frc.robot.commands.RightGoDown;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.FrontIntakeSubsystem;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.PhneumaticsSubsystem;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
import frc.robot.subsystems.ShootingSubsystem;
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();

  private final DriveCommand m_driveCommand = new DriveCommand(m_driveSubsystem);

  private final IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();

  private final IntakeBallsCommand m_intakeBallsCommand = new IntakeBallsCommand(m_intakeSubsystem);

  private final FrontIntakeSubsystem m_frontIntakeSubsystem = new FrontIntakeSubsystem();

  private final ShootingSubsystem m_shootingSubsystem = new ShootingSubsystem();

  private final ClimberSubsystem m_climberSubsystem = new ClimberSubsystem();

  private final PhneumaticsSubsystem m_phneumaticsSubsystem = new PhneumaticsSubsystem();

  private final FrontIntakeUp m_frontIntakeUp = new FrontIntakeUp(m_frontIntakeSubsystem);
  private final FrontIntakeDown m_frontIntakeDown = new FrontIntakeDown(m_frontIntakeSubsystem);
  private final IntakeOn m_intakeOn = new IntakeOn(m_frontIntakeSubsystem);
  private final Shoot m_shoot = new Shoot(m_shootingSubsystem);
  private final ShooterOff m_shooterOff = new ShooterOff(m_shootingSubsystem);
  private final IntakeOff m_intakeOff = new IntakeOff(m_frontIntakeSubsystem);
  private final Reverse m_reverse = new Reverse(m_intakeSubsystem,m_frontIntakeSubsystem);
  private final StopIntake m_stopInnerIntake = new StopIntake(m_intakeSubsystem);
  private final DistanceToggle m_distanceToggle = new DistanceToggle(m_shootingSubsystem);
  private final ClimberUp m_climberUp = new ClimberUp(m_climberSubsystem);
  private final ClimberDown m_climberDown = new ClimberDown(m_climberSubsystem);
  private final LiftForward m_liftForward = new LiftForward(m_phneumaticsSubsystem);
  private final LiftReverse m_liftReverse = new LiftReverse(m_phneumaticsSubsystem);
  private final LeftGo m_leftGo = new LeftGo(m_climberSubsystem);
  private final RightGo m_rightGo = new RightGo(m_climberSubsystem);
  private final LeftGoDown m_leftGoDown = new LeftGoDown(m_climberSubsystem);
  private final RightGoDown m_rightGoDown = new RightGoDown(m_climberSubsystem);
  
//  private final SequentialCommandGroup AutoCommand = new SequentialCommandGroup(new FrontIntakeDown(m_FrontintakeSubsystem), new IntakeOn(m_FrontintakeSubsystem), new intakeBallsCommand(m_intakeSubsystem), new DriveForward(m_driveSubsystem), new IntakeOff(m_FrontintakeSubsystem),new FrontIntakeUp(m_FrontintakeSubsystem),new TurnBot(m_driveSubsystem),new Aim(m_ShootingSubsystem), new Shoot(m_ShootingSubsystem));
private final SequentialCommandGroup autoCommand = new SequentialCommandGroup(new IntakeBallsCommand(m_intakeSubsystem), new Shoot(m_shootingSubsystem), new WaitCommand(5), new DriveForward(m_driveSubsystem), new ShooterOff(m_shootingSubsystem));

  private Joystick xbox = new Joystick(0);
  private Joystick logitech = new Joystick(1);
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    m_driveSubsystem.setDefaultCommand(m_driveCommand);
    JoystickButton buttonRB = new JoystickButton(xbox, 6);
    JoystickButton buttonLB = new JoystickButton(xbox, 5);
    JoystickButton buttonTrigger = new JoystickButton(logitech, 1);
    JoystickButton button3 = new JoystickButton(logitech, 3);
    JoystickButton button4 = new JoystickButton(logitech, 4);
    POVButton logiUp = new POVButton(logitech, 0);
    POVButton LogiDown = new POVButton(logitech, 180);
    JoystickButton button9 = new JoystickButton(logitech, 9);
    JoystickButton button10 = new JoystickButton(logitech, 10);
    JoystickButton button11 = new JoystickButton(logitech, 11);
    JoystickButton button12 = new JoystickButton(logitech, 12);
    JoystickButton buttonA = new JoystickButton(xbox, 1);
    JoystickButton buttonB = new JoystickButton(xbox, 2);
    JoystickButton buttonX = new JoystickButton(xbox, 3);
    JoystickButton buttonY = new JoystickButton(xbox, 4);
    JoystickAnalogButton leftAxis = new JoystickAnalogButton(xbox, 2, .5);
    JoystickAnalogButton rightAxis = new JoystickAnalogButton(xbox, 3, .5);

    logiUp
      .whileActiveContinuous(m_frontIntakeUp);
    LogiDown
      .whileActiveContinuous(m_frontIntakeDown);
    button10
      .whenPressed(m_intakeOn);
    button9
      .whenPressed(m_intakeOff);
    button3
      .whenPressed(m_reverse);
    buttonTrigger
      .whileActiveContinuous(m_shoot);
    buttonTrigger
      .whenReleased(m_shooterOff);
    button12
      .whenPressed(m_intakeBallsCommand);
    button11
      .whenPressed(m_stopInnerIntake);
    button4
      .whenPressed(m_distanceToggle);
    buttonY
      .whenHeld(m_climberUp);
    buttonX
      .whenHeld(m_climberDown);
    buttonA
      .whenPressed(m_liftForward);
    buttonB
      .whenPressed(m_liftReverse);
    buttonLB
      .whenHeld(m_leftGo);
    buttonRB
      .whenHeld(m_rightGo);
    leftAxis
      .whenHeld(m_leftGoDown);
    rightAxis
      .whenHeld(m_rightGoDown);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public SequentialCommandGroup getAuto(){
    return autoCommand;
  }
}