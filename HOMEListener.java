// Generated from HOME.g4 by ANTLR 4.2
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HOMEParser}.
 */
public interface HOMEListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HOMEParser#port}.
	 * @param ctx the parse tree
	 */
	void enterPort(@NotNull HOMEParser.PortContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#port}.
	 * @param ctx the parse tree
	 */
	void exitPort(@NotNull HOMEParser.PortContext ctx);

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
	 * Enter a parse tree produced by {@link HOMEParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(@NotNull HOMEParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(@NotNull HOMEParser.AssignContext ctx);

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
	 * Enter a parse tree produced by {@link HOMEParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(@NotNull HOMEParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(@NotNull HOMEParser.ConditionContext ctx);

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
	 * Enter a parse tree produced by {@link HOMEParser#declarationParameters}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationParameters(@NotNull HOMEParser.DeclarationParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#declarationParameters}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationParameters(@NotNull HOMEParser.DeclarationParametersContext ctx);

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
	 * Enter a parse tree produced by {@link HOMEParser#logicalOperator}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOperator(@NotNull HOMEParser.LogicalOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#logicalOperator}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOperator(@NotNull HOMEParser.LogicalOperatorContext ctx);

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
	 * Enter a parse tree produced by {@link HOMEParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(@NotNull HOMEParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(@NotNull HOMEParser.PrimitiveTypeContext ctx);

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
	 * Enter a parse tree produced by {@link HOMEParser#identifierOrListIndex}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierOrListIndex(@NotNull HOMEParser.IdentifierOrListIndexContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#identifierOrListIndex}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierOrListIndex(@NotNull HOMEParser.IdentifierOrListIndexContext ctx);

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
	 * Enter a parse tree produced by {@link HOMEParser#declarationParameterList}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationParameterList(@NotNull HOMEParser.DeclarationParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#declarationParameterList}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationParameterList(@NotNull HOMEParser.DeclarationParameterListContext ctx);

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
	 * Enter a parse tree produced by {@link HOMEParser#collectionInit}.
	 * @param ctx the parse tree
	 */
	void enterCollectionInit(@NotNull HOMEParser.CollectionInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link HOMEParser#collectionInit}.
	 * @param ctx the parse tree
	 */
	void exitCollectionInit(@NotNull HOMEParser.CollectionInitContext ctx);

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