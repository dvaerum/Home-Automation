#!/bin/sh
java -jar ../../jar/jasmin.jar Output_test.j
javap -c -verbose -private HOME.class > Output_Result.txt
cp HOME.class ../../../../P4\ -\ Datalogi/Simulator/HOME.class
cd ../../../../P4\ -\ Datalogi/Simulator
./run.sh


exit
