import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.mllib.tree.RandomForest
import org.apache.spark.mllib.util.MLUtils
object main {
  def main(args :Array[String]): Unit ={
    val conf = new SparkConf()
      .setMaster("local")
      .setAppName("RF")
    val sc = new SparkContext(conf)
    val data = MLUtils.loadLibSVMFile(sc, "")
    val numclasses = 2
    val categoricalFeatureInfo = Map[Int, Int]()
    val numTrees = 3
    val featureSubsetStrategy = "auto"
    val impurity = "entropy"
    val maxdepth = 5
    val maxBins = 3

    val model = RandomForest.trainClassifier(data, numclasses, categoricalFeatureInfo,
      numTrees, featureSubsetStrategy, impurity, maxdepth, maxBins)

    model.trees.foreach(println)
  }
}
