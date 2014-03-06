// Generated from Hello.g4 by ANTLR 4.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HelloLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IntegerLiteral=1, DecimalLiteral=2, Digs=3, Digit=4, NullLiteral=5, DOT=6, 
		ASSIGN=7, BANG=8, EQUAL=9, GT=10, LT=11, LE=12, GE=13, NOTEQUAL=14, AND=15, 
		OR=16, INC=17, DEC=18, ADD=19, SUB=20, MUL=21, DIV=22, MOD=23, ADD_ASSIGN=24, 
		SUB_ASSIGN=25, MUL_ASSIGN=26, DIV_ASSIGN=27, AND_ASSIGN=28, MOD_ASSIGN=29, 
		WS=30, COMMENT=31, LINE_COMMENT=32;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"IntegerLiteral", "DecimalLiteral", "Digs", "Digit", "'null'", "'.'", 
		"'='", "'!'", "'=='", "'>'", "'<'", "'<='", "'>='", "'!='", "'AND'", "'OR'", 
		"'++'", "'--'", "'+'", "'-'", "'*'", "'/'", "'%'", "'+='", "'-='", "'*='", 
		"'/='", "'&='", "'%='", "WS", "COMMENT", "LINE_COMMENT"
	};
	public static final String[] ruleNames = {
		"IntegerLiteral", "DecimalLiteral", "Digs", "Digit", "NullLiteral", "DOT", 
		"ASSIGN", "BANG", "EQUAL", "GT", "LT", "LE", "GE", "NOTEQUAL", "AND", 
		"OR", "INC", "DEC", "ADD", "SUB", "MUL", "DIV", "MOD", "ADD_ASSIGN", "SUB_ASSIGN", 
		"MUL_ASSIGN", "DIV_ASSIGN", "AND_ASSIGN", "MOD_ASSIGN", "WS", "COMMENT", 
		"LINE_COMMENT"
	};


	public HelloLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Hello.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\"\u00b7\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3K\n\3\3\4\6\4N\n\4\r\4\16\4O\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3"+
		"\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3"+
		"\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3"+
		"\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\37\6\37\u0099\n\37\r\37"+
		"\16\37\u009a\3\37\3\37\3 \3 \3 \3 \7 \u00a3\n \f \16 \u00a6\13 \3 \3 "+
		"\3 \3 \3 \3!\3!\3!\3!\7!\u00b1\n!\f!\16!\u00b4\13!\3!\3!\3\u00a4\2\"\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37="+
		" ?!A\"\3\2\5\3\2\62;\5\2\13\f\16\17\"\"\4\2\f\f\17\17\u00bb\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2"+
		"\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3"+
		"\2\2\2\2?\3\2\2\2\2A\3\2\2\2\3C\3\2\2\2\5J\3\2\2\2\7M\3\2\2\2\tQ\3\2\2"+
		"\2\13S\3\2\2\2\rX\3\2\2\2\17Z\3\2\2\2\21\\\3\2\2\2\23^\3\2\2\2\25a\3\2"+
		"\2\2\27c\3\2\2\2\31e\3\2\2\2\33h\3\2\2\2\35k\3\2\2\2\37n\3\2\2\2!r\3\2"+
		"\2\2#u\3\2\2\2%x\3\2\2\2\'{\3\2\2\2)}\3\2\2\2+\177\3\2\2\2-\u0081\3\2"+
		"\2\2/\u0083\3\2\2\2\61\u0085\3\2\2\2\63\u0088\3\2\2\2\65\u008b\3\2\2\2"+
		"\67\u008e\3\2\2\29\u0091\3\2\2\2;\u0094\3\2\2\2=\u0098\3\2\2\2?\u009e"+
		"\3\2\2\2A\u00ac\3\2\2\2CD\5\7\4\2D\4\3\2\2\2EF\5\7\4\2FG\5\r\7\2GH\5\7"+
		"\4\2HK\3\2\2\2IK\5\7\4\2JE\3\2\2\2JI\3\2\2\2K\6\3\2\2\2LN\5\t\5\2ML\3"+
		"\2\2\2NO\3\2\2\2OM\3\2\2\2OP\3\2\2\2P\b\3\2\2\2QR\t\2\2\2R\n\3\2\2\2S"+
		"T\7p\2\2TU\7w\2\2UV\7n\2\2VW\7n\2\2W\f\3\2\2\2XY\7\60\2\2Y\16\3\2\2\2"+
		"Z[\7?\2\2[\20\3\2\2\2\\]\7#\2\2]\22\3\2\2\2^_\7?\2\2_`\7?\2\2`\24\3\2"+
		"\2\2ab\7@\2\2b\26\3\2\2\2cd\7>\2\2d\30\3\2\2\2ef\7>\2\2fg\7?\2\2g\32\3"+
		"\2\2\2hi\7@\2\2ij\7?\2\2j\34\3\2\2\2kl\7#\2\2lm\7?\2\2m\36\3\2\2\2no\7"+
		"C\2\2op\7P\2\2pq\7F\2\2q \3\2\2\2rs\7Q\2\2st\7T\2\2t\"\3\2\2\2uv\7-\2"+
		"\2vw\7-\2\2w$\3\2\2\2xy\7/\2\2yz\7/\2\2z&\3\2\2\2{|\7-\2\2|(\3\2\2\2}"+
		"~\7/\2\2~*\3\2\2\2\177\u0080\7,\2\2\u0080,\3\2\2\2\u0081\u0082\7\61\2"+
		"\2\u0082.\3\2\2\2\u0083\u0084\7\'\2\2\u0084\60\3\2\2\2\u0085\u0086\7-"+
		"\2\2\u0086\u0087\7?\2\2\u0087\62\3\2\2\2\u0088\u0089\7/\2\2\u0089\u008a"+
		"\7?\2\2\u008a\64\3\2\2\2\u008b\u008c\7,\2\2\u008c\u008d\7?\2\2\u008d\66"+
		"\3\2\2\2\u008e\u008f\7\61\2\2\u008f\u0090\7?\2\2\u00908\3\2\2\2\u0091"+
		"\u0092\7(\2\2\u0092\u0093\7?\2\2\u0093:\3\2\2\2\u0094\u0095\7\'\2\2\u0095"+
		"\u0096\7?\2\2\u0096<\3\2\2\2\u0097\u0099\t\3\2\2\u0098\u0097\3\2\2\2\u0099"+
		"\u009a\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\3\2"+
		"\2\2\u009c\u009d\b\37\2\2\u009d>\3\2\2\2\u009e\u009f\7\61\2\2\u009f\u00a0"+
		"\7,\2\2\u00a0\u00a4\3\2\2\2\u00a1\u00a3\13\2\2\2\u00a2\u00a1\3\2\2\2\u00a3"+
		"\u00a6\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00a7\3\2"+
		"\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00a8\7,\2\2\u00a8\u00a9\7\61\2\2\u00a9"+
		"\u00aa\3\2\2\2\u00aa\u00ab\b \2\2\u00ab@\3\2\2\2\u00ac\u00ad\7\61\2\2"+
		"\u00ad\u00ae\7\61\2\2\u00ae\u00b2\3\2\2\2\u00af\u00b1\n\4\2\2\u00b0\u00af"+
		"\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3"+
		"\u00b5\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b6\b!\2\2\u00b6B\3\2\2\2\b"+
		"\2JO\u009a\u00a4\u00b2\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}