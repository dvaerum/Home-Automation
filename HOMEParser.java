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
		T__32=1, T__31=2, T__30=3, T__29=4, T__28=5, T__27=6, T__26=7, T__25=8, 
		T__24=9, T__23=10, T__22=11, T__21=12, T__20=13, T__19=14, T__18=15, T__17=16, 
		T__16=17, T__15=18, T__14=19, T__13=20, T__12=21, T__11=22, T__10=23, 
		T__9=24, T__8=25, T__7=26, T__6=27, T__5=28, T__4=29, T__3=30, T__2=31, 
		T__1=32, T__0=33, Identifier=34, IntegerLiteral=35, DecimalLiteral=36, 
		StringLiteral=37, NullLiteral=38, DOT=39, BANG=40, SEMICOLON=41, NOTEQUAL=42, 
		EQUAL=43, GT=44, LT=45, LE=46, GE=47, INC=48, DEC=49, ADD=50, SUB=51, 
		MUL=52, DIV=53, MOD=54, BITAND=55, BITOR=56, CARET=57, LPAREN=58, RPAREN=59, 
		AnyAssign=60, ASSIGN=61, ADD_ASSIGN=62, SUB_ASSIGN=63, MUL_ASSIGN=64, 
		DIV_ASSIGN=65, MOD_ASSIGN=66, WS=67, COMMENT=68, LINE_COMMENT=69;
	public static final String[] tokenNames = {
		"<INVALID>", "']'", "'in'", "'endif'", "','", "'Dictionary'", "'\n'", 
		"'['", "'endfunction'", "'while'", "'\r'", "'if'", "'List'", "'false'", 
		"'until'", "'{'", "'Decimal'", "'PORT'", "'OR'", "'else'", "'}'", "'true'", 
		"'elseif'", "'AND'", "'endrepeat'", "'Nothing'", "'function'", "'return'", 
		"'Boolean'", "'String'", "'Integer'", "'repeat'", "'returns'", "'foreach'", 
		"Identifier", "IntegerLiteral", "DecimalLiteral", "StringLiteral", "'null'", 
		"'.'", "'!'", "';'", "'!='", "'=='", "'>'", "'<'", "'<='", "'>='", "'++'", 
		"'--'", "'+'", "'-'", "'*'", "'/'", "'%'", "'&'", "'|'", "'^'", "'('", 
		"')'", "AnyAssign", "'='", "'+='", "'-='", "'*='", "'/='", "'%='", "WS", 
		"COMMENT", "LINE_COMMENT"
	};
	public static final int
		RULE_program = 0, RULE_global = 1, RULE_block = 2, RULE_function = 3, 
		RULE_moreFunctions = 4, RULE_funcParameters = 5, RULE_declarationParameters = 6, 
		RULE_declarationParameterList = 7, RULE_stmts = 8, RULE_stmt = 9, RULE_incDec = 10, 
		RULE_declaration = 11, RULE_assign = 12, RULE_ifStmt = 13, RULE_elseIfStmt = 14, 
		RULE_elseStmt = 15, RULE_loop = 16, RULE_loopWhileOrUntil = 17, RULE_loopForeach = 18, 
		RULE_funcCall = 19, RULE_variableMethodCall = 20, RULE_returnFunction = 21, 
		RULE_condition = 22, RULE_identifierOrListIndex = 23, RULE_expression = 24, 
		RULE_literal = 25, RULE_booleanLiteral = 26, RULE_collectionInit = 27, 
		RULE_type = 28, RULE_primitiveType = 29, RULE_collectionType = 30, RULE_classes = 31, 
		RULE_port = 32, RULE_nothing = 33, RULE_logicalOperator = 34, RULE_newline = 35;
	public static final String[] ruleNames = {
		"program", "global", "block", "function", "moreFunctions", "funcParameters", 
		"declarationParameters", "declarationParameterList", "stmts", "stmt", 
		"incDec", "declaration", "assign", "ifStmt", "elseIfStmt", "elseStmt", 
		"loop", "loopWhileOrUntil", "loopForeach", "funcCall", "variableMethodCall", 
		"returnFunction", "condition", "identifierOrListIndex", "expression", 
		"literal", "booleanLiteral", "collectionInit", "type", "primitiveType", 
		"collectionType", "classes", "port", "nothing", "logicalOperator", "newline"
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
			setState(72); global();
			setState(73); block();
			setState(74); match(EOF);
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
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
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
			setState(93);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(76); declaration();
				setState(78); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(77); newline();
					}
					}
					setState(80); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==6 || _la==10 );
				setState(82); global();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(84); assign();
				setState(86); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(85); newline();
					}
					}
					setState(88); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==6 || _la==10 );
				setState(90); global();
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
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95); function();
			setState(96); moreFunctions();
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
		enterRule(_localctx, 6, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98); match(26);
			setState(99); identifierOrListIndex();
			setState(100); declarationParameters();
			setState(101); match(32);
			setState(104);
			switch (_input.LA(1)) {
			case 5:
			case 12:
			case 16:
			case 28:
			case 29:
			case 30:
			case Identifier:
				{
				setState(102); type();
				}
				break;
			case 25:
				{
				setState(103); nothing();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(107); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(106); newline();
				}
				}
				setState(109); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==6 || _la==10 );
			setState(111); stmts();
			setState(112); match(8);
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
		enterRule(_localctx, 8, RULE_moreFunctions);
		int _la;
		try {
			setState(127);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(115); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(114); newline();
					}
					}
					setState(117); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==6 || _la==10 );
				setState(119); block();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==6 || _la==10) {
					{
					{
					setState(121); newline();
					}
					}
					setState(126);
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
			setState(129); match(LPAREN);
			setState(138);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 13) | (1L << 15) | (1L << 21) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << DecimalLiteral) | (1L << StringLiteral) | (1L << ADD) | (1L << SUB) | (1L << LPAREN))) != 0)) {
				{
				setState(130); expression(0);
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4) {
					{
					{
					setState(131); match(4);
					setState(132); expression(0);
					}
					}
					setState(137);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(140); match(RPAREN);
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
			setState(142); match(LPAREN);
			setState(151);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 5) | (1L << 12) | (1L << 16) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << Identifier))) != 0)) {
				{
				setState(143); declaration();
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4) {
					{
					{
					setState(144); match(4);
					setState(145); declaration();
					}
					}
					setState(150);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(153); match(RPAREN);
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
			setState(155); declaration();
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4) {
				{
				{
				setState(156); match(4);
				setState(157); declaration();
				}
				}
				setState(162);
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
			setState(172);
			switch (_input.LA(1)) {
			case 5:
			case 11:
			case 12:
			case 16:
			case 27:
			case 28:
			case 29:
			case 30:
			case 31:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(163); stmt();
				setState(165); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(164); newline();
					}
					}
					setState(167); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==6 || _la==10 );
				setState(169); stmts();
				}
				break;
			case 3:
			case 8:
			case 19:
			case 22:
			case 24:
				enterOuterAlt(_localctx, 2);
				{
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
			setState(182);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(174); declaration();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(175); assign();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(176); ifStmt();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(177); loop();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(178); funcCall();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(179); variableMethodCall();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(180); returnFunction();
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(181); incDec();
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
			setState(190);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(184); identifierOrListIndex();
				setState(185); match(INC);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(187); identifierOrListIndex();
				setState(188); match(DEC);
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
			setState(192); type();
			setState(193); identifierOrListIndex();
			setState(196);
			_la = _input.LA(1);
			if (_la==AnyAssign) {
				{
				setState(194); match(AnyAssign);
				setState(195); expression(0);
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
			setState(198); identifierOrListIndex();
			setState(199); match(AnyAssign);
			setState(200); expression(0);
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
		public TerminalNode RPAREN() { return getToken(HOMEParser.RPAREN, 0); }
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public List<NewlineContext> newline() {
			return getRuleContexts(NewlineContext.class);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(202); match(11);
			setState(203); match(LPAREN);
			setState(204); expression(0);
			setState(205); match(RPAREN);
			setState(207); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(206); newline();
				}
				}
				setState(209); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==6 || _la==10 );
			setState(211); stmts();
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==22) {
				{
				{
				setState(212); elseIfStmt();
				}
				}
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(219);
			_la = _input.LA(1);
			if (_la==19) {
				{
				setState(218); elseStmt();
				}
			}

			setState(221); match(3);
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
		public TerminalNode RPAREN() { return getToken(HOMEParser.RPAREN, 0); }
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public List<NewlineContext> newline() {
			return getRuleContexts(NewlineContext.class);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223); match(22);
			setState(224); match(LPAREN);
			setState(225); expression(0);
			setState(226); match(RPAREN);
			setState(228); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(227); newline();
				}
				}
				setState(230); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==6 || _la==10 );
			setState(232); stmts();
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234); match(19);
			setState(236); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(235); newline();
				}
				}
				setState(238); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==6 || _la==10 );
			setState(241);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(240); stmts();
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
			setState(245);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(243); loopWhileOrUntil();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(244); loopForeach();
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
		public TerminalNode RPAREN() { return getToken(HOMEParser.RPAREN, 0); }
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public List<NewlineContext> newline() {
			return getRuleContexts(NewlineContext.class);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(247); match(31);
			setState(248);
			_la = _input.LA(1);
			if ( !(_la==9 || _la==14) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(249); match(LPAREN);
			setState(250); expression(0);
			setState(251); match(RPAREN);
			setState(253); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(252); newline();
				}
				}
				setState(255); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==6 || _la==10 );
			setState(257); stmts();
			setState(258); match(24);
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
		public TerminalNode RPAREN() { return getToken(HOMEParser.RPAREN, 0); }
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260); match(31);
			setState(261); match(33);
			setState(262); match(LPAREN);
			setState(263); type();
			setState(264); identifierOrListIndex();
			setState(265); match(2);
			setState(266); identifierOrListIndex();
			setState(267); match(RPAREN);
			setState(269); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(268); newline();
				}
				}
				setState(271); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==6 || _la==10 );
			setState(273); stmts();
			setState(274); match(24);
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
			setState(276); identifierOrListIndex();
			setState(277); funcParameters();
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
			setState(279); identifierOrListIndex();
			setState(280); match(DOT);
			setState(281); funcCall();
			setState(286);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(282); match(DOT);
					setState(283); funcCall();
					}
					} 
				}
				setState(288);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
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
			setState(289); match(27);
			setState(291);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 13) | (1L << 15) | (1L << 21) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << DecimalLiteral) | (1L << StringLiteral) | (1L << ADD) | (1L << SUB) | (1L << LPAREN))) != 0)) {
				{
				setState(290); expression(0);
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
			setState(295);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(293); identifierOrListIndex();
				}
				break;
			case 13:
			case 21:
			case IntegerLiteral:
			case DecimalLiteral:
			case StringLiteral:
				{
				setState(294); literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(297); logicalOperator();
			setState(300);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(298); identifierOrListIndex();
				}
				break;
			case 13:
			case 21:
			case IntegerLiteral:
			case DecimalLiteral:
			case StringLiteral:
				{
				setState(299); literal();
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
			setState(308);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(302); match(Identifier);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(303); match(Identifier);
				setState(304); match(7);
				setState(305); expression(0);
				setState(306); match(1);
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
			setState(322);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(311);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUB) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(312); expression(8);
				}
				break;

			case 2:
				{
				setState(313); funcCall();
				}
				break;

			case 3:
				{
				setState(314); literal();
				}
				break;

			case 4:
				{
				setState(315); collectionInit();
				}
				break;

			case 5:
				{
				setState(316); variableMethodCall();
				}
				break;

			case 6:
				{
				setState(317); identifierOrListIndex();
				}
				break;

			case 7:
				{
				setState(318); match(LPAREN);
				setState(319); expression(0);
				setState(320); match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(336);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(334);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(324);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(325);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(326); expression(11);
						}
						break;

					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(327);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(328);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(329); expression(10);
						}
						break;

					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(330);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(331); logicalOperator();
						setState(332); expression(8);
						}
						break;
					}
					} 
				}
				setState(338);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
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
		enterRule(_localctx, 50, RULE_literal);
		try {
			setState(343);
			switch (_input.LA(1)) {
			case 13:
			case 21:
				enterOuterAlt(_localctx, 1);
				{
				setState(339); booleanLiteral();
				}
				break;
			case DecimalLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(340); match(DecimalLiteral);
				}
				break;
			case IntegerLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(341); match(IntegerLiteral);
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 4);
				{
				setState(342); match(StringLiteral);
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
		enterRule(_localctx, 52, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			_la = _input.LA(1);
			if ( !(_la==13 || _la==21) ) {
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
		enterRule(_localctx, 54, RULE_collectionInit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347); match(15);
			setState(356);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 13) | (1L << 15) | (1L << 21) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << DecimalLiteral) | (1L << StringLiteral) | (1L << ADD) | (1L << SUB) | (1L << LPAREN))) != 0)) {
				{
				setState(348); expression(0);
				setState(353);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4) {
					{
					{
					setState(349); match(4);
					setState(350); expression(0);
					}
					}
					setState(355);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(358); match(20);
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
		enterRule(_localctx, 56, RULE_type);
		try {
			setState(363);
			switch (_input.LA(1)) {
			case 16:
			case 28:
			case 29:
			case 30:
				enterOuterAlt(_localctx, 1);
				{
				setState(360); primitiveType();
				}
				break;
			case 5:
			case 12:
				enterOuterAlt(_localctx, 2);
				{
				setState(361); collectionType();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 3);
				{
				setState(362); classes();
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
		enterRule(_localctx, 58, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 16) | (1L << 28) | (1L << 29) | (1L << 30))) != 0)) ) {
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
		enterRule(_localctx, 60, RULE_collectionType);
		try {
			setState(377);
			switch (_input.LA(1)) {
			case 12:
				enterOuterAlt(_localctx, 1);
				{
				setState(367); match(12);
				setState(368); match(LT);
				setState(369); type();
				setState(370); match(GT);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 2);
				{
				setState(372); match(5);
				setState(373); match(LT);
				setState(374); type();
				setState(375); match(GT);
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
		public TerminalNode Identifier() { return getToken(HOMEParser.Identifier, 0); }
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
		enterRule(_localctx, 62, RULE_classes);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379); match(Identifier);
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
		enterRule(_localctx, 64, RULE_port);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381); match(17);
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
		enterRule(_localctx, 66, RULE_nothing);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(383); match(25);
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
		enterRule(_localctx, 68, RULE_logicalOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(385);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 18) | (1L << 23) | (1L << NOTEQUAL) | (1L << EQUAL) | (1L << GT) | (1L << LT) | (1L << LE) | (1L << GE))) != 0)) ) {
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

	public static class NewlineContext extends ParserRuleContext {
		public NewlineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterNewline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitNewline(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitNewline(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewlineContext newline() throws RecognitionException {
		NewlineContext _localctx = new NewlineContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_newline);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(388);
			_la = _input.LA(1);
			if (_la==10) {
				{
				setState(387); match(10);
				}
			}

			setState(390); match(6);
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
		case 0: return precpred(_ctx, 10);

		case 1: return precpred(_ctx, 9);

		case 2: return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3G\u018b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\3\2\3\2\3\2\3\3\3\3\6\3Q\n\3\r\3\16"+
		"\3R\3\3\3\3\3\3\3\3\6\3Y\n\3\r\3\16\3Z\3\3\3\3\3\3\5\3`\n\3\3\4\3\4\3"+
		"\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5k\n\5\3\5\6\5n\n\5\r\5\16\5o\3\5\3\5\3\5"+
		"\3\6\6\6v\n\6\r\6\16\6w\3\6\3\6\3\6\7\6}\n\6\f\6\16\6\u0080\13\6\5\6\u0082"+
		"\n\6\3\7\3\7\3\7\3\7\7\7\u0088\n\7\f\7\16\7\u008b\13\7\5\7\u008d\n\7\3"+
		"\7\3\7\3\b\3\b\3\b\3\b\7\b\u0095\n\b\f\b\16\b\u0098\13\b\5\b\u009a\n\b"+
		"\3\b\3\b\3\t\3\t\3\t\7\t\u00a1\n\t\f\t\16\t\u00a4\13\t\3\n\3\n\6\n\u00a8"+
		"\n\n\r\n\16\n\u00a9\3\n\3\n\3\n\5\n\u00af\n\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13\u00b9\n\13\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00c1\n\f"+
		"\3\r\3\r\3\r\3\r\5\r\u00c7\n\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\17\6\17\u00d2\n\17\r\17\16\17\u00d3\3\17\3\17\7\17\u00d8\n\17\f\17"+
		"\16\17\u00db\13\17\3\17\5\17\u00de\n\17\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\3\20\6\20\u00e7\n\20\r\20\16\20\u00e8\3\20\3\20\3\21\3\21\6\21\u00ef"+
		"\n\21\r\21\16\21\u00f0\3\21\5\21\u00f4\n\21\3\22\3\22\5\22\u00f8\n\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\6\23\u0100\n\23\r\23\16\23\u0101\3\23\3"+
		"\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\6\24\u0110\n\24"+
		"\r\24\16\24\u0111\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3"+
		"\26\7\26\u011f\n\26\f\26\16\26\u0122\13\26\3\27\3\27\5\27\u0126\n\27\3"+
		"\30\3\30\5\30\u012a\n\30\3\30\3\30\3\30\5\30\u012f\n\30\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\5\31\u0137\n\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\5\32\u0145\n\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\7\32\u0151\n\32\f\32\16\32\u0154\13\32\3\33\3\33\3\33"+
		"\3\33\5\33\u015a\n\33\3\34\3\34\3\35\3\35\3\35\3\35\7\35\u0162\n\35\f"+
		"\35\16\35\u0165\13\35\5\35\u0167\n\35\3\35\3\35\3\36\3\36\3\36\5\36\u016e"+
		"\n\36\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u017c\n \3!\3!\3\"\3"+
		"\"\3#\3#\3$\3$\3%\5%\u0187\n%\3%\3%\3%\2\3\62&\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFH\2\b\4\2\13\13\20\20\3\2"+
		"\64\65\3\2\668\4\2\17\17\27\27\4\2\22\22\36 \5\2\24\24\31\31,\61\u019f"+
		"\2J\3\2\2\2\4_\3\2\2\2\6a\3\2\2\2\bd\3\2\2\2\n\u0081\3\2\2\2\f\u0083\3"+
		"\2\2\2\16\u0090\3\2\2\2\20\u009d\3\2\2\2\22\u00ae\3\2\2\2\24\u00b8\3\2"+
		"\2\2\26\u00c0\3\2\2\2\30\u00c2\3\2\2\2\32\u00c8\3\2\2\2\34\u00cc\3\2\2"+
		"\2\36\u00e1\3\2\2\2 \u00ec\3\2\2\2\"\u00f7\3\2\2\2$\u00f9\3\2\2\2&\u0106"+
		"\3\2\2\2(\u0116\3\2\2\2*\u0119\3\2\2\2,\u0123\3\2\2\2.\u0129\3\2\2\2\60"+
		"\u0136\3\2\2\2\62\u0144\3\2\2\2\64\u0159\3\2\2\2\66\u015b\3\2\2\28\u015d"+
		"\3\2\2\2:\u016d\3\2\2\2<\u016f\3\2\2\2>\u017b\3\2\2\2@\u017d\3\2\2\2B"+
		"\u017f\3\2\2\2D\u0181\3\2\2\2F\u0183\3\2\2\2H\u0186\3\2\2\2JK\5\4\3\2"+
		"KL\5\6\4\2LM\7\2\2\3M\3\3\2\2\2NP\5\30\r\2OQ\5H%\2PO\3\2\2\2QR\3\2\2\2"+
		"RP\3\2\2\2RS\3\2\2\2ST\3\2\2\2TU\5\4\3\2U`\3\2\2\2VX\5\32\16\2WY\5H%\2"+
		"XW\3\2\2\2YZ\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\]\5\4\3\2]`\3\2\2"+
		"\2^`\3\2\2\2_N\3\2\2\2_V\3\2\2\2_^\3\2\2\2`\5\3\2\2\2ab\5\b\5\2bc\5\n"+
		"\6\2c\7\3\2\2\2de\7\34\2\2ef\5\60\31\2fg\5\16\b\2gj\7\"\2\2hk\5:\36\2"+
		"ik\5D#\2jh\3\2\2\2ji\3\2\2\2km\3\2\2\2ln\5H%\2ml\3\2\2\2no\3\2\2\2om\3"+
		"\2\2\2op\3\2\2\2pq\3\2\2\2qr\5\22\n\2rs\7\n\2\2s\t\3\2\2\2tv\5H%\2ut\3"+
		"\2\2\2vw\3\2\2\2wu\3\2\2\2wx\3\2\2\2xy\3\2\2\2yz\5\6\4\2z\u0082\3\2\2"+
		"\2{}\5H%\2|{\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\u0082\3"+
		"\2\2\2\u0080~\3\2\2\2\u0081u\3\2\2\2\u0081~\3\2\2\2\u0082\13\3\2\2\2\u0083"+
		"\u008c\7<\2\2\u0084\u0089\5\62\32\2\u0085\u0086\7\6\2\2\u0086\u0088\5"+
		"\62\32\2\u0087\u0085\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089"+
		"\u008a\3\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u0084\3\2"+
		"\2\2\u008c\u008d\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\7=\2\2\u008f"+
		"\r\3\2\2\2\u0090\u0099\7<\2\2\u0091\u0096\5\30\r\2\u0092\u0093\7\6\2\2"+
		"\u0093\u0095\5\30\r\2\u0094\u0092\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0094"+
		"\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0099"+
		"\u0091\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\7="+
		"\2\2\u009c\17\3\2\2\2\u009d\u00a2\5\30\r\2\u009e\u009f\7\6\2\2\u009f\u00a1"+
		"\5\30\r\2\u00a0\u009e\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0\3\2\2\2"+
		"\u00a2\u00a3\3\2\2\2\u00a3\21\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00a7"+
		"\5\24\13\2\u00a6\u00a8\5H%\2\u00a7\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9"+
		"\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\5\22"+
		"\n\2\u00ac\u00af\3\2\2\2\u00ad\u00af\3\2\2\2\u00ae\u00a5\3\2\2\2\u00ae"+
		"\u00ad\3\2\2\2\u00af\23\3\2\2\2\u00b0\u00b9\5\30\r\2\u00b1\u00b9\5\32"+
		"\16\2\u00b2\u00b9\5\34\17\2\u00b3\u00b9\5\"\22\2\u00b4\u00b9\5(\25\2\u00b5"+
		"\u00b9\5*\26\2\u00b6\u00b9\5,\27\2\u00b7\u00b9\5\26\f\2\u00b8\u00b0\3"+
		"\2\2\2\u00b8\u00b1\3\2\2\2\u00b8\u00b2\3\2\2\2\u00b8\u00b3\3\2\2\2\u00b8"+
		"\u00b4\3\2\2\2\u00b8\u00b5\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b7\3\2"+
		"\2\2\u00b9\25\3\2\2\2\u00ba\u00bb\5\60\31\2\u00bb\u00bc\7\62\2\2\u00bc"+
		"\u00c1\3\2\2\2\u00bd\u00be\5\60\31\2\u00be\u00bf\7\63\2\2\u00bf\u00c1"+
		"\3\2\2\2\u00c0\u00ba\3\2\2\2\u00c0\u00bd\3\2\2\2\u00c1\27\3\2\2\2\u00c2"+
		"\u00c3\5:\36\2\u00c3\u00c6\5\60\31\2\u00c4\u00c5\7>\2\2\u00c5\u00c7\5"+
		"\62\32\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\31\3\2\2\2\u00c8"+
		"\u00c9\5\60\31\2\u00c9\u00ca\7>\2\2\u00ca\u00cb\5\62\32\2\u00cb\33\3\2"+
		"\2\2\u00cc\u00cd\7\r\2\2\u00cd\u00ce\7<\2\2\u00ce\u00cf\5\62\32\2\u00cf"+
		"\u00d1\7=\2\2\u00d0\u00d2\5H%\2\u00d1\u00d0\3\2\2\2\u00d2\u00d3\3\2\2"+
		"\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d9"+
		"\5\22\n\2\u00d6\u00d8\5\36\20\2\u00d7\u00d6\3\2\2\2\u00d8\u00db\3\2\2"+
		"\2\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9"+
		"\3\2\2\2\u00dc\u00de\5 \21\2\u00dd\u00dc\3\2\2\2\u00dd\u00de\3\2\2\2\u00de"+
		"\u00df\3\2\2\2\u00df\u00e0\7\5\2\2\u00e0\35\3\2\2\2\u00e1\u00e2\7\30\2"+
		"\2\u00e2\u00e3\7<\2\2\u00e3\u00e4\5\62\32\2\u00e4\u00e6\7=\2\2\u00e5\u00e7"+
		"\5H%\2\u00e6\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8"+
		"\u00e9\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\5\22\n\2\u00eb\37\3\2\2"+
		"\2\u00ec\u00ee\7\25\2\2\u00ed\u00ef\5H%\2\u00ee\u00ed\3\2\2\2\u00ef\u00f0"+
		"\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f3\3\2\2\2\u00f2"+
		"\u00f4\5\22\n\2\u00f3\u00f2\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4!\3\2\2\2"+
		"\u00f5\u00f8\5$\23\2\u00f6\u00f8\5&\24\2\u00f7\u00f5\3\2\2\2\u00f7\u00f6"+
		"\3\2\2\2\u00f8#\3\2\2\2\u00f9\u00fa\7!\2\2\u00fa\u00fb\t\2\2\2\u00fb\u00fc"+
		"\7<\2\2\u00fc\u00fd\5\62\32\2\u00fd\u00ff\7=\2\2\u00fe\u0100\5H%\2\u00ff"+
		"\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2"+
		"\2\2\u0102\u0103\3\2\2\2\u0103\u0104\5\22\n\2\u0104\u0105\7\32\2\2\u0105"+
		"%\3\2\2\2\u0106\u0107\7!\2\2\u0107\u0108\7#\2\2\u0108\u0109\7<\2\2\u0109"+
		"\u010a\5:\36\2\u010a\u010b\5\60\31\2\u010b\u010c\7\4\2\2\u010c\u010d\5"+
		"\60\31\2\u010d\u010f\7=\2\2\u010e\u0110\5H%\2\u010f\u010e\3\2\2\2\u0110"+
		"\u0111\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0113\3\2"+
		"\2\2\u0113\u0114\5\22\n\2\u0114\u0115\7\32\2\2\u0115\'\3\2\2\2\u0116\u0117"+
		"\5\60\31\2\u0117\u0118\5\f\7\2\u0118)\3\2\2\2\u0119\u011a\5\60\31\2\u011a"+
		"\u011b\7)\2\2\u011b\u0120\5(\25\2\u011c\u011d\7)\2\2\u011d\u011f\5(\25"+
		"\2\u011e\u011c\3\2\2\2\u011f\u0122\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121"+
		"\3\2\2\2\u0121+\3\2\2\2\u0122\u0120\3\2\2\2\u0123\u0125\7\35\2\2\u0124"+
		"\u0126\5\62\32\2\u0125\u0124\3\2\2\2\u0125\u0126\3\2\2\2\u0126-\3\2\2"+
		"\2\u0127\u012a\5\60\31\2\u0128\u012a\5\64\33\2\u0129\u0127\3\2\2\2\u0129"+
		"\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u012e\5F$\2\u012c\u012f\5\60"+
		"\31\2\u012d\u012f\5\64\33\2\u012e\u012c\3\2\2\2\u012e\u012d\3\2\2\2\u012f"+
		"/\3\2\2\2\u0130\u0137\7$\2\2\u0131\u0132\7$\2\2\u0132\u0133\7\t\2\2\u0133"+
		"\u0134\5\62\32\2\u0134\u0135\7\3\2\2\u0135\u0137\3\2\2\2\u0136\u0130\3"+
		"\2\2\2\u0136\u0131\3\2\2\2\u0137\61\3\2\2\2\u0138\u0139\b\32\1\2\u0139"+
		"\u013a\t\3\2\2\u013a\u0145\5\62\32\n\u013b\u0145\5(\25\2\u013c\u0145\5"+
		"\64\33\2\u013d\u0145\58\35\2\u013e\u0145\5*\26\2\u013f\u0145\5\60\31\2"+
		"\u0140\u0141\7<\2\2\u0141\u0142\5\62\32\2\u0142\u0143\7=\2\2\u0143\u0145"+
		"\3\2\2\2\u0144\u0138\3\2\2\2\u0144\u013b\3\2\2\2\u0144\u013c\3\2\2\2\u0144"+
		"\u013d\3\2\2\2\u0144\u013e\3\2\2\2\u0144\u013f\3\2\2\2\u0144\u0140\3\2"+
		"\2\2\u0145\u0152\3\2\2\2\u0146\u0147\f\f\2\2\u0147\u0148\t\4\2\2\u0148"+
		"\u0151\5\62\32\r\u0149\u014a\f\13\2\2\u014a\u014b\t\3\2\2\u014b\u0151"+
		"\5\62\32\f\u014c\u014d\f\t\2\2\u014d\u014e\5F$\2\u014e\u014f\5\62\32\n"+
		"\u014f\u0151\3\2\2\2\u0150\u0146\3\2\2\2\u0150\u0149\3\2\2\2\u0150\u014c"+
		"\3\2\2\2\u0151\u0154\3\2\2\2\u0152\u0150\3\2\2\2\u0152\u0153\3\2\2\2\u0153"+
		"\63\3\2\2\2\u0154\u0152\3\2\2\2\u0155\u015a\5\66\34\2\u0156\u015a\7&\2"+
		"\2\u0157\u015a\7%\2\2\u0158\u015a\7\'\2\2\u0159\u0155\3\2\2\2\u0159\u0156"+
		"\3\2\2\2\u0159\u0157\3\2\2\2\u0159\u0158\3\2\2\2\u015a\65\3\2\2\2\u015b"+
		"\u015c\t\5\2\2\u015c\67\3\2\2\2\u015d\u0166\7\21\2\2\u015e\u0163\5\62"+
		"\32\2\u015f\u0160\7\6\2\2\u0160\u0162\5\62\32\2\u0161\u015f\3\2\2\2\u0162"+
		"\u0165\3\2\2\2\u0163\u0161\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0167\3\2"+
		"\2\2\u0165\u0163\3\2\2\2\u0166\u015e\3\2\2\2\u0166\u0167\3\2\2\2\u0167"+
		"\u0168\3\2\2\2\u0168\u0169\7\26\2\2\u01699\3\2\2\2\u016a\u016e\5<\37\2"+
		"\u016b\u016e\5> \2\u016c\u016e\5@!\2\u016d\u016a\3\2\2\2\u016d\u016b\3"+
		"\2\2\2\u016d\u016c\3\2\2\2\u016e;\3\2\2\2\u016f\u0170\t\6\2\2\u0170=\3"+
		"\2\2\2\u0171\u0172\7\16\2\2\u0172\u0173\7/\2\2\u0173\u0174\5:\36\2\u0174"+
		"\u0175\7.\2\2\u0175\u017c\3\2\2\2\u0176\u0177\7\7\2\2\u0177\u0178\7/\2"+
		"\2\u0178\u0179\5:\36\2\u0179\u017a\7.\2\2\u017a\u017c\3\2\2\2\u017b\u0171"+
		"\3\2\2\2\u017b\u0176\3\2\2\2\u017c?\3\2\2\2\u017d\u017e\7$\2\2\u017eA"+
		"\3\2\2\2\u017f\u0180\7\23\2\2\u0180C\3\2\2\2\u0181\u0182\7\33\2\2\u0182"+
		"E\3\2\2\2\u0183\u0184\t\7\2\2\u0184G\3\2\2\2\u0185\u0187\7\f\2\2\u0186"+
		"\u0185\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u0188\3\2\2\2\u0188\u0189\7\b"+
		"\2\2\u0189I\3\2\2\2+RZ_jow~\u0081\u0089\u008c\u0096\u0099\u00a2\u00a9"+
		"\u00ae\u00b8\u00c0\u00c6\u00d3\u00d9\u00dd\u00e8\u00f0\u00f3\u00f7\u0101"+
		"\u0111\u0120\u0125\u0129\u012e\u0136\u0144\u0150\u0152\u0159\u0163\u0166"+
		"\u016d\u017b\u0186";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}