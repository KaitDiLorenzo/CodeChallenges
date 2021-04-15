function repeatedString(s, n) {
  let aIndices = [];
  for (let i = 0; i < s.length; i++) {
    if (s[i] == "a") aIndices.push(i);
  }

  let aCount = Math.floor(n / s.length) * aIndices.length;

  const remainder = n % s.length;
  for (let i = 0; i < aIndices.length && aIndices[i] < remainder; i++) {
    aCount++;
  }

  return aCount;
}
