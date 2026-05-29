@echo off
title Gym Me - Fitness Center Management
cd /d "%~dp0"
java -cp "build/classes;lib/mariadb-java-client-3.3.3.jar;lib/jasperreports-6.20.6.jar;lib/commons-beanutils-1.9.4.jar;lib/commons-collections4-4.4.jar;lib/commons-digester-2.1.jar;lib/commons-logging-1.2.jar;lib/groovy-3.0.9.jar" gym.form.FormLogin
pause
