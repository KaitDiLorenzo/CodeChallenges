def multiples_of_3_and_5(max_value):
    sum = 0
    for i in range(max_value):
        if i % 3 == 0 or i % 5 == 0:
            sum += i
    return sum

print(multiples_of_3_and_5(1000))