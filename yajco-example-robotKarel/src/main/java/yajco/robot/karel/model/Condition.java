package yajco.robot.karel.model;

import yajco.robot.karel.runtime.World;

public abstract class Condition {
    public abstract boolean eval(World world);
}
