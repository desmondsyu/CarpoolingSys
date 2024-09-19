# CarpoolingSys
 j2ee lab 3 by Kexin Zhu n01621302

# How to run
## Config with annotation
The servlet is configured with annotation by default.<br>
To run the project on server in Eclipse IDE, need to have Tomcat V10.1 server implemented. <br>
Right click on the project, then Run As > Run on Server.<br>
In the browser, use url: http://localhost:8080/CarpoolingSys/carpool<br>
<br>
Or right click the project and export the project to WAR file, save it in the directory of TomCat .\webapps, then start the server.<br>
In the browser, use url: http://localhost:8080/CarpoolingSys/carpool<br>

## Config with web.xml
The backup xml file locates in the ./xmlbackups folder. Replace the .\src\main\webapp\WEB-INF\web.xml with it.<br>
Comment line 13 "@WebServlet("/carpool")" in CarpoolServlet.java.<br>
Use the same method metioned above to run the servlet.<br>

# Others
The screenshots are in the directory ./screenshots.
