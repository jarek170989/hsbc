package output;

public class PrintOnCommandLineRPNOutput implements RPNOutput{

    private String rpnValue;

    public PrintOnCommandLineRPNOutput(String rpnValue) {
        this.rpnValue = rpnValue;
    }

    @Override
    public void outputRPNValue() {
        System.out.println(rpnValue);
    }
}
