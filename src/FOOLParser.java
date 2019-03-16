// Generated from FOOL.g4 by ANTLR 4.4

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import ast.*;
import lib.FOOLlib;
import lib.FOOLParsingLib;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FOOLParser extends Parser {
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
	public static final String[] tokenNames = {
		"<INVALID>", "'+'", "'-'", "'*'", "'/'", "'('", "')'", "'{'", "'}'", "';'", 
		"':'", "','", "'.'", "'||'", "'&&'", "'!'", "'>='", "'<='", "'=='", "'='", 
		"'true'", "'false'", "'if'", "'then'", "'else'", "'print'", "'let'", "'in'", 
		"'var'", "'fun'", "'class'", "'extends'", "'new'", "'null'", "'int'", 
		"'bool'", "'->'", "INTEGER", "ID", "WHITESP", "COMMENT", "ERR"
	};
	public static final int
		RULE_prog = 0, RULE_cllist = 1, RULE_declist = 2, RULE_hotype = 3, RULE_type = 4, 
		RULE_arrow = 5, RULE_exp = 6, RULE_term = 7, RULE_factor = 8, RULE_value = 9;
	public static final String[] ruleNames = {
		"prog", "cllist", "declist", "hotype", "type", "arrow", "exp", "term", 
		"factor", "value"
	};

	@Override
	public String getGrammarFileName() { return "FOOL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	private int nestingLevel = 0;
	private int offset_0 = -2;
	private ArrayList<HashMap<String,STentry>> symTable = new ArrayList<HashMap<String,STentry>>();
	private HashMap<String, HashMap<String, STentry>> classTable = new HashMap<>();
	//livello ambiente con dichiarazioni piu' esterno � 0 (prima posizione ArrayList) invece che 1 (slides)
	//il "fronte" della lista di tabelle � symTable.get(nestingLevel)

	public FOOLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public Node ast;
		public ExpContext e;
		public CllistContext c;
		public DeclistContext d;
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public CllistContext cllist() {
			return getRuleContext(CllistContext.class,0);
		}
		public TerminalNode SEMIC() { return getToken(FOOLParser.SEMIC, 0); }
		public TerminalNode LET() { return getToken(FOOLParser.LET, 0); }
		public TerminalNode IN() { return getToken(FOOLParser.IN, 0); }
		public DeclistContext declist() {
			return getRuleContext(DeclistContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			HashMap<String,STentry> hm = new HashMap<String,STentry> ();
			       symTable.add(hm);
			       boolean cl = false;
			       boolean dec = false;
			setState(41);
			switch (_input.LA(1)) {
			case LPAR:
			case NOT:
			case TRUE:
			case FALSE:
			case IF:
			case PRINT:
			case NEW:
			case NULL:
			case INTEGER:
			case ID:
				{
				setState(21); ((ProgContext)_localctx).e = exp();
				((ProgContext)_localctx).ast =  new ProgNode(((ProgContext)_localctx).e.ast);
				}
				break;
			case LET:
				{
				setState(24); match(LET);
				setState(35);
				switch (_input.LA(1)) {
				case CLASS:
					{
					setState(25); ((ProgContext)_localctx).c = cllist();
					cl=true;
					setState(30);
					_la = _input.LA(1);
					if (_la==VAR || _la==FUN) {
						{
						setState(27); ((ProgContext)_localctx).d = declist();
						dec=true;
						}
					}

					}
					break;
				case VAR:
				case FUN:
					{
					setState(32); ((ProgContext)_localctx).d = declist();
					dec=true;
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(37); match(IN);
				setState(38); ((ProgContext)_localctx).e = exp();

							((ProgContext)_localctx).ast =  new ProgLetInNode(cl ? ((ProgContext)_localctx).c.astlist : new ArrayList<Node>(),
				        		dec ? ((ProgContext)_localctx).d.astlist : new ArrayList<Node>(),((ProgContext)_localctx).e.ast); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			symTable.remove(nestingLevel);
			setState(44); match(SEMIC);
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

	public static class CllistContext extends ParserRuleContext {
		public ArrayList<Node> astlist;
		public Token i;
		public Token i2;
		public Token fid;
		public TypeContext fty;
		public Token id;
		public TypeContext ty;
		public Token im;
		public TypeContext tm;
		public HotypeContext fht;
		public HotypeContext ht;
		public Token ci;
		public TypeContext ct;
		public ExpContext ce;
		public ExpContext be;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public List<TerminalNode> CRPAR() { return getTokens(FOOLParser.CRPAR); }
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode ID(int i) {
			return getToken(FOOLParser.ID, i);
		}
		public TerminalNode EXTENDS(int i) {
			return getToken(FOOLParser.EXTENDS, i);
		}
		public List<TerminalNode> EXTENDS() { return getTokens(FOOLParser.EXTENDS); }
		public TerminalNode COMMA(int i) {
			return getToken(FOOLParser.COMMA, i);
		}
		public TerminalNode RPAR(int i) {
			return getToken(FOOLParser.RPAR, i);
		}
		public List<TerminalNode> ID() { return getTokens(FOOLParser.ID); }
		public TerminalNode CLPAR(int i) {
			return getToken(FOOLParser.CLPAR, i);
		}
		public HotypeContext hotype(int i) {
			return getRuleContext(HotypeContext.class,i);
		}
		public TerminalNode SEMIC(int i) {
			return getToken(FOOLParser.SEMIC, i);
		}
		public List<TerminalNode> VAR() { return getTokens(FOOLParser.VAR); }
		public TerminalNode LPAR(int i) {
			return getToken(FOOLParser.LPAR, i);
		}
		public TerminalNode CRPAR(int i) {
			return getToken(FOOLParser.CRPAR, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FOOLParser.COMMA); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TerminalNode LET(int i) {
			return getToken(FOOLParser.LET, i);
		}
		public List<TerminalNode> COLON() { return getTokens(FOOLParser.COLON); }
		public TerminalNode FUN(int i) {
			return getToken(FOOLParser.FUN, i);
		}
		public List<HotypeContext> hotype() {
			return getRuleContexts(HotypeContext.class);
		}
		public TerminalNode VAR(int i) {
			return getToken(FOOLParser.VAR, i);
		}
		public List<TerminalNode> LPAR() { return getTokens(FOOLParser.LPAR); }
		public List<TerminalNode> CLPAR() { return getTokens(FOOLParser.CLPAR); }
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> IN() { return getTokens(FOOLParser.IN); }
		public List<TerminalNode> SEMIC() { return getTokens(FOOLParser.SEMIC); }
		public TerminalNode IN(int i) {
			return getToken(FOOLParser.IN, i);
		}
		public TerminalNode COLON(int i) {
			return getToken(FOOLParser.COLON, i);
		}
		public List<TerminalNode> RPAR() { return getTokens(FOOLParser.RPAR); }
		public List<TerminalNode> CLASS() { return getTokens(FOOLParser.CLASS); }
		public TerminalNode CLASS(int i) {
			return getToken(FOOLParser.CLASS, i);
		}
		public List<TerminalNode> FUN() { return getTokens(FOOLParser.FUN); }
		public List<TerminalNode> LET() { return getTokens(FOOLParser.LET); }
		public List<TerminalNode> ASS() { return getTokens(FOOLParser.ASS); }
		public TerminalNode ASS(int i) {
			return getToken(FOOLParser.ASS, i);
		}
		public CllistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cllist; }
	}

	public final CllistContext cllist() throws RecognitionException {
		CllistContext _localctx = new CllistContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_cllist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((CllistContext)_localctx).astlist =  new ArrayList<Node>();
			setState(135); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(47); match(CLASS);
				setState(48); ((CllistContext)_localctx).i = match(ID);

						//Creo nuovo ClassTypeNode,VirtualTable e set di nomi (per non permettere override field/metodi nella classe)
						ClassTypeNode ctn = new ClassTypeNode(new ArrayList<Node>(), new ArrayList<Node>());
				        HashMap<String,STentry> virtualTable = new HashMap<String,STentry> ();
						HashSet<String> names = new HashSet<String>();
						STentry superEntry = null;
						String superId = null;
				        STentry entry = new STentry(0, ctn, offset_0--); //Creo la STentry decrementando l'offset del nestingLevel 0
						FOOLParsingLib.addClassToSymTable(symTable.get(0), (((CllistContext)_localctx).i!=null?((CllistContext)_localctx).i.getText():null), entry, (((CllistContext)_localctx).i!=null?((CllistContext)_localctx).i.getLine():0));
				        //NestingLevel = 1 Dentro la classe
				        nestingLevel++;
				        //Infine aggiungo la virtualTable alla symTable (a nestingLevel 1) e alla classTable con il suo id
				        symTable.add(virtualTable);
				        classTable.put((((CllistContext)_localctx).i!=null?((CllistContext)_localctx).i.getText():null), virtualTable);
				setState(53);
				_la = _input.LA(1);
				if (_la==EXTENDS) {
					{
					setState(50); match(EXTENDS);
					setState(51); ((CllistContext)_localctx).i2 = match(ID);

							//Se estende una classe, controllo che esista, dopodiché aggiungo alla virtualTable i metodi/campi ereditati
							superId = (((CllistContext)_localctx).i2!=null?((CllistContext)_localctx).i2.getText():null);
							FOOLParsingLib.ensureExtendedClassExists(symTable.get(0), (((CllistContext)_localctx).i2!=null?((CllistContext)_localctx).i2.getText():null), (((CllistContext)_localctx).i2!=null?((CllistContext)_localctx).i2.getLine():0));
							HashMap<String, STentry> extVirtualTable = classTable.get((((CllistContext)_localctx).i2!=null?((CllistContext)_localctx).i2.getText():null));
							for (String key : extVirtualTable.keySet()) {
								virtualTable.put(key, extVirtualTable.get(key).deepCopy());
							}
							superEntry = symTable.get(0).get((((CllistContext)_localctx).i2!=null?((CllistContext)_localctx).i2.getText():null)); 
							FOOLParsingLib.ensureExtendedSTentryType(superEntry, (((CllistContext)_localctx).i2!=null?((CllistContext)_localctx).i2.getText():null), (((CllistContext)_localctx).i2!=null?((CllistContext)_localctx).i2.getLine():0));
							ClassTypeNode superCtn = (ClassTypeNode) superEntry.getType();
							//Aggiungo tutti i tipi dei metodi e dei campi alla ClassTypeNode della sottoclasse
							ArrayList<Node> fieldTypes = superCtn.getAllFields();
							for (int i = 0; i < fieldTypes.size(); i++) {
								ctn.insertFieldType(fieldTypes.get(i),i);	
							}
							ArrayList<Node> methodTypes = superCtn.getAllMethods();
							for (int i = 0; i < methodTypes.size(); i++) {
								ctn.insertMethodType(methodTypes.get(i),i);	
							}
					}
				}


						//Infine aggiungo la classe alla mappa di sottoclasse-superclasse, se non eredita mappata a null. 
						//E la aggiungo alla lista di dichiarazioni delle classi
						FOOLlib.getSuperTypeMap().put((((CllistContext)_localctx).i!=null?((CllistContext)_localctx).i.getText():null), superId);
						ClassNode c = new ClassNode((((CllistContext)_localctx).i!=null?((CllistContext)_localctx).i.getText():null), ctn, superId, superEntry);
						_localctx.astlist.add(c);
				setState(56); match(LPAR);

						//L'offset dei campi normalmente decresce da -1, se è una sottoclasse, parte deccresce dopo gli altri offset ereditati
				    	int fieldOffset = -ctn.getAllFields().size() - 1; 
				setState(73);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(58); ((CllistContext)_localctx).fid = match(ID);
					setState(59); match(COLON);
					setState(60); ((CllistContext)_localctx).fty = type();

					    	int thisFieldOffset = 0;
							FOOLParsingLib.ensureFieldNotOverridden(names, (((CllistContext)_localctx).fid!=null?((CllistContext)_localctx).fid.getText():null), (((CllistContext)_localctx).fid!=null?((CllistContext)_localctx).fid.getLine():0));
							STentry oldSTentry = virtualTable.get((((CllistContext)_localctx).fid!=null?((CllistContext)_localctx).fid.getText():null));
						    if (oldSTentry != null) { //Permetto override del campo se non è già il nome di un metodo
						    	FOOLParsingLib.ensureFieldSTEntryNotMethod(oldSTentry, (((CllistContext)_localctx).fid!=null?((CllistContext)_localctx).fid.getText():null), (((CllistContext)_localctx).fid!=null?((CllistContext)_localctx).fid.getLine():0));
						    	thisFieldOffset = oldSTentry.getOffset(); //Se override, l'offset è quello della superclasse
						    } else {
						    	thisFieldOffset = fieldOffset--; //Senno decresce dall'ultimo offset dichiarato
						    }
					    	//Infine lo aggiungo come campo alla classe, come tipo alla ClassType e poi lo aggiungo alla virtualTable
					    	FieldNode field = new FieldNode((((CllistContext)_localctx).fid!=null?((CllistContext)_localctx).fid.getText():null), ((CllistContext)_localctx).fty.ast, thisFieldOffset);
					    	c.addField(field);
					    	ctn.insertFieldType(((CllistContext)_localctx).fty.ast, -thisFieldOffset - 1);
					    	//Infine lo aggiungo come campo alla classe, come tipo alla ClassType e poi lo aggiungo alla virtualTable
					    	virtualTable.put((((CllistContext)_localctx).fid!=null?((CllistContext)_localctx).fid.getText():null), new STentry(nestingLevel, ((CllistContext)_localctx).fty.ast, thisFieldOffset));
					setState(70);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(62); match(COMMA);
						setState(63); ((CllistContext)_localctx).id = match(ID);
						setState(64); match(COLON);
						setState(65); ((CllistContext)_localctx).ty = type();

								//Come sopra, ma per i campi dal secondo in poi
								FOOLParsingLib.ensureFieldNotOverridden(names, (((CllistContext)_localctx).id!=null?((CllistContext)_localctx).id.getText():null), (((CllistContext)_localctx).id!=null?((CllistContext)_localctx).id.getLine():0));
								oldSTentry = virtualTable.get((((CllistContext)_localctx).id!=null?((CllistContext)_localctx).id.getText():null));
							    if (oldSTentry != null) { //Enable Field Override
							    	FOOLParsingLib.ensureFieldSTEntryNotMethod(oldSTentry, (((CllistContext)_localctx).id!=null?((CllistContext)_localctx).id.getText():null), (((CllistContext)_localctx).id!=null?((CllistContext)_localctx).id.getLine():0));
							    	thisFieldOffset = oldSTentry.getOffset();
							    } else {
							    	thisFieldOffset = fieldOffset--;
							    }
						    	field = new FieldNode((((CllistContext)_localctx).id!=null?((CllistContext)_localctx).id.getText():null), ((CllistContext)_localctx).ty.ast, thisFieldOffset);
						    	c.addField(field);
						    	ctn.insertFieldType(((CllistContext)_localctx).ty.ast, -thisFieldOffset - 1);
						    	virtualTable.put((((CllistContext)_localctx).id!=null?((CllistContext)_localctx).id.getText():null), new STentry(nestingLevel, ((CllistContext)_localctx).ty.ast, thisFieldOffset));
						}
						}
						setState(72);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(75); match(RPAR);

				setState(77); match(CLPAR);
				 //Gli offset dei metodi normalmente partono da 0 e salgono
						//Se la classe estende, come per i campi, si parte dall'ultimo offset della superclasse
						int methodOffset = ctn.getAllMethods().size();
					
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==FUN) {
					{
					{
					setState(79); match(FUN);
					setState(80); ((CllistContext)_localctx).im = match(ID);
					setState(81); match(COLON);
					setState(82); ((CllistContext)_localctx).tm = type();

							FOOLParsingLib.ensureMethodNotOverridden(names, (((CllistContext)_localctx).im!=null?((CllistContext)_localctx).im.getText():null), (((CllistContext)_localctx).im!=null?((CllistContext)_localctx).im.getLine():0));
							int thisMethodOffset = 0;
					    	STentry oldSTentry = virtualTable.get((((CllistContext)_localctx).im!=null?((CllistContext)_localctx).im.getText():null)); //cerco una possibile entry già presente
						    if (oldSTentry != null) {
						    	FOOLParsingLib.ensureMethodSTentryIsMethod(oldSTentry, (((CllistContext)_localctx).im!=null?((CllistContext)_localctx).im.getText():null), (((CllistContext)_localctx).im!=null?((CllistContext)_localctx).im.getLine():0));
						    	//Se presente nella virtual table ereditata allora faccio override di metodo (nuova STentry con vecchio offset)
					    		thisMethodOffset = oldSTentry.getOffset();
						    } else { //Se non presente allora ne creo una nuova aumentando methodOffset
						    	thisMethodOffset = methodOffset++;
						    }
						    STentry newSTentry = new STentry(nestingLevel, ((CllistContext)_localctx).tm.ast, thisMethodOffset, true);
						    virtualTable.put((((CllistContext)_localctx).im!=null?((CllistContext)_localctx).im.getText():null), newSTentry); //infine aggiorno la virtualTable
							MethodNode m = new MethodNode((((CllistContext)_localctx).im!=null?((CllistContext)_localctx).im.getText():null), thisMethodOffset, ((CllistContext)_localctx).tm.ast, ((CllistContext)_localctx).tm.ast);
							c.addMethod(m); //aggiungo methodNode alla ClassNode
						    ctn.insertMethodType(((CllistContext)_localctx).tm.ast, thisMethodOffset);
					        HashMap<String,STentry> hmn = new HashMap<String,STentry>();
					        nestingLevel++; 
					        symTable.add(hmn); 
					setState(84); match(LPAR);
					 
							ArrayList<Node> parTypes = new ArrayList<Node>();
							int paroffset = 1; 
					setState(101);
					_la = _input.LA(1);
					if (_la==ID) {
						{
						setState(86); ((CllistContext)_localctx).fid = match(ID);
						setState(87); match(COLON);
						setState(88); ((CllistContext)_localctx).fht = hotype();
						 
						    	// qualsiasi ID con tipo funzionale (vero ID di funzione oppure ID di variabile o parametro di tipo
								// funzionale) occupa un offset doppio:
								if (((CllistContext)_localctx).fht.ast instanceof ArrowTypeNode) { paroffset++; }
								parTypes.add(((CllistContext)_localctx).fht.ast);
								m.addPar(new ParNode((((CllistContext)_localctx).fid!=null?((CllistContext)_localctx).fid.getText():null),((CllistContext)_localctx).fht.ast));
								FOOLParsingLib.addParamSTentryToSymbolTable(hmn, (((CllistContext)_localctx).fid!=null?((CllistContext)_localctx).fid.getText():null), nestingLevel, ((CllistContext)_localctx).fht.ast, paroffset++, (((CllistContext)_localctx).fid!=null?((CllistContext)_localctx).fid.getLine():0));
						setState(98);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(90); match(COMMA);
							setState(91); ((CllistContext)_localctx).id = match(ID);
							setState(92); match(COLON);
							setState(93); ((CllistContext)_localctx).ht = hotype();

									// HIGH ORDER
									if (((CllistContext)_localctx).ht.ast instanceof ArrowTypeNode) { paroffset++; }
									parTypes.add(((CllistContext)_localctx).ht.ast);
									m.addPar(new ParNode((((CllistContext)_localctx).id!=null?((CllistContext)_localctx).id.getText():null),((CllistContext)_localctx).ht.ast));
									FOOLParsingLib.addParamSTentryToSymbolTable(hmn, (((CllistContext)_localctx).id!=null?((CllistContext)_localctx).id.getText():null), nestingLevel, ((CllistContext)_localctx).ht.ast, paroffset++, (((CllistContext)_localctx).id!=null?((CllistContext)_localctx).id.getLine():0));
							}
							}
							setState(100);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(103); match(RPAR);
					 newSTentry.addType(new ArrowTypeNode(parTypes,((CllistContext)_localctx).tm.ast)); 
					setState(122);
					_la = _input.LA(1);
					if (_la==LET) {
						{
						setState(105); match(LET);

								//La declist di un metodo può avere un solo livello (a differenza dei possibili livelli infiti delle funzioni)
								ArrayList<Node> declist = new ArrayList<Node>();
								int fOffset = -2;
								m.addDec(declist);
						setState(116); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(107); match(VAR);
							setState(108); ((CllistContext)_localctx).ci = match(ID);
							setState(109); match(COLON);
							setState(110); ((CllistContext)_localctx).ct = type();
							setState(111); match(ASS);
							setState(112); ((CllistContext)_localctx).ce = exp();
							setState(113); match(SEMIC);
							 
									declist.add(new VarNode((((CllistContext)_localctx).ci!=null?((CllistContext)_localctx).ci.getText():null),((CllistContext)_localctx).ct.ast,((CllistContext)_localctx).ce.ast));
									//Controllo che nella Table del metodo non sia già stato dichiarato un campo/parametro uguale
									FOOLParsingLib.addVarSTentryToSymbolTable(hmn, (((CllistContext)_localctx).ci!=null?((CllistContext)_localctx).ci.getText():null), nestingLevel, ((CllistContext)_localctx).ct.ast, fOffset--, (((CllistContext)_localctx).ci!=null?((CllistContext)_localctx).ci.getLine():0));
							}
							}
							setState(118); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==VAR );
						setState(120); match(IN);
						}
					}

					setState(124); ((CllistContext)_localctx).be = exp();
					 
							m.addBody(((CllistContext)_localctx).be.ast);
							//Rimuovo la symbolTable(NL=2) dentro la declist di un metodo(NL=1) di una classe(NL=0)
							symTable.remove(nestingLevel--); 
					setState(126); match(SEMIC);
					}
					}
					setState(132);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(133); match(CRPAR);

						//Esco dalla classe -> rimuovo VirtualTable e torno a NL=0 
						symTable.remove(nestingLevel--);
				}
				}
				setState(137); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CLASS );
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

	public static class DeclistContext extends ParserRuleContext {
		public ArrayList<Node> astlist;
		public Token i;
		public HotypeContext ht;
		public ExpContext e;
		public TypeContext t;
		public Token fid;
		public HotypeContext fht;
		public Token id;
		public DeclistContext d;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode ID(int i) {
			return getToken(FOOLParser.ID, i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(FOOLParser.COMMA, i);
		}
		public TerminalNode RPAR(int i) {
			return getToken(FOOLParser.RPAR, i);
		}
		public List<TerminalNode> ID() { return getTokens(FOOLParser.ID); }
		public HotypeContext hotype(int i) {
			return getRuleContext(HotypeContext.class,i);
		}
		public TerminalNode SEMIC(int i) {
			return getToken(FOOLParser.SEMIC, i);
		}
		public List<TerminalNode> VAR() { return getTokens(FOOLParser.VAR); }
		public TerminalNode LPAR(int i) {
			return getToken(FOOLParser.LPAR, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FOOLParser.COMMA); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TerminalNode LET(int i) {
			return getToken(FOOLParser.LET, i);
		}
		public List<DeclistContext> declist() {
			return getRuleContexts(DeclistContext.class);
		}
		public DeclistContext declist(int i) {
			return getRuleContext(DeclistContext.class,i);
		}
		public List<TerminalNode> COLON() { return getTokens(FOOLParser.COLON); }
		public TerminalNode FUN(int i) {
			return getToken(FOOLParser.FUN, i);
		}
		public List<HotypeContext> hotype() {
			return getRuleContexts(HotypeContext.class);
		}
		public TerminalNode VAR(int i) {
			return getToken(FOOLParser.VAR, i);
		}
		public List<TerminalNode> LPAR() { return getTokens(FOOLParser.LPAR); }
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> IN() { return getTokens(FOOLParser.IN); }
		public List<TerminalNode> SEMIC() { return getTokens(FOOLParser.SEMIC); }
		public TerminalNode IN(int i) {
			return getToken(FOOLParser.IN, i);
		}
		public TerminalNode COLON(int i) {
			return getToken(FOOLParser.COLON, i);
		}
		public List<TerminalNode> RPAR() { return getTokens(FOOLParser.RPAR); }
		public List<TerminalNode> ASS() { return getTokens(FOOLParser.ASS); }
		public List<TerminalNode> FUN() { return getTokens(FOOLParser.FUN); }
		public List<TerminalNode> LET() { return getTokens(FOOLParser.LET); }
		public TerminalNode ASS(int i) {
			return getToken(FOOLParser.ASS, i);
		}
		public DeclistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declist; }
	}

	public final DeclistContext declist() throws RecognitionException {
		DeclistContext _localctx = new DeclistContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((DeclistContext)_localctx).astlist =  new ArrayList<Node>();
				   int offset=-2;
			setState(188); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(184);
				switch (_input.LA(1)) {
				case VAR:
					{
					setState(140); match(VAR);
					setState(141); ((DeclistContext)_localctx).i = match(ID);
					setState(142); match(COLON);
					setState(143); ((DeclistContext)_localctx).ht = hotype();
					setState(144); match(ASS);
					setState(145); ((DeclistContext)_localctx).e = exp();

							VarNode v = new VarNode((((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getText():null),((DeclistContext)_localctx).ht.ast,((DeclistContext)_localctx).e.ast);  
							_localctx.astlist.add(v);                                 
							HashMap<String,STentry> hm = symTable.get(nestingLevel);
							FOOLParsingLib.addVarSTentryToSymbolTable(hm, (((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getText():null), nestingLevel, ((DeclistContext)_localctx).ht.ast, 
								nestingLevel == 0 ? offset_0-- : offset--, (((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getLine():0));
							
							// HIGH ORDER
							if (((DeclistContext)_localctx).ht.ast instanceof ArrowTypeNode) {
					        	// qualsiasi ID con tipo funzionale (vero ID di funzione oppure ID di variabile o parametro di tipo
								// funzionale) occupa un offset doppio.
								if (nestingLevel == 0) {
									offset_0--;
								} else {
									offset--;
								}
					        }			
						
					}
					break;
				case FUN:
					{
					setState(148); match(FUN);
					setState(149); ((DeclistContext)_localctx).i = match(ID);
					setState(150); match(COLON);
					setState(151); ((DeclistContext)_localctx).t = type();

							//inserimento di ID nella symtable
							FunNode f = new FunNode((((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getText():null),((DeclistContext)_localctx).t.ast);      
							_localctx.astlist.add(f);                           
							HashMap<String,STentry> hm = symTable.get(nestingLevel);
							

							FOOLParsingLib.addFunSTentryToSymbolTable(hm, (((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getText():null), nestingLevel, ((DeclistContext)_localctx).t.ast, 
								nestingLevel == 0 ? offset_0 : offset, (((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getLine():0));
							
							// HIGH ORDER
							// qualsiasi ID con tipo funzionale (vero ID di funzione oppure ID di variabile o parametro di tipo
							// funzionale) occupa un offset doppio.
						    if (nestingLevel == 0) {
								offset_0-=2;
							} else {
								offset-=2;
							}	
							
							STentry entry = hm.get((((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getText():null));
							//creare una nuova hashmap per la symTable
							nestingLevel++;
							HashMap<String,STentry> hmn = new HashMap<String,STentry> ();
							symTable.add(hmn); 
					setState(153); match(LPAR);

							ArrayList<Node> parTypes = new ArrayList<Node>();
							int paroffset=1; 
					setState(170);
					_la = _input.LA(1);
					if (_la==ID) {
						{
						setState(155); ((DeclistContext)_localctx).fid = match(ID);
						setState(156); match(COLON);
						setState(157); ((DeclistContext)_localctx).fht = hotype();
						 
								parTypes.add(((DeclistContext)_localctx).fht.ast);
								f.addPar(new ParNode((((DeclistContext)_localctx).fid!=null?((DeclistContext)_localctx).fid.getText():null),((DeclistContext)_localctx).fht.ast));
								
								// HIGH ORDER
								if (((DeclistContext)_localctx).fht.ast instanceof ArrowTypeNode) {
						             paroffset++;	// qualsiasi ID con tipo funzionale (vero ID di funzione oppure ID di variabile o parametro di tipo
												    // funzionale) occupa un offset doppio:
						        }
						        
								FOOLParsingLib.addParamSTentryToSymbolTable(hmn, (((DeclistContext)_localctx).fid!=null?((DeclistContext)_localctx).fid.getText():null), nestingLevel, ((DeclistContext)_localctx).fht.ast, paroffset++, (((DeclistContext)_localctx).fid!=null?((DeclistContext)_localctx).fid.getLine():0));
						setState(167);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(159); match(COMMA);
							setState(160); ((DeclistContext)_localctx).id = match(ID);
							setState(161); match(COLON);
							setState(162); ((DeclistContext)_localctx).ht = hotype();

									parTypes.add(((DeclistContext)_localctx).ht.ast);
							        f.addPar(new ParNode((((DeclistContext)_localctx).id!=null?((DeclistContext)_localctx).id.getText():null),((DeclistContext)_localctx).ht.ast));
							        
							        // HIGH ORDER
							        if (((DeclistContext)_localctx).ht.ast instanceof ArrowTypeNode) {
							             paroffset++;	// qualsiasi ID con tipo funzionale (vero ID di funzione oppure ID di variabile o parametro di tipo
													    // funzionale) occupa un offset doppio:
							        }
							        
									FOOLParsingLib.addParamSTentryToSymbolTable(hmn, (((DeclistContext)_localctx).id!=null?((DeclistContext)_localctx).id.getText():null), nestingLevel, ((DeclistContext)_localctx).ht.ast, paroffset++, (((DeclistContext)_localctx).id!=null?((DeclistContext)_localctx).id.getLine():0));
							}
							}
							setState(169);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(172); match(RPAR);
					 
							
							// HIGH ORDER
							ArrowTypeNode completeType = new ArrowTypeNode(parTypes, ((DeclistContext)_localctx).t.ast);
							entry.addType(completeType); 
							f.setSymType(completeType); // Imposto il symType per poterlo ritornare con getSymType
					              					    // che ritorna il tipo messo in symbol table.
						
					setState(179);
					_la = _input.LA(1);
					if (_la==LET) {
						{
						setState(174); match(LET);
						setState(175); ((DeclistContext)_localctx).d = declist();
						setState(176); match(IN);
						f.addDec(((DeclistContext)_localctx).d.astlist);
						}
					}

					setState(181); ((DeclistContext)_localctx).e = exp();

							f.addBody(((DeclistContext)_localctx).e.ast);
					        //rimuovere la hashmap corrente poich esco dallo scope               
					        symTable.remove(nestingLevel--); 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(186); match(SEMIC);
				}
				}
				setState(190); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==VAR || _la==FUN );
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

	public static class HotypeContext extends ParserRuleContext {
		public Node ast;
		public TypeContext t;
		public ArrowContext a;
		public ArrowContext arrow() {
			return getRuleContext(ArrowContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public HotypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hotype; }
	}

	public final HotypeContext hotype() throws RecognitionException {
		HotypeContext _localctx = new HotypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_hotype);
		try {
			setState(198);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(192); ((HotypeContext)_localctx).t = type();
				((HotypeContext)_localctx).ast =  ((HotypeContext)_localctx).t.ast;
				}
				break;
			case LPAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(195); ((HotypeContext)_localctx).a = arrow();
				((HotypeContext)_localctx).ast =  ((HotypeContext)_localctx).a.ast;
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

	public static class TypeContext extends ParserRuleContext {
		public Node ast;
		public Token i;
		public TerminalNode ID() { return getToken(FOOLParser.ID, 0); }
		public TerminalNode BOOL() { return getToken(FOOLParser.BOOL, 0); }
		public TerminalNode INT() { return getToken(FOOLParser.INT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		try {
			setState(206);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(200); match(INT);
				((TypeContext)_localctx).ast = new IntTypeNode();
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(202); match(BOOL);
				((TypeContext)_localctx).ast = new BoolTypeNode();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(204); ((TypeContext)_localctx).i = match(ID);
				((TypeContext)_localctx).ast = new RefTypeNode((((TypeContext)_localctx).i!=null?((TypeContext)_localctx).i.getText():null));
					
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

	public static class ArrowContext extends ParserRuleContext {
		public Node ast;
		public HotypeContext t;
		public HotypeContext ty;
		public TypeContext typ;
		public HotypeContext hotype(int i) {
			return getRuleContext(HotypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FOOLParser.COMMA); }
		public List<HotypeContext> hotype() {
			return getRuleContexts(HotypeContext.class);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(FOOLParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FOOLParser.RPAR, 0); }
		public TerminalNode ARROW() { return getToken(FOOLParser.ARROW, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(FOOLParser.COMMA, i);
		}
		public ArrowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrow; }
	}

	public final ArrowContext arrow() throws RecognitionException {
		ArrowContext _localctx = new ArrowContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_arrow);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208); match(LPAR);

					ArrayList<Node> arglist = new ArrayList<Node>();
				
			setState(221);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAR) | (1L << INT) | (1L << BOOL) | (1L << ID))) != 0)) {
				{
				setState(210); ((ArrowContext)_localctx).t = hotype();
				arglist.add(((ArrowContext)_localctx).t.ast);
				setState(218);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(212); match(COMMA);
					setState(213); ((ArrowContext)_localctx).ty = hotype();

								arglist.add(((ArrowContext)_localctx).ty.ast);
							
					}
					}
					setState(220);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(223); match(RPAR);

			setState(225); match(ARROW);
			setState(226); ((ArrowContext)_localctx).typ = type();
			((ArrowContext)_localctx).ast =  new ArrowTypeNode(arglist, ((ArrowContext)_localctx).typ.ast);
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

	public static class ExpContext extends ParserRuleContext {
		public Node ast;
		public TermContext f;
		public TermContext l;
		public TerminalNode MINUS(int i) {
			return getToken(FOOLParser.MINUS, i);
		}
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(FOOLParser.PLUS); }
		public List<TerminalNode> MINUS() { return getTokens(FOOLParser.MINUS); }
		public List<TerminalNode> OR() { return getTokens(FOOLParser.OR); }
		public TerminalNode PLUS(int i) {
			return getToken(FOOLParser.PLUS, i);
		}
		public TerminalNode OR(int i) {
			return getToken(FOOLParser.OR, i);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_exp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229); ((ExpContext)_localctx).f = term();
			((ExpContext)_localctx).ast =  ((ExpContext)_localctx).f.ast;
			setState(245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << OR))) != 0)) {
				{
				setState(243);
				switch (_input.LA(1)) {
				case PLUS:
					{
					setState(231); match(PLUS);
					setState(232); ((ExpContext)_localctx).l = term();
					((ExpContext)_localctx).ast =  new PlusNode (_localctx.ast,((ExpContext)_localctx).l.ast);
					}
					break;
				case MINUS:
					{
					setState(235); match(MINUS);
					setState(236); ((ExpContext)_localctx).l = term();
					((ExpContext)_localctx).ast =  new MinusNode (_localctx.ast, ((ExpContext)_localctx).l.ast);
					}
					break;
				case OR:
					{
					setState(239); match(OR);
					setState(240); ((ExpContext)_localctx).l = term();
					((ExpContext)_localctx).ast =  new OrNode (_localctx.ast, ((ExpContext)_localctx).l.ast);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(247);
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

	public static class TermContext extends ParserRuleContext {
		public Node ast;
		public FactorContext f;
		public FactorContext l;
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public TerminalNode AND(int i) {
			return getToken(FOOLParser.AND, i);
		}
		public TerminalNode TIMES(int i) {
			return getToken(FOOLParser.TIMES, i);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TerminalNode> TIMES() { return getTokens(FOOLParser.TIMES); }
		public List<TerminalNode> AND() { return getTokens(FOOLParser.AND); }
		public List<TerminalNode> DIV() { return getTokens(FOOLParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(FOOLParser.DIV, i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248); ((TermContext)_localctx).f = factor();
			((TermContext)_localctx).ast =  ((TermContext)_localctx).f.ast;
			setState(264);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TIMES) | (1L << DIV) | (1L << AND))) != 0)) {
				{
				setState(262);
				switch (_input.LA(1)) {
				case TIMES:
					{
					setState(250); match(TIMES);
					setState(251); ((TermContext)_localctx).l = factor();
					((TermContext)_localctx).ast =  new MultNode (_localctx.ast,((TermContext)_localctx).l.ast);
					}
					break;
				case DIV:
					{
					setState(254); match(DIV);
					setState(255); ((TermContext)_localctx).l = factor();
					((TermContext)_localctx).ast =  new DivNode (_localctx.ast, ((TermContext)_localctx).l.ast);
					}
					break;
				case AND:
					{
					setState(258); match(AND);
					setState(259); ((TermContext)_localctx).l = factor();
					((TermContext)_localctx).ast =  new AndNode (_localctx.ast, ((TermContext)_localctx).l.ast);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(266);
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

	public static class FactorContext extends ParserRuleContext {
		public Node ast;
		public ValueContext f;
		public ValueContext l;
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public List<TerminalNode> GE() { return getTokens(FOOLParser.GE); }
		public TerminalNode GE(int i) {
			return getToken(FOOLParser.GE, i);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TerminalNode EQ(int i) {
			return getToken(FOOLParser.EQ, i);
		}
		public TerminalNode LE(int i) {
			return getToken(FOOLParser.LE, i);
		}
		public List<TerminalNode> LE() { return getTokens(FOOLParser.LE); }
		public List<TerminalNode> EQ() { return getTokens(FOOLParser.EQ); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267); ((FactorContext)_localctx).f = value();
			((FactorContext)_localctx).ast =  ((FactorContext)_localctx).f.ast;
			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GE) | (1L << LE) | (1L << EQ))) != 0)) {
				{
				setState(281);
				switch (_input.LA(1)) {
				case EQ:
					{
					setState(269); match(EQ);
					setState(270); ((FactorContext)_localctx).l = value();
					((FactorContext)_localctx).ast =  new EqualNode (_localctx.ast,((FactorContext)_localctx).l.ast);
					}
					break;
				case GE:
					{
					setState(273); match(GE);
					setState(274); ((FactorContext)_localctx).l = value();
					((FactorContext)_localctx).ast =  new GreaterEqualNode (_localctx.ast, ((FactorContext)_localctx).l.ast);
					}
					break;
				case LE:
					{
					setState(277); match(LE);
					setState(278); ((FactorContext)_localctx).l = value();
					((FactorContext)_localctx).ast =  new LesserEqualNode (_localctx.ast, ((FactorContext)_localctx).l.ast);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(285);
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

	public static class ValueContext extends ParserRuleContext {
		public Node ast;
		public Token n;
		public ExpContext e;
		public Token i;
		public ExpContext fe;
		public ExpContext x;
		public ExpContext y;
		public ExpContext z;
		public ExpContext a;
		public Token mi;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public TerminalNode ELSE() { return getToken(FOOLParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(FOOLParser.IF, 0); }
		public TerminalNode PRINT() { return getToken(FOOLParser.PRINT, 0); }
		public TerminalNode INTEGER() { return getToken(FOOLParser.INTEGER, 0); }
		public TerminalNode FALSE() { return getToken(FOOLParser.FALSE, 0); }
		public List<TerminalNode> CRPAR() { return getTokens(FOOLParser.CRPAR); }
		public TerminalNode TRUE() { return getToken(FOOLParser.TRUE, 0); }
		public TerminalNode THEN() { return getToken(FOOLParser.THEN, 0); }
		public TerminalNode ID(int i) {
			return getToken(FOOLParser.ID, i);
		}
		public TerminalNode LPAR() { return getToken(FOOLParser.LPAR, 0); }
		public List<TerminalNode> CLPAR() { return getTokens(FOOLParser.CLPAR); }
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode NEW() { return getToken(FOOLParser.NEW, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(FOOLParser.COMMA, i);
		}
		public TerminalNode NOT() { return getToken(FOOLParser.NOT, 0); }
		public List<TerminalNode> ID() { return getTokens(FOOLParser.ID); }
		public TerminalNode DOT() { return getToken(FOOLParser.DOT, 0); }
		public TerminalNode CLPAR(int i) {
			return getToken(FOOLParser.CLPAR, i);
		}
		public TerminalNode NULL() { return getToken(FOOLParser.NULL, 0); }
		public TerminalNode CRPAR(int i) {
			return getToken(FOOLParser.CRPAR, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FOOLParser.COMMA); }
		public TerminalNode RPAR() { return getToken(FOOLParser.RPAR, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_value);
		int _la;
		try {
			setState(386);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(286); ((ValueContext)_localctx).n = match(INTEGER);
				((ValueContext)_localctx).ast =  new IntNode(Integer.parseInt((((ValueContext)_localctx).n!=null?((ValueContext)_localctx).n.getText():null)));
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(288); match(TRUE);
				((ValueContext)_localctx).ast =  new BoolNode(true);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(290); match(FALSE);
				((ValueContext)_localctx).ast =  new BoolNode(false);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(292); match(NOT);
				setState(293); match(LPAR);
				setState(294); ((ValueContext)_localctx).e = exp();
				setState(295); match(RPAR);
				((ValueContext)_localctx).ast =  new NotNode(((ValueContext)_localctx).e.ast);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(298); match(NULL);
				((ValueContext)_localctx).ast =  new EmptyNode();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(300); match(NEW);
				setState(301); ((ValueContext)_localctx).i = match(ID);
				setState(302); match(LPAR);

						ArrayList<Node> parlist = new ArrayList<>();
						FOOLParsingLib.ensureNewNodeSTentryIsPresent(symTable.get(0), (((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getText():null), (((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getLine():0));
						STentry entry = symTable.get(0).get((((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getText():null));
						((ValueContext)_localctx).ast =  new NewNode((((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getText():null), entry, parlist, nestingLevel);
				setState(315);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAR) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << PRINT) | (1L << NEW) | (1L << NULL) | (1L << INTEGER) | (1L << ID))) != 0)) {
					{
					setState(304); ((ValueContext)_localctx).fe = exp();
					 parlist.add(((ValueContext)_localctx).fe.ast); 
					setState(312);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(306); match(COMMA);
						setState(307); ((ValueContext)_localctx).e = exp();
						 parlist.add(((ValueContext)_localctx).e.ast); 
						}
						}
						setState(314);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(317); match(RPAR);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(318); match(IF);
				setState(319); ((ValueContext)_localctx).x = exp();
				setState(320); match(THEN);
				setState(321); match(CLPAR);
				setState(322); ((ValueContext)_localctx).y = exp();
				setState(323); match(CRPAR);
				setState(324); match(ELSE);
				setState(325); match(CLPAR);
				setState(326); ((ValueContext)_localctx).z = exp();
				setState(327); match(CRPAR);
				((ValueContext)_localctx).ast =  new IfNode(((ValueContext)_localctx).x.ast,((ValueContext)_localctx).y.ast,((ValueContext)_localctx).z.ast);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(330); match(NOT);
				setState(331); match(LPAR);
				setState(332); exp();
				setState(333); match(RPAR);

				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(336); match(PRINT);
				setState(337); match(LPAR);
				setState(338); ((ValueContext)_localctx).e = exp();
				setState(339); match(RPAR);
				((ValueContext)_localctx).ast =  new PrintNode(((ValueContext)_localctx).e.ast);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(342); match(LPAR);
				setState(343); ((ValueContext)_localctx).e = exp();
				setState(344); match(RPAR);
				((ValueContext)_localctx).ast =  ((ValueContext)_localctx).e.ast;
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(347); ((ValueContext)_localctx).i = match(ID);

						STentry entry = FOOLParsingLib.getIDFromSymbolTable(symTable, (((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getText():null), nestingLevel, (((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getLine():0));       
						((ValueContext)_localctx).ast =  new IdNode((((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getText():null),entry,nestingLevel);
				setState(384);
				switch (_input.LA(1)) {
				case LPAR:
					{
					setState(349); match(LPAR);

							ArrayList<Node> arglist = new ArrayList<Node>(); 
					setState(362);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAR) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << PRINT) | (1L << NEW) | (1L << NULL) | (1L << INTEGER) | (1L << ID))) != 0)) {
						{
						setState(351); ((ValueContext)_localctx).a = exp();
						arglist.add(((ValueContext)_localctx).a.ast);
						setState(359);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(353); match(COMMA);
							setState(354); ((ValueContext)_localctx).a = exp();
							arglist.add(((ValueContext)_localctx).a.ast);
							}
							}
							setState(361);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(364); match(RPAR);
					((ValueContext)_localctx).ast =  new CallNode((((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getText():null),entry,arglist,nestingLevel);
					}
					break;
				case DOT:
					{
					setState(366); match(DOT);
					setState(367); ((ValueContext)_localctx).mi = match(ID);
					setState(368); match(LPAR);

							//Se dopo aver matchato un ID c'è anche una chiamata a metodo (id.metodo())
							ArrayList<Node> parlist = new ArrayList<>();
							FOOLParsingLib.ensureIDIsRefTypeNode(entry, (((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getText():null), (((ValueContext)_localctx).mi!=null?((ValueContext)_localctx).mi.getLine():0));
							RefTypeNode rtn = (RefTypeNode) entry.getType();
					        STentry methodEntry = null;
					        FOOLParsingLib.ensureClassTableContainsMethod(classTable.get(rtn.getId()), (((ValueContext)_localctx).mi!=null?((ValueContext)_localctx).mi.getText():null), (((ValueContext)_localctx).mi!=null?((ValueContext)_localctx).mi.getLine():0));
					        methodEntry = classTable.get(rtn.getId()).get((((ValueContext)_localctx).mi!=null?((ValueContext)_localctx).mi.getText():null));
					        ((ValueContext)_localctx).ast =  new ClassCallNode((((ValueContext)_localctx).mi!=null?((ValueContext)_localctx).mi.getText():null), entry, methodEntry, parlist, nestingLevel);
					setState(381);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAR) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << PRINT) | (1L << NEW) | (1L << NULL) | (1L << INTEGER) | (1L << ID))) != 0)) {
						{
						setState(370); ((ValueContext)_localctx).fe = exp();
						 parlist.add(((ValueContext)_localctx).fe.ast);
						setState(378);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(372); match(COMMA);
							setState(373); ((ValueContext)_localctx).e = exp();
							 parlist.add(((ValueContext)_localctx).e.ast); 
							}
							}
							setState(380);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(383); match(RPAR);
					}
					break;
				case PLUS:
				case MINUS:
				case TIMES:
				case DIV:
				case RPAR:
				case CRPAR:
				case SEMIC:
				case COMMA:
				case OR:
				case AND:
				case GE:
				case LE:
				case EQ:
				case THEN:
					break;
				default:
					throw new NoViableAltException(this);
				}
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3+\u0187\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2!\n\2\3\2\3\2\3\2\5\2&"+
		"\n\2\3\2\3\2\3\2\3\2\5\2,\n\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\5\38\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3G\n\3"+
		"\f\3\16\3J\13\3\5\3L\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3c\n\3\f\3\16\3f\13\3\5\3h\n"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\6\3w\n\3\r\3\16"+
		"\3x\3\3\3\3\5\3}\n\3\3\3\3\3\3\3\3\3\7\3\u0083\n\3\f\3\16\3\u0086\13\3"+
		"\3\3\3\3\6\3\u008a\n\3\r\3\16\3\u008b\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\7\4\u00a8\n\4\f\4\16\4\u00ab\13\4\5\4\u00ad\n\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\5\4\u00b6\n\4\3\4\3\4\3\4\5\4\u00bb\n\4\3\4\3\4\6\4\u00bf\n\4"+
		"\r\4\16\4\u00c0\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u00c9\n\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\5\6\u00d1\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u00db\n\7\f"+
		"\7\16\7\u00de\13\7\5\7\u00e0\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00f6\n\b\f\b\16\b\u00f9"+
		"\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u0109"+
		"\n\t\f\t\16\t\u010c\13\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\7\n\u011c\n\n\f\n\16\n\u011f\13\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\7\13\u0139\n\13\f\13\16\13\u013c\13\13\5\13"+
		"\u013e\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\7\13\u0168\n\13\f\13\16\13\u016b\13\13\5\13\u016d\n\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u017b\n\13\f\13\16"+
		"\13\u017e\13\13\5\13\u0180\n\13\3\13\5\13\u0183\n\13\5\13\u0185\n\13\3"+
		"\13\2\2\f\2\4\6\b\n\f\16\20\22\24\2\2\u01ad\2\26\3\2\2\2\4\60\3\2\2\2"+
		"\6\u008d\3\2\2\2\b\u00c8\3\2\2\2\n\u00d0\3\2\2\2\f\u00d2\3\2\2\2\16\u00e7"+
		"\3\2\2\2\20\u00fa\3\2\2\2\22\u010d\3\2\2\2\24\u0184\3\2\2\2\26+\b\2\1"+
		"\2\27\30\5\16\b\2\30\31\b\2\1\2\31,\3\2\2\2\32%\7\34\2\2\33\34\5\4\3\2"+
		"\34 \b\2\1\2\35\36\5\6\4\2\36\37\b\2\1\2\37!\3\2\2\2 \35\3\2\2\2 !\3\2"+
		"\2\2!&\3\2\2\2\"#\5\6\4\2#$\b\2\1\2$&\3\2\2\2%\33\3\2\2\2%\"\3\2\2\2&"+
		"\'\3\2\2\2\'(\7\35\2\2()\5\16\b\2)*\b\2\1\2*,\3\2\2\2+\27\3\2\2\2+\32"+
		"\3\2\2\2,-\3\2\2\2-.\b\2\1\2./\7\13\2\2/\3\3\2\2\2\60\u0089\b\3\1\2\61"+
		"\62\7 \2\2\62\63\7(\2\2\63\67\b\3\1\2\64\65\7!\2\2\65\66\7(\2\2\668\b"+
		"\3\1\2\67\64\3\2\2\2\678\3\2\2\289\3\2\2\29:\b\3\1\2:;\7\7\2\2;K\b\3\1"+
		"\2<=\7(\2\2=>\7\f\2\2>?\5\n\6\2?H\b\3\1\2@A\7\r\2\2AB\7(\2\2BC\7\f\2\2"+
		"CD\5\n\6\2DE\b\3\1\2EG\3\2\2\2F@\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2"+
		"IL\3\2\2\2JH\3\2\2\2K<\3\2\2\2KL\3\2\2\2LM\3\2\2\2MN\7\b\2\2NO\b\3\1\2"+
		"OP\7\t\2\2P\u0084\b\3\1\2QR\7\37\2\2RS\7(\2\2ST\7\f\2\2TU\5\n\6\2UV\b"+
		"\3\1\2VW\7\7\2\2Wg\b\3\1\2XY\7(\2\2YZ\7\f\2\2Z[\5\b\5\2[d\b\3\1\2\\]\7"+
		"\r\2\2]^\7(\2\2^_\7\f\2\2_`\5\b\5\2`a\b\3\1\2ac\3\2\2\2b\\\3\2\2\2cf\3"+
		"\2\2\2db\3\2\2\2de\3\2\2\2eh\3\2\2\2fd\3\2\2\2gX\3\2\2\2gh\3\2\2\2hi\3"+
		"\2\2\2ij\7\b\2\2j|\b\3\1\2kl\7\34\2\2lv\b\3\1\2mn\7\36\2\2no\7(\2\2op"+
		"\7\f\2\2pq\5\n\6\2qr\7\25\2\2rs\5\16\b\2st\7\13\2\2tu\b\3\1\2uw\3\2\2"+
		"\2vm\3\2\2\2wx\3\2\2\2xv\3\2\2\2xy\3\2\2\2yz\3\2\2\2z{\7\35\2\2{}\3\2"+
		"\2\2|k\3\2\2\2|}\3\2\2\2}~\3\2\2\2~\177\5\16\b\2\177\u0080\b\3\1\2\u0080"+
		"\u0081\7\13\2\2\u0081\u0083\3\2\2\2\u0082Q\3\2\2\2\u0083\u0086\3\2\2\2"+
		"\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0087\3\2\2\2\u0086\u0084"+
		"\3\2\2\2\u0087\u0088\7\n\2\2\u0088\u008a\b\3\1\2\u0089\61\3\2\2\2\u008a"+
		"\u008b\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\5\3\2\2\2"+
		"\u008d\u00be\b\4\1\2\u008e\u008f\7\36\2\2\u008f\u0090\7(\2\2\u0090\u0091"+
		"\7\f\2\2\u0091\u0092\5\b\5\2\u0092\u0093\7\25\2\2\u0093\u0094\5\16\b\2"+
		"\u0094\u0095\b\4\1\2\u0095\u00bb\3\2\2\2\u0096\u0097\7\37\2\2\u0097\u0098"+
		"\7(\2\2\u0098\u0099\7\f\2\2\u0099\u009a\5\n\6\2\u009a\u009b\b\4\1\2\u009b"+
		"\u009c\7\7\2\2\u009c\u00ac\b\4\1\2\u009d\u009e\7(\2\2\u009e\u009f\7\f"+
		"\2\2\u009f\u00a0\5\b\5\2\u00a0\u00a9\b\4\1\2\u00a1\u00a2\7\r\2\2\u00a2"+
		"\u00a3\7(\2\2\u00a3\u00a4\7\f\2\2\u00a4\u00a5\5\b\5\2\u00a5\u00a6\b\4"+
		"\1\2\u00a6\u00a8\3\2\2\2\u00a7\u00a1\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9"+
		"\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3\2"+
		"\2\2\u00ac\u009d\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae"+
		"\u00af\7\b\2\2\u00af\u00b5\b\4\1\2\u00b0\u00b1\7\34\2\2\u00b1\u00b2\5"+
		"\6\4\2\u00b2\u00b3\7\35\2\2\u00b3\u00b4\b\4\1\2\u00b4\u00b6\3\2\2\2\u00b5"+
		"\u00b0\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\5\16"+
		"\b\2\u00b8\u00b9\b\4\1\2\u00b9\u00bb\3\2\2\2\u00ba\u008e\3\2\2\2\u00ba"+
		"\u0096\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00bd\7\13\2\2\u00bd\u00bf\3"+
		"\2\2\2\u00be\u00ba\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0"+
		"\u00c1\3\2\2\2\u00c1\7\3\2\2\2\u00c2\u00c3\5\n\6\2\u00c3\u00c4\b\5\1\2"+
		"\u00c4\u00c9\3\2\2\2\u00c5\u00c6\5\f\7\2\u00c6\u00c7\b\5\1\2\u00c7\u00c9"+
		"\3\2\2\2\u00c8\u00c2\3\2\2\2\u00c8\u00c5\3\2\2\2\u00c9\t\3\2\2\2\u00ca"+
		"\u00cb\7$\2\2\u00cb\u00d1\b\6\1\2\u00cc\u00cd\7%\2\2\u00cd\u00d1\b\6\1"+
		"\2\u00ce\u00cf\7(\2\2\u00cf\u00d1\b\6\1\2\u00d0\u00ca\3\2\2\2\u00d0\u00cc"+
		"\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\13\3\2\2\2\u00d2\u00d3\7\7\2\2\u00d3"+
		"\u00df\b\7\1\2\u00d4\u00d5\5\b\5\2\u00d5\u00dc\b\7\1\2\u00d6\u00d7\7\r"+
		"\2\2\u00d7\u00d8\5\b\5\2\u00d8\u00d9\b\7\1\2\u00d9\u00db\3\2\2\2\u00da"+
		"\u00d6\3\2\2\2\u00db\u00de\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2"+
		"\2\2\u00dd\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00df\u00d4\3\2\2\2\u00df"+
		"\u00e0\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\7\b\2\2\u00e2\u00e3\b\7"+
		"\1\2\u00e3\u00e4\7&\2\2\u00e4\u00e5\5\n\6\2\u00e5\u00e6\b\7\1\2\u00e6"+
		"\r\3\2\2\2\u00e7\u00e8\5\20\t\2\u00e8\u00f7\b\b\1\2\u00e9\u00ea\7\3\2"+
		"\2\u00ea\u00eb\5\20\t\2\u00eb\u00ec\b\b\1\2\u00ec\u00f6\3\2\2\2\u00ed"+
		"\u00ee\7\4\2\2\u00ee\u00ef\5\20\t\2\u00ef\u00f0\b\b\1\2\u00f0\u00f6\3"+
		"\2\2\2\u00f1\u00f2\7\17\2\2\u00f2\u00f3\5\20\t\2\u00f3\u00f4\b\b\1\2\u00f4"+
		"\u00f6\3\2\2\2\u00f5\u00e9\3\2\2\2\u00f5\u00ed\3\2\2\2\u00f5\u00f1\3\2"+
		"\2\2\u00f6\u00f9\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8"+
		"\17\3\2\2\2\u00f9\u00f7\3\2\2\2\u00fa\u00fb\5\22\n\2\u00fb\u010a\b\t\1"+
		"\2\u00fc\u00fd\7\5\2\2\u00fd\u00fe\5\22\n\2\u00fe\u00ff\b\t\1\2\u00ff"+
		"\u0109\3\2\2\2\u0100\u0101\7\6\2\2\u0101\u0102\5\22\n\2\u0102\u0103\b"+
		"\t\1\2\u0103\u0109\3\2\2\2\u0104\u0105\7\20\2\2\u0105\u0106\5\22\n\2\u0106"+
		"\u0107\b\t\1\2\u0107\u0109\3\2\2\2\u0108\u00fc\3\2\2\2\u0108\u0100\3\2"+
		"\2\2\u0108\u0104\3\2\2\2\u0109\u010c\3\2\2\2\u010a\u0108\3\2\2\2\u010a"+
		"\u010b\3\2\2\2\u010b\21\3\2\2\2\u010c\u010a\3\2\2\2\u010d\u010e\5\24\13"+
		"\2\u010e\u011d\b\n\1\2\u010f\u0110\7\24\2\2\u0110\u0111\5\24\13\2\u0111"+
		"\u0112\b\n\1\2\u0112\u011c\3\2\2\2\u0113\u0114\7\22\2\2\u0114\u0115\5"+
		"\24\13\2\u0115\u0116\b\n\1\2\u0116\u011c\3\2\2\2\u0117\u0118\7\23\2\2"+
		"\u0118\u0119\5\24\13\2\u0119\u011a\b\n\1\2\u011a\u011c\3\2\2\2\u011b\u010f"+
		"\3\2\2\2\u011b\u0113\3\2\2\2\u011b\u0117\3\2\2\2\u011c\u011f\3\2\2\2\u011d"+
		"\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e\23\3\2\2\2\u011f\u011d\3\2\2"+
		"\2\u0120\u0121\7\'\2\2\u0121\u0185\b\13\1\2\u0122\u0123\7\26\2\2\u0123"+
		"\u0185\b\13\1\2\u0124\u0125\7\27\2\2\u0125\u0185\b\13\1\2\u0126\u0127"+
		"\7\21\2\2\u0127\u0128\7\7\2\2\u0128\u0129\5\16\b\2\u0129\u012a\7\b\2\2"+
		"\u012a\u012b\b\13\1\2\u012b\u0185\3\2\2\2\u012c\u012d\7#\2\2\u012d\u0185"+
		"\b\13\1\2\u012e\u012f\7\"\2\2\u012f\u0130\7(\2\2\u0130\u0131\7\7\2\2\u0131"+
		"\u013d\b\13\1\2\u0132\u0133\5\16\b\2\u0133\u013a\b\13\1\2\u0134\u0135"+
		"\7\r\2\2\u0135\u0136\5\16\b\2\u0136\u0137\b\13\1\2\u0137\u0139\3\2\2\2"+
		"\u0138\u0134\3\2\2\2\u0139\u013c\3\2\2\2\u013a\u0138\3\2\2\2\u013a\u013b"+
		"\3\2\2\2\u013b\u013e\3\2\2\2\u013c\u013a\3\2\2\2\u013d\u0132\3\2\2\2\u013d"+
		"\u013e\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u0185\7\b\2\2\u0140\u0141\7\30"+
		"\2\2\u0141\u0142\5\16\b\2\u0142\u0143\7\31\2\2\u0143\u0144\7\t\2\2\u0144"+
		"\u0145\5\16\b\2\u0145\u0146\7\n\2\2\u0146\u0147\7\32\2\2\u0147\u0148\7"+
		"\t\2\2\u0148\u0149\5\16\b\2\u0149\u014a\7\n\2\2\u014a\u014b\b\13\1\2\u014b"+
		"\u0185\3\2\2\2\u014c\u014d\7\21\2\2\u014d\u014e\7\7\2\2\u014e\u014f\5"+
		"\16\b\2\u014f\u0150\7\b\2\2\u0150\u0151\b\13\1\2\u0151\u0185\3\2\2\2\u0152"+
		"\u0153\7\33\2\2\u0153\u0154\7\7\2\2\u0154\u0155\5\16\b\2\u0155\u0156\7"+
		"\b\2\2\u0156\u0157\b\13\1\2\u0157\u0185\3\2\2\2\u0158\u0159\7\7\2\2\u0159"+
		"\u015a\5\16\b\2\u015a\u015b\7\b\2\2\u015b\u015c\b\13\1\2\u015c\u0185\3"+
		"\2\2\2\u015d\u015e\7(\2\2\u015e\u0182\b\13\1\2\u015f\u0160\7\7\2\2\u0160"+
		"\u016c\b\13\1\2\u0161\u0162\5\16\b\2\u0162\u0169\b\13\1\2\u0163\u0164"+
		"\7\r\2\2\u0164\u0165\5\16\b\2\u0165\u0166\b\13\1\2\u0166\u0168\3\2\2\2"+
		"\u0167\u0163\3\2\2\2\u0168\u016b\3\2\2\2\u0169\u0167\3\2\2\2\u0169\u016a"+
		"\3\2\2\2\u016a\u016d\3\2\2\2\u016b\u0169\3\2\2\2\u016c\u0161\3\2\2\2\u016c"+
		"\u016d\3\2\2\2\u016d\u016e\3\2\2\2\u016e\u016f\7\b\2\2\u016f\u0183\b\13"+
		"\1\2\u0170\u0171\7\16\2\2\u0171\u0172\7(\2\2\u0172\u0173\7\7\2\2\u0173"+
		"\u017f\b\13\1\2\u0174\u0175\5\16\b\2\u0175\u017c\b\13\1\2\u0176\u0177"+
		"\7\r\2\2\u0177\u0178\5\16\b\2\u0178\u0179\b\13\1\2\u0179\u017b\3\2\2\2"+
		"\u017a\u0176\3\2\2\2\u017b\u017e\3\2\2\2\u017c\u017a\3\2\2\2\u017c\u017d"+
		"\3\2\2\2\u017d\u0180\3\2\2\2\u017e\u017c\3\2\2\2\u017f\u0174\3\2\2\2\u017f"+
		"\u0180\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u0183\7\b\2\2\u0182\u015f\3\2"+
		"\2\2\u0182\u0170\3\2\2\2\u0182\u0183\3\2\2\2\u0183\u0185\3\2\2\2\u0184"+
		"\u0120\3\2\2\2\u0184\u0122\3\2\2\2\u0184\u0124\3\2\2\2\u0184\u0126\3\2"+
		"\2\2\u0184\u012c\3\2\2\2\u0184\u012e\3\2\2\2\u0184\u0140\3\2\2\2\u0184"+
		"\u014c\3\2\2\2\u0184\u0152\3\2\2\2\u0184\u0158\3\2\2\2\u0184\u015d\3\2"+
		"\2\2\u0185\25\3\2\2\2% %+\67HKdgx|\u0084\u008b\u00a9\u00ac\u00b5\u00ba"+
		"\u00c0\u00c8\u00d0\u00dc\u00df\u00f5\u00f7\u0108\u010a\u011b\u011d\u013a"+
		"\u013d\u0169\u016c\u017c\u017f\u0182\u0184";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}