def is_palindrome(value):
    value_as_str = str(value)

    index_1 = 0
    index_2 = len(value_as_str) - 1

    while index_2 > index_1:
        if value_as_str[index_1] != value_as_str[index_2]:
            return False

        index_1 += 1
        index_2 -= 1

    return True


def largest_palindrome_product(num_of_digits):
    max_factor = 10**num_of_digits - 1
    min_factor = 10**(num_of_digits - 1)
    x = y = max_factor

    diagonal_amount = 1
    next_row_value = x

    last_x = x
    last_y = y
    
    while x >= min_factor and y >= min_factor:
        product = x * y
        if is_palindrome(product):
            return product

        if x == max_factor and y == next_row_value:
            if next_row_value > max_factor / 2:
                diagonal_amount += 1
            else:
                diagonal_amount -= 1

            if diagonal_amount % 2 == 0:
                x = last_x
                y = last_y - 1
                last_y = y
            else:
                x = last_x - 1
                last_x = x
                y = last_y

            next_row_value -= 1
        else:
            x += 1
            y -= 1


print(largest_palindrome_product(3))
