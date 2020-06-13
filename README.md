In this repository You can find HashMap with open addressing and quadratic probing collision resolution implemented by Artem Polishchuk.

**********

Hash function description:
https://stackoverflow.com/questions/664014/what-integer-hash-function-are-good-that-accepts-an-integer-hash-key

**********

Performance test

1000 iterations with insertion of random numbers where  number of insertions = {10 000, 100 000, 1 000 000, 10 000 000}
![1](https://user-images.githubusercontent.com/58078781/84572748-db143d80-ada4-11ea-9bd9-c62673148922.jpg)

1000 iterations with sequential insertion of numbers from 0 to m (number of insertions) where m = {10 000, 100 000, 1 000 000, 10 000 000}
![3](https://user-images.githubusercontent.com/58078781/84572782-0bf47280-ada5-11ea-93ef-b787a1dcc2e1.jpg)

1000 iterations with getting elements (random and sequential cases) from HashMap where number of elements = {10 000, 100 000, 1 000 000, 10 000 000}
![2](https://user-images.githubusercontent.com/58078781/84572762-f2532b00-ada4-11ea-9b70-12b05d390218.png)
![4](https://user-images.githubusercontent.com/58078781/84572796-1adb2500-ada5-11ea-91be-e1cd3ce5605d.jpg)
