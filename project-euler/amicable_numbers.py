def amicable_numbers(n):
    sum = 0
    found_pairs = []

    for a in range(1, n):
        b = sum_of_divisors(a)

        if a != b and not (b in found_pairs) and sum_of_divisors(b) == a:
            found_pairs.extend([a, b])
            sum += a + b

    return sum
    
def sum_of_divisors(n):
    sum_of_divisors = 1

    for i in range (2, n // 2 + 1):
        if n % i == 0:
            sum_of_divisors += i

    return sum_of_divisors

print(amicable_numbers(10000))