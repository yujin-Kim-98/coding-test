package leetcode

import java.util.*

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/98/design/562/
 * LeetCode - Top Interview Questions - Min Stack (Design)
 */
fun main() {

    val minStack = MinStack()

    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    println(minStack.getMin()) // -3
    minStack.pop()
    println(minStack.top()) // 0
    println(minStack.getMin()) // -2

}

/**
 * GPT가 최적화 해준 코드
 */
class MinStack() {

    private val stack = Stack<Int>()
    private val minStack = Stack<Int>() // 최소값을 저장하는 보조 스택

    fun push(`val`: Int) {
        stack.push(`val`)
        if (minStack.isEmpty() || `val` <= minStack.peek()) {
            minStack.push(`val`)
        }
    }

    fun pop() {
        if (stack.pop() == minStack.peek()) {
            minStack.pop() // 최소값이 사라지면 minStack에서도 제거
        }
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return minStack.peek() // 최소값을 O(1) 시간에 반환
    }

}

//class MinStack() {
//
//    private val stack = Stack<Int>()
//
//    fun push(`val`: Int) {
//        stack.push(`val`)
//    }
//
//    fun pop() {
//        stack.pop()
//    }
//
//    fun top(): Int {
//        return stack.peek()
//    }
//
//    fun getMin(): Int {
//        return stack.min()
//    }
//
//}