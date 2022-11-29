# Task 3.4 Adding Security

**Assignment**:
1. Review your user/roles model, and ask your mentor for clarifications regarding your security model. For example, you can add ADMIN, STUDENT, TEACHER, and STUFF roles.
2. Use basic security for user authentication.

3. Create an admin panel for assigning a new user's role and create services that help the admin manage users.

4. add required changes with login/logout functionality and logged-in user information to UI

Example:

User administration flow

Given User `A` logged in with Admin role
- User 'A' should be able to navigate to admin panel
- User without admin role should not have access to user admin panel
- User 'A' should be able to list all registered users on user admin page
- User 'A' should be able to set required role for each registered user
  ... etc