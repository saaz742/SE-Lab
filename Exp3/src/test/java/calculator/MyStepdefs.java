package calculator;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class MyStepdefs {
    private Calculator calculator;
    private int fist;
    private int second;
    private char operator;
    private double result;
    private String errorMessage;

    @Before
    public void before() {
        calculator = new Calculator();
    }

    @Given("Two numbers {int} and {int} and operator {word}")
    public void twoNumbersFirstAndSecondAndOperatorOpt(int first, int second, String operator) {

        this.fist = first;
        this.second = second;
        this.operator = operator.charAt(0);
    }

    @When("I calculate the answer")
    public void iCalculateTheAnswer() {
        try {
            result = calculator.calculate(fist, second, operator);
        } catch (ArithmeticException | IllegalArgumentException e) {
            errorMessage = e.getMessage();
        }
    }

    @Then("I get {double}")
    public void iGetAnswer(double answer) {
        assert result == answer;
    }

    @Then("I get an error with message {string}")
    public void iGetAnErrorWithMessageMessage(String message) {
        assert errorMessage.equals(message);
    }
}
