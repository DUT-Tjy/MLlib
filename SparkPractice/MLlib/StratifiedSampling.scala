import org.apache.spark.{SparkContext, SparkConf}

object StratifiedSampling {
  def main(args:Array[String]): Unit ={
    val conf = new SparkConf()
      .setAppName("StratifiedSampling")
      .setMaster("local")
    val sc = new SparkContext(conf)
    val data = sc.textFile("../data/a.txt")
      .map(row => {
        if (row.length == 3)
          (row, 1)
        else (row, 2)
      })
    val fractions: Map[String, Double] = Map("aa" -> 2)
    val approxSample = data.sampleByKey(withReplacement = false, fractions, 0)
    approxSample.foreach(println)
  }
}
