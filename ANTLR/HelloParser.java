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
		T__24=1, T__23=2, T__22=3, T__21=4, T__20=5, T__19=6, T__18=7, T__17=8, 
		T__16=9, T__15=10, T__14=11, T__13=12, T__12=13, T__11=14, T__10=15, T__9=16, 
		T__8=17, T__7=18, T__6=19, T__5=20, T__4=21, T__3=22, T__2=23, T__1=24, 
		T__0=25, Identifier=26, Letter=27, LetterOrDigit=28, IntegerLiteral=29, 
		DecimalLiteral=30, StringLiteral=31, Digs=32, Digit=33, NullLiteral=34, 
		DOT=35, UPPERCASE=36, LOWERCASE=37, CHARACTER=38, UNDERSCORE=39, ASSIGN=40, 
		BANG=41, SEMICOLON=42, LOGICALOPERATOR=43, EQUAL=44, GT=45, LT=46, LE=47, 
		GE=48, NOTEQUAL=49, AND=50, OR=51, INC=52, DEC=53, ADD=54, SUB=55, MUL=56, 
		DIV=57, MOD=58, LPAREN=59, RPAREN=60, ADD_ASSIGN=61, SUB_ASSIGN=62, MUL_ASSIGN=63, 
		DIV_ASSIGN=64, AND_ASSIGN=65, MOD_ASSIGN=66, WS=67, COMMENT=68, LINE_COMMENT=69;
	public static final String[] tokenNames = {
		"<INVALID>", "'&'", "'in'", "'endif'", "','", "'Dictionary'", "'endfunction'", 
		"'while'", "'if'", "'List'", "'false'", "'until'", "'Decimal'", "'{'", 
		"'else'", "'}'", "'true'", "'elseif'", "'endrepeat'", "'function'", "'Boolean'", 
		"'String'", "'Integer'", "'repeat'", "'returns'", "'foreach'", "Identifier", 
		"Letter", "LetterOrDigit", "IntegerLiteral", "DecimalLiteral", "StringLiteral", 
		"Digs", "Digit", "'null'", "'.'", "UPPERCASE", "LOWERCASE", "CHARACTER", 
		"'_'", "'='", "'!'", "';'", "LOGICALOPERATOR", "'=='", "'>'", "'<'", "'<='", 
		"'>='", "'!='", "'AND'", "'OR'", "'++'", "'--'", "'+'", "'-'", "'*'", 
		"'/'", "'%'", "'('", "')'", "'+='", "'-='", "'*='", "'/='", "'&='", "'%='", 
		"WS", "COMMENT", "LINE_COMMENT"
	};
	public static final int
		RULE_programtest = 0, RULE_teststmts = 1, RULE_function = 2, RULE_funcParameters = 3, 
		RULE_declarationParameters = 4, RULE_declarationParameterList = 5, RULE_program = 6, 
		RULE_stmts = 7, RULE_stmt = 8, RULE_loop = 9, RULE_ifStmt = 10, RULE_elseIfStmt = 11, 
		RULE_elseStmt = 12, RULE_condition = 13, RULE_funcCall = 14, RULE_assign = 15, 
		RULE_expression = 16, RULE_declaration = 17, RULE_literal = 18, RULE_booleanLiteral = 19, 
		RULE_collectionInit = 20, RULE_type = 21, RULE_primitiveType = 22, RULE_collectionType = 23;
	public static final String[] ruleNames = {
		"programtest", "teststmts", "function", "funcParameters", "declarationParameters", 
		"declarationParameterList", "program", "stmts", "stmt", "loop", "ifStmt", 
		"elseIfStmt", "elseStmt", "condition", "funcCall", "assign", "expression", 
		"declaration", "literal", "booleanLiteral", "collectionInit", "type", 
		"primitiveType", "collectionType"
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
	public static class ProgramtestContext extends ParserRuleContext {
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public ProgramtestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programtest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterProgramtest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitProgramtest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitProgramtest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramtestContext programtest() throws RecognitionException {
		ProgramtestContext _localctx = new ProgramtestContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programtest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(48); function();
				}
				}
				setState(51); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==19 );
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

	public static class TeststmtsContext extends ParserRuleContext {
		public TeststmtsContext teststmts() {
			return getRuleContext(TeststmtsContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public TeststmtsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_teststmts; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterTeststmts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitTeststmts(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitTeststmts(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TeststmtsContext teststmts() throws RecognitionException {
		TeststmtsContext _localctx = new TeststmtsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_teststmts);
		try {
			setState(57);
			switch (_input.LA(1)) {
			case 5:
			case 8:
			case 9:
			case 12:
			case 20:
			case 21:
			case 22:
			case 23:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(53); stmt();
				setState(54); teststmts();
				}
				break;
			case 6:
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
		public TeststmtsContext teststmts() {
			return getRuleContext(TeststmtsContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(HelloParser.Identifier, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public DeclarationParametersContext declarationParameters() {
			return getRuleContext(DeclarationParametersContext.class,0);
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
			setState(59); match(19);
			setState(60); match(Identifier);
			setState(61); declarationParameters();
			setState(62); match(24);
			setState(63); type();
			setState(64); teststmts();
			setState(65); match(6);
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
			setState(67); match(LPAREN);
			setState(76);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 10) | (1L << 13) | (1L << 16) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << DecimalLiteral) | (1L << StringLiteral))) != 0)) {
				{
				setState(68); expression(0);
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4) {
					{
					{
					setState(69); match(4);
					setState(70); expression(0);
					}
					}
					setState(75);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(78); match(RPAREN);
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
			setState(80); match(LPAREN);
			setState(89);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 5) | (1L << 9) | (1L << 12) | (1L << 20) | (1L << 21) | (1L << 22))) != 0)) {
				{
				setState(81); declaration();
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4) {
					{
					{
					setState(82); match(4);
					setState(83); declaration();
					}
					}
					setState(88);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(91); match(RPAREN);
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
			setState(93); declaration();
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4) {
				{
				{
				setState(94); match(4);
				setState(95); declaration();
				}
				}
				setState(100);
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

	public static class ProgramContext extends ParserRuleContext {
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
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
		enterRule(_localctx, 12, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101); stmts();
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
		enterRule(_localctx, 14, RULE_stmts);
		try {
			setState(107);
			switch (_input.LA(1)) {
			case 5:
			case 8:
			case 9:
			case 12:
			case 20:
			case 21:
			case 22:
			case 23:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(103); stmt();
				setState(104); stmts();
				}
				break;
			case EOF:
			case 3:
			case 14:
			case 17:
			case 18:
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
		enterRule(_localctx, 16, RULE_stmt);
		try {
			setState(114);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(109); declaration();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(110); assign();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(111); ifStmt();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(112); loop();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(113); funcCall();
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

	public static class LoopContext extends ParserRuleContext {
		public TerminalNode Identifier(int i) {
			return getToken(HelloParser.Identifier, i);
		}
		public List<TerminalNode> Identifier() { return getTokens(HelloParser.Identifier); }
		public TerminalNode RPAREN() { return getToken(HelloParser.RPAREN, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(HelloParser.LPAREN, 0); }
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
		enterRule(_localctx, 18, RULE_loop);
		int _la;
		try {
			setState(135);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(116); match(23);
				setState(117);
				_la = _input.LA(1);
				if ( !(_la==7 || _la==11) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(118); match(LPAREN);
				setState(119); expression(0);
				setState(120); match(RPAREN);
				setState(121); stmts();
				setState(122); match(18);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(124); match(23);
				setState(125); match(25);
				setState(126); match(LPAREN);
				setState(127); type();
				setState(128); match(Identifier);
				setState(129); match(2);
				setState(130); match(Identifier);
				setState(131); match(RPAREN);
				setState(132); stmts();
				setState(133); match(18);
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
			setState(137); match(8);
			setState(138); match(LPAREN);
			setState(139); expression(0);
			setState(140); match(RPAREN);
			setState(141); stmts();
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==17) {
				{
				{
				setState(142); elseIfStmt();
				}
				}
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(149);
			_la = _input.LA(1);
			if (_la==14) {
				{
				setState(148); elseStmt();
				}
			}

			setState(151); match(3);
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
			setState(153); match(17);
			setState(154); match(LPAREN);
			setState(155); expression(0);
			setState(156); match(RPAREN);
			setState(157); stmts();
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
			setState(159); match(14);
			setState(161);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(160); stmts();
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
		public TerminalNode Identifier(int i) {
			return getToken(HelloParser.Identifier, i);
		}
		public List<TerminalNode> Identifier() { return getTokens(HelloParser.Identifier); }
		public TerminalNode LOGICALOPERATOR() { return getToken(HelloParser.LOGICALOPERATOR, 0); }
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
		enterRule(_localctx, 26, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(163); match(Identifier);
				}
				break;
			case 10:
			case 16:
			case IntegerLiteral:
			case DecimalLiteral:
			case StringLiteral:
				{
				setState(164); literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(167); match(LOGICALOPERATOR);
			setState(170);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(168); match(Identifier);
				}
				break;
			case 10:
			case 16:
			case IntegerLiteral:
			case DecimalLiteral:
			case StringLiteral:
				{
				setState(169); literal();
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

	public static class FuncCallContext extends ParserRuleContext {
		public FuncParametersContext funcParameters() {
			return getRuleContext(FuncParametersContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(HelloParser.Identifier, 0); }
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
		enterRule(_localctx, 28, RULE_funcCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172); match(Identifier);
			setState(173); funcParameters();
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
		public TerminalNode Identifier() { return getToken(HelloParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		enterRule(_localctx, 30, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175); match(Identifier);
			setState(176); match(ASSIGN);
			setState(177); expression(0);
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
		public TerminalNode Identifier() { return getToken(HelloParser.Identifier, 0); }
		public TerminalNode LOGICALOPERATOR() { return getToken(HelloParser.LOGICALOPERATOR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
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
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(180); funcCall();
				}
				break;

			case 2:
				{
				setState(181); literal();
				}
				break;

			case 3:
				{
				setState(182); match(Identifier);
				}
				break;

			case 4:
				{
				setState(183); collectionInit();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(197);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(195);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(186);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(187);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(188); expression(8);
						}
						break;

					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(189);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(190);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(191); expression(7);
						}
						break;

					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(192);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(193); match(LOGICALOPERATOR);
						setState(194); expression(6);
						}
						break;
					}
					} 
				}
				setState(199);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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

	public static class DeclarationContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(HelloParser.ASSIGN, 0); }
		public TerminalNode Identifier() { return getToken(HelloParser.Identifier, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		enterRule(_localctx, 34, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200); type();
			setState(201); match(Identifier);
			setState(204);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(202); match(ASSIGN);
				setState(203); expression(0);
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
		enterRule(_localctx, 36, RULE_literal);
		try {
			setState(210);
			switch (_input.LA(1)) {
			case IntegerLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(206); match(IntegerLiteral);
				}
				break;
			case DecimalLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(207); match(DecimalLiteral);
				}
				break;
			case 10:
			case 16:
				enterOuterAlt(_localctx, 3);
				{
				setState(208); booleanLiteral();
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 4);
				{
				setState(209); match(StringLiteral);
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
		enterRule(_localctx, 38, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			_la = _input.LA(1);
			if ( !(_la==10 || _la==16) ) {
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
		enterRule(_localctx, 40, RULE_collectionInit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214); match(13);
			setState(223);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 10) | (1L << 13) | (1L << 16) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << DecimalLiteral) | (1L << StringLiteral))) != 0)) {
				{
				setState(215); expression(0);
				setState(220);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4) {
					{
					{
					setState(216); match(4);
					setState(217); expression(0);
					}
					}
					setState(222);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(225); match(15);
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
		enterRule(_localctx, 42, RULE_type);
		try {
			setState(229);
			switch (_input.LA(1)) {
			case 12:
			case 20:
			case 21:
			case 22:
				enterOuterAlt(_localctx, 1);
				{
				setState(227); primitiveType();
				}
				break;
			case 5:
			case 9:
				enterOuterAlt(_localctx, 2);
				{
				setState(228); collectionType();
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
		enterRule(_localctx, 44, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 12) | (1L << 20) | (1L << 21) | (1L << 22))) != 0)) ) {
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
		enterRule(_localctx, 46, RULE_collectionType);
		try {
			setState(243);
			switch (_input.LA(1)) {
			case 9:
				enterOuterAlt(_localctx, 1);
				{
				setState(233); match(9);
				setState(234); match(1);
				setState(235); type();
				setState(236); match(1);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 2);
				{
				setState(238); match(5);
				setState(239); match(1);
				setState(240); type();
				setState(241); match(1);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 16: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 7);

		case 1: return precpred(_ctx, 6);

		case 2: return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3G\u00f8\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\6\2\64\n\2\r\2\16\2\65\3\3\3\3\3\3\3\3\5\3<\n\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\7\5J\n\5\f\5\16\5M\13\5\5\5O\n\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\7\6W\n\6\f\6\16\6Z\13\6\5\6\\\n\6\3\6\3\6\3\7\3\7\3"+
		"\7\7\7c\n\7\f\7\16\7f\13\7\3\b\3\b\3\t\3\t\3\t\3\t\5\tn\n\t\3\n\3\n\3"+
		"\n\3\n\3\n\5\nu\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u008a\n\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\7\f\u0092\n\f\f\f\16\f\u0095\13\f\3\f\5\f\u0098\n\f\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\5\16\u00a4\n\16\3\17\3\17\5\17"+
		"\u00a8\n\17\3\17\3\17\3\17\5\17\u00ad\n\17\3\20\3\20\3\20\3\21\3\21\3"+
		"\21\3\21\3\22\3\22\3\22\3\22\3\22\5\22\u00bb\n\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\7\22\u00c6\n\22\f\22\16\22\u00c9\13\22\3\23"+
		"\3\23\3\23\3\23\5\23\u00cf\n\23\3\24\3\24\3\24\3\24\5\24\u00d5\n\24\3"+
		"\25\3\25\3\26\3\26\3\26\3\26\7\26\u00dd\n\26\f\26\16\26\u00e0\13\26\5"+
		"\26\u00e2\n\26\3\26\3\26\3\27\3\27\5\27\u00e8\n\27\3\30\3\30\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u00f6\n\31\3\31\2\3\"\32"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\2\7\4\2\t\t\r\r\3"+
		"\2:<\3\289\4\2\f\f\22\22\4\2\16\16\26\30\u00ff\2\63\3\2\2\2\4;\3\2\2\2"+
		"\6=\3\2\2\2\bE\3\2\2\2\nR\3\2\2\2\f_\3\2\2\2\16g\3\2\2\2\20m\3\2\2\2\22"+
		"t\3\2\2\2\24\u0089\3\2\2\2\26\u008b\3\2\2\2\30\u009b\3\2\2\2\32\u00a1"+
		"\3\2\2\2\34\u00a7\3\2\2\2\36\u00ae\3\2\2\2 \u00b1\3\2\2\2\"\u00ba\3\2"+
		"\2\2$\u00ca\3\2\2\2&\u00d4\3\2\2\2(\u00d6\3\2\2\2*\u00d8\3\2\2\2,\u00e7"+
		"\3\2\2\2.\u00e9\3\2\2\2\60\u00f5\3\2\2\2\62\64\5\6\4\2\63\62\3\2\2\2\64"+
		"\65\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66\3\3\2\2\2\678\5\22\n\289\5"+
		"\4\3\29<\3\2\2\2:<\3\2\2\2;\67\3\2\2\2;:\3\2\2\2<\5\3\2\2\2=>\7\25\2\2"+
		">?\7\34\2\2?@\5\n\6\2@A\7\32\2\2AB\5,\27\2BC\5\4\3\2CD\7\b\2\2D\7\3\2"+
		"\2\2EN\7=\2\2FK\5\"\22\2GH\7\6\2\2HJ\5\"\22\2IG\3\2\2\2JM\3\2\2\2KI\3"+
		"\2\2\2KL\3\2\2\2LO\3\2\2\2MK\3\2\2\2NF\3\2\2\2NO\3\2\2\2OP\3\2\2\2PQ\7"+
		">\2\2Q\t\3\2\2\2R[\7=\2\2SX\5$\23\2TU\7\6\2\2UW\5$\23\2VT\3\2\2\2WZ\3"+
		"\2\2\2XV\3\2\2\2XY\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2[S\3\2\2\2[\\\3\2\2\2\\"+
		"]\3\2\2\2]^\7>\2\2^\13\3\2\2\2_d\5$\23\2`a\7\6\2\2ac\5$\23\2b`\3\2\2\2"+
		"cf\3\2\2\2db\3\2\2\2de\3\2\2\2e\r\3\2\2\2fd\3\2\2\2gh\5\20\t\2h\17\3\2"+
		"\2\2ij\5\22\n\2jk\5\20\t\2kn\3\2\2\2ln\3\2\2\2mi\3\2\2\2ml\3\2\2\2n\21"+
		"\3\2\2\2ou\5$\23\2pu\5 \21\2qu\5\26\f\2ru\5\24\13\2su\5\36\20\2to\3\2"+
		"\2\2tp\3\2\2\2tq\3\2\2\2tr\3\2\2\2ts\3\2\2\2u\23\3\2\2\2vw\7\31\2\2wx"+
		"\t\2\2\2xy\7=\2\2yz\5\"\22\2z{\7>\2\2{|\5\20\t\2|}\7\24\2\2}\u008a\3\2"+
		"\2\2~\177\7\31\2\2\177\u0080\7\33\2\2\u0080\u0081\7=\2\2\u0081\u0082\5"+
		",\27\2\u0082\u0083\7\34\2\2\u0083\u0084\7\4\2\2\u0084\u0085\7\34\2\2\u0085"+
		"\u0086\7>\2\2\u0086\u0087\5\20\t\2\u0087\u0088\7\24\2\2\u0088\u008a\3"+
		"\2\2\2\u0089v\3\2\2\2\u0089~\3\2\2\2\u008a\25\3\2\2\2\u008b\u008c\7\n"+
		"\2\2\u008c\u008d\7=\2\2\u008d\u008e\5\"\22\2\u008e\u008f\7>\2\2\u008f"+
		"\u0093\5\20\t\2\u0090\u0092\5\30\r\2\u0091\u0090\3\2\2\2\u0092\u0095\3"+
		"\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0097\3\2\2\2\u0095"+
		"\u0093\3\2\2\2\u0096\u0098\5\32\16\2\u0097\u0096\3\2\2\2\u0097\u0098\3"+
		"\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\7\5\2\2\u009a\27\3\2\2\2\u009b"+
		"\u009c\7\23\2\2\u009c\u009d\7=\2\2\u009d\u009e\5\"\22\2\u009e\u009f\7"+
		">\2\2\u009f\u00a0\5\20\t\2\u00a0\31\3\2\2\2\u00a1\u00a3\7\20\2\2\u00a2"+
		"\u00a4\5\20\t\2\u00a3\u00a2\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\33\3\2\2"+
		"\2\u00a5\u00a8\7\34\2\2\u00a6\u00a8\5&\24\2\u00a7\u00a5\3\2\2\2\u00a7"+
		"\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ac\7-\2\2\u00aa\u00ad\7\34"+
		"\2\2\u00ab\u00ad\5&\24\2\u00ac\u00aa\3\2\2\2\u00ac\u00ab\3\2\2\2\u00ad"+
		"\35\3\2\2\2\u00ae\u00af\7\34\2\2\u00af\u00b0\5\b\5\2\u00b0\37\3\2\2\2"+
		"\u00b1\u00b2\7\34\2\2\u00b2\u00b3\7*\2\2\u00b3\u00b4\5\"\22\2\u00b4!\3"+
		"\2\2\2\u00b5\u00b6\b\22\1\2\u00b6\u00bb\5\36\20\2\u00b7\u00bb\5&\24\2"+
		"\u00b8\u00bb\7\34\2\2\u00b9\u00bb\5*\26\2\u00ba\u00b5\3\2\2\2\u00ba\u00b7"+
		"\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00b9\3\2\2\2\u00bb\u00c7\3\2\2\2\u00bc"+
		"\u00bd\f\t\2\2\u00bd\u00be\t\3\2\2\u00be\u00c6\5\"\22\n\u00bf\u00c0\f"+
		"\b\2\2\u00c0\u00c1\t\4\2\2\u00c1\u00c6\5\"\22\t\u00c2\u00c3\f\7\2\2\u00c3"+
		"\u00c4\7-\2\2\u00c4\u00c6\5\"\22\b\u00c5\u00bc\3\2\2\2\u00c5\u00bf\3\2"+
		"\2\2\u00c5\u00c2\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7"+
		"\u00c8\3\2\2\2\u00c8#\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00cb\5,\27\2"+
		"\u00cb\u00ce\7\34\2\2\u00cc\u00cd\7*\2\2\u00cd\u00cf\5\"\22\2\u00ce\u00cc"+
		"\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf%\3\2\2\2\u00d0\u00d5\7\37\2\2\u00d1"+
		"\u00d5\7 \2\2\u00d2\u00d5\5(\25\2\u00d3\u00d5\7!\2\2\u00d4\u00d0\3\2\2"+
		"\2\u00d4\u00d1\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d3\3\2\2\2\u00d5\'"+
		"\3\2\2\2\u00d6\u00d7\t\5\2\2\u00d7)\3\2\2\2\u00d8\u00e1\7\17\2\2\u00d9"+
		"\u00de\5\"\22\2\u00da\u00db\7\6\2\2\u00db\u00dd\5\"\22\2\u00dc\u00da\3"+
		"\2\2\2\u00dd\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df"+
		"\u00e2\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1\u00d9\3\2\2\2\u00e1\u00e2\3\2"+
		"\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\7\21\2\2\u00e4+\3\2\2\2\u00e5\u00e8"+
		"\5.\30\2\u00e6\u00e8\5\60\31\2\u00e7\u00e5\3\2\2\2\u00e7\u00e6\3\2\2\2"+
		"\u00e8-\3\2\2\2\u00e9\u00ea\t\6\2\2\u00ea/\3\2\2\2\u00eb\u00ec\7\13\2"+
		"\2\u00ec\u00ed\7\3\2\2\u00ed\u00ee\5,\27\2\u00ee\u00ef\7\3\2\2\u00ef\u00f6"+
		"\3\2\2\2\u00f0\u00f1\7\7\2\2\u00f1\u00f2\7\3\2\2\u00f2\u00f3\5,\27\2\u00f3"+
		"\u00f4\7\3\2\2\u00f4\u00f6\3\2\2\2\u00f5\u00eb\3\2\2\2\u00f5\u00f0\3\2"+
		"\2\2\u00f6\61\3\2\2\2\32\65;KNX[dmt\u0089\u0093\u0097\u00a3\u00a7\u00ac"+
		"\u00ba\u00c5\u00c7\u00ce\u00d4\u00de\u00e1\u00e7\u00f5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}