// Generated from com/sun/scenario/effect/compiler/JSL.g4 by ANTLR 4.7.2
package com.sun.scenario.effect.compiler;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JSLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, STAR=6, SLASH=7, PLUS=8, DASH=9, 
		LT=10, GT=11, LTEQ=12, GTEQ=13, EQEQ=14, NEQ=15, AND=16, XOR=17, OR=18, 
		INC=19, DEC=20, STAREQ=21, SLASHEQ=22, PLUSEQ=23, DASHEQ=24, LEFT_PAREN=25, 
		RIGHT_PAREN=26, LEFT_BRACKET=27, RIGHT_BRACKET=28, LEFT_BRACE=29, RIGHT_BRACE=30, 
		LEFT_FRENCH=31, RIGHT_FRENCH=32, DOT=33, COMMA=34, EQUAL=35, BANG=36, 
		TILDE=37, QUESTION=38, COLON=39, SEMICOLON=40, IF=41, ELSE=42, WHILE=43, 
		DO=44, FOR=45, UNROLL=46, CONTINUE=47, BREAK=48, DISCARD=49, RETURN=50, 
		VOID=51, TYPE=52, BOOLCONSTANT=53, RGBA_FIELDS=54, XYZW_FIELDS=55, IDENTIFIER=56, 
		INTCONSTANT=57, FLOATCONSTANT=58, WS=59, COMMENT=60, LINE_COMMENT=61, 
		GLUE_BLOCK=62;
	public static final int
		RULE_field_selection = 0, RULE_primary_expression = 1, RULE_primary_or_call = 2, 
		RULE_postfix_expression = 3, RULE_function_call = 4, RULE_function_call_parameter_list = 5, 
		RULE_unary_expression = 6, RULE_multiplicative_operator = 7, RULE_multiplicative_expression = 8, 
		RULE_additive_operator = 9, RULE_additive_expression = 10, RULE_relational_operator = 11, 
		RULE_relational_expression = 12, RULE_equality_operator = 13, RULE_equality_expression = 14, 
		RULE_logical_and_expression = 15, RULE_logical_xor_expression = 16, RULE_logical_or_expression = 17, 
		RULE_ternary_part = 18, RULE_conditional_expression = 19, RULE_assignment_expression = 20, 
		RULE_assignment_operator = 21, RULE_expression = 22, RULE_function_prototype = 23, 
		RULE_parameter_declaration = 24, RULE_parameter_declaration_list = 25, 
		RULE_declaration_identifier_and_init = 26, RULE_single_declaration = 27, 
		RULE_declaration = 28, RULE_fully_specified_type = 29, RULE_type_qualifier = 30, 
		RULE_type_precision = 31, RULE_type_specifier = 32, RULE_array_brackets = 33, 
		RULE_type_specifier_nonarray = 34, RULE_initializer = 35, RULE_declaration_statement = 36, 
		RULE_statement = 37, RULE_simple_statement = 38, RULE_compound_statement = 39, 
		RULE_statement_no_new_scope = 40, RULE_compound_statement_no_new_scope = 41, 
		RULE_expression_statement = 42, RULE_constant_expression = 43, RULE_selection_statement = 44, 
		RULE_condition = 45, RULE_iteration_statement = 46, RULE_unroll_modifier = 47, 
		RULE_for_init_statement = 48, RULE_for_rest_statement = 49, RULE_jump_statement = 50, 
		RULE_translation_unit = 51, RULE_external_declaration = 52, RULE_function_definition = 53, 
		RULE_glue_block = 54;
	private static String[] makeRuleNames() {
		return new String[] {
			"field_selection", "primary_expression", "primary_or_call", "postfix_expression", 
			"function_call", "function_call_parameter_list", "unary_expression", 
			"multiplicative_operator", "multiplicative_expression", "additive_operator", 
			"additive_expression", "relational_operator", "relational_expression", 
			"equality_operator", "equality_expression", "logical_and_expression", 
			"logical_xor_expression", "logical_or_expression", "ternary_part", "conditional_expression", 
			"assignment_expression", "assignment_operator", "expression", "function_prototype", 
			"parameter_declaration", "parameter_declaration_list", "declaration_identifier_and_init", 
			"single_declaration", "declaration", "fully_specified_type", "type_qualifier", 
			"type_precision", "type_specifier", "array_brackets", "type_specifier_nonarray", 
			"initializer", "declaration_statement", "statement", "simple_statement", 
			"compound_statement", "statement_no_new_scope", "compound_statement_no_new_scope", 
			"expression_statement", "constant_expression", "selection_statement", 
			"condition", "iteration_statement", "unroll_modifier", "for_init_statement", 
			"for_rest_statement", "jump_statement", "translation_unit", "external_declaration", 
			"function_definition", "glue_block"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'const'", "'param'", "'lowp'", "'mediump'", "'highp'", "'*'", 
			"'/'", "'+'", "'-'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'&&'", 
			"'^^'", "'||'", "'++'", "'--'", "'*='", "'/='", "'+='", "'-='", "'('", 
			"')'", "'['", "']'", "'{'", "'}'", "'<<'", "'>>'", "'.'", "','", "'='", 
			"'!'", "'~'", "'?'", "':'", "';'", "'if'", "'else'", "'while'", "'do'", 
			"'for'", "'unroll'", "'continue'", "'break'", "'discard'", "'return'", 
			"'void'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "STAR", "SLASH", "PLUS", "DASH", 
			"LT", "GT", "LTEQ", "GTEQ", "EQEQ", "NEQ", "AND", "XOR", "OR", "INC", 
			"DEC", "STAREQ", "SLASHEQ", "PLUSEQ", "DASHEQ", "LEFT_PAREN", "RIGHT_PAREN", 
			"LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_BRACE", "RIGHT_BRACE", "LEFT_FRENCH", 
			"RIGHT_FRENCH", "DOT", "COMMA", "EQUAL", "BANG", "TILDE", "QUESTION", 
			"COLON", "SEMICOLON", "IF", "ELSE", "WHILE", "DO", "FOR", "UNROLL", "CONTINUE", 
			"BREAK", "DISCARD", "RETURN", "VOID", "TYPE", "BOOLCONSTANT", "RGBA_FIELDS", 
			"XYZW_FIELDS", "IDENTIFIER", "INTCONSTANT", "FLOATCONSTANT", "WS", "COMMENT", 
			"LINE_COMMENT", "GLUE_BLOCK"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "JSL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JSLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class Field_selectionContext extends ParserRuleContext {
		public Token r;
		public Token x;
		public TerminalNode RGBA_FIELDS() { return getToken(JSLParser.RGBA_FIELDS, 0); }
		public TerminalNode XYZW_FIELDS() { return getToken(JSLParser.XYZW_FIELDS, 0); }
		public Field_selectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_selection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterField_selection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitField_selection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitField_selection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Field_selectionContext field_selection() throws RecognitionException {
		Field_selectionContext _localctx = new Field_selectionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_field_selection);
		try {
			setState(112);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RGBA_FIELDS:
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				((Field_selectionContext)_localctx).r = match(RGBA_FIELDS);
				}
				break;
			case XYZW_FIELDS:
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				((Field_selectionContext)_localctx).x = match(XYZW_FIELDS);
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

	public static class Primary_expressionContext extends ParserRuleContext {
		public ExpressionContext e;
		public TerminalNode IDENTIFIER() { return getToken(JSLParser.IDENTIFIER, 0); }
		public TerminalNode INTCONSTANT() { return getToken(JSLParser.INTCONSTANT, 0); }
		public TerminalNode FLOATCONSTANT() { return getToken(JSLParser.FLOATCONSTANT, 0); }
		public TerminalNode BOOLCONSTANT() { return getToken(JSLParser.BOOLCONSTANT, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(JSLParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(JSLParser.RIGHT_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Primary_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterPrimary_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitPrimary_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitPrimary_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Primary_expressionContext primary_expression() throws RecognitionException {
		Primary_expressionContext _localctx = new Primary_expressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_primary_expression);
		try {
			setState(122);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				match(IDENTIFIER);
				}
				break;
			case INTCONSTANT:
				enterOuterAlt(_localctx, 2);
				{
				setState(115);
				match(INTCONSTANT);
				}
				break;
			case FLOATCONSTANT:
				enterOuterAlt(_localctx, 3);
				{
				setState(116);
				match(FLOATCONSTANT);
				}
				break;
			case BOOLCONSTANT:
				enterOuterAlt(_localctx, 4);
				{
				setState(117);
				match(BOOLCONSTANT);
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 5);
				{
				setState(118);
				match(LEFT_PAREN);
				setState(119);
				((Primary_expressionContext)_localctx).e = expression();
				setState(120);
				match(RIGHT_PAREN);
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

	public static class Primary_or_callContext extends ParserRuleContext {
		public Primary_expressionContext e;
		public Function_callContext f;
		public Primary_expressionContext primary_expression() {
			return getRuleContext(Primary_expressionContext.class,0);
		}
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public Primary_or_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary_or_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterPrimary_or_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitPrimary_or_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitPrimary_or_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Primary_or_callContext primary_or_call() throws RecognitionException {
		Primary_or_callContext _localctx = new Primary_or_callContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_primary_or_call);
		try {
			setState(126);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				((Primary_or_callContext)_localctx).e = primary_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				((Primary_or_callContext)_localctx).f = function_call();
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

	public static class Postfix_expressionContext extends ParserRuleContext {
		public Primary_or_callContext e;
		public ExpressionContext ae;
		public Field_selectionContext fs;
		public TerminalNode LEFT_BRACKET() { return getToken(JSLParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(JSLParser.RIGHT_BRACKET, 0); }
		public Primary_or_callContext primary_or_call() {
			return getRuleContext(Primary_or_callContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Field_selectionContext field_selection() {
			return getRuleContext(Field_selectionContext.class,0);
		}
		public TerminalNode INC() { return getToken(JSLParser.INC, 0); }
		public TerminalNode DEC() { return getToken(JSLParser.DEC, 0); }
		public Postfix_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfix_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterPostfix_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitPostfix_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitPostfix_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Postfix_expressionContext postfix_expression() throws RecognitionException {
		Postfix_expressionContext _localctx = new Postfix_expressionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_postfix_expression);
		try {
			setState(149);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				((Postfix_expressionContext)_localctx).e = primary_or_call();
				setState(129);
				match(LEFT_BRACKET);
				setState(130);
				((Postfix_expressionContext)_localctx).ae = expression();
				setState(131);
				match(RIGHT_BRACKET);
				setState(132);
				((Postfix_expressionContext)_localctx).fs = field_selection();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(134);
				((Postfix_expressionContext)_localctx).e = primary_or_call();
				setState(135);
				match(LEFT_BRACKET);
				setState(136);
				((Postfix_expressionContext)_localctx).ae = expression();
				setState(137);
				match(RIGHT_BRACKET);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(139);
				((Postfix_expressionContext)_localctx).e = primary_or_call();
				setState(140);
				((Postfix_expressionContext)_localctx).fs = field_selection();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(142);
				((Postfix_expressionContext)_localctx).e = primary_or_call();
				setState(143);
				match(INC);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(145);
				((Postfix_expressionContext)_localctx).e = primary_or_call();
				setState(146);
				match(DEC);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(148);
				((Postfix_expressionContext)_localctx).e = primary_or_call();
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

	public static class Function_callContext extends ParserRuleContext {
		public Token id;
		public Function_call_parameter_listContext p;
		public Type_specifierContext ts;
		public TerminalNode LEFT_PAREN() { return getToken(JSLParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(JSLParser.RIGHT_PAREN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(JSLParser.IDENTIFIER, 0); }
		public Function_call_parameter_listContext function_call_parameter_list() {
			return getRuleContext(Function_call_parameter_listContext.class,0);
		}
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public Function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterFunction_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitFunction_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitFunction_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_function_call);
		int _la;
		try {
			setState(164);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(151);
				((Function_callContext)_localctx).id = match(IDENTIFIER);
				setState(152);
				match(LEFT_PAREN);
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << DASH) | (1L << INC) | (1L << DEC) | (1L << LEFT_PAREN) | (1L << BANG) | (1L << VOID) | (1L << TYPE) | (1L << BOOLCONSTANT) | (1L << IDENTIFIER) | (1L << INTCONSTANT) | (1L << FLOATCONSTANT))) != 0)) {
					{
					setState(153);
					((Function_callContext)_localctx).p = function_call_parameter_list();
					}
				}

				setState(156);
				match(RIGHT_PAREN);
				}
				break;
			case VOID:
			case TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
				((Function_callContext)_localctx).ts = type_specifier();
				setState(158);
				match(LEFT_PAREN);
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << DASH) | (1L << INC) | (1L << DEC) | (1L << LEFT_PAREN) | (1L << BANG) | (1L << VOID) | (1L << TYPE) | (1L << BOOLCONSTANT) | (1L << IDENTIFIER) | (1L << INTCONSTANT) | (1L << FLOATCONSTANT))) != 0)) {
					{
					setState(159);
					((Function_callContext)_localctx).p = function_call_parameter_list();
					}
				}

				setState(162);
				match(RIGHT_PAREN);
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

	public static class Function_call_parameter_listContext extends ParserRuleContext {
		public Assignment_expressionContext a;
		public List<Assignment_expressionContext> assignment_expression() {
			return getRuleContexts(Assignment_expressionContext.class);
		}
		public Assignment_expressionContext assignment_expression(int i) {
			return getRuleContext(Assignment_expressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JSLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JSLParser.COMMA, i);
		}
		public Function_call_parameter_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call_parameter_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterFunction_call_parameter_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitFunction_call_parameter_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitFunction_call_parameter_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_call_parameter_listContext function_call_parameter_list() throws RecognitionException {
		Function_call_parameter_listContext _localctx = new Function_call_parameter_listContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_function_call_parameter_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			((Function_call_parameter_listContext)_localctx).a = assignment_expression();
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(167);
				match(COMMA);
				setState(168);
				((Function_call_parameter_listContext)_localctx).a = assignment_expression();
				}
				}
				setState(173);
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

	public static class Unary_expressionContext extends ParserRuleContext {
		public Postfix_expressionContext p;
		public Unary_expressionContext u;
		public Postfix_expressionContext postfix_expression() {
			return getRuleContext(Postfix_expressionContext.class,0);
		}
		public TerminalNode INC() { return getToken(JSLParser.INC, 0); }
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public TerminalNode DEC() { return getToken(JSLParser.DEC, 0); }
		public TerminalNode PLUS() { return getToken(JSLParser.PLUS, 0); }
		public TerminalNode DASH() { return getToken(JSLParser.DASH, 0); }
		public TerminalNode BANG() { return getToken(JSLParser.BANG, 0); }
		public Unary_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterUnary_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitUnary_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitUnary_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unary_expressionContext unary_expression() throws RecognitionException {
		Unary_expressionContext _localctx = new Unary_expressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_unary_expression);
		try {
			setState(185);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEFT_PAREN:
			case VOID:
			case TYPE:
			case BOOLCONSTANT:
			case IDENTIFIER:
			case INTCONSTANT:
			case FLOATCONSTANT:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				((Unary_expressionContext)_localctx).p = postfix_expression();
				}
				break;
			case INC:
				enterOuterAlt(_localctx, 2);
				{
				setState(175);
				match(INC);
				setState(176);
				((Unary_expressionContext)_localctx).u = unary_expression();
				}
				break;
			case DEC:
				enterOuterAlt(_localctx, 3);
				{
				setState(177);
				match(DEC);
				setState(178);
				((Unary_expressionContext)_localctx).u = unary_expression();
				}
				break;
			case PLUS:
				enterOuterAlt(_localctx, 4);
				{
				setState(179);
				match(PLUS);
				setState(180);
				((Unary_expressionContext)_localctx).u = unary_expression();
				}
				break;
			case DASH:
				enterOuterAlt(_localctx, 5);
				{
				setState(181);
				match(DASH);
				setState(182);
				((Unary_expressionContext)_localctx).u = unary_expression();
				}
				break;
			case BANG:
				enterOuterAlt(_localctx, 6);
				{
				setState(183);
				match(BANG);
				setState(184);
				((Unary_expressionContext)_localctx).u = unary_expression();
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

	public static class Multiplicative_operatorContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(JSLParser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(JSLParser.SLASH, 0); }
		public Multiplicative_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicative_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterMultiplicative_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitMultiplicative_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitMultiplicative_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multiplicative_operatorContext multiplicative_operator() throws RecognitionException {
		Multiplicative_operatorContext _localctx = new Multiplicative_operatorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_multiplicative_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			_la = _input.LA(1);
			if ( !(_la==STAR || _la==SLASH) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Multiplicative_expressionContext extends ParserRuleContext {
		public Unary_expressionContext a;
		public Multiplicative_operatorContext c;
		public Multiplicative_expressionContext b;
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public List<Multiplicative_operatorContext> multiplicative_operator() {
			return getRuleContexts(Multiplicative_operatorContext.class);
		}
		public Multiplicative_operatorContext multiplicative_operator(int i) {
			return getRuleContext(Multiplicative_operatorContext.class,i);
		}
		public List<Multiplicative_expressionContext> multiplicative_expression() {
			return getRuleContexts(Multiplicative_expressionContext.class);
		}
		public Multiplicative_expressionContext multiplicative_expression(int i) {
			return getRuleContext(Multiplicative_expressionContext.class,i);
		}
		public Multiplicative_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicative_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterMultiplicative_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitMultiplicative_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitMultiplicative_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multiplicative_expressionContext multiplicative_expression() throws RecognitionException {
		Multiplicative_expressionContext _localctx = new Multiplicative_expressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_multiplicative_expression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			((Multiplicative_expressionContext)_localctx).a = unary_expression();
			setState(195);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(190);
					((Multiplicative_expressionContext)_localctx).c = multiplicative_operator();
					setState(191);
					((Multiplicative_expressionContext)_localctx).b = multiplicative_expression();
					}
					} 
				}
				setState(197);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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

	public static class Additive_operatorContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(JSLParser.PLUS, 0); }
		public TerminalNode DASH() { return getToken(JSLParser.DASH, 0); }
		public Additive_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additive_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterAdditive_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitAdditive_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitAdditive_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Additive_operatorContext additive_operator() throws RecognitionException {
		Additive_operatorContext _localctx = new Additive_operatorContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_additive_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==DASH) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Additive_expressionContext extends ParserRuleContext {
		public Multiplicative_expressionContext a;
		public Additive_operatorContext c;
		public Multiplicative_expressionContext b;
		public List<Multiplicative_expressionContext> multiplicative_expression() {
			return getRuleContexts(Multiplicative_expressionContext.class);
		}
		public Multiplicative_expressionContext multiplicative_expression(int i) {
			return getRuleContext(Multiplicative_expressionContext.class,i);
		}
		public List<Additive_operatorContext> additive_operator() {
			return getRuleContexts(Additive_operatorContext.class);
		}
		public Additive_operatorContext additive_operator(int i) {
			return getRuleContext(Additive_operatorContext.class,i);
		}
		public Additive_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additive_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterAdditive_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitAdditive_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitAdditive_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Additive_expressionContext additive_expression() throws RecognitionException {
		Additive_expressionContext _localctx = new Additive_expressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_additive_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			((Additive_expressionContext)_localctx).a = multiplicative_expression();
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==DASH) {
				{
				{
				setState(201);
				((Additive_expressionContext)_localctx).c = additive_operator();
				setState(202);
				((Additive_expressionContext)_localctx).b = multiplicative_expression();
				}
				}
				setState(208);
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

	public static class Relational_operatorContext extends ParserRuleContext {
		public TerminalNode LTEQ() { return getToken(JSLParser.LTEQ, 0); }
		public TerminalNode GTEQ() { return getToken(JSLParser.GTEQ, 0); }
		public TerminalNode LT() { return getToken(JSLParser.LT, 0); }
		public TerminalNode GT() { return getToken(JSLParser.GT, 0); }
		public Relational_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relational_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterRelational_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitRelational_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitRelational_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Relational_operatorContext relational_operator() throws RecognitionException {
		Relational_operatorContext _localctx = new Relational_operatorContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_relational_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT) | (1L << GT) | (1L << LTEQ) | (1L << GTEQ))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Relational_expressionContext extends ParserRuleContext {
		public Additive_expressionContext a;
		public Relational_operatorContext c;
		public Additive_expressionContext b;
		public List<Additive_expressionContext> additive_expression() {
			return getRuleContexts(Additive_expressionContext.class);
		}
		public Additive_expressionContext additive_expression(int i) {
			return getRuleContext(Additive_expressionContext.class,i);
		}
		public List<Relational_operatorContext> relational_operator() {
			return getRuleContexts(Relational_operatorContext.class);
		}
		public Relational_operatorContext relational_operator(int i) {
			return getRuleContext(Relational_operatorContext.class,i);
		}
		public Relational_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relational_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterRelational_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitRelational_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitRelational_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Relational_expressionContext relational_expression() throws RecognitionException {
		Relational_expressionContext _localctx = new Relational_expressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_relational_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			((Relational_expressionContext)_localctx).a = additive_expression();
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT) | (1L << GT) | (1L << LTEQ) | (1L << GTEQ))) != 0)) {
				{
				{
				setState(212);
				((Relational_expressionContext)_localctx).c = relational_operator();
				setState(213);
				((Relational_expressionContext)_localctx).b = additive_expression();
				}
				}
				setState(219);
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

	public static class Equality_operatorContext extends ParserRuleContext {
		public TerminalNode EQEQ() { return getToken(JSLParser.EQEQ, 0); }
		public TerminalNode NEQ() { return getToken(JSLParser.NEQ, 0); }
		public Equality_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterEquality_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitEquality_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitEquality_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Equality_operatorContext equality_operator() throws RecognitionException {
		Equality_operatorContext _localctx = new Equality_operatorContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_equality_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			_la = _input.LA(1);
			if ( !(_la==EQEQ || _la==NEQ) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Equality_expressionContext extends ParserRuleContext {
		public Relational_expressionContext a;
		public Equality_operatorContext c;
		public Relational_expressionContext b;
		public List<Relational_expressionContext> relational_expression() {
			return getRuleContexts(Relational_expressionContext.class);
		}
		public Relational_expressionContext relational_expression(int i) {
			return getRuleContext(Relational_expressionContext.class,i);
		}
		public List<Equality_operatorContext> equality_operator() {
			return getRuleContexts(Equality_operatorContext.class);
		}
		public Equality_operatorContext equality_operator(int i) {
			return getRuleContext(Equality_operatorContext.class,i);
		}
		public Equality_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterEquality_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitEquality_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitEquality_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Equality_expressionContext equality_expression() throws RecognitionException {
		Equality_expressionContext _localctx = new Equality_expressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_equality_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			((Equality_expressionContext)_localctx).a = relational_expression();
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EQEQ || _la==NEQ) {
				{
				{
				setState(223);
				((Equality_expressionContext)_localctx).c = equality_operator();
				setState(224);
				((Equality_expressionContext)_localctx).b = relational_expression();
				}
				}
				setState(230);
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

	public static class Logical_and_expressionContext extends ParserRuleContext {
		public Equality_expressionContext a;
		public Equality_expressionContext b;
		public List<Equality_expressionContext> equality_expression() {
			return getRuleContexts(Equality_expressionContext.class);
		}
		public Equality_expressionContext equality_expression(int i) {
			return getRuleContext(Equality_expressionContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(JSLParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(JSLParser.AND, i);
		}
		public Logical_and_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_and_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterLogical_and_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitLogical_and_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitLogical_and_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logical_and_expressionContext logical_and_expression() throws RecognitionException {
		Logical_and_expressionContext _localctx = new Logical_and_expressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_logical_and_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			((Logical_and_expressionContext)_localctx).a = equality_expression();
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(232);
				match(AND);
				setState(233);
				((Logical_and_expressionContext)_localctx).b = equality_expression();
				}
				}
				setState(238);
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

	public static class Logical_xor_expressionContext extends ParserRuleContext {
		public Logical_and_expressionContext a;
		public Logical_and_expressionContext b;
		public List<Logical_and_expressionContext> logical_and_expression() {
			return getRuleContexts(Logical_and_expressionContext.class);
		}
		public Logical_and_expressionContext logical_and_expression(int i) {
			return getRuleContext(Logical_and_expressionContext.class,i);
		}
		public List<TerminalNode> XOR() { return getTokens(JSLParser.XOR); }
		public TerminalNode XOR(int i) {
			return getToken(JSLParser.XOR, i);
		}
		public Logical_xor_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_xor_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterLogical_xor_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitLogical_xor_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitLogical_xor_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logical_xor_expressionContext logical_xor_expression() throws RecognitionException {
		Logical_xor_expressionContext _localctx = new Logical_xor_expressionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_logical_xor_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			((Logical_xor_expressionContext)_localctx).a = logical_and_expression();
			setState(244);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==XOR) {
				{
				{
				setState(240);
				match(XOR);
				setState(241);
				((Logical_xor_expressionContext)_localctx).b = logical_and_expression();
				}
				}
				setState(246);
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

	public static class Logical_or_expressionContext extends ParserRuleContext {
		public Logical_xor_expressionContext a;
		public Logical_xor_expressionContext b;
		public List<Logical_xor_expressionContext> logical_xor_expression() {
			return getRuleContexts(Logical_xor_expressionContext.class);
		}
		public Logical_xor_expressionContext logical_xor_expression(int i) {
			return getRuleContext(Logical_xor_expressionContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(JSLParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(JSLParser.OR, i);
		}
		public Logical_or_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_or_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterLogical_or_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitLogical_or_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitLogical_or_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logical_or_expressionContext logical_or_expression() throws RecognitionException {
		Logical_or_expressionContext _localctx = new Logical_or_expressionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_logical_or_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			((Logical_or_expressionContext)_localctx).a = logical_xor_expression();
			setState(252);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(248);
				match(OR);
				setState(249);
				((Logical_or_expressionContext)_localctx).b = logical_xor_expression();
				}
				}
				setState(254);
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

	public static class Ternary_partContext extends ParserRuleContext {
		public TerminalNode QUESTION() { return getToken(JSLParser.QUESTION, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(JSLParser.COLON, 0); }
		public Assignment_expressionContext assignment_expression() {
			return getRuleContext(Assignment_expressionContext.class,0);
		}
		public Ternary_partContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ternary_part; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterTernary_part(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitTernary_part(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitTernary_part(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ternary_partContext ternary_part() throws RecognitionException {
		Ternary_partContext _localctx = new Ternary_partContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_ternary_part);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(QUESTION);
			setState(256);
			expression();
			setState(257);
			match(COLON);
			setState(258);
			assignment_expression();
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

	public static class Conditional_expressionContext extends ParserRuleContext {
		public Logical_or_expressionContext a;
		public Logical_or_expressionContext logical_or_expression() {
			return getRuleContext(Logical_or_expressionContext.class,0);
		}
		public Ternary_partContext ternary_part() {
			return getRuleContext(Ternary_partContext.class,0);
		}
		public Conditional_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterConditional_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitConditional_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitConditional_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Conditional_expressionContext conditional_expression() throws RecognitionException {
		Conditional_expressionContext _localctx = new Conditional_expressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_conditional_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			((Conditional_expressionContext)_localctx).a = logical_or_expression();
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QUESTION) {
				{
				setState(261);
				ternary_part();
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

	public static class Assignment_expressionContext extends ParserRuleContext {
		public Unary_expressionContext a;
		public Assignment_operatorContext op;
		public Assignment_expressionContext b;
		public Conditional_expressionContext c;
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public Assignment_operatorContext assignment_operator() {
			return getRuleContext(Assignment_operatorContext.class,0);
		}
		public Assignment_expressionContext assignment_expression() {
			return getRuleContext(Assignment_expressionContext.class,0);
		}
		public Conditional_expressionContext conditional_expression() {
			return getRuleContext(Conditional_expressionContext.class,0);
		}
		public Assignment_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterAssignment_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitAssignment_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitAssignment_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assignment_expressionContext assignment_expression() throws RecognitionException {
		Assignment_expressionContext _localctx = new Assignment_expressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_assignment_expression);
		try {
			setState(269);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(264);
				((Assignment_expressionContext)_localctx).a = unary_expression();
				setState(265);
				((Assignment_expressionContext)_localctx).op = assignment_operator();
				setState(266);
				((Assignment_expressionContext)_localctx).b = assignment_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(268);
				((Assignment_expressionContext)_localctx).c = conditional_expression();
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

	public static class Assignment_operatorContext extends ParserRuleContext {
		public TerminalNode EQUAL() { return getToken(JSLParser.EQUAL, 0); }
		public TerminalNode STAREQ() { return getToken(JSLParser.STAREQ, 0); }
		public TerminalNode SLASHEQ() { return getToken(JSLParser.SLASHEQ, 0); }
		public TerminalNode PLUSEQ() { return getToken(JSLParser.PLUSEQ, 0); }
		public TerminalNode DASHEQ() { return getToken(JSLParser.DASHEQ, 0); }
		public Assignment_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterAssignment_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitAssignment_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitAssignment_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assignment_operatorContext assignment_operator() throws RecognitionException {
		Assignment_operatorContext _localctx = new Assignment_operatorContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_assignment_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STAREQ) | (1L << SLASHEQ) | (1L << PLUSEQ) | (1L << DASHEQ) | (1L << EQUAL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class ExpressionContext extends ParserRuleContext {
		public Assignment_expressionContext e;
		public Assignment_expressionContext assignment_expression() {
			return getRuleContext(Assignment_expressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			((ExpressionContext)_localctx).e = assignment_expression();
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

	public static class Function_prototypeContext extends ParserRuleContext {
		public Type_specifierContext t;
		public Token id;
		public Parameter_declaration_listContext p;
		public TerminalNode LEFT_PAREN() { return getToken(JSLParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(JSLParser.RIGHT_PAREN, 0); }
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(JSLParser.IDENTIFIER, 0); }
		public Parameter_declaration_listContext parameter_declaration_list() {
			return getRuleContext(Parameter_declaration_listContext.class,0);
		}
		public Function_prototypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_prototype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterFunction_prototype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitFunction_prototype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitFunction_prototype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_prototypeContext function_prototype() throws RecognitionException {
		Function_prototypeContext _localctx = new Function_prototypeContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_function_prototype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			((Function_prototypeContext)_localctx).t = type_specifier();
			setState(276);
			((Function_prototypeContext)_localctx).id = match(IDENTIFIER);
			setState(277);
			match(LEFT_PAREN);
			setState(279);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VOID || _la==TYPE) {
				{
				setState(278);
				((Function_prototypeContext)_localctx).p = parameter_declaration_list();
				}
			}

			setState(281);
			match(RIGHT_PAREN);
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

	public static class Parameter_declarationContext extends ParserRuleContext {
		public Type_specifierContext t;
		public Token id;
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(JSLParser.IDENTIFIER, 0); }
		public Parameter_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterParameter_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitParameter_declaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitParameter_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parameter_declarationContext parameter_declaration() throws RecognitionException {
		Parameter_declarationContext _localctx = new Parameter_declarationContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_parameter_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			((Parameter_declarationContext)_localctx).t = type_specifier();
			setState(284);
			((Parameter_declarationContext)_localctx).id = match(IDENTIFIER);
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

	public static class Parameter_declaration_listContext extends ParserRuleContext {
		public Parameter_declarationContext p;
		public List<Parameter_declarationContext> parameter_declaration() {
			return getRuleContexts(Parameter_declarationContext.class);
		}
		public Parameter_declarationContext parameter_declaration(int i) {
			return getRuleContext(Parameter_declarationContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JSLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JSLParser.COMMA, i);
		}
		public Parameter_declaration_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_declaration_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterParameter_declaration_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitParameter_declaration_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitParameter_declaration_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parameter_declaration_listContext parameter_declaration_list() throws RecognitionException {
		Parameter_declaration_listContext _localctx = new Parameter_declaration_listContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_parameter_declaration_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			((Parameter_declaration_listContext)_localctx).p = parameter_declaration();
			setState(291);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(287);
				match(COMMA);
				setState(288);
				((Parameter_declaration_listContext)_localctx).p = parameter_declaration();
				}
				}
				setState(293);
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

	public static class Declaration_identifier_and_initContext extends ParserRuleContext {
		public Token id;
		public Constant_expressionContext ae;
		public InitializerContext e;
		public TerminalNode IDENTIFIER() { return getToken(JSLParser.IDENTIFIER, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(JSLParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(JSLParser.RIGHT_BRACKET, 0); }
		public TerminalNode EQUAL() { return getToken(JSLParser.EQUAL, 0); }
		public Constant_expressionContext constant_expression() {
			return getRuleContext(Constant_expressionContext.class,0);
		}
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public Declaration_identifier_and_initContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration_identifier_and_init; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterDeclaration_identifier_and_init(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitDeclaration_identifier_and_init(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitDeclaration_identifier_and_init(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declaration_identifier_and_initContext declaration_identifier_and_init() throws RecognitionException {
		Declaration_identifier_and_initContext _localctx = new Declaration_identifier_and_initContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_declaration_identifier_and_init);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			((Declaration_identifier_and_initContext)_localctx).id = match(IDENTIFIER);
			setState(299);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LEFT_BRACKET) {
				{
				setState(295);
				match(LEFT_BRACKET);
				setState(296);
				((Declaration_identifier_and_initContext)_localctx).ae = constant_expression();
				setState(297);
				match(RIGHT_BRACKET);
				}
			}

			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(301);
				match(EQUAL);
				setState(302);
				((Declaration_identifier_and_initContext)_localctx).e = initializer();
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

	public static class Single_declarationContext extends ParserRuleContext {
		public Fully_specified_typeContext t;
		public Declaration_identifier_and_initContext d;
		public Fully_specified_typeContext fully_specified_type() {
			return getRuleContext(Fully_specified_typeContext.class,0);
		}
		public Declaration_identifier_and_initContext declaration_identifier_and_init() {
			return getRuleContext(Declaration_identifier_and_initContext.class,0);
		}
		public Single_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_single_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterSingle_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitSingle_declaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitSingle_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Single_declarationContext single_declaration() throws RecognitionException {
		Single_declarationContext _localctx = new Single_declarationContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_single_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			((Single_declarationContext)_localctx).t = fully_specified_type();
			setState(306);
			((Single_declarationContext)_localctx).d = declaration_identifier_and_init();
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
		public Single_declarationContext s;
		public Declaration_identifier_and_initContext d;
		public TerminalNode SEMICOLON() { return getToken(JSLParser.SEMICOLON, 0); }
		public Single_declarationContext single_declaration() {
			return getRuleContext(Single_declarationContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(JSLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JSLParser.COMMA, i);
		}
		public List<Declaration_identifier_and_initContext> declaration_identifier_and_init() {
			return getRuleContexts(Declaration_identifier_and_initContext.class);
		}
		public Declaration_identifier_and_initContext declaration_identifier_and_init(int i) {
			return getRuleContext(Declaration_identifier_and_initContext.class,i);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			((DeclarationContext)_localctx).s = single_declaration();
			setState(313);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(309);
				match(COMMA);
				setState(310);
				((DeclarationContext)_localctx).d = declaration_identifier_and_init();
				}
				}
				setState(315);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(316);
			match(SEMICOLON);
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

	public static class Fully_specified_typeContext extends ParserRuleContext {
		public Type_qualifierContext tq;
		public Type_precisionContext tp;
		public Type_specifierContext ts;
		public Type_qualifierContext type_qualifier() {
			return getRuleContext(Type_qualifierContext.class,0);
		}
		public Type_precisionContext type_precision() {
			return getRuleContext(Type_precisionContext.class,0);
		}
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public Fully_specified_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fully_specified_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterFully_specified_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitFully_specified_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitFully_specified_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fully_specified_typeContext fully_specified_type() throws RecognitionException {
		Fully_specified_typeContext _localctx = new Fully_specified_typeContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_fully_specified_type);
		try {
			setState(329);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(318);
				((Fully_specified_typeContext)_localctx).tq = type_qualifier();
				setState(319);
				((Fully_specified_typeContext)_localctx).tp = type_precision();
				setState(320);
				((Fully_specified_typeContext)_localctx).ts = type_specifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(322);
				((Fully_specified_typeContext)_localctx).tq = type_qualifier();
				setState(323);
				((Fully_specified_typeContext)_localctx).ts = type_specifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(325);
				((Fully_specified_typeContext)_localctx).tp = type_precision();
				setState(326);
				((Fully_specified_typeContext)_localctx).ts = type_specifier();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(328);
				((Fully_specified_typeContext)_localctx).ts = type_specifier();
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

	public static class Type_qualifierContext extends ParserRuleContext {
		public Type_qualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_qualifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterType_qualifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitType_qualifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitType_qualifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_qualifierContext type_qualifier() throws RecognitionException {
		Type_qualifierContext _localctx = new Type_qualifierContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_type_qualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			_la = _input.LA(1);
			if ( !(_la==T__0 || _la==T__1) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Type_precisionContext extends ParserRuleContext {
		public Type_precisionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_precision; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterType_precision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitType_precision(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitType_precision(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_precisionContext type_precision() throws RecognitionException {
		Type_precisionContext _localctx = new Type_precisionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_type_precision);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Type_specifierContext extends ParserRuleContext {
		public Type_specifier_nonarrayContext type_specifier_nonarray() {
			return getRuleContext(Type_specifier_nonarrayContext.class,0);
		}
		public Array_bracketsContext array_brackets() {
			return getRuleContext(Array_bracketsContext.class,0);
		}
		public Type_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_specifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterType_specifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitType_specifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitType_specifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_specifierContext type_specifier() throws RecognitionException {
		Type_specifierContext _localctx = new Type_specifierContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_type_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			type_specifier_nonarray();
			setState(337);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LEFT_BRACKET) {
				{
				setState(336);
				array_brackets();
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

	public static class Array_bracketsContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACKET() { return getToken(JSLParser.LEFT_BRACKET, 0); }
		public Constant_expressionContext constant_expression() {
			return getRuleContext(Constant_expressionContext.class,0);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(JSLParser.RIGHT_BRACKET, 0); }
		public Array_bracketsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_brackets; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterArray_brackets(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitArray_brackets(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitArray_brackets(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_bracketsContext array_brackets() throws RecognitionException {
		Array_bracketsContext _localctx = new Array_bracketsContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_array_brackets);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			match(LEFT_BRACKET);
			setState(340);
			constant_expression();
			setState(341);
			match(RIGHT_BRACKET);
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

	public static class Type_specifier_nonarrayContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(JSLParser.TYPE, 0); }
		public TerminalNode VOID() { return getToken(JSLParser.VOID, 0); }
		public Type_specifier_nonarrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_specifier_nonarray; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterType_specifier_nonarray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitType_specifier_nonarray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitType_specifier_nonarray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_specifier_nonarrayContext type_specifier_nonarray() throws RecognitionException {
		Type_specifier_nonarrayContext _localctx = new Type_specifier_nonarrayContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_type_specifier_nonarray);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			_la = _input.LA(1);
			if ( !(_la==VOID || _la==TYPE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class InitializerContext extends ParserRuleContext {
		public Assignment_expressionContext e;
		public Assignment_expressionContext assignment_expression() {
			return getRuleContext(Assignment_expressionContext.class,0);
		}
		public InitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitializerContext initializer() throws RecognitionException {
		InitializerContext _localctx = new InitializerContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_initializer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			((InitializerContext)_localctx).e = assignment_expression();
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

	public static class Declaration_statementContext extends ParserRuleContext {
		public DeclarationContext d;
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public Declaration_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterDeclaration_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitDeclaration_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitDeclaration_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declaration_statementContext declaration_statement() throws RecognitionException {
		Declaration_statementContext _localctx = new Declaration_statementContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_declaration_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			((Declaration_statementContext)_localctx).d = declaration();
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

	public static class StatementContext extends ParserRuleContext {
		public Compound_statementContext c;
		public Simple_statementContext s;
		public Compound_statementContext compound_statement() {
			return getRuleContext(Compound_statementContext.class,0);
		}
		public Simple_statementContext simple_statement() {
			return getRuleContext(Simple_statementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_statement);
		try {
			setState(351);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEFT_BRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(349);
				((StatementContext)_localctx).c = compound_statement();
				}
				break;
			case T__0:
			case T__1:
			case T__2:
			case T__3:
			case T__4:
			case PLUS:
			case DASH:
			case INC:
			case DEC:
			case LEFT_PAREN:
			case BANG:
			case SEMICOLON:
			case IF:
			case WHILE:
			case DO:
			case FOR:
			case UNROLL:
			case CONTINUE:
			case BREAK:
			case DISCARD:
			case RETURN:
			case VOID:
			case TYPE:
			case BOOLCONSTANT:
			case IDENTIFIER:
			case INTCONSTANT:
			case FLOATCONSTANT:
				enterOuterAlt(_localctx, 2);
				{
				setState(350);
				((StatementContext)_localctx).s = simple_statement();
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

	public static class Simple_statementContext extends ParserRuleContext {
		public Declaration_statementContext d;
		public Expression_statementContext e;
		public Selection_statementContext s;
		public Iteration_statementContext i;
		public Jump_statementContext j;
		public Declaration_statementContext declaration_statement() {
			return getRuleContext(Declaration_statementContext.class,0);
		}
		public Expression_statementContext expression_statement() {
			return getRuleContext(Expression_statementContext.class,0);
		}
		public Selection_statementContext selection_statement() {
			return getRuleContext(Selection_statementContext.class,0);
		}
		public Iteration_statementContext iteration_statement() {
			return getRuleContext(Iteration_statementContext.class,0);
		}
		public Jump_statementContext jump_statement() {
			return getRuleContext(Jump_statementContext.class,0);
		}
		public Simple_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterSimple_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitSimple_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitSimple_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Simple_statementContext simple_statement() throws RecognitionException {
		Simple_statementContext _localctx = new Simple_statementContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_simple_statement);
		try {
			setState(358);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(353);
				((Simple_statementContext)_localctx).d = declaration_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(354);
				((Simple_statementContext)_localctx).e = expression_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(355);
				((Simple_statementContext)_localctx).s = selection_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(356);
				((Simple_statementContext)_localctx).i = iteration_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(357);
				((Simple_statementContext)_localctx).j = jump_statement();
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

	public static class Compound_statementContext extends ParserRuleContext {
		public StatementContext s;
		public TerminalNode LEFT_BRACE() { return getToken(JSLParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(JSLParser.RIGHT_BRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Compound_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterCompound_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitCompound_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitCompound_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Compound_statementContext compound_statement() throws RecognitionException {
		Compound_statementContext _localctx = new Compound_statementContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_compound_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			match(LEFT_BRACE);
			setState(364);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << PLUS) | (1L << DASH) | (1L << INC) | (1L << DEC) | (1L << LEFT_PAREN) | (1L << LEFT_BRACE) | (1L << BANG) | (1L << SEMICOLON) | (1L << IF) | (1L << WHILE) | (1L << DO) | (1L << FOR) | (1L << UNROLL) | (1L << CONTINUE) | (1L << BREAK) | (1L << DISCARD) | (1L << RETURN) | (1L << VOID) | (1L << TYPE) | (1L << BOOLCONSTANT) | (1L << IDENTIFIER) | (1L << INTCONSTANT) | (1L << FLOATCONSTANT))) != 0)) {
				{
				{
				setState(361);
				((Compound_statementContext)_localctx).s = statement();
				}
				}
				setState(366);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(367);
			match(RIGHT_BRACE);
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

	public static class Statement_no_new_scopeContext extends ParserRuleContext {
		public Compound_statement_no_new_scopeContext c;
		public Simple_statementContext s;
		public Compound_statement_no_new_scopeContext compound_statement_no_new_scope() {
			return getRuleContext(Compound_statement_no_new_scopeContext.class,0);
		}
		public Simple_statementContext simple_statement() {
			return getRuleContext(Simple_statementContext.class,0);
		}
		public Statement_no_new_scopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement_no_new_scope; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterStatement_no_new_scope(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitStatement_no_new_scope(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitStatement_no_new_scope(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Statement_no_new_scopeContext statement_no_new_scope() throws RecognitionException {
		Statement_no_new_scopeContext _localctx = new Statement_no_new_scopeContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_statement_no_new_scope);
		try {
			setState(371);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEFT_BRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(369);
				((Statement_no_new_scopeContext)_localctx).c = compound_statement_no_new_scope();
				}
				break;
			case T__0:
			case T__1:
			case T__2:
			case T__3:
			case T__4:
			case PLUS:
			case DASH:
			case INC:
			case DEC:
			case LEFT_PAREN:
			case BANG:
			case SEMICOLON:
			case IF:
			case WHILE:
			case DO:
			case FOR:
			case UNROLL:
			case CONTINUE:
			case BREAK:
			case DISCARD:
			case RETURN:
			case VOID:
			case TYPE:
			case BOOLCONSTANT:
			case IDENTIFIER:
			case INTCONSTANT:
			case FLOATCONSTANT:
				enterOuterAlt(_localctx, 2);
				{
				setState(370);
				((Statement_no_new_scopeContext)_localctx).s = simple_statement();
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

	public static class Compound_statement_no_new_scopeContext extends ParserRuleContext {
		public StatementContext s;
		public TerminalNode LEFT_BRACE() { return getToken(JSLParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(JSLParser.RIGHT_BRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Compound_statement_no_new_scopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_statement_no_new_scope; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterCompound_statement_no_new_scope(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitCompound_statement_no_new_scope(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitCompound_statement_no_new_scope(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Compound_statement_no_new_scopeContext compound_statement_no_new_scope() throws RecognitionException {
		Compound_statement_no_new_scopeContext _localctx = new Compound_statement_no_new_scopeContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_compound_statement_no_new_scope);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			match(LEFT_BRACE);
			setState(377);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << PLUS) | (1L << DASH) | (1L << INC) | (1L << DEC) | (1L << LEFT_PAREN) | (1L << LEFT_BRACE) | (1L << BANG) | (1L << SEMICOLON) | (1L << IF) | (1L << WHILE) | (1L << DO) | (1L << FOR) | (1L << UNROLL) | (1L << CONTINUE) | (1L << BREAK) | (1L << DISCARD) | (1L << RETURN) | (1L << VOID) | (1L << TYPE) | (1L << BOOLCONSTANT) | (1L << IDENTIFIER) | (1L << INTCONSTANT) | (1L << FLOATCONSTANT))) != 0)) {
				{
				{
				setState(374);
				((Compound_statement_no_new_scopeContext)_localctx).s = statement();
				}
				}
				setState(379);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(380);
			match(RIGHT_BRACE);
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

	public static class Expression_statementContext extends ParserRuleContext {
		public ExpressionContext e;
		public TerminalNode SEMICOLON() { return getToken(JSLParser.SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Expression_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterExpression_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitExpression_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitExpression_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expression_statementContext expression_statement() throws RecognitionException {
		Expression_statementContext _localctx = new Expression_statementContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_expression_statement);
		try {
			setState(386);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEMICOLON:
				enterOuterAlt(_localctx, 1);
				{
				setState(382);
				match(SEMICOLON);
				}
				break;
			case PLUS:
			case DASH:
			case INC:
			case DEC:
			case LEFT_PAREN:
			case BANG:
			case VOID:
			case TYPE:
			case BOOLCONSTANT:
			case IDENTIFIER:
			case INTCONSTANT:
			case FLOATCONSTANT:
				enterOuterAlt(_localctx, 2);
				{
				setState(383);
				((Expression_statementContext)_localctx).e = expression();
				setState(384);
				match(SEMICOLON);
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

	public static class Constant_expressionContext extends ParserRuleContext {
		public Conditional_expressionContext c;
		public Conditional_expressionContext conditional_expression() {
			return getRuleContext(Conditional_expressionContext.class,0);
		}
		public Constant_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterConstant_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitConstant_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitConstant_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constant_expressionContext constant_expression() throws RecognitionException {
		Constant_expressionContext _localctx = new Constant_expressionContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_constant_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(388);
			((Constant_expressionContext)_localctx).c = conditional_expression();
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

	public static class Selection_statementContext extends ParserRuleContext {
		public ExpressionContext e;
		public StatementContext a;
		public StatementContext b;
		public TerminalNode IF() { return getToken(JSLParser.IF, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(JSLParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(JSLParser.RIGHT_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(JSLParser.ELSE, 0); }
		public Selection_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selection_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterSelection_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitSelection_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitSelection_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Selection_statementContext selection_statement() throws RecognitionException {
		Selection_statementContext _localctx = new Selection_statementContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_selection_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(390);
			match(IF);
			setState(391);
			match(LEFT_PAREN);
			setState(392);
			((Selection_statementContext)_localctx).e = expression();
			setState(393);
			match(RIGHT_PAREN);
			setState(394);
			((Selection_statementContext)_localctx).a = statement();
			setState(397);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(395);
				match(ELSE);
				setState(396);
				((Selection_statementContext)_localctx).b = statement();
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

	public static class ConditionContext extends ParserRuleContext {
		public ExpressionContext e;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(399);
			((ConditionContext)_localctx).e = expression();
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

	public static class Iteration_statementContext extends ParserRuleContext {
		public ConditionContext c;
		public Statement_no_new_scopeContext snns;
		public StatementContext s;
		public ExpressionContext e;
		public Unroll_modifierContext u;
		public For_init_statementContext init;
		public For_rest_statementContext rem;
		public TerminalNode WHILE() { return getToken(JSLParser.WHILE, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(JSLParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(JSLParser.RIGHT_PAREN, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public Statement_no_new_scopeContext statement_no_new_scope() {
			return getRuleContext(Statement_no_new_scopeContext.class,0);
		}
		public TerminalNode DO() { return getToken(JSLParser.DO, 0); }
		public TerminalNode SEMICOLON() { return getToken(JSLParser.SEMICOLON, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode FOR() { return getToken(JSLParser.FOR, 0); }
		public Unroll_modifierContext unroll_modifier() {
			return getRuleContext(Unroll_modifierContext.class,0);
		}
		public For_init_statementContext for_init_statement() {
			return getRuleContext(For_init_statementContext.class,0);
		}
		public For_rest_statementContext for_rest_statement() {
			return getRuleContext(For_rest_statementContext.class,0);
		}
		public Iteration_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iteration_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterIteration_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitIteration_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitIteration_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Iteration_statementContext iteration_statement() throws RecognitionException {
		Iteration_statementContext _localctx = new Iteration_statementContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_iteration_statement);
		try {
			setState(430);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHILE:
				enterOuterAlt(_localctx, 1);
				{
				setState(401);
				match(WHILE);
				setState(402);
				match(LEFT_PAREN);
				setState(403);
				((Iteration_statementContext)_localctx).c = condition();
				setState(404);
				match(RIGHT_PAREN);
				setState(405);
				((Iteration_statementContext)_localctx).snns = statement_no_new_scope();
				}
				break;
			case DO:
				enterOuterAlt(_localctx, 2);
				{
				setState(407);
				match(DO);
				setState(408);
				((Iteration_statementContext)_localctx).s = statement();
				setState(409);
				match(WHILE);
				setState(410);
				match(LEFT_PAREN);
				setState(411);
				((Iteration_statementContext)_localctx).e = expression();
				setState(412);
				match(RIGHT_PAREN);
				setState(413);
				match(SEMICOLON);
				}
				break;
			case UNROLL:
				enterOuterAlt(_localctx, 3);
				{
				setState(415);
				((Iteration_statementContext)_localctx).u = unroll_modifier();
				setState(416);
				match(FOR);
				setState(417);
				match(LEFT_PAREN);
				setState(418);
				((Iteration_statementContext)_localctx).init = for_init_statement();
				setState(419);
				((Iteration_statementContext)_localctx).rem = for_rest_statement();
				setState(420);
				match(RIGHT_PAREN);
				setState(421);
				((Iteration_statementContext)_localctx).snns = statement_no_new_scope();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 4);
				{
				setState(423);
				match(FOR);
				setState(424);
				match(LEFT_PAREN);
				setState(425);
				((Iteration_statementContext)_localctx).init = for_init_statement();
				setState(426);
				((Iteration_statementContext)_localctx).rem = for_rest_statement();
				setState(427);
				match(RIGHT_PAREN);
				setState(428);
				((Iteration_statementContext)_localctx).snns = statement_no_new_scope();
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

	public static class Unroll_modifierContext extends ParserRuleContext {
		public Token m;
		public Token c;
		public TerminalNode UNROLL() { return getToken(JSLParser.UNROLL, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(JSLParser.LEFT_PAREN, 0); }
		public TerminalNode COMMA() { return getToken(JSLParser.COMMA, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(JSLParser.RIGHT_PAREN, 0); }
		public List<TerminalNode> INTCONSTANT() { return getTokens(JSLParser.INTCONSTANT); }
		public TerminalNode INTCONSTANT(int i) {
			return getToken(JSLParser.INTCONSTANT, i);
		}
		public Unroll_modifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unroll_modifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterUnroll_modifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitUnroll_modifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitUnroll_modifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unroll_modifierContext unroll_modifier() throws RecognitionException {
		Unroll_modifierContext _localctx = new Unroll_modifierContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_unroll_modifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(432);
			match(UNROLL);
			setState(433);
			match(LEFT_PAREN);
			setState(434);
			((Unroll_modifierContext)_localctx).m = match(INTCONSTANT);
			setState(435);
			match(COMMA);
			setState(436);
			((Unroll_modifierContext)_localctx).c = match(INTCONSTANT);
			setState(437);
			match(RIGHT_PAREN);
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

	public static class For_init_statementContext extends ParserRuleContext {
		public Expression_statementContext e;
		public Declaration_statementContext d;
		public Expression_statementContext expression_statement() {
			return getRuleContext(Expression_statementContext.class,0);
		}
		public Declaration_statementContext declaration_statement() {
			return getRuleContext(Declaration_statementContext.class,0);
		}
		public For_init_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_init_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterFor_init_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitFor_init_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitFor_init_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_init_statementContext for_init_statement() throws RecognitionException {
		For_init_statementContext _localctx = new For_init_statementContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_for_init_statement);
		try {
			setState(441);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(439);
				((For_init_statementContext)_localctx).e = expression_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(440);
				((For_init_statementContext)_localctx).d = declaration_statement();
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

	public static class For_rest_statementContext extends ParserRuleContext {
		public ConditionContext c;
		public ExpressionContext e;
		public TerminalNode SEMICOLON() { return getToken(JSLParser.SEMICOLON, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public For_rest_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_rest_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterFor_rest_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitFor_rest_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitFor_rest_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_rest_statementContext for_rest_statement() throws RecognitionException {
		For_rest_statementContext _localctx = new For_rest_statementContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_for_rest_statement);
		int _la;
		try {
			setState(452);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
			case DASH:
			case INC:
			case DEC:
			case LEFT_PAREN:
			case BANG:
			case VOID:
			case TYPE:
			case BOOLCONSTANT:
			case IDENTIFIER:
			case INTCONSTANT:
			case FLOATCONSTANT:
				enterOuterAlt(_localctx, 1);
				{
				setState(443);
				((For_rest_statementContext)_localctx).c = condition();
				setState(444);
				match(SEMICOLON);
				setState(446);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << DASH) | (1L << INC) | (1L << DEC) | (1L << LEFT_PAREN) | (1L << BANG) | (1L << VOID) | (1L << TYPE) | (1L << BOOLCONSTANT) | (1L << IDENTIFIER) | (1L << INTCONSTANT) | (1L << FLOATCONSTANT))) != 0)) {
					{
					setState(445);
					((For_rest_statementContext)_localctx).e = expression();
					}
				}

				}
				break;
			case SEMICOLON:
				enterOuterAlt(_localctx, 2);
				{
				setState(448);
				match(SEMICOLON);
				setState(450);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << DASH) | (1L << INC) | (1L << DEC) | (1L << LEFT_PAREN) | (1L << BANG) | (1L << VOID) | (1L << TYPE) | (1L << BOOLCONSTANT) | (1L << IDENTIFIER) | (1L << INTCONSTANT) | (1L << FLOATCONSTANT))) != 0)) {
					{
					setState(449);
					((For_rest_statementContext)_localctx).e = expression();
					}
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

	public static class Jump_statementContext extends ParserRuleContext {
		public ExpressionContext e;
		public TerminalNode CONTINUE() { return getToken(JSLParser.CONTINUE, 0); }
		public TerminalNode SEMICOLON() { return getToken(JSLParser.SEMICOLON, 0); }
		public TerminalNode BREAK() { return getToken(JSLParser.BREAK, 0); }
		public TerminalNode DISCARD() { return getToken(JSLParser.DISCARD, 0); }
		public TerminalNode RETURN() { return getToken(JSLParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Jump_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jump_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterJump_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitJump_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitJump_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Jump_statementContext jump_statement() throws RecognitionException {
		Jump_statementContext _localctx = new Jump_statementContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_jump_statement);
		try {
			setState(466);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(454);
				match(CONTINUE);
				setState(455);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(456);
				match(BREAK);
				setState(457);
				match(SEMICOLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(458);
				match(DISCARD);
				setState(459);
				match(SEMICOLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(460);
				match(RETURN);
				setState(461);
				match(SEMICOLON);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(462);
				match(RETURN);
				setState(463);
				((Jump_statementContext)_localctx).e = expression();
				setState(464);
				match(SEMICOLON);
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

	public static class Translation_unitContext extends ParserRuleContext {
		public External_declarationContext e;
		public List<External_declarationContext> external_declaration() {
			return getRuleContexts(External_declarationContext.class);
		}
		public External_declarationContext external_declaration(int i) {
			return getRuleContext(External_declarationContext.class,i);
		}
		public Translation_unitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_translation_unit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterTranslation_unit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitTranslation_unit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitTranslation_unit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Translation_unitContext translation_unit() throws RecognitionException {
		Translation_unitContext _localctx = new Translation_unitContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_translation_unit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(468);
				((Translation_unitContext)_localctx).e = external_declaration();
				}
				}
				setState(471); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << VOID) | (1L << TYPE) | (1L << GLUE_BLOCK))) != 0) );
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

	public static class External_declarationContext extends ParserRuleContext {
		public Function_definitionContext f;
		public DeclarationContext d;
		public Glue_blockContext g;
		public Function_definitionContext function_definition() {
			return getRuleContext(Function_definitionContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public Glue_blockContext glue_block() {
			return getRuleContext(Glue_blockContext.class,0);
		}
		public External_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_external_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterExternal_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitExternal_declaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitExternal_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final External_declarationContext external_declaration() throws RecognitionException {
		External_declarationContext _localctx = new External_declarationContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_external_declaration);
		try {
			setState(476);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(473);
				((External_declarationContext)_localctx).f = function_definition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(474);
				((External_declarationContext)_localctx).d = declaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(475);
				((External_declarationContext)_localctx).g = glue_block();
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

	public static class Function_definitionContext extends ParserRuleContext {
		public Function_prototypeContext p;
		public Compound_statement_no_new_scopeContext s;
		public Function_prototypeContext function_prototype() {
			return getRuleContext(Function_prototypeContext.class,0);
		}
		public Compound_statement_no_new_scopeContext compound_statement_no_new_scope() {
			return getRuleContext(Compound_statement_no_new_scopeContext.class,0);
		}
		public Function_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterFunction_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitFunction_definition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitFunction_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_definitionContext function_definition() throws RecognitionException {
		Function_definitionContext _localctx = new Function_definitionContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_function_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(478);
			((Function_definitionContext)_localctx).p = function_prototype();
			setState(479);
			((Function_definitionContext)_localctx).s = compound_statement_no_new_scope();
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

	public static class Glue_blockContext extends ParserRuleContext {
		public Token g;
		public TerminalNode GLUE_BLOCK() { return getToken(JSLParser.GLUE_BLOCK, 0); }
		public Glue_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_glue_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).enterGlue_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSLListener ) ((JSLListener)listener).exitGlue_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSLVisitor ) return ((JSLVisitor<? extends T>)visitor).visitGlue_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Glue_blockContext glue_block() throws RecognitionException {
		Glue_blockContext _localctx = new Glue_blockContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_glue_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(481);
			((Glue_blockContext)_localctx).g = match(GLUE_BLOCK);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3@\u01e6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\3\2\3\2\5\2s\n\2\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\5\3}\n\3\3\4\3\4\5\4\u0081\n\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u0098"+
		"\n\5\3\6\3\6\3\6\5\6\u009d\n\6\3\6\3\6\3\6\3\6\5\6\u00a3\n\6\3\6\3\6\5"+
		"\6\u00a7\n\6\3\7\3\7\3\7\7\7\u00ac\n\7\f\7\16\7\u00af\13\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00bc\n\b\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\7\n\u00c4\n\n\f\n\16\n\u00c7\13\n\3\13\3\13\3\f\3\f\3\f\3\f\7\f\u00cf"+
		"\n\f\f\f\16\f\u00d2\13\f\3\r\3\r\3\16\3\16\3\16\3\16\7\16\u00da\n\16\f"+
		"\16\16\16\u00dd\13\16\3\17\3\17\3\20\3\20\3\20\3\20\7\20\u00e5\n\20\f"+
		"\20\16\20\u00e8\13\20\3\21\3\21\3\21\7\21\u00ed\n\21\f\21\16\21\u00f0"+
		"\13\21\3\22\3\22\3\22\7\22\u00f5\n\22\f\22\16\22\u00f8\13\22\3\23\3\23"+
		"\3\23\7\23\u00fd\n\23\f\23\16\23\u0100\13\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\25\3\25\5\25\u0109\n\25\3\26\3\26\3\26\3\26\3\26\5\26\u0110\n\26\3"+
		"\27\3\27\3\30\3\30\3\31\3\31\3\31\3\31\5\31\u011a\n\31\3\31\3\31\3\32"+
		"\3\32\3\32\3\33\3\33\3\33\7\33\u0124\n\33\f\33\16\33\u0127\13\33\3\34"+
		"\3\34\3\34\3\34\3\34\5\34\u012e\n\34\3\34\3\34\5\34\u0132\n\34\3\35\3"+
		"\35\3\35\3\36\3\36\3\36\7\36\u013a\n\36\f\36\16\36\u013d\13\36\3\36\3"+
		"\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u014c"+
		"\n\37\3 \3 \3!\3!\3\"\3\"\5\"\u0154\n\"\3#\3#\3#\3#\3$\3$\3%\3%\3&\3&"+
		"\3\'\3\'\5\'\u0162\n\'\3(\3(\3(\3(\3(\5(\u0169\n(\3)\3)\7)\u016d\n)\f"+
		")\16)\u0170\13)\3)\3)\3*\3*\5*\u0176\n*\3+\3+\7+\u017a\n+\f+\16+\u017d"+
		"\13+\3+\3+\3,\3,\3,\3,\5,\u0185\n,\3-\3-\3.\3.\3.\3.\3.\3.\3.\5.\u0190"+
		"\n.\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60"+
		"\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60"+
		"\3\60\3\60\3\60\5\60\u01b1\n\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\62"+
		"\3\62\5\62\u01bc\n\62\3\63\3\63\3\63\5\63\u01c1\n\63\3\63\3\63\5\63\u01c5"+
		"\n\63\5\63\u01c7\n\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64"+
		"\3\64\3\64\5\64\u01d5\n\64\3\65\6\65\u01d8\n\65\r\65\16\65\u01d9\3\66"+
		"\3\66\3\66\5\66\u01df\n\66\3\67\3\67\3\67\38\38\38\2\29\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bd"+
		"fhjln\2\n\3\2\b\t\3\2\n\13\3\2\f\17\3\2\20\21\4\2\27\32%%\3\2\3\4\3\2"+
		"\5\7\3\2\65\66\2\u01ec\2r\3\2\2\2\4|\3\2\2\2\6\u0080\3\2\2\2\b\u0097\3"+
		"\2\2\2\n\u00a6\3\2\2\2\f\u00a8\3\2\2\2\16\u00bb\3\2\2\2\20\u00bd\3\2\2"+
		"\2\22\u00bf\3\2\2\2\24\u00c8\3\2\2\2\26\u00ca\3\2\2\2\30\u00d3\3\2\2\2"+
		"\32\u00d5\3\2\2\2\34\u00de\3\2\2\2\36\u00e0\3\2\2\2 \u00e9\3\2\2\2\"\u00f1"+
		"\3\2\2\2$\u00f9\3\2\2\2&\u0101\3\2\2\2(\u0106\3\2\2\2*\u010f\3\2\2\2,"+
		"\u0111\3\2\2\2.\u0113\3\2\2\2\60\u0115\3\2\2\2\62\u011d\3\2\2\2\64\u0120"+
		"\3\2\2\2\66\u0128\3\2\2\28\u0133\3\2\2\2:\u0136\3\2\2\2<\u014b\3\2\2\2"+
		">\u014d\3\2\2\2@\u014f\3\2\2\2B\u0151\3\2\2\2D\u0155\3\2\2\2F\u0159\3"+
		"\2\2\2H\u015b\3\2\2\2J\u015d\3\2\2\2L\u0161\3\2\2\2N\u0168\3\2\2\2P\u016a"+
		"\3\2\2\2R\u0175\3\2\2\2T\u0177\3\2\2\2V\u0184\3\2\2\2X\u0186\3\2\2\2Z"+
		"\u0188\3\2\2\2\\\u0191\3\2\2\2^\u01b0\3\2\2\2`\u01b2\3\2\2\2b\u01bb\3"+
		"\2\2\2d\u01c6\3\2\2\2f\u01d4\3\2\2\2h\u01d7\3\2\2\2j\u01de\3\2\2\2l\u01e0"+
		"\3\2\2\2n\u01e3\3\2\2\2ps\78\2\2qs\79\2\2rp\3\2\2\2rq\3\2\2\2s\3\3\2\2"+
		"\2t}\7:\2\2u}\7;\2\2v}\7<\2\2w}\7\67\2\2xy\7\33\2\2yz\5.\30\2z{\7\34\2"+
		"\2{}\3\2\2\2|t\3\2\2\2|u\3\2\2\2|v\3\2\2\2|w\3\2\2\2|x\3\2\2\2}\5\3\2"+
		"\2\2~\u0081\5\4\3\2\177\u0081\5\n\6\2\u0080~\3\2\2\2\u0080\177\3\2\2\2"+
		"\u0081\7\3\2\2\2\u0082\u0083\5\6\4\2\u0083\u0084\7\35\2\2\u0084\u0085"+
		"\5.\30\2\u0085\u0086\7\36\2\2\u0086\u0087\5\2\2\2\u0087\u0098\3\2\2\2"+
		"\u0088\u0089\5\6\4\2\u0089\u008a\7\35\2\2\u008a\u008b\5.\30\2\u008b\u008c"+
		"\7\36\2\2\u008c\u0098\3\2\2\2\u008d\u008e\5\6\4\2\u008e\u008f\5\2\2\2"+
		"\u008f\u0098\3\2\2\2\u0090\u0091\5\6\4\2\u0091\u0092\7\25\2\2\u0092\u0098"+
		"\3\2\2\2\u0093\u0094\5\6\4\2\u0094\u0095\7\26\2\2\u0095\u0098\3\2\2\2"+
		"\u0096\u0098\5\6\4\2\u0097\u0082\3\2\2\2\u0097\u0088\3\2\2\2\u0097\u008d"+
		"\3\2\2\2\u0097\u0090\3\2\2\2\u0097\u0093\3\2\2\2\u0097\u0096\3\2\2\2\u0098"+
		"\t\3\2\2\2\u0099\u009a\7:\2\2\u009a\u009c\7\33\2\2\u009b\u009d\5\f\7\2"+
		"\u009c\u009b\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a7"+
		"\7\34\2\2\u009f\u00a0\5B\"\2\u00a0\u00a2\7\33\2\2\u00a1\u00a3\5\f\7\2"+
		"\u00a2\u00a1\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5"+
		"\7\34\2\2\u00a5\u00a7\3\2\2\2\u00a6\u0099\3\2\2\2\u00a6\u009f\3\2\2\2"+
		"\u00a7\13\3\2\2\2\u00a8\u00ad\5*\26\2\u00a9\u00aa\7$\2\2\u00aa\u00ac\5"+
		"*\26\2\u00ab\u00a9\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad"+
		"\u00ae\3\2\2\2\u00ae\r\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00bc\5\b\5\2"+
		"\u00b1\u00b2\7\25\2\2\u00b2\u00bc\5\16\b\2\u00b3\u00b4\7\26\2\2\u00b4"+
		"\u00bc\5\16\b\2\u00b5\u00b6\7\n\2\2\u00b6\u00bc\5\16\b\2\u00b7\u00b8\7"+
		"\13\2\2\u00b8\u00bc\5\16\b\2\u00b9\u00ba\7&\2\2\u00ba\u00bc\5\16\b\2\u00bb"+
		"\u00b0\3\2\2\2\u00bb\u00b1\3\2\2\2\u00bb\u00b3\3\2\2\2\u00bb\u00b5\3\2"+
		"\2\2\u00bb\u00b7\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\17\3\2\2\2\u00bd\u00be"+
		"\t\2\2\2\u00be\21\3\2\2\2\u00bf\u00c5\5\16\b\2\u00c0\u00c1\5\20\t\2\u00c1"+
		"\u00c2\5\22\n\2\u00c2\u00c4\3\2\2\2\u00c3\u00c0\3\2\2\2\u00c4\u00c7\3"+
		"\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\23\3\2\2\2\u00c7"+
		"\u00c5\3\2\2\2\u00c8\u00c9\t\3\2\2\u00c9\25\3\2\2\2\u00ca\u00d0\5\22\n"+
		"\2\u00cb\u00cc\5\24\13\2\u00cc\u00cd\5\22\n\2\u00cd\u00cf\3\2\2\2\u00ce"+
		"\u00cb\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2"+
		"\2\2\u00d1\27\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d3\u00d4\t\4\2\2\u00d4\31"+
		"\3\2\2\2\u00d5\u00db\5\26\f\2\u00d6\u00d7\5\30\r\2\u00d7\u00d8\5\26\f"+
		"\2\u00d8\u00da\3\2\2\2\u00d9\u00d6\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9"+
		"\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\33\3\2\2\2\u00dd\u00db\3\2\2\2\u00de"+
		"\u00df\t\5\2\2\u00df\35\3\2\2\2\u00e0\u00e6\5\32\16\2\u00e1\u00e2\5\34"+
		"\17\2\u00e2\u00e3\5\32\16\2\u00e3\u00e5\3\2\2\2\u00e4\u00e1\3\2\2\2\u00e5"+
		"\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\37\3\2\2"+
		"\2\u00e8\u00e6\3\2\2\2\u00e9\u00ee\5\36\20\2\u00ea\u00eb\7\22\2\2\u00eb"+
		"\u00ed\5\36\20\2\u00ec\u00ea\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee\u00ec\3"+
		"\2\2\2\u00ee\u00ef\3\2\2\2\u00ef!\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00f6"+
		"\5 \21\2\u00f2\u00f3\7\23\2\2\u00f3\u00f5\5 \21\2\u00f4\u00f2\3\2\2\2"+
		"\u00f5\u00f8\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7#\3"+
		"\2\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00fe\5\"\22\2\u00fa\u00fb\7\24\2\2\u00fb"+
		"\u00fd\5\"\22\2\u00fc\u00fa\3\2\2\2\u00fd\u0100\3\2\2\2\u00fe\u00fc\3"+
		"\2\2\2\u00fe\u00ff\3\2\2\2\u00ff%\3\2\2\2\u0100\u00fe\3\2\2\2\u0101\u0102"+
		"\7(\2\2\u0102\u0103\5.\30\2\u0103\u0104\7)\2\2\u0104\u0105\5*\26\2\u0105"+
		"\'\3\2\2\2\u0106\u0108\5$\23\2\u0107\u0109\5&\24\2\u0108\u0107\3\2\2\2"+
		"\u0108\u0109\3\2\2\2\u0109)\3\2\2\2\u010a\u010b\5\16\b\2\u010b\u010c\5"+
		",\27\2\u010c\u010d\5*\26\2\u010d\u0110\3\2\2\2\u010e\u0110\5(\25\2\u010f"+
		"\u010a\3\2\2\2\u010f\u010e\3\2\2\2\u0110+\3\2\2\2\u0111\u0112\t\6\2\2"+
		"\u0112-\3\2\2\2\u0113\u0114\5*\26\2\u0114/\3\2\2\2\u0115\u0116\5B\"\2"+
		"\u0116\u0117\7:\2\2\u0117\u0119\7\33\2\2\u0118\u011a\5\64\33\2\u0119\u0118"+
		"\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011c\7\34\2\2"+
		"\u011c\61\3\2\2\2\u011d\u011e\5B\"\2\u011e\u011f\7:\2\2\u011f\63\3\2\2"+
		"\2\u0120\u0125\5\62\32\2\u0121\u0122\7$\2\2\u0122\u0124\5\62\32\2\u0123"+
		"\u0121\3\2\2\2\u0124\u0127\3\2\2\2\u0125\u0123\3\2\2\2\u0125\u0126\3\2"+
		"\2\2\u0126\65\3\2\2\2\u0127\u0125\3\2\2\2\u0128\u012d\7:\2\2\u0129\u012a"+
		"\7\35\2\2\u012a\u012b\5X-\2\u012b\u012c\7\36\2\2\u012c\u012e\3\2\2\2\u012d"+
		"\u0129\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u0131\3\2\2\2\u012f\u0130\7%"+
		"\2\2\u0130\u0132\5H%\2\u0131\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132\67"+
		"\3\2\2\2\u0133\u0134\5<\37\2\u0134\u0135\5\66\34\2\u01359\3\2\2\2\u0136"+
		"\u013b\58\35\2\u0137\u0138\7$\2\2\u0138\u013a\5\66\34\2\u0139\u0137\3"+
		"\2\2\2\u013a\u013d\3\2\2\2\u013b\u0139\3\2\2\2\u013b\u013c\3\2\2\2\u013c"+
		"\u013e\3\2\2\2\u013d\u013b\3\2\2\2\u013e\u013f\7*\2\2\u013f;\3\2\2\2\u0140"+
		"\u0141\5> \2\u0141\u0142\5@!\2\u0142\u0143\5B\"\2\u0143\u014c\3\2\2\2"+
		"\u0144\u0145\5> \2\u0145\u0146\5B\"\2\u0146\u014c\3\2\2\2\u0147\u0148"+
		"\5@!\2\u0148\u0149\5B\"\2\u0149\u014c\3\2\2\2\u014a\u014c\5B\"\2\u014b"+
		"\u0140\3\2\2\2\u014b\u0144\3\2\2\2\u014b\u0147\3\2\2\2\u014b\u014a\3\2"+
		"\2\2\u014c=\3\2\2\2\u014d\u014e\t\7\2\2\u014e?\3\2\2\2\u014f\u0150\t\b"+
		"\2\2\u0150A\3\2\2\2\u0151\u0153\5F$\2\u0152\u0154\5D#\2\u0153\u0152\3"+
		"\2\2\2\u0153\u0154\3\2\2\2\u0154C\3\2\2\2\u0155\u0156\7\35\2\2\u0156\u0157"+
		"\5X-\2\u0157\u0158\7\36\2\2\u0158E\3\2\2\2\u0159\u015a\t\t\2\2\u015aG"+
		"\3\2\2\2\u015b\u015c\5*\26\2\u015cI\3\2\2\2\u015d\u015e\5:\36\2\u015e"+
		"K\3\2\2\2\u015f\u0162\5P)\2\u0160\u0162\5N(\2\u0161\u015f\3\2\2\2\u0161"+
		"\u0160\3\2\2\2\u0162M\3\2\2\2\u0163\u0169\5J&\2\u0164\u0169\5V,\2\u0165"+
		"\u0169\5Z.\2\u0166\u0169\5^\60\2\u0167\u0169\5f\64\2\u0168\u0163\3\2\2"+
		"\2\u0168\u0164\3\2\2\2\u0168\u0165\3\2\2\2\u0168\u0166\3\2\2\2\u0168\u0167"+
		"\3\2\2\2\u0169O\3\2\2\2\u016a\u016e\7\37\2\2\u016b\u016d\5L\'\2\u016c"+
		"\u016b\3\2\2\2\u016d\u0170\3\2\2\2\u016e\u016c\3\2\2\2\u016e\u016f\3\2"+
		"\2\2\u016f\u0171\3\2\2\2\u0170\u016e\3\2\2\2\u0171\u0172\7 \2\2\u0172"+
		"Q\3\2\2\2\u0173\u0176\5T+\2\u0174\u0176\5N(\2\u0175\u0173\3\2\2\2\u0175"+
		"\u0174\3\2\2\2\u0176S\3\2\2\2\u0177\u017b\7\37\2\2\u0178\u017a\5L\'\2"+
		"\u0179\u0178\3\2\2\2\u017a\u017d\3\2\2\2\u017b\u0179\3\2\2\2\u017b\u017c"+
		"\3\2\2\2\u017c\u017e\3\2\2\2\u017d\u017b\3\2\2\2\u017e\u017f\7 \2\2\u017f"+
		"U\3\2\2\2\u0180\u0185\7*\2\2\u0181\u0182\5.\30\2\u0182\u0183\7*\2\2\u0183"+
		"\u0185\3\2\2\2\u0184\u0180\3\2\2\2\u0184\u0181\3\2\2\2\u0185W\3\2\2\2"+
		"\u0186\u0187\5(\25\2\u0187Y\3\2\2\2\u0188\u0189\7+\2\2\u0189\u018a\7\33"+
		"\2\2\u018a\u018b\5.\30\2\u018b\u018c\7\34\2\2\u018c\u018f\5L\'\2\u018d"+
		"\u018e\7,\2\2\u018e\u0190\5L\'\2\u018f\u018d\3\2\2\2\u018f\u0190\3\2\2"+
		"\2\u0190[\3\2\2\2\u0191\u0192\5.\30\2\u0192]\3\2\2\2\u0193\u0194\7-\2"+
		"\2\u0194\u0195\7\33\2\2\u0195\u0196\5\\/\2\u0196\u0197\7\34\2\2\u0197"+
		"\u0198\5R*\2\u0198\u01b1\3\2\2\2\u0199\u019a\7.\2\2\u019a\u019b\5L\'\2"+
		"\u019b\u019c\7-\2\2\u019c\u019d\7\33\2\2\u019d\u019e\5.\30\2\u019e\u019f"+
		"\7\34\2\2\u019f\u01a0\7*\2\2\u01a0\u01b1\3\2\2\2\u01a1\u01a2\5`\61\2\u01a2"+
		"\u01a3\7/\2\2\u01a3\u01a4\7\33\2\2\u01a4\u01a5\5b\62\2\u01a5\u01a6\5d"+
		"\63\2\u01a6\u01a7\7\34\2\2\u01a7\u01a8\5R*\2\u01a8\u01b1\3\2\2\2\u01a9"+
		"\u01aa\7/\2\2\u01aa\u01ab\7\33\2\2\u01ab\u01ac\5b\62\2\u01ac\u01ad\5d"+
		"\63\2\u01ad\u01ae\7\34\2\2\u01ae\u01af\5R*\2\u01af\u01b1\3\2\2\2\u01b0"+
		"\u0193\3\2\2\2\u01b0\u0199\3\2\2\2\u01b0\u01a1\3\2\2\2\u01b0\u01a9\3\2"+
		"\2\2\u01b1_\3\2\2\2\u01b2\u01b3\7\60\2\2\u01b3\u01b4\7\33\2\2\u01b4\u01b5"+
		"\7;\2\2\u01b5\u01b6\7$\2\2\u01b6\u01b7\7;\2\2\u01b7\u01b8\7\34\2\2\u01b8"+
		"a\3\2\2\2\u01b9\u01bc\5V,\2\u01ba\u01bc\5J&\2\u01bb\u01b9\3\2\2\2\u01bb"+
		"\u01ba\3\2\2\2\u01bcc\3\2\2\2\u01bd\u01be\5\\/\2\u01be\u01c0\7*\2\2\u01bf"+
		"\u01c1\5.\30\2\u01c0\u01bf\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\u01c7\3\2"+
		"\2\2\u01c2\u01c4\7*\2\2\u01c3\u01c5\5.\30\2\u01c4\u01c3\3\2\2\2\u01c4"+
		"\u01c5\3\2\2\2\u01c5\u01c7\3\2\2\2\u01c6\u01bd\3\2\2\2\u01c6\u01c2\3\2"+
		"\2\2\u01c7e\3\2\2\2\u01c8\u01c9\7\61\2\2\u01c9\u01d5\7*\2\2\u01ca\u01cb"+
		"\7\62\2\2\u01cb\u01d5\7*\2\2\u01cc\u01cd\7\63\2\2\u01cd\u01d5\7*\2\2\u01ce"+
		"\u01cf\7\64\2\2\u01cf\u01d5\7*\2\2\u01d0\u01d1\7\64\2\2\u01d1\u01d2\5"+
		".\30\2\u01d2\u01d3\7*\2\2\u01d3\u01d5\3\2\2\2\u01d4\u01c8\3\2\2\2\u01d4"+
		"\u01ca\3\2\2\2\u01d4\u01cc\3\2\2\2\u01d4\u01ce\3\2\2\2\u01d4\u01d0\3\2"+
		"\2\2\u01d5g\3\2\2\2\u01d6\u01d8\5j\66\2\u01d7\u01d6\3\2\2\2\u01d8\u01d9"+
		"\3\2\2\2\u01d9\u01d7\3\2\2\2\u01d9\u01da\3\2\2\2\u01dai\3\2\2\2\u01db"+
		"\u01df\5l\67\2\u01dc\u01df\5:\36\2\u01dd\u01df\5n8\2\u01de\u01db\3\2\2"+
		"\2\u01de\u01dc\3\2\2\2\u01de\u01dd\3\2\2\2\u01dfk\3\2\2\2\u01e0\u01e1"+
		"\5\60\31\2\u01e1\u01e2\5T+\2\u01e2m\3\2\2\2\u01e3\u01e4\7@\2\2\u01e4o"+
		"\3\2\2\2*r|\u0080\u0097\u009c\u00a2\u00a6\u00ad\u00bb\u00c5\u00d0\u00db"+
		"\u00e6\u00ee\u00f6\u00fe\u0108\u010f\u0119\u0125\u012d\u0131\u013b\u014b"+
		"\u0153\u0161\u0168\u016e\u0175\u017b\u0184\u018f\u01b0\u01bb\u01c0\u01c4"+
		"\u01c6\u01d4\u01d9\u01de";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}