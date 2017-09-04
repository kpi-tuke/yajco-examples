//package yajco.example.imperative.model.expression.assignment;
//
//import yajco.annotation.After;
//import yajco.model.pattern.impl.Associativity;
//import yajco.annotation.Operator;
//import yajco.example.imperative.machine.Machine;
//import yajco.example.imperative.model.expression.Expression;
//import yajco.example.imperative.model.expression.UnaryOperation;
//import yajco.example.imperative.model.expression.Variable;
//
//public class PostfixDecrement extends UnaryOperation {
//    @Operator(priority = 14, associativity = Associativity.NONE)
//    public PostfixDecrement(@After("MINUSMINUS") Expression expression) {
//        super(expression);
//    }
//
//    @Override
//    public long eval() {
//        String ident = ((Variable) getExpression()).getIdent();
//        long value = Machine.getInstance().getValue(ident);
//        Machine.getInstance().setValue(ident, value - 1);
//        return value;
//    }
//}
