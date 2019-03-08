push 0
/*ClassCode:*/

/*ClassNode: Account*/
lhp
push function0
lhp
sw
push 1
lhp
add
shp

/*ClassNode: TradingAcc*/
lhp
push function0
lhp
sw
push 1
lhp
add
shp
push function1
lhp
sw
push 1
lhp
add
shp

/*ClassNode: BankLoan*/
lhp
push function2
lhp
sw
push 1
lhp
add
shp
push function3
lhp
sw
push 1
lhp
add
shp

/*ClassNode: MyBankLoan*/
lhp
push function2
lhp
sw
push 1
lhp
add
shp
push function4
lhp
sw
push 1
lhp
add
shp

/*DeclCode:*/
push 50000
push 40000
lhp
sw
push 1
lhp
add
shp
lhp
sw
push 1
lhp
add
shp
push 9997
lw
lhp
sw
lhp
push 1
lhp
add
shp
lhp
sw
push 1
lhp
add
shp
push 9995
lw
lhp
sw
lhp
push 1
lhp
add
shp
push 20000
push 5000
lhp
sw
push 1
lhp
add
shp
lhp
sw
push 1
lhp
add
shp
push 9997
lw
lhp
sw
lhp
push 1
lhp
add
shp

ClassCallNode: openLoan:
lfp
/*IdNode: myTradingAcc*/
push -7
lfp
add
lw
/*Risalita AR*/
lfp
push -6
add
lw
/*Risalita AR*/
lfp
push -6
add
lw
lw
push 1
add
lw
js

/*ExpCod(ProgLetIn):*/
/*IdNode: myLoan*/
push -8
lfp
add
lw
push -1
/*EqualsNode*/
beq label10
push 0
b label11
label10: 
push 1
label11: 
/*IfNode, check if topStack == 1*/
push 1
beq label8

ClassCallNode: getMon:
lfp
/*Risalita AR*/
lfp
push -8
add
lw
/*Risalita AR*/
lfp
push -8
add
lw
lw
push 0
add
lw
js
b label9
label8: 
push 0
label9: 
print
halt

/*MethodNode: getMon*/
function0:
cfp
lra
/*IdNode: money*/
push -1
lfp
lw
add
lw
srv
sra
pop
sfp
lrv
lra
js

/*MethodNode: getInv*/
function1:
cfp
lra
/*IdNode: invested*/
push -2
lfp
lw
add
lw
srv
sra
pop
sfp
lrv
lra
js

/*MethodNode: getLoan*/
function2:
cfp
lra
/*IdNode: loan*/
push -1
lfp
lw
add
lw
srv
sra
pop
sfp
lrv
lra
js

/*MethodNode: openLoan*/
function3:
cfp
lra
push 30000

ClassCallNode: getMon:
lfp
/*Risalita AR*/
lfp
push 1
add
lw
/*Risalita AR*/
lfp
push 1
add
lw
lw
push 0
add
lw
js

ClassCallNode: getInv:
lfp
/*Risalita AR*/
lfp
push 1
add
lw
/*Risalita AR*/
lfp
push 1
add
lw
lw
push 1
add
lw
js
add
bleq label2
push 0
b label3
label2: 
push 1
label3: 
/*IfNode, check if topStack == 1*/
push 1
beq label0
push -1
b label1
label0: 

ClassCallNode: getMon:
lfp
/*Risalita AR*/
lfp
lw
push -1
add
lw
/*Risalita AR*/
lfp
lw
push -1
add
lw
lw
push 0
add
lw
js
lhp
sw
push 1
lhp
add
shp
push 9998
lw
lhp
sw
lhp
push 1
lhp
add
shp
label1: 
srv
sra
pop
pop
sfp
lrv
lra
js

/*MethodNode: openLoan*/
function4:
cfp
lra
push 20000

ClassCallNode: getMon:
lfp
/*Risalita AR*/
lfp
push 1
add
lw
/*Risalita AR*/
lfp
push 1
add
lw
lw
push 0
add
lw
js
bleq label6
push 0
b label7
label6: 
push 1
label7: 
/*IfNode, check if topStack == 1*/
push 1
beq label4
push -1
b label5
label4: 

ClassCallNode: getMon:
lfp
/*Risalita AR*/
lfp
lw
push -1
add
lw
/*Risalita AR*/
lfp
lw
push -1
add
lw
lw
push 0
add
lw
js

ClassCallNode: getInv:
lfp
/*Risalita AR*/
lfp
lw
push -1
add
lw
/*Risalita AR*/
lfp
lw
push -1
add
lw
lw
push 1
add
lw
js
lhp
sw
push 1
lhp
add
shp
lhp
sw
push 1
lhp
add
shp
push 9997
lw
lhp
sw
lhp
push 1
lhp
add
shp
label5: 
srv
sra
pop
pop
sfp
lrv
lra
js
