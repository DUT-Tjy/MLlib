import org.apache.spark.mllib.feature.{IDF, HashingTF}
import org.apache.spark.{SparkContext, SparkConf}
object main {
  def main(args:Array[String]): Unit ={
    val conf = new SparkConf()
      .setAppName("local")
      .setMaster("main")
    val sc = new SparkContext(conf)

    val documents = sc.textFile("")
    val hashingTF = new HashingTF()
    val tf = hashingTF.transform(documents).cache()
    val idf = new IDF().fit(tf)

    val tf_idf = idf.transform(tf)
    tf_idf.foreach(println)
  }
}
