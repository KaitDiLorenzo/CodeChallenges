class Node:
    def __init__(self, left, right, value):
        self.left = left
        self.right = right
        self.value = value

    def get_factors(self):
        if self != None:
            for i in range(2, self.value // 2):
                if self.value % i == 0:
                    self.left = Node(None, None, i)
                    self.right = Node(None, None, self.value // i)

                    self.left = self.left.get_factors()
                    self.right = self.right.get_factors()
                    break
                
        return self

    def get_largest_prime_factor(self):
        current = self
        while current.right != None:
            current = current.right

        return current.value

def largest_prime_factor(value):
    initial_value = Node(None, None, value)
    factor_tree = initial_value.get_factors()
    largest_prime_factor = factor_tree.get_largest_prime_factor()
    
    return largest_prime_factor

print(largest_prime_factor(600851475143))