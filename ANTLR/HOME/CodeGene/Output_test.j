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
    .limit locals 28
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
    invokeinterface java/util/List/iterator()Ljava/util/Iterator; 1
    astore 9
    Label18:
    aload 9
    invokeinterface java/util/Iterator/hasNext()Z 1
    ifeq Label19
    aload 9
    invokeinterface java/util/Iterator/next()Ljava/lang/Object; 1
    checkcast java/util/ArrayList
    astore 10
.line 51
    aload 10
    invokeinterface java/util/List/iterator()Ljava/util/Iterator; 1
    astore 11
    Label20:
    aload 11
    invokeinterface java/util/Iterator/hasNext()Z 1
    ifeq Label21
    aload 11
    invokeinterface java/util/Iterator/next()Ljava/lang/Object; 1
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer/intValue()I
    istore 12
.line 52
    aload_0
    iload 12
    invokevirtual HOME/PrintI(I)I
    pop
    goto Label20
    Label21:
    goto Label18
    Label19:
.line 59
    new java/util/HashMap
    dup
    invokespecial java/util/HashMap.<init>()V
    astore 13
    aload 13
    ldc "dic1"
    new java/util/HashMap
    dup
    invokespecial java/util/HashMap.<init>()V
    astore 14
    aload 14
    ldc "one"
    bipush 1
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 14
    ldc "two"
    bipush 2
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 14
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 13
    ldc "dic2"
    new java/util/HashMap
    dup
    invokespecial java/util/HashMap.<init>()V
    astore 15
    aload 15
    ldc "three"
    bipush 3
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 15
    ldc "four"
    bipush 4
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 15
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
.line 60
    aload 13
    ldc "dic1"
    invokevirtual java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast java/util/HashMap
    ldc "two"
    aload 13
    ldc "dic1"
    invokevirtual java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast java/util/HashMap
    ldc "two"
    invokevirtual java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer/intValue()I
    sipush 203
    imul
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
.line 61
    aload 13
    ldc "dic1"
    invokevirtual java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast java/util/HashMap
    dup
    ldc "one"
    swap
    ldc "one"
    invokevirtual java/util/HashMap/get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer/intValue()I
    sipush 202
    isub
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
.line 62
    aload 13
    ldc "dic1"
    invokevirtual java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast java/util/HashMap
    invokevirtual java/util/HashMap/values()Ljava/util/Collection;
    invokeinterface java/util/Collection/iterator()Ljava/util/Iterator; 1
    astore 16
    Label22:
    aload 16
    invokeinterface java/util/Iterator/hasNext()Z 1
    ifeq Label23
    aload 16
    invokeinterface java/util/Iterator/next()Ljava/lang/Object; 1
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer/intValue()I
    istore 17
.line 63
    aload_0
    iload 17
    invokevirtual HOME/PrintI(I)I
    pop
    goto Label22
    Label23:
.line 66
    bipush 3
    bipush 3
    bipush 3
    imul
    imul
    iload 1
    iadd
    istore 18
.line 67
    iconst_1
    iconst_0
    iconst_1
    istore 20
    ifne Label25
    iload 20
    ifne Label25
    iconst_0
    goto Label24
    Label25:
    iconst_1
    Label24:
    istore 21
    ifeq Label26
    iload 21
    ifeq Label26
    iconst_1
    goto Label27
    Label26:
    iconst_0
    Label27:
    istore 21
.line 68
    bipush 3
    bipush 3
    if_icmple Label28
    iconst_1
    goto Label29
    Label28:
    iconst_0
    Label29:
    iconst_1
    istore 23
    ifeq Label30
    iload 23
    ifeq Label30
    iconst_1
    goto Label31
    Label30:
    iconst_0
    Label31:
    istore 23
.line 69
    iconst_1
    iconst_0
    istore 25
    ifne Label33
    iload 25
    ifne Label33
    iconst_0
    goto Label32
    Label33:
    iconst_1
    Label32:
    istore 25
.line 70
    ldc "asdf"
    astore 26
.line 71
    aload_0
    aload 26
    invokevirtual HOME/PrintS(Ljava/lang/String;)Ljava/lang/String;
    pop
.line 72
    aload_0
    aload_0
    getfield HOME/TESTER Lclasses/standard/Input;
    invokevirtual classes/standard/Input.getPort()I
    invokevirtual HOME/PrintI(I)I
    pop
.line 73
    aload_0
    getfield HOME/TESTER Lclasses/standard/Input;
    bipush 4
    putfield classes/standard/Input/port I
.line 74
    aload_0
    aload_0
    getfield HOME/TESTER Lclasses/standard/Input;
    invokevirtual classes/standard/Input.getPort()I
    invokevirtual HOME/PrintI(I)I
    pop
.line 75
    aload_0
    getfield HOME/TESTER Lclasses/standard/Input;
    sipush 1337
    invokevirtual classes/standard/Input.setPort(I)V
.line 76
    aload_0
    aload_0
    getfield HOME/TESTER Lclasses/standard/Input;
    getfield classes/standard/Input/port I
    invokevirtual HOME/PrintI(I)I
    pop
.line 77
    aload_0
    getfield HOME/TESTER2 Lclasses/standard/Input;
    astore 27
.line 78
    aload_0
    aload 27
    getfield classes/standard/Input/port I
    invokevirtual HOME/PrintI(I)I
    pop
.line 79
    aload_0
    invokevirtual HOME/returnTest2()Lclasses/standard/Input;
    astore 27
.line 80
    aload_0
    aload 27
    getfield classes/standard/Input/port I
    invokevirtual HOME/PrintI(I)I
    pop
.line 81
    aload 27
    sipush 666
    invokevirtual classes/standard/Input.setPort(I)V
.line 82
    aload_0
    aload 27
    invokevirtual classes/standard/Input.getPort()I
    invokevirtual HOME/PrintI(I)I
    pop
.line 83
    aload_0
    invokevirtual HOME/returnForkTest1()I
    pop
.line 84
    aload_0
    invokevirtual HOME/returnForkTest2()I
    pop
.line 85
    aload_0
    invokevirtual HOME/returnForkTest3()I
    pop
.line 86
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
.line 197
    new classes/standard/Input
    dup
    sipush 333
    ldc "King"
    invokespecial classes/standard/Input.<init>(ILjava/lang/String;)V
    astore 1
.line 198
    aload 1
    areturn
.end method

.method public returnForkTest1()I
    .limit stack 11
    .limit locals 1
.line 204
    bipush 3
    bipush 3
    if_icmpeq Label34
    goto Label35
    Label34:
.line 205
    bipush 5
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 5
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
    Label35:
.line 206
    bipush 3
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 3
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
.end method

.method public hej()Ljava/lang/String;
    .limit stack 11
    .limit locals 2
.line 214
    ldc "HEJ"
    astore 1
.line 215
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
.line 221
    bipush 3
    bipush 4
    if_icmpeq Label36
    bipush 5
    bipush 6
    if_icmpeq Label37
.line 222
    bipush 8
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 8
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
    Label36:
.line 223
    bipush 6
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 6
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
    Label37:
.line 224
    bipush 7
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 7
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
.end method

.method public returnForkTest3()I
    .limit stack 11
    .limit locals 1
.line 235
    bipush 1
    bipush 2
    if_icmpeq Label39
    goto Label40
    Label39:
.line 236
    bipush 3
    bipush 4
    if_icmpeq Label41
    goto Label42
    Label41:
.line 237
    bipush 5
    bipush 6
    if_icmpeq Label43
    goto Label44
    Label43:
.line 238
    bipush 7
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 7
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
    Label44:
    goto Label42
    Label42:
    goto Label40
    Label40:
.line 239
    bipush 0
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 0
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
.end method

.method public hejz()Ljava/util/ArrayList;
    .limit stack 11
    .limit locals 3
.line 251
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
.line 252
    aload 1
    areturn
.end method

.method public not()V
    .limit stack 11
    .limit locals 1
.line 258
    aload_0
    invokevirtual HOME/not2()Ljava/lang/String;
    pop
.line 259
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "Great Success!!"
    invokevirtual java/io/PrintStream.println(Ljava/lang/String;)V
    return
.end method

.method public not2()Ljava/lang/String;
    .limit stack 11
    .limit locals 1
.line 265
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
.line 270
    iconst_0
    istore 1
.line 271
    Label45:
    iload 1
    iconst_1
    if_icmpeq Label46
.line 272
    iload 1
    iconst_0
    if_icmpne Label47
    iconst_1
    goto Label48
    Label47:
    iconst_0
    Label48:
    istore 1
    goto Label45
    Label46:
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "Great Success!!"
    invokevirtual java/io/PrintStream.println(Ljava/lang/String;)V
    return
.end method

.method public PrintI(I)I
    .limit stack 11
    .limit locals 2
.line 284
    iload 1
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 1
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
.end method

.method public PrintD(D)D
    .limit stack 11
    .limit locals 3
.line 289
    dload 1
    getstatic java/lang/System/out Ljava/io/PrintStream;
    dload 1
    invokevirtual java/io/PrintStream/println(D)V
    dreturn
.end method

.method public PrintS(Ljava/lang/String;)Ljava/lang/String;
    .limit stack 11
    .limit locals 2
.line 294
    aload 1
    dup
    getstatic java/lang/System/out Ljava/io/PrintStream;
    swap
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    areturn
.end method

