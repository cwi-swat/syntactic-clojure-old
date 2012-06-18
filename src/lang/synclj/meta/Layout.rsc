module lang::synclj::meta::Layout

layout Meta 
  = MetaWhitespaceOrComment* !>> [\ \t\n\f\r] !>> ";";
  
syntax MetaWhitespaceOrComment 
  = whitespace: MetaWhitespace
  | comment: MetaComment
  ; 

lexical MetaComment = @category="Comment" ";" ![\n\r]* $;
  
lexical MetaWhitespace = [\ \t\n\f\r]; 