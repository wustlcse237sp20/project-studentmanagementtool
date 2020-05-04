# cse237-project

## Student Management Tool (Iteration 1)

* What user stories were completed this iteration?
  * A simple GPA calculator was created, which will hopefully be implemented in User Interface once that is ironed out. This will allow students to calculate their GPA by just entering how many courses they took, the grades they received for those courses, and the credits they received for those courses.
  * A basic User Interface has been completed, which will allow the user easier access to the tools we are creating
  * In the basic User Interface, there is a news feed that contains news about Covid-19 from both CNN and BBC. The user can double click on any news story and they will be taken to a web browser where they can read the article.

* What user stories do you intend to complete next iteration?
  * We still want to create an activity tracker, some sort of scheduler, and a stats page. We also need to add the tools that we created to the User Interface, so that our page can be a Toolbox like we intended.

* Is there anything that you implemented but doesn't currently work?
  * Our interface is not complete yet, but we will be working on it. We need to work on wrapping for the news headlines, a refresh button for the news headlines, and we also need to add GUI components for our other tools, including the GPA calculator.

* What commands are needed to compile and run your code from the command line (or better yet, provide a script that people can use to run your program!)
  * To run the GPA calculator, in the src folder of our project, run the command 'java GPACalculator.java' and the program will run.
  To run the UI interface, go to the src folder and run the command 'javac StudentManagerUI.java' followed by the command 'java StudentManagerUI'

## Student Management Tool (Iteration 2)

  * What user stories were completed this iteration?
    * A Covid-19 statistics table that parses the HTML of the covid-19 tracking site https://www.worldometers.info/coronavirus/country/us/ to get up to date data for the US. A table was added to the UI to visualize this information
    * A panel was created on the Student UI for the GPA Calculator tool. The GPA Calculator code was also updated for an easier user experience when using the tool. The user will now be prompted with questions in order to make for a more intuitive experience.
    * A refresh button was added to the news feeds to be able to get up to date articles if the tool is left open for a long period of time.

  * What user stories do you intend to complete next iteration?
    * We still want to create an activity tracker panel and we want to clean up the other tools and the student UI page in general.

  * Is there anything that you implemented but doesn't currently work?
    * Our interface is not complete yet, but we will be working on it. We need to work on wrapping for the news headlines, a refresh button for the covid-19 stats table, and we also need to add GUI components for our other tools, including the activity tracker

  * What commands are needed to compile and run your code from the command line (or better yet, provide a script that people can use to run your program!)
    * From now on, all the features you will need to see should be in our Student Manager UI Interface:


    To run the UI interface, first install gradle. To do that, for windows, use the command 'apt install gradle', for mac, use the command 'brew install gradle.' Next, navigate to the src folder and run the command 'javac StudentManagerUI.java' followed by the command 'java StudentManagerUI.'

## Student Management Tool (Iteration 3)

  * What user stories were completed this iteration?
    * An activity tracker was added to the UI that allows the user to input the number of activities they want to complete for a day, then prompts them to enter the activities, and finally displays those activities with checkboxes next to them to indicate the activities have been completed
    * The user interface was cleaned up in order to make for a better user experience

  * Is there anything that you implemented but doesn't currently work?
    * 

  * What commands are needed to compile and run your code from the command line (or better yet, provide a script that people can use to run your program!)
    * From now on, all the features you will need to see should be in our Student Manager UI Interface:


    To run the UI interface, first install gradle. To do that, for windows, use the command 'apt install gradle', for mac, use the command 'brew install gradle.' Next, navigate to the src folder and run the command 'javac StudentManagerUI.java' followed by the command 'java StudentManagerUI.'
