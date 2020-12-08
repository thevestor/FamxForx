# FamxForx
栈和队列
采用“后进先出”的存储结构
顺序栈
即用顺序表实现栈存储结构。使用栈存储结构操作数据元素必须遵守“先进后出”的原则。
例如：我们先使用顺序表(a数组)存储{1，2，3，4},存储状态如图
数组a:[1][2][3][4]
    a[0] a[1] a[2] a[3]
数组的存储形式主要以暴力存储的方式
而使用栈的存储结构{1，2，3，4},其存储状态为
[1][2][3][4] ——> 数据进栈
             <-- 数据出栈
通过数组的结构与栈的结构相比较，使用顺序表模拟栈结构较简单，只需要将数据从a数组下标为0的位置异常存储即可。
总结：从数组下标为0的模拟栈存储数据是常用的方法，从其他数组下标处存储数据也完全可以，这里只是为方方便初学者理解。
图数组中元素的消失仅是为了方便初学者学习，其实，这里只需要对top值做-1操作即可，因为top值本身就表示栈的栈顶位置，因此top-1就等同于栈顶元素出栈。
后期向栈中添加元素时，新元素会存储在类似元素4这样的旧元素位置上，将旧元素覆盖。
元素4和元素3全部出栈后，元素2才能出栈。因此，使用顺序表模拟数据出栈操作，都从一个元素入栈开始进栈操作进行匹配。

主体类方法代码如下
代码链接：https://github.com/thevestor/FamxForx/Stack/SqStack.java

总结：通过学习顺序表模拟栈中的数据入栈和出栈的操作，初学者完成了对顺序栈的学习。


链式栈的存储结构
括号匹配linkedlistStack.java
在一个表达式中含有圆括号或方括号等来表示运算的优先级的序列
例如：表达式[(A + B)*C]-[E - F]其中括号序列称为不匹配序列
匹配序列示例： ([()]) [][]() ()[()]
不匹配序列示例：([()]] ([)
栈的存储结构验证：
1.初始化一个空栈，顺序读入括号
2.若是左括号，则压入栈中
3.若全部元素遍历完毕，栈中仍然存在元素，则该序列不合法
1号位左小括号入栈，2号位左中括号入栈，3号位右中括号进栈，匹配2号位，出栈。
2号位右小括号入栈，匹配1号位，出栈
1号位左中括号入栈，2号位右中括号入栈，匹配1号位，出栈。
代码如下： 
主体类:https://github.com/thevestor/FamxForx/Stack/Main.java
扩展：介绍Java hasNext()方法
在用户输入内容时，我们希望先输出“请输入”,然而系统提示为先输入内容，再输出“请输入：”.
于是利用hasNext()方法，我们可以发现，hasNext()返回的是boolean类型而next()返回的是你输入的那个值。，用户可以将输入的内容存储到sc中，然后通过查询sc，再调用用户输入的内容。

优化后栈的链式括号匹配
介绍：用户输入括号，通过函数判断是否匹配
主体类：https://github.com/thevestor/FamxForx/blob/main/stackTest/BalancedParan.java

图
由顶点的有穷非空集合和顶点之间边的集合组成，通常表示为：G(V,E)，其中，G表示一个图，V(vertex)是图G中顶点的集合，E(edge)是图G中边的集合
分类：按有无方向分类：有向图和无向图
无向图由顶点和边组成，有向图由顶点和弧组成，弧有弧头和弧尾两部分组成。
如果任意的两个顶点之间都存在边，叫完全图，有向的图叫有向完全图
如果无重复的边或者顶点到自身的边则叫做简单图，数学表示：无向图用()表示，有向图用<>表示
图的顶点和边间的关系：
顶点的度：就是顶点关联边的数目。在有向图中，分为出度：方向背向顶点的边；
入度：方向指向顶点的边。有向图的度为入度和出度的和。
路径长度：路径上边或者弧的数目。
联通性：在无向图中，从一个顶点除法，有到达其他任意顶点的路径，则称这个图是联通的。具有这种性质的有向图叫做强连通图。
如果把一个有向图的所有有向边去掉方向形成的无向图称为这个有向图的基础图，也叫基图。
有向图不是强连通，但是他的基图是连通的，则被称为弱连通。
图的表示方法：
1.邻接矩阵：使用一个顶点数组存储顶点，使用一个边数组存储顶点间是否存在边。
VertexArray:{A,B,C,D}
EdgeArray:A B C D
        A 0 1 1 1
        B 1 0 0 1
        C 1 0 0 1
        D 1 1 1 0
主对角线都是0，即自身到自身在简单图中不考虑。
        

图的存储结构
邻接矩阵和邻接表

图的邻接矩阵存储方式，结构由顶点数量、边数量、顶点集合和边集合组成
其中顶点集合一维数组，根据顶点的数量来动态分配数组大小。边集合是二维数组，根据顶点的数量来动态分配数组大小，对于无向图来说，该邻接矩阵是对称矩阵。
邻接矩阵比较适用于稠密图
1.首先设置变量：顶点数量、边的数量、顶点集合(动态数组)、边集合(二维动态数组)。其中为了节省空间，将顶点集合设置成动态数组，根据顶点数量来分配空间。

邻接表
结构由边的下标、指向下一个结点的指针、顶点、指向第一条边、顶点数量、边的数量、顶点集合(动态数组)组成。

无向图的遍历
分为深度优先遍历和广度优先遍历

深度优先遍历基本思路：
1.访问顶点V
2.从V的未被访问的邻接点中选取一个顶点W，从W除法进行深度优先遍历
3.重复以上2步，直到图中所有和V有路径相同的顶点被访问到
类似树的遍历
1.访问顶点，visited[v] = 1;
2.w=顶点v的第一个邻接点
3.while(w){
    if(w未被访问) 从顶点w出发递归执行该算法
    w = 顶点v的下一个邻点
}
广度优先遍历
基本思路：
1.访问顶点v
2.依次访问v的各个未被访问的邻接点v1,v2,v3。。。vk
3.分别v1,v2,v3。。。vk从出发依次访问他们未被访问的邻接点，
并使“先被访问的顶点邻接点先于”后被访问顶点的邻接点“
被访问，直到图中所有与顶点V有路径相同的顶点都被访问到。
采用入队的方式，
1.初始化队列Q
2.访问顶点v,visited[w] = 1;顶点入队Q；
3.while(队列Q非空){
    v = 队列Q的队头元素出队
    w = 顶点v的第一个邻接点
    while(w存在){
        if(w未被访问){
            访问顶点w，visited[w] = 1;顶点w入队Q
        }
        w = 顶点v的下一个邻接点
    }
}

