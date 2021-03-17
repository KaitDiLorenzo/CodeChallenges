from math import floor, sqrt

def nth_prime(n):
  primes = []
  i = 2
  while (len(primes) < n):
    for j in range(2, floor(sqrt(i)) + 1):
      if (i % j == 0):
        break
    else:
      primes.append(i)
    i += 1
  return primes.pop()

print(nth_prime(10001))