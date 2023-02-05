package controller.calculateMoney;

/**
 * @author Group 3
 */
public class Calculator implements ICalculatorStrategy {

    @Override
    public int getTotal(int totalTime) {
        if (totalTime <= 10) return 0;
        else if (totalTime <= 30) return 10000;
        else {
            int count = ((totalTime - 30 - 1) / 15) + 1;
            return 10000 + 3000 * count;
        }
    }

    @Override
    public int getDeposit(int amount) {
        return amount * 40 / 100;
    }
}
