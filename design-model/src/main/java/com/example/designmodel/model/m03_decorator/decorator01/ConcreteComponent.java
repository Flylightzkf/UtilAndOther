package com.example.designmodel.model.m03_decorator.decorator01;

/**
 * @author benjamin_5
 * @Description  具体的组件类，定义基本、原始的操作
 * @date 2023/4/13
 */
public class ConcreteComponent extends Component{

    /**
     * 定义这个基本组件最基础的原本操作，要附加的操作抽取到装饰器中
     */
    @Override
    public void operation() {
        System.out.println("具体对象的操作");
    }
}
