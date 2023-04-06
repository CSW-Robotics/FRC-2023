package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Sub_Elbow;

public class Cmd_ElbowIn extends CommandBase {

    private final Sub_Elbow m_sub_Elbow;

    public Cmd_ElbowIn(Sub_Elbow subsystem) {

        m_sub_Elbow = subsystem;
        addRequirements(m_sub_Elbow);

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        m_sub_Elbow.Elbow_In();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_sub_Elbow.Elbow_Stop();
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
