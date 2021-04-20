from math import sqrt, floor


def get_number_of_divisors(value):
    if value == 1:
        return 1
    elif value == 4:
        return 3

    divisors_count = 2
    upper_limit = floor(sqrt(value))

    for i in range(2, upper_limit):
        if value % i == 0:
            if i == value // i:
                divisors_count += 1
            else:
                divisors_count += 2

    return divisors_count


def highly_divisible_triangular_number(divisors_target):
    index = 0
    num_of_divisors = 0
    triangular_number = 0
    while num_of_divisors <= divisors_target:
        index += 1
        triangular_number += index
        num_of_divisors = get_number_of_divisors(triangular_number)

    return triangular_number


print(highly_divisible_triangular_number(500))
