#!/bin/sh
javac JavaTestFileSmall.java
javap -c -v -private JavaTestFileSmall.class
pause
