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
    .limit locals 4
    ldc "jeg"
    ldc "jeg"
    invokevirtual java/lang/String.equals(Ljava/lang/Object;)Z
    istore 2
    astore 3
    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 3
    invokevirtual java/util/HashMap.toString()Ljava/lang/String;
    invokevirtual java/io/PrintStream.println(Ljava/lang/String;)V
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

