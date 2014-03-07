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
	 * Enter a parse tree produced by {@link HelloParser#programtest}.
	 * @param ctx the parse tree
	 */
	void enterProgramtest(@NotNull HelloParser.ProgramtestContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#programtest}.
	 * @param ctx the parse tree
	 */
	void exitProgramtest(@NotNull HelloParser.ProgramtestContext ctx);

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
	 * Enter a parse tree produced by {@link HelloParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(@NotNull HelloParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(@NotNull HelloParser.ParameterListContext ctx);

	/**
	 * Enter a parse tree produced by {@link HelloParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(@NotNull HelloParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(@NotNull HelloParser.ParametersContext ctx);

	/**
	 * Enter a parse tree produced by {@link HelloParser#teststmts}.
	 * @param ctx the parse tree
	 */
	void enterTeststmts(@NotNull HelloParser.TeststmtsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#teststmts}.
	 * @param ctx the parse tree
	 */
	void exitTeststmts(@NotNull HelloParser.TeststmtsContext ctx);

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