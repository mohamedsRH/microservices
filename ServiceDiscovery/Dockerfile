# Use the official Tomcat base image that runs on JDK 17
FROM tomcat:10.1.7-jdk17-corretto

# Remove the default webapps to avoid conflicts
RUN rm -rf /usr/local/tomcat/webapps

# Copy the WAR file to the webapps directory in Tomcat
COPY target/*.war /usr/local/tomcat/webapps/ROOT.war

# Expose the port Tomcat runs on
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
