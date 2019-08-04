package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class ZZCommand extends Command {

  public ZZCommand(Vname vname, SourcePosition thePosition) {
    super(thePosition);
    this.v = vname;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitZZCommand(this, o);
  }

  public Vname v;
}
