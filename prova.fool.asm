push 0
lfp
push 1
push 1
push 1
lfp
push -4
lfp
add
lw
js
lfp
push 2
push 0
push 2
lfp
push -4
lfp
add
lw
js
push 5
push 2
add
push function0
lfp
push -4
lfp
add
lw
lfp
lfp
push -2
lfp
add
lw
js
lfp
push -5
lfp
add
lw
js
push 1
beq label2
lfp
lfp
push -2
lfp
add
lw
js
b label3
label2: 
lfp
lfp
push -2
lfp
add
lw
js
label3: 
print
halt

function0:
cfp
lra
push 2
lfp
add
lw
push -2
lfp
add
lw
push -4
lfp
lw
add
lw
beq label0
push 0
b label1
label0: 
push 1
label1: 
srv
pop
sra
pop
pop
pop
sfp
lrv
lra
js
