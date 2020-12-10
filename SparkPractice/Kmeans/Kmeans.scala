import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.mllib.clustering.KMeans
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.{SparkConf, SparkContext}
object Kmeans {
  def main(args:Array[String]): Unit ={
    val conf = new SparkConf()
      .setAppName("main")
      .setMaster("local")
    val sc = new SparkContext(conf)
    val data = MLUtils.loadLibSVMFile(sc, "")
    val parsedData = data.map{ s => Vectors.dense(s.split(' ').map(_,toDouble))
    }.cache()

    val numClusters = 2
    val numIterrations = 20
    val model = KMeans.train(parsedData, numClusters, numIterrations)
    model.clusterCenters.foreach(println)

  }
}
