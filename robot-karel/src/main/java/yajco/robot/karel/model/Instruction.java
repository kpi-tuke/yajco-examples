package yajco.robot.karel.model;

import yajco.robot.karel.runtime.World;

public abstract class Instruction extends Statement {
    protected void printInfo(World world) {
        System.out.println("----------------------------------------------------------------------------------");
        world.print();
        System.out.println("Karel: " + world.getKarel());
        System.out.println("Executing: " + getClass().getName());
        System.out.println();
    }
}
