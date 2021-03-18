function removeInvalidParentheses(s: string): string[] {
  let removedInvalidParentheses = [];

  removedInvalidParentheses = getInvalidParentheses(s);

  return removedInvalidParentheses;
}

function getInvalidParentheses(s: string): number[] {
  let leftParenthesesIndices: number[] = [];
  let invalidParenthesesIndices: number[] = [];

  for (let i = 0; i < s.length; i++) {
    if (s.charAt(i) == "(") {
      leftParenthesesIndices.push(i);
    } else if (s.charAt(i) == ")") {
      const poppedIndex = leftParenthesesIndices.pop();

      if (poppedIndex == undefined) {
        invalidParenthesesIndices.push(i);
      }
    }
  }

  return invalidParenthesesIndices;
}

console.log(removeInvalidParentheses("()())()"));
