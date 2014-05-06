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
    .limit locals 3
    ldc 4
    ldc 5
    iadd
    istore 1
    iload 1
    ldc 12
    ldc 3
    iadd
    ldc 4
    iadd
    iload 1
    isub
    iadd
    istore 2

    iload_2
    getstatic java/lang/System/out Ljava/io/PrintStream;
    swap
    invokevirtual java/io/PrintStream/println(I)V

return 
.end method