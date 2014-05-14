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
    .limit locals 1
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

.method public returnForkTest2()I
    .limit stack 11
    .limit locals 1
    .line 7
    bipush 3
    bipush 4
    if_icmpeq Label1
    bipush 5
    bipush 6
    if_icmpeq Label2
    .line 8
    bipush 8
    ireturn
    goto Label3
    Label1:
    .line 9
    bipush 6
    ireturn
    goto Label3
    Label2:
    .line 10
    bipush 7
    ireturn
    goto Label3
    Label3:
.end method

