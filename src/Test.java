import java.io.BufferedWriter;
import java.io.FileWriter;

import org.antlr.v4.runtime.*;

import ast.Node;

public class Test {
    public static void main(String[] args) throws Exception {
      
        String fileName = "prova.fool";
      
        CharStream chars = CharStreams.fromFileName(fileName);
        FOOLLexer lexer = new FOOLLexer(chars);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FOOLParser parser = new FOOLParser(tokens);
        
        Node ast = parser.prog().ast; //generazione AST con Id associate a relative entry symbol table
        
        System.out.println("You had: "+lexer.lexicalErrors+" lexical errors and "+parser.getNumberOfSyntaxErrors()+" syntax errors.");

        System.out.println("Visualizing AST...");
        System.out.print(ast.toPrint(""));
        
        Node type=ast.typeCheck(); //type-checking bottom-up
        System.out.println(type.toPrint("Type checking ok! Type of the program is: "));  
        
        // CODE GENERATION  prova.fool.asm
        String code=ast.codeGeneration(); 
        BufferedWriter out = new BufferedWriter(new FileWriter(fileName+".asm")); 
        out.write(code);
        out.close(); 
        System.out.println("Code generated! Assembling and running generated code.");

        CharStream charsASM = CharStreams.fromFileName(fileName+".asm");
        SVMLexer lexerASM = new SVMLexer(charsASM);
        CommonTokenStream tokensASM = new CommonTokenStream(lexerASM);
        SVMParser parserASM = new SVMParser(tokensASM); 
        
        parserASM.assembly();
        
        System.out.println("You had: "+lexerASM.lexicalErrors+" lexical errors and "+parserASM.getNumberOfSyntaxErrors()+" syntax errors.");
        if (lexerASM.lexicalErrors>0 || parserASM.getNumberOfSyntaxErrors()>0) System.exit(1);

        System.out.println("Starting Virtual Machine...");
        ExecuteVM vm = new ExecuteVM(parserASM.code);
        vm.cpu();
       
    }
}
