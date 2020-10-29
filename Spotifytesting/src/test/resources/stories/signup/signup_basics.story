Narrative:
This story covers basic tests of signup

Scenario: Type invalid year
Given I open signup page
When I set month "January"
And I set day "20"
And I set year "85"
And I click Sign Up
Then I see error "Enter a valid year."
Examples:
|month   |day|year|
|December|14 |30  |
|October |29 |53  |
|May     |9  |45  |


Scenario: Type invalid confirm email

Given I open signup page
When I type email "afhjbdsf@ajaff.rt"
And I type confirm email "afhjbdsf@ajaff.rt"
And I type password "Qwerty1@"
And I click Sign Up
Then I see error "The email addresses don't match."


Scenario: Sign Up with empty password

Given I open signup page
When I type email "afhjbdsf@ajaff.rt"
And I type confirm email "afhjbdsf@ajaff.rt"
And I type name "Testname"
And I click Sign Up
Then I see error "You need to enter a password."


Scenario: Type invalid values

Given I open signup page
When I type email "afhjbdsf@ajaff.rt"
And I type confirm email "afhjbdsf@ajaff.rt"
And I type password "Qwerty1@"
And I type name "Testname"
When I set month "January"
And I set day "20"
And I set year "85"
And I select sex "Non-binary"
And I click Sign Up
Then I see "4" errors
And I see that "1" error has text "Enter a valid year."