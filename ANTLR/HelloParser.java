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
		T__33=1, T__32=2, T__31=3, T__30=4, T__29=5, T__28=6, T__27=7, T__26=8,
		T__25=9, T__24=10, T__23=11, T__22=12, T__21=13, T__20=14, T__19=15, T__18=16,
		T__17=17, T__16=18, T__15=19, T__14=20, T__13=21, T__12=22, T__11=23,
		T__10=24, T__9=25, T__8=26, T__7=27, T__6=28, T__5=29, T__4=30, T__3=31,
		T__2=32, T__1=33, T__0=34, Identifier=35, IntegerLiteral=36, DecimalLiteral=37,
		StringLiteral=38, NullLiteral=39, DOT=40, ASSIGN=41, BANG=42, SEMICOLON=43,
		EQUAL=44, GT=45, LT=46, LE=47, GE=48, NOTEQUAL=49, INC=50, DEC=51, ADD=52,
		SUB=53, MUL=54, DIV=55, MOD=56, LPAREN=57, RPAREN=58, ADD_ASSIGN=59, SUB_ASSIGN=60,
		MUL_ASSIGN=61, DIV_ASSIGN=62, AND_ASSIGN=63, MOD_ASSIGN=64, WS=65, COMMENT=66,
		LINE_COMMENT=67;
	public static final String[] tokenNames = {
		"<INVALID>", "']'", "'in'", "'endif'", "','", "'Dictionary'", "'['", "'endfunction'", 
		"'while'", "'Input'", "'if'", "'List'", "'false'", "'until'", "'{'", "'Decimal'", 
		"'PORT'", "'OR'", "'else'", "'}'", "'true'", "'Time'", "'elseif'", "'AND'",
		"'endrepeat'", "'Nothing'", "'function'", "'return'", "'Boolean'", "'String'",
		"'Integer'", "'repeat'", "'Output'", "'returns'", "'foreach'", "Identifier",
		"IntegerLiteral", "DecimalLiteral", "StringLiteral", "'null'", "'.'",
		"'='", "'!'", "';'", "'=='", "'>'", "'<'", "'<='", "'>='", "'!='", "'++'",
		"'--'", "'+'", "'-'", "'*'", "'/'", "'%'", "'('", "')'", "'+='", "'-='", 
		"'*='", "'/='", "'&='", "'%='", "WS", "COMMENT", "LINE_COMMENT"
	};
	public static final int
		RULE_program = 0, RULE_block = 1, RULE_function = 2, RULE_funcParameters = 3, 
		RULE_declarationParameters = 4, RULE_declarationParameterList = 5, RULE_stmts = 6, 
		RULE_stmt = 7, RULE_declaration = 8, RULE_assign = 9, RULE_ifStmt = 10, 
		RULE_elseIfStmt = 11, RULE_elseStmt = 12, RULE_loop = 13, RULE_loopWhileOrUntil = 14, 
		RULE_loopForeach = 15, RULE_funcCall = 16, RULE_variableMethodCall = 17, 
		RULE_returnFunction = 18, RULE_condition = 19, RULE_identifierOrListIndex = 20, 
		RULE_expression = 21, RULE_constructClass = 22, RULE_constructClassPort = 23, 
		RULE_literal = 24, RULE_booleanLiteral = 25, RULE_collectionInit = 26, 
		RULE_type = 27, RULE_primitiveType = 28, RULE_collectionType = 29, RULE_classes = 30, 
		RULE_port = 31, RULE_nothing = 32, RULE_logicalOperator = 33;
	public static final String[] ruleNames = {
		"program", "block", "function", "funcParameters", "declarationParameters", 
		"declarationParameterList", "stmts", "stmt", "declaration", "assign", 
		"ifStmt", "elseIfStmt", "elseStmt", "loop", "loopWhileOrUntil", "loopForeach", 
		"funcCall", "variableMethodCall", "returnFunction", "condition", "identifierOrListIndex", 
		"expression", "constructClass", "constructClassPort", "literal", "booleanLiteral", 
		"collectionInit", "type", "primitiveType", "collectionType", "classes", 
		"port", "nothing", "logicalOperator"
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
			setState(68); block();
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
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
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
		enterRule(_localctx, 2, RULE_block);
		try {
			setState(74);
			switch (_input.LA(1)) {
			case 26:
				enterOuterAlt(_localctx, 1);
				{
				setState(70); function();
				setState(71); block();
				}
				break;
			case EOF:
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

	public static class FunctionContext extends ParserRuleContext {
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
		enterRule(_localctx, 4, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76); match(26);
			setState(77); identifierOrListIndex();
			setState(78); declarationParameters();
			setState(79); match(33);
			setState(82);
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
				setState(80); type();
				}
				break;
			case 25:
				{
				setState(81); nothing();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(84); stmts();
			setState(85); match(7);
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
		enterRule(_localctx, 6, RULE_funcParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87); match(LPAREN);
			setState(96);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 9) | (1L << 12) | (1L << 14) | (1L << 20) | (1L << 21) | (1L << 32) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << DecimalLiteral) | (1L << StringLiteral) | (1L << LPAREN))) != 0)) {
				{
				setState(88); expression(0);
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4) {
					{
					{
					setState(89); match(4);
					setState(90); expression(0);
					}
					}
					setState(95);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(98); match(RPAREN);
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
		enterRule(_localctx, 8, RULE_declarationParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100); match(LPAREN);
			setState(109);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 5) | (1L << 9) | (1L << 11) | (1L << 15) | (1L << 21) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << 32))) != 0)) {
				{
				setState(101); declaration();
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4) {
					{
					{
					setState(102); match(4);
					setState(103); declaration();
					}
					}
					setState(108);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(111); match(RPAREN);
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
		enterRule(_localctx, 10, RULE_declarationParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113); declaration();
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4) {
				{
				{
				setState(114); match(4);
				setState(115); declaration();
				}
				}
				setState(120);
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
		enterRule(_localctx, 12, RULE_stmts);
		try {
			setState(125);
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
				setState(121); stmt();
				setState(122); stmts();
				}
				break;
			case 3:
			case 7:
			case 18:
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
		enterRule(_localctx, 14, RULE_stmt);
		try {
			setState(134);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(127); declaration();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(128); assign();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(129); ifStmt();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(130); loop();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(131); funcCall();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(132); variableMethodCall();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(133); returnFunction();
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
		public TerminalNode ASSIGN() { return getToken(HelloParser.ASSIGN, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
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
		enterRule(_localctx, 16, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136); type();
			setState(137); identifierOrListIndex();
			setState(140);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(138); match(ASSIGN);
				setState(139); expression(0);
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
		public TerminalNode ASSIGN() { return getToken(HelloParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
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
		enterRule(_localctx, 18, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142); identifierOrListIndex();
			setState(143); match(ASSIGN);
			setState(144); expression(0);
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
		enterRule(_localctx, 20, RULE_ifStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146); match(10);
			setState(147); match(LPAREN);
			setState(148); expression(0);
			setState(149); match(RPAREN);
			setState(150); stmts();
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==22) {
				{
				{
				setState(151); elseIfStmt();
				}
				}
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(158);
			_la = _input.LA(1);
			if (_la==18) {
				{
				setState(157); elseStmt();
				}
			}

			setState(160); match(3);
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
		public TerminalNode RPAREN() { return getToken(HelloParser.RPAREN, 0); }
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
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
		enterRule(_localctx, 22, RULE_elseIfStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162); match(22);
			setState(163); match(LPAREN);
			setState(164); expression(0);
			setState(165); match(RPAREN);
			setState(166); stmts();
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
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
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
		enterRule(_localctx, 24, RULE_elseStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168); match(18);
			setState(170);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(169); stmts();
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
		enterRule(_localctx, 26, RULE_loop);
		try {
			setState(174);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(172); loopWhileOrUntil();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(173); loopForeach();
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
		public TerminalNode RPAREN() { return getToken(HelloParser.RPAREN, 0); }
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
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
		enterRule(_localctx, 28, RULE_loopWhileOrUntil);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176); match(31);
			setState(177);
			_la = _input.LA(1);
			if ( !(_la==8 || _la==13) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(178); match(LPAREN);
			setState(179); expression(0);
			setState(180); match(RPAREN);
			setState(181); stmts();
			setState(182); match(24);
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
		public TerminalNode RPAREN() { return getToken(HelloParser.RPAREN, 0); }
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
		enterRule(_localctx, 30, RULE_loopForeach);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184); match(31);
			setState(185); match(34);
			setState(186); match(LPAREN);
			setState(187); type();
			setState(188); identifierOrListIndex();
			setState(189); match(2);
			setState(190); identifierOrListIndex();
			setState(191); match(RPAREN);
			setState(192); stmts();
			setState(193); match(24);
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
		enterRule(_localctx, 32, RULE_funcCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195); identifierOrListIndex();
			setState(196); funcParameters();
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
		enterRule(_localctx, 34, RULE_variableMethodCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198); identifierOrListIndex();
			setState(199); match(DOT);
			setState(200); funcCall();
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
		enterRule(_localctx, 36, RULE_returnFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202); match(27);
			setState(204);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(203); expression(0);
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
		enterRule(_localctx, 38, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(206); identifierOrListIndex();
				}
				break;
			case 12:
			case 20:
			case IntegerLiteral:
			case DecimalLiteral:
			case StringLiteral:
				{
				setState(207); literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(210); logicalOperator();
			setState(213);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(211); identifierOrListIndex();
				}
				break;
			case 12:
			case 20:
			case IntegerLiteral:
			case DecimalLiteral:
			case StringLiteral:
				{
				setState(212); literal();
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
		enterRule(_localctx, 40, RULE_identifierOrListIndex);
		try {
			setState(221);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(215); match(Identifier);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(216); match(Identifier);
				setState(217); match(6);
				setState(218); expression(0);
				setState(219); match(1);
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
		public FuncCallContext funcCall() {
			return getRuleContext(FuncCallContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(HelloParser.LPAREN, 0); }
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
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(224); match(LPAREN);
				setState(225); expression(0);
				setState(226); match(RPAREN);
				}
				break;

			case 2:
				{
				setState(228); funcCall();
				}
				break;

			case 3:
				{
				setState(229); literal();
				}
				break;

			case 4:
				{
				setState(230); collectionInit();
				}
				break;

			case 5:
				{
				setState(231); constructClass();
				}
				break;

			case 6:
				{
				setState(232); variableMethodCall();
				}
				break;

			case 7:
				{
				setState(233); identifierOrListIndex();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(248);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(246);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(236);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(237);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(238); expression(11);
						}
						break;

					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(239);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(240);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(241); expression(10);
						}
						break;

					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(242);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(243); logicalOperator();
						setState(244); expression(9);
						}
						break;
					}
					} 
				}
				setState(250);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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
		enterRule(_localctx, 44, RULE_constructClass);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251); classes();
			setState(252); match(LPAREN);
			setState(264);
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
			case LPAREN:
			case RPAREN:
				{
				{
				setState(254);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 9) | (1L << 12) | (1L << 14) | (1L << 20) | (1L << 21) | (1L << 32) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << DecimalLiteral) | (1L << StringLiteral) | (1L << LPAREN))) != 0)) {
					{
					setState(253); expression(0);
					}
				}

				setState(260);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4) {
					{
					{
					setState(256); match(4);
					setState(257); expression(0);
					}
					}
					setState(262);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case 16:
				{
				setState(263); constructClassPort();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(266); match(RPAREN);
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
		enterRule(_localctx, 46, RULE_constructClassPort);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268); port();
			setState(269); match(IntegerLiteral);
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
		enterRule(_localctx, 48, RULE_literal);
		try {
			setState(275);
			switch (_input.LA(1)) {
			case 12:
			case 20:
				enterOuterAlt(_localctx, 1);
				{
				setState(271); booleanLiteral();
				}
				break;
			case DecimalLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(272); match(DecimalLiteral);
				}
				break;
			case IntegerLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(273); match(IntegerLiteral);
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 4);
				{
				setState(274); match(StringLiteral);
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
		enterRule(_localctx, 50, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
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
		enterRule(_localctx, 52, RULE_collectionInit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279); match(14);
			setState(288);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 9) | (1L << 12) | (1L << 14) | (1L << 20) | (1L << 21) | (1L << 32) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << DecimalLiteral) | (1L << StringLiteral) | (1L << LPAREN))) != 0)) {
				{
				setState(280); expression(0);
				setState(285);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4) {
					{
					{
					setState(281); match(4);
					setState(282); expression(0);
					}
					}
					setState(287);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(290); match(19);
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
		enterRule(_localctx, 54, RULE_type);
		try {
			setState(295);
			switch (_input.LA(1)) {
			case 15:
			case 28:
			case 29:
			case 30:
				enterOuterAlt(_localctx, 1);
				{
				setState(292); primitiveType();
				}
				break;
			case 5:
			case 11:
				enterOuterAlt(_localctx, 2);
				{
				setState(293); collectionType();
				}
				break;
			case 9:
			case 21:
			case 32:
				enterOuterAlt(_localctx, 3);
				{
				setState(294); classes();
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
		enterRule(_localctx, 56, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
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
		enterRule(_localctx, 58, RULE_collectionType);
		try {
			setState(309);
			switch (_input.LA(1)) {
			case 11:
				enterOuterAlt(_localctx, 1);
				{
				setState(299); match(11);
				setState(300); match(LT);
				setState(301); type();
				setState(302); match(GT);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 2);
				{
				setState(304); match(5);
				setState(305); match(LT);
				setState(306); type();
				setState(307); match(GT);
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
		enterRule(_localctx, 60, RULE_classes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
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
		enterRule(_localctx, 62, RULE_port);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313); match(16);
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
		enterRule(_localctx, 64, RULE_nothing);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315); match(25);
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
		enterRule(_localctx, 66, RULE_logicalOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 17) | (1L << 23) | (1L << EQUAL) | (1L << GT) | (1L << LT) | (1L << LE) | (1L << GE) | (1L << NOTEQUAL))) != 0)) ) {
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
		case 21: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 10);

		case 1: return precpred(_ctx, 9);

		case 2: return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3E\u0142\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\3\3\3\3\3\3\3\5\3M\n\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\5\4U\n\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\7\5^\n\5\f\5\16\5a\13\5\5\5"+
		"c\n\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6k\n\6\f\6\16\6n\13\6\5\6p\n\6\3\6\3\6"+
		"\3\7\3\7\3\7\7\7w\n\7\f\7\16\7z\13\7\3\b\3\b\3\b\3\b\5\b\u0080\n\b\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0089\n\t\3\n\3\n\3\n\3\n\5\n\u008f\n\n\3"+
		"\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u009b\n\f\f\f\16\f\u009e"+
		"\13\f\3\f\5\f\u00a1\n\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\5\16"+
		"\u00ad\n\16\3\17\3\17\5\17\u00b1\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3"+
		"\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\5\24\u00cf\n\24\3\25\3\25\5\25"+
		"\u00d3\n\25\3\25\3\25\3\25\5\25\u00d8\n\25\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\5\26\u00e0\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\5\27\u00ed\n\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\7\27\u00f9\n\27\f\27\16\27\u00fc\13\27\3\30\3\30\3\30\5\30\u0101\n\30"+
		"\3\30\3\30\7\30\u0105\n\30\f\30\16\30\u0108\13\30\3\30\5\30\u010b\n\30"+
		"\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\5\32\u0116\n\32\3\33\3\33"+
		"\3\34\3\34\3\34\3\34\7\34\u011e\n\34\f\34\16\34\u0121\13\34\5\34\u0123"+
		"\n\34\3\34\3\34\3\35\3\35\3\35\5\35\u012a\n\35\3\36\3\36\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u0138\n\37\3 \3 \3!\3!\3\"\3"+
		"\"\3#\3#\3#\2\3,$\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\64\668:<>@BD\2\t\4\2\n\n\17\17\3\28:\3\2\66\67\4\2\16\16\26\26\4\2\21"+
		"\21\36 \5\2\13\13\27\27\"\"\5\2\23\23\31\31.\63\u014a\2F\3\2\2\2\4L\3"+
		"\2\2\2\6N\3\2\2\2\bY\3\2\2\2\nf\3\2\2\2\fs\3\2\2\2\16\177\3\2\2\2\20\u0088"+
		"\3\2\2\2\22\u008a\3\2\2\2\24\u0090\3\2\2\2\26\u0094\3\2\2\2\30\u00a4\3"+
		"\2\2\2\32\u00aa\3\2\2\2\34\u00b0\3\2\2\2\36\u00b2\3\2\2\2 \u00ba\3\2\2"+
		"\2\"\u00c5\3\2\2\2$\u00c8\3\2\2\2&\u00cc\3\2\2\2(\u00d2\3\2\2\2*\u00df"+
		"\3\2\2\2,\u00ec\3\2\2\2.\u00fd\3\2\2\2\60\u010e\3\2\2\2\62\u0115\3\2\2"+
		"\2\64\u0117\3\2\2\2\66\u0119\3\2\2\28\u0129\3\2\2\2:\u012b\3\2\2\2<\u0137"+
		"\3\2\2\2>\u0139\3\2\2\2@\u013b\3\2\2\2B\u013d\3\2\2\2D\u013f\3\2\2\2F"+
		"G\5\4\3\2G\3\3\2\2\2HI\5\6\4\2IJ\5\4\3\2JM\3\2\2\2KM\3\2\2\2LH\3\2\2\2"+
		"LK\3\2\2\2M\5\3\2\2\2NO\7\34\2\2OP\5*\26\2PQ\5\n\6\2QT\7#\2\2RU\58\35"+
		"\2SU\5B\"\2TR\3\2\2\2TS\3\2\2\2UV\3\2\2\2VW\5\16\b\2WX\7\t\2\2X\7\3\2"+
		"\2\2Yb\7;\2\2Z_\5,\27\2[\\\7\6\2\2\\^\5,\27\2][\3\2\2\2^a\3\2\2\2_]\3"+
		"\2\2\2_`\3\2\2\2`c\3\2\2\2a_\3\2\2\2bZ\3\2\2\2bc\3\2\2\2cd\3\2\2\2de\7"+
		"<\2\2e\t\3\2\2\2fo\7;\2\2gl\5\22\n\2hi\7\6\2\2ik\5\22\n\2jh\3\2\2\2kn"+
		"\3\2\2\2lj\3\2\2\2lm\3\2\2\2mp\3\2\2\2nl\3\2\2\2og\3\2\2\2op\3\2\2\2p"+
		"q\3\2\2\2qr\7<\2\2r\13\3\2\2\2sx\5\22\n\2tu\7\6\2\2uw\5\22\n\2vt\3\2\2"+
		"\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y\r\3\2\2\2zx\3\2\2\2{|\5\20\t\2|}\5\16"+
		"\b\2}\u0080\3\2\2\2~\u0080\3\2\2\2\177{\3\2\2\2\177~\3\2\2\2\u0080\17"+
		"\3\2\2\2\u0081\u0089\5\22\n\2\u0082\u0089\5\24\13\2\u0083\u0089\5\26\f"+
		"\2\u0084\u0089\5\34\17\2\u0085\u0089\5\"\22\2\u0086\u0089\5$\23\2\u0087"+
		"\u0089\5&\24\2\u0088\u0081\3\2\2\2\u0088\u0082\3\2\2\2\u0088\u0083\3\2"+
		"\2\2\u0088\u0084\3\2\2\2\u0088\u0085\3\2\2\2\u0088\u0086\3\2\2\2\u0088"+
		"\u0087\3\2\2\2\u0089\21\3\2\2\2\u008a\u008b\58\35\2\u008b\u008e\5*\26"+
		"\2\u008c\u008d\7+\2\2\u008d\u008f\5,\27\2\u008e\u008c\3\2\2\2\u008e\u008f"+
		"\3\2\2\2\u008f\23\3\2\2\2\u0090\u0091\5*\26\2\u0091\u0092\7+\2\2\u0092"+
		"\u0093\5,\27\2\u0093\25\3\2\2\2\u0094\u0095\7\f\2\2\u0095\u0096\7;\2\2"+
		"\u0096\u0097\5,\27\2\u0097\u0098\7<\2\2\u0098\u009c\5\16\b\2\u0099\u009b"+
		"\5\30\r\2\u009a\u0099\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2"+
		"\u009c\u009d\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a1"+
		"\5\32\16\2\u00a0\u009f\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\3\2\2\2"+
		"\u00a2\u00a3\7\5\2\2\u00a3\27\3\2\2\2\u00a4\u00a5\7\30\2\2\u00a5\u00a6"+
		"\7;\2\2\u00a6\u00a7\5,\27\2\u00a7\u00a8\7<\2\2\u00a8\u00a9\5\16\b\2\u00a9"+
		"\31\3\2\2\2\u00aa\u00ac\7\24\2\2\u00ab\u00ad\5\16\b\2\u00ac\u00ab\3\2"+
		"\2\2\u00ac\u00ad\3\2\2\2\u00ad\33\3\2\2\2\u00ae\u00b1\5\36\20\2\u00af"+
		"\u00b1\5 \21\2\u00b0\u00ae\3\2\2\2\u00b0\u00af\3\2\2\2\u00b1\35\3\2\2"+
		"\2\u00b2\u00b3\7!\2\2\u00b3\u00b4\t\2\2\2\u00b4\u00b5\7;\2\2\u00b5\u00b6"+
		"\5,\27\2\u00b6\u00b7\7<\2\2\u00b7\u00b8\5\16\b\2\u00b8\u00b9\7\32\2\2"+
		"\u00b9\37\3\2\2\2\u00ba\u00bb\7!\2\2\u00bb\u00bc\7$\2\2\u00bc\u00bd\7"+
		";\2\2\u00bd\u00be\58\35\2\u00be\u00bf\5*\26\2\u00bf\u00c0\7\4\2\2\u00c0"+
		"\u00c1\5*\26\2\u00c1\u00c2\7<\2\2\u00c2\u00c3\5\16\b\2\u00c3\u00c4\7\32"+
		"\2\2\u00c4!\3\2\2\2\u00c5\u00c6\5*\26\2\u00c6\u00c7\5\b\5\2\u00c7#\3\2"+
		"\2\2\u00c8\u00c9\5*\26\2\u00c9\u00ca\7*\2\2\u00ca\u00cb\5\"\22\2\u00cb"+
		"%\3\2\2\2\u00cc\u00ce\7\35\2\2\u00cd\u00cf\5,\27\2\u00ce\u00cd\3\2\2\2"+
		"\u00ce\u00cf\3\2\2\2\u00cf\'\3\2\2\2\u00d0\u00d3\5*\26\2\u00d1\u00d3\5"+
		"\62\32\2\u00d2\u00d0\3\2\2\2\u00d2\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4"+
		"\u00d7\5D#\2\u00d5\u00d8\5*\26\2\u00d6\u00d8\5\62\32\2\u00d7\u00d5\3\2"+
		"\2\2\u00d7\u00d6\3\2\2\2\u00d8)\3\2\2\2\u00d9\u00e0\7%\2\2\u00da\u00db"+
		"\7%\2\2\u00db\u00dc\7\b\2\2\u00dc\u00dd\5,\27\2\u00dd\u00de\7\3\2\2\u00de"+
		"\u00e0\3\2\2\2\u00df\u00d9\3\2\2\2\u00df\u00da\3\2\2\2\u00e0+\3\2\2\2"+
		"\u00e1\u00e2\b\27\1\2\u00e2\u00e3\7;\2\2\u00e3\u00e4\5,\27\2\u00e4\u00e5"+
		"\7<\2\2\u00e5\u00ed\3\2\2\2\u00e6\u00ed\5\"\22\2\u00e7\u00ed\5\62\32\2"+
		"\u00e8\u00ed\5\66\34\2\u00e9\u00ed\5.\30\2\u00ea\u00ed\5$\23\2\u00eb\u00ed"+
		"\5*\26\2\u00ec\u00e1\3\2\2\2\u00ec\u00e6\3\2\2\2\u00ec\u00e7\3\2\2\2\u00ec"+
		"\u00e8\3\2\2\2\u00ec\u00e9\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00eb\3\2"+
		"\2\2\u00ed\u00fa\3\2\2\2\u00ee\u00ef\f\f\2\2\u00ef\u00f0\t\3\2\2\u00f0"+
		"\u00f9\5,\27\r\u00f1\u00f2\f\13\2\2\u00f2\u00f3\t\4\2\2\u00f3\u00f9\5"+
		",\27\f\u00f4\u00f5\f\n\2\2\u00f5\u00f6\5D#\2\u00f6\u00f7\5,\27\13\u00f7"+
		"\u00f9\3\2\2\2\u00f8\u00ee\3\2\2\2\u00f8\u00f1\3\2\2\2\u00f8\u00f4\3\2"+
		"\2\2\u00f9\u00fc\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb"+
		"-\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fd\u00fe\5> \2\u00fe\u010a\7;\2\2\u00ff"+
		"\u0101\5,\27\2\u0100\u00ff\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u0106\3\2"+
		"\2\2\u0102\u0103\7\6\2\2\u0103\u0105\5,\27\2\u0104\u0102\3\2\2\2\u0105"+
		"\u0108\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u010b\3\2"+
		"\2\2\u0108\u0106\3\2\2\2\u0109\u010b\5\60\31\2\u010a\u0100\3\2\2\2\u010a"+
		"\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010d\7<\2\2\u010d/\3\2\2\2\u010e"+
		"\u010f\5@!\2\u010f\u0110\7&\2\2\u0110\61\3\2\2\2\u0111\u0116\5\64\33\2"+
		"\u0112\u0116\7\'\2\2\u0113\u0116\7&\2\2\u0114\u0116\7(\2\2\u0115\u0111"+
		"\3\2\2\2\u0115\u0112\3\2\2\2\u0115\u0113\3\2\2\2\u0115\u0114\3\2\2\2\u0116"+
		"\63\3\2\2\2\u0117\u0118\t\5\2\2\u0118\65\3\2\2\2\u0119\u0122\7\20\2\2"+
		"\u011a\u011f\5,\27\2\u011b\u011c\7\6\2\2\u011c\u011e\5,\27\2\u011d\u011b"+
		"\3\2\2\2\u011e\u0121\3\2\2\2\u011f\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120"+
		"\u0123\3\2\2\2\u0121\u011f\3\2\2\2\u0122\u011a\3\2\2\2\u0122\u0123\3\2"+
		"\2\2\u0123\u0124\3\2\2\2\u0124\u0125\7\25\2\2\u0125\67\3\2\2\2\u0126\u012a"+
		"\5:\36\2\u0127\u012a\5<\37\2\u0128\u012a\5> \2\u0129\u0126\3\2\2\2\u0129"+
		"\u0127\3\2\2\2\u0129\u0128\3\2\2\2\u012a9\3\2\2\2\u012b\u012c\t\6\2\2"+
		"\u012c;\3\2\2\2\u012d\u012e\7\r\2\2\u012e\u012f\7\60\2\2\u012f\u0130\5"+
		"8\35\2\u0130\u0131\7/\2\2\u0131\u0138\3\2\2\2\u0132\u0133\7\7\2\2\u0133"+
		"\u0134\7\60\2\2\u0134\u0135\58\35\2\u0135\u0136\7/\2\2\u0136\u0138\3\2"+
		"\2\2\u0137\u012d\3\2\2\2\u0137\u0132\3\2\2\2\u0138=\3\2\2\2\u0139\u013a"+
		"\t\7\2\2\u013a?\3\2\2\2\u013b\u013c\7\22\2\2\u013cA\3\2\2\2\u013d\u013e"+
		"\7\33\2\2\u013eC\3\2\2\2\u013f\u0140\t\b\2\2\u0140E\3\2\2\2\37LT_blox"+
		"\177\u0088\u008e\u009c\u00a0\u00ac\u00b0\u00ce\u00d2\u00d7\u00df\u00ec"+
		"\u00f8\u00fa\u0100\u0106\u010a\u0115\u011f\u0122\u0129\u0137";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}