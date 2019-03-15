push 0
lhp

push 3
push -5
sub
push 3
lfp
push function0
push 998
lw
lhp
sw
lhp
push 1
lhp
add
shp

push -4
lfp
add
lw
print
halt

function0:
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
