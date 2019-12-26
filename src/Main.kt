class FindMedianSortedArrays {
	fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
		val mergedArray = nums1 mergeWith nums2
		println(mergedArray.contentToString())
		val delta = mergedArray.size / 2
		return if (mergedArray.size % 2 == 0) {
			(mergedArray[delta] + mergedArray[delta - 1]) / 2.0
		} else {
			mergedArray[delta].toDouble()
		}
	}

	infix fun IntArray.mergeWith(a: IntArray): IntArray {
		val res = IntArray(size + a.size)
		var i = 0
		var j = 0
		var k = 0
		while (true) {
			res[i++] = if (j < size && k < a.size) {
				if (get(j) < a[k]) get(j++) else a[k++]
			} else if (j < size) get(j++)
			else if (k < a.size) a[k++]
			else break
		}
		return res
	}
}

fun main() {
	val nums1 = intArrayOf(1, 3, 5, 7)
	val nums2 = intArrayOf(1, 4, 6)
	println(FindMedianSortedArrays().findMedianSortedArrays(nums1, nums2))
}
