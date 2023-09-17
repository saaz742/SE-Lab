@tag
Feature: Calculator

  Scenario Outline: Calculate valid expressions
    Given Two numbers <first> and <second> and operator <opt>
    When I calculate the answer
    Then I get <answer>

    Examples:
      | first | second | opt | answer |
      | 10    | 20     | +   | 30     |
      | -10   | 20     | +   | 10     |
      | -10   | -20    | +   | -30    |
      | 10    | 20     | -   | -10    |
      | -10   | 20     | -   | -30    |
      | -10   | -20    | -   | 10     |
      | 10    | 20     | *   | 200    |
      | -10   | 20     | *   | -200   |
      | -10   | -20    | *   | 200    |
      | 0     | 20     | *   | 0      |
      | 10    | 20     | /   | 0.5    |
      | -10   | 20     | /   | -0.5   |
      | -10   | -20    | /   | 0.5    |
      | 0     | 20     | /   | 0      |
      | 2     | 2      | ^   | 4      |
      | -2    | 2      | ^   | 4      |
      | -2    | 3      | ^   | -8     |
      | 2     | -2     | ^   | 0.25   |
      | -2    | -2     | ^   | 0.25   |
      | -2    | -3     | ^   | -0.125 |
      | 2     | 0      | ^   | 1      |
      | -2    | 0      | ^   | 1      |
      | 0     | 2      | ^   | 0      |

  Scenario Outline: Calculate invalid expressions
    Given Two numbers <first> and <second> and operator <opt>
    When I calculate the answer
    Then I get an error with message "<message>"

    Examples:
      | first | second | opt | message                          |
      | 10    | 0      | %   | Invalid operator                 |
      | 10    | 0      | /   | Division by zero is undefined    |
      | 0     | 0      | /   | Division by zero is undefined    |
      | 0     | 0      | ^   | 0^0 is undefined                 |
      | 0     | -2     | ^   | 0^(negative number) is undefined |




