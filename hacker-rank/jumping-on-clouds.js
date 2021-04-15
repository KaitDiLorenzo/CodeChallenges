function jumpingOnClouds(c) {
  let jumpCount = 0;

  let i = 0;
  while (i < c.length - 1) {
    i += c[i + 2] == 0 ? 2 : 1;
    jumpCount++;
  }
  if (i != c.length - 1) jumpCount++;

  return jumpCount;
}
