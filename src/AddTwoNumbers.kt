class AddTwoNumbers {
	class ListNode(var value: Int, var next: ListNode? = null)

	fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
		val res: ListNode? = ListNode(0)
		var tmp = res

		var i = l1
		var j = l2

		var over = 0

		while (i != null || j != null) {
			val a = i?.value ?: 0
			val b = j?.value ?: 0
			val sum = a + b + over

			over = sum / 10
			tmp?.value = sum % 10

			i = i?.next
			j = j?.next
			if (i != null || j != null || over != 0) {
				tmp?.next = ListNode(0)
			}
			tmp = tmp?.next
		}
		tmp?.value = over
		return res
	}

	fun valueToList(value: Int): ListNode? {
		var i = 1
		val res: ListNode? = ListNode(0)
		var tmp = res
		while (value / i != 0) {
			tmp?.value = (value / i) % 10
			i *= 10
			if (value / i != 0) {
				tmp?.next = ListNode(0)
			}
			tmp = tmp?.next
		}
		return res
	}

	fun printList(l: ListNode?) {
		var i = l
		val sb = StringBuilder()
		while (i != null) {
			sb.append(i.value.toString())
			i = i.next
			if (i != null) {
				sb.append(" -> ")
			}
		}
		println("($sb)")
	}
}