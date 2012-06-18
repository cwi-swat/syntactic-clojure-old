module lang::clojure::syntax::Layout
  
layout Standard 
  = WhitespaceOrComment* !>> [\ \t\n\f\r,] !>> ";";
  
syntax WhitespaceOrComment 
  = whitespace: Whitespace
  | comment: Comment
  ; 

lexical Comment = @category="Comment" ";" ![\n\r]* $;
  
lexical Whitespace = [\ \t\n\f\r,]; 


