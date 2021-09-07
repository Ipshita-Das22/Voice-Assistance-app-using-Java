# Voice-Assistance-app-using-Java
Handles your computer just like "Siri" in mobile.

This project is based on voice assistance and works like "ALEXA","SIRI" for small tasks.

OLIVER THE VOICE ASSISTANT

To make this project you require 3 jars they are mentioned below:-

1. sphinx4-core

2. sphinx4-data

3. freetts jar 

else if you are making maven you will need add dependencies as follows:-

1.  
         Group id-  de.sciss
         artifact id-   sphinx4-data
         version- 1.0.0
    

2.  
        Group id -net.sf.phat
        artifact id -sphinx4-core
        version - 5prealpha
    

3.  
    
        Group id- net.sf.sociaal
        artifact id -freetts
        version -1.2.2
    

after this you need to make list of some commands and make its file and then
search for sphinx knowledge base generator and upload that file and we are 
only bothered about two files .
1. lm file
2. dic file
save both of them and add it to the resource of your project later you need to give path in code.

freetts is used to speak all the commands according to work.

this project can be added to a big project.
In my project this can work for:
1. opening and closing of chrome.
2.opening and closing of youtube.
3.opening and closing of sublimetext.
4. terminating the project itself.etc

way to call the commands as:
oliver open/close chrome/youtube/sublimetext.
oliver terminate.-->for ending the running state.
