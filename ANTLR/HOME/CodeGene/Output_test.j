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
    .limit locals 9
    new Input
    dup
    invokespecial Input.<init>()V
    astore 1
    aload 1
    sipush 400
    putfield Input/x I
    ldc2_w 324.d
    dstore 2
    dload 2
    aload 1
    getfield Input/x I
    i2d
    dup2
    dstore 6
    dcmpl
    ifle Label1
    iconst_1
    goto Label2
    Label1:
    iconst_0
    Label2:
    istore 4
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 4
    invokevirtual java/io/PrintStream/println(Z)V
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

