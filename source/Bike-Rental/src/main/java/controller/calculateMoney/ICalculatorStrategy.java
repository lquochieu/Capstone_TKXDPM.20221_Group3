package controller.calculateMoney;


/**
 * @author Group 3
 */
public interface ICalculatorStrategy {
    int getTotal(int totalTime);
    int getDeposit(int amount);
}
