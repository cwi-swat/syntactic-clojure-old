package lang.clojure.syntax;

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
  private static final IConstructor prod__Ratio__Integer_lit___47_char_class___range__49_57_conditional__iter_star__char_class___range__48_57__not_follow__char_class___range__48_57_ = (IConstructor) _read("prod(lex(\"Ratio\"),[lex(\"Integer\"),lit(\"/\"),\\char-class([range(49,57)]),conditional(\\iter-star(\\char-class([range(48,57)])),{\\not-follow(\\char-class([range(48,57)]))})],{})", Factory.Production);
  private static final IConstructor prod__float_Number__Float_ = (IConstructor) _read("prod(label(\"float\",sort(\"Number\")),[lex(\"Float\")],{})", Factory.Production);
  private static final IConstructor prod__BigDecimal__Float_char_class___range__77_77_ = (IConstructor) _read("prod(lex(\"BigDecimal\"),[lex(\"Float\"),\\char-class([range(77,77)])],{})", Factory.Production);
  private static final IConstructor prod__Char__char_class___range__92_92_lit_space_ = (IConstructor) _read("prod(lex(\"Char\"),[\\char-class([range(92,92)]),lit(\"space\")],{})", Factory.Production);
  private static final IConstructor prod__Symbol__Ident_lit___47_Ident_ = (IConstructor) _read("prod(lex(\"Symbol\"),[lex(\"Ident\"),lit(\"/\"),lex(\"Ident\")],{})", Factory.Production);
  private static final IConstructor prod__lit___35_123__char_class___range__35_35_char_class___range__123_123_ = (IConstructor) _read("prod(lit(\"#{\"),[\\char-class([range(35,35)]),\\char-class([range(123,123)])],{})", Factory.Production);
  private static final IConstructor prod__comment_WhitespaceOrComment__Comment_ = (IConstructor) _read("prod(label(\"comment\",sort(\"WhitespaceOrComment\")),[lex(\"Comment\")],{})", Factory.Production);
  private static final IConstructor prod__String__char_class___range__34_34_iter_star__alt___seq___char_class___range__92_92_char_class___range__34_34_range__92_92_range__98_98_range__102_102_range__110_110_range__114_114_range__116_116_char_class___range__0_33_range__35_91_range__93_16777215_char_class___range__34_34__tag__category___83_116_114_105_110_103_76_105_116_101_114_97_108 = (IConstructor) _read("prod(lex(\"String\"),[\\char-class([range(34,34)]),\\iter-star(alt({seq([\\char-class([range(92,92)]),\\char-class([range(34,34),range(92,92),range(98,98),range(102,102),range(110,110),range(114,114),range(116,116)])]),\\char-class([range(0,33),range(35,91),range(93,16777215)])})),\\char-class([range(34,34)])],{tag(category(\"StringLiteral\"))})", Factory.Production);
  private static final IConstructor prod__RegExp__char_class___range__35_35_char_class___range__34_34_iter_star__alt___seq___char_class___range__92_92_char_class___range__34_34_range__40_43_range__46_46_range__63_63_range__83_83_range__87_87_range__91_93_range__100_100_range__115_115_range__119_119_char_class___range__0_33_range__35_91_range__93_16777215_char_class___range__34_34_ = (IConstructor) _read("prod(lex(\"RegExp\"),[\\char-class([range(35,35)]),\\char-class([range(34,34)]),\\iter-star(alt({seq([\\char-class([range(92,92)]),\\char-class([range(34,34),range(40,43),range(46,46),range(63,63),range(83,83),range(87,87),range(91,93),range(100,100),range(115,115),range(119,119)])]),\\char-class([range(0,33),range(35,91),range(93,16777215)])})),\\char-class([range(34,34)])],{})", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_57_range__65_73_range__97_105 = (IConstructor) _read("regular(iter(\\char-class([range(48,57),range(65,73),range(97,105)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_57_range__65_72_range__97_104 = (IConstructor) _read("regular(iter(\\char-class([range(48,57),range(65,72),range(97,104)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_57_range__65_83_range__97_115 = (IConstructor) _read("regular(iter(\\char-class([range(48,57),range(65,83),range(97,115)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_57_range__65_82_range__97_114 = (IConstructor) _read("regular(iter(\\char-class([range(48,57),range(65,82),range(97,114)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_57_range__65_90_range__97_122 = (IConstructor) _read("regular(iter(\\char-class([range(48,57),range(65,90),range(97,122)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_57_range__65_89_range__97_121 = (IConstructor) _read("regular(iter(\\char-class([range(48,57),range(65,89),range(97,121)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_57_range__65_88_range__97_120 = (IConstructor) _read("regular(iter(\\char-class([range(48,57),range(65,88),range(97,120)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_57_range__65_81_range__97_113 = (IConstructor) _read("regular(iter(\\char-class([range(48,57),range(65,81),range(97,113)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_57_range__65_80_range__97_112 = (IConstructor) _read("regular(iter(\\char-class([range(48,57),range(65,80),range(97,112)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_57_range__65_79_range__97_111 = (IConstructor) _read("regular(iter(\\char-class([range(48,57),range(65,79),range(97,111)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_57_range__65_78_range__97_110 = (IConstructor) _read("regular(iter(\\char-class([range(48,57),range(65,78),range(97,110)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_57_range__65_67_range__97_99 = (IConstructor) _read("regular(iter(\\char-class([range(48,57),range(65,67),range(97,99)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_57_range__65_66_range__97_98 = (IConstructor) _read("regular(iter(\\char-class([range(48,57),range(65,66),range(97,98)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_57_range__65_65_range__97_97 = (IConstructor) _read("regular(iter(\\char-class([range(48,57),range(65,65),range(97,97)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_57_range__65_87_range__97_119 = (IConstructor) _read("regular(iter(\\char-class([range(48,57),range(65,87),range(97,119)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_57_range__65_86_range__97_118 = (IConstructor) _read("regular(iter(\\char-class([range(48,57),range(65,86),range(97,118)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_57_range__65_85_range__97_117 = (IConstructor) _read("regular(iter(\\char-class([range(48,57),range(65,85),range(97,117)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_57_range__65_84_range__97_116 = (IConstructor) _read("regular(iter(\\char-class([range(48,57),range(65,84),range(97,116)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_57_range__65_77_range__97_109 = (IConstructor) _read("regular(iter(\\char-class([range(48,57),range(65,77),range(97,109)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_57_range__65_76_range__97_108 = (IConstructor) _read("regular(iter(\\char-class([range(48,57),range(65,76),range(97,108)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_57_range__65_75_range__97_107 = (IConstructor) _read("regular(iter(\\char-class([range(48,57),range(65,75),range(97,107)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_57_range__65_74_range__97_106 = (IConstructor) _read("regular(iter(\\char-class([range(48,57),range(65,74),range(97,106)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_57_range__65_71_range__97_103 = (IConstructor) _read("regular(iter(\\char-class([range(48,57),range(65,71),range(97,103)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_57_range__65_70_range__97_102 = (IConstructor) _read("regular(iter(\\char-class([range(48,57),range(65,70),range(97,102)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_57_range__65_69_range__97_101 = (IConstructor) _read("regular(iter(\\char-class([range(48,57),range(65,69),range(97,101)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_57_range__65_68_range__97_100 = (IConstructor) _read("regular(iter(\\char-class([range(48,57),range(65,68),range(97,100)])))", Factory.Production);
  private static final IConstructor regular__iter_star__char_class___range__48_57 = (IConstructor) _read("regular(\\iter-star(\\char-class([range(48,57)])))", Factory.Production);
  private static final IConstructor prod__layouts_$BACKTICKS__ = (IConstructor) _read("prod(layouts(\"$BACKTICKS\"),[],{})", Factory.Production);
  private static final IConstructor prod__lit___126_64__char_class___range__126_126_char_class___range__64_64_ = (IConstructor) _read("prod(lit(\"~@\"),[\\char-class([range(126,126)]),\\char-class([range(64,64)])],{})", Factory.Production);
  private static final IConstructor prod__lit_newline__char_class___range__110_110_char_class___range__101_101_char_class___range__119_119_char_class___range__108_108_char_class___range__105_105_char_class___range__110_110_char_class___range__101_101_ = (IConstructor) _read("prod(lit(\"newline\"),[\\char-class([range(110,110)]),\\char-class([range(101,101)]),\\char-class([range(119,119)]),\\char-class([range(108,108)]),\\char-class([range(105,105)]),\\char-class([range(110,110)]),\\char-class([range(101,101)])],{})", Factory.Production);
  private static final IConstructor prod__qquote_Form__lit___96_layouts_Standard_arg_Form_ = (IConstructor) _read("prod(label(\"qquote\",sort(\"Form\")),[lit(\"`\"),layouts(\"Standard\"),label(\"arg\",sort(\"Form\"))],{})", Factory.Production);
  private static final IConstructor prod__unquotes_Form__lit___126_64_layouts_Standard_arg_Form_ = (IConstructor) _read("prod(label(\"unquotes\",sort(\"Form\")),[lit(\"~@\"),layouts(\"Standard\"),label(\"arg\",sort(\"Form\"))],{})", Factory.Production);
  private static final IConstructor prod__layouts_$default$__ = (IConstructor) _read("prod(layouts(\"$default$\"),[],{})", Factory.Production);
  private static final IConstructor prod__ratio_Number__Ratio_ = (IConstructor) _read("prod(label(\"ratio\",sort(\"Number\")),[lex(\"Ratio\")],{})", Factory.Production);
  private static final IConstructor prod__integer_Number__Integer_ = (IConstructor) _read("prod(label(\"integer\",sort(\"Number\")),[lex(\"Integer\")],{})", Factory.Production);
  private static final IConstructor prod__lit___35_95__char_class___range__35_35_char_class___range__95_95_ = (IConstructor) _read("prod(lit(\"#_\"),[\\char-class([range(35,35)]),\\char-class([range(95,95)])],{})", Factory.Production);
  private static final IConstructor prod__start__File__layouts_Standard_top_File_layouts_Standard_ = (IConstructor) _read("prod(start(sort(\"File\")),[layouts(\"Standard\"),label(\"top\",sort(\"File\")),layouts(\"Standard\")],{})", Factory.Production);
  private static final IConstructor prod__lit___35_94__char_class___range__35_35_char_class___range__94_94_ = (IConstructor) _read("prod(lit(\"#^\"),[\\char-class([range(35,35)]),\\char-class([range(94,94)])],{})", Factory.Production);
  private static final IConstructor prod__discard_Form__lit___35_95_layouts_Standard_Form_ = (IConstructor) _read("prod(label(\"discard\",sort(\"Form\")),[lit(\"#_\"),layouts(\"Standard\"),sort(\"Form\")],{})", Factory.Production);
  private static final IConstructor regular__opt__char_class___range__45_45 = (IConstructor) _read("regular(opt(\\char-class([range(45,45)])))", Factory.Production);
  private static final IConstructor prod__Stem__seq___conditional__char_class___range__33_33_range__38_38_range__42_43_range__45_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_ = (IConstructor) _read("prod(lex(\"Stem\"),[seq([conditional(\\char-class([range(33,33),range(38,38),range(42,43),range(45,46),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]),{\\not-precede(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))}),conditional(\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),{\\not-follow(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))})])],{})", Factory.Production);
  private static final IConstructor prod__deref_Form__lit___64_layouts_Standard_Form_ = (IConstructor) _read("prod(label(\"deref\",sort(\"Form\")),[lit(\"@\"),layouts(\"Standard\"),sort(\"Form\")],{})", Factory.Production);
  private static final IConstructor prod__vector_Form__lit___91_layouts_Standard_iter_star_seps__Form__layouts_Standard_layouts_Standard_lit___93_ = (IConstructor) _read("prod(label(\"vector\",sort(\"Form\")),[lit(\"[\"),layouts(\"Standard\"),\\iter-star-seps(sort(\"Form\"),[layouts(\"Standard\")]),layouts(\"Standard\"),lit(\"]\")],{})", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_56 = (IConstructor) _read("regular(iter(\\char-class([range(48,56)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_55 = (IConstructor) _read("regular(iter(\\char-class([range(48,55)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_54 = (IConstructor) _read("regular(iter(\\char-class([range(48,54)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_53 = (IConstructor) _read("regular(iter(\\char-class([range(48,53)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_52 = (IConstructor) _read("regular(iter(\\char-class([range(48,52)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_51 = (IConstructor) _read("regular(iter(\\char-class([range(48,51)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_50 = (IConstructor) _read("regular(iter(\\char-class([range(48,50)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_49 = (IConstructor) _read("regular(iter(\\char-class([range(48,49)])))", Factory.Production);
  private static final IConstructor regular__iter__char_class___range__48_57 = (IConstructor) _read("regular(iter(\\char-class([range(48,57)])))", Factory.Production);
  private static final IConstructor prod__IntBase__char_class___range__56_56_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_55__not_follow__char_class___range__48_55_ = (IConstructor) _read("prod(lex(\"IntBase\"),[\\char-class([range(56,56)]),\\char-class([range(114,114)]),opt(\\char-class([range(45,45)])),conditional(iter(\\char-class([range(48,55)])),{\\not-follow(\\char-class([range(48,55)]))})],{})", Factory.Production);
  private static final IConstructor prod__IntBase__char_class___range__57_57_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_56__not_follow__char_class___range__48_56_ = (IConstructor) _read("prod(lex(\"IntBase\"),[\\char-class([range(57,57)]),\\char-class([range(114,114)]),opt(\\char-class([range(45,45)])),conditional(iter(\\char-class([range(48,56)])),{\\not-follow(\\char-class([range(48,56)]))})],{})", Factory.Production);
  private static final IConstructor prod__IntBase__char_class___range__55_55_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_54__not_follow__char_class___range__48_54_ = (IConstructor) _read("prod(lex(\"IntBase\"),[\\char-class([range(55,55)]),\\char-class([range(114,114)]),opt(\\char-class([range(45,45)])),conditional(iter(\\char-class([range(48,54)])),{\\not-follow(\\char-class([range(48,54)]))})],{})", Factory.Production);
  private static final IConstructor prod__IntBase__char_class___range__54_54_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_53__not_follow__char_class___range__48_53_ = (IConstructor) _read("prod(lex(\"IntBase\"),[\\char-class([range(54,54)]),\\char-class([range(114,114)]),opt(\\char-class([range(45,45)])),conditional(iter(\\char-class([range(48,53)])),{\\not-follow(\\char-class([range(48,53)]))})],{})", Factory.Production);
  private static final IConstructor prod__IntBase__char_class___range__53_53_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_52__not_follow__char_class___range__48_52_ = (IConstructor) _read("prod(lex(\"IntBase\"),[\\char-class([range(53,53)]),\\char-class([range(114,114)]),opt(\\char-class([range(45,45)])),conditional(iter(\\char-class([range(48,52)])),{\\not-follow(\\char-class([range(48,52)]))})],{})", Factory.Production);
  private static final IConstructor prod__IntBase__char_class___range__52_52_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_51__not_follow__char_class___range__48_51_ = (IConstructor) _read("prod(lex(\"IntBase\"),[\\char-class([range(52,52)]),\\char-class([range(114,114)]),opt(\\char-class([range(45,45)])),conditional(iter(\\char-class([range(48,51)])),{\\not-follow(\\char-class([range(48,51)]))})],{})", Factory.Production);
  private static final IConstructor prod__IntBase__char_class___range__51_51_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_50__not_follow__char_class___range__48_50_ = (IConstructor) _read("prod(lex(\"IntBase\"),[\\char-class([range(51,51)]),\\char-class([range(114,114)]),opt(\\char-class([range(45,45)])),conditional(iter(\\char-class([range(48,50)])),{\\not-follow(\\char-class([range(48,50)]))})],{})", Factory.Production);
  private static final IConstructor prod__IntBase__char_class___range__50_50_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_49__not_follow__char_class___range__48_49_ = (IConstructor) _read("prod(lex(\"IntBase\"),[\\char-class([range(50,50)]),\\char-class([range(114,114)]),opt(\\char-class([range(45,45)])),conditional(iter(\\char-class([range(48,49)])),{\\not-follow(\\char-class([range(48,49)]))})],{})", Factory.Production);
  private static final IConstructor prod__number_Form__Number_ = (IConstructor) _read("prod(label(\"number\",sort(\"Form\")),[sort(\"Number\")],{})", Factory.Production);
  private static final IConstructor prod__lit_tab__char_class___range__116_116_char_class___range__97_97_char_class___range__98_98_ = (IConstructor) _read("prod(lit(\"tab\"),[\\char-class([range(116,116)]),\\char-class([range(97,97)]),\\char-class([range(98,98)])],{})", Factory.Production);
  private static final IConstructor prod__map_Form__lit___123_layouts_Standard_iter_star_seps__Form__layouts_Standard_layouts_Standard_lit___125_ = (IConstructor) _read("prod(label(\"map\",sort(\"Form\")),[lit(\"{\"),layouts(\"Standard\"),\\iter-star-seps(sort(\"Form\"),[layouts(\"Standard\")]),layouts(\"Standard\"),lit(\"}\")],{})", Factory.Production);
  private static final IConstructor prod__intbase_Number__IntBase_ = (IConstructor) _read("prod(label(\"intbase\",sort(\"Number\")),[lex(\"IntBase\")],{})", Factory.Production);
  private static final IConstructor prod__unquote_Form__conditional__lit___126__not_follow__char_class___range__64_64_layouts_Standard_arg_Form_ = (IConstructor) _read("prod(label(\"unquote\",sort(\"Form\")),[conditional(lit(\"~\"),{\\not-follow(\\char-class([range(64,64)]))}),layouts(\"Standard\"),label(\"arg\",sort(\"Form\"))],{})", Factory.Production);
  private static final IConstructor prod__Arg__char_class___range__37_37_char_class___range__49_57_conditional__iter_star__char_class___range__48_57__not_follow__char_class___range__48_57_ = (IConstructor) _read("prod(lex(\"Arg\"),[\\char-class([range(37,37)]),\\char-class([range(49,57)]),conditional(\\iter-star(\\char-class([range(48,57)])),{\\not-follow(\\char-class([range(48,57)]))})],{})", Factory.Production);
  private static final IConstructor prod__Symbol__Ident_ = (IConstructor) _read("prod(lex(\"Symbol\"),[lex(\"Ident\")],{})", Factory.Production);
  private static final IConstructor prod__symbol_Form__Symbol_ = (IConstructor) _read("prod(label(\"symbol\",sort(\"Form\")),[lex(\"Symbol\")],{})", Factory.Production);
  private static final IConstructor regular__iter_star__char_class___range__9_10_range__13_13_range__32_32 = (IConstructor) _read("regular(\\iter-star(\\char-class([range(9,10),range(13,13),range(32,32)])))", Factory.Production);
  private static final IConstructor prod__layouts_Standard__conditional__iter_star__WhitespaceOrComment__not_follow__char_class___range__9_10_range__12_13_range__32_32_range__44_44_not_follow__lit___59_ = (IConstructor) _read("prod(layouts(\"Standard\"),[conditional(\\iter-star(sort(\"WhitespaceOrComment\")),{\\not-follow(\\char-class([range(9,10),range(12,13),range(32,32),range(44,44)])),\\not-follow(lit(\";\"))})],{})", Factory.Production);
  private static final IConstructor prod__Float__opt__char_class___range__45_45_iter__char_class___range__48_57_char_class___range__46_46_iter__char_class___range__48_57_ = (IConstructor) _read("prod(lex(\"Float\"),[opt(\\char-class([range(45,45)])),iter(\\char-class([range(48,57)])),\\char-class([range(46,46)]),iter(\\char-class([range(48,57)]))],{})", Factory.Production);
  private static final IConstructor prod__Char__char_class___range__92_92_lit_tab_ = (IConstructor) _read("prod(lex(\"Char\"),[\\char-class([range(92,92)]),lit(\"tab\")],{})", Factory.Production);
  private static final IConstructor regular__seq___conditional__char_class___range__33_33_range__38_38_range__42_43_range__45_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124 = (IConstructor) _read("regular(seq([conditional(\\char-class([range(33,33),range(38,38),range(42,43),range(45,46),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]),{\\not-precede(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))}),conditional(\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),{\\not-follow(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))})]))", Factory.Production);
  private static final IConstructor regular__iter_star__alt___seq___char_class___range__92_92_char_class___range__34_34_range__40_43_range__46_46_range__63_63_range__83_83_range__87_87_range__91_93_range__100_100_range__115_115_range__119_119_char_class___range__0_33_range__35_91_range__93_16777215 = (IConstructor) _read("regular(\\iter-star(alt({seq([\\char-class([range(92,92)]),\\char-class([range(34,34),range(40,43),range(46,46),range(63,63),range(83,83),range(87,87),range(91,93),range(100,100),range(115,115),range(119,119)])]),\\char-class([range(0,33),range(35,91),range(93,16777215)])})))", Factory.Production);
  private static final IConstructor prod__Ident__opt__lit___58_conditional__iter_seps__Stem__lit___58__not_follow__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_ = (IConstructor) _read("prod(lex(\"Ident\"),[opt(lit(\":\")),conditional(\\iter-seps(lex(\"Stem\"),[lit(\":\")]),{\\not-follow(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))})],{})", Factory.Production);
  private static final IConstructor prod__string_Form__String_ = (IConstructor) _read("prod(label(\"string\",sort(\"Form\")),[lex(\"String\")],{})", Factory.Production);
  private static final IConstructor prod__lit_space__char_class___range__115_115_char_class___range__112_112_char_class___range__97_97_char_class___range__99_99_char_class___range__101_101_ = (IConstructor) _read("prod(lit(\"space\"),[\\char-class([range(115,115)]),\\char-class([range(112,112)]),\\char-class([range(97,97)]),\\char-class([range(99,99)]),\\char-class([range(101,101)])],{})", Factory.Production);
  private static final IConstructor prod__var_Form__lit___35_39_layouts_Standard_Form_ = (IConstructor) _read("prod(label(\"var\",sort(\"Form\")),[lit(\"#\\'\\\\\"),layouts(\"Standard\"),sort(\"Form\")],{})", Factory.Production);
  private static final IConstructor prod__Comment__lit___59_conditional__iter_star__char_class___range__0_9_range__11_12_range__14_16777215__end_of_line__tag__category___67_111_109_109_101_110_116 = (IConstructor) _read("prod(lex(\"Comment\"),[lit(\";\"),conditional(\\iter-star(\\char-class([range(0,9),range(11,12),range(14,16777215)])),{\\end-of-line()})],{tag(category(\"Comment\"))})", Factory.Production);
  private static final IConstructor prod__whitespace_WhitespaceOrComment__Whitespace_ = (IConstructor) _read("prod(label(\"whitespace\",sort(\"WhitespaceOrComment\")),[lex(\"Whitespace\")],{})", Factory.Production);
  private static final IConstructor prod__char_Form__Char_ = (IConstructor) _read("prod(label(\"char\",sort(\"Form\")),[lex(\"Char\")],{})", Factory.Production);
  private static final IConstructor regular__iter_star__char_class___range__0_9_range__11_12_range__14_16777215 = (IConstructor) _read("regular(\\iter-star(\\char-class([range(0,9),range(11,12),range(14,16777215)])))", Factory.Production);
  private static final IConstructor prod__Arg__conditional__char_class___range__37_37__not_follow__char_class___range__38_38_range__49_57_ = (IConstructor) _read("prod(lex(\"Arg\"),[conditional(\\char-class([range(37,37)]),{\\not-follow(\\char-class([range(38,38),range(49,57)]))})],{})", Factory.Production);
  private static final IConstructor prod__regexp_Form__RegExp_ = (IConstructor) _read("prod(label(\"regexp\",sort(\"Form\")),[lex(\"RegExp\")],{})", Factory.Production);
  private static final IConstructor prod__Symbol__conditional__lit___47__not_follow__char_class___range__33_33_range__38_38_range__42_43_range__45_46_range__58_58_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_ = (IConstructor) _read("prod(lex(\"Symbol\"),[conditional(lit(\"/\"),{\\not-follow(\\char-class([range(33,33),range(38,38),range(42,43),range(45,46),range(58,58),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])),\\not-precede(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)]))})],{})", Factory.Production);
  private static final IConstructor regular__iter_seps__Stem__lit___58 = (IConstructor) _read("regular(\\iter-seps(lex(\"Stem\"),[lit(\":\")]))", Factory.Production);
  private static final IConstructor prod__lit___59__char_class___range__59_59_ = (IConstructor) _read("prod(lit(\";\"),[\\char-class([range(59,59)])],{})", Factory.Production);
  private static final IConstructor prod__lit___58__char_class___range__58_58_ = (IConstructor) _read("prod(lit(\":\"),[\\char-class([range(58,58)])],{})", Factory.Production);
  private static final IConstructor prod__IntBase__char_class___range__49_49_char_class___range__57_57_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_73_range__97_105__not_follow__char_class___range__48_57_range__65_73_range__97_105_ = (IConstructor) _read("prod(lex(\"IntBase\"),[\\char-class([range(49,49)]),\\char-class([range(57,57)]),\\char-class([range(114,114)]),opt(\\char-class([range(45,45)])),conditional(iter(\\char-class([range(48,57),range(65,73),range(97,105)])),{\\not-follow(\\char-class([range(48,57),range(65,73),range(97,105)]))})],{})", Factory.Production);
  private static final IConstructor prod__IntBase__char_class___range__49_49_char_class___range__56_56_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_72_range__97_104__not_follow__char_class___range__48_57_range__65_72_range__97_104_ = (IConstructor) _read("prod(lex(\"IntBase\"),[\\char-class([range(49,49)]),\\char-class([range(56,56)]),\\char-class([range(114,114)]),opt(\\char-class([range(45,45)])),conditional(iter(\\char-class([range(48,57),range(65,72),range(97,104)])),{\\not-follow(\\char-class([range(48,57),range(65,72),range(97,104)]))})],{})", Factory.Production);
  private static final IConstructor prod__IntBase__char_class___range__50_50_char_class___range__57_57_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_83_range__97_115__not_follow__char_class___range__48_57_range__65_83_range__97_115_ = (IConstructor) _read("prod(lex(\"IntBase\"),[\\char-class([range(50,50)]),\\char-class([range(57,57)]),\\char-class([range(114,114)]),opt(\\char-class([range(45,45)])),conditional(iter(\\char-class([range(48,57),range(65,83),range(97,115)])),{\\not-follow(\\char-class([range(48,57),range(65,83),range(97,115)]))})],{})", Factory.Production);
  private static final IConstructor prod__IntBase__char_class___range__50_50_char_class___range__56_56_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_82_range__97_114__not_follow__char_class___range__48_57_range__65_82_range__97_114_ = (IConstructor) _read("prod(lex(\"IntBase\"),[\\char-class([range(50,50)]),\\char-class([range(56,56)]),\\char-class([range(114,114)]),opt(\\char-class([range(45,45)])),conditional(iter(\\char-class([range(48,57),range(65,82),range(97,114)])),{\\not-follow(\\char-class([range(48,57),range(65,82),range(97,114)]))})],{})", Factory.Production);
  private static final IConstructor prod__Arg__char_class___range__37_37_char_class___range__38_38_ = (IConstructor) _read("prod(lex(\"Arg\"),[\\char-class([range(37,37)]),\\char-class([range(38,38)])],{})", Factory.Production);
  private static final IConstructor prod__IntBase__char_class___range__49_49_char_class___range__49_49_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_65_range__97_97__not_follow__char_class___range__48_57_range__65_65_range__97_97_ = (IConstructor) _read("prod(lex(\"IntBase\"),[\\char-class([range(49,49)]),\\char-class([range(49,49)]),\\char-class([range(114,114)]),opt(\\char-class([range(45,45)])),conditional(iter(\\char-class([range(48,57),range(65,65),range(97,97)])),{\\not-follow(\\char-class([range(48,57),range(65,65),range(97,97)]))})],{})", Factory.Production);
  private static final IConstructor prod__IntBase__char_class___range__49_49_char_class___range__50_50_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_66_range__97_98__not_follow__char_class___range__48_57_range__65_66_range__97_98_ = (IConstructor) _read("prod(lex(\"IntBase\"),[\\char-class([range(49,49)]),\\char-class([range(50,50)]),\\char-class([range(114,114)]),opt(\\char-class([range(45,45)])),conditional(iter(\\char-class([range(48,57),range(65,66),range(97,98)])),{\\not-follow(\\char-class([range(48,57),range(65,66),range(97,98)]))})],{})", Factory.Production);
  private static final IConstructor prod__IntBase__char_class___range__49_49_char_class___range__51_51_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_67_range__97_99__not_follow__char_class___range__48_57_range__65_67_range__97_99_ = (IConstructor) _read("prod(lex(\"IntBase\"),[\\char-class([range(49,49)]),\\char-class([range(51,51)]),\\char-class([range(114,114)]),opt(\\char-class([range(45,45)])),conditional(iter(\\char-class([range(48,57),range(65,67),range(97,99)])),{\\not-follow(\\char-class([range(48,57),range(65,67),range(97,99)]))})],{})", Factory.Production);
  private static final IConstructor prod__IntBase__char_class___range__50_50_char_class___range__52_52_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_78_range__97_110__not_follow__char_class___range__48_57_range__65_78_range__97_110_ = (IConstructor) _read("prod(lex(\"IntBase\"),[\\char-class([range(50,50)]),\\char-class([range(52,52)]),\\char-class([range(114,114)]),opt(\\char-class([range(45,45)])),conditional(iter(\\char-class([range(48,57),range(65,78),range(97,110)])),{\\not-follow(\\char-class([range(48,57),range(65,78),range(97,110)]))})],{})", Factory.Production);
  private static final IConstructor prod__IntBase__char_class___range__50_50_char_class___range__53_53_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_79_range__97_111__not_follow__char_class___range__48_57_range__65_79_range__97_111_ = (IConstructor) _read("prod(lex(\"IntBase\"),[\\char-class([range(50,50)]),\\char-class([range(53,53)]),\\char-class([range(114,114)]),opt(\\char-class([range(45,45)])),conditional(iter(\\char-class([range(48,57),range(65,79),range(97,111)])),{\\not-follow(\\char-class([range(48,57),range(65,79),range(97,111)]))})],{})", Factory.Production);
  private static final IConstructor prod__IntBase__char_class___range__50_50_char_class___range__54_54_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_80_range__97_112__not_follow__char_class___range__48_57_range__65_80_range__97_112_ = (IConstructor) _read("prod(lex(\"IntBase\"),[\\char-class([range(50,50)]),\\char-class([range(54,54)]),\\char-class([range(114,114)]),opt(\\char-class([range(45,45)])),conditional(iter(\\char-class([range(48,57),range(65,80),range(97,112)])),{\\not-follow(\\char-class([range(48,57),range(65,80),range(97,112)]))})],{})", Factory.Production);
  private static final IConstructor prod__IntBase__char_class___range__50_50_char_class___range__55_55_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_81_range__97_113__not_follow__char_class___range__48_57_range__65_81_range__97_113_ = (IConstructor) _read("prod(lex(\"IntBase\"),[\\char-class([range(50,50)]),\\char-class([range(55,55)]),\\char-class([range(114,114)]),opt(\\char-class([range(45,45)])),conditional(iter(\\char-class([range(48,57),range(65,81),range(97,113)])),{\\not-follow(\\char-class([range(48,57),range(65,81),range(97,113)]))})],{})", Factory.Production);
  private static final IConstructor prod__IntBase__char_class___range__51_51_char_class___range__52_52_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_88_range__97_120__not_follow__char_class___range__48_57_range__65_88_range__97_120_ = (IConstructor) _read("prod(lex(\"IntBase\"),[\\char-class([range(51,51)]),\\char-class([range(52,52)]),\\char-class([range(114,114)]),opt(\\char-class([range(45,45)])),conditional(iter(\\char-class([range(48,57),range(65,88),range(97,120)])),{\\not-follow(\\char-class([range(48,57),range(65,88),range(97,120)]))})],{})", Factory.Production);
  private static final IConstructor prod__IntBase__char_class___range__51_51_char_class___range__53_53_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_89_range__97_121__not_follow__char_class___range__48_57_range__65_89_range__97_121_ = (IConstructor) _read("prod(lex(\"IntBase\"),[\\char-class([range(51,51)]),\\char-class([range(53,53)]),\\char-class([range(114,114)]),opt(\\char-class([range(45,45)])),conditional(iter(\\char-class([range(48,57),range(65,89),range(97,121)])),{\\not-follow(\\char-class([range(48,57),range(65,89),range(97,121)]))})],{})", Factory.Production);
  private static final IConstructor prod__IntBase__char_class___range__51_51_char_class___range__54_54_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_90_range__97_122__not_follow__char_class___range__48_57_range__65_90_range__97_122_ = (IConstructor) _read("prod(lex(\"IntBase\"),[\\char-class([range(51,51)]),\\char-class([range(54,54)]),\\char-class([range(114,114)]),opt(\\char-class([range(45,45)])),conditional(iter(\\char-class([range(48,57),range(65,90),range(97,122)])),{\\not-follow(\\char-class([range(48,57),range(65,90),range(97,122)]))})],{})", Factory.Production);
  private static final IConstructor prod__Integer__opt__char_class___range__45_45_char_class___range__48_57_conditional__iter_star__char_class___range__48_57__not_follow__char_class___range__48_57_ = (IConstructor) _read("prod(lex(\"Integer\"),[opt(\\char-class([range(45,45)])),\\char-class([range(48,57)]),conditional(\\iter-star(\\char-class([range(48,57)])),{\\not-follow(\\char-class([range(48,57)]))})],{})", Factory.Production);
  private static final IConstructor prod__IntBase__char_class___range__49_49_char_class___range__52_52_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_68_range__97_100__not_follow__char_class___range__48_57_range__65_68_range__97_100_ = (IConstructor) _read("prod(lex(\"IntBase\"),[\\char-class([range(49,49)]),\\char-class([range(52,52)]),\\char-class([range(114,114)]),opt(\\char-class([range(45,45)])),conditional(iter(\\char-class([range(48,57),range(65,68),range(97,100)])),{\\not-follow(\\char-class([range(48,57),range(65,68),range(97,100)]))})],{})", Factory.Production);
  private static final IConstructor prod__IntBase__char_class___range__49_49_char_class___range__53_53_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_69_range__97_101__not_follow__char_class___range__48_57_range__65_69_range__97_101_ = (IConstructor) _read("prod(lex(\"IntBase\"),[\\char-class([range(49,49)]),\\char-class([range(53,53)]),\\char-class([range(114,114)]),opt(\\char-class([range(45,45)])),conditional(iter(\\char-class([range(48,57),range(65,69),range(97,101)])),{\\not-follow(\\char-class([range(48,57),range(65,69),range(97,101)]))})],{})", Factory.Production);
  private static final IConstructor prod__IntBase__char_class___range__49_49_char_class___range__54_54_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_70_range__97_102__not_follow__char_class___range__48_57_range__65_70_range__97_102_ = (IConstructor) _read("prod(lex(\"IntBase\"),[\\char-class([range(49,49)]),\\char-class([range(54,54)]),\\char-class([range(114,114)]),opt(\\char-class([range(45,45)])),conditional(iter(\\char-class([range(48,57),range(65,70),range(97,102)])),{\\not-follow(\\char-class([range(48,57),range(65,70),range(97,102)]))})],{})", Factory.Production);
  private static final IConstructor prod__IntBase__char_class___range__49_49_char_class___range__55_55_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_71_range__97_103__not_follow__char_class___range__48_57_range__65_71_range__97_103_ = (IConstructor) _read("prod(lex(\"IntBase\"),[\\char-class([range(49,49)]),\\char-class([range(55,55)]),\\char-class([range(114,114)]),opt(\\char-class([range(45,45)])),conditional(iter(\\char-class([range(48,57),range(65,71),range(97,103)])),{\\not-follow(\\char-class([range(48,57),range(65,71),range(97,103)]))})],{})", Factory.Production);
  private static final IConstructor prod__IntBase__char_class___range__50_50_char_class___range__48_48_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_74_range__97_106__not_follow__char_class___range__48_57_range__65_74_range__97_106_ = (IConstructor) _read("prod(lex(\"IntBase\"),[\\char-class([range(50,50)]),\\char-class([range(48,48)]),\\char-class([range(114,114)]),opt(\\char-class([range(45,45)])),conditional(iter(\\char-class([range(48,57),range(65,74),range(97,106)])),{\\not-follow(\\char-class([range(48,57),range(65,74),range(97,106)]))})],{})", Factory.Production);
  private static final IConstructor prod__IntBase__char_class___range__50_50_char_class___range__49_49_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_75_range__97_107__not_follow__char_class___range__48_57_range__65_75_range__97_107_ = (IConstructor) _read("prod(lex(\"IntBase\"),[\\char-class([range(50,50)]),\\char-class([range(49,49)]),\\char-class([range(114,114)]),opt(\\char-class([range(45,45)])),conditional(iter(\\char-class([range(48,57),range(65,75),range(97,107)])),{\\not-follow(\\char-class([range(48,57),range(65,75),range(97,107)]))})],{})", Factory.Production);
  private static final IConstructor prod__IntBase__char_class___range__50_50_char_class___range__50_50_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_76_range__97_108__not_follow__char_class___range__48_57_range__65_76_range__97_108_ = (IConstructor) _read("prod(lex(\"IntBase\"),[\\char-class([range(50,50)]),\\char-class([range(50,50)]),\\char-class([range(114,114)]),opt(\\char-class([range(45,45)])),conditional(iter(\\char-class([range(48,57),range(65,76),range(97,108)])),{\\not-follow(\\char-class([range(48,57),range(65,76),range(97,108)]))})],{})", Factory.Production);
  private static final IConstructor prod__IntBase__char_class___range__50_50_char_class___range__51_51_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_77_range__97_109__not_follow__char_class___range__48_57_range__65_77_range__97_109_ = (IConstructor) _read("prod(lex(\"IntBase\"),[\\char-class([range(50,50)]),\\char-class([range(51,51)]),\\char-class([range(114,114)]),opt(\\char-class([range(45,45)])),conditional(iter(\\char-class([range(48,57),range(65,77),range(97,109)])),{\\not-follow(\\char-class([range(48,57),range(65,77),range(97,109)]))})],{})", Factory.Production);
  private static final IConstructor prod__IntBase__char_class___range__51_51_char_class___range__48_48_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_84_range__97_116__not_follow__char_class___range__48_57_range__65_84_range__97_116_ = (IConstructor) _read("prod(lex(\"IntBase\"),[\\char-class([range(51,51)]),\\char-class([range(48,48)]),\\char-class([range(114,114)]),opt(\\char-class([range(45,45)])),conditional(iter(\\char-class([range(48,57),range(65,84),range(97,116)])),{\\not-follow(\\char-class([range(48,57),range(65,84),range(97,116)]))})],{})", Factory.Production);
  private static final IConstructor prod__IntBase__char_class___range__51_51_char_class___range__49_49_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_85_range__97_117__not_follow__char_class___range__48_57_range__65_85_range__97_117_ = (IConstructor) _read("prod(lex(\"IntBase\"),[\\char-class([range(51,51)]),\\char-class([range(49,49)]),\\char-class([range(114,114)]),opt(\\char-class([range(45,45)])),conditional(iter(\\char-class([range(48,57),range(65,85),range(97,117)])),{\\not-follow(\\char-class([range(48,57),range(65,85),range(97,117)]))})],{})", Factory.Production);
  private static final IConstructor prod__IntBase__char_class___range__51_51_char_class___range__50_50_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_86_range__97_118__not_follow__char_class___range__48_57_range__65_86_range__97_118_ = (IConstructor) _read("prod(lex(\"IntBase\"),[\\char-class([range(51,51)]),\\char-class([range(50,50)]),\\char-class([range(114,114)]),opt(\\char-class([range(45,45)])),conditional(iter(\\char-class([range(48,57),range(65,86),range(97,118)])),{\\not-follow(\\char-class([range(48,57),range(65,86),range(97,118)]))})],{})", Factory.Production);
  private static final IConstructor prod__IntBase__char_class___range__51_51_char_class___range__51_51_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_87_range__97_119__not_follow__char_class___range__48_57_range__65_87_range__97_119_ = (IConstructor) _read("prod(lex(\"IntBase\"),[\\char-class([range(51,51)]),\\char-class([range(51,51)]),\\char-class([range(114,114)]),opt(\\char-class([range(45,45)])),conditional(iter(\\char-class([range(48,57),range(65,87),range(97,119)])),{\\not-follow(\\char-class([range(48,57),range(65,87),range(97,119)]))})],{})", Factory.Production);
  private static final IConstructor prod__empty__ = (IConstructor) _read("prod(empty(),[],{})", Factory.Production);
  private static final IConstructor regular__iter_star__alt___seq___char_class___range__92_92_char_class___range__34_34_range__92_92_range__98_98_range__102_102_range__110_110_range__114_114_range__116_116_char_class___range__0_33_range__35_91_range__93_16777215 = (IConstructor) _read("regular(\\iter-star(alt({seq([\\char-class([range(92,92)]),\\char-class([range(34,34),range(92,92),range(98,98),range(102,102),range(110,110),range(114,114),range(116,116)])]),\\char-class([range(0,33),range(35,91),range(93,16777215)])})))", Factory.Production);
  private static final IConstructor prod__lit___41__char_class___range__41_41_ = (IConstructor) _read("prod(lit(\")\"),[\\char-class([range(41,41)])],{})", Factory.Production);
  private static final IConstructor prod__lit___40__char_class___range__40_40_ = (IConstructor) _read("prod(lit(\"(\"),[\\char-class([range(40,40)])],{})", Factory.Production);
  private static final IConstructor prod__File__iter_star_seps__Form__layouts_Standard_ = (IConstructor) _read("prod(sort(\"File\"),[\\iter-star-seps(sort(\"Form\"),[layouts(\"Standard\")])],{})", Factory.Production);
  private static final IConstructor prod__lit___47__char_class___range__47_47_ = (IConstructor) _read("prod(lit(\"/\"),[\\char-class([range(47,47)])],{})", Factory.Production);
  private static final IConstructor prod__list_Form__lit___40_layouts_Standard_iter_star_seps__Form__layouts_Standard_layouts_Standard_lit___41_ = (IConstructor) _read("prod(label(\"list\",sort(\"Form\")),[lit(\"(\"),layouts(\"Standard\"),\\iter-star-seps(sort(\"Form\"),[layouts(\"Standard\")]),layouts(\"Standard\"),lit(\")\")],{})", Factory.Production);
  private static final IConstructor prod__meta_Form__lit___94_layouts_Standard_meta_Form_layouts_Standard_arg_Form_ = (IConstructor) _read("prod(label(\"meta\",sort(\"Form\")),[lit(\"^\"),layouts(\"Standard\"),label(\"meta\",sort(\"Form\")),layouts(\"Standard\"),label(\"arg\",sort(\"Form\"))],{})", Factory.Production);
  private static final IConstructor prod__lit___39__char_class___range__39_39_ = (IConstructor) _read("prod(lit(\"\\'\\\\\"),[\\char-class([range(39,39)])],{})", Factory.Production);
  private static final IConstructor prod__arg_Form__Arg_ = (IConstructor) _read("prod(label(\"arg\",sort(\"Form\")),[lex(\"Arg\")],{})", Factory.Production);
  private static final IConstructor prod__lit___91__char_class___range__91_91_ = (IConstructor) _read("prod(lit(\"[\"),[\\char-class([range(91,91)])],{})", Factory.Production);
  private static final IConstructor regular__alt___seq___char_class___range__92_92_char_class___range__34_34_range__40_43_range__46_46_range__63_63_range__83_83_range__87_87_range__91_93_range__100_100_range__115_115_range__119_119_char_class___range__0_33_range__35_91_range__93_16777215 = (IConstructor) _read("regular(alt({seq([\\char-class([range(92,92)]),\\char-class([range(34,34),range(40,43),range(46,46),range(63,63),range(83,83),range(87,87),range(91,93),range(100,100),range(115,115),range(119,119)])]),\\char-class([range(0,33),range(35,91),range(93,16777215)])}))", Factory.Production);
  private static final IConstructor prod__lit___94__char_class___range__94_94_ = (IConstructor) _read("prod(lit(\"^\"),[\\char-class([range(94,94)])],{})", Factory.Production);
  private static final IConstructor prod__bigdecimal_Number__BigDecimal_ = (IConstructor) _read("prod(label(\"bigdecimal\",sort(\"Number\")),[lex(\"BigDecimal\")],{})", Factory.Production);
  private static final IConstructor prod__fn_Form__lit___35_40_layouts_Standard_iter_star_seps__Form__layouts_Standard_layouts_Standard_lit___41_ = (IConstructor) _read("prod(label(\"fn\",sort(\"Form\")),[lit(\"#(\"),layouts(\"Standard\"),\\iter-star-seps(sort(\"Form\"),[layouts(\"Standard\")]),layouts(\"Standard\"),lit(\")\")],{})", Factory.Production);
  private static final IConstructor prod__lit___93__char_class___range__93_93_ = (IConstructor) _read("prod(lit(\"]\"),[\\char-class([range(93,93)])],{})", Factory.Production);
  private static final IConstructor prod__lit___35_39__char_class___range__35_35_char_class___range__39_39_ = (IConstructor) _read("prod(lit(\"#\\'\\\\\"),[\\char-class([range(35,35)]),\\char-class([range(39,39)])],{})", Factory.Production);
  private static final IConstructor prod__lit___35_40__char_class___range__35_35_char_class___range__40_40_ = (IConstructor) _read("prod(lit(\"#(\"),[\\char-class([range(35,35)]),\\char-class([range(40,40)])],{})", Factory.Production);
  private static final IConstructor prod__Whitespace__char_class___range__9_10_range__12_13_range__32_32_range__44_44_ = (IConstructor) _read("prod(lex(\"Whitespace\"),[\\char-class([range(9,10),range(12,13),range(32,32),range(44,44)])],{})", Factory.Production);
  private static final IConstructor prod__Char__char_class___range__92_92_lit_newline_ = (IConstructor) _read("prod(lex(\"Char\"),[\\char-class([range(92,92)]),lit(\"newline\")],{})", Factory.Production);
  private static final IConstructor regular__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124 = (IConstructor) _read("regular(\\iter-star(\\char-class([range(33,33),range(35,36),range(38,38),range(42,43),range(45,46),range(48,57),range(60,63),range(65,90),range(95,95),range(97,122),range(124,124)])))", Factory.Production);
  private static final IConstructor regular__iter_star_seps__Form__layouts_Standard = (IConstructor) _read("regular(\\iter-star-seps(sort(\"Form\"),[layouts(\"Standard\")]))", Factory.Production);
  private static final IConstructor prod__Form__lit___35_94_layouts_Standard_Symbol_ = (IConstructor) _read("prod(sort(\"Form\"),[lit(\"#^\"),layouts(\"Standard\"),lex(\"Symbol\")],{})", Factory.Production);
  private static final IConstructor prod__lit___64__char_class___range__64_64_ = (IConstructor) _read("prod(lit(\"@\"),[\\char-class([range(64,64)])],{})", Factory.Production);
  private static final IConstructor regular__seq___char_class___range__92_92_char_class___range__34_34_range__40_43_range__46_46_range__63_63_range__83_83_range__87_87_range__91_93_range__100_100_range__115_115_range__119_119 = (IConstructor) _read("regular(seq([\\char-class([range(92,92)]),\\char-class([range(34,34),range(40,43),range(46,46),range(63,63),range(83,83),range(87,87),range(91,93),range(100,100),range(115,115),range(119,119)])]))", Factory.Production);
  private static final IConstructor prod__lit___123__char_class___range__123_123_ = (IConstructor) _read("prod(lit(\"{\"),[\\char-class([range(123,123)])],{})", Factory.Production);
  private static final IConstructor prod__lit___126__char_class___range__126_126_ = (IConstructor) _read("prod(lit(\"~\"),[\\char-class([range(126,126)])],{})", Factory.Production);
  private static final IConstructor prod__lit___125__char_class___range__125_125_ = (IConstructor) _read("prod(lit(\"}\"),[\\char-class([range(125,125)])],{})", Factory.Production);
  private static final IConstructor regular__alt___seq___char_class___range__92_92_char_class___range__34_34_range__92_92_range__98_98_range__102_102_range__110_110_range__114_114_range__116_116_char_class___range__0_33_range__35_91_range__93_16777215 = (IConstructor) _read("regular(alt({seq([\\char-class([range(92,92)]),\\char-class([range(34,34),range(92,92),range(98,98),range(102,102),range(110,110),range(114,114),range(116,116)])]),\\char-class([range(0,33),range(35,91),range(93,16777215)])}))", Factory.Production);
  private static final IConstructor prod__Symbol__lit___58_58_Ident_ = (IConstructor) _read("prod(lex(\"Symbol\"),[lit(\"::\"),lex(\"Ident\")],{})", Factory.Production);
  private static final IConstructor prod__Char__char_class___range__92_92_char_class___range__0_8_range__11_12_range__14_31_range__33_16777215_ = (IConstructor) _read("prod(lex(\"Char\"),[\\char-class([range(92,92)]),\\char-class([range(0,8),range(11,12),range(14,31),range(33,16777215)])],{})", Factory.Production);
  private static final IConstructor prod__lit___58_58__char_class___range__58_58_char_class___range__58_58_ = (IConstructor) _read("prod(lit(\"::\"),[\\char-class([range(58,58)]),\\char-class([range(58,58)])],{})", Factory.Production);
  private static final IConstructor regular__iter_star__WhitespaceOrComment = (IConstructor) _read("regular(\\iter-star(sort(\"WhitespaceOrComment\")))", Factory.Production);
  private static final IConstructor prod__quote_Form__lit___39_layouts_Standard_arg_Form_ = (IConstructor) _read("prod(label(\"quote\",sort(\"Form\")),[lit(\"\\'\\\\\"),layouts(\"Standard\"),label(\"arg\",sort(\"Form\"))],{})", Factory.Production);
  private static final IConstructor regular__seq___char_class___range__92_92_char_class___range__34_34_range__92_92_range__98_98_range__102_102_range__110_110_range__114_114_range__116_116 = (IConstructor) _read("regular(seq([\\char-class([range(92,92)]),\\char-class([range(34,34),range(92,92),range(98,98),range(102,102),range(110,110),range(114,114),range(116,116)])]))", Factory.Production);
  private static final IConstructor prod__lit___96__char_class___range__96_96_ = (IConstructor) _read("prod(lit(\"`\"),[\\char-class([range(96,96)])],{})", Factory.Production);
  private static final IConstructor regular__opt__lit___58 = (IConstructor) _read("regular(opt(lit(\":\")))", Factory.Production);
  private static final IConstructor prod__layouts_$QUOTES__conditional__iter_star__char_class___range__9_10_range__13_13_range__32_32__not_follow__char_class___range__9_10_range__13_13_range__32_32_ = (IConstructor) _read("prod(layouts(\"$QUOTES\"),[conditional(\\iter-star(\\char-class([range(9,10),range(13,13),range(32,32)])),{\\not-follow(\\char-class([range(9,10),range(13,13),range(32,32)]))})],{})", Factory.Production);
  private static final IConstructor prod__IntBase__char_class___range__49_49_char_class___range__48_48_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57_ = (IConstructor) _read("prod(lex(\"IntBase\"),[\\char-class([range(49,49)]),\\char-class([range(48,48)]),\\char-class([range(114,114)]),opt(\\char-class([range(45,45)])),conditional(iter(\\char-class([range(48,57)])),{\\not-follow(\\char-class([range(48,57)]))})],{})", Factory.Production);
    
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
      
      tmp[0] = new ListStackNode(6, 0, regular__iter_star__WhitespaceOrComment, new NonTerminalStackNode(8, 0, "WhitespaceOrComment", null, null), false, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{9,10},{12,13},{32,32},{44,44}}), new StringFollowRestriction(new int[] {59})});
      builder.addAlternative(ClojureParser.prod__layouts_Standard__conditional__iter_star__WhitespaceOrComment__not_follow__char_class___range__9_10_range__12_13_range__32_32_range__44_44_not_follow__lit___59_, tmp);
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
    
    protected static final void _init_prod__Ratio__Integer_lit___47_char_class___range__49_57_conditional__iter_star__char_class___range__48_57__not_follow__char_class___range__48_57_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[4];
      
      tmp[3] = new ListStackNode(16, 3, regular__iter_star__char_class___range__48_57, new CharStackNode(18, 0, new int[][]{{48,57}}, null, null), false, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57}})});
      tmp[2] = new CharStackNode(14, 2, new int[][]{{49,57}}, null, null);
      tmp[1] = new LiteralStackNode(12, 1, prod__lit___47__char_class___range__47_47_, new int[] {47}, null, null);
      tmp[0] = new NonTerminalStackNode(10, 0, "Integer", null, null);
      builder.addAlternative(ClojureParser.prod__Ratio__Integer_lit___47_char_class___range__49_57_conditional__iter_star__char_class___range__48_57__not_follow__char_class___range__48_57_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__Ratio__Integer_lit___47_char_class___range__49_57_conditional__iter_star__char_class___range__48_57__not_follow__char_class___range__48_57_(builder);
      
    }
  }
	
  protected static class Stem {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__Stem__seq___conditional__char_class___range__33_33_range__38_38_range__42_43_range__45_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new SequenceStackNode(28, 0, regular__seq___conditional__char_class___range__33_33_range__38_38_range__42_43_range__45_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124, new AbstractStackNode[]{new CharStackNode(30, 0, new int[][]{{33,33},{38,38},{42,43},{45,46},{60,63},{65,90},{95,95},{97,122},{124,124}}, new IEnterFilter[] {new CharPrecedeRestriction(new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}})}, null), new ListStackNode(32, 1, regular__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124, new CharStackNode(34, 0, new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}}, null, null), false, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}})})}, null, null);
      builder.addAlternative(ClojureParser.prod__Stem__seq___conditional__char_class___range__33_33_range__38_38_range__42_43_range__45_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__Stem__seq___conditional__char_class___range__33_33_range__38_38_range__42_43_range__45_46_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_conditional__iter_star__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124__not_follow__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_(builder);
      
    }
  }
	
  protected static class start__File {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__start__File__layouts_Standard_top_File_layouts_Standard_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new NonTerminalStackNode(44, 2, "layouts_Standard", null, null);
      tmp[1] = new NonTerminalStackNode(42, 1, "File", null, null);
      tmp[0] = new NonTerminalStackNode(40, 0, "layouts_Standard", null, null);
      builder.addAlternative(ClojureParser.prod__start__File__layouts_Standard_top_File_layouts_Standard_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__start__File__layouts_Standard_top_File_layouts_Standard_(builder);
      
    }
  }
	
  protected static class Char {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__Char__char_class___range__92_92_lit_tab_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[2];
      
      tmp[1] = new LiteralStackNode(58, 1, prod__lit_tab__char_class___range__116_116_char_class___range__97_97_char_class___range__98_98_, new int[] {116,97,98}, null, null);
      tmp[0] = new CharStackNode(56, 0, new int[][]{{92,92}}, null, null);
      builder.addAlternative(ClojureParser.prod__Char__char_class___range__92_92_lit_tab_, tmp);
	}
    protected static final void _init_prod__Char__char_class___range__92_92_lit_newline_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[2];
      
      tmp[1] = new LiteralStackNode(62, 1, prod__lit_newline__char_class___range__110_110_char_class___range__101_101_char_class___range__119_119_char_class___range__108_108_char_class___range__105_105_char_class___range__110_110_char_class___range__101_101_, new int[] {110,101,119,108,105,110,101}, null, null);
      tmp[0] = new CharStackNode(60, 0, new int[][]{{92,92}}, null, null);
      builder.addAlternative(ClojureParser.prod__Char__char_class___range__92_92_lit_newline_, tmp);
	}
    protected static final void _init_prod__Char__char_class___range__92_92_char_class___range__0_8_range__11_12_range__14_31_range__33_16777215_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[2];
      
      tmp[1] = new CharStackNode(66, 1, new int[][]{{0,8},{11,12},{14,31},{33,16777215}}, null, null);
      tmp[0] = new CharStackNode(64, 0, new int[][]{{92,92}}, null, null);
      builder.addAlternative(ClojureParser.prod__Char__char_class___range__92_92_char_class___range__0_8_range__11_12_range__14_31_range__33_16777215_, tmp);
	}
    protected static final void _init_prod__Char__char_class___range__92_92_lit_space_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[2];
      
      tmp[1] = new LiteralStackNode(70, 1, prod__lit_space__char_class___range__115_115_char_class___range__112_112_char_class___range__97_97_char_class___range__99_99_char_class___range__101_101_, new int[] {115,112,97,99,101}, null, null);
      tmp[0] = new CharStackNode(68, 0, new int[][]{{92,92}}, null, null);
      builder.addAlternative(ClojureParser.prod__Char__char_class___range__92_92_lit_space_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__Char__char_class___range__92_92_lit_tab_(builder);
      
        _init_prod__Char__char_class___range__92_92_lit_newline_(builder);
      
        _init_prod__Char__char_class___range__92_92_char_class___range__0_8_range__11_12_range__14_31_range__33_16777215_(builder);
      
        _init_prod__Char__char_class___range__92_92_lit_space_(builder);
      
    }
  }
	
  protected static class File {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__File__iter_star_seps__Form__layouts_Standard_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new SeparatedListStackNode(72, 0, regular__iter_star_seps__Form__layouts_Standard, new NonTerminalStackNode(74, 0, "Form", null, null), new AbstractStackNode[]{new NonTerminalStackNode(76, 1, "layouts_Standard", null, null)}, false, null, null);
      builder.addAlternative(ClojureParser.prod__File__iter_star_seps__Form__layouts_Standard_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__File__iter_star_seps__Form__layouts_Standard_(builder);
      
    }
  }
	
  protected static class IntBase {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__IntBase__char_class___range__57_57_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_56__not_follow__char_class___range__48_56_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[4];
      
      tmp[3] = new ListStackNode(102, 3, regular__iter__char_class___range__48_56, new CharStackNode(104, 0, new int[][]{{48,56}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,56}})});
      tmp[2] = new OptionalStackNode(98, 2, regular__opt__char_class___range__45_45, new CharStackNode(100, 0, new int[][]{{45,45}}, null, null), null, null);
      tmp[1] = new CharStackNode(96, 1, new int[][]{{114,114}}, null, null);
      tmp[0] = new CharStackNode(94, 0, new int[][]{{57,57}}, null, null);
      builder.addAlternative(ClojureParser.prod__IntBase__char_class___range__57_57_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_56__not_follow__char_class___range__48_56_, tmp);
	}
    protected static final void _init_prod__IntBase__char_class___range__56_56_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_55__not_follow__char_class___range__48_55_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[4];
      
      tmp[3] = new ListStackNode(114, 3, regular__iter__char_class___range__48_55, new CharStackNode(116, 0, new int[][]{{48,55}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,55}})});
      tmp[2] = new OptionalStackNode(110, 2, regular__opt__char_class___range__45_45, new CharStackNode(112, 0, new int[][]{{45,45}}, null, null), null, null);
      tmp[1] = new CharStackNode(108, 1, new int[][]{{114,114}}, null, null);
      tmp[0] = new CharStackNode(106, 0, new int[][]{{56,56}}, null, null);
      builder.addAlternative(ClojureParser.prod__IntBase__char_class___range__56_56_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_55__not_follow__char_class___range__48_55_, tmp);
	}
    protected static final void _init_prod__IntBase__char_class___range__55_55_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_54__not_follow__char_class___range__48_54_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[4];
      
      tmp[3] = new ListStackNode(126, 3, regular__iter__char_class___range__48_54, new CharStackNode(128, 0, new int[][]{{48,54}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,54}})});
      tmp[2] = new OptionalStackNode(122, 2, regular__opt__char_class___range__45_45, new CharStackNode(124, 0, new int[][]{{45,45}}, null, null), null, null);
      tmp[1] = new CharStackNode(120, 1, new int[][]{{114,114}}, null, null);
      tmp[0] = new CharStackNode(118, 0, new int[][]{{55,55}}, null, null);
      builder.addAlternative(ClojureParser.prod__IntBase__char_class___range__55_55_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_54__not_follow__char_class___range__48_54_, tmp);
	}
    protected static final void _init_prod__IntBase__char_class___range__54_54_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_53__not_follow__char_class___range__48_53_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[4];
      
      tmp[3] = new ListStackNode(138, 3, regular__iter__char_class___range__48_53, new CharStackNode(140, 0, new int[][]{{48,53}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,53}})});
      tmp[2] = new OptionalStackNode(134, 2, regular__opt__char_class___range__45_45, new CharStackNode(136, 0, new int[][]{{45,45}}, null, null), null, null);
      tmp[1] = new CharStackNode(132, 1, new int[][]{{114,114}}, null, null);
      tmp[0] = new CharStackNode(130, 0, new int[][]{{54,54}}, null, null);
      builder.addAlternative(ClojureParser.prod__IntBase__char_class___range__54_54_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_53__not_follow__char_class___range__48_53_, tmp);
	}
    protected static final void _init_prod__IntBase__char_class___range__53_53_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_52__not_follow__char_class___range__48_52_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[4];
      
      tmp[3] = new ListStackNode(150, 3, regular__iter__char_class___range__48_52, new CharStackNode(152, 0, new int[][]{{48,52}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,52}})});
      tmp[2] = new OptionalStackNode(146, 2, regular__opt__char_class___range__45_45, new CharStackNode(148, 0, new int[][]{{45,45}}, null, null), null, null);
      tmp[1] = new CharStackNode(144, 1, new int[][]{{114,114}}, null, null);
      tmp[0] = new CharStackNode(142, 0, new int[][]{{53,53}}, null, null);
      builder.addAlternative(ClojureParser.prod__IntBase__char_class___range__53_53_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_52__not_follow__char_class___range__48_52_, tmp);
	}
    protected static final void _init_prod__IntBase__char_class___range__52_52_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_51__not_follow__char_class___range__48_51_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[4];
      
      tmp[3] = new ListStackNode(162, 3, regular__iter__char_class___range__48_51, new CharStackNode(164, 0, new int[][]{{48,51}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,51}})});
      tmp[2] = new OptionalStackNode(158, 2, regular__opt__char_class___range__45_45, new CharStackNode(160, 0, new int[][]{{45,45}}, null, null), null, null);
      tmp[1] = new CharStackNode(156, 1, new int[][]{{114,114}}, null, null);
      tmp[0] = new CharStackNode(154, 0, new int[][]{{52,52}}, null, null);
      builder.addAlternative(ClojureParser.prod__IntBase__char_class___range__52_52_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_51__not_follow__char_class___range__48_51_, tmp);
	}
    protected static final void _init_prod__IntBase__char_class___range__51_51_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_50__not_follow__char_class___range__48_50_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[4];
      
      tmp[3] = new ListStackNode(174, 3, regular__iter__char_class___range__48_50, new CharStackNode(176, 0, new int[][]{{48,50}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,50}})});
      tmp[2] = new OptionalStackNode(170, 2, regular__opt__char_class___range__45_45, new CharStackNode(172, 0, new int[][]{{45,45}}, null, null), null, null);
      tmp[1] = new CharStackNode(168, 1, new int[][]{{114,114}}, null, null);
      tmp[0] = new CharStackNode(166, 0, new int[][]{{51,51}}, null, null);
      builder.addAlternative(ClojureParser.prod__IntBase__char_class___range__51_51_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_50__not_follow__char_class___range__48_50_, tmp);
	}
    protected static final void _init_prod__IntBase__char_class___range__50_50_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_49__not_follow__char_class___range__48_49_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[4];
      
      tmp[3] = new ListStackNode(186, 3, regular__iter__char_class___range__48_49, new CharStackNode(188, 0, new int[][]{{48,49}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,49}})});
      tmp[2] = new OptionalStackNode(182, 2, regular__opt__char_class___range__45_45, new CharStackNode(184, 0, new int[][]{{45,45}}, null, null), null, null);
      tmp[1] = new CharStackNode(180, 1, new int[][]{{114,114}}, null, null);
      tmp[0] = new CharStackNode(178, 0, new int[][]{{50,50}}, null, null);
      builder.addAlternative(ClojureParser.prod__IntBase__char_class___range__50_50_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_49__not_follow__char_class___range__48_49_, tmp);
	}
    protected static final void _init_prod__IntBase__char_class___range__49_49_char_class___range__57_57_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_73_range__97_105__not_follow__char_class___range__48_57_range__65_73_range__97_105_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new ListStackNode(200, 4, regular__iter__char_class___range__48_57_range__65_73_range__97_105, new CharStackNode(202, 0, new int[][]{{48,57},{65,73},{97,105}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57},{65,73},{97,105}})});
      tmp[3] = new OptionalStackNode(196, 3, regular__opt__char_class___range__45_45, new CharStackNode(198, 0, new int[][]{{45,45}}, null, null), null, null);
      tmp[2] = new CharStackNode(194, 2, new int[][]{{114,114}}, null, null);
      tmp[1] = new CharStackNode(192, 1, new int[][]{{57,57}}, null, null);
      tmp[0] = new CharStackNode(190, 0, new int[][]{{49,49}}, null, null);
      builder.addAlternative(ClojureParser.prod__IntBase__char_class___range__49_49_char_class___range__57_57_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_73_range__97_105__not_follow__char_class___range__48_57_range__65_73_range__97_105_, tmp);
	}
    protected static final void _init_prod__IntBase__char_class___range__49_49_char_class___range__56_56_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_72_range__97_104__not_follow__char_class___range__48_57_range__65_72_range__97_104_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new ListStackNode(214, 4, regular__iter__char_class___range__48_57_range__65_72_range__97_104, new CharStackNode(216, 0, new int[][]{{48,57},{65,72},{97,104}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57},{65,72},{97,104}})});
      tmp[3] = new OptionalStackNode(210, 3, regular__opt__char_class___range__45_45, new CharStackNode(212, 0, new int[][]{{45,45}}, null, null), null, null);
      tmp[2] = new CharStackNode(208, 2, new int[][]{{114,114}}, null, null);
      tmp[1] = new CharStackNode(206, 1, new int[][]{{56,56}}, null, null);
      tmp[0] = new CharStackNode(204, 0, new int[][]{{49,49}}, null, null);
      builder.addAlternative(ClojureParser.prod__IntBase__char_class___range__49_49_char_class___range__56_56_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_72_range__97_104__not_follow__char_class___range__48_57_range__65_72_range__97_104_, tmp);
	}
    protected static final void _init_prod__IntBase__char_class___range__50_50_char_class___range__57_57_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_83_range__97_115__not_follow__char_class___range__48_57_range__65_83_range__97_115_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new ListStackNode(228, 4, regular__iter__char_class___range__48_57_range__65_83_range__97_115, new CharStackNode(230, 0, new int[][]{{48,57},{65,83},{97,115}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57},{65,83},{97,115}})});
      tmp[3] = new OptionalStackNode(224, 3, regular__opt__char_class___range__45_45, new CharStackNode(226, 0, new int[][]{{45,45}}, null, null), null, null);
      tmp[2] = new CharStackNode(222, 2, new int[][]{{114,114}}, null, null);
      tmp[1] = new CharStackNode(220, 1, new int[][]{{57,57}}, null, null);
      tmp[0] = new CharStackNode(218, 0, new int[][]{{50,50}}, null, null);
      builder.addAlternative(ClojureParser.prod__IntBase__char_class___range__50_50_char_class___range__57_57_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_83_range__97_115__not_follow__char_class___range__48_57_range__65_83_range__97_115_, tmp);
	}
    protected static final void _init_prod__IntBase__char_class___range__50_50_char_class___range__56_56_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_82_range__97_114__not_follow__char_class___range__48_57_range__65_82_range__97_114_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new ListStackNode(242, 4, regular__iter__char_class___range__48_57_range__65_82_range__97_114, new CharStackNode(244, 0, new int[][]{{48,57},{65,82},{97,114}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57},{65,82},{97,114}})});
      tmp[3] = new OptionalStackNode(238, 3, regular__opt__char_class___range__45_45, new CharStackNode(240, 0, new int[][]{{45,45}}, null, null), null, null);
      tmp[2] = new CharStackNode(236, 2, new int[][]{{114,114}}, null, null);
      tmp[1] = new CharStackNode(234, 1, new int[][]{{56,56}}, null, null);
      tmp[0] = new CharStackNode(232, 0, new int[][]{{50,50}}, null, null);
      builder.addAlternative(ClojureParser.prod__IntBase__char_class___range__50_50_char_class___range__56_56_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_82_range__97_114__not_follow__char_class___range__48_57_range__65_82_range__97_114_, tmp);
	}
    protected static final void _init_prod__IntBase__char_class___range__51_51_char_class___range__54_54_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_90_range__97_122__not_follow__char_class___range__48_57_range__65_90_range__97_122_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new ListStackNode(256, 4, regular__iter__char_class___range__48_57_range__65_90_range__97_122, new CharStackNode(258, 0, new int[][]{{48,57},{65,90},{97,122}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57},{65,90},{97,122}})});
      tmp[3] = new OptionalStackNode(252, 3, regular__opt__char_class___range__45_45, new CharStackNode(254, 0, new int[][]{{45,45}}, null, null), null, null);
      tmp[2] = new CharStackNode(250, 2, new int[][]{{114,114}}, null, null);
      tmp[1] = new CharStackNode(248, 1, new int[][]{{54,54}}, null, null);
      tmp[0] = new CharStackNode(246, 0, new int[][]{{51,51}}, null, null);
      builder.addAlternative(ClojureParser.prod__IntBase__char_class___range__51_51_char_class___range__54_54_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_90_range__97_122__not_follow__char_class___range__48_57_range__65_90_range__97_122_, tmp);
	}
    protected static final void _init_prod__IntBase__char_class___range__51_51_char_class___range__53_53_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_89_range__97_121__not_follow__char_class___range__48_57_range__65_89_range__97_121_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new ListStackNode(270, 4, regular__iter__char_class___range__48_57_range__65_89_range__97_121, new CharStackNode(272, 0, new int[][]{{48,57},{65,89},{97,121}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57},{65,89},{97,121}})});
      tmp[3] = new OptionalStackNode(266, 3, regular__opt__char_class___range__45_45, new CharStackNode(268, 0, new int[][]{{45,45}}, null, null), null, null);
      tmp[2] = new CharStackNode(264, 2, new int[][]{{114,114}}, null, null);
      tmp[1] = new CharStackNode(262, 1, new int[][]{{53,53}}, null, null);
      tmp[0] = new CharStackNode(260, 0, new int[][]{{51,51}}, null, null);
      builder.addAlternative(ClojureParser.prod__IntBase__char_class___range__51_51_char_class___range__53_53_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_89_range__97_121__not_follow__char_class___range__48_57_range__65_89_range__97_121_, tmp);
	}
    protected static final void _init_prod__IntBase__char_class___range__51_51_char_class___range__52_52_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_88_range__97_120__not_follow__char_class___range__48_57_range__65_88_range__97_120_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new ListStackNode(284, 4, regular__iter__char_class___range__48_57_range__65_88_range__97_120, new CharStackNode(286, 0, new int[][]{{48,57},{65,88},{97,120}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57},{65,88},{97,120}})});
      tmp[3] = new OptionalStackNode(280, 3, regular__opt__char_class___range__45_45, new CharStackNode(282, 0, new int[][]{{45,45}}, null, null), null, null);
      tmp[2] = new CharStackNode(278, 2, new int[][]{{114,114}}, null, null);
      tmp[1] = new CharStackNode(276, 1, new int[][]{{52,52}}, null, null);
      tmp[0] = new CharStackNode(274, 0, new int[][]{{51,51}}, null, null);
      builder.addAlternative(ClojureParser.prod__IntBase__char_class___range__51_51_char_class___range__52_52_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_88_range__97_120__not_follow__char_class___range__48_57_range__65_88_range__97_120_, tmp);
	}
    protected static final void _init_prod__IntBase__char_class___range__50_50_char_class___range__55_55_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_81_range__97_113__not_follow__char_class___range__48_57_range__65_81_range__97_113_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new ListStackNode(298, 4, regular__iter__char_class___range__48_57_range__65_81_range__97_113, new CharStackNode(300, 0, new int[][]{{48,57},{65,81},{97,113}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57},{65,81},{97,113}})});
      tmp[3] = new OptionalStackNode(294, 3, regular__opt__char_class___range__45_45, new CharStackNode(296, 0, new int[][]{{45,45}}, null, null), null, null);
      tmp[2] = new CharStackNode(292, 2, new int[][]{{114,114}}, null, null);
      tmp[1] = new CharStackNode(290, 1, new int[][]{{55,55}}, null, null);
      tmp[0] = new CharStackNode(288, 0, new int[][]{{50,50}}, null, null);
      builder.addAlternative(ClojureParser.prod__IntBase__char_class___range__50_50_char_class___range__55_55_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_81_range__97_113__not_follow__char_class___range__48_57_range__65_81_range__97_113_, tmp);
	}
    protected static final void _init_prod__IntBase__char_class___range__50_50_char_class___range__54_54_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_80_range__97_112__not_follow__char_class___range__48_57_range__65_80_range__97_112_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new ListStackNode(312, 4, regular__iter__char_class___range__48_57_range__65_80_range__97_112, new CharStackNode(314, 0, new int[][]{{48,57},{65,80},{97,112}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57},{65,80},{97,112}})});
      tmp[3] = new OptionalStackNode(308, 3, regular__opt__char_class___range__45_45, new CharStackNode(310, 0, new int[][]{{45,45}}, null, null), null, null);
      tmp[2] = new CharStackNode(306, 2, new int[][]{{114,114}}, null, null);
      tmp[1] = new CharStackNode(304, 1, new int[][]{{54,54}}, null, null);
      tmp[0] = new CharStackNode(302, 0, new int[][]{{50,50}}, null, null);
      builder.addAlternative(ClojureParser.prod__IntBase__char_class___range__50_50_char_class___range__54_54_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_80_range__97_112__not_follow__char_class___range__48_57_range__65_80_range__97_112_, tmp);
	}
    protected static final void _init_prod__IntBase__char_class___range__50_50_char_class___range__53_53_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_79_range__97_111__not_follow__char_class___range__48_57_range__65_79_range__97_111_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new ListStackNode(326, 4, regular__iter__char_class___range__48_57_range__65_79_range__97_111, new CharStackNode(328, 0, new int[][]{{48,57},{65,79},{97,111}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57},{65,79},{97,111}})});
      tmp[3] = new OptionalStackNode(322, 3, regular__opt__char_class___range__45_45, new CharStackNode(324, 0, new int[][]{{45,45}}, null, null), null, null);
      tmp[2] = new CharStackNode(320, 2, new int[][]{{114,114}}, null, null);
      tmp[1] = new CharStackNode(318, 1, new int[][]{{53,53}}, null, null);
      tmp[0] = new CharStackNode(316, 0, new int[][]{{50,50}}, null, null);
      builder.addAlternative(ClojureParser.prod__IntBase__char_class___range__50_50_char_class___range__53_53_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_79_range__97_111__not_follow__char_class___range__48_57_range__65_79_range__97_111_, tmp);
	}
    protected static final void _init_prod__IntBase__char_class___range__50_50_char_class___range__52_52_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_78_range__97_110__not_follow__char_class___range__48_57_range__65_78_range__97_110_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new ListStackNode(340, 4, regular__iter__char_class___range__48_57_range__65_78_range__97_110, new CharStackNode(342, 0, new int[][]{{48,57},{65,78},{97,110}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57},{65,78},{97,110}})});
      tmp[3] = new OptionalStackNode(336, 3, regular__opt__char_class___range__45_45, new CharStackNode(338, 0, new int[][]{{45,45}}, null, null), null, null);
      tmp[2] = new CharStackNode(334, 2, new int[][]{{114,114}}, null, null);
      tmp[1] = new CharStackNode(332, 1, new int[][]{{52,52}}, null, null);
      tmp[0] = new CharStackNode(330, 0, new int[][]{{50,50}}, null, null);
      builder.addAlternative(ClojureParser.prod__IntBase__char_class___range__50_50_char_class___range__52_52_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_78_range__97_110__not_follow__char_class___range__48_57_range__65_78_range__97_110_, tmp);
	}
    protected static final void _init_prod__IntBase__char_class___range__49_49_char_class___range__51_51_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_67_range__97_99__not_follow__char_class___range__48_57_range__65_67_range__97_99_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new ListStackNode(354, 4, regular__iter__char_class___range__48_57_range__65_67_range__97_99, new CharStackNode(356, 0, new int[][]{{48,57},{65,67},{97,99}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57},{65,67},{97,99}})});
      tmp[3] = new OptionalStackNode(350, 3, regular__opt__char_class___range__45_45, new CharStackNode(352, 0, new int[][]{{45,45}}, null, null), null, null);
      tmp[2] = new CharStackNode(348, 2, new int[][]{{114,114}}, null, null);
      tmp[1] = new CharStackNode(346, 1, new int[][]{{51,51}}, null, null);
      tmp[0] = new CharStackNode(344, 0, new int[][]{{49,49}}, null, null);
      builder.addAlternative(ClojureParser.prod__IntBase__char_class___range__49_49_char_class___range__51_51_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_67_range__97_99__not_follow__char_class___range__48_57_range__65_67_range__97_99_, tmp);
	}
    protected static final void _init_prod__IntBase__char_class___range__49_49_char_class___range__50_50_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_66_range__97_98__not_follow__char_class___range__48_57_range__65_66_range__97_98_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new ListStackNode(368, 4, regular__iter__char_class___range__48_57_range__65_66_range__97_98, new CharStackNode(370, 0, new int[][]{{48,57},{65,66},{97,98}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57},{65,66},{97,98}})});
      tmp[3] = new OptionalStackNode(364, 3, regular__opt__char_class___range__45_45, new CharStackNode(366, 0, new int[][]{{45,45}}, null, null), null, null);
      tmp[2] = new CharStackNode(362, 2, new int[][]{{114,114}}, null, null);
      tmp[1] = new CharStackNode(360, 1, new int[][]{{50,50}}, null, null);
      tmp[0] = new CharStackNode(358, 0, new int[][]{{49,49}}, null, null);
      builder.addAlternative(ClojureParser.prod__IntBase__char_class___range__49_49_char_class___range__50_50_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_66_range__97_98__not_follow__char_class___range__48_57_range__65_66_range__97_98_, tmp);
	}
    protected static final void _init_prod__IntBase__char_class___range__49_49_char_class___range__49_49_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_65_range__97_97__not_follow__char_class___range__48_57_range__65_65_range__97_97_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new ListStackNode(382, 4, regular__iter__char_class___range__48_57_range__65_65_range__97_97, new CharStackNode(384, 0, new int[][]{{48,57},{65,65},{97,97}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57},{65,65},{97,97}})});
      tmp[3] = new OptionalStackNode(378, 3, regular__opt__char_class___range__45_45, new CharStackNode(380, 0, new int[][]{{45,45}}, null, null), null, null);
      tmp[2] = new CharStackNode(376, 2, new int[][]{{114,114}}, null, null);
      tmp[1] = new CharStackNode(374, 1, new int[][]{{49,49}}, null, null);
      tmp[0] = new CharStackNode(372, 0, new int[][]{{49,49}}, null, null);
      builder.addAlternative(ClojureParser.prod__IntBase__char_class___range__49_49_char_class___range__49_49_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_65_range__97_97__not_follow__char_class___range__48_57_range__65_65_range__97_97_, tmp);
	}
    protected static final void _init_prod__IntBase__char_class___range__51_51_char_class___range__51_51_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_87_range__97_119__not_follow__char_class___range__48_57_range__65_87_range__97_119_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new ListStackNode(396, 4, regular__iter__char_class___range__48_57_range__65_87_range__97_119, new CharStackNode(398, 0, new int[][]{{48,57},{65,87},{97,119}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57},{65,87},{97,119}})});
      tmp[3] = new OptionalStackNode(392, 3, regular__opt__char_class___range__45_45, new CharStackNode(394, 0, new int[][]{{45,45}}, null, null), null, null);
      tmp[2] = new CharStackNode(390, 2, new int[][]{{114,114}}, null, null);
      tmp[1] = new CharStackNode(388, 1, new int[][]{{51,51}}, null, null);
      tmp[0] = new CharStackNode(386, 0, new int[][]{{51,51}}, null, null);
      builder.addAlternative(ClojureParser.prod__IntBase__char_class___range__51_51_char_class___range__51_51_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_87_range__97_119__not_follow__char_class___range__48_57_range__65_87_range__97_119_, tmp);
	}
    protected static final void _init_prod__IntBase__char_class___range__51_51_char_class___range__50_50_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_86_range__97_118__not_follow__char_class___range__48_57_range__65_86_range__97_118_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new ListStackNode(410, 4, regular__iter__char_class___range__48_57_range__65_86_range__97_118, new CharStackNode(412, 0, new int[][]{{48,57},{65,86},{97,118}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57},{65,86},{97,118}})});
      tmp[3] = new OptionalStackNode(406, 3, regular__opt__char_class___range__45_45, new CharStackNode(408, 0, new int[][]{{45,45}}, null, null), null, null);
      tmp[2] = new CharStackNode(404, 2, new int[][]{{114,114}}, null, null);
      tmp[1] = new CharStackNode(402, 1, new int[][]{{50,50}}, null, null);
      tmp[0] = new CharStackNode(400, 0, new int[][]{{51,51}}, null, null);
      builder.addAlternative(ClojureParser.prod__IntBase__char_class___range__51_51_char_class___range__50_50_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_86_range__97_118__not_follow__char_class___range__48_57_range__65_86_range__97_118_, tmp);
	}
    protected static final void _init_prod__IntBase__char_class___range__51_51_char_class___range__49_49_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_85_range__97_117__not_follow__char_class___range__48_57_range__65_85_range__97_117_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new ListStackNode(424, 4, regular__iter__char_class___range__48_57_range__65_85_range__97_117, new CharStackNode(426, 0, new int[][]{{48,57},{65,85},{97,117}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57},{65,85},{97,117}})});
      tmp[3] = new OptionalStackNode(420, 3, regular__opt__char_class___range__45_45, new CharStackNode(422, 0, new int[][]{{45,45}}, null, null), null, null);
      tmp[2] = new CharStackNode(418, 2, new int[][]{{114,114}}, null, null);
      tmp[1] = new CharStackNode(416, 1, new int[][]{{49,49}}, null, null);
      tmp[0] = new CharStackNode(414, 0, new int[][]{{51,51}}, null, null);
      builder.addAlternative(ClojureParser.prod__IntBase__char_class___range__51_51_char_class___range__49_49_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_85_range__97_117__not_follow__char_class___range__48_57_range__65_85_range__97_117_, tmp);
	}
    protected static final void _init_prod__IntBase__char_class___range__51_51_char_class___range__48_48_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_84_range__97_116__not_follow__char_class___range__48_57_range__65_84_range__97_116_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new ListStackNode(438, 4, regular__iter__char_class___range__48_57_range__65_84_range__97_116, new CharStackNode(440, 0, new int[][]{{48,57},{65,84},{97,116}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57},{65,84},{97,116}})});
      tmp[3] = new OptionalStackNode(434, 3, regular__opt__char_class___range__45_45, new CharStackNode(436, 0, new int[][]{{45,45}}, null, null), null, null);
      tmp[2] = new CharStackNode(432, 2, new int[][]{{114,114}}, null, null);
      tmp[1] = new CharStackNode(430, 1, new int[][]{{48,48}}, null, null);
      tmp[0] = new CharStackNode(428, 0, new int[][]{{51,51}}, null, null);
      builder.addAlternative(ClojureParser.prod__IntBase__char_class___range__51_51_char_class___range__48_48_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_84_range__97_116__not_follow__char_class___range__48_57_range__65_84_range__97_116_, tmp);
	}
    protected static final void _init_prod__IntBase__char_class___range__50_50_char_class___range__51_51_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_77_range__97_109__not_follow__char_class___range__48_57_range__65_77_range__97_109_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new ListStackNode(452, 4, regular__iter__char_class___range__48_57_range__65_77_range__97_109, new CharStackNode(454, 0, new int[][]{{48,57},{65,77},{97,109}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57},{65,77},{97,109}})});
      tmp[3] = new OptionalStackNode(448, 3, regular__opt__char_class___range__45_45, new CharStackNode(450, 0, new int[][]{{45,45}}, null, null), null, null);
      tmp[2] = new CharStackNode(446, 2, new int[][]{{114,114}}, null, null);
      tmp[1] = new CharStackNode(444, 1, new int[][]{{51,51}}, null, null);
      tmp[0] = new CharStackNode(442, 0, new int[][]{{50,50}}, null, null);
      builder.addAlternative(ClojureParser.prod__IntBase__char_class___range__50_50_char_class___range__51_51_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_77_range__97_109__not_follow__char_class___range__48_57_range__65_77_range__97_109_, tmp);
	}
    protected static final void _init_prod__IntBase__char_class___range__50_50_char_class___range__50_50_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_76_range__97_108__not_follow__char_class___range__48_57_range__65_76_range__97_108_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new ListStackNode(466, 4, regular__iter__char_class___range__48_57_range__65_76_range__97_108, new CharStackNode(468, 0, new int[][]{{48,57},{65,76},{97,108}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57},{65,76},{97,108}})});
      tmp[3] = new OptionalStackNode(462, 3, regular__opt__char_class___range__45_45, new CharStackNode(464, 0, new int[][]{{45,45}}, null, null), null, null);
      tmp[2] = new CharStackNode(460, 2, new int[][]{{114,114}}, null, null);
      tmp[1] = new CharStackNode(458, 1, new int[][]{{50,50}}, null, null);
      tmp[0] = new CharStackNode(456, 0, new int[][]{{50,50}}, null, null);
      builder.addAlternative(ClojureParser.prod__IntBase__char_class___range__50_50_char_class___range__50_50_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_76_range__97_108__not_follow__char_class___range__48_57_range__65_76_range__97_108_, tmp);
	}
    protected static final void _init_prod__IntBase__char_class___range__50_50_char_class___range__49_49_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_75_range__97_107__not_follow__char_class___range__48_57_range__65_75_range__97_107_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new ListStackNode(480, 4, regular__iter__char_class___range__48_57_range__65_75_range__97_107, new CharStackNode(482, 0, new int[][]{{48,57},{65,75},{97,107}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57},{65,75},{97,107}})});
      tmp[3] = new OptionalStackNode(476, 3, regular__opt__char_class___range__45_45, new CharStackNode(478, 0, new int[][]{{45,45}}, null, null), null, null);
      tmp[2] = new CharStackNode(474, 2, new int[][]{{114,114}}, null, null);
      tmp[1] = new CharStackNode(472, 1, new int[][]{{49,49}}, null, null);
      tmp[0] = new CharStackNode(470, 0, new int[][]{{50,50}}, null, null);
      builder.addAlternative(ClojureParser.prod__IntBase__char_class___range__50_50_char_class___range__49_49_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_75_range__97_107__not_follow__char_class___range__48_57_range__65_75_range__97_107_, tmp);
	}
    protected static final void _init_prod__IntBase__char_class___range__50_50_char_class___range__48_48_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_74_range__97_106__not_follow__char_class___range__48_57_range__65_74_range__97_106_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new ListStackNode(494, 4, regular__iter__char_class___range__48_57_range__65_74_range__97_106, new CharStackNode(496, 0, new int[][]{{48,57},{65,74},{97,106}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57},{65,74},{97,106}})});
      tmp[3] = new OptionalStackNode(490, 3, regular__opt__char_class___range__45_45, new CharStackNode(492, 0, new int[][]{{45,45}}, null, null), null, null);
      tmp[2] = new CharStackNode(488, 2, new int[][]{{114,114}}, null, null);
      tmp[1] = new CharStackNode(486, 1, new int[][]{{48,48}}, null, null);
      tmp[0] = new CharStackNode(484, 0, new int[][]{{50,50}}, null, null);
      builder.addAlternative(ClojureParser.prod__IntBase__char_class___range__50_50_char_class___range__48_48_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_74_range__97_106__not_follow__char_class___range__48_57_range__65_74_range__97_106_, tmp);
	}
    protected static final void _init_prod__IntBase__char_class___range__49_49_char_class___range__55_55_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_71_range__97_103__not_follow__char_class___range__48_57_range__65_71_range__97_103_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new ListStackNode(508, 4, regular__iter__char_class___range__48_57_range__65_71_range__97_103, new CharStackNode(510, 0, new int[][]{{48,57},{65,71},{97,103}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57},{65,71},{97,103}})});
      tmp[3] = new OptionalStackNode(504, 3, regular__opt__char_class___range__45_45, new CharStackNode(506, 0, new int[][]{{45,45}}, null, null), null, null);
      tmp[2] = new CharStackNode(502, 2, new int[][]{{114,114}}, null, null);
      tmp[1] = new CharStackNode(500, 1, new int[][]{{55,55}}, null, null);
      tmp[0] = new CharStackNode(498, 0, new int[][]{{49,49}}, null, null);
      builder.addAlternative(ClojureParser.prod__IntBase__char_class___range__49_49_char_class___range__55_55_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_71_range__97_103__not_follow__char_class___range__48_57_range__65_71_range__97_103_, tmp);
	}
    protected static final void _init_prod__IntBase__char_class___range__49_49_char_class___range__54_54_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_70_range__97_102__not_follow__char_class___range__48_57_range__65_70_range__97_102_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new ListStackNode(522, 4, regular__iter__char_class___range__48_57_range__65_70_range__97_102, new CharStackNode(524, 0, new int[][]{{48,57},{65,70},{97,102}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57},{65,70},{97,102}})});
      tmp[3] = new OptionalStackNode(518, 3, regular__opt__char_class___range__45_45, new CharStackNode(520, 0, new int[][]{{45,45}}, null, null), null, null);
      tmp[2] = new CharStackNode(516, 2, new int[][]{{114,114}}, null, null);
      tmp[1] = new CharStackNode(514, 1, new int[][]{{54,54}}, null, null);
      tmp[0] = new CharStackNode(512, 0, new int[][]{{49,49}}, null, null);
      builder.addAlternative(ClojureParser.prod__IntBase__char_class___range__49_49_char_class___range__54_54_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_70_range__97_102__not_follow__char_class___range__48_57_range__65_70_range__97_102_, tmp);
	}
    protected static final void _init_prod__IntBase__char_class___range__49_49_char_class___range__53_53_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_69_range__97_101__not_follow__char_class___range__48_57_range__65_69_range__97_101_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new ListStackNode(536, 4, regular__iter__char_class___range__48_57_range__65_69_range__97_101, new CharStackNode(538, 0, new int[][]{{48,57},{65,69},{97,101}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57},{65,69},{97,101}})});
      tmp[3] = new OptionalStackNode(532, 3, regular__opt__char_class___range__45_45, new CharStackNode(534, 0, new int[][]{{45,45}}, null, null), null, null);
      tmp[2] = new CharStackNode(530, 2, new int[][]{{114,114}}, null, null);
      tmp[1] = new CharStackNode(528, 1, new int[][]{{53,53}}, null, null);
      tmp[0] = new CharStackNode(526, 0, new int[][]{{49,49}}, null, null);
      builder.addAlternative(ClojureParser.prod__IntBase__char_class___range__49_49_char_class___range__53_53_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_69_range__97_101__not_follow__char_class___range__48_57_range__65_69_range__97_101_, tmp);
	}
    protected static final void _init_prod__IntBase__char_class___range__49_49_char_class___range__52_52_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_68_range__97_100__not_follow__char_class___range__48_57_range__65_68_range__97_100_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new ListStackNode(550, 4, regular__iter__char_class___range__48_57_range__65_68_range__97_100, new CharStackNode(552, 0, new int[][]{{48,57},{65,68},{97,100}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57},{65,68},{97,100}})});
      tmp[3] = new OptionalStackNode(546, 3, regular__opt__char_class___range__45_45, new CharStackNode(548, 0, new int[][]{{45,45}}, null, null), null, null);
      tmp[2] = new CharStackNode(544, 2, new int[][]{{114,114}}, null, null);
      tmp[1] = new CharStackNode(542, 1, new int[][]{{52,52}}, null, null);
      tmp[0] = new CharStackNode(540, 0, new int[][]{{49,49}}, null, null);
      builder.addAlternative(ClojureParser.prod__IntBase__char_class___range__49_49_char_class___range__52_52_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_68_range__97_100__not_follow__char_class___range__48_57_range__65_68_range__97_100_, tmp);
	}
    protected static final void _init_prod__IntBase__char_class___range__49_49_char_class___range__48_48_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new ListStackNode(564, 4, regular__iter__char_class___range__48_57, new CharStackNode(566, 0, new int[][]{{48,57}}, null, null), true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57}})});
      tmp[3] = new OptionalStackNode(560, 3, regular__opt__char_class___range__45_45, new CharStackNode(562, 0, new int[][]{{45,45}}, null, null), null, null);
      tmp[2] = new CharStackNode(558, 2, new int[][]{{114,114}}, null, null);
      tmp[1] = new CharStackNode(556, 1, new int[][]{{48,48}}, null, null);
      tmp[0] = new CharStackNode(554, 0, new int[][]{{49,49}}, null, null);
      builder.addAlternative(ClojureParser.prod__IntBase__char_class___range__49_49_char_class___range__48_48_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__IntBase__char_class___range__57_57_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_56__not_follow__char_class___range__48_56_(builder);
      
        _init_prod__IntBase__char_class___range__56_56_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_55__not_follow__char_class___range__48_55_(builder);
      
        _init_prod__IntBase__char_class___range__55_55_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_54__not_follow__char_class___range__48_54_(builder);
      
        _init_prod__IntBase__char_class___range__54_54_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_53__not_follow__char_class___range__48_53_(builder);
      
        _init_prod__IntBase__char_class___range__53_53_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_52__not_follow__char_class___range__48_52_(builder);
      
        _init_prod__IntBase__char_class___range__52_52_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_51__not_follow__char_class___range__48_51_(builder);
      
        _init_prod__IntBase__char_class___range__51_51_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_50__not_follow__char_class___range__48_50_(builder);
      
        _init_prod__IntBase__char_class___range__50_50_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_49__not_follow__char_class___range__48_49_(builder);
      
        _init_prod__IntBase__char_class___range__49_49_char_class___range__57_57_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_73_range__97_105__not_follow__char_class___range__48_57_range__65_73_range__97_105_(builder);
      
        _init_prod__IntBase__char_class___range__49_49_char_class___range__56_56_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_72_range__97_104__not_follow__char_class___range__48_57_range__65_72_range__97_104_(builder);
      
        _init_prod__IntBase__char_class___range__50_50_char_class___range__57_57_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_83_range__97_115__not_follow__char_class___range__48_57_range__65_83_range__97_115_(builder);
      
        _init_prod__IntBase__char_class___range__50_50_char_class___range__56_56_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_82_range__97_114__not_follow__char_class___range__48_57_range__65_82_range__97_114_(builder);
      
        _init_prod__IntBase__char_class___range__51_51_char_class___range__54_54_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_90_range__97_122__not_follow__char_class___range__48_57_range__65_90_range__97_122_(builder);
      
        _init_prod__IntBase__char_class___range__51_51_char_class___range__53_53_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_89_range__97_121__not_follow__char_class___range__48_57_range__65_89_range__97_121_(builder);
      
        _init_prod__IntBase__char_class___range__51_51_char_class___range__52_52_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_88_range__97_120__not_follow__char_class___range__48_57_range__65_88_range__97_120_(builder);
      
        _init_prod__IntBase__char_class___range__50_50_char_class___range__55_55_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_81_range__97_113__not_follow__char_class___range__48_57_range__65_81_range__97_113_(builder);
      
        _init_prod__IntBase__char_class___range__50_50_char_class___range__54_54_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_80_range__97_112__not_follow__char_class___range__48_57_range__65_80_range__97_112_(builder);
      
        _init_prod__IntBase__char_class___range__50_50_char_class___range__53_53_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_79_range__97_111__not_follow__char_class___range__48_57_range__65_79_range__97_111_(builder);
      
        _init_prod__IntBase__char_class___range__50_50_char_class___range__52_52_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_78_range__97_110__not_follow__char_class___range__48_57_range__65_78_range__97_110_(builder);
      
        _init_prod__IntBase__char_class___range__49_49_char_class___range__51_51_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_67_range__97_99__not_follow__char_class___range__48_57_range__65_67_range__97_99_(builder);
      
        _init_prod__IntBase__char_class___range__49_49_char_class___range__50_50_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_66_range__97_98__not_follow__char_class___range__48_57_range__65_66_range__97_98_(builder);
      
        _init_prod__IntBase__char_class___range__49_49_char_class___range__49_49_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_65_range__97_97__not_follow__char_class___range__48_57_range__65_65_range__97_97_(builder);
      
        _init_prod__IntBase__char_class___range__51_51_char_class___range__51_51_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_87_range__97_119__not_follow__char_class___range__48_57_range__65_87_range__97_119_(builder);
      
        _init_prod__IntBase__char_class___range__51_51_char_class___range__50_50_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_86_range__97_118__not_follow__char_class___range__48_57_range__65_86_range__97_118_(builder);
      
        _init_prod__IntBase__char_class___range__51_51_char_class___range__49_49_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_85_range__97_117__not_follow__char_class___range__48_57_range__65_85_range__97_117_(builder);
      
        _init_prod__IntBase__char_class___range__51_51_char_class___range__48_48_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_84_range__97_116__not_follow__char_class___range__48_57_range__65_84_range__97_116_(builder);
      
        _init_prod__IntBase__char_class___range__50_50_char_class___range__51_51_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_77_range__97_109__not_follow__char_class___range__48_57_range__65_77_range__97_109_(builder);
      
        _init_prod__IntBase__char_class___range__50_50_char_class___range__50_50_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_76_range__97_108__not_follow__char_class___range__48_57_range__65_76_range__97_108_(builder);
      
        _init_prod__IntBase__char_class___range__50_50_char_class___range__49_49_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_75_range__97_107__not_follow__char_class___range__48_57_range__65_75_range__97_107_(builder);
      
        _init_prod__IntBase__char_class___range__50_50_char_class___range__48_48_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_74_range__97_106__not_follow__char_class___range__48_57_range__65_74_range__97_106_(builder);
      
        _init_prod__IntBase__char_class___range__49_49_char_class___range__55_55_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_71_range__97_103__not_follow__char_class___range__48_57_range__65_71_range__97_103_(builder);
      
        _init_prod__IntBase__char_class___range__49_49_char_class___range__54_54_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_70_range__97_102__not_follow__char_class___range__48_57_range__65_70_range__97_102_(builder);
      
        _init_prod__IntBase__char_class___range__49_49_char_class___range__53_53_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_69_range__97_101__not_follow__char_class___range__48_57_range__65_69_range__97_101_(builder);
      
        _init_prod__IntBase__char_class___range__49_49_char_class___range__52_52_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57_range__65_68_range__97_100__not_follow__char_class___range__48_57_range__65_68_range__97_100_(builder);
      
        _init_prod__IntBase__char_class___range__49_49_char_class___range__48_48_char_class___range__114_114_opt__char_class___range__45_45_conditional__iter__char_class___range__48_57__not_follow__char_class___range__48_57_(builder);
      
    }
  }
	
  protected static class Ident {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__Ident__opt__lit___58_conditional__iter_seps__Stem__lit___58__not_follow__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[2];
      
      tmp[1] = new SeparatedListStackNode(596, 1, regular__iter_seps__Stem__lit___58, new NonTerminalStackNode(598, 0, "Stem", null, null), new AbstractStackNode[]{new LiteralStackNode(600, 1, prod__lit___58__char_class___range__58_58_, new int[] {58}, null, null)}, true, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}})});
      tmp[0] = new OptionalStackNode(592, 0, regular__opt__lit___58, new LiteralStackNode(594, 0, prod__lit___58__char_class___range__58_58_, new int[] {58}, null, null), null, null);
      builder.addAlternative(ClojureParser.prod__Ident__opt__lit___58_conditional__iter_seps__Stem__lit___58__not_follow__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__Ident__opt__lit___58_conditional__iter_seps__Stem__lit___58__not_follow__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_(builder);
      
    }
  }
	
  protected static class BigDecimal {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__BigDecimal__Float_char_class___range__77_77_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[2];
      
      tmp[1] = new CharStackNode(622, 1, new int[][]{{77,77}}, null, null);
      tmp[0] = new NonTerminalStackNode(620, 0, "Float", null, null);
      builder.addAlternative(ClojureParser.prod__BigDecimal__Float_char_class___range__77_77_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__BigDecimal__Float_char_class___range__77_77_(builder);
      
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
      
      tmp[0] = new ListStackNode(634, 0, regular__iter_star__char_class___range__9_10_range__13_13_range__32_32, new CharStackNode(636, 0, new int[][]{{9,10},{13,13},{32,32}}, null, null), false, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{9,10},{13,13},{32,32}})});
      builder.addAlternative(ClojureParser.prod__layouts_$QUOTES__conditional__iter_star__char_class___range__9_10_range__13_13_range__32_32__not_follow__char_class___range__9_10_range__13_13_range__32_32_, tmp);
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
      
      tmp[1] = new ListStackNode(672, 1, regular__iter_star__char_class___range__0_9_range__11_12_range__14_16777215, new CharStackNode(674, 0, new int[][]{{0,9},{11,12},{14,16777215}}, null, null), false, null, new ICompletionFilter[] {new AtEndOfLineRequirement()});
      tmp[0] = new LiteralStackNode(670, 0, prod__lit___59__char_class___range__59_59_, new int[] {59}, null, null);
      builder.addAlternative(ClojureParser.prod__Comment__lit___59_conditional__iter_star__char_class___range__0_9_range__11_12_range__14_16777215__end_of_line__tag__category___67_111_109_109_101_110_116, tmp);
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
    
    protected static final void _init_prod__Float__opt__char_class___range__45_45_iter__char_class___range__48_57_char_class___range__46_46_iter__char_class___range__48_57_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[4];
      
      tmp[3] = new ListStackNode(686, 3, regular__iter__char_class___range__48_57, new CharStackNode(688, 0, new int[][]{{48,57}}, null, null), true, null, null);
      tmp[2] = new CharStackNode(684, 2, new int[][]{{46,46}}, null, null);
      tmp[1] = new ListStackNode(680, 1, regular__iter__char_class___range__48_57, new CharStackNode(682, 0, new int[][]{{48,57}}, null, null), true, null, null);
      tmp[0] = new OptionalStackNode(676, 0, regular__opt__char_class___range__45_45, new CharStackNode(678, 0, new int[][]{{45,45}}, null, null), null, null);
      builder.addAlternative(ClojureParser.prod__Float__opt__char_class___range__45_45_iter__char_class___range__48_57_char_class___range__46_46_iter__char_class___range__48_57_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__Float__opt__char_class___range__45_45_iter__char_class___range__48_57_char_class___range__46_46_iter__char_class___range__48_57_(builder);
      
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
      
      tmp[2] = new NonTerminalStackNode(706, 2, "Ident", null, null);
      tmp[1] = new LiteralStackNode(704, 1, prod__lit___47__char_class___range__47_47_, new int[] {47}, null, null);
      tmp[0] = new NonTerminalStackNode(702, 0, "Ident", null, null);
      builder.addAlternative(ClojureParser.prod__Symbol__Ident_lit___47_Ident_, tmp);
	}
    protected static final void _init_prod__Symbol__Ident_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(708, 0, "Ident", null, null);
      builder.addAlternative(ClojureParser.prod__Symbol__Ident_, tmp);
	}
    protected static final void _init_prod__Symbol__conditional__lit___47__not_follow__char_class___range__33_33_range__38_38_range__42_43_range__45_46_range__58_58_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new LiteralStackNode(710, 0, prod__lit___47__char_class___range__47_47_, new int[] {47}, new IEnterFilter[] {new CharPrecedeRestriction(new int[][]{{33,33},{35,36},{38,38},{42,43},{45,46},{48,57},{60,63},{65,90},{95,95},{97,122},{124,124}})}, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{33,33},{38,38},{42,43},{45,46},{58,58},{60,63},{65,90},{95,95},{97,122},{124,124}})});
      builder.addAlternative(ClojureParser.prod__Symbol__conditional__lit___47__not_follow__char_class___range__33_33_range__38_38_range__42_43_range__45_46_range__58_58_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_, tmp);
	}
    protected static final void _init_prod__Symbol__lit___58_58_Ident_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[2];
      
      tmp[1] = new NonTerminalStackNode(714, 1, "Ident", null, null);
      tmp[0] = new LiteralStackNode(712, 0, prod__lit___58_58__char_class___range__58_58_char_class___range__58_58_, new int[] {58,58}, null, null);
      builder.addAlternative(ClojureParser.prod__Symbol__lit___58_58_Ident_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__Symbol__Ident_lit___47_Ident_(builder);
      
        _init_prod__Symbol__Ident_(builder);
      
        _init_prod__Symbol__conditional__lit___47__not_follow__char_class___range__33_33_range__38_38_range__42_43_range__45_46_range__58_58_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_not_precede__char_class___range__33_33_range__35_36_range__38_38_range__42_43_range__45_46_range__48_57_range__60_63_range__65_90_range__95_95_range__97_122_range__124_124_(builder);
      
        _init_prod__Symbol__lit___58_58_Ident_(builder);
      
    }
  }
	
  protected static class Arg {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__Arg__char_class___range__37_37_char_class___range__49_57_conditional__iter_star__char_class___range__48_57__not_follow__char_class___range__48_57_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new ListStackNode(720, 2, regular__iter_star__char_class___range__48_57, new CharStackNode(722, 0, new int[][]{{48,57}}, null, null), false, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57}})});
      tmp[1] = new CharStackNode(718, 1, new int[][]{{49,57}}, null, null);
      tmp[0] = new CharStackNode(716, 0, new int[][]{{37,37}}, null, null);
      builder.addAlternative(ClojureParser.prod__Arg__char_class___range__37_37_char_class___range__49_57_conditional__iter_star__char_class___range__48_57__not_follow__char_class___range__48_57_, tmp);
	}
    protected static final void _init_prod__Arg__conditional__char_class___range__37_37__not_follow__char_class___range__38_38_range__49_57_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new CharStackNode(724, 0, new int[][]{{37,37}}, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{38,38},{49,57}})});
      builder.addAlternative(ClojureParser.prod__Arg__conditional__char_class___range__37_37__not_follow__char_class___range__38_38_range__49_57_, tmp);
	}
    protected static final void _init_prod__Arg__char_class___range__37_37_char_class___range__38_38_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[2];
      
      tmp[1] = new CharStackNode(728, 1, new int[][]{{38,38}}, null, null);
      tmp[0] = new CharStackNode(726, 0, new int[][]{{37,37}}, null, null);
      builder.addAlternative(ClojureParser.prod__Arg__char_class___range__37_37_char_class___range__38_38_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__Arg__char_class___range__37_37_char_class___range__49_57_conditional__iter_star__char_class___range__48_57__not_follow__char_class___range__48_57_(builder);
      
        _init_prod__Arg__conditional__char_class___range__37_37__not_follow__char_class___range__38_38_range__49_57_(builder);
      
        _init_prod__Arg__char_class___range__37_37_char_class___range__38_38_(builder);
      
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
      
      tmp[0] = new NonTerminalStackNode(730, 0, "Whitespace", null, null);
      builder.addAlternative(ClojureParser.prod__whitespace_WhitespaceOrComment__Whitespace_, tmp);
	}
    protected static final void _init_prod__comment_WhitespaceOrComment__Comment_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(732, 0, "Comment", null, null);
      builder.addAlternative(ClojureParser.prod__comment_WhitespaceOrComment__Comment_, tmp);
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
    
    protected static final void _init_prod__String__char_class___range__34_34_iter_star__alt___seq___char_class___range__92_92_char_class___range__34_34_range__92_92_range__98_98_range__102_102_range__110_110_range__114_114_range__116_116_char_class___range__0_33_range__35_91_range__93_16777215_char_class___range__34_34__tag__category___83_116_114_105_110_103_76_105_116_101_114_97_108(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new CharStackNode(748, 2, new int[][]{{34,34}}, null, null);
      tmp[1] = new ListStackNode(736, 1, regular__iter_star__alt___seq___char_class___range__92_92_char_class___range__34_34_range__92_92_range__98_98_range__102_102_range__110_110_range__114_114_range__116_116_char_class___range__0_33_range__35_91_range__93_16777215, new AlternativeStackNode(738, 0, regular__alt___seq___char_class___range__92_92_char_class___range__34_34_range__92_92_range__98_98_range__102_102_range__110_110_range__114_114_range__116_116_char_class___range__0_33_range__35_91_range__93_16777215, new AbstractStackNode[]{new SequenceStackNode(740, 0, regular__seq___char_class___range__92_92_char_class___range__34_34_range__92_92_range__98_98_range__102_102_range__110_110_range__114_114_range__116_116, new AbstractStackNode[]{new CharStackNode(742, 0, new int[][]{{92,92}}, null, null), new CharStackNode(744, 1, new int[][]{{34,34},{92,92},{98,98},{102,102},{110,110},{114,114},{116,116}}, null, null)}, null, null), new CharStackNode(746, 0, new int[][]{{0,33},{35,91},{93,16777215}}, null, null)}, null, null), false, null, null);
      tmp[0] = new CharStackNode(734, 0, new int[][]{{34,34}}, null, null);
      builder.addAlternative(ClojureParser.prod__String__char_class___range__34_34_iter_star__alt___seq___char_class___range__92_92_char_class___range__34_34_range__92_92_range__98_98_range__102_102_range__110_110_range__114_114_range__116_116_char_class___range__0_33_range__35_91_range__93_16777215_char_class___range__34_34__tag__category___83_116_114_105_110_103_76_105_116_101_114_97_108, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__String__char_class___range__34_34_iter_star__alt___seq___char_class___range__92_92_char_class___range__34_34_range__92_92_range__98_98_range__102_102_range__110_110_range__114_114_range__116_116_char_class___range__0_33_range__35_91_range__93_16777215_char_class___range__34_34__tag__category___83_116_114_105_110_103_76_105_116_101_114_97_108(builder);
      
    }
  }
	
  protected static class Form {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__set_Form__lit___35_123_layouts_Standard_iter_star_seps__Form__layouts_Standard_layouts_Standard_lit___125_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new LiteralStackNode(762, 4, prod__lit___125__char_class___range__125_125_, new int[] {125}, null, null);
      tmp[3] = new NonTerminalStackNode(760, 3, "layouts_Standard", null, null);
      tmp[2] = new SeparatedListStackNode(754, 2, regular__iter_star_seps__Form__layouts_Standard, new NonTerminalStackNode(756, 0, "Form", null, null), new AbstractStackNode[]{new NonTerminalStackNode(758, 1, "layouts_Standard", null, null)}, false, null, null);
      tmp[1] = new NonTerminalStackNode(752, 1, "layouts_Standard", null, null);
      tmp[0] = new LiteralStackNode(750, 0, prod__lit___35_123__char_class___range__35_35_char_class___range__123_123_, new int[] {35,123}, null, null);
      builder.addAlternative(ClojureParser.prod__set_Form__lit___35_123_layouts_Standard_iter_star_seps__Form__layouts_Standard_layouts_Standard_lit___125_, tmp);
	}
    protected static final void _init_prod__deref_Form__lit___64_layouts_Standard_Form_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new NonTerminalStackNode(768, 2, "Form", null, null);
      tmp[1] = new NonTerminalStackNode(766, 1, "layouts_Standard", null, null);
      tmp[0] = new LiteralStackNode(764, 0, prod__lit___64__char_class___range__64_64_, new int[] {64}, null, null);
      builder.addAlternative(ClojureParser.prod__deref_Form__lit___64_layouts_Standard_Form_, tmp);
	}
    protected static final void _init_prod__fn_Form__lit___35_40_layouts_Standard_iter_star_seps__Form__layouts_Standard_layouts_Standard_lit___41_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new LiteralStackNode(782, 4, prod__lit___41__char_class___range__41_41_, new int[] {41}, null, null);
      tmp[3] = new NonTerminalStackNode(780, 3, "layouts_Standard", null, null);
      tmp[2] = new SeparatedListStackNode(774, 2, regular__iter_star_seps__Form__layouts_Standard, new NonTerminalStackNode(776, 0, "Form", null, null), new AbstractStackNode[]{new NonTerminalStackNode(778, 1, "layouts_Standard", null, null)}, false, null, null);
      tmp[1] = new NonTerminalStackNode(772, 1, "layouts_Standard", null, null);
      tmp[0] = new LiteralStackNode(770, 0, prod__lit___35_40__char_class___range__35_35_char_class___range__40_40_, new int[] {35,40}, null, null);
      builder.addAlternative(ClojureParser.prod__fn_Form__lit___35_40_layouts_Standard_iter_star_seps__Form__layouts_Standard_layouts_Standard_lit___41_, tmp);
	}
    protected static final void _init_prod__string_Form__String_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(784, 0, "String", null, null);
      builder.addAlternative(ClojureParser.prod__string_Form__String_, tmp);
	}
    protected static final void _init_prod__qquote_Form__lit___96_layouts_Standard_arg_Form_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new NonTerminalStackNode(790, 2, "Form", null, null);
      tmp[1] = new NonTerminalStackNode(788, 1, "layouts_Standard", null, null);
      tmp[0] = new LiteralStackNode(786, 0, prod__lit___96__char_class___range__96_96_, new int[] {96}, null, null);
      builder.addAlternative(ClojureParser.prod__qquote_Form__lit___96_layouts_Standard_arg_Form_, tmp);
	}
    protected static final void _init_prod__symbol_Form__Symbol_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(798, 0, "Symbol", null, null);
      builder.addAlternative(ClojureParser.prod__symbol_Form__Symbol_, tmp);
	}
    protected static final void _init_prod__unquotes_Form__lit___126_64_layouts_Standard_arg_Form_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new NonTerminalStackNode(796, 2, "Form", null, null);
      tmp[1] = new NonTerminalStackNode(794, 1, "layouts_Standard", null, null);
      tmp[0] = new LiteralStackNode(792, 0, prod__lit___126_64__char_class___range__126_126_char_class___range__64_64_, new int[] {126,64}, null, null);
      builder.addAlternative(ClojureParser.prod__unquotes_Form__lit___126_64_layouts_Standard_arg_Form_, tmp);
	}
    protected static final void _init_prod__vector_Form__lit___91_layouts_Standard_iter_star_seps__Form__layouts_Standard_layouts_Standard_lit___93_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new LiteralStackNode(812, 4, prod__lit___93__char_class___range__93_93_, new int[] {93}, null, null);
      tmp[3] = new NonTerminalStackNode(810, 3, "layouts_Standard", null, null);
      tmp[2] = new SeparatedListStackNode(804, 2, regular__iter_star_seps__Form__layouts_Standard, new NonTerminalStackNode(806, 0, "Form", null, null), new AbstractStackNode[]{new NonTerminalStackNode(808, 1, "layouts_Standard", null, null)}, false, null, null);
      tmp[1] = new NonTerminalStackNode(802, 1, "layouts_Standard", null, null);
      tmp[0] = new LiteralStackNode(800, 0, prod__lit___91__char_class___range__91_91_, new int[] {91}, null, null);
      builder.addAlternative(ClojureParser.prod__vector_Form__lit___91_layouts_Standard_iter_star_seps__Form__layouts_Standard_layouts_Standard_lit___93_, tmp);
	}
    protected static final void _init_prod__var_Form__lit___35_39_layouts_Standard_Form_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new NonTerminalStackNode(818, 2, "Form", null, null);
      tmp[1] = new NonTerminalStackNode(816, 1, "layouts_Standard", null, null);
      tmp[0] = new LiteralStackNode(814, 0, prod__lit___35_39__char_class___range__35_35_char_class___range__39_39_, new int[] {35,39}, null, null);
      builder.addAlternative(ClojureParser.prod__var_Form__lit___35_39_layouts_Standard_Form_, tmp);
	}
    protected static final void _init_prod__Form__lit___35_94_layouts_Standard_Symbol_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new NonTerminalStackNode(824, 2, "Symbol", null, null);
      tmp[1] = new NonTerminalStackNode(822, 1, "layouts_Standard", null, null);
      tmp[0] = new LiteralStackNode(820, 0, prod__lit___35_94__char_class___range__35_35_char_class___range__94_94_, new int[] {35,94}, null, null);
      builder.addAlternative(ClojureParser.prod__Form__lit___35_94_layouts_Standard_Symbol_, tmp);
	}
    protected static final void _init_prod__quote_Form__lit___39_layouts_Standard_arg_Form_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new NonTerminalStackNode(830, 2, "Form", null, null);
      tmp[1] = new NonTerminalStackNode(828, 1, "layouts_Standard", null, null);
      tmp[0] = new LiteralStackNode(826, 0, prod__lit___39__char_class___range__39_39_, new int[] {39}, null, null);
      builder.addAlternative(ClojureParser.prod__quote_Form__lit___39_layouts_Standard_arg_Form_, tmp);
	}
    protected static final void _init_prod__char_Form__Char_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(832, 0, "Char", null, null);
      builder.addAlternative(ClojureParser.prod__char_Form__Char_, tmp);
	}
    protected static final void _init_prod__discard_Form__lit___35_95_layouts_Standard_Form_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new NonTerminalStackNode(838, 2, "Form", null, null);
      tmp[1] = new NonTerminalStackNode(836, 1, "layouts_Standard", null, null);
      tmp[0] = new LiteralStackNode(834, 0, prod__lit___35_95__char_class___range__35_35_char_class___range__95_95_, new int[] {35,95}, null, null);
      builder.addAlternative(ClojureParser.prod__discard_Form__lit___35_95_layouts_Standard_Form_, tmp);
	}
    protected static final void _init_prod__list_Form__lit___40_layouts_Standard_iter_star_seps__Form__layouts_Standard_layouts_Standard_lit___41_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new LiteralStackNode(852, 4, prod__lit___41__char_class___range__41_41_, new int[] {41}, null, null);
      tmp[3] = new NonTerminalStackNode(850, 3, "layouts_Standard", null, null);
      tmp[2] = new SeparatedListStackNode(844, 2, regular__iter_star_seps__Form__layouts_Standard, new NonTerminalStackNode(846, 0, "Form", null, null), new AbstractStackNode[]{new NonTerminalStackNode(848, 1, "layouts_Standard", null, null)}, false, null, null);
      tmp[1] = new NonTerminalStackNode(842, 1, "layouts_Standard", null, null);
      tmp[0] = new LiteralStackNode(840, 0, prod__lit___40__char_class___range__40_40_, new int[] {40}, null, null);
      builder.addAlternative(ClojureParser.prod__list_Form__lit___40_layouts_Standard_iter_star_seps__Form__layouts_Standard_layouts_Standard_lit___41_, tmp);
	}
    protected static final void _init_prod__regexp_Form__RegExp_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(854, 0, "RegExp", null, null);
      builder.addAlternative(ClojureParser.prod__regexp_Form__RegExp_, tmp);
	}
    protected static final void _init_prod__meta_Form__lit___94_layouts_Standard_meta_Form_layouts_Standard_arg_Form_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new NonTerminalStackNode(866, 4, "Form", null, null);
      tmp[3] = new NonTerminalStackNode(864, 3, "layouts_Standard", null, null);
      tmp[2] = new NonTerminalStackNode(862, 2, "Form", null, null);
      tmp[1] = new NonTerminalStackNode(860, 1, "layouts_Standard", null, null);
      tmp[0] = new LiteralStackNode(858, 0, prod__lit___94__char_class___range__94_94_, new int[] {94}, null, null);
      builder.addAlternative(ClojureParser.prod__meta_Form__lit___94_layouts_Standard_meta_Form_layouts_Standard_arg_Form_, tmp);
	}
    protected static final void _init_prod__number_Form__Number_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(856, 0, "Number", null, null);
      builder.addAlternative(ClojureParser.prod__number_Form__Number_, tmp);
	}
    protected static final void _init_prod__arg_Form__Arg_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(868, 0, "Arg", null, null);
      builder.addAlternative(ClojureParser.prod__arg_Form__Arg_, tmp);
	}
    protected static final void _init_prod__map_Form__lit___123_layouts_Standard_iter_star_seps__Form__layouts_Standard_layouts_Standard_lit___125_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[5];
      
      tmp[4] = new LiteralStackNode(882, 4, prod__lit___125__char_class___range__125_125_, new int[] {125}, null, null);
      tmp[3] = new NonTerminalStackNode(880, 3, "layouts_Standard", null, null);
      tmp[2] = new SeparatedListStackNode(874, 2, regular__iter_star_seps__Form__layouts_Standard, new NonTerminalStackNode(876, 0, "Form", null, null), new AbstractStackNode[]{new NonTerminalStackNode(878, 1, "layouts_Standard", null, null)}, false, null, null);
      tmp[1] = new NonTerminalStackNode(872, 1, "layouts_Standard", null, null);
      tmp[0] = new LiteralStackNode(870, 0, prod__lit___123__char_class___range__123_123_, new int[] {123}, null, null);
      builder.addAlternative(ClojureParser.prod__map_Form__lit___123_layouts_Standard_iter_star_seps__Form__layouts_Standard_layouts_Standard_lit___125_, tmp);
	}
    protected static final void _init_prod__unquote_Form__conditional__lit___126__not_follow__char_class___range__64_64_layouts_Standard_arg_Form_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new NonTerminalStackNode(888, 2, "Form", null, null);
      tmp[1] = new NonTerminalStackNode(886, 1, "layouts_Standard", null, null);
      tmp[0] = new LiteralStackNode(884, 0, prod__lit___126__char_class___range__126_126_, new int[] {126}, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{64,64}})});
      builder.addAlternative(ClojureParser.prod__unquote_Form__conditional__lit___126__not_follow__char_class___range__64_64_layouts_Standard_arg_Form_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__set_Form__lit___35_123_layouts_Standard_iter_star_seps__Form__layouts_Standard_layouts_Standard_lit___125_(builder);
      
        _init_prod__deref_Form__lit___64_layouts_Standard_Form_(builder);
      
        _init_prod__fn_Form__lit___35_40_layouts_Standard_iter_star_seps__Form__layouts_Standard_layouts_Standard_lit___41_(builder);
      
        _init_prod__string_Form__String_(builder);
      
        _init_prod__qquote_Form__lit___96_layouts_Standard_arg_Form_(builder);
      
        _init_prod__symbol_Form__Symbol_(builder);
      
        _init_prod__unquotes_Form__lit___126_64_layouts_Standard_arg_Form_(builder);
      
        _init_prod__vector_Form__lit___91_layouts_Standard_iter_star_seps__Form__layouts_Standard_layouts_Standard_lit___93_(builder);
      
        _init_prod__var_Form__lit___35_39_layouts_Standard_Form_(builder);
      
        _init_prod__Form__lit___35_94_layouts_Standard_Symbol_(builder);
      
        _init_prod__quote_Form__lit___39_layouts_Standard_arg_Form_(builder);
      
        _init_prod__char_Form__Char_(builder);
      
        _init_prod__discard_Form__lit___35_95_layouts_Standard_Form_(builder);
      
        _init_prod__list_Form__lit___40_layouts_Standard_iter_star_seps__Form__layouts_Standard_layouts_Standard_lit___41_(builder);
      
        _init_prod__regexp_Form__RegExp_(builder);
      
        _init_prod__meta_Form__lit___94_layouts_Standard_meta_Form_layouts_Standard_arg_Form_(builder);
      
        _init_prod__number_Form__Number_(builder);
      
        _init_prod__arg_Form__Arg_(builder);
      
        _init_prod__map_Form__lit___123_layouts_Standard_iter_star_seps__Form__layouts_Standard_layouts_Standard_lit___125_(builder);
      
        _init_prod__unquote_Form__conditional__lit___126__not_follow__char_class___range__64_64_layouts_Standard_arg_Form_(builder);
      
    }
  }
	
  protected static class RegExp {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__RegExp__char_class___range__35_35_char_class___range__34_34_iter_star__alt___seq___char_class___range__92_92_char_class___range__34_34_range__40_43_range__46_46_range__63_63_range__83_83_range__87_87_range__91_93_range__100_100_range__115_115_range__119_119_char_class___range__0_33_range__35_91_range__93_16777215_char_class___range__34_34_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[4];
      
      tmp[3] = new CharStackNode(906, 3, new int[][]{{34,34}}, null, null);
      tmp[2] = new ListStackNode(894, 2, regular__iter_star__alt___seq___char_class___range__92_92_char_class___range__34_34_range__40_43_range__46_46_range__63_63_range__83_83_range__87_87_range__91_93_range__100_100_range__115_115_range__119_119_char_class___range__0_33_range__35_91_range__93_16777215, new AlternativeStackNode(896, 0, regular__alt___seq___char_class___range__92_92_char_class___range__34_34_range__40_43_range__46_46_range__63_63_range__83_83_range__87_87_range__91_93_range__100_100_range__115_115_range__119_119_char_class___range__0_33_range__35_91_range__93_16777215, new AbstractStackNode[]{new SequenceStackNode(898, 0, regular__seq___char_class___range__92_92_char_class___range__34_34_range__40_43_range__46_46_range__63_63_range__83_83_range__87_87_range__91_93_range__100_100_range__115_115_range__119_119, new AbstractStackNode[]{new CharStackNode(900, 0, new int[][]{{92,92}}, null, null), new CharStackNode(902, 1, new int[][]{{34,34},{40,43},{46,46},{63,63},{83,83},{87,87},{91,93},{100,100},{115,115},{119,119}}, null, null)}, null, null), new CharStackNode(904, 0, new int[][]{{0,33},{35,91},{93,16777215}}, null, null)}, null, null), false, null, null);
      tmp[1] = new CharStackNode(892, 1, new int[][]{{34,34}}, null, null);
      tmp[0] = new CharStackNode(890, 0, new int[][]{{35,35}}, null, null);
      builder.addAlternative(ClojureParser.prod__RegExp__char_class___range__35_35_char_class___range__34_34_iter_star__alt___seq___char_class___range__92_92_char_class___range__34_34_range__40_43_range__46_46_range__63_63_range__83_83_range__87_87_range__91_93_range__100_100_range__115_115_range__119_119_char_class___range__0_33_range__35_91_range__93_16777215_char_class___range__34_34_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__RegExp__char_class___range__35_35_char_class___range__34_34_iter_star__alt___seq___char_class___range__92_92_char_class___range__34_34_range__40_43_range__46_46_range__63_63_range__83_83_range__87_87_range__91_93_range__100_100_range__115_115_range__119_119_char_class___range__0_33_range__35_91_range__93_16777215_char_class___range__34_34_(builder);
      
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
      
      tmp[0] = new NonTerminalStackNode(932, 0, "Ratio", null, null);
      builder.addAlternative(ClojureParser.prod__ratio_Number__Ratio_, tmp);
	}
    protected static final void _init_prod__integer_Number__Integer_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(934, 0, "Integer", null, null);
      builder.addAlternative(ClojureParser.prod__integer_Number__Integer_, tmp);
	}
    protected static final void _init_prod__bigdecimal_Number__BigDecimal_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(936, 0, "BigDecimal", null, null);
      builder.addAlternative(ClojureParser.prod__bigdecimal_Number__BigDecimal_, tmp);
	}
    protected static final void _init_prod__float_Number__Float_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(938, 0, "Float", null, null);
      builder.addAlternative(ClojureParser.prod__float_Number__Float_, tmp);
	}
    protected static final void _init_prod__intbase_Number__IntBase_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[1];
      
      tmp[0] = new NonTerminalStackNode(940, 0, "IntBase", null, null);
      builder.addAlternative(ClojureParser.prod__intbase_Number__IntBase_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__ratio_Number__Ratio_(builder);
      
        _init_prod__integer_Number__Integer_(builder);
      
        _init_prod__bigdecimal_Number__BigDecimal_(builder);
      
        _init_prod__float_Number__Float_(builder);
      
        _init_prod__intbase_Number__IntBase_(builder);
      
    }
  }
	
  protected static class Integer {
    public final static AbstractStackNode[] EXPECTS;
    static{
      ExpectBuilder builder = new ExpectBuilder(_resultStoreIdMappings);
      init(builder);
      EXPECTS = builder.buildExpectArray();
    }
    
    protected static final void _init_prod__Integer__opt__char_class___range__45_45_char_class___range__48_57_conditional__iter_star__char_class___range__48_57__not_follow__char_class___range__48_57_(ExpectBuilder builder) {
      AbstractStackNode[] tmp = new AbstractStackNode[3];
      
      tmp[2] = new ListStackNode(1004, 2, regular__iter_star__char_class___range__48_57, new CharStackNode(1006, 0, new int[][]{{48,57}}, null, null), false, null, new ICompletionFilter[] {new CharFollowRestriction(new int[][]{{48,57}})});
      tmp[1] = new CharStackNode(1002, 1, new int[][]{{48,57}}, null, null);
      tmp[0] = new OptionalStackNode(998, 0, regular__opt__char_class___range__45_45, new CharStackNode(1000, 0, new int[][]{{45,45}}, null, null), null, null);
      builder.addAlternative(ClojureParser.prod__Integer__opt__char_class___range__45_45_char_class___range__48_57_conditional__iter_star__char_class___range__48_57__not_follow__char_class___range__48_57_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__Integer__opt__char_class___range__45_45_char_class___range__48_57_conditional__iter_star__char_class___range__48_57__not_follow__char_class___range__48_57_(builder);
      
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
      
      tmp[0] = new EpsilonStackNode(1010, 0);
      builder.addAlternative(ClojureParser.prod__layouts_$BACKTICKS__, tmp);
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
      
      tmp[0] = new CharStackNode(1012, 0, new int[][]{{9,10},{12,13},{32,32},{44,44}}, null, null);
      builder.addAlternative(ClojureParser.prod__Whitespace__char_class___range__9_10_range__12_13_range__32_32_range__44_44_, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__Whitespace__char_class___range__9_10_range__12_13_range__32_32_range__44_44_(builder);
      
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
      
      tmp[0] = new EpsilonStackNode(1026, 0);
      builder.addAlternative(ClojureParser.prod__layouts_$default$__, tmp);
	}
    public static void init(ExpectBuilder builder){
      
      
        _init_prod__layouts_$default$__(builder);
      
    }
  }
	
  public ClojureParser() {
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
  public AbstractStackNode[] start__File() {
    return start__File.EXPECTS;
  }
  public AbstractStackNode[] Char() {
    return Char.EXPECTS;
  }
  public AbstractStackNode[] File() {
    return File.EXPECTS;
  }
  public AbstractStackNode[] IntBase() {
    return IntBase.EXPECTS;
  }
  public AbstractStackNode[] Ident() {
    return Ident.EXPECTS;
  }
  public AbstractStackNode[] BigDecimal() {
    return BigDecimal.EXPECTS;
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
  public AbstractStackNode[] Arg() {
    return Arg.EXPECTS;
  }
  public AbstractStackNode[] WhitespaceOrComment() {
    return WhitespaceOrComment.EXPECTS;
  }
  public AbstractStackNode[] String() {
    return String.EXPECTS;
  }
  public AbstractStackNode[] Form() {
    return Form.EXPECTS;
  }
  public AbstractStackNode[] RegExp() {
    return RegExp.EXPECTS;
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
  public AbstractStackNode[] Whitespace() {
    return Whitespace.EXPECTS;
  }
  public AbstractStackNode[] layouts_$default$() {
    return layouts_$default$.EXPECTS;
  }
}