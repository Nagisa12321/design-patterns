# Head First Designer Patterns

___

## 1. 策略模式([stategy](src/main/java/com/jtchen/strategy))

- 策略模式定义了算法簇, 分别封装起来, 让它们之间可以相互替换。 此模式让算法的变化独立于使用法的客户

#### 🍺设计原则1:

- 找出应用中可能需要变化的地方, 把他们独立起来, 不要和那些不需要变化的代码混在一起

#### 🍺设计原则2:

- 针对接口编程, 而不是针对实现编程

#### 🍺设计原则3:

- 多用组合, 少用继承

#### ⭐'has a' is better than 'is a'

- "有一个"关系相当有趣, 每一只鸭子都有一个fly behavior 和 quack behavior 好将飞行和呱呱叫行为委托给他们处理

## 2. 观察者模式([observer](src/main/java/com/jtchen/observer))

- 观察者模式定义了对象之间一对多的依赖, 这样一来, 当一个对象改变状态 所有依赖都会收到通知, 自动更新

#### 🍺设计原则1:

- 为了交互对象之间的松耦合设计而努力

#### ⭐实现细节

1. 自己设计的`Observer/Subject`: 见[*weather*](src/main/java/com/jtchen/observer/weather)
2. 使用`java.util`中的`Observable/Observer`见[*weatherobservable*](src/main/java/com/jtchen/observer/weatherObservable)

#### ⭐ 关于`Observer::update(Observable o, Object arg)`

- `o`: 主题本身当作第一个变量, 好让观察者知道是哪个对象通知它的
- `arg`: 传入观察者的数据对象, 如果没有, 则为空

#### ⭐关于`Observable::notifyObservers()`

- 我用的是`notifyObservers(state)`(push), 把状态封装为一个State对象.
- 书中用的是`notifyObservers()`(pull)。然后观察者收到通知调用自己想要调用的getter方法

> 书中方法更胜一筹, 因为不用每次都传完整的内部信息给观察者, 会造成资源的浪费

#### ⭐关于`setChange()`

- `setChange()`方法用来标记已经改变的事实, 好让`notifyObservers()`知道它被调用 时应该通知观察者, 如果调用`notifyObservers()`之前, 没有调用`setChange()`, 观察者们将
  不会被通知
    - 另外还有`clearChanged()`和`hasChanged()`, 相关功能不再赘述。

#### ⭐不要依赖于观察者被通知的次序

- `Observable::notifyObservers()`中的通知次序是无序的。

#### ⭐`java.util.Obserable`的黑暗面

1. `Obserable`是一个类 你必须得继承他, 因此限制了复用的潜力。

2. `Obserable` 将关键的方法保护起来了, 比如`setChange()`。

#### ⭐ swing中也有相应的观察者模式"listener"

- 详见[swing](src/main/java/com/jtchen/observer/swing/SwingObserverExample.java)

- 主题: `button`, 观察者: 两个`Listener`对象, 通过add...Listener来注册

## 3. 装饰者模式([decorator](src/main/java/com/jtchen/decorator))

- 装饰者模式动态的将责任附加到对象上, 若要扩展功能, 装饰者提供了比继承更有弹性的替代方案
    - 装饰者和被装饰者有相同的超类型
    - 你可以用一个或多个装饰者包装一个对象
    - 在任何需要原始对象被包装的场合, 可以用装饰着替代它
    - 装饰者可以在所委托的被装饰者的行为之前/之后加上自己的行为以达到特定的目的
    - 可以在任何时候被装饰, 可以在运行时动态的不限量的用你喜欢的装饰者装饰对象

#### ⭐ 关于Starbuzz的类初始设计

- 原本设计为

```java
// 父类
public abstract class Beverage {
	private String description;// 由每个子类设置, 描述饮料

	public String getDescription() {
		// ...
	}

	public abstract double cost();
}

// 每种饮料继承该父类
public class Milk extends Beverage {
	public double cost() {
		// 计算咖啡加上订单上各种调料的价钱
	}
}

// ....
```

- 违反了哪两个原则?
    - 多用组合少用继承
    - 找出应用中可能需要变化的地方, 不要和那些不变的混杂在一起

#### ⭐ Beverage的改进

```java
public abstract class Beverage {

	private static final double MILK_VALUE = 10.5;
	private static final double SOY_VALUE = 5.5;
	private static final double MOCHA_VALUE = 8;
	private static final double WHIP_VALUE = 7.5;

	private String description;
	public boolean milk;
	public boolean soy;
	public boolean mocha;
	public boolean whip;

	public String getDescription() {
		return description;
	}

	public double cost() {
		double cost = 0;
		if (milk) cost += MILK_VALUE;
		if (soy) cost += SOY_VALUE;
		if (mocha) cost += MOCHA_VALUE;
		if (whip) cost += WHIP_VALUE;

		return cost;
	}

	// .....
}

```

- Beverage中的`cost()`不在是一个抽象方法, 我们提供了`cost()` 的实现, 让他计算要加入各种饮料的价钱, 子类仍将覆盖`cost()`, 但是会调用超类的`cost()`, 计算出基本饮料加上调料的价钱

#### 🍺 设计原则1: 开放-关闭原则: 类应该对扩展开放, 对修改关闭

- 我们的目标是允许类容易扩展, 在不修改现有代码的情况下, 就能搭配新的行为。
- 不必要让设计的每个部分遵守开放-关闭原则, 通常会引入新的抽象层次。增加代码复杂度

#### ⭐ 利用装饰器模式书写Beverage

- [StarBuzz](src/main/java/com/jtchen/decorator/starbuzz)

- 我们虽然用到了继承, 但是我们用继承达到"类型匹配", 而不是获得某种"行为"。

- 书写完成后, 可以如下添加装饰者, 而且顺序无关, 可重复添加

```
Beverage beverage1 = new HouseBlend();
        beverage1 = new Soy(beverage1);
        beverage1 = new Mocha(beverage1);
        beverage1 = new Mocha(beverage1);
        beverage1 = new Whip(beverage1);
        System.out.println(beverage1.getDescription() + " $" + beverage1.cost());

[sout]: House Blend Coffee, Soy, Mocha, Mocha, Whip $1.54

```

- 工厂模式或者生成器模式将会对装饰者模式封装的更好, 不用担心没有使用到最外圈的装饰者

#### ⭐ 真实世界的装饰者模式 -- InputStream

- 抽象类InputStream相当于我们的Beverage类

- 继承于InputStream的FileInputStream, StringBufferInputStream, ByteArrayInputStream等相当于我们的具体饮料

- FilterInputStream是一个抽象装饰者, 相当于我们的CondimentDecorator。

- 继承于FilterInputStream是具体的装饰者, 可以装饰FileInputStream...等

- [实现自己的InputStream装饰器](src/main/java/com/jtchen/decorator/io/LowerCaseInputStream.java)

#### ⭐ 要点

1. 继承属于扩展形式之一, 但不见得是达到弹性设计的最佳方法

2. 在我们的实际中， 应该允许行为可以被扩展, 而无需修改现有的代码

3. 组合和委托有利于运行时动态加上新的行为

4. 除了继承, 装饰者模式也可以让我们扩展行为

5. 装饰者模式意味着**一群装饰者类**, 这些类用来包装具体组件

6. 装饰者类反映出被装饰的组件类型, **事实上它们具有相同的类型**, 都是经过接口或者继承实现

7. 装饰者可以在被装饰着的前面或者后面加上自己的行为, 甚至可以将被装饰者的行为整个取代掉, 而达到特定的目的

8. 你可以用**无数**个装饰者装饰特定的组件

9. 装饰者一般对组件的客户是透明的, 除非客户依赖于组件的具体类型

10. 装饰者会导致设计中出现很多小对象, 会让程序变得复杂

## 4. 工厂模式([factory](src/main/java/com/jtchen/factory))

- **工厂方法模式**: 定义了一个创建对象的接口, 但由子类决定要实例化的类是哪一个, 工厂方法让类的实例化推迟到子类

- **抽象工厂模式**: 提供一个接口, 用于创建相关或依赖对象的家族, 而不需要明确指定具体类。

- 区别：
    - 抽象工厂使用的是对象: 模式用于对象中的多个实例创建, 工厂方法使用的是类: 用于不同种类对象的创建
    - 方法工厂用继承的方法延迟对象的创建, 抽象工厂是通过各种对象的组合, 而且这个各种对象指的是被创建对象所包含的对象

#### ⭐ "new"有什么不对劲?

- 技术上new没有错。但是会导致我们代码使用大量具体类, 就是自找麻烦, 因为一旦加入新的具体类的时候, 就必须改变代码。也就是说, 你的代码并非"对修改关闭".

#### ⭐ 关于Pizza的初始方法设计:

```
Pizza orderPizza(String type) {
	Pizza pizza;
	if (type.eqauals("...")) {
	
	}
	if (type.eqauals("...")) {
	
	}
	if (type.eqauals("...")) {
	
	}
	if (type.eqauals("...")) {
	
	}
	
	// .....
}
```

- 明显的, 当你需要更新菜单(添加删除某个种类的pizza, 必须不断修改菜单), 如果实例化某些pizza类, 将使`orderPizza()`出现问题, 也无法让`orderPizza()`对修改关闭

- 哪些是改变的, 哪些是不变的?   
  明显pizza的种类是改变的, 但是要通过字符串实例化一个pizza对象这个动作是不变的

#### ⭐ 建立一个简单的pizza工厂

- 将创建对象移动到`orderPizza()`之外的另一个对象中, 这个新的对象只管如何创建pizza, 如果任何对象想要创建pizza, 找它就行了;

- 我们称这个新的对象为"工厂"(factory). 那么`orderPizza()`就是该对象的客户

- [SimplePizzaFactory.java](src/main/java/com/jtchen/factory/pizzas/SimplePizzaFactory.java)

- 利用静态方法定义一个工厂, 这是很常见的技巧, 常常被称为静态工厂, 但是它也有缺点, 不能通过继承来改变创建方法的行为

- 简单工厂不是一个设计模式, 是一种编程习惯

#### ⭐ 加盟Pizza店

- 需求: 加盟的pizza店不仅要有自己风格的pizza, 还要有自己独特的做菜方法

```
// 把工厂对象重新移动到这个方法中, 不过是抽象的
// 加盟的pizza店应该继承PizzaStore类并且实现自己的create方法

public abstract Pizza createPizza(String type);
```

- 允许子类做决定:

1. 我们希望所有加盟店对于订单的处理能够一致: 因此在父类定义好`orderPizza()` 方法

2. 我们希望每个加盟店做出不同风味的pizza, 因此在父类声明抽象`createPizza()`方法

3. 我们希望pizza有自己独特的制作方法, 因此我们可以适当重写Pizza中的方法.

- 子类如何做决定?

    - `orderPizza()`是父类中定义的方法, 因此不知道哪个子类(Store)在制作pizza

    - Pizza也是抽象的, `orderPizza()`并不知道在具体制作pizza的过程中哪些具体参数参与进来了

- [pizza](src/main/java/com/jtchen/factory/pizzafm);

- 工厂方法用来处理对象的创建, 并将这样的行为封装在子类之中, 这样, 客户程序中关于超类的代码就和子类对象创建代码解耦了

```
/*
abstract      :   工厂方法是抽象的, 所以依赖子类处理对象的创建
Product       :   工厂方法必须返回一个产品, 超类中定义的方法, 通常使用到工厂方法的返回值
factoryMethod :   工厂方法将客户(也就是超类中的代码(orderPizza())和实际创建具体产品分割开来)
String type   :   工厂方法可能需要参数也可能不需要, 来指定所需要的产品
*/

absert Product factoryMethod(String type) {
    // ...
}
```

- 如何产生你想要的pizza?
    1. 创建一个PizzaStore的子类实例  
       `PizzaStore store = new NYPizzaStore()`
    2. 调用实例的orderPizza方法  
       `store.orderPizza("cheese")`
    3. orderPizza虽位于抽象类PizzaStore, 但是在运行时会调用具体类的`createPizza()`方法
    4. 最后由父类对具体的pizza进行处理, 返回Pizza对象

#### ⭐ 关于工厂方法模式

1. 当只有一个具体实现的时候, 工厂方法模式有什么优点?

    - 只有一个具体创建者, 工厂方法模式依然推荐, 因为它帮助我们"实现" 从'使用'中解耦。如果我们增加任何产品, Creator丝毫没有受到影响

2. 工厂方法是否总是抽象的?

    - 不一定, 这取决于产品是否有抽象类, 如果产品没有抽象类, 也就是说, 只有一种具体产品, 那我们就不需要抽象的创建者和抽象的工厂方法了

3. 简单工厂和工厂方法模式的区别?

    - 简单工厂把所有的事情都在一个地方处理完了. 工厂方法模式创建一个模式, 让子类决定要如何实现

#### ⭐ 一个很依赖的PizzaStore

- [DependentPizzaStore](src/main/java/headfirst/designpatterns/factory/pizzafm/DependentPizzaStore.java)

- 当你实例化一个对象的时候, 它就是在依赖具体类

- 我们已经创建了一个抽象Pizza类, 但在DependentPizzaStore代码中, 我们仍然创建了具体Pizza类

- 依靠工厂方法, 我们把这些实例化代码独立出来, 变成只依赖Pizza类, 符合依赖抽象不依赖具体的原则.

#### 🍺 设计原则1: 依赖倒置原则

要依赖抽象, 不要依赖具体

1. 变量不可以持有**具体类**的引用: 如果使用new, 就会持有具体类的引用, 你可以用工厂方法来避开这样的做法
2. 不要让类派生具体类: 如果派生自具体类, 那么还是会依赖具体类, 请派生自一个抽象接口/类
3. 不要覆盖基类中实现的方法: 如果覆盖已实现的方法, 那么你的基类就不是真正一个适合被继承的抽象，基类中实现的方法, 应该由所有子类共享

- 自己设计的HttpRequest工厂: [RequestFactory](src/main/java/com/jtchen/factory/http/RequestFactory.java)(待测试)

#### ⭐ 依赖原料的pizza店

- [pizzaf](src/main/java/com/jtchen/factory/pizzaaf)

- 在这种设计之中我们把Pizza, material(原料), PizzaFactory, PizzaIngredientFactory(原料工厂) 分开。因此我们不需要为原料产地不同, 但所需原料种类相同,
  而且制作方法相同的pizza分不同的类 。例如CheesPizza就是CheesPizza, 没有所谓NYCheesPizza和ChicagoPizza的区别。抽象类Pizza只关心如何处理Pizza,
  Pizza子类关心从哪个工厂取真实原料进行处理。各种Store负责Pizza的生成加工, 并且初始化 Pizza子类的时候会通知其去哪个工厂取原料。

- 顺序:
    1. 为原料工厂创建一个接口, 这个接口负责处理所有原料.
    2. 为每个区域创建具体工厂, 继承1. 所创建的工厂接口
    3. 实现一组原料类提供使用
    4. 重写pizza类: 每个pizza都持有一组原料。将prepare设置为抽象方法。 让子类决定要去哪个工厂获取原料
    5. 重写pizza子类, 子类的构造函数中必须获得一个原料工厂, 实现prepare方法, 从具体工厂获得具体原料
    6. 重写PizzaStore子类, 在重写的create方法中将具体工厂赋给具体Pizza子类, 并且return出相应制造好的不同地区, 不同种类的pizza供父类实现加工。

## 5. 单件模式([Singleton](src/main/java/com/jtchen/singleton))

- **单件模式**: 确保一个类只有一个实例, 并且提供一个全局访问点
    - 把某个类设计自己管理的一个单独实例.
    - 当你需要时, 向类查询, 它会返回单个实例

#### ⭐ 全局变量的缺点?

- 如果把对象赋值给一个全局变量, 那么你就必须在程序开始的时候就创建它, 如果不对它加以使用, 就会造成浪费

#### ⭐ 剖析经典单例模式实现

- [Singleton](src/main/java/com/jtchen/singleton/example/Singleton.java)

#### ⭐ 单件模式的特点:

1. 独一无二: 在任意时刻只有一个对象
2. 独一无二的好处: 常常被用来管理资源, 如: 数据库连接池和线程池
3. 没有公有构造器: 外人为了取得单例模式的实例, 必须请求得到一个实例, 而不是自行实例化得到一个实例。

#### ⭐ 巧克力工厂

- [ChocolateBoiler](src/main/java/com/jtchen/singleton/chocolate/ChocolateBoiler.java)

```
public static synchronized ChocolateBoiler getInstance() {
        if (chocolateBoiler == null)
            chocolateBoiler = new ChocolateBoiler();
        return chocolateBoiler;
}
```

- 在多线程模式下, 居然会拿到两个不同的实例[ChocolateBoilerTest](src/test/java/com/jtchen/singleton/chocolate/ChocolateBoilerTest.java)
    - 解决方法1: 使用synchronized关键字对`getInstance()`方法进行同步
    - 解决方法2: 采用急切创建实例, 而不是延迟创建实例的方法: jvm在加在类的过程中也会直接加载实例出来
    - 解决方法3: 采用"双重检查加锁", 首先检查实例是否创建了, 如果尚未创建, 才进行同步。

## 6. 命令模式([Command](src/main/java/com/jtchen/command))

- **命令模式**: 将"请求"封装成对象, 以便使用不同的请求, 队列或者日志来参数化其他对象, 命令模式也支持可撤销操作
    - 我们知道一个命令对象通过在特定的接收者上绑定一组动作来封装一个请求。要达到这一点, 命令对象将动作和接收者包进对象之中, 这个对象只暴露出一个`execute()`方法, 从外面来看, 其他对象不知道究竟哪个接收者进行了哪些动作
      , 只知道如果调用execute()
      方法, 请求目的就能达到

#### ⭐ 神奇遥控器

- [Control](src/main/java/com/jtchen/command/control/app)

- 在本章我们将把封装调用推到另一个新的境界: 对函数进行封装

- 如何设计遥控器api?

    - 遥控器应该知道如何解读按钮被按下的动作, 然后发出正确的请求, 但遥控器不需知道这些家电的自动化细节

    - 采用命令模式 : 可以把动作的请求者从动作的执行者中解耦, 采用"命令对象" 就可以办得到。如果每个按钮都存储一个命令对象, 当按钮被按下的时候, 就可以请命令对象做相关的工作

    - 使用这个模式, 我们能创建一个API, 将这些命令对象加载到按钮的插槽, 让遥控器的代码尽量保持简单, 而把家电自动化的工作和进行该工作的对象一起封装在命令对象之中

    - 这种模式/模型允许将"发出请求的对象"和"接收和执行这些请求的对象"分割开来

- [关于NoCommand](src/main/java/com/jtchen/command/control/command/impl/NoCommand.java)
    - 是一个空对象的例子, 当你不想返回一个有意义的对象的时候, 客户也可以将处理null的责任交给空对象

- **添加撤销操作**:
    - 用栈来保存执行过的指令

```
    private final Stack<Command> stack;

    ....

    public void onCommandWasPushed(int slot) {
	    onCommands[slot].execute();
	    stack.push(onCommands[slot]);
    }

	public void offCommandWasPushed(int slot) {
	    offCommands[slot].execute();    
	    stack.push(offCommands[slot]);
    }
    ....
```

- 每次执行指令都存入栈中, 等到要撤销时, 如果栈不空, 从栈顶弹出一个指令, 并且执行其`undo()`方法

- [**宏命令**](src/main/java/com/jtchen/command/control/command/impl/MacroCommand.java);

#### ⭐ 命令模式的更多用途: 队列请求

- [workingqueue](src/main/java/com/jtchen/command/workingqueue)

- 在队列中装入多个TwoSumCommand, ThreeSumCommand, 让各个线程去执行

- 工作队列类和进行计算的对象时完全解耦的, 工作队列对象不在乎到底在做些什么, 它们只知道从BQ中取出命令对象, 并且调用其execute方法

## 7. 适配器模式([Adapter](src/main/java/com/jtchen/adapter))

- **适配器模式**: 将一个类的接口, 转换成客户期望的另一个接口, 适配器让原本接口不兼容的类可以合作无间

#### ⭐ 从插头开始:

- 插座适配器的作用: 它位于美式插头和欧式插座之间, 它的工作时将欧式插座转换成美式插座, 好让美式插头可以插进这个插座获得电力

- java适配器和真实世界的适配器没什么区别, 将一个接口转化成另一个接口, 以符合客户的期望.

- 适配器就像一个中间人, 将客户发出的请求转换成厂商类能理解的请求

#### ⭐ 用鸭子适配器来让火鸡冒充鸭子🦃

- [TurkeyAdapter](src/main/java/com/jtchen/adapter/duck/TurkeyAdapter.java)

- 客户使用适配器的过程如下:
    - 客户通过目标接口调用适配器的方法对适配器发出请求  
      (表现在客户只需调用适配器的`quack()`方法来间接调用turkey对象的`gobble()`方法)
    - 适配器使用被适配者接口把请求转换成被适配者的一个或者多个调用接口  
      (表现在适配器应该继承Duck接口, 并且把火鸡的种种行为写在继承方法之中)
    - 客户收到调用的结果, 但并未察觉这一切是适配器在起转化作用  
      (表现在客户并不知道这是一只真正的Duck还是火鸡冒充的Duck)

#### ⭐ 迭代器的适配器

- [iterator](src/main/java/com/jtchen/adapter/iterator)

#### ⭐ 装饰者模式和适配器模式的区别

- 装饰者模式: 工作是和"责任"相关的, 有时候它只是一个装饰者, 天晓得还有多少其他的装饰者会把它包装起来, 当一个方法调用委托给他时, 它根本不知道有多少个装饰者已经装饰过这个方法
  而它也不知道它对这个方法的装饰是否会得到别人的注意
- 适配器模式: 一定会进行接口的调换

