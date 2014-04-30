.source                  HOME.java
.class                   public HOME
.super                   java/lang/Object
.field public s Ljava/lang/String; = "Hej"
.field public a Ljava/lang/Integer; = 70000
.field public b Ljava/lang/Integer; = 30000
.field public c Ljava/lang/Integer; = 500
.field public d Ljava/lang/Integer; = -100
.method public <init>()V
    .limit stack 32
    .limit locals 32
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
    aload_0
    ldc "Hej"
    putfield HOME/s Ljava/lang/String;
    aload_0
    ldc 70000
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    putfield HOME/a Ljava/lang/Integer;
    aload_0
    sipush 30000
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    putfield HOME/b Ljava/lang/Integer;
    aload_0
    sipush 500
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    putfield HOME/c Ljava/lang/Integer;
    aload_0
    bipush -100
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    putfield HOME/d Ljava/lang/Integer;
return
.end method

.method public static main([Ljava/lang/String;)V
    .limit stack 32
    .limit locals 32
    new java/lang/Integer
    dup
    ldc 4
    invokespecial java/lang/Integer/<init>(I)V
return 
.end method

.method public test(Ljava/lang/Integer;)V
    .limit stack 1
    .limit locals 32
return 
.end method

