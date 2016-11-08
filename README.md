# Spark Basic

##  What is RDD?
```
   여러 컴퓨터 노드에 흩어져 있으면서 병렬 처리될 수 있는 아이템들의 모음, distributed immutable dataset
```
## RDD Operation
*  Trasnforamtion : RDD -> new RDD (기존 RDD를 새로운 RDD로 생성)
```
  * Narrow dependency : 파티션과 파티션의 관계가 1:1, 1:N (shffule 발생 안함, 네트웍 비용 없음)
        ex) filter, map, mapValues, flatMap, flatMapValues, union, mapPartitions ..
  * Wide dependcency : 파티션과 파티션의 관계가 N :N (shffule 발생, PairRDD에서만 사용, 네트웍 비용 높음)
        ex) sortByKey, combineByKey, groupByKey, partitionBy
```
* Action : Action : RDD를 반환 ( 최종값을 반환하거나, HDFS같은 외부저장소로 저장시 사용)
```
    ex) collect, count, take, reduce, fold, foreach ..
```

## Lineage Graph(DAG)
```
    fault-tolerance를 만족시키기 위한 meta-data, transformation의 의해  Node(RDD) -> RDD(Edge) -> RDD(Edge) ..의 관계를 형성
        ex) 특정 Edge RDD를 손실했을때, lineage Graph에 의해 손실된 RDD를 복구
```

## Driver-worker flow
```
    Driver : 전체 RDD관리, DAG생성, work에게 task할당
    Worker : task처리, 결과값을 Driver에게 반환, 실제 데이터 저장
```

## Driver-worker Cluster flow
* [Spark Cluster](http://spark.apache.org/docs/latest/cluster-overview.html)
```
    Driver Program : SparkContext 생성, Transformation, Action 실행
    Cluster Manager : Task작성 및 조정, DAG생성
    Executor : 각 Task를 실행
```
## Lazy-EXECUTION
* 원하는 값을 처리할떄까지만 기다렸다가 처리(실행), 리소스 최적화에 효과적
```
    transformation에서 DAG를 생성만 하고 실제 Action이 호출될때 연산이 발생
```

## Reference
[Spark 페이지](http://spark.apache.org/docs/latest/)

[Spark 논문](https://www.cs.princeton.edu/courses/archive/spring13/cos598C/spark.pdf)