// Generated from ./HOME.g4 by ANTLR 4.2

package HOME.Grammar;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HOMEParser}.
 */
public interface HOMEListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HOMEParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull HOMEParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull HOMEParser.ExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link HOMEParser#collectionType}.
	 * @param ctx the parse tree
	 */
	void enterCollectionType(@NotNull HOMEParser.CollectionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#collectionType}.
	 * @param ctx the parse tree
	 */
	void exitCollectionType(@NotNull HOMEParser.CollectionTypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link HOMEParser#int2dec}.
	 * @param ctx the parse tree
	 */
	void enterInt2dec(@NotNull HOMEParser.Int2decContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#int2dec}.
	 * @param ctx the parse tree
	 */
	void exitInt2dec(@NotNull HOMEParser.Int2decContext ctx);

	/**
	 * Enter a parse tree produced by {@link HOMEParser#dictionaryLiteral}.
	 * @param ctx the parse tree
	 */
	void enterDictionaryLiteral(@NotNull HOMEParser.DictionaryLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#dictionaryLiteral}.
	 * @param ctx the parse tree
	 */
	void exitDictionaryLiteral(@NotNull HOMEParser.DictionaryLiteralContext ctx);

	/**
	 * Enter a parse tree produced by {@link HOMEParser#stmts}.
	 * @param ctx the parse tree
	 */
	void enterStmts(@NotNull HOMEParser.StmtsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#stmts}.
	 * @param ctx the parse tree
	 */
	void exitStmts(@NotNull HOMEParser.StmtsContext ctx);

	/**
	 * Enter a parse tree produced by {@link HOMEParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull HOMEParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull HOMEParser.BlockContext ctx);

	/**
	 * Enter a parse tree produced by {@link HOMEParser#listIndex}.
	 * @param ctx the parse tree
	 */
	void enterListIndex(@NotNull HOMEParser.ListIndexContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#listIndex}.
	 * @param ctx the parse tree
	 */
	void exitListIndex(@NotNull HOMEParser.ListIndexContext ctx);

	/**
	 * Enter a parse tree produced by {@link HOMEParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull HOMEParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull HOMEParser.TypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link HOMEParser#loopForeach}.
	 * @param ctx the parse tree
	 */
	void enterLoopForeach(@NotNull HOMEParser.LoopForeachContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#loopForeach}.
	 * @param ctx the parse tree
	 */
	void exitLoopForeach(@NotNull HOMEParser.LoopForeachContext ctx);

	/**
	 * Enter a parse tree produced by {@link HOMEParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(@NotNull HOMEParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(@NotNull HOMEParser.FunctionContext ctx);

	/**
	 * Enter a parse tree produced by {@link HOMEParser#elseStmt}.
	 * @param ctx the parse tree
	 */
	void enterElseStmt(@NotNull HOMEParser.ElseStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#elseStmt}.
	 * @param ctx the parse tree
	 */
	void exitElseStmt(@NotNull HOMEParser.ElseStmtContext ctx);

	/**
	 * Enter a parse tree produced by {@link HOMEParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(@NotNull HOMEParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(@NotNull HOMEParser.LoopContext ctx);

	/**
	 * Enter a parse tree produced by {@link HOMEParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(@NotNull HOMEParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(@NotNull HOMEParser.IfStmtContext ctx);

	/**
	 * Enter a parse tree produced by {@link HOMEParser#classes}.
	 * @param ctx the parse tree
	 */
	void enterClasses(@NotNull HOMEParser.ClassesContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#classes}.
	 * @param ctx the parse tree
	 */
	void exitClasses(@NotNull HOMEParser.ClassesContext ctx);

	/**
	 * Enter a parse tree produced by {@link HOMEParser#dictionaryEntry}.
	 * @param ctx the parse tree
	 */
	void enterDictionaryEntry(@NotNull HOMEParser.DictionaryEntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#dictionaryEntry}.
	 * @param ctx the parse tree
	 */
	void exitDictionaryEntry(@NotNull HOMEParser.DictionaryEntryContext ctx);

	/**
	 * Enter a parse tree produced by {@link HOMEParser#listLiteral}.
	 * @param ctx the parse tree
	 */
	void enterListLiteral(@NotNull HOMEParser.ListLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#listLiteral}.
	 * @param ctx the parse tree
	 */
	void exitListLiteral(@NotNull HOMEParser.ListLiteralContext ctx);

	/**
	 * Enter a parse tree produced by {@link HOMEParser#functionParameters}.
	 * @param ctx the parse tree
	 */
	void enterFunctionParameters(@NotNull HOMEParser.FunctionParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#functionParameters}.
	 * @param ctx the parse tree
	 */
	void exitFunctionParameters(@NotNull HOMEParser.FunctionParametersContext ctx);

	/**
	 * Enter a parse tree produced by {@link HOMEParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(@NotNull HOMEParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(@NotNull HOMEParser.DeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link HOMEParser#or}.
	 * @param ctx the parse tree
	 */
	void enterOr(@NotNull HOMEParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#or}.
	 * @param ctx the parse tree
	 */
	void exitOr(@NotNull HOMEParser.OrContext ctx);

	/**
	 * Enter a parse tree produced by {@link HOMEParser#global}.
	 * @param ctx the parse tree
	 */
	void enterGlobal(@NotNull HOMEParser.GlobalContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#global}.
	 * @param ctx the parse tree
	 */
	void exitGlobal(@NotNull HOMEParser.GlobalContext ctx);

	/**
	 * Enter a parse tree produced by {@link HOMEParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(@NotNull HOMEParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(@NotNull HOMEParser.StmtContext ctx);

	/**
	 * Enter a parse tree produced by {@link HOMEParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(@NotNull HOMEParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(@NotNull HOMEParser.BooleanLiteralContext ctx);

	/**
	 * Enter a parse tree produced by {@link HOMEParser#loopWhileOrUntil}.
	 * @param ctx the parse tree
	 */
	void enterLoopWhileOrUntil(@NotNull HOMEParser.LoopWhileOrUntilContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#loopWhileOrUntil}.
	 * @param ctx the parse tree
	 */
	void exitLoopWhileOrUntil(@NotNull HOMEParser.LoopWhileOrUntilContext ctx);

	/**
	 * Enter a parse tree produced by {@link HOMEParser#and}.
	 * @param ctx the parse tree
	 */
	void enterAnd(@NotNull HOMEParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#and}.
	 * @param ctx the parse tree
	 */
	void exitAnd(@NotNull HOMEParser.AndContext ctx);

	/**
	 * Enter a parse tree produced by {@link HOMEParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(@NotNull HOMEParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(@NotNull HOMEParser.FieldContext ctx);

	/**
	 * Enter a parse tree produced by {@link HOMEParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(@NotNull HOMEParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(@NotNull HOMEParser.AssignmentContext ctx);

	/**
	 * Enter a parse tree produced by {@link HOMEParser#newline}.
	 * @param ctx the parse tree
	 */
	void enterNewline(@NotNull HOMEParser.NewlineContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#newline}.
	 * @param ctx the parse tree
	 */
	void exitNewline(@NotNull HOMEParser.NewlineContext ctx);

	/**
	 * Enter a parse tree produced by {@link HOMEParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull HOMEParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull HOMEParser.ProgramContext ctx);

	/**
	 * Enter a parse tree produced by {@link HOMEParser#elseIfStmt}.
	 * @param ctx the parse tree
	 */
	void enterElseIfStmt(@NotNull HOMEParser.ElseIfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#elseIfStmt}.
	 * @param ctx the parse tree
	 */
	void exitElseIfStmt(@NotNull HOMEParser.ElseIfStmtContext ctx);

	/**
	 * Enter a parse tree produced by {@link HOMEParser#returnFunction}.
	 * @param ctx the parse tree
	 */
	void enterReturnFunction(@NotNull HOMEParser.ReturnFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#returnFunction}.
	 * @param ctx the parse tree
	 */
	void exitReturnFunction(@NotNull HOMEParser.ReturnFunctionContext ctx);

	/**
	 * Enter a parse tree produced by {@link HOMEParser#nothing}.
	 * @param ctx the parse tree
	 */
	void enterNothing(@NotNull HOMEParser.NothingContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#nothing}.
	 * @param ctx the parse tree
	 */
	void exitNothing(@NotNull HOMEParser.NothingContext ctx);

	/**
	 * Enter a parse tree produced by {@link HOMEParser#funcParamDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFuncParamDeclaration(@NotNull HOMEParser.FuncParamDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#funcParamDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFuncParamDeclaration(@NotNull HOMEParser.FuncParamDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link HOMEParser#funcParameters}.
	 * @param ctx the parse tree
	 */
	void enterFuncParameters(@NotNull HOMEParser.FuncParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#funcParameters}.
	 * @param ctx the parse tree
	 */
	void exitFuncParameters(@NotNull HOMEParser.FuncParametersContext ctx);

	/**
	 * Enter a parse tree produced by {@link HOMEParser#incDec}.
	 * @param ctx the parse tree
	 */
	void enterIncDec(@NotNull HOMEParser.IncDecContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#incDec}.
	 * @param ctx the parse tree
	 */
	void exitIncDec(@NotNull HOMEParser.IncDecContext ctx);

	/**
	 * Enter a parse tree produced by {@link HOMEParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(@NotNull HOMEParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(@NotNull HOMEParser.IdentifierContext ctx);

	/**
	 * Enter a parse tree produced by {@link HOMEParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void enterFuncCall(@NotNull HOMEParser.FuncCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void exitFuncCall(@NotNull HOMEParser.FuncCallContext ctx);

	/**
	 * Enter a parse tree produced by {@link HOMEParser#moreFunctions}.
	 * @param ctx the parse tree
	 */
	void enterMoreFunctions(@NotNull HOMEParser.MoreFunctionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#moreFunctions}.
	 * @param ctx the parse tree
	 */
	void exitMoreFunctions(@NotNull HOMEParser.MoreFunctionsContext ctx);

	/**
	 * Enter a parse tree produced by {@link HOMEParser#variableMethodCall}.
	 * @param ctx the parse tree
	 */
	void enterVariableMethodCall(@NotNull HOMEParser.VariableMethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#variableMethodCall}.
	 * @param ctx the parse tree
	 */
	void exitVariableMethodCall(@NotNull HOMEParser.VariableMethodCallContext ctx);

	/**
	 * Enter a parse tree produced by {@link HOMEParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(@NotNull HOMEParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(@NotNull HOMEParser.LiteralContext ctx);
}