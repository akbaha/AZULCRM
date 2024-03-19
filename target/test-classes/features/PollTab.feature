@B32G19-262
Feature: Default
	@login
	Scenario Outline: Verify login with different user types
		Given the user logged in as "<user type>"
		Then user land on base page

		Examples:
			| user type      |
			| Helpdesk user  |
			| Marketing user |
			| HR user        |

	@B32G19-251
	Scenario: Verify that the delivery is 'All employees' by default.
		Given user click on a Poll tab
		Then user should see in the delivery box "All employees" by default	

	#{color:#de350b}*User Story*{color}
	#
	#As a user, I should be able to create a poll by clicking on Poll tab in the Activity Stream
	#
	#*{color:#de350b}AC2{color}* Verify that the user can create a poll by adding questions and multiple answers.
	#
	# 
	@B32G19-252
	Scenario: Verify that the user can create a poll by adding questions and multiple answers.
		Given user click on a Poll tab
		Then user can write "Message title" in the Message title field
		
		And user can write "Question" in the Question field
		
		And user can write "Answer 1" in the Answer 1 field
		
		And user can write "Answer 2" in the Answer 2 field
		
		Then user click on Send button
		
		Then user can see created Poll	

	#{color:#de350b}*User Story*{color}
	#
	#As a user, I should be able to create a poll by clicking on Poll tab in the Activity Stream
	#
	#*{color:#de350b}AC3{color}* Verify that the user can select the “Allow multiple choice” checkbox.
	@B32G19-253
	Scenario: Verify that the user can select the “Allow multiple choice” checkbox.
		Given user click on a Poll tab
		Then user can select the “Allow multiple choice” checkbox	

	#{color:#de350b}*User Story*{color}
	#
	#As a user, I should be able to create a poll by clicking on Poll tab in the Activity Stream
	#
	#
	#*{color:#de350b}AC4{color}* Verify the corresponding error messages for the mandatory fields.
	#
	#*Mandatory fields:* Message title, recipient, 1 question, 1 answer
	#● Error message: "The message title is not specified"
	#● Error message: "Please specify at least one person."
	#● Error message: "The question text is not specified."
	#● Error message: "The question "........." has no answers."
	@B32G19-254
	Scenario: Verify the corresponding error messages for the mandatory fields. Message title.
		Given user click on a Poll tab
		Then user can write "Question" in the Question field
		And user can write "Answer 1" in the Answer1 field
		And user can write "Answer 2" in the Answer2 field
		Then user click on Send button
		Then user can see Error message "The message title is not specified"	

	#{color:#de350b}*User Story*{color}
	#
	#As a user, I should be able to create a poll by clicking on Poll tab in the Activity Stream
	#
	#
	#*{color:#de350b}AC4{color}* Verify the corresponding error messages for the mandatory fields.
	#
	#*Mandatory fields:* Message title, recipient, 1 question, 1 answer
	#● Error message: "The message title is not specified"
	#● Error message: "Please specify at least one person."
	#● Error message: "The question text is not specified."
	#● Error message: "The question "........." has no answers."
	@B32G19-255
	Scenario: Verify the corresponding error messages for the mandatory fields. Recipient.
		Given user click on a Poll tab
		Then user can write "Message title" in the Message title field
		Then user delete "All employees" from delivery box
		Then user can write "Question" in the Question field
		And user can write "Answer 1" in the Answer1 field
		And user can write "Answer 2" in the Answer2 field
		Then user click on Send button
		Then user can see Error message "Please specify at least one person."	

	#{color:#de350b}*User Story*{color}
	#
	#As a user, I should be able to create a poll by clicking on Poll tab in the Activity Stream
	#
	#
	#*{color:#de350b}AC4{color}* Verify the corresponding error messages for the mandatory fields.
	#
	#*Mandatory fields:* Message title, recipient, 1 question, 1 answer
	#● Error message: "The message title is not specified"
	#● Error message: "Please specify at least one person."
	#● Error message: "The question text is not specified."
	#● Error message: "The question "........." has no answers."
	@B32G19-256
	Scenario: Verify the corresponding error messages for the mandatory fields. 1 question.
		Given user click on a Poll tab
		Then user can write "Message title" in the Message title field
		And user can write "Answer 1" in the Answer1 field
		And user can write "Answer 2" in the Answer2 field
		Then user click on Send button
		Then user can see Error message "The question text is not specified"	

	#{color:#de350b}*User Story*{color}
	#
	#As a user, I should be able to create a poll by clicking on Poll tab in the Activity Stream
	#
	#
	#*{color:#de350b}AC4{color}* Verify the corresponding error messages for the mandatory fields.
	#
	#*Mandatory fields:* Message title, recipient, 1 question, 1 answer
	#● Error message: "The message title is not specified"
	#● Error message: "Please specify at least one person."
	#● Error message: "The question text is not specified."
	#● Error message: "The question "........." has no answers."
	@B32G19-257
	Scenario: Verify the corresponding error messages for the mandatory fields. 1 answer.
		Given user click on a Poll tab
		Then user can write "Message title" in the Message title field
		Then user can write "Question" in the Question field
		Then user click on Send button
		Then user can see Error message "The question ... has no answers."