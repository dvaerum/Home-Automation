// Generated from HOME.g4 by ANTLR 4.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HOMEParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__33=1, T__32=2, T__31=3, T__30=4, T__29=5, T__28=6, T__27=7, T__26=8, 
		T__25=9, T__24=10, T__23=11, T__22=12, T__21=13, T__20=14, T__19=15, T__18=16, 
		T__17=17, T__16=18, T__15=19, T__14=20, T__13=21, T__12=22, T__11=23, 
		T__10=24, T__9=25, T__8=26, T__7=27, T__6=28, T__5=29, T__4=30, T__3=31, 
		T__2=32, T__1=33, T__0=34, Newline=35, Identifier=36, IntegerLiteral=37, 
		DecimalLiteral=38, StringLiteral=39, NullLiteral=40, DOT=41, BANG=42, 
		NOTEQUAL=43, EQUAL=44, GT=45, LT=46, LE=47, GE=48, INC=49, DEC=50, ADD=51, 
		SUB=52, MUL=53, DIV=54, MOD=55, BITAND=56, BITOR=57, CARET=58, LPAREN=59, 
		RPAREN=60, AnyAssign=61, ASSIGN=62, ADD_ASSIGN=63, SUB_ASSIGN=64, MUL_ASSIGN=65, 
		DIV_ASSIGN=66, MOD_ASSIGN=67, WS=68, COMMENT=69, LINE_COMMENT=70;
	public static final String[] tokenNames = {
		"<INVALID>", "']'", "'in'", "'endif'", "','", "'Dictionary'", "'['", "'endfunction'", 
		"'while'", "'Input'", "'if'", "'List'", "'false'", "'until'", "'{'", "'Decimal'", 
		"'PORT'", "'OR'", "'else'", "'}'", "'true'", "'Time'", "'elseif'", "'AND'", 
		"'endrepeat'", "'Nothing'", "'function'", "'return'", "'Boolean'", "'String'", 
		"'Integer'", "'repeat'", "'Output'", "'returns'", "'foreach'", "Newline", 
		"Identifier", "IntegerLiteral", "DecimalLiteral", "StringLiteral", "'null'", 
		"'.'", "'!'", "'!='", "'=='", "'>'", "'<'", "'<='", "'>='", "'++'", "'--'", 
		"'+'", "'-'", "'*'", "'/'", "'%'", "'&'", "'|'", "'^'", "'('", "')'", 
		"AnyAssign", "'='", "'+='", "'-='", "'*='", "'/='", "'%='", "WS", "COMMENT", 
		"LINE_COMMENT"
	};
	public static final int
		RULE_program = 0, RULE_global = 1, RULE_block = 2, RULE_moreFunctions = 3, 
		RULE_function = 4, RULE_funcParameters = 5, RULE_declarationParameters = 6, 
		RULE_declarationParameterList = 7, RULE_stmts = 8, RULE_stmt = 9, RULE_incDec = 10, 
		RULE_declaration = 11, RULE_assign = 12, RULE_ifStmt = 13, RULE_elseIfStmt = 14, 
		RULE_elseStmt = 15, RULE_loop = 16, RULE_loopWhileOrUntil = 17, RULE_loopForeach = 18, 
		RULE_funcCall = 19, RULE_variableMethodCall = 20, RULE_returnFunction = 21, 
		RULE_condition = 22, RULE_identifierOrListIndex = 23, RULE_expression = 24, 
		RULE_constructClass = 25, RULE_constructClassPort = 26, RULE_literal = 27, 
		RULE_booleanLiteral = 28, RULE_collectionInit = 29, RULE_type = 30, RULE_primitiveType = 31, 
		RULE_collectionType = 32, RULE_classes = 33, RULE_port = 34, RULE_nothing = 35, 
		RULE_logicalOperator = 36;
	public static final String[] ruleNames = {
		"program", "global", "block", "moreFunctions", "function", "funcParameters", 
		"declarationParameters", "declarationParameterList", "stmts", "stmt", 
		"incDec", "declaration", "assign", "ifStmt", "elseIfStmt", "elseStmt", 
		"loop", "loopWhileOrUntil", "loopForeach", "funcCall", "variableMethodCall", 
		"returnFunction", "condition", "identifierOrListIndex", "expression", 
		"constructClass", "constructClassPort", "literal", "booleanLiteral", "collectionInit", 
		"type", "primitiveType", "collectionType", "classes", "port", "nothing", 
		"logicalOperator"
	};

	@Override
	public String getGrammarFileName() { return "HOME.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public HOMEParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(HOMEParser.EOF, 0); }
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
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74); global();
			setState(75); block();
			setState(76); match(EOF);
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
		public List<TerminalNode> Newline() { return getTokens(HOMEParser.Newline); }
		public GlobalContext global() {
			return getRuleContext(GlobalContext.class,0);
		}
		public TerminalNode Newline(int i) {
			return getToken(HOMEParser.Newline, i);
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
		public GlobalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_global; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterGlobal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitGlobal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitGlobal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GlobalContext global() throws RecognitionException {
		GlobalContext _localctx = new GlobalContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_global);
		int _la;
		try {
			int _alt;
			setState(103);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 5) | (1L << 9) | (1L << 11) | (1L << 15) | (1L << 21) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 32))) != 0)) {
					{
					{
					setState(78); declaration();
					}
					}
					setState(83);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(85); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(84); match(Newline);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(87); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				} while ( _alt!=2 && _alt!=-1 );
				setState(89); global();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Identifier) {
					{
					{
					setState(90); assign();
					}
					}
					setState(95);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(97); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(96); match(Newline);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(99); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				} while ( _alt!=2 && _alt!=-1 );
				setState(101); global();
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
		public List<TerminalNode> Newline() { return getTokens(HOMEParser.Newline); }
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public TerminalNode Newline(int i) {
			return getToken(HOMEParser.Newline, i);
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
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_block);
		int _la;
		try {
			setState(114);
			switch (_input.LA(1)) {
			case 26:
				enterOuterAlt(_localctx, 1);
				{
				setState(105); function();
				setState(106); moreFunctions();
				}
				break;
			case EOF:
			case Newline:
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Newline) {
					{
					{
					setState(108); match(Newline);
					}
					}
					setState(113);
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
		public List<TerminalNode> Newline() { return getTokens(HOMEParser.Newline); }
		public TerminalNode Newline(int i) {
			return getToken(HOMEParser.Newline, i);
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
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterMoreFunctions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitMoreFunctions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitMoreFunctions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MoreFunctionsContext moreFunctions() throws RecognitionException {
		MoreFunctionsContext _localctx = new MoreFunctionsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_moreFunctions);
		int _la;
		try {
			int _alt;
			setState(128);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(117); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(116); match(Newline);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(119); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				} while ( _alt!=2 && _alt!=-1 );
				setState(121); block();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Newline) {
					{
					{
					setState(122); match(Newline);
					}
					}
					setState(127);
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
		public List<TerminalNode> Newline() { return getTokens(HOMEParser.Newline); }
		public TerminalNode Newline(int i) {
			return getToken(HOMEParser.Newline, i);
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
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitFunction(this);
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
			setState(130); match(26);
			setState(131); identifierOrListIndex();
			setState(132); declarationParameters();
			setState(133); match(33);
			setState(136);
			switch (_input.LA(1)) {
			case 5:
			case 9:
			case 11:
			case 15:
			case 21:
			case 28:
			case 29:
			case 30:
			case 32:
				{
				setState(134); type();
				}
				break;
			case 25:
				{
				setState(135); nothing();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(139); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(138); match(Newline);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(141); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			setState(143); stmts();
			setState(144); match(7);
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
		public TerminalNode RPAREN() { return getToken(HOMEParser.RPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode LPAREN() { return getToken(HOMEParser.LPAREN, 0); }
		public FuncParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterFuncParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitFuncParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitFuncParameters(this);
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
			setState(146); match(LPAREN);
			setState(155);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 9) | (1L << 12) | (1L << 14) | (1L << 20) | (1L << 21) | (1L << 32) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << DecimalLiteral) | (1L << StringLiteral) | (1L << ADD) | (1L << SUB) | (1L << LPAREN))) != 0)) {
				{
				setState(147); expression(0);
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4) {
					{
					{
					setState(148); match(4);
					setState(149); expression(0);
					}
					}
					setState(154);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(157); match(RPAREN);
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
		public TerminalNode RPAREN() { return getToken(HOMEParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(HOMEParser.LPAREN, 0); }
		public DeclarationParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterDeclarationParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitDeclarationParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitDeclarationParameters(this);
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
			setState(159); match(LPAREN);
			setState(168);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 5) | (1L << 9) | (1L << 11) | (1L << 15) | (1L << 21) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 32))) != 0)) {
				{
				setState(160); declaration();
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4) {
					{
					{
					setState(161); match(4);
					setState(162); declaration();
					}
					}
					setState(167);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(170); match(RPAREN);
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
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterDeclarationParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitDeclarationParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitDeclarationParameterList(this);
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
			setState(172); declaration();
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4) {
				{
				{
				setState(173); match(4);
				setState(174); declaration();
				}
				}
				setState(179);
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
		public List<TerminalNode> Newline() { return getTokens(HOMEParser.Newline); }
		public TerminalNode Newline(int i) {
			return getToken(HOMEParser.Newline, i);
		}
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
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
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterStmts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitStmts(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitStmts(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtsContext stmts() throws RecognitionException {
		StmtsContext _localctx = new StmtsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_stmts);
		int _la;
		try {
			int _alt;
			setState(194);
			switch (_input.LA(1)) {
			case 5:
			case 9:
			case 10:
			case 11:
			case 15:
			case 21:
			case 27:
			case 28:
			case 29:
			case 30:
			case 31:
			case 32:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(180); stmt();
				setState(182); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(181); match(Newline);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(184); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				} while ( _alt!=2 && _alt!=-1 );
				setState(186); stmts();
				}
				break;
			case 3:
			case 7:
			case 18:
			case 22:
			case 24:
			case Newline:
				enterOuterAlt(_localctx, 2);
				{
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Newline) {
					{
					{
					setState(188); match(Newline);
					}
					}
					setState(193);
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
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_stmt);
		try {
			setState(204);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(196); declaration();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(197); assign();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(198); ifStmt();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(199); loop();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(200); funcCall();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(201); variableMethodCall();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(202); returnFunction();
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(203); incDec();
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
		public TerminalNode INC() { return getToken(HOMEParser.INC, 0); }
		public TerminalNode DEC() { return getToken(HOMEParser.DEC, 0); }
		public IdentifierOrListIndexContext identifierOrListIndex() {
			return getRuleContext(IdentifierOrListIndexContext.class,0);
		}
		public IncDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_incDec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterIncDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitIncDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitIncDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IncDecContext incDec() throws RecognitionException {
		IncDecContext _localctx = new IncDecContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_incDec);
		try {
			setState(212);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(206); identifierOrListIndex();
				setState(207); match(INC);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(209); identifierOrListIndex();
				setState(210); match(DEC);
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
		public TerminalNode AnyAssign() { return getToken(HOMEParser.AnyAssign, 0); }
		public IdentifierOrListIndexContext identifierOrListIndex() {
			return getRuleContext(IdentifierOrListIndexContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214); type();
			setState(215); identifierOrListIndex();
			setState(218);
			_la = _input.LA(1);
			if (_la==AnyAssign) {
				{
				setState(216); match(AnyAssign);
				setState(217); expression(0);
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
		public TerminalNode AnyAssign() { return getToken(HOMEParser.AnyAssign, 0); }
		public IdentifierOrListIndexContext identifierOrListIndex() {
			return getRuleContext(IdentifierOrListIndexContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220); identifierOrListIndex();
			setState(221); match(AnyAssign);
			setState(222); expression(0);
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
		public List<TerminalNode> Newline() { return getTokens(HOMEParser.Newline); }
		public ElseStmtContext elseStmt() {
			return getRuleContext(ElseStmtContext.class,0);
		}
		public TerminalNode Newline(int i) {
			return getToken(HOMEParser.Newline, i);
		}
		public ElseIfStmtContext elseIfStmt(int i) {
			return getRuleContext(ElseIfStmtContext.class,i);
		}
		public List<ElseIfStmtContext> elseIfStmt() {
			return getRuleContexts(ElseIfStmtContext.class);
		}
		public TerminalNode RPAREN() { return getToken(HOMEParser.RPAREN, 0); }
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(HOMEParser.LPAREN, 0); }
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_ifStmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(224); match(10);
			setState(225); match(LPAREN);
			setState(226); expression(0);
			setState(227); match(RPAREN);
			setState(229); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(228); match(Newline);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(231); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			setState(233); stmts();
			setState(237);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==22) {
				{
				{
				setState(234); elseIfStmt();
				}
				}
				setState(239);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(241);
			_la = _input.LA(1);
			if (_la==18) {
				{
				setState(240); elseStmt();
				}
			}

			setState(243); match(3);
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
		public List<TerminalNode> Newline() { return getTokens(HOMEParser.Newline); }
		public TerminalNode Newline(int i) {
			return getToken(HOMEParser.Newline, i);
		}
		public TerminalNode RPAREN() { return getToken(HOMEParser.RPAREN, 0); }
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(HOMEParser.LPAREN, 0); }
		public ElseIfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseIfStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterElseIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitElseIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitElseIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseIfStmtContext elseIfStmt() throws RecognitionException {
		ElseIfStmtContext _localctx = new ElseIfStmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_elseIfStmt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(245); match(22);
			setState(246); match(LPAREN);
			setState(247); expression(0);
			setState(248); match(RPAREN);
			setState(250); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(249); match(Newline);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(252); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			setState(254); stmts();
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
		public List<TerminalNode> Newline() { return getTokens(HOMEParser.Newline); }
		public TerminalNode Newline(int i) {
			return getToken(HOMEParser.Newline, i);
		}
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public ElseStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterElseStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitElseStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitElseStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStmtContext elseStmt() throws RecognitionException {
		ElseStmtContext _localctx = new ElseStmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_elseStmt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(256); match(18);
			setState(258); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(257); match(Newline);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(260); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			setState(263);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(262); stmts();
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
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_loop);
		try {
			setState(267);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(265); loopWhileOrUntil();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(266); loopForeach();
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
		public List<TerminalNode> Newline() { return getTokens(HOMEParser.Newline); }
		public TerminalNode Newline(int i) {
			return getToken(HOMEParser.Newline, i);
		}
		public TerminalNode RPAREN() { return getToken(HOMEParser.RPAREN, 0); }
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(HOMEParser.LPAREN, 0); }
		public LoopWhileOrUntilContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopWhileOrUntil; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterLoopWhileOrUntil(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitLoopWhileOrUntil(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitLoopWhileOrUntil(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopWhileOrUntilContext loopWhileOrUntil() throws RecognitionException {
		LoopWhileOrUntilContext _localctx = new LoopWhileOrUntilContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_loopWhileOrUntil);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(269); match(31);
			setState(270);
			_la = _input.LA(1);
			if ( !(_la==8 || _la==13) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(271); match(LPAREN);
			setState(272); expression(0);
			setState(273); match(RPAREN);
			setState(275); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(274); match(Newline);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(277); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			setState(279); stmts();
			setState(280); match(24);
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
		public List<TerminalNode> Newline() { return getTokens(HOMEParser.Newline); }
		public TerminalNode Newline(int i) {
			return getToken(HOMEParser.Newline, i);
		}
		public TerminalNode RPAREN() { return getToken(HOMEParser.RPAREN, 0); }
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentifierOrListIndexContext identifierOrListIndex(int i) {
			return getRuleContext(IdentifierOrListIndexContext.class,i);
		}
		public List<IdentifierOrListIndexContext> identifierOrListIndex() {
			return getRuleContexts(IdentifierOrListIndexContext.class);
		}
		public TerminalNode LPAREN() { return getToken(HOMEParser.LPAREN, 0); }
		public LoopForeachContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopForeach; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterLoopForeach(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitLoopForeach(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitLoopForeach(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopForeachContext loopForeach() throws RecognitionException {
		LoopForeachContext _localctx = new LoopForeachContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_loopForeach);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(282); match(31);
			setState(283); match(34);
			setState(284); match(LPAREN);
			setState(285); type();
			setState(286); identifierOrListIndex();
			setState(287); match(2);
			setState(288); identifierOrListIndex();
			setState(289); match(RPAREN);
			setState(291); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(290); match(Newline);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(293); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			setState(295); stmts();
			setState(296); match(24);
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
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterFuncCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitFuncCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitFuncCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncCallContext funcCall() throws RecognitionException {
		FuncCallContext _localctx = new FuncCallContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_funcCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298); identifierOrListIndex();
			setState(299); funcParameters();
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
		public List<TerminalNode> DOT() { return getTokens(HOMEParser.DOT); }
		public FuncCallContext funcCall(int i) {
			return getRuleContext(FuncCallContext.class,i);
		}
		public IdentifierOrListIndexContext identifierOrListIndex() {
			return getRuleContext(IdentifierOrListIndexContext.class,0);
		}
		public List<FuncCallContext> funcCall() {
			return getRuleContexts(FuncCallContext.class);
		}
		public TerminalNode DOT(int i) {
			return getToken(HOMEParser.DOT, i);
		}
		public VariableMethodCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableMethodCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterVariableMethodCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitVariableMethodCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitVariableMethodCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableMethodCallContext variableMethodCall() throws RecognitionException {
		VariableMethodCallContext _localctx = new VariableMethodCallContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_variableMethodCall);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(301); identifierOrListIndex();
			setState(302); match(DOT);
			setState(303); funcCall();
			setState(308);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(304); match(DOT);
					setState(305); funcCall();
					}
					} 
				}
				setState(310);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
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
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterReturnFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitReturnFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitReturnFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnFunctionContext returnFunction() throws RecognitionException {
		ReturnFunctionContext _localctx = new ReturnFunctionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_returnFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311); match(27);
			setState(313);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 9) | (1L << 12) | (1L << 14) | (1L << 20) | (1L << 21) | (1L << 32) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << DecimalLiteral) | (1L << StringLiteral) | (1L << ADD) | (1L << SUB) | (1L << LPAREN))) != 0)) {
				{
				setState(312); expression(0);
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
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(315); identifierOrListIndex();
				}
				break;
			case 12:
			case 20:
			case IntegerLiteral:
			case DecimalLiteral:
			case StringLiteral:
				{
				setState(316); literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(319); logicalOperator();
			setState(322);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(320); identifierOrListIndex();
				}
				break;
			case 12:
			case 20:
			case IntegerLiteral:
			case DecimalLiteral:
			case StringLiteral:
				{
				setState(321); literal();
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
		public TerminalNode Identifier() { return getToken(HOMEParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IdentifierOrListIndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierOrListIndex; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterIdentifierOrListIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitIdentifierOrListIndex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitIdentifierOrListIndex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierOrListIndexContext identifierOrListIndex() throws RecognitionException {
		IdentifierOrListIndexContext _localctx = new IdentifierOrListIndexContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_identifierOrListIndex);
		try {
			setState(330);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(324); match(Identifier);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(325); match(Identifier);
				setState(326); match(6);
				setState(327); expression(0);
				setState(328); match(1);
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
		public TerminalNode RPAREN() { return getToken(HOMEParser.RPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public IdentifierOrListIndexContext identifierOrListIndex() {
			return getRuleContext(IdentifierOrListIndexContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(HOMEParser.LPAREN, 0); }
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
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitExpression(this);
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
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(333);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUB) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(334); expression(9);
				}
				break;

			case 2:
				{
				setState(335); funcCall();
				}
				break;

			case 3:
				{
				setState(336); literal();
				}
				break;

			case 4:
				{
				setState(337); collectionInit();
				}
				break;

			case 5:
				{
				setState(338); constructClass();
				}
				break;

			case 6:
				{
				setState(339); variableMethodCall();
				}
				break;

			case 7:
				{
				setState(340); identifierOrListIndex();
				}
				break;

			case 8:
				{
				setState(341); match(LPAREN);
				setState(342); expression(0);
				setState(343); match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(359);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(357);
					switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(347);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(348);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(349); expression(12);
						}
						break;

					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(350);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(351);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(352); expression(11);
						}
						break;

					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(353);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(354); logicalOperator();
						setState(355); expression(9);
						}
						break;
					}
					} 
				}
				setState(361);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
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
		public TerminalNode RPAREN() { return getToken(HOMEParser.RPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ConstructClassPortContext constructClassPort() {
			return getRuleContext(ConstructClassPortContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(HOMEParser.LPAREN, 0); }
		public ClassesContext classes() {
			return getRuleContext(ClassesContext.class,0);
		}
		public ConstructClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterConstructClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitConstructClass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitConstructClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructClassContext constructClass() throws RecognitionException {
		ConstructClassContext _localctx = new ConstructClassContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_constructClass);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362); classes();
			setState(363); match(LPAREN);
			setState(375);
			switch (_input.LA(1)) {
			case 4:
			case 9:
			case 12:
			case 14:
			case 20:
			case 21:
			case 32:
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
				setState(365);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 9) | (1L << 12) | (1L << 14) | (1L << 20) | (1L << 21) | (1L << 32) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << DecimalLiteral) | (1L << StringLiteral) | (1L << ADD) | (1L << SUB) | (1L << LPAREN))) != 0)) {
					{
					setState(364); expression(0);
					}
				}

				setState(371);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4) {
					{
					{
					setState(367); match(4);
					setState(368); expression(0);
					}
					}
					setState(373);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case 16:
				{
				setState(374); constructClassPort();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(377); match(RPAREN);
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
		public TerminalNode IntegerLiteral() { return getToken(HOMEParser.IntegerLiteral, 0); }
		public ConstructClassPortContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructClassPort; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterConstructClassPort(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitConstructClassPort(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitConstructClassPort(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructClassPortContext constructClassPort() throws RecognitionException {
		ConstructClassPortContext _localctx = new ConstructClassPortContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_constructClassPort);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379); port();
			setState(380); match(IntegerLiteral);
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
		public TerminalNode IntegerLiteral() { return getToken(HOMEParser.IntegerLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(HOMEParser.StringLiteral, 0); }
		public TerminalNode DecimalLiteral() { return getToken(HOMEParser.DecimalLiteral, 0); }
		public BooleanLiteralContext booleanLiteral() {
			return getRuleContext(BooleanLiteralContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_literal);
		try {
			setState(386);
			switch (_input.LA(1)) {
			case 12:
			case 20:
				enterOuterAlt(_localctx, 1);
				{
				setState(382); booleanLiteral();
				}
				break;
			case DecimalLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(383); match(DecimalLiteral);
				}
				break;
			case IntegerLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(384); match(IntegerLiteral);
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 4);
				{
				setState(385); match(StringLiteral);
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
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterBooleanLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitBooleanLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitBooleanLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanLiteralContext booleanLiteral() throws RecognitionException {
		BooleanLiteralContext _localctx = new BooleanLiteralContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(388);
			_la = _input.LA(1);
			if ( !(_la==12 || _la==20) ) {
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
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterCollectionInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitCollectionInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitCollectionInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CollectionInitContext collectionInit() throws RecognitionException {
		CollectionInitContext _localctx = new CollectionInitContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_collectionInit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(390); match(14);
			setState(399);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 9) | (1L << 12) | (1L << 14) | (1L << 20) | (1L << 21) | (1L << 32) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << DecimalLiteral) | (1L << StringLiteral) | (1L << ADD) | (1L << SUB) | (1L << LPAREN))) != 0)) {
				{
				setState(391); expression(0);
				setState(396);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4) {
					{
					{
					setState(392); match(4);
					setState(393); expression(0);
					}
					}
					setState(398);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(401); match(19);
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
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_type);
		try {
			setState(406);
			switch (_input.LA(1)) {
			case 15:
			case 28:
			case 29:
			case 30:
				enterOuterAlt(_localctx, 1);
				{
				setState(403); primitiveType();
				}
				break;
			case 5:
			case 11:
				enterOuterAlt(_localctx, 2);
				{
				setState(404); collectionType();
				}
				break;
			case 9:
			case 21:
			case 32:
				enterOuterAlt(_localctx, 3);
				{
				setState(405); classes();
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
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitPrimitiveType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitPrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(408);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 15) | (1L << 28) | (1L << 29) | (1L << 30))) != 0)) ) {
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
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterCollectionType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitCollectionType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitCollectionType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CollectionTypeContext collectionType() throws RecognitionException {
		CollectionTypeContext _localctx = new CollectionTypeContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_collectionType);
		try {
			setState(420);
			switch (_input.LA(1)) {
			case 11:
				enterOuterAlt(_localctx, 1);
				{
				setState(410); match(11);
				setState(411); match(LT);
				setState(412); type();
				setState(413); match(GT);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 2);
				{
				setState(415); match(5);
				setState(416); match(LT);
				setState(417); type();
				setState(418); match(GT);
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
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterClasses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitClasses(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitClasses(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassesContext classes() throws RecognitionException {
		ClassesContext _localctx = new ClassesContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_classes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(422);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 9) | (1L << 21) | (1L << 32))) != 0)) ) {
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
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterPort(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitPort(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitPort(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PortContext port() throws RecognitionException {
		PortContext _localctx = new PortContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_port);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(424); match(16);
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
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterNothing(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitNothing(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitNothing(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NothingContext nothing() throws RecognitionException {
		NothingContext _localctx = new NothingContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_nothing);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(426); match(25);
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
		public TerminalNode LT() { return getToken(HOMEParser.LT, 0); }
		public TerminalNode LE() { return getToken(HOMEParser.LE, 0); }
		public TerminalNode EQUAL() { return getToken(HOMEParser.EQUAL, 0); }
		public TerminalNode GT() { return getToken(HOMEParser.GT, 0); }
		public TerminalNode NOTEQUAL() { return getToken(HOMEParser.NOTEQUAL, 0); }
		public TerminalNode GE() { return getToken(HOMEParser.GE, 0); }
		public LogicalOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterLogicalOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitLogicalOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitLogicalOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalOperatorContext logicalOperator() throws RecognitionException {
		LogicalOperatorContext _localctx = new LogicalOperatorContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_logicalOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(428);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 17) | (1L << 23) | (1L << NOTEQUAL) | (1L << EQUAL) | (1L << GT) | (1L << LT) | (1L << LE) | (1L << GE))) != 0)) ) {
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
		case 24: return expression_sempred((ExpressionContext)_localctx, predIndex);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3H\u01b1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\2\3\2\3\3\7\3R\n\3\f\3\16"+
		"\3U\13\3\3\3\6\3X\n\3\r\3\16\3Y\3\3\3\3\7\3^\n\3\f\3\16\3a\13\3\3\3\6"+
		"\3d\n\3\r\3\16\3e\3\3\3\3\5\3j\n\3\3\4\3\4\3\4\3\4\7\4p\n\4\f\4\16\4s"+
		"\13\4\5\4u\n\4\3\5\6\5x\n\5\r\5\16\5y\3\5\3\5\7\5~\n\5\f\5\16\5\u0081"+
		"\13\5\5\5\u0083\n\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u008b\n\6\3\6\6\6\u008e"+
		"\n\6\r\6\16\6\u008f\3\6\3\6\3\6\3\7\3\7\3\7\3\7\7\7\u0099\n\7\f\7\16\7"+
		"\u009c\13\7\5\7\u009e\n\7\3\7\3\7\3\b\3\b\3\b\3\b\7\b\u00a6\n\b\f\b\16"+
		"\b\u00a9\13\b\5\b\u00ab\n\b\3\b\3\b\3\t\3\t\3\t\7\t\u00b2\n\t\f\t\16\t"+
		"\u00b5\13\t\3\n\3\n\6\n\u00b9\n\n\r\n\16\n\u00ba\3\n\3\n\3\n\7\n\u00c0"+
		"\n\n\f\n\16\n\u00c3\13\n\5\n\u00c5\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\5\13\u00cf\n\13\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00d7\n\f\3\r\3\r"+
		"\3\r\3\r\5\r\u00dd\n\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\6"+
		"\17\u00e8\n\17\r\17\16\17\u00e9\3\17\3\17\7\17\u00ee\n\17\f\17\16\17\u00f1"+
		"\13\17\3\17\5\17\u00f4\n\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\6\20\u00fd"+
		"\n\20\r\20\16\20\u00fe\3\20\3\20\3\21\3\21\6\21\u0105\n\21\r\21\16\21"+
		"\u0106\3\21\5\21\u010a\n\21\3\22\3\22\5\22\u010e\n\22\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\6\23\u0116\n\23\r\23\16\23\u0117\3\23\3\23\3\23\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\6\24\u0126\n\24\r\24\16\24\u0127\3"+
		"\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\7\26\u0135\n\26"+
		"\f\26\16\26\u0138\13\26\3\27\3\27\5\27\u013c\n\27\3\30\3\30\5\30\u0140"+
		"\n\30\3\30\3\30\3\30\5\30\u0145\n\30\3\31\3\31\3\31\3\31\3\31\3\31\5\31"+
		"\u014d\n\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\5\32\u015c\n\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\7\32\u0168\n\32\f\32\16\32\u016b\13\32\3\33\3\33\3\33\5\33\u0170\n\33"+
		"\3\33\3\33\7\33\u0174\n\33\f\33\16\33\u0177\13\33\3\33\5\33\u017a\n\33"+
		"\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\5\35\u0185\n\35\3\36\3\36"+
		"\3\37\3\37\3\37\3\37\7\37\u018d\n\37\f\37\16\37\u0190\13\37\5\37\u0192"+
		"\n\37\3\37\3\37\3 \3 \3 \5 \u0199\n \3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3\"\3\"\5\"\u01a7\n\"\3#\3#\3$\3$\3%\3%\3&\3&\3&\2\3\62\'\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJ\2\t\4\2"+
		"\n\n\17\17\3\2\65\66\3\2\679\4\2\16\16\26\26\4\2\21\21\36 \5\2\13\13\27"+
		"\27\"\"\5\2\23\23\31\31-\62\u01cc\2L\3\2\2\2\4i\3\2\2\2\6t\3\2\2\2\b\u0082"+
		"\3\2\2\2\n\u0084\3\2\2\2\f\u0094\3\2\2\2\16\u00a1\3\2\2\2\20\u00ae\3\2"+
		"\2\2\22\u00c4\3\2\2\2\24\u00ce\3\2\2\2\26\u00d6\3\2\2\2\30\u00d8\3\2\2"+
		"\2\32\u00de\3\2\2\2\34\u00e2\3\2\2\2\36\u00f7\3\2\2\2 \u0102\3\2\2\2\""+
		"\u010d\3\2\2\2$\u010f\3\2\2\2&\u011c\3\2\2\2(\u012c\3\2\2\2*\u012f\3\2"+
		"\2\2,\u0139\3\2\2\2.\u013f\3\2\2\2\60\u014c\3\2\2\2\62\u015b\3\2\2\2\64"+
		"\u016c\3\2\2\2\66\u017d\3\2\2\28\u0184\3\2\2\2:\u0186\3\2\2\2<\u0188\3"+
		"\2\2\2>\u0198\3\2\2\2@\u019a\3\2\2\2B\u01a6\3\2\2\2D\u01a8\3\2\2\2F\u01aa"+
		"\3\2\2\2H\u01ac\3\2\2\2J\u01ae\3\2\2\2LM\5\4\3\2MN\5\6\4\2NO\7\2\2\3O"+
		"\3\3\2\2\2PR\5\30\r\2QP\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TW\3\2\2"+
		"\2US\3\2\2\2VX\7%\2\2WV\3\2\2\2XY\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z[\3\2\2"+
		"\2[j\5\4\3\2\\^\5\32\16\2]\\\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`c\3"+
		"\2\2\2a_\3\2\2\2bd\7%\2\2cb\3\2\2\2de\3\2\2\2ec\3\2\2\2ef\3\2\2\2fg\3"+
		"\2\2\2gj\5\4\3\2hj\3\2\2\2iS\3\2\2\2i_\3\2\2\2ih\3\2\2\2j\5\3\2\2\2kl"+
		"\5\n\6\2lm\5\b\5\2mu\3\2\2\2np\7%\2\2on\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr"+
		"\3\2\2\2ru\3\2\2\2sq\3\2\2\2tk\3\2\2\2tq\3\2\2\2u\7\3\2\2\2vx\7%\2\2w"+
		"v\3\2\2\2xy\3\2\2\2yw\3\2\2\2yz\3\2\2\2z{\3\2\2\2{\u0083\5\6\4\2|~\7%"+
		"\2\2}|\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\u0083"+
		"\3\2\2\2\u0081\177\3\2\2\2\u0082w\3\2\2\2\u0082\177\3\2\2\2\u0083\t\3"+
		"\2\2\2\u0084\u0085\7\34\2\2\u0085\u0086\5\60\31\2\u0086\u0087\5\16\b\2"+
		"\u0087\u008a\7#\2\2\u0088\u008b\5> \2\u0089\u008b\5H%\2\u008a\u0088\3"+
		"\2\2\2\u008a\u0089\3\2\2\2\u008b\u008d\3\2\2\2\u008c\u008e\7%\2\2\u008d"+
		"\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2"+
		"\2\2\u0090\u0091\3\2\2\2\u0091\u0092\5\22\n\2\u0092\u0093\7\t\2\2\u0093"+
		"\13\3\2\2\2\u0094\u009d\7=\2\2\u0095\u009a\5\62\32\2\u0096\u0097\7\6\2"+
		"\2\u0097\u0099\5\62\32\2\u0098\u0096\3\2\2\2\u0099\u009c\3\2\2\2\u009a"+
		"\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2"+
		"\2\2\u009d\u0095\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\3\2\2\2\u009f"+
		"\u00a0\7>\2\2\u00a0\r\3\2\2\2\u00a1\u00aa\7=\2\2\u00a2\u00a7\5\30\r\2"+
		"\u00a3\u00a4\7\6\2\2\u00a4\u00a6\5\30\r\2\u00a5\u00a3\3\2\2\2\u00a6\u00a9"+
		"\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9"+
		"\u00a7\3\2\2\2\u00aa\u00a2\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\3\2"+
		"\2\2\u00ac\u00ad\7>\2\2\u00ad\17\3\2\2\2\u00ae\u00b3\5\30\r\2\u00af\u00b0"+
		"\7\6\2\2\u00b0\u00b2\5\30\r\2\u00b1\u00af\3\2\2\2\u00b2\u00b5\3\2\2\2"+
		"\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\21\3\2\2\2\u00b5\u00b3"+
		"\3\2\2\2\u00b6\u00b8\5\24\13\2\u00b7\u00b9\7%\2\2\u00b8\u00b7\3\2\2\2"+
		"\u00b9\u00ba\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc"+
		"\3\2\2\2\u00bc\u00bd\5\22\n\2\u00bd\u00c5\3\2\2\2\u00be\u00c0\7%\2\2\u00bf"+
		"\u00be\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2"+
		"\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4\u00b6\3\2\2\2\u00c4"+
		"\u00c1\3\2\2\2\u00c5\23\3\2\2\2\u00c6\u00cf\5\30\r\2\u00c7\u00cf\5\32"+
		"\16\2\u00c8\u00cf\5\34\17\2\u00c9\u00cf\5\"\22\2\u00ca\u00cf\5(\25\2\u00cb"+
		"\u00cf\5*\26\2\u00cc\u00cf\5,\27\2\u00cd\u00cf\5\26\f\2\u00ce\u00c6\3"+
		"\2\2\2\u00ce\u00c7\3\2\2\2\u00ce\u00c8\3\2\2\2\u00ce\u00c9\3\2\2\2\u00ce"+
		"\u00ca\3\2\2\2\u00ce\u00cb\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cd\3\2"+
		"\2\2\u00cf\25\3\2\2\2\u00d0\u00d1\5\60\31\2\u00d1\u00d2\7\63\2\2\u00d2"+
		"\u00d7\3\2\2\2\u00d3\u00d4\5\60\31\2\u00d4\u00d5\7\64\2\2\u00d5\u00d7"+
		"\3\2\2\2\u00d6\u00d0\3\2\2\2\u00d6\u00d3\3\2\2\2\u00d7\27\3\2\2\2\u00d8"+
		"\u00d9\5> \2\u00d9\u00dc\5\60\31\2\u00da\u00db\7?\2\2\u00db\u00dd\5\62"+
		"\32\2\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\31\3\2\2\2\u00de\u00df"+
		"\5\60\31\2\u00df\u00e0\7?\2\2\u00e0\u00e1\5\62\32\2\u00e1\33\3\2\2\2\u00e2"+
		"\u00e3\7\f\2\2\u00e3\u00e4\7=\2\2\u00e4\u00e5\5\62\32\2\u00e5\u00e7\7"+
		">\2\2\u00e6\u00e8\7%\2\2\u00e7\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9"+
		"\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ef\5\22"+
		"\n\2\u00ec\u00ee\5\36\20\2\u00ed\u00ec\3\2\2\2\u00ee\u00f1\3\2\2\2\u00ef"+
		"\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1\u00ef\3\2"+
		"\2\2\u00f2\u00f4\5 \21\2\u00f3\u00f2\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4"+
		"\u00f5\3\2\2\2\u00f5\u00f6\7\5\2\2\u00f6\35\3\2\2\2\u00f7\u00f8\7\30\2"+
		"\2\u00f8\u00f9\7=\2\2\u00f9\u00fa\5\62\32\2\u00fa\u00fc\7>\2\2\u00fb\u00fd"+
		"\7%\2\2\u00fc\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe"+
		"\u00ff\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0101\5\22\n\2\u0101\37\3\2\2"+
		"\2\u0102\u0104\7\24\2\2\u0103\u0105\7%\2\2\u0104\u0103\3\2\2\2\u0105\u0106"+
		"\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0109\3\2\2\2\u0108"+
		"\u010a\5\22\n\2\u0109\u0108\3\2\2\2\u0109\u010a\3\2\2\2\u010a!\3\2\2\2"+
		"\u010b\u010e\5$\23\2\u010c\u010e\5&\24\2\u010d\u010b\3\2\2\2\u010d\u010c"+
		"\3\2\2\2\u010e#\3\2\2\2\u010f\u0110\7!\2\2\u0110\u0111\t\2\2\2\u0111\u0112"+
		"\7=\2\2\u0112\u0113\5\62\32\2\u0113\u0115\7>\2\2\u0114\u0116\7%\2\2\u0115"+
		"\u0114\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0115\3\2\2\2\u0117\u0118\3\2"+
		"\2\2\u0118\u0119\3\2\2\2\u0119\u011a\5\22\n\2\u011a\u011b\7\32\2\2\u011b"+
		"%\3\2\2\2\u011c\u011d\7!\2\2\u011d\u011e\7$\2\2\u011e\u011f\7=\2\2\u011f"+
		"\u0120\5> \2\u0120\u0121\5\60\31\2\u0121\u0122\7\4\2\2\u0122\u0123\5\60"+
		"\31\2\u0123\u0125\7>\2\2\u0124\u0126\7%\2\2\u0125\u0124\3\2\2\2\u0126"+
		"\u0127\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u0129\3\2"+
		"\2\2\u0129\u012a\5\22\n\2\u012a\u012b\7\32\2\2\u012b\'\3\2\2\2\u012c\u012d"+
		"\5\60\31\2\u012d\u012e\5\f\7\2\u012e)\3\2\2\2\u012f\u0130\5\60\31\2\u0130"+
		"\u0131\7+\2\2\u0131\u0136\5(\25\2\u0132\u0133\7+\2\2\u0133\u0135\5(\25"+
		"\2\u0134\u0132\3\2\2\2\u0135\u0138\3\2\2\2\u0136\u0134\3\2\2\2\u0136\u0137"+
		"\3\2\2\2\u0137+\3\2\2\2\u0138\u0136\3\2\2\2\u0139\u013b\7\35\2\2\u013a"+
		"\u013c\5\62\32\2\u013b\u013a\3\2\2\2\u013b\u013c\3\2\2\2\u013c-\3\2\2"+
		"\2\u013d\u0140\5\60\31\2\u013e\u0140\58\35\2\u013f\u013d\3\2\2\2\u013f"+
		"\u013e\3\2\2\2\u0140\u0141\3\2\2\2\u0141\u0144\5J&\2\u0142\u0145\5\60"+
		"\31\2\u0143\u0145\58\35\2\u0144\u0142\3\2\2\2\u0144\u0143\3\2\2\2\u0145"+
		"/\3\2\2\2\u0146\u014d\7&\2\2\u0147\u0148\7&\2\2\u0148\u0149\7\b\2\2\u0149"+
		"\u014a\5\62\32\2\u014a\u014b\7\3\2\2\u014b\u014d\3\2\2\2\u014c\u0146\3"+
		"\2\2\2\u014c\u0147\3\2\2\2\u014d\61\3\2\2\2\u014e\u014f\b\32\1\2\u014f"+
		"\u0150\t\3\2\2\u0150\u015c\5\62\32\13\u0151\u015c\5(\25\2\u0152\u015c"+
		"\58\35\2\u0153\u015c\5<\37\2\u0154\u015c\5\64\33\2\u0155\u015c\5*\26\2"+
		"\u0156\u015c\5\60\31\2\u0157\u0158\7=\2\2\u0158\u0159\5\62\32\2\u0159"+
		"\u015a\7>\2\2\u015a\u015c\3\2\2\2\u015b\u014e\3\2\2\2\u015b\u0151\3\2"+
		"\2\2\u015b\u0152\3\2\2\2\u015b\u0153\3\2\2\2\u015b\u0154\3\2\2\2\u015b"+
		"\u0155\3\2\2\2\u015b\u0156\3\2\2\2\u015b\u0157\3\2\2\2\u015c\u0169\3\2"+
		"\2\2\u015d\u015e\f\r\2\2\u015e\u015f\t\4\2\2\u015f\u0168\5\62\32\16\u0160"+
		"\u0161\f\f\2\2\u0161\u0162\t\3\2\2\u0162\u0168\5\62\32\r\u0163\u0164\f"+
		"\n\2\2\u0164\u0165\5J&\2\u0165\u0166\5\62\32\13\u0166\u0168\3\2\2\2\u0167"+
		"\u015d\3\2\2\2\u0167\u0160\3\2\2\2\u0167\u0163\3\2\2\2\u0168\u016b\3\2"+
		"\2\2\u0169\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016a\63\3\2\2\2\u016b\u0169"+
		"\3\2\2\2\u016c\u016d\5D#\2\u016d\u0179\7=\2\2\u016e\u0170\5\62\32\2\u016f"+
		"\u016e\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0175\3\2\2\2\u0171\u0172\7\6"+
		"\2\2\u0172\u0174\5\62\32\2\u0173\u0171\3\2\2\2\u0174\u0177\3\2\2\2\u0175"+
		"\u0173\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u017a\3\2\2\2\u0177\u0175\3\2"+
		"\2\2\u0178\u017a\5\66\34\2\u0179\u016f\3\2\2\2\u0179\u0178\3\2\2\2\u017a"+
		"\u017b\3\2\2\2\u017b\u017c\7>\2\2\u017c\65\3\2\2\2\u017d\u017e\5F$\2\u017e"+
		"\u017f\7\'\2\2\u017f\67\3\2\2\2\u0180\u0185\5:\36\2\u0181\u0185\7(\2\2"+
		"\u0182\u0185\7\'\2\2\u0183\u0185\7)\2\2\u0184\u0180\3\2\2\2\u0184\u0181"+
		"\3\2\2\2\u0184\u0182\3\2\2\2\u0184\u0183\3\2\2\2\u01859\3\2\2\2\u0186"+
		"\u0187\t\5\2\2\u0187;\3\2\2\2\u0188\u0191\7\20\2\2\u0189\u018e\5\62\32"+
		"\2\u018a\u018b\7\6\2\2\u018b\u018d\5\62\32\2\u018c\u018a\3\2\2\2\u018d"+
		"\u0190\3\2\2\2\u018e\u018c\3\2\2\2\u018e\u018f\3\2\2\2\u018f\u0192\3\2"+
		"\2\2\u0190\u018e\3\2\2\2\u0191\u0189\3\2\2\2\u0191\u0192\3\2\2\2\u0192"+
		"\u0193\3\2\2\2\u0193\u0194\7\25\2\2\u0194=\3\2\2\2\u0195\u0199\5@!\2\u0196"+
		"\u0199\5B\"\2\u0197\u0199\5D#\2\u0198\u0195\3\2\2\2\u0198\u0196\3\2\2"+
		"\2\u0198\u0197\3\2\2\2\u0199?\3\2\2\2\u019a\u019b\t\6\2\2\u019bA\3\2\2"+
		"\2\u019c\u019d\7\r\2\2\u019d\u019e\7\60\2\2\u019e\u019f\5> \2\u019f\u01a0"+
		"\7/\2\2\u01a0\u01a7\3\2\2\2\u01a1\u01a2\7\7\2\2\u01a2\u01a3\7\60\2\2\u01a3"+
		"\u01a4\5> \2\u01a4\u01a5\7/\2\2\u01a5\u01a7\3\2\2\2\u01a6\u019c\3\2\2"+
		"\2\u01a6\u01a1\3\2\2\2\u01a7C\3\2\2\2\u01a8\u01a9\t\7\2\2\u01a9E\3\2\2"+
		"\2\u01aa\u01ab\7\22\2\2\u01abG\3\2\2\2\u01ac\u01ad\7\33\2\2\u01adI\3\2"+
		"\2\2\u01ae\u01af\t\b\2\2\u01afK\3\2\2\2\62SY_eiqty\177\u0082\u008a\u008f"+
		"\u009a\u009d\u00a7\u00aa\u00b3\u00ba\u00c1\u00c4\u00ce\u00d6\u00dc\u00e9"+
		"\u00ef\u00f3\u00fe\u0106\u0109\u010d\u0117\u0127\u0136\u013b\u013f\u0144"+
		"\u014c\u015b\u0167\u0169\u016f\u0175\u0179\u0184\u018e\u0191\u0198\u01a6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}