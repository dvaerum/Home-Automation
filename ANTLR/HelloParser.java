// Generated from Hello.g4 by ANTLR 4.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HelloParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__35=1, T__34=2, T__33=3, T__32=4, T__31=5, T__30=6, T__29=7, T__28=8,
		T__27=9, T__26=10, T__25=11, T__24=12, T__23=13, T__22=14, T__21=15, T__20=16,
		T__19=17, T__18=18, T__17=19, T__16=20, T__15=21, T__14=22, T__13=23,
		T__12=24, T__11=25, T__10=26, T__9=27, T__8=28, T__7=29, T__6=30, T__5=31,
		T__4=32, T__3=33, T__2=34, T__1=35, T__0=36, Identifier=37, IntegerLiteral=38,
		DecimalLiteral=39, StringLiteral=40, NullLiteral=41, DOT=42, BANG=43,
		SEMICOLON=44, NOTEQUAL=45, EQUAL=46, GT=47, LT=48, LE=49, GE=50, INC=51,
		DEC=52, ADD=53, SUB=54, MUL=55, DIV=56, MOD=57, BITAND=58, BITOR=59, CARET=60,
		LPAREN=61, RPAREN=62, AnyAssign=63, ASSIGN=64, ADD_ASSIGN=65, SUB_ASSIGN=66,
		MUL_ASSIGN=67, DIV_ASSIGN=68, MOD_ASSIGN=69, WS=70, COMMENT=71, LINE_COMMENT=72;
	public static final String[] tokenNames = {
		"<INVALID>", "']'", "'in'", "'endif'", "','", "'\n'", "'Dictionary'",
		"'['", "'endfunction'", "'while'", "'Input'", "'\r'", "'if'", "'List'",
		"'false'", "'until'", "'{'", "'Decimal'", "'PORT'", "'OR'", "'else'",
		"'}'", "'true'", "'Time'", "'elseif'", "'AND'", "'endrepeat'", "'Nothing'",
		"'function'", "'return'", "'Boolean'", "'String'", "'Integer'", "'repeat'",
		"'Output'", "'returns'", "'foreach'", "Identifier", "IntegerLiteral",
		"DecimalLiteral", "StringLiteral", "'null'", "'.'", "'!'", "';'", "'!='",
		"'=='", "'>'", "'<'", "'<='", "'>='", "'++'", "'--'", "'+'", "'-'", "'*'",
		"'/'", "'%'", "'&'", "'|'", "'^'", "'('", "')'", "AnyAssign", "'='", "'+='",
		"'-='", "'*='", "'/='", "'%='", "WS", "COMMENT", "LINE_COMMENT"
	};
	public static final int
		RULE_program = 0, RULE_global = 1, RULE_block = 2, RULE_moreFunctions = 3,
		RULE_function = 4, RULE_funcParameters = 5, RULE_declarationParameters = 6,
		RULE_declarationParameterList = 7, RULE_stmts = 8, RULE_newline = 9, RULE_stmt = 10,
		RULE_incDec = 11, RULE_declaration = 12, RULE_assign = 13, RULE_ifStmt = 14,
		RULE_elseIfStmt = 15, RULE_elseStmt = 16, RULE_loop = 17, RULE_loopWhileOrUntil = 18,
		RULE_loopForeach = 19, RULE_funcCall = 20, RULE_variableMethodCall = 21,
		RULE_returnFunction = 22, RULE_condition = 23, RULE_identifierOrListIndex = 24,
		RULE_expression = 25, RULE_constructClass = 26, RULE_constructClassPort = 27,
		RULE_literal = 28, RULE_booleanLiteral = 29, RULE_collectionInit = 30,
		RULE_type = 31, RULE_primitiveType = 32, RULE_collectionType = 33, RULE_classes = 34,
		RULE_port = 35, RULE_nothing = 36, RULE_logicalOperator = 37;
	public static final String[] ruleNames = {
		"program", "global", "block", "moreFunctions", "function", "funcParameters",
		"declarationParameters", "declarationParameterList", "stmts", "newline",
		"stmt", "incDec", "declaration", "assign", "ifStmt", "elseIfStmt", "elseStmt",
		"loop", "loopWhileOrUntil", "loopForeach", "funcCall", "variableMethodCall",
		"returnFunction", "condition", "identifierOrListIndex", "expression",
		"constructClass", "constructClassPort", "literal", "booleanLiteral", "collectionInit",
		"type", "primitiveType", "collectionType", "classes", "port", "nothing",
		"logicalOperator"
	};

	@Override
	public String getGrammarFileName() { return "Hello.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public HelloParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(HelloParser.EOF, 0); }
		public GlobalContext global() {
			return getRuleContext(GlobalContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76); global();
			setState(77); block();
			setState(78); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GlobalContext extends ParserRuleContext {
		public NewlineContext newline(int i) {
			return getRuleContext(NewlineContext.class,i);
		}
		public GlobalContext global() {
			return getRuleContext(GlobalContext.class,0);
		}
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public List<AssignContext> assign() {
			return getRuleContexts(AssignContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public AssignContext assign(int i) {
			return getRuleContext(AssignContext.class,i);
		}
		public List<NewlineContext> newline() {
			return getRuleContexts(NewlineContext.class);
		}
		public GlobalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_global; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterGlobal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitGlobal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitGlobal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GlobalContext global() throws RecognitionException {
		GlobalContext _localctx = new GlobalContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_global);
		int _la;
		try {
			int _alt;
			setState(107);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 6) | (1L << 10) | (1L << 13) | (1L << 17) | (1L << 23) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 34))) != 0)) {
					{
					{
					setState(80); declaration();
					}
					}
					setState(85);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(87);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(86); newline();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(89);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				} while ( _alt!=2 && _alt!=-1 );
				setState(91); global();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Identifier) {
					{
					{
					setState(93); assign();
					}
					}
					setState(98);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(100);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(99); newline();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(102);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				} while ( _alt!=2 && _alt!=-1 );
				setState(104); global();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public NewlineContext newline(int i) {
			return getRuleContext(NewlineContext.class,i);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public List<NewlineContext> newline() {
			return getRuleContexts(NewlineContext.class);
		}
		public MoreFunctionsContext moreFunctions() {
			return getRuleContext(MoreFunctionsContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_block);
		int _la;
		try {
			setState(118);
			switch (_input.LA(1)) {
			case 28:
				enterOuterAlt(_localctx, 1);
				{
				setState(109); function();
				setState(110); moreFunctions();
				}
				break;
			case EOF:
			case 5:
			case 11:
				enterOuterAlt(_localctx, 2);
				{
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==5 || _la==11) {
					{
					{
					setState(112); newline();
					}
					}
					setState(117);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MoreFunctionsContext extends ParserRuleContext {
		public NewlineContext newline(int i) {
			return getRuleContext(NewlineContext.class,i);
		}
		public List<NewlineContext> newline() {
			return getRuleContexts(NewlineContext.class);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MoreFunctionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moreFunctions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterMoreFunctions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitMoreFunctions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitMoreFunctions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MoreFunctionsContext moreFunctions() throws RecognitionException {
		MoreFunctionsContext _localctx = new MoreFunctionsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_moreFunctions);
		int _la;
		try {
			int _alt;
			setState(133);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(120); newline();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(123);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				} while ( _alt!=2 && _alt!=-1 );
				setState(125); block();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==5 || _la==11) {
					{
					{
					setState(127); newline();
					}
					}
					setState(132);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public NewlineContext newline(int i) {
			return getRuleContext(NewlineContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public DeclarationParametersContext declarationParameters() {
			return getRuleContext(DeclarationParametersContext.class,0);
		}
		public List<NewlineContext> newline() {
			return getRuleContexts(NewlineContext.class);
		}
		public NothingContext nothing() {
			return getRuleContext(NothingContext.class,0);
		}
		public IdentifierOrListIndexContext identifierOrListIndex() {
			return getRuleContext(IdentifierOrListIndexContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_function);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(135); match(28);
			setState(136); identifierOrListIndex();
			setState(137); declarationParameters();
			setState(138); match(35);
			setState(141);
			switch (_input.LA(1)) {
			case 6:
			case 10:
			case 13:
			case 17:
			case 23:
			case 30:
			case 31:
			case 32:
			case 34:
				{
				setState(139); type();
				}
				break;
			case 27:
				{
				setState(140); nothing();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(144);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(143); newline();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(146);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			setState(148); stmts();
			setState(149); match(8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncParametersContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(HelloParser.RPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode LPAREN() { return getToken(HelloParser.LPAREN, 0); }
		public FuncParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterFuncParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitFuncParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitFuncParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncParametersContext funcParameters() throws RecognitionException {
		FuncParametersContext _localctx = new FuncParametersContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_funcParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151); match(LPAREN);
			setState(160);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 10) | (1L << 14) | (1L << 16) | (1L << 22) | (1L << 23) | (1L << 34) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << DecimalLiteral) | (1L << StringLiteral) | (1L << ADD) | (1L << SUB) | (1L << LPAREN))) != 0)) {
				{
				setState(152); expression(0);
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4) {
					{
					{
					setState(153); match(4);
					setState(154); expression(0);
					}
					}
					setState(159);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(162); match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationParametersContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(HelloParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(HelloParser.LPAREN, 0); }
		public DeclarationParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterDeclarationParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitDeclarationParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitDeclarationParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationParametersContext declarationParameters() throws RecognitionException {
		DeclarationParametersContext _localctx = new DeclarationParametersContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_declarationParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164); match(LPAREN);
			setState(173);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 6) | (1L << 10) | (1L << 13) | (1L << 17) | (1L << 23) | (1L << 30) | (1L << 31) | (1L << 32) | (1L << 34))) != 0)) {
				{
				setState(165); declaration();
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4) {
					{
					{
					setState(166); match(4);
					setState(167); declaration();
					}
					}
					setState(172);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(175); match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationParameterListContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public DeclarationParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterDeclarationParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitDeclarationParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitDeclarationParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationParameterListContext declarationParameterList() throws RecognitionException {
		DeclarationParameterListContext _localctx = new DeclarationParameterListContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_declarationParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177); declaration();
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4) {
				{
				{
				setState(178); match(4);
				setState(179); declaration();
				}
				}
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtsContext extends ParserRuleContext {
		public NewlineContext newline(int i) {
			return getRuleContext(NewlineContext.class,i);
		}
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public List<NewlineContext> newline() {
			return getRuleContexts(NewlineContext.class);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public StmtsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmts; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterStmts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitStmts(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitStmts(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtsContext stmts() throws RecognitionException {
		StmtsContext _localctx = new StmtsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_stmts);
		int _la;
		try {
			int _alt;
			setState(199);
			switch (_input.LA(1)) {
			case 6:
			case 10:
			case 12:
			case 13:
			case 17:
			case 23:
			case 29:
			case 30:
			case 31:
			case 32:
			case 33:
			case 34:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(185); stmt();
				setState(187);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(186); newline();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(189);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				} while ( _alt!=2 && _alt!=-1 );
				setState(191); stmts();
				}
				break;
			case 3:
			case 5:
			case 8:
			case 11:
			case 20:
			case 24:
			case 26:
				enterOuterAlt(_localctx, 2);
				{
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==5 || _la==11) {
					{
					{
					setState(193); newline();
					}
					}
					setState(198);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewlineContext extends ParserRuleContext {
		public NewlineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterNewline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitNewline(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitNewline(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewlineContext newline() throws RecognitionException {
		NewlineContext _localctx = new NewlineContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_newline);
		int _la;
		try {
			setState(206);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(202);
				_la = _input.LA(1);
				if (_la==11) {
					{
					setState(201); match(11);
					}
				}

				setState(204); match(5);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(205); match(11);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public IncDecContext incDec() {
			return getRuleContext(IncDecContext.class,0);
		}
		public VariableMethodCallContext variableMethodCall() {
			return getRuleContext(VariableMethodCallContext.class,0);
		}
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public ReturnFunctionContext returnFunction() {
			return getRuleContext(ReturnFunctionContext.class,0);
		}
		public FuncCallContext funcCall() {
			return getRuleContext(FuncCallContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_stmt);
		try {
			setState(216);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(208); declaration();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(209); assign();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(210); ifStmt();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(211); loop();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(212); funcCall();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(213); variableMethodCall();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(214); returnFunction();
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(215); incDec();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IncDecContext extends ParserRuleContext {
		public TerminalNode INC() { return getToken(HelloParser.INC, 0); }
		public TerminalNode DEC() { return getToken(HelloParser.DEC, 0); }
		public IdentifierOrListIndexContext identifierOrListIndex() {
			return getRuleContext(IdentifierOrListIndexContext.class,0);
		}
		public IncDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_incDec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterIncDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitIncDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitIncDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IncDecContext incDec() throws RecognitionException {
		IncDecContext _localctx = new IncDecContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_incDec);
		try {
			setState(224);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(218); identifierOrListIndex();
				setState(219); match(INC);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(221); identifierOrListIndex();
				setState(222); match(DEC);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode AnyAssign() { return getToken(HelloParser.AnyAssign, 0); }
		public IdentifierOrListIndexContext identifierOrListIndex() {
			return getRuleContext(IdentifierOrListIndexContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226); type();
			setState(227); identifierOrListIndex();
			setState(230);
			_la = _input.LA(1);
			if (_la==AnyAssign) {
				{
				setState(228); match(AnyAssign);
				setState(229); expression(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode AnyAssign() { return getToken(HelloParser.AnyAssign, 0); }
		public IdentifierOrListIndexContext identifierOrListIndex() {
			return getRuleContext(IdentifierOrListIndexContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232); identifierOrListIndex();
			setState(233); match(AnyAssign);
			setState(234); expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStmtContext extends ParserRuleContext {
		public NewlineContext newline(int i) {
			return getRuleContext(NewlineContext.class,i);
		}
		public ElseStmtContext elseStmt() {
			return getRuleContext(ElseStmtContext.class,0);
		}
		public ElseIfStmtContext elseIfStmt(int i) {
			return getRuleContext(ElseIfStmtContext.class,i);
		}
		public List<ElseIfStmtContext> elseIfStmt() {
			return getRuleContexts(ElseIfStmtContext.class);
		}
		public TerminalNode RPAREN() { return getToken(HelloParser.RPAREN, 0); }
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public List<NewlineContext> newline() {
			return getRuleContexts(NewlineContext.class);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(HelloParser.LPAREN, 0); }
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_ifStmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(236); match(12);
			setState(237); match(LPAREN);
			setState(238); expression(0);
			setState(239); match(RPAREN);
			setState(241);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(240); newline();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(243);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			setState(245); stmts();
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==24) {
				{
				{
				setState(246); elseIfStmt();
				}
				}
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(253);
			_la = _input.LA(1);
			if (_la==20) {
				{
				setState(252); elseStmt();
				}
			}

			setState(255); match(3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseIfStmtContext extends ParserRuleContext {
		public NewlineContext newline(int i) {
			return getRuleContext(NewlineContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(HelloParser.RPAREN, 0); }
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public List<NewlineContext> newline() {
			return getRuleContexts(NewlineContext.class);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(HelloParser.LPAREN, 0); }
		public ElseIfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseIfStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterElseIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitElseIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitElseIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseIfStmtContext elseIfStmt() throws RecognitionException {
		ElseIfStmtContext _localctx = new ElseIfStmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_elseIfStmt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(257); match(24);
			setState(258); match(LPAREN);
			setState(259); expression(0);
			setState(260); match(RPAREN);
			setState(262);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(261); newline();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(264);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			setState(266); stmts();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseStmtContext extends ParserRuleContext {
		public NewlineContext newline(int i) {
			return getRuleContext(NewlineContext.class,i);
		}
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public List<NewlineContext> newline() {
			return getRuleContexts(NewlineContext.class);
		}
		public ElseStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterElseStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitElseStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitElseStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStmtContext elseStmt() throws RecognitionException {
		ElseStmtContext _localctx = new ElseStmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_elseStmt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(268); match(20);
			setState(270);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(269); newline();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(272);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			setState(275);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(274); stmts();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoopContext extends ParserRuleContext {
		public LoopForeachContext loopForeach() {
			return getRuleContext(LoopForeachContext.class,0);
		}
		public LoopWhileOrUntilContext loopWhileOrUntil() {
			return getRuleContext(LoopWhileOrUntilContext.class,0);
		}
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_loop);
		try {
			setState(279);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(277); loopWhileOrUntil();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(278); loopForeach();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoopWhileOrUntilContext extends ParserRuleContext {
		public NewlineContext newline(int i) {
			return getRuleContext(NewlineContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(HelloParser.RPAREN, 0); }
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public List<NewlineContext> newline() {
			return getRuleContexts(NewlineContext.class);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(HelloParser.LPAREN, 0); }
		public LoopWhileOrUntilContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopWhileOrUntil; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterLoopWhileOrUntil(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitLoopWhileOrUntil(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitLoopWhileOrUntil(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopWhileOrUntilContext loopWhileOrUntil() throws RecognitionException {
		LoopWhileOrUntilContext _localctx = new LoopWhileOrUntilContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_loopWhileOrUntil);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(281); match(33);
			setState(282);
			_la = _input.LA(1);
			if ( !(_la==9 || _la==15) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(283); match(LPAREN);
			setState(284); expression(0);
			setState(285); match(RPAREN);
			setState(287);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(286); newline();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(289);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			setState(291); stmts();
			setState(292); match(26);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoopForeachContext extends ParserRuleContext {
		public NewlineContext newline(int i) {
			return getRuleContext(NewlineContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(HelloParser.RPAREN, 0); }
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<NewlineContext> newline() {
			return getRuleContexts(NewlineContext.class);
		}
		public IdentifierOrListIndexContext identifierOrListIndex(int i) {
			return getRuleContext(IdentifierOrListIndexContext.class,i);
		}
		public List<IdentifierOrListIndexContext> identifierOrListIndex() {
			return getRuleContexts(IdentifierOrListIndexContext.class);
		}
		public TerminalNode LPAREN() { return getToken(HelloParser.LPAREN, 0); }
		public LoopForeachContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopForeach; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterLoopForeach(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitLoopForeach(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitLoopForeach(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopForeachContext loopForeach() throws RecognitionException {
		LoopForeachContext _localctx = new LoopForeachContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_loopForeach);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(294); match(33);
			setState(295); match(36);
			setState(296); match(LPAREN);
			setState(297); type();
			setState(298); identifierOrListIndex();
			setState(299); match(2);
			setState(300); identifierOrListIndex();
			setState(301); match(RPAREN);
			setState(303);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(302); newline();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(305);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			setState(307); stmts();
			setState(308); match(26);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncCallContext extends ParserRuleContext {
		public FuncParametersContext funcParameters() {
			return getRuleContext(FuncParametersContext.class,0);
		}
		public IdentifierOrListIndexContext identifierOrListIndex() {
			return getRuleContext(IdentifierOrListIndexContext.class,0);
		}
		public FuncCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterFuncCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitFuncCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitFuncCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncCallContext funcCall() throws RecognitionException {
		FuncCallContext _localctx = new FuncCallContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_funcCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310); identifierOrListIndex();
			setState(311); funcParameters();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableMethodCallContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(HelloParser.DOT, 0); }
		public IdentifierOrListIndexContext identifierOrListIndex() {
			return getRuleContext(IdentifierOrListIndexContext.class,0);
		}
		public FuncCallContext funcCall() {
			return getRuleContext(FuncCallContext.class,0);
		}
		public VariableMethodCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableMethodCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterVariableMethodCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitVariableMethodCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitVariableMethodCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableMethodCallContext variableMethodCall() throws RecognitionException {
		VariableMethodCallContext _localctx = new VariableMethodCallContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_variableMethodCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313); identifierOrListIndex();
			setState(314); match(DOT);
			setState(315); funcCall();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnFunctionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterReturnFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitReturnFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitReturnFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnFunctionContext returnFunction() throws RecognitionException {
		ReturnFunctionContext _localctx = new ReturnFunctionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_returnFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317); match(29);
			setState(319);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 10) | (1L << 14) | (1L << 16) | (1L << 22) | (1L << 23) | (1L << 34) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << DecimalLiteral) | (1L << StringLiteral) | (1L << ADD) | (1L << SUB) | (1L << LPAREN))) != 0)) {
				{
				setState(318); expression(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public LogicalOperatorContext logicalOperator() {
			return getRuleContext(LogicalOperatorContext.class,0);
		}
		public IdentifierOrListIndexContext identifierOrListIndex(int i) {
			return getRuleContext(IdentifierOrListIndexContext.class,i);
		}
		public List<IdentifierOrListIndexContext> identifierOrListIndex() {
			return getRuleContexts(IdentifierOrListIndexContext.class);
		}
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(321); identifierOrListIndex();
				}
				break;
			case 14:
			case 22:
			case IntegerLiteral:
			case DecimalLiteral:
			case StringLiteral:
				{
				setState(322); literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(325); logicalOperator();
			setState(328);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(326); identifierOrListIndex();
				}
				break;
			case 14:
			case 22:
			case IntegerLiteral:
			case DecimalLiteral:
			case StringLiteral:
				{
				setState(327); literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierOrListIndexContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(HelloParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IdentifierOrListIndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierOrListIndex; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterIdentifierOrListIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitIdentifierOrListIndex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitIdentifierOrListIndex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierOrListIndexContext identifierOrListIndex() throws RecognitionException {
		IdentifierOrListIndexContext _localctx = new IdentifierOrListIndexContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_identifierOrListIndex);
		try {
			setState(336);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(330); match(Identifier);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(331); match(Identifier);
				setState(332); match(7);
				setState(333); expression(0);
				setState(334); match(1);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public LogicalOperatorContext logicalOperator() {
			return getRuleContext(LogicalOperatorContext.class,0);
		}
		public VariableMethodCallContext variableMethodCall() {
			return getRuleContext(VariableMethodCallContext.class,0);
		}
		public ConstructClassContext constructClass() {
			return getRuleContext(ConstructClassContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(HelloParser.RPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public IdentifierOrListIndexContext identifierOrListIndex() {
			return getRuleContext(IdentifierOrListIndexContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(HelloParser.LPAREN, 0); }
		public FuncCallContext funcCall() {
			return getRuleContext(FuncCallContext.class,0);
		}
		public CollectionInitContext collectionInit() {
			return getRuleContext(CollectionInitContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(351);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(339);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUB) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(340); expression(9);
				}
				break;

			case 2:
				{
				setState(341); funcCall();
				}
				break;

			case 3:
				{
				setState(342); literal();
				}
				break;

			case 4:
				{
				setState(343); collectionInit();
				}
				break;

			case 5:
				{
				setState(344); constructClass();
				}
				break;

			case 6:
				{
				setState(345); variableMethodCall();
				}
				break;

			case 7:
				{
				setState(346); identifierOrListIndex();
				}
				break;

			case 8:
				{
				setState(347); match(LPAREN);
				setState(348); expression(0);
				setState(349); match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(365);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(363);
					switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(353);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(354);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(355); expression(12);
						}
						break;

					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(356);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(357);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(358); expression(11);
						}
						break;

					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(359);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(360); logicalOperator();
						setState(361); expression(9);
						}
						break;
					}
					} 
				}
				setState(367);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ConstructClassContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(HelloParser.RPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ConstructClassPortContext constructClassPort() {
			return getRuleContext(ConstructClassPortContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(HelloParser.LPAREN, 0); }
		public ClassesContext classes() {
			return getRuleContext(ClassesContext.class,0);
		}
		public ConstructClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterConstructClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitConstructClass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitConstructClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructClassContext constructClass() throws RecognitionException {
		ConstructClassContext _localctx = new ConstructClassContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_constructClass);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(368); classes();
			setState(369); match(LPAREN);
			setState(381);
			switch (_input.LA(1)) {
			case 4:
			case 10:
			case 14:
			case 16:
			case 22:
			case 23:
			case 34:
			case Identifier:
			case IntegerLiteral:
			case DecimalLiteral:
			case StringLiteral:
			case ADD:
			case SUB:
			case LPAREN:
			case RPAREN:
				{
				{
				setState(371);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 10) | (1L << 14) | (1L << 16) | (1L << 22) | (1L << 23) | (1L << 34) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << DecimalLiteral) | (1L << StringLiteral) | (1L << ADD) | (1L << SUB) | (1L << LPAREN))) != 0)) {
					{
					setState(370); expression(0);
					}
				}

				setState(377);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4) {
					{
					{
					setState(373); match(4);
					setState(374); expression(0);
					}
					}
					setState(379);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case 18:
				{
				setState(380); constructClassPort();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(383); match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructClassPortContext extends ParserRuleContext {
		public PortContext port() {
			return getRuleContext(PortContext.class,0);
		}
		public TerminalNode IntegerLiteral() { return getToken(HelloParser.IntegerLiteral, 0); }
		public ConstructClassPortContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructClassPort; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterConstructClassPort(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitConstructClassPort(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitConstructClassPort(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructClassPortContext constructClassPort() throws RecognitionException {
		ConstructClassPortContext _localctx = new ConstructClassPortContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_constructClassPort);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(385); port();
			setState(386); match(IntegerLiteral);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode IntegerLiteral() { return getToken(HelloParser.IntegerLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(HelloParser.StringLiteral, 0); }
		public TerminalNode DecimalLiteral() { return getToken(HelloParser.DecimalLiteral, 0); }
		public BooleanLiteralContext booleanLiteral() {
			return getRuleContext(BooleanLiteralContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_literal);
		try {
			setState(392);
			switch (_input.LA(1)) {
			case 14:
			case 22:
				enterOuterAlt(_localctx, 1);
				{
				setState(388); booleanLiteral();
				}
				break;
			case DecimalLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(389); match(DecimalLiteral);
				}
				break;
			case IntegerLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(390); match(IntegerLiteral);
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 4);
				{
				setState(391); match(StringLiteral);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanLiteralContext extends ParserRuleContext {
		public BooleanLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterBooleanLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitBooleanLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitBooleanLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanLiteralContext booleanLiteral() throws RecognitionException {
		BooleanLiteralContext _localctx = new BooleanLiteralContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(394);
			_la = _input.LA(1);
			if ( !(_la==14 || _la==22) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CollectionInitContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public CollectionInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_collectionInit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterCollectionInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitCollectionInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitCollectionInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CollectionInitContext collectionInit() throws RecognitionException {
		CollectionInitContext _localctx = new CollectionInitContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_collectionInit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(396); match(16);
			setState(405);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 10) | (1L << 14) | (1L << 16) | (1L << 22) | (1L << 23) | (1L << 34) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << DecimalLiteral) | (1L << StringLiteral) | (1L << ADD) | (1L << SUB) | (1L << LPAREN))) != 0)) {
				{
				setState(397); expression(0);
				setState(402);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4) {
					{
					{
					setState(398); match(4);
					setState(399); expression(0);
					}
					}
					setState(404);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(407); match(21);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public CollectionTypeContext collectionType() {
			return getRuleContext(CollectionTypeContext.class,0);
		}
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public ClassesContext classes() {
			return getRuleContext(ClassesContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_type);
		try {
			setState(412);
			switch (_input.LA(1)) {
			case 17:
			case 30:
			case 31:
			case 32:
				enterOuterAlt(_localctx, 1);
				{
				setState(409); primitiveType();
				}
				break;
			case 6:
			case 13:
				enterOuterAlt(_localctx, 2);
				{
				setState(410); collectionType();
				}
				break;
			case 10:
			case 23:
			case 34:
				enterOuterAlt(_localctx, 3);
				{
				setState(411); classes();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimitiveTypeContext extends ParserRuleContext {
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitPrimitiveType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitPrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(414);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 17) | (1L << 30) | (1L << 31) | (1L << 32))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CollectionTypeContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public CollectionTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_collectionType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterCollectionType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitCollectionType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitCollectionType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CollectionTypeContext collectionType() throws RecognitionException {
		CollectionTypeContext _localctx = new CollectionTypeContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_collectionType);
		try {
			setState(426);
			switch (_input.LA(1)) {
			case 13:
				enterOuterAlt(_localctx, 1);
				{
				setState(416); match(13);
				setState(417); match(LT);
				setState(418); type();
				setState(419); match(GT);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 2);
				{
				setState(421); match(6);
				setState(422); match(LT);
				setState(423); type();
				setState(424); match(GT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassesContext extends ParserRuleContext {
		public ClassesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterClasses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitClasses(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitClasses(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassesContext classes() throws RecognitionException {
		ClassesContext _localctx = new ClassesContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_classes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(428);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 10) | (1L << 23) | (1L << 34))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PortContext extends ParserRuleContext {
		public PortContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_port; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterPort(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitPort(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitPort(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PortContext port() throws RecognitionException {
		PortContext _localctx = new PortContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_port);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(430); match(18);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NothingContext extends ParserRuleContext {
		public NothingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nothing; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterNothing(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitNothing(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitNothing(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NothingContext nothing() throws RecognitionException {
		NothingContext _localctx = new NothingContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_nothing);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(432); match(27);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogicalOperatorContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(HelloParser.LT, 0); }
		public TerminalNode LE() { return getToken(HelloParser.LE, 0); }
		public TerminalNode EQUAL() { return getToken(HelloParser.EQUAL, 0); }
		public TerminalNode GT() { return getToken(HelloParser.GT, 0); }
		public TerminalNode NOTEQUAL() { return getToken(HelloParser.NOTEQUAL, 0); }
		public TerminalNode GE() { return getToken(HelloParser.GE, 0); }
		public LogicalOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterLogicalOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitLogicalOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitLogicalOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalOperatorContext logicalOperator() throws RecognitionException {
		LogicalOperatorContext _localctx = new LogicalOperatorContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_logicalOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(434);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 19) | (1L << 25) | (1L << NOTEQUAL) | (1L << EQUAL) | (1L << GT) | (1L << LT) | (1L << LE) | (1L << GE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 25: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 11);

		case 1: return precpred(_ctx, 10);

		case 2: return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3J\u01b7\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\3\2\3\2\3\2\3\3\7\3T\n"+
		"\3\f\3\16\3W\13\3\3\3\6\3Z\n\3\r\3\16\3[\3\3\3\3\3\3\7\3a\n\3\f\3\16\3"+
		"d\13\3\3\3\6\3g\n\3\r\3\16\3h\3\3\3\3\3\3\5\3n\n\3\3\4\3\4\3\4\3\4\7\4"+
		"t\n\4\f\4\16\4w\13\4\5\4y\n\4\3\5\6\5|\n\5\r\5\16\5}\3\5\3\5\3\5\7\5\u0083"+
		"\n\5\f\5\16\5\u0086\13\5\5\5\u0088\n\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u0090"+
		"\n\6\3\6\6\6\u0093\n\6\r\6\16\6\u0094\3\6\3\6\3\6\3\7\3\7\3\7\3\7\7\7"+
		"\u009e\n\7\f\7\16\7\u00a1\13\7\5\7\u00a3\n\7\3\7\3\7\3\b\3\b\3\b\3\b\7"+
		"\b\u00ab\n\b\f\b\16\b\u00ae\13\b\5\b\u00b0\n\b\3\b\3\b\3\t\3\t\3\t\7\t"+
		"\u00b7\n\t\f\t\16\t\u00ba\13\t\3\n\3\n\6\n\u00be\n\n\r\n\16\n\u00bf\3"+
		"\n\3\n\3\n\7\n\u00c5\n\n\f\n\16\n\u00c8\13\n\5\n\u00ca\n\n\3\13\5\13\u00cd"+
		"\n\13\3\13\3\13\5\13\u00d1\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00db"+
		"\n\f\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00e3\n\r\3\16\3\16\3\16\3\16\5\16\u00e9"+
		"\n\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\6\20\u00f4\n\20\r\20"+
		"\16\20\u00f5\3\20\3\20\7\20\u00fa\n\20\f\20\16\20\u00fd\13\20\3\20\5\20"+
		"\u0100\n\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\6\21\u0109\n\21\r\21\16"+
		"\21\u010a\3\21\3\21\3\22\3\22\6\22\u0111\n\22\r\22\16\22\u0112\3\22\5"+
		"\22\u0116\n\22\3\23\3\23\5\23\u011a\n\23\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\6\24\u0122\n\24\r\24\16\24\u0123\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\6\25\u0132\n\25\r\25\16\25\u0133\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\5\30\u0142\n\30\3\31\3\31"+
		"\5\31\u0146\n\31\3\31\3\31\3\31\5\31\u014b\n\31\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\5\32\u0153\n\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\5\33\u0162\n\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\7\33\u016e\n\33\f\33\16\33\u0171\13\33\3\34\3\34\3\34"+
		"\5\34\u0176\n\34\3\34\3\34\7\34\u017a\n\34\f\34\16\34\u017d\13\34\3\34"+
		"\5\34\u0180\n\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\36\5\36\u018b"+
		"\n\36\3\37\3\37\3 \3 \3 \3 \7 \u0193\n \f \16 \u0196\13 \5 \u0198\n \3"+
		" \3 \3!\3!\3!\5!\u019f\n!\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\5#\u01ad"+
		"\n#\3$\3$\3%\3%\3&\3&\3\'\3\'\3\'\2\3\64(\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJL\2\t\4\2\13\13\21\21\3\2\678"+
		"\3\29;\4\2\20\20\30\30\4\2\23\23 \"\5\2\f\f\31\31$$\5\2\25\25\33\33/\64"+
		"\u01d2\2N\3\2\2\2\4m\3\2\2\2\6x\3\2\2\2\b\u0087\3\2\2\2\n\u0089\3\2\2"+
		"\2\f\u0099\3\2\2\2\16\u00a6\3\2\2\2\20\u00b3\3\2\2\2\22\u00c9\3\2\2\2"+
		"\24\u00d0\3\2\2\2\26\u00da\3\2\2\2\30\u00e2\3\2\2\2\32\u00e4\3\2\2\2\34"+
		"\u00ea\3\2\2\2\36\u00ee\3\2\2\2 \u0103\3\2\2\2\"\u010e\3\2\2\2$\u0119"+
		"\3\2\2\2&\u011b\3\2\2\2(\u0128\3\2\2\2*\u0138\3\2\2\2,\u013b\3\2\2\2."+
		"\u013f\3\2\2\2\60\u0145\3\2\2\2\62\u0152\3\2\2\2\64\u0161\3\2\2\2\66\u0172"+
		"\3\2\2\28\u0183\3\2\2\2:\u018a\3\2\2\2<\u018c\3\2\2\2>\u018e\3\2\2\2@"+
		"\u019e\3\2\2\2B\u01a0\3\2\2\2D\u01ac\3\2\2\2F\u01ae\3\2\2\2H\u01b0\3\2"+
		"\2\2J\u01b2\3\2\2\2L\u01b4\3\2\2\2NO\5\4\3\2OP\5\6\4\2PQ\7\2\2\3Q\3\3"+
		"\2\2\2RT\5\32\16\2SR\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2VY\3\2\2\2W"+
		"U\3\2\2\2XZ\5\24\13\2YX\3\2\2\2Z[\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\]\3\2"+
		"\2\2]^\5\4\3\2^n\3\2\2\2_a\5\34\17\2`_\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3"+
		"\2\2\2cf\3\2\2\2db\3\2\2\2eg\5\24\13\2fe\3\2\2\2gh\3\2\2\2hf\3\2\2\2h"+
		"i\3\2\2\2ij\3\2\2\2jk\5\4\3\2kn\3\2\2\2ln\3\2\2\2mU\3\2\2\2mb\3\2\2\2"+
		"ml\3\2\2\2n\5\3\2\2\2op\5\n\6\2pq\5\b\5\2qy\3\2\2\2rt\5\24\13\2sr\3\2"+
		"\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2vy\3\2\2\2wu\3\2\2\2xo\3\2\2\2xu\3\2"+
		"\2\2y\7\3\2\2\2z|\5\24\13\2{z\3\2\2\2|}\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\177"+
		"\3\2\2\2\177\u0080\5\6\4\2\u0080\u0088\3\2\2\2\u0081\u0083\5\24\13\2\u0082"+
		"\u0081\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2"+
		"\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0087{\3\2\2\2\u0087\u0084"+
		"\3\2\2\2\u0088\t\3\2\2\2\u0089\u008a\7\36\2\2\u008a\u008b\5\62\32\2\u008b"+
		"\u008c\5\16\b\2\u008c\u008f\7%\2\2\u008d\u0090\5@!\2\u008e\u0090\5J&\2"+
		"\u008f\u008d\3\2\2\2\u008f\u008e\3\2\2\2\u0090\u0092\3\2\2\2\u0091\u0093"+
		"\5\24\13\2\u0092\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0092\3\2\2\2"+
		"\u0094\u0095\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097\5\22\n\2\u0097\u0098"+
		"\7\n\2\2\u0098\13\3\2\2\2\u0099\u00a2\7?\2\2\u009a\u009f\5\64\33\2\u009b"+
		"\u009c\7\6\2\2\u009c\u009e\5\64\33\2\u009d\u009b\3\2\2\2\u009e\u00a1\3"+
		"\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1"+
		"\u009f\3\2\2\2\u00a2\u009a\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\3\2"+
		"\2\2\u00a4\u00a5\7@\2\2\u00a5\r\3\2\2\2\u00a6\u00af\7?\2\2\u00a7\u00ac"+
		"\5\32\16\2\u00a8\u00a9\7\6\2\2\u00a9\u00ab\5\32\16\2\u00aa\u00a8\3\2\2"+
		"\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00b0"+
		"\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00a7\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0"+
		"\u00b1\3\2\2\2\u00b1\u00b2\7@\2\2\u00b2\17\3\2\2\2\u00b3\u00b8\5\32\16"+
		"\2\u00b4\u00b5\7\6\2\2\u00b5\u00b7\5\32\16\2\u00b6\u00b4\3\2\2\2\u00b7"+
		"\u00ba\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\21\3\2\2"+
		"\2\u00ba\u00b8\3\2\2\2\u00bb\u00bd\5\26\f\2\u00bc\u00be\5\24\13\2\u00bd"+
		"\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2"+
		"\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\5\22\n\2\u00c2\u00ca\3\2\2\2\u00c3"+
		"\u00c5\5\24\13\2\u00c4\u00c3\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4\3"+
		"\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9"+
		"\u00bb\3\2\2\2\u00c9\u00c6\3\2\2\2\u00ca\23\3\2\2\2\u00cb\u00cd\7\r\2"+
		"\2\u00cc\u00cb\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00d1"+
		"\7\7\2\2\u00cf\u00d1\7\r\2\2\u00d0\u00cc\3\2\2\2\u00d0\u00cf\3\2\2\2\u00d1"+
		"\25\3\2\2\2\u00d2\u00db\5\32\16\2\u00d3\u00db\5\34\17\2\u00d4\u00db\5"+
		"\36\20\2\u00d5\u00db\5$\23\2\u00d6\u00db\5*\26\2\u00d7\u00db\5,\27\2\u00d8"+
		"\u00db\5.\30\2\u00d9\u00db\5\30\r\2\u00da\u00d2\3\2\2\2\u00da\u00d3\3"+
		"\2\2\2\u00da\u00d4\3\2\2\2\u00da\u00d5\3\2\2\2\u00da\u00d6\3\2\2\2\u00da"+
		"\u00d7\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00d9\3\2\2\2\u00db\27\3\2\2"+
		"\2\u00dc\u00dd\5\62\32\2\u00dd\u00de\7\65\2\2\u00de\u00e3\3\2\2\2\u00df"+
		"\u00e0\5\62\32\2\u00e0\u00e1\7\66\2\2\u00e1\u00e3\3\2\2\2\u00e2\u00dc"+
		"\3\2\2\2\u00e2\u00df\3\2\2\2\u00e3\31\3\2\2\2\u00e4\u00e5\5@!\2\u00e5"+
		"\u00e8\5\62\32\2\u00e6\u00e7\7A\2\2\u00e7\u00e9\5\64\33\2\u00e8\u00e6"+
		"\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\33\3\2\2\2\u00ea\u00eb\5\62\32\2\u00eb"+
		"\u00ec\7A\2\2\u00ec\u00ed\5\64\33\2\u00ed\35\3\2\2\2\u00ee\u00ef\7\16"+
		"\2\2\u00ef\u00f0\7?\2\2\u00f0\u00f1\5\64\33\2\u00f1\u00f3\7@\2\2\u00f2"+
		"\u00f4\5\24\13\2\u00f3\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f3\3"+
		"\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00fb\5\22\n\2\u00f8"+
		"\u00fa\5 \21\2\u00f9\u00f8\3\2\2\2\u00fa\u00fd\3\2\2\2\u00fb\u00f9\3\2"+
		"\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00ff\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fe"+
		"\u0100\5\"\22\2\u00ff\u00fe\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0101\3"+
		"\2\2\2\u0101\u0102\7\5\2\2\u0102\37\3\2\2\2\u0103\u0104\7\32\2\2\u0104"+
		"\u0105\7?\2\2\u0105\u0106\5\64\33\2\u0106\u0108\7@\2\2\u0107\u0109\5\24"+
		"\13\2\u0108\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u0108\3\2\2\2\u010a"+
		"\u010b\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010d\5\22\n\2\u010d!\3\2\2\2"+
		"\u010e\u0110\7\26\2\2\u010f\u0111\5\24\13\2\u0110\u010f\3\2\2\2\u0111"+
		"\u0112\3\2\2\2\u0112\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0115\3\2"+
		"\2\2\u0114\u0116\5\22\n\2\u0115\u0114\3\2\2\2\u0115\u0116\3\2\2\2\u0116"+
		"#\3\2\2\2\u0117\u011a\5&\24\2\u0118\u011a\5(\25\2\u0119\u0117\3\2\2\2"+
		"\u0119\u0118\3\2\2\2\u011a%\3\2\2\2\u011b\u011c\7#\2\2\u011c\u011d\t\2"+
		"\2\2\u011d\u011e\7?\2\2\u011e\u011f\5\64\33\2\u011f\u0121\7@\2\2\u0120"+
		"\u0122\5\24\13\2\u0121\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0121\3"+
		"\2\2\2\u0123\u0124\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0126\5\22\n\2\u0126"+
		"\u0127\7\34\2\2\u0127\'\3\2\2\2\u0128\u0129\7#\2\2\u0129\u012a\7&\2\2"+
		"\u012a\u012b\7?\2\2\u012b\u012c\5@!\2\u012c\u012d\5\62\32\2\u012d\u012e"+
		"\7\4\2\2\u012e\u012f\5\62\32\2\u012f\u0131\7@\2\2\u0130\u0132\5\24\13"+
		"\2\u0131\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0131\3\2\2\2\u0133\u0134"+
		"\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0136\5\22\n\2\u0136\u0137\7\34\2\2"+
		"\u0137)\3\2\2\2\u0138\u0139\5\62\32\2\u0139\u013a\5\f\7\2\u013a+\3\2\2"+
		"\2\u013b\u013c\5\62\32\2\u013c\u013d\7,\2\2\u013d\u013e\5*\26\2\u013e"+
		"-\3\2\2\2\u013f\u0141\7\37\2\2\u0140\u0142\5\64\33\2\u0141\u0140\3\2\2"+
		"\2\u0141\u0142\3\2\2\2\u0142/\3\2\2\2\u0143\u0146\5\62\32\2\u0144\u0146"+
		"\5:\36\2\u0145\u0143\3\2\2\2\u0145\u0144\3\2\2\2\u0146\u0147\3\2\2\2\u0147"+
		"\u014a\5L\'\2\u0148\u014b\5\62\32\2\u0149\u014b\5:\36\2\u014a\u0148\3"+
		"\2\2\2\u014a\u0149\3\2\2\2\u014b\61\3\2\2\2\u014c\u0153\7\'\2\2\u014d"+
		"\u014e\7\'\2\2\u014e\u014f\7\t\2\2\u014f\u0150\5\64\33\2\u0150\u0151\7"+
		"\3\2\2\u0151\u0153\3\2\2\2\u0152\u014c\3\2\2\2\u0152\u014d\3\2\2\2\u0153"+
		"\63\3\2\2\2\u0154\u0155\b\33\1\2\u0155\u0156\t\3\2\2\u0156\u0162\5\64"+
		"\33\13\u0157\u0162\5*\26\2\u0158\u0162\5:\36\2\u0159\u0162\5> \2\u015a"+
		"\u0162\5\66\34\2\u015b\u0162\5,\27\2\u015c\u0162\5\62\32\2\u015d\u015e"+
		"\7?\2\2\u015e\u015f\5\64\33\2\u015f\u0160\7@\2\2\u0160\u0162\3\2\2\2\u0161"+
		"\u0154\3\2\2\2\u0161\u0157\3\2\2\2\u0161\u0158\3\2\2\2\u0161\u0159\3\2"+
		"\2\2\u0161\u015a\3\2\2\2\u0161\u015b\3\2\2\2\u0161\u015c\3\2\2\2\u0161"+
		"\u015d\3\2\2\2\u0162\u016f\3\2\2\2\u0163\u0164\f\r\2\2\u0164\u0165\t\4"+
		"\2\2\u0165\u016e\5\64\33\16\u0166\u0167\f\f\2\2\u0167\u0168\t\3\2\2\u0168"+
		"\u016e\5\64\33\r\u0169\u016a\f\n\2\2\u016a\u016b\5L\'\2\u016b\u016c\5"+
		"\64\33\13\u016c\u016e\3\2\2\2\u016d\u0163\3\2\2\2\u016d\u0166\3\2\2\2"+
		"\u016d\u0169\3\2\2\2\u016e\u0171\3\2\2\2\u016f\u016d\3\2\2\2\u016f\u0170"+
		"\3\2\2\2\u0170\65\3\2\2\2\u0171\u016f\3\2\2\2\u0172\u0173\5F$\2\u0173"+
		"\u017f\7?\2\2\u0174\u0176\5\64\33\2\u0175\u0174\3\2\2\2\u0175\u0176\3"+
		"\2\2\2\u0176\u017b\3\2\2\2\u0177\u0178\7\6\2\2\u0178\u017a\5\64\33\2\u0179"+
		"\u0177\3\2\2\2\u017a\u017d\3\2\2\2\u017b\u0179\3\2\2\2\u017b\u017c\3\2"+
		"\2\2\u017c\u0180\3\2\2\2\u017d\u017b\3\2\2\2\u017e\u0180\58\35\2\u017f"+
		"\u0175\3\2\2\2\u017f\u017e\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u0182\7@"+
		"\2\2\u0182\67\3\2\2\2\u0183\u0184\5H%\2\u0184\u0185\7(\2\2\u01859\3\2"+
		"\2\2\u0186\u018b\5<\37\2\u0187\u018b\7)\2\2\u0188\u018b\7(\2\2\u0189\u018b"+
		"\7*\2\2\u018a\u0186\3\2\2\2\u018a\u0187\3\2\2\2\u018a\u0188\3\2\2\2\u018a"+
		"\u0189\3\2\2\2\u018b;\3\2\2\2\u018c\u018d\t\5\2\2\u018d=\3\2\2\2\u018e"+
		"\u0197\7\22\2\2\u018f\u0194\5\64\33\2\u0190\u0191\7\6\2\2\u0191\u0193"+
		"\5\64\33\2\u0192\u0190\3\2\2\2\u0193\u0196\3\2\2\2\u0194\u0192\3\2\2\2"+
		"\u0194\u0195\3\2\2\2\u0195\u0198\3\2\2\2\u0196\u0194\3\2\2\2\u0197\u018f"+
		"\3\2\2\2\u0197\u0198\3\2\2\2\u0198\u0199\3\2\2\2\u0199\u019a\7\27\2\2"+
		"\u019a?\3\2\2\2\u019b\u019f\5B\"\2\u019c\u019f\5D#\2\u019d\u019f\5F$\2"+
		"\u019e\u019b\3\2\2\2\u019e\u019c\3\2\2\2\u019e\u019d\3\2\2\2\u019fA\3"+
		"\2\2\2\u01a0\u01a1\t\6\2\2\u01a1C\3\2\2\2\u01a2\u01a3\7\17\2\2\u01a3\u01a4"+
		"\7\62\2\2\u01a4\u01a5\5@!\2\u01a5\u01a6\7\61\2\2\u01a6\u01ad\3\2\2\2\u01a7"+
		"\u01a8\7\b\2\2\u01a8\u01a9\7\62\2\2\u01a9\u01aa\5@!\2\u01aa\u01ab\7\61"+
		"\2\2\u01ab\u01ad\3\2\2\2\u01ac\u01a2\3\2\2\2\u01ac\u01a7\3\2\2\2\u01ad"+
		"E\3\2\2\2\u01ae\u01af\t\7\2\2\u01afG\3\2\2\2\u01b0\u01b1\7\24\2\2\u01b1"+
		"I\3\2\2\2\u01b2\u01b3\7\35\2\2\u01b3K\3\2\2\2\u01b4\u01b5\t\b\2\2\u01b5"+
		"M\3\2\2\2\63U[bhmux}\u0084\u0087\u008f\u0094\u009f\u00a2\u00ac\u00af\u00b8"+
		"\u00bf\u00c6\u00c9\u00cc\u00d0\u00da\u00e2\u00e8\u00f5\u00fb\u00ff\u010a"+
		"\u0112\u0115\u0119\u0123\u0133\u0141\u0145\u014a\u0152\u0161\u016d\u016f"+
		"\u0175\u017b\u017f\u018a\u0194\u0197\u019e\u01ac";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}