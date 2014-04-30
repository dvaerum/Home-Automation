java -jar ByteTest/jasmin.jar Output_test.j
javap -c -verbose -private HOME.class > Output_Result.txt
jar cvf HOME.jar HOME.class
java HOME
pause
exit