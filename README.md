# java
AFL Java Project

Class Implementation Assessment Create an object-oriented design from a problem description and implement as a working Java program



You will, using object-oriented principles, design a set of interrelated classes and implement them as a Java program. It’s your final grand challenge!

Specifically, you will create a program for organizing AFL team members, teams, and results.

Part I: AFLTeamMember (10 marks)

You will implement a class AFLTeamMember. Each team member (players, coaches, etc.) has a
name and a position.

You will implement this class, including getter and setter methods as appropriate.The positions on an AFL team are as follows: FB, HB, C, HF, FF, FOL, IC, COACH. Therefore, check if the value of position is relevant before setting in the setter.

Also, write a toString method to have String representation of an AFLTeamMember as follows: “FirstName LastName,POSITION”. For example, “Simon Goodwin, COACH”.

Part II: AFLPlayer (10 marks)

You will implement a class AFLPlayer. This will be a child class of AFLTeamMember. Each AFLPlayer, in addition to having a name and a position, will also have a number, and may or may not be a captain.

You will implement this class, including getter and setter methods as appropriate. However, for setting the value of number, it is required to check if the number is a valid positive number.

The String representation of an AFLPlayer should be as follows “[Number] FirstName Last Name, POSITION”, followed by “(c)” if that player is a captain. For example, “[1] Adam Treloar, HF”, or “[11] Max Gawn, FOL (c)”.


Part III: AFLTeam (10 marks)

You will implement a class AFLTeam. Each team has a name, a coach (which is an instance of AFLTeamMember), and a lineup consisting of 22 AFLPlayers.

You will implement this class, including getter and setter methods as appropriate. Also write a toString method to get current value of all the attributes of this class.
Part IV: AFLMatch (15 marks)

You will implement a class AFLMatch. An AFL match has two AFLTeams homeTeam and awayTeam, and the score attributes for each team. In an AFL match, each score can either be a goal worth 6 points, or a behind, worth 1 point. You will need to keep track of these separately, as in the number of homeGoals, the number of homeBehinds, the number of awayGoals, and the number of awayBehinds. This class will also contain main() method and another method to load the lineup.

You will implement this class, including getter and setter methods as appropriate.

Part V: Load in the lineups (25 marks)

To load the lineups of the two teams, you will accept as input at the command line the names of two files. The first filename will be the name of a file the home team’s lineup, and the second filename will be the name of a file containing the away team’s lineup.

For example, you would start the program as:

> java AFLMatch MelbourneDemons.txt WesternBulldogs.txt

File names must be passed as arguments to the main method. This would load the home team’s lineup from MelbourneDemons.txt, and the away team’s lineup from WesternBulldogs.txt. These two files are provided to you for testing; the content of WesternBulldogs.txt is included here:

Western Bulldogs
Luke Beveridge, COACH 10, Easton Wood, FB 42, Alex Keath, FB
15, Taylor Duryea, FB 35, Caleb Daniel, HB 12, Zaine Cordy, HB 31, Bailey Dale, HB
6, Bailey Smith, C
21, Tom Liberatore, C 7, Lachie Hunter, C
19, Cody Weightman, HF 33, Aaron Naughton, HF 1, Adam Treloar, HF
39, Jason Johannisen, FF 44, Tim English, FF
29, Mitch Hannan, FF 8, Stefan Martin, FOL 11, Jack Macrae, FOL
4, Marcus Bontempelli, FOL, c 34, Bailey Williams, IC
5, Josh Dunkley, IC 37, Roarke Smith, IC 13, Josh Schache, IC

These files consist of name of team, COACH and 22 players (among them 1 is captain) details. Before the game starts loadup both teams homeTeam and awayTeam. However, if the number of players is less than 22 in any team, a relevant error message should be printed, and match should not start.


Part VI: Run the game (20 marks)

You will use a loop to take input from the user, who is the “scorekeeper.” This loop will prompt the user to type one letter to indicate which team scored: “h” for the home team or “a” for the away team. It will then prompt the user to type one letter to indicate the type of score: “g” for goal or “b” for behind. This loop will keep running until the user types “f”, to indicate full time (the end of the match). In action, the loop might look like this:


Which team scored? h
Goal or behind? b	
The current score is Which team scored? a	0.1	(1)	to	0.0	(0).
Goal or behind? g					
The current score is	0.1	(1)	to	1.0	(6).
Which team scored? h					
Goal or behind? g					
The current score is	1.1	(7)	to	1.0	(6).
Which team scored? f					
FULL TIME					

 Melbourne Demons 1.1 (7) defeated Western Bulldogs 1.0 (6).
 For   example, if current score is 1.10, it means 1 goal and 10 behind so final score would be 

6+10=16.
Please supply screenshots of the output of your program.
Part VII: Test Results for invalid input (10 marks)

Please supply screenshots for the output of your program for invalid input values – that is inputs other than “h”, “a”, “b”, “g”, or “f” entered in the scorekeeping loop.
