from math import floor, sqrt


def is_prime(value):
    if value <= 1:
        return False

    max_check = floor(sqrt(value)) + 1
    for i in range(2, max_check):
        if value % i == 0:
            return False
    else:
        return True


def summation_of_primes(max):
    sum = 0
    for i in range(1, max):
        if is_prime(i):
            sum += i
    return sum


print(summation_of_primes(2000000))