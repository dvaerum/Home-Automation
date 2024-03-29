// Generated from ./HOME.g4 by ANTLR 4.2

package HOME.Grammar;

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
		T__27=1, T__26=2, T__25=3, T__24=4, T__23=5, T__22=6, T__21=7, T__20=8, 
		T__19=9, T__18=10, T__17=11, T__16=12, T__15=13, T__14=14, T__13=15, T__12=16, 
		T__11=17, T__10=18, T__9=19, T__8=20, T__7=21, T__6=22, T__5=23, T__4=24, 
		T__3=25, T__2=26, T__1=27, T__0=28, IdentifierExact=29, IntegerLiteral=30, 
		DecimalLiteral=31, StringLiteral=32, NullLiteral=33, DOT=34, BANG=35, 
		SEMICOLON=36, NOTEQUAL=37, EQUAL=38, GT=39, LT=40, LE=41, GE=42, INC=43, 
		DEC=44, NOUSE1=45, NOUSE2=46, ADD=47, SUB=48, MUL=49, DIV=50, MOD=51, 
		LPAREN=52, RPAREN=53, AnyAssign=54, ASSIGN=55, ADD_ASSIGN=56, SUB_ASSIGN=57, 
		MUL_ASSIGN=58, DIV_ASSIGN=59, MOD_ASSIGN=60, WS=61, COMMENT=62, LINE_COMMENT=63;
	public static final String[] tokenNames = {
		"<INVALID>", "']'", "'in'", "'endif'", "','", "'Dictionary'", "'\n'", 
		"'['", "'endfunction'", "'while'", "'\r'", "'if'", "'List'", "'false'", 
		"'until'", "'{'", "'OR'", "'else'", "'}'", "'true'", "'elseif'", "'AND'", 
		"'endrepeat'", "'Nothing'", "'function'", "'return'", "'repeat'", "'returns'", 
		"'foreach'", "IdentifierExact", "IntegerLiteral", "DecimalLiteral", "StringLiteral", 
		"'null'", "'.'", "'!'", "';'", "'!='", "'=='", "'>'", "'<'", "'<='", "'>='", 
		"'++'", "'--'", "'+-'", "'-+'", "'+'", "'-'", "'*'", "'/'", "'%'", "'('", 
		"')'", "AnyAssign", "'='", "'+='", "'-='", "'*='", "'/='", "'%='", "WS", 
		"COMMENT", "LINE_COMMENT"
	};
	public static final int
		RULE_program = 0, RULE_global = 1, RULE_block = 2, RULE_function = 3, 
		RULE_moreFunctions = 4, RULE_functionParameters = 5, RULE_funcParamDeclaration = 6, 
		RULE_stmts = 7, RULE_stmt = 8, RULE_declaration = 9, RULE_assignment = 10, 
		RULE_ifStmt = 11, RULE_elseIfStmt = 12, RULE_elseStmt = 13, RULE_loop = 14, 
		RULE_loopWhileOrUntil = 15, RULE_loopForeach = 16, RULE_funcCall = 17, 
		RULE_funcParameters = 18, RULE_variableMethodCall = 19, RULE_returnFunction = 20, 
		RULE_incDec = 21, RULE_listIndex = 22, RULE_field = 23, RULE_identifier = 24, 
		RULE_expression = 25, RULE_literal = 26, RULE_listLiteral = 27, RULE_dictionaryLiteral = 28, 
		RULE_dictionaryEntry = 29, RULE_int2dec = 30, RULE_booleanLiteral = 31, 
		RULE_type = 32, RULE_collectionType = 33, RULE_classes = 34, RULE_nothing = 35, 
		RULE_and = 36, RULE_or = 37, RULE_newline = 38;
	public static final String[] ruleNames = {
		"program", "global", "block", "function", "moreFunctions", "functionParameters", 
		"funcParamDeclaration", "stmts", "stmt", "declaration", "assignment", 
		"ifStmt", "elseIfStmt", "elseStmt", "loop", "loopWhileOrUntil", "loopForeach", 
		"funcCall", "funcParameters", "variableMethodCall", "returnFunction", 
		"incDec", "listIndex", "field", "identifier", "expression", "literal", 
		"listLiteral", "dictionaryLiteral", "dictionaryEntry", "int2dec", "booleanLiteral", 
		"type", "collectionType", "classes", "nothing", "and", "or", "newline"
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
		public NewlineContext newline(int i) {
			return getRuleContext(NewlineContext.class,i);
		}
		public TerminalNode EOF() { return getToken(HOMEParser.EOF, 0); }
		public GlobalContext global() {
			return getRuleContext(GlobalContext.class,0);
		}
		public List<NewlineContext> newline() {
			return getRuleContexts(NewlineContext.class);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==6 || _la==10) {
				{
				{
				setState(78); newline();
				}
				}
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(84); global();
			setState(85); block();
			setState(86); match(EOF);
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
			setState(97);
			switch (_input.LA(1)) {
			case 5:
			case 12:
			case IdentifierExact:
				enterOuterAlt(_localctx, 1);
				{
				setState(88); declaration();
				setState(90); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(89); newline();
					}
					}
					setState(92); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==6 || _la==10 );
				setState(94); global();
				}
				break;
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
			setState(99); function();
			setState(100); moreFunctions();
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
		public FunctionParametersContext functionParameters() {
			return getRuleContext(FunctionParametersContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public List<NewlineContext> newline() {
			return getRuleContexts(NewlineContext.class);
		}
		public NothingContext nothing() {
			return getRuleContext(NothingContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
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
			setState(102); match(24);
			setState(103); identifier();
			setState(104); functionParameters();
			setState(105); match(27);
			setState(108);
			switch (_input.LA(1)) {
			case 5:
			case 12:
			case IdentifierExact:
				{
				setState(106); type();
				}
				break;
			case 23:
				{
				setState(107); nothing();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(111); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(110); newline();
				}
				}
				setState(113); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==6 || _la==10 );
			setState(115); stmts();
			setState(116); match(8);
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
			setState(131);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(119); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(118); newline();
					}
					}
					setState(121); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==6 || _la==10 );
				setState(123); block();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==6 || _la==10) {
					{
					{
					setState(125); newline();
					}
					}
					setState(130);
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

	public static class FunctionParametersContext extends ParserRuleContext {
		public List<FuncParamDeclarationContext> funcParamDeclaration() {
			return getRuleContexts(FuncParamDeclarationContext.class);
		}
		public FuncParamDeclarationContext funcParamDeclaration(int i) {
			return getRuleContext(FuncParamDeclarationContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(HOMEParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(HOMEParser.LPAREN, 0); }
		public FunctionParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterFunctionParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitFunctionParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitFunctionParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionParametersContext functionParameters() throws RecognitionException {
		FunctionParametersContext _localctx = new FunctionParametersContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_functionParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133); match(LPAREN);
			setState(142);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 5) | (1L << 12) | (1L << IdentifierExact))) != 0)) {
				{
				setState(134); funcParamDeclaration();
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4) {
					{
					{
					setState(135); match(4);
					setState(136); funcParamDeclaration();
					}
					}
					setState(141);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(144); match(RPAREN);
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

	public static class FuncParamDeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FuncParamDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcParamDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterFuncParamDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitFuncParamDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitFuncParamDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncParamDeclarationContext funcParamDeclaration() throws RecognitionException {
		FuncParamDeclarationContext _localctx = new FuncParamDeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_funcParamDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146); type();
			setState(147); identifier();
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
		enterRule(_localctx, 14, RULE_stmts);
		int _la;
		try {
			setState(158);
			switch (_input.LA(1)) {
			case 5:
			case 11:
			case 12:
			case 25:
			case 26:
			case IdentifierExact:
				enterOuterAlt(_localctx, 1);
				{
				setState(149); stmt();
				setState(151); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(150); newline();
					}
					}
					setState(153); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==6 || _la==10 );
				setState(155); stmts();
				}
				break;
			case 3:
			case 8:
			case 17:
			case 20:
			case 22:
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
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
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
		enterRule(_localctx, 16, RULE_stmt);
		try {
			setState(168);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(160); declaration();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(161); assignment();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(162); ifStmt();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(163); loop();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(164); funcCall();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(165); variableMethodCall();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(166); returnFunction();
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(167); incDec();
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
		public TerminalNode ASSIGN() { return getToken(HOMEParser.ASSIGN, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode AnyAssign() { return getToken(HOMEParser.AnyAssign, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
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
		enterRule(_localctx, 18, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170); type();
			setState(171); identifier();
			setState(174);
			_la = _input.LA(1);
			if (_la==AnyAssign || _la==ASSIGN) {
				{
				setState(172);
				_la = _input.LA(1);
				if ( !(_la==AnyAssign || _la==ASSIGN) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(173); expression(0);
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

	public static class AssignmentContext extends ParserRuleContext {
		public ListIndexContext listIndex() {
			return getRuleContext(ListIndexContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(HOMEParser.ASSIGN, 0); }
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode AnyAssign() { return getToken(HOMEParser.AnyAssign, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_assignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(176); identifier();
				}
				break;

			case 2:
				{
				setState(177); listIndex();
				}
				break;

			case 3:
				{
				setState(178); field();
				}
				break;
			}
			setState(181);
			_la = _input.LA(1);
			if ( !(_la==AnyAssign || _la==ASSIGN) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(182); expression(0);
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
		enterRule(_localctx, 22, RULE_ifStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184); match(11);
			setState(185); match(LPAREN);
			setState(186); expression(0);
			setState(187); match(RPAREN);
			setState(189); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(188); newline();
				}
				}
				setState(191); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==6 || _la==10 );
			setState(193); stmts();
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==20) {
				{
				{
				setState(194); elseIfStmt();
				}
				}
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(201);
			_la = _input.LA(1);
			if (_la==17) {
				{
				setState(200); elseStmt();
				}
			}

			setState(203); match(3);
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
		enterRule(_localctx, 24, RULE_elseIfStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205); match(20);
			setState(206); match(LPAREN);
			setState(207); expression(0);
			setState(208); match(RPAREN);
			setState(210); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(209); newline();
				}
				}
				setState(212); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==6 || _la==10 );
			setState(214); stmts();
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
		enterRule(_localctx, 26, RULE_elseStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216); match(17);
			setState(218); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(217); newline();
				}
				}
				setState(220); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==6 || _la==10 );
			setState(222); stmts();
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
		enterRule(_localctx, 28, RULE_loop);
		try {
			setState(226);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(224); loopWhileOrUntil();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(225); loopForeach();
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
		enterRule(_localctx, 30, RULE_loopWhileOrUntil);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228); match(26);
			setState(229);
			_la = _input.LA(1);
			if ( !(_la==9 || _la==14) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(230); match(LPAREN);
			setState(231); expression(0);
			setState(232); match(RPAREN);
			setState(234); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(233); newline();
				}
				}
				setState(236); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==6 || _la==10 );
			setState(238); stmts();
			setState(239); match(22);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(HOMEParser.LPAREN, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
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
		enterRule(_localctx, 32, RULE_loopForeach);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241); match(26);
			setState(242); match(28);
			setState(243); match(LPAREN);
			setState(244); type();
			setState(245); identifier();
			setState(246); match(2);
			setState(247); expression(0);
			setState(248); match(RPAREN);
			setState(250); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(249); newline();
				}
				}
				setState(252); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==6 || _la==10 );
			setState(254); stmts();
			setState(255); match(22);
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
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
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
		enterRule(_localctx, 34, RULE_funcCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257); identifier();
			setState(258); funcParameters();
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
		enterRule(_localctx, 36, RULE_funcParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260); match(LPAREN);
			setState(269);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 13) | (1L << 15) | (1L << 19) | (1L << IdentifierExact) | (1L << IntegerLiteral) | (1L << DecimalLiteral) | (1L << StringLiteral) | (1L << SUB) | (1L << LPAREN))) != 0)) {
				{
				setState(261); expression(0);
				setState(266);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4) {
					{
					{
					setState(262); match(4);
					setState(263); expression(0);
					}
					}
					setState(268);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(271); match(RPAREN);
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
		public TerminalNode DOT() { return getToken(HOMEParser.DOT, 0); }
		public FuncCallContext funcCall() {
			return getRuleContext(FuncCallContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
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
		enterRule(_localctx, 38, RULE_variableMethodCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273); identifier();
			setState(274); match(DOT);
			setState(275); funcCall();
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
		enterRule(_localctx, 40, RULE_returnFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277); match(25);
			setState(279);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 13) | (1L << 15) | (1L << 19) | (1L << IdentifierExact) | (1L << IntegerLiteral) | (1L << DecimalLiteral) | (1L << StringLiteral) | (1L << SUB) | (1L << LPAREN))) != 0)) {
				{
				setState(278); expression(0);
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

	public static class IncDecContext extends ParserRuleContext {
		public ListIndexContext listIndex() {
			return getRuleContext(ListIndexContext.class,0);
		}
		public TerminalNode INC() { return getToken(HOMEParser.INC, 0); }
		public TerminalNode DEC() { return getToken(HOMEParser.DEC, 0); }
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
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
		enterRule(_localctx, 42, RULE_incDec);
		try {
			setState(295);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(284);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(281); identifier();
					}
					break;

				case 2:
					{
					setState(282); listIndex();
					}
					break;

				case 3:
					{
					setState(283); field();
					}
					break;
				}
				setState(286); match(INC);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(291);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(288); identifier();
					}
					break;

				case 2:
					{
					setState(289); listIndex();
					}
					break;

				case 3:
					{
					setState(290); field();
					}
					break;
				}
				setState(293); match(DEC);
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

	public static class ListIndexContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ListIndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listIndex; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterListIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitListIndex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitListIndex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListIndexContext listIndex() throws RecognitionException {
		ListIndexContext _localctx = new ListIndexContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_listIndex);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(297); identifier();
			setState(302); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(298); match(7);
					setState(299); expression(0);
					setState(300); match(1);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(304); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
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

	public static class FieldContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(HOMEParser.DOT, 0); }
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_field);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306); identifier();
			setState(307); match(DOT);
			setState(308); identifier();
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

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode IdentifierExact() { return getToken(HOMEParser.IdentifierExact, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310); match(IdentifierExact);
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
		public ListIndexContext listIndex() {
			return getRuleContext(ListIndexContext.class,0);
		}
		public TerminalNode MUL() { return getToken(HOMEParser.MUL, 0); }
		public VariableMethodCallContext variableMethodCall() {
			return getRuleContext(VariableMethodCallContext.class,0);
		}
		public TerminalNode LE() { return getToken(HOMEParser.LE, 0); }
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode EQUAL() { return getToken(HOMEParser.EQUAL, 0); }
		public FuncCallContext funcCall() {
			return getRuleContext(FuncCallContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(HOMEParser.LPAREN, 0); }
		public AndContext and() {
			return getRuleContext(AndContext.class,0);
		}
		public OrContext or() {
			return getRuleContext(OrContext.class,0);
		}
		public TerminalNode GE() { return getToken(HOMEParser.GE, 0); }
		public TerminalNode ADD() { return getToken(HOMEParser.ADD, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DIV() { return getToken(HOMEParser.DIV, 0); }
		public TerminalNode LT() { return getToken(HOMEParser.LT, 0); }
		public TerminalNode RPAREN() { return getToken(HOMEParser.RPAREN, 0); }
		public TerminalNode GT() { return getToken(HOMEParser.GT, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode NOTEQUAL() { return getToken(HOMEParser.NOTEQUAL, 0); }
		public TerminalNode MOD() { return getToken(HOMEParser.MOD, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode SUB() { return getToken(HOMEParser.SUB, 0); }
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
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(313); match(SUB);
				setState(314); expression(14);
				}
				break;

			case 2:
				{
				setState(315); funcCall();
				}
				break;

			case 3:
				{
				setState(316); literal();
				}
				break;

			case 4:
				{
				setState(317); variableMethodCall();
				}
				break;

			case 5:
				{
				setState(318); identifier();
				}
				break;

			case 6:
				{
				setState(319); listIndex();
				}
				break;

			case 7:
				{
				setState(320); field();
				}
				break;

			case 8:
				{
				setState(321); match(LPAREN);
				setState(322); expression(0);
				setState(323); match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(349);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(347);
					switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(327);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(328);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(329); expression(14);
						}
						break;

					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(330);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(331);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(332); expression(13);
						}
						break;

					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(333);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(334);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << LT) | (1L << LE) | (1L << GE))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(335); expression(12);
						}
						break;

					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(336);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(337);
						_la = _input.LA(1);
						if ( !(_la==NOTEQUAL || _la==EQUAL) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(338); expression(11);
						}
						break;

					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(339);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(340); and();
						setState(341); expression(10);
						}
						break;

					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(343);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(344); or();
						setState(345); expression(9);
						}
						break;
					}
					} 
				}
				setState(351);
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
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode IntegerLiteral() { return getToken(HOMEParser.IntegerLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(HOMEParser.StringLiteral, 0); }
		public TerminalNode DecimalLiteral() { return getToken(HOMEParser.DecimalLiteral, 0); }
		public ListLiteralContext listLiteral() {
			return getRuleContext(ListLiteralContext.class,0);
		}
		public BooleanLiteralContext booleanLiteral() {
			return getRuleContext(BooleanLiteralContext.class,0);
		}
		public DictionaryLiteralContext dictionaryLiteral() {
			return getRuleContext(DictionaryLiteralContext.class,0);
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
		enterRule(_localctx, 52, RULE_literal);
		try {
			setState(358);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(352); listLiteral();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(353); dictionaryLiteral();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(354); booleanLiteral();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(355); match(DecimalLiteral);
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(356); match(IntegerLiteral);
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(357); match(StringLiteral);
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

	public static class ListLiteralContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ListLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterListLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitListLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitListLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListLiteralContext listLiteral() throws RecognitionException {
		ListLiteralContext _localctx = new ListLiteralContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_listLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360); match(15);
			setState(369);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 13) | (1L << 15) | (1L << 19) | (1L << IdentifierExact) | (1L << IntegerLiteral) | (1L << DecimalLiteral) | (1L << StringLiteral) | (1L << SUB) | (1L << LPAREN))) != 0)) {
				{
				setState(361); expression(0);
				setState(366);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4) {
					{
					{
					setState(362); match(4);
					setState(363); expression(0);
					}
					}
					setState(368);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(371); match(18);
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

	public static class DictionaryLiteralContext extends ParserRuleContext {
		public DictionaryEntryContext dictionaryEntry(int i) {
			return getRuleContext(DictionaryEntryContext.class,i);
		}
		public List<DictionaryEntryContext> dictionaryEntry() {
			return getRuleContexts(DictionaryEntryContext.class);
		}
		public DictionaryLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dictionaryLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterDictionaryLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitDictionaryLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitDictionaryLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DictionaryLiteralContext dictionaryLiteral() throws RecognitionException {
		DictionaryLiteralContext _localctx = new DictionaryLiteralContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_dictionaryLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373); match(15);
			setState(382);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 13) | (1L << 15) | (1L << 19) | (1L << IdentifierExact) | (1L << IntegerLiteral) | (1L << DecimalLiteral) | (1L << StringLiteral) | (1L << SUB) | (1L << LPAREN))) != 0)) {
				{
				setState(374); dictionaryEntry();
				setState(379);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4) {
					{
					{
					setState(375); match(4);
					setState(376); dictionaryEntry();
					}
					}
					setState(381);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(384); match(18);
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

	public static class DictionaryEntryContext extends ParserRuleContext {
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ASSIGN() { return getToken(HOMEParser.ASSIGN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public DictionaryEntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dictionaryEntry; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterDictionaryEntry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitDictionaryEntry(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitDictionaryEntry(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DictionaryEntryContext dictionaryEntry() throws RecognitionException {
		DictionaryEntryContext _localctx = new DictionaryEntryContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_dictionaryEntry);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(386); expression(0);
			setState(387); match(ASSIGN);
			setState(388); expression(0);
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

	public static class Int2decContext extends ParserRuleContext {
		public TerminalNode IntegerLiteral() { return getToken(HOMEParser.IntegerLiteral, 0); }
		public Int2decContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_int2dec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterInt2dec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitInt2dec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitInt2dec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Int2decContext int2dec() throws RecognitionException {
		Int2decContext _localctx = new Int2decContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_int2dec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(390); match(IntegerLiteral);
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
		enterRule(_localctx, 62, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392);
			_la = _input.LA(1);
			if ( !(_la==13 || _la==19) ) {
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

	public static class TypeContext extends ParserRuleContext {
		public CollectionTypeContext collectionType() {
			return getRuleContext(CollectionTypeContext.class,0);
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
		enterRule(_localctx, 64, RULE_type);
		try {
			setState(396);
			switch (_input.LA(1)) {
			case 5:
			case 12:
				enterOuterAlt(_localctx, 1);
				{
				setState(394); collectionType();
				}
				break;
			case IdentifierExact:
				enterOuterAlt(_localctx, 2);
				{
				setState(395); classes();
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
		enterRule(_localctx, 66, RULE_collectionType);
		try {
			setState(408);
			switch (_input.LA(1)) {
			case 12:
				enterOuterAlt(_localctx, 1);
				{
				setState(398); match(12);
				setState(399); match(LT);
				setState(400); type();
				setState(401); match(GT);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 2);
				{
				setState(403); match(5);
				setState(404); match(LT);
				setState(405); type();
				setState(406); match(GT);
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
		public TerminalNode IdentifierExact() { return getToken(HOMEParser.IdentifierExact, 0); }
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
		enterRule(_localctx, 68, RULE_classes);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(410); match(IdentifierExact);
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
			setState(412); match(23);
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

	public static class AndContext extends ParserRuleContext {
		public AndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndContext and() throws RecognitionException {
		AndContext _localctx = new AndContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_and);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(414); match(21);
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

	public static class OrContext extends ParserRuleContext {
		public OrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HOMEListener ) ((HOMEListener)listener).exitOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HOMEVisitor ) return ((HOMEVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrContext or() throws RecognitionException {
		OrContext _localctx = new OrContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(416); match(16);
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
		enterRule(_localctx, 76, RULE_newline);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(419);
			_la = _input.LA(1);
			if (_la==10) {
				{
				setState(418); match(10);
				}
			}

			setState(421); match(6);
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
		case 0: return precpred(_ctx, 13);

		case 1: return precpred(_ctx, 12);

		case 2: return precpred(_ctx, 11);

		case 3: return precpred(_ctx, 10);

		case 4: return precpred(_ctx, 9);

		case 5: return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3A\u01aa\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\7\2R\n\2\f\2\16"+
		"\2U\13\2\3\2\3\2\3\2\3\2\3\3\3\3\6\3]\n\3\r\3\16\3^\3\3\3\3\3\3\5\3d\n"+
		"\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5o\n\5\3\5\6\5r\n\5\r\5\16\5"+
		"s\3\5\3\5\3\5\3\6\6\6z\n\6\r\6\16\6{\3\6\3\6\3\6\7\6\u0081\n\6\f\6\16"+
		"\6\u0084\13\6\5\6\u0086\n\6\3\7\3\7\3\7\3\7\7\7\u008c\n\7\f\7\16\7\u008f"+
		"\13\7\5\7\u0091\n\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\6\t\u009a\n\t\r\t\16\t"+
		"\u009b\3\t\3\t\3\t\5\t\u00a1\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00ab"+
		"\n\n\3\13\3\13\3\13\3\13\5\13\u00b1\n\13\3\f\3\f\3\f\5\f\u00b6\n\f\3\f"+
		"\3\f\3\f\3\r\3\r\3\r\3\r\3\r\6\r\u00c0\n\r\r\r\16\r\u00c1\3\r\3\r\7\r"+
		"\u00c6\n\r\f\r\16\r\u00c9\13\r\3\r\5\r\u00cc\n\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\16\6\16\u00d5\n\16\r\16\16\16\u00d6\3\16\3\16\3\17\3\17\6\17\u00dd"+
		"\n\17\r\17\16\17\u00de\3\17\3\17\3\20\3\20\5\20\u00e5\n\20\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\6\21\u00ed\n\21\r\21\16\21\u00ee\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\6\22\u00fd\n\22\r\22\16\22\u00fe"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\24\7\24\u010b\n\24\f\24"+
		"\16\24\u010e\13\24\5\24\u0110\n\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26"+
		"\3\26\5\26\u011a\n\26\3\27\3\27\3\27\5\27\u011f\n\27\3\27\3\27\3\27\3"+
		"\27\3\27\5\27\u0126\n\27\3\27\3\27\5\27\u012a\n\27\3\30\3\30\3\30\3\30"+
		"\3\30\6\30\u0131\n\30\r\30\16\30\u0132\3\31\3\31\3\31\3\31\3\32\3\32\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u0148"+
		"\n\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\7\33\u015e\n\33\f\33\16\33\u0161\13"+
		"\33\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0169\n\34\3\35\3\35\3\35\3\35"+
		"\7\35\u016f\n\35\f\35\16\35\u0172\13\35\5\35\u0174\n\35\3\35\3\35\3\36"+
		"\3\36\3\36\3\36\7\36\u017c\n\36\f\36\16\36\u017f\13\36\5\36\u0181\n\36"+
		"\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3!\3!\3\"\3\"\5\"\u018f\n\"\3#\3"+
		"#\3#\3#\3#\3#\3#\3#\3#\3#\5#\u019b\n#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\5("+
		"\u01a6\n(\3(\3(\3(\2\3\64)\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$"+
		"&(*,.\60\62\64\668:<>@BDFHJLN\2\t\3\289\4\2\13\13\20\20\3\2\63\65\3\2"+
		"\61\62\3\2),\3\2\'(\4\2\17\17\25\25\u01c2\2S\3\2\2\2\4c\3\2\2\2\6e\3\2"+
		"\2\2\bh\3\2\2\2\n\u0085\3\2\2\2\f\u0087\3\2\2\2\16\u0094\3\2\2\2\20\u00a0"+
		"\3\2\2\2\22\u00aa\3\2\2\2\24\u00ac\3\2\2\2\26\u00b5\3\2\2\2\30\u00ba\3"+
		"\2\2\2\32\u00cf\3\2\2\2\34\u00da\3\2\2\2\36\u00e4\3\2\2\2 \u00e6\3\2\2"+
		"\2\"\u00f3\3\2\2\2$\u0103\3\2\2\2&\u0106\3\2\2\2(\u0113\3\2\2\2*\u0117"+
		"\3\2\2\2,\u0129\3\2\2\2.\u012b\3\2\2\2\60\u0134\3\2\2\2\62\u0138\3\2\2"+
		"\2\64\u0147\3\2\2\2\66\u0168\3\2\2\28\u016a\3\2\2\2:\u0177\3\2\2\2<\u0184"+
		"\3\2\2\2>\u0188\3\2\2\2@\u018a\3\2\2\2B\u018e\3\2\2\2D\u019a\3\2\2\2F"+
		"\u019c\3\2\2\2H\u019e\3\2\2\2J\u01a0\3\2\2\2L\u01a2\3\2\2\2N\u01a5\3\2"+
		"\2\2PR\5N(\2QP\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TV\3\2\2\2US\3\2\2"+
		"\2VW\5\4\3\2WX\5\6\4\2XY\7\2\2\3Y\3\3\2\2\2Z\\\5\24\13\2[]\5N(\2\\[\3"+
		"\2\2\2]^\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_`\3\2\2\2`a\5\4\3\2ad\3\2\2\2bd"+
		"\3\2\2\2cZ\3\2\2\2cb\3\2\2\2d\5\3\2\2\2ef\5\b\5\2fg\5\n\6\2g\7\3\2\2\2"+
		"hi\7\32\2\2ij\5\62\32\2jk\5\f\7\2kn\7\35\2\2lo\5B\"\2mo\5H%\2nl\3\2\2"+
		"\2nm\3\2\2\2oq\3\2\2\2pr\5N(\2qp\3\2\2\2rs\3\2\2\2sq\3\2\2\2st\3\2\2\2"+
		"tu\3\2\2\2uv\5\20\t\2vw\7\n\2\2w\t\3\2\2\2xz\5N(\2yx\3\2\2\2z{\3\2\2\2"+
		"{y\3\2\2\2{|\3\2\2\2|}\3\2\2\2}~\5\6\4\2~\u0086\3\2\2\2\177\u0081\5N("+
		"\2\u0080\177\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083"+
		"\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0085y\3\2\2\2\u0085"+
		"\u0082\3\2\2\2\u0086\13\3\2\2\2\u0087\u0090\7\66\2\2\u0088\u008d\5\16"+
		"\b\2\u0089\u008a\7\6\2\2\u008a\u008c\5\16\b\2\u008b\u0089\3\2\2\2\u008c"+
		"\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0091\3\2"+
		"\2\2\u008f\u008d\3\2\2\2\u0090\u0088\3\2\2\2\u0090\u0091\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\u0093\7\67\2\2\u0093\r\3\2\2\2\u0094\u0095\5B\"\2"+
		"\u0095\u0096\5\62\32\2\u0096\17\3\2\2\2\u0097\u0099\5\22\n\2\u0098\u009a"+
		"\5N(\2\u0099\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u0099\3\2\2\2\u009b"+
		"\u009c\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e\5\20\t\2\u009e\u00a1\3"+
		"\2\2\2\u009f\u00a1\3\2\2\2\u00a0\u0097\3\2\2\2\u00a0\u009f\3\2\2\2\u00a1"+
		"\21\3\2\2\2\u00a2\u00ab\5\24\13\2\u00a3\u00ab\5\26\f\2\u00a4\u00ab\5\30"+
		"\r\2\u00a5\u00ab\5\36\20\2\u00a6\u00ab\5$\23\2\u00a7\u00ab\5(\25\2\u00a8"+
		"\u00ab\5*\26\2\u00a9\u00ab\5,\27\2\u00aa\u00a2\3\2\2\2\u00aa\u00a3\3\2"+
		"\2\2\u00aa\u00a4\3\2\2\2\u00aa\u00a5\3\2\2\2\u00aa\u00a6\3\2\2\2\u00aa"+
		"\u00a7\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00a9\3\2\2\2\u00ab\23\3\2\2"+
		"\2\u00ac\u00ad\5B\"\2\u00ad\u00b0\5\62\32\2\u00ae\u00af\t\2\2\2\u00af"+
		"\u00b1\5\64\33\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\25\3\2"+
		"\2\2\u00b2\u00b6\5\62\32\2\u00b3\u00b6\5.\30\2\u00b4\u00b6\5\60\31\2\u00b5"+
		"\u00b2\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b4\3\2\2\2\u00b6\u00b7\3\2"+
		"\2\2\u00b7\u00b8\t\2\2\2\u00b8\u00b9\5\64\33\2\u00b9\27\3\2\2\2\u00ba"+
		"\u00bb\7\r\2\2\u00bb\u00bc\7\66\2\2\u00bc\u00bd\5\64\33\2\u00bd\u00bf"+
		"\7\67\2\2\u00be\u00c0\5N(\2\u00bf\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1"+
		"\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c7\5\20"+
		"\t\2\u00c4\u00c6\5\32\16\2\u00c5\u00c4\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7"+
		"\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3\2"+
		"\2\2\u00ca\u00cc\5\34\17\2\u00cb\u00ca\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc"+
		"\u00cd\3\2\2\2\u00cd\u00ce\7\5\2\2\u00ce\31\3\2\2\2\u00cf\u00d0\7\26\2"+
		"\2\u00d0\u00d1\7\66\2\2\u00d1\u00d2\5\64\33\2\u00d2\u00d4\7\67\2\2\u00d3"+
		"\u00d5\5N(\2\u00d4\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d4\3\2\2"+
		"\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\5\20\t\2\u00d9"+
		"\33\3\2\2\2\u00da\u00dc\7\23\2\2\u00db\u00dd\5N(\2\u00dc\u00db\3\2\2\2"+
		"\u00dd\u00de\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e0"+
		"\3\2\2\2\u00e0\u00e1\5\20\t\2\u00e1\35\3\2\2\2\u00e2\u00e5\5 \21\2\u00e3"+
		"\u00e5\5\"\22\2\u00e4\u00e2\3\2\2\2\u00e4\u00e3\3\2\2\2\u00e5\37\3\2\2"+
		"\2\u00e6\u00e7\7\34\2\2\u00e7\u00e8\t\3\2\2\u00e8\u00e9\7\66\2\2\u00e9"+
		"\u00ea\5\64\33\2\u00ea\u00ec\7\67\2\2\u00eb\u00ed\5N(\2\u00ec\u00eb\3"+
		"\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef"+
		"\u00f0\3\2\2\2\u00f0\u00f1\5\20\t\2\u00f1\u00f2\7\30\2\2\u00f2!\3\2\2"+
		"\2\u00f3\u00f4\7\34\2\2\u00f4\u00f5\7\36\2\2\u00f5\u00f6\7\66\2\2\u00f6"+
		"\u00f7\5B\"\2\u00f7\u00f8\5\62\32\2\u00f8\u00f9\7\4\2\2\u00f9\u00fa\5"+
		"\64\33\2\u00fa\u00fc\7\67\2\2\u00fb\u00fd\5N(\2\u00fc\u00fb\3\2\2\2\u00fd"+
		"\u00fe\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0100\3\2"+
		"\2\2\u0100\u0101\5\20\t\2\u0101\u0102\7\30\2\2\u0102#\3\2\2\2\u0103\u0104"+
		"\5\62\32\2\u0104\u0105\5&\24\2\u0105%\3\2\2\2\u0106\u010f\7\66\2\2\u0107"+
		"\u010c\5\64\33\2\u0108\u0109\7\6\2\2\u0109\u010b\5\64\33\2\u010a\u0108"+
		"\3\2\2\2\u010b\u010e\3\2\2\2\u010c\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010d"+
		"\u0110\3\2\2\2\u010e\u010c\3\2\2\2\u010f\u0107\3\2\2\2\u010f\u0110\3\2"+
		"\2\2\u0110\u0111\3\2\2\2\u0111\u0112\7\67\2\2\u0112\'\3\2\2\2\u0113\u0114"+
		"\5\62\32\2\u0114\u0115\7$\2\2\u0115\u0116\5$\23\2\u0116)\3\2\2\2\u0117"+
		"\u0119\7\33\2\2\u0118\u011a\5\64\33\2\u0119\u0118\3\2\2\2\u0119\u011a"+
		"\3\2\2\2\u011a+\3\2\2\2\u011b\u011f\5\62\32\2\u011c\u011f\5.\30\2\u011d"+
		"\u011f\5\60\31\2\u011e\u011b\3\2\2\2\u011e\u011c\3\2\2\2\u011e\u011d\3"+
		"\2\2\2\u011f\u0120\3\2\2\2\u0120\u0121\7-\2\2\u0121\u012a\3\2\2\2\u0122"+
		"\u0126\5\62\32\2\u0123\u0126\5.\30\2\u0124\u0126\5\60\31\2\u0125\u0122"+
		"\3\2\2\2\u0125\u0123\3\2\2\2\u0125\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127"+
		"\u0128\7.\2\2\u0128\u012a\3\2\2\2\u0129\u011e\3\2\2\2\u0129\u0125\3\2"+
		"\2\2\u012a-\3\2\2\2\u012b\u0130\5\62\32\2\u012c\u012d\7\t\2\2\u012d\u012e"+
		"\5\64\33\2\u012e\u012f\7\3\2\2\u012f\u0131\3\2\2\2\u0130\u012c\3\2\2\2"+
		"\u0131\u0132\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133/\3"+
		"\2\2\2\u0134\u0135\5\62\32\2\u0135\u0136\7$\2\2\u0136\u0137\5\62\32\2"+
		"\u0137\61\3\2\2\2\u0138\u0139\7\37\2\2\u0139\63\3\2\2\2\u013a\u013b\b"+
		"\33\1\2\u013b\u013c\7\62\2\2\u013c\u0148\5\64\33\20\u013d\u0148\5$\23"+
		"\2\u013e\u0148\5\66\34\2\u013f\u0148\5(\25\2\u0140\u0148\5\62\32\2\u0141"+
		"\u0148\5.\30\2\u0142\u0148\5\60\31\2\u0143\u0144\7\66\2\2\u0144\u0145"+
		"\5\64\33\2\u0145\u0146\7\67\2\2\u0146\u0148\3\2\2\2\u0147\u013a\3\2\2"+
		"\2\u0147\u013d\3\2\2\2\u0147\u013e\3\2\2\2\u0147\u013f\3\2\2\2\u0147\u0140"+
		"\3\2\2\2\u0147\u0141\3\2\2\2\u0147\u0142\3\2\2\2\u0147\u0143\3\2\2\2\u0148"+
		"\u015f\3\2\2\2\u0149\u014a\f\17\2\2\u014a\u014b\t\4\2\2\u014b\u015e\5"+
		"\64\33\20\u014c\u014d\f\16\2\2\u014d\u014e\t\5\2\2\u014e\u015e\5\64\33"+
		"\17\u014f\u0150\f\r\2\2\u0150\u0151\t\6\2\2\u0151\u015e\5\64\33\16\u0152"+
		"\u0153\f\f\2\2\u0153\u0154\t\7\2\2\u0154\u015e\5\64\33\r\u0155\u0156\f"+
		"\13\2\2\u0156\u0157\5J&\2\u0157\u0158\5\64\33\f\u0158\u015e\3\2\2\2\u0159"+
		"\u015a\f\n\2\2\u015a\u015b\5L\'\2\u015b\u015c\5\64\33\13\u015c\u015e\3"+
		"\2\2\2\u015d\u0149\3\2\2\2\u015d\u014c\3\2\2\2\u015d\u014f\3\2\2\2\u015d"+
		"\u0152\3\2\2\2\u015d\u0155\3\2\2\2\u015d\u0159\3\2\2\2\u015e\u0161\3\2"+
		"\2\2\u015f\u015d\3\2\2\2\u015f\u0160\3\2\2\2\u0160\65\3\2\2\2\u0161\u015f"+
		"\3\2\2\2\u0162\u0169\58\35\2\u0163\u0169\5:\36\2\u0164\u0169\5@!\2\u0165"+
		"\u0169\7!\2\2\u0166\u0169\7 \2\2\u0167\u0169\7\"\2\2\u0168\u0162\3\2\2"+
		"\2\u0168\u0163\3\2\2\2\u0168\u0164\3\2\2\2\u0168\u0165\3\2\2\2\u0168\u0166"+
		"\3\2\2\2\u0168\u0167\3\2\2\2\u0169\67\3\2\2\2\u016a\u0173\7\21\2\2\u016b"+
		"\u0170\5\64\33\2\u016c\u016d\7\6\2\2\u016d\u016f\5\64\33\2\u016e\u016c"+
		"\3\2\2\2\u016f\u0172\3\2\2\2\u0170\u016e\3\2\2\2\u0170\u0171\3\2\2\2\u0171"+
		"\u0174\3\2\2\2\u0172\u0170\3\2\2\2\u0173\u016b\3\2\2\2\u0173\u0174\3\2"+
		"\2\2\u0174\u0175\3\2\2\2\u0175\u0176\7\24\2\2\u01769\3\2\2\2\u0177\u0180"+
		"\7\21\2\2\u0178\u017d\5<\37\2\u0179\u017a\7\6\2\2\u017a\u017c\5<\37\2"+
		"\u017b\u0179\3\2\2\2\u017c\u017f\3\2\2\2\u017d\u017b\3\2\2\2\u017d\u017e"+
		"\3\2\2\2\u017e\u0181\3\2\2\2\u017f\u017d\3\2\2\2\u0180\u0178\3\2\2\2\u0180"+
		"\u0181\3\2\2\2\u0181\u0182\3\2\2\2\u0182\u0183\7\24\2\2\u0183;\3\2\2\2"+
		"\u0184\u0185\5\64\33\2\u0185\u0186\79\2\2\u0186\u0187\5\64\33\2\u0187"+
		"=\3\2\2\2\u0188\u0189\7 \2\2\u0189?\3\2\2\2\u018a\u018b\t\b\2\2\u018b"+
		"A\3\2\2\2\u018c\u018f\5D#\2\u018d\u018f\5F$\2\u018e\u018c\3\2\2\2\u018e"+
		"\u018d\3\2\2\2\u018fC\3\2\2\2\u0190\u0191\7\16\2\2\u0191\u0192\7*\2\2"+
		"\u0192\u0193\5B\"\2\u0193\u0194\7)\2\2\u0194\u019b\3\2\2\2\u0195\u0196"+
		"\7\7\2\2\u0196\u0197\7*\2\2\u0197\u0198\5B\"\2\u0198\u0199\7)\2\2\u0199"+
		"\u019b\3\2\2\2\u019a\u0190\3\2\2\2\u019a\u0195\3\2\2\2\u019bE\3\2\2\2"+
		"\u019c\u019d\7\37\2\2\u019dG\3\2\2\2\u019e\u019f\7\31\2\2\u019fI\3\2\2"+
		"\2\u01a0\u01a1\7\27\2\2\u01a1K\3\2\2\2\u01a2\u01a3\7\22\2\2\u01a3M\3\2"+
		"\2\2\u01a4\u01a6\7\f\2\2\u01a5\u01a4\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6"+
		"\u01a7\3\2\2\2\u01a7\u01a8\7\b\2\2\u01a8O\3\2\2\2+S^cns{\u0082\u0085\u008d"+
		"\u0090\u009b\u00a0\u00aa\u00b0\u00b5\u00c1\u00c7\u00cb\u00d6\u00de\u00e4"+
		"\u00ee\u00fe\u010c\u010f\u0119\u011e\u0125\u0129\u0132\u0147\u015d\u015f"+
		"\u0168\u0170\u0173\u017d\u0180\u018e\u019a\u01a5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}