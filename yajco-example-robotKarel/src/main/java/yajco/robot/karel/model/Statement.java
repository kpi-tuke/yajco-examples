package yajco.robot.karel.model;

import yajco.robot.karel.runtime.World;

public abstract class Statement {
    public abstract void execute(World world);
}
