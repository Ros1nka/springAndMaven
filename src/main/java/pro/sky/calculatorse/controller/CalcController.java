package pro.sky.calculatorse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.calculatorse.Service.CalcService;
import pro.sky.calculatorse.exception.DivideByZeroException;
import pro.sky.calculatorse.exception.NullParameterException;

@RestController
@RequestMapping("/calculator")
public class CalcController {
    private final CalcService calcService;

    public CalcController(CalcService calcService) {
        this.calcService = calcService;
    }

    @GetMapping
    public String hello() {
        return calcService.hello();
    }

    @GetMapping(path = "/plus")
    public String plus(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        validateParameters(num1, num2);
        return num1 + " + " + num2 + " = " + calcService.plus(num1, num2);
    }

    @GetMapping(path = "/minus")
    public String minus(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        validateParameters(num1, num2);
        return num1 + " - " + num2 + " = " + calcService.minus(num1, num2);
    }

    @GetMapping(path = "/multiply")
    public String multiply(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        validateParameters(num1, num2);
        return num1 + " * " + num2 + " = " + calcService.multiply(num1, num2);
    }

    @GetMapping(path = "/divide")
    public String divide(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        validateParameters(num1, num2);
        if (num2 == 0) {
            throw new DivideByZeroException("Деление на ноль");
        }
        return num1 + " / " + num2 + " = " + calcService.divide(num1, num2);
    }

    private void validateParameters(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
            throw new NullParameterException("Ошибка ввода параметров");
        }
    }
}
