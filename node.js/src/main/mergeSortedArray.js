/**
 * 88. Merge Sorted Array
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold
 * additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and
 * n respectively.
 *
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
function merge(nums1, m, nums2, n) {
  let i = 0
  let j = 0
  if (m > 0 && n > 0) {
    while (i < m) {
      if (nums1[i] > nums2[j]) {
        shiftRight(nums1, i, m)
        nums1[i] = nums2[j++]
        m++
        n--
      }
      i++
    }
  }
  while (n-- > 0) {
    nums1[i++] = nums2[j++]
  }
}
function shiftRight(arr, i, l) {
  while (l > i) {
    arr[l] = arr[l - 1]
    l--
  }
}

module.exports = { merge, shiftRight }
