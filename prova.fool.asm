push 0
/*ClassCode:*/

/*ClassNode: B*/
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
push function4
lhp
sw
push 1
lhp
add
shp
push function5
lhp
sw
push 1
lhp
add
shp

/*DeclCode:*/
push 96
lw
lhp
sw
lhp
push 1
lhp
add
shp
push 9
push 10
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
push 97
lw
lhp
sw
lhp
push 1
lhp
add
shp
push function6

/*ExpCod(ProgLetIn):*/
/*CallNode: funTest()*/
lfp
/*IdNode: var1*/
push -5
lfp
add
lw
lfp
push -7
lfp
add
lw
js
print
halt

/*MethodNode: test*/
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

/*MethodNode: test2*/
function1:
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

/*MethodNode: notTest*/
function2:
cfp
lra
push 0
srv
sra
pop
sfp
lrv
lra
js

/*MethodNode: x*/
function3:
cfp
lra
/*IdNode: t1*/
push 1
lfp
add
lw
/*IdNode: t2*/
push 2
lfp
add
lw
beq label0
push 0
b label1
label0: 
push 1
label1: 
srv
sra
pop
pop
pop
sfp
lrv
lra
js

/*MethodNode: y*/
function4:
cfp
lra
/*IdNode: t1*/
push 1
lfp
add
lw
push 1
/*IdNode: t2*/
push 2
lfp
add
lw
beq label2
push 0
b label3
label2: 
push 1
label3: 
add
srv
sra
pop
pop
pop
sfp
lrv
lra
js

/*MethodNode: z*/
function5:
cfp
lra
/*IdNode: t1*/
push 1
lfp
add
lw
srv
sra
pop
pop
sfp
lrv
lra
js

/*FunNode: funTest*/
function6:
cfp
lra

ClassCallNode: x:
lfp
push 1
push 1
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
lw
push 0
add
js
srv
sra
pop
pop
sfp
lrv
lra
js
