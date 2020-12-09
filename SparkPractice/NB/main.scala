import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.classification.{NaiveBayes, NaiveBayesModel}
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.{SparkConf, SparkContext}
import spire.math.Algebraic.Expr.Mul
object main {
  def main(args: Array[String]): Unit ={
    val conf = new SparkConf()
      .setMaster("main")
      .setAppName("local")
    val sc = new SparkContext(conf)

    val data = MLUtils.loadLibSVMFile(sc, "")
    val model = NaiveBayes.train(data, 1.0)
    model.labels.foreach(println)
    model.pi.foreach(println)

  }
}
