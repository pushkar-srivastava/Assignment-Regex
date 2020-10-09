# Assignment-Regex
Steps to run the project:

1.Take pull from the given git repository
2.import the project as existing maven project into Eclipse,STS or intelliJ etc.
3.Open AssignmentApplication file right click select option Run As Spring Boot Application.


Endpoint of the API

http://localhost:8080/match

Sample request:
{
    "regex": "[a-zA-Z0-9][a-zA-Z0-9_.]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+",
    "textBody": "Hello my name is pushkar and my email id is push.sriv1@gmail.com. Welcome to Geeksgorgeeks, A Computer Science portal for geeks. It contains well written, well thought and well explained computer science and programming articles, quizzes . My brother, Utkarsh having email id utkrst.sriv@gmail.com and my friend Tanu Jain having email id tanu_jain@gmail.com contributing to geeksforgeeks. If you like GeeksforGeeks and would like to contribute, you can also mail your article to contribute@geeksforgeeks.org."
}

Sample response:
{
    "match": "push.sriv1@gmail.com",
    "error": false
}
