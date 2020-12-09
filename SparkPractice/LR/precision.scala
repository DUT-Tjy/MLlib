import org.apache.spark.mllib.classification.LogisticRegressionWithSGD
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.evaluation.MulticlassMetrics
import sun.security.krb5.internal.PAData.{SaltAndParams, getSaltAndParams}

object precision {
  val conf = new SparkConf()
    .setAppName("precision")
    .setMaster("local")
  val sc = new SparkContext(conf)

  def main(args:Array[String]): Unit ={
    val data = MLUtils.loadLibSVMFile(sc, "")
    val splits = data.randomSplit(Array(0.6, 0.4), seed = 11L)
    val parsedData = splits(0)
    val parsedTest = splits(1)
    val model = LogisticRegressionWithSGD.train(parsedData, 50)
    println(model.weights)
    val predictionAndLabels = parsedTest.map{
      case LabeledPoint(label, features) =>
        val prediction = model.predict(features)
        (prediction, label)
    }
    val metrices = new MulticlassMetrics(predictionAndLabels)
    val precision = metrices.precision
    println(precision)
  }
}
