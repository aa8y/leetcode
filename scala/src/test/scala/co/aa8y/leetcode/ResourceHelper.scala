package co.aa8y.leetcode

import scala.io.Source

trait ResourceHelper {
  def read(filename: String): Array[String] = {
    val className = this.getClass.getSimpleName
    val filePath = s"$className/$filename"

    Source.fromResource(filePath).getLines.toArray
  }
}
