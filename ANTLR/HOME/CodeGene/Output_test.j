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
    .limit locals 8
    ldc2_w 2.d
    dstore 2
    ldc2_w 5.0d
    dstore 4
    dload 2
    dload 4
    dadd
    dneg
    dstore 6
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "RETURNING NOTHING"
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
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

