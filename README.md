# CarpoolingSys
 j2ee lab 3 by Kexin Zhu

# How to run
## Config with annotation
The servlet is configured with annotation by default.
Run the project on server in IDE. Or export the project to .war in the directory of TomCat .\webapps, then start the server.
In the browser, use url: http://localhost:8080/CarpoolingSys/carpool

## Config with web.xml
The backup xml file locates in the ./xmlbackups folder. Replace the .\src\main\webapp\WEB-INF\web.xml with it.
Comment line 13 "@WebServlet("/carpool")" in CarpoolServlet.java.
Use the same method metioned above to run the servlet.

# Others
The screenshots are in the directory ./screenshots.
