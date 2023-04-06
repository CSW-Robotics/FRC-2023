package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Sub_Claw;

public class Cmd_ClawStop extends CommandBase {

    private final Sub_Claw m_sub_Claw;

    public Cmd_ClawStop(Sub_Claw subsystem) {

        m_sub_Claw = subsystem;
        addRequirements(m_sub_Claw);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        m_sub_Claw.Claw_Stop();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_sub_Claw.Claw_Stop();
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
