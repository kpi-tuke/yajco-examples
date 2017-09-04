package yajco.example.desk.model;

import yajco.annotation.reference.References;

public class ConstUsage extends Factor {
    private Constant constant;

    public ConstUsage(@References(Constant.class) String name) {
    }

    @Override
    public int getValue() {
        return getConstant().getValue();
    }

    /**
     * @return the constant
     */
    public Constant getConstant() {
        return constant;
    }

}
