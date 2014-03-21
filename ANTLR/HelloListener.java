// Generated from Hello.g4 by ANTLR 4.2
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HelloParser}.
 */
public interface HelloListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HelloParser#port}.
	 * @param ctx the parse tree
	 */
	void enterPort(@NotNull HelloParser.PortContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#port}.
	 * @param ctx the parse tree
	 */
	void exitPort(@NotNull HelloParser.PortContext ctx);

	/**
	 * Enter a parse tree produced by {@link HelloParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull HelloParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull HelloParser.ExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link HelloParser#collectionType}.
	 * @param ctx the parse tree
	 */
	void enterCollectionType(@NotNull HelloParser.CollectionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#collectionType}.
	 * @param ctx the parse tree
	 */
	void exitCollectionType(@NotNull HelloParser.CollectionTypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link HelloParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(@NotNull HelloParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(@NotNull HelloParser.AssignContext ctx);

	/**
	 * Enter a parse tree produced by {@link HelloParser#stmts}.
	 * @param ctx the parse tree
	 */
	void enterStmts(@NotNull HelloParser.StmtsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#stmts}.
	 * @param ctx the parse tree
	 */
	void exitStmts(@NotNull HelloParser.StmtsContext ctx);

	/**
	 * Enter a parse tree produced by {@link HelloParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull HelloParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull HelloParser.BlockContext ctx);

	/**
	 * Enter a parse tree produced by {@link HelloParser#constructClass}.
	 * @param ctx the parse tree
	 */
	void enterConstructClass(@NotNull HelloParser.ConstructClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#constructClass}.
	 * @param ctx the parse tree
	 */
	void exitConstructClass(@NotNull HelloParser.ConstructClassContext ctx);

	/**
	 * Enter a parse tree produced by {@link HelloParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull HelloParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull HelloParser.TypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link HelloParser#loopForeach}.
	 * @param ctx the parse tree
	 */
	void enterLoopForeach(@NotNull HelloParser.LoopForeachContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#loopForeach}.
	 * @param ctx the parse tree
	 */
	void exitLoopForeach(@NotNull HelloParser.LoopForeachContext ctx);

	/**
	 * Enter a parse tree produced by {@link HelloParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(@NotNull HelloParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(@NotNull HelloParser.FunctionContext ctx);

	/**
	 * Enter a parse tree produced by {@link HelloParser#elseStmt}.
	 * @param ctx the parse tree
	 */
	void enterElseStmt(@NotNull HelloParser.ElseStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#elseStmt}.
	 * @param ctx the parse tree
	 */
	void exitElseStmt(@NotNull HelloParser.ElseStmtContext ctx);

	/**
	 * Enter a parse tree produced by {@link HelloParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(@NotNull HelloParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(@NotNull HelloParser.LoopContext ctx);

	/**
	 * Enter a parse tree produced by {@link HelloParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(@NotNull HelloParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(@NotNull HelloParser.IfStmtContext ctx);

	/**
	 * Enter a parse tree produced by {@link HelloParser#constructClassPort}.
	 * @param ctx the parse tree
	 */
	void enterConstructClassPort(@NotNull HelloParser.ConstructClassPortContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#constructClassPort}.
	 * @param ctx the parse tree
	 */
	void exitConstructClassPort(@NotNull HelloParser.ConstructClassPortContext ctx);

	/**
	 * Enter a parse tree produced by {@link HelloParser#classes}.
	 * @param ctx the parse tree
	 */
	void enterClasses(@NotNull HelloParser.ClassesContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#classes}.
	 * @param ctx the parse tree
	 */
	void exitClasses(@NotNull HelloParser.ClassesContext ctx);

	/**
	 * Enter a parse tree produced by {@link HelloParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(@NotNull HelloParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(@NotNull HelloParser.DeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link HelloParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(@NotNull HelloParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(@NotNull HelloParser.ConditionContext ctx);

	/**
	 * Enter a parse tree produced by {@link HelloParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(@NotNull HelloParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(@NotNull HelloParser.StmtContext ctx);

	/**
	 * Enter a parse tree produced by {@link HelloParser#declarationParameters}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationParameters(@NotNull HelloParser.DeclarationParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#declarationParameters}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationParameters(@NotNull HelloParser.DeclarationParametersContext ctx);

	/**
	 * Enter a parse tree produced by {@link HelloParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(@NotNull HelloParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(@NotNull HelloParser.BooleanLiteralContext ctx);

	/**
	 * Enter a parse tree produced by {@link HelloParser#loopWhileOrUntil}.
	 * @param ctx the parse tree
	 */
	void enterLoopWhileOrUntil(@NotNull HelloParser.LoopWhileOrUntilContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#loopWhileOrUntil}.
	 * @param ctx the parse tree
	 */
	void exitLoopWhileOrUntil(@NotNull HelloParser.LoopWhileOrUntilContext ctx);

	/**
	 * Enter a parse tree produced by {@link HelloParser#logicalOperator}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOperator(@NotNull HelloParser.LogicalOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#logicalOperator}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOperator(@NotNull HelloParser.LogicalOperatorContext ctx);

	/**
	 * Enter a parse tree produced by {@link HelloParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(@NotNull HelloParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(@NotNull HelloParser.PrimitiveTypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link HelloParser#elseIfStmt}.
	 * @param ctx the parse tree
	 */
	void enterElseIfStmt(@NotNull HelloParser.ElseIfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#elseIfStmt}.
	 * @param ctx the parse tree
	 */
	void exitElseIfStmt(@NotNull HelloParser.ElseIfStmtContext ctx);

	/**
	 * Enter a parse tree produced by {@link HelloParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull HelloParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull HelloParser.ProgramContext ctx);

	/**
	 * Enter a parse tree produced by {@link HelloParser#identifierOrListIndex}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierOrListIndex(@NotNull HelloParser.IdentifierOrListIndexContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#identifierOrListIndex}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierOrListIndex(@NotNull HelloParser.IdentifierOrListIndexContext ctx);

	/**
	 * Enter a parse tree produced by {@link HelloParser#returnFunction}.
	 * @param ctx the parse tree
	 */
	void enterReturnFunction(@NotNull HelloParser.ReturnFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#returnFunction}.
	 * @param ctx the parse tree
	 */
	void exitReturnFunction(@NotNull HelloParser.ReturnFunctionContext ctx);

	/**
	 * Enter a parse tree produced by {@link HelloParser#nothing}.
	 * @param ctx the parse tree
	 */
	void enterNothing(@NotNull HelloParser.NothingContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#nothing}.
	 * @param ctx the parse tree
	 */
	void exitNothing(@NotNull HelloParser.NothingContext ctx);

	/**
	 * Enter a parse tree produced by {@link HelloParser#funcParameters}.
	 * @param ctx the parse tree
	 */
	void enterFuncParameters(@NotNull HelloParser.FuncParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#funcParameters}.
	 * @param ctx the parse tree
	 */
	void exitFuncParameters(@NotNull HelloParser.FuncParametersContext ctx);

	/**
	 * Enter a parse tree produced by {@link HelloParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void enterFuncCall(@NotNull HelloParser.FuncCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void exitFuncCall(@NotNull HelloParser.FuncCallContext ctx);

	/**
	 * Enter a parse tree produced by {@link HelloParser#declarationParameterList}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationParameterList(@NotNull HelloParser.DeclarationParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#declarationParameterList}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationParameterList(@NotNull HelloParser.DeclarationParameterListContext ctx);

	/**
	 * Enter a parse tree produced by {@link HelloParser#variableMethodCall}.
	 * @param ctx the parse tree
	 */
	void enterVariableMethodCall(@NotNull HelloParser.VariableMethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#variableMethodCall}.
	 * @param ctx the parse tree
	 */
	void exitVariableMethodCall(@NotNull HelloParser.VariableMethodCallContext ctx);

	/**
	 * Enter a parse tree produced by {@link HelloParser#collectionInit}.
	 * @param ctx the parse tree
	 */
	void enterCollectionInit(@NotNull HelloParser.CollectionInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#collectionInit}.
	 * @param ctx the parse tree
	 */
	void exitCollectionInit(@NotNull HelloParser.CollectionInitContext ctx);

	/**
	 * Enter a parse tree produced by {@link HelloParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(@NotNull HelloParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(@NotNull HelloParser.LiteralContext ctx);
}