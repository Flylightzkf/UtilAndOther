package com.example.designmodel.model.m02_strategy.strategy01;

/**
 * @author benjamin_5
 * @Description 上下文
 * @date 2023/4/13
 */
public class Context {
    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void contextInterface() {
        strategy.algorithmInterface();
    }

    public static void main(String[] args) {
        Context context;
        context = new Context(new ConcreteStrategyA());
        context.contextInterface();
        context = new Context(new ConcreteStrategyB());
        context.contextInterface();
        context = new Context(new ConcreteStrategyC());
        context.contextInterface();
    }
}
