package co.aa8y.leetcode

/**
 * 937. Reorder Log Files
 *
 * You have an array of logs. Each log is a space delimited string of words. For each log, the
 * first word in each log is an alphanumeric identifier. Then, either:
 * 1. Each word after the identifier will consist only of lowercase letters, or;
 * 2. Each word after the identifier will consist only of digits.
 * We will call these two varieties of logs letter-logs and digit-logs. It is guaranteed that each
 * log has at least one word after its identifier.
 *
 * Reorder the logs so that all of the letter-logs come before any digit-log. The letter-logs are
 * ordered lexicographically ignoring identifier, with the identifier used in case of ties. The
 * digit-logs should be put in their original order.
 *
 * Return the final order of the logs.
 *
 * Example 1:
 * Input: ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 * Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 *
 * Note:
 * 1. 0 <= logs.length <= 100
 * 2. 3 <= logs[i].length <= 100
 * 3. logs[i] is guaranteed to have an identifier, and a word after the identifier.
 */
object ReorderLogFiles {
  trait Log {
    val id: String
    val value: String

    override def toString: String = s"$id $value"
  }
  object Log {
    def apply(logLine: String, index: Int): Log = {
      logLine.split(" ").toList match {
        case head :: Nil => LetterLog(head, "")
        case head :: tail =>
          if (tail.head.charAt(0).isDigit) {
            DigitLog(head, tail.mkString(" "), index)
          } else LetterLog(head, tail.mkString(" "))
        case _ => LetterLog("", "")
      }
    }
  }
  object LogOrdering extends Ordering[Log] {
    def compare(left: Log, right: Log): Int = {
      (left, right) match {
        case (_: LetterLog, _: DigitLog) => -1
        case (_: DigitLog, _: LetterLog) => 1
        case (l: DigitLog, r: DigitLog) => l.index - r.index
        case _ =>
          val valueComparison = left.value.compare(right.value)
          if (valueComparison == 0) left.id.compare(right.id) else valueComparison
      }
    }
  }
  case class DigitLog(id: String, value: String, index: Int) extends Log
  case class LetterLog(id: String, value: String) extends Log

  def reorderLogFiles(logs: Array[String]): Array[String] = {
    logs.zipWithIndex
        .map { case (logLine, index) => Log(logLine, index) }
        .sorted(LogOrdering)
        .map(_.toString)
  }
}
