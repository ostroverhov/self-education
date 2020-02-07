Feature: Second test

  Scenario Outline: Compare characteristics of two cars with price

    Given Open page 'MAINPAGE'
    When I click button 'RESEARCH' from main page
    Then Open page 'RESEARCHPAGE'

    When Search '<firstCarModel>'
    Then '<firstCarModel>' is found

    When Click “Compare trims” link
    Then Open page 'COMPARETRIM'
    And Trim for selected '<firstCarModel>'
    And Save other parameters for '<firstCarModel>' into json

    When I open main page
    Then Open page 'MAINPAGE'

    When I click button 'RESEARCH' from main page
    Then Open page 'RESEARCHPAGE'

    When Search '<secondCarModel>'
    Then '<secondCarModel>' is found

    When Click “Compare trims” link
    Then Open page 'COMPARETRIM'
    And Trim for selected '<secondCarModel>'
    And Save other parameters for '<secondCarModel>' into json

    When I click button 'RESEARCH'
    Then Open page 'RESEARCHPAGE'

    When Click button 'Side-by-side Comparisons'
    Then Open page 'COMPARECARS'

    When I select '<firstCarModel>' and click button 'Start compare'
    Then Open page 'MODELCOMPAREPAGE'
    And Page with selected '<firstCarModel>'

    When Click button 'Add another car' and select '<secondCarModel>'
    Then Page with added '<secondCarModel>'
    And Check car parameters for '<firstCarModel>' and '<secondCarModel>'

    When Click first car panel
    Then '<firstCarModel>' is found
    And Price are save

    When I open main page
    Then Open page 'MAINPAGE'

    When I search '<firstCarModel>' in 'Used Cars' with 'No Max Price' radius '20 Miles from' zip code '10001'
    Then Found at least one result

    When Add trim and year from '<firstCarModel>'
    Then Found at least one result
    And Price used car lower then price new car

    Examples:
      | firstCarModel | secondCarModel |
      | car1          | car2           |
      | car3          | car2           |
