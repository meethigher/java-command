package top.meethigher.line;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;


public class Calc {

    @Parameter(names = {"--numberA", "-a"}, description = "数字A")
    int a;
    @Parameter(names = {"--numberB", "-b"}, description = "数字B")
    int b;

    @Parameter(names = {"--model", "-m"}, description = "运算符，支持 + - x /")
    String model;

    @Parameter(names = "--help", help = true)
    boolean help;

    public static void main(String... args) {
        Calc main = new Calc();
        JCommander jCommander = JCommander.newBuilder()
                .addObject(main)
                .build();
        jCommander.parse(args);
        if (main.help) {
            jCommander.usage();
            return;
        }
        main.run();
    }

    public void run() {
        int result;
        switch (model) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "x":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            default:
                System.out.println("不支持的运算符");
                return;
        }
        System.out.println(result);
    }
}
