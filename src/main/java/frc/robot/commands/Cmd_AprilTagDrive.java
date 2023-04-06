package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Sub_Drivetrain;

public class Cmd_AprilTagDrive extends CommandBase {

    private final Sub_Drivetrain m_sub_Drivetrain;

    public Cmd_AprilTagDrive(Sub_Drivetrain subsystem) {

        m_sub_Drivetrain = subsystem;
        addRequirements(m_sub_Drivetrain);

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}
