push 0
/*ClassCode:*/

/*DeclCode:*/
lfp
push function0
lfp
push function2

/*ExpCod(ProgLetIn):*/
lfp
push 2
push -4
lfp
add
lw
push -5
lfp
add
lw
js
print
halt

/*FunNode: g*/
function0:
cfp
lra
lfp
push 7
push 5
push 2
lfp
add
lw
push 1
lfp
add
lw
js
srv
sra
pop
pop
pop
sfp
lrv
lra
js

/*FunNode: linsum*/
function1:
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
add
push 1
lfp
lw
add
lw
mult
srv
sra
pop
pop
pop
sfp
lrv
lra
js

/*FunNode: f*/
function2:
cfp
lra
lfp
push function1
lfp
push -2
lfp
add
lw
push -3
lfp
add
lw
push -2
lfp
lw
add
lw
push -3
lfp
lw
add
lw
js
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
