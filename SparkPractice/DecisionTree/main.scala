import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.mllib.tree.DecisionTree
import org.apache.spark.mllib.util.MLUtils
object main {
  def main(args:Array[String]): Unit ={
    val conf = new SparkConf()
      .setMaster("local")
      .setAppName("main")
    val sc = new SparkContext(conf)
    val data = MLUtils.loadLibSVMFile(sc, "")

    val numClasses = 2
    val categoricalFeatureInfo = Map[Int, Int]
    val impurity = "entropy"
    val max_depth = 5
    val max_Bins = 3

    val model = DecisionTree.trainClassifier(data, categoricalFeatureInfo,
      numClasses, impurity, max_Bins, max_depth)
    println(model.topNode)
    
  }
}
