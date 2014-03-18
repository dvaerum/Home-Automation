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
		MUL_ASSIGN=35, DIV_ASSIGN=36, AND_ASSIGN=37, MOD_ASSIGN=38, EOL=39, WS=40, 
		COMMENT=41, LINE_COMMENT=42;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"Identifier", "Letter", "LetterOrDigit", "IntegerLiteral", "DecimalLiteral", 
		"Digs", "Digit", "'null'", "'.'", "UPPERCASE", "LOWERCASE", "CHARACTER", 
		"'_'", "NUMBER", "'='", "'!'", "';'", "'=='", "'>'", "'<'", "'<='", "'>='", 
		"'!='", "'AND'", "'OR'", "'++'", "'--'", "'+'", "'-'", "'*'", "'/'", "'%'", 
		"'+='", "'-='", "'*='", "'/='", "'&='", "'%='", "EOL", "WS", "COMMENT", 
		"LINE_COMMENT"
	};
	public static final String[] ruleNames = {
		"Identifier", "Letter", "LetterOrDigit", "IntegerLiteral", "DecimalLiteral", 
		"Digs", "Digit", "NullLiteral", "DOT", "UPPERCASE", "LOWERCASE", "CHARACTER", 
		"UNDERSCORE", "NUMBER", "ASSIGN", "BANG", "SEMICOLON", "EQUAL", "GT", 
		"LT", "LE", "GE", "NOTEQUAL", "AND", "OR", "INC", "DEC", "ADD", "SUB", 
		"MUL", "DIV", "MOD", "ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", 
		"AND_ASSIGN", "MOD_ASSIGN", "EOL", "WS", "COMMENT", "LINE_COMMENT"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2,\u00ee\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\3\2\7\2Z\n\2\f\2\16\2]\13\2\3\3\3\3\5\3a\n\3\3\4\3\4\3\4\5\4f\n\4\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\6\5\6o\n\6\3\7\6\7r\n\7\r\7\16\7s\3\b\3\b\3\t"+
		"\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\5\r\u0085\n\r\3\16"+
		"\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24"+
		"\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31"+
		"\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\36\3\36"+
		"\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3%\3%\3%\3&\3&\3"+
		"&\3\'\3\'\3\'\3(\3(\3(\5(\u00cd\n(\3)\6)\u00d0\n)\r)\16)\u00d1\3)\3)\3"+
		"*\3*\3*\3*\7*\u00da\n*\f*\16*\u00dd\13*\3*\3*\3*\3*\3*\3+\3+\3+\3+\7+"+
		"\u00e8\n+\f+\16+\u00eb\13+\3+\3+\3\u00db\2,\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+"+
		"U,\3\2\7\3\2C\\\3\2c|\3\2\62;\4\2\f\f\17\17\5\2\13\f\16\17\"\"\u00f8\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2"+
		"\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2"+
		"\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U"+
		"\3\2\2\2\3W\3\2\2\2\5`\3\2\2\2\7e\3\2\2\2\tg\3\2\2\2\13n\3\2\2\2\rq\3"+
		"\2\2\2\17u\3\2\2\2\21w\3\2\2\2\23|\3\2\2\2\25~\3\2\2\2\27\u0080\3\2\2"+
		"\2\31\u0084\3\2\2\2\33\u0086\3\2\2\2\35\u0088\3\2\2\2\37\u008a\3\2\2\2"+
		"!\u008c\3\2\2\2#\u008e\3\2\2\2%\u0090\3\2\2\2\'\u0093\3\2\2\2)\u0095\3"+
		"\2\2\2+\u0097\3\2\2\2-\u009a\3\2\2\2/\u009d\3\2\2\2\61\u00a0\3\2\2\2\63"+
		"\u00a4\3\2\2\2\65\u00a7\3\2\2\2\67\u00aa\3\2\2\29\u00ad\3\2\2\2;\u00af"+
		"\3\2\2\2=\u00b1\3\2\2\2?\u00b3\3\2\2\2A\u00b5\3\2\2\2C\u00b7\3\2\2\2E"+
		"\u00ba\3\2\2\2G\u00bd\3\2\2\2I\u00c0\3\2\2\2K\u00c3\3\2\2\2M\u00c6\3\2"+
		"\2\2O\u00cc\3\2\2\2Q\u00cf\3\2\2\2S\u00d5\3\2\2\2U\u00e3\3\2\2\2W[\5\5"+
		"\3\2XZ\5\7\4\2YX\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\\4\3\2\2\2]["+
		"\3\2\2\2^a\5\31\r\2_a\5\33\16\2`^\3\2\2\2`_\3\2\2\2a\6\3\2\2\2bf\5\31"+
		"\r\2cf\5\33\16\2df\5\35\17\2eb\3\2\2\2ec\3\2\2\2ed\3\2\2\2f\b\3\2\2\2"+
		"gh\5\r\7\2h\n\3\2\2\2ij\5\r\7\2jk\5\23\n\2kl\5\r\7\2lo\3\2\2\2mo\5\r\7"+
		"\2ni\3\2\2\2nm\3\2\2\2o\f\3\2\2\2pr\5\17\b\2qp\3\2\2\2rs\3\2\2\2sq\3\2"+
		"\2\2st\3\2\2\2t\16\3\2\2\2uv\5\35\17\2v\20\3\2\2\2wx\7p\2\2xy\7w\2\2y"+
		"z\7n\2\2z{\7n\2\2{\22\3\2\2\2|}\7\60\2\2}\24\3\2\2\2~\177\t\2\2\2\177"+
		"\26\3\2\2\2\u0080\u0081\t\3\2\2\u0081\30\3\2\2\2\u0082\u0085\5\25\13\2"+
		"\u0083\u0085\5\27\f\2\u0084\u0082\3\2\2\2\u0084\u0083\3\2\2\2\u0085\32"+
		"\3\2\2\2\u0086\u0087\7a\2\2\u0087\34\3\2\2\2\u0088\u0089\t\4\2\2\u0089"+
		"\36\3\2\2\2\u008a\u008b\7?\2\2\u008b \3\2\2\2\u008c\u008d\7#\2\2\u008d"+
		"\"\3\2\2\2\u008e\u008f\7=\2\2\u008f$\3\2\2\2\u0090\u0091\7?\2\2\u0091"+
		"\u0092\7?\2\2\u0092&\3\2\2\2\u0093\u0094\7@\2\2\u0094(\3\2\2\2\u0095\u0096"+
		"\7>\2\2\u0096*\3\2\2\2\u0097\u0098\7>\2\2\u0098\u0099\7?\2\2\u0099,\3"+
		"\2\2\2\u009a\u009b\7@\2\2\u009b\u009c\7?\2\2\u009c.\3\2\2\2\u009d\u009e"+
		"\7#\2\2\u009e\u009f\7?\2\2\u009f\60\3\2\2\2\u00a0\u00a1\7C\2\2\u00a1\u00a2"+
		"\7P\2\2\u00a2\u00a3\7F\2\2\u00a3\62\3\2\2\2\u00a4\u00a5\7Q\2\2\u00a5\u00a6"+
		"\7T\2\2\u00a6\64\3\2\2\2\u00a7\u00a8\7-\2\2\u00a8\u00a9\7-\2\2\u00a9\66"+
		"\3\2\2\2\u00aa\u00ab\7/\2\2\u00ab\u00ac\7/\2\2\u00ac8\3\2\2\2\u00ad\u00ae"+
		"\7-\2\2\u00ae:\3\2\2\2\u00af\u00b0\7/\2\2\u00b0<\3\2\2\2\u00b1\u00b2\7"+
		",\2\2\u00b2>\3\2\2\2\u00b3\u00b4\7\61\2\2\u00b4@\3\2\2\2\u00b5\u00b6\7"+
		"\'\2\2\u00b6B\3\2\2\2\u00b7\u00b8\7-\2\2\u00b8\u00b9\7?\2\2\u00b9D\3\2"+
		"\2\2\u00ba\u00bb\7/\2\2\u00bb\u00bc\7?\2\2\u00bcF\3\2\2\2\u00bd\u00be"+
		"\7,\2\2\u00be\u00bf\7?\2\2\u00bfH\3\2\2\2\u00c0\u00c1\7\61\2\2\u00c1\u00c2"+
		"\7?\2\2\u00c2J\3\2\2\2\u00c3\u00c4\7(\2\2\u00c4\u00c5\7?\2\2\u00c5L\3"+
		"\2\2\2\u00c6\u00c7\7\'\2\2\u00c7\u00c8\7?\2\2\u00c8N\3\2\2\2\u00c9\u00ca"+
		"\7\17\2\2\u00ca\u00cd\7\f\2\2\u00cb\u00cd\t\5\2\2\u00cc\u00c9\3\2\2\2"+
		"\u00cc\u00cb\3\2\2\2\u00cdP\3\2\2\2\u00ce\u00d0\t\6\2\2\u00cf\u00ce\3"+
		"\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2"+
		"\u00d3\3\2\2\2\u00d3\u00d4\b)\2\2\u00d4R\3\2\2\2\u00d5\u00d6\7\61\2\2"+
		"\u00d6\u00d7\7,\2\2\u00d7\u00db\3\2\2\2\u00d8\u00da\13\2\2\2\u00d9\u00d8"+
		"\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00dc\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc"+
		"\u00de\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00df\7,\2\2\u00df\u00e0\7\61"+
		"\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\b*\2\2\u00e2T\3\2\2\2\u00e3\u00e4"+
		"\7\61\2\2\u00e4\u00e5\7\61\2\2\u00e5\u00e9\3\2\2\2\u00e6\u00e8\n\5\2\2"+
		"\u00e7\u00e6\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea"+
		"\3\2\2\2\u00ea\u00ec\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00ed\b+\2\2\u00ed"+
		"V\3\2\2\2\r\2[`ens\u0084\u00cc\u00d1\u00db\u00e9\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}