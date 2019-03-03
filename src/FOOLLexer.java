// Generated from FOOL.g4 by ANTLR 4.4

import java.util.ArrayList;
import java.util.HashMap;
import ast.*;
import lib.FOOLlib;

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
		PLUS=1, MINUS=2, TIMES=3, DIV=4, LPAR=5, RPAR=6, CLPAR=7, CRPAR=8, SEMIC=9, 
		COLON=10, COMMA=11, DOT=12, OR=13, AND=14, NOT=15, GE=16, LE=17, EQ=18, 
		ASS=19, TRUE=20, FALSE=21, IF=22, THEN=23, ELSE=24, PRINT=25, LET=26, 
		IN=27, VAR=28, FUN=29, CLASS=30, EXTENDS=31, NEW=32, NULL=33, INT=34, 
		BOOL=35, ARROW=36, INTEGER=37, ID=38, WHITESP=39, COMMENT=40, ERR=41;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'", "'#'", "'$'", "'%'", "'&'", "'''", 
		"'('", "')'"
	};
	public static final String[] ruleNames = {
		"PLUS", "MINUS", "TIMES", "DIV", "LPAR", "RPAR", "CLPAR", "CRPAR", "SEMIC", 
		"COLON", "COMMA", "DOT", "OR", "AND", "NOT", "GE", "LE", "EQ", "ASS", 
		"TRUE", "FALSE", "IF", "THEN", "ELSE", "PRINT", "LET", "IN", "VAR", "FUN", 
		"CLASS", "EXTENDS", "NEW", "NULL", "INT", "BOOL", "ARROW", "INTEGER", 
		"ID", "WHITESP", "COMMENT", "ERR"
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
		case 40: ERR_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void ERR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:  System.out.println("Invalid char: "+ getText()); lexicalErrors++;  break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2+\u00fe\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\3\2"+
		"\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13"+
		"\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30"+
		"\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33"+
		"\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3"+
		"\"\3\"\3#\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3&\3&\5&\u00d3\n&\3&\3&\7&"+
		"\u00d7\n&\f&\16&\u00da\13&\5&\u00dc\n&\3\'\3\'\7\'\u00e0\n\'\f\'\16\'"+
		"\u00e3\13\'\3(\6(\u00e6\n(\r(\16(\u00e7\3(\3(\3)\3)\3)\3)\7)\u00f0\n)"+
		"\f)\16)\u00f3\13)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3\u00f1\2+\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M(O)Q*S+\3\2\5\4\2C\\c|\5\2\62;C\\c|\5\2\13\f\17\17\"\"\u0103\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2"+
		"\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2"+
		"\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\3U"+
		"\3\2\2\2\5W\3\2\2\2\7Y\3\2\2\2\t[\3\2\2\2\13]\3\2\2\2\r_\3\2\2\2\17a\3"+
		"\2\2\2\21c\3\2\2\2\23e\3\2\2\2\25g\3\2\2\2\27i\3\2\2\2\31k\3\2\2\2\33"+
		"m\3\2\2\2\35p\3\2\2\2\37s\3\2\2\2!u\3\2\2\2#x\3\2\2\2%{\3\2\2\2\'~\3\2"+
		"\2\2)\u0080\3\2\2\2+\u0085\3\2\2\2-\u008b\3\2\2\2/\u008e\3\2\2\2\61\u0093"+
		"\3\2\2\2\63\u0098\3\2\2\2\65\u009e\3\2\2\2\67\u00a2\3\2\2\29\u00a5\3\2"+
		"\2\2;\u00a9\3\2\2\2=\u00ad\3\2\2\2?\u00b3\3\2\2\2A\u00bb\3\2\2\2C\u00bf"+
		"\3\2\2\2E\u00c4\3\2\2\2G\u00c8\3\2\2\2I\u00cd\3\2\2\2K\u00db\3\2\2\2M"+
		"\u00dd\3\2\2\2O\u00e5\3\2\2\2Q\u00eb\3\2\2\2S\u00f9\3\2\2\2UV\7-\2\2V"+
		"\4\3\2\2\2WX\7/\2\2X\6\3\2\2\2YZ\7,\2\2Z\b\3\2\2\2[\\\7\61\2\2\\\n\3\2"+
		"\2\2]^\7*\2\2^\f\3\2\2\2_`\7+\2\2`\16\3\2\2\2ab\7}\2\2b\20\3\2\2\2cd\7"+
		"\177\2\2d\22\3\2\2\2ef\7=\2\2f\24\3\2\2\2gh\7<\2\2h\26\3\2\2\2ij\7.\2"+
		"\2j\30\3\2\2\2kl\7\60\2\2l\32\3\2\2\2mn\7~\2\2no\7~\2\2o\34\3\2\2\2pq"+
		"\7(\2\2qr\7(\2\2r\36\3\2\2\2st\7#\2\2t \3\2\2\2uv\7@\2\2vw\7?\2\2w\"\3"+
		"\2\2\2xy\7>\2\2yz\7?\2\2z$\3\2\2\2{|\7?\2\2|}\7?\2\2}&\3\2\2\2~\177\7"+
		"?\2\2\177(\3\2\2\2\u0080\u0081\7v\2\2\u0081\u0082\7t\2\2\u0082\u0083\7"+
		"w\2\2\u0083\u0084\7g\2\2\u0084*\3\2\2\2\u0085\u0086\7h\2\2\u0086\u0087"+
		"\7c\2\2\u0087\u0088\7n\2\2\u0088\u0089\7u\2\2\u0089\u008a\7g\2\2\u008a"+
		",\3\2\2\2\u008b\u008c\7k\2\2\u008c\u008d\7h\2\2\u008d.\3\2\2\2\u008e\u008f"+
		"\7v\2\2\u008f\u0090\7j\2\2\u0090\u0091\7g\2\2\u0091\u0092\7p\2\2\u0092"+
		"\60\3\2\2\2\u0093\u0094\7g\2\2\u0094\u0095\7n\2\2\u0095\u0096\7u\2\2\u0096"+
		"\u0097\7g\2\2\u0097\62\3\2\2\2\u0098\u0099\7r\2\2\u0099\u009a\7t\2\2\u009a"+
		"\u009b\7k\2\2\u009b\u009c\7p\2\2\u009c\u009d\7v\2\2\u009d\64\3\2\2\2\u009e"+
		"\u009f\7n\2\2\u009f\u00a0\7g\2\2\u00a0\u00a1\7v\2\2\u00a1\66\3\2\2\2\u00a2"+
		"\u00a3\7k\2\2\u00a3\u00a4\7p\2\2\u00a48\3\2\2\2\u00a5\u00a6\7x\2\2\u00a6"+
		"\u00a7\7c\2\2\u00a7\u00a8\7t\2\2\u00a8:\3\2\2\2\u00a9\u00aa\7h\2\2\u00aa"+
		"\u00ab\7w\2\2\u00ab\u00ac\7p\2\2\u00ac<\3\2\2\2\u00ad\u00ae\7e\2\2\u00ae"+
		"\u00af\7n\2\2\u00af\u00b0\7c\2\2\u00b0\u00b1\7u\2\2\u00b1\u00b2\7u\2\2"+
		"\u00b2>\3\2\2\2\u00b3\u00b4\7g\2\2\u00b4\u00b5\7z\2\2\u00b5\u00b6\7v\2"+
		"\2\u00b6\u00b7\7g\2\2\u00b7\u00b8\7p\2\2\u00b8\u00b9\7f\2\2\u00b9\u00ba"+
		"\7u\2\2\u00ba@\3\2\2\2\u00bb\u00bc\7p\2\2\u00bc\u00bd\7g\2\2\u00bd\u00be"+
		"\7y\2\2\u00beB\3\2\2\2\u00bf\u00c0\7p\2\2\u00c0\u00c1\7w\2\2\u00c1\u00c2"+
		"\7n\2\2\u00c2\u00c3\7n\2\2\u00c3D\3\2\2\2\u00c4\u00c5\7k\2\2\u00c5\u00c6"+
		"\7p\2\2\u00c6\u00c7\7v\2\2\u00c7F\3\2\2\2\u00c8\u00c9\7d\2\2\u00c9\u00ca"+
		"\7q\2\2\u00ca\u00cb\7q\2\2\u00cb\u00cc\7n\2\2\u00ccH\3\2\2\2\u00cd\u00ce"+
		"\7/\2\2\u00ce\u00cf\7@\2\2\u00cfJ\3\2\2\2\u00d0\u00dc\7\62\2\2\u00d1\u00d3"+
		"\7/\2\2\u00d2\u00d1\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4"+
		"\u00d8\4\63;\2\u00d5\u00d7\4\62;\2\u00d6\u00d5\3\2\2\2\u00d7\u00da\3\2"+
		"\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da"+
		"\u00d8\3\2\2\2\u00db\u00d0\3\2\2\2\u00db\u00d2\3\2\2\2\u00dcL\3\2\2\2"+
		"\u00dd\u00e1\t\2\2\2\u00de\u00e0\t\3\2\2\u00df\u00de\3\2\2\2\u00e0\u00e3"+
		"\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2N\3\2\2\2\u00e3"+
		"\u00e1\3\2\2\2\u00e4\u00e6\t\4\2\2\u00e5\u00e4\3\2\2\2\u00e6\u00e7\3\2"+
		"\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9"+
		"\u00ea\b(\2\2\u00eaP\3\2\2\2\u00eb\u00ec\7\61\2\2\u00ec\u00ed\7,\2\2\u00ed"+
		"\u00f1\3\2\2\2\u00ee\u00f0\13\2\2\2\u00ef\u00ee\3\2\2\2\u00f0\u00f3\3"+
		"\2\2\2\u00f1\u00f2\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f2\u00f4\3\2\2\2\u00f3"+
		"\u00f1\3\2\2\2\u00f4\u00f5\7,\2\2\u00f5\u00f6\7\61\2\2\u00f6\u00f7\3\2"+
		"\2\2\u00f7\u00f8\b)\2\2\u00f8R\3\2\2\2\u00f9\u00fa\13\2\2\2\u00fa\u00fb"+
		"\b*\3\2\u00fb\u00fc\3\2\2\2\u00fc\u00fd\b*\2\2\u00fdT\3\2\2\2\t\2\u00d2"+
		"\u00d8\u00db\u00e1\u00e7\u00f1\4\2\3\2\3*\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}