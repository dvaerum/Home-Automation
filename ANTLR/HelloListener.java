// Generated from Hello.g4 by ANTLR 4.2
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HelloParser}.
 */
public interface HelloListener extends ParseTreeListener {
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
	 * Enter a parse tree produced by {@link HelloParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(@NotNull HelloParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(@NotNull HelloParser.AssignmentContext ctx);

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
	 * Enter a parse tree produced by {@link HelloParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void enterFunctionBody(@NotNull HelloParser.FunctionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void exitFunctionBody(@NotNull HelloParser.FunctionBodyContext ctx);

	/**
	 * Enter a parse tree produced by {@link HelloParser#typeDeclarations}.
	 * @param ctx the parse tree
	 */
	void enterTypeDeclarations(@NotNull HelloParser.TypeDeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#typeDeclarations}.
	 * @param ctx the parse tree
	 */
	void exitTypeDeclarations(@NotNull HelloParser.TypeDeclarationsContext ctx);

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