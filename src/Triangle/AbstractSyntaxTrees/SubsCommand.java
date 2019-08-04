package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class SubsCommand extends Command {
    public SubsCommand(Identifier ident, IntegerLiteral il, SourcePosition thePosition) {
        super (thePosition);
        Ident = ident;
        IL = il;
    }

    public Object visit(Visitor v, Object o) {
        return v.visitSubsCommand(this, o);
    }

    public Identifier Ident;
    public IntegerLiteral IL;

    public Vname v;
}