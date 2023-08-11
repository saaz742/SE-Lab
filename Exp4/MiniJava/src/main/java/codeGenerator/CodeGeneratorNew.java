package codeGenerator;

import scanner.token.Token;

public class CodeGeneratorNew {
    private CodeGenerator codeGenerator;

    public CodeGeneratorNew() {
        codeGenerator = new CodeGenerator();
    }

    public void semanticFunction(int func, Token next) {
        codeGenerator.semanticFunction(func, next);
    }

    public void printMemory() {
        codeGenerator.printMemory();
    }
}
