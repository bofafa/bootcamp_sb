# bootcamp_sb




 position 
 - software developer
 - data engineer
 - business Analyst
 - Assistant project manager

# tech Stack 
proamming language to focus;
Reactjs

Tech Stack to focus:
kubemetes, Devops, typescript

System integrator (SI) like a agent 

question ask in interview:

1.Tech Stacks: what language?
2.Team size > 5 
3. teach team's vision 
4. job project vs BAU, business as usuall, re ream?
5. what applications they use? what coding system 
6. do they have SA/AP level to coach you on coding


in- house: 
its not project based

vendor:
project based - (contrat)
new project? 做upgrade? 
EDM system, CRM system?
domain sunset or booming? // product is leading or not?

SI:
what department？
client, industriess
project scale
ERS system
CRM system, follow up
front end ot back end


Here's a more structured bullet-point version of your interview notes:

- **Self-Introduction**:
  - Mention past experience briefly (under 20 seconds).
  
- **Why Change Career Path to IT**:
  - I believe IT is creative and offers the opportunity to build and innovate.

- **Why IT is a Good Fit**:
  - Coding provides self-fulfillment.
  - I enjoy solving problems through debugging and creating new things.

- **Pre-Bootcamp Experience**:
  - Self-studied coding before starting the bootcamp.
  - Found coding to be fascinating and engaging.

- **Why Choose Me Over a CS Degree Graduate**:
  - Practical reasons: no time or resources to pursue a full CS degree.
  - The bootcamp provided me with the specific skills for this role.

- **Biggest Strengths and Weaknesses**:
  - **Weakness**: Public speaking, but I’m working on improving it.
  - **Strength**: Ability to adapt to different environments quickly.

- **Salary Requirements**:
  - Desired range: 23K-25K.

- **What Are You Looking for in This Position**:
  - I want to establish my career path in IT.

- **Where Do You See Yourself in Five Years**:
  - If given this opportunity, I hope to perform well and prove to myself and my family that this was the right career choice.

- **Are You Considering Other Positions**:
  - Yes, I am exploring all opportunities to break into the IT industry.

- **Questions to Ask**:
  - Prepare around 15 questions.
  - Examples: How many people are in the team? Who will be my team lead?

This structure should help you stay organized and clear during your interview.

Junit -> case test 
frame work 
method 愈多test case 愈少, 

# controller call service, service call database





# spring boot 

#open folder

1. resource folder creat yml -> 
   server:
     port: 8081


2. open folder model, service, controller, operation 
3. create responds file  for result: string x, string, opertaion, result
4.  create operator file  for // -> enum 
   ADD("add),
   SUB etc........

5. open folder operation -> create operation, @getMapping (url), @PostMapping  (url)
6. res 
     @RequestParam  link 有"?" 形式
     @PathVariable 
     @RequestBody -> object -> send Json to server

7. go back to enum. write operation , divied zero, throw excepting 

8. open floder exerption: write exception method
9.  go back to model open a class  for exception for ErroResponse
10. go back to model operator put the put the exception in the throw exception


OSCAR: https://github.com/OscarLoOscar/bc2405p/tree/main/demo-api

## MVN
- mvn compile (main code)
- mvn test-compile (main compile + test compile)
- ** mvn test (main comile +test compile +test), test -> bean cycle
- mvn package (all the above + generate jar)
- mvn install (all thee above + copy the jar from project to m2)