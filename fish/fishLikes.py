class Fish:

    # assume all data is valid
    def __init__(self, number, ptype, name, age, weight, hunger):
        self.number = number
        self.ptype = ptype
        self.name = name
        self.age = age
        self.weight = weight
        self.hunger = hunger

    # Complete this instance method based on the rules described. 
    # returns True if this fish (self) likes other, otherwise False
    # self - the current fish (X)
    # other - the other fish (Y) 
    # allfish is an array of all fish
    # Note: where calculations require counting the number of fish, you should also include X and Y.

    def fish_likes(self, other, allfish):
        # 
        # WRITE YOUR CODE
        #
    
        score = 0
    
        if self.ptype == 'Bony' or (self.ptype == 'Cartilaginous' and other.ptype == 'Cartilaginous'):
            score += 1
        if self.weight <= other.weight * .20:
            score += 1
        if self.age > other.age:
            score += 1
        if not self.hunger:
            score += 1
        if (self.ptype == 'Bony' and len(allfish) > 2 or self.ptype == 'Cartilaginous') and len(allfish) > 4:
            bony_count = 1
            for fish in allfish:
                if fish.ptype == 'Bony':
                    bony_count += 1