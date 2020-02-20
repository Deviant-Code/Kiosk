// Generated from com/sun/scenario/effect/compiler/JSL.g4 by ANTLR 4.7.2
package com.sun.scenario.effect.compiler;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JSLParser}.
 */
public interface JSLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JSLParser#field_selection}.
	 * @param ctx the parse tree
	 */
	void enterField_selection(JSLParser.Field_selectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#field_selection}.
	 * @param ctx the parse tree
	 */
	void exitField_selection(JSLParser.Field_selectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#primary_expression}.
	 * @param ctx the parse tree
	 */
	void enterPrimary_expression(JSLParser.Primary_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#primary_expression}.
	 * @param ctx the parse tree
	 */
	void exitPrimary_expression(JSLParser.Primary_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#primary_or_call}.
	 * @param ctx the parse tree
	 */
	void enterPrimary_or_call(JSLParser.Primary_or_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#primary_or_call}.
	 * @param ctx the parse tree
	 */
	void exitPrimary_or_call(JSLParser.Primary_or_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#postfix_expression}.
	 * @param ctx the parse tree
	 */
	void enterPostfix_expression(JSLParser.Postfix_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#postfix_expression}.
	 * @param ctx the parse tree
	 */
	void exitPostfix_expression(JSLParser.Postfix_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterFunction_call(JSLParser.Function_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitFunction_call(JSLParser.Function_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#function_call_parameter_list}.
	 * @param ctx the parse tree
	 */
	void enterFunction_call_parameter_list(JSLParser.Function_call_parameter_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#function_call_parameter_list}.
	 * @param ctx the parse tree
	 */
	void exitFunction_call_parameter_list(JSLParser.Function_call_parameter_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void enterUnary_expression(JSLParser.Unary_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void exitUnary_expression(JSLParser.Unary_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#multiplicative_operator}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicative_operator(JSLParser.Multiplicative_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#multiplicative_operator}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicative_operator(JSLParser.Multiplicative_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#multiplicative_expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicative_expression(JSLParser.Multiplicative_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#multiplicative_expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicative_expression(JSLParser.Multiplicative_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#additive_operator}.
	 * @param ctx the parse tree
	 */
	void enterAdditive_operator(JSLParser.Additive_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#additive_operator}.
	 * @param ctx the parse tree
	 */
	void exitAdditive_operator(JSLParser.Additive_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#additive_expression}.
	 * @param ctx the parse tree
	 */
	void enterAdditive_expression(JSLParser.Additive_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#additive_expression}.
	 * @param ctx the parse tree
	 */
	void exitAdditive_expression(JSLParser.Additive_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#relational_operator}.
	 * @param ctx the parse tree
	 */
	void enterRelational_operator(JSLParser.Relational_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#relational_operator}.
	 * @param ctx the parse tree
	 */
	void exitRelational_operator(JSLParser.Relational_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#relational_expression}.
	 * @param ctx the parse tree
	 */
	void enterRelational_expression(JSLParser.Relational_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#relational_expression}.
	 * @param ctx the parse tree
	 */
	void exitRelational_expression(JSLParser.Relational_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#equality_operator}.
	 * @param ctx the parse tree
	 */
	void enterEquality_operator(JSLParser.Equality_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#equality_operator}.
	 * @param ctx the parse tree
	 */
	void exitEquality_operator(JSLParser.Equality_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#equality_expression}.
	 * @param ctx the parse tree
	 */
	void enterEquality_expression(JSLParser.Equality_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#equality_expression}.
	 * @param ctx the parse tree
	 */
	void exitEquality_expression(JSLParser.Equality_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#logical_and_expression}.
	 * @param ctx the parse tree
	 */
	void enterLogical_and_expression(JSLParser.Logical_and_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#logical_and_expression}.
	 * @param ctx the parse tree
	 */
	void exitLogical_and_expression(JSLParser.Logical_and_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#logical_xor_expression}.
	 * @param ctx the parse tree
	 */
	void enterLogical_xor_expression(JSLParser.Logical_xor_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#logical_xor_expression}.
	 * @param ctx the parse tree
	 */
	void exitLogical_xor_expression(JSLParser.Logical_xor_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#logical_or_expression}.
	 * @param ctx the parse tree
	 */
	void enterLogical_or_expression(JSLParser.Logical_or_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#logical_or_expression}.
	 * @param ctx the parse tree
	 */
	void exitLogical_or_expression(JSLParser.Logical_or_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#ternary_part}.
	 * @param ctx the parse tree
	 */
	void enterTernary_part(JSLParser.Ternary_partContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#ternary_part}.
	 * @param ctx the parse tree
	 */
	void exitTernary_part(JSLParser.Ternary_partContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#conditional_expression}.
	 * @param ctx the parse tree
	 */
	void enterConditional_expression(JSLParser.Conditional_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#conditional_expression}.
	 * @param ctx the parse tree
	 */
	void exitConditional_expression(JSLParser.Conditional_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#assignment_expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignment_expression(JSLParser.Assignment_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#assignment_expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignment_expression(JSLParser.Assignment_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#assignment_operator}.
	 * @param ctx the parse tree
	 */
	void enterAssignment_operator(JSLParser.Assignment_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#assignment_operator}.
	 * @param ctx the parse tree
	 */
	void exitAssignment_operator(JSLParser.Assignment_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(JSLParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(JSLParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#function_prototype}.
	 * @param ctx the parse tree
	 */
	void enterFunction_prototype(JSLParser.Function_prototypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#function_prototype}.
	 * @param ctx the parse tree
	 */
	void exitFunction_prototype(JSLParser.Function_prototypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#parameter_declaration}.
	 * @param ctx the parse tree
	 */
	void enterParameter_declaration(JSLParser.Parameter_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#parameter_declaration}.
	 * @param ctx the parse tree
	 */
	void exitParameter_declaration(JSLParser.Parameter_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#parameter_declaration_list}.
	 * @param ctx the parse tree
	 */
	void enterParameter_declaration_list(JSLParser.Parameter_declaration_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#parameter_declaration_list}.
	 * @param ctx the parse tree
	 */
	void exitParameter_declaration_list(JSLParser.Parameter_declaration_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#declaration_identifier_and_init}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration_identifier_and_init(JSLParser.Declaration_identifier_and_initContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#declaration_identifier_and_init}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration_identifier_and_init(JSLParser.Declaration_identifier_and_initContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#single_declaration}.
	 * @param ctx the parse tree
	 */
	void enterSingle_declaration(JSLParser.Single_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#single_declaration}.
	 * @param ctx the parse tree
	 */
	void exitSingle_declaration(JSLParser.Single_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(JSLParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(JSLParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#fully_specified_type}.
	 * @param ctx the parse tree
	 */
	void enterFully_specified_type(JSLParser.Fully_specified_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#fully_specified_type}.
	 * @param ctx the parse tree
	 */
	void exitFully_specified_type(JSLParser.Fully_specified_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#type_qualifier}.
	 * @param ctx the parse tree
	 */
	void enterType_qualifier(JSLParser.Type_qualifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#type_qualifier}.
	 * @param ctx the parse tree
	 */
	void exitType_qualifier(JSLParser.Type_qualifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#type_precision}.
	 * @param ctx the parse tree
	 */
	void enterType_precision(JSLParser.Type_precisionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#type_precision}.
	 * @param ctx the parse tree
	 */
	void exitType_precision(JSLParser.Type_precisionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#type_specifier}.
	 * @param ctx the parse tree
	 */
	void enterType_specifier(JSLParser.Type_specifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#type_specifier}.
	 * @param ctx the parse tree
	 */
	void exitType_specifier(JSLParser.Type_specifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#array_brackets}.
	 * @param ctx the parse tree
	 */
	void enterArray_brackets(JSLParser.Array_bracketsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#array_brackets}.
	 * @param ctx the parse tree
	 */
	void exitArray_brackets(JSLParser.Array_bracketsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#type_specifier_nonarray}.
	 * @param ctx the parse tree
	 */
	void enterType_specifier_nonarray(JSLParser.Type_specifier_nonarrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#type_specifier_nonarray}.
	 * @param ctx the parse tree
	 */
	void exitType_specifier_nonarray(JSLParser.Type_specifier_nonarrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#initializer}.
	 * @param ctx the parse tree
	 */
	void enterInitializer(JSLParser.InitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#initializer}.
	 * @param ctx the parse tree
	 */
	void exitInitializer(JSLParser.InitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#declaration_statement}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration_statement(JSLParser.Declaration_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#declaration_statement}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration_statement(JSLParser.Declaration_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(JSLParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(JSLParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#simple_statement}.
	 * @param ctx the parse tree
	 */
	void enterSimple_statement(JSLParser.Simple_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#simple_statement}.
	 * @param ctx the parse tree
	 */
	void exitSimple_statement(JSLParser.Simple_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#compound_statement}.
	 * @param ctx the parse tree
	 */
	void enterCompound_statement(JSLParser.Compound_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#compound_statement}.
	 * @param ctx the parse tree
	 */
	void exitCompound_statement(JSLParser.Compound_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#statement_no_new_scope}.
	 * @param ctx the parse tree
	 */
	void enterStatement_no_new_scope(JSLParser.Statement_no_new_scopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#statement_no_new_scope}.
	 * @param ctx the parse tree
	 */
	void exitStatement_no_new_scope(JSLParser.Statement_no_new_scopeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#compound_statement_no_new_scope}.
	 * @param ctx the parse tree
	 */
	void enterCompound_statement_no_new_scope(JSLParser.Compound_statement_no_new_scopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#compound_statement_no_new_scope}.
	 * @param ctx the parse tree
	 */
	void exitCompound_statement_no_new_scope(JSLParser.Compound_statement_no_new_scopeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#expression_statement}.
	 * @param ctx the parse tree
	 */
	void enterExpression_statement(JSLParser.Expression_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#expression_statement}.
	 * @param ctx the parse tree
	 */
	void exitExpression_statement(JSLParser.Expression_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#constant_expression}.
	 * @param ctx the parse tree
	 */
	void enterConstant_expression(JSLParser.Constant_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#constant_expression}.
	 * @param ctx the parse tree
	 */
	void exitConstant_expression(JSLParser.Constant_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#selection_statement}.
	 * @param ctx the parse tree
	 */
	void enterSelection_statement(JSLParser.Selection_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#selection_statement}.
	 * @param ctx the parse tree
	 */
	void exitSelection_statement(JSLParser.Selection_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(JSLParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(JSLParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#iteration_statement}.
	 * @param ctx the parse tree
	 */
	void enterIteration_statement(JSLParser.Iteration_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#iteration_statement}.
	 * @param ctx the parse tree
	 */
	void exitIteration_statement(JSLParser.Iteration_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#unroll_modifier}.
	 * @param ctx the parse tree
	 */
	void enterUnroll_modifier(JSLParser.Unroll_modifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#unroll_modifier}.
	 * @param ctx the parse tree
	 */
	void exitUnroll_modifier(JSLParser.Unroll_modifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#for_init_statement}.
	 * @param ctx the parse tree
	 */
	void enterFor_init_statement(JSLParser.For_init_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#for_init_statement}.
	 * @param ctx the parse tree
	 */
	void exitFor_init_statement(JSLParser.For_init_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#for_rest_statement}.
	 * @param ctx the parse tree
	 */
	void enterFor_rest_statement(JSLParser.For_rest_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#for_rest_statement}.
	 * @param ctx the parse tree
	 */
	void exitFor_rest_statement(JSLParser.For_rest_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#jump_statement}.
	 * @param ctx the parse tree
	 */
	void enterJump_statement(JSLParser.Jump_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#jump_statement}.
	 * @param ctx the parse tree
	 */
	void exitJump_statement(JSLParser.Jump_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#translation_unit}.
	 * @param ctx the parse tree
	 */
	void enterTranslation_unit(JSLParser.Translation_unitContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#translation_unit}.
	 * @param ctx the parse tree
	 */
	void exitTranslation_unit(JSLParser.Translation_unitContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#external_declaration}.
	 * @param ctx the parse tree
	 */
	void enterExternal_declaration(JSLParser.External_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#external_declaration}.
	 * @param ctx the parse tree
	 */
	void exitExternal_declaration(JSLParser.External_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#function_definition}.
	 * @param ctx the parse tree
	 */
	void enterFunction_definition(JSLParser.Function_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#function_definition}.
	 * @param ctx the parse tree
	 */
	void exitFunction_definition(JSLParser.Function_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSLParser#glue_block}.
	 * @param ctx the parse tree
	 */
	void enterGlue_block(JSLParser.Glue_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSLParser#glue_block}.
	 * @param ctx the parse tree
	 */
	void exitGlue_block(JSLParser.Glue_blockContext ctx);
}