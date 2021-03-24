function countingValleys(steps, path) {
  let elevation = 0;
  let valleyCount = 0;

  let isValley = false;
  for (let i = 0; i < steps; i++) {
    path[i] == "D" ? elevation-- : elevation++;

    if (elevation == -1 && !isValley) {
      isValley = true;
      valleyCount++;
    } else if (elevation == 0 && isValley) {
      isValley = false;
    }
  }

  return valleyCount;
}
