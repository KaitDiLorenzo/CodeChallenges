def n_digit_fibonacci(n):
    if(n < 1):
        raise ValueError('The value of n can\'t be non-positive')
    if(n == 1):
        return 1

    i = 2
    a = 1
    b = 1

    while b < pow(10, n - 1):
        c = a + b
        a = b
        b = c
        i += 1

    return i

print(n_digit_fibonacci(1000))