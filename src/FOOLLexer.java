// Generated from FOOL.g4 by ANTLR 4.7.1

import java.util.ArrayList;
import java.util.HashMap;
import ast.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FOOLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COLON=1, COMMA=2, ASS=3, SEMIC=4, EQ=5, PLUS=6, TIMES=7, INTEGER=8, TRUE=9, 
		FALSE=10, LPAR=11, RPAR=12, CLPAR=13, CRPAR=14, IF=15, THEN=16, ELSE=17, 
		PRINT=18, LET=19, IN=20, VAR=21, FUN=22, INT=23, BOOL=24, ID=25, WHITESP=26, 
		COMMENT=27, ERR=28;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"COLON", "COMMA", "ASS", "SEMIC", "EQ", "PLUS", "TIMES", "INTEGER", "TRUE", 
		"FALSE", "LPAR", "RPAR", "CLPAR", "CRPAR", "IF", "THEN", "ELSE", "PRINT", 
		"LET", "IN", "VAR", "FUN", "INT", "BOOL", "ID", "WHITESP", "COMMENT", 
		"ERR"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "':'", "','", "'='", "';'", "'=='", "'+'", "'*'", null, "'true'", 
		"'false'", "'('", "')'", "'{'", "'}'", "'if'", "'then'", "'else'", "'print'", 
		"'let'", "'in'", "'var'", "'fun'", "'int'", "'bool'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "COLON", "COMMA", "ASS", "SEMIC", "EQ", "PLUS", "TIMES", "INTEGER", 
		"TRUE", "FALSE", "LPAR", "RPAR", "CLPAR", "CRPAR", "IF", "THEN", "ELSE", 
		"PRINT", "LET", "IN", "VAR", "FUN", "INT", "BOOL", "ID", "WHITESP", "COMMENT", 
		"ERR"
	};
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


	int lexicalErrors=0;


	public FOOLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FOOL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 27:
			ERR_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void ERR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 System.out.println("Invalid char: "+ getText()); lexicalErrors++; 
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\36\u00b6\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\5\tL\n\t\3\t\3\t\7\tP\n\t\f\t"+
		"\16\tS\13\t\3\t\5\tV\n\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24"+
		"\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\7\32\u0098\n\32"+
		"\f\32\16\32\u009b\13\32\3\33\6\33\u009e\n\33\r\33\16\33\u009f\3\33\3\33"+
		"\3\34\3\34\3\34\3\34\7\34\u00a8\n\34\f\34\16\34\u00ab\13\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\u00a9\2\36\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24"+
		"\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36\3\2\5\4\2C\\c|\5\2\62"+
		";C\\c|\5\2\13\f\17\17\"\"\2\u00bb\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2"+
		"\2\2\2\67\3\2\2\2\29\3\2\2\2\3;\3\2\2\2\5=\3\2\2\2\7?\3\2\2\2\tA\3\2\2"+
		"\2\13C\3\2\2\2\rF\3\2\2\2\17H\3\2\2\2\21U\3\2\2\2\23W\3\2\2\2\25\\\3\2"+
		"\2\2\27b\3\2\2\2\31d\3\2\2\2\33f\3\2\2\2\35h\3\2\2\2\37j\3\2\2\2!m\3\2"+
		"\2\2#r\3\2\2\2%w\3\2\2\2\'}\3\2\2\2)\u0081\3\2\2\2+\u0084\3\2\2\2-\u0088"+
		"\3\2\2\2/\u008c\3\2\2\2\61\u0090\3\2\2\2\63\u0095\3\2\2\2\65\u009d\3\2"+
		"\2\2\67\u00a3\3\2\2\29\u00b1\3\2\2\2;<\7<\2\2<\4\3\2\2\2=>\7.\2\2>\6\3"+
		"\2\2\2?@\7?\2\2@\b\3\2\2\2AB\7=\2\2B\n\3\2\2\2CD\7?\2\2DE\7?\2\2E\f\3"+
		"\2\2\2FG\7-\2\2G\16\3\2\2\2HI\7,\2\2I\20\3\2\2\2JL\7/\2\2KJ\3\2\2\2KL"+
		"\3\2\2\2LM\3\2\2\2MQ\4\63;\2NP\4\62;\2ON\3\2\2\2PS\3\2\2\2QO\3\2\2\2Q"+
		"R\3\2\2\2RV\3\2\2\2SQ\3\2\2\2TV\7\62\2\2UK\3\2\2\2UT\3\2\2\2V\22\3\2\2"+
		"\2WX\7v\2\2XY\7t\2\2YZ\7w\2\2Z[\7g\2\2[\24\3\2\2\2\\]\7h\2\2]^\7c\2\2"+
		"^_\7n\2\2_`\7u\2\2`a\7g\2\2a\26\3\2\2\2bc\7*\2\2c\30\3\2\2\2de\7+\2\2"+
		"e\32\3\2\2\2fg\7}\2\2g\34\3\2\2\2hi\7\177\2\2i\36\3\2\2\2jk\7k\2\2kl\7"+
		"h\2\2l \3\2\2\2mn\7v\2\2no\7j\2\2op\7g\2\2pq\7p\2\2q\"\3\2\2\2rs\7g\2"+
		"\2st\7n\2\2tu\7u\2\2uv\7g\2\2v$\3\2\2\2wx\7r\2\2xy\7t\2\2yz\7k\2\2z{\7"+
		"p\2\2{|\7v\2\2|&\3\2\2\2}~\7n\2\2~\177\7g\2\2\177\u0080\7v\2\2\u0080("+
		"\3\2\2\2\u0081\u0082\7k\2\2\u0082\u0083\7p\2\2\u0083*\3\2\2\2\u0084\u0085"+
		"\7x\2\2\u0085\u0086\7c\2\2\u0086\u0087\7t\2\2\u0087,\3\2\2\2\u0088\u0089"+
		"\7h\2\2\u0089\u008a\7w\2\2\u008a\u008b\7p\2\2\u008b.\3\2\2\2\u008c\u008d"+
		"\7k\2\2\u008d\u008e\7p\2\2\u008e\u008f\7v\2\2\u008f\60\3\2\2\2\u0090\u0091"+
		"\7d\2\2\u0091\u0092\7q\2\2\u0092\u0093\7q\2\2\u0093\u0094\7n\2\2\u0094"+
		"\62\3\2\2\2\u0095\u0099\t\2\2\2\u0096\u0098\t\3\2\2\u0097\u0096\3\2\2"+
		"\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\64"+
		"\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u009e\t\4\2\2\u009d\u009c\3\2\2\2\u009e"+
		"\u009f\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\3\2"+
		"\2\2\u00a1\u00a2\b\33\2\2\u00a2\66\3\2\2\2\u00a3\u00a4\7\61\2\2\u00a4"+
		"\u00a5\7,\2\2\u00a5\u00a9\3\2\2\2\u00a6\u00a8\13\2\2\2\u00a7\u00a6\3\2"+
		"\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00aa\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa"+
		"\u00ac\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00ad\7,\2\2\u00ad\u00ae\7\61"+
		"\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\b\34\2\2\u00b08\3\2\2\2\u00b1\u00b2"+
		"\13\2\2\2\u00b2\u00b3\b\35\3\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\b\35\2"+
		"\2\u00b5:\3\2\2\2\t\2KQU\u0099\u009f\u00a9\4\2\3\2\3\35\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}