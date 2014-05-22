#!/bin/sh
java -jar ../../jar/jasmin.jar Output_test.j
javap -c -verbose -private HOME.class > Output_Result.txt
java HOME
exit