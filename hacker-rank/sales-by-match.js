function sockMerchant(n, ar) {
  let pairCount = 0;
  let sockPairs = new Map();

  ar.forEach((sock) => {
    if (sockPairs.get(sock) == 1) {
      pairCount++;
      sockPairs.set(sock, 0);
    } else {
      sockPairs.set(sock, 1);
    }
  });

  return pairCount;
}
