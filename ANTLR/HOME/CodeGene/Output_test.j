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
    .limit locals 5
    new Input
    dup
    invokespecial Input.<init>()V
    astore 1
    aload 1
    bipush 54
    ineg
    putfield Input/x I
    ldc2_w 324.d
    dstore 2
    dload 2
    aload 4
    getfield Input/x I
    dcmpl
    ifle Label1
    iconst_1
    goto Label2
    Label1:
    iconst_0
    Label2:
    istore 4
    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 4
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

