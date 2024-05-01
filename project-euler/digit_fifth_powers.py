import math

def digit_powers(exponent):
    dfp_sum = 0

    for n in range(10, 10**(exponent + 1)):
        digits = [(n // (10**i)) % 10 for i in range(math.ceil(math.log(n, 10)) - 1, -1, -1)]
        sum = 0

        for digit in digits:
            sum += digit**exponent

        if sum == n:
            dfp_sum += n
            print(n)

    return dfp_sum

print(digit_powers(5))