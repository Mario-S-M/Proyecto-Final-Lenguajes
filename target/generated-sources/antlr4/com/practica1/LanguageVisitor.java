// Generated from com/practica1/Language.g4 by ANTLR 4.13.1
package com.practica1;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LanguageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LanguageVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LanguageParser#almaPrograma}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlmaPrograma(LanguageParser.AlmaProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#almaDeclaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlmaDeclaracion(LanguageParser.AlmaDeclaracionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#almaTipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlmaTipo(LanguageParser.AlmaTipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#almaInstruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlmaInstruccion(LanguageParser.AlmaInstruccionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#almaConsola}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlmaConsola(LanguageParser.AlmaConsolaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#almaPara}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlmaPara(LanguageParser.AlmaParaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#almaSi}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlmaSi(LanguageParser.AlmaSiContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#almaSino}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlmaSino(LanguageParser.AlmaSinoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#almaBloque}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlmaBloque(LanguageParser.AlmaBloqueContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#almaCondicion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlmaCondicion(LanguageParser.AlmaCondicionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#almaAsignar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlmaAsignar(LanguageParser.AlmaAsignarContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#almaIncremento}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlmaIncremento(LanguageParser.AlmaIncrementoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#almaIncrementoSimple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlmaIncrementoSimple(LanguageParser.AlmaIncrementoSimpleContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#almaAsignacionCompuesta}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlmaAsignacionCompuesta(LanguageParser.AlmaAsignacionCompuestaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#almaImprimir}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlmaImprimir(LanguageParser.AlmaImprimirContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#almaExpresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlmaExpresion(LanguageParser.AlmaExpresionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#almaTernario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlmaTernario(LanguageParser.AlmaTernarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#almaLogico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlmaLogico(LanguageParser.AlmaLogicoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#almaIgualdad}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlmaIgualdad(LanguageParser.AlmaIgualdadContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#almaRelacional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlmaRelacional(LanguageParser.AlmaRelacionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#almaAditivo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlmaAditivo(LanguageParser.AlmaAditivoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#almaMultiplicativo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlmaMultiplicativo(LanguageParser.AlmaMultiplicativoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#almaPrimario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlmaPrimario(LanguageParser.AlmaPrimarioContext ctx);
}