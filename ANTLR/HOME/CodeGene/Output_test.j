.source                  HOME.java
.class                   public HOME
.super                   java/lang/Object
.method public <init>()V
    .limit stack 32
    .limit locals 2
    aload_0
    invokespecial java/lang/Object/<init>()V
return
.end method

.method public Setup()V
    .limit stack 32
    .limit locals 3
    bipush 5
    bipush 6
    iadd
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    astore 2
    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 2
    invokevirtual java/io/PrintStream.println(Ljava/lang/Object;)V
    return
.end method

.method public static main([Ljava/lang/String;)V
    .limit stack 32
    .limit locals 2
    new HOME
    dup
    invokespecial HOME/<init>()V
    invokespecial HOME/Setup()V
    return
.end method

