def even_fibonacci_numbers(max_fibonacci):
    sum = 0

    fibonacci_0 = 1
    fibonacci_1 = 1
    fibonacci_2 = 2

    while (fibonacci_2 <= max_fibonacci):
        if(fibonacci_2 % 2 == 0):
            sum += fibonacci_2
        
        fibonacci_0 = fibonacci_1
        fibonacci_1 = fibonacci_2
        fibonacci_2 = fibonacci_0 + fibonacci_1

    return sum

print(even_fibonacci_numbers(4000000))