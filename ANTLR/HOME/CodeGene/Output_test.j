.source                  HOME.java
.class                   public HOME
.super                   java/lang/Object
.field public TESTER Lclasses/standard/Input;
.field public TESTER2 Lclasses/standard/Input;
.field public abe1 Ljava/util/ArrayList;
.field public abe2 Ljava/util/HashMap;
.field public listBool Ljava/util/ArrayList;
.field public t Ljava/lang/String;
.field public y Ljava/lang/Double;
.field public z Ljava/lang/Integer;
.method public <init>()V
    .limit stack 62
    .limit locals 22
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
    invokestatic java/lang/Boolean.valueOf(Z)Ljava/lang/Boolean;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 9
    iconst_0
    invokestatic java/lang/Boolean.valueOf(Z)Ljava/lang/Boolean;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 9
    iconst_1
    invokestatic java/lang/Boolean.valueOf(Z)Ljava/lang/Boolean;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 9
    iconst_1
    invokestatic java/lang/Boolean.valueOf(Z)Ljava/lang/Boolean;
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
    aload_0
    ldc2_w 24.3d
    dneg
    invokestatic java/lang/Double.valueOf(D)Ljava/lang/Double;
    aload_0
    swap
    putfield HOME/y Ljava/lang/Double;
    aload_0
    bipush 3
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    aload_0
    swap
    putfield HOME/z Ljava/lang/Integer;
return
.end method

.method public Setup()V
    .limit stack 108
    .limit locals 30
.line 12
    aload_0
    getfield HOME/y Ljava/lang/Double;
    invokevirtual java/lang/Double.doubleValue()D
    dconst_1
    dadd
    invokestatic java/lang/Double.valueOf(D)Ljava/lang/Double;
    aload_0
    swap
    putfield HOME/y Ljava/lang/Double;
.line 13
    aload_0
    getfield HOME/z Ljava/lang/Integer;
    invokevirtual java/lang/Integer.intValue()I
    iconst_1
    iadd
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    aload_0
    swap
    putfield HOME/z Ljava/lang/Integer;
.line 14
    aload_0
    aload_0
    getfield HOME/y Ljava/lang/Double;
    invokevirtual java/lang/Double.doubleValue()D
    invokevirtual HOME/PrintD(D)D
    pop2
.line 15
    aload_0
    aload_0
    getfield HOME/z Ljava/lang/Integer;
    invokevirtual java/lang/Integer.intValue()I
    invokevirtual HOME/PrintI(I)I
    pop
.line 16
    aload_0
    getfield HOME/y Ljava/lang/Double;
    invokevirtual java/lang/Double.doubleValue()D
    dconst_1
    dsub
    invokestatic java/lang/Double.valueOf(D)Ljava/lang/Double;
    aload_0
    swap
    putfield HOME/y Ljava/lang/Double;
.line 17
    aload_0
    getfield HOME/z Ljava/lang/Integer;
    invokevirtual java/lang/Integer.intValue()I
    iconst_1
    isub
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    aload_0
    swap
    putfield HOME/z Ljava/lang/Integer;
.line 18
    aload_0
    aload_0
    getfield HOME/y Ljava/lang/Double;
    invokevirtual java/lang/Double.doubleValue()D
    invokevirtual HOME/PrintD(D)D
    pop2
.line 19
    aload_0
    aload_0
    getfield HOME/z Ljava/lang/Integer;
    invokevirtual java/lang/Integer.intValue()I
    invokevirtual HOME/PrintI(I)I
    pop
.line 20
    bipush 3
    istore 1
.line 21
    aload_0
    getfield HOME/t Ljava/lang/String;
    ldc " "
    astore 3
    astore 2
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder.<init>()V
    aload 2
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    aload 3
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder.toString()Ljava/lang/String;
    ldc "Master"
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
    aload_0
    swap
    putfield HOME/t Ljava/lang/String;
.line 22
    aload_0
    aload_0
    getfield HOME/t Ljava/lang/String;
    invokevirtual HOME/PrintS(Ljava/lang/String;)Ljava/lang/String;
    pop
.line 23
    aload_0
    getfield HOME/abe1 Ljava/util/ArrayList;
    bipush 1
    invokevirtual java/util/ArrayList.get(I)Ljava/lang/Object;
    checkcast java/util/ArrayList
    bipush 0
    invokevirtual java/util/ArrayList.get(I)Ljava/lang/Object;
    checkcast classes/standard/Input
    astore 6
.line 24
    aload_0
    aload 6
    invokevirtual classes/standard/Input.getPort()I
    invokevirtual HOME/PrintI(I)I
    pop
.line 25
    aload_0
    getfield HOME/abe2 Ljava/util/HashMap;
    ldc "dic1"
    invokevirtual java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast java/util/HashMap
    ldc "dic2"
    invokevirtual java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast classes/standard/Input
    astore 6
.line 26
    aload_0
    aload 6
    invokevirtual classes/standard/Input.getPort()I
    invokevirtual HOME/PrintI(I)I
    pop
.line 27
    iload 1
    sipush 314
    if_icmpeq Label1
    bipush 43
    iload 1
    if_icmpeq Label2
.line 28
    iload 1
    bipush 4
    iadd
    istore 1
    goto Label3
    Label1:
.line 29
    iload 1
    iconst_1
    iadd
    istore 1
    goto Label3
    Label2:
.line 30
    iload 1
    bipush 123
    iadd
    istore 1
    goto Label3
    Label3:
.line 31
    iload 1
    bipush 3
    if_icmpeq Label4
    goto Label5
    Label4:
.line 32
    aload_0
    getfield HOME/y Ljava/lang/Double;
    invokevirtual java/lang/Double.doubleValue()D
    ldc2_w 3.3d
    dcmpl
    iflt Label6
.line 33
    iload 1
    iconst_1
    isub
    istore 1
    goto Label7
    Label6:
.line 34
    aload_0
    getfield HOME/y Ljava/lang/Double;
    invokevirtual java/lang/Double.doubleValue()D
    dconst_1
    dadd
    invokestatic java/lang/Double.valueOf(D)Ljava/lang/Double;
    aload_0
    swap
    putfield HOME/y Ljava/lang/Double;
    goto Label7
    Label7:
    goto Label5
    Label5:
.line 35
    aload_0
    iload 1
    invokevirtual HOME/PrintI(I)I
    pop
.line 36
    goto Label9
    Label8:
.line 37
    iload 1
    iconst_1
    iadd
    istore 1
    Label9:
    iload 1
    sipush 300
    if_icmplt Label8
.line 42
    Label10:
    iconst_1
    aload_0
    getfield HOME/y Ljava/lang/Double;
    invokevirtual java/lang/Double.doubleValue()D
    ldc2_w 8.1d
    dcmpl
    ifle Label12
    iconst_1
    goto Label13
    Label12:
    iconst_0
    Label13:
    if_icmpeq Label11
.line 43
    aload_0
    getfield HOME/y Ljava/lang/Double;
    invokevirtual java/lang/Double.doubleValue()D
    dconst_1
    dadd
    invokestatic java/lang/Double.valueOf(D)Ljava/lang/Double;
    aload_0
    swap
    putfield HOME/y Ljava/lang/Double;
    goto Label10
    Label11:
.line 48
    goto Label15
    Label14:
.line 49
    goto Label17
    Label16:
.line 50
    aload_0
    getfield HOME/y Ljava/lang/Double;
    invokevirtual java/lang/Double.doubleValue()D
    dconst_1
    dadd
    invokestatic java/lang/Double.valueOf(D)Ljava/lang/Double;
    aload_0
    swap
    putfield HOME/y Ljava/lang/Double;
    Label17:
    iload 1
    bipush 3
    if_icmpgt Label16
    Label15:
    aload_0
    getfield HOME/y Ljava/lang/Double;
    invokevirtual java/lang/Double.doubleValue()D
    ldc2_w 3.2d
    dcmpl
    iflt Label14
.line 63
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 7
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 8
    aload 8
    bipush 11
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 8
    bipush 22
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 8
    bipush 33
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 7
    aload 8
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 9
    aload 9
    bipush 44
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 9
    bipush 55
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 9
    bipush 66
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 7
    aload 9
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 10
    aload 10
    bipush 77
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 10
    bipush 88
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 10
    bipush 99
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 7
    aload 10
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
.line 64
    aload 7
    invokeinterface java/util/List/iterator()Ljava/util/Iterator; 1
    astore 11
    Label18:
    aload 11
    invokeinterface java/util/Iterator/hasNext()Z 1
    ifeq Label19
    aload 11
    invokeinterface java/util/Iterator/next()Ljava/lang/Object; 1
    checkcast java/util/ArrayList
    astore 12
.line 65
    aload 12
    invokeinterface java/util/List/iterator()Ljava/util/Iterator; 1
    astore 13
    Label20:
    aload 13
    invokeinterface java/util/Iterator/hasNext()Z 1
    ifeq Label21
    aload 13
    invokeinterface java/util/Iterator/next()Ljava/lang/Object; 1
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer/intValue()I
    istore 14
.line 66
    aload_0
    iload 14
    invokevirtual HOME/PrintI(I)I
    pop
    goto Label20
    Label21:
    goto Label18
    Label19:
.line 73
    new java/util/HashMap
    dup
    invokespecial java/util/HashMap.<init>()V
    astore 15
    aload 15
    ldc "dic1"
    new java/util/HashMap
    dup
    invokespecial java/util/HashMap.<init>()V
    astore 16
    aload 16
    ldc "one"
    bipush 1
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 16
    ldc "two"
    bipush 2
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 16
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 15
    ldc "dic2"
    new java/util/HashMap
    dup
    invokespecial java/util/HashMap.<init>()V
    astore 17
    aload 17
    ldc "three"
    bipush 3
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 17
    ldc "four"
    bipush 4
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 17
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
.line 74
    aload 15
    ldc "dic1"
    invokevirtual java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast java/util/HashMap
    ldc "two"
    aload 15
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
.line 75
    aload 15
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
.line 76
    aload 15
    ldc "dic1"
    invokevirtual java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast java/util/HashMap
    invokevirtual java/util/HashMap/values()Ljava/util/Collection;
    invokeinterface java/util/Collection/iterator()Ljava/util/Iterator; 1
    astore 18
    Label22:
    aload 18
    invokeinterface java/util/Iterator/hasNext()Z 1
    ifeq Label23
    aload 18
    invokeinterface java/util/Iterator/next()Ljava/lang/Object; 1
    checkcast java/lang/Integer
    invokevirtual java/lang/Integer/intValue()I
    istore 19
.line 77
    aload_0
    iload 19
    invokevirtual HOME/PrintI(I)I
    pop
    goto Label22
    Label23:
.line 80
    bipush 3
    bipush 3
    bipush 3
    imul
    imul
    iload 1
    iadd
    istore 20
.line 81
    iconst_1
    iconst_0
    iconst_1
    istore 22
    ifne Label25
    iload 22
    ifne Label25
    iconst_0
    goto Label24
    Label25:
    iconst_1
    Label24:
    istore 23
    ifeq Label26
    iload 23
    ifeq Label26
    iconst_1
    goto Label27
    Label26:
    iconst_0
    Label27:
    istore 21
.line 82
    bipush 3
    bipush 3
    if_icmple Label28
    iconst_1
    goto Label29
    Label28:
    iconst_0
    Label29:
    iconst_1
    istore 25
    ifeq Label30
    iload 25
    ifeq Label30
    iconst_1
    goto Label31
    Label30:
    iconst_0
    Label31:
    istore 24
.line 83
    iconst_1
    iconst_0
    istore 27
    ifne Label33
    iload 27
    ifne Label33
    iconst_0
    goto Label32
    Label33:
    iconst_1
    Label32:
    istore 26
.line 84
    ldc "asdf"
    astore 28
.line 85
    aload_0
    aload 28
    invokevirtual HOME/PrintS(Ljava/lang/String;)Ljava/lang/String;
    pop
.line 86
    aload_0
    aload_0
    getfield HOME/TESTER Lclasses/standard/Input;
    invokevirtual classes/standard/Input.getPort()I
    invokevirtual HOME/PrintI(I)I
    pop
.line 87
    aload_0
    getfield HOME/TESTER Lclasses/standard/Input;
    bipush 4
    putfield classes/standard/Input/port I
.line 88
    aload_0
    aload_0
    getfield HOME/TESTER Lclasses/standard/Input;
    invokevirtual classes/standard/Input.getPort()I
    invokevirtual HOME/PrintI(I)I
    pop
.line 89
    aload_0
    getfield HOME/TESTER Lclasses/standard/Input;
    sipush 1337
    invokevirtual classes/standard/Input.setPort(I)V
.line 90
    aload_0
    aload_0
    getfield HOME/TESTER Lclasses/standard/Input;
    getfield classes/standard/Input/port I
    invokevirtual HOME/PrintI(I)I
    pop
.line 91
    aload_0
    getfield HOME/TESTER2 Lclasses/standard/Input;
    astore 29
.line 92
    aload_0
    aload 29
    getfield classes/standard/Input/port I
    invokevirtual HOME/PrintI(I)I
    pop
.line 93
    aload_0
    invokevirtual HOME/returnTest2()Lclasses/standard/Input;
    astore 29
.line 94
    aload_0
    aload 29
    getfield classes/standard/Input/port I
    invokevirtual HOME/PrintI(I)I
    pop
.line 95
    aload 29
    sipush 666
    invokevirtual classes/standard/Input.setPort(I)V
.line 96
    aload_0
    aload 29
    invokevirtual classes/standard/Input.getPort()I
    invokevirtual HOME/PrintI(I)I
    pop
.line 97
    aload_0
    invokevirtual HOME/returnForkTest1()I
    pop
.line 98
    aload_0
    invokevirtual HOME/returnForkTest2()I
    pop
.line 99
    aload_0
    invokevirtual HOME/returnForkTest3()I
    pop
.line 100
    aload_0
    invokevirtual HOME/hejz()Ljava/util/ArrayList;
    pop
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "Great Success!!"
    invokevirtual java/io/PrintStream.println(Ljava/lang/String;)V
    return
.end method

.method public static main([Ljava/lang/String;)V
    .limit stack 34
    .limit locals 1
    new HOME
    dup
    invokespecial HOME/<init>()V
    invokespecial HOME/Setup()V
    return
.end method

.method public returnTest2()Lclasses/standard/Input;
    .limit stack 12
    .limit locals 2
.line 221
    new classes/standard/Input
    dup
    sipush 333
    ldc "King"
    invokespecial classes/standard/Input.<init>(ILjava/lang/String;)V
    astore 1
.line 222
    aload 1
    areturn
.end method

.method public returnForkTest1()I
    .limit stack 13
    .limit locals 1
.line 228
    bipush 3
    bipush 3
    if_icmpeq Label34
    goto Label35
    Label34:
.line 229
    bipush 5
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 5
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
    Label35:
.line 230
    bipush 3
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 3
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
.end method

.method public hej()Ljava/lang/String;
    .limit stack 12
    .limit locals 2
.line 238
    ldc "HEJ"
    astore 1
.line 239
    aload 1
    dup
    getstatic java/lang/System/out Ljava/io/PrintStream;
    swap
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    areturn
.end method

.method public returnForkTest2()I
    .limit stack 14
    .limit locals 1
.line 245
    bipush 3
    bipush 4
    if_icmpeq Label36
    bipush 5
    bipush 6
    if_icmpeq Label37
.line 246
    bipush 8
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 8
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
    Label36:
.line 247
    bipush 6
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 6
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
    Label37:
.line 248
    bipush 7
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 7
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
.end method

.method public returnForkTest3()I
    .limit stack 13
    .limit locals 1
.line 259
    bipush 1
    bipush 2
    if_icmpeq Label39
    goto Label40
    Label39:
.line 260
    bipush 3
    bipush 4
    if_icmpeq Label41
    goto Label42
    Label41:
.line 261
    bipush 5
    bipush 6
    if_icmpeq Label43
    goto Label44
    Label43:
.line 262
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
.line 263
    bipush 0
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 0
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
.end method

.method public hejz()Ljava/util/ArrayList;
    .limit stack 11
    .limit locals 3
.line 275
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
.line 276
    aload 1
    areturn
.end method

.method public not()V
    .limit stack 13
    .limit locals 1
.line 282
    aload_0
    invokevirtual HOME/not2()Ljava/lang/String;
    pop
.line 283
    getstatic java/lang/System/out Ljava/io/PrintStream;
    ldc "Great Success!!"
    invokevirtual java/io/PrintStream.println(Ljava/lang/String;)V
    return
.end method

.method public not2()Ljava/lang/String;
    .limit stack 13
    .limit locals 1
.line 289
    aload_0
    invokevirtual HOME/hej()Ljava/lang/String;
    dup
    getstatic java/lang/System/out Ljava/io/PrintStream;
    swap
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    areturn
.end method

.method public testtt()V
    .limit stack 13
    .limit locals 2
.line 294
    iconst_0
    istore 1
.line 295
    Label45:
    iload 1
    iconst_1
    if_icmpeq Label46
.line 296
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
    .limit stack 12
    .limit locals 2
.line 308
    iload 1
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 1
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
.end method

.method public PrintD(D)D
    .limit stack 16
    .limit locals 3
.line 313
    dload 1
    getstatic java/lang/System/out Ljava/io/PrintStream;
    dload 1
    invokevirtual java/io/PrintStream/println(D)V
    dreturn
.end method

.method public PrintS(Ljava/lang/String;)Ljava/lang/String;
    .limit stack 12
    .limit locals 2
.line 318
    aload 1
    dup
    getstatic java/lang/System/out Ljava/io/PrintStream;
    swap
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    areturn
.end method

