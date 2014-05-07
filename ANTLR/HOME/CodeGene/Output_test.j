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
    .limit locals 6
    ldc "lol"
    astore 1
    load 1
    ldc "error"
    astore 3
    astore 2
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder.<init>()V
    aload 2
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    aload 3
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder.toString()Ljava/lang/String;
    astore 4
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

