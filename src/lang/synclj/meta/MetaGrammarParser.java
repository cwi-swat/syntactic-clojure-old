package lang.synclj.meta;

import java.io.IOException;
import java.io.StringReader;

import org.eclipse.imp.pdb.facts.type.TypeFactory;
import org.eclipse.imp.pdb.facts.IConstructor;
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

public class MetaGrammarParser extends org.rascalmpl.library.lang.rascal.syntax.RascalRascal {
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
	
  private static final IConstructor regular__seq___conditional__char_class___range__33_33_range__38_38_range__42_43_range__46_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39 = (IConstructor) _read("regular(seq([conditional(\\char-class([range(33,33),range(38,38),range(42,43),range(46,46),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]),{\\not-precede(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))}),\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),conditional(iter(\\char-class([range(39,39)])),{\\not-follow(\\char-class([range(39,39)]))})]))", Factory.Production);
  private static final IConstructor prod__Tokens__lit_float_ = (IConstructor) _read("prod(keywords(\"Tokens\"),[lit(\"float\")],{})", Factory.Production);
  private static final IConstructor prod__whitespace_MetaWhitespaceOrComment__MetaWhitespace_ = (IConstructor) _read("prod(label(\"whitespace\",sort(\"MetaWhitespaceOrComment\")),[lex(\"MetaWhitespace\")],{})", Factory.Production);
  private static final IConstructor prod__Char__char_class___range__92_92_lit_formfeed_ = (IConstructor) _read("prod(lex(\"Char\"),[\\char-class([range(92,92)]),lit(\"formfeed\")],{})", Factory.Production);
  private static final IConstructor prod__rational_Exp__lit_rational_ = (IConstructor) _read("prod(label(\"rational\",sort(\"Exp\")),[lit(\"rational\")],{})", Factory.Production);
  private static final IConstructor prod__setLit_Exp__lit___34_35_123_34_layouts_Meta_iter_star_seps__Exp__layouts_Meta_layouts_Meta_lit___34_125_34_ = (IConstructor) _read("prod(label(\"setLit\",sort(\"Exp\")),[lit(\"\\\"#{\\\"\"),layouts(\"Meta\"),\\iter-star-seps(sort(\"Exp\"),[layouts(\"Meta\")]),layouts(\"Meta\"),lit(\"\\\"}\\\"\")],{})", Factory.Production);
  private static final IConstructor prod__float_Number__Float_ = (IConstructor) _read("prod(label(\"float\",sort(\"Number\")),[lex(\"Float\")],{})", Factory.Production);
  private static final IConstructor prod__MetaLiteral__Float_ = (IConstructor) _read("prod(lex(\"MetaLiteral\"),[lex(\"Float\")],{})", Factory.Production);
  private static final IConstructor prod__lit___34_91_34__char_class___range__34_34_char_class___range__91_91_char_class___range__34_34_ = (IConstructor) _read("prod(lit(\"\\\"[\\\"\"),[\\char-class([range(34,34)]),\\char-class([range(91,91)]),\\char-class([range(34,34)])],{})", Factory.Production);
  private static final IConstructor regular__seq___char_class___range__92_92_char_class___range__34_34 = (IConstructor) _read("regular(seq([\\char-class([range(92,92)]),\\char-class([range(34,34)])]))", Factory.Production);
  private static final IConstructor prod__Char__char_class___range__92_92_lit_space_ = (IConstructor) _read("prod(lex(\"Char\"),[\\char-class([range(92,92)]),lit(\"space\")],{})", Factory.Production);
  private static final IConstructor prod__plusSep_Exp__lit___123_layouts_Meta_Exp_layouts_Meta_Literal_layouts_Meta_lit___125_layouts_Meta_lit___43_ = (IConstructor) _read("prod(label(\"plusSep\",sort(\"Exp\")),[lit(\"{\"),layouts(\"Meta\"),sort(\"Exp\"),layouts(\"Meta\"),lex(\"Literal\"),layouts(\"Meta\"),lit(\"}\"),layouts(\"Meta\"),lit(\"+\")],{})", Factory.Production);
  private static final IConstructor prod__Tokens__lit_string_ = (IConstructor) _read("prod(keywords(\"Tokens\"),[lit(\"string\")],{})", Factory.Production);
  private static final IConstructor prod__Tokens__lit___61_ = (IConstructor) _read("prod(keywords(\"Tokens\"),[lit(\"=\")],{})", Factory.Production);
  private static final IConstructor prod__Tokens__lit___43_ = (IConstructor) _read("prod(keywords(\"Tokens\"),[lit(\"+\")],{})", Factory.Production);
  private static final IConstructor prod__Tokens__lit___63_ = (IConstructor) _read("prod(keywords(\"Tokens\"),[lit(\"?\")],{})", Factory.Production);
  private static final IConstructor prod__Tokens__lit___42_ = (IConstructor) _read("prod(keywords(\"Tokens\"),[lit(\"*\")],{})", Factory.Production);
  private static final IConstructor prod__Tokens__lit___46_ = (IConstructor) _read("prod(keywords(\"Tokens\"),[lit(\".\")],{})", Factory.Production);
  private static final IConstructor prod__Tokens__lit___124_ = (IConstructor) _read("prod(keywords(\"Tokens\"),[lit(\"|\")],{})", Factory.Production);
  private static final IConstructor prod__lit_grammar__char_class___range__103_103_char_class___range__114_114_char_class___range__97_97_char_class___range__109_109_char_class___range__109_109_char_class___range__97_97_char_class___range__114_114_ = (IConstructor) _read("prod(lit(\"grammar\"),[\\char-class([range(103,103)]),\\char-class([range(114,114)]),\\char-class([range(97,97)]),\\char-class([range(109,109)]),\\char-class([range(109,109)]),\\char-class([range(97,97)]),\\char-class([range(114,114)])],{})", Factory.Production);
  private static final IConstructor prod__Symbol__Ident_lit___47_Ident_ = (IConstructor) _read("prod(lex(\"Symbol\"),[lex(\"Ident\"),lit(\"/\"),lex(\"Ident\")],{})", Factory.Production);
  private static final IConstructor prod__Tokens__lit_integer_ = (IConstructor) _read("prod(keywords(\"Tokens\"),[lit(\"integer\")],{})", Factory.Production);
  private static final IConstructor prod__literal_Exp__Literal_ = (IConstructor) _read("prod(label(\"literal\",sort(\"Exp\")),[lex(\"Literal\")],{})", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_57_range__65_90_range__97_122 = (IConstructor) _read("regular(iter(\\char-class([range(48,57),range(65,90),range(97,122)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_57_range__65_70_range__97_102 = (IConstructor) _read("regular(iter(\\char-class([range(48,57),range(65,70),range(97,102)])))", Factory.Production);
  private static final IConstructor prod__lit___34_35_123_34__char_class___range__34_34_char_class___range__35_35_char_class___range__123_123_char_class___range__34_34_ = (IConstructor) _read("prod(lit(\"\\\"#{\\\"\"),[\\char-class([range(34,34)]),\\char-class([range(35,35)]),\\char-class([range(123,123)]),\\char-class([range(34,34)])],{})", Factory.Production);
  private static final IConstructor prod__lit_symbol__char_class___range__115_115_char_class___range__121_121_char_class___range__109_109_char_class___range__98_98_char_class___range__111_111_char_class___range__108_108_ = (IConstructor) _read("prod(lit(\"symbol\"),[\\char-class([range(115,115)]),\\char-class([range(121,121)]),\\char-class([range(109,109)]),\\char-class([range(98,98)]),\\char-class([range(111,111)]),\\char-class([range(108,108)])],{})", Factory.Production);
  private static final IConstructor regular__iter_star__char_class___range__48_57 = (IConstructor) _read("regular(\\iter-star(\\char-class([range(48,57)])))", Factory.Production);
  private static final IConstructor prod__regexp_Exp__lit_regexp_ = (IConstructor) _read("prod(label(\"regexp\",sort(\"Exp\")),[lit(\"regexp\")],{})", Factory.Production);
  private static final IConstructor prod__Integer__opt__char_class___range__43_43_range__45_45_IntValue_opt__char_class___range__78_78_ = (IConstructor) _read("prod(lex(\"Integer\"),[opt(\\char-class([range(43,43),range(45,45)])),lex(\"IntValue\"),opt(\\char-class([range(78,78)]))],{})", Factory.Production);
  private static final IConstructor prod__layouts_$BACKTICKS__ = (IConstructor) _read("prod(layouts(\"$BACKTICKS\"),[],{})", Factory.Production);
  private static final IConstructor prod__plus_Exp__lit___123_layouts_Meta_Exp_layouts_Meta_lit___125_layouts_Meta_lit___43_ = (IConstructor) _read("prod(label(\"plus\",sort(\"Exp\")),[lit(\"{\"),layouts(\"Meta\"),sort(\"Exp\"),layouts(\"Meta\"),lit(\"}\"),layouts(\"Meta\"),lit(\"+\")],{})", Factory.Production);
  private static final IConstructor regular__opt__char_class___range__48_57 = (IConstructor) _read("regular(opt(\\char-class([range(48,57)])))", Factory.Production);
  private static final IConstructor prod__lit___34_125_34__char_class___range__34_34_char_class___range__125_125_char_class___range__34_34_ = (IConstructor) _read("prod(lit(\"\\\"}\\\"\"),[\\char-class([range(34,34)]),\\char-class([range(125,125)]),\\char-class([range(34,34)])],{})", Factory.Production);
  private static final IConstructor prod__lit_newline__char_class___range__110_110_char_class___range__101_101_char_class___range__119_119_char_class___range__108_108_char_class___range__105_105_char_class___range__110_110_char_class___range__101_101_ = (IConstructor) _read("prod(lit(\"newline\"),[\\char-class([range(110,110)]),\\char-class([range(101,101)]),\\char-class([range(119,119)]),\\char-class([range(108,108)]),\\char-class([range(105,105)]),\\char-class([range(110,110)]),\\char-class([range(101,101)])],{})", Factory.Production);
  private static final IConstructor prod__String1__char_class___range__92_92_char_class___range__34_34_iter_star__StrChar1_char_class___range__92_92_char_class___range__34_34_ = (IConstructor) _read("prod(lex(\"String1\"),[\\char-class([range(92,92)]),\\char-class([range(34,34)]),\\iter-star(lex(\"StrChar1\")),\\char-class([range(92,92)]),\\char-class([range(34,34)])],{})", Factory.Production);
  private static final IConstructor prod__char_Exp__lit_char_ = (IConstructor) _read("prod(label(\"char\",sort(\"Exp\")),[lit(\"char\")],{})", Factory.Production);
  private static final IConstructor prod__Tokens__lit_grammar_ = (IConstructor) _read("prod(keywords(\"Tokens\"),[lit(\"grammar\")],{})", Factory.Production);
  private static final IConstructor prod__layouts_$default$__ = (IConstructor) _read("prod(layouts(\"$default$\"),[],{})", Factory.Production);
  private static final IConstructor prod__Stem__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_ = (IConstructor) _read("prod(lex(\"Stem\"),[seq([conditional(\\char-class([range(45,45)]),{\\not-precede(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))}),\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]),conditional(\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),{\\not-follow(\\char-class([range(33,33),range(35,36),range(38,39),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))})])],{})", Factory.Production);
  private static final IConstructor prod__ratio_Number__Ratio_ = (IConstructor) _read("prod(label(\"ratio\",sort(\"Number\")),[lex(\"Ratio\")],{})", Factory.Production);
  private static final IConstructor regular__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124 = (IConstructor) _read("regular(seq([conditional(\\char-class([range(45,45)]),{\\not-precede(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))}),\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]),conditional(\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),{\\not-follow(\\char-class([range(33,33),range(35,36),range(38,39),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))})]))", Factory.Production);
  private static final IConstructor prod__integer_Number__Integer_ = (IConstructor) _read("prod(label(\"integer\",sort(\"Number\")),[lex(\"Integer\")],{})", Factory.Production);
  private static final IConstructor prod__deref_Exp__lit___34_64_34_layouts_Meta_Exp_ = (IConstructor) _read("prod(label(\"deref\",sort(\"Exp\")),[lit(\"\\\"@\\\"\"),layouts(\"Meta\"),sort(\"Exp\")],{})", Factory.Production);
  private static final IConstructor prod__StrChar__char_class___range__92_92_char_class___range__48_51_char_class___range__48_55_char_class___range__48_55_ = (IConstructor) _read("prod(lex(\"StrChar\"),[\\char-class([range(92,92)]),\\char-class([range(48,51)]),\\char-class([range(48,55)]),\\char-class([range(48,55)])],{})", Factory.Production);
  private static final IConstructor prod__StrChar__char_class___range__0_33_range__35_91_range__93_16777215_ = (IConstructor) _read("prod(lex(\"StrChar\"),[\\char-class([range(0,33),range(35,91),range(93,16777215)])],{})", Factory.Production);
  private static final IConstructor prod__StrChar1__char_class___range__0_33_range__35_91_range__93_16777215_ = (IConstructor) _read("prod(lex(\"StrChar1\"),[\\char-class([range(0,33),range(35,91),range(93,16777215)])],{})", Factory.Production);
  private static final IConstructor prod__Stem__seq___conditional__char_class___range__33_33_range__38_38_range__42_43_range__46_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_ = (IConstructor) _read("prod(lex(\"Stem\"),[seq([conditional(\\char-class([range(33,33),range(38,38),range(42,43),range(46,46),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]),{\\not-precede(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))}),conditional(\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),{\\not-follow(\\char-class([range(33,33),range(35,36),range(38,39),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))})])],{})", Factory.Production);
  private static final IConstructor prod__RegExp__char_class___range__35_35_char_class___range__34_34_iter_star__alt___char_class___range__0_33_range__35_16777215_seq___char_class___range__92_92_char_class___range__34_34_char_class___range__34_34_ = (IConstructor) _read("prod(lex(\"RegExp\"),[\\char-class([range(35,35)]),\\char-class([range(34,34)]),\\iter-star(alt({\\char-class([range(0,33),range(35,16777215)]),seq([\\char-class([range(92,92)]),\\char-class([range(34,34)])])})),\\char-class([range(34,34)])],{})", Factory.Production);
  private static final IConstructor prod__layouts_Meta__conditional__iter_star__MetaWhitespaceOrComment__not_follow__char_class___range__9_10_range__12_13_range__32_32_not_follow__lit___59_ = (IConstructor) _read("prod(layouts(\"Meta\"),[conditional(\\iter-star(sort(\"MetaWhitespaceOrComment\")),{\\not-follow(\\char-class([range(9,10),range(12,13),range(32,32)])),\\not-follow(lit(\";\"))})],{})", Factory.Production);
  private static final IConstructor prod__form_Exp__lit_form_ = (IConstructor) _read("prod(label(\"form\",sort(\"Exp\")),[lit(\"form\")],{})", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__39_39 = (IConstructor) _read("regular(iter(\\char-class([range(39,39)])))", Factory.Production);
  private static final IConstructor prod__lit___34_64_34__char_class___range__34_34_char_class___range__64_64_char_class___range__34_34_ = (IConstructor) _read("prod(lit(\"\\\"@\\\"\"),[\\char-class([range(34,34)]),\\char-class([range(64,64)]),\\char-class([range(34,34)])],{})", Factory.Production);
  private static final IConstructor regular__seq___conditional__char_class___range__33_33_range__38_38_range__42_43_range__46_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124 = (IConstructor) _read("regular(seq([conditional(\\char-class([range(33,33),range(38,38),range(42,43),range(46,46),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]),{\\not-precede(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))}),conditional(\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),{\\not-follow(\\char-class([range(33,33),range(35,36),range(38,39),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))})]))", Factory.Production);
  private static final IConstructor prod__vectorLit_Exp__lit___34_91_34_layouts_Meta_iter_star_seps__Exp__layouts_Meta_layouts_Meta_lit___34_93_34_ = (IConstructor) _read("prod(label(\"vectorLit\",sort(\"Exp\")),[lit(\"\\\"[\\\"\"),layouts(\"Meta\"),\\iter-star-seps(sort(\"Exp\"),[layouts(\"Meta\")]),layouts(\"Meta\"),lit(\"\\\"]\\\"\")],{})", Factory.Production);
  private static final IConstructor prod__quote_Exp__lit___34_39_34_layouts_Meta_Exp_ = (IConstructor) _read("prod(label(\"quote\",sort(\"Exp\")),[lit(\"\\\"\\'\\\\\\\"\"),layouts(\"Meta\"),sort(\"Exp\")],{})", Factory.Production);
  private static final IConstructor prod__MetaLiteral__String1_ = (IConstructor) _read("prod(lex(\"MetaLiteral\"),[lex(\"String1\")],{})", Factory.Production);
  private static final IConstructor prod__unquotes_Exp__lit___34_126_64_34_layouts_Meta_Exp_ = (IConstructor) _read("prod(label(\"unquotes\",sort(\"Exp\")),[lit(\"\\\"~@\\\"\"),layouts(\"Meta\"),sort(\"Exp\")],{})", Factory.Production);
  private static final IConstructor prod__MetaWhitespace__char_class___range__9_10_range__12_13_range__32_32_ = (IConstructor) _read("prod(lex(\"MetaWhitespace\"),[\\char-class([range(9,10),range(12,13),range(32,32)])],{})", Factory.Production);
  private static final IConstructor prod__grammar_MetaGrammar__lit_grammar_layouts_Meta_iter_seps__Rule__layouts_Meta_ = (IConstructor) _read("prod(label(\"grammar\",sort(\"MetaGrammar\")),[lit(\"grammar\"),layouts(\"Meta\"),\\iter-seps(sort(\"Rule\"),[layouts(\"Meta\")])],{})", Factory.Production);
  private static final IConstructor prod__Literal__char_class___range__34_34_layouts_Meta_MetaLiteral_layouts_Meta_char_class___range__34_34_ = (IConstructor) _read("prod(sort(\"Literal\"),[\\char-class([range(34,34)]),layouts(\"Meta\"),lex(\"MetaLiteral\"),layouts(\"Meta\"),\\char-class([range(34,34)])],{})", Factory.Production);
  private static final IConstructor prod__MetaLiteral__Integer_ = (IConstructor) _read("prod(lex(\"MetaLiteral\"),[lex(\"Integer\")],{})", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_55 = (IConstructor) _read("regular(iter(\\char-class([range(48,55)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_57 = (IConstructor) _read("regular(iter(\\char-class([range(48,57)])))", Factory.Production);
  private static final IConstructor prod__lit_char__char_class___range__99_99_char_class___range__104_104_char_class___range__97_97_char_class___range__114_114_ = (IConstructor) _read("prod(lit(\"char\"),[\\char-class([range(99,99)]),\\char-class([range(104,104)]),\\char-class([range(97,97)]),\\char-class([range(114,114)])],{})", Factory.Production);
  private static final IConstructor regular__opt__char_class___range__78_78 = (IConstructor) _read("regular(opt(\\char-class([range(78,78)])))", Factory.Production);
  private static final IConstructor regular__opt__char_class___range__77_77 = (IConstructor) _read("regular(opt(\\char-class([range(77,77)])))", Factory.Production);
  private static final IConstructor prod__lit___34_40_34__char_class___range__34_34_char_class___range__40_40_char_class___range__34_34_ = (IConstructor) _read("prod(lit(\"\\\"(\\\"\"),[\\char-class([range(34,34)]),\\char-class([range(40,40)]),\\char-class([range(34,34)])],{})", Factory.Production);
  private static final IConstructor prod__listLit_Exp__lit___34_40_34_layouts_Meta_iter_star_seps__Exp__layouts_Meta_layouts_Meta_lit___34_41_34_ = (IConstructor) _read("prod(label(\"listLit\",sort(\"Exp\")),[lit(\"\\\"(\\\"\"),layouts(\"Meta\"),\\iter-star-seps(sort(\"Exp\"),[layouts(\"Meta\")]),layouts(\"Meta\"),lit(\"\\\")\\\"\")],{})", Factory.Production);
  private static final IConstructor prod__lit_tab__char_class___range__116_116_char_class___range__97_97_char_class___range__98_98_ = (IConstructor) _read("prod(lit(\"tab\"),[\\char-class([range(116,116)]),\\char-class([range(97,97)]),\\char-class([range(98,98)])],{})", Factory.Production);
  private static final IConstructor prod__lit_keyword__char_class___range__107_107_char_class___range__101_101_char_class___range__121_121_char_class___range__119_119_char_class___range__111_111_char_class___range__114_114_char_class___range__100_100_ = (IConstructor) _read("prod(lit(\"keyword\"),[\\char-class([range(107,107)]),\\char-class([range(101,101)]),\\char-class([range(121,121)]),\\char-class([range(119,119)]),\\char-class([range(111,111)]),\\char-class([range(114,114)]),\\char-class([range(100,100)])],{})", Factory.Production);
  private static final IConstructor prod__lit___34_126_64_34__char_class___range__34_34_char_class___range__126_126_char_class___range__64_64_char_class___range__34_34_ = (IConstructor) _read("prod(lit(\"\\\"~@\\\"\"),[\\char-class([range(34,34)]),\\char-class([range(126,126)]),\\char-class([range(64,64)]),\\char-class([range(34,34)])],{})", Factory.Production);
  private static final IConstructor prod__rule_Rule__MetaIdent_layouts_Meta_lit___61_layouts_Meta_iter_seps__Alt__layouts_Meta_lit___124_layouts_Meta_ = (IConstructor) _read("prod(label(\"rule\",sort(\"Rule\")),[lex(\"MetaIdent\"),layouts(\"Meta\"),lit(\"=\"),layouts(\"Meta\"),\\iter-seps(sort(\"Alt\"),[layouts(\"Meta\"),lit(\"|\"),layouts(\"Meta\")])],{})", Factory.Production);
  private static final IConstructor prod__alt_Alt__Ident_layouts_Meta_iter_star_seps__Exp__layouts_Meta_ = (IConstructor) _read("prod(label(\"alt\",sort(\"Alt\")),[lex(\"Ident\"),layouts(\"Meta\"),\\iter-star-seps(sort(\"Exp\"),[layouts(\"Meta\")])],{})", Factory.Production);
  private static final IConstructor prod__IntValue__conditional__char_class___range__48_48__not_follow__char_class___range__48_55_range__88_88_range__120_120_ = (IConstructor) _read("prod(lex(\"IntValue\"),[conditional(\\char-class([range(48,48)]),{\\not-follow(\\char-class([range(48,55),range(88,88),range(120,120)]))})],{})", Factory.Production);
  private static final IConstructor prod__Symbol__Ident_ = (IConstructor) _read("prod(lex(\"Symbol\"),[lex(\"Ident\")],{})", Factory.Production);
  private static final IConstructor prod__MetaLiteral__Ratio_ = (IConstructor) _read("prod(lex(\"MetaLiteral\"),[lex(\"Ratio\")],{})", Factory.Production);
  private static final IConstructor regular__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__46_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39 = (IConstructor) _read("regular(seq([conditional(\\char-class([range(45,45)]),{\\not-precede(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))}),\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(46,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]),\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),conditional(iter(\\char-class([range(39,39)])),{\\not-follow(\\char-class([range(39,39)]))})]))", Factory.Production);
  private static final IConstructor prod__lit___34_123_34__char_class___range__34_34_char_class___range__123_123_char_class___range__34_34_ = (IConstructor) _read("prod(lit(\"\\\"{\\\"\"),[\\char-class([range(34,34)]),\\char-class([range(123,123)]),\\char-class([range(34,34)])],{})", Factory.Production);
  private static final IConstructor regular__iter_star__char_class___range__9_10_range__13_13_range__32_32 = (IConstructor) _read("regular(\\iter-star(\\char-class([range(9,10),range(13,13),range(32,32)])))", Factory.Production);
  private static final IConstructor prod__metaString_Exp__lit___34_94_34_layouts_Meta_lit_string_ = (IConstructor) _read("prod(label(\"metaString\",sort(\"Exp\")),[lit(\"\\\"^\\\"\"),layouts(\"Meta\"),lit(\"string\")],{})", Factory.Production);
  private static final IConstructor prod__Char__char_class___range__92_92_lit_return_ = (IConstructor) _read("prod(lex(\"Char\"),[\\char-class([range(92,92)]),lit(\"return\")],{})", Factory.Production);
  private static final IConstructor prod__MetaLiteral__char_class___range__44_44_ = (IConstructor) _read("prod(lex(\"MetaLiteral\"),[\\char-class([range(44,44)])],{})", Factory.Production);
  private static final IConstructor regular__iter_seps__Alt__layouts_Meta_lit___124_layouts_Meta = (IConstructor) _read("regular(\\iter-seps(sort(\"Alt\"),[layouts(\"Meta\"),lit(\"|\"),layouts(\"Meta\")]))", Factory.Production);
  private static final IConstructor prod__qquote_Exp__lit___34_96_34_layouts_Meta_Exp_ = (IConstructor) _read("prod(label(\"qquote\",sort(\"Exp\")),[lit(\"\\\"`\\\"\"),layouts(\"Meta\"),sort(\"Exp\")],{})", Factory.Production);
  private static final IConstructor prod__number_Exp__lit_number_ = (IConstructor) _read("prod(label(\"number\",sort(\"Exp\")),[lit(\"number\")],{})", Factory.Production);
  private static final IConstructor prod__Tokens__lit_form_ = (IConstructor) _read("prod(keywords(\"Tokens\"),[lit(\"form\")],{})", Factory.Production);
  private static final IConstructor prod__comment_MetaWhitespaceOrComment__MetaComment_ = (IConstructor) _read("prod(label(\"comment\",sort(\"MetaWhitespaceOrComment\")),[lex(\"MetaComment\")],{})", Factory.Production);
  private static final IConstructor prod__lit_ident__char_class___range__105_105_char_class___range__100_100_char_class___range__101_101_char_class___range__110_110_char_class___range__116_116_ = (IConstructor) _read("prod(lit(\"ident\"),[\\char-class([range(105,105)]),\\char-class([range(100,100)]),\\char-class([range(101,101)]),\\char-class([range(110,110)]),\\char-class([range(116,116)])],{})", Factory.Production);
  private static final IConstructor prod__Char__char_class___range__92_92_lit_tab_ = (IConstructor) _read("prod(lex(\"Char\"),[\\char-class([range(92,92)]),lit(\"tab\")],{})", Factory.Production);
  private static final IConstructor prod__lit___34_41_34__char_class___range__34_34_char_class___range__41_41_char_class___range__34_34_ = (IConstructor) _read("prod(lit(\"\\\")\\\"\"),[\\char-class([range(34,34)]),\\char-class([range(41,41)]),\\char-class([range(34,34)])],{})", Factory.Production);
  private static final IConstructor prod__String__char_class___range__34_34_iter_star__StrChar_char_class___range__34_34__tag__category___83_116_114_105_110_103_76_105_116_101_114_97_108 = (IConstructor) _read("prod(lex(\"String\"),[\\char-class([range(34,34)]),\\iter-star(lex(\"StrChar\")),\\char-class([range(34,34)])],{tag(category(\"StringLiteral\"))})", Factory.Production);
  private static final IConstructor prod__lit_backspace__char_class___range__98_98_char_class___range__97_97_char_class___range__99_99_char_class___range__107_107_char_class___range__115_115_char_class___range__112_112_char_class___range__97_97_char_class___range__99_99_char_class___range__101_101_ = (IConstructor) _read("prod(lit(\"backspace\"),[\\char-class([range(98,98)]),\\char-class([range(97,97)]),\\char-class([range(99,99)]),\\char-class([range(107,107)]),\\char-class([range(115,115)]),\\char-class([range(112,112)]),\\char-class([range(97,97)]),\\char-class([range(99,99)]),\\char-class([range(101,101)])],{})", Factory.Production);
  private static final IConstructor prod__lit_regexp__char_class___range__114_114_char_class___range__101_101_char_class___range__103_103_char_class___range__101_101_char_class___range__120_120_char_class___range__112_112_ = (IConstructor) _read("prod(lit(\"regexp\"),[\\char-class([range(114,114)]),\\char-class([range(101,101)]),\\char-class([range(103,103)]),\\char-class([range(101,101)]),\\char-class([range(120,120)]),\\char-class([range(112,112)])],{})", Factory.Production);
  private static final IConstructor prod__Ident__opt__lit___58_conditional__iter_seps__Stem__lit___58__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_ = (IConstructor) _read("prod(lex(\"Ident\"),[opt(lit(\":\")),conditional(\\iter-seps(lex(\"Stem\"),[lit(\":\")]),{\\not-follow(\\char-class([range(33,33),range(35,36),range(38,39),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))})],{})", Factory.Production);
  private static final IConstructor prod__lit_integer__char_class___range__105_105_char_class___range__110_110_char_class___range__116_116_char_class___range__101_101_char_class___range__103_103_char_class___range__101_101_char_class___range__114_114_ = (IConstructor) _read("prod(lit(\"integer\"),[\\char-class([range(105,105)]),\\char-class([range(110,110)]),\\char-class([range(116,116)]),\\char-class([range(101,101)]),\\char-class([range(103,103)]),\\char-class([range(101,101)]),\\char-class([range(114,114)])],{})", Factory.Production);
  private static final IConstructor prod__Stem__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__46_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39_ = (IConstructor) _read("prod(lex(\"Stem\"),[seq([conditional(\\char-class([range(45,45)]),{\\not-precede(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))}),\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(46,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]),\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),conditional(iter(\\char-class([range(39,39)])),{\\not-follow(\\char-class([range(39,39)]))})])],{})", Factory.Production);
  private static final IConstructor prod__MetaIdent__conditional__Ident__delete__Tokens_ = (IConstructor) _read("prod(lex(\"MetaIdent\"),[conditional(lex(\"Ident\"),{delete(keywords(\"Tokens\"))})],{})", Factory.Production);
  private static final IConstructor prod__lit_space__char_class___range__115_115_char_class___range__112_112_char_class___range__97_97_char_class___range__99_99_char_class___range__101_101_ = (IConstructor) _read("prod(lit(\"space\"),[\\char-class([range(115,115)]),\\char-class([range(112,112)]),\\char-class([range(97,97)]),\\char-class([range(99,99)]),\\char-class([range(101,101)])],{})", Factory.Production);
  private static final IConstructor prod__StrChar1__char_class___range__92_92_char_class___range__92_92_char_class___range__117_117_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_ = (IConstructor) _read("prod(lex(\"StrChar1\"),[\\char-class([range(92,92)]),\\char-class([range(92,92)]),\\char-class([range(117,117)]),\\char-class([range(48,57),range(65,70),range(97,102)]),\\char-class([range(48,57),range(65,70),range(97,102)]),\\char-class([range(48,57),range(65,70),range(97,102)]),\\char-class([range(48,57),range(65,70),range(97,102)])],{})", Factory.Production);
  private static final IConstructor prod__Tokens__lit_char_ = (IConstructor) _read("prod(keywords(\"Tokens\"),[lit(\"char\")],{})", Factory.Production);
  private static final IConstructor prod__metaMap_Exp__lit___34_94_34_layouts_Meta_lit___34_123_34_layouts_Meta_iter_star_seps__Exp__layouts_Meta_layouts_Meta_lit___34_125_34_ = (IConstructor) _read("prod(label(\"metaMap\",sort(\"Exp\")),[lit(\"\\\"^\\\"\"),layouts(\"Meta\"),lit(\"\\\"{\\\"\"),layouts(\"Meta\"),\\iter-star-seps(sort(\"Exp\"),[layouts(\"Meta\")]),layouts(\"Meta\"),lit(\"\\\"}\\\"\")],{})", Factory.Production);
  private static final IConstructor regular__iter_star_seps__Exp__layouts_Meta = (IConstructor) _read("regular(\\iter-star-seps(sort(\"Exp\"),[layouts(\"Meta\")]))", Factory.Production);
  private static final IConstructor prod__Ratio__opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__47_47_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57_ = (IConstructor) _read("prod(lex(\"Ratio\"),[opt(\\char-class([range(43,43),range(45,45)])),iter(\\char-class([range(48,57)])),\\char-class([range(47,47)]),conditional(iter(\\char-class([range(48,57)])),{\\not-follow(\\char-class([range(48,57)]))})],{})", Factory.Production);
  private static final IConstructor prod__MetaLiteral__Symbol_ = (IConstructor) _read("prod(lex(\"MetaLiteral\"),[lex(\"Symbol\")],{})", Factory.Production);
  private static final IConstructor regular__iter_star__char_class___range__0_9_range__11_12_range__14_16777215 = (IConstructor) _read("regular(\\iter-star(\\char-class([range(0,9),range(11,12),range(14,16777215)])))", Factory.Production);
  private static final IConstructor prod__lit_string__char_class___range__115_115_char_class___range__116_116_char_class___range__114_114_char_class___range__105_105_char_class___range__110_110_char_class___range__103_103_ = (IConstructor) _read("prod(lit(\"string\"),[\\char-class([range(115,115)]),\\char-class([range(116,116)]),\\char-class([range(114,114)]),\\char-class([range(105,105)]),\\char-class([range(110,110)]),\\char-class([range(103,103)])],{})", Factory.Production);
  private static final IConstructor prod__mapLit_Exp__lit___34_123_34_layouts_Meta_iter_star_seps__Exp__layouts_Meta_layouts_Meta_lit___34_125_34_ = (IConstructor) _read("prod(label(\"mapLit\",sort(\"Exp\")),[lit(\"\\\"{\\\"\"),layouts(\"Meta\"),\\iter-star-seps(sort(\"Exp\"),[layouts(\"Meta\")]),layouts(\"Meta\"),lit(\"\\\"}\\\"\")],{})", Factory.Production);
  private static final IConstructor prod__Stem__seq___conditional__char_class___range__33_33_range__38_38_range__42_43_range__46_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39_ = (IConstructor) _read("prod(lex(\"Stem\"),[seq([conditional(\\char-class([range(33,33),range(38,38),range(42,43),range(46,46),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]),{\\not-precede(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))}),\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),conditional(iter(\\char-class([range(39,39)])),{\\not-follow(\\char-class([range(39,39)]))})])],{})", Factory.Production);
  private static final IConstructor prod__Symbol__conditional__lit___47__not_follow__char_class___range__33_33_range__38_38_range__42_43_range__45_46_range__58_58_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_ = (IConstructor) _read("prod(lex(\"Symbol\"),[conditional(lit(\"/\"),{\\not-follow(\\char-class([range(33,33),range(38,38),range(42,43),range(45,46),range(58,58),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),\\not-precede(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))})],{})", Factory.Production);
  private static final IConstructor regular__iter_seps__Stem__lit___58 = (IConstructor) _read("regular(\\iter-seps(lex(\"Stem\"),[lit(\":\")]))", Factory.Production);
  private static final IConstructor prod__lit___59__char_class___range__59_59_ = (IConstructor) _read("prod(lit(\";\"),[\\char-class([range(59,59)])],{})", Factory.Production);
  private static final IConstructor prod__MetaLiteral__Char_ = (IConstructor) _read("prod(lex(\"MetaLiteral\"),[lex(\"Char\")],{})", Factory.Production);
  private static final IConstructor prod__lit___58__char_class___range__58_58_ = (IConstructor) _read("prod(lit(\":\"),[\\char-class([range(58,58)])],{})", Factory.Production);
  private static final IConstructor prod__lit___61__char_class___range__61_61_ = (IConstructor) _read("prod(lit(\"=\"),[\\char-class([range(61,61)])],{})", Factory.Production);
  private static final IConstructor regular__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57 = (IConstructor) _read("regular(seq([\\char-class([range(69,69),range(101,101)]),opt(\\char-class([range(43,43),range(45,45)])),conditional(iter(\\char-class([range(48,57)])),{\\not-follow(\\char-class([range(48,57)]))})]))", Factory.Production);
  private static final IConstructor prod__Char__char_class___range__92_92_lit_backspace_ = (IConstructor) _read("prod(lex(\"Char\"),[\\char-class([range(92,92)]),lit(\"backspace\")],{})", Factory.Production);
  private static final IConstructor prod__lit___63__char_class___range__63_63_ = (IConstructor) _read("prod(lit(\"?\"),[\\char-class([range(63,63)])],{})", Factory.Production);
  private static final IConstructor regular__opt__char_class___range__43_43_range__45_45 = (IConstructor) _read("regular(opt(\\char-class([range(43,43),range(45,45)])))", Factory.Production);
  private static final IConstructor prod__lit___34_96_34__char_class___range__34_34_char_class___range__96_96_char_class___range__34_34_ = (IConstructor) _read("prod(lit(\"\\\"`\\\"\"),[\\char-class([range(34,34)]),\\char-class([range(96,96)]),\\char-class([range(34,34)])],{})", Factory.Production);
  private static final IConstructor prod__StrChar1__char_class___range__92_92_char_class___range__92_92_char_class___range__48_51_char_class___range__48_55_char_class___range__48_55_ = (IConstructor) _read("prod(lex(\"StrChar1\"),[\\char-class([range(92,92)]),\\char-class([range(92,92)]),\\char-class([range(48,51)]),\\char-class([range(48,55)]),\\char-class([range(48,55)])],{})", Factory.Production);
  private static final IConstructor regular__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39 = (IConstructor) _read("regular(seq([conditional(\\char-class([range(45,45)]),{\\not-precede(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))}),conditional(iter(\\char-class([range(39,39)])),{\\not-follow(\\char-class([range(39,39)]))})]))", Factory.Production);
  private static final IConstructor prod__empty__ = (IConstructor) _read("prod(empty(),[],{})", Factory.Production);
  private static final IConstructor prod__nonTerminal_Exp__MetaIdent_ = (IConstructor) _read("prod(label(\"nonTerminal\",sort(\"Exp\")),[lex(\"MetaIdent\")],{})", Factory.Production);
  private static final IConstructor prod__float_Exp__lit_float_ = (IConstructor) _read("prod(label(\"float\",sort(\"Exp\")),[lit(\"float\")],{})", Factory.Production);
  private static final IConstructor prod__StrChar1__char_class___range__92_92_char_class___range__92_92_char_class___range__34_34_range__92_92_range__98_98_range__102_102_range__110_110_range__114_114_range__116_116_ = (IConstructor) _read("prod(lex(\"StrChar1\"),[\\char-class([range(92,92)]),\\char-class([range(92,92)]),\\char-class([range(34,34),range(92,92),range(98,98),range(102,102),range(110,110),range(114,114),range(116,116)])],{})", Factory.Production);
  private static final IConstructor prod__lit_rational__char_class___range__114_114_char_class___range__97_97_char_class___range__116_116_char_class___range__105_105_char_class___range__111_111_char_class___range__110_110_char_class___range__97_97_char_class___range__108_108_ = (IConstructor) _read("prod(lit(\"rational\"),[\\char-class([range(114,114)]),\\char-class([range(97,97)]),\\char-class([range(116,116)]),\\char-class([range(105,105)]),\\char-class([range(111,111)]),\\char-class([range(110,110)]),\\char-class([range(97,97)]),\\char-class([range(108,108)])],{})", Factory.Production);
  private static final IConstructor prod__lit___43__char_class___range__43_43_ = (IConstructor) _read("prod(lit(\"+\"),[\\char-class([range(43,43)])],{})", Factory.Production);
  private static final IConstructor prod__lit___42__char_class___range__42_42_ = (IConstructor) _read("prod(lit(\"*\"),[\\char-class([range(42,42)])],{})", Factory.Production);
  private static final IConstructor prod__FloatValue__iter__char_class___range__48_57_char_class___range__46_46_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57_ = (IConstructor) _read("prod(lex(\"FloatValue\"),[iter(\\char-class([range(48,57)])),\\char-class([range(46,46)]),conditional(iter(\\char-class([range(48,57)])),{\\not-follow(\\char-class([range(48,57)]))}),opt(seq([\\char-class([range(69,69),range(101,101)]),opt(\\char-class([range(43,43),range(45,45)])),conditional(iter(\\char-class([range(48,57)])),{\\not-follow(\\char-class([range(48,57)]))})]))],{})", Factory.Production);
  private static final IConstructor prod__lit_formfeed__char_class___range__102_102_char_class___range__111_111_char_class___range__114_114_char_class___range__109_109_char_class___range__102_102_char_class___range__101_101_char_class___range__101_101_char_class___range__100_100_ = (IConstructor) _read("prod(lit(\"formfeed\"),[\\char-class([range(102,102)]),\\char-class([range(111,111)]),\\char-class([range(114,114)]),\\char-class([range(109,109)]),\\char-class([range(102,102)]),\\char-class([range(101,101)]),\\char-class([range(101,101)]),\\char-class([range(100,100)])],{})", Factory.Production);
  private static final IConstructor prod__lit___47__char_class___range__47_47_ = (IConstructor) _read("prod(lit(\"/\"),[\\char-class([range(47,47)])],{})", Factory.Production);
  private static final IConstructor regular__iter_star__MetaWhitespaceOrComment = (IConstructor) _read("regular(\\iter-star(sort(\"MetaWhitespaceOrComment\")))", Factory.Production);
  private static final IConstructor prod__lit___46__char_class___range__46_46_ = (IConstructor) _read("prod(lit(\".\"),[\\char-class([range(46,46)])],{})", Factory.Production);
  private static final IConstructor regular__alt___char_class___range__0_33_range__35_16777215_seq___char_class___range__92_92_char_class___range__34_34 = (IConstructor) _read("regular(alt({\\char-class([range(0,33),range(35,16777215)]),seq([\\char-class([range(92,92)]),\\char-class([range(34,34)])])}))", Factory.Production);
  private static final IConstructor prod__lit___34_39_34__char_class___range__34_34_char_class___range__39_39_char_class___range__34_34_ = (IConstructor) _read("prod(lit(\"\\\"\\'\\\\\\\"\"),[\\char-class([range(34,34)]),\\char-class([range(39,39)]),\\char-class([range(34,34)])],{})", Factory.Production);
  private static final IConstructor prod__Stem__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39_ = (IConstructor) _read("prod(lex(\"Stem\"),[seq([conditional(\\char-class([range(45,45)]),{\\not-precede(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))}),conditional(iter(\\char-class([range(39,39)])),{\\not-follow(\\char-class([range(39,39)]))})])],{})", Factory.Production);
  private static final IConstructor prod__IntValue__char_class___range__48_48_conditional__iter__char_class___range__48_55__not_follow__char_class___range__48_55_ = (IConstructor) _read("prod(lex(\"IntValue\"),[\\char-class([range(48,48)]),conditional(iter(\\char-class([range(48,55)])),{\\not-follow(\\char-class([range(48,55)]))})],{})", Factory.Production);
  private static final IConstructor prod__Tokens__lit_symbol_ = (IConstructor) _read("prod(keywords(\"Tokens\"),[lit(\"symbol\")],{})", Factory.Production);
  private static final IConstructor prod__lit_return__char_class___range__114_114_char_class___range__101_101_char_class___range__116_116_char_class___range__117_117_char_class___range__114_114_char_class___range__110_110_ = (IConstructor) _read("prod(lit(\"return\"),[\\char-class([range(114,114)]),\\char-class([range(101,101)]),\\char-class([range(116,116)]),\\char-class([range(117,117)]),\\char-class([range(114,114)]),\\char-class([range(110,110)])],{})", Factory.Production);
  private static final IConstructor regular__iter_star__StrChar = (IConstructor) _read("regular(\\iter-star(lex(\"StrChar\")))", Factory.Production);
  private static final IConstructor prod__lit___34_126_34__char_class___range__34_34_char_class___range__126_126_char_class___range__34_34_ = (IConstructor) _read("prod(lit(\"\\\"~\\\"\"),[\\char-class([range(34,34)]),\\char-class([range(126,126)]),\\char-class([range(34,34)])],{})", Factory.Production);
  private static final IConstructor prod__starSep_Exp__lit___123_layouts_Meta_Exp_layouts_Meta_Literal_layouts_Meta_lit___125_layouts_Meta_lit___42_ = (IConstructor) _read("prod(label(\"starSep\",sort(\"Exp\")),[lit(\"{\"),layouts(\"Meta\"),sort(\"Exp\"),layouts(\"Meta\"),lex(\"Literal\"),layouts(\"Meta\"),lit(\"}\"),layouts(\"Meta\"),lit(\"*\")],{})", Factory.Production);
  private static final IConstructor prod__StrChar__char_class___range__92_92_char_class___range__34_34_range__92_92_range__98_98_range__102_102_range__110_110_range__114_114_range__116_116_ = (IConstructor) _read("prod(lex(\"StrChar\"),[\\char-class([range(92,92)]),\\char-class([range(34,34),range(92,92),range(98,98),range(102,102),range(110,110),range(114,114),range(116,116)])],{})", Factory.Production);
  private static final IConstructor prod__lit___34_93_34__char_class___range__34_34_char_class___range__93_93_char_class___range__34_34_ = (IConstructor) _read("prod(lit(\"\\\"]\\\"\"),[\\char-class([range(34,34)]),\\char-class([range(93,93)]),\\char-class([range(34,34)])],{})", Factory.Production);
  private static final IConstructor prod__StrChar__char_class___range__92_92_char_class___range__117_117_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_ = (IConstructor) _read("prod(lex(\"StrChar\"),[\\char-class([range(92,92)]),\\char-class([range(117,117)]),\\char-class([range(48,57),range(65,70),range(97,102)]),\\char-class([range(48,57),range(65,70),range(97,102)]),\\char-class([range(48,57),range(65,70),range(97,102)]),\\char-class([range(48,57),range(65,70),range(97,102)])],{})", Factory.Production);
  private static final IConstructor regular__iter_seps__Rule__layouts_Meta = (IConstructor) _read("regular(\\iter-seps(sort(\"Rule\"),[layouts(\"Meta\")]))", Factory.Production);
  private static final IConstructor prod__Tokens__lit_number_ = (IConstructor) _read("prod(keywords(\"Tokens\"),[lit(\"number\")],{})", Factory.Production);
  private static final IConstructor prod__lit_form__char_class___range__102_102_char_class___range__111_111_char_class___range__114_114_char_class___range__109_109_ = (IConstructor) _read("prod(lit(\"form\"),[\\char-class([range(102,102)]),\\char-class([range(111,111)]),\\char-class([range(114,114)]),\\char-class([range(109,109)])],{})", Factory.Production);
  private static final IConstructor prod__Char__char_class___range__92_92_lit_newline_ = (IConstructor) _read("prod(lex(\"Char\"),[\\char-class([range(92,92)]),lit(\"newline\")],{})", Factory.Production);
  private static final IConstructor regular__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124 = (IConstructor) _read("regular(\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])))", Factory.Production);
  private static final IConstructor regular__iter_star__StrChar1 = (IConstructor) _read("regular(\\iter-star(lex(\"StrChar1\")))", Factory.Production);
  private static final IConstructor prod__IntValue__char_class___range__48_48_char_class___range__88_88_range__120_120_conditional__iter__char_class___range__48_57_range__65_70_range__97_102__not_follow__char_class___range__48_57_range__65_70_range__97_102_ = (IConstructor) _read("prod(lex(\"IntValue\"),[\\char-class([range(48,48)]),\\char-class([range(88,88),range(120,120)]),conditional(iter(\\char-class([range(48,57),range(65,70),range(97,102)])),{\\not-follow(\\char-class([range(48,57),range(65,70),range(97,102)]))})],{})", Factory.Production);
  private static final IConstructor prod__symbol_Exp__lit_symbol_ = (IConstructor) _read("prod(label(\"symbol\",sort(\"Exp\")),[lit(\"symbol\")],{})", Factory.Production);
  private static final IConstructor prod__MetaComment__lit___59_conditional__iter_star__char_class___range__0_9_range__11_12_range__14_16777215__end_of_line__tag__category___67_111_109_109_101_110_116 = (IConstructor) _read("prod(lex(\"MetaComment\"),[lit(\";\"),conditional(\\iter-star(\\char-class([range(0,9),range(11,12),range(14,16777215)])),{\\end-of-line()})],{tag(category(\"Comment\"))})", Factory.Production);
  private static final IConstructor prod__lit_number__char_class___range__110_110_char_class___range__117_117_char_class___range__109_109_char_class___range__98_98_char_class___range__101_101_char_class___range__114_114_ = (IConstructor) _read("prod(lit(\"number\"),[\\char-class([range(110,110)]),\\char-class([range(117,117)]),\\char-class([range(109,109)]),\\char-class([range(98,98)]),\\char-class([range(101,101)]),\\char-class([range(114,114)])],{})", Factory.Production);
  private static final IConstructor prod__unquote_Exp__lit___34_126_34_layouts_Meta_Exp_ = (IConstructor) _read("prod(label(\"unquote\",sort(\"Exp\")),[lit(\"\\\"~\\\"\"),layouts(\"Meta\"),sort(\"Exp\")],{})", Factory.Production);
  private static final IConstructor prod__integer_Exp__lit_integer_ = (IConstructor) _read("prod(label(\"integer\",sort(\"Exp\")),[lit(\"integer\")],{})", Factory.Production);
  private static final IConstructor prod__Tokens__lit_regexp_ = (IConstructor) _read("prod(keywords(\"Tokens\"),[lit(\"regexp\")],{})", Factory.Production);
  private static final IConstructor prod__fnLit_Exp__lit___34_35_40_34_layouts_Meta_iter_star_seps__Exp__layouts_Meta_layouts_Meta_lit___34_41_34_ = (IConstructor) _read("prod(label(\"fnLit\",sort(\"Exp\")),[lit(\"\\\"#(\\\"\"),layouts(\"Meta\"),\\iter-star-seps(sort(\"Exp\"),[layouts(\"Meta\")]),layouts(\"Meta\"),lit(\"\\\")\\\"\")],{})", Factory.Production);
  private static final IConstructor prod__Tokens__lit_rational_ = (IConstructor) _read("prod(keywords(\"Tokens\"),[lit(\"rational\")],{})", Factory.Production);
  private static final IConstructor regular__opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57 = (IConstructor) _read("regular(opt(seq([\\char-class([range(69,69),range(101,101)]),opt(\\char-class([range(43,43),range(45,45)])),conditional(iter(\\char-class([range(48,57)])),{\\not-follow(\\char-class([range(48,57)]))})])))", Factory.Production);
  private static final IConstructor prod__IntValue__char_class___range__49_57_conditional__iter_star__char_class___range__48_57__not_follow__char_class___range__48_57_ = (IConstructor) _read("prod(lex(\"IntValue\"),[\\char-class([range(49,57)]),conditional(\\iter-star(\\char-class([range(48,57)])),{\\not-follow(\\char-class([range(48,57)]))})],{})", Factory.Production);
  private static final IConstructor prod__lit_float__char_class___range__102_102_char_class___range__108_108_char_class___range__111_111_char_class___range__97_97_char_class___range__116_116_ = (IConstructor) _read("prod(lit(\"float\"),[\\char-class([range(102,102)]),\\char-class([range(108,108)]),\\char-class([range(111,111)]),\\char-class([range(97,97)]),\\char-class([range(116,116)])],{})", Factory.Production);
  private static final IConstructor prod__lit___123__char_class___range__123_123_ = (IConstructor) _read("prod(lit(\"{\"),[\\char-class([range(123,123)])],{})", Factory.Production);
  private static final IConstructor prod__keyword_Exp__lit_keyword_ = (IConstructor) _read("prod(label(\"keyword\",sort(\"Exp\")),[lit(\"keyword\")],{})", Factory.Production);
  private static final IConstructor prod__lit___34_94_34__char_class___range__34_34_char_class___range__94_94_char_class___range__34_34_ = (IConstructor) _read("prod(lit(\"\\\"^\\\"\"),[\\char-class([range(34,34)]),\\char-class([range(94,94)]),\\char-class([range(34,34)])],{})", Factory.Production);
  private static final IConstructor prod__lit___125__char_class___range__125_125_ = (IConstructor) _read("prod(lit(\"}\"),[\\char-class([range(125,125)])],{})", Factory.Production);
  private static final IConstructor prod__Float__opt__char_class___range__43_43_range__45_45_FloatValue_opt__char_class___range__77_77_ = (IConstructor) _read("prod(lex(\"Float\"),[opt(\\char-class([range(43,43),range(45,45)])),lex(\"FloatValue\"),opt(\\char-class([range(77,77)]))],{})", Factory.Production);
  private static final IConstructor prod__lit___124__char_class___range__124_124_ = (IConstructor) _read("prod(lit(\"|\"),[\\char-class([range(124,124)])],{})", Factory.Production);
  private static final IConstructor prod__opt_Exp__Exp_layouts_Meta_lit___63_ = (IConstructor) _read("prod(label(\"opt\",sort(\"Exp\")),[sort(\"Exp\"),layouts(\"Meta\"),lit(\"?\")],{})", Factory.Production);
  private static final IConstructor prod__lit___34_35_40_34__char_class___range__34_34_char_class___range__35_35_char_class___range__40_40_char_class___range__34_34_ = (IConstructor) _read("prod(lit(\"\\\"#(\\\"\"),[\\char-class([range(34,34)]),\\char-class([range(35,35)]),\\char-class([range(40,40)]),\\char-class([range(34,34)])],{})", Factory.Production);
  private static final IConstructor prod__Symbol__lit___58_58_Ident_ = (IConstructor) _read("prod(lex(\"Symbol\"),[lit(\"::\"),lex(\"Ident\")],{})", Factory.Production);
  private static final IConstructor prod__Stem__conditional__char_class___range__45_45__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_ = (IConstructor) _read("prod(lex(\"Stem\"),[conditional(\\char-class([range(45,45)]),{\\not-follow(\\char-class([range(33,33),range(35,36),range(38,39),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),\\not-precede(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))})],{})", Factory.Production);
  private static final IConstructor prod__star_Exp__lit___123_layouts_Meta_Exp_layouts_Meta_lit___125_layouts_Meta_lit___42_ = (IConstructor) _read("prod(label(\"star\",sort(\"Exp\")),[lit(\"{\"),layouts(\"Meta\"),sort(\"Exp\"),layouts(\"Meta\"),lit(\"}\"),layouts(\"Meta\"),lit(\"*\")],{})", Factory.Production);
  private static final IConstructor prod__Char__char_class___range__92_92_char_class___range__0_7_range__11_11_range__14_31_range__33_16777215_ = (IConstructor) _read("prod(lex(\"Char\"),[\\char-class([range(92,92)]),\\char-class([range(0,7),range(11,11),range(14,31),range(33,16777215)])],{})", Factory.Production);
  private static final IConstructor prod__lit___58_58__char_class___range__58_58_char_class___range__58_58_ = (IConstructor) _read("prod(lit(\"::\"),[\\char-class([range(58,58)]),\\char-class([range(58,58)])],{})", Factory.Production);
  private static final IConstructor prod__string_Exp__lit_string_ = (IConstructor) _read("prod(label(\"string\",sort(\"Exp\")),[lit(\"string\")],{})", Factory.Production);
  private static final IConstructor prod__IntValue__char_class___range__49_57_opt__char_class___range__48_57_char_class___range__82_82_range__114_114_conditional__iter__char_class___range__48_57_range__65_90_range__97_122__not_follow__char_class___range__48_57_range__65_90_range__97_122_ = (IConstructor) _read("prod(lex(\"IntValue\"),[\\char-class([range(49,57)]),opt(\\char-class([range(48,57)])),\\char-class([range(82,82),range(114,114)]),conditional(iter(\\char-class([range(48,57),range(65,90),range(97,122)])),{\\not-follow(\\char-class([range(48,57),range(65,90),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor regular__opt__lit___58 = (IConstructor) _read("regular(opt(lit(\":\")))", Factory.Production);
  private static final IConstructor prod__layouts_$QUOTES__conditional__iter_star__char_class___range__9_10_range__13_13_range__32_32__not_follow__char_class___range__9_10_range__13_13_range__32_32_ = (IConstructor) _read("prod(layouts(\"$QUOTES\"),[conditional(\\iter-star(\\char-class([range(9,10),range(13,13),range(32,32)])),{\\not-follow(\\char-class([range(9,10),range(13,13),range(32,32)]))})],{})", Factory.Production);
  private static final IConstructor prod__metaIdent_Exp__lit___34_94_34_layouts_Meta_lit_ident_ = (IConstructor) _read("prod(label(\"metaIdent\",sort(\"Exp\")),[lit(\"\\\"^\\\"\"),layouts(\"Meta\"),lit(\"ident\")],{})", Factory.Production);
  private static final IConstructor regular__iter_star__alt___char_class___range__0_33_range__35_16777215_seq___char_class___range__92_92_char_class___range__34_34 = (IConstructor) _read("regular(\\iter-star(alt({\\char-class([range(0,33),range(35,16777215)]),seq([\\char-class([range(92,92)]),\\char-class([range(34,34)])])})))", Factory.Production);
  private static final IConstructor prod__Tokens__lit_keyword_ = (IConstructor) _read("prod(keywords(\"Tokens\"),[lit(\"keyword\")],{})", Factory.Production);
    
  // Item declarations
	
	
  protected static class Ratio {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__Ratio__opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__47_47_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[4];
      
      tmp[3] = new ListStackNode(24, 3, regular__iter__char_class___range__48_57, new CharStackNode(26, 0, new int[][]{{48,57}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57}})});
      tmp[2] = new CharStackNode(22, 2, new int[][]{{47,47}}, null, null);
      tmp[1] = new ListStackNode(18, 1, regular__iter__char_class___range__48_57, new CharStackNode(20, 0, new int[][]{{48,57}}, null, null), true, null, null);
      tmp[0] = new OptionalStackNode(14, 0, regular__opt__char_class___range__43_43_range__45_45, new CharStackNode(16, 0, new int[][]{{43,43},{45,45}}, null, null), null, null);
      builder.addAlternative(MetaGrammarParser.prod__Ratio__opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__47_47_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__Ratio__opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__47_47_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57_(builder);
      
    }
  }
	
  protected static class Stem {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__Stem__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__46_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new SequenceStackNode(44, 0, regular__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__46_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39, new AbstractStackNode[]{new CharStackNode(46, 0, new int[][]{{45,45}}, new IEnterFilter[] {new CharPrecedeRestriction(new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}})}, null), new ListStackNode(48, 1, regular__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124, new CharStackNode(50, 0, new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}}, null, null), false, null, null), new CharStackNode(52, 2, new int[][]{{33,33},{35,36},{38,38},{42,43},{46,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}}, null, null), new ListStackNode(54, 3, regular__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124, new CharStackNode(56, 0, new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}}, null, null), false, null, null), new ListStackNode(58, 4, regular__iter__char_class___range__39_39, new CharStackNode(60, 0, new int[][]{{39,39}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{39,39}})})}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__Stem__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__46_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39_, tmp);
	}
    protected static final void _init_prod__Stem__seq___conditional__char_class___range__33_33_range__38_38_range__42_43_range__46_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new SequenceStackNode(62, 0, regular__seq___conditional__char_class___range__33_33_range__38_38_range__42_43_range__46_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39, new AbstractStackNode[]{new CharStackNode(64, 0, new int[][]{{33,33},{38,38},{42,43},{46,46},{60,63},{65,90},{95,95},{97,122},{124,124}}, new IEnterFilter[] {new CharPrecedeRestriction(new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}})}, null), new ListStackNode(66, 1, regular__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124, new CharStackNode(68, 0, new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}}, null, null), false, null, null), new ListStackNode(70, 2, regular__iter__char_class___range__39_39, new CharStackNode(72, 0, new int[][]{{39,39}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{39,39}})})}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__Stem__seq___conditional__char_class___range__33_33_range__38_38_range__42_43_range__46_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39_, tmp);
	}
    protected static final void _init_prod__Stem__conditional__char_class___range__45_45__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new CharStackNode(74, 0, new int[][]{{45,45}}, new IEnterFilter[] {new CharPrecedeRestriction(new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}})}, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{33,33},{35,36},{38,39},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}})});
      builder.addAlternative(MetaGrammarParser.prod__Stem__conditional__char_class___range__45_45__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_, tmp);
	}
    protected static final void _init_prod__Stem__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new SequenceStackNode(76, 0, regular__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39, new AbstractStackNode[]{new CharStackNode(78, 0, new int[][]{{45,45}}, new IEnterFilter[] {new CharPrecedeRestriction(new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}})}, null), new ListStackNode(80, 1, regular__iter__char_class___range__39_39, new CharStackNode(82, 0, new int[][]{{39,39}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{39,39}})})}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__Stem__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39_, tmp);
	}
    protected static final void _init_prod__Stem__seq___conditional__char_class___range__33_33_range__38_38_range__42_43_range__46_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new SequenceStackNode(84, 0, regular__seq___conditional__char_class___range__33_33_range__38_38_range__42_43_range__46_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124, new AbstractStackNode[]{new CharStackNode(86, 0, new int[][]{{33,33},{38,38},{42,43},{46,46},{60,63},{65,90},{95,95},{97,122},{124,124}}, new IEnterFilter[] {new CharPrecedeRestriction(new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}})}, null), new ListStackNode(88, 1, regular__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124, new CharStackNode(90, 0, new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}}, null, null), false, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{33,33},{35,36},{38,39},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}})})}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__Stem__seq___conditional__char_class___range__33_33_range__38_38_range__42_43_range__46_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_, tmp);
	}
    protected static final void _init_prod__Stem__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new SequenceStackNode(92, 0, regular__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124, new AbstractStackNode[]{new CharStackNode(94, 0, new int[][]{{45,45}}, new IEnterFilter[] {new CharPrecedeRestriction(new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}})}, null), new ListStackNode(96, 1, regular__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124, new CharStackNode(98, 0, new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}}, null, null), false, null, null), new CharStackNode(100, 2, new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{60,63},{65,90},{95,95},{97,122},{124,124}}, null, null), new ListStackNode(102, 3, regular__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124, new CharStackNode(104, 0, new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}}, null, null), false, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{33,33},{35,36},{38,39},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}})})}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__Stem__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__Stem__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__46_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39_(builder);
      
        _init_prod__Stem__seq___conditional__char_class___range__33_33_range__38_38_range__42_43_range__46_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39_(builder);
      
        _init_prod__Stem__conditional__char_class___range__45_45__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_(builder);
      
        _init_prod__Stem__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39_(builder);
      
        _init_prod__Stem__seq___conditional__char_class___range__33_33_range__38_38_range__42_43_range__46_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_(builder);
      
        _init_prod__Stem__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_(builder);
      
    }
  }
	
  protected static class Literal {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__Literal__char_class___range__34_34_layouts_Meta_MetaLiteral_layouts_Meta_char_class___range__34_34_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new CharStackNode(114, 4, new int[][]{{34,34}}, null, null);
      tmp[3] = new NonTerminalStackNode(112, 3, "layouts_Meta", null, null);
      tmp[2] = new NonTerminalStackNode(110, 2, "MetaLiteral", null, null);
      tmp[1] = new NonTerminalStackNode(108, 1, "layouts_Meta", null, null);
      tmp[0] = new CharStackNode(106, 0, new int[][]{{34,34}}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__Literal__char_class___range__34_34_layouts_Meta_MetaLiteral_layouts_Meta_char_class___range__34_34_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__Literal__char_class___range__34_34_layouts_Meta_MetaLiteral_layouts_Meta_char_class___range__34_34_(builder);
      
    }
  }
	
  protected static class IntValue {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__IntValue__char_class___range__49_57_opt__char_class___range__48_57_char_class___range__82_82_range__114_114_conditional__iter__char_class___range__48_57_range__65_90_range__97_122__not_follow__char_class___range__48_57_range__65_90_range__97_122_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[4];
      
      tmp[3] = new ListStackNode(124, 3, regular__iter__char_class___range__48_57_range__65_90_range__97_122, new CharStackNode(126, 0, new int[][]{{48,57},{65,90},{97,122}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57},{65,90},{97,122}})});
      tmp[2] = new CharStackNode(122, 2, new int[][]{{82,82},{114,114}}, null, null);
      tmp[1] = new OptionalStackNode(118, 1, regular__opt__char_class___range__48_57, new CharStackNode(120, 0, new int[][]{{48,57}}, null, null), null, null);
      tmp[0] = new CharStackNode(116, 0, new int[][]{{49,57}}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__IntValue__char_class___range__49_57_opt__char_class___range__48_57_char_class___range__82_82_range__114_114_conditional__iter__char_class___range__48_57_range__65_90_range__97_122__not_follow__char_class___range__48_57_range__65_90_range__97_122_, tmp);
	}
    protected static final void _init_prod__IntValue__conditional__char_class___range__48_48__not_follow__char_class___range__48_55_range__88_88_range__120_120_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new CharStackNode(128, 0, new int[][]{{48,48}}, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,55},{88,88},{120,120}})});
      builder.addAlternative(MetaGrammarParser.prod__IntValue__conditional__char_class___range__48_48__not_follow__char_class___range__48_55_range__88_88_range__120_120_, tmp);
	}
    protected static final void _init_prod__IntValue__char_class___range__48_48_conditional__iter__char_class___range__48_55__not_follow__char_class___range__48_55_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[2];
      
      tmp[1] = new ListStackNode(132, 1, regular__iter__char_class___range__48_55, new CharStackNode(134, 0, new int[][]{{48,55}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,55}})});
      tmp[0] = new CharStackNode(130, 0, new int[][]{{48,48}}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__IntValue__char_class___range__48_48_conditional__iter__char_class___range__48_55__not_follow__char_class___range__48_55_, tmp);
	}
    protected static final void _init_prod__IntValue__char_class___range__49_57_conditional__iter_star__char_class___range__48_57__not_follow__char_class___range__48_57_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[2];
      
      tmp[1] = new ListStackNode(138, 1, regular__iter_star__char_class___range__48_57, new CharStackNode(140, 0, new int[][]{{48,57}}, null, null), false, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57}})});
      tmp[0] = new CharStackNode(136, 0, new int[][]{{49,57}}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__IntValue__char_class___range__49_57_conditional__iter_star__char_class___range__48_57__not_follow__char_class___range__48_57_, tmp);
	}
    protected static final void _init_prod__IntValue__char_class___range__48_48_char_class___range__88_88_range__120_120_conditional__iter__char_class___range__48_57_range__65_70_range__97_102__not_follow__char_class___range__48_57_range__65_70_range__97_102_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new ListStackNode(146, 2, regular__iter__char_class___range__48_57_range__65_70_range__97_102, new CharStackNode(148, 0, new int[][]{{48,57},{65,70},{97,102}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57},{65,70},{97,102}})});
      tmp[1] = new CharStackNode(144, 1, new int[][]{{88,88},{120,120}}, null, null);
      tmp[0] = new CharStackNode(142, 0, new int[][]{{48,48}}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__IntValue__char_class___range__48_48_char_class___range__88_88_range__120_120_conditional__iter__char_class___range__48_57_range__65_70_range__97_102__not_follow__char_class___range__48_57_range__65_70_range__97_102_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__IntValue__char_class___range__49_57_opt__char_class___range__48_57_char_class___range__82_82_range__114_114_conditional__iter__char_class___range__48_57_range__65_90_range__97_122__not_follow__char_class___range__48_57_range__65_90_range__97_122_(builder);
      
        _init_prod__IntValue__conditional__char_class___range__48_48__not_follow__char_class___range__48_55_range__88_88_range__120_120_(builder);
      
        _init_prod__IntValue__char_class___range__48_48_conditional__iter__char_class___range__48_55__not_follow__char_class___range__48_55_(builder);
      
        _init_prod__IntValue__char_class___range__49_57_conditional__iter_star__char_class___range__48_57__not_follow__char_class___range__48_57_(builder);
      
        _init_prod__IntValue__char_class___range__48_48_char_class___range__88_88_range__120_120_conditional__iter__char_class___range__48_57_range__65_70_range__97_102__not_follow__char_class___range__48_57_range__65_70_range__97_102_(builder);
      
    }
  }
	
  protected static class Alt {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__alt_Alt__Ident_layouts_Meta_iter_star_seps__Exp__layouts_Meta_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new SeparatedListStackNode(164, 2, regular__iter_star_seps__Exp__layouts_Meta, new NonTerminalStackNode(166, 0, "Exp", null, null), new AbstractStackNode[]{new NonTerminalStackNode(168, 1, "layouts_Meta", null, null)}, false, null, null);
      tmp[1] = new NonTerminalStackNode(162, 1, "layouts_Meta", null, null);
      tmp[0] = new NonTerminalStackNode(160, 0, "Ident", null, null);
      builder.addAlternative(MetaGrammarParser.prod__alt_Alt__Ident_layouts_Meta_iter_star_seps__Exp__layouts_Meta_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__alt_Alt__Ident_layouts_Meta_iter_star_seps__Exp__layouts_Meta_(builder);
      
    }
  }
	
  protected static class MetaComment {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__MetaComment__lit___59_conditional__iter_star__char_class___range__0_9_range__11_12_range__14_16777215__end_of_line__tag__category___67_111_109_109_101_110_116(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[2];
      
      tmp[1] = new ListStackNode(186, 1, regular__iter_star__char_class___range__0_9_range__11_12_range__14_16777215, new CharStackNode(188, 0, new int[][]{{0,9},{11,12},{14,16777215}}, null, null), false, null, new ICompletionFilter[] {new AtEndOfLineRequirement()});
      tmp[0] = new LiteralStackNode(184, 0, prod__lit___59__char_class___range__59_59_, new int[] {59}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__MetaComment__lit___59_conditional__iter_star__char_class___range__0_9_range__11_12_range__14_16777215__end_of_line__tag__category___67_111_109_109_101_110_116, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__MetaComment__lit___59_conditional__iter_star__char_class___range__0_9_range__11_12_range__14_16777215__end_of_line__tag__category___67_111_109_109_101_110_116(builder);
      
    }
  }
	
  protected static class Char {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__Char__char_class___range__92_92_lit_backspace_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[2];
      
      tmp[1] = new LiteralStackNode(202, 1, prod__lit_backspace__char_class___range__98_98_char_class___range__97_97_char_class___range__99_99_char_class___range__107_107_char_class___range__115_115_char_class___range__112_112_char_class___range__97_97_char_class___range__99_99_char_class___range__101_101_, new int[] {98,97,99,107,115,112,97,99,101}, null, null);
      tmp[0] = new CharStackNode(200, 0, new int[][]{{92,92}}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__Char__char_class___range__92_92_lit_backspace_, tmp);
	}
    protected static final void _init_prod__Char__char_class___range__92_92_lit_formfeed_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[2];
      
      tmp[1] = new LiteralStackNode(206, 1, prod__lit_formfeed__char_class___range__102_102_char_class___range__111_111_char_class___range__114_114_char_class___range__109_109_char_class___range__102_102_char_class___range__101_101_char_class___range__101_101_char_class___range__100_100_, new int[] {102,111,114,109,102,101,101,100}, null, null);
      tmp[0] = new CharStackNode(204, 0, new int[][]{{92,92}}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__Char__char_class___range__92_92_lit_formfeed_, tmp);
	}
    protected static final void _init_prod__Char__char_class___range__92_92_lit_tab_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[2];
      
      tmp[1] = new LiteralStackNode(210, 1, prod__lit_tab__char_class___range__116_116_char_class___range__97_97_char_class___range__98_98_, new int[] {116,97,98}, null, null);
      tmp[0] = new CharStackNode(208, 0, new int[][]{{92,92}}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__Char__char_class___range__92_92_lit_tab_, tmp);
	}
    protected static final void _init_prod__Char__char_class___range__92_92_lit_newline_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[2];
      
      tmp[1] = new LiteralStackNode(214, 1, prod__lit_newline__char_class___range__110_110_char_class___range__101_101_char_class___range__119_119_char_class___range__108_108_char_class___range__105_105_char_class___range__110_110_char_class___range__101_101_, new int[] {110,101,119,108,105,110,101}, null, null);
      tmp[0] = new CharStackNode(212, 0, new int[][]{{92,92}}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__Char__char_class___range__92_92_lit_newline_, tmp);
	}
    protected static final void _init_prod__Char__char_class___range__92_92_char_class___range__0_7_range__11_11_range__14_31_range__33_16777215_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[2];
      
      tmp[1] = new CharStackNode(218, 1, new int[][]{{0,7},{11,11},{14,31},{33,16777215}}, null, null);
      tmp[0] = new CharStackNode(216, 0, new int[][]{{92,92}}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__Char__char_class___range__92_92_char_class___range__0_7_range__11_11_range__14_31_range__33_16777215_, tmp);
	}
    protected static final void _init_prod__Char__char_class___range__92_92_lit_space_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[2];
      
      tmp[1] = new LiteralStackNode(222, 1, prod__lit_space__char_class___range__115_115_char_class___range__112_112_char_class___range__97_97_char_class___range__99_99_char_class___range__101_101_, new int[] {115,112,97,99,101}, null, null);
      tmp[0] = new CharStackNode(220, 0, new int[][]{{92,92}}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__Char__char_class___range__92_92_lit_space_, tmp);
	}
    protected static final void _init_prod__Char__char_class___range__92_92_lit_return_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[2];
      
      tmp[1] = new LiteralStackNode(226, 1, prod__lit_return__char_class___range__114_114_char_class___range__101_101_char_class___range__116_116_char_class___range__117_117_char_class___range__114_114_char_class___range__110_110_, new int[] {114,101,116,117,114,110}, null, null);
      tmp[0] = new CharStackNode(224, 0, new int[][]{{92,92}}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__Char__char_class___range__92_92_lit_return_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__Char__char_class___range__92_92_lit_backspace_(builder);
      
        _init_prod__Char__char_class___range__92_92_lit_formfeed_(builder);
      
        _init_prod__Char__char_class___range__92_92_lit_tab_(builder);
      
        _init_prod__Char__char_class___range__92_92_lit_newline_(builder);
      
        _init_prod__Char__char_class___range__92_92_char_class___range__0_7_range__11_11_range__14_31_range__33_16777215_(builder);
      
        _init_prod__Char__char_class___range__92_92_lit_space_(builder);
      
        _init_prod__Char__char_class___range__92_92_lit_return_(builder);
      
    }
  }
	
  protected static class Rule {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__rule_Rule__MetaIdent_layouts_Meta_lit___61_layouts_Meta_iter_seps__Alt__layouts_Meta_lit___124_layouts_Meta_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new SeparatedListStackNode(236, 4, regular__iter_seps__Alt__layouts_Meta_lit___124_layouts_Meta, new NonTerminalStackNode(238, 0, "Alt", null, null), new AbstractStackNode[]{new NonTerminalStackNode(240, 1, "layouts_Meta", null, null), new LiteralStackNode(242, 2, prod__lit___124__char_class___range__124_124_, new int[] {124}, null, null), new NonTerminalStackNode(244, 3, "layouts_Meta", null, null)}, true, null, null);
      tmp[3] = new NonTerminalStackNode(234, 3, "layouts_Meta", null, null);
      tmp[2] = new LiteralStackNode(232, 2, prod__lit___61__char_class___range__61_61_, new int[] {61}, null, null);
      tmp[1] = new NonTerminalStackNode(230, 1, "layouts_Meta", null, null);
      tmp[0] = new NonTerminalStackNode(228, 0, "MetaIdent", null, null);
      builder.addAlternative(MetaGrammarParser.prod__rule_Rule__MetaIdent_layouts_Meta_lit___61_layouts_Meta_iter_seps__Alt__layouts_Meta_lit___124_layouts_Meta_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__rule_Rule__MetaIdent_layouts_Meta_lit___61_layouts_Meta_iter_seps__Alt__layouts_Meta_lit___124_layouts_Meta_(builder);
      
    }
  }
	
  protected static class MetaWhitespaceOrComment {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__whitespace_MetaWhitespaceOrComment__MetaWhitespace_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(264, 0, "MetaWhitespace", null, null);
      builder.addAlternative(MetaGrammarParser.prod__whitespace_MetaWhitespaceOrComment__MetaWhitespace_, tmp);
	}
    protected static final void _init_prod__comment_MetaWhitespaceOrComment__MetaComment_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(266, 0, "MetaComment", null, null);
      builder.addAlternative(MetaGrammarParser.prod__comment_MetaWhitespaceOrComment__MetaComment_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__whitespace_MetaWhitespaceOrComment__MetaWhitespace_(builder);
      
        _init_prod__comment_MetaWhitespaceOrComment__MetaComment_(builder);
      
    }
  }
	
  protected static class MetaLiteral {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__MetaLiteral__Integer_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(290, 0, "Integer", null, null);
      builder.addAlternative(MetaGrammarParser.prod__MetaLiteral__Integer_, tmp);
	}
    protected static final void _init_prod__MetaLiteral__Char_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(292, 0, "Char", null, null);
      builder.addAlternative(MetaGrammarParser.prod__MetaLiteral__Char_, tmp);
	}
    protected static final void _init_prod__MetaLiteral__Symbol_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(294, 0, "Symbol", null, null);
      builder.addAlternative(MetaGrammarParser.prod__MetaLiteral__Symbol_, tmp);
	}
    protected static final void _init_prod__MetaLiteral__Ratio_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(296, 0, "Ratio", null, null);
      builder.addAlternative(MetaGrammarParser.prod__MetaLiteral__Ratio_, tmp);
	}
    protected static final void _init_prod__MetaLiteral__Float_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(298, 0, "Float", null, null);
      builder.addAlternative(MetaGrammarParser.prod__MetaLiteral__Float_, tmp);
	}
    protected static final void _init_prod__MetaLiteral__String1_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(300, 0, "String1", null, null);
      builder.addAlternative(MetaGrammarParser.prod__MetaLiteral__String1_, tmp);
	}
    protected static final void _init_prod__MetaLiteral__char_class___range__44_44_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new CharStackNode(302, 0, new int[][]{{44,44}}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__MetaLiteral__char_class___range__44_44_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__MetaLiteral__Integer_(builder);
      
        _init_prod__MetaLiteral__Char_(builder);
      
        _init_prod__MetaLiteral__Symbol_(builder);
      
        _init_prod__MetaLiteral__Ratio_(builder);
      
        _init_prod__MetaLiteral__Float_(builder);
      
        _init_prod__MetaLiteral__String1_(builder);
      
        _init_prod__MetaLiteral__char_class___range__44_44_(builder);
      
    }
  }
	
  protected static class MetaIdent {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__MetaIdent__conditional__Ident__delete__Tokens_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(308, 0, "Ident", null, new ICompletionFilter[] {new StringMatchRestriction(new int[] {102,111,114,109}), new StringMatchRestriction(new int[] {99,104,97,114}), new StringMatchRestriction(new int[] {103,114,97,109,109,97,114}), new StringMatchRestriction(new int[] {115,116,114,105,110,103}), new StringMatchRestriction(new int[] {102,108,111,97,116}), new StringMatchRestriction(new int[] {124}), new StringMatchRestriction(new int[] {61}), new StringMatchRestriction(new int[] {46}), new StringMatchRestriction(new int[] {114,97,116,105,111,110,97,108}), new StringMatchRestriction(new int[] {105,110,116,101,103,101,114}), new StringMatchRestriction(new int[] {63}), new StringMatchRestriction(new int[] {115,121,109,98,111,108}), new StringMatchRestriction(new int[] {114,101,103,101,120,112}), new StringMatchRestriction(new int[] {110,117,109,98,101,114}), new StringMatchRestriction(new int[] {107,101,121,119,111,114,100}), new StringMatchRestriction(new int[] {42}), new StringMatchRestriction(new int[] {43})});
      builder.addAlternative(MetaGrammarParser.prod__MetaIdent__conditional__Ident__delete__Tokens_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__MetaIdent__conditional__Ident__delete__Tokens_(builder);
      
    }
  }
	
  protected static class Tokens {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__Tokens__lit_string_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(424, 0, prod__lit_string__char_class___range__115_115_char_class___range__116_116_char_class___range__114_114_char_class___range__105_105_char_class___range__110_110_char_class___range__103_103_, new int[] {115,116,114,105,110,103}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__Tokens__lit_string_, tmp);
	}
    protected static final void _init_prod__Tokens__lit___61_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(426, 0, prod__lit___61__char_class___range__61_61_, new int[] {61}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__Tokens__lit___61_, tmp);
	}
    protected static final void _init_prod__Tokens__lit___43_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(428, 0, prod__lit___43__char_class___range__43_43_, new int[] {43}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__Tokens__lit___43_, tmp);
	}
    protected static final void _init_prod__Tokens__lit___63_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(430, 0, prod__lit___63__char_class___range__63_63_, new int[] {63}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__Tokens__lit___63_, tmp);
	}
    protected static final void _init_prod__Tokens__lit___42_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(432, 0, prod__lit___42__char_class___range__42_42_, new int[] {42}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__Tokens__lit___42_, tmp);
	}
    protected static final void _init_prod__Tokens__lit___46_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(434, 0, prod__lit___46__char_class___range__46_46_, new int[] {46}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__Tokens__lit___46_, tmp);
	}
    protected static final void _init_prod__Tokens__lit_float_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(436, 0, prod__lit_float__char_class___range__102_102_char_class___range__108_108_char_class___range__111_111_char_class___range__97_97_char_class___range__116_116_, new int[] {102,108,111,97,116}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__Tokens__lit_float_, tmp);
	}
    protected static final void _init_prod__Tokens__lit___124_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(438, 0, prod__lit___124__char_class___range__124_124_, new int[] {124}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__Tokens__lit___124_, tmp);
	}
    protected static final void _init_prod__Tokens__lit_form_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(440, 0, prod__lit_form__char_class___range__102_102_char_class___range__111_111_char_class___range__114_114_char_class___range__109_109_, new int[] {102,111,114,109}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__Tokens__lit_form_, tmp);
	}
    protected static final void _init_prod__Tokens__lit_regexp_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(442, 0, prod__lit_regexp__char_class___range__114_114_char_class___range__101_101_char_class___range__103_103_char_class___range__101_101_char_class___range__120_120_char_class___range__112_112_, new int[] {114,101,103,101,120,112}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__Tokens__lit_regexp_, tmp);
	}
    protected static final void _init_prod__Tokens__lit_rational_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(444, 0, prod__lit_rational__char_class___range__114_114_char_class___range__97_97_char_class___range__116_116_char_class___range__105_105_char_class___range__111_111_char_class___range__110_110_char_class___range__97_97_char_class___range__108_108_, new int[] {114,97,116,105,111,110,97,108}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__Tokens__lit_rational_, tmp);
	}
    protected static final void _init_prod__Tokens__lit_integer_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(446, 0, prod__lit_integer__char_class___range__105_105_char_class___range__110_110_char_class___range__116_116_char_class___range__101_101_char_class___range__103_103_char_class___range__101_101_char_class___range__114_114_, new int[] {105,110,116,101,103,101,114}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__Tokens__lit_integer_, tmp);
	}
    protected static final void _init_prod__Tokens__lit_char_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(448, 0, prod__lit_char__char_class___range__99_99_char_class___range__104_104_char_class___range__97_97_char_class___range__114_114_, new int[] {99,104,97,114}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__Tokens__lit_char_, tmp);
	}
    protected static final void _init_prod__Tokens__lit_number_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(450, 0, prod__lit_number__char_class___range__110_110_char_class___range__117_117_char_class___range__109_109_char_class___range__98_98_char_class___range__101_101_char_class___range__114_114_, new int[] {110,117,109,98,101,114}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__Tokens__lit_number_, tmp);
	}
    protected static final void _init_prod__Tokens__lit_symbol_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(452, 0, prod__lit_symbol__char_class___range__115_115_char_class___range__121_121_char_class___range__109_109_char_class___range__98_98_char_class___range__111_111_char_class___range__108_108_, new int[] {115,121,109,98,111,108}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__Tokens__lit_symbol_, tmp);
	}
    protected static final void _init_prod__Tokens__lit_grammar_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(454, 0, prod__lit_grammar__char_class___range__103_103_char_class___range__114_114_char_class___range__97_97_char_class___range__109_109_char_class___range__109_109_char_class___range__97_97_char_class___range__114_114_, new int[] {103,114,97,109,109,97,114}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__Tokens__lit_grammar_, tmp);
	}
    protected static final void _init_prod__Tokens__lit_keyword_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(456, 0, prod__lit_keyword__char_class___range__107_107_char_class___range__101_101_char_class___range__121_121_char_class___range__119_119_char_class___range__111_111_char_class___range__114_114_char_class___range__100_100_, new int[] {107,101,121,119,111,114,100}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__Tokens__lit_keyword_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__Tokens__lit_string_(builder);
      
        _init_prod__Tokens__lit___61_(builder);
      
        _init_prod__Tokens__lit___43_(builder);
      
        _init_prod__Tokens__lit___63_(builder);
      
        _init_prod__Tokens__lit___42_(builder);
      
        _init_prod__Tokens__lit___46_(builder);
      
        _init_prod__Tokens__lit_float_(builder);
      
        _init_prod__Tokens__lit___124_(builder);
      
        _init_prod__Tokens__lit_form_(builder);
      
        _init_prod__Tokens__lit_regexp_(builder);
      
        _init_prod__Tokens__lit_rational_(builder);
      
        _init_prod__Tokens__lit_integer_(builder);
      
        _init_prod__Tokens__lit_char_(builder);
      
        _init_prod__Tokens__lit_number_(builder);
      
        _init_prod__Tokens__lit_symbol_(builder);
      
        _init_prod__Tokens__lit_grammar_(builder);
      
        _init_prod__Tokens__lit_keyword_(builder);
      
    }
  }
	
  protected static class Ident {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__Ident__opt__lit___58_conditional__iter_seps__Stem__lit___58__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[2];
      
      tmp[1] = new SeparatedListStackNode(462, 1, regular__iter_seps__Stem__lit___58, new NonTerminalStackNode(464, 0, "Stem", null, null), new AbstractStackNode[]{new LiteralStackNode(466, 1, prod__lit___58__char_class___range__58_58_, new int[] {58}, null, null)}, true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{33,33},{35,36},{38,39},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}})});
      tmp[0] = new OptionalStackNode(458, 0, regular__opt__lit___58, new LiteralStackNode(460, 0, prod__lit___58__char_class___range__58_58_, new int[] {58}, null, null), null, null);
      builder.addAlternative(MetaGrammarParser.prod__Ident__opt__lit___58_conditional__iter_seps__Stem__lit___58__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__Ident__opt__lit___58_conditional__iter_seps__Stem__lit___58__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_(builder);
      
    }
  }
	
  protected static class layouts_$QUOTES {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__layouts_$QUOTES__conditional__iter_star__char_class___range__9_10_range__13_13_range__32_32__not_follow__char_class___range__9_10_range__13_13_range__32_32_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new ListStackNode(472, 0, regular__iter_star__char_class___range__9_10_range__13_13_range__32_32, new CharStackNode(474, 0, new int[][]{{9,10},{13,13},{32,32}}, null, null), false, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{9,10},{13,13},{32,32}})});
      builder.addAlternative(MetaGrammarParser.prod__layouts_$QUOTES__conditional__iter_star__char_class___range__9_10_range__13_13_range__32_32__not_follow__char_class___range__9_10_range__13_13_range__32_32_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__layouts_$QUOTES__conditional__iter_star__char_class___range__9_10_range__13_13_range__32_32__not_follow__char_class___range__9_10_range__13_13_range__32_32_(builder);
      
    }
  }
	
  protected static class MetaGrammar {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__grammar_MetaGrammar__lit_grammar_layouts_Meta_iter_seps__Rule__layouts_Meta_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new SeparatedListStackNode(498, 2, regular__iter_seps__Rule__layouts_Meta, new NonTerminalStackNode(500, 0, "Rule", null, null), new AbstractStackNode[]{new NonTerminalStackNode(502, 1, "layouts_Meta", null, null)}, true, null, null);
      tmp[1] = new NonTerminalStackNode(496, 1, "layouts_Meta", null, null);
      tmp[0] = new LiteralStackNode(494, 0, prod__lit_grammar__char_class___range__103_103_char_class___range__114_114_char_class___range__97_97_char_class___range__109_109_char_class___range__109_109_char_class___range__97_97_char_class___range__114_114_, new int[] {103,114,97,109,109,97,114}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__grammar_MetaGrammar__lit_grammar_layouts_Meta_iter_seps__Rule__layouts_Meta_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__grammar_MetaGrammar__lit_grammar_layouts_Meta_iter_seps__Rule__layouts_Meta_(builder);
      
    }
  }
	
  protected static class String1 {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__String1__char_class___range__92_92_char_class___range__34_34_iter_star__StrChar1_char_class___range__92_92_char_class___range__34_34_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new CharStackNode(566, 4, new int[][]{{34,34}}, null, null);
      tmp[3] = new CharStackNode(564, 3, new int[][]{{92,92}}, null, null);
      tmp[2] = new ListStackNode(560, 2, regular__iter_star__StrChar1, new NonTerminalStackNode(562, 0, "StrChar1", null, null), false, null, null);
      tmp[1] = new CharStackNode(558, 1, new int[][]{{34,34}}, null, null);
      tmp[0] = new CharStackNode(556, 0, new int[][]{{92,92}}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__String1__char_class___range__92_92_char_class___range__34_34_iter_star__StrChar1_char_class___range__92_92_char_class___range__34_34_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__String1__char_class___range__92_92_char_class___range__34_34_iter_star__StrChar1_char_class___range__92_92_char_class___range__34_34_(builder);
      
    }
  }
	
  protected static class Float {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__Float__opt__char_class___range__43_43_range__45_45_FloatValue_opt__char_class___range__77_77_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new OptionalStackNode(574, 2, regular__opt__char_class___range__77_77, new CharStackNode(576, 0, new int[][]{{77,77}}, null, null), null, null);
      tmp[1] = new NonTerminalStackNode(572, 1, "FloatValue", null, null);
      tmp[0] = new OptionalStackNode(568, 0, regular__opt__char_class___range__43_43_range__45_45, new CharStackNode(570, 0, new int[][]{{43,43},{45,45}}, null, null), null, null);
      builder.addAlternative(MetaGrammarParser.prod__Float__opt__char_class___range__43_43_range__45_45_FloatValue_opt__char_class___range__77_77_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__Float__opt__char_class___range__43_43_range__45_45_FloatValue_opt__char_class___range__77_77_(builder);
      
    }
  }
	
  protected static class Symbol {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__Symbol__Ident_lit___47_Ident_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new NonTerminalStackNode(618, 2, "Ident", null, null);
      tmp[1] = new LiteralStackNode(616, 1, prod__lit___47__char_class___range__47_47_, new int[] {47}, null, null);
      tmp[0] = new NonTerminalStackNode(614, 0, "Ident", null, null);
      builder.addAlternative(MetaGrammarParser.prod__Symbol__Ident_lit___47_Ident_, tmp);
	}
    protected static final void _init_prod__Symbol__Ident_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(620, 0, "Ident", null, null);
      builder.addAlternative(MetaGrammarParser.prod__Symbol__Ident_, tmp);
	}
    protected static final void _init_prod__Symbol__conditional__lit___47__not_follow__char_class___range__33_33_range__38_38_range__42_43_range__45_46_range__58_58_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(622, 0, prod__lit___47__char_class___range__47_47_, new int[] {47}, new IEnterFilter[] {new CharPrecedeRestriction(new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}})}, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{33,33},{38,38},{42,43},{45,46},{58,58},{60,63},{65,90},{95,95},{97,122},{124,124}})});
      builder.addAlternative(MetaGrammarParser.prod__Symbol__conditional__lit___47__not_follow__char_class___range__33_33_range__38_38_range__42_43_range__45_46_range__58_58_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_, tmp);
	}
    protected static final void _init_prod__Symbol__lit___58_58_Ident_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[2];
      
      tmp[1] = new NonTerminalStackNode(626, 1, "Ident", null, null);
      tmp[0] = new LiteralStackNode(624, 0, prod__lit___58_58__char_class___range__58_58_char_class___range__58_58_, new int[] {58,58}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__Symbol__lit___58_58_Ident_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__Symbol__Ident_lit___47_Ident_(builder);
      
        _init_prod__Symbol__Ident_(builder);
      
        _init_prod__Symbol__conditional__lit___47__not_follow__char_class___range__33_33_range__38_38_range__42_43_range__45_46_range__58_58_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_(builder);
      
        _init_prod__Symbol__lit___58_58_Ident_(builder);
      
    }
  }
	
  protected static class String {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__String__char_class___range__34_34_iter_star__StrChar_char_class___range__34_34__tag__category___83_116_114_105_110_103_76_105_116_101_114_97_108(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new CharStackNode(668, 2, new int[][]{{34,34}}, null, null);
      tmp[1] = new ListStackNode(664, 1, regular__iter_star__StrChar, new NonTerminalStackNode(666, 0, "StrChar", null, null), false, null, null);
      tmp[0] = new CharStackNode(662, 0, new int[][]{{34,34}}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__String__char_class___range__34_34_iter_star__StrChar_char_class___range__34_34__tag__category___83_116_114_105_110_103_76_105_116_101_114_97_108, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__String__char_class___range__34_34_iter_star__StrChar_char_class___range__34_34__tag__category___83_116_114_105_110_103_76_105_116_101_114_97_108(builder);
      
    }
  }
	
  protected static class StrChar1 {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__StrChar1__char_class___range__92_92_char_class___range__92_92_char_class___range__48_51_char_class___range__48_55_char_class___range__48_55_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new CharStackNode(690, 4, new int[][]{{48,55}}, null, null);
      tmp[3] = new CharStackNode(688, 3, new int[][]{{48,55}}, null, null);
      tmp[2] = new CharStackNode(686, 2, new int[][]{{48,51}}, null, null);
      tmp[1] = new CharStackNode(684, 1, new int[][]{{92,92}}, null, null);
      tmp[0] = new CharStackNode(682, 0, new int[][]{{92,92}}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__StrChar1__char_class___range__92_92_char_class___range__92_92_char_class___range__48_51_char_class___range__48_55_char_class___range__48_55_, tmp);
	}
    protected static final void _init_prod__StrChar1__char_class___range__92_92_char_class___range__92_92_char_class___range__117_117_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[7];
      
      tmp[6] = new CharStackNode(704, 6, new int[][]{{48,57},{65,70},{97,102}}, null, null);
      tmp[5] = new CharStackNode(702, 5, new int[][]{{48,57},{65,70},{97,102}}, null, null);
      tmp[4] = new CharStackNode(700, 4, new int[][]{{48,57},{65,70},{97,102}}, null, null);
      tmp[3] = new CharStackNode(698, 3, new int[][]{{48,57},{65,70},{97,102}}, null, null);
      tmp[2] = new CharStackNode(696, 2, new int[][]{{117,117}}, null, null);
      tmp[1] = new CharStackNode(694, 1, new int[][]{{92,92}}, null, null);
      tmp[0] = new CharStackNode(692, 0, new int[][]{{92,92}}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__StrChar1__char_class___range__92_92_char_class___range__92_92_char_class___range__117_117_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_, tmp);
	}
    protected static final void _init_prod__StrChar1__char_class___range__0_33_range__35_91_range__93_16777215_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new CharStackNode(706, 0, new int[][]{{0,33},{35,91},{93,16777215}}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__StrChar1__char_class___range__0_33_range__35_91_range__93_16777215_, tmp);
	}
    protected static final void _init_prod__StrChar1__char_class___range__92_92_char_class___range__92_92_char_class___range__34_34_range__92_92_range__98_98_range__102_102_range__110_110_range__114_114_range__116_116_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new CharStackNode(712, 2, new int[][]{{34,34},{92,92},{98,98},{102,102},{110,110},{114,114},{116,116}}, null, null);
      tmp[1] = new CharStackNode(710, 1, new int[][]{{92,92}}, null, null);
      tmp[0] = new CharStackNode(708, 0, new int[][]{{92,92}}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__StrChar1__char_class___range__92_92_char_class___range__92_92_char_class___range__34_34_range__92_92_range__98_98_range__102_102_range__110_110_range__114_114_range__116_116_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__StrChar1__char_class___range__92_92_char_class___range__92_92_char_class___range__48_51_char_class___range__48_55_char_class___range__48_55_(builder);
      
        _init_prod__StrChar1__char_class___range__92_92_char_class___range__92_92_char_class___range__117_117_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_(builder);
      
        _init_prod__StrChar1__char_class___range__0_33_range__35_91_range__93_16777215_(builder);
      
        _init_prod__StrChar1__char_class___range__92_92_char_class___range__92_92_char_class___range__34_34_range__92_92_range__98_98_range__102_102_range__110_110_range__114_114_range__116_116_(builder);
      
    }
  }
	
  protected static class RegExp {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__RegExp__char_class___range__35_35_char_class___range__34_34_iter_star__alt___char_class___range__0_33_range__35_16777215_seq___char_class___range__92_92_char_class___range__34_34_char_class___range__34_34_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[4];
      
      tmp[3] = new CharStackNode(734, 3, new int[][]{{34,34}}, null, null);
      tmp[2] = new ListStackNode(722, 2, regular__iter_star__alt___char_class___range__0_33_range__35_16777215_seq___char_class___range__92_92_char_class___range__34_34, new AlternativeStackNode(724, 0, regular__alt___char_class___range__0_33_range__35_16777215_seq___char_class___range__92_92_char_class___range__34_34, new AbstractStackNode[]{new CharStackNode(726, 0, new int[][]{{0,33},{35,16777215}}, null, null), new SequenceStackNode(728, 0, regular__seq___char_class___range__92_92_char_class___range__34_34, new AbstractStackNode[]{new CharStackNode(730, 0, new int[][]{{92,92}}, null, null), new CharStackNode(732, 1, new int[][]{{34,34}}, null, null)}, null, null)}, null, null), false, null, null);
      tmp[1] = new CharStackNode(720, 1, new int[][]{{34,34}}, null, null);
      tmp[0] = new CharStackNode(718, 0, new int[][]{{35,35}}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__RegExp__char_class___range__35_35_char_class___range__34_34_iter_star__alt___char_class___range__0_33_range__35_16777215_seq___char_class___range__92_92_char_class___range__34_34_char_class___range__34_34_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__RegExp__char_class___range__35_35_char_class___range__34_34_iter_star__alt___char_class___range__0_33_range__35_16777215_seq___char_class___range__92_92_char_class___range__34_34_char_class___range__34_34_(builder);
      
    }
  }
	
  protected static class StrChar {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__StrChar__char_class___range__92_92_char_class___range__48_51_char_class___range__48_55_char_class___range__48_55_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[4];
      
      tmp[3] = new CharStackNode(752, 3, new int[][]{{48,55}}, null, null);
      tmp[2] = new CharStackNode(750, 2, new int[][]{{48,55}}, null, null);
      tmp[1] = new CharStackNode(748, 1, new int[][]{{48,51}}, null, null);
      tmp[0] = new CharStackNode(746, 0, new int[][]{{92,92}}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__StrChar__char_class___range__92_92_char_class___range__48_51_char_class___range__48_55_char_class___range__48_55_, tmp);
	}
    protected static final void _init_prod__StrChar__char_class___range__0_33_range__35_91_range__93_16777215_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new CharStackNode(754, 0, new int[][]{{0,33},{35,91},{93,16777215}}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__StrChar__char_class___range__0_33_range__35_91_range__93_16777215_, tmp);
	}
    protected static final void _init_prod__StrChar__char_class___range__92_92_char_class___range__34_34_range__92_92_range__98_98_range__102_102_range__110_110_range__114_114_range__116_116_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[2];
      
      tmp[1] = new CharStackNode(758, 1, new int[][]{{34,34},{92,92},{98,98},{102,102},{110,110},{114,114},{116,116}}, null, null);
      tmp[0] = new CharStackNode(756, 0, new int[][]{{92,92}}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__StrChar__char_class___range__92_92_char_class___range__34_34_range__92_92_range__98_98_range__102_102_range__110_110_range__114_114_range__116_116_, tmp);
	}
    protected static final void _init_prod__StrChar__char_class___range__92_92_char_class___range__117_117_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[6];
      
      tmp[5] = new CharStackNode(770, 5, new int[][]{{48,57},{65,70},{97,102}}, null, null);
      tmp[4] = new CharStackNode(768, 4, new int[][]{{48,57},{65,70},{97,102}}, null, null);
      tmp[3] = new CharStackNode(766, 3, new int[][]{{48,57},{65,70},{97,102}}, null, null);
      tmp[2] = new CharStackNode(764, 2, new int[][]{{48,57},{65,70},{97,102}}, null, null);
      tmp[1] = new CharStackNode(762, 1, new int[][]{{117,117}}, null, null);
      tmp[0] = new CharStackNode(760, 0, new int[][]{{92,92}}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__StrChar__char_class___range__92_92_char_class___range__117_117_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__StrChar__char_class___range__92_92_char_class___range__48_51_char_class___range__48_55_char_class___range__48_55_(builder);
      
        _init_prod__StrChar__char_class___range__0_33_range__35_91_range__93_16777215_(builder);
      
        _init_prod__StrChar__char_class___range__92_92_char_class___range__34_34_range__92_92_range__98_98_range__102_102_range__110_110_range__114_114_range__116_116_(builder);
      
        _init_prod__StrChar__char_class___range__92_92_char_class___range__117_117_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_(builder);
      
    }
  }
	
  protected static class MetaWhitespace {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__MetaWhitespace__char_class___range__9_10_range__12_13_range__32_32_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new CharStackNode(786, 0, new int[][]{{9,10},{12,13},{32,32}}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__MetaWhitespace__char_class___range__9_10_range__12_13_range__32_32_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__MetaWhitespace__char_class___range__9_10_range__12_13_range__32_32_(builder);
      
    }
  }
	
  protected static class Number {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__ratio_Number__Ratio_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(802, 0, "Ratio", null, null);
      builder.addAlternative(MetaGrammarParser.prod__ratio_Number__Ratio_, tmp);
	}
    protected static final void _init_prod__integer_Number__Integer_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(804, 0, "Integer", null, null);
      builder.addAlternative(MetaGrammarParser.prod__integer_Number__Integer_, tmp);
	}
    protected static final void _init_prod__float_Number__Float_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(806, 0, "Float", null, null);
      builder.addAlternative(MetaGrammarParser.prod__float_Number__Float_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__ratio_Number__Ratio_(builder);
      
        _init_prod__integer_Number__Integer_(builder);
      
        _init_prod__float_Number__Float_(builder);
      
    }
  }
	
  protected static class Integer {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__Integer__opt__char_class___range__43_43_range__45_45_IntValue_opt__char_class___range__78_78_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new OptionalStackNode(822, 2, regular__opt__char_class___range__78_78, new CharStackNode(824, 0, new int[][]{{78,78}}, null, null), null, null);
      tmp[1] = new NonTerminalStackNode(820, 1, "IntValue", null, null);
      tmp[0] = new OptionalStackNode(816, 0, regular__opt__char_class___range__43_43_range__45_45, new CharStackNode(818, 0, new int[][]{{43,43},{45,45}}, null, null), null, null);
      builder.addAlternative(MetaGrammarParser.prod__Integer__opt__char_class___range__43_43_range__45_45_IntValue_opt__char_class___range__78_78_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__Integer__opt__char_class___range__43_43_range__45_45_IntValue_opt__char_class___range__78_78_(builder);
      
    }
  }
	
  protected static class layouts_$BACKTICKS {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__layouts_$BACKTICKS__(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new EpsilonStackNode(828, 0);
      builder.addAlternative(MetaGrammarParser.prod__layouts_$BACKTICKS__, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__layouts_$BACKTICKS__(builder);
      
    }
  }
	
  protected static class FloatValue {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__FloatValue__iter__char_class___range__48_57_char_class___range__46_46_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[4];
      
      tmp[3] = new OptionalStackNode(1096, 3, regular__opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57, new SequenceStackNode(1098, 0, regular__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57, new AbstractStackNode[]{new CharStackNode(1100, 0, new int[][]{{69,69},{101,101}}, null, null), new OptionalStackNode(1102, 1, regular__opt__char_class___range__43_43_range__45_45, new CharStackNode(1104, 0, new int[][]{{43,43},{45,45}}, null, null), null, null), new ListStackNode(1106, 2, regular__iter__char_class___range__48_57, new CharStackNode(1108, 0, new int[][]{{48,57}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57}})})}, null, null), null, null);
      tmp[2] = new ListStackNode(1092, 2, regular__iter__char_class___range__48_57, new CharStackNode(1094, 0, new int[][]{{48,57}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57}})});
      tmp[1] = new CharStackNode(1090, 1, new int[][]{{46,46}}, null, null);
      tmp[0] = new ListStackNode(1086, 0, regular__iter__char_class___range__48_57, new CharStackNode(1088, 0, new int[][]{{48,57}}, null, null), true, null, null);
      builder.addAlternative(MetaGrammarParser.prod__FloatValue__iter__char_class___range__48_57_char_class___range__46_46_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__FloatValue__iter__char_class___range__48_57_char_class___range__46_46_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57_(builder);
      
    }
  }
	
  protected static class Exp {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__regexp_Exp__lit_regexp_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(862, 0, prod__lit_regexp__char_class___range__114_114_char_class___range__101_101_char_class___range__103_103_char_class___range__101_101_char_class___range__120_120_char_class___range__112_112_, new int[] {114,101,103,101,120,112}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__regexp_Exp__lit_regexp_, tmp);
	}
    protected static final void _init_prod__form_Exp__lit_form_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(864, 0, prod__lit_form__char_class___range__102_102_char_class___range__111_111_char_class___range__114_114_char_class___range__109_109_, new int[] {102,111,114,109}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__form_Exp__lit_form_, tmp);
	}
    protected static final void _init_prod__plus_Exp__lit___123_layouts_Meta_Exp_layouts_Meta_lit___125_layouts_Meta_lit___43_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[7];
      
      tmp[6] = new LiteralStackNode(878, 6, prod__lit___43__char_class___range__43_43_, new int[] {43}, null, null);
      tmp[5] = new NonTerminalStackNode(876, 5, "layouts_Meta", null, null);
      tmp[4] = new LiteralStackNode(874, 4, prod__lit___125__char_class___range__125_125_, new int[] {125}, null, null);
      tmp[3] = new NonTerminalStackNode(872, 3, "layouts_Meta", null, null);
      tmp[2] = new NonTerminalStackNode(870, 2, "Exp", null, null);
      tmp[1] = new NonTerminalStackNode(868, 1, "layouts_Meta", null, null);
      tmp[0] = new LiteralStackNode(866, 0, prod__lit___123__char_class___range__123_123_, new int[] {123}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__plus_Exp__lit___123_layouts_Meta_Exp_layouts_Meta_lit___125_layouts_Meta_lit___43_, tmp);
	}
    protected static final void _init_prod__keyword_Exp__lit_keyword_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(894, 0, prod__lit_keyword__char_class___range__107_107_char_class___range__101_101_char_class___range__121_121_char_class___range__119_119_char_class___range__111_111_char_class___range__114_114_char_class___range__100_100_, new int[] {107,101,121,119,111,114,100}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__keyword_Exp__lit_keyword_, tmp);
	}
    protected static final void _init_prod__vectorLit_Exp__lit___34_91_34_layouts_Meta_iter_star_seps__Exp__layouts_Meta_layouts_Meta_lit___34_93_34_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new LiteralStackNode(892, 4, prod__lit___34_93_34__char_class___range__34_34_char_class___range__93_93_char_class___range__34_34_, new int[] {34,93,34}, null, null);
      tmp[3] = new NonTerminalStackNode(890, 3, "layouts_Meta", null, null);
      tmp[2] = new SeparatedListStackNode(884, 2, regular__iter_star_seps__Exp__layouts_Meta, new NonTerminalStackNode(886, 0, "Exp", null, null), new AbstractStackNode[]{new NonTerminalStackNode(888, 1, "layouts_Meta", null, null)}, false, null, null);
      tmp[1] = new NonTerminalStackNode(882, 1, "layouts_Meta", null, null);
      tmp[0] = new LiteralStackNode(880, 0, prod__lit___34_91_34__char_class___range__34_34_char_class___range__91_91_char_class___range__34_34_, new int[] {34,91,34}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__vectorLit_Exp__lit___34_91_34_layouts_Meta_iter_star_seps__Exp__layouts_Meta_layouts_Meta_lit___34_93_34_, tmp);
	}
    protected static final void _init_prod__rational_Exp__lit_rational_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(914, 0, prod__lit_rational__char_class___range__114_114_char_class___range__97_97_char_class___range__116_116_char_class___range__105_105_char_class___range__111_111_char_class___range__110_110_char_class___range__97_97_char_class___range__108_108_, new int[] {114,97,116,105,111,110,97,108}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__rational_Exp__lit_rational_, tmp);
	}
    protected static final void _init_prod__starSep_Exp__lit___123_layouts_Meta_Exp_layouts_Meta_Literal_layouts_Meta_lit___125_layouts_Meta_lit___42_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[9];
      
      tmp[8] = new LiteralStackNode(912, 8, prod__lit___42__char_class___range__42_42_, new int[] {42}, null, null);
      tmp[7] = new NonTerminalStackNode(910, 7, "layouts_Meta", null, null);
      tmp[6] = new LiteralStackNode(908, 6, prod__lit___125__char_class___range__125_125_, new int[] {125}, null, null);
      tmp[5] = new NonTerminalStackNode(906, 5, "layouts_Meta", null, null);
      tmp[4] = new NonTerminalStackNode(904, 4, "Literal", null, null);
      tmp[3] = new NonTerminalStackNode(902, 3, "layouts_Meta", null, null);
      tmp[2] = new NonTerminalStackNode(900, 2, "Exp", null, null);
      tmp[1] = new NonTerminalStackNode(898, 1, "layouts_Meta", null, null);
      tmp[0] = new LiteralStackNode(896, 0, prod__lit___123__char_class___range__123_123_, new int[] {123}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__starSep_Exp__lit___123_layouts_Meta_Exp_layouts_Meta_Literal_layouts_Meta_lit___125_layouts_Meta_lit___42_, tmp);
	}
    protected static final void _init_prod__quote_Exp__lit___34_39_34_layouts_Meta_Exp_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[0] = new LiteralStackNode(916, 0, prod__lit___34_39_34__char_class___range__34_34_char_class___range__39_39_char_class___range__34_34_, new int[] {34,39,34}, null, null);
      tmp[1] = new NonTerminalStackNode(918, 1, "layouts_Meta", null, null);
      tmp[2] = new NonTerminalStackNode(920, 2, "Exp", null, null);
      builder.addAlternative(MetaGrammarParser.prod__quote_Exp__lit___34_39_34_layouts_Meta_Exp_, tmp);
	}
    protected static final void _init_prod__setLit_Exp__lit___34_35_123_34_layouts_Meta_iter_star_seps__Exp__layouts_Meta_layouts_Meta_lit___34_125_34_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new LiteralStackNode(934, 4, prod__lit___34_125_34__char_class___range__34_34_char_class___range__125_125_char_class___range__34_34_, new int[] {34,125,34}, null, null);
      tmp[3] = new NonTerminalStackNode(932, 3, "layouts_Meta", null, null);
      tmp[2] = new SeparatedListStackNode(926, 2, regular__iter_star_seps__Exp__layouts_Meta, new NonTerminalStackNode(928, 0, "Exp", null, null), new AbstractStackNode[]{new NonTerminalStackNode(930, 1, "layouts_Meta", null, null)}, false, null, null);
      tmp[1] = new NonTerminalStackNode(924, 1, "layouts_Meta", null, null);
      tmp[0] = new LiteralStackNode(922, 0, prod__lit___34_35_123_34__char_class___range__34_34_char_class___range__35_35_char_class___range__123_123_char_class___range__34_34_, new int[] {34,35,123,34}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__setLit_Exp__lit___34_35_123_34_layouts_Meta_iter_star_seps__Exp__layouts_Meta_layouts_Meta_lit___34_125_34_, tmp);
	}
    protected static final void _init_prod__opt_Exp__Exp_layouts_Meta_lit___63_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new LiteralStackNode(940, 2, prod__lit___63__char_class___range__63_63_, new int[] {63}, null, null);
      tmp[1] = new NonTerminalStackNode(938, 1, "layouts_Meta", null, null);
      tmp[0] = new NonTerminalStackNode(936, 0, "Exp", null, null);
      builder.addAlternative(MetaGrammarParser.prod__opt_Exp__Exp_layouts_Meta_lit___63_, tmp);
	}
    protected static final void _init_prod__unquotes_Exp__lit___34_126_64_34_layouts_Meta_Exp_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new NonTerminalStackNode(946, 2, "Exp", null, null);
      tmp[1] = new NonTerminalStackNode(944, 1, "layouts_Meta", null, null);
      tmp[0] = new LiteralStackNode(942, 0, prod__lit___34_126_64_34__char_class___range__34_34_char_class___range__126_126_char_class___range__64_64_char_class___range__34_34_, new int[] {34,126,64,34}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__unquotes_Exp__lit___34_126_64_34_layouts_Meta_Exp_, tmp);
	}
    protected static final void _init_prod__char_Exp__lit_char_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(962, 0, prod__lit_char__char_class___range__99_99_char_class___range__104_104_char_class___range__97_97_char_class___range__114_114_, new int[] {99,104,97,114}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__char_Exp__lit_char_, tmp);
	}
    protected static final void _init_prod__star_Exp__lit___123_layouts_Meta_Exp_layouts_Meta_lit___125_layouts_Meta_lit___42_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[7];
      
      tmp[6] = new LiteralStackNode(960, 6, prod__lit___42__char_class___range__42_42_, new int[] {42}, null, null);
      tmp[5] = new NonTerminalStackNode(958, 5, "layouts_Meta", null, null);
      tmp[4] = new LiteralStackNode(956, 4, prod__lit___125__char_class___range__125_125_, new int[] {125}, null, null);
      tmp[3] = new NonTerminalStackNode(954, 3, "layouts_Meta", null, null);
      tmp[2] = new NonTerminalStackNode(952, 2, "Exp", null, null);
      tmp[1] = new NonTerminalStackNode(950, 1, "layouts_Meta", null, null);
      tmp[0] = new LiteralStackNode(948, 0, prod__lit___123__char_class___range__123_123_, new int[] {123}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__star_Exp__lit___123_layouts_Meta_Exp_layouts_Meta_lit___125_layouts_Meta_lit___42_, tmp);
	}
    protected static final void _init_prod__float_Exp__lit_float_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(964, 0, prod__lit_float__char_class___range__102_102_char_class___range__108_108_char_class___range__111_111_char_class___range__97_97_char_class___range__116_116_, new int[] {102,108,111,97,116}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__float_Exp__lit_float_, tmp);
	}
    protected static final void _init_prod__nonTerminal_Exp__MetaIdent_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(966, 0, "MetaIdent", null, null);
      builder.addAlternative(MetaGrammarParser.prod__nonTerminal_Exp__MetaIdent_, tmp);
	}
    protected static final void _init_prod__metaMap_Exp__lit___34_94_34_layouts_Meta_lit___34_123_34_layouts_Meta_iter_star_seps__Exp__layouts_Meta_layouts_Meta_lit___34_125_34_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[7];
      
      tmp[6] = new LiteralStackNode(990, 6, prod__lit___34_125_34__char_class___range__34_34_char_class___range__125_125_char_class___range__34_34_, new int[] {34,125,34}, null, null);
      tmp[5] = new NonTerminalStackNode(988, 5, "layouts_Meta", null, null);
      tmp[4] = new SeparatedListStackNode(982, 4, regular__iter_star_seps__Exp__layouts_Meta, new NonTerminalStackNode(984, 0, "Exp", null, null), new AbstractStackNode[]{new NonTerminalStackNode(986, 1, "layouts_Meta", null, null)}, false, null, null);
      tmp[3] = new NonTerminalStackNode(980, 3, "layouts_Meta", null, null);
      tmp[2] = new LiteralStackNode(978, 2, prod__lit___34_123_34__char_class___range__34_34_char_class___range__123_123_char_class___range__34_34_, new int[] {34,123,34}, null, null);
      tmp[1] = new NonTerminalStackNode(976, 1, "layouts_Meta", null, null);
      tmp[0] = new LiteralStackNode(974, 0, prod__lit___34_94_34__char_class___range__34_34_char_class___range__94_94_char_class___range__34_34_, new int[] {34,94,34}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__metaMap_Exp__lit___34_94_34_layouts_Meta_lit___34_123_34_layouts_Meta_iter_star_seps__Exp__layouts_Meta_layouts_Meta_lit___34_125_34_, tmp);
	}
    protected static final void _init_prod__plusSep_Exp__lit___123_layouts_Meta_Exp_layouts_Meta_Literal_layouts_Meta_lit___125_layouts_Meta_lit___43_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[9];
      
      tmp[8] = new LiteralStackNode(1008, 8, prod__lit___43__char_class___range__43_43_, new int[] {43}, null, null);
      tmp[7] = new NonTerminalStackNode(1006, 7, "layouts_Meta", null, null);
      tmp[6] = new LiteralStackNode(1004, 6, prod__lit___125__char_class___range__125_125_, new int[] {125}, null, null);
      tmp[5] = new NonTerminalStackNode(1002, 5, "layouts_Meta", null, null);
      tmp[4] = new NonTerminalStackNode(1000, 4, "Literal", null, null);
      tmp[3] = new NonTerminalStackNode(998, 3, "layouts_Meta", null, null);
      tmp[2] = new NonTerminalStackNode(996, 2, "Exp", null, null);
      tmp[1] = new NonTerminalStackNode(994, 1, "layouts_Meta", null, null);
      tmp[0] = new LiteralStackNode(992, 0, prod__lit___123__char_class___range__123_123_, new int[] {123}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__plusSep_Exp__lit___123_layouts_Meta_Exp_layouts_Meta_Literal_layouts_Meta_lit___125_layouts_Meta_lit___43_, tmp);
	}
    protected static final void _init_prod__metaString_Exp__lit___34_94_34_layouts_Meta_lit_string_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new LiteralStackNode(972, 2, prod__lit_string__char_class___range__115_115_char_class___range__116_116_char_class___range__114_114_char_class___range__105_105_char_class___range__110_110_char_class___range__103_103_, new int[] {115,116,114,105,110,103}, null, null);
      tmp[1] = new NonTerminalStackNode(970, 1, "layouts_Meta", null, null);
      tmp[0] = new LiteralStackNode(968, 0, prod__lit___34_94_34__char_class___range__34_34_char_class___range__94_94_char_class___range__34_34_, new int[] {34,94,34}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__metaString_Exp__lit___34_94_34_layouts_Meta_lit_string_, tmp);
	}
    protected static final void _init_prod__string_Exp__lit_string_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(1010, 0, prod__lit_string__char_class___range__115_115_char_class___range__116_116_char_class___range__114_114_char_class___range__105_105_char_class___range__110_110_char_class___range__103_103_, new int[] {115,116,114,105,110,103}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__string_Exp__lit_string_, tmp);
	}
    protected static final void _init_prod__number_Exp__lit_number_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(1012, 0, prod__lit_number__char_class___range__110_110_char_class___range__117_117_char_class___range__109_109_char_class___range__98_98_char_class___range__101_101_char_class___range__114_114_, new int[] {110,117,109,98,101,114}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__number_Exp__lit_number_, tmp);
	}
    protected static final void _init_prod__qquote_Exp__lit___34_96_34_layouts_Meta_Exp_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new NonTerminalStackNode(1018, 2, "Exp", null, null);
      tmp[1] = new NonTerminalStackNode(1016, 1, "layouts_Meta", null, null);
      tmp[0] = new LiteralStackNode(1014, 0, prod__lit___34_96_34__char_class___range__34_34_char_class___range__96_96_char_class___range__34_34_, new int[] {34,96,34}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__qquote_Exp__lit___34_96_34_layouts_Meta_Exp_, tmp);
	}
    protected static final void _init_prod__symbol_Exp__lit_symbol_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(1020, 0, prod__lit_symbol__char_class___range__115_115_char_class___range__121_121_char_class___range__109_109_char_class___range__98_98_char_class___range__111_111_char_class___range__108_108_, new int[] {115,121,109,98,111,108}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__symbol_Exp__lit_symbol_, tmp);
	}
    protected static final void _init_prod__deref_Exp__lit___34_64_34_layouts_Meta_Exp_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new NonTerminalStackNode(1026, 2, "Exp", null, null);
      tmp[1] = new NonTerminalStackNode(1024, 1, "layouts_Meta", null, null);
      tmp[0] = new LiteralStackNode(1022, 0, prod__lit___34_64_34__char_class___range__34_34_char_class___range__64_64_char_class___range__34_34_, new int[] {34,64,34}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__deref_Exp__lit___34_64_34_layouts_Meta_Exp_, tmp);
	}
    protected static final void _init_prod__mapLit_Exp__lit___34_123_34_layouts_Meta_iter_star_seps__Exp__layouts_Meta_layouts_Meta_lit___34_125_34_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new LiteralStackNode(1040, 4, prod__lit___34_125_34__char_class___range__34_34_char_class___range__125_125_char_class___range__34_34_, new int[] {34,125,34}, null, null);
      tmp[3] = new NonTerminalStackNode(1038, 3, "layouts_Meta", null, null);
      tmp[2] = new SeparatedListStackNode(1032, 2, regular__iter_star_seps__Exp__layouts_Meta, new NonTerminalStackNode(1034, 0, "Exp", null, null), new AbstractStackNode[]{new NonTerminalStackNode(1036, 1, "layouts_Meta", null, null)}, false, null, null);
      tmp[1] = new NonTerminalStackNode(1030, 1, "layouts_Meta", null, null);
      tmp[0] = new LiteralStackNode(1028, 0, prod__lit___34_123_34__char_class___range__34_34_char_class___range__123_123_char_class___range__34_34_, new int[] {34,123,34}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__mapLit_Exp__lit___34_123_34_layouts_Meta_iter_star_seps__Exp__layouts_Meta_layouts_Meta_lit___34_125_34_, tmp);
	}
    protected static final void _init_prod__unquote_Exp__lit___34_126_34_layouts_Meta_Exp_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new NonTerminalStackNode(1048, 2, "Exp", null, null);
      tmp[1] = new NonTerminalStackNode(1046, 1, "layouts_Meta", null, null);
      tmp[0] = new LiteralStackNode(1044, 0, prod__lit___34_126_34__char_class___range__34_34_char_class___range__126_126_char_class___range__34_34_, new int[] {34,126,34}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__unquote_Exp__lit___34_126_34_layouts_Meta_Exp_, tmp);
	}
    protected static final void _init_prod__integer_Exp__lit_integer_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(1042, 0, prod__lit_integer__char_class___range__105_105_char_class___range__110_110_char_class___range__116_116_char_class___range__101_101_char_class___range__103_103_char_class___range__101_101_char_class___range__114_114_, new int[] {105,110,116,101,103,101,114}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__integer_Exp__lit_integer_, tmp);
	}
    protected static final void _init_prod__fnLit_Exp__lit___34_35_40_34_layouts_Meta_iter_star_seps__Exp__layouts_Meta_layouts_Meta_lit___34_41_34_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new LiteralStackNode(1062, 4, prod__lit___34_41_34__char_class___range__34_34_char_class___range__41_41_char_class___range__34_34_, new int[] {34,41,34}, null, null);
      tmp[3] = new NonTerminalStackNode(1060, 3, "layouts_Meta", null, null);
      tmp[2] = new SeparatedListStackNode(1054, 2, regular__iter_star_seps__Exp__layouts_Meta, new NonTerminalStackNode(1056, 0, "Exp", null, null), new AbstractStackNode[]{new NonTerminalStackNode(1058, 1, "layouts_Meta", null, null)}, false, null, null);
      tmp[1] = new NonTerminalStackNode(1052, 1, "layouts_Meta", null, null);
      tmp[0] = new LiteralStackNode(1050, 0, prod__lit___34_35_40_34__char_class___range__34_34_char_class___range__35_35_char_class___range__40_40_char_class___range__34_34_, new int[] {34,35,40,34}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__fnLit_Exp__lit___34_35_40_34_layouts_Meta_iter_star_seps__Exp__layouts_Meta_layouts_Meta_lit___34_41_34_, tmp);
	}
    protected static final void _init_prod__literal_Exp__Literal_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(1064, 0, "Literal", null, null);
      builder.addAlternative(MetaGrammarParser.prod__literal_Exp__Literal_, tmp);
	}
    protected static final void _init_prod__listLit_Exp__lit___34_40_34_layouts_Meta_iter_star_seps__Exp__layouts_Meta_layouts_Meta_lit___34_41_34_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new LiteralStackNode(1078, 4, prod__lit___34_41_34__char_class___range__34_34_char_class___range__41_41_char_class___range__34_34_, new int[] {34,41,34}, null, null);
      tmp[3] = new NonTerminalStackNode(1076, 3, "layouts_Meta", null, null);
      tmp[2] = new SeparatedListStackNode(1070, 2, regular__iter_star_seps__Exp__layouts_Meta, new NonTerminalStackNode(1072, 0, "Exp", null, null), new AbstractStackNode[]{new NonTerminalStackNode(1074, 1, "layouts_Meta", null, null)}, false, null, null);
      tmp[1] = new NonTerminalStackNode(1068, 1, "layouts_Meta", null, null);
      tmp[0] = new LiteralStackNode(1066, 0, prod__lit___34_40_34__char_class___range__34_34_char_class___range__40_40_char_class___range__34_34_, new int[] {34,40,34}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__listLit_Exp__lit___34_40_34_layouts_Meta_iter_star_seps__Exp__layouts_Meta_layouts_Meta_lit___34_41_34_, tmp);
	}
    protected static final void _init_prod__metaIdent_Exp__lit___34_94_34_layouts_Meta_lit_ident_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new LiteralStackNode(1084, 2, prod__lit_ident__char_class___range__105_105_char_class___range__100_100_char_class___range__101_101_char_class___range__110_110_char_class___range__116_116_, new int[] {105,100,101,110,116}, null, null);
      tmp[1] = new NonTerminalStackNode(1082, 1, "layouts_Meta", null, null);
      tmp[0] = new LiteralStackNode(1080, 0, prod__lit___34_94_34__char_class___range__34_34_char_class___range__94_94_char_class___range__34_34_, new int[] {34,94,34}, null, null);
      builder.addAlternative(MetaGrammarParser.prod__metaIdent_Exp__lit___34_94_34_layouts_Meta_lit_ident_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__regexp_Exp__lit_regexp_(builder);
      
        _init_prod__form_Exp__lit_form_(builder);
      
        _init_prod__plus_Exp__lit___123_layouts_Meta_Exp_layouts_Meta_lit___125_layouts_Meta_lit___43_(builder);
      
        _init_prod__keyword_Exp__lit_keyword_(builder);
      
        _init_prod__vectorLit_Exp__lit___34_91_34_layouts_Meta_iter_star_seps__Exp__layouts_Meta_layouts_Meta_lit___34_93_34_(builder);
      
        _init_prod__rational_Exp__lit_rational_(builder);
      
        _init_prod__starSep_Exp__lit___123_layouts_Meta_Exp_layouts_Meta_Literal_layouts_Meta_lit___125_layouts_Meta_lit___42_(builder);
      
        _init_prod__quote_Exp__lit___34_39_34_layouts_Meta_Exp_(builder);
      
        _init_prod__setLit_Exp__lit___34_35_123_34_layouts_Meta_iter_star_seps__Exp__layouts_Meta_layouts_Meta_lit___34_125_34_(builder);
      
        _init_prod__opt_Exp__Exp_layouts_Meta_lit___63_(builder);
      
        _init_prod__unquotes_Exp__lit___34_126_64_34_layouts_Meta_Exp_(builder);
      
        _init_prod__char_Exp__lit_char_(builder);
      
        _init_prod__star_Exp__lit___123_layouts_Meta_Exp_layouts_Meta_lit___125_layouts_Meta_lit___42_(builder);
      
        _init_prod__float_Exp__lit_float_(builder);
      
        _init_prod__nonTerminal_Exp__MetaIdent_(builder);
      
        _init_prod__metaMap_Exp__lit___34_94_34_layouts_Meta_lit___34_123_34_layouts_Meta_iter_star_seps__Exp__layouts_Meta_layouts_Meta_lit___34_125_34_(builder);
      
        _init_prod__plusSep_Exp__lit___123_layouts_Meta_Exp_layouts_Meta_Literal_layouts_Meta_lit___125_layouts_Meta_lit___43_(builder);
      
        _init_prod__metaString_Exp__lit___34_94_34_layouts_Meta_lit_string_(builder);
      
        _init_prod__string_Exp__lit_string_(builder);
      
        _init_prod__number_Exp__lit_number_(builder);
      
        _init_prod__qquote_Exp__lit___34_96_34_layouts_Meta_Exp_(builder);
      
        _init_prod__symbol_Exp__lit_symbol_(builder);
      
        _init_prod__deref_Exp__lit___34_64_34_layouts_Meta_Exp_(builder);
      
        _init_prod__mapLit_Exp__lit___34_123_34_layouts_Meta_iter_star_seps__Exp__layouts_Meta_layouts_Meta_lit___34_125_34_(builder);
      
        _init_prod__unquote_Exp__lit___34_126_34_layouts_Meta_Exp_(builder);
      
        _init_prod__integer_Exp__lit_integer_(builder);
      
        _init_prod__fnLit_Exp__lit___34_35_40_34_layouts_Meta_iter_star_seps__Exp__layouts_Meta_layouts_Meta_lit___34_41_34_(builder);
      
        _init_prod__literal_Exp__Literal_(builder);
      
        _init_prod__listLit_Exp__lit___34_40_34_layouts_Meta_iter_star_seps__Exp__layouts_Meta_layouts_Meta_lit___34_41_34_(builder);
      
        _init_prod__metaIdent_Exp__lit___34_94_34_layouts_Meta_lit_ident_(builder);
      
    }
  }
	
  protected static class layouts_Meta {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__layouts_Meta__conditional__iter_star__MetaWhitespaceOrComment__not_follow__char_class___range__9_10_range__12_13_range__32_32_not_follow__lit___59_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new ListStackNode(1132, 0, regular__iter_star__MetaWhitespaceOrComment, new NonTerminalStackNode(1134, 0, "MetaWhitespaceOrComment", null, null), false, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{9,10},{12,13},{32,32}}), new StringFollowRestriction(new int[] {59})});
      builder.addAlternative(MetaGrammarParser.prod__layouts_Meta__conditional__iter_star__MetaWhitespaceOrComment__not_follow__char_class___range__9_10_range__12_13_range__32_32_not_follow__lit___59_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__layouts_Meta__conditional__iter_star__MetaWhitespaceOrComment__not_follow__char_class___range__9_10_range__12_13_range__32_32_not_follow__lit___59_(builder);
      
    }
  }
	
  protected static class layouts_$default$ {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__layouts_$default$__(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new EpsilonStackNode(1140, 0);
      builder.addAlternative(MetaGrammarParser.prod__layouts_$default$__, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__layouts_$default$__(builder);
      
    }
  }
	
  public MetaGrammarParser() {
    super();
  }

  // Parse methods    
  
  public AbstractStackNode[] Ratio() {
    return Ratio.EXPECTS;
  }
  public AbstractStackNode[] Stem() {
    return Stem.EXPECTS;
  }
  public AbstractStackNode[] Literal() {
    return Literal.EXPECTS;
  }
  public AbstractStackNode[] IntValue() {
    return IntValue.EXPECTS;
  }
  public AbstractStackNode[] Alt() {
    return Alt.EXPECTS;
  }
  public AbstractStackNode[] MetaComment() {
    return MetaComment.EXPECTS;
  }
  public AbstractStackNode[] Char() {
    return Char.EXPECTS;
  }
  public AbstractStackNode[] Rule() {
    return Rule.EXPECTS;
  }
  public AbstractStackNode[] MetaWhitespaceOrComment() {
    return MetaWhitespaceOrComment.EXPECTS;
  }
  public AbstractStackNode[] MetaLiteral() {
    return MetaLiteral.EXPECTS;
  }
  public AbstractStackNode[] MetaIdent() {
    return MetaIdent.EXPECTS;
  }
  public AbstractStackNode[] Tokens() {
    return Tokens.EXPECTS;
  }
  public AbstractStackNode[] Ident() {
    return Ident.EXPECTS;
  }
  public AbstractStackNode[] layouts_$QUOTES() {
    return layouts_$QUOTES.EXPECTS;
  }
  public AbstractStackNode[] MetaGrammar() {
    return MetaGrammar.EXPECTS;
  }
  public AbstractStackNode[] String1() {
    return String1.EXPECTS;
  }
  public AbstractStackNode[] Float() {
    return Float.EXPECTS;
  }
  public AbstractStackNode[] Symbol() {
    return Symbol.EXPECTS;
  }
  public AbstractStackNode[] String() {
    return String.EXPECTS;
  }
  public AbstractStackNode[] StrChar1() {
    return StrChar1.EXPECTS;
  }
  public AbstractStackNode[] RegExp() {
    return RegExp.EXPECTS;
  }
  public AbstractStackNode[] StrChar() {
    return StrChar.EXPECTS;
  }
  public AbstractStackNode[] MetaWhitespace() {
    return MetaWhitespace.EXPECTS;
  }
  public AbstractStackNode[] Number() {
    return Number.EXPECTS;
  }
  public AbstractStackNode[] Integer() {
    return Integer.EXPECTS;
  }
  public AbstractStackNode[] layouts_$BACKTICKS() {
    return layouts_$BACKTICKS.EXPECTS;
  }
  public AbstractStackNode[] Exp() {
    return Exp.EXPECTS;
  }
  public AbstractStackNode[] FloatValue() {
    return FloatValue.EXPECTS;
  }
  public AbstractStackNode[] layouts_Meta() {
    return layouts_Meta.EXPECTS;
  }
  public AbstractStackNode[] layouts_$default$() {
    return layouts_$default$.EXPECTS;
  }
}