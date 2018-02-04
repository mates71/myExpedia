Feature: Expedia flight booking

Scenario: flight field should be displayed
	Given the use on expedia home page
	When user clict the flight button
	Then user should be fill out flight origne and destination field
	And user also chose departing and returning date
	And user should chose Adault count
	And user should be define children count and ages
	Then user should be clict search button