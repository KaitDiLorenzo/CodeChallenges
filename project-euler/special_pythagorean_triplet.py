from math import sqrt


def special_pythagorean_triplet(sum):
    for i in range(1, sum):
        a = i
        if (sum ** 2 - 2 * sum * a) % (2 * sum - 2 * a) == 0:
            b = (sum ** 2 - 2 * sum * a) / (2 * sum - 2 * a)
            c = sum - a - b
            return a * b * c


print(special_pythagorean_triplet(1000))