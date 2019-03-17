push 0
lhp
lhp

lfp
push function0
lfp
push function1
push 998
lw
lhp
sw
lhp
push 1
lhp
add
shp
push 997
lw
lhp
sw
lhp
push 1
lhp
add
shp

push 1
push 1
bleq label2
push 0
b label3
label2: 
push 1
label3: 
push 1
beq label0
push 1
b label1
label0: 
push 0
label1: 
print
halt

function0:
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
