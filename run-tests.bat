@echo off
REM Run Gradle tests and produce reports (Windows)
call gradlew.bat clean test
if %errorlevel% neq 0 (
  echo "Tests failed or gradlew returned an error. Check output above."
) else (
  echo "Tests finished. Open build/reports/tests/test/index.html"
)
