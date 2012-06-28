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

public class EBNFParser extends org.rascalmpl.library.lang.rascal.syntax.RascalRascal {
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
  private static final IConstructor prod__Char__char_class___range__92_92_lit_formfeed_ = (IConstructor) _read("prod(lex(\"Char\"),[\\char-class([range(92,92)]),lit(\"formfeed\")],{})", Factory.Production);
  private static final IConstructor prod__rational_Exp__lit_rational_ = (IConstructor) _read("prod(label(\"rational\",sort(\"Exp\")),[lit(\"rational\")],{})", Factory.Production);
  private static final IConstructor regular__seq___char_class___range__92_92_char_class___range__34_34 = (IConstructor) _read("regular(seq([\\char-class([range(92,92)]),\\char-class([range(34,34)])]))", Factory.Production);
  private static final IConstructor prod__Char__char_class___range__92_92_lit_space_ = (IConstructor) _read("prod(lex(\"Char\"),[\\char-class([range(92,92)]),lit(\"space\")],{})", Factory.Production);
  private static final IConstructor prod__Tokens__lit_string_ = (IConstructor) _read("prod(keywords(\"Tokens\"),[lit(\"string\")],{})", Factory.Production);
  private static final IConstructor prod__Tokens__lit___61_ = (IConstructor) _read("prod(keywords(\"Tokens\"),[lit(\"=\")],{})", Factory.Production);
  private static final IConstructor prod__Tokens__lit___124_ = (IConstructor) _read("prod(keywords(\"Tokens\"),[lit(\"|\")],{})", Factory.Production);
  private static final IConstructor prod__Symbol__Ident_lit___47_Ident_ = (IConstructor) _read("prod(lex(\"Symbol\"),[lex(\"Ident\"),lit(\"/\"),lex(\"Ident\")],{})", Factory.Production);
  private static final IConstructor prod__lit_grammar__char_class___range__103_103_char_class___range__114_114_char_class___range__97_97_char_class___range__109_109_char_class___range__109_109_char_class___range__97_97_char_class___range__114_114_ = (IConstructor) _read("prod(lit(\"grammar\"),[\\char-class([range(103,103)]),\\char-class([range(114,114)]),\\char-class([range(97,97)]),\\char-class([range(109,109)]),\\char-class([range(109,109)]),\\char-class([range(97,97)]),\\char-class([range(114,114)])],{})", Factory.Production);
  private static final IConstructor prod__comment_WhitespaceOrComment__Comment_ = (IConstructor) _read("prod(label(\"comment\",sort(\"WhitespaceOrComment\")),[lex(\"Comment\")],{})", Factory.Production);
  private static final IConstructor prod__Tokens__lit_integer_ = (IConstructor) _read("prod(keywords(\"Tokens\"),[lit(\"integer\")],{})", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_57_range__65_70_range__97_102 = (IConstructor) _read("regular(iter(\\char-class([range(48,57),range(65,70),range(97,102)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_57_range__65_90_range__97_122 = (IConstructor) _read("regular(iter(\\char-class([range(48,57),range(65,90),range(97,122)])))", Factory.Production);
  private static final IConstructor prod__lit_symbol__char_class___range__115_115_char_class___range__121_121_char_class___range__109_109_char_class___range__98_98_char_class___range__111_111_char_class___range__108_108_ = (IConstructor) _read("prod(lit(\"symbol\"),[\\char-class([range(115,115)]),\\char-class([range(121,121)]),\\char-class([range(109,109)]),\\char-class([range(98,98)]),\\char-class([range(111,111)]),\\char-class([range(108,108)])],{})", Factory.Production);
  private static final IConstructor regular__iter_star__char_class___range__48_57 = (IConstructor) _read("regular(\\iter-star(\\char-class([range(48,57)])))", Factory.Production);
  private static final IConstructor prod__regexp_Exp__lit_regexp_ = (IConstructor) _read("prod(label(\"regexp\",sort(\"Exp\")),[lit(\"regexp\")],{})", Factory.Production);
  private static final IConstructor prod__Integer__opt__char_class___range__43_43_range__45_45_IntValue_opt__char_class___range__78_78_ = (IConstructor) _read("prod(lex(\"Integer\"),[opt(\\char-class([range(43,43),range(45,45)])),lex(\"IntValue\"),opt(\\char-class([range(78,78)]))],{})", Factory.Production);
  private static final IConstructor prod__layouts_$BACKTICKS__ = (IConstructor) _read("prod(layouts(\"$BACKTICKS\"),[],{})", Factory.Production);
  private static final IConstructor prod__class_Hint__lit_class_layouts_Standard_Symbol_ = (IConstructor) _read("prod(label(\"class\",sort(\"Hint\")),[lit(\"class\"),layouts(\"Standard\"),lex(\"Symbol\")],{})", Factory.Production);
  private static final IConstructor regular__opt__char_class___range__48_57 = (IConstructor) _read("regular(opt(\\char-class([range(48,57)])))", Factory.Production);
  private static final IConstructor prod__lit_newline__char_class___range__110_110_char_class___range__101_101_char_class___range__119_119_char_class___range__108_108_char_class___range__105_105_char_class___range__110_110_char_class___range__101_101_ = (IConstructor) _read("prod(lit(\"newline\"),[\\char-class([range(110,110)]),\\char-class([range(101,101)]),\\char-class([range(119,119)]),\\char-class([range(108,108)]),\\char-class([range(105,105)]),\\char-class([range(110,110)]),\\char-class([range(101,101)])],{})", Factory.Production);
  private static final IConstructor prod__char_Exp__lit_char_ = (IConstructor) _read("prod(label(\"char\",sort(\"Exp\")),[lit(\"char\")],{})", Factory.Production);
  private static final IConstructor prod__Tokens__lit_grammar_ = (IConstructor) _read("prod(keywords(\"Tokens\"),[lit(\"grammar\")],{})", Factory.Production);
  private static final IConstructor prod__layouts_$default$__ = (IConstructor) _read("prod(layouts(\"$default$\"),[],{})", Factory.Production);
  private static final IConstructor prod__Stem__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_ = (IConstructor) _read("prod(lex(\"Stem\"),[seq([conditional(\\char-class([range(45,45)]),{\\not-precede(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))}),\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]),conditional(\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),{\\not-follow(\\char-class([range(33,33),range(35,36),range(38,39),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))})])],{})", Factory.Production);
  private static final IConstructor regular__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124 = (IConstructor) _read("regular(seq([conditional(\\char-class([range(45,45)]),{\\not-precede(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))}),\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]),conditional(\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),{\\not-follow(\\char-class([range(33,33),range(35,36),range(38,39),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))})]))", Factory.Production);
  private static final IConstructor prod__StrChar__char_class___range__0_33_range__35_91_range__93_16777215_ = (IConstructor) _read("prod(lex(\"StrChar\"),[\\char-class([range(0,33),range(35,91),range(93,16777215)])],{})", Factory.Production);
  private static final IConstructor prod__StrChar__char_class___range__92_92_char_class___range__48_51_char_class___range__48_55_char_class___range__48_55_ = (IConstructor) _read("prod(lex(\"StrChar\"),[\\char-class([range(92,92)]),\\char-class([range(48,51)]),\\char-class([range(48,55)]),\\char-class([range(48,55)])],{})", Factory.Production);
  private static final IConstructor regular__iter_star_seps__Rule__layouts_Standard = (IConstructor) _read("regular(\\iter-star-seps(sort(\"Rule\"),[layouts(\"Standard\")]))", Factory.Production);
  private static final IConstructor prod__repeat_Exp__lit___123_layouts_Standard_Exp_layouts_Standard_lit___125_ = (IConstructor) _read("prod(label(\"repeat\",sort(\"Exp\")),[lit(\"{\"),layouts(\"Standard\"),sort(\"Exp\"),layouts(\"Standard\"),lit(\"}\")],{})", Factory.Production);
  private static final IConstructor prod__Stem__seq___conditional__char_class___range__33_33_range__38_38_range__42_43_range__46_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_ = (IConstructor) _read("prod(lex(\"Stem\"),[seq([conditional(\\char-class([range(33,33),range(38,38),range(42,43),range(46,46),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]),{\\not-precede(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))}),conditional(\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),{\\not-follow(\\char-class([range(33,33),range(35,36),range(38,39),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))})])],{})", Factory.Production);
  private static final IConstructor prod__RegExp__char_class___range__35_35_char_class___range__34_34_iter_star__alt___char_class___range__0_33_range__35_16777215_seq___char_class___range__92_92_char_class___range__34_34_char_class___range__34_34_ = (IConstructor) _read("prod(lex(\"RegExp\"),[\\char-class([range(35,35)]),\\char-class([range(34,34)]),\\iter-star(alt({\\char-class([range(0,33),range(35,16777215)]),seq([\\char-class([range(92,92)]),\\char-class([range(34,34)])])})),\\char-class([range(34,34)])],{})", Factory.Production);
  private static final IConstructor prod__form_Exp__lit_form_ = (IConstructor) _read("prod(label(\"form\",sort(\"Exp\")),[lit(\"form\")],{})", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__39_39 = (IConstructor) _read("regular(iter(\\char-class([range(39,39)])))", Factory.Production);
  private static final IConstructor regular__seq___conditional__char_class___range__33_33_range__38_38_range__42_43_range__46_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124 = (IConstructor) _read("regular(seq([conditional(\\char-class([range(33,33),range(38,38),range(42,43),range(46,46),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]),{\\not-precede(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))}),conditional(\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),{\\not-follow(\\char-class([range(33,33),range(35,36),range(38,39),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))})]))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_55 = (IConstructor) _read("regular(iter(\\char-class([range(48,55)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_57 = (IConstructor) _read("regular(iter(\\char-class([range(48,57)])))", Factory.Production);
  private static final IConstructor prod__lit_char__char_class___range__99_99_char_class___range__104_104_char_class___range__97_97_char_class___range__114_114_ = (IConstructor) _read("prod(lit(\"char\"),[\\char-class([range(99,99)]),\\char-class([range(104,104)]),\\char-class([range(97,97)]),\\char-class([range(114,114)])],{})", Factory.Production);
  private static final IConstructor regular__opt__char_class___range__78_78 = (IConstructor) _read("regular(opt(\\char-class([range(78,78)])))", Factory.Production);
  private static final IConstructor regular__opt__char_class___range__77_77 = (IConstructor) _read("regular(opt(\\char-class([range(77,77)])))", Factory.Production);
  private static final IConstructor prod__rule_Rule__Symbol_layouts_Standard_lit___61_layouts_Standard_iter_star_seps__Alt__layouts_Standard_lit___124_layouts_Standard_ = (IConstructor) _read("prod(label(\"rule\",sort(\"Rule\")),[lex(\"Symbol\"),layouts(\"Standard\"),lit(\"=\"),layouts(\"Standard\"),\\iter-star-seps(sort(\"Alt\"),[layouts(\"Standard\"),lit(\"|\"),layouts(\"Standard\")])],{})", Factory.Production);
  private static final IConstructor prod__lit_tab__char_class___range__116_116_char_class___range__97_97_char_class___range__98_98_ = (IConstructor) _read("prod(lit(\"tab\"),[\\char-class([range(116,116)]),\\char-class([range(97,97)]),\\char-class([range(98,98)])],{})", Factory.Production);
  private static final IConstructor prod__lit_keyword__char_class___range__107_107_char_class___range__101_101_char_class___range__121_121_char_class___range__119_119_char_class___range__111_111_char_class___range__114_114_char_class___range__100_100_ = (IConstructor) _read("prod(lit(\"keyword\"),[\\char-class([range(107,107)]),\\char-class([range(101,101)]),\\char-class([range(121,121)]),\\char-class([range(119,119)]),\\char-class([range(111,111)]),\\char-class([range(114,114)]),\\char-class([range(100,100)])],{})", Factory.Production);
  private static final IConstructor prod__IntValue__conditional__char_class___range__48_48__not_follow__char_class___range__48_55_range__88_88_range__120_120_ = (IConstructor) _read("prod(lex(\"IntValue\"),[conditional(\\char-class([range(48,48)]),{\\not-follow(\\char-class([range(48,55),range(88,88),range(120,120)]))})],{})", Factory.Production);
  private static final IConstructor prod__Symbol__Ident_ = (IConstructor) _read("prod(lex(\"Symbol\"),[lex(\"Ident\")],{})", Factory.Production);
  private static final IConstructor regular__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__46_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39 = (IConstructor) _read("regular(seq([conditional(\\char-class([range(45,45)]),{\\not-precede(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))}),\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(46,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]),\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),conditional(iter(\\char-class([range(39,39)])),{\\not-follow(\\char-class([range(39,39)]))})]))", Factory.Production);
  private static final IConstructor regular__iter_star__char_class___range__9_10_range__13_13_range__32_32 = (IConstructor) _read("regular(\\iter-star(\\char-class([range(9,10),range(13,13),range(32,32)])))", Factory.Production);
  private static final IConstructor prod__Char__char_class___range__92_92_lit_return_ = (IConstructor) _read("prod(lex(\"Char\"),[\\char-class([range(92,92)]),lit(\"return\")],{})", Factory.Production);
  private static final IConstructor prod__layouts_Standard__conditional__iter_star__WhitespaceOrComment__not_follow__char_class___range__9_10_range__12_13_range__32_32_range__44_44_not_follow__lit___59_ = (IConstructor) _read("prod(layouts(\"Standard\"),[conditional(\\iter-star(sort(\"WhitespaceOrComment\")),{\\not-follow(\\char-class([range(9,10),range(12,13),range(32,32),range(44,44)])),\\not-follow(lit(\";\"))})],{})", Factory.Production);
  private static final IConstructor prod__number_Exp__lit_number_ = (IConstructor) _read("prod(label(\"number\",sort(\"Exp\")),[lit(\"number\")],{})", Factory.Production);
  private static final IConstructor prod__Tokens__lit_form_ = (IConstructor) _read("prod(keywords(\"Tokens\"),[lit(\"form\")],{})", Factory.Production);
  private static final IConstructor prod__Char__char_class___range__92_92_lit_tab_ = (IConstructor) _read("prod(lex(\"Char\"),[\\char-class([range(92,92)]),lit(\"tab\")],{})", Factory.Production);
  private static final IConstructor prod__String__char_class___range__34_34_iter_star__StrChar_char_class___range__34_34__tag__category___83_116_114_105_110_103_76_105_116_101_114_97_108 = (IConstructor) _read("prod(lex(\"String\"),[\\char-class([range(34,34)]),\\iter-star(lex(\"StrChar\")),\\char-class([range(34,34)])],{tag(category(\"StringLiteral\"))})", Factory.Production);
  private static final IConstructor prod__lit_backspace__char_class___range__98_98_char_class___range__97_97_char_class___range__99_99_char_class___range__107_107_char_class___range__115_115_char_class___range__112_112_char_class___range__97_97_char_class___range__99_99_char_class___range__101_101_ = (IConstructor) _read("prod(lit(\"backspace\"),[\\char-class([range(98,98)]),\\char-class([range(97,97)]),\\char-class([range(99,99)]),\\char-class([range(107,107)]),\\char-class([range(115,115)]),\\char-class([range(112,112)]),\\char-class([range(97,97)]),\\char-class([range(99,99)]),\\char-class([range(101,101)])],{})", Factory.Production);
  private static final IConstructor prod__lit_regexp__char_class___range__114_114_char_class___range__101_101_char_class___range__103_103_char_class___range__101_101_char_class___range__120_120_char_class___range__112_112_ = (IConstructor) _read("prod(lit(\"regexp\"),[\\char-class([range(114,114)]),\\char-class([range(101,101)]),\\char-class([range(103,103)]),\\char-class([range(101,101)]),\\char-class([range(120,120)]),\\char-class([range(112,112)])],{})", Factory.Production);
  private static final IConstructor prod__Ident__opt__lit___58_conditional__iter_seps__Stem__lit___58__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_ = (IConstructor) _read("prod(lex(\"Ident\"),[opt(lit(\":\")),conditional(\\iter-seps(lex(\"Stem\"),[lit(\":\")]),{\\not-follow(\\char-class([range(33,33),range(35,36),range(38,39),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))})],{})", Factory.Production);
  private static final IConstructor prod__lit_integer__char_class___range__105_105_char_class___range__110_110_char_class___range__116_116_char_class___range__101_101_char_class___range__103_103_char_class___range__101_101_char_class___range__114_114_ = (IConstructor) _read("prod(lit(\"integer\"),[\\char-class([range(105,105)]),\\char-class([range(110,110)]),\\char-class([range(116,116)]),\\char-class([range(101,101)]),\\char-class([range(103,103)]),\\char-class([range(101,101)]),\\char-class([range(114,114)])],{})", Factory.Production);
  private static final IConstructor prod__Stem__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__46_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39_ = (IConstructor) _read("prod(lex(\"Stem\"),[seq([conditional(\\char-class([range(45,45)]),{\\not-precede(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))}),\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(46,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]),\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),conditional(iter(\\char-class([range(39,39)])),{\\not-follow(\\char-class([range(39,39)]))})])],{})", Factory.Production);
  private static final IConstructor prod__lit_space__char_class___range__115_115_char_class___range__112_112_char_class___range__97_97_char_class___range__99_99_char_class___range__101_101_ = (IConstructor) _read("prod(lit(\"space\"),[\\char-class([range(115,115)]),\\char-class([range(112,112)]),\\char-class([range(97,97)]),\\char-class([range(99,99)]),\\char-class([range(101,101)])],{})", Factory.Production);
  private static final IConstructor prod__Tokens__lit_char_ = (IConstructor) _read("prod(keywords(\"Tokens\"),[lit(\"char\")],{})", Factory.Production);
  private static final IConstructor prod__grammar_EBNF__lit_grammar_layouts_Standard_iter_star_seps__Rule__layouts_Standard_ = (IConstructor) _read("prod(label(\"grammar\",sort(\"EBNF\")),[lit(\"grammar\"),layouts(\"Standard\"),\\iter-star-seps(sort(\"Rule\"),[layouts(\"Standard\")])],{})", Factory.Production);
  private static final IConstructor regular__iter_star_seps__Hint__layouts_Standard = (IConstructor) _read("regular(\\iter-star-seps(sort(\"Hint\"),[layouts(\"Standard\")]))", Factory.Production);
  private static final IConstructor prod__Comment__lit___59_conditional__iter_star__char_class___range__0_9_range__11_12_range__14_16777215__end_of_line__tag__category___67_111_109_109_101_110_116 = (IConstructor) _read("prod(lex(\"Comment\"),[lit(\";\"),conditional(\\iter-star(\\char-class([range(0,9),range(11,12),range(14,16777215)])),{\\end-of-line()})],{tag(category(\"Comment\"))})", Factory.Production);
  private static final IConstructor regular__iter_star_seps__Alt__layouts_Standard_lit___124_layouts_Standard = (IConstructor) _read("regular(\\iter-star-seps(sort(\"Alt\"),[layouts(\"Standard\"),lit(\"|\"),layouts(\"Standard\")]))", Factory.Production);
  private static final IConstructor prod__whitespace_WhitespaceOrComment__Whitespace_ = (IConstructor) _read("prod(label(\"whitespace\",sort(\"WhitespaceOrComment\")),[lex(\"Whitespace\")],{})", Factory.Production);
  private static final IConstructor prod__Ratio__opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__47_47_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57_ = (IConstructor) _read("prod(lex(\"Ratio\"),[opt(\\char-class([range(43,43),range(45,45)])),iter(\\char-class([range(48,57)])),\\char-class([range(47,47)]),conditional(iter(\\char-class([range(48,57)])),{\\not-follow(\\char-class([range(48,57)]))})],{})", Factory.Production);
  private static final IConstructor regular__iter_star__char_class___range__0_9_range__11_12_range__14_16777215 = (IConstructor) _read("regular(\\iter-star(\\char-class([range(0,9),range(11,12),range(14,16777215)])))", Factory.Production);
  private static final IConstructor prod__lit_string__char_class___range__115_115_char_class___range__116_116_char_class___range__114_114_char_class___range__105_105_char_class___range__110_110_char_class___range__103_103_ = (IConstructor) _read("prod(lit(\"string\"),[\\char-class([range(115,115)]),\\char-class([range(116,116)]),\\char-class([range(114,114)]),\\char-class([range(105,105)]),\\char-class([range(110,110)]),\\char-class([range(103,103)])],{})", Factory.Production);
  private static final IConstructor prod__Stem__seq___conditional__char_class___range__33_33_range__38_38_range__42_43_range__46_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39_ = (IConstructor) _read("prod(lex(\"Stem\"),[seq([conditional(\\char-class([range(33,33),range(38,38),range(42,43),range(46,46),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]),{\\not-precede(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))}),\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),conditional(iter(\\char-class([range(39,39)])),{\\not-follow(\\char-class([range(39,39)]))})])],{})", Factory.Production);
  private static final IConstructor prod__Symbol__conditional__lit___47__not_follow__char_class___range__33_33_range__38_38_range__42_43_range__45_46_range__58_58_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_ = (IConstructor) _read("prod(lex(\"Symbol\"),[conditional(lit(\"/\"),{\\not-follow(\\char-class([range(33,33),range(38,38),range(42,43),range(45,46),range(58,58),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),\\not-precede(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))})],{})", Factory.Production);
  private static final IConstructor regular__iter_seps__Stem__lit___58 = (IConstructor) _read("regular(\\iter-seps(lex(\"Stem\"),[lit(\":\")]))", Factory.Production);
  private static final IConstructor prod__lit___59__char_class___range__59_59_ = (IConstructor) _read("prod(lit(\";\"),[\\char-class([range(59,59)])],{})", Factory.Production);
  private static final IConstructor prod__lit___58__char_class___range__58_58_ = (IConstructor) _read("prod(lit(\":\"),[\\char-class([range(58,58)])],{})", Factory.Production);
  private static final IConstructor prod__lit___61__char_class___range__61_61_ = (IConstructor) _read("prod(lit(\"=\"),[\\char-class([range(61,61)])],{})", Factory.Production);
  private static final IConstructor regular__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57 = (IConstructor) _read("regular(seq([\\char-class([range(69,69),range(101,101)]),opt(\\char-class([range(43,43),range(45,45)])),conditional(iter(\\char-class([range(48,57)])),{\\not-follow(\\char-class([range(48,57)]))})]))", Factory.Production);
  private static final IConstructor prod__Char__char_class___range__92_92_lit_backspace_ = (IConstructor) _read("prod(lex(\"Char\"),[\\char-class([range(92,92)]),lit(\"backspace\")],{})", Factory.Production);
  private static final IConstructor regular__opt__char_class___range__43_43_range__45_45 = (IConstructor) _read("regular(opt(\\char-class([range(43,43),range(45,45)])))", Factory.Production);
  private static final IConstructor regular__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39 = (IConstructor) _read("regular(seq([conditional(\\char-class([range(45,45)]),{\\not-precede(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))}),conditional(iter(\\char-class([range(39,39)])),{\\not-follow(\\char-class([range(39,39)]))})]))", Factory.Production);
  private static final IConstructor prod__empty__ = (IConstructor) _read("prod(empty(),[],{})", Factory.Production);
  private static final IConstructor prod__float_Exp__lit_float_ = (IConstructor) _read("prod(label(\"float\",sort(\"Exp\")),[lit(\"float\")],{})", Factory.Production);
  private static final IConstructor prod__lit___41__char_class___range__41_41_ = (IConstructor) _read("prod(lit(\")\"),[\\char-class([range(41,41)])],{})", Factory.Production);
  private static final IConstructor prod__lit___40__char_class___range__40_40_ = (IConstructor) _read("prod(lit(\"(\"),[\\char-class([range(40,40)])],{})", Factory.Production);
  private static final IConstructor prod__lit_rational__char_class___range__114_114_char_class___range__97_97_char_class___range__116_116_char_class___range__105_105_char_class___range__111_111_char_class___range__110_110_char_class___range__97_97_char_class___range__108_108_ = (IConstructor) _read("prod(lit(\"rational\"),[\\char-class([range(114,114)]),\\char-class([range(97,97)]),\\char-class([range(116,116)]),\\char-class([range(105,105)]),\\char-class([range(111,111)]),\\char-class([range(110,110)]),\\char-class([range(97,97)]),\\char-class([range(108,108)])],{})", Factory.Production);
  private static final IConstructor prod__FloatValue__iter__char_class___range__48_57_char_class___range__46_46_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57_ = (IConstructor) _read("prod(lex(\"FloatValue\"),[iter(\\char-class([range(48,57)])),\\char-class([range(46,46)]),conditional(iter(\\char-class([range(48,57)])),{\\not-follow(\\char-class([range(48,57)]))}),opt(seq([\\char-class([range(69,69),range(101,101)]),opt(\\char-class([range(43,43),range(45,45)])),conditional(iter(\\char-class([range(48,57)])),{\\not-follow(\\char-class([range(48,57)]))})]))],{})", Factory.Production);
  private static final IConstructor prod__lit_formfeed__char_class___range__102_102_char_class___range__111_111_char_class___range__114_114_char_class___range__109_109_char_class___range__102_102_char_class___range__101_101_char_class___range__101_101_char_class___range__100_100_ = (IConstructor) _read("prod(lit(\"formfeed\"),[\\char-class([range(102,102)]),\\char-class([range(111,111)]),\\char-class([range(114,114)]),\\char-class([range(109,109)]),\\char-class([range(102,102)]),\\char-class([range(101,101)]),\\char-class([range(101,101)]),\\char-class([range(100,100)])],{})", Factory.Production);
  private static final IConstructor prod__lit___47__char_class___range__47_47_ = (IConstructor) _read("prod(lit(\"/\"),[\\char-class([range(47,47)])],{})", Factory.Production);
  private static final IConstructor regular__alt___char_class___range__0_33_range__35_16777215_seq___char_class___range__92_92_char_class___range__34_34 = (IConstructor) _read("regular(alt({\\char-class([range(0,33),range(35,16777215)]),seq([\\char-class([range(92,92)]),\\char-class([range(34,34)])])}))", Factory.Production);
  private static final IConstructor regular__opt__Hints = (IConstructor) _read("regular(opt(sort(\"Hints\")))", Factory.Production);
  private static final IConstructor prod__folding_Hint__lit_folding_ = (IConstructor) _read("prod(label(\"folding\",sort(\"Hint\")),[lit(\"folding\")],{})", Factory.Production);
  private static final IConstructor prod__Stem__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39_ = (IConstructor) _read("prod(lex(\"Stem\"),[seq([conditional(\\char-class([range(45,45)]),{\\not-precede(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))}),conditional(iter(\\char-class([range(39,39)])),{\\not-follow(\\char-class([range(39,39)]))})])],{})", Factory.Production);
  private static final IConstructor prod__call_Exp__conditional__Symbol__delete__Tokens_ = (IConstructor) _read("prod(label(\"call\",sort(\"Exp\")),[conditional(lex(\"Symbol\"),{delete(keywords(\"Tokens\"))})],{})", Factory.Production);
  private static final IConstructor prod__IntValue__char_class___range__48_48_conditional__iter__char_class___range__48_55__not_follow__char_class___range__48_55_ = (IConstructor) _read("prod(lex(\"IntValue\"),[\\char-class([range(48,48)]),conditional(iter(\\char-class([range(48,55)])),{\\not-follow(\\char-class([range(48,55)]))})],{})", Factory.Production);
  private static final IConstructor prod__Tokens__lit_symbol_ = (IConstructor) _read("prod(keywords(\"Tokens\"),[lit(\"symbol\")],{})", Factory.Production);
  private static final IConstructor prod__lit_return__char_class___range__114_114_char_class___range__101_101_char_class___range__116_116_char_class___range__117_117_char_class___range__114_114_char_class___range__110_110_ = (IConstructor) _read("prod(lit(\"return\"),[\\char-class([range(114,114)]),\\char-class([range(101,101)]),\\char-class([range(116,116)]),\\char-class([range(117,117)]),\\char-class([range(114,114)]),\\char-class([range(110,110)])],{})", Factory.Production);
  private static final IConstructor prod__literal_Exp__String_ = (IConstructor) _read("prod(label(\"literal\",sort(\"Exp\")),[lex(\"String\")],{})", Factory.Production);
  private static final IConstructor prod__hints_Hints__lit___40_layouts_Standard_iter_star_seps__Hint__layouts_Standard_layouts_Standard_lit___41_ = (IConstructor) _read("prod(label(\"hints\",sort(\"Hints\")),[lit(\"(\"),layouts(\"Standard\"),\\iter-star-seps(sort(\"Hint\"),[layouts(\"Standard\")]),layouts(\"Standard\"),lit(\")\")],{})", Factory.Production);
  private static final IConstructor prod__lit___91__char_class___range__91_91_ = (IConstructor) _read("prod(lit(\"[\"),[\\char-class([range(91,91)])],{})", Factory.Production);
  private static final IConstructor regular__iter_star__StrChar = (IConstructor) _read("regular(\\iter-star(lex(\"StrChar\")))", Factory.Production);
  private static final IConstructor prod__StrChar__char_class___range__92_92_char_class___range__34_34_range__92_92_range__98_98_range__102_102_range__110_110_range__114_114_range__116_116_ = (IConstructor) _read("prod(lex(\"StrChar\"),[\\char-class([range(92,92)]),\\char-class([range(34,34),range(92,92),range(98,98),range(102,102),range(110,110),range(114,114),range(116,116)])],{})", Factory.Production);
  private static final IConstructor prod__lit___93__char_class___range__93_93_ = (IConstructor) _read("prod(lit(\"]\"),[\\char-class([range(93,93)])],{})", Factory.Production);
  private static final IConstructor prod__StrChar__char_class___range__92_92_char_class___range__117_117_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_ = (IConstructor) _read("prod(lex(\"StrChar\"),[\\char-class([range(92,92)]),\\char-class([range(117,117)]),\\char-class([range(48,57),range(65,70),range(97,102)]),\\char-class([range(48,57),range(65,70),range(97,102)]),\\char-class([range(48,57),range(65,70),range(97,102)]),\\char-class([range(48,57),range(65,70),range(97,102)])],{})", Factory.Production);
  private static final IConstructor prod__Whitespace__char_class___range__9_10_range__12_13_range__32_32_range__44_44_ = (IConstructor) _read("prod(lex(\"Whitespace\"),[\\char-class([range(9,10),range(12,13),range(32,32),range(44,44)])],{})", Factory.Production);
  private static final IConstructor prod__Tokens__lit_number_ = (IConstructor) _read("prod(keywords(\"Tokens\"),[lit(\"number\")],{})", Factory.Production);
  private static final IConstructor prod__lit_form__char_class___range__102_102_char_class___range__111_111_char_class___range__114_114_char_class___range__109_109_ = (IConstructor) _read("prod(lit(\"form\"),[\\char-class([range(102,102)]),\\char-class([range(111,111)]),\\char-class([range(114,114)]),\\char-class([range(109,109)])],{})", Factory.Production);
  private static final IConstructor prod__Char__char_class___range__92_92_lit_newline_ = (IConstructor) _read("prod(lex(\"Char\"),[\\char-class([range(92,92)]),lit(\"newline\")],{})", Factory.Production);
  private static final IConstructor regular__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124 = (IConstructor) _read("regular(\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])))", Factory.Production);
  private static final IConstructor prod__IntValue__char_class___range__48_48_char_class___range__88_88_range__120_120_conditional__iter__char_class___range__48_57_range__65_70_range__97_102__not_follow__char_class___range__48_57_range__65_70_range__97_102_ = (IConstructor) _read("prod(lex(\"IntValue\"),[\\char-class([range(48,48)]),\\char-class([range(88,88),range(120,120)]),conditional(iter(\\char-class([range(48,57),range(65,70),range(97,102)])),{\\not-follow(\\char-class([range(48,57),range(65,70),range(97,102)]))})],{})", Factory.Production);
  private static final IConstructor prod__optional_Exp__lit___91_layouts_Standard_Exp_layouts_Standard_lit___93_ = (IConstructor) _read("prod(label(\"optional\",sort(\"Exp\")),[lit(\"[\"),layouts(\"Standard\"),sort(\"Exp\"),layouts(\"Standard\"),lit(\"]\")],{})", Factory.Production);
  private static final IConstructor prod__symbol_Exp__lit_symbol_ = (IConstructor) _read("prod(label(\"symbol\",sort(\"Exp\")),[lit(\"symbol\")],{})", Factory.Production);
  private static final IConstructor prod__lit_number__char_class___range__110_110_char_class___range__117_117_char_class___range__109_109_char_class___range__98_98_char_class___range__101_101_char_class___range__114_114_ = (IConstructor) _read("prod(lit(\"number\"),[\\char-class([range(110,110)]),\\char-class([range(117,117)]),\\char-class([range(109,109)]),\\char-class([range(98,98)]),\\char-class([range(101,101)]),\\char-class([range(114,114)])],{})", Factory.Production);
  private static final IConstructor prod__integer_Exp__lit_integer_ = (IConstructor) _read("prod(label(\"integer\",sort(\"Exp\")),[lit(\"integer\")],{})", Factory.Production);
  private static final IConstructor regular__iter_star_seps__Exp__layouts_Standard = (IConstructor) _read("regular(\\iter-star-seps(sort(\"Exp\"),[layouts(\"Standard\")]))", Factory.Production);
  private static final IConstructor prod__alt_Alt__Symbol_layouts_Standard_iter_star_seps__Exp__layouts_Standard_layouts_Standard_opt__Hints_ = (IConstructor) _read("prod(label(\"alt\",sort(\"Alt\")),[lex(\"Symbol\"),layouts(\"Standard\"),\\iter-star-seps(sort(\"Exp\"),[layouts(\"Standard\")]),layouts(\"Standard\"),opt(sort(\"Hints\"))],{})", Factory.Production);
  private static final IConstructor prod__Tokens__lit_regexp_ = (IConstructor) _read("prod(keywords(\"Tokens\"),[lit(\"regexp\")],{})", Factory.Production);
  private static final IConstructor prod__Tokens__lit_rational_ = (IConstructor) _read("prod(keywords(\"Tokens\"),[lit(\"rational\")],{})", Factory.Production);
  private static final IConstructor regular__opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57 = (IConstructor) _read("regular(opt(seq([\\char-class([range(69,69),range(101,101)]),opt(\\char-class([range(43,43),range(45,45)])),conditional(iter(\\char-class([range(48,57)])),{\\not-follow(\\char-class([range(48,57)]))})])))", Factory.Production);
  private static final IConstructor prod__IntValue__char_class___range__49_57_conditional__iter_star__char_class___range__48_57__not_follow__char_class___range__48_57_ = (IConstructor) _read("prod(lex(\"IntValue\"),[\\char-class([range(49,57)]),conditional(\\iter-star(\\char-class([range(48,57)])),{\\not-follow(\\char-class([range(48,57)]))})],{})", Factory.Production);
  private static final IConstructor prod__lit_float__char_class___range__102_102_char_class___range__108_108_char_class___range__111_111_char_class___range__97_97_char_class___range__116_116_ = (IConstructor) _read("prod(lit(\"float\"),[\\char-class([range(102,102)]),\\char-class([range(108,108)]),\\char-class([range(111,111)]),\\char-class([range(97,97)]),\\char-class([range(116,116)])],{})", Factory.Production);
  private static final IConstructor prod__float_Number__Float_ = (IConstructor) _read("prod(label(\"float\",lex(\"Number\")),[lex(\"Float\")],{})", Factory.Production);
  private static final IConstructor prod__lit___123__char_class___range__123_123_ = (IConstructor) _read("prod(lit(\"{\"),[\\char-class([range(123,123)])],{})", Factory.Production);
  private static final IConstructor prod__integer_Number__Integer_ = (IConstructor) _read("prod(label(\"integer\",lex(\"Number\")),[lex(\"Integer\")],{})", Factory.Production);
  private static final IConstructor prod__keyword_Exp__lit_keyword_ = (IConstructor) _read("prod(label(\"keyword\",sort(\"Exp\")),[lit(\"keyword\")],{})", Factory.Production);
  private static final IConstructor prod__lit___125__char_class___range__125_125_ = (IConstructor) _read("prod(lit(\"}\"),[\\char-class([range(125,125)])],{})", Factory.Production);
  private static final IConstructor prod__ratio_Number__Ratio_ = (IConstructor) _read("prod(label(\"ratio\",lex(\"Number\")),[lex(\"Ratio\")],{})", Factory.Production);
  private static final IConstructor prod__Float__opt__char_class___range__43_43_range__45_45_FloatValue_opt__char_class___range__77_77_ = (IConstructor) _read("prod(lex(\"Float\"),[opt(\\char-class([range(43,43),range(45,45)])),lex(\"FloatValue\"),opt(\\char-class([range(77,77)]))],{})", Factory.Production);
  private static final IConstructor prod__lit___124__char_class___range__124_124_ = (IConstructor) _read("prod(lit(\"|\"),[\\char-class([range(124,124)])],{})", Factory.Production);
  private static final IConstructor prod__lit_folding__char_class___range__102_102_char_class___range__111_111_char_class___range__108_108_char_class___range__100_100_char_class___range__105_105_char_class___range__110_110_char_class___range__103_103_ = (IConstructor) _read("prod(lit(\"folding\"),[\\char-class([range(102,102)]),\\char-class([range(111,111)]),\\char-class([range(108,108)]),\\char-class([range(100,100)]),\\char-class([range(105,105)]),\\char-class([range(110,110)]),\\char-class([range(103,103)])],{})", Factory.Production);
  private static final IConstructor prod__Symbol__lit___58_58_Ident_ = (IConstructor) _read("prod(lex(\"Symbol\"),[lit(\"::\"),lex(\"Ident\")],{})", Factory.Production);
  private static final IConstructor prod__Stem__conditional__char_class___range__45_45__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_ = (IConstructor) _read("prod(lex(\"Stem\"),[conditional(\\char-class([range(45,45)]),{\\not-follow(\\char-class([range(33,33),range(35,36),range(38,39),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),\\not-precede(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))})],{})", Factory.Production);
  private static final IConstructor prod__Char__char_class___range__92_92_char_class___range__0_7_range__11_11_range__14_31_range__33_16777215_ = (IConstructor) _read("prod(lex(\"Char\"),[\\char-class([range(92,92)]),\\char-class([range(0,7),range(11,11),range(14,31),range(33,16777215)])],{})", Factory.Production);
  private static final IConstructor prod__lit___58_58__char_class___range__58_58_char_class___range__58_58_ = (IConstructor) _read("prod(lit(\"::\"),[\\char-class([range(58,58)]),\\char-class([range(58,58)])],{})", Factory.Production);
  private static final IConstructor prod__string_Exp__lit_string_ = (IConstructor) _read("prod(label(\"string\",sort(\"Exp\")),[lit(\"string\")],{})", Factory.Production);
  private static final IConstructor regular__iter_star__WhitespaceOrComment = (IConstructor) _read("regular(\\iter-star(sort(\"WhitespaceOrComment\")))", Factory.Production);
  private static final IConstructor prod__IntValue__char_class___range__49_57_opt__char_class___range__48_57_char_class___range__82_82_range__114_114_conditional__iter__char_class___range__48_57_range__65_90_range__97_122__not_follow__char_class___range__48_57_range__65_90_range__97_122_ = (IConstructor) _read("prod(lex(\"IntValue\"),[\\char-class([range(49,57)]),opt(\\char-class([range(48,57)])),\\char-class([range(82,82),range(114,114)]),conditional(iter(\\char-class([range(48,57),range(65,90),range(97,122)])),{\\not-follow(\\char-class([range(48,57),range(65,90),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__repeatSep_Exp__lit___123_layouts_Standard_Exp_layouts_Standard_String_layouts_Standard_lit___125_ = (IConstructor) _read("prod(label(\"repeatSep\",sort(\"Exp\")),[lit(\"{\"),layouts(\"Standard\"),sort(\"Exp\"),layouts(\"Standard\"),lex(\"String\"),layouts(\"Standard\"),lit(\"}\")],{})", Factory.Production);
  private static final IConstructor prod__lit_class__char_class___range__99_99_char_class___range__108_108_char_class___range__97_97_char_class___range__115_115_char_class___range__115_115_ = (IConstructor) _read("prod(lit(\"class\"),[\\char-class([range(99,99)]),\\char-class([range(108,108)]),\\char-class([range(97,97)]),\\char-class([range(115,115)]),\\char-class([range(115,115)])],{})", Factory.Production);
  private static final IConstructor regular__opt__lit___58 = (IConstructor) _read("regular(opt(lit(\":\")))", Factory.Production);
  private static final IConstructor prod__layouts_$QUOTES__conditional__iter_star__char_class___range__9_10_range__13_13_range__32_32__not_follow__char_class___range__9_10_range__13_13_range__32_32_ = (IConstructor) _read("prod(layouts(\"$QUOTES\"),[conditional(\\iter-star(\\char-class([range(9,10),range(13,13),range(32,32)])),{\\not-follow(\\char-class([range(9,10),range(13,13),range(32,32)]))})],{})", Factory.Production);
  private static final IConstructor regular__iter_star__alt___char_class___range__0_33_range__35_16777215_seq___char_class___range__92_92_char_class___range__34_34 = (IConstructor) _read("regular(\\iter-star(alt({\\char-class([range(0,33),range(35,16777215)]),seq([\\char-class([range(92,92)]),\\char-class([range(34,34)])])})))", Factory.Production);
  private static final IConstructor prod__Tokens__lit_keyword_ = (IConstructor) _read("prod(keywords(\"Tokens\"),[lit(\"keyword\")],{})", Factory.Production);
    
  // Item declarations
	
	
  protected static class layouts_Standard {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__layouts_Standard__conditional__iter_star__WhitespaceOrComment__not_follow__char_class___range__9_10_range__12_13_range__32_32_range__44_44_not_follow__lit___59_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new ListStackNode(14, 0, regular__iter_star__WhitespaceOrComment, new NonTerminalStackNode(16, 0, "WhitespaceOrComment", null, null), false, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{9,10},{12,13},{32,32},{44,44}}), new StringFollowRestriction(new int[] {59})});
      builder.addAlternative(EBNFParser.prod__layouts_Standard__conditional__iter_star__WhitespaceOrComment__not_follow__char_class___range__9_10_range__12_13_range__32_32_range__44_44_not_follow__lit___59_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__layouts_Standard__conditional__iter_star__WhitespaceOrComment__not_follow__char_class___range__9_10_range__12_13_range__32_32_range__44_44_not_follow__lit___59_(builder);
      
    }
  }
	
  protected static class Ratio {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__Ratio__opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__47_47_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[4];
      
      tmp[3] = new ListStackNode(28, 3, regular__iter__char_class___range__48_57, new CharStackNode(30, 0, new int[][]{{48,57}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57}})});
      tmp[2] = new CharStackNode(26, 2, new int[][]{{47,47}}, null, null);
      tmp[1] = new ListStackNode(22, 1, regular__iter__char_class___range__48_57, new CharStackNode(24, 0, new int[][]{{48,57}}, null, null), true, null, null);
      tmp[0] = new OptionalStackNode(18, 0, regular__opt__char_class___range__43_43_range__45_45, new CharStackNode(20, 0, new int[][]{{43,43},{45,45}}, null, null), null, null);
      builder.addAlternative(EBNFParser.prod__Ratio__opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__47_47_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__Ratio__opt__char_class___range__43_43_range__45_45_iter__char_class___range__48_57_char_class___range__47_47_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57_(builder);
      
    }
  }
	
  protected static class Number {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__integer_Number__Integer_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(110, 0, "Integer", null, null);
      builder.addAlternative(EBNFParser.prod__integer_Number__Integer_, tmp);
	}
    protected static final void _init_prod__ratio_Number__Ratio_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(112, 0, "Ratio", null, null);
      builder.addAlternative(EBNFParser.prod__ratio_Number__Ratio_, tmp);
	}
    protected static final void _init_prod__float_Number__Float_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(114, 0, "Float", null, null);
      builder.addAlternative(EBNFParser.prod__float_Number__Float_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__integer_Number__Integer_(builder);
      
        _init_prod__ratio_Number__Ratio_(builder);
      
        _init_prod__float_Number__Float_(builder);
      
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
      
      tmp[0] = new SequenceStackNode(48, 0, regular__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__46_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39, new AbstractStackNode[]{new CharStackNode(50, 0, new int[][]{{45,45}}, new IEnterFilter[] {new CharPrecedeRestriction(new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}})}, null), new ListStackNode(52, 1, regular__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124, new CharStackNode(54, 0, new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}}, null, null), false, null, null), new CharStackNode(56, 2, new int[][]{{33,33},{35,36},{38,38},{42,43},{46,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}}, null, null), new ListStackNode(58, 3, regular__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124, new CharStackNode(60, 0, new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}}, null, null), false, null, null), new ListStackNode(62, 4, regular__iter__char_class___range__39_39, new CharStackNode(64, 0, new int[][]{{39,39}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{39,39}})})}, null, null);
      builder.addAlternative(EBNFParser.prod__Stem__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__46_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39_, tmp);
	}
    protected static final void _init_prod__Stem__seq___conditional__char_class___range__33_33_range__38_38_range__42_43_range__46_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new SequenceStackNode(66, 0, regular__seq___conditional__char_class___range__33_33_range__38_38_range__42_43_range__46_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39, new AbstractStackNode[]{new CharStackNode(68, 0, new int[][]{{33,33},{38,38},{42,43},{46,46},{60,63},{65,90},{95,95},{97,122},{124,124}}, new IEnterFilter[] {new CharPrecedeRestriction(new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}})}, null), new ListStackNode(70, 1, regular__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124, new CharStackNode(72, 0, new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}}, null, null), false, null, null), new ListStackNode(74, 2, regular__iter__char_class___range__39_39, new CharStackNode(76, 0, new int[][]{{39,39}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{39,39}})})}, null, null);
      builder.addAlternative(EBNFParser.prod__Stem__seq___conditional__char_class___range__33_33_range__38_38_range__42_43_range__46_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39_, tmp);
	}
    protected static final void _init_prod__Stem__conditional__char_class___range__45_45__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new CharStackNode(78, 0, new int[][]{{45,45}}, new IEnterFilter[] {new CharPrecedeRestriction(new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}})}, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{33,33},{35,36},{38,39},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}})});
      builder.addAlternative(EBNFParser.prod__Stem__conditional__char_class___range__45_45__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_, tmp);
	}
    protected static final void _init_prod__Stem__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new SequenceStackNode(80, 0, regular__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39, new AbstractStackNode[]{new CharStackNode(82, 0, new int[][]{{45,45}}, new IEnterFilter[] {new CharPrecedeRestriction(new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}})}, null), new ListStackNode(84, 1, regular__iter__char_class___range__39_39, new CharStackNode(86, 0, new int[][]{{39,39}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{39,39}})})}, null, null);
      builder.addAlternative(EBNFParser.prod__Stem__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter__char_class___range__39_39__not_follow__char_class___range__39_39_, tmp);
	}
    protected static final void _init_prod__Stem__seq___conditional__char_class___range__33_33_range__38_38_range__42_43_range__46_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new SequenceStackNode(88, 0, regular__seq___conditional__char_class___range__33_33_range__38_38_range__42_43_range__46_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124, new AbstractStackNode[]{new CharStackNode(90, 0, new int[][]{{33,33},{38,38},{42,43},{46,46},{60,63},{65,90},{95,95},{97,122},{124,124}}, new IEnterFilter[] {new CharPrecedeRestriction(new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}})}, null), new ListStackNode(92, 1, regular__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124, new CharStackNode(94, 0, new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}}, null, null), false, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{33,33},{35,36},{38,39},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}})})}, null, null);
      builder.addAlternative(EBNFParser.prod__Stem__seq___conditional__char_class___range__33_33_range__38_38_range__42_43_range__46_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_, tmp);
	}
    protected static final void _init_prod__Stem__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new SequenceStackNode(96, 0, regular__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124, new AbstractStackNode[]{new CharStackNode(98, 0, new int[][]{{45,45}}, new IEnterFilter[] {new CharPrecedeRestriction(new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}})}, null), new ListStackNode(100, 1, regular__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124, new CharStackNode(102, 0, new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}}, null, null), false, null, null), new CharStackNode(104, 2, new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{60,63},{65,90},{95,95},{97,122},{124,124}}, null, null), new ListStackNode(106, 3, regular__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124, new CharStackNode(108, 0, new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}}, null, null), false, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{33,33},{35,36},{38,39},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}})})}, null, null);
      builder.addAlternative(EBNFParser.prod__Stem__seq___conditional__char_class___range__45_45__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_, tmp);
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
	
  protected static class IntValue {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__IntValue__char_class___range__49_57_opt__char_class___range__48_57_char_class___range__82_82_range__114_114_conditional__iter__char_class___range__48_57_range__65_90_range__97_122__not_follow__char_class___range__48_57_range__65_90_range__97_122_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[4];
      
      tmp[3] = new ListStackNode(126, 3, regular__iter__char_class___range__48_57_range__65_90_range__97_122, new CharStackNode(128, 0, new int[][]{{48,57},{65,90},{97,122}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57},{65,90},{97,122}})});
      tmp[2] = new CharStackNode(124, 2, new int[][]{{82,82},{114,114}}, null, null);
      tmp[1] = new OptionalStackNode(120, 1, regular__opt__char_class___range__48_57, new CharStackNode(122, 0, new int[][]{{48,57}}, null, null), null, null);
      tmp[0] = new CharStackNode(118, 0, new int[][]{{49,57}}, null, null);
      builder.addAlternative(EBNFParser.prod__IntValue__char_class___range__49_57_opt__char_class___range__48_57_char_class___range__82_82_range__114_114_conditional__iter__char_class___range__48_57_range__65_90_range__97_122__not_follow__char_class___range__48_57_range__65_90_range__97_122_, tmp);
	}
    protected static final void _init_prod__IntValue__conditional__char_class___range__48_48__not_follow__char_class___range__48_55_range__88_88_range__120_120_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new CharStackNode(130, 0, new int[][]{{48,48}}, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,55},{88,88},{120,120}})});
      builder.addAlternative(EBNFParser.prod__IntValue__conditional__char_class___range__48_48__not_follow__char_class___range__48_55_range__88_88_range__120_120_, tmp);
	}
    protected static final void _init_prod__IntValue__char_class___range__48_48_conditional__iter__char_class___range__48_55__not_follow__char_class___range__48_55_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[2];
      
      tmp[1] = new ListStackNode(134, 1, regular__iter__char_class___range__48_55, new CharStackNode(136, 0, new int[][]{{48,55}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,55}})});
      tmp[0] = new CharStackNode(132, 0, new int[][]{{48,48}}, null, null);
      builder.addAlternative(EBNFParser.prod__IntValue__char_class___range__48_48_conditional__iter__char_class___range__48_55__not_follow__char_class___range__48_55_, tmp);
	}
    protected static final void _init_prod__IntValue__char_class___range__49_57_conditional__iter_star__char_class___range__48_57__not_follow__char_class___range__48_57_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[2];
      
      tmp[1] = new ListStackNode(140, 1, regular__iter_star__char_class___range__48_57, new CharStackNode(142, 0, new int[][]{{48,57}}, null, null), false, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57}})});
      tmp[0] = new CharStackNode(138, 0, new int[][]{{49,57}}, null, null);
      builder.addAlternative(EBNFParser.prod__IntValue__char_class___range__49_57_conditional__iter_star__char_class___range__48_57__not_follow__char_class___range__48_57_, tmp);
	}
    protected static final void _init_prod__IntValue__char_class___range__48_48_char_class___range__88_88_range__120_120_conditional__iter__char_class___range__48_57_range__65_70_range__97_102__not_follow__char_class___range__48_57_range__65_70_range__97_102_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new ListStackNode(148, 2, regular__iter__char_class___range__48_57_range__65_70_range__97_102, new CharStackNode(150, 0, new int[][]{{48,57},{65,70},{97,102}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57},{65,70},{97,102}})});
      tmp[1] = new CharStackNode(146, 1, new int[][]{{88,88},{120,120}}, null, null);
      tmp[0] = new CharStackNode(144, 0, new int[][]{{48,48}}, null, null);
      builder.addAlternative(EBNFParser.prod__IntValue__char_class___range__48_48_char_class___range__88_88_range__120_120_conditional__iter__char_class___range__48_57_range__65_70_range__97_102__not_follow__char_class___range__48_57_range__65_70_range__97_102_, tmp);
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
    
    protected static final void _init_prod__alt_Alt__Symbol_layouts_Standard_iter_star_seps__Exp__layouts_Standard_layouts_Standard_opt__Hints_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new OptionalStackNode(176, 4, regular__opt__Hints, new NonTerminalStackNode(178, 0, "Hints", null, null), null, null);
      tmp[3] = new NonTerminalStackNode(174, 3, "layouts_Standard", null, null);
      tmp[2] = new SeparatedListStackNode(168, 2, regular__iter_star_seps__Exp__layouts_Standard, new NonTerminalStackNode(170, 0, "Exp", null, null), new AbstractStackNode[]{new NonTerminalStackNode(172, 1, "layouts_Standard", null, null)}, false, null, null);
      tmp[1] = new NonTerminalStackNode(166, 1, "layouts_Standard", null, null);
      tmp[0] = new NonTerminalStackNode(164, 0, "Symbol", null, null);
      builder.addAlternative(EBNFParser.prod__alt_Alt__Symbol_layouts_Standard_iter_star_seps__Exp__layouts_Standard_layouts_Standard_opt__Hints_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__alt_Alt__Symbol_layouts_Standard_iter_star_seps__Exp__layouts_Standard_layouts_Standard_opt__Hints_(builder);
      
    }
  }
	
  protected static class EBNF {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__grammar_EBNF__lit_grammar_layouts_Standard_iter_star_seps__Rule__layouts_Standard_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new SeparatedListStackNode(212, 2, regular__iter_star_seps__Rule__layouts_Standard, new NonTerminalStackNode(214, 0, "Rule", null, null), new AbstractStackNode[]{new NonTerminalStackNode(216, 1, "layouts_Standard", null, null)}, false, null, null);
      tmp[1] = new NonTerminalStackNode(210, 1, "layouts_Standard", null, null);
      tmp[0] = new LiteralStackNode(208, 0, prod__lit_grammar__char_class___range__103_103_char_class___range__114_114_char_class___range__97_97_char_class___range__109_109_char_class___range__109_109_char_class___range__97_97_char_class___range__114_114_, new int[] {103,114,97,109,109,97,114}, null, null);
      builder.addAlternative(EBNFParser.prod__grammar_EBNF__lit_grammar_layouts_Standard_iter_star_seps__Rule__layouts_Standard_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__grammar_EBNF__lit_grammar_layouts_Standard_iter_star_seps__Rule__layouts_Standard_(builder);
      
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
      
      tmp[1] = new LiteralStackNode(230, 1, prod__lit_backspace__char_class___range__98_98_char_class___range__97_97_char_class___range__99_99_char_class___range__107_107_char_class___range__115_115_char_class___range__112_112_char_class___range__97_97_char_class___range__99_99_char_class___range__101_101_, new int[] {98,97,99,107,115,112,97,99,101}, null, null);
      tmp[0] = new CharStackNode(228, 0, new int[][]{{92,92}}, null, null);
      builder.addAlternative(EBNFParser.prod__Char__char_class___range__92_92_lit_backspace_, tmp);
	}
    protected static final void _init_prod__Char__char_class___range__92_92_lit_formfeed_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[2];
      
      tmp[1] = new LiteralStackNode(234, 1, prod__lit_formfeed__char_class___range__102_102_char_class___range__111_111_char_class___range__114_114_char_class___range__109_109_char_class___range__102_102_char_class___range__101_101_char_class___range__101_101_char_class___range__100_100_, new int[] {102,111,114,109,102,101,101,100}, null, null);
      tmp[0] = new CharStackNode(232, 0, new int[][]{{92,92}}, null, null);
      builder.addAlternative(EBNFParser.prod__Char__char_class___range__92_92_lit_formfeed_, tmp);
	}
    protected static final void _init_prod__Char__char_class___range__92_92_lit_tab_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[2];
      
      tmp[1] = new LiteralStackNode(238, 1, prod__lit_tab__char_class___range__116_116_char_class___range__97_97_char_class___range__98_98_, new int[] {116,97,98}, null, null);
      tmp[0] = new CharStackNode(236, 0, new int[][]{{92,92}}, null, null);
      builder.addAlternative(EBNFParser.prod__Char__char_class___range__92_92_lit_tab_, tmp);
	}
    protected static final void _init_prod__Char__char_class___range__92_92_lit_newline_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[2];
      
      tmp[1] = new LiteralStackNode(242, 1, prod__lit_newline__char_class___range__110_110_char_class___range__101_101_char_class___range__119_119_char_class___range__108_108_char_class___range__105_105_char_class___range__110_110_char_class___range__101_101_, new int[] {110,101,119,108,105,110,101}, null, null);
      tmp[0] = new CharStackNode(240, 0, new int[][]{{92,92}}, null, null);
      builder.addAlternative(EBNFParser.prod__Char__char_class___range__92_92_lit_newline_, tmp);
	}
    protected static final void _init_prod__Char__char_class___range__92_92_char_class___range__0_7_range__11_11_range__14_31_range__33_16777215_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[2];
      
      tmp[1] = new CharStackNode(246, 1, new int[][]{{0,7},{11,11},{14,31},{33,16777215}}, null, null);
      tmp[0] = new CharStackNode(244, 0, new int[][]{{92,92}}, null, null);
      builder.addAlternative(EBNFParser.prod__Char__char_class___range__92_92_char_class___range__0_7_range__11_11_range__14_31_range__33_16777215_, tmp);
	}
    protected static final void _init_prod__Char__char_class___range__92_92_lit_space_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[2];
      
      tmp[1] = new LiteralStackNode(250, 1, prod__lit_space__char_class___range__115_115_char_class___range__112_112_char_class___range__97_97_char_class___range__99_99_char_class___range__101_101_, new int[] {115,112,97,99,101}, null, null);
      tmp[0] = new CharStackNode(248, 0, new int[][]{{92,92}}, null, null);
      builder.addAlternative(EBNFParser.prod__Char__char_class___range__92_92_lit_space_, tmp);
	}
    protected static final void _init_prod__Char__char_class___range__92_92_lit_return_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[2];
      
      tmp[1] = new LiteralStackNode(254, 1, prod__lit_return__char_class___range__114_114_char_class___range__101_101_char_class___range__116_116_char_class___range__117_117_char_class___range__114_114_char_class___range__110_110_, new int[] {114,101,116,117,114,110}, null, null);
      tmp[0] = new CharStackNode(252, 0, new int[][]{{92,92}}, null, null);
      builder.addAlternative(EBNFParser.prod__Char__char_class___range__92_92_lit_return_, tmp);
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
    
    protected static final void _init_prod__rule_Rule__Symbol_layouts_Standard_lit___61_layouts_Standard_iter_star_seps__Alt__layouts_Standard_lit___124_layouts_Standard_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new SeparatedListStackNode(264, 4, regular__iter_star_seps__Alt__layouts_Standard_lit___124_layouts_Standard, new NonTerminalStackNode(266, 0, "Alt", null, null), new AbstractStackNode[]{new NonTerminalStackNode(268, 1, "layouts_Standard", null, null), new LiteralStackNode(270, 2, prod__lit___124__char_class___range__124_124_, new int[] {124}, null, null), new NonTerminalStackNode(272, 3, "layouts_Standard", null, null)}, false, null, null);
      tmp[3] = new NonTerminalStackNode(262, 3, "layouts_Standard", null, null);
      tmp[2] = new LiteralStackNode(260, 2, prod__lit___61__char_class___range__61_61_, new int[] {61}, null, null);
      tmp[1] = new NonTerminalStackNode(258, 1, "layouts_Standard", null, null);
      tmp[0] = new NonTerminalStackNode(256, 0, "Symbol", null, null);
      builder.addAlternative(EBNFParser.prod__rule_Rule__Symbol_layouts_Standard_lit___61_layouts_Standard_iter_star_seps__Alt__layouts_Standard_lit___124_layouts_Standard_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__rule_Rule__Symbol_layouts_Standard_lit___61_layouts_Standard_iter_star_seps__Alt__layouts_Standard_lit___124_layouts_Standard_(builder);
      
    }
  }
	
  protected static class Hint {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__class_Hint__lit_class_layouts_Standard_Symbol_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new NonTerminalStackNode(294, 2, "Symbol", null, null);
      tmp[1] = new NonTerminalStackNode(292, 1, "layouts_Standard", null, null);
      tmp[0] = new LiteralStackNode(290, 0, prod__lit_class__char_class___range__99_99_char_class___range__108_108_char_class___range__97_97_char_class___range__115_115_char_class___range__115_115_, new int[] {99,108,97,115,115}, null, null);
      builder.addAlternative(EBNFParser.prod__class_Hint__lit_class_layouts_Standard_Symbol_, tmp);
	}
    protected static final void _init_prod__folding_Hint__lit_folding_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(296, 0, prod__lit_folding__char_class___range__102_102_char_class___range__111_111_char_class___range__108_108_char_class___range__100_100_char_class___range__105_105_char_class___range__110_110_char_class___range__103_103_, new int[] {102,111,108,100,105,110,103}, null, null);
      builder.addAlternative(EBNFParser.prod__folding_Hint__lit_folding_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__class_Hint__lit_class_layouts_Standard_Symbol_(builder);
      
        _init_prod__folding_Hint__lit_folding_(builder);
      
    }
  }
	
  protected static class Hints {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__hints_Hints__lit___40_layouts_Standard_iter_star_seps__Hint__layouts_Standard_layouts_Standard_lit___41_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new LiteralStackNode(330, 4, prod__lit___41__char_class___range__41_41_, new int[] {41}, null, null);
      tmp[3] = new NonTerminalStackNode(328, 3, "layouts_Standard", null, null);
      tmp[2] = new SeparatedListStackNode(322, 2, regular__iter_star_seps__Hint__layouts_Standard, new NonTerminalStackNode(324, 0, "Hint", null, null), new AbstractStackNode[]{new NonTerminalStackNode(326, 1, "layouts_Standard", null, null)}, false, null, null);
      tmp[1] = new NonTerminalStackNode(320, 1, "layouts_Standard", null, null);
      tmp[0] = new LiteralStackNode(318, 0, prod__lit___40__char_class___range__40_40_, new int[] {40}, null, null);
      builder.addAlternative(EBNFParser.prod__hints_Hints__lit___40_layouts_Standard_iter_star_seps__Hint__layouts_Standard_layouts_Standard_lit___41_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__hints_Hints__lit___40_layouts_Standard_iter_star_seps__Hint__layouts_Standard_layouts_Standard_lit___41_(builder);
      
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
      
      tmp[0] = new LiteralStackNode(406, 0, prod__lit_string__char_class___range__115_115_char_class___range__116_116_char_class___range__114_114_char_class___range__105_105_char_class___range__110_110_char_class___range__103_103_, new int[] {115,116,114,105,110,103}, null, null);
      builder.addAlternative(EBNFParser.prod__Tokens__lit_string_, tmp);
	}
    protected static final void _init_prod__Tokens__lit___61_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(408, 0, prod__lit___61__char_class___range__61_61_, new int[] {61}, null, null);
      builder.addAlternative(EBNFParser.prod__Tokens__lit___61_, tmp);
	}
    protected static final void _init_prod__Tokens__lit_float_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(410, 0, prod__lit_float__char_class___range__102_102_char_class___range__108_108_char_class___range__111_111_char_class___range__97_97_char_class___range__116_116_, new int[] {102,108,111,97,116}, null, null);
      builder.addAlternative(EBNFParser.prod__Tokens__lit_float_, tmp);
	}
    protected static final void _init_prod__Tokens__lit___124_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(412, 0, prod__lit___124__char_class___range__124_124_, new int[] {124}, null, null);
      builder.addAlternative(EBNFParser.prod__Tokens__lit___124_, tmp);
	}
    protected static final void _init_prod__Tokens__lit_form_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(414, 0, prod__lit_form__char_class___range__102_102_char_class___range__111_111_char_class___range__114_114_char_class___range__109_109_, new int[] {102,111,114,109}, null, null);
      builder.addAlternative(EBNFParser.prod__Tokens__lit_form_, tmp);
	}
    protected static final void _init_prod__Tokens__lit_regexp_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(416, 0, prod__lit_regexp__char_class___range__114_114_char_class___range__101_101_char_class___range__103_103_char_class___range__101_101_char_class___range__120_120_char_class___range__112_112_, new int[] {114,101,103,101,120,112}, null, null);
      builder.addAlternative(EBNFParser.prod__Tokens__lit_regexp_, tmp);
	}
    protected static final void _init_prod__Tokens__lit_rational_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(418, 0, prod__lit_rational__char_class___range__114_114_char_class___range__97_97_char_class___range__116_116_char_class___range__105_105_char_class___range__111_111_char_class___range__110_110_char_class___range__97_97_char_class___range__108_108_, new int[] {114,97,116,105,111,110,97,108}, null, null);
      builder.addAlternative(EBNFParser.prod__Tokens__lit_rational_, tmp);
	}
    protected static final void _init_prod__Tokens__lit_integer_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(420, 0, prod__lit_integer__char_class___range__105_105_char_class___range__110_110_char_class___range__116_116_char_class___range__101_101_char_class___range__103_103_char_class___range__101_101_char_class___range__114_114_, new int[] {105,110,116,101,103,101,114}, null, null);
      builder.addAlternative(EBNFParser.prod__Tokens__lit_integer_, tmp);
	}
    protected static final void _init_prod__Tokens__lit_char_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(422, 0, prod__lit_char__char_class___range__99_99_char_class___range__104_104_char_class___range__97_97_char_class___range__114_114_, new int[] {99,104,97,114}, null, null);
      builder.addAlternative(EBNFParser.prod__Tokens__lit_char_, tmp);
	}
    protected static final void _init_prod__Tokens__lit_number_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(424, 0, prod__lit_number__char_class___range__110_110_char_class___range__117_117_char_class___range__109_109_char_class___range__98_98_char_class___range__101_101_char_class___range__114_114_, new int[] {110,117,109,98,101,114}, null, null);
      builder.addAlternative(EBNFParser.prod__Tokens__lit_number_, tmp);
	}
    protected static final void _init_prod__Tokens__lit_symbol_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(426, 0, prod__lit_symbol__char_class___range__115_115_char_class___range__121_121_char_class___range__109_109_char_class___range__98_98_char_class___range__111_111_char_class___range__108_108_, new int[] {115,121,109,98,111,108}, null, null);
      builder.addAlternative(EBNFParser.prod__Tokens__lit_symbol_, tmp);
	}
    protected static final void _init_prod__Tokens__lit_grammar_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(428, 0, prod__lit_grammar__char_class___range__103_103_char_class___range__114_114_char_class___range__97_97_char_class___range__109_109_char_class___range__109_109_char_class___range__97_97_char_class___range__114_114_, new int[] {103,114,97,109,109,97,114}, null, null);
      builder.addAlternative(EBNFParser.prod__Tokens__lit_grammar_, tmp);
	}
    protected static final void _init_prod__Tokens__lit_keyword_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(430, 0, prod__lit_keyword__char_class___range__107_107_char_class___range__101_101_char_class___range__121_121_char_class___range__119_119_char_class___range__111_111_char_class___range__114_114_char_class___range__100_100_, new int[] {107,101,121,119,111,114,100}, null, null);
      builder.addAlternative(EBNFParser.prod__Tokens__lit_keyword_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__Tokens__lit_string_(builder);
      
        _init_prod__Tokens__lit___61_(builder);
      
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
      
      tmp[1] = new SeparatedListStackNode(436, 1, regular__iter_seps__Stem__lit___58, new NonTerminalStackNode(438, 0, "Stem", null, null), new AbstractStackNode[]{new LiteralStackNode(440, 1, prod__lit___58__char_class___range__58_58_, new int[] {58}, null, null)}, true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{33,33},{35,36},{38,39},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}})});
      tmp[0] = new OptionalStackNode(432, 0, regular__opt__lit___58, new LiteralStackNode(434, 0, prod__lit___58__char_class___range__58_58_, new int[] {58}, null, null), null, null);
      builder.addAlternative(EBNFParser.prod__Ident__opt__lit___58_conditional__iter_seps__Stem__lit___58__not_follow__char_class___range__33_33_range__35_36_range__38_39_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_, tmp);
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
      
      tmp[0] = new ListStackNode(446, 0, regular__iter_star__char_class___range__9_10_range__13_13_range__32_32, new CharStackNode(448, 0, new int[][]{{9,10},{13,13},{32,32}}, null, null), false, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{9,10},{13,13},{32,32}})});
      builder.addAlternative(EBNFParser.prod__layouts_$QUOTES__conditional__iter_star__char_class___range__9_10_range__13_13_range__32_32__not_follow__char_class___range__9_10_range__13_13_range__32_32_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__layouts_$QUOTES__conditional__iter_star__char_class___range__9_10_range__13_13_range__32_32__not_follow__char_class___range__9_10_range__13_13_range__32_32_(builder);
      
    }
  }
	
  protected static class Comment {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__Comment__lit___59_conditional__iter_star__char_class___range__0_9_range__11_12_range__14_16777215__end_of_line__tag__category___67_111_109_109_101_110_116(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[2];
      
      tmp[1] = new ListStackNode(516, 1, regular__iter_star__char_class___range__0_9_range__11_12_range__14_16777215, new CharStackNode(518, 0, new int[][]{{0,9},{11,12},{14,16777215}}, null, null), false, null, new ICompletionFilter[] {new AtEndOfLineRequirement()});
      tmp[0] = new LiteralStackNode(514, 0, prod__lit___59__char_class___range__59_59_, new int[] {59}, null, null);
      builder.addAlternative(EBNFParser.prod__Comment__lit___59_conditional__iter_star__char_class___range__0_9_range__11_12_range__14_16777215__end_of_line__tag__category___67_111_109_109_101_110_116, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__Comment__lit___59_conditional__iter_star__char_class___range__0_9_range__11_12_range__14_16777215__end_of_line__tag__category___67_111_109_109_101_110_116(builder);
      
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
      
      tmp[2] = new OptionalStackNode(526, 2, regular__opt__char_class___range__77_77, new CharStackNode(528, 0, new int[][]{{77,77}}, null, null), null, null);
      tmp[1] = new NonTerminalStackNode(524, 1, "FloatValue", null, null);
      tmp[0] = new OptionalStackNode(520, 0, regular__opt__char_class___range__43_43_range__45_45, new CharStackNode(522, 0, new int[][]{{43,43},{45,45}}, null, null), null, null);
      builder.addAlternative(EBNFParser.prod__Float__opt__char_class___range__43_43_range__45_45_FloatValue_opt__char_class___range__77_77_, tmp);
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
      
      tmp[2] = new NonTerminalStackNode(554, 2, "Ident", null, null);
      tmp[1] = new LiteralStackNode(552, 1, prod__lit___47__char_class___range__47_47_, new int[] {47}, null, null);
      tmp[0] = new NonTerminalStackNode(550, 0, "Ident", null, null);
      builder.addAlternative(EBNFParser.prod__Symbol__Ident_lit___47_Ident_, tmp);
	}
    protected static final void _init_prod__Symbol__Ident_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(556, 0, "Ident", null, null);
      builder.addAlternative(EBNFParser.prod__Symbol__Ident_, tmp);
	}
    protected static final void _init_prod__Symbol__conditional__lit___47__not_follow__char_class___range__33_33_range__38_38_range__42_43_range__45_46_range__58_58_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(558, 0, prod__lit___47__char_class___range__47_47_, new int[] {47}, new IEnterFilter[] {new CharPrecedeRestriction(new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}})}, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{33,33},{38,38},{42,43},{45,46},{58,58},{60,63},{65,90},{95,95},{97,122},{124,124}})});
      builder.addAlternative(EBNFParser.prod__Symbol__conditional__lit___47__not_follow__char_class___range__33_33_range__38_38_range__42_43_range__45_46_range__58_58_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_, tmp);
	}
    protected static final void _init_prod__Symbol__lit___58_58_Ident_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[2];
      
      tmp[1] = new NonTerminalStackNode(562, 1, "Ident", null, null);
      tmp[0] = new LiteralStackNode(560, 0, prod__lit___58_58__char_class___range__58_58_char_class___range__58_58_, new int[] {58,58}, null, null);
      builder.addAlternative(EBNFParser.prod__Symbol__lit___58_58_Ident_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__Symbol__Ident_lit___47_Ident_(builder);
      
        _init_prod__Symbol__Ident_(builder);
      
        _init_prod__Symbol__conditional__lit___47__not_follow__char_class___range__33_33_range__38_38_range__42_43_range__45_46_range__58_58_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_(builder);
      
        _init_prod__Symbol__lit___58_58_Ident_(builder);
      
    }
  }
	
  protected static class WhitespaceOrComment {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__whitespace_WhitespaceOrComment__Whitespace_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(564, 0, "Whitespace", null, null);
      builder.addAlternative(EBNFParser.prod__whitespace_WhitespaceOrComment__Whitespace_, tmp);
	}
    protected static final void _init_prod__comment_WhitespaceOrComment__Comment_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(566, 0, "Comment", null, null);
      builder.addAlternative(EBNFParser.prod__comment_WhitespaceOrComment__Comment_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__whitespace_WhitespaceOrComment__Whitespace_(builder);
      
        _init_prod__comment_WhitespaceOrComment__Comment_(builder);
      
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
      
      tmp[2] = new CharStackNode(602, 2, new int[][]{{34,34}}, null, null);
      tmp[1] = new ListStackNode(598, 1, regular__iter_star__StrChar, new NonTerminalStackNode(600, 0, "StrChar", null, null), false, null, null);
      tmp[0] = new CharStackNode(596, 0, new int[][]{{34,34}}, null, null);
      builder.addAlternative(EBNFParser.prod__String__char_class___range__34_34_iter_star__StrChar_char_class___range__34_34__tag__category___83_116_114_105_110_103_76_105_116_101_114_97_108, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__String__char_class___range__34_34_iter_star__StrChar_char_class___range__34_34__tag__category___83_116_114_105_110_103_76_105_116_101_114_97_108(builder);
      
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
      
      tmp[3] = new CharStackNode(640, 3, new int[][]{{34,34}}, null, null);
      tmp[2] = new ListStackNode(628, 2, regular__iter_star__alt___char_class___range__0_33_range__35_16777215_seq___char_class___range__92_92_char_class___range__34_34, new AlternativeStackNode(630, 0, regular__alt___char_class___range__0_33_range__35_16777215_seq___char_class___range__92_92_char_class___range__34_34, new AbstractStackNode[]{new CharStackNode(632, 0, new int[][]{{0,33},{35,16777215}}, null, null), new SequenceStackNode(634, 0, regular__seq___char_class___range__92_92_char_class___range__34_34, new AbstractStackNode[]{new CharStackNode(636, 0, new int[][]{{92,92}}, null, null), new CharStackNode(638, 1, new int[][]{{34,34}}, null, null)}, null, null)}, null, null), false, null, null);
      tmp[1] = new CharStackNode(626, 1, new int[][]{{34,34}}, null, null);
      tmp[0] = new CharStackNode(624, 0, new int[][]{{35,35}}, null, null);
      builder.addAlternative(EBNFParser.prod__RegExp__char_class___range__35_35_char_class___range__34_34_iter_star__alt___char_class___range__0_33_range__35_16777215_seq___char_class___range__92_92_char_class___range__34_34_char_class___range__34_34_, tmp);
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
      
      tmp[3] = new CharStackNode(652, 3, new int[][]{{48,55}}, null, null);
      tmp[2] = new CharStackNode(650, 2, new int[][]{{48,55}}, null, null);
      tmp[1] = new CharStackNode(648, 1, new int[][]{{48,51}}, null, null);
      tmp[0] = new CharStackNode(646, 0, new int[][]{{92,92}}, null, null);
      builder.addAlternative(EBNFParser.prod__StrChar__char_class___range__92_92_char_class___range__48_51_char_class___range__48_55_char_class___range__48_55_, tmp);
	}
    protected static final void _init_prod__StrChar__char_class___range__0_33_range__35_91_range__93_16777215_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new CharStackNode(654, 0, new int[][]{{0,33},{35,91},{93,16777215}}, null, null);
      builder.addAlternative(EBNFParser.prod__StrChar__char_class___range__0_33_range__35_91_range__93_16777215_, tmp);
	}
    protected static final void _init_prod__StrChar__char_class___range__92_92_char_class___range__34_34_range__92_92_range__98_98_range__102_102_range__110_110_range__114_114_range__116_116_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[2];
      
      tmp[1] = new CharStackNode(658, 1, new int[][]{{34,34},{92,92},{98,98},{102,102},{110,110},{114,114},{116,116}}, null, null);
      tmp[0] = new CharStackNode(656, 0, new int[][]{{92,92}}, null, null);
      builder.addAlternative(EBNFParser.prod__StrChar__char_class___range__92_92_char_class___range__34_34_range__92_92_range__98_98_range__102_102_range__110_110_range__114_114_range__116_116_, tmp);
	}
    protected static final void _init_prod__StrChar__char_class___range__92_92_char_class___range__117_117_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[6];
      
      tmp[5] = new CharStackNode(670, 5, new int[][]{{48,57},{65,70},{97,102}}, null, null);
      tmp[4] = new CharStackNode(668, 4, new int[][]{{48,57},{65,70},{97,102}}, null, null);
      tmp[3] = new CharStackNode(666, 3, new int[][]{{48,57},{65,70},{97,102}}, null, null);
      tmp[2] = new CharStackNode(664, 2, new int[][]{{48,57},{65,70},{97,102}}, null, null);
      tmp[1] = new CharStackNode(662, 1, new int[][]{{117,117}}, null, null);
      tmp[0] = new CharStackNode(660, 0, new int[][]{{92,92}}, null, null);
      builder.addAlternative(EBNFParser.prod__StrChar__char_class___range__92_92_char_class___range__117_117_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__StrChar__char_class___range__92_92_char_class___range__48_51_char_class___range__48_55_char_class___range__48_55_(builder);
      
        _init_prod__StrChar__char_class___range__0_33_range__35_91_range__93_16777215_(builder);
      
        _init_prod__StrChar__char_class___range__92_92_char_class___range__34_34_range__92_92_range__98_98_range__102_102_range__110_110_range__114_114_range__116_116_(builder);
      
        _init_prod__StrChar__char_class___range__92_92_char_class___range__117_117_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_char_class___range__48_57_range__65_70_range__97_102_(builder);
      
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
      
      tmp[2] = new OptionalStackNode(712, 2, regular__opt__char_class___range__78_78, new CharStackNode(714, 0, new int[][]{{78,78}}, null, null), null, null);
      tmp[1] = new NonTerminalStackNode(710, 1, "IntValue", null, null);
      tmp[0] = new OptionalStackNode(706, 0, regular__opt__char_class___range__43_43_range__45_45, new CharStackNode(708, 0, new int[][]{{43,43},{45,45}}, null, null), null, null);
      builder.addAlternative(EBNFParser.prod__Integer__opt__char_class___range__43_43_range__45_45_IntValue_opt__char_class___range__78_78_, tmp);
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
      
      tmp[0] = new EpsilonStackNode(718, 0);
      builder.addAlternative(EBNFParser.prod__layouts_$BACKTICKS__, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__layouts_$BACKTICKS__(builder);
      
    }
  }
	
  protected static class Whitespace {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__Whitespace__char_class___range__9_10_range__12_13_range__32_32_range__44_44_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new CharStackNode(720, 0, new int[][]{{9,10},{12,13},{32,32},{44,44}}, null, null);
      builder.addAlternative(EBNFParser.prod__Whitespace__char_class___range__9_10_range__12_13_range__32_32_range__44_44_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__Whitespace__char_class___range__9_10_range__12_13_range__32_32_range__44_44_(builder);
      
    }
  }
	
  protected static class Exp {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__optional_Exp__lit___91_layouts_Standard_Exp_layouts_Standard_lit___93_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new LiteralStackNode(774, 4, prod__lit___93__char_class___range__93_93_, new int[] {93}, null, null);
      tmp[3] = new NonTerminalStackNode(772, 3, "layouts_Standard", null, null);
      tmp[2] = new NonTerminalStackNode(770, 2, "Exp", null, null);
      tmp[1] = new NonTerminalStackNode(768, 1, "layouts_Standard", null, null);
      tmp[0] = new LiteralStackNode(766, 0, prod__lit___91__char_class___range__91_91_, new int[] {91}, null, null);
      builder.addAlternative(EBNFParser.prod__optional_Exp__lit___91_layouts_Standard_Exp_layouts_Standard_lit___93_, tmp);
	}
    protected static final void _init_prod__string_Exp__lit_string_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(778, 0, prod__lit_string__char_class___range__115_115_char_class___range__116_116_char_class___range__114_114_char_class___range__105_105_char_class___range__110_110_char_class___range__103_103_, new int[] {115,116,114,105,110,103}, null, null);
      builder.addAlternative(EBNFParser.prod__string_Exp__lit_string_, tmp);
	}
    protected static final void _init_prod__regexp_Exp__lit_regexp_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(776, 0, prod__lit_regexp__char_class___range__114_114_char_class___range__101_101_char_class___range__103_103_char_class___range__101_101_char_class___range__120_120_char_class___range__112_112_, new int[] {114,101,103,101,120,112}, null, null);
      builder.addAlternative(EBNFParser.prod__regexp_Exp__lit_regexp_, tmp);
	}
    protected static final void _init_prod__form_Exp__lit_form_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(780, 0, prod__lit_form__char_class___range__102_102_char_class___range__111_111_char_class___range__114_114_char_class___range__109_109_, new int[] {102,111,114,109}, null, null);
      builder.addAlternative(EBNFParser.prod__form_Exp__lit_form_, tmp);
	}
    protected static final void _init_prod__number_Exp__lit_number_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(782, 0, prod__lit_number__char_class___range__110_110_char_class___range__117_117_char_class___range__109_109_char_class___range__98_98_char_class___range__101_101_char_class___range__114_114_, new int[] {110,117,109,98,101,114}, null, null);
      builder.addAlternative(EBNFParser.prod__number_Exp__lit_number_, tmp);
	}
    protected static final void _init_prod__symbol_Exp__lit_symbol_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(784, 0, prod__lit_symbol__char_class___range__115_115_char_class___range__121_121_char_class___range__109_109_char_class___range__98_98_char_class___range__111_111_char_class___range__108_108_, new int[] {115,121,109,98,111,108}, null, null);
      builder.addAlternative(EBNFParser.prod__symbol_Exp__lit_symbol_, tmp);
	}
    protected static final void _init_prod__keyword_Exp__lit_keyword_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(786, 0, prod__lit_keyword__char_class___range__107_107_char_class___range__101_101_char_class___range__121_121_char_class___range__119_119_char_class___range__111_111_char_class___range__114_114_char_class___range__100_100_, new int[] {107,101,121,119,111,114,100}, null, null);
      builder.addAlternative(EBNFParser.prod__keyword_Exp__lit_keyword_, tmp);
	}
    protected static final void _init_prod__integer_Exp__lit_integer_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(790, 0, prod__lit_integer__char_class___range__105_105_char_class___range__110_110_char_class___range__116_116_char_class___range__101_101_char_class___range__103_103_char_class___range__101_101_char_class___range__114_114_, new int[] {105,110,116,101,103,101,114}, null, null);
      builder.addAlternative(EBNFParser.prod__integer_Exp__lit_integer_, tmp);
	}
    protected static final void _init_prod__rational_Exp__lit_rational_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(788, 0, prod__lit_rational__char_class___range__114_114_char_class___range__97_97_char_class___range__116_116_char_class___range__105_105_char_class___range__111_111_char_class___range__110_110_char_class___range__97_97_char_class___range__108_108_, new int[] {114,97,116,105,111,110,97,108}, null, null);
      builder.addAlternative(EBNFParser.prod__rational_Exp__lit_rational_, tmp);
	}
    protected static final void _init_prod__repeatSep_Exp__lit___123_layouts_Standard_Exp_layouts_Standard_String_layouts_Standard_lit___125_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[7];
      
      tmp[6] = new LiteralStackNode(804, 6, prod__lit___125__char_class___range__125_125_, new int[] {125}, null, null);
      tmp[5] = new NonTerminalStackNode(802, 5, "layouts_Standard", null, null);
      tmp[4] = new NonTerminalStackNode(800, 4, "String", null, null);
      tmp[3] = new NonTerminalStackNode(798, 3, "layouts_Standard", null, null);
      tmp[2] = new NonTerminalStackNode(796, 2, "Exp", null, null);
      tmp[1] = new NonTerminalStackNode(794, 1, "layouts_Standard", null, null);
      tmp[0] = new LiteralStackNode(792, 0, prod__lit___123__char_class___range__123_123_, new int[] {123}, null, null);
      builder.addAlternative(EBNFParser.prod__repeatSep_Exp__lit___123_layouts_Standard_Exp_layouts_Standard_String_layouts_Standard_lit___125_, tmp);
	}
    protected static final void _init_prod__repeat_Exp__lit___123_layouts_Standard_Exp_layouts_Standard_lit___125_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new LiteralStackNode(814, 4, prod__lit___125__char_class___range__125_125_, new int[] {125}, null, null);
      tmp[3] = new NonTerminalStackNode(812, 3, "layouts_Standard", null, null);
      tmp[2] = new NonTerminalStackNode(810, 2, "Exp", null, null);
      tmp[1] = new NonTerminalStackNode(808, 1, "layouts_Standard", null, null);
      tmp[0] = new LiteralStackNode(806, 0, prod__lit___123__char_class___range__123_123_, new int[] {123}, null, null);
      builder.addAlternative(EBNFParser.prod__repeat_Exp__lit___123_layouts_Standard_Exp_layouts_Standard_lit___125_, tmp);
	}
    protected static final void _init_prod__call_Exp__conditional__Symbol__delete__Tokens_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(816, 0, "Symbol", null, new ICompletionFilter[] {new StringMatchRestriction(new int[] {102,111,114,109}), new StringMatchRestriction(new int[] {99,104,97,114}), new StringMatchRestriction(new int[] {103,114,97,109,109,97,114}), new StringMatchRestriction(new int[] {115,116,114,105,110,103}), new StringMatchRestriction(new int[] {102,108,111,97,116}), new StringMatchRestriction(new int[] {124}), new StringMatchRestriction(new int[] {61}), new StringMatchRestriction(new int[] {114,97,116,105,111,110,97,108}), new StringMatchRestriction(new int[] {105,110,116,101,103,101,114}), new StringMatchRestriction(new int[] {115,121,109,98,111,108}), new StringMatchRestriction(new int[] {114,101,103,101,120,112}), new StringMatchRestriction(new int[] {110,117,109,98,101,114}), new StringMatchRestriction(new int[] {107,101,121,119,111,114,100})});
      builder.addAlternative(EBNFParser.prod__call_Exp__conditional__Symbol__delete__Tokens_, tmp);
	}
    protected static final void _init_prod__char_Exp__lit_char_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(818, 0, prod__lit_char__char_class___range__99_99_char_class___range__104_104_char_class___range__97_97_char_class___range__114_114_, new int[] {99,104,97,114}, null, null);
      builder.addAlternative(EBNFParser.prod__char_Exp__lit_char_, tmp);
	}
    protected static final void _init_prod__float_Exp__lit_float_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(820, 0, prod__lit_float__char_class___range__102_102_char_class___range__108_108_char_class___range__111_111_char_class___range__97_97_char_class___range__116_116_, new int[] {102,108,111,97,116}, null, null);
      builder.addAlternative(EBNFParser.prod__float_Exp__lit_float_, tmp);
	}
    protected static final void _init_prod__literal_Exp__String_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(822, 0, "String", null, null);
      builder.addAlternative(EBNFParser.prod__literal_Exp__String_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__optional_Exp__lit___91_layouts_Standard_Exp_layouts_Standard_lit___93_(builder);
      
        _init_prod__string_Exp__lit_string_(builder);
      
        _init_prod__regexp_Exp__lit_regexp_(builder);
      
        _init_prod__form_Exp__lit_form_(builder);
      
        _init_prod__number_Exp__lit_number_(builder);
      
        _init_prod__symbol_Exp__lit_symbol_(builder);
      
        _init_prod__keyword_Exp__lit_keyword_(builder);
      
        _init_prod__integer_Exp__lit_integer_(builder);
      
        _init_prod__rational_Exp__lit_rational_(builder);
      
        _init_prod__repeatSep_Exp__lit___123_layouts_Standard_Exp_layouts_Standard_String_layouts_Standard_lit___125_(builder);
      
        _init_prod__repeat_Exp__lit___123_layouts_Standard_Exp_layouts_Standard_lit___125_(builder);
      
        _init_prod__call_Exp__conditional__Symbol__delete__Tokens_(builder);
      
        _init_prod__char_Exp__lit_char_(builder);
      
        _init_prod__float_Exp__lit_float_(builder);
      
        _init_prod__literal_Exp__String_(builder);
      
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
      
      tmp[3] = new OptionalStackNode(752, 3, regular__opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57, new SequenceStackNode(754, 0, regular__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57, new AbstractStackNode[]{new CharStackNode(756, 0, new int[][]{{69,69},{101,101}}, null, null), new OptionalStackNode(758, 1, regular__opt__char_class___range__43_43_range__45_45, new CharStackNode(760, 0, new int[][]{{43,43},{45,45}}, null, null), null, null), new ListStackNode(762, 2, regular__iter__char_class___range__48_57, new CharStackNode(764, 0, new int[][]{{48,57}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57}})})}, null, null), null, null);
      tmp[2] = new ListStackNode(748, 2, regular__iter__char_class___range__48_57, new CharStackNode(750, 0, new int[][]{{48,57}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57}})});
      tmp[1] = new CharStackNode(746, 1, new int[][]{{46,46}}, null, null);
      tmp[0] = new ListStackNode(742, 0, regular__iter__char_class___range__48_57, new CharStackNode(744, 0, new int[][]{{48,57}}, null, null), true, null, null);
      builder.addAlternative(EBNFParser.prod__FloatValue__iter__char_class___range__48_57_char_class___range__46_46_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__FloatValue__iter__char_class___range__48_57_char_class___range__46_46_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57_opt__seq___char_class___range__69_69_range__101_101_opt__char_class___range__43_43_range__45_45_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57_(builder);
      
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
      
      tmp[0] = new EpsilonStackNode(852, 0);
      builder.addAlternative(EBNFParser.prod__layouts_$default$__, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__layouts_$default$__(builder);
      
    }
  }
	
  public EBNFParser() {
    super();
  }

  // Parse methods    
  
  public AbstractStackNode[] layouts_Standard() {
    return layouts_Standard.EXPECTS;
  }
  public AbstractStackNode[] Ratio() {
    return Ratio.EXPECTS;
  }
  public AbstractStackNode[] Stem() {
    return Stem.EXPECTS;
  }
  public AbstractStackNode[] Number() {
    return Number.EXPECTS;
  }
  public AbstractStackNode[] IntValue() {
    return IntValue.EXPECTS;
  }
  public AbstractStackNode[] Alt() {
    return Alt.EXPECTS;
  }
  public AbstractStackNode[] EBNF() {
    return EBNF.EXPECTS;
  }
  public AbstractStackNode[] Char() {
    return Char.EXPECTS;
  }
  public AbstractStackNode[] Rule() {
    return Rule.EXPECTS;
  }
  public AbstractStackNode[] Hint() {
    return Hint.EXPECTS;
  }
  public AbstractStackNode[] Hints() {
    return Hints.EXPECTS;
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
  public AbstractStackNode[] Comment() {
    return Comment.EXPECTS;
  }
  public AbstractStackNode[] Float() {
    return Float.EXPECTS;
  }
  public AbstractStackNode[] Symbol() {
    return Symbol.EXPECTS;
  }
  public AbstractStackNode[] WhitespaceOrComment() {
    return WhitespaceOrComment.EXPECTS;
  }
  public AbstractStackNode[] String() {
    return String.EXPECTS;
  }
  public AbstractStackNode[] RegExp() {
    return RegExp.EXPECTS;
  }
  public AbstractStackNode[] StrChar() {
    return StrChar.EXPECTS;
  }
  public AbstractStackNode[] Integer() {
    return Integer.EXPECTS;
  }
  public AbstractStackNode[] layouts_$BACKTICKS() {
    return layouts_$BACKTICKS.EXPECTS;
  }
  public AbstractStackNode[] Whitespace() {
    return Whitespace.EXPECTS;
  }
  public AbstractStackNode[] FloatValue() {
    return FloatValue.EXPECTS;
  }
  public AbstractStackNode[] Exp() {
    return Exp.EXPECTS;
  }
  public AbstractStackNode[] layouts_$default$() {
    return layouts_$default$.EXPECTS;
  }
}