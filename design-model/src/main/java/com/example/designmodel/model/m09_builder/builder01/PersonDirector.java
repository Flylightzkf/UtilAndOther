package com.example.designmodel.model.m09_builder.builder01;

/**
 * @author benjamin_5
 * @Description 指挥者：构建一个使用Builder的对象
 * @date 2023/4/24
 */
public class PersonDirector {

    private PersonBuilder personBuilder;

    public PersonDirector(PersonBuilder personBuilder) {
        this.personBuilder = personBuilder;
    }

    public void createPerson() {
        personBuilder.buildHead();
        personBuilder.buildBody();
        personBuilder.buildArmLeft();
        personBuilder.buildArmRight();
        personBuilder.buildLegLeft();
        personBuilder.buildLegRight();
    }
}
