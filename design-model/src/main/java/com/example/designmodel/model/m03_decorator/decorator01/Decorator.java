package com.example.designmodel.model.m03_decorator.decorator01;

/**
 * @author benjamin_5
 * @Description 抽象装饰器
 * 相比较于策略模式，多了一个装饰器，隔离开了具体的实现
 * @date 2023/4/13
 */
public abstract class Decorator extends Component{
    private Component component; // 持有一个组件对象的引用

    /**
     * 在装饰器的operation中定义除基本操作外，需要额外添加的操作，将这些额外的操作，通过装饰器，与原本的实现类隔离开
     */
    @Override
    public void operation() {
        if(component != null){
            component.operation();
        }
    }

    /**
     * 用setComponent对对象进行包装，这样每个装饰对象的实现就和如何使用这个对象分离开了，每个装饰对象只关心自己的功能，不需要关系如何被添加到对象链中的
     * @param component
     */
    public void setComponent(Component component) {
        this.component = component;
    }
}
