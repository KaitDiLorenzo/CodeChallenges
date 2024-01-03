def power_digit_sum(base, exponent):
    power = pow(base, exponent)

    sum = 0
    for digit in str(power):
        sum += int(digit)

    return sum

print(power_digit_sum(2, 1000))