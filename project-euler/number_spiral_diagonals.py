def number_spiral_diagonals(n):
    if n < 1 or n % 2 == 0:
        raise ValueError('The value of n is invalid.')
    
    addend = 2
    counter = 0
    sum = 1
    value = 1

    while value < n**2:
        value += addend
        sum += value
        counter += 1

        if counter == 4:
            counter = 0
            addend += 2

    return sum

print(number_spiral_diagonals(1001))