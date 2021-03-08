/**
 * >> 采用继承: 鸭子的行为在子类中不停的改变, 让所有鸭子的子类中都拥有这些行为是不恰当的
 * >> 采用Flyable, Quackable接口: 接口不能实现代码, 继承接口无法达到代码复用, 如果想修改fly行为
 * 		你必须在每个类中修改
 *
 *
 * 	>> 设计原则1: 找出应用中可能需要变化的地方, 把他们独立起来, 不要和那些不需要变化的代码混在一起
 *
 * 	>> 设计原则2: 针对接口编程, 而不是针对实现编程
 *
 *
 * 	>> 'has a' is better than 'is a'
 * 		"有一个"关系相当有趣, 每一只鸭子都有一个fly behavior 和 quack behavior
 * 		好将飞行和呱呱叫行为委托给他们处理
 *
 * 	>> 设计原则3: 多用组合, 少用继承
 *
 *
 * 	>> 策略模式:
 * 		策略模式定义了算法簇, 分别封装起来, 让它们之间可以相互替换
 * 		此模式让算法的变化独立于使用法的客户
 *
 */
package com.jtchen.strategy;