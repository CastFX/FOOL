push 0
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

lfp
push function2
lfp
push function3
lfp
push function4
push -1

lfp
push -5
lfp
add
lw
push -6
lfp
add
lw
lfp
push -9
lfp
add
lw
push -7
lfp
add
lw
push -8
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
print
halt

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

function2:
cfp
lra
lfp
push 1
lfp
add
lw
push 3
lfp
add
lw
push 2
lfp
add
lw
js
push 1
beq label0
lfp
lfp
push 1
add
lw
lfp
push 1
add
lw
lw
push 1
add
lw
js
b label1
label0: 
lfp
lfp
push 1
add
lw
lfp
push 1
add
lw
lw
push 0
add
lw
js
label1: 
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

function3:
cfp
lra
lfp
lfp
push 1
add
lw
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
lfp
push 1
add
lw
lfp
push 1
add
lw
lw
push 1
add
lw
js
beq label4
push 0
b label5
label4: 
push 1
label5: 
push 1
beq label2
push 0
b label3
label2: 
push 1
label3: 
srv
sra
pop
pop
sfp
lrv
lra
js

function4:
cfp
lra
push 1
lfp
add
lw
push -1
beq label8
push 0
b label9
label8: 
push 1
label9: 
push 1
beq label6
push 1
lfp
add
lw
b label7
label6: 
push 1
push 1
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
push 998
lw
lhp
sw
lhp
push 1
lhp
add
shp
label7: 
srv
sra
pop
pop
sfp
lrv
lra
js
