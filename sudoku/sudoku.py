from turtle import *


setup(800, 800)
setworldcoordinates(-50, -50, 750, 750)
tracer(False)
cell = 50

# xys = [(0, 0), (1, 0), (2, 0)]
# ns = [0, 1, 3]


ns = [
    0, 0, 8, 9, 6, 0, 0, 4, 0,
    4, 0, 9, 0, 0, 0, 0, 0, 3,
    5, 6, 1, 3, 7, 0, 0, 9, 8,

    1, 9, 0, 7, 5, 3, 0, 0, 4,
    0, 0, 0, 2, 1, 0, 0, 0, 0,
    0, 0, 0, 0, 0, 0, 5, 0, 7,

    9, 8, 4, 5, 0, 0, 7, 6, 0,
    0, 0, 0, 0, 4, 9, 0, 8, 0,
    0, 1, 3, 8, 2, 0, 4, 0, 0
]

# print(ns[28])


def one_cell(n, x, y):
    up()
    goto(x * cell, y * cell)
    down()
    for i in range(4):
        color('lightgray')

        forward(cell)
        left(90)

    forward(cell / 2)
    color('black')

    if n == 0:
        n = ''
    write(n, font=('times', 30), align='center')


# [0, n)
for i in range(len(ns)):
    x = i % 9
    y = i // 9

    n = ns[i]
    one_cell(n, x, y)

up()
goto(0, 0)
down()
pensize(2)
color('black')
for i in range(4):
    forward(cell * 9)
    left(90)


def draw_3_lines():
    for i in range(3):
        forward(cell * 3)
        left(90)
        forward(cell * 9)
        backward(cell * 9)
        right(90)


draw_3_lines()
left(90)
draw_3_lines()
update()


def mark_xy():
    color('red')
    for i in range(0, 9):
        write(i, font=('times', 30), align='center')
        forward(cell)
        print(i)


def same_row(n):
    start = n * 9
    pick_ns = []
    for i in range(start, start + 9):
        if ns[i] != 0:
            pick_ns.append(ns[i])
    return pick_ns
    # return ns[start: start + 9]


def same_col(n):
    return ns[n::9]


def same_3x3(r, c):
    pick_ns = []

    start_r = r // 3 * 3
    start_c = c // 3 * 3
    start = start_r * 9 + start_c
    print(start_r, start_c)
    print(start)

    for i in range(3):
        pick_ns += ns[start: start + 3]
        start += 9

    return pick_ns


def is_valid(r, c, n):
    rows = same_row(r)
    cols = same_col(c)
    blocks = same_3x3(r, c)
    if n in rows:
        return False
    if n in cols:
        return False
    if n in blocks:
        return False

    return True


up()

goto(-20, 0)
mark_xy()

goto(30, -50)
right(90)
mark_xy()

print(same_row(2))
print(same_row(1))
print(same_row(0))

print(same_col(0))
print(same_col(1))
print(same_col(2))

print(same_3x3(3, 2))
print(same_3x3(2, 3))
print(same_3x3(3, 3))
print(same_3x3(6, 3))

print(is_valid(0, 0, 1))
print(is_valid(0, 0, 2))

done()
