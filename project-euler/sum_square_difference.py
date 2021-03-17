def sum_square_difference(max_value):
  sum = 0
  sum_of_squares = 0
  for i in range(1, max_value + 1):
    sum += i
    sum_of_squares += i ** 2
  else:
    square_of_sum = sum ** 2
  return square_of_sum - sum_of_squares

print(sum_square_difference(100))