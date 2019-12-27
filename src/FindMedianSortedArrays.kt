import java.lang.IllegalArgumentException

class FindMedianSortedArrays {

	/**
	 * 		Solution without merge and use binary search
	 *
	 * 		realization from https://www.youtube.com/watch?v=LPFhl65R7ww
	 */

	fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
		if (nums2.size < nums1.size) {
			return findMedianSortedArrays(nums2, nums1)
		}
		val aSize = nums1.size
		val bSize = nums2.size
		val sumOfSizes = aSize + bSize
		val half = (sumOfSizes + 1) / 2
		var low = 0
		var high = aSize
		while (low <= high) {
			val posA = (low + high) / 2
			val posB = half - posA

			val aLeft = if (posA > 0) nums1[posA - 1] else Int.MIN_VALUE
			val bLeft = if (posB > 0) nums2[posB - 1] else Int.MIN_VALUE
			val aRight = if (posA < aSize) nums1[posA] else Int.MAX_VALUE
			val bRight = if (posB < bSize) nums2[posB] else Int.MAX_VALUE

			when {
				aLeft <= bRight && bLeft <= aRight -> {
					val leftMax = Math.max(aLeft, bLeft)
					val rightMin = Math.min(aRight, bRight)
					return when {
						sumOfSizes % 2 == 0 -> (leftMax + rightMin) / 2.0
						else -> leftMax.toDouble()
					}
				}
				aLeft > bRight -> high = posA - 1
				else -> low = posA + 1
			}
		}
		throw IllegalArgumentException()
	}

	/**
	 * 		Solution with merge two arrays
	 */

	fun findMedianSortedArraysTry1(nums1: IntArray, nums2: IntArray): Double {
		val mergedArray = nums1.mergeWith(nums2)
		println(mergedArray.contentToString())
		return findMedian(mergedArray)
	}

	private fun findMedian(array: IntArray): Double {
		val delta = array.size / 2
		return if (array.size % 2 == 0) {
			(array[delta] + array[delta - 1]) / 2.0
		} else {
			array[delta].toDouble()
		}
	}

	private fun IntArray.mergeWith(a: IntArray): IntArray {
		val aSize = a.size
		val res = IntArray(size + aSize)
		var i = 0
		var j = 0
		var k = 0
		while (true) {
			res[i++] = when {
				j < size && k < aSize -> if (get(j) < a[k]) get(j++) else a[k++]
				j < size -> get(j++)
				k < aSize -> a[k++]
				else -> return res
			}
		}
	}
}