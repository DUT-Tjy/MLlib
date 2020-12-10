import org.apache.spark.mllib.feature.Word2Vec
import org.apache.spark.{SparkContext, SparkConf}
object main {
  def main(args:Array[String]): Unit ={
    val conf = new SparkConf()
      .setMaster("local")
      .setAppName("main")
    val sc = new SparkContext(conf)

    val documents = sc.textFile("").map(_.split(" ").toSeq)
    val word2vec = new Word2Vec()
    val model = word2vec.fit(data)
    println(model.getVectors)
  }
}
