class FindMedianSortedArrays {
	fun findMedianSortedArraysTry1(nums1: IntArray, nums2: IntArray): Double {
		val mergedArray = nums1.mergeWith(nums2)
		println(mergedArray.contentToString())
		val delta = mergedArray.size / 2
		return if (mergedArray.size % 2 == 0) {
			(mergedArray[delta] + mergedArray[delta - 1]) / 2.0
		} else {
			mergedArray[delta].toDouble()
		}
	}

	fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {

	}

	fun IntArray.mergeWith(a: IntArray): IntArray {
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

fun main() {
	val nums1 = intArrayOf(1, 3, 5, 7)
	val nums2 = intArrayOf(1, 4, 6)
	println(FindMedianSortedArrays().findMedianSortedArrays(nums1, nums2))
}
