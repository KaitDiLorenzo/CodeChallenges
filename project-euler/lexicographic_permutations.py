import math

def get_edit_values(n, digits):
    edits = {}
    for i in range(len(digits), 0, -1):
        edits[i] = 0        
    
    i = 1
    while i <= len(digits):
        factorial = math.factorial(i)
        if factorial >= n:
            edits[i] = edits[i] + 1

            if factorial > n:
                n = n - math.factorial(i - 1)
                i = 0
            else:
                break
        i += 1

    return edits


def lexicographic_permutations(n, digits):
    if math.factorial(len(digits)) < n:
        raise ValueError('The value of n is greater than the number of possible permutations')
    
    edits = get_edit_values(n, digits)

    permutation = ""
    number_of_digits = len(digits)
    for i in range(0, number_of_digits):
        edit_value = edits.get(number_of_digits - i)
        permutation += str(digits.pop(edit_value if edit_value < len(digits) else -1))

    return permutation

print(lexicographic_permutations(1000000, [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]))