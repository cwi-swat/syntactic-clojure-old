module lang::synclj::compile::Eval

import lang::clojure::syntax::Clojure;


data Var = var(str ns, str name);



public Result eval(Form* forms, ModEnv mods, Env env) {
   result = nil();
   ns = "user";
   for (Form f <- forms) {
     <ns, env, val> = eval(ns, f, env);
   }
   
}

public Result eval(str namespace, Form form, Env env) {

} 