// Generated from Hello.g4 by ANTLR 4.2
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link HelloParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface HelloVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link HelloParser#port}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPort(@NotNull HelloParser.PortContext ctx);

	/**
	 * Visit a parse tree produced by {@link HelloParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull HelloParser.ExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link HelloParser#collectionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollectionType(@NotNull HelloParser.CollectionTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link HelloParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(@NotNull HelloParser.AssignContext ctx);

	/**
	 * Visit a parse tree produced by {@link HelloParser#stmts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmts(@NotNull HelloParser.StmtsContext ctx);

	/**
	 * Visit a parse tree produced by {@link HelloParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull HelloParser.BlockContext ctx);

	/**
	 * Visit a parse tree produced by {@link HelloParser#constructClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructClass(@NotNull HelloParser.ConstructClassContext ctx);

	/**
	 * Visit a parse tree produced by {@link HelloParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull HelloParser.TypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link HelloParser#loopForeach}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopForeach(@NotNull HelloParser.LoopForeachContext ctx);

	/**
	 * Visit a parse tree produced by {@link HelloParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(@NotNull HelloParser.FunctionContext ctx);

	/**
	 * Visit a parse tree produced by {@link HelloParser#elseStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStmt(@NotNull HelloParser.ElseStmtContext ctx);

	/**
	 * Visit a parse tree produced by {@link HelloParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop(@NotNull HelloParser.LoopContext ctx);

	/**
	 * Visit a parse tree produced by {@link HelloParser#constructClassPort}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructClassPort(@NotNull HelloParser.ConstructClassPortContext ctx);

	/**
	 * Visit a parse tree produced by {@link HelloParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(@NotNull HelloParser.IfStmtContext ctx);

	/**
	 * Visit a parse tree produced by {@link HelloParser#classes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClasses(@NotNull HelloParser.ClassesContext ctx);

	/**
	 * Visit a parse tree produced by {@link HelloParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(@NotNull HelloParser.DeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link HelloParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(@NotNull HelloParser.ConditionContext ctx);

	/**
	 * Visit a parse tree produced by {@link HelloParser#global}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobal(@NotNull HelloParser.GlobalContext ctx);

	/**
	 * Visit a parse tree produced by {@link HelloParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(@NotNull HelloParser.StmtContext ctx);

	/**
	 * Visit a parse tree produced by {@link HelloParser#declarationParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationParameters(@NotNull HelloParser.DeclarationParametersContext ctx);

	/**
	 * Visit a parse tree produced by {@link HelloParser#booleanLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(@NotNull HelloParser.BooleanLiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link HelloParser#loopWhileOrUntil}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopWhileOrUntil(@NotNull HelloParser.LoopWhileOrUntilContext ctx);

	/**
	 * Visit a parse tree produced by {@link HelloParser#logicalOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOperator(@NotNull HelloParser.LogicalOperatorContext ctx);

	/**
	 * Visit a parse tree produced by {@link HelloParser#newline}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewline(@NotNull HelloParser.NewlineContext ctx);

	/**
	 * Visit a parse tree produced by {@link HelloParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(@NotNull HelloParser.PrimitiveTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link HelloParser#identifierOrListIndex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierOrListIndex(@NotNull HelloParser.IdentifierOrListIndexContext ctx);

	/**
	 * Visit a parse tree produced by {@link HelloParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull HelloParser.ProgramContext ctx);

	/**
	 * Visit a parse tree produced by {@link HelloParser#elseIfStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIfStmt(@NotNull HelloParser.ElseIfStmtContext ctx);

	/**
	 * Visit a parse tree produced by {@link HelloParser#returnFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnFunction(@NotNull HelloParser.ReturnFunctionContext ctx);

	/**
	 * Visit a parse tree produced by {@link HelloParser#nothing}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNothing(@NotNull HelloParser.NothingContext ctx);

	/**
	 * Visit a parse tree produced by {@link HelloParser#funcParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncParameters(@NotNull HelloParser.FuncParametersContext ctx);

	/**
	 * Visit a parse tree produced by {@link HelloParser#incDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncDec(@NotNull HelloParser.IncDecContext ctx);

	/**
	 * Visit a parse tree produced by {@link HelloParser#funcCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCall(@NotNull HelloParser.FuncCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link HelloParser#declarationParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationParameterList(@NotNull HelloParser.DeclarationParameterListContext ctx);

	/**
	 * Visit a parse tree produced by {@link HelloParser#moreFunctions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoreFunctions(@NotNull HelloParser.MoreFunctionsContext ctx);

	/**
	 * Visit a parse tree produced by {@link HelloParser#variableMethodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableMethodCall(@NotNull HelloParser.VariableMethodCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link HelloParser#collectionInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollectionInit(@NotNull HelloParser.CollectionInitContext ctx);

	/**
	 * Visit a parse tree produced by {@link HelloParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(@NotNull HelloParser.LiteralContext ctx);
}