import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.classification.SVMWithSGD
import org.apache.spark.mllib.regression.LabeledPoint
object main {
  def main(args:Array[String]): Unit ={
    val conf = new SparkConf()
      .setMaster("main")
      .setAppName("local")
    val sc = new SparkContext(conf)

    val data = sc.textFile("")
    val parsedData = data.map{ line =>
      val parts = line.split('|')
      LabeledPoint(parts(0).toDouble, Vectors.dense(parts(1).map(_.toDouble)))
    }.cache()
    val model = SVMWithSGD.train(parsedData, 10)
    println(model.weights)
    println(model.intercept)
  }
}
