const { performance } = require("perf_hooks");

var fs = require("fs");
var text = fs.readFileSync("hacker-rank/input03.txt", "utf-8");

let queries = text.split("\n");

for (var i = 0; i < queries.length; i++) {
  queries[i] = queries[i].split(" ");
  for (var j = 0; j < queries[i].length; j++) {
    queries[i][j] = parseInt(queries[i][j]);
  }
}

var n = 40;

/*
var n = 40;
var queries = [
  [2, 6, 8],
  [3, 5, 7],
  [1, 8, 1],
  [5, 9, 15],
];
*/
var t0 = performance.now();
console.log(arrayManipulation(n, queries));
var t1 = performance.now();
console.log("Call to arrayManipulation took " + (t1 - t0) + " milliseconds.");

function arrayManipulation(n, queries) {
  var maxValue = 0;
  var groups = { a: 1, b: n, k: 0, previous: null, next: null };

  queries.forEach((query) => {
    for (var group = groups; group != null; group = group.next) {
      var gb = group.b;
      var qa = query[0];

      if (qa > gb) continue;

      var ga = group.a;
      var qb = query[1];

      if (qa <= ga) {
        if (qb < ga) break;

        var newK = group.k + query[2];
        if (newK > maxValue) maxValue = newK;

        if (qb < gb) {
          var newGroup = {
            a: ga,
            b: qb,
            k: newK,
            previous: group.previous,
            next: group,
          };

          if (group.previous == null) {
            groups = newGroup;
          } else {
            group.previous.next = newGroup;
          }

          group.a = qb + 1;
          group.previous = newGroup;
        } else {
          group.k = newK;
        }
      } else {
        var newK = group.k + query[2];
        if (newK > maxValue) maxValue = newK;

        if (qb < gb) {
          var newGroup1 = {
            a: ga,
            b: qa - 1,
            k: group.k,
            previous: group.previous,
          };
          var newGroup2 = {
            a: qa,
            b: qb,
            k: newK,
            previous: newGroup1,
            next: group,
          };

          if (group.previous == null) {
            groups = newGroup1;
          } else {
            group.previous.next = newGroup1;
          }

          newGroup1.next = newGroup2;
          group.a = qb + 1;
          group.previous = newGroup2;
        } else {
          var newGroup = {
            a: qa,
            b: gb,
            k: newK,
            previous: group,
            next: group.next,
          };
          group.b = qa - 1;
          if (group.next != null) group.next.previous = newGroup;
          group.next = newGroup;
          group = group.next;
        }
      }
    }
  });

  return maxValue;
}
