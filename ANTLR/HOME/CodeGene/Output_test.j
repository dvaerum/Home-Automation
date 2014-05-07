.source                  HOME.java
.class                   public HOME
.super                   java/lang/Object
.method public <init>()V
    .limit stack 32
    .limit locals 1
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
return
.end method

.method public static main([Ljava/lang/String;)V
    .limit stack 32
    .limit locals 7
    ldc2_w 2.d
    dstore 1
    ldc2_w 5.0d
    dstore 3
    dload 1
    dload 3
    dadd
    dneg
    dstore 5
    

    getstatic java/lang/System/out Ljava/io/PrintStream;
    dload 5
    invokevirtual java/io/PrintStream/println(D)V
return 
.end method

