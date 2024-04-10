import math

def factorial_digit_sum(n):
    factorial = math.factorial(n)
    factorial_digit_sum = 0

    while factorial > 0:
        factorial_digit_sum += factorial % 10
        factorial = factorial // 10

    return factorial_digit_sum

print(factorial_digit_sum(100))
