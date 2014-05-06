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
    bipush 9
    bipush 9
    istore 1
    iload_1
    bipush 15
    bipush 19
    iload_1
    bipush 19
    isub
    iadd
    istore 2
return 
.end method

