.source                  HOME.java
.class                   public HOME
.super                   java/lang/Object
.field public TESTER Lclasses/standard/Input;
.field public TESTER2 Lclasses/standard/Input;
.method public <init>()V
    .limit stack 32
    .limit locals 3
    aload_0
    invokespecial java/lang/Object/<init>()V
    aload_0
    new classes/standard/Input
    dup
    bipush 32
    ldc "Stue"
    invokespecial classes/standard/Input.<init>(ILjava/lang/String;)V
    putfield HOME/TESTER Lclasses/standard/Input;
    aload_0
    aload_0
    invokevirtual HOME/returnTest2()Lclasses/standard/Input;
    putfield HOME/TESTER2 Lclasses/standard/Input;
return
.end method

.method public Setup()V
    .limit stack 32
    .limit locals 20
.line 5
    bipush 3
    istore 1
.line 6
    ldc2_w 24.3d
    dneg
    dstore 2
.line 7
    iload 1
    sipush 314
    if_icmpeq Label1
    bipush 43
    iload 1
    if_icmpeq Label2
.line 8
    iload 1
    bipush 4
    iadd
    istore 1
    goto Label3
    Label1:
.line 9
    iinc 1 1
    goto Label3
    Label2:
.line 10
    iload 1
    bipush 123
    iadd
    istore 1
    goto Label3
    Label3:
.line 11
    iload 1
    bipush 3
    if_icmpeq Label4
    goto Label5
    Label4:
.line 12
    dload 2
    ldc2_w 3.3d
    dcmpl
    iflt Label6
.line 13
    iinc 1 -1
    goto Label7
    Label6:
.line 14
    dload 2
    dconst_1
    dadd
    dstore 2
    goto Label7
    Label7:
    goto Label5
    Label5:
.line 15
    aload_0
    iload 1
    invokevirtual HOME/PrintI(I)I
    pop
.line 16
    goto Label9
    Label8:
.line 17
    iinc 1 1
    Label9:
    iload 1
    sipush 300
    if_icmplt Label8
.line 22
    Label10:
    iconst_1
    dload 2
    ldc2_w 8.1d
    dcmpl
    ifle Label12
    iconst_1
    goto Label13
    Label12:
    iconst_0
    Label13:
    if_icmpeq Label11
.line 23
    dload 2
    dconst_1
    dadd
    dstore 2
    goto Label10
    Label11:
.line 28
    goto Label15
    Label14:
.line 29
    goto Label17
    Label16:
.line 30
    dload 2
    dconst_1
    dadd
    dstore 2
    Label17:
    iload 1
    bipush 3
    if_icmpgt Label16
    Label15:
    dload 2
    ldc2_w 3.2d
    dcmpl
    iflt Label14
.line 43
    new java/util/HashMap
    dup
    invokespecial java/util/HashMap.<init>()V
    astore 4
    aload 4
    ldc "dic1"
    new java/util/HashMap
    dup
    invokespecial java/util/HashMap.<init>()V
    astore 5
    aload 5
    ldc "one"
    bipush 1
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 5
    ldc "two"
    bipush 2
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 5
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 4
    ldc "dic2"
    new java/util/HashMap
    dup
    invokespecial java/util/HashMap.<init>()V
    astore 6
    aload 6
    ldc "three"
    bipush 3
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 6
    ldc "four"
    bipush 4
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 6
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
.line 44
    aload 4
    ldc "dic1"
    invokevirtual java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast java/util/HashMap
    invokevirtual java/util/HashMap/values()Ljava/util/Collection;
    invokeinterface java/util/Collection/iterator()Ljava/util/Iterator; 1
    astore 7
    Label18:
    aload 7
    invokeinterface java/util/Iterator/hasNext()Z 1
    ifeq Label19
    aload 7
    invokeinterface java/util/Iterator/next()Ljava/lang/Object; 1
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer/intValue()I
    istore 8
.line 45
    aload_0
    iload 8
    invokevirtual HOME/PrintI(I)I
    pop
    goto Label18
    Label19:
.line 50
    bipush 3
    bipush 3
    bipush 3
    imul
    imul
    iload 1
    iadd
    istore 10
.line 51
    iconst_1
    iconst_0
    iconst_1
    istore 12
    ifne Label21
    iload 12
    ifne Label21
    iconst_0
    goto Label20
    Label21:
    iconst_1
    Label20:
    istore 13
    ifeq Label22
    iload 13
    ifeq Label22
    iconst_1
    goto Label23
    Label22:
    iconst_0
    Label23:
    istore 13
.line 52
    bipush 3
    bipush 3
    if_icmple Label24
    iconst_1
    goto Label25
    Label24:
    iconst_0
    Label25:
    iconst_1
    istore 15
    ifeq Label26
    iload 15
    ifeq Label26
    iconst_1
    goto Label27
    Label26:
    iconst_0
    Label27:
    istore 15
.line 53
    iconst_1
    iconst_0
    istore 17
    ifne Label29
    iload 17
    ifne Label29
    iconst_0
    goto Label28
    Label29:
    iconst_1
    Label28:
    istore 17
.line 54
    ldc "asdf"
    astore 18
.line 55
    aload_0
    aload 18
    invokevirtual HOME/PrintS(Ljava/lang/String;)Ljava/lang/String;
    pop
.line 56
    aload_0
    aload_0
    getfield HOME/TESTER Lclasses/standard/Input;
    invokevirtual classes/standard/Input.getPort()I
    invokevirtual HOME/PrintI(I)I
    pop
.line 57
    aload_0
    getfield HOME/TESTER Lclasses/standard/Input;
    bipush 4
    putfield classes/standard/Input/port I
.line 58
    aload_0
    aload_0
    getfield HOME/TESTER Lclasses/standard/Input;
    invokevirtual classes/standard/Input.getPort()I
    invokevirtual HOME/PrintI(I)I
    pop
.line 59
    aload_0
    getfield HOME/TESTER Lclasses/standard/Input;
    sipush 1337
    invokevirtual classes/standard/Input.setPort(I)V
.line 60
    aload_0
    aload_0
    getfield HOME/TESTER Lclasses/standard/Input;
    getfield classes/standard/Input/port I
    invokevirtual HOME/PrintI(I)I
    pop
.line 61
    aload_0
    getfield HOME/TESTER2 Lclasses/standard/Input;
    astore 19
.line 62
    aload_0
    aload 19
    getfield classes/standard/Input/port I
    invokevirtual HOME/PrintI(I)I
    pop
.line 63
    aload_0
    invokevirtual HOME/returnTest2()Lclasses/standard/Input;
    astore 19
.line 64
    aload_0
    aload 19
    getfield classes/standard/Input/port I
    invokevirtual HOME/PrintI(I)I
    pop
.line 65
    aload 19
    sipush 666
    invokevirtual classes/standard/Input.setPort(I)V
.line 66
    aload_0
    aload 19
    invokevirtual classes/standard/Input.getPort()I
    invokevirtual HOME/PrintI(I)I
    pop
.line 67
    aload_0
    invokevirtual HOME/returnForkTest1()I
    pop
.line 68
    aload_0
    invokevirtual HOME/returnForkTest2()I
    pop
.line 69
    aload_0
    invokevirtual HOME/returnForkTest3()I
    pop
.line 70
    aload_0
    invokevirtual HOME/hejz()Ljava/util/ArrayList;
    pop
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

.method public returnTest2()Lclasses/standard/Input;
    .limit stack 11
    .limit locals 2
.line 161
    new classes/standard/Input
    dup
    sipush 333
    ldc "King"
    invokespecial classes/standard/Input.<init>(ILjava/lang/String;)V
    astore 1
.line 162
    aload 1
    areturn
.end method

.method public returnForkTest1()I
    .limit stack 11
    .limit locals 1
.line 168
    bipush 3
    bipush 3
    if_icmpeq Label30
    goto Label31
    Label30:
.line 169
    bipush 5
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 5
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
    Label31:
.line 170
    bipush 3
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 3
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
.end method

.method public hej()Ljava/lang/String;
    .limit stack 11
    .limit locals 2
.line 178
    ldc "HEJ"
    astore 1
.line 179
    aload 1
    dup
    getstatic java/lang/System/out Ljava/io/PrintStream;
    swap
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    areturn
.end method

.method public returnForkTest2()I
    .limit stack 11
    .limit locals 1
.line 185
    bipush 3
    bipush 4
    if_icmpeq Label32
    bipush 5
    bipush 6
    if_icmpeq Label33
.line 186
    bipush 8
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 8
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
    Label32:
.line 187
    bipush 6
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 6
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
    Label33:
.line 188
    bipush 7
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 7
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
.end method

.method public returnForkTest3()I
    .limit stack 11
    .limit locals 1
.line 199
    bipush 1
    bipush 2
    if_icmpeq Label35
    goto Label36
    Label35:
.line 200
    bipush 3
    bipush 4
    if_icmpeq Label37
    goto Label38
    Label37:
.line 201
    bipush 5
    bipush 6
    if_icmpeq Label39
    goto Label40
    Label39:
.line 202
    bipush 7
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 7
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
    Label40:
    goto Label38
    Label38:
    goto Label36
    Label36:
.line 203
    bipush 0
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 0
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
.end method

.method public hejz()Ljava/util/ArrayList;
    .limit stack 11
    .limit locals 3
.line 215
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 1
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 2
    aload 2
    ldc "lol2"
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 1
    aload 2
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
.line 216
    aload 1
    areturn
.end method

.method public not()V
    .limit stack 11
    .limit locals 1
.line 222
    aload_0
    invokevirtual HOME/not2()Ljava/lang/String;
    pop
.line 223
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "Great Success!!"
    invokevirtual java/io/PrintStream.println(Ljava/lang/String;)V
    return
.end method

.method public not2()Ljava/lang/String;
    .limit stack 11
    .limit locals 1
.line 229
    aload_0
    invokevirtual HOME/hej()Ljava/lang/String;
    dup
    getstatic java/lang/System/out Ljava/io/PrintStream;
    swap
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    areturn
.end method

.method public testtt()V
    .limit stack 11
    .limit locals 2
.line 234
    iconst_0
    istore 1
.line 235
    Label41:
    iload 1
    iconst_1
    if_icmpeq Label42
.line 236
    iload 1
    iconst_0
    if_icmpne Label43
    iconst_1
    goto Label44
    Label43:
    iconst_0
    Label44:
    istore 1
    goto Label41
    Label42:
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "Great Success!!"
    invokevirtual java/io/PrintStream.println(Ljava/lang/String;)V
    return
.end method

.method public PrintI(I)I
    .limit stack 11
    .limit locals 2
.line 248
    iload 1
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 1
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
.end method

.method public PrintD(D)D
    .limit stack 11
    .limit locals 3
.line 253
    dload 1
    getstatic java/lang/System/out Ljava/io/PrintStream;
    dload 1
    invokevirtual java/io/PrintStream/println(D)V
    dreturn
.end method

.method public PrintS(Ljava/lang/String;)Ljava/lang/String;
    .limit stack 11
    .limit locals 2
.line 258
    aload 1
    dup
    getstatic java/lang/System/out Ljava/io/PrintStream;
    swap
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    areturn
.end method

