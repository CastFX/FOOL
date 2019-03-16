push 0
lhp

push 1
push 1
beq label0
push 998
lw
lhp
sw
lhp
push 1
lhp
add
shp
b label1
label0: 
push 998
lw
lhp
sw
lhp
push 1
lhp
add
shp
label1: 

push -3
lfp
add
lw
print
halt
