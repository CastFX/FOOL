push 0
/*ClassCode:*/

/*ClassNode: List*/
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

/*DeclCode:*/
lfp
push function3
lfp
push function4
lfp
push function5
lfp
push function8
lfp
push function9
lfp
push function10
push 2
push 1
push 4
push 3
push 2
push 5
push -1
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
push 9998
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
push 9998
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
push 9998
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

/*ExpCod(ProgLetIn):*/
lfp
lfp
push -11
lfp
add
lw
push -12
lfp
add
lw
push -15
lfp
add
lw
push -9
lfp
add
lw
push -10
lfp
add
lw
js
push -3
lfp
add
lw
push -4
lfp
add
lw
js
halt

/*MethodNode: first*/
function0:
cfp
lra
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

/*MethodNode: rest*/
function1:
cfp
lra
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

/*FunNode: makeList*/
function2:
cfp
lra
push 2
lfp
add
lw
push 1
lfp
add
lw
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
push 9998
lw
lhp
sw
lhp
push 1
lhp
add
shp
srv
sra
pop
pop
pop
sfp
lrv
lra
js

/*FunNode: printList*/
function3:
cfp
lra
lfp
push function2
push 1
lfp
add
lw
push -1
/*EqualsNode*/
beq label2
push 0
b label3
label2: 
push 1
label3: 
/*IfNode, check if topStack == 1*/
push 1
beq label0
lfp

ClassCallNode: first:
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
print
lfp

ClassCallNode: rest:
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
push -3
lfp
lw
add
lw
push -4
lfp
lw
add
lw
js
push -2
lfp
add
lw
push -3
lfp
add
lw
js
b label1
label0: 
push -1
label1: 
srv
pop
pop
sra
pop
pop
sfp
lrv
lra
js

/*FunNode: append*/
function4:
cfp
lra
push 1
lfp
add
lw
push -1
/*EqualsNode*/
beq label6
push 0
b label7
label6: 
push 1
label7: 
/*IfNode, check if topStack == 1*/
push 1
beq label4

ClassCallNode: first:
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
lfp
push 2
lfp
add
lw

ClassCallNode: rest:
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
push -5
lfp
lw
add
lw
push -6
lfp
lw
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
push 9998
lw
lhp
sw
lhp
push 1
lhp
add
shp
b label5
label4: 
push 2
lfp
add
lw
label5: 
srv
sra
pop
pop
pop
sfp
lrv
lra
js

/*FunNode: filter*/
function5:
cfp
lra
push 1
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
lfp

ClassCallNode: first:
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
push 3
lfp
add
lw
push 2
lfp
add
lw
js
/*IfNode, check if topStack == 1*/
push 1
beq label12
lfp
push 3
lfp
add
lw
push 2
lfp
add
lw

ClassCallNode: rest:
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
push -7
lfp
lw
add
lw
push -8
lfp
lw
add
lw
js
b label13
label12: 

ClassCallNode: first:
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
lfp
push 3
lfp
add
lw
push 2
lfp
add
lw

ClassCallNode: rest:
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
push -7
lfp
lw
add
lw
push -8
lfp
lw
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
push 9998
lw
lhp
sw
lhp
push 1
lhp
add
shp
label13: 
b label9
label8: 
push -1
label9: 
srv
sra
pop
pop
pop
pop
sfp
lrv
lra
js

/*FunNode: beforePivot*/
function6:
cfp
lra
lfp
push -2
lfp
lw
add
lw
push 1
lfp
add
lw
push 3
lfp
lw
add
lw
push 2
lfp
lw
add
lw
js
srv
sra
pop
pop
sfp
lrv
lra
js

/*FunNode: afterPivot*/
function7:
cfp
lra
lfp
push -2
lfp
lw
add
lw
push 1
lfp
add
lw
push 3
lfp
lw
add
lw
push 2
lfp
lw
add
lw
js
push 1
beq label18
push 1
b label19
label18: 
push 0
label19: 
srv
sra
pop
pop
sfp
lrv
lra
js

/*FunNode: quicksort*/
function8:
cfp
lra
push 1
lfp
add
lw
push -1
/*EqualsNode*/
beq label16
push 0
b label17
label16: 
push 1
label17: 
/*IfNode, check if topStack == 1*/
push 1
beq label14

ClassCallNode: first:
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
b label15
label14: 
push 0
label15: 
lfp
push function6
lfp
push function7
push 1
lfp
add
lw
push -1
/*EqualsNode*/
beq label22
push 0
b label23
label22: 
push 1
label23: 
/*IfNode, check if topStack == 1*/
push 1
beq label20
lfp
push -2
lfp
add
lw
lfp
push 3
lfp
add
lw
push 2
lfp
add
lw
lfp
push -5
lfp
add
lw
push -6
lfp
add
lw

ClassCallNode: rest:
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
push -7
lfp
lw
add
lw
push -8
lfp
lw
add
lw
js
push -9
lfp
lw
add
lw
push -10
lfp
lw
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
push 9998
lw
lhp
sw
lhp
push 1
lhp
add
shp
lfp
push 3
lfp
add
lw
push 2
lfp
add
lw
lfp
push -3
lfp
add
lw
push -4
lfp
add
lw

ClassCallNode: rest:
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
push -7
lfp
lw
add
lw
push -8
lfp
lw
add
lw
js
push -9
lfp
lw
add
lw
push -10
lfp
lw
add
lw
js
push -5
lfp
lw
add
lw
push -6
lfp
lw
add
lw
js
b label21
label20: 
push -1
label21: 
srv
pop
pop
pop
pop
pop
sra
pop
pop
pop
pop
sfp
lrv
lra
js

/*FunNode: inc*/
function9:
cfp
lra
push 1
lfp
add
lw
push 2
lfp
add
lw
bleq label24
push 0
b label25
label24: 
push 1
label25: 
srv
sra
pop
pop
pop
sfp
lrv
lra
js

/*FunNode: dec*/
function10:
cfp
lra
push 2
lfp
add
lw
push 1
lfp
add
lw
bleq label26
push 0
b label27
label26: 
push 1
label27: 
srv
sra
pop
pop
pop
sfp
lrv
lra
js
