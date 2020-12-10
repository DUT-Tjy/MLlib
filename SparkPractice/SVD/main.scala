import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.linalg.distributed.RowMatrix
import org.apache.spark.{SparkContext, SparkConf}
object main {
  def main(args:Array[String]): Unit ={
    val conf = new SparkConf()
      .setAppName("main")
      .setMaster("local")
    val sc = new SparkContext(conf)

    val data = sc.textFile("")
      .map(_.split(' ')
      .map(_.toDouble))
      .map(line => Vectors.dense(line))

    val rm = new RowMatrix(data)
    val SVD = rm.computeSVD(2, computeU = true)
    println(SVD)

  }
}
