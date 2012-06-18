module lang::clojure::check::Check

import lang::clojure::syntax::Clojure;
import Message;
import ParseTree;
import IO;

public start[File] check(start[File] pt) = checkQuoting(pt);

public start[File] checkQuoting(start[File] pt) {
  errs = {};
  top-down-break visit(pt) {
    case Form f: errs += checkQuotingRec(f, 0);
  }
  return pt[@messages=errs];
}

public set[Message] checkQuotingRec(Form form, int qq) {
   errs = {};

   Form handleQQ(Form f) {
     println("NESTING: <qq>");
     errs += checkQuotingRec(f.arg, qq + 1);
     return f;
   }

   Form handleUQ(Form f) {
     if (qq > 0) {
       println("NESTING: <qq>");
       errs += checkQuotingRec(f.arg, qq - 1);
     }
     else {
       println("Error: <f@\loc>");
       qloc = f@\loc;
       qloc.length = 1;
       qloc.end.line = qloc.begin.line;
       qloc.end.column = qloc.begin.column + 1;
       errs += {error("Invalid unquote", qloc)};
       checkQuotingRec(f.arg, qq);
     }
     return f;
   }

   top-down-break visit (form) {
     case Form f => handleQQ(f)
       when f is qquote
     case Form f => handleUQ(f)
       when f is unquote || f is unquotes 
   }
   return errs;
} 