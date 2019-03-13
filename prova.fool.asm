push 0
lhp
push function0
lhp
sw
push 1
lhp
add
shp
lhp
push function1
lhp
sw
push 1
lhp
add
shp
lhp
push function2
lhp
sw
push 1
lhp
add
shp
lhp
push function3
lhp
sw
push 1
lhp
add
shp
lhp
push function4
lhp
sw
push 1
lhp
add
shp
lhp
push function5
lhp
sw
push 1
lhp
add
shp
lhp
push function6
lhp
sw
push 1
lhp
add
shp
lhp
push function7
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
push 1
beq label0
push -14
lfp
add
lw
b label1
label0: 
push -13
lfp
add
lw
label1: 

lfp
lfp
push -15
add
lw
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
