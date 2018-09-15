package input;

public class CommandLineRPNInputFetcher implements RPNInputFetcher{

    private String rpnInputFromCommandLine;

    public CommandLineRPNInputFetcher(String rpnInputFromCommandLine) {
        this.rpnInputFromCommandLine = rpnInputFromCommandLine;
    }

    public String getRPN() {
        return rpnInputFromCommandLine;
    }
}
