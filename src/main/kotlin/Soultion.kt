import java.lang.Math.pow
import java.util.*
import kotlin.collections.HashSet
import kotlin.math.sqrt
import kotlin.math.pow

/**
 * 2021.08.12
 * Level1. 제일 작은 수 제거하기
 * https://programmers.co.kr/learn/courses/30/lessons/12935
 *
 * reduce 로 최소값을 찾고 remove 로 그 값을 지우고 toIntArray 로 변환하여 리턴했다.
 *
 * 다른 사람의 풀이 (Ayteneve) 가 훨신 간소했다.
 * min 함수를 활용하면 코드가 더 간소화된다.
 */
class Solution {
    fun solution(arr: IntArray): IntArray {
        val list = arr.toMutableList()
        if (list.size == 1) {
            return intArrayOf(-1)
        } else {
            val min = list.reduce { min, cur ->
                if (min > cur) {
                    cur
                } else {
                    min
                }
            }
            list.remove(min)
            return list.toIntArray()
        }
    }
}


fun main() {
    println(java.util.Arrays.toString(Solution().solution(intArrayOf(4))))
}