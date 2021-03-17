def smallest_multiple(max_divisor):
  min_divisor = max_divisor // 2 + 1
  smallest_multiple = max_divisor

  i = min_divisor
  while i < max_divisor:
    if (smallest_multiple % i != 0):
      smallest_multiple += max_divisor
      i = min_divisor
    else:
      i += 1

  return smallest_multiple

print(smallest_multiple(20))