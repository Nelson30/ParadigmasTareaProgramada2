package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class AddCommand extends Command {
    public AddCommand(Identifier ident, IntegerLiteral il, SourcePosition thePosition) {
        super (thePosition);
        Ident = ident;
        IL = il;
    }

    public Object visit(Visitor v, Object o) {
        return v.visitAddCommand(this, o);
    }

    public Identifier Ident;
    public IntegerLiteral IL;

    public Vname v;
}