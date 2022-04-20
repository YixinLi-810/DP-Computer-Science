'''
Description: 0810
Author: Yixin Li
Date: 2022-04-11 08:13:17
LastEditors: Yixin Li
LastEditTime: 2022-04-11 08:13:18
'''
def make_one_row(n):
    for col in range(1, n + 1):
        print(f'{col}x{n}={col*n}', end=' ')


for i in range(9):
    make_one_row(i)
    print()