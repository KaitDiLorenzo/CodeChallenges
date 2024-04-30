from math import floor, pow, sqrt


primes = []
non_primes = []

def is_prime(n):
    if n in primes:
        return True
    
    if n in non_primes:
        return False

    for i in range(2, floor(sqrt(n)) + 1):
        if n % i == 0:
            non_primes.append(n)
            return False
        
    primes.append(n)
    return True

def quadratic_primes():
    max_a = 0
    max_b = 0
    max_n = 0

    for a in range(-1000, 1001):
        for b in range(-1000, 1001):
            n = 0
            
            while(is_prime(abs(pow(n, 2) + a*n + b))):
                n += 1
    
            if n - 1 > max_n:
                max_a = a
                max_b = b
                max_n = n - 1

    return max_a * max_b;

print(quadratic_primes())