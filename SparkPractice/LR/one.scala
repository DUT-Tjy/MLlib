import org.apache.spark.mllib.classification.LogisticRegressionWithSGD
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.{SparkContext, SparkConf}
object one {
  val conf = new SparkConf()
    .setAppName("one")
    .setMaster("local")
  val sc = new SparkContext(conf)

  def main(args:Array[String]): Unit ={
    val data = sc.textFile("../data/a.txt")
    val parsedData = data.map{ line =>
      val parts = line.split('|')
      LabeledPoint(parts(0).toDouble, Vectors.dense(parts(1).map(_.toDouble)))
    }.cache()
    val model = LogisticRegressionWithSGD.train(parsedData, 50)
    val target = Vectors.dense(-1)
    val result = model.predict(target)
    println(result)
  }
}
