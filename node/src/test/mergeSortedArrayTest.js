const { assert } = require('chai')

const { merge, shiftRight } = require('../main/mergeSortedArray')

describe('88. Merge Sorted Array', () => {
  describe('shiftRight()', () => {
    it('should shift an array from the given index.', () => {
      let arr = [1, 2, 3, 4]
      shiftRight(arr, 1, 4)

      assert.deepEqual(arr, [1, 2, 2, 3, 4])
    })
  })
  describe('merge()', () => {
    it('should not mutate the array if n is 0.', () => {
      let arr1 = []
      let arr2 = [1, 2, 3]
      merge(arr1, 0, [], 0)
      merge(arr2, 3, [], 0)

      assert.deepEqual(arr1, [])
      assert.deepEqual(arr2, [1, 2, 3])
    })
    it('should merge all elements of n in order if m is 0.', () => {
      let arr = []
      merge(arr, 0, [1, 2, 3], 3)

      assert.deepEqual(arr, [1, 2, 3])
    })
    it('should merge the elements from the second array into the first, sorted, for two small arrays.', () => {
      let arr1 = [2, 4, 9]
      let arr2 = [1, 10]
      merge(arr1, 3, arr2, 2)

      assert.deepEqual(arr1, [1, 2, 4, 9, 10])
    })
    it('should merge the elements from the second array into the first, sorted, for two large arrays.', () => {
      let arr1 = [1, 3, 5, 7, 9, 11, 13, 15, 17, 19]
      let arr2 = [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]
      merge(arr1, 10, arr2, 10)

      assert.deepEqual(arr1, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20])
    })
  })
  describe('LeetCode', () => {
    it('Test case #4', () => {
      let arr1 = [0]
      let arr2 = [1]
      merge(arr1, 0, arr2, 1)

      assert.deepEqual(arr1, [1])
    })
    it('Test case #11', () => {
      let arr1 = [2, 0]
      let arr2 = [1]
      merge(arr1, 1, arr2, 1)

      assert.deepEqual(arr1, [1, 2])
    })
  })
})

