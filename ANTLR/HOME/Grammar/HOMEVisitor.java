// Generated from ./HOME.g4 by ANTLR 4.2

package HOME.Grammar;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link HOMEParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface HOMEVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link HOMEParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull HOMEParser.ExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link HOMEParser#collectionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollectionType(@NotNull HOMEParser.CollectionTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link HOMEParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(@NotNull HOMEParser.AssignContext ctx);

	/**
	 * Visit a parse tree produced by {@link HOMEParser#int2dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt2dec(@NotNull HOMEParser.Int2decContext ctx);

	/**
	 * Visit a parse tree produced by {@link HOMEParser#dictionaryLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictionaryLiteral(@NotNull HOMEParser.DictionaryLiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link HOMEParser#stmts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmts(@NotNull HOMEParser.StmtsContext ctx);

	/**
	 * Visit a parse tree produced by {@link HOMEParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull HOMEParser.BlockContext ctx);

	/**
	 * Visit a parse tree produced by {@link HOMEParser#listIndex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListIndex(@NotNull HOMEParser.ListIndexContext ctx);

	/**
	 * Visit a parse tree produced by {@link HOMEParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull HOMEParser.TypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link HOMEParser#loopForeach}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopForeach(@NotNull HOMEParser.LoopForeachContext ctx);

	/**
	 * Visit a parse tree produced by {@link HOMEParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(@NotNull HOMEParser.FunctionContext ctx);

	/**
	 * Visit a parse tree produced by {@link HOMEParser#elseStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStmt(@NotNull HOMEParser.ElseStmtContext ctx);

	/**
	 * Visit a parse tree produced by {@link HOMEParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop(@NotNull HOMEParser.LoopContext ctx);

	/**
	 * Visit a parse tree produced by {@link HOMEParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(@NotNull HOMEParser.IfStmtContext ctx);

	/**
	 * Visit a parse tree produced by {@link HOMEParser#classes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClasses(@NotNull HOMEParser.ClassesContext ctx);

	/**
	 * Visit a parse tree produced by {@link HOMEParser#dictionaryEntry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictionaryEntry(@NotNull HOMEParser.DictionaryEntryContext ctx);

	/**
	 * Visit a parse tree produced by {@link HOMEParser#listLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListLiteral(@NotNull HOMEParser.ListLiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link HOMEParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(@NotNull HOMEParser.DeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link HOMEParser#or}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(@NotNull HOMEParser.OrContext ctx);

	/**
	 * Visit a parse tree produced by {@link HOMEParser#global}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobal(@NotNull HOMEParser.GlobalContext ctx);

	/**
	 * Visit a parse tree produced by {@link HOMEParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(@NotNull HOMEParser.StmtContext ctx);

	/**
	 * Visit a parse tree produced by {@link HOMEParser#declarationParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationParameters(@NotNull HOMEParser.DeclarationParametersContext ctx);

	/**
	 * Visit a parse tree produced by {@link HOMEParser#booleanLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(@NotNull HOMEParser.BooleanLiteralContext ctx);

	/**
	 * Visit a parse tree produced by {@link HOMEParser#loopWhileOrUntil}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopWhileOrUntil(@NotNull HOMEParser.LoopWhileOrUntilContext ctx);

	/**
	 * Visit a parse tree produced by {@link HOMEParser#and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(@NotNull HOMEParser.AndContext ctx);

	/**
	 * Visit a parse tree produced by {@link HOMEParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(@NotNull HOMEParser.FieldContext ctx);

	/**
	 * Visit a parse tree produced by {@link HOMEParser#newline}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewline(@NotNull HOMEParser.NewlineContext ctx);

	/**
	 * Visit a parse tree produced by {@link HOMEParser#elseIfStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIfStmt(@NotNull HOMEParser.ElseIfStmtContext ctx);

	/**
	 * Visit a parse tree produced by {@link HOMEParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull HOMEParser.ProgramContext ctx);

	/**
	 * Visit a parse tree produced by {@link HOMEParser#returnFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnFunction(@NotNull HOMEParser.ReturnFunctionContext ctx);

	/**
	 * Visit a parse tree produced by {@link HOMEParser#nothing}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNothing(@NotNull HOMEParser.NothingContext ctx);

	/**
	 * Visit a parse tree produced by {@link HOMEParser#funcParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncParameters(@NotNull HOMEParser.FuncParametersContext ctx);

	/**
	 * Visit a parse tree produced by {@link HOMEParser#incDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncDec(@NotNull HOMEParser.IncDecContext ctx);

	/**
	 * Visit a parse tree produced by {@link HOMEParser#funcCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCall(@NotNull HOMEParser.FuncCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link HOMEParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(@NotNull HOMEParser.IdentifierContext ctx);

	/**
	 * Visit a parse tree produced by {@link HOMEParser#moreFunctions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoreFunctions(@NotNull HOMEParser.MoreFunctionsContext ctx);

	/**
	 * Visit a parse tree produced by {@link HOMEParser#variableMethodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableMethodCall(@NotNull HOMEParser.VariableMethodCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link HOMEParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(@NotNull HOMEParser.LiteralContext ctx);
}