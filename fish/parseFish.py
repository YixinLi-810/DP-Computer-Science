import sys

file = 'fish.txt'

print(file)

fields=[
    '',
    'Fish number',
    'Type',
    ''

]

fishes = []

with open(file, 'r') as file_reader:
    fishFields = []
    fieldCount = 1

    while True:
        line = file_reader.readline()
        if not line:
            break

        line = line.strip()
        if len(line) > 0:
            print(fieldCount, line)
            fishFields.append(line)
            if fieldCount == 6:
                fishes.append(fishFields)
                fishFields = []
                fieldCount = 0

            fieldCount += 1
print(fishes)