.source                  HOME.java
.class                   public HOME
.super                   java/lang/Object
.field public TESTER Lclasses/standard/Input;
.field public TESTER2 Lclasses/standard/Input;
.field public abe1 Ljava/util/ArrayList;
.field public abe2 Ljava/util/HashMap;
.field public listBool Ljava/util/ArrayList;
.field public t Ljava/lang/String;
.method public <init>()V
    .limit stack 32
    .limit locals 19
    aload_0
    invokespecial java/lang/Object/<init>()V
    aload_0
    new classes/standard/Input
    dup
    bipush 32
    ldc "Stue"
    invokespecial classes/standard/Input.<init>(ILjava/lang/String;)V
    aload_0
    swap
    putfield HOME/TESTER Lclasses/standard/Input;
    aload_0
    aload_0
    invokevirtual HOME/returnTest2()Lclasses/standard/Input;
    aload_0
    swap
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
    aload_0
    swap
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
    aload_0
    swap
    putfield HOME/abe2 Ljava/util/HashMap;
    aload_0
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 9
    aload 9
    iconst_1
    invokestatic  java/lang/Boolean.valueOf(Z)Ljava/lang/Boolean;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 9
    iconst_0
    invokestatic  java/lang/Boolean.valueOf(Z)Ljava/lang/Boolean;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 9
    iconst_1
    invokestatic  java/lang/Boolean.valueOf(Z)Ljava/lang/Boolean;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 9
    iconst_1
    invokestatic  java/lang/Boolean.valueOf(Z)Ljava/lang/Boolean;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 9
    aload_0
    swap
    putfield HOME/listBool Ljava/util/ArrayList;
    aload_0
    ldc "hej"
    ldc " "
    astore 12
    astore 11
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder.<init>()V
    aload 11
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    aload 12
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder.toString()Ljava/lang/String;
    ldc "med"
    astore 14
    astore 13
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder.<init>()V
    aload 13
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    aload 14
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder.toString()Ljava/lang/String;
    ldc " "
    astore 16
    astore 15
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder.<init>()V
    aload 15
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    aload 16
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder.toString()Ljava/lang/String;
    ldc "dig"
    astore 18
    astore 17
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder.<init>()V
    aload 17
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    aload 18
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder.toString()Ljava/lang/String;
    aload_0
    swap
    putfield HOME/t Ljava/lang/String;
return
.end method

.method public Setup()V
    .limit stack 32
    .limit locals 33
.line 9
    bipush 3
    istore 1
.line 10
    ldc2_w 24.3d
    dneg
    dstore 2
.line 11
    aload_0
    getfield HOME/t Ljava/lang/String;
    ldc " "
    astore 5
    astore 4
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder.<init>()V
    aload 4
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    aload 5
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder.toString()Ljava/lang/String;
    ldc "Master"
    astore 7
    astore 6
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder.<init>()V
    aload 6
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    aload 7
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder.toString()Ljava/lang/String;
    aload_0
    swap
    putfield HOME/t Ljava/lang/String;
.line 12
    aload_0
    aload_0
    getfield HOME/t Ljava/lang/String;
    invokevirtual HOME/PrintS(Ljava/lang/String;)Ljava/lang/String;
    pop
.line 13
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 8
    aload 8
    iconst_1
    invokestatic  java/lang/Boolean.valueOf(Z)Ljava/lang/Boolean;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 8
    iconst_0
    invokestatic  java/lang/Boolean.valueOf(Z)Ljava/lang/Boolean;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 8
    iconst_1
    invokestatic  java/lang/Boolean.valueOf(Z)Ljava/lang/Boolean;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 8
    iconst_1
    invokestatic  java/lang/Boolean.valueOf(Z)Ljava/lang/Boolean;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
.line 14
    aload_0
    getfield HOME/abe1 Ljava/util/ArrayList;
    bipush 1
    invokevirtual java/util/ArrayList.get(I)Ljava/lang/Object;
    checkcast java/util/ArrayList
    bipush 0
    invokevirtual java/util/ArrayList.get(I)Ljava/lang/Object;
    checkcast classes/standard/Input
    astore 9
.line 15
    aload_0
    aload 9
    invokevirtual classes/standard/Input.getPort()I
    invokevirtual HOME/PrintI(I)I
    pop
.line 16
    aload_0
    getfield HOME/abe2 Ljava/util/HashMap;
    ldc "dic1"
    invokevirtual java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast java/util/HashMap
    ldc "dic2"
    invokevirtual java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast classes/standard/Input
    astore 9
.line 17
    aload_0
    aload 9
    invokevirtual classes/standard/Input.getPort()I
    invokevirtual HOME/PrintI(I)I
    pop
.line 18
    iload 1
    sipush 314
    if_icmpeq Label1
    bipush 43
    iload 1
    if_icmpeq Label2
.line 19
    iload 1
    bipush 4
    iadd
    istore 1
    goto Label3
    Label1:
.line 20
    iinc 1 1
    goto Label3
    Label2:
.line 21
    iload 1
    bipush 123
    iadd
    istore 1
    goto Label3
    Label3:
.line 22
    iload 1
    bipush 3
    if_icmpeq Label4
    goto Label5
    Label4:
.line 23
    dload 2
    ldc2_w 3.3d
    dcmpl
    iflt Label6
.line 24
    iinc 1 -1
    goto Label7
    Label6:
.line 25
    dload 2
    dconst_1
    dadd
    dstore 2
    goto Label7
    Label7:
    goto Label5
    Label5:
.line 26
    aload_0
    iload 1
    invokevirtual HOME/PrintI(I)I
    pop
.line 27
    goto Label9
    Label8:
.line 28
    iinc 1 1
    Label9:
    iload 1
    sipush 300
    if_icmplt Label8
.line 33
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
.line 34
    dload 2
    dconst_1
    dadd
    dstore 2
    goto Label10
    Label11:
.line 39
    goto Label15
    Label14:
.line 40
    goto Label17
    Label16:
.line 41
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
.line 54
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 10
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 11
    aload 11
    bipush 11
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 11
    bipush 22
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 11
    bipush 33
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 10
    aload 11
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 12
    aload 12
    bipush 44
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 12
    bipush 55
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 12
    bipush 66
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 10
    aload 12
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 13
    aload 13
    bipush 77
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 13
    bipush 88
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 13
    bipush 99
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 10
    aload 13
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
.line 55
    aload 10
    invokeinterface java/util/List/iterator()Ljava/util/Iterator; 1
    astore 14
    Label18:
    aload 14
    invokeinterface java/util/Iterator/hasNext()Z 1
    ifeq Label19
    aload 14
    invokeinterface java/util/Iterator/next()Ljava/lang/Object; 1
    checkcast java/util/ArrayList
    astore 15
.line 56
    aload 15
    invokeinterface java/util/List/iterator()Ljava/util/Iterator; 1
    astore 16
    Label20:
    aload 16
    invokeinterface java/util/Iterator/hasNext()Z 1
    ifeq Label21
    aload 16
    invokeinterface java/util/Iterator/next()Ljava/lang/Object; 1
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer/intValue()I
    istore 17
.line 57
    aload_0
    iload 17
    invokevirtual HOME/PrintI(I)I
    pop
    goto Label20
    Label21:
    goto Label18
    Label19:
.line 64
    new java/util/HashMap
    dup
    invokespecial java/util/HashMap.<init>()V
    astore 18
    aload 18
    ldc "dic1"
    new java/util/HashMap
    dup
    invokespecial java/util/HashMap.<init>()V
    astore 19
    aload 19
    ldc "one"
    bipush 1
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 19
    ldc "two"
    bipush 2
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 19
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 18
    ldc "dic2"
    new java/util/HashMap
    dup
    invokespecial java/util/HashMap.<init>()V
    astore 20
    aload 20
    ldc "three"
    bipush 3
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 20
    ldc "four"
    bipush 4
    invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 20
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
.line 65
    aload 18
    ldc "dic1"
    invokevirtual java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast java/util/HashMap
    ldc "two"
    aload 18
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
.line 66
    aload 18
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
.line 67
    aload 18
    ldc "dic1"
    invokevirtual java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast java/util/HashMap
    invokevirtual java/util/HashMap/values()Ljava/util/Collection;
    invokeinterface java/util/Collection/iterator()Ljava/util/Iterator; 1
    astore 21
    Label22:
    aload 21
    invokeinterface java/util/Iterator/hasNext()Z 1
    ifeq Label23
    aload 21
    invokeinterface java/util/Iterator/next()Ljava/lang/Object; 1
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer/intValue()I
    istore 22
.line 68
    aload_0
    iload 22
    invokevirtual HOME/PrintI(I)I
    pop
    goto Label22
    Label23:
.line 71
    bipush 3
    bipush 3
    bipush 3
    imul
    imul
    iload 1
    iadd
    istore 23
.line 72
    iconst_1
    iconst_0
    iconst_1
    istore 25
    ifne Label25
    iload 25
    ifne Label25
    iconst_0
    goto Label24
    Label25:
    iconst_1
    Label24:
    istore 26
    ifeq Label26
    iload 26
    ifeq Label26
    iconst_1
    goto Label27
    Label26:
    iconst_0
    Label27:
    istore 24
.line 73
    bipush 3
    bipush 3
    if_icmple Label28
    iconst_1
    goto Label29
    Label28:
    iconst_0
    Label29:
    iconst_1
    istore 28
    ifeq Label30
    iload 28
    ifeq Label30
    iconst_1
    goto Label31
    Label30:
    iconst_0
    Label31:
    istore 27
.line 74
    iconst_1
    iconst_0
    istore 30
    ifne Label33
    iload 30
    ifne Label33
    iconst_0
    goto Label32
    Label33:
    iconst_1
    Label32:
    istore 29
.line 75
    ldc "asdf"
    astore 31
.line 76
    aload_0
    aload 31
    invokevirtual HOME/PrintS(Ljava/lang/String;)Ljava/lang/String;
    pop
.line 77
    aload_0
    aload_0
    getfield HOME/TESTER Lclasses/standard/Input;
    invokevirtual classes/standard/Input.getPort()I
    invokevirtual HOME/PrintI(I)I
    pop
.line 78
    aload_0
    getfield HOME/TESTER Lclasses/standard/Input;
    bipush 4
    putfield classes/standard/Input/port I
.line 79
    aload_0
    aload_0
    getfield HOME/TESTER Lclasses/standard/Input;
    invokevirtual classes/standard/Input.getPort()I
    invokevirtual HOME/PrintI(I)I
    pop
.line 80
    aload_0
    getfield HOME/TESTER Lclasses/standard/Input;
    sipush 1337
    invokevirtual classes/standard/Input.setPort(I)V
.line 81
    aload_0
    aload_0
    getfield HOME/TESTER Lclasses/standard/Input;
    getfield classes/standard/Input/port I
    invokevirtual HOME/PrintI(I)I
    pop
.line 82
    aload_0
    getfield HOME/TESTER2 Lclasses/standard/Input;
    astore 32
.line 83
    aload_0
    aload 32
    getfield classes/standard/Input/port I
    invokevirtual HOME/PrintI(I)I
    pop
.line 84
    aload_0
    invokevirtual HOME/returnTest2()Lclasses/standard/Input;
    astore 32
.line 85
    aload_0
    aload 32
    getfield classes/standard/Input/port I
    invokevirtual HOME/PrintI(I)I
    pop
.line 86
    aload 32
    sipush 666
    invokevirtual classes/standard/Input.setPort(I)V
.line 87
    aload_0
    aload 32
    invokevirtual classes/standard/Input.getPort()I
    invokevirtual HOME/PrintI(I)I
    pop
.line 88
    aload_0
    invokevirtual HOME/returnForkTest1()I
    pop
.line 89
    aload_0
    invokevirtual HOME/returnForkTest2()I
    pop
.line 90
    aload_0
    invokevirtual HOME/returnForkTest3()I
    pop
.line 91
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
.line 207
    new classes/standard/Input
    dup
    sipush 333
    ldc "King"
    invokespecial classes/standard/Input.<init>(ILjava/lang/String;)V
    astore 1
.line 208
    aload 1
    areturn
.end method

.method public returnForkTest1()I
    .limit stack 11
    .limit locals 1
.line 214
    bipush 3
    bipush 3
    if_icmpeq Label34
    goto Label35
    Label34:
.line 215
    bipush 5
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 5
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
    Label35:
.line 216
    bipush 3
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 3
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
.end method

.method public hej()Ljava/lang/String;
    .limit stack 11
    .limit locals 2
.line 224
    ldc "HEJ"
    astore 1
.line 225
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
.line 231
    bipush 3
    bipush 4
    if_icmpeq Label36
    bipush 5
    bipush 6
    if_icmpeq Label37
.line 232
    bipush 8
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 8
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
    Label36:
.line 233
    bipush 6
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 6
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
    Label37:
.line 234
    bipush 7
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 7
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
.end method

.method public returnForkTest3()I
    .limit stack 11
    .limit locals 1
.line 245
    bipush 1
    bipush 2
    if_icmpeq Label39
    goto Label40
    Label39:
.line 246
    bipush 3
    bipush 4
    if_icmpeq Label41
    goto Label42
    Label41:
.line 247
    bipush 5
    bipush 6
    if_icmpeq Label43
    goto Label44
    Label43:
.line 248
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
.line 249
    bipush 0
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 0
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
.end method

.method public hejz()Ljava/util/ArrayList;
    .limit stack 11
    .limit locals 3
.line 261
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
.line 262
    aload 1
    areturn
.end method

.method public not()V
    .limit stack 11
    .limit locals 1
.line 268
    aload_0
    invokevirtual HOME/not2()Ljava/lang/String;
    pop
.line 269
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "Great Success!!"
    invokevirtual java/io/PrintStream.println(Ljava/lang/String;)V
    return
.end method

.method public not2()Ljava/lang/String;
    .limit stack 11
    .limit locals 1
.line 275
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
.line 280
    iconst_0
    istore 1
.line 281
    Label45:
    iload 1
    iconst_1
    if_icmpeq Label46
.line 282
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
.line 294
    iload 1
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 1
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
.end method

.method public PrintD(D)D
    .limit stack 11
    .limit locals 3
.line 299
    dload 1
    getstatic java/lang/System/out Ljava/io/PrintStream;
    dload 1
    invokevirtual java/io/PrintStream/println(D)V
    dreturn
.end method

.method public PrintS(Ljava/lang/String;)Ljava/lang/String;
    .limit stack 11
    .limit locals 2
.line 304
    aload 1
    dup
    getstatic java/lang/System/out Ljava/io/PrintStream;
    swap
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    areturn
.end method

