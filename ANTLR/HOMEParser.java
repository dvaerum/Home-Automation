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
		"<INVALID>", "']'", "'in'", "'endif'", "','", "'\n'", "'Dictionary'", 
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
		RULE_program = 0, RULE_global = 1, RULE_block = 2, RULE_moreFunctions = 3, 
		RULE_function = 4, RULE_funcParameters = 5, RULE_declarationParameters = 6, 
		RULE_declarationParameterList = 7, RULE_stmts = 8, RULE_newline = 9, RULE_stmt = 10, 
		RULE_incDec = 11, RULE_declaration = 12, RULE_assign = 13, RULE_ifStmt = 14, 
		RULE_elseIfStmt = 15, RULE_elseStmt = 16, RULE_loop = 17, RULE_loopWhileOrUntil = 18, 
		RULE_loopForeach = 19, RULE_funcCall = 20, RULE_variableMethodCall = 21, 
		RULE_returnFunction = 22, RULE_condition = 23, RULE_identifierOrListIndex = 24, 
		RULE_expression = 25, RULE_literal = 26, RULE_booleanLiteral = 27, RULE_collectionInit = 28, 
		RULE_type = 29, RULE_primitiveType = 30, RULE_collectionType = 31, RULE_classes = 32, 
		RULE_port = 33, RULE_nothing = 34, RULE_logicalOperator = 35;
	public static final String[] ruleNames = {
		"program", "global", "block", "moreFunctions", "function", "funcParameters", 
		"declarationParameters", "declarationParameterList", "stmts", "newline", 
		"stmt", "incDec", "declaration", "assign", "ifStmt", "elseIfStmt", "elseStmt", 
		"loop", "loopWhileOrUntil", "loopForeach", "funcCall", "variableMethodCall", 
		"returnFunction", "condition", "identifierOrListIndex", "expression", 
		"literal", "booleanLiteral", "collectionInit", "type", "primitiveType", 
		"collectionType", "classes", "port", "nothing", "logicalOperator"
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
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 6) | (1L << 12) | (1L << 16) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << Identifier))) != 0)) {
					{
					{
					setState(76); declaration();
					}
					}
					setState(81);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(83); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(82); newline();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(85); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				} while ( _alt!=2 && _alt!=-1 );
				setState(87); global();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Identifier) {
					{
					{
					setState(89); assign();
					}
					}
					setState(94);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(96); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(95); newline();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(98); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				} while ( _alt!=2 && _alt!=-1 );
				setState(100); global();
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
			case 5:
			case 10:
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==5 || _la==10) {
					{
					{
					setState(108); newline();
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
		enterRule(_localctx, 6, RULE_moreFunctions);
		int _la;
		try {
			int _alt;
			setState(129);
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
						setState(116); newline();
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
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==5 || _la==10) {
					{
					{
					setState(123); newline();
					}
					}
					setState(128);
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
			setState(131); match(26);
			setState(132); identifierOrListIndex();
			setState(133); declarationParameters();
			setState(134); match(32);
			setState(137);
			switch (_input.LA(1)) {
			case 6:
			case 12:
			case 16:
			case 28:
			case 29:
			case 30:
			case Identifier:
				{
				setState(135); type();
				}
				break;
			case 25:
				{
				setState(136); nothing();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(140); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(139); newline();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(142); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			setState(144); stmts();
			setState(145); match(8);
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
			setState(147); match(LPAREN);
			setState(156);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 13) | (1L << 15) | (1L << 21) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << DecimalLiteral) | (1L << StringLiteral) | (1L << ADD) | (1L << SUB) | (1L << LPAREN))) != 0)) {
				{
				setState(148); expression(0);
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4) {
					{
					{
					setState(149); match(4);
					setState(150); expression(0);
					}
					}
					setState(155);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(158); match(RPAREN);
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
			setState(160); match(LPAREN);
			setState(169);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 6) | (1L << 12) | (1L << 16) | (1L << 28) | (1L << 29) | (1L << 30) | (1L << Identifier))) != 0)) {
				{
				setState(161); declaration();
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4) {
					{
					{
					setState(162); match(4);
					setState(163); declaration();
					}
					}
					setState(168);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(171); match(RPAREN);
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
			setState(173); declaration();
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4) {
				{
				{
				setState(174); match(4);
				setState(175); declaration();
				}
				}
				setState(180);
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
			int _alt;
			setState(195);
			switch (_input.LA(1)) {
			case 6:
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
				setState(181); stmt();
				setState(183); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(182); newline();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(185); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				} while ( _alt!=2 && _alt!=-1 );
				setState(187); stmts();
				}
				break;
			case 3:
			case 5:
			case 8:
			case 10:
			case 19:
			case 22:
			case 24:
				enterOuterAlt(_localctx, 2);
				{
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==5 || _la==10) {
					{
					{
					setState(189); newline();
					}
					}
					setState(194);
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
		enterRule(_localctx, 18, RULE_newline);
		int _la;
		try {
			setState(202);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				_la = _input.LA(1);
				if (_la==10) {
					{
					setState(197); match(10);
					}
				}

				setState(200); match(5);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(201); match(10);
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
		enterRule(_localctx, 20, RULE_stmt);
		try {
			setState(212);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(204); declaration();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(205); assign();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(206); ifStmt();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(207); loop();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(208); funcCall();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(209); variableMethodCall();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(210); returnFunction();
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(211); incDec();
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
		enterRule(_localctx, 22, RULE_incDec);
		try {
			setState(220);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(214); identifierOrListIndex();
				setState(215); match(INC);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(217); identifierOrListIndex();
				setState(218); match(DEC);
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
		enterRule(_localctx, 24, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222); type();
			setState(223); identifierOrListIndex();
			setState(226);
			_la = _input.LA(1);
			if (_la==AnyAssign) {
				{
				setState(224); match(AnyAssign);
				setState(225); expression(0);
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
		enterRule(_localctx, 26, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228); identifierOrListIndex();
			setState(229); match(AnyAssign);
			setState(230); expression(0);
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
		enterRule(_localctx, 28, RULE_ifStmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(232); match(11);
			setState(233); match(LPAREN);
			setState(234); expression(0);
			setState(235); match(RPAREN);
			setState(237); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(236); newline();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(239); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			setState(241); stmts();
			setState(245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==22) {
				{
				{
				setState(242); elseIfStmt();
				}
				}
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(249);
			_la = _input.LA(1);
			if (_la==19) {
				{
				setState(248); elseStmt();
				}
			}

			setState(251); match(3);
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
		enterRule(_localctx, 30, RULE_elseIfStmt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(253); match(22);
			setState(254); match(LPAREN);
			setState(255); expression(0);
			setState(256); match(RPAREN);
			setState(258); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(257); newline();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(260); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			setState(262); stmts();
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
		enterRule(_localctx, 32, RULE_elseStmt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(264); match(19);
			setState(266); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(265); newline();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(268); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			setState(271);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(270); stmts();
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
		enterRule(_localctx, 34, RULE_loop);
		try {
			setState(275);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(273); loopWhileOrUntil();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(274); loopForeach();
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
		enterRule(_localctx, 36, RULE_loopWhileOrUntil);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(277); match(31);
			setState(278);
			_la = _input.LA(1);
			if ( !(_la==9 || _la==14) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(279); match(LPAREN);
			setState(280); expression(0);
			setState(281); match(RPAREN);
			setState(283); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(282); newline();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(285); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			setState(287); stmts();
			setState(288); match(24);
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
		enterRule(_localctx, 38, RULE_loopForeach);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(290); match(31);
			setState(291); match(33);
			setState(292); match(LPAREN);
			setState(293); type();
			setState(294); identifierOrListIndex();
			setState(295); match(2);
			setState(296); identifierOrListIndex();
			setState(297); match(RPAREN);
			setState(299); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(298); newline();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(301); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			setState(303); stmts();
			setState(304); match(24);
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
		enterRule(_localctx, 40, RULE_funcCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306); identifierOrListIndex();
			setState(307); funcParameters();
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
		enterRule(_localctx, 42, RULE_variableMethodCall);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(309); identifierOrListIndex();
			setState(310); match(DOT);
			setState(311); funcCall();
			setState(316);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(312); match(DOT);
					setState(313); funcCall();
					}
					} 
				}
				setState(318);
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
		enterRule(_localctx, 44, RULE_returnFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319); match(27);
			setState(321);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 13) | (1L << 15) | (1L << 21) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << DecimalLiteral) | (1L << StringLiteral) | (1L << ADD) | (1L << SUB) | (1L << LPAREN))) != 0)) {
				{
				setState(320); expression(0);
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
		enterRule(_localctx, 46, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(323); identifierOrListIndex();
				}
				break;
			case 13:
			case 21:
			case IntegerLiteral:
			case DecimalLiteral:
			case StringLiteral:
				{
				setState(324); literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(327); logicalOperator();
			setState(330);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(328); identifierOrListIndex();
				}
				break;
			case 13:
			case 21:
			case IntegerLiteral:
			case DecimalLiteral:
			case StringLiteral:
				{
				setState(329); literal();
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
		enterRule(_localctx, 48, RULE_identifierOrListIndex);
		try {
			setState(338);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(332); match(Identifier);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(333); match(Identifier);
				setState(334); match(7);
				setState(335); expression(0);
				setState(336); match(1);
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
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				setState(341);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUB) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(342); expression(8);
				}
				break;

			case 2:
				{
				setState(343); funcCall();
				}
				break;

			case 3:
				{
				setState(344); literal();
				}
				break;

			case 4:
				{
				setState(345); collectionInit();
				}
				break;

			case 5:
				{
				setState(346); variableMethodCall();
				}
				break;

			case 6:
				{
				setState(347); identifierOrListIndex();
				}
				break;

			case 7:
				{
				setState(348); match(LPAREN);
				setState(349); expression(0);
				setState(350); match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(366);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(364);
					switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(354);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(355);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(356); expression(11);
						}
						break;

					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(357);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(358);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(359); expression(10);
						}
						break;

					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(360);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(361); logicalOperator();
						setState(362); expression(8);
						}
						break;
					}
					} 
				}
				setState(368);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
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
		enterRule(_localctx, 52, RULE_literal);
		try {
			setState(373);
			switch (_input.LA(1)) {
			case 13:
			case 21:
				enterOuterAlt(_localctx, 1);
				{
				setState(369); booleanLiteral();
				}
				break;
			case DecimalLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(370); match(DecimalLiteral);
				}
				break;
			case IntegerLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(371); match(IntegerLiteral);
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 4);
				{
				setState(372); match(StringLiteral);
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
		enterRule(_localctx, 54, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
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
		enterRule(_localctx, 56, RULE_collectionInit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(377); match(15);
			setState(386);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 13) | (1L << 15) | (1L << 21) | (1L << Identifier) | (1L << IntegerLiteral) | (1L << DecimalLiteral) | (1L << StringLiteral) | (1L << ADD) | (1L << SUB) | (1L << LPAREN))) != 0)) {
				{
				setState(378); expression(0);
				setState(383);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4) {
					{
					{
					setState(379); match(4);
					setState(380); expression(0);
					}
					}
					setState(385);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(388); match(20);
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
		enterRule(_localctx, 58, RULE_type);
		try {
			setState(393);
			switch (_input.LA(1)) {
			case 16:
			case 28:
			case 29:
			case 30:
				enterOuterAlt(_localctx, 1);
				{
				setState(390); primitiveType();
				}
				break;
			case 6:
			case 12:
				enterOuterAlt(_localctx, 2);
				{
				setState(391); collectionType();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 3);
				{
				setState(392); classes();
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
		enterRule(_localctx, 60, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(395);
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
		enterRule(_localctx, 62, RULE_collectionType);
		try {
			setState(407);
			switch (_input.LA(1)) {
			case 12:
				enterOuterAlt(_localctx, 1);
				{
				setState(397); match(12);
				setState(398); match(LT);
				setState(399); type();
				setState(400); match(GT);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 2);
				{
				setState(402); match(6);
				setState(403); match(LT);
				setState(404); type();
				setState(405); match(GT);
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
		enterRule(_localctx, 64, RULE_classes);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(409); match(Identifier);
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
		enterRule(_localctx, 66, RULE_port);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(411); match(17);
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
		enterRule(_localctx, 68, RULE_nothing);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(413); match(25);
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
		enterRule(_localctx, 70, RULE_logicalOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 25: return expression_sempred((ExpressionContext)_localctx, predIndex);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3G\u01a4\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\3\2\3\2\3\2\3\3\7\3P\n\3\f\3\16\3S\13"+
		"\3\3\3\6\3V\n\3\r\3\16\3W\3\3\3\3\3\3\7\3]\n\3\f\3\16\3`\13\3\3\3\6\3"+
		"c\n\3\r\3\16\3d\3\3\3\3\3\3\5\3j\n\3\3\4\3\4\3\4\3\4\7\4p\n\4\f\4\16\4"+
		"s\13\4\5\4u\n\4\3\5\6\5x\n\5\r\5\16\5y\3\5\3\5\3\5\7\5\177\n\5\f\5\16"+
		"\5\u0082\13\5\5\5\u0084\n\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u008c\n\6\3\6"+
		"\6\6\u008f\n\6\r\6\16\6\u0090\3\6\3\6\3\6\3\7\3\7\3\7\3\7\7\7\u009a\n"+
		"\7\f\7\16\7\u009d\13\7\5\7\u009f\n\7\3\7\3\7\3\b\3\b\3\b\3\b\7\b\u00a7"+
		"\n\b\f\b\16\b\u00aa\13\b\5\b\u00ac\n\b\3\b\3\b\3\t\3\t\3\t\7\t\u00b3\n"+
		"\t\f\t\16\t\u00b6\13\t\3\n\3\n\6\n\u00ba\n\n\r\n\16\n\u00bb\3\n\3\n\3"+
		"\n\7\n\u00c1\n\n\f\n\16\n\u00c4\13\n\5\n\u00c6\n\n\3\13\5\13\u00c9\n\13"+
		"\3\13\3\13\5\13\u00cd\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00d7\n"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00df\n\r\3\16\3\16\3\16\3\16\5\16\u00e5"+
		"\n\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\6\20\u00f0\n\20\r\20"+
		"\16\20\u00f1\3\20\3\20\7\20\u00f6\n\20\f\20\16\20\u00f9\13\20\3\20\5\20"+
		"\u00fc\n\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\6\21\u0105\n\21\r\21\16"+
		"\21\u0106\3\21\3\21\3\22\3\22\6\22\u010d\n\22\r\22\16\22\u010e\3\22\5"+
		"\22\u0112\n\22\3\23\3\23\5\23\u0116\n\23\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\6\24\u011e\n\24\r\24\16\24\u011f\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\6\25\u012e\n\25\r\25\16\25\u012f\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\7\27\u013d\n\27\f\27\16\27\u0140"+
		"\13\27\3\30\3\30\5\30\u0144\n\30\3\31\3\31\5\31\u0148\n\31\3\31\3\31\3"+
		"\31\5\31\u014d\n\31\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0155\n\32\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u0163\n\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\7\33\u016f\n\33\f\33"+
		"\16\33\u0172\13\33\3\34\3\34\3\34\3\34\5\34\u0178\n\34\3\35\3\35\3\36"+
		"\3\36\3\36\3\36\7\36\u0180\n\36\f\36\16\36\u0183\13\36\5\36\u0185\n\36"+
		"\3\36\3\36\3\37\3\37\3\37\5\37\u018c\n\37\3 \3 \3!\3!\3!\3!\3!\3!\3!\3"+
		"!\3!\3!\5!\u019a\n!\3\"\3\"\3#\3#\3$\3$\3%\3%\3%\2\3\64&\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFH\2\b\4\2\13\13\20"+
		"\20\3\2\64\65\3\2\668\4\2\17\17\27\27\4\2\22\22\36 \5\2\24\24\31\31,\61"+
		"\u01be\2J\3\2\2\2\4i\3\2\2\2\6t\3\2\2\2\b\u0083\3\2\2\2\n\u0085\3\2\2"+
		"\2\f\u0095\3\2\2\2\16\u00a2\3\2\2\2\20\u00af\3\2\2\2\22\u00c5\3\2\2\2"+
		"\24\u00cc\3\2\2\2\26\u00d6\3\2\2\2\30\u00de\3\2\2\2\32\u00e0\3\2\2\2\34"+
		"\u00e6\3\2\2\2\36\u00ea\3\2\2\2 \u00ff\3\2\2\2\"\u010a\3\2\2\2$\u0115"+
		"\3\2\2\2&\u0117\3\2\2\2(\u0124\3\2\2\2*\u0134\3\2\2\2,\u0137\3\2\2\2."+
		"\u0141\3\2\2\2\60\u0147\3\2\2\2\62\u0154\3\2\2\2\64\u0162\3\2\2\2\66\u0177"+
		"\3\2\2\28\u0179\3\2\2\2:\u017b\3\2\2\2<\u018b\3\2\2\2>\u018d\3\2\2\2@"+
		"\u0199\3\2\2\2B\u019b\3\2\2\2D\u019d\3\2\2\2F\u019f\3\2\2\2H\u01a1\3\2"+
		"\2\2JK\5\4\3\2KL\5\6\4\2LM\7\2\2\3M\3\3\2\2\2NP\5\32\16\2ON\3\2\2\2PS"+
		"\3\2\2\2QO\3\2\2\2QR\3\2\2\2RU\3\2\2\2SQ\3\2\2\2TV\5\24\13\2UT\3\2\2\2"+
		"VW\3\2\2\2WU\3\2\2\2WX\3\2\2\2XY\3\2\2\2YZ\5\4\3\2Zj\3\2\2\2[]\5\34\17"+
		"\2\\[\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_b\3\2\2\2`^\3\2\2\2ac\5\24"+
		"\13\2ba\3\2\2\2cd\3\2\2\2db\3\2\2\2de\3\2\2\2ef\3\2\2\2fg\5\4\3\2gj\3"+
		"\2\2\2hj\3\2\2\2iQ\3\2\2\2i^\3\2\2\2ih\3\2\2\2j\5\3\2\2\2kl\5\n\6\2lm"+
		"\5\b\5\2mu\3\2\2\2np\5\24\13\2on\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2"+
		"ru\3\2\2\2sq\3\2\2\2tk\3\2\2\2tq\3\2\2\2u\7\3\2\2\2vx\5\24\13\2wv\3\2"+
		"\2\2xy\3\2\2\2yw\3\2\2\2yz\3\2\2\2z{\3\2\2\2{|\5\6\4\2|\u0084\3\2\2\2"+
		"}\177\5\24\13\2~}\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081"+
		"\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0083w\3\2\2\2\u0083"+
		"\u0080\3\2\2\2\u0084\t\3\2\2\2\u0085\u0086\7\34\2\2\u0086\u0087\5\62\32"+
		"\2\u0087\u0088\5\16\b\2\u0088\u008b\7\"\2\2\u0089\u008c\5<\37\2\u008a"+
		"\u008c\5F$\2\u008b\u0089\3\2\2\2\u008b\u008a\3\2\2\2\u008c\u008e\3\2\2"+
		"\2\u008d\u008f\5\24\13\2\u008e\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090"+
		"\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\5\22"+
		"\n\2\u0093\u0094\7\n\2\2\u0094\13\3\2\2\2\u0095\u009e\7<\2\2\u0096\u009b"+
		"\5\64\33\2\u0097\u0098\7\6\2\2\u0098\u009a\5\64\33\2\u0099\u0097\3\2\2"+
		"\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009f"+
		"\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u0096\3\2\2\2\u009e\u009f\3\2\2\2\u009f"+
		"\u00a0\3\2\2\2\u00a0\u00a1\7=\2\2\u00a1\r\3\2\2\2\u00a2\u00ab\7<\2\2\u00a3"+
		"\u00a8\5\32\16\2\u00a4\u00a5\7\6\2\2\u00a5\u00a7\5\32\16\2\u00a6\u00a4"+
		"\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9"+
		"\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab\u00a3\3\2\2\2\u00ab\u00ac\3\2"+
		"\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\7=\2\2\u00ae\17\3\2\2\2\u00af\u00b4"+
		"\5\32\16\2\u00b0\u00b1\7\6\2\2\u00b1\u00b3\5\32\16\2\u00b2\u00b0\3\2\2"+
		"\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\21"+
		"\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00b9\5\26\f\2\u00b8\u00ba\5\24\13"+
		"\2\u00b9\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc"+
		"\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\5\22\n\2\u00be\u00c6\3\2\2\2"+
		"\u00bf\u00c1\5\24\13\2\u00c0\u00bf\3\2\2\2\u00c1\u00c4\3\2\2\2\u00c2\u00c0"+
		"\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c5"+
		"\u00b7\3\2\2\2\u00c5\u00c2\3\2\2\2\u00c6\23\3\2\2\2\u00c7\u00c9\7\f\2"+
		"\2\u00c8\u00c7\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cd"+
		"\7\7\2\2\u00cb\u00cd\7\f\2\2\u00cc\u00c8\3\2\2\2\u00cc\u00cb\3\2\2\2\u00cd"+
		"\25\3\2\2\2\u00ce\u00d7\5\32\16\2\u00cf\u00d7\5\34\17\2\u00d0\u00d7\5"+
		"\36\20\2\u00d1\u00d7\5$\23\2\u00d2\u00d7\5*\26\2\u00d3\u00d7\5,\27\2\u00d4"+
		"\u00d7\5.\30\2\u00d5\u00d7\5\30\r\2\u00d6\u00ce\3\2\2\2\u00d6\u00cf\3"+
		"\2\2\2\u00d6\u00d0\3\2\2\2\u00d6\u00d1\3\2\2\2\u00d6\u00d2\3\2\2\2\u00d6"+
		"\u00d3\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d5\3\2\2\2\u00d7\27\3\2\2"+
		"\2\u00d8\u00d9\5\62\32\2\u00d9\u00da\7\62\2\2\u00da\u00df\3\2\2\2\u00db"+
		"\u00dc\5\62\32\2\u00dc\u00dd\7\63\2\2\u00dd\u00df\3\2\2\2\u00de\u00d8"+
		"\3\2\2\2\u00de\u00db\3\2\2\2\u00df\31\3\2\2\2\u00e0\u00e1\5<\37\2\u00e1"+
		"\u00e4\5\62\32\2\u00e2\u00e3\7>\2\2\u00e3\u00e5\5\64\33\2\u00e4\u00e2"+
		"\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\33\3\2\2\2\u00e6\u00e7\5\62\32\2\u00e7"+
		"\u00e8\7>\2\2\u00e8\u00e9\5\64\33\2\u00e9\35\3\2\2\2\u00ea\u00eb\7\r\2"+
		"\2\u00eb\u00ec\7<\2\2\u00ec\u00ed\5\64\33\2\u00ed\u00ef\7=\2\2\u00ee\u00f0"+
		"\5\24\13\2\u00ef\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00ef\3\2\2\2"+
		"\u00f1\u00f2\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f7\5\22\n\2\u00f4\u00f6"+
		"\5 \21\2\u00f5\u00f4\3\2\2\2\u00f6\u00f9\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7"+
		"\u00f8\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9\u00f7\3\2\2\2\u00fa\u00fc\5\""+
		"\22\2\u00fb\u00fa\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd"+
		"\u00fe\7\5\2\2\u00fe\37\3\2\2\2\u00ff\u0100\7\30\2\2\u0100\u0101\7<\2"+
		"\2\u0101\u0102\5\64\33\2\u0102\u0104\7=\2\2\u0103\u0105\5\24\13\2\u0104"+
		"\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2"+
		"\2\2\u0107\u0108\3\2\2\2\u0108\u0109\5\22\n\2\u0109!\3\2\2\2\u010a\u010c"+
		"\7\25\2\2\u010b\u010d\5\24\13\2\u010c\u010b\3\2\2\2\u010d\u010e\3\2\2"+
		"\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0111\3\2\2\2\u0110\u0112"+
		"\5\22\n\2\u0111\u0110\3\2\2\2\u0111\u0112\3\2\2\2\u0112#\3\2\2\2\u0113"+
		"\u0116\5&\24\2\u0114\u0116\5(\25\2\u0115\u0113\3\2\2\2\u0115\u0114\3\2"+
		"\2\2\u0116%\3\2\2\2\u0117\u0118\7!\2\2\u0118\u0119\t\2\2\2\u0119\u011a"+
		"\7<\2\2\u011a\u011b\5\64\33\2\u011b\u011d\7=\2\2\u011c\u011e\5\24\13\2"+
		"\u011d\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u011d\3\2\2\2\u011f\u0120"+
		"\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0122\5\22\n\2\u0122\u0123\7\32\2\2"+
		"\u0123\'\3\2\2\2\u0124\u0125\7!\2\2\u0125\u0126\7#\2\2\u0126\u0127\7<"+
		"\2\2\u0127\u0128\5<\37\2\u0128\u0129\5\62\32\2\u0129\u012a\7\4\2\2\u012a"+
		"\u012b\5\62\32\2\u012b\u012d\7=\2\2\u012c\u012e\5\24\13\2\u012d\u012c"+
		"\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130"+
		"\u0131\3\2\2\2\u0131\u0132\5\22\n\2\u0132\u0133\7\32\2\2\u0133)\3\2\2"+
		"\2\u0134\u0135\5\62\32\2\u0135\u0136\5\f\7\2\u0136+\3\2\2\2\u0137\u0138"+
		"\5\62\32\2\u0138\u0139\7)\2\2\u0139\u013e\5*\26\2\u013a\u013b\7)\2\2\u013b"+
		"\u013d\5*\26\2\u013c\u013a\3\2\2\2\u013d\u0140\3\2\2\2\u013e\u013c\3\2"+
		"\2\2\u013e\u013f\3\2\2\2\u013f-\3\2\2\2\u0140\u013e\3\2\2\2\u0141\u0143"+
		"\7\35\2\2\u0142\u0144\5\64\33\2\u0143\u0142\3\2\2\2\u0143\u0144\3\2\2"+
		"\2\u0144/\3\2\2\2\u0145\u0148\5\62\32\2\u0146\u0148\5\66\34\2\u0147\u0145"+
		"\3\2\2\2\u0147\u0146\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u014c\5H%\2\u014a"+
		"\u014d\5\62\32\2\u014b\u014d\5\66\34\2\u014c\u014a\3\2\2\2\u014c\u014b"+
		"\3\2\2\2\u014d\61\3\2\2\2\u014e\u0155\7$\2\2\u014f\u0150\7$\2\2\u0150"+
		"\u0151\7\t\2\2\u0151\u0152\5\64\33\2\u0152\u0153\7\3\2\2\u0153\u0155\3"+
		"\2\2\2\u0154\u014e\3\2\2\2\u0154\u014f\3\2\2\2\u0155\63\3\2\2\2\u0156"+
		"\u0157\b\33\1\2\u0157\u0158\t\3\2\2\u0158\u0163\5\64\33\n\u0159\u0163"+
		"\5*\26\2\u015a\u0163\5\66\34\2\u015b\u0163\5:\36\2\u015c\u0163\5,\27\2"+
		"\u015d\u0163\5\62\32\2\u015e\u015f\7<\2\2\u015f\u0160\5\64\33\2\u0160"+
		"\u0161\7=\2\2\u0161\u0163\3\2\2\2\u0162\u0156\3\2\2\2\u0162\u0159\3\2"+
		"\2\2\u0162\u015a\3\2\2\2\u0162\u015b\3\2\2\2\u0162\u015c\3\2\2\2\u0162"+
		"\u015d\3\2\2\2\u0162\u015e\3\2\2\2\u0163\u0170\3\2\2\2\u0164\u0165\f\f"+
		"\2\2\u0165\u0166\t\4\2\2\u0166\u016f\5\64\33\r\u0167\u0168\f\13\2\2\u0168"+
		"\u0169\t\3\2\2\u0169\u016f\5\64\33\f\u016a\u016b\f\t\2\2\u016b\u016c\5"+
		"H%\2\u016c\u016d\5\64\33\n\u016d\u016f\3\2\2\2\u016e\u0164\3\2\2\2\u016e"+
		"\u0167\3\2\2\2\u016e\u016a\3\2\2\2\u016f\u0172\3\2\2\2\u0170\u016e\3\2"+
		"\2\2\u0170\u0171\3\2\2\2\u0171\65\3\2\2\2\u0172\u0170\3\2\2\2\u0173\u0178"+
		"\58\35\2\u0174\u0178\7&\2\2\u0175\u0178\7%\2\2\u0176\u0178\7\'\2\2\u0177"+
		"\u0173\3\2\2\2\u0177\u0174\3\2\2\2\u0177\u0175\3\2\2\2\u0177\u0176\3\2"+
		"\2\2\u0178\67\3\2\2\2\u0179\u017a\t\5\2\2\u017a9\3\2\2\2\u017b\u0184\7"+
		"\21\2\2\u017c\u0181\5\64\33\2\u017d\u017e\7\6\2\2\u017e\u0180\5\64\33"+
		"\2\u017f\u017d\3\2\2\2\u0180\u0183\3\2\2\2\u0181\u017f\3\2\2\2\u0181\u0182"+
		"\3\2\2\2\u0182\u0185\3\2\2\2\u0183\u0181\3\2\2\2\u0184\u017c\3\2\2\2\u0184"+
		"\u0185\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u0187\7\26\2\2\u0187;\3\2\2\2"+
		"\u0188\u018c\5> \2\u0189\u018c\5@!\2\u018a\u018c\5B\"\2\u018b\u0188\3"+
		"\2\2\2\u018b\u0189\3\2\2\2\u018b\u018a\3\2\2\2\u018c=\3\2\2\2\u018d\u018e"+
		"\t\6\2\2\u018e?\3\2\2\2\u018f\u0190\7\16\2\2\u0190\u0191\7/\2\2\u0191"+
		"\u0192\5<\37\2\u0192\u0193\7.\2\2\u0193\u019a\3\2\2\2\u0194\u0195\7\b"+
		"\2\2\u0195\u0196\7/\2\2\u0196\u0197\5<\37\2\u0197\u0198\7.\2\2\u0198\u019a"+
		"\3\2\2\2\u0199\u018f\3\2\2\2\u0199\u0194\3\2\2\2\u019aA\3\2\2\2\u019b"+
		"\u019c\7$\2\2\u019cC\3\2\2\2\u019d\u019e\7\23\2\2\u019eE\3\2\2\2\u019f"+
		"\u01a0\7\33\2\2\u01a0G\3\2\2\2\u01a1\u01a2\t\7\2\2\u01a2I\3\2\2\2\61Q"+
		"W^diqty\u0080\u0083\u008b\u0090\u009b\u009e\u00a8\u00ab\u00b4\u00bb\u00c2"+
		"\u00c5\u00c8\u00cc\u00d6\u00de\u00e4\u00f1\u00f7\u00fb\u0106\u010e\u0111"+
		"\u0115\u011f\u012f\u013e\u0143\u0147\u014c\u0154\u0162\u016e\u0170\u0177"+
		"\u0181\u0184\u018b\u0199";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}