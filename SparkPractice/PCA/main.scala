import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.linalg.distributed.RowMatrix
import org.apache.spark.{SparkContext, SparkConf}
object main {
  def main(args:Array[String]): Unit ={
    val conf = new SparkConf()
      .setMaster("local")
      .setAppName("main")
    val sc = new SparkContext(conf)

    val data = sc.textFile("")
      .map(_.split(' ')
      .map(_.toDouble))
      .map(line => Vectors.dense(line))
    val rm = new RowMatrix(data)

    val pc = rm.computePrincipalComponents(3)
    val mx = rm.multiply(pc)
    mx.rows.foreach(println)
  }
}
