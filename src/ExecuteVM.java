import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lib.FOOLlib;

public class ExecuteVM {

    public static final int CODESIZE = 10000;
    private static final int MEMSIZE = FOOLlib.MEMSIZE;

    private int[] code;
    private int[] memory = new int[MEMSIZE];

    private int ip = 0;
    private int sp = MEMSIZE;

    private int hp = 0;
    private int fp = MEMSIZE;
    private int ra;
    private int rv;
    private int cycleCounter = 0;
    private List<String> istrList = new ArrayList<>();

    public ExecuteVM(int[] code) {
        this.code = code;
    }

    public void cpu() {
        while (true) {
            cycleCounter++;
            int bytecode = code[ip++]; // fetch
            int v1, v2;
            int address;
            switch (bytecode) {
            case SVMParser.PUSH:
                try {
                    push(code[ip++]);
                    istrList.add("PUSH " + code[ip-1] + getHeapAndStack());
                } catch (Exception e) {
                    System.out.println("exception at ip:" + (ip - 1) + ", cycle: " + cycleCounter);
                }
                break;
            case SVMParser.POP:
                pop();
                istrList.add("POP= " + memory[sp-1] + "SP: " + (sp) + getHeapAndStack());
                break;
            case SVMParser.ADD:
                v1 = pop();
                v2 = pop();
                push(v2 + v1);
                istrList.add("ADD" + getHeapAndStack());
                break;
            case SVMParser.MULT:
                v1 = pop();
                v2 = pop();
                push(v2 * v1);
                istrList.add("MULT" + getHeapAndStack());
                break;
            case SVMParser.DIV:
                v1 = pop();
                v2 = pop();
                push(v2 / v1);
                istrList.add("DIV= " + getHeapAndStack());
                break;
            case SVMParser.SUB:
                v1 = pop();
                v2 = pop();
                push(v2 - v1);
                istrList.add("SUB= " + getHeapAndStack());
                break;
            case SVMParser.STOREW: //
                address = pop();
                int value = pop();
                try {
                    memory[address] = value;
                    istrList.add("SW: MEM[ " + address + "]=" + value + (address < MEMSIZE/2 ? getHeapPlusAndStack(1) : getHeapAndStack()));
                } catch (Exception e) {
                    istrList.add("SW: MEM[ " + address + "]=" + value + (address < MEMSIZE/2 ? getHeapPlusAndStack(1) : getHeapAndStack()));
                    try {
                        FileWriter writer = new FileWriter("output.txt");
                        for (String str : istrList) {
                            writer.write(str);
                        }
                        writer.close();
                    } catch (IOException ex) {
                    }
                    System.out.println("exception at address:" + address + ", cycle: " + cycleCounter);
                    System.exit(0);
                }
                break;
            case SVMParser.LOADW: //
                int addr = pop();
                try {
                    push(memory[addr]);
                    istrList.add("LOADW=(PUSH " + addr + ")" + getHeapAndStack());

                } catch (Exception e) {
                    istrList.add("LOADW=(PUSH " + memory[sp] + ")" + getHeapAndStack());
                    writeToFile();
                    e.printStackTrace();
                    System.out.println("sp: " + sp + ", " + Arrays.toString(memory));
                    System.out.println("exception at address:" + addr + ", cycle: " + cycleCounter);
                    //System.out.println("istrList: " + istrList);
                    System.exit(0);
                }
                break;
            case SVMParser.BRANCH:
                address = code[ip];
                ip = address;
                istrList.add("BRANCH: " + code[ip] + getHeapAndStack());
                break;
            case SVMParser.BRANCHEQ: //
                address = code[ip++];
                v1 = pop();
                v2 = pop();
                if (v2 == v1)
                    ip = address;
                istrList.add("BRANCHEQ: " + code[ip-1] + getHeapAndStack());
                break;
            case SVMParser.BRANCHLESSEQ:
                address = code[ip++];
                v1 = pop();
                v2 = pop();
                if (v2 <= v1)
                    ip = address;
                istrList.add("BRANCHLESSEQ: " + code[ip-1] + getHeapAndStack());
                break;
            case SVMParser.JS: //
                address = pop();
                ra = ip;
                // System.out.println("js: address=" + address + "memory address
                // -1:" + memory[sp-1] + ", -2:" + memory[sp-2]);
                ip = address;
                istrList.add("JS. ADDR= " + memory[sp-1] + ",RA: " + ra + getHeapAndStack());
                break;
            case SVMParser.STORERA: //
                ra = pop();
                istrList.add("STORERA: " + memory[sp-1] + getHeapAndStack());
                break;
            case SVMParser.LOADRA: //
                push(ra);
                istrList.add("LOADRA: PUSH " + ra + getHeapAndStack());
                break;
            case SVMParser.STORERV: //
                rv = pop();
                istrList.add("STORERV: " + memory[sp-1] + getHeapAndStack());
                break;
            case SVMParser.LOADRV: //
                push(rv);
                istrList.add("LOADRV: PUSH " + rv + getHeapAndStack());
                break;
            case SVMParser.LOADFP: //
                push(fp);
                istrList.add("LOADFP: PUSH " + fp + getHeapAndStack());
                break;
            case SVMParser.STOREFP: //
                fp = pop();
                istrList.add("STOREFP: " + memory[sp-1] + getHeapAndStack());
                break;
            case SVMParser.COPYFP: //
                fp = sp;
                istrList.add("COPYFP: FP=" + sp + getHeapAndStack());
                break;
            case SVMParser.STOREHP: //
                hp = pop();
                istrList.add("STOREHP: " + memory[sp-1] + getHeapAndStack());
                break;
            case SVMParser.LOADHP: //
                push(hp);
                istrList.add("LOADHP: PUSH " + hp + getHeapAndStack());
                break;
            case SVMParser.PRINT:
                System.out.println((sp < MEMSIZE) ? memory[sp] : "Empty stack!");
                istrList.add("PRINT " + ((sp < MEMSIZE) ? memory[sp] : "Empty stack!") + getHeapAndStack());
                break;
            case SVMParser.HALT:
                istrList.add("HALT" + getHeapAndStack());
                writeToFile();
                return;
            }
        }
    }
    private String getHeapPlusAndStack(int plusHeap) {
        //System.out.println("sp: " + sp);
        return "\nHeap: " + Arrays.toString(Arrays.copyOfRange(memory, 0, hp + plusHeap)) + "  Stack: " 
                + (sp >= 0 ? Arrays.toString(Arrays.copyOfRange(memory, sp, MEMSIZE)) : "")
                + "\n\n";
    }
    
    private String getHeapAndStack() {
        return getHeapPlusAndStack(0);
    }
    
    private void writeToFile() {
        try {
            FileWriter writer = new FileWriter("output.txt");
            for (String str : istrList) {
                writer.write(str);
            }
            writer.close();
        } catch (IOException e ) { }
    }

    private int pop() {
        return memory[sp++];
    }

    private void push(int v) {
        if (v == 1000) {
            // System.out.println(cycleCounter);
            // Thread.dumpStack();
        }
        try {memory[--sp] = v;}
        catch (Exception e) { writeToFile();}
    }
}