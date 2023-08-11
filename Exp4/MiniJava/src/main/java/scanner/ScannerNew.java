package scanner;

import scanner.token.Token;

public class ScannerNew {
    private final lexicalAnalyzer lexicalAnalyzer;

    public ScannerNew(java.util.Scanner sc) {
        lexicalAnalyzer = new lexicalAnalyzer(sc);
    }

    public Token getNextToken() {
        return lexicalAnalyzer.getNextToken();
    }
}
