// Generated from com/practica1/Language.g4 by ANTLR 4.13.1
package com.practica1;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LanguageParser}.
 */
public interface LanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LanguageParser#almaPrograma}.
	 * @param ctx the parse tree
	 */
	void enterAlmaPrograma(LanguageParser.AlmaProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#almaPrograma}.
	 * @param ctx the parse tree
	 */
	void exitAlmaPrograma(LanguageParser.AlmaProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#almaDeclaracion}.
	 * @param ctx the parse tree
	 */
	void enterAlmaDeclaracion(LanguageParser.AlmaDeclaracionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#almaDeclaracion}.
	 * @param ctx the parse tree
	 */
	void exitAlmaDeclaracion(LanguageParser.AlmaDeclaracionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#almaTipo}.
	 * @param ctx the parse tree
	 */
	void enterAlmaTipo(LanguageParser.AlmaTipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#almaTipo}.
	 * @param ctx the parse tree
	 */
	void exitAlmaTipo(LanguageParser.AlmaTipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#almaInstruccion}.
	 * @param ctx the parse tree
	 */
	void enterAlmaInstruccion(LanguageParser.AlmaInstruccionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#almaInstruccion}.
	 * @param ctx the parse tree
	 */
	void exitAlmaInstruccion(LanguageParser.AlmaInstruccionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#almaConsola}.
	 * @param ctx the parse tree
	 */
	void enterAlmaConsola(LanguageParser.AlmaConsolaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#almaConsola}.
	 * @param ctx the parse tree
	 */
	void exitAlmaConsola(LanguageParser.AlmaConsolaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#almaPara}.
	 * @param ctx the parse tree
	 */
	void enterAlmaPara(LanguageParser.AlmaParaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#almaPara}.
	 * @param ctx the parse tree
	 */
	void exitAlmaPara(LanguageParser.AlmaParaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#almaSi}.
	 * @param ctx the parse tree
	 */
	void enterAlmaSi(LanguageParser.AlmaSiContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#almaSi}.
	 * @param ctx the parse tree
	 */
	void exitAlmaSi(LanguageParser.AlmaSiContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#almaSino}.
	 * @param ctx the parse tree
	 */
	void enterAlmaSino(LanguageParser.AlmaSinoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#almaSino}.
	 * @param ctx the parse tree
	 */
	void exitAlmaSino(LanguageParser.AlmaSinoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#almaBloque}.
	 * @param ctx the parse tree
	 */
	void enterAlmaBloque(LanguageParser.AlmaBloqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#almaBloque}.
	 * @param ctx the parse tree
	 */
	void exitAlmaBloque(LanguageParser.AlmaBloqueContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#almaCondicion}.
	 * @param ctx the parse tree
	 */
	void enterAlmaCondicion(LanguageParser.AlmaCondicionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#almaCondicion}.
	 * @param ctx the parse tree
	 */
	void exitAlmaCondicion(LanguageParser.AlmaCondicionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#almaAsignar}.
	 * @param ctx the parse tree
	 */
	void enterAlmaAsignar(LanguageParser.AlmaAsignarContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#almaAsignar}.
	 * @param ctx the parse tree
	 */
	void exitAlmaAsignar(LanguageParser.AlmaAsignarContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#almaIncremento}.
	 * @param ctx the parse tree
	 */
	void enterAlmaIncremento(LanguageParser.AlmaIncrementoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#almaIncremento}.
	 * @param ctx the parse tree
	 */
	void exitAlmaIncremento(LanguageParser.AlmaIncrementoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#almaIncrementoSimple}.
	 * @param ctx the parse tree
	 */
	void enterAlmaIncrementoSimple(LanguageParser.AlmaIncrementoSimpleContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#almaIncrementoSimple}.
	 * @param ctx the parse tree
	 */
	void exitAlmaIncrementoSimple(LanguageParser.AlmaIncrementoSimpleContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#almaAsignacionCompuesta}.
	 * @param ctx the parse tree
	 */
	void enterAlmaAsignacionCompuesta(LanguageParser.AlmaAsignacionCompuestaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#almaAsignacionCompuesta}.
	 * @param ctx the parse tree
	 */
	void exitAlmaAsignacionCompuesta(LanguageParser.AlmaAsignacionCompuestaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#almaImprimir}.
	 * @param ctx the parse tree
	 */
	void enterAlmaImprimir(LanguageParser.AlmaImprimirContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#almaImprimir}.
	 * @param ctx the parse tree
	 */
	void exitAlmaImprimir(LanguageParser.AlmaImprimirContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#almaExpresion}.
	 * @param ctx the parse tree
	 */
	void enterAlmaExpresion(LanguageParser.AlmaExpresionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#almaExpresion}.
	 * @param ctx the parse tree
	 */
	void exitAlmaExpresion(LanguageParser.AlmaExpresionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#almaTernario}.
	 * @param ctx the parse tree
	 */
	void enterAlmaTernario(LanguageParser.AlmaTernarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#almaTernario}.
	 * @param ctx the parse tree
	 */
	void exitAlmaTernario(LanguageParser.AlmaTernarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#almaLogico}.
	 * @param ctx the parse tree
	 */
	void enterAlmaLogico(LanguageParser.AlmaLogicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#almaLogico}.
	 * @param ctx the parse tree
	 */
	void exitAlmaLogico(LanguageParser.AlmaLogicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#almaIgualdad}.
	 * @param ctx the parse tree
	 */
	void enterAlmaIgualdad(LanguageParser.AlmaIgualdadContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#almaIgualdad}.
	 * @param ctx the parse tree
	 */
	void exitAlmaIgualdad(LanguageParser.AlmaIgualdadContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#almaRelacional}.
	 * @param ctx the parse tree
	 */
	void enterAlmaRelacional(LanguageParser.AlmaRelacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#almaRelacional}.
	 * @param ctx the parse tree
	 */
	void exitAlmaRelacional(LanguageParser.AlmaRelacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#almaAditivo}.
	 * @param ctx the parse tree
	 */
	void enterAlmaAditivo(LanguageParser.AlmaAditivoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#almaAditivo}.
	 * @param ctx the parse tree
	 */
	void exitAlmaAditivo(LanguageParser.AlmaAditivoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#almaMultiplicativo}.
	 * @param ctx the parse tree
	 */
	void enterAlmaMultiplicativo(LanguageParser.AlmaMultiplicativoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#almaMultiplicativo}.
	 * @param ctx the parse tree
	 */
	void exitAlmaMultiplicativo(LanguageParser.AlmaMultiplicativoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#almaPrimario}.
	 * @param ctx the parse tree
	 */
	void enterAlmaPrimario(LanguageParser.AlmaPrimarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#almaPrimario}.
	 * @param ctx the parse tree
	 */
	void exitAlmaPrimario(LanguageParser.AlmaPrimarioContext ctx);
}