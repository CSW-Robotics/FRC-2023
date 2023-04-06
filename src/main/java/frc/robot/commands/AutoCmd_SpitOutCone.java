// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import frc.robot.RobotContainer;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoCmd_SpitOutCone extends ParallelDeadlineGroup {
  /** Creates a new CmdGroup_DriveUntilTimeout. */
  public AutoCmd_SpitOutCone(double timeout) {
    // Add the deadline command in the super() call. Add other commands using
    // addCommands().
    super(new Cmd_WaitCommand(timeout));
    addCommands(new Cmd_ShoulderIn(new Sub_Shoulder()));
    addCommands(new Cmd_ClawCube(new Sub_Claw()));

    //addCommands(new Cmd_Drivetrain(new Sub_Drivetrain(), velocity, 0.0));
    // addCommands(new FooCommand(), new BarCommand());
  }
}