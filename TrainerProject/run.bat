set projectpath=C:\Users\Vijay\git\Daily-Check-List\TrainerProject
echo %projectpath%
set classpath=%projectpath%\bin;%projectpath%\libs\*
echo %classpath%
java org.testng.TestNG %projectpath%\testng.xml
pause


