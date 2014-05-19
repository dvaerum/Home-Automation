.source                  HOME.java
.class                   public HOME
.super                   java/lang/Object
.field public TESTER Lclasses/standard/Input;
.field public TESTER2 Lclasses/standard/Input;
.field public abe1 Ljava/util/ArrayList;
.field public abe2 Ljava/util/HashMap;
.method public <init>()V
    .limit stack 32
    .limit locals 9
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
    aload_0
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 3
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 4
    aload 4
    aload_0
    getfield HOME/TESTER Lclasses/standard/Input;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 4
    aload_0
    getfield HOME/TESTER2 Lclasses/standard/Input;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 3
    aload 4
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 5
    aload 5
    aload_0
    getfield HOME/TESTER Lclasses/standard/Input;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 5
    aload_0
    getfield HOME/TESTER2 Lclasses/standard/Input;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 3
    aload 5
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 3
    putfield HOME/abe1 Ljava/util/ArrayList;
    aload_0
    new java/util/HashMap
    dup
    invokespecial java/util/HashMap.<init>()V
    astore 6
    aload 6
    ldc "dic1"
    new java/util/HashMap
    dup
    invokespecial java/util/HashMap.<init>()V
    astore 7
    aload 7
    ldc "dic1"
    aload_0
    getfield HOME/TESTER Lclasses/standard/Input;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 7
    ldc "dic2"
    aload_0
    getfield HOME/TESTER2 Lclasses/standard/Input;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 7
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 6
    ldc "dic1"
    new java/util/HashMap
    dup
    invokespecial java/util/HashMap.<init>()V
    astore 8
    aload 8
    ldc "dic1"
    aload_0
    getfield HOME/TESTER Lclasses/standard/Input;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 8
    ldc "dic2"
    aload_0
    getfield HOME/TESTER2 Lclasses/standard/Input;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 8
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 6
    putfield HOME/abe2 Ljava/util/HashMap;
return
.end method

.method public Setup()V
    .limit stack 32
    .limit locals 22
.line 7
    bipush 3
    istore 1
.line 8
    ldc2_w 24.3d
    dneg
    dstore 2
.line 9
    aload_0
    getfield HOME/abe1 Ljava/util/ArrayList;
    bipush 1
    invokevirtual java/util/ArrayList.get(I)Ljava/lang/Object;
    checkcast java/util/ArrayList
    bipush 0
    invokevirtual java/util/ArrayList.get(I)Ljava/lang/Object;
    checkcast classes/standard/Input
    astore 4
.line 10
    aload_0
    aload 4
    invokevirtual classes/standard/Input.getPort()I
    invokevirtual HOME/PrintI(I)I
    pop
.line 11
    aload_0
    getfield HOME/abe2 Ljava/util/HashMap;
    ldc "dic1"
    invokevirtual java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast java/util/HashMap
    ldc "dic2"
    invokevirtual java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast classes/standard/Input
    astore 4
.line 12
    aload_0
    aload 4
    invokevirtual classes/standard/Input.getPort()I
    invokevirtual HOME/PrintI(I)I
    pop
.line 13
    iload 1
    sipush 314
    if_icmpeq Label1
    bipush 43
    iload 1
    if_icmpeq Label2
.line 14
    iload 1
    bipush 4
    iadd
    istore 1
    goto Label3
    Label1:
.line 15
    iinc 1 1
    goto Label3
    Label2:
.line 16
    iload 1
    bipush 123
    iadd
    istore 1
    goto Label3
    Label3:
.line 17
    iload 1
    bipush 3
    if_icmpeq Label4
    goto Label5
    Label4:
.line 18
    dload 2
    ldc2_w 3.3d
    dcmpl
    iflt Label6
.line 19
    iinc 1 -1
    goto Label7
    Label6:
.line 20
    dload 2
    dconst_1
    dadd
    dstore 2
    goto Label7
    Label7:
    goto Label5
    Label5:
.line 21
    aload_0
    iload 1
    invokevirtual HOME/PrintI(I)I
    pop
.line 22
    goto Label9
    Label8:
.line 23
    iinc 1 1
    Label9:
    iload 1
    sipush 300
    if_icmplt Label8
.line 28
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
.line 29
    dload 2
    dconst_1
    dadd
    dstore 2
    goto Label10
    Label11:
.line 34
    goto Label15
    Label14:
.line 35
    goto Label17
    Label16:
.line 36
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
.line 49
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 5
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 6
    aload 6
    bipush 11
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 6
    bipush 22
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 6
    bipush 33
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 5
    aload 6
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 7
    aload 7
    bipush 44
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 7
    bipush 55
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 7
    bipush 66
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 5
    aload 7
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 8
    aload 8
    bipush 77
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 8
    bipush 88
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 8
    bipush 99
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 5
    aload 8
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
.line 50
    aload 5
.line 55
    new java/util/HashMap
    dup
    invokespecial java/util/HashMap.<init>()V
    astore 9
    aload 9
    ldc "dic1"
    new java/util/HashMap
    dup
    invokespecial java/util/HashMap.<init>()V
    astore 10
    aload 10
    ldc "one"
    bipush 1
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 10
    ldc "two"
    bipush 2
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 10
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 9
    ldc "dic2"
    new java/util/HashMap
    dup
    invokespecial java/util/HashMap.<init>()V
    astore 11
    aload 11
    ldc "three"
    bipush 3
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 11
    ldc "four"
    bipush 4
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 11
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
.line 56
    aload 9
    ldc "dic1"
    invokevirtual java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast java/util/HashMap
.line 59
    bipush 3
    bipush 3
    bipush 3
    imul
    imul
    iload 1
    iadd
    istore 12
.line 60
    iconst_1
    iconst_0
    iconst_1
    istore 14
    ifne Label19
    iload 14
    ifne Label19
    iconst_0
    goto Label18
    Label19:
    iconst_1
    Label18:
    istore 15
    ifeq Label20
    iload 15
    ifeq Label20
    iconst_1
    goto Label21
    Label20:
    iconst_0
    Label21:
    istore 15
.line 61
    bipush 3
    bipush 3
    if_icmple Label22
    iconst_1
    goto Label23
    Label22:
    iconst_0
    Label23:
    iconst_1
    istore 17
    ifeq Label24
    iload 17
    ifeq Label24
    iconst_1
    goto Label25
    Label24:
    iconst_0
    Label25:
    istore 17
.line 62
    iconst_1
    iconst_0
    istore 19
    ifne Label27
    iload 19
    ifne Label27
    iconst_0
    goto Label26
    Label27:
    iconst_1
    Label26:
    istore 19
.line 63
    ldc "asdf"
    astore 20
.line 64
    aload_0
    aload 20
    invokevirtual HOME/PrintS(Ljava/lang/String;)Ljava/lang/String;
    pop
.line 65
    aload_0
    aload_0
    getfield HOME/TESTER Lclasses/standard/Input;
    invokevirtual classes/standard/Input.getPort()I
    invokevirtual HOME/PrintI(I)I
    pop
.line 66
    aload_0
    getfield HOME/TESTER Lclasses/standard/Input;
    bipush 4
    putfield classes/standard/Input/port I
.line 67
    aload_0
    aload_0
    getfield HOME/TESTER Lclasses/standard/Input;
    invokevirtual classes/standard/Input.getPort()I
    invokevirtual HOME/PrintI(I)I
    pop
.line 68
    aload_0
    getfield HOME/TESTER Lclasses/standard/Input;
    sipush 1337
    invokevirtual classes/standard/Input.setPort(I)V
.line 69
    aload_0
    aload_0
    getfield HOME/TESTER Lclasses/standard/Input;
    getfield classes/standard/Input/port I
    invokevirtual HOME/PrintI(I)I
    pop
.line 70
    aload_0
    getfield HOME/TESTER2 Lclasses/standard/Input;
    astore 21
.line 71
    aload_0
    aload 21
    getfield classes/standard/Input/port I
    invokevirtual HOME/PrintI(I)I
    pop
.line 72
    aload_0
    invokevirtual HOME/returnTest2()Lclasses/standard/Input;
    astore 21
.line 73
    aload_0
    aload 21
    getfield classes/standard/Input/port I
    invokevirtual HOME/PrintI(I)I
    pop
.line 74
    aload 21
    sipush 666
    invokevirtual classes/standard/Input.setPort(I)V
.line 75
    aload_0
    aload 21
    invokevirtual classes/standard/Input.getPort()I
    invokevirtual HOME/PrintI(I)I
    pop
.line 76
    aload_0
    invokevirtual HOME/returnForkTest1()I
    pop
.line 77
    aload_0
    invokevirtual HOME/returnForkTest2()I
    pop
.line 78
    aload_0
    invokevirtual HOME/returnForkTest3()I
    pop
.line 79
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
.line 189
    new classes/standard/Input
    dup
    sipush 333
    ldc "King"
    invokespecial classes/standard/Input.<init>(ILjava/lang/String;)V
    astore 1
.line 190
    aload 1
    areturn
.end method

.method public returnForkTest1()I
    .limit stack 11
    .limit locals 1
.line 196
    bipush 3
    bipush 3
    if_icmpeq Label28
    goto Label29
    Label28:
.line 197
    bipush 5
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 5
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
    Label29:
.line 198
    bipush 3
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 3
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
.end method

.method public hej()Ljava/lang/String;
    .limit stack 11
    .limit locals 2
.line 206
    ldc "HEJ"
    astore 1
.line 207
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
.line 213
    bipush 3
    bipush 4
    if_icmpeq Label30
    bipush 5
    bipush 6
    if_icmpeq Label31
.line 214
    bipush 8
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 8
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
    Label30:
.line 215
    bipush 6
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 6
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
    Label31:
.line 216
    bipush 7
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 7
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
.end method

.method public returnForkTest3()I
    .limit stack 11
    .limit locals 1
.line 227
    bipush 1
    bipush 2
    if_icmpeq Label33
    goto Label34
    Label33:
.line 228
    bipush 3
    bipush 4
    if_icmpeq Label35
    goto Label36
    Label35:
.line 229
    bipush 5
    bipush 6
    if_icmpeq Label37
    goto Label38
    Label37:
.line 230
    bipush 7
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 7
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
    Label38:
    goto Label36
    Label36:
    goto Label34
    Label34:
.line 231
    bipush 0
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 0
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
.end method

.method public hejz()Ljava/util/ArrayList;
    .limit stack 11
    .limit locals 3
.line 243
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
.line 244
    aload 1
    areturn
.end method

.method public not()V
    .limit stack 11
    .limit locals 1
.line 250
    aload_0
    invokevirtual HOME/not2()Ljava/lang/String;
    pop
.line 251
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "Great Success!!"
    invokevirtual java/io/PrintStream.println(Ljava/lang/String;)V
    return
.end method

.method public not2()Ljava/lang/String;
    .limit stack 11
    .limit locals 1
.line 257
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
.line 262
    iconst_0
    istore 1
.line 263
    Label39:
    iload 1
    iconst_1
    if_icmpeq Label40
.line 264
    iload 1
    iconst_0
    if_icmpne Label41
    iconst_1
    goto Label42
    Label41:
    iconst_0
    Label42:
    istore 1
    goto Label39
    Label40:
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "Great Success!!"
    invokevirtual java/io/PrintStream.println(Ljava/lang/String;)V
    return
.end method

.method public PrintI(I)I
    .limit stack 11
    .limit locals 2
.line 276
    iload 1
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 1
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
.end method

.method public PrintD(D)D
    .limit stack 11
    .limit locals 3
.line 281
    dload 1
    getstatic java/lang/System/out Ljava/io/PrintStream;
    dload 1
    invokevirtual java/io/PrintStream/println(D)V
    dreturn
.end method

.method public PrintS(Ljava/lang/String;)Ljava/lang/String;
    .limit stack 11
    .limit locals 2
.line 286
    aload 1
    dup
    getstatic java/lang/System/out Ljava/io/PrintStream;
    swap
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    areturn
.end method

