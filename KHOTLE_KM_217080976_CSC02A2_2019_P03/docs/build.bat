REM Author: Kananelo Maxwell
REM Student#: 217080976
REM Practical: 01

REM dont print anything to the console unless told to.
@echo off

REM clears the screen.
cls

echo *** Navigating to parent directory ***

REM change to parent directory
cd ..

echo *** Setting program variables ***

REM declare variables.
set BIN=.\bin
set SRC=.\src
set DOCS=.\docs

echo *** Setting path variable ***

REM set path variable
set PATH=%PATH%;C:\Program Files\Java\jdk1.8.0_172\bin

echo *** Compiling program ***

REM compile program
javac -sourcepath %SRC% -cp %BIN% -d %BIN% %SRC%\Main.java

echo *** Running program ***
echo.
echo ***********************

REM execute program.
java -cp %BIN% Main

echo.
echo ***********************

REM navigate to DOCS directory
cd %DOCS%