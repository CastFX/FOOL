push 0
/*ClassCode:*/

/*ClassNode: A*/
lhp
push function0
lhp
sw
push 1
lhp
add
shp

/*ClassNode: B*/
lhp
push function1
lhp
sw
push 1
lhp
add
shp

/*ClassNode: C*/
lhp
push function2
lhp
sw
push 1
lhp
add
shp

/*ClassNode: D*/
lhp
push function3
lhp
sw
push 1
lhp
add
shp

/*ClassNode: E*/
lhp
push function4
lhp
sw
push 1
lhp
add
shp

/*ClassNode: F*/
lhp
push function5
lhp
sw
push 1
lhp
add
shp

/*ClassNode: G*/
lhp
push function6
lhp
sw
push 1
lhp
add
shp

/*ClassNode: Z*/
lhp
push function7
lhp
sw
push 1
lhp
add
shp

/*DeclCode:*/
push 9998
lw
lhp
sw
lhp
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
push 9993
lw
lhp
sw
lhp
push 1
lhp
add
shp
push 9994
lw
lhp
sw
lhp
push 1
lhp
add
shp
push 9992
lw
lhp
sw
lhp
push 1
lhp
add
shp
push 1
/*IfNode, check if topStack == 1*/
push 1
beq label0
push -1
b label1
label0: 
push -1
label1: 

/*ExpCod(ProgLetIn):*/

ClassCallNode: getFucked:
lfp
/*Risalita AR*/
lfp
push -15
add
lw
/*Risalita AR*/
lfp
push -15
add
lw
lw
push 0
add
lw
js
print
halt

/*MethodNode: getFucked*/
function0:
cfp
lra
push 1
srv
sra
pop
sfp
lrv
lra
js

/*MethodNode: getFucked*/
function1:
cfp
lra
push 2
srv
sra
pop
sfp
lrv
lra
js

/*MethodNode: getFucked*/
function2:
cfp
lra
push 3
srv
sra
pop
sfp
lrv
lra
js

/*MethodNode: getFucked*/
function3:
cfp
lra
push 4
srv
sra
pop
sfp
lrv
lra
js

/*MethodNode: getFucked*/
function4:
cfp
lra
push 5
srv
sra
pop
sfp
lrv
lra
js

/*MethodNode: getFucked*/
function5:
cfp
lra
push 6
srv
sra
pop
sfp
lrv
lra
js

/*MethodNode: getFucked*/
function6:
cfp
lra
push 7
srv
sra
pop
sfp
lrv
lra
js

/*MethodNode: getFucked*/
function7:
cfp
lra
push 8
srv
sra
pop
sfp
lrv
lra
js
