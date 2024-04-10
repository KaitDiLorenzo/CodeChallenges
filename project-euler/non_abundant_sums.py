def is_abundant_number(n):
    divisors_sum = 1

    for i in range(2, n // 2 + 1):
        if n % i == 0:
            divisors_sum += i

    return n < divisors_sum

def is_sum_of_two_abundant_numbers(n, abundant_numbers):
    for a in abundant_numbers:
        if a > n // 2:
            return False
        
        if n - a in abundant_numbers:
            return True
        
    return False

def non_abundant_sums():
    UPPER_LIMIT = 28123

    non_abundant_sum = 0
    abundant_numbers = []

    for n in range(1, UPPER_LIMIT):
        if not is_sum_of_two_abundant_numbers(n, abundant_numbers):
            non_abundant_sum += n
        
        if is_abundant_number(n):
            abundant_numbers.append(n)
        
    return non_abundant_sum

print(non_abundant_sums())