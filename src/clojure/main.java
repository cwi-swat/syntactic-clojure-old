/* TODO:
 * 
 * rebind load/read
 * 
 */

package clojure;

import clojure.lang.Symbol;
import clojure.lang.Var;
import clojure.lang.RT;

public class main {

	final static private Symbol CLOJURE_MAIN = Symbol.intern("clojure.main");
	final static private Var REQUIRE = RT.var("clojure.core", "require");
	final static private Var LEGACY_REPL = RT.var("clojure.main", "legacy-repl");
	final static private Var LEGACY_SCRIPT = RT.var("clojure.main", "legacy-script");
	final static private Var MAIN = RT.var("clojure.main", "main");

	public static void legacy_repl(String[] args) {
		REQUIRE.invoke(CLOJURE_MAIN);
		LEGACY_REPL.invoke(RT.seq(args));
	}

	public static void legacy_script(String[] args) {
		REQUIRE.invoke(CLOJURE_MAIN);
		LEGACY_SCRIPT.invoke(RT.seq(args));
	}

	public static void main(String[] args) {
		REQUIRE.invoke(CLOJURE_MAIN);
		MAIN.applyTo(RT.seq(args));
	}
}
