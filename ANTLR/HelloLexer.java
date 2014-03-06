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
		Identifier=1, Letter=2, LetterOrDigit=3, IntegerLiteral=4, DecimalLiteral=5, 
		Digs=6, Digit=7, NullLiteral=8, DOT=9, UPPERCASE=10, LOWERCASE=11, CHARACTER=12, 
		UNDERSCORE=13, NUMBER=14, ASSIGN=15, BANG=16, SEMICOLON=17, EQUAL=18, 
		GT=19, LT=20, LE=21, GE=22, NOTEQUAL=23, AND=24, OR=25, INC=26, DEC=27, 
		ADD=28, SUB=29, MUL=30, DIV=31, MOD=32, ADD_ASSIGN=33, SUB_ASSIGN=34, 
		MUL_ASSIGN=35, DIV_ASSIGN=36, AND_ASSIGN=37, MOD_ASSIGN=38, WS=39, COMMENT=40, 
		LINE_COMMENT=41;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"Identifier", "Letter", "LetterOrDigit", "IntegerLiteral", "DecimalLiteral", 
		"Digs", "Digit", "'null'", "'.'", "UPPERCASE", "LOWERCASE", "CHARACTER", 
		"'_'", "NUMBER", "'='", "'!'", "';'", "'=='", "'>'", "'<'", "'<='", "'>='", 
		"'!='", "'AND'", "'OR'", "'++'", "'--'", "'+'", "'-'", "'*'", "'/'", "'%'", 
		"'+='", "'-='", "'*='", "'/='", "'&='", "'%='", "WS", "COMMENT", "LINE_COMMENT"
	};
	public static final String[] ruleNames = {
		"Identifier", "Letter", "LetterOrDigit", "IntegerLiteral", "DecimalLiteral", 
		"Digs", "Digit", "NullLiteral", "DOT", "UPPERCASE", "LOWERCASE", "CHARACTER", 
		"UNDERSCORE", "NUMBER", "ASSIGN", "BANG", "SEMICOLON", "EQUAL", "GT", 
		"LT", "LE", "GE", "NOTEQUAL", "AND", "OR", "INC", "DEC", "ADD", "SUB", 
		"MUL", "DIV", "MOD", "ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", 
		"AND_ASSIGN", "MOD_ASSIGN", "WS", "COMMENT", "LINE_COMMENT"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2+\u00e7\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\3\2"+
		"\7\2X\n\2\f\2\16\2[\13\2\3\3\3\3\5\3_\n\3\3\4\3\4\3\4\5\4d\n\4\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\6\5\6m\n\6\3\7\6\7p\n\7\r\7\16\7q\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\5\r\u0083\n\r\3\16\3\16\3"+
		"\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3"+
		"\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3"+
		"\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3"+
		"\37\3 \3 \3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3%\3%\3%\3&\3&\3&\3\'\3"+
		"\'\3\'\3(\6(\u00c9\n(\r(\16(\u00ca\3(\3(\3)\3)\3)\3)\7)\u00d3\n)\f)\16"+
		")\u00d6\13)\3)\3)\3)\3)\3)\3*\3*\3*\3*\7*\u00e1\n*\f*\16*\u00e4\13*\3"+
		"*\3*\3\u00d4\2+\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+\3\2\7\3\2C\\\3\2c|\3\2\62"+
		";\5\2\13\f\16\17\"\"\4\2\f\f\17\17\u00f0\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2"+
		"A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3"+
		"\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\3U\3\2\2\2\5^\3\2\2\2\7c\3\2\2"+
		"\2\te\3\2\2\2\13l\3\2\2\2\ro\3\2\2\2\17s\3\2\2\2\21u\3\2\2\2\23z\3\2\2"+
		"\2\25|\3\2\2\2\27~\3\2\2\2\31\u0082\3\2\2\2\33\u0084\3\2\2\2\35\u0086"+
		"\3\2\2\2\37\u0088\3\2\2\2!\u008a\3\2\2\2#\u008c\3\2\2\2%\u008e\3\2\2\2"+
		"\'\u0091\3\2\2\2)\u0093\3\2\2\2+\u0095\3\2\2\2-\u0098\3\2\2\2/\u009b\3"+
		"\2\2\2\61\u009e\3\2\2\2\63\u00a2\3\2\2\2\65\u00a5\3\2\2\2\67\u00a8\3\2"+
		"\2\29\u00ab\3\2\2\2;\u00ad\3\2\2\2=\u00af\3\2\2\2?\u00b1\3\2\2\2A\u00b3"+
		"\3\2\2\2C\u00b5\3\2\2\2E\u00b8\3\2\2\2G\u00bb\3\2\2\2I\u00be\3\2\2\2K"+
		"\u00c1\3\2\2\2M\u00c4\3\2\2\2O\u00c8\3\2\2\2Q\u00ce\3\2\2\2S\u00dc\3\2"+
		"\2\2UY\5\5\3\2VX\5\7\4\2WV\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\4\3"+
		"\2\2\2[Y\3\2\2\2\\_\5\31\r\2]_\5\33\16\2^\\\3\2\2\2^]\3\2\2\2_\6\3\2\2"+
		"\2`d\5\31\r\2ad\5\33\16\2bd\5\35\17\2c`\3\2\2\2ca\3\2\2\2cb\3\2\2\2d\b"+
		"\3\2\2\2ef\5\r\7\2f\n\3\2\2\2gh\5\r\7\2hi\5\23\n\2ij\5\r\7\2jm\3\2\2\2"+
		"km\5\r\7\2lg\3\2\2\2lk\3\2\2\2m\f\3\2\2\2np\5\17\b\2on\3\2\2\2pq\3\2\2"+
		"\2qo\3\2\2\2qr\3\2\2\2r\16\3\2\2\2st\5\35\17\2t\20\3\2\2\2uv\7p\2\2vw"+
		"\7w\2\2wx\7n\2\2xy\7n\2\2y\22\3\2\2\2z{\7\60\2\2{\24\3\2\2\2|}\t\2\2\2"+
		"}\26\3\2\2\2~\177\t\3\2\2\177\30\3\2\2\2\u0080\u0083\5\25\13\2\u0081\u0083"+
		"\5\27\f\2\u0082\u0080\3\2\2\2\u0082\u0081\3\2\2\2\u0083\32\3\2\2\2\u0084"+
		"\u0085\7a\2\2\u0085\34\3\2\2\2\u0086\u0087\t\4\2\2\u0087\36\3\2\2\2\u0088"+
		"\u0089\7?\2\2\u0089 \3\2\2\2\u008a\u008b\7#\2\2\u008b\"\3\2\2\2\u008c"+
		"\u008d\7=\2\2\u008d$\3\2\2\2\u008e\u008f\7?\2\2\u008f\u0090\7?\2\2\u0090"+
		"&\3\2\2\2\u0091\u0092\7@\2\2\u0092(\3\2\2\2\u0093\u0094\7>\2\2\u0094*"+
		"\3\2\2\2\u0095\u0096\7>\2\2\u0096\u0097\7?\2\2\u0097,\3\2\2\2\u0098\u0099"+
		"\7@\2\2\u0099\u009a\7?\2\2\u009a.\3\2\2\2\u009b\u009c\7#\2\2\u009c\u009d"+
		"\7?\2\2\u009d\60\3\2\2\2\u009e\u009f\7C\2\2\u009f\u00a0\7P\2\2\u00a0\u00a1"+
		"\7F\2\2\u00a1\62\3\2\2\2\u00a2\u00a3\7Q\2\2\u00a3\u00a4\7T\2\2\u00a4\64"+
		"\3\2\2\2\u00a5\u00a6\7-\2\2\u00a6\u00a7\7-\2\2\u00a7\66\3\2\2\2\u00a8"+
		"\u00a9\7/\2\2\u00a9\u00aa\7/\2\2\u00aa8\3\2\2\2\u00ab\u00ac\7-\2\2\u00ac"+
		":\3\2\2\2\u00ad\u00ae\7/\2\2\u00ae<\3\2\2\2\u00af\u00b0\7,\2\2\u00b0>"+
		"\3\2\2\2\u00b1\u00b2\7\61\2\2\u00b2@\3\2\2\2\u00b3\u00b4\7\'\2\2\u00b4"+
		"B\3\2\2\2\u00b5\u00b6\7-\2\2\u00b6\u00b7\7?\2\2\u00b7D\3\2\2\2\u00b8\u00b9"+
		"\7/\2\2\u00b9\u00ba\7?\2\2\u00baF\3\2\2\2\u00bb\u00bc\7,\2\2\u00bc\u00bd"+
		"\7?\2\2\u00bdH\3\2\2\2\u00be\u00bf\7\61\2\2\u00bf\u00c0\7?\2\2\u00c0J"+
		"\3\2\2\2\u00c1\u00c2\7(\2\2\u00c2\u00c3\7?\2\2\u00c3L\3\2\2\2\u00c4\u00c5"+
		"\7\'\2\2\u00c5\u00c6\7?\2\2\u00c6N\3\2\2\2\u00c7\u00c9\t\5\2\2\u00c8\u00c7"+
		"\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb"+
		"\u00cc\3\2\2\2\u00cc\u00cd\b(\2\2\u00cdP\3\2\2\2\u00ce\u00cf\7\61\2\2"+
		"\u00cf\u00d0\7,\2\2\u00d0\u00d4\3\2\2\2\u00d1\u00d3\13\2\2\2\u00d2\u00d1"+
		"\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5"+
		"\u00d7\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00d8\7,\2\2\u00d8\u00d9\7\61"+
		"\2\2\u00d9\u00da\3\2\2\2\u00da\u00db\b)\2\2\u00dbR\3\2\2\2\u00dc\u00dd"+
		"\7\61\2\2\u00dd\u00de\7\61\2\2\u00de\u00e2\3\2\2\2\u00df\u00e1\n\6\2\2"+
		"\u00e0\u00df\3\2\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3"+
		"\3\2\2\2\u00e3\u00e5\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5\u00e6\b*\2\2\u00e6"+
		"T\3\2\2\2\f\2Y^clq\u0082\u00ca\u00d4\u00e2\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}