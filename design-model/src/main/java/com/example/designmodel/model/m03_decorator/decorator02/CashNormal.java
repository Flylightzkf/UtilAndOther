package com.example.designmodel.model.m03_decorator.decorator02;

/**
 * @author benjamin_5
 * @Description 正常收银
 * @date 2023/4/18
 */
public class CashNormal implements ISale{

        @Override
        public double acceptCash(double price, int num) {
            System.out.println("normal: "+ (price * num));
            return price * num;
        }
}
