# Task 3.6 Implement Groups view + edit feature
**Assignment**
1. Using your flows descriptions from task 3.1 create list of flows to implement, call it features, consult with Mentor if required.
Example:

User administration flow

Given User `A` logged in with Admin role
- User 'A' can Create/Read/Update/Delete group information
  Given User `B` logged in with Student or Teacher role.
- User 'A' should be able to list all groups information (read access).
  Given User `C` logged in with Stuff role
- User 'A' should be able to Create/Read/Update group information.
  ... etc
  
2. Consider feature implementation as subtask(made in new branch and merged int main/master on completion)

For each feature, implement UI pages(usually list, create, edit, delete, etc), controller/controller methods, service/service methods, repository methods.

Controller tests are mandatory, add other components tests if required