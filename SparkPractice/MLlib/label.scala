import org.apache.spark.mllib.linalg.{Vector, Vectors}
import org.apache.spark.mllib.regression.LabeledPoint

object label {
  def main(args:Array[String]): Unit ={
    val vd: Vector = Vectors.dense(2, 0, 6)
    val pos = LabeledPoint(1, vd)
    println(pos.features)
    println(pos.label)
    val vs: Vector = Vectors.sparse(4, Array(0, 1, 2, 3), Array(4, 6, 3, 9))
    val nag = LabeledPoint(2, vs)
    println(nag.label)
    //对数据打标签
  }
}
