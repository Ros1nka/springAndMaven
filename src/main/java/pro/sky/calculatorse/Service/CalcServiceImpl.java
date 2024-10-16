package pro.sky.calculatorse.Service;

import org.springframework.stereotype.Service;

@Service
public class CalcServiceImpl implements CalcService {

    public String hello() {
        return "<i>Добро пожаловать в калькулятор<i>";
    }

    public Integer plus(int num1, int num2) {
        return num1 + num2;
    }

    public Integer minus(int num1, int num2) {
        return num1 - num2;
    }

    public Integer multiply(int num1, int num2) {
        return (num1 * num2);
    }

    public Double divide(int num1, int num2) {
        return num1 / (double)num2;
    }
}
