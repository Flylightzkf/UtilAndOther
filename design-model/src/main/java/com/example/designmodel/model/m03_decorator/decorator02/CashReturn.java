package com.example.designmodel.model.m03_decorator.decorator02;

/**
 * @author benjamin_5
 * @Description 买xx返yy收银
 * @date 2023/4/18
 */
public class CashReturn extends CashSuper{

        private double moneyCondition = 0d;
        private double moneyReturn = 0d;

        public CashReturn(double moneyCondition, double moneyReturn) {
            this.moneyCondition = moneyCondition;
            this.moneyReturn = moneyReturn;
        }

        @Override
        public double acceptCash(double price, int num) {
            double result = price * num;
            if (result >= moneyCondition) {
                result = result - Math.floor(result / moneyCondition) * moneyReturn;
            }
            System.out.println("return: "+ result);
            return super.acceptCash(result, 1);
        }
}
