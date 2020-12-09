import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.{LabeledPoint, LinearRegressionWithSGD}
object MSE {
  val conf = new SparkConf()
    .setAppName("MSE")
    .setMaster("local")
  val sc = new SparkContext(conf)

  def main(args:Array[String]): Unit = {
    val data = sc.textFile("../data/a.txt")
    val parsedData = data.map { line =>
      val parts = line.split("|")
      LabeledPoint(parts(0).toDouble,
        Vectors.dense(parts(1).split(',').map(_.toDouble)))
    }.cache()
    val model = LinearRegressionWithSGD.train(parsedData, 2, 0.1)
    val valueAndPreds = parsedData.map { point => {
      val prediction = model.predict(point.features)
      (point.label, prediction)
    }
    }

    val MSE = valueAndPreds.map {
      case (v, p) => math.pow((v - p), 2)
    }.mean()

    println(MSE)
  }
}
