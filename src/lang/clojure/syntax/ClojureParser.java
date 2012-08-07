package lang.clojure.syntax;

import java.io.IOException;
import java.io.StringReader;

import org.eclipse.imp.pdb.facts.type.TypeFactory;
import org.eclipse.imp.pdb.facts.IConstructor;
import org.eclipse.imp.pdb.facts.ISourceLocation;
import org.eclipse.imp.pdb.facts.IValue;
import org.eclipse.imp.pdb.facts.IValueFactory;
import org.eclipse.imp.pdb.facts.exceptions.FactTypeUseException;
import org.eclipse.imp.pdb.facts.io.StandardTextReader;
import org.rascalmpl.parser.gtd.stack.*;
import org.rascalmpl.parser.gtd.stack.filter.*;
import org.rascalmpl.parser.gtd.stack.filter.follow.*;
import org.rascalmpl.parser.gtd.stack.filter.match.*;
import org.rascalmpl.parser.gtd.stack.filter.precede.*;
import org.rascalmpl.parser.gtd.preprocessing.ExpectBuilder;
import org.rascalmpl.parser.gtd.util.IntegerKeyedHashMap;
import org.rascalmpl.parser.gtd.util.IntegerList;
import org.rascalmpl.parser.gtd.util.IntegerMap;
import org.rascalmpl.values.ValueFactoryFactory;
import org.rascalmpl.values.uptr.Factory;

@SuppressWarnings("all")
public class ClojureParser extends org.rascalmpl.library.lang.rascal.syntax.RascalRascal {
  protected final static IValueFactory VF = ValueFactoryFactory.getValueFactory();
  
  private static final IntegerMap _resultStoreIdMappings;
  private static final IntegerKeyedHashMap<IntegerList> _dontNest;
	
  protected static void _putDontNest(IntegerKeyedHashMap<IntegerList> result, int parentId, int childId) {
    IntegerList donts = result.get(childId);
    if (donts == null) {
      donts = new IntegerList();
      result.put(childId, donts);
    }
    donts.add(parentId);
  }
    
  protected int getResultStoreId(int parentId) {
    return _resultStoreIdMappings.get(parentId);
  }
    
  protected static IntegerKeyedHashMap<IntegerList> _initDontNest() {
    IntegerKeyedHashMap<IntegerList> result = org.rascalmpl.library.lang.rascal.syntax.RascalRascal._initDontNest(); 
    
    
    
   return result;
  }
    
  protected static IntegerMap _initDontNestGroups() {
    IntegerMap result = org.rascalmpl.library.lang.rascal.syntax.RascalRascal._initDontNestGroups();
    int resultStoreId = result.size();
    
    
      
    return result;
  }
  
  protected boolean hasNestingRestrictions(String name){
		return (_dontNest.size() != 0); // TODO Make more specific.
  }
    
  protected IntegerList getFilteredParents(int childId) {
		return _dontNest.get(childId);
  }
    
  // initialize priorities     
  static {
    _dontNest = _initDontNest();
    _resultStoreIdMappings = _initDontNestGroups();
  }
    
  // Production declarations
	
  private static final IConstructor prod__set_Form__lit___35_123_layouts_Standard_iter_star_seps__Form__layouts_Standard_layouts_Standard_lit___125_ = (IConstructor) _read("prod(label(\"set\",sort(\"Form\")),[lit(\"#{\"),layouts(\"Standard\"),\\iter-star-seps(sort(\"Form\"),[layouts(\"Standard\")]),layouts(\"Standard\"),lit(\"}\")],{})", Factory.Production);
  private static final IConstructor regular__seq___conditional__char_class___range__33_33_range__38_38_range__42_43_range__46_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39 = (IConstructor) _read("regular(seq([conditional(\\char-class([range(33,33),range(38,38),range(42,43),range(46,46),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]),{\\not-precede(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))}),\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),conditional(iter(\\char-class([range(39,39)])),{\\not-follow(\\char-class([range(39,39)]))})]))", Factory.Production);
  private static final IConstructor prod__Ident__opt__lit___58_conditional__iter_seps__Stem__lit___58__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_ = (IConstructor) _read("prod(lex(\"Ident\"),[opt(lit(\":\")),conditional(\\iter-seps(lex(\"Stem\"),[lit(\":\")]),{\\not-follow(\\char-class([range(33,33),range(35,36),range(38,39),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))})],{})", Factory.Production);
  private static final IConstructor prod__Char__char_class___range__92_92_lit_formfeed_ = (IConstructor) _read("prod(lex(\"Char\"),[\\char-class([range(92,92)]),lit(\"formfeed\")],{})", Factory.Production);
  private static final IConstructor prod__Stem__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__46_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39_ = (IConstructor) _read("prod(lex(\"Stem\"),[seq([conditional(\\char-class([range(45,45)]),{\\not-precede(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))}),\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(46,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]),\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),conditional(iter(\\char-class([range(39,39)])),{\\not-follow(\\char-class([range(39,39)]))})])],{})", Factory.Production);
  private static final IConstructor regular__alt___lit___35_94_lit___94 = (IConstructor) _read("regular(alt({lit(\"#^\"),lit(\"^\")}))", Factory.Production);
  private static final IConstructor prod__string_Form__String_ = (IConstructor) _read("prod(label(\"string\",sort(\"Form\")),[lex(\"String\")],{})", Factory.Production);
  private static final IConstructor prod__lit_space__char_class___range__115_115_char_class___range__112_112_char_class___range__97_97_char_class___range__99_99_char_class___range__101_101_ = (IConstructor) _read("prod(lit(\"space\"),[\\char-class([range(115,115)]),\\char-class([range(112,112)]),\\char-class([range(97,97)]),\\char-class([range(99,99)]),\\char-class([range(101,101)])],{})", Factory.Production);
  private static final IConstructor regular__seq___char_class___range__92_92_char_class___range__34_34 = (IConstructor) _read("regular(seq([\\char-class([range(92,92)]),\\char-class([range(34,34)])]))", Factory.Production);
  private static final IConstructor prod__number_Form__Number_ = (IConstructor) _read("prod(label(\"number\",sort(\"Form\")),[lex(\"Number\")],{})", Factory.Production);
  private static final IConstructor prod__Char__char_class___range__92_92_lit_space_ = (IConstructor) _read("prod(lex(\"Char\"),[\\char-class([range(92,92)]),lit(\"space\")],{})", Factory.Production);
  private static final IConstructor prod__var_Form__lit___35_39_layouts_Standard_Form_ = (IConstructor) _read("prod(label(\"var\",sort(\"Form\")),[lit(\"#\\'\\\\\"),layouts(\"Standard\"),sort(\"Form\")],{})", Factory.Production);
  private static final IConstructor prod__Comment__lit___59_conditional__iter_star__char_class___range__0_9_range__11_12_range__14_16777215__end_of_line__tag__category___67_111_109_109_101_110_116 = (IConstructor) _read("prod(lex(\"Comment\"),[lit(\";\"),conditional(\\iter-star(\\char-class([range(0,9),range(11,12),range(14,16777215)])),{\\end-of-line()})],{tag(category(\"Comment\"))})", Factory.Production);
  private static final IConstructor prod__whitespace_WhitespaceOrComment__Whitespace_ = (IConstructor) _read("prod(label(\"whitespace\",sort(\"WhitespaceOrComment\")),[lex(\"Whitespace\")],{})", Factory.Production);
  private static final IConstructor prod__Ratio__opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__47_47_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57_ = (IConstructor) _read("prod(lex(\"Ratio\"),[opt(\\char-class([range(43,43),range(45,45)])),iter(\\char-class([range(48,57)])),\\char-class([range(47,47)]),conditional(iter(\\char-class([range(48,57)])),{\\not-follow(\\char-class([range(48,57)]))})],{})", Factory.Production);
  private static final IConstructor prod__char_Form__Char_ = (IConstructor) _read("prod(label(\"char\",sort(\"Form\")),[lex(\"Char\")],{})", Factory.Production);
  private static final IConstructor regular__iter_star__char_class___range__0_9_range__11_12_range__14_16777215 = (IConstructor) _read("regular(\\iter-star(\\char-class([range(0,9),range(11,12),range(14,16777215)])))", Factory.Production);
  private static final IConstructor prod__Arg__conditional__char_class___range__37_37__not_follow__char_class___range__38_38_range__49_57_ = (IConstructor) _read("prod(lex(\"Arg\"),[conditional(\\char-class([range(37,37)]),{\\not-follow(\\char-class([range(38,38),range(49,57)]))})],{})", Factory.Production);
  private static final IConstructor prod__Symbol__Ident_lit___47_Ident_ = (IConstructor) _read("prod(lex(\"Symbol\"),[lex(\"Ident\"),lit(\"/\"),lex(\"Ident\")],{})", Factory.Production);
  private static final IConstructor prod__lit___35_123__char_class___range__35_35_char_class___range__123_123_ = (IConstructor) _read("prod(lit(\"#{\"),[\\char-class([range(35,35)]),\\char-class([range(123,123)])],{})", Factory.Production);
  private static final IConstructor prod__comment_WhitespaceOrComment__Comment_ = (IConstructor) _read("prod(label(\"comment\",sort(\"WhitespaceOrComment\")),[lex(\"Comment\")],{})", Factory.Production);
  private static final IConstructor prod__Stem__seq___conditional__char_class___range__33_33_range__38_38_range__42_43_range__46_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39_ = (IConstructor) _read("prod(lex(\"Stem\"),[seq([conditional(\\char-class([range(33,33),range(38,38),range(42,43),range(46,46),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]),{\\not-precede(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))}),\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),conditional(iter(\\char-class([range(39,39)])),{\\not-follow(\\char-class([range(39,39)]))})])],{})", Factory.Production);
  private static final IConstructor prod__regexp_Form__RegExp_ = (IConstructor) _read("prod(label(\"regexp\",sort(\"Form\")),[lex(\"RegExp\")],{})", Factory.Production);
  private static final IConstructor prod__Symbol__conditional__lit___47__not_follow__char_class___range__33_33_range__38_38_range__42_43_range__45_46_range__58_58_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_ = (IConstructor) _read("prod(lex(\"Symbol\"),[conditional(lit(\"/\"),{\\not-follow(\\char-class([range(33,33),range(38,38),range(42,43),range(45,46),range(58,58),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),\\not-precede(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))})],{})", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_57_range__65_90_range__97_122 = (IConstructor) _read("regular(iter(\\char-class([range(48,57),range(65,90),range(97,122)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_57_range__65_70_range__97_102 = (IConstructor) _read("regular(iter(\\char-class([range(48,57),range(65,70),range(97,102)])))", Factory.Production);
  private static final IConstructor regular__iter_seps__Stem__lit___58 = (IConstructor) _read("regular(\\iter-seps(lex(\"Stem\"),[lit(\":\")]))", Factory.Production);
  private static final IConstructor regular__iter_star__char_class___range__48_57 = (IConstructor) _read("regular(\\iter-star(\\char-class([range(48,57)])))", Factory.Production);
  private static final IConstructor prod__Integer__opt__char_class___range__43_43_range__45_45_IntValue_opt__char_class___range__78_78_ = (IConstructor) _read("prod(lex(\"Integer\"),[opt(\\char-class([range(43,43),range(45,45)])),lex(\"IntValue\"),opt(\\char-class([range(78,78)]))],{})", Factory.Production);
  private static final IConstructor prod__lit___59__char_class___range__59_59_ = (IConstructor) _read("prod(lit(\";\"),[\\char-class([range(59,59)])],{})", Factory.Production);
  private static final IConstructor prod__layouts_$BACKTICKS__ = (IConstructor) _read("prod(layouts(\"$BACKTICKS\"),[],{})", Factory.Production);
  private static final IConstructor prod__lit___58__char_class___range__58_58_ = (IConstructor) _read("prod(lit(\":\"),[\\char-class([range(58,58)])],{})", Factory.Production);
  private static final IConstructor regular__opt__char_class___range__48_57 = (IConstructor) _read("regular(opt(\\char-class([range(48,57)])))", Factory.Production);
  private static final IConstructor regular__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57 = (IConstructor) _read("regular(seq([\\char-class([range(69,69),range(101,101)]),opt(\\char-class([range(43,43),range(45,45)])),conditional(iter(\\char-class([range(48,57)])),{\\not-follow(\\char-class([range(48,57)]))})]))", Factory.Production);
  private static final IConstructor prod__Char__char_class___range__92_92_lit_backspace_ = (IConstructor) _read("prod(lex(\"Char\"),[\\char-class([range(92,92)]),lit(\"backspace\")],{})", Factory.Production);
  private static final IConstructor prod__Arg__char_class___range__37_37_char_class___range__38_38_ = (IConstructor) _read("prod(lex(\"Arg\"),[\\char-class([range(37,37)]),\\char-class([range(38,38)])],{})", Factory.Production);
  private static final IConstructor regular__opt__char_class___range__43_43_range__45_45 = (IConstructor) _read("regular(opt(\\char-class([range(43,43),range(45,45)])))", Factory.Production);
  private static final IConstructor prod__lit___126_64__char_class___range__126_126_char_class___range__64_64_ = (IConstructor) _read("prod(lit(\"~@\"),[\\char-class([range(126,126)]),\\char-class([range(64,64)])],{})", Factory.Production);
  private static final IConstructor prod__lit_newline__char_class___range__110_110_char_class___range__101_101_char_class___range__119_119_char_class___range__108_108_char_class___range__105_105_char_class___range__110_110_char_class___range__101_101_ = (IConstructor) _read("prod(lit(\"newline\"),[\\char-class([range(110,110)]),\\char-class([range(101,101)]),\\char-class([range(119,119)]),\\char-class([range(108,108)]),\\char-class([range(105,105)]),\\char-class([range(110,110)]),\\char-class([range(101,101)])],{})", Factory.Production);
  private static final IConstructor regular__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39 = (IConstructor) _read("regular(seq([conditional(\\char-class([range(45,45)]),{\\not-precede(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))}),conditional(iter(\\char-class([range(39,39)])),{\\not-follow(\\char-class([range(39,39)]))})]))", Factory.Production);
  private static final IConstructor prod__qquote_Form__lit___96_layouts_Standard_arg_Form_ = (IConstructor) _read("prod(label(\"qquote\",sort(\"Form\")),[lit(\"`\"),layouts(\"Standard\"),label(\"arg\",sort(\"Form\"))],{})", Factory.Production);
  private static final IConstructor prod__empty__ = (IConstructor) _read("prod(empty(),[],{})", Factory.Production);
  private static final IConstructor prod__unquotes_Form__lit___126_64_layouts_Standard_arg_Form_ = (IConstructor) _read("prod(label(\"unquotes\",sort(\"Form\")),[lit(\"~@\"),layouts(\"Standard\"),label(\"arg\",sort(\"Form\"))],{})", Factory.Production);
  private static final IConstructor prod__layouts_$default$__ = (IConstructor) _read("prod(layouts(\"$default$\"),[],{})", Factory.Production);
  private static final IConstructor prod__Stem__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_ = (IConstructor) _read("prod(lex(\"Stem\"),[seq([conditional(\\char-class([range(45,45)]),{\\not-precede(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))}),\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]),conditional(\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),{\\not-follow(\\char-class([range(33,33),range(35,36),range(38,39),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))})])],{})", Factory.Production);
  private static final IConstructor prod__lit___41__char_class___range__41_41_ = (IConstructor) _read("prod(lit(\")\"),[\\char-class([range(41,41)])],{})", Factory.Production);
  private static final IConstructor prod__lit___40__char_class___range__40_40_ = (IConstructor) _read("prod(lit(\"(\"),[\\char-class([range(40,40)])],{})", Factory.Production);
  private static final IConstructor regular__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124 = (IConstructor) _read("regular(seq([conditional(\\char-class([range(45,45)]),{\\not-precede(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))}),\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]),conditional(\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),{\\not-follow(\\char-class([range(33,33),range(35,36),range(38,39),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))})]))", Factory.Production);
  private static final IConstructor prod__lit___35_95__char_class___range__35_35_char_class___range__95_95_ = (IConstructor) _read("prod(lit(\"#_\"),[\\char-class([range(35,35)]),\\char-class([range(95,95)])],{})", Factory.Production);
  private static final IConstructor prod__start__File__layouts_Standard_top_File_layouts_Standard_ = (IConstructor) _read("prod(start(sort(\"File\")),[layouts(\"Standard\"),label(\"top\",sort(\"File\")),layouts(\"Standard\")],{})", Factory.Production);
  private static final IConstructor prod__lit___35_94__char_class___range__35_35_char_class___range__94_94_ = (IConstructor) _read("prod(lit(\"#^\"),[\\char-class([range(35,35)]),\\char-class([range(94,94)])],{})", Factory.Production);
  private static final IConstructor prod__FloatValue__iter__char_class___range__48_57_char_class___range__46_46_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57_ = (IConstructor) _read("prod(lex(\"FloatValue\"),[iter(\\char-class([range(48,57)])),\\char-class([range(46,46)]),conditional(iter(\\char-class([range(48,57)])),{\\not-follow(\\char-class([range(48,57)]))}),opt(seq([\\char-class([range(69,69),range(101,101)]),opt(\\char-class([range(43,43),range(45,45)])),conditional(iter(\\char-class([range(48,57)])),{\\not-follow(\\char-class([range(48,57)]))})]))],{})", Factory.Production);
  private static final IConstructor prod__lit_formfeed__char_class___range__102_102_char_class___range__111_111_char_class___range__114_114_char_class___range__109_109_char_class___range__102_102_char_class___range__101_101_char_class___range__101_101_char_class___range__100_100_ = (IConstructor) _read("prod(lit(\"formfeed\"),[\\char-class([range(102,102)]),\\char-class([range(111,111)]),\\char-class([range(114,114)]),\\char-class([range(109,109)]),\\char-class([range(102,102)]),\\char-class([range(101,101)]),\\char-class([range(101,101)]),\\char-class([range(100,100)])],{})", Factory.Production);
  private static final IConstructor prod__File__iter_star_seps__Form__layouts_Standard_ = (IConstructor) _read("prod(sort(\"File\"),[\\iter-star-seps(sort(\"Form\"),[layouts(\"Standard\")])],{})", Factory.Production);
  private static final IConstructor prod__lit___47__char_class___range__47_47_ = (IConstructor) _read("prod(lit(\"/\"),[\\char-class([range(47,47)])],{})", Factory.Production);
  private static final IConstructor prod__StrChar__char_class___range__0_33_range__35_91_range__93_16777215_ = (IConstructor) _read("prod(lex(\"StrChar\"),[\\char-class([range(0,33),range(35,91),range(93,16777215)])],{})", Factory.Production);
  private static final IConstructor prod__StrChar__char_class___range__92_92_char_class___range__48_51_char_class___range__48_55_char_class___range__48_55_ = (IConstructor) _read("prod(lex(\"StrChar\"),[\\char-class([range(92,92)]),\\char-class([range(48,51)]),\\char-class([range(48,55)]),\\char-class([range(48,55)])],{})", Factory.Production);
  private static final IConstructor prod__discard_Form__lit___35_95_layouts_Standard_Form_ = (IConstructor) _read("prod(label(\"discard\",sort(\"Form\")),[lit(\"#_\"),layouts(\"Standard\"),sort(\"Form\")],{})", Factory.Production);
  private static final IConstructor prod__list_Form__lit___40_layouts_Standard_iter_star_seps__Form__layouts_Standard_layouts_Standard_lit___41_ = (IConstructor) _read("prod(label(\"list\",sort(\"Form\")),[lit(\"(\"),layouts(\"Standard\"),\\iter-star-seps(sort(\"Form\"),[layouts(\"Standard\")]),layouts(\"Standard\"),lit(\")\")],{})", Factory.Production);
  private static final IConstructor regular__alt___char_class___range__0_33_range__35_16777215_seq___char_class___range__92_92_char_class___range__34_34 = (IConstructor) _read("regular(alt({\\char-class([range(0,33),range(35,16777215)]),seq([\\char-class([range(92,92)]),\\char-class([range(34,34)])])}))", Factory.Production);
  private static final IConstructor prod__Stem__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39_ = (IConstructor) _read("prod(lex(\"Stem\"),[seq([conditional(\\char-class([range(45,45)]),{\\not-precede(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))}),conditional(iter(\\char-class([range(39,39)])),{\\not-follow(\\char-class([range(39,39)]))})])],{})", Factory.Production);
  private static final IConstructor prod__IntValue__char_class___range__48_48_conditional__iter__char_class___range__48_55__not_follow__char_class___range__48_55_ = (IConstructor) _read("prod(lex(\"IntValue\"),[\\char-class([range(48,48)]),conditional(iter(\\char-class([range(48,55)])),{\\not-follow(\\char-class([range(48,55)]))})],{})", Factory.Production);
  private static final IConstructor prod__Stem__seq___conditional__char_class___range__33_33_range__38_38_range__42_43_range__46_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_ = (IConstructor) _read("prod(lex(\"Stem\"),[seq([conditional(\\char-class([range(33,33),range(38,38),range(42,43),range(46,46),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]),{\\not-precede(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))}),conditional(\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),{\\not-follow(\\char-class([range(33,33),range(35,36),range(38,39),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))})])],{})", Factory.Production);
  private static final IConstructor prod__lit___39__char_class___range__39_39_ = (IConstructor) _read("prod(lit(\"\\'\\\\\"),[\\char-class([range(39,39)])],{})", Factory.Production);
  private static final IConstructor prod__lit_return__char_class___range__114_114_char_class___range__101_101_char_class___range__116_116_char_class___range__117_117_char_class___range__114_114_char_class___range__110_110_ = (IConstructor) _read("prod(lit(\"return\"),[\\char-class([range(114,114)]),\\char-class([range(101,101)]),\\char-class([range(116,116)]),\\char-class([range(117,117)]),\\char-class([range(114,114)]),\\char-class([range(110,110)])],{})", Factory.Production);
  private static final IConstructor prod__arg_Form__Arg_ = (IConstructor) _read("prod(label(\"arg\",sort(\"Form\")),[lex(\"Arg\")],{})", Factory.Production);
  private static final IConstructor prod__RegExp__char_class___range__35_35_char_class___range__34_34_iter_star__alt___char_class___range__0_33_range__35_16777215_seq___char_class___range__92_92_char_class___range__34_34_char_class___range__34_34_ = (IConstructor) _read("prod(lex(\"RegExp\"),[\\char-class([range(35,35)]),\\char-class([range(34,34)]),\\iter-star(alt({\\char-class([range(0,33),range(35,16777215)]),seq([\\char-class([range(92,92)]),\\char-class([range(34,34)])])})),\\char-class([range(34,34)])],{})", Factory.Production);
  private static final IConstructor prod__deref_Form__lit___64_layouts_Standard_Form_ = (IConstructor) _read("prod(label(\"deref\",sort(\"Form\")),[lit(\"@\"),layouts(\"Standard\"),sort(\"Form\")],{})", Factory.Production);
  private static final IConstructor prod__lit___91__char_class___range__91_91_ = (IConstructor) _read("prod(lit(\"[\"),[\\char-class([range(91,91)])],{})", Factory.Production);
  private static final IConstructor regular__iter_star__StrChar = (IConstructor) _read("regular(\\iter-star(lex(\"StrChar\")))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__39_39 = (IConstructor) _read("regular(iter(\\char-class([range(39,39)])))", Factory.Production);
  private static final IConstructor prod__lit___94__char_class___range__94_94_ = (IConstructor) _read("prod(lit(\"^\"),[\\char-class([range(94,94)])],{})", Factory.Production);
  private static final IConstructor regular__seq___conditional__char_class___range__33_33_range__38_38_range__42_43_range__46_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124 = (IConstructor) _read("regular(seq([conditional(\\char-class([range(33,33),range(38,38),range(42,43),range(46,46),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]),{\\not-precede(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))}),conditional(\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),{\\not-follow(\\char-class([range(33,33),range(35,36),range(38,39),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))})]))", Factory.Production);
  private static final IConstructor prod__StrChar__char_class___range__92_92_char_class___range__34_34_range__92_92_range__98_98_range__102_102_range__110_110_range__114_114_range__116_116_ = (IConstructor) _read("prod(lex(\"StrChar\"),[\\char-class([range(92,92)]),\\char-class([range(34,34),range(92,92),range(98,98),range(102,102),range(110,110),range(114,114),range(116,116)])],{})", Factory.Production);
  private static final IConstructor prod__fn_Form__lit___35_40_layouts_Standard_iter_star_seps__Form__layouts_Standard_layouts_Standard_lit___41_ = (IConstructor) _read("prod(label(\"fn\",sort(\"Form\")),[lit(\"#(\"),layouts(\"Standard\"),\\iter-star-seps(sort(\"Form\"),[layouts(\"Standard\")]),layouts(\"Standard\"),lit(\")\")],{})", Factory.Production);
  private static final IConstructor prod__lit___93__char_class___range__93_93_ = (IConstructor) _read("prod(lit(\"]\"),[\\char-class([range(93,93)])],{})", Factory.Production);
  private static final IConstructor prod__meta_Form__alt___lit___35_94_lit___94_layouts_Standard_meta_Form_layouts_Standard_arg_Form_ = (IConstructor) _read("prod(label(\"meta\",sort(\"Form\")),[alt({lit(\"#^\"),lit(\"^\")}),layouts(\"Standard\"),label(\"meta\",sort(\"Form\")),layouts(\"Standard\"),label(\"arg\",sort(\"Form\"))],{})", Factory.Production);
  private static final IConstructor prod__lit___35_39__char_class___range__35_35_char_class___range__39_39_ = (IConstructor) _read("prod(lit(\"#\\'\\\\\"),[\\char-class([range(35,35)]),\\char-class([range(39,39)])],{})", Factory.Production);
  private static final IConstructor prod__StrChar__char_class___range__92_92_char_class___range__117_117_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_ = (IConstructor) _read("prod(lex(\"StrChar\"),[\\char-class([range(92,92)]),\\char-class([range(117,117)]),\\char-class([range(48,57),range(65,70),range(97,102)]),\\char-class([range(48,57),range(65,70),range(97,102)]),\\char-class([range(48,57),range(65,70),range(97,102)]),\\char-class([range(48,57),range(65,70),range(97,102)])],{})", Factory.Production);
  private static final IConstructor prod__lit___35_40__char_class___range__35_35_char_class___range__40_40_ = (IConstructor) _read("prod(lit(\"#(\"),[\\char-class([range(35,35)]),\\char-class([range(40,40)])],{})", Factory.Production);
  private static final IConstructor prod__Whitespace__char_class___range__9_10_range__12_13_range__32_32_range__44_44_ = (IConstructor) _read("prod(lex(\"Whitespace\"),[\\char-class([range(9,10),range(12,13),range(32,32),range(44,44)])],{})", Factory.Production);
  private static final IConstructor prod__Char__char_class___range__92_92_lit_newline_ = (IConstructor) _read("prod(lex(\"Char\"),[\\char-class([range(92,92)]),lit(\"newline\")],{})", Factory.Production);
  private static final IConstructor regular__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124 = (IConstructor) _read("regular(\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])))", Factory.Production);
  private static final IConstructor regular__iter_star_seps__Form__layouts_Standard = (IConstructor) _read("regular(\\iter-star-seps(sort(\"Form\"),[layouts(\"Standard\")]))", Factory.Production);
  private static final IConstructor prod__IntValue__char_class___range__48_48_char_class___range__88_88_range__120_120_conditional__iter__char_class___range__48_57_range__65_70_range__97_102__not_follow__char_class___range__48_57_range__65_70_range__97_102_ = (IConstructor) _read("prod(lex(\"IntValue\"),[\\char-class([range(48,48)]),\\char-class([range(88,88),range(120,120)]),conditional(iter(\\char-class([range(48,57),range(65,70),range(97,102)])),{\\not-follow(\\char-class([range(48,57),range(65,70),range(97,102)]))})],{})", Factory.Production);
  private static final IConstructor prod__vector_Form__lit___91_layouts_Standard_iter_star_seps__Form__layouts_Standard_layouts_Standard_lit___93_ = (IConstructor) _read("prod(label(\"vector\",sort(\"Form\")),[lit(\"[\"),layouts(\"Standard\"),\\iter-star-seps(sort(\"Form\"),[layouts(\"Standard\")]),layouts(\"Standard\"),lit(\"]\")],{})", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_55 = (IConstructor) _read("regular(iter(\\char-class([range(48,55)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_57 = (IConstructor) _read("regular(iter(\\char-class([range(48,57)])))", Factory.Production);
  private static final IConstructor regular__opt__char_class___range__78_78 = (IConstructor) _read("regular(opt(\\char-class([range(78,78)])))", Factory.Production);
  private static final IConstructor regular__opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57 = (IConstructor) _read("regular(opt(seq([\\char-class([range(69,69),range(101,101)]),opt(\\char-class([range(43,43),range(45,45)])),conditional(iter(\\char-class([range(48,57)])),{\\not-follow(\\char-class([range(48,57)]))})])))", Factory.Production);
  private static final IConstructor regular__opt__char_class___range__77_77 = (IConstructor) _read("regular(opt(\\char-class([range(77,77)])))", Factory.Production);
  private static final IConstructor prod__lit___64__char_class___range__64_64_ = (IConstructor) _read("prod(lit(\"@\"),[\\char-class([range(64,64)])],{})", Factory.Production);
  private static final IConstructor prod__map_Form__lit___123_layouts_Standard_iter_star_seps__Form__layouts_Standard_layouts_Standard_lit___125_ = (IConstructor) _read("prod(label(\"map\",sort(\"Form\")),[lit(\"{\"),layouts(\"Standard\"),\\iter-star-seps(sort(\"Form\"),[layouts(\"Standard\")]),layouts(\"Standard\"),lit(\"}\")],{})", Factory.Production);
  private static final IConstructor prod__lit_tab__char_class___range__116_116_char_class___range__97_97_char_class___range__98_98_ = (IConstructor) _read("prod(lit(\"tab\"),[\\char-class([range(116,116)]),\\char-class([range(97,97)]),\\char-class([range(98,98)])],{})", Factory.Production);
  private static final IConstructor prod__IntValue__char_class___range__49_57_conditional__iter_star__char_class___range__48_57__not_follow__char_class___range__48_57_ = (IConstructor) _read("prod(lex(\"IntValue\"),[\\char-class([range(49,57)]),conditional(\\iter-star(\\char-class([range(48,57)])),{\\not-follow(\\char-class([range(48,57)]))})],{})", Factory.Production);
  private static final IConstructor prod__unquote_Form__conditional__lit___126__not_follow__char_class___range__64_64_layouts_Standard_arg_Form_ = (IConstructor) _read("prod(label(\"unquote\",sort(\"Form\")),[conditional(lit(\"~\"),{\\not-follow(\\char-class([range(64,64)]))}),layouts(\"Standard\"),label(\"arg\",sort(\"Form\"))],{})", Factory.Production);
  private static final IConstructor prod__float_Number__Float_ = (IConstructor) _read("prod(label(\"float\",lex(\"Number\")),[lex(\"Float\")],{})", Factory.Production);
  private static final IConstructor prod__lit___123__char_class___range__123_123_ = (IConstructor) _read("prod(lit(\"{\"),[\\char-class([range(123,123)])],{})", Factory.Production);
  private static final IConstructor prod__Arg__char_class___range__37_37_char_class___range__49_57_conditional__iter_star__char_class___range__48_57__not_follow__char_class___range__48_57_ = (IConstructor) _read("prod(lex(\"Arg\"),[\\char-class([range(37,37)]),\\char-class([range(49,57)]),conditional(\\iter-star(\\char-class([range(48,57)])),{\\not-follow(\\char-class([range(48,57)]))})],{})", Factory.Production);
  private static final IConstructor prod__IntValue__conditional__char_class___range__48_48__not_follow__char_class___range__48_55_range__88_88_range__120_120_ = (IConstructor) _read("prod(lex(\"IntValue\"),[conditional(\\char-class([range(48,48)]),{\\not-follow(\\char-class([range(48,55),range(88,88),range(120,120)]))})],{})", Factory.Production);
  private static final IConstructor prod__integer_Number__Integer_ = (IConstructor) _read("prod(label(\"integer\",lex(\"Number\")),[lex(\"Integer\")],{})", Factory.Production);
  private static final IConstructor prod__Symbol__Ident_ = (IConstructor) _read("prod(lex(\"Symbol\"),[lex(\"Ident\")],{})", Factory.Production);
  private static final IConstructor prod__lit___126__char_class___range__126_126_ = (IConstructor) _read("prod(lit(\"~\"),[\\char-class([range(126,126)])],{})", Factory.Production);
  private static final IConstructor prod__lit___125__char_class___range__125_125_ = (IConstructor) _read("prod(lit(\"}\"),[\\char-class([range(125,125)])],{})", Factory.Production);
  private static final IConstructor prod__ratio_Number__Ratio_ = (IConstructor) _read("prod(label(\"ratio\",lex(\"Number\")),[lex(\"Ratio\")],{})", Factory.Production);
  private static final IConstructor prod__Float__opt__char_class___range__43_43_range__45_45_FloatValue_opt__char_class___range__77_77_ = (IConstructor) _read("prod(lex(\"Float\"),[opt(\\char-class([range(43,43),range(45,45)])),lex(\"FloatValue\"),opt(\\char-class([range(77,77)]))],{})", Factory.Production);
  private static final IConstructor regular__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__46_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39 = (IConstructor) _read("regular(seq([conditional(\\char-class([range(45,45)]),{\\not-precede(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))}),\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(46,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]),\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),conditional(iter(\\char-class([range(39,39)])),{\\not-follow(\\char-class([range(39,39)]))})]))", Factory.Production);
  private static final IConstructor prod__Symbol__lit___58_58_Ident_ = (IConstructor) _read("prod(lex(\"Symbol\"),[lit(\"::\"),lex(\"Ident\")],{})", Factory.Production);
  private static final IConstructor prod__Stem__conditional__char_class___range__45_45__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_ = (IConstructor) _read("prod(lex(\"Stem\"),[conditional(\\char-class([range(45,45)]),{\\not-follow(\\char-class([range(33,33),range(35,36),range(38,39),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),\\not-precede(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))})],{})", Factory.Production);
  private static final IConstructor prod__symbol_Form__Symbol_ = (IConstructor) _read("prod(label(\"symbol\",sort(\"Form\")),[lex(\"Symbol\")],{})", Factory.Production);
  private static final IConstructor prod__Char__char_class___range__92_92_char_class___range__0_7_range__11_11_range__14_31_range__33_16777215_ = (IConstructor) _read("prod(lex(\"Char\"),[\\char-class([range(92,92)]),\\char-class([range(0,7),range(11,11),range(14,31),range(33,16777215)])],{})", Factory.Production);
  private static final IConstructor prod__lit___58_58__char_class___range__58_58_char_class___range__58_58_ = (IConstructor) _read("prod(lit(\"::\"),[\\char-class([range(58,58)]),\\char-class([range(58,58)])],{})", Factory.Production);
  private static final IConstructor regular__iter_star__char_class___range__9_10_range__13_13_range__32_32 = (IConstructor) _read("regular(\\iter-star(\\char-class([range(9,10),range(13,13),range(32,32)])))", Factory.Production);
  private static final IConstructor prod__Char__char_class___range__92_92_lit_return_ = (IConstructor) _read("prod(lex(\"Char\"),[\\char-class([range(92,92)]),lit(\"return\")],{})", Factory.Production);
  private static final IConstructor prod__layouts_Standard__conditional__iter_star__WhitespaceOrComment__not_follow__char_class___range__9_10_range__12_13_range__32_32_range__44_44_not_follow__lit___59_ = (IConstructor) _read("prod(layouts(\"Standard\"),[conditional(\\iter-star(sort(\"WhitespaceOrComment\")),{\\not-follow(\\char-class([range(9,10),range(12,13),range(32,32),range(44,44)])),\\not-follow(lit(\";\"))})],{})", Factory.Production);
  private static final IConstructor prod__IntValue__char_class___range__49_57_opt__char_class___range__48_57_char_class___range__82_82_range__114_114_conditional__iter__char_class___range__48_57_range__65_90_range__97_122__not_follow__char_class___range__48_57_range__65_90_range__97_122_ = (IConstructor) _read("prod(lex(\"IntValue\"),[\\char-class([range(49,57)]),opt(\\char-class([range(48,57)])),\\char-class([range(82,82),range(114,114)]),conditional(iter(\\char-class([range(48,57),range(65,90),range(97,122)])),{\\not-follow(\\char-class([range(48,57),range(65,90),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor regular__iter_star__WhitespaceOrComment = (IConstructor) _read("regular(\\iter-star(sort(\"WhitespaceOrComment\")))", Factory.Production);
  private static final IConstructor prod__quote_Form__lit___39_layouts_Standard_arg_Form_ = (IConstructor) _read("prod(label(\"quote\",sort(\"Form\")),[lit(\"\\'\\\\\"),layouts(\"Standard\"),label(\"arg\",sort(\"Form\"))],{})", Factory.Production);
  private static final IConstructor prod__Char__char_class___range__92_92_lit_tab_ = (IConstructor) _read("prod(lex(\"Char\"),[\\char-class([range(92,92)]),lit(\"tab\")],{})", Factory.Production);
  private static final IConstructor regular__opt__lit___58 = (IConstructor) _read("regular(opt(lit(\":\")))", Factory.Production);
  private static final IConstructor prod__lit___96__char_class___range__96_96_ = (IConstructor) _read("prod(lit(\"`\"),[\\char-class([range(96,96)])],{})", Factory.Production);
  private static final IConstructor prod__layouts_$QUOTES__conditional__iter_star__char_class___range__9_10_range__13_13_range__32_32__not_follow__char_class___range__9_10_range__13_13_range__32_32_ = (IConstructor) _read("prod(layouts(\"$QUOTES\"),[conditional(\\iter-star(\\char-class([range(9,10),range(13,13),range(32,32)])),{\\not-follow(\\char-class([range(9,10),range(13,13),range(32,32)]))})],{})", Factory.Production);
  private static final IConstructor prod__String__char_class___range__34_34_iter_star__StrChar_char_class___range__34_34__tag__category___83_116_114_105_110_103_76_105_116_101_114_97_108 = (IConstructor) _read("prod(lex(\"String\"),[\\char-class([range(34,34)]),\\iter-star(lex(\"StrChar\")),\\char-class([range(34,34)])],{tag(category(\"StringLiteral\"))})", Factory.Production);
  private static final IConstructor regular__iter_star__alt___char_class___range__0_33_range__35_16777215_seq___char_class___range__92_92_char_class___range__34_34 = (IConstructor) _read("regular(\\iter-star(alt({\\char-class([range(0,33),range(35,16777215)]),seq([\\char-class([range(92,92)]),\\char-class([range(34,34)])])})))", Factory.Production);
  private static final IConstructor prod__lit_backspace__char_class___range__98_98_char_class___range__97_97_char_class___range__99_99_char_class___range__107_107_char_class___range__115_115_char_class___range__112_112_char_class___range__97_97_char_class___range__99_99_char_class___range__101_101_ = (IConstructor) _read("prod(lit(\"backspace\"),[\\char-class([range(98,98)]),\\char-class([range(97,97)]),\\char-class([range(99,99)]),\\char-class([range(107,107)]),\\char-class([range(115,115)]),\\char-class([range(112,112)]),\\char-class([range(97,97)]),\\char-class([range(99,99)]),\\char-class([range(101,101)])],{})", Factory.Production);
    
  // Item declarations
	
	
  protected static class layouts_Standard {
    public final static AbstractStackNode<IConstructor>[] EXPECTS;
    static{
      ExpectBuilder<IConstructor> builder = new ExpectBuilder<IConstructor>(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__layouts_Standard__conditional__iter_star__WhitespaceOrComment__not_follow__char_class___range__9_10_range__12_13_range__32_32_range__44_44_not_follow__lit___59_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[1];
      
      tmp[0] = new ListStackNode<IConstructor>(6, 0, regular__iter_star__WhitespaceOrComment, new NonTerminalStackNode<IConstructor>(8, 0, "WhitespaceOrComment", null, null), false, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{9,10},{12,13},{32,32},{44,44}}), new StringFollowRestriction(new int[] {59})});
      builder.addAlternative(ClojureParser.prod__layouts_Standard__conditional__iter_star__WhitespaceOrComment__not_follow__char_class___range__9_10_range__12_13_range__32_32_range__44_44_not_follow__lit___59_, tmp);
	}
    public static void init(ExpectBuilder<IConstructor> builder){
      
      
        _init_prod__layouts_Standard__conditional__iter_star__WhitespaceOrComment__not_follow__char_class___range__9_10_range__12_13_range__32_32_range__44_44_not_follow__lit___59_(builder);
      
    }
  }
	
  protected static class Ratio {
    public final static AbstractStackNode<IConstructor>[] EXPECTS;
    static{
      ExpectBuilder<IConstructor> builder = new ExpectBuilder<IConstructor>(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__Ratio__opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__47_47_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[4];
      
      tmp[3] = new ListStackNode<IConstructor>(20, 3, regular__iter__char_class___range__48_57, new CharStackNode<IConstructor>(22, 0, new int[][]{{48,57}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57}})});
      tmp[2] = new CharStackNode<IConstructor>(18, 2, new int[][]{{47,47}}, null, null);
      tmp[1] = new ListStackNode<IConstructor>(14, 1, regular__iter__char_class___range__48_57, new CharStackNode<IConstructor>(16, 0, new int[][]{{48,57}}, null, null), true, null, null);
      tmp[0] = new OptionalStackNode<IConstructor>(10, 0, regular__opt__char_class___range__43_43_range__45_45, new CharStackNode<IConstructor>(12, 0, new int[][]{{43,43},{45,45}}, null, null), null, null);
      builder.addAlternative(ClojureParser.prod__Ratio__opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__47_47_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57_, tmp);
	}
    public static void init(ExpectBuilder<IConstructor> builder){
      
      
        _init_prod__Ratio__opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__47_47_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57_(builder);
      
    }
  }
	
  protected static class Number {
    public final static AbstractStackNode<IConstructor>[] EXPECTS;
    static{
      ExpectBuilder<IConstructor> builder = new ExpectBuilder<IConstructor>(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__integer_Number__Integer_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode<IConstructor>(102, 0, "Integer", null, null);
      builder.addAlternative(ClojureParser.prod__integer_Number__Integer_, tmp);
	}
    protected static final void _init_prod__ratio_Number__Ratio_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode<IConstructor>(104, 0, "Ratio", null, null);
      builder.addAlternative(ClojureParser.prod__ratio_Number__Ratio_, tmp);
	}
    protected static final void _init_prod__float_Number__Float_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode<IConstructor>(106, 0, "Float", null, null);
      builder.addAlternative(ClojureParser.prod__float_Number__Float_, tmp);
	}
    public static void init(ExpectBuilder<IConstructor> builder){
      
      
        _init_prod__integer_Number__Integer_(builder);
      
        _init_prod__ratio_Number__Ratio_(builder);
      
        _init_prod__float_Number__Float_(builder);
      
    }
  }
	
  protected static class Stem {
    public final static AbstractStackNode<IConstructor>[] EXPECTS;
    static{
      ExpectBuilder<IConstructor> builder = new ExpectBuilder<IConstructor>(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__Stem__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__46_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[1];
      
      tmp[0] = new SequenceStackNode<IConstructor>(40, 0, regular__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__46_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39, (AbstractStackNode<IConstructor>[]) new AbstractStackNode[]{new CharStackNode<IConstructor>(42, 0, new int[][]{{45,45}}, new IEnterFilter[] {new CharPrecedeRestriction(new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}})}, null), new ListStackNode<IConstructor>(44, 1, regular__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124, new CharStackNode<IConstructor>(46, 0, new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}}, null, null), false, null, null), new CharStackNode<IConstructor>(48, 2, new int[][]{{33,33},{35,36},{38,38},{42,43},{46,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}}, null, null), new ListStackNode<IConstructor>(50, 3, regular__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124, new CharStackNode<IConstructor>(52, 0, new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}}, null, null), false, null, null), new ListStackNode<IConstructor>(54, 4, regular__iter__char_class___range__39_39, new CharStackNode<IConstructor>(56, 0, new int[][]{{39,39}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{39,39}})})}, null, null);
      builder.addAlternative(ClojureParser.prod__Stem__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__46_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39_, tmp);
	}
    protected static final void _init_prod__Stem__seq___conditional__char_class___range__33_33_range__38_38_range__42_43_range__46_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[1];
      
      tmp[0] = new SequenceStackNode<IConstructor>(58, 0, regular__seq___conditional__char_class___range__33_33_range__38_38_range__42_43_range__46_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39, (AbstractStackNode<IConstructor>[]) new AbstractStackNode[]{new CharStackNode<IConstructor>(60, 0, new int[][]{{33,33},{38,38},{42,43},{46,46},{60,63},{65,90},{95,95},{97,122},{124,124}}, new IEnterFilter[] {new CharPrecedeRestriction(new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}})}, null), new ListStackNode<IConstructor>(62, 1, regular__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124, new CharStackNode<IConstructor>(64, 0, new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}}, null, null), false, null, null), new ListStackNode<IConstructor>(66, 2, regular__iter__char_class___range__39_39, new CharStackNode<IConstructor>(68, 0, new int[][]{{39,39}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{39,39}})})}, null, null);
      builder.addAlternative(ClojureParser.prod__Stem__seq___conditional__char_class___range__33_33_range__38_38_range__42_43_range__46_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39_, tmp);
	}
    protected static final void _init_prod__Stem__conditional__char_class___range__45_45__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[1];
      
      tmp[0] = new CharStackNode<IConstructor>(70, 0, new int[][]{{45,45}}, new IEnterFilter[] {new CharPrecedeRestriction(new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}})}, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{33,33},{35,36},{38,39},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}})});
      builder.addAlternative(ClojureParser.prod__Stem__conditional__char_class___range__45_45__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_, tmp);
	}
    protected static final void _init_prod__Stem__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[1];
      
      tmp[0] = new SequenceStackNode<IConstructor>(72, 0, regular__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39, (AbstractStackNode<IConstructor>[]) new AbstractStackNode[]{new CharStackNode<IConstructor>(74, 0, new int[][]{{45,45}}, new IEnterFilter[] {new CharPrecedeRestriction(new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}})}, null), new ListStackNode<IConstructor>(76, 1, regular__iter__char_class___range__39_39, new CharStackNode<IConstructor>(78, 0, new int[][]{{39,39}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{39,39}})})}, null, null);
      builder.addAlternative(ClojureParser.prod__Stem__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39_, tmp);
	}
    protected static final void _init_prod__Stem__seq___conditional__char_class___range__33_33_range__38_38_range__42_43_range__46_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[1];
      
      tmp[0] = new SequenceStackNode<IConstructor>(80, 0, regular__seq___conditional__char_class___range__33_33_range__38_38_range__42_43_range__46_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124, (AbstractStackNode<IConstructor>[]) new AbstractStackNode[]{new CharStackNode<IConstructor>(82, 0, new int[][]{{33,33},{38,38},{42,43},{46,46},{60,63},{65,90},{95,95},{97,122},{124,124}}, new IEnterFilter[] {new CharPrecedeRestriction(new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}})}, null), new ListStackNode<IConstructor>(84, 1, regular__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124, new CharStackNode<IConstructor>(86, 0, new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}}, null, null), false, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{33,33},{35,36},{38,39},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}})})}, null, null);
      builder.addAlternative(ClojureParser.prod__Stem__seq___conditional__char_class___range__33_33_range__38_38_range__42_43_range__46_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_, tmp);
	}
    protected static final void _init_prod__Stem__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[1];
      
      tmp[0] = new SequenceStackNode<IConstructor>(88, 0, regular__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124, (AbstractStackNode<IConstructor>[]) new AbstractStackNode[]{new CharStackNode<IConstructor>(90, 0, new int[][]{{45,45}}, new IEnterFilter[] {new CharPrecedeRestriction(new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}})}, null), new ListStackNode<IConstructor>(92, 1, regular__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124, new CharStackNode<IConstructor>(94, 0, new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}}, null, null), false, null, null), new CharStackNode<IConstructor>(96, 2, new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{60,63},{65,90},{95,95},{97,122},{124,124}}, null, null), new ListStackNode<IConstructor>(98, 3, regular__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124, new CharStackNode<IConstructor>(100, 0, new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}}, null, null), false, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{33,33},{35,36},{38,39},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}})})}, null, null);
      builder.addAlternative(ClojureParser.prod__Stem__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_, tmp);
	}
    public static void init(ExpectBuilder<IConstructor> builder){
      
      
        _init_prod__Stem__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__46_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39_(builder);
      
        _init_prod__Stem__seq___conditional__char_class___range__33_33_range__38_38_range__42_43_range__46_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39_(builder);
      
        _init_prod__Stem__conditional__char_class___range__45_45__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_(builder);
      
        _init_prod__Stem__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39_(builder);
      
        _init_prod__Stem__seq___conditional__char_class___range__33_33_range__38_38_range__42_43_range__46_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_(builder);
      
        _init_prod__Stem__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_(builder);
      
    }
  }
	
  protected static class IntValue {
    public final static AbstractStackNode<IConstructor>[] EXPECTS;
    static{
      ExpectBuilder<IConstructor> builder = new ExpectBuilder<IConstructor>(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__IntValue__char_class___range__49_57_opt__char_class___range__48_57_char_class___range__82_82_range__114_114_conditional__iter__char_class___range__48_57_range__65_90_range__97_122__not_follow__char_class___range__48_57_range__65_90_range__97_122_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[4];
      
      tmp[3] = new ListStackNode<IConstructor>(126, 3, regular__iter__char_class___range__48_57_range__65_90_range__97_122, new CharStackNode<IConstructor>(128, 0, new int[][]{{48,57},{65,90},{97,122}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57},{65,90},{97,122}})});
      tmp[2] = new CharStackNode<IConstructor>(124, 2, new int[][]{{82,82},{114,114}}, null, null);
      tmp[1] = new OptionalStackNode<IConstructor>(120, 1, regular__opt__char_class___range__48_57, new CharStackNode<IConstructor>(122, 0, new int[][]{{48,57}}, null, null), null, null);
      tmp[0] = new CharStackNode<IConstructor>(118, 0, new int[][]{{49,57}}, null, null);
      builder.addAlternative(ClojureParser.prod__IntValue__char_class___range__49_57_opt__char_class___range__48_57_char_class___range__82_82_range__114_114_conditional__iter__char_class___range__48_57_range__65_90_range__97_122__not_follow__char_class___range__48_57_range__65_90_range__97_122_, tmp);
	}
    protected static final void _init_prod__IntValue__conditional__char_class___range__48_48__not_follow__char_class___range__48_55_range__88_88_range__120_120_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[1];
      
      tmp[0] = new CharStackNode<IConstructor>(130, 0, new int[][]{{48,48}}, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,55},{88,88},{120,120}})});
      builder.addAlternative(ClojureParser.prod__IntValue__conditional__char_class___range__48_48__not_follow__char_class___range__48_55_range__88_88_range__120_120_, tmp);
	}
    protected static final void _init_prod__IntValue__char_class___range__48_48_conditional__iter__char_class___range__48_55__not_follow__char_class___range__48_55_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[2];
      
      tmp[1] = new ListStackNode<IConstructor>(134, 1, regular__iter__char_class___range__48_55, new CharStackNode<IConstructor>(136, 0, new int[][]{{48,55}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,55}})});
      tmp[0] = new CharStackNode<IConstructor>(132, 0, new int[][]{{48,48}}, null, null);
      builder.addAlternative(ClojureParser.prod__IntValue__char_class___range__48_48_conditional__iter__char_class___range__48_55__not_follow__char_class___range__48_55_, tmp);
	}
    protected static final void _init_prod__IntValue__char_class___range__49_57_conditional__iter_star__char_class___range__48_57__not_follow__char_class___range__48_57_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[2];
      
      tmp[1] = new ListStackNode<IConstructor>(140, 1, regular__iter_star__char_class___range__48_57, new CharStackNode<IConstructor>(142, 0, new int[][]{{48,57}}, null, null), false, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57}})});
      tmp[0] = new CharStackNode<IConstructor>(138, 0, new int[][]{{49,57}}, null, null);
      builder.addAlternative(ClojureParser.prod__IntValue__char_class___range__49_57_conditional__iter_star__char_class___range__48_57__not_follow__char_class___range__48_57_, tmp);
	}
    protected static final void _init_prod__IntValue__char_class___range__48_48_char_class___range__88_88_range__120_120_conditional__iter__char_class___range__48_57_range__65_70_range__97_102__not_follow__char_class___range__48_57_range__65_70_range__97_102_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[3];
      
      tmp[2] = new ListStackNode<IConstructor>(148, 2, regular__iter__char_class___range__48_57_range__65_70_range__97_102, new CharStackNode<IConstructor>(150, 0, new int[][]{{48,57},{65,70},{97,102}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57},{65,70},{97,102}})});
      tmp[1] = new CharStackNode<IConstructor>(146, 1, new int[][]{{88,88},{120,120}}, null, null);
      tmp[0] = new CharStackNode<IConstructor>(144, 0, new int[][]{{48,48}}, null, null);
      builder.addAlternative(ClojureParser.prod__IntValue__char_class___range__48_48_char_class___range__88_88_range__120_120_conditional__iter__char_class___range__48_57_range__65_70_range__97_102__not_follow__char_class___range__48_57_range__65_70_range__97_102_, tmp);
	}
    public static void init(ExpectBuilder<IConstructor> builder){
      
      
        _init_prod__IntValue__char_class___range__49_57_opt__char_class___range__48_57_char_class___range__82_82_range__114_114_conditional__iter__char_class___range__48_57_range__65_90_range__97_122__not_follow__char_class___range__48_57_range__65_90_range__97_122_(builder);
      
        _init_prod__IntValue__conditional__char_class___range__48_48__not_follow__char_class___range__48_55_range__88_88_range__120_120_(builder);
      
        _init_prod__IntValue__char_class___range__48_48_conditional__iter__char_class___range__48_55__not_follow__char_class___range__48_55_(builder);
      
        _init_prod__IntValue__char_class___range__49_57_conditional__iter_star__char_class___range__48_57__not_follow__char_class___range__48_57_(builder);
      
        _init_prod__IntValue__char_class___range__48_48_char_class___range__88_88_range__120_120_conditional__iter__char_class___range__48_57_range__65_70_range__97_102__not_follow__char_class___range__48_57_range__65_70_range__97_102_(builder);
      
    }
  }
	
  protected static class start__File {
    public final static AbstractStackNode<IConstructor>[] EXPECTS;
    static{
      ExpectBuilder<IConstructor> builder = new ExpectBuilder<IConstructor>(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__start__File__layouts_Standard_top_File_layouts_Standard_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[3];
      
      tmp[2] = new NonTerminalStackNode<IConstructor>(116, 2, "layouts_Standard", null, null);
      tmp[1] = new NonTerminalStackNode<IConstructor>(114, 1, "File", null, null);
      tmp[0] = new NonTerminalStackNode<IConstructor>(112, 0, "layouts_Standard", null, null);
      builder.addAlternative(ClojureParser.prod__start__File__layouts_Standard_top_File_layouts_Standard_, tmp);
	}
    public static void init(ExpectBuilder<IConstructor> builder){
      
      
        _init_prod__start__File__layouts_Standard_top_File_layouts_Standard_(builder);
      
    }
  }
	
  protected static class Char {
    public final static AbstractStackNode<IConstructor>[] EXPECTS;
    static{
      ExpectBuilder<IConstructor> builder = new ExpectBuilder<IConstructor>(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__Char__char_class___range__92_92_lit_backspace_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[2];
      
      tmp[1] = new LiteralStackNode<IConstructor>(174, 1, prod__lit_backspace__char_class___range__98_98_char_class___range__97_97_char_class___range__99_99_char_class___range__107_107_char_class___range__115_115_char_class___range__112_112_char_class___range__97_97_char_class___range__99_99_char_class___range__101_101_, new int[] {98,97,99,107,115,112,97,99,101}, null, null);
      tmp[0] = new CharStackNode<IConstructor>(172, 0, new int[][]{{92,92}}, null, null);
      builder.addAlternative(ClojureParser.prod__Char__char_class___range__92_92_lit_backspace_, tmp);
	}
    protected static final void _init_prod__Char__char_class___range__92_92_lit_formfeed_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[2];
      
      tmp[1] = new LiteralStackNode<IConstructor>(178, 1, prod__lit_formfeed__char_class___range__102_102_char_class___range__111_111_char_class___range__114_114_char_class___range__109_109_char_class___range__102_102_char_class___range__101_101_char_class___range__101_101_char_class___range__100_100_, new int[] {102,111,114,109,102,101,101,100}, null, null);
      tmp[0] = new CharStackNode<IConstructor>(176, 0, new int[][]{{92,92}}, null, null);
      builder.addAlternative(ClojureParser.prod__Char__char_class___range__92_92_lit_formfeed_, tmp);
	}
    protected static final void _init_prod__Char__char_class___range__92_92_lit_tab_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[2];
      
      tmp[1] = new LiteralStackNode<IConstructor>(182, 1, prod__lit_tab__char_class___range__116_116_char_class___range__97_97_char_class___range__98_98_, new int[] {116,97,98}, null, null);
      tmp[0] = new CharStackNode<IConstructor>(180, 0, new int[][]{{92,92}}, null, null);
      builder.addAlternative(ClojureParser.prod__Char__char_class___range__92_92_lit_tab_, tmp);
	}
    protected static final void _init_prod__Char__char_class___range__92_92_lit_newline_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[2];
      
      tmp[1] = new LiteralStackNode<IConstructor>(186, 1, prod__lit_newline__char_class___range__110_110_char_class___range__101_101_char_class___range__119_119_char_class___range__108_108_char_class___range__105_105_char_class___range__110_110_char_class___range__101_101_, new int[] {110,101,119,108,105,110,101}, null, null);
      tmp[0] = new CharStackNode<IConstructor>(184, 0, new int[][]{{92,92}}, null, null);
      builder.addAlternative(ClojureParser.prod__Char__char_class___range__92_92_lit_newline_, tmp);
	}
    protected static final void _init_prod__Char__char_class___range__92_92_char_class___range__0_7_range__11_11_range__14_31_range__33_16777215_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[2];
      
      tmp[1] = new CharStackNode<IConstructor>(190, 1, new int[][]{{0,7},{11,11},{14,31},{33,16777215}}, null, null);
      tmp[0] = new CharStackNode<IConstructor>(188, 0, new int[][]{{92,92}}, null, null);
      builder.addAlternative(ClojureParser.prod__Char__char_class___range__92_92_char_class___range__0_7_range__11_11_range__14_31_range__33_16777215_, tmp);
	}
    protected static final void _init_prod__Char__char_class___range__92_92_lit_space_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[2];
      
      tmp[1] = new LiteralStackNode<IConstructor>(194, 1, prod__lit_space__char_class___range__115_115_char_class___range__112_112_char_class___range__97_97_char_class___range__99_99_char_class___range__101_101_, new int[] {115,112,97,99,101}, null, null);
      tmp[0] = new CharStackNode<IConstructor>(192, 0, new int[][]{{92,92}}, null, null);
      builder.addAlternative(ClojureParser.prod__Char__char_class___range__92_92_lit_space_, tmp);
	}
    protected static final void _init_prod__Char__char_class___range__92_92_lit_return_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[2];
      
      tmp[1] = new LiteralStackNode<IConstructor>(198, 1, prod__lit_return__char_class___range__114_114_char_class___range__101_101_char_class___range__116_116_char_class___range__117_117_char_class___range__114_114_char_class___range__110_110_, new int[] {114,101,116,117,114,110}, null, null);
      tmp[0] = new CharStackNode<IConstructor>(196, 0, new int[][]{{92,92}}, null, null);
      builder.addAlternative(ClojureParser.prod__Char__char_class___range__92_92_lit_return_, tmp);
	}
    public static void init(ExpectBuilder<IConstructor> builder){
      
      
        _init_prod__Char__char_class___range__92_92_lit_backspace_(builder);
      
        _init_prod__Char__char_class___range__92_92_lit_formfeed_(builder);
      
        _init_prod__Char__char_class___range__92_92_lit_tab_(builder);
      
        _init_prod__Char__char_class___range__92_92_lit_newline_(builder);
      
        _init_prod__Char__char_class___range__92_92_char_class___range__0_7_range__11_11_range__14_31_range__33_16777215_(builder);
      
        _init_prod__Char__char_class___range__92_92_lit_space_(builder);
      
        _init_prod__Char__char_class___range__92_92_lit_return_(builder);
      
    }
  }
	
  protected static class File {
    public final static AbstractStackNode<IConstructor>[] EXPECTS;
    static{
      ExpectBuilder<IConstructor> builder = new ExpectBuilder<IConstructor>(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__File__iter_star_seps__Form__layouts_Standard_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[1];
      
      tmp[0] = new SeparatedListStackNode<IConstructor>(200, 0, regular__iter_star_seps__Form__layouts_Standard, new NonTerminalStackNode<IConstructor>(202, 0, "Form", null, null), (AbstractStackNode<IConstructor>[]) new AbstractStackNode[]{new NonTerminalStackNode<IConstructor>(204, 1, "layouts_Standard", null, null)}, false, null, null);
      builder.addAlternative(ClojureParser.prod__File__iter_star_seps__Form__layouts_Standard_, tmp);
	}
    public static void init(ExpectBuilder<IConstructor> builder){
      
      
        _init_prod__File__iter_star_seps__Form__layouts_Standard_(builder);
      
    }
  }
	
  protected static class Ident {
    public final static AbstractStackNode<IConstructor>[] EXPECTS;
    static{
      ExpectBuilder<IConstructor> builder = new ExpectBuilder<IConstructor>(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__Ident__opt__lit___58_conditional__iter_seps__Stem__lit___58__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[2];
      
      tmp[1] = new SeparatedListStackNode<IConstructor>(294, 1, regular__iter_seps__Stem__lit___58, new NonTerminalStackNode<IConstructor>(296, 0, "Stem", null, null), (AbstractStackNode<IConstructor>[]) new AbstractStackNode[]{new LiteralStackNode<IConstructor>(298, 1, prod__lit___58__char_class___range__58_58_, new int[] {58}, null, null)}, true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{33,33},{35,36},{38,39},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}})});
      tmp[0] = new OptionalStackNode<IConstructor>(290, 0, regular__opt__lit___58, new LiteralStackNode<IConstructor>(292, 0, prod__lit___58__char_class___range__58_58_, new int[] {58}, null, null), null, null);
      builder.addAlternative(ClojureParser.prod__Ident__opt__lit___58_conditional__iter_seps__Stem__lit___58__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_, tmp);
	}
    public static void init(ExpectBuilder<IConstructor> builder){
      
      
        _init_prod__Ident__opt__lit___58_conditional__iter_seps__Stem__lit___58__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_(builder);
      
    }
  }
	
  protected static class layouts_$QUOTES {
    public final static AbstractStackNode<IConstructor>[] EXPECTS;
    static{
      ExpectBuilder<IConstructor> builder = new ExpectBuilder<IConstructor>(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__layouts_$QUOTES__conditional__iter_star__char_class___range__9_10_range__13_13_range__32_32__not_follow__char_class___range__9_10_range__13_13_range__32_32_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[1];
      
      tmp[0] = new ListStackNode<IConstructor>(304, 0, regular__iter_star__char_class___range__9_10_range__13_13_range__32_32, new CharStackNode<IConstructor>(306, 0, new int[][]{{9,10},{13,13},{32,32}}, null, null), false, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{9,10},{13,13},{32,32}})});
      builder.addAlternative(ClojureParser.prod__layouts_$QUOTES__conditional__iter_star__char_class___range__9_10_range__13_13_range__32_32__not_follow__char_class___range__9_10_range__13_13_range__32_32_, tmp);
	}
    public static void init(ExpectBuilder<IConstructor> builder){
      
      
        _init_prod__layouts_$QUOTES__conditional__iter_star__char_class___range__9_10_range__13_13_range__32_32__not_follow__char_class___range__9_10_range__13_13_range__32_32_(builder);
      
    }
  }
	
  protected static class Comment {
    public final static AbstractStackNode<IConstructor>[] EXPECTS;
    static{
      ExpectBuilder<IConstructor> builder = new ExpectBuilder<IConstructor>(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__Comment__lit___59_conditional__iter_star__char_class___range__0_9_range__11_12_range__14_16777215__end_of_line__tag__category___67_111_109_109_101_110_116(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[2];
      
      tmp[1] = new ListStackNode<IConstructor>(362, 1, regular__iter_star__char_class___range__0_9_range__11_12_range__14_16777215, new CharStackNode<IConstructor>(364, 0, new int[][]{{0,9},{11,12},{14,16777215}}, null, null), false, null, new ICompletionFilter[] {new AtEndOfLineRequirement()});
      tmp[0] = new LiteralStackNode<IConstructor>(360, 0, prod__lit___59__char_class___range__59_59_, new int[] {59}, null, null);
      builder.addAlternative(ClojureParser.prod__Comment__lit___59_conditional__iter_star__char_class___range__0_9_range__11_12_range__14_16777215__end_of_line__tag__category___67_111_109_109_101_110_116, tmp);
	}
    public static void init(ExpectBuilder<IConstructor> builder){
      
      
        _init_prod__Comment__lit___59_conditional__iter_star__char_class___range__0_9_range__11_12_range__14_16777215__end_of_line__tag__category___67_111_109_109_101_110_116(builder);
      
    }
  }
	
  protected static class Float {
    public final static AbstractStackNode<IConstructor>[] EXPECTS;
    static{
      ExpectBuilder<IConstructor> builder = new ExpectBuilder<IConstructor>(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__Float__opt__char_class___range__43_43_range__45_45_FloatValue_opt__char_class___range__77_77_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[3];
      
      tmp[2] = new OptionalStackNode<IConstructor>(372, 2, regular__opt__char_class___range__77_77, new CharStackNode<IConstructor>(374, 0, new int[][]{{77,77}}, null, null), null, null);
      tmp[1] = new NonTerminalStackNode<IConstructor>(370, 1, "FloatValue", null, null);
      tmp[0] = new OptionalStackNode<IConstructor>(366, 0, regular__opt__char_class___range__43_43_range__45_45, new CharStackNode<IConstructor>(368, 0, new int[][]{{43,43},{45,45}}, null, null), null, null);
      builder.addAlternative(ClojureParser.prod__Float__opt__char_class___range__43_43_range__45_45_FloatValue_opt__char_class___range__77_77_, tmp);
	}
    public static void init(ExpectBuilder<IConstructor> builder){
      
      
        _init_prod__Float__opt__char_class___range__43_43_range__45_45_FloatValue_opt__char_class___range__77_77_(builder);
      
    }
  }
	
  protected static class Symbol {
    public final static AbstractStackNode<IConstructor>[] EXPECTS;
    static{
      ExpectBuilder<IConstructor> builder = new ExpectBuilder<IConstructor>(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__Symbol__Ident_lit___47_Ident_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[3];
      
      tmp[2] = new NonTerminalStackNode<IConstructor>(398, 2, "Ident", null, null);
      tmp[1] = new LiteralStackNode<IConstructor>(396, 1, prod__lit___47__char_class___range__47_47_, new int[] {47}, null, null);
      tmp[0] = new NonTerminalStackNode<IConstructor>(394, 0, "Ident", null, null);
      builder.addAlternative(ClojureParser.prod__Symbol__Ident_lit___47_Ident_, tmp);
	}
    protected static final void _init_prod__Symbol__Ident_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode<IConstructor>(400, 0, "Ident", null, null);
      builder.addAlternative(ClojureParser.prod__Symbol__Ident_, tmp);
	}
    protected static final void _init_prod__Symbol__conditional__lit___47__not_follow__char_class___range__33_33_range__38_38_range__42_43_range__45_46_range__58_58_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode<IConstructor>(402, 0, prod__lit___47__char_class___range__47_47_, new int[] {47}, new IEnterFilter[] {new CharPrecedeRestriction(new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}})}, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{33,33},{38,38},{42,43},{45,46},{58,58},{60,63},{65,90},{95,95},{97,122},{124,124}})});
      builder.addAlternative(ClojureParser.prod__Symbol__conditional__lit___47__not_follow__char_class___range__33_33_range__38_38_range__42_43_range__45_46_range__58_58_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_, tmp);
	}
    protected static final void _init_prod__Symbol__lit___58_58_Ident_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[2];
      
      tmp[1] = new NonTerminalStackNode<IConstructor>(406, 1, "Ident", null, null);
      tmp[0] = new LiteralStackNode<IConstructor>(404, 0, prod__lit___58_58__char_class___range__58_58_char_class___range__58_58_, new int[] {58,58}, null, null);
      builder.addAlternative(ClojureParser.prod__Symbol__lit___58_58_Ident_, tmp);
	}
    public static void init(ExpectBuilder<IConstructor> builder){
      
      
        _init_prod__Symbol__Ident_lit___47_Ident_(builder);
      
        _init_prod__Symbol__Ident_(builder);
      
        _init_prod__Symbol__conditional__lit___47__not_follow__char_class___range__33_33_range__38_38_range__42_43_range__45_46_range__58_58_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_(builder);
      
        _init_prod__Symbol__lit___58_58_Ident_(builder);
      
    }
  }
	
  protected static class Arg {
    public final static AbstractStackNode<IConstructor>[] EXPECTS;
    static{
      ExpectBuilder<IConstructor> builder = new ExpectBuilder<IConstructor>(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__Arg__char_class___range__37_37_char_class___range__49_57_conditional__iter_star__char_class___range__48_57__not_follow__char_class___range__48_57_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[3];
      
      tmp[2] = new ListStackNode<IConstructor>(412, 2, regular__iter_star__char_class___range__48_57, new CharStackNode<IConstructor>(414, 0, new int[][]{{48,57}}, null, null), false, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57}})});
      tmp[1] = new CharStackNode<IConstructor>(410, 1, new int[][]{{49,57}}, null, null);
      tmp[0] = new CharStackNode<IConstructor>(408, 0, new int[][]{{37,37}}, null, null);
      builder.addAlternative(ClojureParser.prod__Arg__char_class___range__37_37_char_class___range__49_57_conditional__iter_star__char_class___range__48_57__not_follow__char_class___range__48_57_, tmp);
	}
    protected static final void _init_prod__Arg__conditional__char_class___range__37_37__not_follow__char_class___range__38_38_range__49_57_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[1];
      
      tmp[0] = new CharStackNode<IConstructor>(416, 0, new int[][]{{37,37}}, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{38,38},{49,57}})});
      builder.addAlternative(ClojureParser.prod__Arg__conditional__char_class___range__37_37__not_follow__char_class___range__38_38_range__49_57_, tmp);
	}
    protected static final void _init_prod__Arg__char_class___range__37_37_char_class___range__38_38_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[2];
      
      tmp[1] = new CharStackNode<IConstructor>(420, 1, new int[][]{{38,38}}, null, null);
      tmp[0] = new CharStackNode<IConstructor>(418, 0, new int[][]{{37,37}}, null, null);
      builder.addAlternative(ClojureParser.prod__Arg__char_class___range__37_37_char_class___range__38_38_, tmp);
	}
    public static void init(ExpectBuilder<IConstructor> builder){
      
      
        _init_prod__Arg__char_class___range__37_37_char_class___range__49_57_conditional__iter_star__char_class___range__48_57__not_follow__char_class___range__48_57_(builder);
      
        _init_prod__Arg__conditional__char_class___range__37_37__not_follow__char_class___range__38_38_range__49_57_(builder);
      
        _init_prod__Arg__char_class___range__37_37_char_class___range__38_38_(builder);
      
    }
  }
	
  protected static class WhitespaceOrComment {
    public final static AbstractStackNode<IConstructor>[] EXPECTS;
    static{
      ExpectBuilder<IConstructor> builder = new ExpectBuilder<IConstructor>(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__whitespace_WhitespaceOrComment__Whitespace_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode<IConstructor>(422, 0, "Whitespace", null, null);
      builder.addAlternative(ClojureParser.prod__whitespace_WhitespaceOrComment__Whitespace_, tmp);
	}
    protected static final void _init_prod__comment_WhitespaceOrComment__Comment_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode<IConstructor>(424, 0, "Comment", null, null);
      builder.addAlternative(ClojureParser.prod__comment_WhitespaceOrComment__Comment_, tmp);
	}
    public static void init(ExpectBuilder<IConstructor> builder){
      
      
        _init_prod__whitespace_WhitespaceOrComment__Whitespace_(builder);
      
        _init_prod__comment_WhitespaceOrComment__Comment_(builder);
      
    }
  }
	
  protected static class String {
    public final static AbstractStackNode<IConstructor>[] EXPECTS;
    static{
      ExpectBuilder<IConstructor> builder = new ExpectBuilder<IConstructor>(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__String__char_class___range__34_34_iter_star__StrChar_char_class___range__34_34__tag__category___83_116_114_105_110_103_76_105_116_101_114_97_108(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[3];
      
      tmp[2] = new CharStackNode<IConstructor>(444, 2, new int[][]{{34,34}}, null, null);
      tmp[1] = new ListStackNode<IConstructor>(440, 1, regular__iter_star__StrChar, new NonTerminalStackNode<IConstructor>(442, 0, "StrChar", null, null), false, null, null);
      tmp[0] = new CharStackNode<IConstructor>(438, 0, new int[][]{{34,34}}, null, null);
      builder.addAlternative(ClojureParser.prod__String__char_class___range__34_34_iter_star__StrChar_char_class___range__34_34__tag__category___83_116_114_105_110_103_76_105_116_101_114_97_108, tmp);
	}
    public static void init(ExpectBuilder<IConstructor> builder){
      
      
        _init_prod__String__char_class___range__34_34_iter_star__StrChar_char_class___range__34_34__tag__category___83_116_114_105_110_103_76_105_116_101_114_97_108(builder);
      
    }
  }
	
  protected static class Form {
    public final static AbstractStackNode<IConstructor>[] EXPECTS;
    static{
      ExpectBuilder<IConstructor> builder = new ExpectBuilder<IConstructor>(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__set_Form__lit___35_123_layouts_Standard_iter_star_seps__Form__layouts_Standard_layouts_Standard_lit___125_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[5];
      
      tmp[4] = new LiteralStackNode<IConstructor>(458, 4, prod__lit___125__char_class___range__125_125_, new int[] {125}, null, null);
      tmp[3] = new NonTerminalStackNode<IConstructor>(456, 3, "layouts_Standard", null, null);
      tmp[2] = new SeparatedListStackNode<IConstructor>(450, 2, regular__iter_star_seps__Form__layouts_Standard, new NonTerminalStackNode<IConstructor>(452, 0, "Form", null, null), (AbstractStackNode<IConstructor>[]) new AbstractStackNode[]{new NonTerminalStackNode<IConstructor>(454, 1, "layouts_Standard", null, null)}, false, null, null);
      tmp[1] = new NonTerminalStackNode<IConstructor>(448, 1, "layouts_Standard", null, null);
      tmp[0] = new LiteralStackNode<IConstructor>(446, 0, prod__lit___35_123__char_class___range__35_35_char_class___range__123_123_, new int[] {35,123}, null, null);
      builder.addAlternative(ClojureParser.prod__set_Form__lit___35_123_layouts_Standard_iter_star_seps__Form__layouts_Standard_layouts_Standard_lit___125_, tmp);
	}
    protected static final void _init_prod__deref_Form__lit___64_layouts_Standard_Form_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[3];
      
      tmp[2] = new NonTerminalStackNode<IConstructor>(464, 2, "Form", null, null);
      tmp[1] = new NonTerminalStackNode<IConstructor>(462, 1, "layouts_Standard", null, null);
      tmp[0] = new LiteralStackNode<IConstructor>(460, 0, prod__lit___64__char_class___range__64_64_, new int[] {64}, null, null);
      builder.addAlternative(ClojureParser.prod__deref_Form__lit___64_layouts_Standard_Form_, tmp);
	}
    protected static final void _init_prod__fn_Form__lit___35_40_layouts_Standard_iter_star_seps__Form__layouts_Standard_layouts_Standard_lit___41_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[5];
      
      tmp[4] = new LiteralStackNode<IConstructor>(478, 4, prod__lit___41__char_class___range__41_41_, new int[] {41}, null, null);
      tmp[3] = new NonTerminalStackNode<IConstructor>(476, 3, "layouts_Standard", null, null);
      tmp[2] = new SeparatedListStackNode<IConstructor>(470, 2, regular__iter_star_seps__Form__layouts_Standard, new NonTerminalStackNode<IConstructor>(472, 0, "Form", null, null), (AbstractStackNode<IConstructor>[]) new AbstractStackNode[]{new NonTerminalStackNode<IConstructor>(474, 1, "layouts_Standard", null, null)}, false, null, null);
      tmp[1] = new NonTerminalStackNode<IConstructor>(468, 1, "layouts_Standard", null, null);
      tmp[0] = new LiteralStackNode<IConstructor>(466, 0, prod__lit___35_40__char_class___range__35_35_char_class___range__40_40_, new int[] {35,40}, null, null);
      builder.addAlternative(ClojureParser.prod__fn_Form__lit___35_40_layouts_Standard_iter_star_seps__Form__layouts_Standard_layouts_Standard_lit___41_, tmp);
	}
    protected static final void _init_prod__meta_Form__alt___lit___35_94_lit___94_layouts_Standard_meta_Form_layouts_Standard_arg_Form_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[5];
      
      tmp[4] = new NonTerminalStackNode<IConstructor>(492, 4, "Form", null, null);
      tmp[3] = new NonTerminalStackNode<IConstructor>(490, 3, "layouts_Standard", null, null);
      tmp[2] = new NonTerminalStackNode<IConstructor>(488, 2, "Form", null, null);
      tmp[1] = new NonTerminalStackNode<IConstructor>(486, 1, "layouts_Standard", null, null);
      tmp[0] = new AlternativeStackNode<IConstructor>(480, 0, regular__alt___lit___35_94_lit___94, (AbstractStackNode<IConstructor>[]) new AbstractStackNode[]{new LiteralStackNode<IConstructor>(482, 0, prod__lit___35_94__char_class___range__35_35_char_class___range__94_94_, new int[] {35,94}, null, null), new LiteralStackNode<IConstructor>(484, 0, prod__lit___94__char_class___range__94_94_, new int[] {94}, null, null)}, null, null);
      builder.addAlternative(ClojureParser.prod__meta_Form__alt___lit___35_94_lit___94_layouts_Standard_meta_Form_layouts_Standard_arg_Form_, tmp);
	}
    protected static final void _init_prod__string_Form__String_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode<IConstructor>(494, 0, "String", null, null);
      builder.addAlternative(ClojureParser.prod__string_Form__String_, tmp);
	}
    protected static final void _init_prod__qquote_Form__lit___96_layouts_Standard_arg_Form_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[3];
      
      tmp[0] = new LiteralStackNode<IConstructor>(498, 0, prod__lit___96__char_class___range__96_96_, new int[] {96}, null, null);
      tmp[1] = new NonTerminalStackNode<IConstructor>(500, 1, "layouts_Standard", null, null);
      tmp[2] = new NonTerminalStackNode<IConstructor>(502, 2, "Form", null, null);
      builder.addAlternative(ClojureParser.prod__qquote_Form__lit___96_layouts_Standard_arg_Form_, tmp);
	}
    protected static final void _init_prod__number_Form__Number_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode<IConstructor>(496, 0, "Number", null, null);
      builder.addAlternative(ClojureParser.prod__number_Form__Number_, tmp);
	}
    protected static final void _init_prod__unquotes_Form__lit___126_64_layouts_Standard_arg_Form_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[3];
      
      tmp[2] = new NonTerminalStackNode<IConstructor>(508, 2, "Form", null, null);
      tmp[1] = new NonTerminalStackNode<IConstructor>(506, 1, "layouts_Standard", null, null);
      tmp[0] = new LiteralStackNode<IConstructor>(504, 0, prod__lit___126_64__char_class___range__126_126_char_class___range__64_64_, new int[] {126,64}, null, null);
      builder.addAlternative(ClojureParser.prod__unquotes_Form__lit___126_64_layouts_Standard_arg_Form_, tmp);
	}
    protected static final void _init_prod__symbol_Form__Symbol_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode<IConstructor>(510, 0, "Symbol", null, null);
      builder.addAlternative(ClojureParser.prod__symbol_Form__Symbol_, tmp);
	}
    protected static final void _init_prod__vector_Form__lit___91_layouts_Standard_iter_star_seps__Form__layouts_Standard_layouts_Standard_lit___93_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[5];
      
      tmp[4] = new LiteralStackNode<IConstructor>(524, 4, prod__lit___93__char_class___range__93_93_, new int[] {93}, null, null);
      tmp[3] = new NonTerminalStackNode<IConstructor>(522, 3, "layouts_Standard", null, null);
      tmp[2] = new SeparatedListStackNode<IConstructor>(516, 2, regular__iter_star_seps__Form__layouts_Standard, new NonTerminalStackNode<IConstructor>(518, 0, "Form", null, null), (AbstractStackNode<IConstructor>[]) new AbstractStackNode[]{new NonTerminalStackNode<IConstructor>(520, 1, "layouts_Standard", null, null)}, false, null, null);
      tmp[1] = new NonTerminalStackNode<IConstructor>(514, 1, "layouts_Standard", null, null);
      tmp[0] = new LiteralStackNode<IConstructor>(512, 0, prod__lit___91__char_class___range__91_91_, new int[] {91}, null, null);
      builder.addAlternative(ClojureParser.prod__vector_Form__lit___91_layouts_Standard_iter_star_seps__Form__layouts_Standard_layouts_Standard_lit___93_, tmp);
	}
    protected static final void _init_prod__var_Form__lit___35_39_layouts_Standard_Form_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[3];
      
      tmp[2] = new NonTerminalStackNode<IConstructor>(530, 2, "Form", null, null);
      tmp[1] = new NonTerminalStackNode<IConstructor>(528, 1, "layouts_Standard", null, null);
      tmp[0] = new LiteralStackNode<IConstructor>(526, 0, prod__lit___35_39__char_class___range__35_35_char_class___range__39_39_, new int[] {35,39}, null, null);
      builder.addAlternative(ClojureParser.prod__var_Form__lit___35_39_layouts_Standard_Form_, tmp);
	}
    protected static final void _init_prod__quote_Form__lit___39_layouts_Standard_arg_Form_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[3];
      
      tmp[2] = new NonTerminalStackNode<IConstructor>(536, 2, "Form", null, null);
      tmp[1] = new NonTerminalStackNode<IConstructor>(534, 1, "layouts_Standard", null, null);
      tmp[0] = new LiteralStackNode<IConstructor>(532, 0, prod__lit___39__char_class___range__39_39_, new int[] {39}, null, null);
      builder.addAlternative(ClojureParser.prod__quote_Form__lit___39_layouts_Standard_arg_Form_, tmp);
	}
    protected static final void _init_prod__char_Form__Char_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode<IConstructor>(538, 0, "Char", null, null);
      builder.addAlternative(ClojureParser.prod__char_Form__Char_, tmp);
	}
    protected static final void _init_prod__discard_Form__lit___35_95_layouts_Standard_Form_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[3];
      
      tmp[2] = new NonTerminalStackNode<IConstructor>(544, 2, "Form", null, null);
      tmp[1] = new NonTerminalStackNode<IConstructor>(542, 1, "layouts_Standard", null, null);
      tmp[0] = new LiteralStackNode<IConstructor>(540, 0, prod__lit___35_95__char_class___range__35_35_char_class___range__95_95_, new int[] {35,95}, null, null);
      builder.addAlternative(ClojureParser.prod__discard_Form__lit___35_95_layouts_Standard_Form_, tmp);
	}
    protected static final void _init_prod__list_Form__lit___40_layouts_Standard_iter_star_seps__Form__layouts_Standard_layouts_Standard_lit___41_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[5];
      
      tmp[4] = new LiteralStackNode<IConstructor>(558, 4, prod__lit___41__char_class___range__41_41_, new int[] {41}, null, null);
      tmp[3] = new NonTerminalStackNode<IConstructor>(556, 3, "layouts_Standard", null, null);
      tmp[2] = new SeparatedListStackNode<IConstructor>(550, 2, regular__iter_star_seps__Form__layouts_Standard, new NonTerminalStackNode<IConstructor>(552, 0, "Form", null, null), (AbstractStackNode<IConstructor>[]) new AbstractStackNode[]{new NonTerminalStackNode<IConstructor>(554, 1, "layouts_Standard", null, null)}, false, null, null);
      tmp[1] = new NonTerminalStackNode<IConstructor>(548, 1, "layouts_Standard", null, null);
      tmp[0] = new LiteralStackNode<IConstructor>(546, 0, prod__lit___40__char_class___range__40_40_, new int[] {40}, null, null);
      builder.addAlternative(ClojureParser.prod__list_Form__lit___40_layouts_Standard_iter_star_seps__Form__layouts_Standard_layouts_Standard_lit___41_, tmp);
	}
    protected static final void _init_prod__regexp_Form__RegExp_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode<IConstructor>(560, 0, "RegExp", null, null);
      builder.addAlternative(ClojureParser.prod__regexp_Form__RegExp_, tmp);
	}
    protected static final void _init_prod__arg_Form__Arg_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode<IConstructor>(562, 0, "Arg", null, null);
      builder.addAlternative(ClojureParser.prod__arg_Form__Arg_, tmp);
	}
    protected static final void _init_prod__map_Form__lit___123_layouts_Standard_iter_star_seps__Form__layouts_Standard_layouts_Standard_lit___125_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[5];
      
      tmp[4] = new LiteralStackNode<IConstructor>(576, 4, prod__lit___125__char_class___range__125_125_, new int[] {125}, null, null);
      tmp[3] = new NonTerminalStackNode<IConstructor>(574, 3, "layouts_Standard", null, null);
      tmp[2] = new SeparatedListStackNode<IConstructor>(568, 2, regular__iter_star_seps__Form__layouts_Standard, new NonTerminalStackNode<IConstructor>(570, 0, "Form", null, null), (AbstractStackNode<IConstructor>[]) new AbstractStackNode[]{new NonTerminalStackNode<IConstructor>(572, 1, "layouts_Standard", null, null)}, false, null, null);
      tmp[1] = new NonTerminalStackNode<IConstructor>(566, 1, "layouts_Standard", null, null);
      tmp[0] = new LiteralStackNode<IConstructor>(564, 0, prod__lit___123__char_class___range__123_123_, new int[] {123}, null, null);
      builder.addAlternative(ClojureParser.prod__map_Form__lit___123_layouts_Standard_iter_star_seps__Form__layouts_Standard_layouts_Standard_lit___125_, tmp);
	}
    protected static final void _init_prod__unquote_Form__conditional__lit___126__not_follow__char_class___range__64_64_layouts_Standard_arg_Form_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[3];
      
      tmp[2] = new NonTerminalStackNode<IConstructor>(582, 2, "Form", null, null);
      tmp[1] = new NonTerminalStackNode<IConstructor>(580, 1, "layouts_Standard", null, null);
      tmp[0] = new LiteralStackNode<IConstructor>(578, 0, prod__lit___126__char_class___range__126_126_, new int[] {126}, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{64,64}})});
      builder.addAlternative(ClojureParser.prod__unquote_Form__conditional__lit___126__not_follow__char_class___range__64_64_layouts_Standard_arg_Form_, tmp);
	}
    public static void init(ExpectBuilder<IConstructor> builder){
      
      
        _init_prod__set_Form__lit___35_123_layouts_Standard_iter_star_seps__Form__layouts_Standard_layouts_Standard_lit___125_(builder);
      
        _init_prod__deref_Form__lit___64_layouts_Standard_Form_(builder);
      
        _init_prod__fn_Form__lit___35_40_layouts_Standard_iter_star_seps__Form__layouts_Standard_layouts_Standard_lit___41_(builder);
      
        _init_prod__meta_Form__alt___lit___35_94_lit___94_layouts_Standard_meta_Form_layouts_Standard_arg_Form_(builder);
      
        _init_prod__string_Form__String_(builder);
      
        _init_prod__qquote_Form__lit___96_layouts_Standard_arg_Form_(builder);
      
        _init_prod__number_Form__Number_(builder);
      
        _init_prod__unquotes_Form__lit___126_64_layouts_Standard_arg_Form_(builder);
      
        _init_prod__symbol_Form__Symbol_(builder);
      
        _init_prod__vector_Form__lit___91_layouts_Standard_iter_star_seps__Form__layouts_Standard_layouts_Standard_lit___93_(builder);
      
        _init_prod__var_Form__lit___35_39_layouts_Standard_Form_(builder);
      
        _init_prod__quote_Form__lit___39_layouts_Standard_arg_Form_(builder);
      
        _init_prod__char_Form__Char_(builder);
      
        _init_prod__discard_Form__lit___35_95_layouts_Standard_Form_(builder);
      
        _init_prod__list_Form__lit___40_layouts_Standard_iter_star_seps__Form__layouts_Standard_layouts_Standard_lit___41_(builder);
      
        _init_prod__regexp_Form__RegExp_(builder);
      
        _init_prod__arg_Form__Arg_(builder);
      
        _init_prod__map_Form__lit___123_layouts_Standard_iter_star_seps__Form__layouts_Standard_layouts_Standard_lit___125_(builder);
      
        _init_prod__unquote_Form__conditional__lit___126__not_follow__char_class___range__64_64_layouts_Standard_arg_Form_(builder);
      
    }
  }
	
  protected static class RegExp {
    public final static AbstractStackNode<IConstructor>[] EXPECTS;
    static{
      ExpectBuilder<IConstructor> builder = new ExpectBuilder<IConstructor>(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__RegExp__char_class___range__35_35_char_class___range__34_34_iter_star__alt___char_class___range__0_33_range__35_16777215_seq___char_class___range__92_92_char_class___range__34_34_char_class___range__34_34_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[4];
      
      tmp[3] = new CharStackNode<IConstructor>(616, 3, new int[][]{{34,34}}, null, null);
      tmp[2] = new ListStackNode<IConstructor>(604, 2, regular__iter_star__alt___char_class___range__0_33_range__35_16777215_seq___char_class___range__92_92_char_class___range__34_34, new AlternativeStackNode<IConstructor>(606, 0, regular__alt___char_class___range__0_33_range__35_16777215_seq___char_class___range__92_92_char_class___range__34_34, (AbstractStackNode<IConstructor>[]) new AbstractStackNode[]{new CharStackNode<IConstructor>(608, 0, new int[][]{{0,33},{35,16777215}}, null, null), new SequenceStackNode<IConstructor>(610, 0, regular__seq___char_class___range__92_92_char_class___range__34_34, (AbstractStackNode<IConstructor>[]) new AbstractStackNode[]{new CharStackNode<IConstructor>(612, 0, new int[][]{{92,92}}, null, null), new CharStackNode<IConstructor>(614, 1, new int[][]{{34,34}}, null, null)}, null, null)}, null, null), false, null, null);
      tmp[1] = new CharStackNode<IConstructor>(602, 1, new int[][]{{34,34}}, null, null);
      tmp[0] = new CharStackNode<IConstructor>(600, 0, new int[][]{{35,35}}, null, null);
      builder.addAlternative(ClojureParser.prod__RegExp__char_class___range__35_35_char_class___range__34_34_iter_star__alt___char_class___range__0_33_range__35_16777215_seq___char_class___range__92_92_char_class___range__34_34_char_class___range__34_34_, tmp);
	}
    public static void init(ExpectBuilder<IConstructor> builder){
      
      
        _init_prod__RegExp__char_class___range__35_35_char_class___range__34_34_iter_star__alt___char_class___range__0_33_range__35_16777215_seq___char_class___range__92_92_char_class___range__34_34_char_class___range__34_34_(builder);
      
    }
  }
	
  protected static class StrChar {
    public final static AbstractStackNode<IConstructor>[] EXPECTS;
    static{
      ExpectBuilder<IConstructor> builder = new ExpectBuilder<IConstructor>(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__StrChar__char_class___range__92_92_char_class___range__48_51_char_class___range__48_55_char_class___range__48_55_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[4];
      
      tmp[3] = new CharStackNode<IConstructor>(632, 3, new int[][]{{48,55}}, null, null);
      tmp[2] = new CharStackNode<IConstructor>(630, 2, new int[][]{{48,55}}, null, null);
      tmp[1] = new CharStackNode<IConstructor>(628, 1, new int[][]{{48,51}}, null, null);
      tmp[0] = new CharStackNode<IConstructor>(626, 0, new int[][]{{92,92}}, null, null);
      builder.addAlternative(ClojureParser.prod__StrChar__char_class___range__92_92_char_class___range__48_51_char_class___range__48_55_char_class___range__48_55_, tmp);
	}
    protected static final void _init_prod__StrChar__char_class___range__0_33_range__35_91_range__93_16777215_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[1];
      
      tmp[0] = new CharStackNode<IConstructor>(634, 0, new int[][]{{0,33},{35,91},{93,16777215}}, null, null);
      builder.addAlternative(ClojureParser.prod__StrChar__char_class___range__0_33_range__35_91_range__93_16777215_, tmp);
	}
    protected static final void _init_prod__StrChar__char_class___range__92_92_char_class___range__34_34_range__92_92_range__98_98_range__102_102_range__110_110_range__114_114_range__116_116_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[2];
      
      tmp[1] = new CharStackNode<IConstructor>(638, 1, new int[][]{{34,34},{92,92},{98,98},{102,102},{110,110},{114,114},{116,116}}, null, null);
      tmp[0] = new CharStackNode<IConstructor>(636, 0, new int[][]{{92,92}}, null, null);
      builder.addAlternative(ClojureParser.prod__StrChar__char_class___range__92_92_char_class___range__34_34_range__92_92_range__98_98_range__102_102_range__110_110_range__114_114_range__116_116_, tmp);
	}
    protected static final void _init_prod__StrChar__char_class___range__92_92_char_class___range__117_117_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[6];
      
      tmp[5] = new CharStackNode<IConstructor>(650, 5, new int[][]{{48,57},{65,70},{97,102}}, null, null);
      tmp[4] = new CharStackNode<IConstructor>(648, 4, new int[][]{{48,57},{65,70},{97,102}}, null, null);
      tmp[3] = new CharStackNode<IConstructor>(646, 3, new int[][]{{48,57},{65,70},{97,102}}, null, null);
      tmp[2] = new CharStackNode<IConstructor>(644, 2, new int[][]{{48,57},{65,70},{97,102}}, null, null);
      tmp[1] = new CharStackNode<IConstructor>(642, 1, new int[][]{{117,117}}, null, null);
      tmp[0] = new CharStackNode<IConstructor>(640, 0, new int[][]{{92,92}}, null, null);
      builder.addAlternative(ClojureParser.prod__StrChar__char_class___range__92_92_char_class___range__117_117_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_, tmp);
	}
    public static void init(ExpectBuilder<IConstructor> builder){
      
      
        _init_prod__StrChar__char_class___range__92_92_char_class___range__48_51_char_class___range__48_55_char_class___range__48_55_(builder);
      
        _init_prod__StrChar__char_class___range__0_33_range__35_91_range__93_16777215_(builder);
      
        _init_prod__StrChar__char_class___range__92_92_char_class___range__34_34_range__92_92_range__98_98_range__102_102_range__110_110_range__114_114_range__116_116_(builder);
      
        _init_prod__StrChar__char_class___range__92_92_char_class___range__117_117_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_(builder);
      
    }
  }
	
  protected static class Integer {
    public final static AbstractStackNode<IConstructor>[] EXPECTS;
    static{
      ExpectBuilder<IConstructor> builder = new ExpectBuilder<IConstructor>(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__Integer__opt__char_class___range__43_43_range__45_45_IntValue_opt__char_class___range__78_78_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[3];
      
      tmp[2] = new OptionalStackNode<IConstructor>(680, 2, regular__opt__char_class___range__78_78, new CharStackNode<IConstructor>(682, 0, new int[][]{{78,78}}, null, null), null, null);
      tmp[1] = new NonTerminalStackNode<IConstructor>(678, 1, "IntValue", null, null);
      tmp[0] = new OptionalStackNode<IConstructor>(674, 0, regular__opt__char_class___range__43_43_range__45_45, new CharStackNode<IConstructor>(676, 0, new int[][]{{43,43},{45,45}}, null, null), null, null);
      builder.addAlternative(ClojureParser.prod__Integer__opt__char_class___range__43_43_range__45_45_IntValue_opt__char_class___range__78_78_, tmp);
	}
    public static void init(ExpectBuilder<IConstructor> builder){
      
      
        _init_prod__Integer__opt__char_class___range__43_43_range__45_45_IntValue_opt__char_class___range__78_78_(builder);
      
    }
  }
	
  protected static class layouts_$BACKTICKS {
    public final static AbstractStackNode<IConstructor>[] EXPECTS;
    static{
      ExpectBuilder<IConstructor> builder = new ExpectBuilder<IConstructor>(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__layouts_$BACKTICKS__(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[1];
      
      tmp[0] = new EpsilonStackNode<IConstructor>(686, 0);
      builder.addAlternative(ClojureParser.prod__layouts_$BACKTICKS__, tmp);
	}
    public static void init(ExpectBuilder<IConstructor> builder){
      
      
        _init_prod__layouts_$BACKTICKS__(builder);
      
    }
  }
	
  protected static class Whitespace {
    public final static AbstractStackNode<IConstructor>[] EXPECTS;
    static{
      ExpectBuilder<IConstructor> builder = new ExpectBuilder<IConstructor>(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__Whitespace__char_class___range__9_10_range__12_13_range__32_32_range__44_44_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[1];
      
      tmp[0] = new CharStackNode<IConstructor>(688, 0, new int[][]{{9,10},{12,13},{32,32},{44,44}}, null, null);
      builder.addAlternative(ClojureParser.prod__Whitespace__char_class___range__9_10_range__12_13_range__32_32_range__44_44_, tmp);
	}
    public static void init(ExpectBuilder<IConstructor> builder){
      
      
        _init_prod__Whitespace__char_class___range__9_10_range__12_13_range__32_32_range__44_44_(builder);
      
    }
  }
	
  protected static class FloatValue {
    public final static AbstractStackNode<IConstructor>[] EXPECTS;
    static{
      ExpectBuilder<IConstructor> builder = new ExpectBuilder<IConstructor>(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__FloatValue__iter__char_class___range__48_57_char_class___range__46_46_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57_(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[4];
      
      tmp[3] = new OptionalStackNode<IConstructor>(708, 3, regular__opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57, new SequenceStackNode<IConstructor>(710, 0, regular__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57, (AbstractStackNode<IConstructor>[]) new AbstractStackNode[]{new CharStackNode<IConstructor>(712, 0, new int[][]{{69,69},{101,101}}, null, null), new OptionalStackNode<IConstructor>(714, 1, regular__opt__char_class___range__43_43_range__45_45, new CharStackNode<IConstructor>(716, 0, new int[][]{{43,43},{45,45}}, null, null), null, null), new ListStackNode<IConstructor>(718, 2, regular__iter__char_class___range__48_57, new CharStackNode<IConstructor>(720, 0, new int[][]{{48,57}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57}})})}, null, null), null, null);
      tmp[2] = new ListStackNode<IConstructor>(704, 2, regular__iter__char_class___range__48_57, new CharStackNode<IConstructor>(706, 0, new int[][]{{48,57}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57}})});
      tmp[1] = new CharStackNode<IConstructor>(702, 1, new int[][]{{46,46}}, null, null);
      tmp[0] = new ListStackNode<IConstructor>(698, 0, regular__iter__char_class___range__48_57, new CharStackNode<IConstructor>(700, 0, new int[][]{{48,57}}, null, null), true, null, null);
      builder.addAlternative(ClojureParser.prod__FloatValue__iter__char_class___range__48_57_char_class___range__46_46_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57_, tmp);
	}
    public static void init(ExpectBuilder<IConstructor> builder){
      
      
        _init_prod__FloatValue__iter__char_class___range__48_57_char_class___range__46_46_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57_(builder);
      
    }
  }
	
  protected static class layouts_$default$ {
    public final static AbstractStackNode<IConstructor>[] EXPECTS;
    static{
      ExpectBuilder<IConstructor> builder = new ExpectBuilder<IConstructor>(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__layouts_$default$__(ExpectBuilder<IConstructor> builder) {
      AbstractStackNode<IConstructor>[] tmp = (AbstractStackNode<IConstructor>[]) new AbstractStackNode[1];
      
      tmp[0] = new EpsilonStackNode<IConstructor>(726, 0);
      builder.addAlternative(ClojureParser.prod__layouts_$default$__, tmp);
	}
    public static void init(ExpectBuilder<IConstructor> builder){
      
      
        _init_prod__layouts_$default$__(builder);
      
    }
  }
	
  public ClojureParser() {
    super();
  }

  // Parse methods    
  
  public AbstractStackNode<IConstructor>[] layouts_Standard() {
    return layouts_Standard.EXPECTS;
  }
  public AbstractStackNode<IConstructor>[] Ratio() {
    return Ratio.EXPECTS;
  }
  public AbstractStackNode<IConstructor>[] Stem() {
    return Stem.EXPECTS;
  }
  public AbstractStackNode<IConstructor>[] Number() {
    return Number.EXPECTS;
  }
  public AbstractStackNode<IConstructor>[] start__File() {
    return start__File.EXPECTS;
  }
  public AbstractStackNode<IConstructor>[] IntValue() {
    return IntValue.EXPECTS;
  }
  public AbstractStackNode<IConstructor>[] Char() {
    return Char.EXPECTS;
  }
  public AbstractStackNode<IConstructor>[] File() {
    return File.EXPECTS;
  }
  public AbstractStackNode<IConstructor>[] Ident() {
    return Ident.EXPECTS;
  }
  public AbstractStackNode<IConstructor>[] layouts_$QUOTES() {
    return layouts_$QUOTES.EXPECTS;
  }
  public AbstractStackNode<IConstructor>[] Comment() {
    return Comment.EXPECTS;
  }
  public AbstractStackNode<IConstructor>[] Float() {
    return Float.EXPECTS;
  }
  public AbstractStackNode<IConstructor>[] Symbol() {
    return Symbol.EXPECTS;
  }
  public AbstractStackNode<IConstructor>[] Arg() {
    return Arg.EXPECTS;
  }
  public AbstractStackNode<IConstructor>[] WhitespaceOrComment() {
    return WhitespaceOrComment.EXPECTS;
  }
  public AbstractStackNode<IConstructor>[] String() {
    return String.EXPECTS;
  }
  public AbstractStackNode<IConstructor>[] Form() {
    return Form.EXPECTS;
  }
  public AbstractStackNode<IConstructor>[] RegExp() {
    return RegExp.EXPECTS;
  }
  public AbstractStackNode<IConstructor>[] StrChar() {
    return StrChar.EXPECTS;
  }
  public AbstractStackNode<IConstructor>[] Integer() {
    return Integer.EXPECTS;
  }
  public AbstractStackNode<IConstructor>[] layouts_$BACKTICKS() {
    return layouts_$BACKTICKS.EXPECTS;
  }
  public AbstractStackNode<IConstructor>[] Whitespace() {
    return Whitespace.EXPECTS;
  }
  public AbstractStackNode<IConstructor>[] FloatValue() {
    return FloatValue.EXPECTS;
  }
  public AbstractStackNode<IConstructor>[] layouts_$default$() {
    return layouts_$default$.EXPECTS;
  }
}