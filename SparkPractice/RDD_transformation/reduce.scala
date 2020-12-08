import org.apache.spark.{SparkContext, SparkConf}

object reduce {
  def main(args:Array[String]): Unit ={
    val conf = new SparkConf()
      .setMaster("local")
      .setAppName("reduce")
    val sc = new SparkContext(conf)
    val arr = sc.parallelize(Array("a", "b"))
    val result = arr.reduce(myFun)
    result.foreach(print)
  }

  def myFun(str1:String, str2:String): String={
    var str = str1
    if(str.size <= str2.size){
      str = str2
    }
    return str
  }
  //按指定的方式进行数据修改
}
