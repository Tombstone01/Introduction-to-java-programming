@echo off

REM Author: Kananelo Maxwell
REM Student#: 217080976
REM Practical: 00

cd ..

set %PATH%  = %PATH%;C:\Program Files\Java\jdk1.8.0_201\bin

REM echo %PATH%

set BIN=.\bin
set SRC=.\acsse.csc2a
set DOC=.\docs

javac -sourcepath %SRC% -d %BIN% %SRC%\Main.java
java -cp %BIN% Main
javap -c %BIN%\Main.class >> %DOC%\ByteCode.txt

REM move ByteCode.txt %DOC%

cd %DOC%
