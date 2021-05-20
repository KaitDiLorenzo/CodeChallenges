function checkMagazine(magazine, note) {
  const magazineSorted = magazine.sort();
  const noteSorted = note.sort();

  let j = 0;
  for (let i = 0; i < noteSorted.length; i++) {
    while (magazineSorted[j] < noteSorted[i] && j < magazineSorted.length - 1) {
      j++;
    }

    if (noteSorted[i] == magazineSorted[j]) {
      j++;
      if (j != magazineSorted.length) {
        continue;
      }
    }

    console.log("No");
    return;
  }

  console.log("Yes");
}

checkMagazine(
  ["give", "me", "one", "grand", "today", "night"],
  ["give", "one", "grand"]
);
// checkMagazine(
//   ["two", "times", "three", "is", "not", "four"],
//   ["two", "times", "two", "is", "four"]
// );
