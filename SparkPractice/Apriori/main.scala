import scala.collection.mutable
import scala.io.Source
object main {
  def main(args:Array[String]): Unit ={
    val minSup = 2
    val list = new mutable.LinkedHashSet[String]()
    Source.fromFile("").getLines()
      .foreach(str => list.add(str))
    var map = mutable.Map[String, Int]()
    list.foreach(strss=>{
      val strs = strss.split(".")
      strs.foreach(str =>{
        if (map.contains(str)){
          map.update(str, map(str)+1)
        } else map += (str -> 1)
      })
    })
    val tmpMap = map.filter(_._2 > minSup)
    val mapKey = tmpMap.keySet
    val tempList = new mutable.LinkedHashSet[String]()
    val conList = new mutable.LinkedHashSet[String]()
    mapKey.foreach(str => tempList.add(str))
    tempList.foreach(str => {
      tempList.foreach(str2 => {
        if (str != str2){
          val result = str + "/" + str2
          conList.add(result)
        }
      })
    })

    conList.foreach(strss => {
      val strs = strss.split(".")
      strs.foreach(str => {
        if (map.contains(str)){
          map.update(str, map(str)+1)
        }else map += (str -> 1)
      })
    })
  }
}
