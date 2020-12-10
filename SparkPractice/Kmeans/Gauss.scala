import org.apache.spark.ml.clustering.GaussianMixture
import org.apache.spark.mllib.ustering.GaussianMixture
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.{SparkConf, SparkContext}

object Gauss {
  def main(args:Array[String]): Unit ={
    val conf = new SparkConf()
      .setMaster("Gauss")
      .setAppName("local")
    val sc = new SparkContext(conf)

    val data = sc.textFile("")
    val parsedData = data.map{s => Vectors.dense(s.trim.split(" "))}
      .map(_.toSDouble).cache()
    val model = new GaussianMixture().setK(2).run(parsedData)
    for (i <- 0 until model.k){
      println("weight=%f\nmu=%s\nsigma=\n%s\n"format
        (model.weights(i), model.gaussians(i).mu, model.gaussian(i).sigma)
      )
    }
  }
}
