// Generated from FOOL.g4 by ANTLR 4.4

import java.util.ArrayList;
import java.util.HashMap;
import ast.*;

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
		COLON=1, COMMA=2, ASS=3, SEMIC=4, EQ=5, PLUS=6, TIMES=7, INTEGER=8, TRUE=9, 
		FALSE=10, LPAR=11, RPAR=12, CLPAR=13, CRPAR=14, IF=15, THEN=16, ELSE=17, 
		PRINT=18, LET=19, IN=20, VAR=21, FUN=22, CLASS=23, EXT=24, NEW=25, INT=26, 
		BOOL=27, ID=28, WHITESP=29, COMMENT=30, ERR=31;
	public static final String[] tokenNames = {
		"<INVALID>", "':'", "','", "'='", "';'", "'=='", "'+'", "'*'", "INTEGER", 
		"'true'", "'false'", "'('", "')'", "'{'", "'}'", "'if'", "'then'", "'else'", 
		"'print'", "'let'", "'in'", "'var'", "'fun'", "'class'", "'extends'", 
		"'new'", "'int'", "'bool'", "ID", "WHITESP", "COMMENT", "ERR"
	};
	public static final int
		RULE_prog = 0, RULE_declist = 1, RULE_varfunlist = 2, RULE_type = 3, RULE_exp = 4, 
		RULE_term = 5, RULE_factor = 6, RULE_value = 7;
	public static final String[] ruleNames = {
		"prog", "declist", "varfunlist", "type", "exp", "term", "factor", "value"
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
		public DeclistContext d;
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			HashMap<String,STentry> hm = new HashMap<String,STentry> ();
			       symTable.add(hm);
			setState(26);
			switch (_input.LA(1)) {
			case INTEGER:
			case TRUE:
			case FALSE:
			case LPAR:
			case IF:
			case PRINT:
			case ID:
				{
				setState(17); ((ProgContext)_localctx).e = exp();
				((ProgContext)_localctx).ast =  new ProgNode(((ProgContext)_localctx).e.ast);
				}
				break;
			case LET:
				{
				setState(20); match(LET);
				setState(21); ((ProgContext)_localctx).d = declist();
				setState(22); match(IN);
				setState(23); ((ProgContext)_localctx).e = exp();
				((ProgContext)_localctx).ast =  new ProgLetInNode(((ProgContext)_localctx).d.astlist,((ProgContext)_localctx).e.ast);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			symTable.remove(nestingLevel);
			setState(29); match(SEMIC);
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
		public Token fid;
		public TypeContext fty;
		public Token id;
		public TypeContext ty;
		public Token im;
		public TypeContext tm;
		public VarfunlistContext v;
		public ExpContext e;
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
		public TerminalNode COMMA(int i) {
			return getToken(FOOLParser.COMMA, i);
		}
		public List<VarfunlistContext> varfunlist() {
			return getRuleContexts(VarfunlistContext.class);
		}
		public TerminalNode RPAR(int i) {
			return getToken(FOOLParser.RPAR, i);
		}
		public List<TerminalNode> ID() { return getTokens(FOOLParser.ID); }
		public TerminalNode CLPAR(int i) {
			return getToken(FOOLParser.CLPAR, i);
		}
		public TerminalNode SEMIC(int i) {
			return getToken(FOOLParser.SEMIC, i);
		}
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
		public VarfunlistContext varfunlist(int i) {
			return getRuleContext(VarfunlistContext.class,i);
		}
		public List<TerminalNode> COLON() { return getTokens(FOOLParser.COLON); }
		public TerminalNode FUN(int i) {
			return getToken(FOOLParser.FUN, i);
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
		public DeclistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declist; }
	}

	public final DeclistContext declist() throws RecognitionException {
		DeclistContext _localctx = new DeclistContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((DeclistContext)_localctx).astlist =  new ArrayList<Node>();
					int offset = -2;
			{
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASS) {
				{
				{
				setState(32); match(CLASS);
				setState(33); ((DeclistContext)_localctx).i = match(ID);

						ClassNode c = new ClassNode((((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getText():null));
						_localctx.astlist.add(c);
				        HashMap<String,STentry> virtualTable = new HashMap<String,STentry> ();
				        nestingLevel++;
				        symTable.add(virtualTable);
				        ClassTypeNode ctn = new ClassTypeNode(new ArrayList<Node>(), new ArrayList<Node>());
				        classTable.put((((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getText():null), virtualTable);
				        STentry entry = new STentry(0, ctn, offset--);
				        if (symTable.get(0).put((((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getText():null), entry) != null) { //niente override tra classi
				        	System.out.println("Class id "+(((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getText():null)+" at line "+(((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getLine():0)+" already declared");
				            System.exit(0); } 
				setState(35); match(LPAR);
				 /*START_Fields*/
						ArrayList<Node> fieldTypes = new ArrayList<Node>();
				    	int fieldOffset = -1; 
				setState(52);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(37); ((DeclistContext)_localctx).fid = match(ID);
					setState(38); match(COLON);
					setState(39); ((DeclistContext)_localctx).fty = type();

							fieldTypes.add(((DeclistContext)_localctx).fty.ast);
						    FieldNode ffield = new FieldNode((((DeclistContext)_localctx).fid!=null?((DeclistContext)_localctx).fid.getText():null),((DeclistContext)_localctx).fty.ast);
						    c.addField(ffield);
						    ctn.insertFieldType(((DeclistContext)_localctx).fty.ast, -fieldOffset - 1);
						    if (virtualTable.containsKey((((DeclistContext)_localctx).fid!=null?((DeclistContext)_localctx).fid.getText():null))) { //Enable Field Override
						    	STentry oldSTentry = virtualTable.get((((DeclistContext)_localctx).fid!=null?((DeclistContext)_localctx).fid.getText():null));
						    	if (oldSTentry.isMethod()){ //Disable Field Override from Method
						    		System.out.println("Field id "+(((DeclistContext)_localctx).fid!=null?((DeclistContext)_localctx).fid.getText():null)+" at line "+(((DeclistContext)_localctx).fid!=null?((DeclistContext)_localctx).fid.getLine():0)+" already declared as method");
					        		System.exit(0);
						    	} else {
							    	virtualTable.put((((DeclistContext)_localctx).fid!=null?((DeclistContext)_localctx).fid.getText():null), new STentry(nestingLevel, ((DeclistContext)_localctx).fty.ast, oldSTentry.getOffset()));
						    	}
						    } else {
						    	virtualTable.put((((DeclistContext)_localctx).fid!=null?((DeclistContext)_localctx).fid.getText():null), new STentry(nestingLevel, ((DeclistContext)_localctx).fty.ast, fieldOffset--));
						    } 
					setState(49);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(41); match(COMMA);
						setState(42); ((DeclistContext)_localctx).id = match(ID);
						setState(43); match(COLON);
						setState(44); ((DeclistContext)_localctx).ty = type();

						    	fieldTypes.add(((DeclistContext)_localctx).ty.ast);
						    	FieldNode field = new FieldNode((((DeclistContext)_localctx).id!=null?((DeclistContext)_localctx).id.getText():null), ((DeclistContext)_localctx).ty.ast);
						    	c.addField(field);
							    ctn.insertFieldType(((DeclistContext)_localctx).ty.ast, -offset - 1);
							    if (virtualTable.containsKey((((DeclistContext)_localctx).id!=null?((DeclistContext)_localctx).id.getText():null))) { //Enable Field Override
							    	STentry oldSTentry = virtualTable.get((((DeclistContext)_localctx).id!=null?((DeclistContext)_localctx).id.getText():null));
							    	if (oldSTentry.isMethod()){ //Disable Field Override from Method
							    		System.out.println("Field id "+(((DeclistContext)_localctx).id!=null?((DeclistContext)_localctx).id.getText():null)+" at line "+(((DeclistContext)_localctx).id!=null?((DeclistContext)_localctx).id.getLine():0)+" already declared as method");
						        		System.exit(0);
							    	} else {
								    	virtualTable.put((((DeclistContext)_localctx).id!=null?((DeclistContext)_localctx).id.getText():null), new STentry(nestingLevel, ((DeclistContext)_localctx).ty.ast, oldSTentry.getOffset()));
							    	}
							    } else {
							    	virtualTable.put((((DeclistContext)_localctx).id!=null?((DeclistContext)_localctx).id.getText():null), new STentry(nestingLevel, ((DeclistContext)_localctx).ty.ast, fieldOffset--));
							    } 
						}
						}
						setState(51);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(54); match(RPAR);

				setState(56); match(CLPAR);
					ArrayList<Node> methodTypes = new ArrayList<Node>(); 
						int methodOffset = 0; 
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==FUN) {
					{
					{
					setState(58); match(FUN);
					setState(59); ((DeclistContext)_localctx).im = match(ID);
					setState(60); match(COLON);
					setState(61); ((DeclistContext)_localctx).tm = type();

							//inserimento di ID nella symtable
							MethodNode m = new MethodNode((((DeclistContext)_localctx).im!=null?((DeclistContext)_localctx).im.getText():null),((DeclistContext)_localctx).tm.ast);      
							c.addMethod(m);
						    ctn.insertMethodType(((DeclistContext)_localctx).tm.ast, methodOffset);                            
						    if (virtualTable.containsKey((((DeclistContext)_localctx).im!=null?((DeclistContext)_localctx).im.getText():null))) { //Enable Method Override
						    	STentry oldSTentry = virtualTable.get((((DeclistContext)_localctx).im!=null?((DeclistContext)_localctx).im.getText():null));
						    	if (!oldSTentry.isMethod()){ //Disable Method Override from Field
						    		System.out.println("Field id "+(((DeclistContext)_localctx).im!=null?((DeclistContext)_localctx).im.getText():null)+" at line "+(((DeclistContext)_localctx).im!=null?((DeclistContext)_localctx).im.getLine():0)+" already declared as method");
					        		System.exit(0);
						    	} else {
							    	virtualTable.put((((DeclistContext)_localctx).im!=null?((DeclistContext)_localctx).im.getText():null), new STentry(nestingLevel, ((DeclistContext)_localctx).tm.ast, oldSTentry.getOffset(), true));
						    	}
						    } else {
						    	virtualTable.put((((DeclistContext)_localctx).im!=null?((DeclistContext)_localctx).im.getText():null), new STentry(nestingLevel, ((DeclistContext)_localctx).tm.ast, methodOffset++, true));
						    }
					        //TODO verificare creare una nuova hashmap per la symTable
					        nestingLevel++;
					        HashMap<String,STentry> hmn = new HashMap<String,STentry> ();
					        symTable.add(hmn); 
					setState(63); match(LPAR);
					 
							ArrayList<Node> parTypes = new ArrayList<Node>();
							int paroffset=1; 
					setState(80);
					_la = _input.LA(1);
					if (_la==ID) {
						{
						setState(65); ((DeclistContext)_localctx).fid = match(ID);
						setState(66); match(COLON);
						setState(67); ((DeclistContext)_localctx).fty = type();
						 
								parTypes.add(((DeclistContext)_localctx).fty.ast);
								ParNode fpar = new ParNode((((DeclistContext)_localctx).fid!=null?((DeclistContext)_localctx).fid.getText():null),((DeclistContext)_localctx).fty.ast); //creo nodo ParNode
								m.addPar(fpar);                                 //lo attacco al FunNode con addPar
								if ( hmn.put((((DeclistContext)_localctx).fid!=null?((DeclistContext)_localctx).fid.getText():null),new STentry(nestingLevel,((DeclistContext)_localctx).fty.ast,paroffset++)) != null  ) //aggiungo dich a hmn
								{ System.out.println("Parameter id "+(((DeclistContext)_localctx).fid!=null?((DeclistContext)_localctx).fid.getText():null)+" at line "+(((DeclistContext)_localctx).fid!=null?((DeclistContext)_localctx).fid.getLine():0)+" already declared");
									System.exit(0); } 
						setState(77);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(69); match(COMMA);
							setState(70); ((DeclistContext)_localctx).id = match(ID);
							setState(71); match(COLON);
							setState(72); ((DeclistContext)_localctx).ty = type();

									parTypes.add(((DeclistContext)_localctx).ty.ast);
									ParNode par = new ParNode((((DeclistContext)_localctx).id!=null?((DeclistContext)_localctx).id.getText():null),((DeclistContext)_localctx).ty.ast);
									m.addPar(par);
									if ( hmn.put((((DeclistContext)_localctx).id!=null?((DeclistContext)_localctx).id.getText():null),new STentry(nestingLevel,((DeclistContext)_localctx).ty.ast,paroffset++)) != null  )
									{ System.out.println("Parameter id "+(((DeclistContext)_localctx).id!=null?((DeclistContext)_localctx).id.getText():null)+" at line "+(((DeclistContext)_localctx).id!=null?((DeclistContext)_localctx).id.getLine():0)+" already declared");
										System.exit(0); } 
							}
							}
							setState(79);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(82); match(RPAR);
					/*entry.addType(new ArrowTypeNode(parTypes,$tm.ast));*/
					setState(89);
					_la = _input.LA(1);
					if (_la==LET) {
						{
						setState(84); match(LET);
						setState(85); ((DeclistContext)_localctx).v = varfunlist();
						setState(86); match(IN);
						m.addDec(((DeclistContext)_localctx).v.astlist);
						}
					}

					setState(91); ((DeclistContext)_localctx).e = exp();

					  		m.addBody(((DeclistContext)_localctx).e.ast);
							/*(ok: pag.36) rimuovere la hashmap corrente poich esco dallo scope*/               
							symTable.remove(nestingLevel--); 
					setState(93); match(SEMIC);
					}
					}
					setState(99);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(100); match(CRPAR);
				entry.addType(new ClassTypeNode(fieldTypes, methodTypes));
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(107); ((DeclistContext)_localctx).v = varfunlist();

			  		_localctx.astlist.addAll(((DeclistContext)_localctx).v.astlist); 
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

	public static class VarfunlistContext extends ParserRuleContext {
		public ArrayList<Node> astlist;
		public Token i;
		public TypeContext t;
		public ExpContext e;
		public Token fid;
		public TypeContext fty;
		public Token id;
		public TypeContext ty;
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
		public VarfunlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varfunlist; }
	}

	public final VarfunlistContext varfunlist() throws RecognitionException {
		VarfunlistContext _localctx = new VarfunlistContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_varfunlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((VarfunlistContext)_localctx).astlist =  new ArrayList<Node>() ;
				   int offset=-2;
			setState(159); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(155);
				switch (_input.LA(1)) {
				case VAR:
					{
					setState(111); match(VAR);
					setState(112); ((VarfunlistContext)_localctx).i = match(ID);
					setState(113); match(COLON);
					setState(114); ((VarfunlistContext)_localctx).t = type();
					setState(115); match(ASS);
					setState(116); ((VarfunlistContext)_localctx).e = exp();

							VarNode v = new VarNode((((VarfunlistContext)_localctx).i!=null?((VarfunlistContext)_localctx).i.getText():null),((VarfunlistContext)_localctx).t.ast,((VarfunlistContext)_localctx).e.ast);  
							_localctx.astlist.add(v);                                 
							HashMap<String,STentry> hm = symTable.get(nestingLevel);
							if ( hm.put((((VarfunlistContext)_localctx).i!=null?((VarfunlistContext)_localctx).i.getText():null),new STentry(nestingLevel,((VarfunlistContext)_localctx).t.ast,offset--)) != null  )
							{
								System.out.println("Var id "+(((VarfunlistContext)_localctx).i!=null?((VarfunlistContext)_localctx).i.getText():null)+" at line "+(((VarfunlistContext)_localctx).i!=null?((VarfunlistContext)_localctx).i.getLine():0)+" already declared");
					              System.exit(0); } 
					}
					break;
				case FUN:
					{
					setState(119); match(FUN);
					setState(120); ((VarfunlistContext)_localctx).i = match(ID);
					setState(121); match(COLON);
					setState(122); ((VarfunlistContext)_localctx).t = type();
					//inserimento di ID nella symtable
							FunNode f = new FunNode((((VarfunlistContext)_localctx).i!=null?((VarfunlistContext)_localctx).i.getText():null),((VarfunlistContext)_localctx).t.ast);      
							_localctx.astlist.add(f);                              
							HashMap<String,STentry> hm = symTable.get(nestingLevel);
							STentry entry = new STentry(nestingLevel, offset--);
							if ( hm.put((((VarfunlistContext)_localctx).i!=null?((VarfunlistContext)_localctx).i.getText():null),entry) != null  ) {
								System.out.println("Fun id "+(((VarfunlistContext)_localctx).i!=null?((VarfunlistContext)_localctx).i.getText():null)+" at line "+(((VarfunlistContext)_localctx).i!=null?((VarfunlistContext)_localctx).i.getLine():0)+" already declared");
								System.exit(0); }
							//creare una nuova hashmap per la symTable
							nestingLevel++;
							HashMap<String,STentry> hmn = new HashMap<String,STentry> ();
							symTable.add(hmn); 
					setState(124); match(LPAR);

							ArrayList<Node> parTypes = new ArrayList<Node>();
							int paroffset=1; 
					setState(141);
					_la = _input.LA(1);
					if (_la==ID) {
						{
						setState(126); ((VarfunlistContext)_localctx).fid = match(ID);
						setState(127); match(COLON);
						setState(128); ((VarfunlistContext)_localctx).fty = type();
						 
								parTypes.add(((VarfunlistContext)_localctx).fty.ast);
								ParNode fpar = new ParNode((((VarfunlistContext)_localctx).fid!=null?((VarfunlistContext)_localctx).fid.getText():null),((VarfunlistContext)_localctx).fty.ast); //creo nodo ParNode
								f.addPar(fpar);                                 //lo attacco al FunNode con addPar
						        if ( hmn.put((((VarfunlistContext)_localctx).fid!=null?((VarfunlistContext)_localctx).fid.getText():null),new STentry(nestingLevel,((VarfunlistContext)_localctx).fty.ast,paroffset++)) != null  ) //aggiungo dich a hmn
						        { System.out.println("Parameter id "+(((VarfunlistContext)_localctx).fid!=null?((VarfunlistContext)_localctx).fid.getText():null)+" at line "+(((VarfunlistContext)_localctx).fid!=null?((VarfunlistContext)_localctx).fid.getLine():0)+" already declared");
						        	System.exit(0);} 
						setState(138);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(130); match(COMMA);
							setState(131); ((VarfunlistContext)_localctx).id = match(ID);
							setState(132); match(COLON);
							setState(133); ((VarfunlistContext)_localctx).ty = type();

									parTypes.add(((VarfunlistContext)_localctx).ty.ast);
									ParNode par = new ParNode((((VarfunlistContext)_localctx).id!=null?((VarfunlistContext)_localctx).id.getText():null),((VarfunlistContext)_localctx).ty.ast);
							        f.addPar(par);
							        if ( hmn.put((((VarfunlistContext)_localctx).id!=null?((VarfunlistContext)_localctx).id.getText():null),new STentry(nestingLevel,((VarfunlistContext)_localctx).ty.ast,paroffset++)) != null  )
							        { System.out.println("Parameter id "+(((VarfunlistContext)_localctx).id!=null?((VarfunlistContext)_localctx).id.getText():null)+" at line "+(((VarfunlistContext)_localctx).id!=null?((VarfunlistContext)_localctx).id.getLine():0)+" already declared");
							        	System.exit(0);} 
							}
							}
							setState(140);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(143); match(RPAR);

							entry.addType(new ArrowTypeNode(parTypes,((VarfunlistContext)_localctx).t.ast)); 
					setState(150);
					_la = _input.LA(1);
					if (_la==LET) {
						{
						setState(145); match(LET);
						setState(146); ((VarfunlistContext)_localctx).d = declist();
						setState(147); match(IN);
						f.addDec(((VarfunlistContext)_localctx).d.astlist);
						}
					}

					setState(152); ((VarfunlistContext)_localctx).e = exp();

							f.addBody(((VarfunlistContext)_localctx).e.ast);
					        //rimuovere la hashmap corrente poich esco dallo scope               
					        symTable.remove(nestingLevel--); 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(157); match(SEMIC);
				}
				}
				setState(161); 
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

	public static class TypeContext extends ParserRuleContext {
		public Node ast;
		public TerminalNode BOOL() { return getToken(FOOLParser.BOOL, 0); }
		public TerminalNode INT() { return getToken(FOOLParser.INT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		try {
			setState(167);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(163); match(INT);
				((TypeContext)_localctx).ast = new IntTypeNode();
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(165); match(BOOL);
				((TypeContext)_localctx).ast = new BoolTypeNode();
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
		enterRule(_localctx, 8, RULE_exp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169); ((ExpContext)_localctx).f = term();
			((ExpContext)_localctx).ast =  ((ExpContext)_localctx).f.ast;
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS) {
				{
				{
				setState(171); match(PLUS);
				setState(172); ((ExpContext)_localctx).l = term();

						((ExpContext)_localctx).ast =  new PlusNode (_localctx.ast,((ExpContext)_localctx).l.ast); 
				}
				}
				setState(179);
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
		enterRule(_localctx, 10, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180); ((TermContext)_localctx).f = factor();
			((TermContext)_localctx).ast =  ((TermContext)_localctx).f.ast;
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TIMES) {
				{
				{
				setState(182); match(TIMES);
				setState(183); ((TermContext)_localctx).l = factor();
				((TermContext)_localctx).ast =  new MultNode (_localctx.ast,((TermContext)_localctx).l.ast);
				}
				}
				setState(190);
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
		enterRule(_localctx, 12, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191); ((FactorContext)_localctx).f = value();
			((FactorContext)_localctx).ast =  ((FactorContext)_localctx).f.ast;
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EQ) {
				{
				{
				setState(193); match(EQ);
				setState(194); ((FactorContext)_localctx).l = value();
				((FactorContext)_localctx).ast =  new EqualNode (_localctx.ast,((FactorContext)_localctx).l.ast);
				}
				}
				setState(201);
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
		public ExpContext x;
		public ExpContext y;
		public ExpContext z;
		public Token i;
		public ExpContext a;
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
		public TerminalNode LPAR() { return getToken(FOOLParser.LPAR, 0); }
		public List<TerminalNode> CLPAR() { return getTokens(FOOLParser.CLPAR); }
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(FOOLParser.COMMA, i);
		}
		public TerminalNode ID() { return getToken(FOOLParser.ID, 0); }
		public TerminalNode CLPAR(int i) {
			return getToken(FOOLParser.CLPAR, i);
		}
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
		enterRule(_localctx, 14, RULE_value);
		int _la;
		try {
			setState(252);
			switch (_input.LA(1)) {
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(202); ((ValueContext)_localctx).n = match(INTEGER);
				((ValueContext)_localctx).ast =  new IntNode(Integer.parseInt((((ValueContext)_localctx).n!=null?((ValueContext)_localctx).n.getText():null)));
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(204); match(TRUE);
				((ValueContext)_localctx).ast =  new BoolNode(true);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 3);
				{
				setState(206); match(FALSE);
				((ValueContext)_localctx).ast =  new BoolNode(false);
				}
				break;
			case LPAR:
				enterOuterAlt(_localctx, 4);
				{
				setState(208); match(LPAR);
				setState(209); ((ValueContext)_localctx).e = exp();
				setState(210); match(RPAR);
				((ValueContext)_localctx).ast =  ((ValueContext)_localctx).e.ast;
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 5);
				{
				setState(213); match(IF);
				setState(214); ((ValueContext)_localctx).x = exp();
				setState(215); match(THEN);
				setState(216); match(CLPAR);
				setState(217); ((ValueContext)_localctx).y = exp();
				setState(218); match(CRPAR);
				setState(219); match(ELSE);
				setState(220); match(CLPAR);
				setState(221); ((ValueContext)_localctx).z = exp();
				setState(222); match(CRPAR);
				((ValueContext)_localctx).ast =  new IfNode(((ValueContext)_localctx).x.ast,((ValueContext)_localctx).y.ast,((ValueContext)_localctx).z.ast);
				}
				break;
			case PRINT:
				enterOuterAlt(_localctx, 6);
				{
				setState(225); match(PRINT);
				setState(226); match(LPAR);
				setState(227); ((ValueContext)_localctx).e = exp();
				setState(228); match(RPAR);
				((ValueContext)_localctx).ast =  new PrintNode(((ValueContext)_localctx).e.ast);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 7);
				{
				setState(231); ((ValueContext)_localctx).i = match(ID);
				//cercare la dichiarazione
				           int j=nestingLevel;
				           STentry entry=null; 
				           while (j>=0 && entry==null)
				             entry=(symTable.get(j--)).get((((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getText():null));
				           if (entry==null)
				           {System.out.println("Id "+(((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getText():null)+" at line "+(((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getLine():0)+" not declared");
				            System.exit(0);}               
					   ((ValueContext)_localctx).ast =  new IdNode((((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getText():null),entry,nestingLevel);
				setState(250);
				_la = _input.LA(1);
				if (_la==LPAR) {
					{
					setState(233); match(LPAR);
					ArrayList<Node> arglist = new ArrayList<Node>();
					setState(246);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << IF) | (1L << PRINT) | (1L << ID))) != 0)) {
						{
						setState(235); ((ValueContext)_localctx).a = exp();
						arglist.add(((ValueContext)_localctx).a.ast);
						setState(243);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(237); match(COMMA);
							setState(238); ((ValueContext)_localctx).a = exp();
							arglist.add(((ValueContext)_localctx).a.ast);
							}
							}
							setState(245);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(248); match(RPAR);
					((ValueContext)_localctx).ast =  new CallNode((((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getText():null),entry,arglist,nestingLevel);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3!\u0101\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\5\2\35\n\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\62\n\3\f\3\16\3\65\13\3"+
		"\5\3\67\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3N\n\3\f\3\16\3Q\13\3\5\3S\n\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\5\3\\\n\3\3\3\3\3\3\3\3\3\7\3b\n\3\f\3\16\3e\13\3\3"+
		"\3\3\3\7\3i\n\3\f\3\16\3l\13\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\7\4\u008b\n\4\f\4\16\4\u008e\13\4\5\4\u0090\n\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\5\4\u0099\n\4\3\4\3\4\3\4\5\4\u009e\n\4\3\4\3\4\6\4\u00a2"+
		"\n\4\r\4\16\4\u00a3\3\5\3\5\3\5\3\5\5\5\u00aa\n\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\7\6\u00b2\n\6\f\6\16\6\u00b5\13\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u00bd"+
		"\n\7\f\7\16\7\u00c0\13\7\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00c8\n\b\f\b\16"+
		"\b\u00cb\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00f4\n\t\f\t\16\t\u00f7\13\t\5\t\u00f9"+
		"\n\t\3\t\3\t\5\t\u00fd\n\t\5\t\u00ff\n\t\3\t\2\2\n\2\4\6\b\n\f\16\20\2"+
		"\2\u0112\2\22\3\2\2\2\4!\3\2\2\2\6p\3\2\2\2\b\u00a9\3\2\2\2\n\u00ab\3"+
		"\2\2\2\f\u00b6\3\2\2\2\16\u00c1\3\2\2\2\20\u00fe\3\2\2\2\22\34\b\2\1\2"+
		"\23\24\5\n\6\2\24\25\b\2\1\2\25\35\3\2\2\2\26\27\7\25\2\2\27\30\5\4\3"+
		"\2\30\31\7\26\2\2\31\32\5\n\6\2\32\33\b\2\1\2\33\35\3\2\2\2\34\23\3\2"+
		"\2\2\34\26\3\2\2\2\35\36\3\2\2\2\36\37\b\2\1\2\37 \7\6\2\2 \3\3\2\2\2"+
		"!j\b\3\1\2\"#\7\31\2\2#$\7\36\2\2$%\b\3\1\2%&\7\r\2\2&\66\b\3\1\2\'(\7"+
		"\36\2\2()\7\3\2\2)*\5\b\5\2*\63\b\3\1\2+,\7\4\2\2,-\7\36\2\2-.\7\3\2\2"+
		"./\5\b\5\2/\60\b\3\1\2\60\62\3\2\2\2\61+\3\2\2\2\62\65\3\2\2\2\63\61\3"+
		"\2\2\2\63\64\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\66\'\3\2\2\2\66\67\3"+
		"\2\2\2\678\3\2\2\289\7\16\2\29:\b\3\1\2:;\7\17\2\2;c\b\3\1\2<=\7\30\2"+
		"\2=>\7\36\2\2>?\7\3\2\2?@\5\b\5\2@A\b\3\1\2AB\7\r\2\2BR\b\3\1\2CD\7\36"+
		"\2\2DE\7\3\2\2EF\5\b\5\2FO\b\3\1\2GH\7\4\2\2HI\7\36\2\2IJ\7\3\2\2JK\5"+
		"\b\5\2KL\b\3\1\2LN\3\2\2\2MG\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2PS\3"+
		"\2\2\2QO\3\2\2\2RC\3\2\2\2RS\3\2\2\2ST\3\2\2\2TU\7\16\2\2U[\b\3\1\2VW"+
		"\7\25\2\2WX\5\6\4\2XY\7\26\2\2YZ\b\3\1\2Z\\\3\2\2\2[V\3\2\2\2[\\\3\2\2"+
		"\2\\]\3\2\2\2]^\5\n\6\2^_\b\3\1\2_`\7\6\2\2`b\3\2\2\2a<\3\2\2\2be\3\2"+
		"\2\2ca\3\2\2\2cd\3\2\2\2df\3\2\2\2ec\3\2\2\2fg\7\20\2\2gi\b\3\1\2h\"\3"+
		"\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2km\3\2\2\2lj\3\2\2\2mn\5\6\4\2no\b"+
		"\3\1\2o\5\3\2\2\2p\u00a1\b\4\1\2qr\7\27\2\2rs\7\36\2\2st\7\3\2\2tu\5\b"+
		"\5\2uv\7\5\2\2vw\5\n\6\2wx\b\4\1\2x\u009e\3\2\2\2yz\7\30\2\2z{\7\36\2"+
		"\2{|\7\3\2\2|}\5\b\5\2}~\b\4\1\2~\177\7\r\2\2\177\u008f\b\4\1\2\u0080"+
		"\u0081\7\36\2\2\u0081\u0082\7\3\2\2\u0082\u0083\5\b\5\2\u0083\u008c\b"+
		"\4\1\2\u0084\u0085\7\4\2\2\u0085\u0086\7\36\2\2\u0086\u0087\7\3\2\2\u0087"+
		"\u0088\5\b\5\2\u0088\u0089\b\4\1\2\u0089\u008b\3\2\2\2\u008a\u0084\3\2"+
		"\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d"+
		"\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0080\3\2\2\2\u008f\u0090\3\2"+
		"\2\2\u0090\u0091\3\2\2\2\u0091\u0092\7\16\2\2\u0092\u0098\b\4\1\2\u0093"+
		"\u0094\7\25\2\2\u0094\u0095\5\4\3\2\u0095\u0096\7\26\2\2\u0096\u0097\b"+
		"\4\1\2\u0097\u0099\3\2\2\2\u0098\u0093\3\2\2\2\u0098\u0099\3\2\2\2\u0099"+
		"\u009a\3\2\2\2\u009a\u009b\5\n\6\2\u009b\u009c\b\4\1\2\u009c\u009e\3\2"+
		"\2\2\u009dq\3\2\2\2\u009dy\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\7\6"+
		"\2\2\u00a0\u00a2\3\2\2\2\u00a1\u009d\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3"+
		"\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\7\3\2\2\2\u00a5\u00a6\7\34\2"+
		"\2\u00a6\u00aa\b\5\1\2\u00a7\u00a8\7\35\2\2\u00a8\u00aa\b\5\1\2\u00a9"+
		"\u00a5\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\t\3\2\2\2\u00ab\u00ac\5\f\7\2"+
		"\u00ac\u00b3\b\6\1\2\u00ad\u00ae\7\b\2\2\u00ae\u00af\5\f\7\2\u00af\u00b0"+
		"\b\6\1\2\u00b0\u00b2\3\2\2\2\u00b1\u00ad\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3"+
		"\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\13\3\2\2\2\u00b5\u00b3\3\2\2"+
		"\2\u00b6\u00b7\5\16\b\2\u00b7\u00be\b\7\1\2\u00b8\u00b9\7\t\2\2\u00b9"+
		"\u00ba\5\16\b\2\u00ba\u00bb\b\7\1\2\u00bb\u00bd\3\2\2\2\u00bc\u00b8\3"+
		"\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf"+
		"\r\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c2\5\20\t\2\u00c2\u00c9\b\b\1"+
		"\2\u00c3\u00c4\7\7\2\2\u00c4\u00c5\5\20\t\2\u00c5\u00c6\b\b\1\2\u00c6"+
		"\u00c8\3\2\2\2\u00c7\u00c3\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3\2"+
		"\2\2\u00c9\u00ca\3\2\2\2\u00ca\17\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00cd"+
		"\7\n\2\2\u00cd\u00ff\b\t\1\2\u00ce\u00cf\7\13\2\2\u00cf\u00ff\b\t\1\2"+
		"\u00d0\u00d1\7\f\2\2\u00d1\u00ff\b\t\1\2\u00d2\u00d3\7\r\2\2\u00d3\u00d4"+
		"\5\n\6\2\u00d4\u00d5\7\16\2\2\u00d5\u00d6\b\t\1\2\u00d6\u00ff\3\2\2\2"+
		"\u00d7\u00d8\7\21\2\2\u00d8\u00d9\5\n\6\2\u00d9\u00da\7\22\2\2\u00da\u00db"+
		"\7\17\2\2\u00db\u00dc\5\n\6\2\u00dc\u00dd\7\20\2\2\u00dd\u00de\7\23\2"+
		"\2\u00de\u00df\7\17\2\2\u00df\u00e0\5\n\6\2\u00e0\u00e1\7\20\2\2\u00e1"+
		"\u00e2\b\t\1\2\u00e2\u00ff\3\2\2\2\u00e3\u00e4\7\24\2\2\u00e4\u00e5\7"+
		"\r\2\2\u00e5\u00e6\5\n\6\2\u00e6\u00e7\7\16\2\2\u00e7\u00e8\b\t\1\2\u00e8"+
		"\u00ff\3\2\2\2\u00e9\u00ea\7\36\2\2\u00ea\u00fc\b\t\1\2\u00eb\u00ec\7"+
		"\r\2\2\u00ec\u00f8\b\t\1\2\u00ed\u00ee\5\n\6\2\u00ee\u00f5\b\t\1\2\u00ef"+
		"\u00f0\7\4\2\2\u00f0\u00f1\5\n\6\2\u00f1\u00f2\b\t\1\2\u00f2\u00f4\3\2"+
		"\2\2\u00f3\u00ef\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5"+
		"\u00f6\3\2\2\2\u00f6\u00f9\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8\u00ed\3\2"+
		"\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fb\7\16\2\2\u00fb"+
		"\u00fd\b\t\1\2\u00fc\u00eb\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00ff\3\2"+
		"\2\2\u00fe\u00cc\3\2\2\2\u00fe\u00ce\3\2\2\2\u00fe\u00d0\3\2\2\2\u00fe"+
		"\u00d2\3\2\2\2\u00fe\u00d7\3\2\2\2\u00fe\u00e3\3\2\2\2\u00fe\u00e9\3\2"+
		"\2\2\u00ff\21\3\2\2\2\27\34\63\66OR[cj\u008c\u008f\u0098\u009d\u00a3\u00a9"+
		"\u00b3\u00be\u00c9\u00f5\u00f8\u00fc\u00fe";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}