// Generated from c:/Users/mayit/OneDrive/Documentos/automatas/other/grammar1.2/grammar1.2/src/main/antlr4/com/practica1/AlmaLiliaLanguage.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class AlmaLiliaLanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, ALMA_SI=2, ALMA_SINO=3, ALMA_INT=4, ALMA_FLOAT=5, ALMA_BOOLEAN=6, 
		ALMA_STRING=7, ALMA_IMPRIMIR=8, ALMA_PARA=9, ALMA_ASIGNAR=10, ALMA_COMP_IGUAL=11, 
		ALMA_COMP_DIF=12, ALMA_MAYOR_IGUAL=13, ALMA_MENOR_IGUAL=14, ALMA_MENOR=15, 
		ALMA_MAYOR=16, ALMA_SUMA=17, ALMA_REST=18, ALMA_MULT=19, ALMA_DIV=20, 
		ALMA_MOD=21, ALMA_Y=22, ALMA_O=23, ALMA_INC=24, ALMA_DEC=25, ALMA_TERNARIO=26, 
		ALMA_DOSPUNTOS=27, ALMA_ARIT=28, ALMA_FIN=29, ALMA_LPAR=30, ALMA_RPAR=31, 
		ALMA_ACOR=32, ALMA_CCOR=33, ALMA_NUM=34, ALMA_DECIMAL=35, ALMA_TEXTO=36, 
		ALMA_BOOLEANO=37, ALMA_ID=38, ALMA_WS=39, ALMA_COMENTARIO=40;
	public static final int
		RULE_almaPrograma = 0, RULE_almaDeclaracion = 1, RULE_almaTipo = 2, RULE_almaInstruccion = 3, 
		RULE_almaConsola = 4, RULE_almaPara = 5, RULE_almaSi = 6, RULE_almaSino = 7, 
		RULE_almaBloque = 8, RULE_almaCondicion = 9, RULE_almaAsignar = 10, RULE_almaIncremento = 11, 
		RULE_almaIncrementoSimple = 12, RULE_almaAsignacionCompuesta = 13, RULE_almaImprimir = 14, 
		RULE_almaExpresion = 15, RULE_almaTernario = 16, RULE_almaLogico = 17, 
		RULE_almaIgualdad = 18, RULE_almaRelacional = 19, RULE_almaAditivo = 20, 
		RULE_almaMultiplicativo = 21, RULE_almaPrimario = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"almaPrograma", "almaDeclaracion", "almaTipo", "almaInstruccion", "almaConsola", 
			"almaPara", "almaSi", "almaSino", "almaBloque", "almaCondicion", "almaAsignar", 
			"almaIncremento", "almaIncrementoSimple", "almaAsignacionCompuesta", 
			"almaImprimir", "almaExpresion", "almaTernario", "almaLogico", "almaIgualdad", 
			"almaRelacional", "almaAditivo", "almaMultiplicativo", "almaPrimario"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'AlmaLilia.consola'", "'AlmaLilia.si'", "'AlmaLilia.sino'", "'AlmaLilia.int'", 
			"'AlmaLilia.float'", "'AlmaLilia.boolean'", "'AlmaLilia.string'", "'AlmaLilia.imprimir'", 
			"'AlmaLilia.para'", "'='", "'=='", "'!='", "'>='", "'<='", "'<'", "'>'", 
			"'+'", "'-'", "'*'", "'/'", "'%'", "'&&'", "'||'", "'++'", "'--'", "'?'", 
			"':'", null, "';'", "'('", "')'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "ALMA_SI", "ALMA_SINO", "ALMA_INT", "ALMA_FLOAT", "ALMA_BOOLEAN", 
			"ALMA_STRING", "ALMA_IMPRIMIR", "ALMA_PARA", "ALMA_ASIGNAR", "ALMA_COMP_IGUAL", 
			"ALMA_COMP_DIF", "ALMA_MAYOR_IGUAL", "ALMA_MENOR_IGUAL", "ALMA_MENOR", 
			"ALMA_MAYOR", "ALMA_SUMA", "ALMA_REST", "ALMA_MULT", "ALMA_DIV", "ALMA_MOD", 
			"ALMA_Y", "ALMA_O", "ALMA_INC", "ALMA_DEC", "ALMA_TERNARIO", "ALMA_DOSPUNTOS", 
			"ALMA_ARIT", "ALMA_FIN", "ALMA_LPAR", "ALMA_RPAR", "ALMA_ACOR", "ALMA_CCOR", 
			"ALMA_NUM", "ALMA_DECIMAL", "ALMA_TEXTO", "ALMA_BOOLEANO", "ALMA_ID", 
			"ALMA_WS", "ALMA_COMENTARIO"
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
	public String getGrammarFileName() { return "AlmaLiliaLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AlmaLiliaLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AlmaProgramaContext extends ParserRuleContext {
		public List<AlmaDeclaracionContext> almaDeclaracion() {
			return getRuleContexts(AlmaDeclaracionContext.class);
		}
		public AlmaDeclaracionContext almaDeclaracion(int i) {
			return getRuleContext(AlmaDeclaracionContext.class,i);
		}
		public List<AlmaInstruccionContext> almaInstruccion() {
			return getRuleContexts(AlmaInstruccionContext.class);
		}
		public AlmaInstruccionContext almaInstruccion(int i) {
			return getRuleContext(AlmaInstruccionContext.class,i);
		}
		public AlmaProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_almaPrograma; }
	}

	public final AlmaProgramaContext almaPrograma() throws RecognitionException {
		AlmaProgramaContext _localctx = new AlmaProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_almaPrograma);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 533649687542L) != 0)) {
				{
				setState(48);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ALMA_INT:
				case ALMA_FLOAT:
				case ALMA_BOOLEAN:
				case ALMA_STRING:
					{
					setState(46);
					almaDeclaracion();
					}
					break;
				case T__0:
				case ALMA_SI:
				case ALMA_IMPRIMIR:
				case ALMA_PARA:
				case ALMA_LPAR:
				case ALMA_NUM:
				case ALMA_DECIMAL:
				case ALMA_TEXTO:
				case ALMA_BOOLEANO:
				case ALMA_ID:
					{
					setState(47);
					almaInstruccion();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(52);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AlmaDeclaracionContext extends ParserRuleContext {
		public AlmaTipoContext almaTipo() {
			return getRuleContext(AlmaTipoContext.class,0);
		}
		public TerminalNode ALMA_ID() { return getToken(AlmaLiliaLanguageParser.ALMA_ID, 0); }
		public TerminalNode ALMA_FIN() { return getToken(AlmaLiliaLanguageParser.ALMA_FIN, 0); }
		public TerminalNode ALMA_ASIGNAR() { return getToken(AlmaLiliaLanguageParser.ALMA_ASIGNAR, 0); }
		public AlmaExpresionContext almaExpresion() {
			return getRuleContext(AlmaExpresionContext.class,0);
		}
		public AlmaDeclaracionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_almaDeclaracion; }
	}

	public final AlmaDeclaracionContext almaDeclaracion() throws RecognitionException {
		AlmaDeclaracionContext _localctx = new AlmaDeclaracionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_almaDeclaracion);
		int _la;
		try {
			setState(67);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				almaTipo();
				setState(54);
				match(ALMA_ID);
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ALMA_ASIGNAR) {
					{
					setState(55);
					match(ALMA_ASIGNAR);
					setState(56);
					almaExpresion(0);
					}
				}

				setState(59);
				match(ALMA_FIN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
				almaTipo();
				setState(62);
				match(ALMA_ID);
				setState(63);
				match(ALMA_ASIGNAR);
				setState(64);
				almaExpresion(0);
				setState(65);
				match(ALMA_FIN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AlmaTipoContext extends ParserRuleContext {
		public TerminalNode ALMA_INT() { return getToken(AlmaLiliaLanguageParser.ALMA_INT, 0); }
		public TerminalNode ALMA_FLOAT() { return getToken(AlmaLiliaLanguageParser.ALMA_FLOAT, 0); }
		public TerminalNode ALMA_BOOLEAN() { return getToken(AlmaLiliaLanguageParser.ALMA_BOOLEAN, 0); }
		public TerminalNode ALMA_STRING() { return getToken(AlmaLiliaLanguageParser.ALMA_STRING, 0); }
		public AlmaTipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_almaTipo; }
	}

	public final AlmaTipoContext almaTipo() throws RecognitionException {
		AlmaTipoContext _localctx = new AlmaTipoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_almaTipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 240L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class AlmaInstruccionContext extends ParserRuleContext {
		public AlmaSiContext almaSi() {
			return getRuleContext(AlmaSiContext.class,0);
		}
		public AlmaParaContext almaPara() {
			return getRuleContext(AlmaParaContext.class,0);
		}
		public AlmaAsignarContext almaAsignar() {
			return getRuleContext(AlmaAsignarContext.class,0);
		}
		public TerminalNode ALMA_FIN() { return getToken(AlmaLiliaLanguageParser.ALMA_FIN, 0); }
		public AlmaExpresionContext almaExpresion() {
			return getRuleContext(AlmaExpresionContext.class,0);
		}
		public AlmaIncrementoContext almaIncremento() {
			return getRuleContext(AlmaIncrementoContext.class,0);
		}
		public AlmaImprimirContext almaImprimir() {
			return getRuleContext(AlmaImprimirContext.class,0);
		}
		public AlmaConsolaContext almaConsola() {
			return getRuleContext(AlmaConsolaContext.class,0);
		}
		public AlmaInstruccionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_almaInstruccion; }
	}

	public final AlmaInstruccionContext almaInstruccion() throws RecognitionException {
		AlmaInstruccionContext _localctx = new AlmaInstruccionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_almaInstruccion);
		try {
			setState(88);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				almaSi();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				almaPara();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(73);
				almaAsignar();
				setState(74);
				match(ALMA_FIN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(76);
				almaExpresion(0);
				setState(77);
				match(ALMA_FIN);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(79);
				almaIncremento();
				setState(80);
				match(ALMA_FIN);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(82);
				almaImprimir();
				setState(83);
				match(ALMA_FIN);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(85);
				almaConsola();
				setState(86);
				match(ALMA_FIN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AlmaConsolaContext extends ParserRuleContext {
		public TerminalNode ALMA_LPAR() { return getToken(AlmaLiliaLanguageParser.ALMA_LPAR, 0); }
		public AlmaExpresionContext almaExpresion() {
			return getRuleContext(AlmaExpresionContext.class,0);
		}
		public TerminalNode ALMA_RPAR() { return getToken(AlmaLiliaLanguageParser.ALMA_RPAR, 0); }
		public AlmaConsolaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_almaConsola; }
	}

	public final AlmaConsolaContext almaConsola() throws RecognitionException {
		AlmaConsolaContext _localctx = new AlmaConsolaContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_almaConsola);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(T__0);
			setState(91);
			match(ALMA_LPAR);
			setState(92);
			almaExpresion(0);
			setState(93);
			match(ALMA_RPAR);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AlmaParaContext extends ParserRuleContext {
		public TerminalNode ALMA_PARA() { return getToken(AlmaLiliaLanguageParser.ALMA_PARA, 0); }
		public TerminalNode ALMA_LPAR() { return getToken(AlmaLiliaLanguageParser.ALMA_LPAR, 0); }
		public List<TerminalNode> ALMA_FIN() { return getTokens(AlmaLiliaLanguageParser.ALMA_FIN); }
		public TerminalNode ALMA_FIN(int i) {
			return getToken(AlmaLiliaLanguageParser.ALMA_FIN, i);
		}
		public TerminalNode ALMA_RPAR() { return getToken(AlmaLiliaLanguageParser.ALMA_RPAR, 0); }
		public AlmaBloqueContext almaBloque() {
			return getRuleContext(AlmaBloqueContext.class,0);
		}
		public AlmaDeclaracionContext almaDeclaracion() {
			return getRuleContext(AlmaDeclaracionContext.class,0);
		}
		public List<AlmaAsignarContext> almaAsignar() {
			return getRuleContexts(AlmaAsignarContext.class);
		}
		public AlmaAsignarContext almaAsignar(int i) {
			return getRuleContext(AlmaAsignarContext.class,i);
		}
		public AlmaCondicionContext almaCondicion() {
			return getRuleContext(AlmaCondicionContext.class,0);
		}
		public AlmaIncrementoContext almaIncremento() {
			return getRuleContext(AlmaIncrementoContext.class,0);
		}
		public AlmaParaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_almaPara; }
	}

	public final AlmaParaContext almaPara() throws RecognitionException {
		AlmaParaContext _localctx = new AlmaParaContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_almaPara);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(ALMA_PARA);
			setState(96);
			match(ALMA_LPAR);
			setState(99);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ALMA_INT:
			case ALMA_FLOAT:
			case ALMA_BOOLEAN:
			case ALMA_STRING:
				{
				setState(97);
				almaDeclaracion();
				}
				break;
			case ALMA_ID:
				{
				setState(98);
				almaAsignar();
				}
				break;
			case ALMA_FIN:
				break;
			default:
				break;
			}
			setState(101);
			match(ALMA_FIN);
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 533649686528L) != 0)) {
				{
				setState(102);
				almaCondicion();
				}
			}

			setState(105);
			match(ALMA_FIN);
			setState(108);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(106);
				almaAsignar();
				}
				break;
			case 2:
				{
				setState(107);
				almaIncremento();
				}
				break;
			}
			setState(110);
			match(ALMA_RPAR);
			setState(111);
			almaBloque();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AlmaSiContext extends ParserRuleContext {
		public List<TerminalNode> ALMA_SI() { return getTokens(AlmaLiliaLanguageParser.ALMA_SI); }
		public TerminalNode ALMA_SI(int i) {
			return getToken(AlmaLiliaLanguageParser.ALMA_SI, i);
		}
		public List<TerminalNode> ALMA_LPAR() { return getTokens(AlmaLiliaLanguageParser.ALMA_LPAR); }
		public TerminalNode ALMA_LPAR(int i) {
			return getToken(AlmaLiliaLanguageParser.ALMA_LPAR, i);
		}
		public List<AlmaCondicionContext> almaCondicion() {
			return getRuleContexts(AlmaCondicionContext.class);
		}
		public AlmaCondicionContext almaCondicion(int i) {
			return getRuleContext(AlmaCondicionContext.class,i);
		}
		public List<TerminalNode> ALMA_RPAR() { return getTokens(AlmaLiliaLanguageParser.ALMA_RPAR); }
		public TerminalNode ALMA_RPAR(int i) {
			return getToken(AlmaLiliaLanguageParser.ALMA_RPAR, i);
		}
		public List<AlmaBloqueContext> almaBloque() {
			return getRuleContexts(AlmaBloqueContext.class);
		}
		public AlmaBloqueContext almaBloque(int i) {
			return getRuleContext(AlmaBloqueContext.class,i);
		}
		public List<TerminalNode> ALMA_SINO() { return getTokens(AlmaLiliaLanguageParser.ALMA_SINO); }
		public TerminalNode ALMA_SINO(int i) {
			return getToken(AlmaLiliaLanguageParser.ALMA_SINO, i);
		}
		public AlmaSinoContext almaSino() {
			return getRuleContext(AlmaSinoContext.class,0);
		}
		public AlmaSiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_almaSi; }
	}

	public final AlmaSiContext almaSi() throws RecognitionException {
		AlmaSiContext _localctx = new AlmaSiContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_almaSi);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(ALMA_SI);
			setState(114);
			match(ALMA_LPAR);
			setState(115);
			almaCondicion();
			setState(116);
			match(ALMA_RPAR);
			setState(117);
			almaBloque();
			setState(127);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(118);
					match(ALMA_SINO);
					setState(119);
					match(ALMA_SI);
					setState(120);
					match(ALMA_LPAR);
					setState(121);
					almaCondicion();
					setState(122);
					match(ALMA_RPAR);
					setState(123);
					almaBloque();
					}
					} 
				}
				setState(129);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ALMA_SINO) {
				{
				setState(130);
				almaSino();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AlmaSinoContext extends ParserRuleContext {
		public TerminalNode ALMA_SINO() { return getToken(AlmaLiliaLanguageParser.ALMA_SINO, 0); }
		public AlmaBloqueContext almaBloque() {
			return getRuleContext(AlmaBloqueContext.class,0);
		}
		public AlmaSinoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_almaSino; }
	}

	public final AlmaSinoContext almaSino() throws RecognitionException {
		AlmaSinoContext _localctx = new AlmaSinoContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_almaSino);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(ALMA_SINO);
			setState(134);
			almaBloque();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AlmaBloqueContext extends ParserRuleContext {
		public TerminalNode ALMA_ACOR() { return getToken(AlmaLiliaLanguageParser.ALMA_ACOR, 0); }
		public TerminalNode ALMA_CCOR() { return getToken(AlmaLiliaLanguageParser.ALMA_CCOR, 0); }
		public List<AlmaInstruccionContext> almaInstruccion() {
			return getRuleContexts(AlmaInstruccionContext.class);
		}
		public AlmaInstruccionContext almaInstruccion(int i) {
			return getRuleContext(AlmaInstruccionContext.class,i);
		}
		public AlmaBloqueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_almaBloque; }
	}

	public final AlmaBloqueContext almaBloque() throws RecognitionException {
		AlmaBloqueContext _localctx = new AlmaBloqueContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_almaBloque);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(ALMA_ACOR);
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 533649687302L) != 0)) {
				{
				{
				setState(137);
				almaInstruccion();
				}
				}
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(143);
			match(ALMA_CCOR);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AlmaCondicionContext extends ParserRuleContext {
		public AlmaExpresionContext almaExpresion() {
			return getRuleContext(AlmaExpresionContext.class,0);
		}
		public AlmaCondicionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_almaCondicion; }
	}

	public final AlmaCondicionContext almaCondicion() throws RecognitionException {
		AlmaCondicionContext _localctx = new AlmaCondicionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_almaCondicion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			almaExpresion(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AlmaAsignarContext extends ParserRuleContext {
		public TerminalNode ALMA_ID() { return getToken(AlmaLiliaLanguageParser.ALMA_ID, 0); }
		public TerminalNode ALMA_ASIGNAR() { return getToken(AlmaLiliaLanguageParser.ALMA_ASIGNAR, 0); }
		public AlmaExpresionContext almaExpresion() {
			return getRuleContext(AlmaExpresionContext.class,0);
		}
		public AlmaAsignarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_almaAsignar; }
	}

	public final AlmaAsignarContext almaAsignar() throws RecognitionException {
		AlmaAsignarContext _localctx = new AlmaAsignarContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_almaAsignar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(ALMA_ID);
			setState(148);
			match(ALMA_ASIGNAR);
			setState(149);
			almaExpresion(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AlmaIncrementoContext extends ParserRuleContext {
		public AlmaIncrementoSimpleContext almaIncrementoSimple() {
			return getRuleContext(AlmaIncrementoSimpleContext.class,0);
		}
		public AlmaAsignacionCompuestaContext almaAsignacionCompuesta() {
			return getRuleContext(AlmaAsignacionCompuestaContext.class,0);
		}
		public AlmaIncrementoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_almaIncremento; }
	}

	public final AlmaIncrementoContext almaIncremento() throws RecognitionException {
		AlmaIncrementoContext _localctx = new AlmaIncrementoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_almaIncremento);
		try {
			setState(153);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(151);
				almaIncrementoSimple();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(152);
				almaAsignacionCompuesta();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AlmaIncrementoSimpleContext extends ParserRuleContext {
		public TerminalNode ALMA_ID() { return getToken(AlmaLiliaLanguageParser.ALMA_ID, 0); }
		public TerminalNode ALMA_INC() { return getToken(AlmaLiliaLanguageParser.ALMA_INC, 0); }
		public TerminalNode ALMA_DEC() { return getToken(AlmaLiliaLanguageParser.ALMA_DEC, 0); }
		public AlmaIncrementoSimpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_almaIncrementoSimple; }
	}

	public final AlmaIncrementoSimpleContext almaIncrementoSimple() throws RecognitionException {
		AlmaIncrementoSimpleContext _localctx = new AlmaIncrementoSimpleContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_almaIncrementoSimple);
		try {
			setState(159);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				match(ALMA_ID);
				setState(156);
				match(ALMA_INC);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
				match(ALMA_ID);
				setState(158);
				match(ALMA_DEC);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AlmaAsignacionCompuestaContext extends ParserRuleContext {
		public List<TerminalNode> ALMA_ID() { return getTokens(AlmaLiliaLanguageParser.ALMA_ID); }
		public TerminalNode ALMA_ID(int i) {
			return getToken(AlmaLiliaLanguageParser.ALMA_ID, i);
		}
		public TerminalNode ALMA_ASIGNAR() { return getToken(AlmaLiliaLanguageParser.ALMA_ASIGNAR, 0); }
		public TerminalNode ALMA_ARIT() { return getToken(AlmaLiliaLanguageParser.ALMA_ARIT, 0); }
		public TerminalNode ALMA_NUM() { return getToken(AlmaLiliaLanguageParser.ALMA_NUM, 0); }
		public TerminalNode ALMA_DECIMAL() { return getToken(AlmaLiliaLanguageParser.ALMA_DECIMAL, 0); }
		public AlmaAsignacionCompuestaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_almaAsignacionCompuesta; }
	}

	public final AlmaAsignacionCompuestaContext almaAsignacionCompuesta() throws RecognitionException {
		AlmaAsignacionCompuestaContext _localctx = new AlmaAsignacionCompuestaContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_almaAsignacionCompuesta);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(ALMA_ID);
			setState(162);
			match(ALMA_ASIGNAR);
			setState(163);
			match(ALMA_ID);
			setState(164);
			match(ALMA_ARIT);
			setState(165);
			_la = _input.LA(1);
			if ( !(_la==ALMA_NUM || _la==ALMA_DECIMAL) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class AlmaImprimirContext extends ParserRuleContext {
		public TerminalNode ALMA_IMPRIMIR() { return getToken(AlmaLiliaLanguageParser.ALMA_IMPRIMIR, 0); }
		public TerminalNode ALMA_LPAR() { return getToken(AlmaLiliaLanguageParser.ALMA_LPAR, 0); }
		public TerminalNode ALMA_RPAR() { return getToken(AlmaLiliaLanguageParser.ALMA_RPAR, 0); }
		public AlmaImprimirContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_almaImprimir; }
	}

	public final AlmaImprimirContext almaImprimir() throws RecognitionException {
		AlmaImprimirContext _localctx = new AlmaImprimirContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_almaImprimir);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(ALMA_IMPRIMIR);
			setState(168);
			match(ALMA_LPAR);
			setState(169);
			match(ALMA_RPAR);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AlmaExpresionContext extends ParserRuleContext {
		public AlmaTernarioContext almaTernario() {
			return getRuleContext(AlmaTernarioContext.class,0);
		}
		public List<AlmaExpresionContext> almaExpresion() {
			return getRuleContexts(AlmaExpresionContext.class);
		}
		public AlmaExpresionContext almaExpresion(int i) {
			return getRuleContext(AlmaExpresionContext.class,i);
		}
		public TerminalNode ALMA_SUMA() { return getToken(AlmaLiliaLanguageParser.ALMA_SUMA, 0); }
		public TerminalNode ALMA_ARIT() { return getToken(AlmaLiliaLanguageParser.ALMA_ARIT, 0); }
		public TerminalNode ALMA_MULT() { return getToken(AlmaLiliaLanguageParser.ALMA_MULT, 0); }
		public AlmaExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_almaExpresion; }
	}

	public final AlmaExpresionContext almaExpresion() throws RecognitionException {
		return almaExpresion(0);
	}

	private AlmaExpresionContext almaExpresion(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AlmaExpresionContext _localctx = new AlmaExpresionContext(_ctx, _parentState);
		AlmaExpresionContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_almaExpresion, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(172);
			almaTernario();
			}
			_ctx.stop = _input.LT(-1);
			setState(185);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(183);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new AlmaExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_almaExpresion);
						setState(174);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(175);
						match(ALMA_SUMA);
						setState(176);
						almaExpresion(4);
						}
						break;
					case 2:
						{
						_localctx = new AlmaExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_almaExpresion);
						setState(177);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(178);
						match(ALMA_ARIT);
						setState(179);
						almaExpresion(3);
						}
						break;
					case 3:
						{
						_localctx = new AlmaExpresionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_almaExpresion);
						setState(180);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(181);
						match(ALMA_MULT);
						setState(182);
						almaExpresion(2);
						}
						break;
					}
					} 
				}
				setState(187);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AlmaTernarioContext extends ParserRuleContext {
		public AlmaLogicoContext almaLogico() {
			return getRuleContext(AlmaLogicoContext.class,0);
		}
		public TerminalNode ALMA_TERNARIO() { return getToken(AlmaLiliaLanguageParser.ALMA_TERNARIO, 0); }
		public List<AlmaExpresionContext> almaExpresion() {
			return getRuleContexts(AlmaExpresionContext.class);
		}
		public AlmaExpresionContext almaExpresion(int i) {
			return getRuleContext(AlmaExpresionContext.class,i);
		}
		public TerminalNode ALMA_DOSPUNTOS() { return getToken(AlmaLiliaLanguageParser.ALMA_DOSPUNTOS, 0); }
		public AlmaTernarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_almaTernario; }
	}

	public final AlmaTernarioContext almaTernario() throws RecognitionException {
		AlmaTernarioContext _localctx = new AlmaTernarioContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_almaTernario);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			almaLogico();
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(189);
				match(ALMA_TERNARIO);
				setState(190);
				almaExpresion(0);
				setState(191);
				match(ALMA_DOSPUNTOS);
				setState(192);
				almaExpresion(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AlmaLogicoContext extends ParserRuleContext {
		public List<AlmaIgualdadContext> almaIgualdad() {
			return getRuleContexts(AlmaIgualdadContext.class);
		}
		public AlmaIgualdadContext almaIgualdad(int i) {
			return getRuleContext(AlmaIgualdadContext.class,i);
		}
		public List<TerminalNode> ALMA_Y() { return getTokens(AlmaLiliaLanguageParser.ALMA_Y); }
		public TerminalNode ALMA_Y(int i) {
			return getToken(AlmaLiliaLanguageParser.ALMA_Y, i);
		}
		public List<TerminalNode> ALMA_O() { return getTokens(AlmaLiliaLanguageParser.ALMA_O); }
		public TerminalNode ALMA_O(int i) {
			return getToken(AlmaLiliaLanguageParser.ALMA_O, i);
		}
		public AlmaLogicoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_almaLogico; }
	}

	public final AlmaLogicoContext almaLogico() throws RecognitionException {
		AlmaLogicoContext _localctx = new AlmaLogicoContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_almaLogico);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			almaIgualdad();
			setState(203);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(201);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case ALMA_Y:
						{
						setState(197);
						match(ALMA_Y);
						setState(198);
						almaIgualdad();
						}
						break;
					case ALMA_O:
						{
						setState(199);
						match(ALMA_O);
						setState(200);
						almaIgualdad();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(205);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AlmaIgualdadContext extends ParserRuleContext {
		public List<AlmaRelacionalContext> almaRelacional() {
			return getRuleContexts(AlmaRelacionalContext.class);
		}
		public AlmaRelacionalContext almaRelacional(int i) {
			return getRuleContext(AlmaRelacionalContext.class,i);
		}
		public List<TerminalNode> ALMA_COMP_IGUAL() { return getTokens(AlmaLiliaLanguageParser.ALMA_COMP_IGUAL); }
		public TerminalNode ALMA_COMP_IGUAL(int i) {
			return getToken(AlmaLiliaLanguageParser.ALMA_COMP_IGUAL, i);
		}
		public List<TerminalNode> ALMA_COMP_DIF() { return getTokens(AlmaLiliaLanguageParser.ALMA_COMP_DIF); }
		public TerminalNode ALMA_COMP_DIF(int i) {
			return getToken(AlmaLiliaLanguageParser.ALMA_COMP_DIF, i);
		}
		public AlmaIgualdadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_almaIgualdad; }
	}

	public final AlmaIgualdadContext almaIgualdad() throws RecognitionException {
		AlmaIgualdadContext _localctx = new AlmaIgualdadContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_almaIgualdad);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			almaRelacional();
			setState(213);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(211);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case ALMA_COMP_IGUAL:
						{
						setState(207);
						match(ALMA_COMP_IGUAL);
						setState(208);
						almaRelacional();
						}
						break;
					case ALMA_COMP_DIF:
						{
						setState(209);
						match(ALMA_COMP_DIF);
						setState(210);
						almaRelacional();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(215);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AlmaRelacionalContext extends ParserRuleContext {
		public List<AlmaAditivoContext> almaAditivo() {
			return getRuleContexts(AlmaAditivoContext.class);
		}
		public AlmaAditivoContext almaAditivo(int i) {
			return getRuleContext(AlmaAditivoContext.class,i);
		}
		public List<TerminalNode> ALMA_MAYOR() { return getTokens(AlmaLiliaLanguageParser.ALMA_MAYOR); }
		public TerminalNode ALMA_MAYOR(int i) {
			return getToken(AlmaLiliaLanguageParser.ALMA_MAYOR, i);
		}
		public List<TerminalNode> ALMA_MENOR() { return getTokens(AlmaLiliaLanguageParser.ALMA_MENOR); }
		public TerminalNode ALMA_MENOR(int i) {
			return getToken(AlmaLiliaLanguageParser.ALMA_MENOR, i);
		}
		public List<TerminalNode> ALMA_MAYOR_IGUAL() { return getTokens(AlmaLiliaLanguageParser.ALMA_MAYOR_IGUAL); }
		public TerminalNode ALMA_MAYOR_IGUAL(int i) {
			return getToken(AlmaLiliaLanguageParser.ALMA_MAYOR_IGUAL, i);
		}
		public List<TerminalNode> ALMA_MENOR_IGUAL() { return getTokens(AlmaLiliaLanguageParser.ALMA_MENOR_IGUAL); }
		public TerminalNode ALMA_MENOR_IGUAL(int i) {
			return getToken(AlmaLiliaLanguageParser.ALMA_MENOR_IGUAL, i);
		}
		public AlmaRelacionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_almaRelacional; }
	}

	public final AlmaRelacionalContext almaRelacional() throws RecognitionException {
		AlmaRelacionalContext _localctx = new AlmaRelacionalContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_almaRelacional);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			almaAditivo();
			setState(227);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(225);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case ALMA_MAYOR:
						{
						setState(217);
						match(ALMA_MAYOR);
						setState(218);
						almaAditivo();
						}
						break;
					case ALMA_MENOR:
						{
						setState(219);
						match(ALMA_MENOR);
						setState(220);
						almaAditivo();
						}
						break;
					case ALMA_MAYOR_IGUAL:
						{
						setState(221);
						match(ALMA_MAYOR_IGUAL);
						setState(222);
						almaAditivo();
						}
						break;
					case ALMA_MENOR_IGUAL:
						{
						setState(223);
						match(ALMA_MENOR_IGUAL);
						setState(224);
						almaAditivo();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(229);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AlmaAditivoContext extends ParserRuleContext {
		public List<AlmaMultiplicativoContext> almaMultiplicativo() {
			return getRuleContexts(AlmaMultiplicativoContext.class);
		}
		public AlmaMultiplicativoContext almaMultiplicativo(int i) {
			return getRuleContext(AlmaMultiplicativoContext.class,i);
		}
		public List<TerminalNode> ALMA_ARIT() { return getTokens(AlmaLiliaLanguageParser.ALMA_ARIT); }
		public TerminalNode ALMA_ARIT(int i) {
			return getToken(AlmaLiliaLanguageParser.ALMA_ARIT, i);
		}
		public AlmaAditivoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_almaAditivo; }
	}

	public final AlmaAditivoContext almaAditivo() throws RecognitionException {
		AlmaAditivoContext _localctx = new AlmaAditivoContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_almaAditivo);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			almaMultiplicativo();
			setState(235);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(231);
					match(ALMA_ARIT);
					setState(232);
					almaMultiplicativo();
					}
					} 
				}
				setState(237);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AlmaMultiplicativoContext extends ParserRuleContext {
		public List<AlmaPrimarioContext> almaPrimario() {
			return getRuleContexts(AlmaPrimarioContext.class);
		}
		public AlmaPrimarioContext almaPrimario(int i) {
			return getRuleContext(AlmaPrimarioContext.class,i);
		}
		public List<TerminalNode> ALMA_MULT() { return getTokens(AlmaLiliaLanguageParser.ALMA_MULT); }
		public TerminalNode ALMA_MULT(int i) {
			return getToken(AlmaLiliaLanguageParser.ALMA_MULT, i);
		}
		public List<TerminalNode> ALMA_DIV() { return getTokens(AlmaLiliaLanguageParser.ALMA_DIV); }
		public TerminalNode ALMA_DIV(int i) {
			return getToken(AlmaLiliaLanguageParser.ALMA_DIV, i);
		}
		public List<TerminalNode> ALMA_MOD() { return getTokens(AlmaLiliaLanguageParser.ALMA_MOD); }
		public TerminalNode ALMA_MOD(int i) {
			return getToken(AlmaLiliaLanguageParser.ALMA_MOD, i);
		}
		public AlmaMultiplicativoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_almaMultiplicativo; }
	}

	public final AlmaMultiplicativoContext almaMultiplicativo() throws RecognitionException {
		AlmaMultiplicativoContext _localctx = new AlmaMultiplicativoContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_almaMultiplicativo);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			almaPrimario();
			setState(247);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(245);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case ALMA_MULT:
						{
						setState(239);
						match(ALMA_MULT);
						setState(240);
						almaPrimario();
						}
						break;
					case ALMA_DIV:
						{
						setState(241);
						match(ALMA_DIV);
						setState(242);
						almaPrimario();
						}
						break;
					case ALMA_MOD:
						{
						setState(243);
						match(ALMA_MOD);
						setState(244);
						almaPrimario();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(249);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AlmaPrimarioContext extends ParserRuleContext {
		public TerminalNode ALMA_LPAR() { return getToken(AlmaLiliaLanguageParser.ALMA_LPAR, 0); }
		public AlmaExpresionContext almaExpresion() {
			return getRuleContext(AlmaExpresionContext.class,0);
		}
		public TerminalNode ALMA_RPAR() { return getToken(AlmaLiliaLanguageParser.ALMA_RPAR, 0); }
		public TerminalNode ALMA_ID() { return getToken(AlmaLiliaLanguageParser.ALMA_ID, 0); }
		public TerminalNode ALMA_NUM() { return getToken(AlmaLiliaLanguageParser.ALMA_NUM, 0); }
		public TerminalNode ALMA_DECIMAL() { return getToken(AlmaLiliaLanguageParser.ALMA_DECIMAL, 0); }
		public TerminalNode ALMA_TEXTO() { return getToken(AlmaLiliaLanguageParser.ALMA_TEXTO, 0); }
		public TerminalNode ALMA_BOOLEANO() { return getToken(AlmaLiliaLanguageParser.ALMA_BOOLEANO, 0); }
		public AlmaPrimarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_almaPrimario; }
	}

	public final AlmaPrimarioContext almaPrimario() throws RecognitionException {
		AlmaPrimarioContext _localctx = new AlmaPrimarioContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_almaPrimario);
		try {
			setState(259);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ALMA_LPAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(250);
				match(ALMA_LPAR);
				setState(251);
				almaExpresion(0);
				setState(252);
				match(ALMA_RPAR);
				}
				break;
			case ALMA_ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(254);
				match(ALMA_ID);
				}
				break;
			case ALMA_NUM:
				enterOuterAlt(_localctx, 3);
				{
				setState(255);
				match(ALMA_NUM);
				}
				break;
			case ALMA_DECIMAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(256);
				match(ALMA_DECIMAL);
				}
				break;
			case ALMA_TEXTO:
				enterOuterAlt(_localctx, 5);
				{
				setState(257);
				match(ALMA_TEXTO);
				}
				break;
			case ALMA_BOOLEANO:
				enterOuterAlt(_localctx, 6);
				{
				setState(258);
				match(ALMA_BOOLEANO);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 15:
			return almaExpresion_sempred((AlmaExpresionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean almaExpresion_sempred(AlmaExpresionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001(\u0106\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0001\u0000\u0001\u0000\u0005\u00001\b\u0000"+
		"\n\u0000\f\u00004\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001:\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001D\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003Y\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u0005d\b\u0005\u0001\u0005\u0001\u0005\u0003\u0005h\b\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0003\u0005m\b\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0005\u0006~\b\u0006\n\u0006\f\u0006\u0081\t\u0006"+
		"\u0001\u0006\u0003\u0006\u0084\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0005\b\u008b\b\b\n\b\f\b\u008e\t\b\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u009a\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u00a0\b\f"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0005\u000f\u00b8\b\u000f\n\u000f\f\u000f\u00bb"+
		"\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0003\u0010\u00c3\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0005\u0011\u00ca\b\u0011\n\u0011\f\u0011\u00cd\t\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012"+
		"\u00d4\b\u0012\n\u0012\f\u0012\u00d7\t\u0012\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0005\u0013\u00e2\b\u0013\n\u0013\f\u0013\u00e5\t\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0005\u0014\u00ea\b\u0014\n\u0014\f\u0014\u00ed"+
		"\t\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0005\u0015\u00f6\b\u0015\n\u0015\f\u0015\u00f9\t\u0015"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u0104\b\u0016\u0001\u0016"+
		"\u0000\u0001\u001e\u0017\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,\u0000\u0002\u0001\u0000\u0004"+
		"\u0007\u0001\u0000\"#\u0117\u00002\u0001\u0000\u0000\u0000\u0002C\u0001"+
		"\u0000\u0000\u0000\u0004E\u0001\u0000\u0000\u0000\u0006X\u0001\u0000\u0000"+
		"\u0000\bZ\u0001\u0000\u0000\u0000\n_\u0001\u0000\u0000\u0000\fq\u0001"+
		"\u0000\u0000\u0000\u000e\u0085\u0001\u0000\u0000\u0000\u0010\u0088\u0001"+
		"\u0000\u0000\u0000\u0012\u0091\u0001\u0000\u0000\u0000\u0014\u0093\u0001"+
		"\u0000\u0000\u0000\u0016\u0099\u0001\u0000\u0000\u0000\u0018\u009f\u0001"+
		"\u0000\u0000\u0000\u001a\u00a1\u0001\u0000\u0000\u0000\u001c\u00a7\u0001"+
		"\u0000\u0000\u0000\u001e\u00ab\u0001\u0000\u0000\u0000 \u00bc\u0001\u0000"+
		"\u0000\u0000\"\u00c4\u0001\u0000\u0000\u0000$\u00ce\u0001\u0000\u0000"+
		"\u0000&\u00d8\u0001\u0000\u0000\u0000(\u00e6\u0001\u0000\u0000\u0000*"+
		"\u00ee\u0001\u0000\u0000\u0000,\u0103\u0001\u0000\u0000\u0000.1\u0003"+
		"\u0002\u0001\u0000/1\u0003\u0006\u0003\u00000.\u0001\u0000\u0000\u0000"+
		"0/\u0001\u0000\u0000\u000014\u0001\u0000\u0000\u000020\u0001\u0000\u0000"+
		"\u000023\u0001\u0000\u0000\u00003\u0001\u0001\u0000\u0000\u000042\u0001"+
		"\u0000\u0000\u000056\u0003\u0004\u0002\u000069\u0005&\u0000\u000078\u0005"+
		"\n\u0000\u00008:\u0003\u001e\u000f\u000097\u0001\u0000\u0000\u00009:\u0001"+
		"\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;<\u0005\u001d\u0000\u0000"+
		"<D\u0001\u0000\u0000\u0000=>\u0003\u0004\u0002\u0000>?\u0005&\u0000\u0000"+
		"?@\u0005\n\u0000\u0000@A\u0003\u001e\u000f\u0000AB\u0005\u001d\u0000\u0000"+
		"BD\u0001\u0000\u0000\u0000C5\u0001\u0000\u0000\u0000C=\u0001\u0000\u0000"+
		"\u0000D\u0003\u0001\u0000\u0000\u0000EF\u0007\u0000\u0000\u0000F\u0005"+
		"\u0001\u0000\u0000\u0000GY\u0003\f\u0006\u0000HY\u0003\n\u0005\u0000I"+
		"J\u0003\u0014\n\u0000JK\u0005\u001d\u0000\u0000KY\u0001\u0000\u0000\u0000"+
		"LM\u0003\u001e\u000f\u0000MN\u0005\u001d\u0000\u0000NY\u0001\u0000\u0000"+
		"\u0000OP\u0003\u0016\u000b\u0000PQ\u0005\u001d\u0000\u0000QY\u0001\u0000"+
		"\u0000\u0000RS\u0003\u001c\u000e\u0000ST\u0005\u001d\u0000\u0000TY\u0001"+
		"\u0000\u0000\u0000UV\u0003\b\u0004\u0000VW\u0005\u001d\u0000\u0000WY\u0001"+
		"\u0000\u0000\u0000XG\u0001\u0000\u0000\u0000XH\u0001\u0000\u0000\u0000"+
		"XI\u0001\u0000\u0000\u0000XL\u0001\u0000\u0000\u0000XO\u0001\u0000\u0000"+
		"\u0000XR\u0001\u0000\u0000\u0000XU\u0001\u0000\u0000\u0000Y\u0007\u0001"+
		"\u0000\u0000\u0000Z[\u0005\u0001\u0000\u0000[\\\u0005\u001e\u0000\u0000"+
		"\\]\u0003\u001e\u000f\u0000]^\u0005\u001f\u0000\u0000^\t\u0001\u0000\u0000"+
		"\u0000_`\u0005\t\u0000\u0000`c\u0005\u001e\u0000\u0000ad\u0003\u0002\u0001"+
		"\u0000bd\u0003\u0014\n\u0000ca\u0001\u0000\u0000\u0000cb\u0001\u0000\u0000"+
		"\u0000cd\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000eg\u0005\u001d"+
		"\u0000\u0000fh\u0003\u0012\t\u0000gf\u0001\u0000\u0000\u0000gh\u0001\u0000"+
		"\u0000\u0000hi\u0001\u0000\u0000\u0000il\u0005\u001d\u0000\u0000jm\u0003"+
		"\u0014\n\u0000km\u0003\u0016\u000b\u0000lj\u0001\u0000\u0000\u0000lk\u0001"+
		"\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000"+
		"no\u0005\u001f\u0000\u0000op\u0003\u0010\b\u0000p\u000b\u0001\u0000\u0000"+
		"\u0000qr\u0005\u0002\u0000\u0000rs\u0005\u001e\u0000\u0000st\u0003\u0012"+
		"\t\u0000tu\u0005\u001f\u0000\u0000u\u007f\u0003\u0010\b\u0000vw\u0005"+
		"\u0003\u0000\u0000wx\u0005\u0002\u0000\u0000xy\u0005\u001e\u0000\u0000"+
		"yz\u0003\u0012\t\u0000z{\u0005\u001f\u0000\u0000{|\u0003\u0010\b\u0000"+
		"|~\u0001\u0000\u0000\u0000}v\u0001\u0000\u0000\u0000~\u0081\u0001\u0000"+
		"\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000"+
		"\u0000\u0080\u0083\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000"+
		"\u0000\u0082\u0084\u0003\u000e\u0007\u0000\u0083\u0082\u0001\u0000\u0000"+
		"\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084\r\u0001\u0000\u0000\u0000"+
		"\u0085\u0086\u0005\u0003\u0000\u0000\u0086\u0087\u0003\u0010\b\u0000\u0087"+
		"\u000f\u0001\u0000\u0000\u0000\u0088\u008c\u0005 \u0000\u0000\u0089\u008b"+
		"\u0003\u0006\u0003\u0000\u008a\u0089\u0001\u0000\u0000\u0000\u008b\u008e"+
		"\u0001\u0000\u0000\u0000\u008c\u008a\u0001\u0000\u0000\u0000\u008c\u008d"+
		"\u0001\u0000\u0000\u0000\u008d\u008f\u0001\u0000\u0000\u0000\u008e\u008c"+
		"\u0001\u0000\u0000\u0000\u008f\u0090\u0005!\u0000\u0000\u0090\u0011\u0001"+
		"\u0000\u0000\u0000\u0091\u0092\u0003\u001e\u000f\u0000\u0092\u0013\u0001"+
		"\u0000\u0000\u0000\u0093\u0094\u0005&\u0000\u0000\u0094\u0095\u0005\n"+
		"\u0000\u0000\u0095\u0096\u0003\u001e\u000f\u0000\u0096\u0015\u0001\u0000"+
		"\u0000\u0000\u0097\u009a\u0003\u0018\f\u0000\u0098\u009a\u0003\u001a\r"+
		"\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u0099\u0098\u0001\u0000\u0000"+
		"\u0000\u009a\u0017\u0001\u0000\u0000\u0000\u009b\u009c\u0005&\u0000\u0000"+
		"\u009c\u00a0\u0005\u0018\u0000\u0000\u009d\u009e\u0005&\u0000\u0000\u009e"+
		"\u00a0\u0005\u0019\u0000\u0000\u009f\u009b\u0001\u0000\u0000\u0000\u009f"+
		"\u009d\u0001\u0000\u0000\u0000\u00a0\u0019\u0001\u0000\u0000\u0000\u00a1"+
		"\u00a2\u0005&\u0000\u0000\u00a2\u00a3\u0005\n\u0000\u0000\u00a3\u00a4"+
		"\u0005&\u0000\u0000\u00a4\u00a5\u0005\u001c\u0000\u0000\u00a5\u00a6\u0007"+
		"\u0001\u0000\u0000\u00a6\u001b\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005"+
		"\b\u0000\u0000\u00a8\u00a9\u0005\u001e\u0000\u0000\u00a9\u00aa\u0005\u001f"+
		"\u0000\u0000\u00aa\u001d\u0001\u0000\u0000\u0000\u00ab\u00ac\u0006\u000f"+
		"\uffff\uffff\u0000\u00ac\u00ad\u0003 \u0010\u0000\u00ad\u00b9\u0001\u0000"+
		"\u0000\u0000\u00ae\u00af\n\u0003\u0000\u0000\u00af\u00b0\u0005\u0011\u0000"+
		"\u0000\u00b0\u00b8\u0003\u001e\u000f\u0004\u00b1\u00b2\n\u0002\u0000\u0000"+
		"\u00b2\u00b3\u0005\u001c\u0000\u0000\u00b3\u00b8\u0003\u001e\u000f\u0003"+
		"\u00b4\u00b5\n\u0001\u0000\u0000\u00b5\u00b6\u0005\u0013\u0000\u0000\u00b6"+
		"\u00b8\u0003\u001e\u000f\u0002\u00b7\u00ae\u0001\u0000\u0000\u0000\u00b7"+
		"\u00b1\u0001\u0000\u0000\u0000\u00b7\u00b4\u0001\u0000\u0000\u0000\u00b8"+
		"\u00bb\u0001\u0000\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000\u00b9"+
		"\u00ba\u0001\u0000\u0000\u0000\u00ba\u001f\u0001\u0000\u0000\u0000\u00bb"+
		"\u00b9\u0001\u0000\u0000\u0000\u00bc\u00c2\u0003\"\u0011\u0000\u00bd\u00be"+
		"\u0005\u001a\u0000\u0000\u00be\u00bf\u0003\u001e\u000f\u0000\u00bf\u00c0"+
		"\u0005\u001b\u0000\u0000\u00c0\u00c1\u0003\u001e\u000f\u0000\u00c1\u00c3"+
		"\u0001\u0000\u0000\u0000\u00c2\u00bd\u0001\u0000\u0000\u0000\u00c2\u00c3"+
		"\u0001\u0000\u0000\u0000\u00c3!\u0001\u0000\u0000\u0000\u00c4\u00cb\u0003"+
		"$\u0012\u0000\u00c5\u00c6\u0005\u0016\u0000\u0000\u00c6\u00ca\u0003$\u0012"+
		"\u0000\u00c7\u00c8\u0005\u0017\u0000\u0000\u00c8\u00ca\u0003$\u0012\u0000"+
		"\u00c9\u00c5\u0001\u0000\u0000\u0000\u00c9\u00c7\u0001\u0000\u0000\u0000"+
		"\u00ca\u00cd\u0001\u0000\u0000\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000"+
		"\u00cb\u00cc\u0001\u0000\u0000\u0000\u00cc#\u0001\u0000\u0000\u0000\u00cd"+
		"\u00cb\u0001\u0000\u0000\u0000\u00ce\u00d5\u0003&\u0013\u0000\u00cf\u00d0"+
		"\u0005\u000b\u0000\u0000\u00d0\u00d4\u0003&\u0013\u0000\u00d1\u00d2\u0005"+
		"\f\u0000\u0000\u00d2\u00d4\u0003&\u0013\u0000\u00d3\u00cf\u0001\u0000"+
		"\u0000\u0000\u00d3\u00d1\u0001\u0000\u0000\u0000\u00d4\u00d7\u0001\u0000"+
		"\u0000\u0000\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000"+
		"\u0000\u0000\u00d6%\u0001\u0000\u0000\u0000\u00d7\u00d5\u0001\u0000\u0000"+
		"\u0000\u00d8\u00e3\u0003(\u0014\u0000\u00d9\u00da\u0005\u0010\u0000\u0000"+
		"\u00da\u00e2\u0003(\u0014\u0000\u00db\u00dc\u0005\u000f\u0000\u0000\u00dc"+
		"\u00e2\u0003(\u0014\u0000\u00dd\u00de\u0005\r\u0000\u0000\u00de\u00e2"+
		"\u0003(\u0014\u0000\u00df\u00e0\u0005\u000e\u0000\u0000\u00e0\u00e2\u0003"+
		"(\u0014\u0000\u00e1\u00d9\u0001\u0000\u0000\u0000\u00e1\u00db\u0001\u0000"+
		"\u0000\u0000\u00e1\u00dd\u0001\u0000\u0000\u0000\u00e1\u00df\u0001\u0000"+
		"\u0000\u0000\u00e2\u00e5\u0001\u0000\u0000\u0000\u00e3\u00e1\u0001\u0000"+
		"\u0000\u0000\u00e3\u00e4\u0001\u0000\u0000\u0000\u00e4\'\u0001\u0000\u0000"+
		"\u0000\u00e5\u00e3\u0001\u0000\u0000\u0000\u00e6\u00eb\u0003*\u0015\u0000"+
		"\u00e7\u00e8\u0005\u001c\u0000\u0000\u00e8\u00ea\u0003*\u0015\u0000\u00e9"+
		"\u00e7\u0001\u0000\u0000\u0000\u00ea\u00ed\u0001\u0000\u0000\u0000\u00eb"+
		"\u00e9\u0001\u0000\u0000\u0000\u00eb\u00ec\u0001\u0000\u0000\u0000\u00ec"+
		")\u0001\u0000\u0000\u0000\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ee\u00f7"+
		"\u0003,\u0016\u0000\u00ef\u00f0\u0005\u0013\u0000\u0000\u00f0\u00f6\u0003"+
		",\u0016\u0000\u00f1\u00f2\u0005\u0014\u0000\u0000\u00f2\u00f6\u0003,\u0016"+
		"\u0000\u00f3\u00f4\u0005\u0015\u0000\u0000\u00f4\u00f6\u0003,\u0016\u0000"+
		"\u00f5\u00ef\u0001\u0000\u0000\u0000\u00f5\u00f1\u0001\u0000\u0000\u0000"+
		"\u00f5\u00f3\u0001\u0000\u0000\u0000\u00f6\u00f9\u0001\u0000\u0000\u0000"+
		"\u00f7\u00f5\u0001\u0000\u0000\u0000\u00f7\u00f8\u0001\u0000\u0000\u0000"+
		"\u00f8+\u0001\u0000\u0000\u0000\u00f9\u00f7\u0001\u0000\u0000\u0000\u00fa"+
		"\u00fb\u0005\u001e\u0000\u0000\u00fb\u00fc\u0003\u001e\u000f\u0000\u00fc"+
		"\u00fd\u0005\u001f\u0000\u0000\u00fd\u0104\u0001\u0000\u0000\u0000\u00fe"+
		"\u0104\u0005&\u0000\u0000\u00ff\u0104\u0005\"\u0000\u0000\u0100\u0104"+
		"\u0005#\u0000\u0000\u0101\u0104\u0005$\u0000\u0000\u0102\u0104\u0005%"+
		"\u0000\u0000\u0103\u00fa\u0001\u0000\u0000\u0000\u0103\u00fe\u0001\u0000"+
		"\u0000\u0000\u0103\u00ff\u0001\u0000\u0000\u0000\u0103\u0100\u0001\u0000"+
		"\u0000\u0000\u0103\u0101\u0001\u0000\u0000\u0000\u0103\u0102\u0001\u0000"+
		"\u0000\u0000\u0104-\u0001\u0000\u0000\u0000\u001a029CXcgl\u007f\u0083"+
		"\u008c\u0099\u009f\u00b7\u00b9\u00c2\u00c9\u00cb\u00d3\u00d5\u00e1\u00e3"+
		"\u00eb\u00f5\u00f7\u0103";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}