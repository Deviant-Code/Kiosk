// Generated from com/sun/scenario/effect/compiler/JSL.g4 by ANTLR 4.7.2
package com.sun.scenario.effect.compiler;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JSLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JSLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JSLParser#field_selection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField_selection(JSLParser.Field_selectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#primary_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary_expression(JSLParser.Primary_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#primary_or_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary_or_call(JSLParser.Primary_or_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#postfix_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfix_expression(JSLParser.Postfix_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_call(JSLParser.Function_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#function_call_parameter_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_call_parameter_list(JSLParser.Function_call_parameter_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#unary_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_expression(JSLParser.Unary_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#multiplicative_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicative_operator(JSLParser.Multiplicative_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#multiplicative_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicative_expression(JSLParser.Multiplicative_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#additive_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditive_operator(JSLParser.Additive_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#additive_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditive_expression(JSLParser.Additive_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#relational_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelational_operator(JSLParser.Relational_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#relational_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelational_expression(JSLParser.Relational_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#equality_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality_operator(JSLParser.Equality_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#equality_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality_expression(JSLParser.Equality_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#logical_and_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical_and_expression(JSLParser.Logical_and_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#logical_xor_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical_xor_expression(JSLParser.Logical_xor_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#logical_or_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical_or_expression(JSLParser.Logical_or_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#ternary_part}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernary_part(JSLParser.Ternary_partContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#conditional_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditional_expression(JSLParser.Conditional_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#assignment_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment_expression(JSLParser.Assignment_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#assignment_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment_operator(JSLParser.Assignment_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(JSLParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#function_prototype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_prototype(JSLParser.Function_prototypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#parameter_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_declaration(JSLParser.Parameter_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#parameter_declaration_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_declaration_list(JSLParser.Parameter_declaration_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#declaration_identifier_and_init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration_identifier_and_init(JSLParser.Declaration_identifier_and_initContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#single_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingle_declaration(JSLParser.Single_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(JSLParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#fully_specified_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFully_specified_type(JSLParser.Fully_specified_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#type_qualifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_qualifier(JSLParser.Type_qualifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#type_precision}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_precision(JSLParser.Type_precisionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#type_specifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_specifier(JSLParser.Type_specifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#array_brackets}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_brackets(JSLParser.Array_bracketsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#type_specifier_nonarray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_specifier_nonarray(JSLParser.Type_specifier_nonarrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#initializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializer(JSLParser.InitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#declaration_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration_statement(JSLParser.Declaration_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(JSLParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#simple_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_statement(JSLParser.Simple_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#compound_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompound_statement(JSLParser.Compound_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#statement_no_new_scope}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement_no_new_scope(JSLParser.Statement_no_new_scopeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#compound_statement_no_new_scope}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompound_statement_no_new_scope(JSLParser.Compound_statement_no_new_scopeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#expression_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_statement(JSLParser.Expression_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#constant_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant_expression(JSLParser.Constant_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#selection_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelection_statement(JSLParser.Selection_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(JSLParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#iteration_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIteration_statement(JSLParser.Iteration_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#unroll_modifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnroll_modifier(JSLParser.Unroll_modifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#for_init_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_init_statement(JSLParser.For_init_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#for_rest_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_rest_statement(JSLParser.For_rest_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#jump_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJump_statement(JSLParser.Jump_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#translation_unit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTranslation_unit(JSLParser.Translation_unitContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#external_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExternal_declaration(JSLParser.External_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#function_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_definition(JSLParser.Function_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSLParser#glue_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlue_block(JSLParser.Glue_blockContext ctx);
}