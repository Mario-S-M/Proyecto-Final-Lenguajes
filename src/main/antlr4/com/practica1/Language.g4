grammar Language;

// Parser Rules
almaPrograma
    : (almaDeclaracion | almaInstruccion)*
    ;

almaDeclaracion
    : almaTipo ALMA_ID ('=' almaExpresion)? ALMA_FIN
    | almaTipo ALMA_ID '=' almaExpresion ALMA_FIN
    ;

almaTipo
    : ALMA_INT
    | ALMA_FLOAT
    | ALMA_BOOLEAN
    | ALMA_STRING
    ;

almaInstruccion
    : almaSi
    | almaPara
    | almaAsignar ALMA_FIN
    | almaExpresion ALMA_FIN
    | almaIncremento ALMA_FIN
    | almaImprimir ALMA_FIN
    | almaConsola ALMA_FIN 
    ;

almaConsola
    : 'AlmaLilia.consola' ALMA_LPAR almaExpresion ALMA_RPAR
    ;

almaPara
    : ALMA_PARA ALMA_LPAR (almaDeclaracion | almaAsignar)? ALMA_FIN almaCondicion? ALMA_FIN (almaAsignar | almaIncremento)? ALMA_RPAR almaBloque
    ;

almaSi
    : ALMA_SI ALMA_LPAR almaCondicion ALMA_RPAR almaBloque
    (ALMA_SINO ALMA_SI ALMA_LPAR almaCondicion ALMA_RPAR almaBloque)*
    (almaSino)?
    ;

almaSino
    : ALMA_SINO almaBloque
    ;

almaBloque
    : ALMA_ACOR almaInstruccion* ALMA_CCOR
    ;

almaCondicion
    : almaExpresion
    ;

almaAsignar
    : ALMA_ID ALMA_ASIGNAR almaExpresion
    ;

almaIncremento
    : almaIncrementoSimple
    | almaAsignacionCompuesta
    ;

almaIncrementoSimple
    : ALMA_ID ALMA_INC
    | ALMA_ID ALMA_DEC
    ;

almaAsignacionCompuesta
    : ALMA_ID ALMA_ASIGNAR ALMA_ID ALMA_ARIT (ALMA_NUM | ALMA_DECIMAL)
    ;

almaImprimir
    : ALMA_IMPRIMIR ALMA_LPAR ALMA_RPAR
    ;

almaExpresion
    : almaTernario
    | almaExpresion ALMA_SUMA almaExpresion
    | almaExpresion ALMA_ARIT almaExpresion
    | almaExpresion ALMA_MULT almaExpresion
    ;

almaTernario
    : almaLogico (ALMA_TERNARIO almaExpresion ALMA_DOSPUNTOS almaExpresion)?
    ;

almaLogico
    : almaIgualdad (ALMA_Y almaIgualdad | ALMA_O almaIgualdad)*
    ;

almaIgualdad
    : almaRelacional (ALMA_COMP_IGUAL almaRelacional | ALMA_COMP_DIF almaRelacional)*
    ;

almaRelacional
    : almaAditivo (ALMA_MAYOR almaAditivo | ALMA_MENOR almaAditivo | ALMA_MAYOR_IGUAL almaAditivo | ALMA_MENOR_IGUAL almaAditivo)*
    ;

almaAditivo
    : almaMultiplicativo (ALMA_ARIT almaMultiplicativo)*
    ;

almaMultiplicativo
    : almaPrimario (ALMA_MULT almaPrimario | ALMA_DIV almaPrimario | ALMA_MOD almaPrimario)*
    ;

almaPrimario
    : ALMA_LPAR almaExpresion ALMA_RPAR
    | ALMA_ID
    | ALMA_NUM
    | ALMA_DECIMAL
    | ALMA_TEXTO
    | ALMA_BOOLEANO
    ;

// Lexer Rules
ALMA_SI: 'AlmaLilia.si';
ALMA_SINO: 'AlmaLilia.sino';
ALMA_INT: 'AlmaLilia.complete';
ALMA_FLOAT: 'AlmaLilia.cacho';
ALMA_BOOLEAN: 'AlmaLilia.pregunta';
ALMA_STRING: 'AlmaLilia.cadena';
ALMA_IMPRIMIR: 'AlmaLilia.imprimir';
ALMA_PARA: 'AlmaLilia.para';

ALMA_ASIGNAR: '=';
ALMA_COMP_IGUAL: '==';
ALMA_COMP_DIF: '!=';
ALMA_MAYOR_IGUAL: '>=';
ALMA_MENOR_IGUAL: '<=';
ALMA_MENOR: '<';
ALMA_MAYOR: '>';
ALMA_SUMA: '+';
ALMA_REST: '-';
ALMA_MULT: '*';
ALMA_DIV: '/';
ALMA_MOD: '%';
ALMA_Y: '&&';
ALMA_O: '||';
ALMA_INC: '++';
ALMA_DEC: '--';
ALMA_TERNARIO: '?';
ALMA_DOSPUNTOS: ':';
ALMA_ARIT: '+' | '-';

ALMA_FIN: ';';
ALMA_LPAR: '(';
ALMA_RPAR: ')';
ALMA_ACOR: '{';
ALMA_CCOR: '}';

ALMA_NUM: [0-9]+;
ALMA_DECIMAL: [0-9]+ '.' [0-9]+;
ALMA_TEXTO: '"' .*? '"';
ALMA_BOOLEANO: 'AlmaLilia.verdadero' | 'AlmaLilia.falso';
ALMA_ID: [a-zA-Z_][a-zA-Z_0-9]*;

ALMA_WS: [ \t\n\r\f]+ -> skip;
ALMA_COMENTARIO: '//' .*? '\n' -> skip;