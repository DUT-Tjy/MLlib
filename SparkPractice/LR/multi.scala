import org.apache.spark.mllib.classification.LogisticRegressionWithSGD
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.{SparkContext, SparkConf}
object multi {
  val conf = new SparkConf()
    .setMaster("local")
    .setAppName("multi")
  val sc = new SparkContext(conf)

  def main(args:Array[String]): Unit ={
    val data = MLUtils.loadLibSVMFile(sc, "")
    val model = LogisticRegressionWithSGD.train(data, 50)
    println(model.weights.size)
    println(model.weights)
    println(model.weights.toArray.filter(_ != 0).size)
  }
}
