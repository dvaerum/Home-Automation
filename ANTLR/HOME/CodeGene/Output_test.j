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
    .limit locals 15
    sipush 213
    istore 1
    ldc2_w 24.3d
    dstore 2
    iload 1
    sipush 334
    if_icmpeq Label1
    goto Label2
    Label1:
    goto Label2
    Label2:
    iload 1
    sipush 314
    if_icmpeq Label3
    bipush 43
    iload 1
    if_icmpeq Label4
    iload 1
    bipush 4
    iadd
    istore 1
    goto Label5
    Label3:
    iinc 1 1
    goto Label5
    Label4:
    iload 1
    bipush 123
    iadd
    istore 1
    goto Label5
    Label5:
    iload 1
    bipush 3
    if_icmpeq Label6
    goto Label7
    Label6:
    dload 2
    ldc2_w 3.3d
    dcmpl
    ifeg Label8
    iinc 2 1
    goto Label9
    Label8:
    iinc 2 1
    goto Label9
    Label9:
    goto Label7
    Label7:
    goto Label11
    Label10:
    iinc 1 1
    Label11:
    iload 1
    bipush 3
    if_icmpeq Label10
    Label12:
    iconst_1
    ldc2_w 4.d
    ldc2_w 5.1d
    dcmpl
    ifle Label14
    iconst_1
    goto Label15
    Label14:
    iconst_0
    Label15:
    if_icmpeq Label13
    iinc 1 1
    goto Label12
    Label13:
    goto Label17
    Label16:
    goto Label19
    Label18:
    iinc 2 1
    Label19:
    iload 1
    bipush 3
    if_icmpgt Label18
    Label17:
    dload 2
    ldc2_w 3.2d
    dcmpl
    iflt Label16
    iconst_1
    iconst_0
    iconst_1
    istore 5
    ifne Label21
    iload 5
    ifne Label21
    iconst_0
    goto Label20
    Label21:
    iconst_1
    Label20:
    istore 6
    ifeq Label22
    iload 6
    ifeq Label22
    iconst_1
    goto Label23
    Label22:
    iconst_0
    Label23:
    istore 6
    bipush 3
    bipush 3
    if_icmple Label24
    iconst_1
    goto Label25
    Label24:
    iconst_0
    Label25:
    iconst_1
    istore 8
    ifeq Label26
    iload 8
    ifeq Label26
    iconst_1
    goto Label27
    Label26:
    iconst_0
    Label27:
    istore 8
    iconst_1
    iconst_0
    istore 10
    ifne Label29
    iload 10
    ifne Label29
    iconst_0
    goto Label28
    Label29:
    iconst_1
    Label28:
    istore 10
    ldc "asdf"
    astore 11
    new Input
    dup
    invokespecial Input.<init>()V
    astore 12
    new Input
    dup
    invokespecial Input.<init>()V
    astore 13
    new Input
    dup
    invokespecial Input.<init>()V
    astore 14
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

.method public nothingtest1()V
    .limit stack 11
    .limit locals 1
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "Great Success!!"
    invokevirtual java/io/PrintStream.println(Ljava/lang/String;)V
    return
.end method

.method public nothingtest2(II)V
    .limit stack 11
    .limit locals 3
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "Great Success!!"
    invokevirtual java/io/PrintStream.println(Ljava/lang/String;)V
    return
.end method

.method public nothingtest3(IDLjava/lang/String;Z)V
    .limit stack 11
    .limit locals 6
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "Great Success!!"
    invokevirtual java/io/PrintStream.println(Ljava/lang/String;)V
    return
.end method

.method public nothingtest4(LHOME/Input;)V
    .limit stack 11
    .limit locals 2
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "Great Success!!"
    invokevirtual java/io/PrintStream.println(Ljava/lang/String;)V
    return
.end method

.method public returnTest()I
    .limit stack 11
    .limit locals 1
    bipush 4
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 4
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
.end method

.method public returnTest2()LHOME/Input;
    .limit stack 11
    .limit locals 2
    new Input
    dup
    invokespecial Input.<init>()V
    astore 1
    aload 1
    dup
    getstatic java/lang/System/out Ljava/io/PrintStream;
    swap
    invokevirtual java/io/PrintStream/println(LHOME/Input;)V
    areturn
.end method

.method public returnForkTest2()I
    .limit stack 11
    .limit locals 1
    bipush 3
    bipush 4
    if_icmpeq Label30
    bipush 5
    bipush 6
    if_icmpeq Label31
    bipush 8
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 8
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
    goto Label32
    Label30:
    bipush 6
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 6
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
    goto Label32
    Label31:
    bipush 7
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 7
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
    goto Label32
    Label32:
.end method

