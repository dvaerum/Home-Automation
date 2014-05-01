.source                  HOME.java
.class                   public HOME
.super                   java/lang/Object
.method public <init>()V
    .limit stack 32
    .limit locals 0
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
return
.end method

.method public static main([Ljava/lang/String;)V
    .limit stack 32
    .limit locals 1
    ldc 0
    istore 1
    Label1:
    iload 1
    bipush 100
    if_icmplt Label2
    iinc 1 -1
    goto Label1
    Label2:
return
.end method

