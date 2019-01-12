package co.aa8y.leetcode

/**
 * 936. Stamping The Sequence
 *
 * You want to form a target string of lowercase letters.
 *
 * At the beginning, your sequence is target.length '?' marks.  You also have a stamp of lowercase
 * letters.
 *
 * On each turn, you may place the stamp over the sequence, and replace every letter in the sequence
 * with the corresponding letter from the stamp.  You can make up to 10 * target.length turns.
 *
 * For example, if the initial sequence is "?????", and your stamp is "abc",  then you may make
 * "abc??", "?abc?", "??abc" in the first turn.  (Note that the stamp must be fully contained in
 * the boundaries of the sequence in order to stamp.)
 *
 * If the sequence is possible to stamp, then return an array of the index of the left-most letter
 * being stamped at each turn.  If the sequence is not possible to stamp, return an empty array.
 *
 * For example, if the sequence is "ababc", and the stamp is "abc", then we could return the answer
 * [0, 2], corresponding to the moves "?????" -> "abc??" -> "ababc".
 *
 * Also, if the sequence is possible to stamp, it is guaranteed it is possible to stamp within
 * 10 * target.length moves.  Any answers specifying more than this number of moves will not be
 * accepted.
 *
 * Example 1:
 *
 * Input: stamp = "abc", target = "ababc"
 * Output: [0,2]
 * ([1,0,2] would also be accepted as an answer, as well as some other answers.)
 *
 * Example 2:
 *
 * Input: stamp = "abca", target = "aabcaca"
 * Output: [3,0,1]
 *
 * Note:
 * 1. 1 <= stamp.length <= target.length <= 1000
 * 2. stamp and target only contain lowercase letters.
 */
object StampingTheSequence {
  trait Side
  case object Right extends Side
  case object Left extends Side
  case class Substring(from: Int, to: Int) {
    def newOffset(oldOffset: Int, l: String) = oldOffset + to - from + l.size
  }

  /*
  def movesToStamp(stamp: String, target: String): Array[Int] = {
    def loop(stamp: String, leftTarget: String, rightTarget: String, offset: Int, acc: List[Int]): List[Int] = {
      (leftTarget, rightTarget) match {
        case ("", "") => acc
        case (_, "") => findBiggestCommonSubstring(stamp, leftTarget, Left, offset) match { case sub =>
          split(leftTarget, sub, offset) match { case (l, r) => loop(stamp, l, r, sub.newOffset(offset, l), sub.from :: acc) }
        }
        case ("", _) => findBiggestCommonSubstring(stamp, rightTarget, Right, offset) match { case sub =>
          split(rightTarget, sub, offset) match { case (l, r) => loop(stamp, l, r, sub.newOffset(offset, l), sub.from :: acc) }
        }
        case _ =>
          val lacc = findBiggestCommonSubstring(stamp, leftTarget, Left, offset) match { case sub =>
            split(leftTarget, sub, offset) match { case (l, r) => loop(stamp, l, r, sub.newOffset(offset, l), sub.from :: acc) }
          }
          val racc = findBiggestCommonSubstring(stamp, rightTarget, Right, offset) match { case sub =>
            split(rightTarget, sub, offset) match { case (l, r) => loop(stamp, l, r, sub.newOffset(offset, l), sub.from :: acc) }
          }
          lacc ++ racc
      }
    }
    loop(stamp, target, "", 0, Nil).toArray
  }
  */

  def movesToStamp(stamp: String, target: String): Array[Int] = {
    def loop(stamp: String, target: String, offset: Int, acc: List[Int]): List[Int] = {
      if (target.isEmpty) acc
      else {
        findBiggestCommonSubstring(stamp, target, offset) match {
          case Some(sub) =>
            split(target, sub, offset) match { case (l, r) =>
              loop(stamp, l, offset, sub.from :: acc) ++ loop(stamp, r, sub.newOffset(offset, l), sub.from :: acc)
            }
          case None => acc
        }
      }
    }
    loop(stamp, target, 0, Nil).toArray
  }

  def split(s: String, sub: Substring, offset: Int): (String, String) = {
    (s.substring(0, sub.from - offset), s.substring(sub.to - offset, s.size))
  }

  def findBiggestCommonSubstring(stamp: String, target: String, offset: Int): Option[Substring] = {
    if (target.isEmpty || stamp.isEmpty) None
    else if (target.contains(stamp)) {
      val from = target.indexOf(stamp) + offset
      val sub = Substring(from, from + stamp.size)
      println(sub)
      Some(sub)
    } else if (target.size < stamp.size) {
      val charsToDrop = target.size - stamp.size
      val right = findBiggestCommonSubstring(stamp.dropRight(charsToDrop), target, offset)
      lazy val left = findBiggestCommonSubstring(stamp.drop(charsToDrop), target, offset)
      right.orElse(left)
    } else {
      val charsToDrop = 1
      val right = findBiggestCommonSubstring(stamp.dropRight(charsToDrop), target, offset)
      lazy val left = findBiggestCommonSubstring(stamp.drop(charsToDrop), target, offset)
      right.orElse(left)
    }
  }

  /*
  @tailrec
  def findBiggestCommonSubstring(stamp: String, target: String, side: Side, offset: Int): Substring = {
    if (target.contains(stamp)) {
      val from = target.indexOf(stamp) + offset
      val sub = Substring(from, from + stamp.size)
      println(side, sub)
      sub
    } else if (side == Right) {
      findBiggestCommonSubstring(stamp.drop(1), target, side, offset)
    } else {
      findBiggestCommonSubstring(stamp.dropRight(1), target, side, offset)
    }
  }

  @tailrec
  def findBiggestCommonSubstring(stamp: String, leftTarget: String, rightTarget: String, offset: Int): Substring = {
    if (leftTarget.contains(stamp)) {
      val from = leftTarget.indexOf(stamp)
      Substring(from, from + stamp.size, stamp.size, Left)
    } else if (rightTarget.contains(stamp)) {
      val from = rightTarget.indexOf(stamp)
      Substring(from + offset, from + offset + stamp.size, stamp.size, Right)
    } else if (rightTarget.size > leftTarget.size) {
      findBiggestCommonSubstring(stamp.drop(1), leftTarget, rightTarget)
    } else {
      findBiggestCommonSubstring(stamp.dropRight(1), leftTarget, rightTarget)
    }
  }
  */
}
