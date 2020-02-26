Feature: First test

  Scenario: Compare characteristics of two cars

    Given Check the page 'MAINPAGE' opening
    When I click button 'RESEARCH' from main page
    Then Check the page 'RESEARCHPAGE' opening

    When Search 'car1'
    Then 'car1' is found

    When Click “Compare trims” link
    Then Check the page 'COMPARETRIM' opening
    And Trim for selected 'car1'
    And Save other parameters for 'car1' into json

    When I open main page
    Then Check the page 'MAINPAGE' opening

    When I click button 'RESEARCH' from main page
    Then Check the page 'RESEARCHPAGE' opening

    When Search 'car2'
    Then 'car2' is found

    When Click “Compare trims” link
    Then Check the page 'COMPARETRIM' opening
    And Trim for selected 'car2'
    And Save other parameters for 'car2' into json

    When I click button 'RESEARCH'
    Then Check the page 'RESEARCHPAGE' opening

    When Click button 'Side-by-side Comparisons'
    Then Check the page 'COMPARECARS' opening

    When I select 'car1' and click button 'Start compare'
    Then Check the page 'MODELCOMPAREPAGE' opening
    And Page with selected 'car1'

    When Click button 'Add another car' and select 'car2'
    Then Page with added 'car2'
    And Check car parameters for 'car1' and 'car2'