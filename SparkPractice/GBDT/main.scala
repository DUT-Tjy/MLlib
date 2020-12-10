import org.apache.spark.mllib.tree.GradientBoostedTrees
import org.apache.spark.mllib.tree.configuration.BoostingStrategy
import org.apache.spark.mllib.tree.model.GradientBoostedTreesModel
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.util.MLUtils
object main {
  def main(args : Array[String]): Unit ={
    val conf = new SparkConf()
      .setMaster("main")
      .setAppName("local")
    val sc = new SparkContext(conf)
    val data = MLUtils.loadLibSVMFile(sc, "")
    val boostingStrategy = BoostingStrategy.defaultParams("classification")
    boostingStrategy.numIterations = 3
    boostingStrategy.treeStrategy.numClasses = 2
    boostingStrategy.treeStrategy.maxDepth = 5
    boostingStrategy.treeStrategy.categoricalFeaturesInfo = Map[Int, Int]()

    val model = GradientBoostedTrees.train(data, boostingStrategy)
  }
}
