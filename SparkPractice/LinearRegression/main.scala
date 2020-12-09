import org.apache.spark.ml.regression.LinearRegressionModel
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.{LabeledPoint, LinearRegressionWithSGD, StreamingLinearRegressionWithSGD}
import org.apache.spark.{SparkConf, SparkContext}
object main {
  val conf = new SparkConf()
    .setMaster("local")
    .setAppName("LinearRegression")
  val sc = new SparkContext(conf)

  def main(args:Array[String]): Unit ={
    val data = sc.textFile("../data/a.txt")
    val parsedData = data.map{line =>
      val parts = line.split(',')
      LabeledPoint(parts(0).toDouble, Vectors.dense(parts(1).split(' ').map(_.toDouble)))
    }.cache()
    val model = LinearRegressionWithSGD.train(parsedData, 100, 0.1)
    val result = model.predict(Vectors.dense(2))
  println(result)
  }
}
