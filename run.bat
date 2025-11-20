@echo off
REM run.bat — compile all .java files and run Main (compiles all sources together)

cd /d "%~dp0"

echo === Cleaning previous build ===
if exist out (
    rmdir /s /q out
)

echo === Creating new out folder ===
mkdir out

echo === Collecting Java source files ===
set "filelist="
for /R src %%f in (*.java) do (
    REM Append with space delimiter
    set "filelist=!filelist! "%%f""
)

REM Use delayed expansion to read filelist variable
setlocal enableDelayedExpansion
echo Files to compile:
echo !filelist!

echo === Compiling all Java sources in one javac invocation ===
javac -d out !filelist!
if ERRORLEVEL 1 (
    echo.
    echo COMPILATION FAILED! See the errors above.
    endlocal
    pause
    exit /b 1
)
endlocal

echo.
echo === Compilation Success! Running Program ===
echo.
java -cp out Main

echo.
echo Press any key to exit...
pause > nul
