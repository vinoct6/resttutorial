#!/bin/sh
echo "Deleting file"
rm /Users/vinoth/Documents/Softwares/wildfly-8.2.1.Final/standalone/deployments/resttutorial.war
echo "copying...."
cp /Users/vinoth/Documents/Learning/resttutorial/target/resttutorial.war /Users/vinoth/Documents/Softwares/wildfly-8.2.1.Final/standalone/deployments
