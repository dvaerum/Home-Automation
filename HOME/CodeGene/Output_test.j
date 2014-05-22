.source                  HOME.java
.class                   public HOME
.super                   java/lang/Object
.field public y Ljava/lang/Double;
.field public z Ljava/lang/Integer;
.method public <init>()V
    .limit stack 4
    .limit locals 4
    aload_0
    invokespecial java/lang/Object/<init>()V
.line 1
    aload_0
    ldc2_w 24.3d
    dneg
    invokestatic java/lang/Double.valueOf(D)Ljava/lang/Double;
    aload_0
    swap
    putfield HOME/y Ljava/lang/Double;
.line 2
    aload_0
    bipush 3
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    aload_0
    swap
    putfield HOME/z Ljava/lang/Integer;
return
.end method

.method public Setup()V
    .limit stack 4
    .limit locals 4
.line 9
    bipush 3
    istore 1
.line 14
    iload 1
    bipush 3
    if_icmpeq Label1
    goto Label2
    Label1:
.line 15
    aload_0
    getfield HOME/y Ljava/lang/Double;
    invokevirtual java/lang/Double.doubleValue()D
    ldc2_w 3.3d
    dcmpl
    iflt Label3
.line 19
    iload 1
    iconst_1
    isub
    istore 1
    goto Label4
    Label3:
.line 16
    aload_0
    getfield HOME/y Ljava/lang/Double;
    invokevirtual java/lang/Double.doubleValue()D
    dconst_1
    dadd
    invokestatic java/lang/Double.valueOf(D)Ljava/lang/Double;
    aload_0
    swap
    putfield HOME/y Ljava/lang/Double;
.line 17
    bipush 5
    istore 2
    goto Label4
    Label4:
    goto Label2
    Label2:
.line 23
    iconst_0
    istore 3
.line 24
    aload_0
    iload 3
    invokevirtual HOME/PrintI(I)I
    pop
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "Great Success!!"
    invokevirtual java/io/PrintStream.println(Ljava/lang/String;)V
    return
.end method

.method public turnOnLamp()V
    .limit stack 2
    .limit locals 3
.line 5
    ldc2_w 4.d
    dstore 1
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "Great Success!!"
    invokevirtual java/io/PrintStream.println(Ljava/lang/String;)V
    return
.end method

.method public static main([Ljava/lang/String;)V
    .limit stack 2
    .limit locals 1
.line 8
    new HOME
    dup
    invokespecial HOME/<init>()V
    invokespecial HOME/Setup()V
    return
.end method

.method public PrintI(I)I
    .limit stack 3
    .limit locals 2
.line 29
    iload 1
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 1
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
.end method

