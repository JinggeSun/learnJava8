# learnJava8
学习java8的新个性

最近在学习Flink,Spark流计算引擎，想到Java中也有相关的接口，再次重新复习一下。

学习中，要思考在Java7中如何实现，在Java8中如何实现。如果不明白，记住，时刻几日，再复习。

思路为主，主要是lambda，stream，webflux
# IDEA 常用快捷键
1. 编译 control + r
2. 实体构造settergetter command + n

## stream
### Intermediate：
map (mapToInt, flatMap 等)、 filter、 distinct、 sorted、 peek、 limit、 skip、 parallel、 sequential、 unordered

### Terminal：
forEach、 forEachOrdered、 toArray、 reduce、 collect、 min、 max、 count、 anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 iterator

### Short-circuiting：
anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 limit


参考文章[stram](https://www.ibm.com/developerworks/cn/java/j-lo-java8streamapi/index.html)
### map
map 生成的是个 1:1 映射，每个输入元素，都按照规则转换成为另外一个元素
1. 列表数据转换大小写
2. 列表数据平方
### flatMap
一对多映射关系
1. 将hello world 两个单词合并去重
2. 多个stream<List> 转为 stream<String>
### filter
filter 对原始 Stream 进行某项测试，通过测试的元素被留下来生成一个新 Stream。

在flink，spark也有这个算子，可以这样理解，filter为过滤，满足过滤条件的留下来，组成新的stream
1. 只要偶数
### forEach
forEach 方法接收一个 Lambda 表达式，然后在 Stream 的每一个元素上执行该表达式。

forEach 是 terminal 操作，因此它执行后，Stream 的元素就被“消费”掉了，你无法对一个 Stream 进行两次 terminal 运算。
1. 打印列表中男性的姓名
### findFirst
这是一个 termimal 兼 short-circuiting 操作，它总是返回 Stream 的第一个元素，或者空。

这里比较重点的是它的返回值类型：Optional。这也是一个模仿 Scala 语言中的概念，作为一个容器，它可能含有某值，或者不包含。使用它的目的是尽可能避免 NullPointerException。
1. Optional.ofNullable(text).ifPresent(System.out::println);
2. Optional.ofNullable(text).map(String::length).orElse(-1);
#### Optional要加入到接口学习中来

### reduce
 Stream 元素组合起来

 它提供一个起始值（种子），然后依照运算规则（BinaryOperator）

 String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);

 第一个参数（空白字符）即为起始值，第二个参数（String::concat）为 BinaryOperator
 1. 拼接字符串
 2. 求和

### limit/skip
limit 返回 Stream 的前面 n 个元素；skip 则是扔掉前 n 个元素

persons.stream().map(Person::getName).limit(10).skip(3).collect(Collectors.toList());

 limit 和 skip   先sorted后 l/s 有影响

### sorted
它比数组的排序更强之处在于你可以首先对 Stream 进行各类 map、filter、limit、skip 甚至 distinct 来减少元素数量后，再排序，这能帮助程序明显缩短执行时间。

compareTo 两个数据比较
### min/max/distinct
最小值，最大值，去重
### Match
只返回true和false
1. allMatch：Stream 中全部元素符合传入的 predicate，返回 true
2. anyMatch：Stream 中只要有一个元素符合传入的 predicate，返回 true
3. noneMatch：Stream 中没有一个元素符合传入的 predicate，返回 true
