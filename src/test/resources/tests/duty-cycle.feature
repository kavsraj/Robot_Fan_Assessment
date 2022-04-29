Feature: Fan Control

  Scenario Outline: Duty Cycle verificationsx
    Given the temperature is at <mostRecentTemp>
    When the temperature is <comparator> <thresholdTemp>
    Then Fan should run at <dutyCycle>

    Examples:
      | mostRecentTemp | comparator  | thresholdTemp | dutyCycle |
      | 24        | lessThan    | 25            | 20%       |
      | 35        | equalsTo    | 35            | 28%       |
      | 45        | equalsTo    | 45            | 36%       |
      | 55        | equalsTo    | 55            | 44%       |
      | 65        | equalsTo    | 65            | 52%       |
      | 75        | greaterThan | 75            | 100%      |

