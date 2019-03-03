// Generated from FOOL.g4 by ANTLR 4.4

import java.util.ArrayList;
import java.util.HashMap;
import ast.*;
import lib.FOOLlib;

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
			setState(36);
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
				setState(30);
				switch (_input.LA(1)) {
				case CLASS:
					{
					setState(25); ((ProgContext)_localctx).c = cllist();
					setState(27);
					_la = _input.LA(1);
					if (_la==VAR || _la==FUN) {
						{
						setState(26); ((ProgContext)_localctx).d = declist();
						}
					}

					}
					break;
				case VAR:
				case FUN:
					{
					setState(29); ((ProgContext)_localctx).d = declist();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(32); match(IN);
				setState(33); ((ProgContext)_localctx).e = exp();
				((ProgContext)_localctx).ast =  new ProgLetInNode(((ProgContext)_localctx).c.astlist,((ProgContext)_localctx).d.astlist,((ProgContext)_localctx).e.ast);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			symTable.remove(nestingLevel);
			setState(39); match(SEMIC);
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
		public ExpContext re;
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
					int offset = offset_0;
			setState(130); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(42); match(CLASS);
				setState(43); ((CllistContext)_localctx).i = match(ID);

						ClassTypeNode ctn = new ClassTypeNode(new ArrayList<Node>(), new ArrayList<Node>());
				        HashMap<String,STentry> virtualTable = new HashMap<String,STentry> ();
						STentry superEntry = null;
						String superId = "";
					
				setState(48);
				_la = _input.LA(1);
				if (_la==EXTENDS) {
					{
					setState(45); match(EXTENDS);
					setState(46); ((CllistContext)_localctx).i2 = match(ID);

							superId = (((CllistContext)_localctx).i2!=null?((CllistContext)_localctx).i2.getText():null);
							if (!symTable.get(0).containsKey((((CllistContext)_localctx).i2!=null?((CllistContext)_localctx).i2.getText():null)) || !classTable.containsKey((((CllistContext)_localctx).i2!=null?((CllistContext)_localctx).i2.getText():null))) {
								System.out.println("Super class " + (((CllistContext)_localctx).i2!=null?((CllistContext)_localctx).i2.getText():null) + " at line: " + (((CllistContext)_localctx).i2!=null?((CllistContext)_localctx).i2.getLine():0) + " does not exist");
								System.exit(0);
							}
							HashMap<String, STentry> extVirtualTable = classTable.get((((CllistContext)_localctx).i2!=null?((CllistContext)_localctx).i2.getText():null));
							for (String key : extVirtualTable.keySet()) {
								virtualTable.put(key, extVirtualTable.get(key).deepCopy());
							}
							superEntry = symTable.get(0).get((((CllistContext)_localctx).i2!=null?((CllistContext)_localctx).i2.getText():null)); 
							if (!(superEntry.getType()  instanceof ClassTypeNode)) {
								System.out.println((((CllistContext)_localctx).i2!=null?((CllistContext)_localctx).i2.getText():null) + " extended at line: " + (((CllistContext)_localctx).i2!=null?((CllistContext)_localctx).i2.getLine():0) +  "is not a class");
								System.exit(0);			
							}
							ClassTypeNode superCtn = (ClassTypeNode) superEntry.getType();
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


				        nestingLevel++;
				        symTable.add(virtualTable);
				        classTable.put((((CllistContext)_localctx).i!=null?((CllistContext)_localctx).i.getText():null), virtualTable);
				        STentry entry = new STentry(0, ctn, offset--);
				        if (symTable.get(0).put((((CllistContext)_localctx).i!=null?((CllistContext)_localctx).i.getText():null), entry) != null) { //niente override tra classi
				        	System.out.println("Class id "+(((CllistContext)_localctx).i!=null?((CllistContext)_localctx).i.getText():null)+" at line "+(((CllistContext)_localctx).i!=null?((CllistContext)_localctx).i.getLine():0)+" already declared");
				            System.exit(0); 
				        } 
						ClassNode c = new ClassNode((((CllistContext)_localctx).i!=null?((CllistContext)_localctx).i.getText():null), ctn, superId, superEntry);
						FOOLlib.getSuperTypeMap().put((((CllistContext)_localctx).i!=null?((CllistContext)_localctx).i.getText():null), (((CllistContext)_localctx).i2!=null?((CllistContext)_localctx).i2.getText():null));
						_localctx.astlist.add(c);
				setState(51); match(LPAR);
				 /*START_Fields*/
				    	int fieldOffset = -1 - ctn.getAllFields().size(); 
				setState(68);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(53); ((CllistContext)_localctx).fid = match(ID);
					setState(54); match(COLON);
					setState(55); ((CllistContext)_localctx).fty = type();

						    FieldNode ffield = new FieldNode((((CllistContext)_localctx).fid!=null?((CllistContext)_localctx).fid.getText():null),((CllistContext)_localctx).fty.ast);
						    c.addField(ffield);
						    ctn.insertFieldType(((CllistContext)_localctx).fty.ast, -fieldOffset - 1);
						    if (virtualTable.containsKey((((CllistContext)_localctx).fid!=null?((CllistContext)_localctx).fid.getText():null))) { //Enable Field Override
						    	STentry oldSTentry = virtualTable.get((((CllistContext)_localctx).fid!=null?((CllistContext)_localctx).fid.getText():null));
						    	if (oldSTentry.isMethod()){ //Disable Field Override from Method
						    		System.out.println("Field id "+(((CllistContext)_localctx).fid!=null?((CllistContext)_localctx).fid.getText():null)+" at line "+(((CllistContext)_localctx).fid!=null?((CllistContext)_localctx).fid.getLine():0)+" already declared as method");
					        		System.exit(0);
						    	} else {
							    	virtualTable.put((((CllistContext)_localctx).fid!=null?((CllistContext)_localctx).fid.getText():null), new STentry(nestingLevel, ((CllistContext)_localctx).fty.ast, oldSTentry.getOffset()));
						    	}
						    } else {
						    	virtualTable.put((((CllistContext)_localctx).fid!=null?((CllistContext)_localctx).fid.getText():null), new STentry(nestingLevel, ((CllistContext)_localctx).fty.ast, fieldOffset--));
						    } 
					setState(65);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(57); match(COMMA);
						setState(58); ((CllistContext)_localctx).id = match(ID);
						setState(59); match(COLON);
						setState(60); ((CllistContext)_localctx).ty = type();

						    	FieldNode field = new FieldNode((((CllistContext)_localctx).id!=null?((CllistContext)_localctx).id.getText():null), ((CllistContext)_localctx).ty.ast);
						    	c.addField(field);
							    ctn.insertFieldType(((CllistContext)_localctx).ty.ast, -fieldOffset - 1);
							    if (virtualTable.containsKey((((CllistContext)_localctx).id!=null?((CllistContext)_localctx).id.getText():null))) { //Enable Field Override
							    	STentry oldSTentry = virtualTable.get((((CllistContext)_localctx).id!=null?((CllistContext)_localctx).id.getText():null));
							    	if (oldSTentry.isMethod()){ //Disable Field Override from Method
							    		System.out.println("Field id "+(((CllistContext)_localctx).id!=null?((CllistContext)_localctx).id.getText():null)+" at line "+(((CllistContext)_localctx).id!=null?((CllistContext)_localctx).id.getLine():0)+" already declared as method");
						        		System.exit(0);
							    	} else {
								    	virtualTable.put((((CllistContext)_localctx).id!=null?((CllistContext)_localctx).id.getText():null), new STentry(nestingLevel, ((CllistContext)_localctx).ty.ast, oldSTentry.getOffset()));
							    	}
							    } else {
							    	virtualTable.put((((CllistContext)_localctx).id!=null?((CllistContext)_localctx).id.getText():null), new STentry(nestingLevel, ((CllistContext)_localctx).ty.ast, fieldOffset--));
							    } 
						}
						}
						setState(67);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(70); match(RPAR);

				setState(72); match(CLPAR);
				 int methodOffset = ctn.getAllMethods().size(); 
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==FUN) {
					{
					{
					setState(74); match(FUN);
					setState(75); ((CllistContext)_localctx).im = match(ID);
					setState(76); match(COLON);
					setState(77); ((CllistContext)_localctx).tm = type();

							//inserimento di ID nella symtable
							MethodNode m = new MethodNode((((CllistContext)_localctx).im!=null?((CllistContext)_localctx).im.getText():null),((CllistContext)_localctx).tm.ast, ((CllistContext)_localctx).tm.ast);      
							c.addMethod(m);
						    ctn.insertMethodType(((CllistContext)_localctx).tm.ast, methodOffset);                            
						    STentry newSTentry = null;
						    if (virtualTable.containsKey((((CllistContext)_localctx).im!=null?((CllistContext)_localctx).im.getText():null))) { //Enable Method Override
						    	STentry oldSTentry = virtualTable.get((((CllistContext)_localctx).im!=null?((CllistContext)_localctx).im.getText():null));
						    	if (!oldSTentry.isMethod()){ //Disable Method Override from Field
						    		System.out.println("Field id "+(((CllistContext)_localctx).im!=null?((CllistContext)_localctx).im.getText():null)+" at line "+(((CllistContext)_localctx).im!=null?((CllistContext)_localctx).im.getLine():0)+" already declared as method");
					        		System.exit(0);
						    	} else {
						    		newSTentry = new STentry(nestingLevel, ((CllistContext)_localctx).tm.ast, oldSTentry.getOffset(), true);
						    	}
						    } else {
						    	newSTentry = new STentry(nestingLevel, ((CllistContext)_localctx).tm.ast, methodOffset++, true);
						    }
						    virtualTable.put((((CllistContext)_localctx).im!=null?((CllistContext)_localctx).im.getText():null), newSTentry);
					        //TODO verificare creare una nuova hashmap per la symTable
					        nestingLevel++;
					        HashMap<String,STentry> hmn = new HashMap<String,STentry> ();
					        symTable.add(hmn); 
					setState(79); match(LPAR);
					 
							ArrayList<Node> parTypes = new ArrayList<Node>();
							int paroffset=1; 
					setState(96);
					_la = _input.LA(1);
					if (_la==ID) {
						{
						setState(81); ((CllistContext)_localctx).fid = match(ID);
						setState(82); match(COLON);
						setState(83); ((CllistContext)_localctx).fht = hotype();
						 
								parTypes.add(((CllistContext)_localctx).fty.ast);
								ParNode fpar = new ParNode((((CllistContext)_localctx).fid!=null?((CllistContext)_localctx).fid.getText():null),((CllistContext)_localctx).fty.ast); //creo nodo ParNode
								m.addPar(fpar);                                 //lo attacco al FunNode con addPar
								if ( hmn.put((((CllistContext)_localctx).fid!=null?((CllistContext)_localctx).fid.getText():null),new STentry(nestingLevel,((CllistContext)_localctx).fty.ast,paroffset++)) != null  ) //aggiungo dich a hmn
								{ System.out.println("Parameter id "+(((CllistContext)_localctx).fid!=null?((CllistContext)_localctx).fid.getText():null)+" at line "+(((CllistContext)_localctx).fid!=null?((CllistContext)_localctx).fid.getLine():0)+" already declared");
									System.exit(0); } 
						setState(93);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(85); match(COMMA);
							setState(86); ((CllistContext)_localctx).id = match(ID);
							setState(87); match(COLON);
							setState(88); ((CllistContext)_localctx).ht = hotype();

									parTypes.add(((CllistContext)_localctx).ty.ast);
									ParNode par = new ParNode((((CllistContext)_localctx).id!=null?((CllistContext)_localctx).id.getText():null),((CllistContext)_localctx).ty.ast);
									m.addPar(par);
									if ( hmn.put((((CllistContext)_localctx).id!=null?((CllistContext)_localctx).id.getText():null),new STentry(nestingLevel,((CllistContext)_localctx).ty.ast,paroffset++)) != null  )
									{ System.out.println("Parameter id "+(((CllistContext)_localctx).id!=null?((CllistContext)_localctx).id.getText():null)+" at line "+(((CllistContext)_localctx).id!=null?((CllistContext)_localctx).id.getLine():0)+" already declared");
										System.exit(0); } 
							}
							}
							setState(95);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(98); match(RPAR);

							newSTentry.addType(new ArrowTypeNode(parTypes,((CllistContext)_localctx).tm.ast));
						
					setState(117);
					_la = _input.LA(1);
					if (_la==LET) {
						{
						setState(100); match(LET);

								ArrayList<Node> declist = new ArrayList<Node>();
								m.addDec(declist); 
						setState(111); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(102); match(VAR);
							setState(103); ((CllistContext)_localctx).ci = match(ID);
							setState(104); match(COLON);
							setState(105); ((CllistContext)_localctx).ct = type();
							setState(106); match(ASS);
							setState(107); ((CllistContext)_localctx).ce = exp();
							setState(108); match(SEMIC);
							 
									VarNode v = new VarNode((((CllistContext)_localctx).ci!=null?((CllistContext)_localctx).ci.getText():null),((CllistContext)_localctx).ct.ast,((CllistContext)_localctx).ce.ast);
									declist.add(v);
									if ( hmn.put((((CllistContext)_localctx).ci!=null?((CllistContext)_localctx).ci.getText():null), new STentry(nestingLevel,((CllistContext)_localctx).ct.ast,offset--)) != null) {
										System.out.println("Var id "+(((CllistContext)_localctx).i!=null?((CllistContext)_localctx).i.getText():null)+" at line "+(((CllistContext)_localctx).i!=null?((CllistContext)_localctx).i.getLine():0)+" already declared");
							  			System.exit(0); } 
							}
							}
							setState(113); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==VAR );
						setState(115); match(IN);
						}
					}

					setState(119); ((CllistContext)_localctx).re = exp();

							m.addBody(((CllistContext)_localctx).re.ast);
							//rimuovere la hashmap corrente poich esco dallo scope*/               
							symTable.remove(nestingLevel--); 
					setState(121); match(SEMIC);
					}
					}
					setState(127);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(128); match(CRPAR);

						symTable.remove(nestingLevel--);
				}
				}
				setState(132); 
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
		public HotypeContext fty;
		public Token id;
		public HotypeContext ty;
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
			((DeclistContext)_localctx).astlist =  new ArrayList<Node>() ;
				   int offset=-2;
			setState(183); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(179);
				switch (_input.LA(1)) {
				case VAR:
					{
					setState(135); match(VAR);
					setState(136); ((DeclistContext)_localctx).i = match(ID);
					setState(137); match(COLON);
					setState(138); ((DeclistContext)_localctx).ht = hotype();
					setState(139); match(ASS);
					setState(140); ((DeclistContext)_localctx).e = exp();

							VarNode v = new VarNode((((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getText():null),((DeclistContext)_localctx).ht.ast,((DeclistContext)_localctx).e.ast);  
							_localctx.astlist.add(v);                                 
							HashMap<String,STentry> hm = symTable.get(nestingLevel);
							if ( hm.put((((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getText():null),new STentry(nestingLevel,((DeclistContext)_localctx).ht.ast,nestingLevel == 0 ? offset_0-- : offset--)) != null  )
							{
								System.out.println("Var id "+(((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getText():null)+" at line "+(((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getLine():0)+" already declared");
					              System.exit(0); } 
					}
					break;
				case FUN:
					{
					setState(143); match(FUN);
					setState(144); ((DeclistContext)_localctx).i = match(ID);
					setState(145); match(COLON);
					setState(146); ((DeclistContext)_localctx).t = type();
					//inserimento di ID nella symtable
							FunNode f = new FunNode((((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getText():null),((DeclistContext)_localctx).t.ast);      
							_localctx.astlist.add(f);                           
							HashMap<String,STentry> hm = symTable.get(nestingLevel);
							STentry entry = new STentry(nestingLevel, nestingLevel == 0 ? offset_0-- : offset--);
							if ( hm.put((((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getText():null),entry) != null  ) {
								System.out.println("Fun id "+(((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getText():null)+" at line "+(((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getLine():0)+" already declared");
								System.exit(0); }
							//creare una nuova hashmap per la symTable
							nestingLevel++;
							HashMap<String,STentry> hmn = new HashMap<String,STentry> ();
							symTable.add(hmn); 
					setState(148); match(LPAR);

							ArrayList<Node> parTypes = new ArrayList<Node>();
							int paroffset=1; 
					setState(165);
					_la = _input.LA(1);
					if (_la==ID) {
						{
						setState(150); ((DeclistContext)_localctx).fid = match(ID);
						setState(151); match(COLON);
						setState(152); ((DeclistContext)_localctx).fty = hotype();
						 
								parTypes.add(((DeclistContext)_localctx).fty.ast);
								ParNode fpar = new ParNode((((DeclistContext)_localctx).fid!=null?((DeclistContext)_localctx).fid.getText():null),((DeclistContext)_localctx).fty.ast); //creo nodo ParNode
								f.addPar(fpar);                                 //lo attacco al FunNode con addPar
						        if ( hmn.put((((DeclistContext)_localctx).fid!=null?((DeclistContext)_localctx).fid.getText():null),new STentry(nestingLevel,((DeclistContext)_localctx).fty.ast,paroffset++)) != null  ) //aggiungo dich a hmn
						        { System.out.println("Parameter id "+(((DeclistContext)_localctx).fid!=null?((DeclistContext)_localctx).fid.getText():null)+" at line "+(((DeclistContext)_localctx).fid!=null?((DeclistContext)_localctx).fid.getLine():0)+" already declared");
						        	System.exit(0);} 
						setState(162);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(154); match(COMMA);
							setState(155); ((DeclistContext)_localctx).id = match(ID);
							setState(156); match(COLON);
							setState(157); ((DeclistContext)_localctx).ty = hotype();

									parTypes.add(((DeclistContext)_localctx).ty.ast);
									ParNode par = new ParNode((((DeclistContext)_localctx).id!=null?((DeclistContext)_localctx).id.getText():null),((DeclistContext)_localctx).ty.ast);
							        f.addPar(par);
							        if ( hmn.put((((DeclistContext)_localctx).id!=null?((DeclistContext)_localctx).id.getText():null),new STentry(nestingLevel,((DeclistContext)_localctx).ty.ast,paroffset++)) != null  )
							        { System.out.println("Parameter id "+(((DeclistContext)_localctx).id!=null?((DeclistContext)_localctx).id.getText():null)+" at line "+(((DeclistContext)_localctx).id!=null?((DeclistContext)_localctx).id.getLine():0)+" already declared");
							        	System.exit(0);} 
							}
							}
							setState(164);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(167); match(RPAR);

							entry.addType(new ArrowTypeNode(parTypes,((DeclistContext)_localctx).t.ast)); 
					setState(174);
					_la = _input.LA(1);
					if (_la==LET) {
						{
						setState(169); match(LET);
						setState(170); ((DeclistContext)_localctx).d = declist();
						setState(171); match(IN);
						f.addDec(((DeclistContext)_localctx).d.astlist);
						}
					}

					setState(176); ((DeclistContext)_localctx).e = exp();

							f.addBody(((DeclistContext)_localctx).e.ast);
					        //rimuovere la hashmap corrente poich esco dallo scope               
					        symTable.remove(nestingLevel--); 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(181); match(SEMIC);
				}
				}
				setState(185); 
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
		public ArrowContext a;
		public TypeContext t;
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
			setState(193);
			switch (_input.LA(1)) {
			case LPAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(187); ((HotypeContext)_localctx).a = arrow();
				((HotypeContext)_localctx).ast =  ((HotypeContext)_localctx).a.ast;
				}
				break;
			case INT:
			case BOOL:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(190); ((HotypeContext)_localctx).t = type();
				((HotypeContext)_localctx).ast =  ((HotypeContext)_localctx).t.ast;
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
			setState(201);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(195); match(INT);
				((TypeContext)_localctx).ast = new IntTypeNode();
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(197); match(BOOL);
				((TypeContext)_localctx).ast = new BoolTypeNode();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(199); ((TypeContext)_localctx).i = match(ID);
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
			setState(203); match(LPAR);
			setState(212);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAR) | (1L << INT) | (1L << BOOL) | (1L << ID))) != 0)) {
				{
				setState(204); hotype();
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(205); match(COMMA);
					setState(206); hotype();
					}
					}
					setState(211);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(214); match(RPAR);
			setState(215); match(ARROW);
			setState(216); type();

					return null;
				
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
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(FOOLParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(FOOLParser.PLUS, i);
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
			setState(219); ((ExpContext)_localctx).f = term();
			((ExpContext)_localctx).ast =  ((ExpContext)_localctx).f.ast;
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS) {
				{
				{
				setState(221); match(PLUS);
				setState(222); ((ExpContext)_localctx).l = term();

						((ExpContext)_localctx).ast =  new PlusNode (_localctx.ast,((ExpContext)_localctx).l.ast); 
				}
				}
				setState(229);
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
		public TerminalNode TIMES(int i) {
			return getToken(FOOLParser.TIMES, i);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TerminalNode> TIMES() { return getTokens(FOOLParser.TIMES); }
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
			setState(230); ((TermContext)_localctx).f = factor();
			((TermContext)_localctx).ast =  ((TermContext)_localctx).f.ast;
			setState(238);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TIMES) {
				{
				{
				setState(232); match(TIMES);
				setState(233); ((TermContext)_localctx).l = factor();
				((TermContext)_localctx).ast =  new MultNode (_localctx.ast,((TermContext)_localctx).l.ast);
				}
				}
				setState(240);
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
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TerminalNode EQ(int i) {
			return getToken(FOOLParser.EQ, i);
		}
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
			setState(241); ((FactorContext)_localctx).f = value();
			((FactorContext)_localctx).ast =  ((FactorContext)_localctx).f.ast;
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EQ) {
				{
				{
				setState(243); match(EQ);
				setState(244); ((FactorContext)_localctx).l = value();
				((FactorContext)_localctx).ast =  new EqualNode (_localctx.ast,((FactorContext)_localctx).l.ast);
				}
				}
				setState(251);
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
		public Token i;
		public ExpContext fe;
		public ExpContext e;
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
		public TerminalNode NEW() { return getToken(FOOLParser.NEW, 0); }
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
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
			setState(346);
			switch (_input.LA(1)) {
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(252); ((ValueContext)_localctx).n = match(INTEGER);
				((ValueContext)_localctx).ast =  new IntNode(Integer.parseInt((((ValueContext)_localctx).n!=null?((ValueContext)_localctx).n.getText():null)));
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(254); match(TRUE);
				((ValueContext)_localctx).ast =  new BoolNode(true);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 3);
				{
				setState(256); match(FALSE);
				((ValueContext)_localctx).ast =  new BoolNode(false);
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 4);
				{
				setState(258); match(NULL);
				((ValueContext)_localctx).ast =  new EmptyNode();
				}
				break;
			case NEW:
				enterOuterAlt(_localctx, 5);
				{
				setState(260); match(NEW);
				setState(261); ((ValueContext)_localctx).i = match(ID);
				setState(262); match(LPAR);

						ArrayList<Node> parlist = new ArrayList<>();
						STentry entry = symTable.get(0).get((((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getText():null));
						if (entry == null) {
							System.out.println("Id "+(((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getText():null)+" at line "+(((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getLine():0)+" not declared");
				            System.exit(0);
				        }
						((ValueContext)_localctx).ast =  new NewNode((((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getText():null), entry, parlist, nestingLevel);
				setState(275);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAR) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << PRINT) | (1L << NEW) | (1L << NULL) | (1L << INTEGER) | (1L << ID))) != 0)) {
					{
					setState(264); ((ValueContext)_localctx).fe = exp();
					 parlist.add(((ValueContext)_localctx).fe.ast); 
					setState(272);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(266); match(COMMA);
						setState(267); ((ValueContext)_localctx).e = exp();
						 parlist.add(((ValueContext)_localctx).e.ast); 
						}
						}
						setState(274);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(277); match(RPAR);
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 6);
				{
				setState(278); match(IF);
				setState(279); ((ValueContext)_localctx).x = exp();
				setState(280); match(THEN);
				setState(281); match(CLPAR);
				setState(282); ((ValueContext)_localctx).y = exp();
				setState(283); match(CRPAR);
				setState(284); match(ELSE);
				setState(285); match(CLPAR);
				setState(286); ((ValueContext)_localctx).z = exp();
				setState(287); match(CRPAR);
				((ValueContext)_localctx).ast =  new IfNode(((ValueContext)_localctx).x.ast,((ValueContext)_localctx).y.ast,((ValueContext)_localctx).z.ast);
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 7);
				{
				setState(290); match(NOT);
				setState(291); match(LPAR);
				setState(292); exp();
				setState(293); match(RPAR);

				}
				break;
			case PRINT:
				enterOuterAlt(_localctx, 8);
				{
				setState(296); match(PRINT);
				setState(297); match(LPAR);
				setState(298); ((ValueContext)_localctx).e = exp();
				setState(299); match(RPAR);
				((ValueContext)_localctx).ast =  new PrintNode(((ValueContext)_localctx).e.ast);
				}
				break;
			case LPAR:
				enterOuterAlt(_localctx, 9);
				{
				setState(302); match(LPAR);
				setState(303); ((ValueContext)_localctx).e = exp();
				setState(304); match(RPAR);
				((ValueContext)_localctx).ast =  ((ValueContext)_localctx).e.ast;
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 10);
				{
				setState(307); ((ValueContext)_localctx).i = match(ID);
				//cercare la dichiarazione
						int j=nestingLevel;
						STentry entry=null; 
						while (j>=0 && entry==null)
							entry=(symTable.get(j--)).get((((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getText():null));
						if (entry==null) {
							System.out.println("Id "+(((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getText():null)+" at line "+(((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getLine():0)+" not declared");
				            System.exit(0);}               
						((ValueContext)_localctx).ast =  new IdNode((((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getText():null),entry,nestingLevel);
				setState(344);
				switch (_input.LA(1)) {
				case LPAR:
					{
					setState(309); match(LPAR);

							ArrayList<Node> arglist = new ArrayList<Node>(); 
					setState(322);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAR) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << PRINT) | (1L << NEW) | (1L << NULL) | (1L << INTEGER) | (1L << ID))) != 0)) {
						{
						setState(311); ((ValueContext)_localctx).a = exp();
						arglist.add(((ValueContext)_localctx).a.ast);
						setState(319);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(313); match(COMMA);
							setState(314); ((ValueContext)_localctx).a = exp();
							arglist.add(((ValueContext)_localctx).a.ast);
							}
							}
							setState(321);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(324); match(RPAR);
					((ValueContext)_localctx).ast =  new CallNode((((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getText():null),entry,arglist,nestingLevel);
					}
					break;
				case DOT:
					{
					setState(326); match(DOT);
					setState(327); ((ValueContext)_localctx).mi = match(ID);
					setState(328); match(LPAR);

							ArrayList<Node> parlist = new ArrayList<>();
							if (!(entry.getType() instanceof RefTypeNode)) {
								System.out.println("ID " + (((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getText():null) + " not instance of RefTypeNode at line " + (((ValueContext)_localctx).mi!=null?((ValueContext)_localctx).mi.getLine():0));
								System.exit(0);
							}
							RefTypeNode rtn = (RefTypeNode) entry.getType();
					        STentry methodEntry = null;
					        if (!classTable.get(rtn.getId()).containsKey((((ValueContext)_localctx).mi!=null?((ValueContext)_localctx).mi.getText():null))) {
								System.out.println("Method Id "+(((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getText():null)+" at line "+(((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getLine():0)+" not declared");
					            System.exit(0);
					        }
					        methodEntry = classTable.get(rtn.getId()).get((((ValueContext)_localctx).mi!=null?((ValueContext)_localctx).mi.getText():null));
					        ((ValueContext)_localctx).ast =  new ClassCallNode((((ValueContext)_localctx).mi!=null?((ValueContext)_localctx).mi.getText():null), entry, methodEntry, parlist, nestingLevel);
					setState(341);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAR) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << PRINT) | (1L << NEW) | (1L << NULL) | (1L << INTEGER) | (1L << ID))) != 0)) {
						{
						setState(330); ((ValueContext)_localctx).fe = exp();
						 parlist.add(((ValueContext)_localctx).fe.ast);
						setState(336);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(332); match(COMMA);
							setState(333); ((ValueContext)_localctx).e = exp();
							}
							}
							setState(338);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						parlist.add(((ValueContext)_localctx).e.ast);
						}
					}

					setState(343); match(RPAR);
					}
					break;
				case PLUS:
				case TIMES:
				case RPAR:
				case CRPAR:
				case SEMIC:
				case COMMA:
				case EQ:
				case THEN:
					break;
				default:
					throw new NoViableAltException(this);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3+\u015f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\36\n\2\3\2\5\2!\n\2\3\2\3\2\3\2\3"+
		"\2\5\2\'\n\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\63\n\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3B\n\3\f\3\16\3E\13\3"+
		"\5\3G\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\7\3^\n\3\f\3\16\3a\13\3\5\3c\n\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\6\3r\n\3\r\3\16\3s\3\3\3\3\5"+
		"\3x\n\3\3\3\3\3\3\3\3\3\7\3~\n\3\f\3\16\3\u0081\13\3\3\3\3\3\6\3\u0085"+
		"\n\3\r\3\16\3\u0086\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\u00a3\n\4\f"+
		"\4\16\4\u00a6\13\4\5\4\u00a8\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u00b1"+
		"\n\4\3\4\3\4\3\4\5\4\u00b6\n\4\3\4\3\4\6\4\u00ba\n\4\r\4\16\4\u00bb\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\5\5\u00c4\n\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00cc"+
		"\n\6\3\7\3\7\3\7\3\7\7\7\u00d2\n\7\f\7\16\7\u00d5\13\7\5\7\u00d7\n\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00e4\n\b\f\b\16\b\u00e7"+
		"\13\b\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00ef\n\t\f\t\16\t\u00f2\13\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\7\n\u00fa\n\n\f\n\16\n\u00fd\13\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\7\13\u0111\n\13\f\13\16\13\u0114\13\13\5\13\u0116\n\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u0140\n\13\f\13"+
		"\16\13\u0143\13\13\5\13\u0145\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\7\13\u0151\n\13\f\13\16\13\u0154\13\13\3\13\3\13\5\13"+
		"\u0158\n\13\3\13\5\13\u015b\n\13\5\13\u015d\n\13\3\13\2\2\f\2\4\6\b\n"+
		"\f\16\20\22\24\2\2\u017e\2\26\3\2\2\2\4+\3\2\2\2\6\u0088\3\2\2\2\b\u00c3"+
		"\3\2\2\2\n\u00cb\3\2\2\2\f\u00cd\3\2\2\2\16\u00dd\3\2\2\2\20\u00e8\3\2"+
		"\2\2\22\u00f3\3\2\2\2\24\u015c\3\2\2\2\26&\b\2\1\2\27\30\5\16\b\2\30\31"+
		"\b\2\1\2\31\'\3\2\2\2\32 \7\34\2\2\33\35\5\4\3\2\34\36\5\6\4\2\35\34\3"+
		"\2\2\2\35\36\3\2\2\2\36!\3\2\2\2\37!\5\6\4\2 \33\3\2\2\2 \37\3\2\2\2!"+
		"\"\3\2\2\2\"#\7\35\2\2#$\5\16\b\2$%\b\2\1\2%\'\3\2\2\2&\27\3\2\2\2&\32"+
		"\3\2\2\2\'(\3\2\2\2()\b\2\1\2)*\7\13\2\2*\3\3\2\2\2+\u0084\b\3\1\2,-\7"+
		" \2\2-.\7(\2\2.\62\b\3\1\2/\60\7!\2\2\60\61\7(\2\2\61\63\b\3\1\2\62/\3"+
		"\2\2\2\62\63\3\2\2\2\63\64\3\2\2\2\64\65\b\3\1\2\65\66\7\7\2\2\66F\b\3"+
		"\1\2\678\7(\2\289\7\f\2\29:\5\n\6\2:C\b\3\1\2;<\7\r\2\2<=\7(\2\2=>\7\f"+
		"\2\2>?\5\n\6\2?@\b\3\1\2@B\3\2\2\2A;\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2"+
		"\2\2DG\3\2\2\2EC\3\2\2\2F\67\3\2\2\2FG\3\2\2\2GH\3\2\2\2HI\7\b\2\2IJ\b"+
		"\3\1\2JK\7\t\2\2K\177\b\3\1\2LM\7\37\2\2MN\7(\2\2NO\7\f\2\2OP\5\n\6\2"+
		"PQ\b\3\1\2QR\7\7\2\2Rb\b\3\1\2ST\7(\2\2TU\7\f\2\2UV\5\b\5\2V_\b\3\1\2"+
		"WX\7\r\2\2XY\7(\2\2YZ\7\f\2\2Z[\5\b\5\2[\\\b\3\1\2\\^\3\2\2\2]W\3\2\2"+
		"\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`c\3\2\2\2a_\3\2\2\2bS\3\2\2\2bc\3\2\2"+
		"\2cd\3\2\2\2de\7\b\2\2ew\b\3\1\2fg\7\34\2\2gq\b\3\1\2hi\7\36\2\2ij\7("+
		"\2\2jk\7\f\2\2kl\5\n\6\2lm\7\25\2\2mn\5\16\b\2no\7\13\2\2op\b\3\1\2pr"+
		"\3\2\2\2qh\3\2\2\2rs\3\2\2\2sq\3\2\2\2st\3\2\2\2tu\3\2\2\2uv\7\35\2\2"+
		"vx\3\2\2\2wf\3\2\2\2wx\3\2\2\2xy\3\2\2\2yz\5\16\b\2z{\b\3\1\2{|\7\13\2"+
		"\2|~\3\2\2\2}L\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080"+
		"\u0082\3\2\2\2\u0081\177\3\2\2\2\u0082\u0083\7\n\2\2\u0083\u0085\b\3\1"+
		"\2\u0084,\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087"+
		"\3\2\2\2\u0087\5\3\2\2\2\u0088\u00b9\b\4\1\2\u0089\u008a\7\36\2\2\u008a"+
		"\u008b\7(\2\2\u008b\u008c\7\f\2\2\u008c\u008d\5\b\5\2\u008d\u008e\7\25"+
		"\2\2\u008e\u008f\5\16\b\2\u008f\u0090\b\4\1\2\u0090\u00b6\3\2\2\2\u0091"+
		"\u0092\7\37\2\2\u0092\u0093\7(\2\2\u0093\u0094\7\f\2\2\u0094\u0095\5\n"+
		"\6\2\u0095\u0096\b\4\1\2\u0096\u0097\7\7\2\2\u0097\u00a7\b\4\1\2\u0098"+
		"\u0099\7(\2\2\u0099\u009a\7\f\2\2\u009a\u009b\5\b\5\2\u009b\u00a4\b\4"+
		"\1\2\u009c\u009d\7\r\2\2\u009d\u009e\7(\2\2\u009e\u009f\7\f\2\2\u009f"+
		"\u00a0\5\b\5\2\u00a0\u00a1\b\4\1\2\u00a1\u00a3\3\2\2\2\u00a2\u009c\3\2"+
		"\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5"+
		"\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u0098\3\2\2\2\u00a7\u00a8\3\2"+
		"\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\7\b\2\2\u00aa\u00b0\b\4\1\2\u00ab"+
		"\u00ac\7\34\2\2\u00ac\u00ad\5\6\4\2\u00ad\u00ae\7\35\2\2\u00ae\u00af\b"+
		"\4\1\2\u00af\u00b1\3\2\2\2\u00b0\u00ab\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1"+
		"\u00b2\3\2\2\2\u00b2\u00b3\5\16\b\2\u00b3\u00b4\b\4\1\2\u00b4\u00b6\3"+
		"\2\2\2\u00b5\u0089\3\2\2\2\u00b5\u0091\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7"+
		"\u00b8\7\13\2\2\u00b8\u00ba\3\2\2\2\u00b9\u00b5\3\2\2\2\u00ba\u00bb\3"+
		"\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\7\3\2\2\2\u00bd\u00be"+
		"\5\f\7\2\u00be\u00bf\b\5\1\2\u00bf\u00c4\3\2\2\2\u00c0\u00c1\5\n\6\2\u00c1"+
		"\u00c2\b\5\1\2\u00c2\u00c4\3\2\2\2\u00c3\u00bd\3\2\2\2\u00c3\u00c0\3\2"+
		"\2\2\u00c4\t\3\2\2\2\u00c5\u00c6\7$\2\2\u00c6\u00cc\b\6\1\2\u00c7\u00c8"+
		"\7%\2\2\u00c8\u00cc\b\6\1\2\u00c9\u00ca\7(\2\2\u00ca\u00cc\b\6\1\2\u00cb"+
		"\u00c5\3\2\2\2\u00cb\u00c7\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc\13\3\2\2"+
		"\2\u00cd\u00d6\7\7\2\2\u00ce\u00d3\5\b\5\2\u00cf\u00d0\7\r\2\2\u00d0\u00d2"+
		"\5\b\5\2\u00d1\u00cf\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3"+
		"\u00d4\3\2\2\2\u00d4\u00d7\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00ce\3\2"+
		"\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\7\b\2\2\u00d9"+
		"\u00da\7&\2\2\u00da\u00db\5\n\6\2\u00db\u00dc\b\7\1\2\u00dc\r\3\2\2\2"+
		"\u00dd\u00de\5\20\t\2\u00de\u00e5\b\b\1\2\u00df\u00e0\7\3\2\2\u00e0\u00e1"+
		"\5\20\t\2\u00e1\u00e2\b\b\1\2\u00e2\u00e4\3\2\2\2\u00e3\u00df\3\2\2\2"+
		"\u00e4\u00e7\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\17"+
		"\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e8\u00e9\5\22\n\2\u00e9\u00f0\b\t\1\2"+
		"\u00ea\u00eb\7\5\2\2\u00eb\u00ec\5\22\n\2\u00ec\u00ed\b\t\1\2\u00ed\u00ef"+
		"\3\2\2\2\u00ee\u00ea\3\2\2\2\u00ef\u00f2\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0"+
		"\u00f1\3\2\2\2\u00f1\21\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f3\u00f4\5\24\13"+
		"\2\u00f4\u00fb\b\n\1\2\u00f5\u00f6\7\24\2\2\u00f6\u00f7\5\24\13\2\u00f7"+
		"\u00f8\b\n\1\2\u00f8\u00fa\3\2\2\2\u00f9\u00f5\3\2\2\2\u00fa\u00fd\3\2"+
		"\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\23\3\2\2\2\u00fd\u00fb"+
		"\3\2\2\2\u00fe\u00ff\7\'\2\2\u00ff\u015d\b\13\1\2\u0100\u0101\7\26\2\2"+
		"\u0101\u015d\b\13\1\2\u0102\u0103\7\27\2\2\u0103\u015d\b\13\1\2\u0104"+
		"\u0105\7#\2\2\u0105\u015d\b\13\1\2\u0106\u0107\7\"\2\2\u0107\u0108\7("+
		"\2\2\u0108\u0109\7\7\2\2\u0109\u0115\b\13\1\2\u010a\u010b\5\16\b\2\u010b"+
		"\u0112\b\13\1\2\u010c\u010d\7\r\2\2\u010d\u010e\5\16\b\2\u010e\u010f\b"+
		"\13\1\2\u010f\u0111\3\2\2\2\u0110\u010c\3\2\2\2\u0111\u0114\3\2\2\2\u0112"+
		"\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0116\3\2\2\2\u0114\u0112\3\2"+
		"\2\2\u0115\u010a\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0117\3\2\2\2\u0117"+
		"\u015d\7\b\2\2\u0118\u0119\7\30\2\2\u0119\u011a\5\16\b\2\u011a\u011b\7"+
		"\31\2\2\u011b\u011c\7\t\2\2\u011c\u011d\5\16\b\2\u011d\u011e\7\n\2\2\u011e"+
		"\u011f\7\32\2\2\u011f\u0120\7\t\2\2\u0120\u0121\5\16\b\2\u0121\u0122\7"+
		"\n\2\2\u0122\u0123\b\13\1\2\u0123\u015d\3\2\2\2\u0124\u0125\7\21\2\2\u0125"+
		"\u0126\7\7\2\2\u0126\u0127\5\16\b\2\u0127\u0128\7\b\2\2\u0128\u0129\b"+
		"\13\1\2\u0129\u015d\3\2\2\2\u012a\u012b\7\33\2\2\u012b\u012c\7\7\2\2\u012c"+
		"\u012d\5\16\b\2\u012d\u012e\7\b\2\2\u012e\u012f\b\13\1\2\u012f\u015d\3"+
		"\2\2\2\u0130\u0131\7\7\2\2\u0131\u0132\5\16\b\2\u0132\u0133\7\b\2\2\u0133"+
		"\u0134\b\13\1\2\u0134\u015d\3\2\2\2\u0135\u0136\7(\2\2\u0136\u015a\b\13"+
		"\1\2\u0137\u0138\7\7\2\2\u0138\u0144\b\13\1\2\u0139\u013a\5\16\b\2\u013a"+
		"\u0141\b\13\1\2\u013b\u013c\7\r\2\2\u013c\u013d\5\16\b\2\u013d\u013e\b"+
		"\13\1\2\u013e\u0140\3\2\2\2\u013f\u013b\3\2\2\2\u0140\u0143\3\2\2\2\u0141"+
		"\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0145\3\2\2\2\u0143\u0141\3\2"+
		"\2\2\u0144\u0139\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0146\3\2\2\2\u0146"+
		"\u0147\7\b\2\2\u0147\u015b\b\13\1\2\u0148\u0149\7\16\2\2\u0149\u014a\7"+
		"(\2\2\u014a\u014b\7\7\2\2\u014b\u0157\b\13\1\2\u014c\u014d\5\16\b\2\u014d"+
		"\u0152\b\13\1\2\u014e\u014f\7\r\2\2\u014f\u0151\5\16\b\2\u0150\u014e\3"+
		"\2\2\2\u0151\u0154\3\2\2\2\u0152\u0150\3\2\2\2\u0152\u0153\3\2\2\2\u0153"+
		"\u0155\3\2\2\2\u0154\u0152\3\2\2\2\u0155\u0156\b\13\1\2\u0156\u0158\3"+
		"\2\2\2\u0157\u014c\3\2\2\2\u0157\u0158\3\2\2\2\u0158\u0159\3\2\2\2\u0159"+
		"\u015b\7\b\2\2\u015a\u0137\3\2\2\2\u015a\u0148\3\2\2\2\u015a\u015b\3\2"+
		"\2\2\u015b\u015d\3\2\2\2\u015c\u00fe\3\2\2\2\u015c\u0100\3\2\2\2\u015c"+
		"\u0102\3\2\2\2\u015c\u0104\3\2\2\2\u015c\u0106\3\2\2\2\u015c\u0118\3\2"+
		"\2\2\u015c\u0124\3\2\2\2\u015c\u012a\3\2\2\2\u015c\u0130\3\2\2\2\u015c"+
		"\u0135\3\2\2\2\u015d\25\3\2\2\2\"\35 &\62CF_bsw\177\u0086\u00a4\u00a7"+
		"\u00b0\u00b5\u00bb\u00c3\u00cb\u00d3\u00d6\u00e5\u00f0\u00fb\u0112\u0115"+
		"\u0141\u0144\u0152\u0157\u015a\u015c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}