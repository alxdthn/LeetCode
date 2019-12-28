class TwoSum {
	fun twoSum(nums: IntArray, target: Int): IntArray {
		val hash = mutableMapOf<Int, Int>()
		val size = nums.size
		for (i in 0..size) {
			val index = hash[target - nums[i]]
			if (index != null && i != index) {
				return intArrayOf(i, index)
			}
			hash[nums[i]] = i
		}
		throw IllegalArgumentException("No solution")
	}
}