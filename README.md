
Demo Desktop Client
============================================================

used IDE is ApacheNetBeans 12.0


imap config:
de.jsoft.jdesktop.email.MailClient
username / password
-> line 57

de.jsoft.jdesktop.emails.createMail
smtp config for send mail with username password and config for gmx 
over smtp handshake
-> line 138


default username: admin
        password: jj78mvpr52k1



this Java Swing Application connects with 

http basic (RFC 2617) 

auth over port 8443.





To compile this application install maven.

maven
https://downloads.apache.org/maven/maven-3/3.8.2/binaries/apache-maven-3.8.2-bin.zip

make sure that java is correctly installed and the "JAVA_HOME" path is set.

You can get the java jdk from here:

----------------------------------------------

used jdk:
**GraalVM Community **
https://www.graalvm.org/downloads/

----------------------------------------------

**Java Azul **
https://www.azul.com/products/core/

**Open JDK**
https://openjdk.java.net/

**or Java Bell Soft**
https://bell-sw.com/pages/downloads/#mn



to run the programm install netbeans

https://downloads.apache.org/netbeans/netbeans/12.5/Apache-NetBeans-12.5-bin-windows-x64.exe

and compile the main file 

**JDesktop**



make sure that 

https://github.com/demogitjava/LanServer.git

from here is running.



To run the software in a sandbox you can choose the Docker Desktop from here:
https://www.docker.com/products/docker-desktop


**jgsoftwares/jgsoftwares:latest** 

start the container and open ports for connect:

9092 127.0.0.1 9092
8443 127.0.0.1 8443











