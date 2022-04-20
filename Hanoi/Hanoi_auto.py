'''
Description: 0810
Author: Yixin Li
Date: 2021-12-28 15:45:54
LastEditors: Yixin Li
LastEditTime: 2021-12-28 15:46:57
'''
from turtle import *
from random import randint
colormode(255)

setup(1280, 720)
rod_gap = 200

disk_count = 5

in_hands_disks = []

tracer(False)  # stop animotion save time for draw start status

# ------------
# classes
# ------------


class Rod:
    def __init__(self, location):
        self.location = location
        self.pen = Turtle('square')
        self.pen.turtlesize(15, 0.5)
        self.pen.up()
        self.pen.setx(location)
        self.pen.sety(150)

        self.disks = []

    def collect(self):
        disk = in_hands_disks.pop()

        disk.pen.setx(self.location)
        disk.pen.sety(len(self.disks) * 20)
        self.disks.append(disk)

    def takeaway(self):
        disk = self.disks.pop()
        disk.move_top()

        in_hands_disks.append(disk)
        return disk


class Disk:
    def __init__(self, size):
        self.pen = Turtle('square')
        self.pen.turtlesize(1, size)
        r = randint(0, 255)
        g = randint(0, 255)
        b = randint(0, 255)

        self.pen.color(r, g, b)
        self.pen.up()

    def move_top(self):
        self.pen.sety(300)


# ------------
# game on
# ------------

rod_left = Rod(-rod_gap * 2)
rod_mid = Rod(0)
rod_right = Rod(rod_gap * 2)


'''
a1 = 2
an = a1 + (n - 1) * 2
2 + (4 - 1) * 2 = 

4:
-------
2 4 6 8


3:
-------
2 4 6

2:
-------
2 4
'''

# bottom_width = 2 + (n - 1) * 2
bottom_width = 2 * disk_count
for i in range(disk_count):
    disk = Disk(bottom_width)
    in_hands_disks.append(disk)
    rod_left.collect()
    bottom_width -= 2


update()    # no animation but show me the result

tracer(True)    # enable animation


# mouse click intraction


def manual_action(x, y):

    # find the selected rod
    clicked_rod = rod_mid

    if x < -150:
        clicked_rod = rod_left
    elif x > 150:
        clicked_rod = rod_right

    # shoud I move the disk up or down

    if len(in_hands_disks) == 0:
        # if I have a empty hand, I take a disk from the rod I clicked
        clicked_rod.takeaway()
    else:
        # if I have a disk in my hand, I just drop it
        clicked_rod.collect()


onscreenclick(manual_action)


def cpu_action(n, from_rod, to_rod, by_pass_rod):
    if n > 0:
        #  (n - 1 )from_rod --> by pass rod
        cpu_action(n - 1, from_rod, by_pass_rod, to_rod)

        from_rod.takeaway()
        to_rod.collect()

        # move (n - 1 )from by pass rod  --> to target rod
        cpu_action(n - 1, by_pass_rod, to_rod, from_rod)


cpu_action(disk_count, rod_left, rod_right, rod_mid)


done()