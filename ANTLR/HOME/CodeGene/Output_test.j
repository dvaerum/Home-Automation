.source                  HOME.java
.class                   public HOME
.super                   java/lang/Object
.method public <init>()V
    .limit stack 32
    .limit locals 1
    aload_0
    invokespecial java/lang/Object/<init>()V
return
.end method

.method public Setup()V
    .limit stack 32
    .limit locals 2
.line 2
    new classes/standard/Input
    dup
    invokespecial classes/standard/Input.<init>()V
    astore 1
.line 3
    aload_0
    bipush 34
    bipush 43
    invokevirtual classes/turnOnLamp(II)V
.line 4
    aload 1
    ldc ONTOGGLED
    ldc turnOnLamp2
    invokevirtual classes/standard/Input/registerEvent(Ljava/lang/String;Ljava/lang/String;)V
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "Great Success!!"
    invokevirtual java/io/PrintStream.println(Ljava/lang/String;)V
    return
.end method

.method public static main([Ljava/lang/String;)V
    .limit stack 32
    .limit locals 1
    new HOME
    dup
    invokespecial HOME/<init>()V
    invokespecial HOME/Setup()V
    return
.end method

.method public turnOnLamp(II)V
    .limit stack 11
    .limit locals 3
.line 13
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "Great Success!!"
    invokevirtual java/io/PrintStream.println(Ljava/lang/String;)V
    return
.end method

.method public turnOnLamp2()V
    .limit stack 11
    .limit locals 1
.line 18
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "Great Success!!"
    invokevirtual java/io/PrintStream.println(Ljava/lang/String;)V
    return
.end method

