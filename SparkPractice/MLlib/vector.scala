import org.apache.spark.mllib.linalg.{Vector, Vectors}
object vector {
  def main(args:Array[String]): Unit ={
    val vd: Vector = Vectors.dense(2, 0, 6)
    println(vd(2))
    val vs: Vector = Vectors.sparse(4, Array(0, 1, 2, 3), Array(4, 6, 2, 9))
    println(vs(2))
  }
}
