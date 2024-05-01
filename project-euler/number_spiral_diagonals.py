import math

def number_spiral_diagonals(n):
    if n < 1 or n % 2 == 0:
        raise ValueError('The value of n is invalid.')
    
    sum = 0
    for i in range(1, 2 * n):
        sum += (2 * math.ceil(i / 4) - 1) ** 2 + 2 * math.ceil(i / 4) * ((i - 1) % 4)

    return sum

print(number_spiral_diagonals(1001))