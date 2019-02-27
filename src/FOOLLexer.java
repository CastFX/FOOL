// Generated from FOOL.g4 by ANTLR 4.4

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
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COLON=1, COMMA=2, ASS=3, SEMIC=4, EQ=5, PLUS=6, TIMES=7, INTEGER=8, TRUE=9, 
		FALSE=10, LPAR=11, RPAR=12, CLPAR=13, CRPAR=14, IF=15, THEN=16, ELSE=17, 
		PRINT=18, LET=19, IN=20, VAR=21, FUN=22, CLASS=23, EXT=24, NEW=25, INT=26, 
		BOOL=27, ID=28, WHITESP=29, COMMENT=30, ERR=31;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'"
	};
	public static final String[] ruleNames = {
		"COLON", "COMMA", "ASS", "SEMIC", "EQ", "PLUS", "TIMES", "INTEGER", "TRUE", 
		"FALSE", "LPAR", "RPAR", "CLPAR", "CRPAR", "IF", "THEN", "ELSE", "PRINT", 
		"LET", "IN", "VAR", "FUN", "CLASS", "EXT", "NEW", "INT", "BOOL", "ID", 
		"WHITESP", "COMMENT", "ERR"
	};


	int lexicalErrors=0;


	public FOOLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FOOL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 30: ERR_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void ERR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:  System.out.println("Invalid char: "+ getText()); lexicalErrors++;  break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2!\u00ce\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\5\tR\n\t"+
		"\3\t\3\t\7\tV\n\t\f\t\16\tY\13\t\3\t\5\t\\\n\t\3\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26"+
		"\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34"+
		"\3\34\3\34\3\34\3\35\3\35\7\35\u00b0\n\35\f\35\16\35\u00b3\13\35\3\36"+
		"\6\36\u00b6\n\36\r\36\16\36\u00b7\3\36\3\36\3\37\3\37\3\37\3\37\7\37\u00c0"+
		"\n\37\f\37\16\37\u00c3\13\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3"+
		"\u00c1\2!\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!\3\2\5\4\2C\\c|\5\2\62;C\\c|\5\2\13\f\17\17\"\"\u00d3\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2"+
		"\2\2\2=\3\2\2\2\2?\3\2\2\2\3A\3\2\2\2\5C\3\2\2\2\7E\3\2\2\2\tG\3\2\2\2"+
		"\13I\3\2\2\2\rL\3\2\2\2\17N\3\2\2\2\21[\3\2\2\2\23]\3\2\2\2\25b\3\2\2"+
		"\2\27h\3\2\2\2\31j\3\2\2\2\33l\3\2\2\2\35n\3\2\2\2\37p\3\2\2\2!s\3\2\2"+
		"\2#x\3\2\2\2%}\3\2\2\2\'\u0083\3\2\2\2)\u0087\3\2\2\2+\u008a\3\2\2\2-"+
		"\u008e\3\2\2\2/\u0092\3\2\2\2\61\u0098\3\2\2\2\63\u00a0\3\2\2\2\65\u00a4"+
		"\3\2\2\2\67\u00a8\3\2\2\29\u00ad\3\2\2\2;\u00b5\3\2\2\2=\u00bb\3\2\2\2"+
		"?\u00c9\3\2\2\2AB\7<\2\2B\4\3\2\2\2CD\7.\2\2D\6\3\2\2\2EF\7?\2\2F\b\3"+
		"\2\2\2GH\7=\2\2H\n\3\2\2\2IJ\7?\2\2JK\7?\2\2K\f\3\2\2\2LM\7-\2\2M\16\3"+
		"\2\2\2NO\7,\2\2O\20\3\2\2\2PR\7/\2\2QP\3\2\2\2QR\3\2\2\2RS\3\2\2\2SW\4"+
		"\63;\2TV\4\62;\2UT\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2X\\\3\2\2\2YW"+
		"\3\2\2\2Z\\\7\62\2\2[Q\3\2\2\2[Z\3\2\2\2\\\22\3\2\2\2]^\7v\2\2^_\7t\2"+
		"\2_`\7w\2\2`a\7g\2\2a\24\3\2\2\2bc\7h\2\2cd\7c\2\2de\7n\2\2ef\7u\2\2f"+
		"g\7g\2\2g\26\3\2\2\2hi\7*\2\2i\30\3\2\2\2jk\7+\2\2k\32\3\2\2\2lm\7}\2"+
		"\2m\34\3\2\2\2no\7\177\2\2o\36\3\2\2\2pq\7k\2\2qr\7h\2\2r \3\2\2\2st\7"+
		"v\2\2tu\7j\2\2uv\7g\2\2vw\7p\2\2w\"\3\2\2\2xy\7g\2\2yz\7n\2\2z{\7u\2\2"+
		"{|\7g\2\2|$\3\2\2\2}~\7r\2\2~\177\7t\2\2\177\u0080\7k\2\2\u0080\u0081"+
		"\7p\2\2\u0081\u0082\7v\2\2\u0082&\3\2\2\2\u0083\u0084\7n\2\2\u0084\u0085"+
		"\7g\2\2\u0085\u0086\7v\2\2\u0086(\3\2\2\2\u0087\u0088\7k\2\2\u0088\u0089"+
		"\7p\2\2\u0089*\3\2\2\2\u008a\u008b\7x\2\2\u008b\u008c\7c\2\2\u008c\u008d"+
		"\7t\2\2\u008d,\3\2\2\2\u008e\u008f\7h\2\2\u008f\u0090\7w\2\2\u0090\u0091"+
		"\7p\2\2\u0091.\3\2\2\2\u0092\u0093\7e\2\2\u0093\u0094\7n\2\2\u0094\u0095"+
		"\7c\2\2\u0095\u0096\7u\2\2\u0096\u0097\7u\2\2\u0097\60\3\2\2\2\u0098\u0099"+
		"\7g\2\2\u0099\u009a\7z\2\2\u009a\u009b\7v\2\2\u009b\u009c\7g\2\2\u009c"+
		"\u009d\7p\2\2\u009d\u009e\7f\2\2\u009e\u009f\7u\2\2\u009f\62\3\2\2\2\u00a0"+
		"\u00a1\7p\2\2\u00a1\u00a2\7g\2\2\u00a2\u00a3\7y\2\2\u00a3\64\3\2\2\2\u00a4"+
		"\u00a5\7k\2\2\u00a5\u00a6\7p\2\2\u00a6\u00a7\7v\2\2\u00a7\66\3\2\2\2\u00a8"+
		"\u00a9\7d\2\2\u00a9\u00aa\7q\2\2\u00aa\u00ab\7q\2\2\u00ab\u00ac\7n\2\2"+
		"\u00ac8\3\2\2\2\u00ad\u00b1\t\2\2\2\u00ae\u00b0\t\3\2\2\u00af\u00ae\3"+
		"\2\2\2\u00b0\u00b3\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2"+
		":\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b4\u00b6\t\4\2\2\u00b5\u00b4\3\2\2\2"+
		"\u00b6\u00b7\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9"+
		"\3\2\2\2\u00b9\u00ba\b\36\2\2\u00ba<\3\2\2\2\u00bb\u00bc\7\61\2\2\u00bc"+
		"\u00bd\7,\2\2\u00bd\u00c1\3\2\2\2\u00be\u00c0\13\2\2\2\u00bf\u00be\3\2"+
		"\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2"+
		"\u00c4\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4\u00c5\7,\2\2\u00c5\u00c6\7\61"+
		"\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c8\b\37\2\2\u00c8>\3\2\2\2\u00c9\u00ca"+
		"\13\2\2\2\u00ca\u00cb\b \3\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\b \2\2\u00cd"+
		"@\3\2\2\2\t\2QW[\u00b1\u00b7\u00c1\4\2\3\2\3 \2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}