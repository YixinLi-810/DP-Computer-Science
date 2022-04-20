'''
Description: 0810
Author: Yixin Li
Date: 2021-12-28 15:48:02
LastEditors: Yixin Li
LastEditTime: 2021-12-28 15:48:02
'''

from turtle import *

# for random color
from random import randint
colormode(255)

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

    def collect(self, disk):
        disk.pen.setx(self.location)
        disk.pen.sety(len(self.disks) * 20)
        self.disks.append(disk)

    def takeaway(self):
        disk = self.disks.pop()
        disk.move_top()
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

rod_left = Rod(-300)
rod_mid = Rod(0)
rod_right = Rod(300)

disk1 = Disk(6)
disk2 = Disk(4)
disk3 = Disk(2)

rod_left.collect(disk1)
rod_left.collect(disk2)
rod_left.collect(disk3)

update()    # no animation but show me the result

tracer(True)    # enable animation

# mouse click intraction
in_hands_disks = []

def action(x, y):

    # find the selected rod
    clicked_rod = rod_mid

    if x < -150:
        clicked_rod = rod_left
    elif x > 150:
        clicked_rod = rod_right

    # shoud I move the disk up or down

    if len(in_hands_disks) == 0:
        # if I have a empty hand, I take a disk from the rod I clicked
        disk = clicked_rod.takeaway()
        in_hands_disks.append(disk)
    else:
        # if I have a disk in my hand, I just drop it
        disk = in_hands_disks.pop()
        clicked_rod.collect(disk)

    print(clicked_rod.location)
    print(in_hands_disks)

onscreenclick(action)

done()
