import org.apache.spark.mllib.classification.SVMWithSGD
import org.apache.spark.mllib.evaluation.MulticlassMetrics
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.{SparkContext, SparkConf}
object shijian {
  def main(args:Array[String]): Unit ={
    val conf = new SparkConf()
      .setMaster("local")
      .setAppName("shijian")
    val sc = new SparkContext(conf)

    val data = MLUtils.loadLibSVMFile(sc, "")
    val splits = data.randomSplit(Array(0.7, 0.3))
    val parsedData = splits(0)
    val parsedTest = splits(1)
    var model = SVMWithSGD.train(parsedData, 50)
    val predictionAndLabel = parsedTest.map{
      case LabeledPoint(label, features) =>
        val prediction = model.predict(features)
        (prediction, label)
    }
    val metrics = new MulticlassMetrics(predictionAndLabel)
    val precision=  metrics.precision

  }
}
