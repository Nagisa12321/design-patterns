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